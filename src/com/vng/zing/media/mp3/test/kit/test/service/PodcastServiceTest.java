package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 14/01/2021
 */

import com.vng.zing.media.mp3.commonlib.thrift.podcast.TPodcastProgramGetEpisodeIdsReq;
import com.vng.zing.media.mp3.mw.podcast.thrift.client.TZMP3PodcastMWClient;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;
import org.apache.commons.codec.digest.DigestUtils;

public class PodcastServiceTest extends Test {

    private static final TZMP3PodcastMWClient MW = TZMP3PodcastMWClient.INST;

    //    private static final TZMP3PodcastServiceClient SERVICE = TZMP3PodcastServiceClient.INST;
//
    public static void main(String[] args) {
        try {
//            _testEpisode();
            _testProgram();
//            _testCategory();
//            _testList();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.exit(0);
    }

    //
//    private static void _testEpisode() throws IOException {
////        ThriftUtils.prettyPrint(SERVICE.getEpisodeHistorySlice(new TGetEpisodeHistorySliceReq()
////                .setUserId(WhiteListUserUtils.NAMNH16)
////                .setStart(20)
////                .setCount(10)
////        ));
//
////        List<TPodcastEpisode> episodes = SERVICE.mgetEpisode(new TMGetEpisodeReq()
////                .setEpisodeIds(Arrays.asList(1107549733, 1124674895, 1124676418))
////                .setAsList(true)
////        ).dataList;
////        EPaging<TPodcastEpisode> episodes = EPodcastProgramModel.INST.getListEpisode(
////                1454954673,
////                84,
////                0, 10,
////                true
////        );
////        for (TPodcastEpisode ep : episodes) {
////            System.out.println(ep.id + " " + ep.countryCodes);
////        }
//
//        TPodcastEpisode ep = MW.getEpisode(new TPodcastEpisodeGetReq()
//                .setId(1127722051)
//        ).value;
//        ThriftUtils.prettyPrint(ep);
//
////        int userId = NoiseUserIdUtils.denoiseUserId("53b736eec99520cb7984");
////        System.out.println(userId);
////        int userId = NAMNH16_ZMP3_ID;
//
////        TGetNewEpisodeIdsRes res = SERVICE.getNewEpisodeIds(new TGetNewEpisodeIdsReq()
////                .setUserId(userId)
////                .setStart(0)
////                .setCount(30)
////        );
////        ThriftUtils.prettyPrint(res);
////        List<TPodcastEpisode> eps = EPodcastEpisodeModel.INST.multiGetAsList(res.values);
////        eps.forEach(e -> System.out.println(e.status + " - " + e.title));
//    }
//
    private static void _testProgram() {
        PrintUtils.printTBase(MW.getEpisodeIdsOfProgram(new TPodcastProgramGetEpisodeIdsReq()
                .setProgramId(1492946538)
        ));
    }
//
//    private static void _testCategory() {
////        TPodcastCategory category = SERVICE.getCategory(new TGetCateforyReq().setCategoryId(12211)).category;
////        ThriftUtils.prettyPrint(category);
//
//        System.out.println(SERVICE.getCategoryProgramIdSlice(new TGetCategoryProgramIdSliceReq()
//                .setCategoryId(12321)
//                .setStart(0)
//                .setCount(100)
//        ).values.size());
//    }
//
//    private static void _testList() {
////        for (int start = 0; start < 120000; start += 250) {
////            List<Integer> values = TZMP3PodcastServiceClient.INST.getSlice(new TGetSliceReq()
////                    .setListType(TPodcastListType.PROGRAM_FOLLOWER.getValue())
////                    .setListId(1372611983)
////                    .setStart(start)
////                    .setCount(250)
////            ).values;
////        }
//
////        ThriftUtils.prettyPrint(SERVICE.getSlice(new TGetSliceReq()
////                .setListType(TPodcastListType.PROGRAM_FOLLOWER.getValue())
////                .setListId(1450144942)
////                .setStart(0)
////                .setCount(250)
////        ));
//
////        System.out.println(EPodcastProgramModel.INST.getFollowerCount(1372611983));
//
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
//    }
}
