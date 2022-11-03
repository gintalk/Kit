/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.logger.ZLogger;
import org.apache.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    private static final Logger LOG = ZLogger.getLogger(CommonTest.class);

    public static void main(String[] args) {
        String s = "https://www.nct.com/wyewuqwqeqwiewqewq";
        int splitAt = s.indexOf(".com") + 4;
        System.out.println(s.substring(0, splitAt));
        System.out.println(s.substring(splitAt));
    }
}
