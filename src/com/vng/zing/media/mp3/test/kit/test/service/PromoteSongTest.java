package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 31/10/2022
 */

import com.vng.zing.common.ZUtil;
import com.vng.zing.media.commonlib.thrift.TPlatform;
import com.vng.zing.media.mp3.service.promotesong.thrift.client.TZMP3PromoteSongServiceClient;
import com.vng.zing.media.mp3.service.promotesong.thrift.req.TGetPromotedSongReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

import java.util.concurrent.CountDownLatch;

public class PromoteSongTest extends Test {

    private static final TZMP3PromoteSongServiceClient SERVICE = TZMP3PromoteSongServiceClient.INST;

    public static void main(String[] args) {
//        PrintUtils.printTBase(TZMP3CoreMWClient.INST.getMedia(1138133687).value);

        PrintUtils.printTBase(SERVICE.getPromotedSong(new TGetPromotedSongReq()
                .setMediaID(1138133687)
                .setUserID(NAMNH16_ZMP3_ID)
                .setPlatformID(TPlatform.APP_ANDROID.getValue())
        ));

        System.exit(0);
    }
}
