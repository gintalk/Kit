package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/02/2022
 */

import com.vng.zing.media.commonlib.thrift.TCountryCode;
import com.vng.zing.media.commonlib.thrift.TPlatform;
import com.vng.zing.media.mp3.commonlib.thrift.TMediaSourceFormat;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkReq;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkRes;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

import java.util.Arrays;

public class BuildLinkServiceTest extends Test {

    private static final ZMP3BuildLinkServiceClient SERVICE = ZMP3BuildLinkServiceClient.INST;

    public static void main(String[] args) {
//        TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.getVideoZMCLinks(new TBuildLinkReq()
//                .setCountryCode(TCountryCode.VIETNAM.getValue())
//                .setFormats(Arrays.asList(
//                        TMediaSourceFormat.Video1080.getValue(),
//                        TMediaSourceFormat.Video720.getValue()
//                ))
//                .setPlatform(TPlatform.APP.getValue())
//                .setZmcId("742a64fc8dae64f03dbf")
//                .setHeader(new THeaderReq())
//        );
//        PrintUtils.printTBase(res);

        TBuildLinkRes res = SERVICE.getAudioZMCLinks(new TBuildLinkReq()
                .setCountryCode(TCountryCode.VIETNAM.getValue())
                .setFormats(Arrays.asList(TMediaSourceFormat.Audio320.getValue(), TMediaSourceFormat.Audio128.getValue()))
                .setZmcId("58505c12ca7c23227a6d")
        );
        PrintUtils.printTBase(res);

        System.exit(0);
    }
}
