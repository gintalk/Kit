package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 05/08/2021
 */

import com.vng.zing.media.mp3.mw.indie.thrift.client.TZMP3IndieMWClient;
import com.vng.zing.media.mp3.service.indie.thrift.client.TZMP3IndieServiceClient;
import com.vng.zing.media.mp3.service.indie.thrift.req.TGetIndieArtistReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

public class IndieServiceTest extends Test {

    //    private static final TZMP3IndieServiceClient STG_SERVICE = new TZMP3IndieServiceClient("staging");
    private static final TZMP3IndieMWClient MW = TZMP3IndieMWClient.INST;
    private static final TZMP3IndieServiceClient SERVICE = TZMP3IndieServiceClient.INST_INDIE;

    //
    public static void main(String[] args) {
//        _testUser();
        _testArtist();
//        _testPlaylist();
//        _testMedia();
//        _testCreateIndieMediaV2();
//        _testRemoveIndieMedia();
//        _testRemoveIndiePlaylist();

        System.exit(0);
    }

    //
//    private static void _testUser() {
////        ThriftUtils.prettyPrint(TZMP3IndieServiceClient.INST_INDIE.resendMailVerify(new TResendMailVerifyReq().setUserId()));
//
////        System.out.println(MW.removeIndieArtistAlias("Dzung-Accoustic1"));
////        System.out.println(MW.removeArtist(1952175));
//    }
//
    private static void _testArtist() {
//        System.out.println(STG_SERVICE.isValidVipUser(new TIsValidVipUserReq()
//                .setHeader(Constant.HEADER)
//                .setUserId(WhiteListUserUtils.TRUONGDT)
//        ));

//        ThriftUtils.prettyPrint(SERVICE.getIndieDashboard(new TGetIndieDashboardReq()
//                .setHeader(Constant.HEADER)
//                .setArtistId(1873062)
//                .setCountryCode(84)
//                .setIsGetAll(true)
//        ).value);

//        ThriftUtils.prettyPrint(SERVICE.getIndieStats(new TGetIndieStatsReq()
//                .setHeader(Constant.HEADER)
//                .setCountryCode(84)
//                .setArtistId(1873062)
//                .setStartDay(20210926)
//                .setEndDay(20210930)
//        ));

        PrintUtils.printTBase(SERVICE.getIndieArtist(new TGetIndieArtistReq()
//                        .setArtistId(2335270)
                        .setUserId(1016254788)
//                        .setAliasName("Ovenis")
        ).value);
        PrintUtils.printTBase(MW.getIndieArtistByUserID(1016254788).value);

//        for(int i=0; i<20; i++) {
//            System.out.println(TZMP3IndieMWClient.INST.getIndieArtistByAlias("Phan-Tran-Cong-Hieu").value.aliasName);
//        }
    }
//
//    private static void _testPlaylist() {
////        SERVICE.addMediasToIndiePlaylist(new TAddMediasToIndiePlaylistReq()
////                .setPlaylistId(1453463877)
////                .setMediaIds(Collections.singletonList(1113952333))
////                .setHeader(Constant.HEADER.setUserId(XONE_RADIO_USER_ID))
////                .setArtistId(XONE_RADIO_INDIE_ARTIST_ID)
////        );
//    }
//
//    private static void _testMedia() {
//        ThriftUtils.prettyPrint(SERVICE.getIndieMedia(new TGetIndieMediaReq()
//                .setHeader(Constant.HEADER)
//                .setArtistId(957809)
//                .setMediaId(1125423470)
//        ).value);
//        ThriftUtils.prettyPrint(TZMP3CoreMWClient.INST.getMedia(1125423470).value);
//
////        ThriftUtils.prettyPrint(STG_SERVICE.getIndieMedia(new TGetIndieMediaReq()
////                .setHeader(Constant.HEADER)
////                .setArtistId(1787888)
////                .setMediaId(1104656804)
////        ).value);
//
////        List<TIndieMedia> media = SERVICE.getIndieMedias(new TGetIndieMediasReq()
////                .setHeader(Constant.HEADER)
////                .setCountryCode(84)
////                .setStart(0)
////                .setCount(20)
////                .setAritstId(957809)
////                .setType(TIndiePublicStatus.REJECTED.getValue())
////        ).values;
////        List<TMedia> tMedia = EMediaModel.INST.multiGetAsList(Collections.singletonList(1109165218));
////        tMedia.forEach(m -> System.out.println(m.title));
////        ThriftUtils.prettyPrint(STG_SERVICE.getIndieMedias(new TGetIndieMediasReq()
////                .setHeader(Constant.HEADER)
////                .setCountryCode(84)
////                .setStart(0)
////                .setCount(2)
////                .setAritstId(1866305)
////                .setType(TIndiePublicStatus.APPROVED.getValue())
////        ).values);
//
//
////        ThriftUtils.prettyPrint(SERVICE.getIndiePlaylists(new TGetIndiePlaylistsReq()
////                .setHeader(Constant.HEADER)
////                .setArtistId(1492331)
////                .setStart(0)
////                .setCount(2)
////        ).values);
////        ThriftUtils.prettyPrint(STG_SERVICE.getIndiePlaylists(new TGetIndiePlaylistsReq()
////                .setHeader(Constant.HEADER)
////                .setArtistId(1866305)
////                .setStart(0)
////                .setCount(2)
////        ));
//
////        STG_SERVICE.mgetIndieMedia(new TMGetIndieMediaReq()
////                .setHeader(Constant.HEADER)
//////                .setAsList(true)
////                .setArtistId(1873062)
////                .setMediaIds(Arrays.asList(1108954170, 1108954121, 1108954040, 1108953900))
////        ).valueMap.entrySet().forEach(e -> ThriftUtils.prettyPrint(e.getValue()));
//    }
//
//    private static void _testCreateIndieMediaV2() {
//        STG_SERVICE.createIndieMediaV2(new TCreateIndieMediaV2Req()
//                .setArtistId(NAMNH16_INDIE_ARTIST_ID)
//                .setCountryCode(84)
//                .setHeader(Constant.HEADER.setUserId(NAMNH16_ZMP3_ID))
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setFtArtists("None")
//                .setIsLyricist(true)
//                .setIsProducer(true)
//                .setPublicType(2)
//        );
//    }
//
//    private static void _testRemoveIndieMedia() {
//        int mediaId = 1126773626;
//        int userId = NAMNH16_ZMP3_ID;
//        int artistId = NAMNH16_INDIE_ARTIST_ID;
//        String md5 = "c4140205157c4918113929a770caf4b6";
//
//        ThriftUtils.prettyPrint(SERVICE.clearIndieMedia(new TClearIndieMediaReq()
//                .setMediaId(mediaId)
//                .setUserId(userId)
//                .setArtistId(artistId)
//                .setCountryCode(84)
//                .setHeader(Constant.HEADER)
//        ));
////        ThriftUtils.prettyPrint(SERVICE.removeIndieMedia(new TRemoveIndieMediaReq()
////                .setMediaId(mediaId)
////                .setUserId(userId)
////                .setArtistId(artistId)
////                .setCountryCode(84)
////                .setHeader(Constant.HEADER)
////        ));
//
////        System.out.println(TZMP3CoreMWClient.INST.removeMedia(mediaId));
////        System.out.println(TZMP3UserServiceClient.INST.removeAsset(new TRemoveAssetReq()
////                .setUserId(userId)
////                .setAssetId(mediaId)
////                .setAssetType(TUserListType.CREATE_SONG.getValue())
////        ));
////        System.out.println(TZMP3UserServiceClient.INST.removeAsset(new TRemoveAssetReq()
////                .setUserId(userId)
////                .setAssetId(mediaId)
////                .setAssetType(TUserListType.LIBRARY_SONG.getValue())
////        ));
////        System.out.println(TZMP3UserMWClient.INST.removeMapSource(userId, md5));
////        for (int assetStatus : Arrays.asList(0, 1, 2, 3, 4, 5)) {
////            System.out.println(TZMP3PublisherMWClient.INST.removeAsset(new TRemoveAssetMWReq()
////                    .setPublisherId(artistId)
////                    .setAssetId(mediaId)
////                    .setAssetType(TPublisherAssetType.MEDIA.getValue())
////                    .setAssetStatus(assetStatus)
////            ));
////        }
//    }
//
//    private static void _testRemoveIndiePlaylist() {
////        ThriftUtils.prettyPrint(STG_SERVICE.removeIndiePlaylist(new TRemoveIndiePlaylistReq()
////                .setArtistId(NAMNH16_INDIE_ARTIST_ID)
////                .setHeader(Constant.HEADER.setUserId(NAMNH16_ZMP3_ID))
////                .setPlaylistId(1452409156)
////                .setRemoveIndieMedia(true)
////        ));
//
////        ThriftUtils.prettyPrint(TZMP3PublisherMWClient.INST.getAssetSlice(new TGetAssetSliceMWReq()
////                .setStart(0)
////                .setCount(10)
////                .setAssetType(TPublisherAssetType.MEDIA.getValue())
////                .setPublisherId(NAMNH16_INDIE_ARTIST_ID)
////                .setAssetStatus(0)
////        ));
//
////        ThriftUtils.prettyPrint(TZMP3UserMWClient.INST.getAssetSlice(new TUserReadAssetReq()
////                .setUserId(NAMNH16_ZMP3_ID)
////                .setStart(0)
////                .setCount(133)
////                .setAssetType(TUserListType.LIBRARY_SONG.getValue())
////        ));
//    }
}
