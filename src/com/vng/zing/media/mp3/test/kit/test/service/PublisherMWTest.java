/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;


import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.mw.publisher.thrift.client.TZMP3PublisherMWClient;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.*;

/**
 * @author namnh16
 */
public class PublisherMWTest extends BaseTest {

    private static final TZMP3PublisherMWClient MW = TZMP3PublisherMWClient.INST;

    public static void main(String[] args) {
//        _testGetAssetSlice();
//        _testGetAssetAssetSliceWithScore();
        _testGetAssetCount();

//        _testGetFollowerSlice();
//        _testGetFollowerCount();
//        _testPutFollower();
//        _testRemoveFollower();

        System.exit(0);
    }

    private static void _testGetAssetSlice() {
        System.out.println(MW.getAssetSlice(new TGetAssetSliceMWReq()
                .setPublisherId(6980)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(0)
                .setStart(0)
                .setCount(200)
        ));
    }

    private static void _testGetAssetAssetSliceWithScore() {
        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
                .setPublisherId(6980)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(0)
                .setStart(0)
                .setCount(200)
        ));
    }

    private static void _testGetAssetCount() {
        System.out.println(MW.getAssetCount(new TGetAssetCountMWReq()
                .setPublisherId(6980)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(0)
        ));
    }

    private static void _testGetFollowerSlice() {
        System.out.println(MW.getFollowerSlice(new TGetFollowerSliceMWReq()
                .setPublisherId(6980)
                .setStart(0)
                .setCount(100)
        ));
    }

    private static void _testGetFollowerCount() {
        System.out.println(MW.getFollowerCount(new TGetFollowerCountMWReq()
                .setPublisherId(6980)
        ));
    }

    private static void _testPutFollower() {
        System.out.println(MW.putFollower(new TPutFollowerMWReq()
                .setPublisherId(6980)
                .setFollowerId(1)
        ));
    }

    private static void _testRemoveFollower() {
        System.out.println(MW.removeFollower(new TRemoveFollowerMWReq()
                .setPublisherId(6980)
                .setFollowerId(1)
        ));
    }
}
