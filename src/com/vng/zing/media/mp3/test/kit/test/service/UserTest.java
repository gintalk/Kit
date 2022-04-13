package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 26/04/2021
 */

import com.vng.zing.media.common.thrift.TI32ListResult;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.TUserListType;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisode;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastListType;
import com.vng.zing.media.mp3.common.thrift.user.TUserReadAssetReq;
import com.vng.zing.media.mp3.engine.model.EPodcastEpisodeModel;
import com.vng.zing.media.mp3.mw.user.thrift.client.TZMP3UserMWClient;
import com.vng.zing.media.mp3.service.podcast.thrift.client.TZMP3PodcastServiceClient;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TGetProgramEpisodeIdsReq;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TGetSimilarEpisodeIdsReq;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TGetSliceReq;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TMGetEpisodeReq;
import com.vng.zing.media.mp3.service.podcast.thrift.res.TGetSimilarEpisodeIdsRes;
import com.vng.zing.media.mp3.service.user.thrift.client.TZMP3UserServiceClient;
import com.vng.zing.media.mp3.service.user.thrift.req.TAddAssetReq;
import com.vng.zing.media.mp3.service.user.thrift.req.TGetAssetSliceReq;
import com.vng.zing.media.mp3.service.user.thrift.req.TMultiRemoveAssetReq;
import com.vng.zing.media.mp3.service.user.thrift.req.TRemoveAssetReq;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class UserTest extends Test {

    private static final TZMP3UserMWClient USER_MW = TZMP3UserMWClient.INST;
    private static final TZMP3UserServiceClient USER_SERVICE = TZMP3UserServiceClient.INST;

    public static void main(String[] args) {
//        _testLists();
//        _testMultiAssets();
//        _testMultiAddAssets();
//        _testSource();

        System.exit(0);
    }

    private static void _testLists() {
//        System.out.println(TZMP3PodcastServiceClient.INST.getSlice(new TGetSliceReq()
//                .setListType(TPodcastListType.PROGRAM_FOLLOWER.getValue())
//                .setListId(1489425060)
//                .setStart(0)
//                .setCount(0)
//        ).values);

//        try {
//            List<String> lines = FileUtils.readLines(new File("data/zuser_follow_podcast_program.csv"), "UTF-8");
//
//            for (String line : lines) {
//                int userId = ConvertUtils.toInteger(line);
//
//                System.out.println(USER_SERVICE.addAsset(new TAddAssetReq()
//                        .setUserId(userId)
//                        .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM.getValue())
//                        .setAssetId(1489425060)
//                        .setTime(System.currentTimeMillis())
//                ));
//            }
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }

//        int userId = NoiseUserIdUtils.denoiseUserId("039ffc5a851b6c45350a");
//        System.out.println(userId);
        int userId = 1060675699;

//        ThriftUtils.prettyPrint(USER_SERVICE.getAssetSlice(new TGetAssetSliceReq()
//                .setUserId(userId)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM.getValue())
//                .setStart(0)
//                .setCount(0)
//        ));

//        System.out.println(TZMP3PodcastServiceClient.INST.getProgramEpisodeIds(new TGetProgramEpisodeIdsReq()
//                .setProgramId(1487195834)
//        ));

//        ThriftUtils.prettyPrint(USER_SERVICE.addAsset(new TAddAssetReq()
//                .setUserId(userId)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM.getValue())
//                .setAssetId(1370253673)
//                .setTime(System.currentTimeMillis())
//        ));
        System.out.println(USER_SERVICE.multiRemoveAsset(new TMultiRemoveAssetReq()
                .setUserId(userId)
                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM.getValue())
                .setAssetIds(Arrays.asList(
                        1487195834
                ))
        ));

//        ThriftUtils.prettyPrint(USER_SERVICE.getAssetSliceWithScore(new TGetAssetSliceWithScoreReq()
//                .setUserId(userId)
//                .setAssetType(TUserListType.LIBRARY_ARTIST.getValue())
//                .setStart(0)
//                .setCount(100)
//        ));
//        ThriftUtils.prettyPrint(USER_MW.getAssetSlice(new TUserReadAssetReq()
//                .setUserId(userId)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM.getValue())
//                .setStart(0)
//                .setCount(100)
//        ));

//        ThriftUtils.prettyPrint(USER_MW.getHistoryEpisode(new TUserReadHistoryEpisodeReq()
//                .setUserId(userId)
//                .setEpisodeId(1126510926)
//        ));

//        TI32ListResult listResult = USER_MW.getAssetSlice(new TUserReadAssetReq()
//                .setUserId(userId)
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//                .setStart(0)
//                .setCount(200)
//        );
//        System.out.println(listResult);
//        List<TPodcastEpisode> episodes = EPodcastEpisodeModel.INST.multiGetAsList(listResult.values);
//        int i = 1;
//        for (TPodcastEpisode episode : episodes) {
//            System.out.println(i++ + " | " + episode.id + " | " + episode.title);
//        }
//        System.out.println("------------------------");
//        TGetSimilarEpisodeIdsRes similarRes = TZMP3PodcastServiceClient.INST.getSimilarEpisodeIds(new TGetSimilarEpisodeIdsReq()
//                .setUserId(0)
//                .setEpisodeId(1127722035)
//        );
//        System.out.println(similarRes);
//        List<TPodcastEpisode> eps = TZMP3PodcastServiceClient.INST.mgetEpisode(new TMGetEpisodeReq()
//                .setAsList(true)
//                .setEpisodeIds(similarRes.values)
//        ).dataList;
//        int i = 1;
//        for (TPodcastEpisode episode : eps) {
//            System.out.println(i++ + " | " + episode.id + " | " + episode.title);
//        }
    }

    private static void _testMultiAssets() {
//        System.out.println(USER_MW.multiAddAssets(
//                Arrays.asList(NAMNH16_ZMP3_ID, QUYENDB_ZMP3_ID),
//                TUserListType.NEW_PODCAST_EPISODE.getValue(),
//                1112632482,
//                DateTimeUtils.currentTimeSeconds()
//        ));
//        System.out.println(USER_MW.multiAddAssets(
//                Arrays.asList(NAMNH16_ZMP3_ID, QUYENDB_ZMP3_ID),
//                TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue(),
//                1447727002,
//                DateTimeUtils.currentTimeSeconds()
//        ));

//        System.out.println(USER_MW.multiRemoveAssets(
//                Arrays.asList(NAMNH16_ZMP3_ID, QUYENDB_ZMP3_ID),
//                TUserListType.NEW_PODCAST_EPISODE.getValue(),
//                1112632482
//        ));
//        System.out.println(USER_MW.multiRemoveAssets(
//                Arrays.asList(NAMNH16_ZMP3_ID, QUYENDB_ZMP3_ID),
//                TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue(),
//                1447727002
//        ));

//        ThriftUtils.prettyPrint(USER_MW.getAssetSlice(new TUserReadAssetReq()
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setStart(0)
//                .setCount(10)
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//        ));
//        ThriftUtils.prettyPrint(USER_MW.getAssetSlice(new TUserReadAssetReq()
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setStart(0)
//                .setCount(10)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue())
//        ));
//
//        ThriftUtils.prettyPrint(USER_MW.getAssetSlice(new TUserReadAssetReq()
//                .setUserId(QUYENDB_ZMP3_ID)
//                .setStart(0)
//                .setCount(10)
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//        ));
//        ThriftUtils.prettyPrint(USER_MW.getAssetSlice(new TUserReadAssetReq()
//                .setUserId(QUYENDB_ZMP3_ID)
//                .setStart(0)
//                .setCount(10)
//                .setAssetType(TUserListType.FOLLOW_.getValue())
//        ));
    }

    private static void _testMultiAddAssets() {
//        System.out.println(USER_SERVICE.multiAddAssets(new TMultiAddAssetsReq()
//                .setUserIds(Arrays.asList(NAMNH16_ZMP3_ID, QUYENDB_ZMP3_ID))
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//                .setAssetId(1112632482)
//                .setTime(DateTimeUtils.currentTimeSeconds())
//        ));
//        System.out.println(USER_SERVICE.multiAddAssets(new TMultiAddAssetsReq()
//                .setUserIds(Arrays.asList(NAMNH16_ZMP3_ID, QUYENDB_ZMP3_ID))
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue())
//                .setAssetId(1447732717)
//                .setTime(DateTimeUtils.currentTimeSeconds())
//        ));

//        System.out.println(USER_SERVICE.multiRemoveAsset(new TMultiRemoveAssetReq()
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//                .setAssetIds(Arrays.asList(1103756031, 1112632482))
//        ));
//        System.out.println(USER_SERVICE.multiRemoveAsset(new TMultiRemoveAssetReq()
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue())
//                .setAssetIds(Arrays.asList(1447727002, 1447732717))
//        ));
//        System.out.println(USER_SERVICE.multiRemoveAsset(new TMultiRemoveAssetReq()
//                .setUserId(QUYENDB_ZMP3_ID)
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//                .setAssetIds(Arrays.asList(1103756031, 1112632482))
//        ));
//        System.out.println(USER_SERVICE.multiRemoveAsset(new TMultiRemoveAssetReq()
//                .setUserId(QUYENDB_ZMP3_ID)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue())
//                .setAssetIds(Arrays.asList(1447727002, 1447732717))
//        ));

//        ThriftUtils.prettyPrint(USER_SERVICE.getAssetSlice(new TGetAssetSliceReq()
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//                .setStart(0)
//                .setCount(10)
//        ));
//        ThriftUtils.prettyPrint(USER_SERVICE.getAssetSlice(new TGetAssetSliceReq()
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue())
//                .setStart(0)
//                .setCount(10)
//        ));
//        ThriftUtils.prettyPrint(USER_SERVICE.getAssetSlice(new TGetAssetSliceReq()
//                .setUserId(QUYENDB_ZMP3_ID)
//                .setAssetType(TUserListType.NEW_PODCAST_EPISODE.getValue())
//                .setStart(0)
//                .setCount(10)
//        ));
//        ThriftUtils.prettyPrint(USER_SERVICE.getAssetSlice(new TGetAssetSliceReq()
//                .setUserId(QUYENDB_ZMP3_ID)
//                .setAssetType(TUserListType.FOLLOW_PODCAST_PROGRAM_HAS_NEW_EPISODE.getValue())
//                .setStart(0)
//                .setCount(10)
//        ));
    }

    private static void _testSource() {
        System.out.println(USER_MW.getMapSource(1049058769, "04244cbd9831f442ea1ad2479212e8e5"));
    }
}
