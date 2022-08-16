/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;


import com.vng.zing.media.mp3.mw.publisher.thrift.client.TZMP3PublisherMWClient;

/**
 * @author namnh16
 */
public class PublisherMWTest extends Test {

    private static final TZMP3PublisherMWClient MW = TZMP3PublisherMWClient.INST;

    public static void main(String[] args) {
//        _testGetAssetSlice();
//        _testGetAssetAssetSliceWithScore();
//        _testGetAssetCount();
//        _testPutAsset();
        _testRemoveAsset();

//        _testGetFollowerSlice();
//        _testGetFollowerCount();
//        _testPutFollower();
//        _testRemoveFollower();

        System.exit(0);
    }

    private static void _testPutAsset() {
//        for (int i = 1; i < 1005; i++) {
//            System.out.println(MW.putAsset(new TPutAssetMWReq()
//                    .setAssetId(i)
//                    .setAssetStatus(0)
//                    .setAssetType(TPublisherAssetType.LIVESTREAM.getValue())
//                    .setScore(1)
//                    .setPublisherId(NAMNH16_ZMP3_ID)
//            ));
//        }

//        for (int i = 0; i < 1000; i++) {
//            System.out.println(MW.putTypedAsset(new TPutAssetMWReq()
//                    .setPublisherId(6980)
//                    .setListType(TPublisherListType.NEW_CONTENT_BY_ARTIST.getValue())
//                    .setAssetType(TPublisherAssetType.PLAYLIST.getValue())
//                    .setAssetId(i)
//                    .setScore(100)
//            ));
//        }
    }

    private static void _testRemoveAsset() {
//        System.out.println(MW.removeAsset(new TRemoveAssetMWReq()
//                .setPublisherId(2031318)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetId(1129257375)
//        ));
//
//        System.out.println(MW.exists(new TExistsMWReq()
//                .setPublisherId(2031318)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetId(1129257375)
//        ));
    }

    private static void _testGetAssetSlice() {
//        System.out.println(MW.getAssetSlice(new TGetAssetSliceMWReq()
//                .setPublisherId(VED_DNARB_OA_ID)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetStatus(0)
//                .setStart(0)
//                .setCount(0)
//        ).values);

//        ThriftUtils.prettyPrint(MW.getTypedAssetSlice(new TGetAssetSliceMWReq()
//                .setPublisherId(105478)
//                .setListType(TPublisherListType.EVENT_AS_GUEST.getValue())
//                .setAssetType(TPublisherAssetType.EVENT.getValue())
//                .setStart(0)
//                .setCount(10)
//        ));
    }

    private static void _testGetAssetAssetSliceWithScore() {
//        int artistId = 1907714;
//
//        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
//                .setPublisherId(artistId)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetStatus(0)
//                .setStart(0)
//                .setCount(200)
//        ));
//
//        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
//                .setPublisherId(artistId)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetStatus(TPodcastEpisodeStatus.SHOW.getValue())
//                .setStart(0)
//                .setCount(200)
//        ));
//
//        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
//                .setPublisherId(artistId)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetStatus(TPodcastEpisodeStatus.HIDE.getValue())
//                .setStart(0)
//                .setCount(200)
//        ));
//
//        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
//                .setPublisherId(artistId)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetStatus(TPodcastEpisodeStatus.SCHEDULED.getValue())
//                .setStart(0)
//                .setCount(200)
//        ));
//
//        System.out.println(MW.getAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
//                .setPublisherId(artistId)
//                .setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue())
//                .setAssetStatus(TPodcastEpisodeStatus.DRAFT.getValue())
//                .setStart(0)
//                .setCount(200)
//        ));

//        ThriftUtils.prettyPrint(MW.getTypedAssetSliceWithScore(new TGetAssetSliceWithScoreMWReq()
//                .setPublisherId(6980)
//                .setListType(TPublisherListType.NEW_CONTENT_BY_ARTIST.getValue())
//                .setAssetType(TPublisherAssetType.PLAYLIST.getValue())
//                .setStart(0)
//                .setCount(10)
//        ));
    }

    private static void _testGetAssetCount() {
//        System.out.println(MW.getAssetCount(new TGetAssetCountMWReq()
//                .setPublisherId(1866305)
//                .setAssetType(TPublisherAssetType.MEDIA.getValue())
//                .setAssetStatus(0)
//        ));
    }

    private static void _testGetFollowerSlice() {
//        ThriftUtils.prettyPrint(MW.getFollowerSlice(new TGetFollowerSliceMWReq()
//                .setPublisherId(24591)
//                .setStart(0)
//                .setCount(10000)
//        ));
    }

    private static void _testGetFollowerCount() {
//        System.out.println(MW.getFollowerCount(new TGetFollowerCountMWReq()
//                .setPublisherId(6980)
//        ));
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
}
