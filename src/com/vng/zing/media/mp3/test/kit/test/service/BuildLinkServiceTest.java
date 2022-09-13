package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/02/2022
 */

import com.vng.zing.media.mp3.commonlib.thrift.TMediaSourceFormat;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkReq;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

public class BuildLinkServiceTest extends Test {

    private static final ZMP3BuildLinkServiceClient SERVICE = ZMP3BuildLinkServiceClient.INST;

    public static void main(String[] args) {
        PrintUtils.printTBase(SERVICE.getAudioZMCLinks(new TBuildLinkReq()
                .setZmcId("2a4a35dc1bbdf2e3abac")
        ));

        System.exit(0);
    }
}
