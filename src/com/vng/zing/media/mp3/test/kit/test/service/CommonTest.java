/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.commonlib.helper.OAMessageHelper;

import java.util.Collections;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    public static void main(String[] args) {
        System.out.println(OAMessageHelper.ZMP3_INST.sendTextMessage("Thử HttpRequestHelper", Collections.singletonList(NAMNH16_ZALO_ID)));

        System.exit(0);
    }
}
