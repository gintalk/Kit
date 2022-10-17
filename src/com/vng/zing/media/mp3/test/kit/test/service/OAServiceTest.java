/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.mp3.commonlib.thrift.oa.TZMP3OABox;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOABoxReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TPutOABoxReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

/**
 * @author namnh16
 */
public class OAServiceTest extends Test {

    private static final TZMP3OAServiceClient OA_SERVICE = TZMP3OAServiceClient.INST;
//    private static final TZMP3OAServiceClient OA_SERVICE_STG = new TZMP3OAServiceClient("staging");
//
    public static void main(String[] args) {
////        _testOA();
        _testOABox();
//        testStats();
//        _testPlaylist();
////        test();
//
//        System.exit(0);
    }
//
//    private static void _testOA() {
//        TZMP3OA oa = OA_SERVICE.getOA(new TGetOAReq().setOaId(1921897)).value;
//        oa.setDescription("");
//        System.out.println(OA_SERVICE.putOA(new TPutOAReq().setOa(oa)));
//    }
//
    private static void _testOABox() {
        TZMP3OABox box = OA_SERVICE.getOABox(new TGetOABoxReq()
                .setBoxId(15664)
        ).value;
        PrintUtils.printTBase(box);
//        box.setType(TZMP3OABoxType.PODCAST_EPISODE.getValue());
//        System.out.println(OA_SERVICE.putOABox(new TPutOABoxReq()
//                .setBox(box)
//        ));
//
//        TZMP3OAHome home = OA_SERVICE.getOAHome(new TGetOAHomeReq()
//                .setOaId(947376)
//        ).value;
//        Map<Integer, Integer> boxMap = home.boxMap;
//        boxMap.remove(15);
//        boxMap.put(12, 1);
//        System.out.println(OA_SERVICE.putOAHome(new TPutOAHomeReq()
//                .setHome(home)
//        ));
    }
//
//    private static void _testStats() {
//        ThriftUtils.prettyPrint(OA_SERVICE.getOADashboard(new TGetOADashboardReq()
//                .setOaId(Constant.OA_PETER_SERKIN)
//        ));
//
//        System.exit(0);
//    }
//
//    private static void _testPlaylist() {
////        ThriftUtils.prettyPrint(OA_SERVICE_STG.createOAPlaylist(new TCreateOAPlaylistReq()
////                .setOaID(1921897)
////                .setTitle("Playlist 2 của quyendb2")
////                .setDescription("Playlist này của OA Bảo Quyên")
////                .setCover("avatars/0/f/9/c/0f9ccb324339a6380cb1e9ad358a3ce4.jpg")
////                .setPrivacy(TPrivacy.UNKNOWN.getValue())
////                .setShuffle(false)
////                .setMediaIDs(Arrays.asList(1104975717, 1083030837, 1080856394))
////        ));
//
////        ThriftUtils.prettyPrint(OA_SERVICE_STG.updateOAPlaylist(new TUpdateOAPlaylistReq()
////                .setOaID(1921897)
////                .setPlaylistID(1489750524)
////                .setTitle("Plalist 2.1 của quyendb2")
////                .setDescription("Playlist này đã được chỉnh sửa")
////                .setMediaIDs(Arrays.asList(1078852122))
////                .setPrivacy(TPrivacy.PRIVATE.getValue())
////                .setShuffle(true)
////        ));
//
////        ThriftUtils.prettyPrint(OA_SERVICE_STG.removeOAPlaylist(new TRemoveOAPlaylistReq()
////                .setOaID(1921897)
////                .setPlaylistID(1489750476)
////        ));
//
////        ThriftUtils.prettyPrint(TZMP3PublisherMWClient.INST.getAssetSlice(new TGetAssetSliceMWReq()
////                .setPublisherId(1921897)
////                .setAssetType(TPublisherAssetType.PLAYLIST.getValue())
////                .setStart(0)
////                .setCount(100)
////        ));
//        ThriftUtils.prettyPrint(OA_SERVICE_STG.getOAPlaylist(new TGetOAPlaylistReq()
//                .setOaID(1921897)
//                .setPlaylistID(1489750476)
//        ).value.storageMeta);
//    }
//
//    private static void test() {
//        System.out.println(OA_SERVICE.getOAAccountPermission(new TGetOAAccountPermissionReq()
//                .setUserID(QUYENDB2_ZMP3_ID)
//                .setOaID(813577)
//        ));
//    }
}
