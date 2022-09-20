package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/02/2022
 */

import com.vng.zing.media.common.thrift.THeaderReq;
import com.vng.zing.media.commonlib.thrift.TCountryCode;
import com.vng.zing.media.commonlib.thrift.TPlatform;
import com.vng.zing.media.mp3.common.thrift.TMediaSourceFormat;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkReq;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkRes;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

import java.util.Arrays;

public class BuildLinkServiceTest extends Test {

    private static final ZMP3BuildLinkServiceClient SERVICE = ZMP3BuildLinkServiceClient.INST;

    public static void main(String[] args) {
//        TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.getAudioBigFileLinks(new TBuildLinkReq()
//                .setCountryCode(TCountryCode.VIETNAM.getValue())
//                .setFormats(Arrays.asList(TMediaSourceFormat.AudioLossless.getValue(), TMediaSourceFormat.Audio320.getValue(), TMediaSourceFormat.Audio128.getValue()))
//                .setMediaId(1079103858)
//        );
//        PrintUtils.printTBase(res);

        TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.getVideoZMCLinks(new TBuildLinkReq()
                .setCountryCode(TCountryCode.VIETNAM.getValue())
                .setFormats(Arrays.asList(
                        TMediaSourceFormat.Video1080.getValue(),
                        TMediaSourceFormat.Video720.getValue()
                ))
                .setPlatform(TPlatform.APP.getValue())
                .setZmcId("9d64676e6c298577dc38")
                .setHeader(new THeaderReq())
        );
        PrintUtils.printTBase(res);

        PrintUtils.printTBase(TZMP3CoreMWClient.INST.getMedia(1079103858).value);

//        TBuildLinkRes res = SERVICE.getAudioZMCLinks(new TBuildLinkReq()
//                .setZmcId("5e6bcbfeb4935dcd0482")
//        );
//        PrintUtils.printTBase(res);

        System.exit(0);
    }
}
