/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.mp3.commonlib.thrift.TCounterTotalIndex;
import com.vng.zing.media.mp3.commonlib.thrift.TCounterTotalType;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;

import java.io.IOException;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    private static final String SEPARATOR = "¸";

    public static void main(String[] args) throws IOException {
        System.out.println(TZMP3CoreMWClient.INST.getCounterTotal(
                TCounterTotalType.ZMP3_PLAYLIST.getValue(), TCounterTotalIndex.FAVOURITE.getValue(),
                1298655796
        ));

        System.exit(0);
    }
}
