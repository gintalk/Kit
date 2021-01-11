/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.mp3.feed.mw.thrift.client.TZMP3FeedMWClient;

/**
 *
 * @author namnh16
 */
public class FeedTest extends BaseTest{
    
    private static final TZMP3FeedMWClient CLI = new TZMP3FeedMWClient("main");
    
    public static void main(String[] args) {
        System.out.println(CLI.getFeed(1657320));
    }
}
