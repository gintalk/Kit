/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.common.ZUtil;
import com.vng.zing.media.common.thrift.TCountryCode;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.HttpUtils;
import com.vng.zing.media.mp3.common.thrift.TCounterTotalIndex;
import com.vng.zing.media.mp3.common.thrift.TCounterTotalType;
import com.vng.zing.media.mp3.common.thrift.TFollowType;
import com.vng.zing.media.mp3.common.thrift.TMP3ItemType;
import com.vng.zing.media.mp3.common.thrift.TMP3ListType;
import com.vng.zing.media.mp3.common.thrift.TMediaSourceFormat;
import com.vng.zing.media.mp3.common.thrift.core.TListInfo;
import com.vng.zing.media.mp3.common.thrift.core.TMedia;
import com.vng.zing.media.mp3.common.thrift.core.TMediaResult;
import com.vng.zing.media.mp3.common.thrift.core.TStreamingLink;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkReq;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkRes;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import com.vng.zing.media.mp3.service.core.thrift.client.TZMP3CoreServiceClient;
import com.vng.zing.media.mp3.service.core.thrift.req.TGetTotalFollowReq;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    private static final String PHOTO_DOMAIN = "https://photo-zmp3.zmdcdn.me/";

    public static void main(String[] args) {
        try {
            List<String> lines = FileUtils.readLines(new File("data/artist.csv"), StandardCharsets.UTF_8);

            StringBuilder sb = new StringBuilder("ID,Name,Total follow,Total view\n");
            for (String line : lines) {
                String[] split = line.split(",");

                List<Integer> mediaIDs = TZMP3CoreMWClient.INST.getSliceIds(
                        new TListInfo()
                                .setId(ConvertUtils.toInteger(split[0]))
                                .setCountryCode(84)
                                .setItemType(TMP3ItemType.MEDIA.getValue())
                                .setType(TMP3ListType.LIST_BY_ARTIST.getValue()),
                        0, 0
                ).values;

                long total = 0;

                List<List<Integer>> parts = ZUtil.splitList(mediaIDs, 200);
                for (List<Integer> part : parts) {
                    Map<Integer, Integer> map = TZMP3CoreMWClient.INST.mgetCounterTotal(TCounterTotalType.ZMP3_SONG.getValue(), TCounterTotalIndex.VIEW_ALL.getValue(), part).values;
                    if (map != null) {
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            total += entry.getValue();
                        }
                    }
                }

                sb.append(split[0]).append(",")
                        .append(split[1]).append(",")
                        .append(TZMP3CoreServiceClient.INST.getTotalFollow(new TGetTotalFollowReq()
                                .setType(TFollowType.ARTIST.getValue())
                                .setId(ConvertUtils.toInteger(split[0]))
                        ).value).append(",")
                        .append(total).append("\n");
            }

            FileUtils.writeStringToFile(new File("data/ARTISTS.csv"), sb.toString(), StandardCharsets.UTF_8, false);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        System.exit(0);
    }

    private static void _downloadSource(String name, int mediaID) throws IOException {
        TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.getAudioBigFileLinks(new TBuildLinkReq()
                .setCountryCode(TCountryCode.VIETNAM.getValue())
                .setFormats(Arrays.asList(TMediaSourceFormat.AudioLossless.getValue(), TMediaSourceFormat.Audio320.getValue(), TMediaSourceFormat.Audio128.getValue()))
                .setMediaId(mediaID)
        );
        if (ZErrorHelper.isFail(res.error)) {
            System.err.println("BUILD_LINK_SERVICE.FAIL" + " | " + res.error + " | " + mediaID + " | " + mediaID);
            return;
        }
        Map<Integer, TStreamingLink> values = res.values;

        String link = "", extension = "";
        if (values.containsKey(TMediaSourceFormat.AudioLossless.getValue())) {
            link = values.get(TMediaSourceFormat.AudioLossless.getValue()).link;
            extension = ".flac";
        } else if (values.containsKey(TMediaSourceFormat.Audio320.getValue())) {
            link = values.get(TMediaSourceFormat.Audio320.getValue()).link;
            extension = ".mp3";
        } else if (values.containsKey(TMediaSourceFormat.Audio128.getValue())) {
            link = values.get(TMediaSourceFormat.Audio128.getValue()).link;
            extension = ".mp3";
        }

        if (CommonUtils.isEmpty(link)) {
            System.err.println("Lossless, 320, 128 not available" + " | " + mediaID + " | " + mediaID);
            return;
        }

        HttpUtils.downloadFile(link, "/home/namnh16/Data/source/" + name + extension);
    }

    private static void _downloadThumb(String name, int id) throws IOException {
        TMediaResult mediaResult = TZMP3CoreMWClient.INST.getMedia(id);
        if (ZErrorHelper.isFail(mediaResult.error)) {
            System.err.println("CORE_MW_FAIL" + " | " + mediaResult.error + " | " + id);
            return;
        }
        TMedia media = mediaResult.value;

        String thumbnail = (media.audio == null && media.video == null) ? "" : (media.audio == null ? media.video.thumbnail : media.audio.thumbnail);

        String link = CommonUtils.isEmpty(thumbnail) ? "" : PHOTO_DOMAIN + thumbnail;
        if (CommonUtils.isEmpty(link)) {
            System.err.println("Thumbnail not available" + " | " + id);
            return;
        }

        HttpUtils.downloadFile(link, "/home/namnh16/Data/thumb/" + name + ".jpg");
    }
}
