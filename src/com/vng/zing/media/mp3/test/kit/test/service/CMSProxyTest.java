package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 25/06/2021
 */

import com.vng.zing.media.common.thrift.TCMSClient;
import com.vng.zing.media.common.thrift.TCMSHeader;
import com.vng.zing.media.mp3.common.thrift.TCountryCode;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAAccount;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABoxItemType;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAPromotionStatus;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisode;
import com.vng.zing.media.mp3.common.thrift.search.TZMP3SearchESType;
import com.vng.zing.media.mp3.common.thrift.search.TZMP3SearchFilter;
import com.vng.zing.media.mp3.common.thrift.search.TZMP3SearchFilterParam;
import com.vng.zing.media.mp3.common.thrift.search.TZMP3SearchSort;
import com.vng.zing.media.mp3.engine.wrapper.CMSProxyWrapper;
import com.vng.zing.media.mp3.searchservice.thrift.client.TZMP3SearchServiceClient;
import com.vng.zing.media.mp3.searchservice.thrift.req.TSearchESReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

import java.util.Collections;
import java.util.List;

public class CMSProxyTest extends Test {

    private static final CMSProxyWrapper WRAPPER = CMSProxyWrapper.INST;

    public static void main(String[] args) {
//        _testOA();
//        _testOAHome();
//        _testOABox();
//        _testOAStats();
//        _testEvent();
//        _testEpisode();
//        _testProgram();
//        _testCategory();
//        _testLivestream();
//        _testsPerformance();
//        _testAccount();
//        _testLivestreamStats();
//        _testPodcastProgramStats();
//        _testPodcastEpisodeStats();
        _testPlaylist();
//        _testPromotion();

        System.exit(0);
    }

    public static void _testOA() {
//        List<TZMP3OAAccount> accounts = WRAPPER.getMyOAAccountSlice(1014146619, 0, 10);
//        accounts.forEach(ThriftUtils::prettyPrint);
//

    }

    private static void _testOAHome() {
//        List<TZMP3OABox> boxes = CMSProxyWrapper.INST.multiGetOABoxAsList(home.boxIds, 1003611770);
//        boxes.forEach(ThriftUtils::prettyPrint);

//        home.setBoxIds(Arrays.asList(10913, 10915));
//
//        Map<Integer, Integer> boxMap = new HashMap<>();
//        boxMap.put(2, 1);
//        boxMap.put(9, 1);
//        home.setBoxMap(boxMap);
//
//        System.out.println(WRAPPER.updateOAHome(home, 1003611770));
    }

    private static void _testOABox() {
//        System.out.println(WRAPPER.addOrUpdateOABox(new TZMP3OABox()
//                        .setCreatedAt(DateTimeUtils.currentTimeSeconds())
//                        .setCreatedBy(NAMNH16_ZMP3_ID)
//                        .setItemType(TZMP3OABoxItemType.PODCAST_EPISODE.getValue())
//                        .setDescription("Podcast mới nhất type 12")
//                        .setItemIds(Arrays.asList(1123540336))
//                        .setModifiedAt(DateTimeUtils.currentTimeSeconds())
//                        .setModifiedBy(NAMNH16_ZMP3_ID)
//                        .setStatus(TZMP3OABoxStatus.SHOW.getValue())
//                        .setTimestamp(System.currentTimeMillis())
//                        .setTitle("Podcast mới nhất type 12")
//                        .setTitleEn("PODCAST_EPISODE")
//                        .setType(TZMP3OABoxType.PODCAST_EPISODE.getValue())
//                        .setZmp3OAId(VED_DNARB_OA_ID)
//                        .setZmp3OAType(TZMP3OAType.BRAND.getValue()),
//                NAMNH16_ZMP3_ID
//        ));

//        List<Integer> itemIds = WRAPPER.getOABoxByType(1921897, TZMP3OABoxType.LATEST_PODCAST_EPISODE.getValue(), NAMNH16_ZMP3_ID).get(0).itemIds;
//        System.out.println(itemIds.size());
//        List<TPodcastEpisode> episodes = WRAPPER.multiGetPodcastEpisodeAsList(itemIds, NAMNH16_ZMP3_ID);
//        episodes.forEach(e -> System.out.println(e.title + " | " + DateTimeUtils.format(e.releaseDate, "yyyy/MM/dd HH:mm" + " | " + e.status)));

//        System.out.println(WRAPPER.removeOABox(15146, NAMNH16_ZMP3_ID));

//        List<TZMP3OABox> boxes = WRAPPER.multiGetOABoxAsList(boxIds, NAMNH16_ZMP3_ID);
//        boxes.forEach(b -> {
//            System.out.println(WRAPPER.multiGetPodcastEpisodeAsList(b.itemIds, NAMNH16_ZMP3_ID));
//        });


    }

    private static void _testOAStats() {
//        ThriftUtils.prettyPrint(BAHAINAM.getOAZCPositionStats(new TGetOAZCPositionStatsReq()
//                .setOaId(Constant.OA_CHI_DAN)
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setItemType(1)
//                .setFromTime(0)
//                .setToTime(0)
//        ));

//        ThriftUtils.prettyPrint(BAHAISAU.getOAZCPositionDetailStats(new TGetOAZCPositionDetailStatsReq()
//                .setOaId(Constant.OA_CHI_DAN)
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setItemType(1)
//                .setItemId(1079315275)
//                .setFromTime(1609041703)
//                .setToTime(1640577703)
//        ));

//        ThriftUtils.prettyPrint(BAHAINAM.getOAZCPositionDetailChartSlice(new TGetOAZCPositionDetailChartSliceReq()
//                .setOaId(Constant.OA_CHI_DAN)
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setStart(0)
//                .setCount(10)
//        ));

//        System.out.println(WRAPPER.getOAFollowerDemographicStats(1223281, NAMNH16_ZMP3_ID, 1647190800, 1649610000, true, true));

//        System.out.println(WRAPPER.getOAFollowChart(961068, NAMNH16_ZMP3_ID, 1647622800, 1652893200));

//        System.out.println(WRAPPER.getOAListenChart(1223281, NAMNH16_ZMP3_ID, 1647190800, 1649610000));
    }

    private static void _testEvent() {
//        List<Integer> eventIds = WRAPPER.getOAEventIds(VED_DNARB_OA_ID, 0, 0, NGUYENLT4_ZMP3_ID).values;
//        System.out.println(eventIds);

//        TEvent event = WRAPPER.getEvent(10615, WhiteListUserUtils.NAMNH16);
//        ThriftUtils.prettyPrint(event);

//        List<TEvent> events = WRAPPER.multiGetEventAsList(Arrays.asList(10282, 10620, 10275, 10305, 10558, 11053, 10313, 10327, 10341, 10352), WhiteListUserUtils.NAMNH16);
//        events.forEach(ThriftUtils::prettyPrint);

//        TEvent newEvent = new TEvent(event);
//        newEvent.setId(0);
//        System.out.println(WRAPPER.addOrUpdateEvent(newEvent, WhiteListUserUtils.NAMNH16));

        WRAPPER.getEventTypeSlice(CMS_HEADER.apply(6980, NAMNH16_ZMP3_ID), 0, 100).values.forEach(t -> System.out.println(t.name));
    }

    private static void _testEpisode() {
        System.out.println(WRAPPER.addOrUpdatePodcastEpisode(new TCMSHeader().setClientPlatformID(TCMSClient.OA_CMS.getValue()).setObjectID(1001371).setUserID(NAMNH16_ZMP3_ID), new TPodcastEpisode().setTitle("Trùng title").setEpisode(-1).setChannelIds(Collections.singletonList(1001371)).setProgramIds(Collections.singletonList(1331068752)).setZmcId("2a934982b6da5f8406cb").setZmcStatus(1).setCountryCodes(Collections.singletonList(84)).setDuration(0).setStatus(1).setPublicStatus(2).setReleaseDate(1646308800).setCreatedAt(1646458506).setModifiedAt(1646458506).setTimestamp(1646459400218L), false));

//        ThriftUtils.prettyPrint(WRAPPER.getPodcastEpisode(
//                new TCMSHeader().setClientPlatformID(TCMSClient.OA_CMS.getValue()).setObjectID(1001371).setUserID(NAMNH16_ZMP3_ID),
//                1132849107
//        ));

        System.out.println(WRAPPER.getPodcastProgramEpisodeIdSlice(new TCMSHeader().setClientPlatformID(TCMSClient.OA_CMS.getValue()).setObjectID(1001371).setUserID(NAMNH16_ZMP3_ID), 1331068752, 0, 10));
    }

    private static void _testProgram() {
//        TPodcastProgram program = WRAPPER.getPodcastProgram(1094011417, 1003611770);
//        ThriftUtils.prettyPrint(program);
//
//        program.setStatus(2);
//        System.out.println(WRAPPER.addOrUpdatePodcastProgram(program, 1003611770));

//        TI32ListResult programIds = WRAPPER.getOAPodcastProgramIds(ON_AIR_OA_ID, 0, 200, 1040149705);
//        System.out.println(programIds.values);
//        System.out.println(programIds);
//        List<TPodcastProgram> programs = WRAPPER.multiGetPodcastProgramAsList(programIds.values, 1003611770);
//        System.out.println(programs);

//        TI32ListResult epIds = WRAPPER.getPodcastProgramEpisodeIdSlice(1442829803, 0, 100, 1040149705);
//        List<TPodcastEpisode> eps = WRAPPER.multiGetPodcastEpisodeAsList(epIds.values, 1040149705);
//        eps.forEach(e -> System.out.println(e.title));
//        Map<Integer, Integer> dataMap = new HashMap<>();
//        for (int i = 0; i < epIds.values.size(); i++) {
//            dataMap.put(epIds.values.get(i), i+1);
//        }
//        dataMap.remove(1078188995);
//        System.out.println(dataMap);
//        System.out.println(WRAPPER.setPodcastProgramEpisodeId(1094011417, dataMap, 1003611770));

//        List<TPodcastProgram> programs = WRAPPER.multiGetPodcastProgramAsList(programIds.values, WhiteListUserUtils.NAMNH16);
//        programs.forEach(p -> System.out.println(p.title));
    }

    private static void _testCategory() {
    }

    private static void _testLivestream() {
    }

    private static void _testAccount() {
        List<TZMP3OAAccount> accounts = WRAPPER.getOAAccountSlice(CMS_HEADER.apply(1013702, NAMNH16_ZMP3_ID), 0, 10);
        accounts.forEach(PrintUtils::printTBase);
//        PrintUtils.printOAAccountPermission(WRAPPER.getOAAccountPermission(CMS_HEADER.apply(1013702, 2072500), 2072500));

//        System.out.println(WRAPPER.putOAAccount(CMS_HEADER.apply(1013702, 2072500), 1084267889, TZMP3OAAccountRole.MEMBER.getValue()));
//        System.out.println(WRAPPER.removeOAAccount(CMS_HEADER.apply(2247056, 1036815003), 1033327547));
    }

    private static void _testLivestreamStats() {
//        ThriftUtils.prettyPrint(BAHAINAM.getLivestreamOverview(new TGetLivestreamOverviewReq()
//                .setLivestreamID(10562)
//                .setOaID(XONE_RADIO_OA_ID)
//                .setUserID(QUYENDB2_ZMP3_ID)
//        ));
//
//        ThriftUtils.prettyPrint(BAHAINAM.getLivestreamViewChart(new TGetLivestreamViewChartReq()
//                .setLivestreamID(10562)
//                .setOaID(XONE_RADIO_OA_ID)
//                .setUserID(QUYENDB2_ZMP3_ID)
//                .setFromTime(1646067600)
//                .setToTime(1646240400)
//        ));
//
//        ThriftUtils.prettyPrint(WRAPPER.getLivestreamUserChart(
//                1223281,
//                NAMNH16_ZMP3_ID,
//                10643,
//                1649091600,
//                1649696400)
//        );
//
//        ThriftUtils.prettyPrint(BAHAINAM.getLivestreamPlayTimeChart(new TGetLivestreamPlayTimeChartReq()
//                .setLivestreamID(10562)
//                .setOaID(XONE_RADIO_OA_ID)
//                .setUserID(QUYENDB2_ZMP3_ID)
//                .setFromTime(1646067600)
//                .setToTime(1646240400)
//        ));
//
//        ThriftUtils.prettyPrint(BAHAINAM.getLivestreamReturnRateChart(new TGetLivestreamReturnRateChartReq()
//                .setLivestreamID(10562)
//                .setOaID(XONE_RADIO_OA_ID)
//                .setUserID(QUYENDB2_ZMP3_ID)
//                .setFromTime(1646067600)
//                .setToTime(1646240400)
//        ));
//
//        ThriftUtils.prettyPrint(BAHAINAM.getLivestreamUserDemographicStats(new TGetLivestreamUserDemographicStatsReq()
//                .setLivestreamID(10562)
//                .setOaID(947376)
//                .setUserID(1021507292)
//                .setTime(1646192771)
//        ));
//
//        System.out.println(BAHAINAM.getLivestreamCCUChart(new TGetLivestreamCCUChartReq()
//                .setLivestreamID(10562)
//                .setOaID(XONE_RADIO_OA_ID)
//                .setUserID(QUYENDB2_ZMP3_ID)
//                .setFromTime(1646067600)
//                .setToTime(1646240400)
//                .setMinuteStep(30)
//        ).values.entrySet().stream().sorted((a, b) -> (int) (ConvertUtils.toLong(a.getKey()) - ConvertUtils.toLong(b.getKey()))).collect(Collectors.toList()));

        System.out.println();
    }

    private static void _testPodcastProgramStats() {
//        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramOverview(XONE_RADIO_OA_ID, NGUYENLT4_ZMP3_ID, 1372611983));

//        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramViewChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));

//        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramUserChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));

//        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramReturnRateChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));

//        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramPlayTimeChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));

//        ThriftUtils.prettyPrint(WRAPPER.getPodcastProgramFollowChart(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1372611983, 1646499600, 1649232781));
    }

    private static void _testPodcastEpisodeStats() {
//        Map<String, Long> values = WRAPPER.getPodcastEpisodeDropOffChart(1962225, NAMNH16_ZMP3_ID, 1128161877).values;
//        System.out.println(values.entrySet().stream().sorted(Comparator.comparingInt(a -> ConvertUtils.toInteger(a.getKey()))).collect(Collectors.toList()));

//        ThriftUtils.prettyPrint(WRAPPER.getPodcastEpisodeOverview(XONE_RADIO_OA_ID, NAMNH16_ZMP3_ID, 1128299373).value);
    }

    private static void _testPlaylist() {
//        List<Integer> playlistIDs = WRAPPER.getOAPlaylistIDs(VED_DNARB_OA_ID, NAMNH16_ZMP3_ID, 0, 100).values;
//        System.out.println(playlistIDs);
//        for (int playlistID : playlistIDs) {
//            TPlaylist playlist = WRAPPER.getOAPlaylist(VED_DNARB_OA_ID, NAMNH16_ZMP3_ID, playlistID);
//            System.out.println(WRAPPER.updateOAPlaylist(
//                    VED_DNARB_OA_ID, NAMNH16_ZMP3_ID, playlistID, playlist.storageMeta.title, playlist.storageMeta.description,
//                    playlist.storageMeta.coverImage, playlist.storageMeta.mediaIds, 1, false
//            ));
//            System.out.println(playlist.storageMeta.id + " | " + playlist.storageMeta.title + " | " + playlist.storageMeta.modifiedAt);
//        }

//        TPlaylist playlist = WRAPPER.getOAPlaylist(VED_DNARB_OA_ID, NAMNH16_ZMP3_ID, 1489839577);
//        ThriftUtils.prettyPrint(playlist.storageMeta);

//        System.out.println(CMSProxyWrapper.INST.searchOAPlaylist(VED_DNARB_OA_ID, NIENDT_ZMP3_ID, 0, 100, "kaka"));
//        System.out.println(CMSProxyWrapper.INST.searchOAPlaylist(CMS_HEADER.setObjectID(XONE_RADIO_OA_ID).setUserID(NAMNH16_ZMP3_ID), 0, 100, "In the Asia"));
        System.out.println(TZMP3SearchServiceClient.INST.searchES(new TSearchESReq()
                .setSearchESType(TZMP3SearchESType.PLAYLIST.getValue())
                .setKeyword("in the asia")
                .setCountryCode(TCountryCode.VIETNAM.getValue())
                .setStart(0)
                .setCount(100)
                .setFields(Collections.emptyList())
                .setSort(TZMP3SearchSort.DEFAULT.getValue())
                .setFilters(Collections.singletonList(new TZMP3SearchFilterParam()
                        .setFieldId(TZMP3SearchFilter.CREATED_BY.getValue()).
                        setValueNum(1059126461))
                )
        ));

//        System.out.println(WRAPPER.updateOAPlaylist(
//                BAO_QUYEN_OA_ID, NAMNH16_ZMP3_ID, 1489750475, playlist.storageMeta.title, playlist.storageMeta.description,
//                playlist.storageMeta.coverImage, playlist.storageMeta.mediaIds, 2, false
//        ));
//        TZMP3PublisherMWClient.INST.removeAsset(new TRemoveAssetMWReq()
//                .setPublisherId(BAO_QUYEN_OA_ID)
//                .setAssetId(1489750475)
//                .setAssetStatus(1)
//                .setAssetType(TZMP3OAAssetType.PLAYLIST.getValue())
//        );
//        System.out.println(WRAPPER.getOAPlaylistIDs(BAO_QUYEN_OA_ID, NAMNH16_ZMP3_ID, 0, 100, 2));
    }

    private static void _testPromotion() {
        TCMSHeader header = CMS_HEADER.apply(DEMO_4_DEV, NIENDT_ZMP3_ID);

        System.out.println(WRAPPER.addOAPromotion(
                header,
                TZMP3OABoxItemType.PLAYLIST.getValue(),
                Collections.singletonList(5),
                1657169540,
                1657169541,
                TZMP3OAPromotionStatus.SHOWN.getValue()
        ));

//        System.out.println(WRAPPER.updateOAPromotion(
//                header,
//                13,
//                TZMP3OABoxItemType.PODCAST_PROGRAM.getValue(),
//                Collections.singletonList(8),
//                1657164600,
//                1657164720,
//                TZMP3OAPromotionStatus.SHOWN.getValue()
//        ));

//        WRAPPER.multiGetOAPromotionAsList(header, WRAPPER.getOAPromotionIDSlice(header, 0, 100).values).forEach(PrintUtils::printTBase);
    }
}
