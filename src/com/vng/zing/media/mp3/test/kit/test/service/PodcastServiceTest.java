package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 14/01/2021
 */

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisode;
import com.vng.zing.media.mp3.engine.model.EPodcastEpisodeModel;
import com.vng.zing.media.mp3.mw.podcast.thrift.client.TZMP3PodcastMWClient;
import com.vng.zing.media.mp3.mw.podcast.thrift.req.TDecreaseProgramRatingMWReq;
import com.vng.zing.media.mp3.mw.podcast.thrift.req.TGetProgramRatingByUserMWReq;
import com.vng.zing.media.mp3.mw.podcast.thrift.req.TGetProgramRatingCountByUserMWReq;
import com.vng.zing.media.mp3.mw.podcast.thrift.req.TGetProgramRatingMWReq;
import com.vng.zing.media.mp3.mw.podcast.thrift.req.TGetProgramRatingSliceByUserMWReq;
import com.vng.zing.media.mp3.mw.podcast.thrift.req.TRemoveProgramRatingByUserMWReq;
import com.vng.zing.media.mp3.mw.podcast.thrift.req.TRemoveProgramRatingMWReq;
import com.vng.zing.media.mp3.service.podcast.thrift.client.TZMP3PodcastServiceClient;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TGetProgramEpisodeIdsReq;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TGetProgramRatingReq;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TGetProgramReq;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TMGetEpisodeReq;
import com.vng.zing.media.mp3.service.podcast.thrift.req.TRateProgramReq;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class PodcastServiceTest extends Test {

    private static final TZMP3PodcastMWClient MW = TZMP3PodcastMWClient.INST;
    private static final TZMP3PodcastServiceClient SERVICE = TZMP3PodcastServiceClient.INST;

    public static void main(String[] args) {
        try {
//            _testEpisode();
            _testProgram();
//            _testCategory();
//            _testList();
//            _testRating();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.exit(0);
    }

    private static void _testEpisode() throws IOException {
//        ThriftUtils.prettyPrint(SERVICE.getEpisodeHistorySlice(new TGetEpisodeHistorySliceReq()
//                .setUserId(WhiteListUserUtils.NAMNH16)
//                .setStart(20)
//                .setCount(10)
//        ));

//        List<TPodcastEpisode> episodes = SERVICE.mgetEpisode(new TMGetEpisodeReq()
//                .setEpisodeIds(Arrays.asList(1107549733, 1124674895, 1124676418))
//                .setAsList(true)
//        ).dataList;
//        EPaging<TPodcastEpisode> episodes = EPodcastProgramModel.INST.getListEpisode(
//                1454954673,
//                84,
//                0, 10,
//                true
//        );
//        for (TPodcastEpisode ep : episodes) {
//            System.out.println(ep.id + " " + ep.countryCodes);
//        }

//        TPodcastEpisode ep = MW.getEpisode(new TPodcastEpisodeGetReq()
//                .setId(1129720036)
//        ).value;
//        ThriftUtils.prettyPrint(ep);

//        int userId = NoiseUserIdUtils.denoiseUserId("53b736eec99520cb7984");
//        System.out.println(userId);
//        int userId = NAMNH16_ZMP3_ID;

//        TGetNewEpisodeIdsRes res = SERVICE.getNewEpisodeIds(new TGetNewEpisodeIdsReq()
//                .setUserId(userId)
//                .setStart(0)
//                .setCount(30)
//        );
//        ThriftUtils.prettyPrint(res);
//        List<TPodcastEpisode> eps = EPodcastEpisodeModel.INST.multiGetAsList(res.values);
//        eps.forEach(e -> System.out.println(e.status + " - " + e.title));
    }

    private static void _testProgram() {
//        ThriftUtils.prettyPrint(SERVICE.getProgram(new TGetProgramReq()
//                .setProgramId(1331068752)
//        ).program);

        List<Integer> episodeIds = SERVICE.getProgramEpisodeIds(new TGetProgramEpisodeIdsReq()
                .setProgramId(1331068752)
                .setStart(0)
                .setCount(0)
        ).values;
        System.out.println(episodeIds);
        List<TPodcastEpisode> episodes = SERVICE.mgetEpisode(new TMGetEpisodeReq().setEpisodeIds(episodeIds).setAsList(true)).dataList;
        episodes.forEach(e -> System.out.println(e.title));

//        EPaging<TPodcastEpisode> paging = EPodcastProgramModel.INST.getListEpisode(1370253673, TCountryCode.VIETNAM.getValue(), 0, 1, false);
//        ThriftUtils.prettyPrint(paging.getValues().get(0));
    }

    private static void _testCategory() {
//        TPodcastCategory category = SERVICE.getCategory(new TGetCateforyReq().setCategoryId(12211)).category;
//        ThriftUtils.prettyPrint(category);

//        List<Integer> programIds = SERVICE.getCategoryProgramIdSlice(new TGetCategoryProgramIdSliceReq()
//                .setCategoryId(12320)
//                .setStart(0)
//                .setCount(100)
//        ).values;
//        for (TPodcastProgram program : SERVICE.mgetProgram(new TMGetProgramReq().setProgramIds(programIds).setAsList(true)).dataList) {
//            System.out.println(program.title);
//        }

        System.out.println(MW.programIdExistsInCategory(12321, 1490013927));
    }

    private static void _testList() {
//        for (int start = 0; start < 120000; start += 250) {
//            List<Integer> values = TZMP3PodcastServiceClient.INST.getSlice(new TGetSliceReq()
//                    .setListType(TPodcastListType.PROGRAM_FOLLOWER.getValue())
//                    .setListId(1372611983)
//                    .setStart(start)
//                    .setCount(250)
//            ).values;
//        }

//        ThriftUtils.prettyPrint(SERVICE.getSlice(new TGetSliceReq()
//                .setListType(TPodcastListType.CUSTOM_LIST.getValue())
//                .setListId(TPodcastCustomListID.PROMOTE_CATEGORY.getValue())
//                .setStart(0)
//                .setCount(250)
//        ));

//        System.out.println(EPodcastProgramModel.INST.getFollowerCount(1372611983));

//        System.out.println(SERVICE.getProgramIdSlice(new TGetProgramIdSliceReq()
//                .setStart(70)
//                .setCount(200)
//        ));
//
//        System.out.println(SERVICE.getCategoryProgramIdSlice(new TGetCategoryProgramIdSliceReq()
//                .setStart(0)
//                .setCount(200)
//                .setCategoryId(12424)
//        ));
//
//        System.out.println(SERVICE.getCategoryProgramIdSlice(new TGetCategoryProgramIdSliceReq()
//                .setStart(0)
//                .setCount(200)
//                .setCategoryId(12320)
//        ));

//        List<Integer> values = SERVICE.getSuggestedEpisodeIds(new TGetSuggestedEpisodeIdsReq()
//                .setEpisodeId(1129957827)
//                .setUserId(NAMNH16_ZMP3_ID)
//        ).values;
//        EPodcastEpisodeModel.INST.multiGetAsList(values).forEach(e -> System.out.println(e.title));
    }

    private static void _testRating() {
        int programID = 1489573904;
        int userID = NAMNH16_ZMP3_ID;
        Random random = new Random();

        /*
        Test remove
         */
        ThriftUtils.prettyPrint(MW.removeProgramRating(new TRemoveProgramRatingMWReq()
                .setProgramID(programID)
                .setUserID(userID)
        ));
        ThriftUtils.prettyPrint(MW.removeProgramRatingByUser(new TRemoveProgramRatingByUserMWReq()
                .setProgramID(programID)
                .setUserID(userID)
        ));
        ThriftUtils.prettyPrint(MW.decreaseRating(new TDecreaseProgramRatingMWReq()
                .setProgramID(programID)
                .setIndex(4)
                .setAmount(1)
        ));

//        for(int i=1; i<=5000; i++){
//            System.out.println(SERVICE.rateProgram(new TRateProgramReq()
//                    .setProgramID(programID)
//                    .setUserID(i)
//                    .setRatingScore(random.ints(1, 6).findAny().getAsInt())
//            ).error);
//        }

//        for(int i = 1; i <= 2000; i++){
//            System.out.println(SERVICE.rateProgram(new TRateProgramReq()
//                    .setProgramID(i)
//                    .setUserID(5001)
//                    .setRatingScore(1)
//            ).error);
//        }

//        System.out.println(SERVICE.rateProgram(new TRateProgramReq()
//                .setUserID(NAMNH16_ZMP3_ID)
//                .setProgramID(programID)
//                .setRatingScore(5)
//        ));

        /*
        Test get
         */
        ThriftUtils.prettyPrint(MW.getProgramRating(new TGetProgramRatingMWReq()
                .setProgramID(programID)
        ));
        ThriftUtils.prettyPrint(SERVICE.getProgramRating(new TGetProgramRatingReq()
                .setProgramID(programID)
        ));
//        ThriftUtils.prettyPrint(MW.getProgramRatingByUser(new TGetProgramRatingByUserMWReq()
//                .setProgramID(programID)
//                .setUserID(userID)
//        ));
//        ThriftUtils.prettyPrint(MW.getProgramRatingSliceByUser(new TGetProgramRatingSliceByUserMWReq()
//                .setUserID(5001)
//                .setStart(1995)
//                .setCount(5)
//        ));
//        ThriftUtils.prettyPrint(MW.getProgramRatingCountByUser(new TGetProgramRatingCountByUserMWReq()
//                .setUserID(5001)
//        ));
    }
}
