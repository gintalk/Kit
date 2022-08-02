package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/03/2021
 */

import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.core.thrift.client.TZMP3CoreServiceClient;
import com.vng.zing.media.mp3.service.core.thrift.req.TGetArtistReq;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOAReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

import java.io.IOException;

public class CoreServiceTest extends Test {

    private static final TZMP3CoreServiceClient CORE_SERVICE = TZMP3CoreServiceClient.INST;
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;

    public static void main(String[] args) throws IOException {
//        ThriftUtils.prettyPrint(CORE_SERVICE.getMedia(new TGetMediaReq()
//                .setId(1132441715)
//        ).value.audio);
//        ThriftUtils.prettyPrint(CORE_SERVICE.getMedia(new TGetMediaReq()
//                .setId(1132443159)
//        ).value.audio);

//        ThriftUtils.prettyPrint(CORE_SERVICE.getLyric(new TGetLyricReq().setId(7134066)));

//        int playlistID = EncodeUtils.numberDecode("6BW6BID6");
//        ThriftUtils.prettyPrint(CORE_SERVICE.getOldPlaylist(new TGetOldPlaylistReq()
//                .setPlaylistId(1489854806)
//        ).value);
//        System.out.println(BitUtils.hasBit(1017860, TPlaylistInfoBoolAttribute.IS_INDIE.getValue()));

//        System.out.println(EMediaModel.INST.get(1126720611).audio.releaseDate);
//        ThriftUtils.prettyPrint(CORE_MW.getMedia(1126774785).value.audio);

//        ThriftUtils.prettyPrint(CORE_SERVICE.getSlice(new TGetSliceIdsScoreReq()
//                .setType(TMP3ListType.ARTIST.getValue())
//                .setItemType(TMP3ItemType.PLAYLIST.getValue())
//                .setId(XONE_RADIO_INDIE_ARTIST_ID)
//                .setStart(0)
//                .setCount(100)
//        ));

//        System.out.println(CORE_SERVICE.getSliceIds(new TGetSliceIdsReq()
//                .setId(TMP3CustomListID.PLAYLIST_CURATOR.getValue())
//                .setItemType(TMP3ItemType.PLAYLIST.getValue())
//                .setType(TMP3ListType.LIST_BY_CUSTOM.getValue())
//                .setStart(0)
//                .setCount(10)
//        ));

//        System.out.println(EConfigApiModel.INST.get().getXoneHome().getSrc());

//        System.out.println(TZMP3CoreServiceClient.INST.getTotalFollow(new TGetTotalFollowReq()
//                .setType(TFollowType.ARTIST.getValue())
//                .setId(72597)
//        ));

//        System.out.println(TZMP3CoreServiceClient.INST.getCounterTotal(new TGetCounterTotalReq()
//                .setType(TCounterTotalType.ZMP3_ARTIST.getValue())
//                .setIndex(TCounterTotalIndex.CUSTOM_VIEW_ALL.getValue())
//                .setKey(72597)
//        ));

//        System.out.println(CORE_SERVICE.putStringConfig(new TPutStringConfigReq()
//                .setCountryCode(84)
//                .setKey(TStringConfigKey.PODCAST_EPISODE_RANKING.name())
//                .setValue(JsonWrapper.parseStr(Arrays.asList(
//                        1127173747, 1127215181, 1127444462, 1126915022, 1125436955, 1127482983, 1125435981, 1125436224, 1127443366, 1127003390, 1125436482, 1125436734, 1127482997, 1127319759, 1127405381, 1126581147, 1124851883, 1123868795, 1127365648, 1127405318, 1107525457, 1126444749, 1127544096, 1127405403, 1126763140, 1104058299, 1124851902, 1124490236, 1126175690, 1127320005, 1127213201, 1127336751, 1127483006, 1127319937, 1127187578, 1124851934, 1124492939, 1124490965, 1123868798, 1124490295, 1127510017, 1124448475, 1125187234, 1115414442, 1123868814, 1123868808, 1124493711, 1124490724, 1127483024, 1125880556
//                )))
//        ));

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

//        String value = CORE_SERVICE.getStringConfig(new TGetStringConfigReq()
//                .setCountryCode(84)
//                .setKey(StringConfigKeyUtils.getHomeSectionLayoutConfigKey(true))
//        ).value;
//
//        THomeSectionLayout loggedInLayout = JsonWrapper.parseObj(value, THomeSectionLayout.class);
//        loggedInLayout.addToSections(new THomeSection(THomeSectionType.PROMOTE_PODCAST_PROGRAM, false, false));
//        loggedInLayout.sections.forEach(System.out::println);
//
//        System.out.println(CORE_SERVICE.putStringConfig(new TPutStringConfigReq()
//                .setKey(StringConfigKeyUtils.getHomeSectionLayoutConfigKey(true))
//                .setCountryCode(84)
//                .setValue(JsonWrapper.parseStr(loggedInLayout))
//        ));

//        System.out.println(EHomeSectionAppModel.INST.addSection(
//                true,
//                21,
//                new THomeSection(THomeSectionType.PROMOTE_PODCAST_PROGRAM, false, false))
//        );
//        EHomeSectionAppModel.printSectionIndexs(EHomeSectionAppModel.INST.getHomeSectionLayout(true));
//        System.out.println(EHomeSectionAppModel.INST.removeSection(
//                true,
//                THomeSectionType.PROMOTE_PODCAST_PROGRAM
//        ));

//        ThriftUtils.prettyPrint(CORE_SERVICE.getGenericArtist(new TGetGenericArtistReq()
//                .setId(2251273)
//        ).value);

//        List<String> lines = FileUtils.readLines(new File("data/indie_artist.csv"), "UTF-8");
//        for (String line : lines) {
//            int artistID = ConvertUtils.toInteger(line);
//            System.out.println(CORE_MW.removeGenericArtist(artistID));
//        }

//        ThriftUtils.prettyPrint(CORE_MW.getMedia(1089920256));

//        PrintUtils.printTBase(CORE_SERVICE.getPlaylist(new TGetPlaylistReq()
//                .setPlaylistId(1491854332)
//        ).value.storageMeta);

//        PrintUtils.printTBase(CORE_SERVICE.putArtist(new TPutArtistReq().setArtist(new TArtist()
//                .setId(9999998)
//                .setAliasName("Rub-Thy-Camel")
//        )));

//        PrintUtils.printTBase(CORE_SERVICE.removeArtist(new TRemoveArtistReq()
//                .setId(9999999)
//        ));

//        PrintUtils.printTBase(CORE_SERVICE.mremoveArtist(new TMRemoveArtistReq()
//                .setIds(Arrays.asList(9999999, 9999998))
//        ));

        PrintUtils.printTBase(CORE_SERVICE.getArtist(new TGetArtistReq()
                        .setArtistId(6980)
        ).value);

        PrintUtils.printTBase(TZMP3OAServiceClient.INST.getOA(new TGetOAReq()
                .setOaId(6980)
                .setIsOrigin(true)
        ).value);

//        PrintUtils.printTBase(CORE_SERVICE.mgetArtist(new TMGetArtistReq()
//                .setAsList(true)
//                .setAliasNames(Arrays.asList("Jack-J97", "Liz-Kim-Cuong"))
//        ));

//        PrintUtils.printTBase(CORE_MW.getArtist(100789));

        System.exit(0);
    }
}
