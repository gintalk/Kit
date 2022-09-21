package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/03/2021
 */

import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;

public class CoreServiceTest extends Test {

//    private static final TZMP3CoreServiceClient CORE_SERVICE = TZMP3CoreServiceClient.INST;
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;
//
    public static void main(String[] args) {
        System.out.println(CORE_MW.getMediaIdsOfPlaylist(1073896871));

////        ThriftUtils.prettyPrint(CORE_SERVICE.getMedia(new TGetMediaReq()
////                .setId(1125869134)
////        ));
//
////        System.out.println(EMediaModel.INST.get(1126720611).audio.releaseDate);
////        ThriftUtils.prettyPrint(CORE_MW.getMedia(1126774785).value.audio);
//
////        ThriftUtils.prettyPrint(CORE_SERVICE.getSliceIdsScore(new TGetSliceIdsScoreReq()
////                .setType(TMP3ListType.LIST_TOP_BY_ARTIST.getValue())
////                .setItemType(TMP3ItemType.MEDIA.getValue())
////                .setId(1911872)
////                .setStart(0)
////                .setCount(100)
////        ));
//
////        System.out.println(CORE_MW.getSliceIds(new TListInfo()
////                .setId(1873062)
////                .setType(TMP3ListType.LIST_BY_ARTIST.getValue())
////                .setItemType(TMP3ItemType.MEDIA.getValue())
////                .setCountryCode(84)
////        , 0, 100));
//
////        System.out.println(CORE_SERVICE.getTotalFollow(new TGetTotalFollowReq()
////                .setType(TFollowType.ARTIST.getValue())
////                .setId(958520)
////        ));
//
////        System.out.println(CORE_SERVICE.putStringConfig(new TPutStringConfigReq()
////                .setCountryCode(84)
////                .setKey(TStringConfigKey.PODCAST_EPISODE_RANKING.name())
////                .setValue(JsonWrapper.parseStr(Arrays.asList(
////                        1127173747, 1127215181, 1127444462, 1126915022, 1125436955, 1127482983, 1125435981, 1125436224, 1127443366, 1127003390, 1125436482, 1125436734, 1127482997, 1127319759, 1127405381, 1126581147, 1124851883, 1123868795, 1127365648, 1127405318, 1107525457, 1126444749, 1127544096, 1127405403, 1126763140, 1104058299, 1124851902, 1124490236, 1126175690, 1127320005, 1127213201, 1127336751, 1127483006, 1127319937, 1127187578, 1124851934, 1124492939, 1124490965, 1123868798, 1124490295, 1127510017, 1124448475, 1125187234, 1115414442, 1123868814, 1123868808, 1124493711, 1124490724, 1127483024, 1125880556
////                )))
////        ));
//
//        System.out.println(CORE_SERVICE.getStringConfig(new TGetStringConfigReq()
//                .setCountryCode(84)
//                .setKey(TStringConfigKey.PODCAST_EPISODE_RANKING.name())
//        ).value);
//        System.out.println(CORE_SERVICE.putStringConfig(new TPutStringConfigReq()
//                .setCountryCode(84)
//                .setKey(TStringConfigKey.PODCAST_EPISODE_RANKING.name())
//                .setValue(JsonWrapper.parseStr(Arrays.asList(
//                        1127173747,1127215181,1127444462,1126915022,1125436955,1127482983,1125435981,1125436224,1127443366,
//                        1127003390,1125436482,1125436734,1127482997,1127319759,1127405381,1126581147,1124851883,1123868795,
//                        1127365648,1127405318,1107525457,1126444749,1127544096,1127405403,1126763140,1104058299,1124851902,
//                        1124490236,1126175690,1127320005,1127213201,1127336751,1127483006,1127319937,1127187578,1124851934,
//                        1124492939,1124490965,1123868798,1124490295,1127510017,1124448475,1125187234,1115414442,1123868814,
//                        1123868808,1124493711,1124490724,1127483024,1125880556
//                )))
//        ));
//
////        String value = CORE_SERVICE.getStringConfig(new TGetStringConfigReq()
////                .setCountryCode(84)
////                .setKey(StringConfigKeyUtils.getHomeSectionLayoutConfigKey(true))
////        ).value;
////        THomeSectionLayout loggedInLayout = JsonWrapper.parseObj(value, THomeSectionLayout.class);
////        loggedInLayout.sections.forEach(System.out::println);
////        THomeSectionLayout nonLoggedInLayout = JsonWrapper.parseObj(value, THomeSectionLayout.class);
////        nonLoggedInLayout.sections.add(
////                new THomeSection(THomeSectionType.PROMOTE_PODCAST_PROGRAM, false, false)
////        );
////        System.out.println(CORE_SERVICE.putStringConfig(new TPutStringConfigReq()
////                .setKey(StringConfigKeyUtils.getHomeSectionLayoutConfigKey(false))
////                .setCountryCode(84)
////                .setValue(JsonWrapper.parseStr(nonLoggedInLayout))
////        ));
//
////        THomeSectionLayout layout = new THomeSectionLayout(0, Arrays.asList(
////                new THomeSection(THomeSectionType.BANNERS, false, false),
////                new THomeSection(THomeSectionType.SHORTCUT_NAVIGATION, false, false),
////                new THomeSection(THomeSectionType.EVENT_BANNERS, false, false),
////                new THomeSection(THomeSectionType.DOWNLOADED_PLAYLISTS, false, false),
////                new THomeSection(THomeSectionType.RETARGETING_HUB, false, false),
////                new THomeSection(THomeSectionType.SUGGESTED_PLAYLISTS, true, false),
////                new THomeSection(THomeSectionType.RECENTLY_PLAYED, true, false),
////                new THomeSection(THomeSectionType.PERSONALIZED_PLAYLISTS, true, false),
////                new THomeSection(THomeSectionType.LATEST_POSTS, false, false),
////                new THomeSection(THomeSectionType.MTHEME_1, false, false),
////                new THomeSection(THomeSectionType.MTHEME_2, false, false),
////                new THomeSection(THomeSectionType.MAUTO_THEME_1, false, false),
////                new THomeSection(THomeSectionType.LIVESTREAMS, true, false),
////                new THomeSection(THomeSectionType.REALTIME_ZCHART, false, false),
////                new THomeSection(THomeSectionType.ZCHART_WEEKLY, false, false),
////                new THomeSection(THomeSectionType.TOP_100_PLAYLISTS, true, false),
////                new THomeSection(THomeSectionType.NEW_RELEASED_PLAYLISTS, false, false),
////                new THomeSection(THomeSectionType.HOT_VIDEOS, false, false),
////                new THomeSection(THomeSectionType.HOT_COVER, false, false),
////                new THomeSection(THomeSectionType.AUTOGENRE_1, false, false),
////                new THomeSection(THomeSectionType.AUTOGENRE_2, false, false),
////                new THomeSection(THomeSectionType.RADIO, true, false),
////                new THomeSection(THomeSectionType.SUGGEST_BY_ARTIST, false, false),
////                new THomeSection(THomeSectionType.SUGGEST_BY_PLAYLIST, false, false),
////                new THomeSection(THomeSectionType.SUGGEST_BY_SONG, false, false),
////                new THomeSection(THomeSectionType.HUB, false, false),
////                new THomeSection(THomeSectionType.HOT_ALBUMS, false, false),
////                new THomeSection(THomeSectionType.HOT_SONGS, false, false),
////                new THomeSection(THomeSectionType.UPCOMING_EVENT, false, false),
////                new THomeSection(THomeSectionType.PROMOTE_PODCAST_PROGRAM, false, false),
////                new THomeSection(THomeSectionType.EVENT_FOR_YOU, false, false),
////                new THomeSection(THomeSectionType.LIVE_RADIO, true, false)
////        ));
//
////        System.out.println(CORE_SERVICE.putStringConfig(new TPutStringConfigReq()
////                .setKey(StringConfigKeyUtils.getHomeSectionLayoutConfigKey(true))
////                .setCountryCode(84)
////                .setValue(JsonWrapper.parseStr(layout))
////        ));
//
        System.exit(0);
    }
}
