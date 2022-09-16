/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.common.profiler.ZMProfiler;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.HttpUtils;
import com.vng.zing.media.mp3.common.thrift.TCountryCode;
import com.vng.zing.media.mp3.common.thrift.TMediaSourceFormat;
import com.vng.zing.media.mp3.common.thrift.core.TMedia;
import com.vng.zing.media.mp3.common.thrift.core.TMediaResult;
import com.vng.zing.media.mp3.common.thrift.core.TStreamingLink;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkReq;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkRes;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

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

    public static void main(String[] args) throws IOException {
        ZMProfiler.open("ThumbAndSourceFetcher");
        try {
            Logger logger = ZLogger.getLogger(CommonTest.class);

            List<String> lines = FileUtils.readLines(new File("data/media.csv"), StandardCharsets.UTF_8);
            lines = lines.subList(0, 100);

            List<String> finalLines = lines;
            new Thread(() -> {
                ZMProfiler.open("SourceFetcher");
                try {

                    for (String line : finalLines) {
                        ZMProfiler.count(CommonTest.class, "main", "SOURCE", "PROGRESS");

                        String[] split = line.split("¸");

                        int mediaID = ConvertUtils.toInteger(split[0]);
                        String mediaName = split[1];

                        _downloadSource(mediaName, mediaID);
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }).start();

            new Thread(() -> {
                ZMProfiler.open("ThumbFetcher");
                try {
                    for (String line : finalLines) {
                        ZMProfiler.count(CommonTest.class, "main", "THUMB", "PROGRESS");

                        String[] split = line.split("¸");

                        int mediaID = ConvertUtils.toInteger(split[0]);
                        String mediaName = split[1];

                        try {
                            _downloadThumb(mediaName, mediaID);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(), e);
                }
            }).start();
        } catch (Exception e) {
            ZLogger.getLogger(CommonTest.class).error(e.getMessage(), e);
        } finally {
            ZMProfiler.close();
        }
    }

    private static void _downloadSource(String name, int mediaID) throws IOException {
        TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.getAudioBigFileLinks(new TBuildLinkReq()
                .setCountryCode(TCountryCode.VIETNAM.getValue())
                .setFormats(Arrays.asList(
                        TMediaSourceFormat.AudioLossless.getValue(),
                        TMediaSourceFormat.Audio320.getValue(),
                        TMediaSourceFormat.Audio128.getValue())
                )
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
