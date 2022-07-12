/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.common.thrift.TI32Pair;
import com.vng.zing.media.common.thrift.comment.TCommentApp;
import com.vng.zing.media.common.thrift.comment.TCommentGetType;
import com.vng.zing.media.mp3.common.thrift.TZCRealtimeType;
import com.vng.zing.media.mp3.common.thrift.core.TMedia;
import com.vng.zing.media.mp3.engine.model.EZingChartModel;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mw.comment.thrift.client.TZMediaCommentMWClient;
import com.vng.zing.media.mw.comment.thrift.req.TGetCommentCountMWReq;
import com.vng.zing.media.mw.comment.thrift.res.TGetCommentCountMWRes;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author namnh16
 */
public class EModelTest extends Test {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder("STT\tID\tTitle\tSố comment\n");

        List<TI32Pair> list = EZingChartModel.INST.getTopCCURealtimeCached(84, TZCRealtimeType.SONG).getItem();
        for (int i = 0; i < list.size(); i++) {
            TI32Pair pair = list.get(i);

            TMedia media = TZMP3CoreMWClient.INST.getMedia(pair.key).value;
            if (media == null) {
                System.err.println(pair.key);
                continue;
            }

            TGetCommentCountMWRes res = TZMediaCommentMWClient.DEFAULT_INST.getCommentCount(new TGetCommentCountMWReq()
                    .setAppId(TCommentApp.ZMP3_SONG.getValue())
                    .setGetType(TCommentGetType.ALL.getValue())
                    .setObjectId(pair.key)
            );
            if (ZErrorHelper.isFail(res.error)) {
                System.err.println(pair.key + " | " + res.error);
                continue;
            }

            sb.append(i + 1).append("\t")
                    .append(media.id).append("\t")
                    .append(media.title).append("\t")
                    .append(res.value).append("\n");
        }

        FileUtils.writeStringToFile(new File("data/quyendb2_zc_comment.csv"), sb.toString(), StandardCharsets.UTF_8, false);

        System.exit(0);
    }
}
