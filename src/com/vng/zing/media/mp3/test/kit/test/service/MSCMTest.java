package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 14/05/2021
 */

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;
import com.vng.zing.media.mscmhost.thrift.client.TZMMSCMHostClient;
import com.vng.zing.media.mscmhost.thrift.req.TGetHostReq;

public class MSCMTest extends Test {

    private static final TZMMSCMHostClient HOST = TZMMSCMHostClient.INST;

    public static void main(String[] args) {
//        System.out.println(MSCMApiWrapper.INST.getHosts(
//                "ZMP3OAMW",
//                "TestClientApp5",
//                "TZMP3OAMWClient",
//                "main",
//                "10.30.80.131"
//        ));

//        System.out.println(MSCMApiWrapper.INST.broadcastPutConfig(
//                "ZMP3OAMW",
//                "ZMP3OAService",
//                "TZMP3OAMWClient",
//                "main",
//                new TCentralConfig()
//                        .setId(1)
//                        .setHosts("10.13.3.25:10500")
//                        .setScaleMode(1)
//                        .setTimeout(3000)
//                        .setNRetry(3)
//                        .setKey("None")
//                        .setSource("None")
//                        .setVersion(DateTimeUtils.currentTimeSeconds())
//        ));

//        PrintUtils.printTBase(HOST.getHosts(new TGetHostReq()
//                .setClientApp("ZMP3OAService")
//                .setClientName("TZMP3OAMWClient")
//                .setClientInstance("main")
//                .setServiceApp("ZMP3OAMW")
//        ).value);
//
        ThriftUtils.prettyPrint(HOST.getHosts(new TGetHostReq()
                .setClientApp("Kit")
                .setClientName("TZMP3OAMWClient")
                .setClientInstance("main")
                .setServiceApp("ZMP3OAMW")
        ).value);

        System.exit(0);
    }
}
