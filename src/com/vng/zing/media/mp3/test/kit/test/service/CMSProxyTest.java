package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 25/06/2021
 */

import com.vng.zing.media.commonlib.thrift.TCMSClient;
import com.vng.zing.media.mp3.engine.wrapper.CMSProxyWrapper;
import com.vng.zing.media.mp3.proxy.cms.thrift.shared.TCMSHeader;

public class CMSProxyTest extends Test {

    private static final CMSProxyWrapper WRAPPER = CMSProxyWrapper.INST;

    //
    public static void main(String[] args) {
////        _testOA();
////        _testOAHome();
////        _testOABox();
////        _testOAStats();
////        _testEvent();
////        _testEpisode();
////        _testProgram();
////        _testCategory();
////        _testLivestream();
////        _testsPerformance();
////        _testAccount();
        _testLivestreamStats();
////        _testPodcastProgramStats();
////        _testPodcastEpisodeStats();
//        _testPlaylist();
//
//        System.exit(0);
    }

    //
//    public static void _testOA() {
////        List<TZMP3OAAccount> accounts = WRAPPER.getMyOAAccountSlice(1014146619, 0, 10);
////        accounts.forEach(ThriftUtils::prettyPrint);
////
////        TZMP3OA oa = WRAPPER.getOA(947376, 1014146619);
////        ThriftUtils.prettyPrint(oa);
//    }
//
//    private static void _testOAHome() {
//        TZMP3OAHome home = WRAPPER.getOAHome(638319, 1003611770);
//        ThriftUtils.prettyPrint(home);
//
////        List<TZMP3OABox> boxes = CMSProxyWrapper.INST.multiGetOABoxAsList(home.boxIds, 1003611770);
////        boxes.forEach(ThriftUtils::prettyPrint);
//
////        home.setBoxIds(Arrays.asList(10913, 10915));
////
////        Map<Integer, Integer> boxMap = new HashMap<>();
////        boxMap.put(2, 1);
////        boxMap.put(9, 1);
////        home.setBoxMap(boxMap);
////
////        System.out.println(WRAPPER.updateOAHome(home, 1003611770));
//    }
//
//    private static void _testOABox() {
////        System.out.println(WRAPPER.addOrUpdateOABox(new TZMP3OABox()
////                        .setCreatedAt(DateTimeUtils.currentTimeSeconds())
////                        .setCreatedBy(NAMNH16_ZMP3_ID)
////                        .setItemType(TZMP3OABoxItemType.PODCAST_EPISODE.getValue())
////                        .setDescription("Test Latest Podcast Episodes Box")
////                        .setItemIds(new ArrayList<>())
////                        .setModifiedAt(DateTimeUtils.currentTimeSeconds())
////                        .setModifiedBy(NAMNH16_ZMP3_ID)
////                        .setStatus(TZMP3OABoxStatus.SHOW.getValue())
////                        .setTimestamp(System.currentTimeMillis())
////                        .setTitle("Cac tap moi nhat")
////                        .setTitleEn("Latest Pocast Episodes")
////                        .setType(TZMP3OABoxType.LATEST_PODCAST_EPISODE.getValue())
////                        .setZmp3OAId(1921897)
////                        .setZmp3OAType(TZMP3OAType.BRAND.getValue()),
////                NAMNH16_ZMP3_ID
////        ));
//
////        List<Integer> itemIds = WRAPPER.getOABoxByType(1921897, TZMP3OABoxType.LATEST_PODCAST_EPISODE.getValue(), NAMNH16_ZMP3_ID).get(0).itemIds;
////        System.out.println(itemIds.size());
////        List<TPodcastEpisode> episodes = WRAPPER.multiGetPodcastEpisodeAsList(itemIds, NAMNH16_ZMP3_ID);
////        episodes.forEach(e -> System.out.println(e.title + " | " + DateTimeUtils.format(e.releaseDate, "yyyy/MM/dd HH:mm" + " | " + e.status)));
//
////        System.out.println(WRAPPER.removeOABox(14773, NGUYENLT4_ZMP3_ID));
//    }
//
//    private static void _testOAStats() {
////        ThriftUtils.prettyPrint(BAHAINAM.getOAZCPositionStats(new TGetOAZCPositionStatsReq()
////                .setOaId(Constant.OA_CHI_DAN)
////                .setUserId(NAMNH16_ZMP3_ID)
////                .setItemType(1)
////                .setFromTime(0)
////                .setToTime(0)
////        ));
//
////        ThriftUtils.prettyPrint(BAHAISAU.getOAZCPositionDetailStats(new TGetOAZCPositionDetailStatsReq()
////                .setOaId(Constant.OA_CHI_DAN)
////                .setUserId(NAMNH16_ZMP3_ID)
////                .setItemType(1)
////                .setItemId(1079315275)
////                .setFromTime(1609041703)
////                .setToTime(1640577703)
////        ));
//
////        ThriftUtils.prettyPrint(BAHAINAM.getOAZCPositionDetailChartSlice(new TGetOAZCPositionDetailChartSliceReq()
////                .setOaId(Constant.OA_CHI_DAN)
////                .setUserId(NAMNH16_ZMP3_ID)
////                .setStart(0)
////                .setCount(10)
////        ));
//
////        System.out.println(WRAPPER.getOAFollowerDemographicStats(1223281, NAMNH16_ZMP3_ID, 1647190800, 1649610000, true, true));
//
////        System.out.println(WRAPPER.getOAFollowChart(1223281, NAMNH16_ZMP3_ID, 1647190800, 1649610000));
//
////        System.out.println(WRAPPER.getOAListenChart(1223281, NAMNH16_ZMP3_ID, 1647190800, 1649610000));
//    }
//
//    private static void _testEvent() {
////        List<Integer> eventIds = WRAPPER.getOAEventIds(6980, 0, 0, WhiteListUserUtils.NAMNH16);
////        System.out.println(eventIds);
//
////        TEvent event = WRAPPER.getEvent(10615, WhiteListUserUtils.NAMNH16);
////        ThriftUtils.prettyPrint(event);
//
////        List<TEvent> events = WRAPPER.multiGetEventAsList(Arrays.asList(10282, 10620, 10275, 10305, 10558, 11053, 10313, 10327, 10341, 10352), WhiteListUserUtils.NAMNH16);
////        events.forEach(ThriftUtils::prettyPrint);
//
////        TEvent newEvent = new TEvent(event);
////        newEvent.setId(0);
////        System.out.println(WRAPPER.addOrUpdateEvent(newEvent, WhiteListUserUtils.NAMNH16));
//    }
//
//    private static void _testEpisode() {
////        System.out.println(WRAPPER.addOrUpdatePodcastEpisode(new TPodcastEpisode()
////                        .setTitle("Tập test proxy")
////                        .setEpisode(-1)
////                        .setChannelIds(Arrays.asList(1921897))
////                        .setProgramIds(Arrays.asList(1331068752))
////                        .setZmcId("2a934982b6da5f8406cb")
////                        .setZmcStatus(1)
////                        .setCountryCodes(Arrays.asList(84))
////                        .setDuration(0)
////                        .setStatus(1)
////                        .setPublicStatus(2)
////                        .setReleaseDate(1646308800)
////                        .setCreatedAt(1646458506)
////                        .setModifiedAt(1646458506)
////                        .setTimestamp(1646459400218L)
////                , NAMNH16_ZMP3_ID
////        ));
//
//        ThriftUtils.prettyPrint(WRAPPER.getPodcastEpisode(1128218574, NAMNH16_ZMP3_ID));
//    }
//
//    private static void _testProgram() {
////        TPodcastProgram program = WRAPPER.getPodcastProgram(1094011417, 1003611770);
////        ThriftUtils.prettyPrint(program);
////
////        program.setStatus(2);
////        System.out.println(WRAPPER.addOrUpdatePodcastProgram(program, 1003611770));
//
//        TI32ListResult programIds = WRAPPER.getOAPodcastProgramIds(XONE_RADIO_OA_ID, 0, 200, 1003611770);
//        System.out.println(programIds.values);
////        System.out.println(programIds);
////        List<TPodcastProgram> programs = WRAPPER.multiGetPodcastProgramAsList(programIds.values, 1003611770);
////        System.out.println(programs);
//
////        TI32ListResult epIds = WRAPPER.getPodcastProgramEpisodeIdSlice(1094011417, 0, 10, 1003611770);
////        System.out.println(epIds);
////        Map<Integer, Integer> dataMap = new HashMap<>();
////        for (int i = 0; i < epIds.values.size(); i++) {
////            dataMap.put(epIds.values.get(i), i+1);
////        }
////        dataMap.remove(1078188995);
////        System.out.println(dataMap);
////        System.out.println(WRAPPER.setPodcastProgramEpisodeId(1094011417, dataMap, 1003611770));
//
//        List<TPodcastProgram> programs = WRAPPER.multiGetPodcastProgramAsList(programIds.values, WhiteListUserUtils.NAMNH16);
//        programs.forEach(p -> System.out.println(p.title));
//    }
//
//    private static void _testCategory() {
//        TI32ListResult catIds = WRAPPER.getPodcastCategoryIdSlice(0, 10);
//        System.out.println(catIds);
//        List<TPodcastCategory> cats = WRAPPER.multiGetPodcastCategoryAsList(catIds.values);
//        System.out.println(cats);
//    }
//
//    private static void _testLivestream() {
//        TI32ListResult listResult = WRAPPER.getOALivestreamIds(947376, 0, 11, 1014483768);
//        List<TLiveStream> livestreams = WRAPPER.multiGetOALiveStreamAsList(947376, listResult.values, 1014483768);
//        livestreams.forEach(ThriftUtils::prettyPrint);
//
//        TMGetLiveStreamRs rs = TZMediaLiveStreamServiceClient.INST.mGetLiveStream(new TMGetLiveStreamReq().setStreamIds(listResult.values).setAsList(true));
//        ThriftUtils.prettyPrint(rs);
//    }
//
//    private static void _testAccount() {
////        WRAPPER.getMyOAAccountSlice(NGUYENLT4_ZMP3_ID, 0, 100).forEach(ThriftUtils::prettyPrint);
//        System.out.println(WRAPPER.getOAAccountPermission(1144229, NGUYENLT4_ZMP3_ID));
//    }
//
    private static void _testLivestreamStats() {
        System.out.println(WRAPPER.getLivestreamOverview(
                new TCMSHeader().setUserID(NAMNH16_ZMP3_ID).setClientPlatformID(TCMSClient.OA_CMS.getValue()).setObjectID(XONE_RADIO),
                10562
        ));

        System.out.println(WRAPPER.getLivestreamViewChart(
                new TCMSHeader().setUserID(NAMNH16_ZMP3_ID).setClientPlatformID(TCMSClient.OA_CMS.getValue()).setObjectID(XONE_RADIO),
                10562, 1669482000, 1670173200
        ));

        System.exit(0);
    }
//
//    private static void _testPodcastProgramStats() {
////        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramOverview(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983));
//
////        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramViewChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));
//
////        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramUserChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));
//
////        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramReturnRateChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));
//
////        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramPlayTimeChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));
//
////        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramFollowChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));
//    }
//
//    private static void _testPodcastEpisodeStats() {
//        Map<String, Long> values = WRAPPER.getPodcastEpisodeDropOffChart(1962225, NAMNH16_ZMP3_ID, 1128161877).values;
//        System.out.println(values.entrySet().stream().sorted(Comparator.comparingInt(a -> ConvertUtils.toInteger(a.getKey()))).collect(Collectors.toList()));
//    }
//
//    private static void _testPlaylist() {
////        System.out.println(WRAPPER.getOAPlaylistIDs(BAO_QUYEN_OA_ID, NAMNH16_ZMP3_ID, 0, 100));
////        TPlaylist playlist = WRAPPER.getOAPlaylist(BAO_QUYEN_OA_ID, NAMNH16_ZMP3_ID, 1489750475);
////        System.out.println(WRAPPER.updateOAPlaylist(
////                BAO_QUYEN_OA_ID, NAMNH16_ZMP3_ID, 1489750475, playlist.storageMeta.title, playlist.storageMeta.description,
////                playlist.storageMeta.coverImage, playlist.storageMeta.mediaIds, 2, false
////        ));
////        TZMP3PublisherMWClient.INST.removeAsset(new TRemoveAssetMWReq()
////                .setPublisherId(BAO_QUYEN_OA_ID)
////                .setAssetId(1489750475)
////                .setAssetStatus(1)
////                .setAssetType(TZMP3OAAssetType.PLAYLIST.getValue())
////        );
////        System.out.println(WRAPPER.getOAPlaylistIDs(BAO_QUYEN_OA_ID, NAMNH16_ZMP3_ID, 0, 100, 2));
//    }
}
