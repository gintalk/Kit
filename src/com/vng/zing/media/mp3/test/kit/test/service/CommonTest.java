/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.commonlib.helper.JsoniterHelper;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    public static void main(String[] args) {
        System.out.println(DurationFormatUtils.formatDuration(86400000L, "MM:SS", true));

        System.exit(0);
    }
}
