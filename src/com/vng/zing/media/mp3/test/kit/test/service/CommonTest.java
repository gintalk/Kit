/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.mp3.commonlib.thrift.TForbiddenType;
import com.vng.zing.media.mp3.service.forbiddenfilter.thrift.client.TZMP3ForbiddenFilterClient;
import com.vng.zing.media.mp3.service.forbiddenfilter.thrift.req.CheckForbiddenReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    public static void main(String[] args) {
//        System.out.println(ZCommonX.noise_withkey("https://api.spotify.com/v1/search", "Wm5itpSZX0"));

        PrintUtils.printTBase(TZMP3ForbiddenFilterClient.INST.checkForbidden(new CheckForbiddenReq()
                .setCountryCode(84)
                .setType(TForbiddenType.COMMENT.getValue())
                .setInput("dcm")
        ));

        System.exit(0);
    }
}
