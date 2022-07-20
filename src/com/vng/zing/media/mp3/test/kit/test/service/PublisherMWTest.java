/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;


import com.vng.zing.media.mp3.commonlib.thrift.TPublisherType;
import com.vng.zing.media.mp3.commonlib.thrift.podcast.TPodcastEpisodeStatus;
import com.vng.zing.media.mp3.commonlib.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.mw.publisher.thrift.client.TZMP3PublisherMWClient;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TGetAssetCountMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TGetAssetSliceMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TGetAssetSliceWithScoreMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TGetFollowerCountMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TGetFollowerSliceMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TGetPublisherIDMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TMGetPublisherIDMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TMPutPublisherAliasMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TMRemovePublisherAliasMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TPublisherAliasExistsMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TPutAssetMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TPutPublisherAliasMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TRemoveAssetMWReq;
import com.vng.zing.media.mp3.mw.publisher.thrift.req.TRemovePublisherAliasMWReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author namnh16
 */
public class PublisherMWTest extends Test {

    private static final TZMP3PublisherMWClient MW = TZMP3PublisherMWClient.INST;

    public static void main(String[] args) {
//        _testGetAssetSlice();
        _testGetAssetAssetSliceWithScore();
//        _testGetAssetCount();
//        _testPutAsset();
//        _testRemoveAsset();

//        _testGetFollowerSlice();
//        _testGetFollowerCount();
//        _testPutFollower();
//        _testRemoveFollower();

        _testAlias();

        System.exit(0);
    }

    private static void _testPutAsset() {
        for (int i = 1; i < 1005; i++) {
            System.out.println(MW.putAsset(new TPutAssetMWReq()
                    .setAssetId(i)
                    .setAssetStatus(0)
                    .setAssetType(TPublisherAssetType.LIVESTREAM.getValue())
                    .setScore(1)
                    .setPublisherId(NAMNH16_ZMP3_ID)
            ));
        }
    }

    private static void _testRemoveAsset() {
        for (int i = 1; i < 1005; i++) {
            System.out.println(MW.removeAsset(new TRemoveAssetMWReq()
                    .setAssetId(i)
                    .setAssetStatus(0)
                    .setAssetType(TPublisherAssetType.LIVESTREAM.getValue())
                    .setPublisherId(NAMNH16_ZMP3_ID)
            ));
        }
    }

    private static void _testGetAssetSlice() {
        System.out.println(MW.getAssetSlice(new TGetAssetSliceMWReq()
                .setPublisherId(PETER_SERKIN_OA_ID)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(0)
                .setStart(0)
                .setCount(0)
        ).values);
    }

    private static void _testGetAssetAssetSliceWithScore() {
        int artistId = 1907714;

        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
                .setPublisherId(artistId)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(0)
                .setStart(0)
                .setCount(200)
        ));

        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
                .setPublisherId(artistId)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(TPodcastEpisodeStatus.SHOW.getValue())
                .setStart(0)
                .setCount(200)
        ));

        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
                .setPublisherId(artistId)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(TPodcastEpisodeStatus.HIDE.getValue())
                .setStart(0)
                .setCount(200)
        ));

        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
                .setPublisherId(artistId)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(TPodcastEpisodeStatus.SCHEDULED.getValue())
                .setStart(0)
                .setCount(200)
        ));

        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
                .setPublisherId(artistId)
                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
                .setAssetStatus(TPodcastEpisodeStatus.DRAFT.getValue())
                .setStart(0)
                .setCount(200)
        ));
    }

    private static void _testGetAssetCount() {
        System.out.println(MW.getAssetCount(new TGetAssetCountMWReq()
                .setPublisherId(1866305)
                .setAssetType(TPublisherAssetType.MEDIA.getValue())
                .setAssetStatus(0)
        ));
    }

    private static void _testGetFollowerSlice() {
        PrintUtils.printTBase(MW.getFollowerSlice(new TGetFollowerSliceMWReq()
                .setPublisherId(24591)
                .setStart(0)
                .setCount(10000)
        ));
    }

    private static void _testGetFollowerCount() {
        System.out.println(MW.getFollowerCount(new TGetFollowerCountMWReq()
                .setPublisherId(6980)
        ));
    }

    private static void _testPutFollower() {
//        System.out.println(MW.putFollower(new TPutFollowerMWReq()
//                .setPublisherId(6980)
//                .setFollowerId(1)
//        ));
    }

    private static void _testRemoveFollower() {
//        System.out.println(MW.removeFollower(new TRemoveFollowerMWReq()
//                .setPublisherId(6980)
//                .setFollowerId(1)
//        ));
    }

    private static void _testAlias() {
//        PrintUtils.printTBase(MW.putPublisherAlias(new TPutPublisherAliasMWReq()
//                .setPublisherType(TPublisherType.INDIE_ARTIST.getValue())
//                .setAliasName("rubyourcamel")
//                .setPublisherID(2222)
//        ));

        PrintUtils.printTBase(MW.publisherAliasExists(new TPublisherAliasExistsMWReq()
                .setAliasName("rubyourcamel")
        ));

//        PrintUtils.printTBase(MW.removePublisherAlias(new TRemovePublisherAliasMWReq()
//                .setPublisherType(TPublisherType.INDIE_ARTIST.getValue())
//                .setAliasName("rubyourcamel")
//        ));

//        PrintUtils.printTBase(MW.getPublisherID(new TGetPublisherIDMWReq()
//                .setPublisherType(TPublisherType.INDIE_ARTIST.getValue())
//                .setAliasName("rubyourcamel")
//        ));

//        Map<String, Integer> dataMap = new HashMap<>();
//        dataMap.put("rubyourcamel", 333);
//        dataMap.put("dontrubyourcamel", 444);
//        System.out.println(MW.mputPublisherAlias(new TMPutPublisherAliasMWReq()
//                .setPublisherType(TPublisherType.INDIE_ARTIST.getValue())
//                .setDataMap(dataMap)
//        ));

//        System.out.println(MW.mremovePublisherAlias(new TMRemovePublisherAliasMWReq()
//                .setPublisherType(TPublisherType.ARTIST.getValue())
//                .setAliasNames(Arrays.asList("rubyourcamel", "dontrubyourcamel"))
//        ));
//
//        PrintUtils.printTBase(MW.mgetPublisherID(new TMGetPublisherIDMWReq()
//                .setPublisherType(TPublisherType.ARTIST.getValue())
//                .setAliasNames(Arrays.asList("rubyourcamel", "dontrubyourcamel"))
//        ));
    }
}
