/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.commonlib.wrapper.JsonWrapper;
import com.vng.zing.media.mp3.test.kit.test.common.OAMsgUtils;

import java.util.Collections;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    public static void main(String[] args) {
//        System.out.println(OAMsgUtils.ZMP3_INST.sendTextMessage("Test method", Collections.singletonList(NAMNH16_ZALO_ID)));

//        String s = "{\"wqqwd\": \"sad\"}";
//        System.out.println(isJsonObject(s));

        System.exit(0);
    }

    private static boolean isJsonObject(String s) {
        if (!s.startsWith("{") || !s.endsWith("}")) {
            return false;
        }

        JsonWrapper jw = JsonWrapper.buildOnlyRead(s);
        try {
            jw.isEmpty();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
