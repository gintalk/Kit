package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 18/03/2022
 */

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.alert.service.thrift.TAlertMessageDetailType;
import com.vng.zing.media.alert.service.thrift.TAlertMessageReceivedType;
import com.vng.zing.media.alert.service.thrift.TAlertType;
import com.vng.zing.media.alert.service.thrift.TOAInfo;
import com.vng.zing.media.alert.service.thrift.TSendMessageReq;
import com.vng.zing.media.alert.service.thrift.client.TZMediaAlertServiceClient;
import com.vng.zing.media.commonlib.thrift.TPlatform;
import com.vng.zing.media.commonlib.thrift.TStringResult;
import com.vng.zing.media.commonlib.utils.LogUtils;
import com.vng.zing.media.commonlib.wrapper.oa.OAMsgWrapper;
import com.vng.zing.media.mp3.commonlib.thrift.TZMP3RCounterDimension;
import com.vng.zing.media.mp3.commonlib.thrift.TZMP3RCounterObject;
import com.vng.zing.media.mp3.commonlib.thrift.TZMP3RCounterType;
import com.vng.zing.media.mp3.commonlib.thrift.TZMP3RCounterZone;
import com.vng.zing.media.mp3.mw.stats.thrift.TBaseQueryGenStats;
import com.vng.zing.media.mp3.mw.stats.thrift.TMappedQueryGenTextStats;
import com.vng.zing.media.mp3.mw.stats.thrift.TQueryGenTextStats;
import com.vng.zing.media.mp3.mw.stats.thrift.TSource;
import com.vng.zing.media.mp3.mw.stats.thrift.client.TZMP3StatsMWClient;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RealtimeTest extends Test {

    private static final TZMP3StatsMWClient STATS_MW = TZMP3StatsMWClient.INST;

    public static void main(String[] args) {
        Date time = new Date(1670842800000L);

//        source(time);
        iSource(time);

//        song(time);
//        iSong(time);

//        Map<Integer, Map<Integer, List<Long>>> values = new ZMediaRealtimeCounterClient("main").getCounters(
//                new TRCountersQuery()
//                        .setDimensions(Arrays.stream(TZMP3RCounterDimension.values()).map(TZMP3RCounterDimension::getValue).collect(Collectors.toList()))
//                        .setItemId(0)
//                        .setObject(TZMP3RCounterObject.SONG.getValue())
//                        .setPlatforms(Arrays.asList(TPlatform.WEB_DESKTOP.getValue(), TPlatform.APP_ANDROID.getValue()))
//                        .setType(TZMP3RCounterType.LISTEN.getValue())
//                        .setSrc("htpTrending")
//                        .setStartTime(new TRCDayTime().setDay(1).setMonth(12).setYear(2022).setHour(0))
//                        .setEndTime(new TRCDayTime().setDay(8).setMonth(12).setYear(2022).setHour(23))
//                        .setZone(TZMP3RCounterZone.ZMP3.getValue())
//        ).values;

        /*
         * Dimension: {Platform=[Value at start time, ..., value at end time]}
         * - Dimensions: -1 = official, 0 = all, 1 = vip, 2 = online, 3 = login, 4 = cheat
         * - Platforms: 1 = web desktop, 4 = android, 8 = ios
         */
//        values.forEach((k, v) -> {
//            System.out.println(TZMP3RCounterDimension.findByValue(k));
//            v.forEach((i, j) -> System.out.println("\t" + TPlatform.findByValue(i) + ": " + j.stream().filter(h -> h > 0).collect(Collectors.toList())));
//        });

        System.exit(0);
    }

    private static void source(Date time) {
        TQueryGenTextStats query = new TQueryGenTextStats(
                new TBaseQueryGenStats(
                        time.getTime(), true, false,
                        TZMP3RCounterObject.SONG.getValue(), TZMP3RCounterType.LISTEN.getValue(),
                        TZMP3RCounterZone.ZMP3.getValue(), TZMP3RCounterDimension.ALL.getValue(), "0"
                ),
                Arrays.asList(TPlatform.APP_IOS.getValue(), TPlatform.APP_ANDROID.getValue()),
                Arrays.asList(
                        new TSource("My Music",
                                Arrays.asList("mFavSong", "mSong", "mPlaylist", "mRecent", "mFavAlbum", "mArtist", "offSong", "offPlaylist")
                        ),
                        new TSource("Chart", Arrays.asList("zChart", "hZC")),
                        new TSource("Home",
                                Arrays.asList("hRecent", "hSuggestPl", "hsTop100", "hsTopNewSong", "h100", "hTheme", "hSlider", "hsHub", "hsVip",
                                        "hRetargeting", "hNewReleases", "hNewReleasesDetail", "hSuggestAlbum", "hPersonalized", "hDm", "hOnRepeat",
                                        "hDiscovery", "hRewind", "hFavoriteMix", "hSuggestByPlaylist", "hSuggestByArtist", "hMix", "hAutoTheme1",
                                        "hRadio", "hAutoGenre1", "hAutoGenre2", "hXONE", "hAlbum")
                        ),
                        new TSource("Home Monitor",
                                Arrays.asList("hSuggestPl", "hsTop100", "hsTopNewSong", "h100 ", "hTheme", "hSlider", "hsHub", "hsVip", "hRetargeting",
                                        "hNewReleases", "hNewReleasesDetail", "hSuggestAlbum", "hPersonalized", "hDm", "hOnRepeat", "hDiscovery",
                                        "hRewind", "hFavoriteMix", "hSuggestByPlaylist", "hSuggestByArtist", "hMix", "hAutoTheme1", "hRadio",
                                        "hAutoGenre1", "hAutoGenre2", "hXONE", "hAlbum")
                        ),
                        new TSource("Search",
                                Arrays.asList("search", "searchRecent", "searchACSuggested", "searchSuggestedResult", "searchFullSong",
                                        "searchFullArtist", "searchFullPlaylist", "searchACLocal", "searchFull", "searchOff", "searchHub",
                                        "searchGenreMood")
                        ),
                        new TSource("Similar", Arrays.asList("mpSimSong", "riSimilarSongs")),
                        new TSource("Unknown", Collections.singletonList("unknown"))
                )
        );

        TStringResult sResult = STATS_MW.genTextStatsReport(query);
        System.out.println(sResult.value);
//            sendTextMsg(query.baseQuery.object, !CommonUtils.isEmpty(query.sources), sResult.value, Arrays.asList(1, 3));
    }

    private static void iSource(Date time) {
        List<TSource> mobileSources = Arrays.asList(
                new TSource("My Music", Arrays.asList(
                        "mFavSong", "mSong", "mPlaylist", "mRecent", "mFavAlbum", "mArtist", "offSong", "offPlaylist"
                )), new TSource("Chart", Arrays.asList(
                        "zChart", "hZC"
                )), new TSource("Home", Arrays.asList(
                        "hRecent", "hSuggestPl", "hsTop100", "hsTopNewSong", "h100", "hTheme", "hSlider", "hsHub",
                        "hsVip", "hRetargeting", "hNewReleases", "hNewReleasesDetail", "hSuggestAlbum", "hPersonalized",
                        "hDm", "hOnRepeat", "hDiscovery", "hRewind", "hFavoriteMix", "hSuggestByPlaylist", "hSuggestByArtist",
                        "hMix", "hAutoTheme1", "hRadio", "hAutoGenre1", "hAutoGenre2", "hXONE", "hAlbum",
                        // new - December 1, 2022 9:37 AM
                        "hArtistTheme", "hTopPicks", "htpTrending", "htpArtist", "htpPromoteArtist", "htpActivity", "hPromote", "hCategory"
                )), new TSource("Home Monitor", Arrays.asList(
                        "hSuggestPl", "hsTop100", "hsTopNewSong", "h100 ", "hTheme", "hSlider", "hsHub", "hsVip", "hRetargeting",
                        "hNewReleases", "hNewReleasesDetail", "hSuggestAlbum", "hPersonalized", "hDm", "hOnRepeat", "hDiscovery",
                        "hRewind", "hFavoriteMix", "hSuggestByPlaylist", "hSuggestByArtist", "hMix", "hAutoTheme1", "hRadio",
                        "hAutoGenre1", "hAutoGenre2", "hXONE", "hAlbum",
                        // new - December 1, 2022 9:37 AM
                        "hArtistTheme", "hTopPicks", "htpTrending", "htpArtist", "htpPromoteArtist", "htpActivity", "hPromote", "hCategory"
                )), new TSource("Search", Arrays.asList("search", "searchRecent", "searchACSuggested", "searchSuggestedResult",
                        "searchFullSong", "searchFullArtist", "searchFullPlaylist", "searchACLocal", "searchFull", "searchOff",
                        "searchHub", "searchGenreMood"
                )), new TSource("Similar", Arrays.asList(
                        "mpSimSong", "riSimilarSongs"
                )), new TSource("Unknown", Collections.singletonList("unknown"))
        );
        List<TSource> webSources = Arrays.asList( // new - December 1, 2022 9:37 AM
                new TSource("My Music", Arrays.asList(
                        "mFavSong", "mPlaylist", "mAlbum", "mRecent", "aSong", "mMV", "mUpload", "mArtist"
                )), new TSource("Chart", Arrays.asList(
                        "cZC", "cZCW", "hZC"
                )), new TSource("Home", Arrays.asList(
                        "h100", "hAlbum", "hAutogenre1", "hAutoenre2", "hAutoTheme1", "hAutoTheme2", "hDailyTheme",
                        "hDiscovery", "hDm", "hGenre", "hMix", "hNewRelPI", "hNewSong", "hRadio", "hRecent", "hRewind",
                        "hSlider", "hSuggestPl", "hNewrelease", "hArtistTheme", "hXone", "hBasedOnRecent", "hRecent"
                )), new TSource("Home Monitor", Arrays.asList(
                        "h100", "hAlbum", "hAutogenre1", "hAutoenre2", "hAutoTheme1", "hAutoTheme2", "hDailyTheme",
                        "hDiscovery", "hDm", "hGenre", "hMix", "hNewRelPI", "hNewSong", "hRadio", "hRecent", "hRewind",
                        "hSlider", "hSuggestPl", "hNewrelease", "hArtistTheme", "hXone", "hBasedOnRecent"
                )), new TSource("Search", Arrays.asList(
                        "search", "npsearch", "mvsearch"
                )), new TSource("Similar", Collections.singletonList("npSuggests")
                ), new TSource("Unknown", Arrays.asList(
                        "Genre", "album", "playConcern", "playLink", "t100"
                ))
        );

        Map<Integer, List<TSource>> platformSources = new LinkedHashMap<>();
        platformSources.put(TPlatform.APP_ANDROID.getValue(), mobileSources);
        platformSources.put(TPlatform.APP_IOS.getValue(), mobileSources);
        platformSources.put(TPlatform.WEB_DESKTOP.getValue(), webSources);
        TMappedQueryGenTextStats query = new TMappedQueryGenTextStats()
                .setBaseQuery(new TBaseQueryGenStats(
                        time.getTime(), true, false,
                        TZMP3RCounterObject.SONG.getValue(), TZMP3RCounterType.LISTEN.getValue(),
                        TZMP3RCounterZone.ZMP3.getValue(), TZMP3RCounterDimension.ALL.getValue(), "0")
                ).setPlatformSources(platformSources);

        TStringResult sResult = STATS_MW.genTextStatsReport(query);
        System.out.println(sResult.value);
//            sendTextMsg(query.baseQuery.object, !CommonUtils.isEmpty(query.sources), sResult.value, Arrays.asList(1, 3));
    }

    public static void song(Date time) {
        TQueryGenTextStats query = new TQueryGenTextStats(
                new TBaseQueryGenStats(
                        time.getTime(), true, true,
                        TZMP3RCounterObject.SONG.getValue(), TZMP3RCounterType.LISTEN.getValue(),
                        TZMP3RCounterZone.ZMP3.getValue(), TZMP3RCounterDimension.ALL.getValue(), "0"
                ),
                Arrays.asList(0, TPlatform.APP_ANDROID.getValue(), TPlatform.APP_IOS.getValue(), TPlatform.WEB_DESKTOP.getValue()),
                Collections.emptyList()
        );

        TStringResult sResult = STATS_MW.genTextStatsReport(query);
        System.out.println(sResult.value);
//            sendTextMsg(query.baseQuery.object, !CommonUtils.isEmpty(query.sources), sResult.value, Arrays.asList(1, 3));
    }

    public static void iSong(Date time) {
        Map<Integer, List<TSource>> emptyPlatformSources = new LinkedHashMap<>();
        emptyPlatformSources.put(0, Collections.emptyList());
        emptyPlatformSources.put(TPlatform.APP_ANDROID.getValue(), Collections.emptyList());
        emptyPlatformSources.put(TPlatform.APP_IOS.getValue(), Collections.emptyList());
        emptyPlatformSources.put(TPlatform.WEB_DESKTOP.getValue(), Collections.emptyList());
        TMappedQueryGenTextStats query = new TMappedQueryGenTextStats(
                new TBaseQueryGenStats(
                        time.getTime(), true, true,
                        TZMP3RCounterObject.SONG.getValue(), TZMP3RCounterType.LISTEN.getValue(),
                        TZMP3RCounterZone.ZMP3.getValue(), TZMP3RCounterDimension.ALL.getValue(), "0"
                ),
                emptyPlatformSources
        );

        TStringResult sResult = STATS_MW.genTextStatsReport(query);
        System.out.println(sResult.value);
//            sendTextMsg(query.baseQuery.object, !CommonUtils.isEmpty(query.sources), sResult.value, Arrays.asList(1, 3));
    }

    public static void sendTextMsg(int objectType, boolean sourceStats, String msg, List<Integer> groupIds) {
        TZMP3RCounterObject objectObj = TZMP3RCounterObject.findByValue(objectType);
        String tag = String.format("text.%s.%s", objectObj == null ? "null" : objectObj.name().toLowerCase(), sourceStats ? "source" : "all");
        notiInfoStatsTextToGroup(tag, msg, groupIds);
    }

    public static void notiInfoStatsTextToGroup(String tagName, String message, List<Integer> groupIds) {
        TSendMessageReq messageReq = new TSendMessageReq();
        messageReq.setAlertType(TAlertType.INFO.getValue());
        messageReq.setCustomTag(tagName);
        messageReq.setMessage(message);
        messageReq.setIds(Collections.singletonList(NAMNH16_ZALO_ID));
        messageReq.setReceivedType(TAlertMessageReceivedType.USER.getValue());
        messageReq.setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue());
        messageReq.setOa(new TOAInfo(OAMsgWrapperInst.ZMP3_OPERATION_INST.getAccessToken(), OAMsgWrapperInst.ZMP3_OPERATION_INST.getOAIdRaw()));
        int rsSend = TZMediaAlertServiceClient.INST.sendMessage(messageReq);
        if (ZErrorHelper.isFail(rsSend)) {
            System.err.println(LogUtils.buildTabLog("sendMessageFail", rsSend, messageReq));
        }
    }

    @NoArgsConstructor
    private static class OAMsgWrapperInst {
        public static final OAMsgWrapper ZMP3_OPERATION_INST = new OAMsgWrapper("zmp3_operation");
    }
}
