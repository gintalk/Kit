package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 29/12/2022
 */

import com.vng.zing.media.commonlib.thrift.TPlatform;
import com.vng.zing.media.realtimecounterccu.thrift.client.ZMediaRealtimeCounterCCUClient;

public class CCUTest extends Test {

    private static final ZMediaRealtimeCounterCCUClient CCU = ZMediaRealtimeCounterCCUClient.INST;

    public static void main(String[] args) {
        TPlatform platform = TPlatform.valueOf("ajkhdwqkhewq");
        System.out.println(platform);
    }
}
