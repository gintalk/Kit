/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.jni.zcommonx.wrapper.ZCommonX;
import com.vng.zing.media.commonlib.wrapper.JsonWrapper;
import com.vng.zing.media.mp3.test.kit.test.common.OAMsgUtils;

import java.util.Collections;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    public static void main(String[] args) {
        System.out.println(ZCommonX.noise_withkey("https://api.spotify.com/v1/search", "Wm5itpSZX0"));

        System.exit(0);
    }
}
