package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 05/08/2021
 */

import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.mp3.mw.indie.thrift.client.TZMP3IndieMWClient;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IndieMWTest extends Test {

    private static final TZMP3IndieMWClient INDIE_MW = TZMP3IndieMWClient.INST;

    public static void main(String[] args) throws IOException {
        PrintUtils.printTBase(INDIE_MW.getIndieArtist(956800));

        System.exit(0);
    }
}
