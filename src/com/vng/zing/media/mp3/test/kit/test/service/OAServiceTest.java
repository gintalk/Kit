/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.common.utils.BitUtils;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.api.TUserInfoBoolAttribute;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OA;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAHome;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOAAccountPermissionReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOABoxReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOADashboardReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOAHomeReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOAPlaylistReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOAReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TPutOAHomeReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TPutOAReq;
import com.vng.zing.media.mp3.test.kit.test.common.Constant;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author namnh16
 */
public class OAServiceTest extends Test {

    private static final TZMP3OAServiceClient OA_SERVICE = TZMP3OAServiceClient.INST;
    private static final TZMP3OAServiceClient OA_SERVICE_STG = new TZMP3OAServiceClient("staging");

    public static void main(String[] args) {
        _testOA();
//        _testOABox();
//        testStats();
//        _testPlaylist();
//        test();
//        testPermission();

        System.exit(0);
    }

    private static void _testOA() {
        PrintUtils.printTBase(OA_SERVICE.getOA(new TGetOAReq()
                .setOaId(7907)
        ).value);
    }

    private static void _testOABox() {
        TZMP3OABox box = OA_SERVICE.getOABox(new TGetOABoxReq()
                .setBoxId(7907)
        ).value;
        box.setItemType(11);

//        ThriftUtils.prettyPrint(box);
//        box.setType(TZMP3OABoxType.PODCAST_EPISODE.getValue());
//        System.out.println(OA_SERVICE.putOABox(new TPutOABoxReq()
//                .setBox(box)
//        ));

//        ThriftUtils.prettyPrint(OA_SERVICE.removeOABox(new TRemoveOABoxReq()
//                .setBoxId(15146)
//                .setUserId(NAMNH16_ZMP3_ID)
//        ));

        TZMP3OAHome home = OA_SERVICE.getOAHome(new TGetOAHomeReq()
                .setOaId(XONE_RADIO)
        ).value;
        Map<Integer, Integer> boxMap = home.boxMap;
        boxMap.remove(2);
        List<Integer> boxIds = home.boxIds;
        boxIds.remove(new Integer(15146));
        System.out.println(OA_SERVICE.putOAHome(new TPutOAHomeReq()
                .setHome(home)
        ));
    }

    private static void _testStats() {
        ThriftUtils.prettyPrint(OA_SERVICE.getOADashboard(new TGetOADashboardReq()
                .setOaId(Constant.OA_PETER_SERKIN)
        ));

        System.exit(0);
    }

    private static void _testPlaylist() {
//        ThriftUtils.prettyPrint(OA_SERVICE_STG.createOAPlaylist(new TCreateOAPlaylistReq()
//                .setOaID(1921897)
//                .setTitle("Playlist 2 của quyendb2")
//                .setDescription("Playlist này của OA Bảo Quyên")
//                .setCover("avatars/0/f/9/c/0f9ccb324339a6380cb1e9ad358a3ce4.jpg")
//                .setPrivacy(TPrivacy.UNKNOWN.getValue())
//                .setShuffle(false)
//                .setMediaIDs(Arrays.asList(1104975717, 1083030837, 1080856394))
//        ));

//        ThriftUtils.prettyPrint(OA_SERVICE_STG.updateOAPlaylist(new TUpdateOAPlaylistReq()
//                .setOaID(1921897)
//                .setPlaylistID(1489750524)
//                .setTitle("Plalist 2.1 của quyendb2")
//                .setDescription("Playlist này đã được chỉnh sửa")
//                .setMediaIDs(Arrays.asList(1078852122))
//                .setPrivacy(TPrivacy.PRIVATE.getValue())
//                .setShuffle(true)
//        ));

//        ThriftUtils.prettyPrint(OA_SERVICE_STG.removeOAPlaylist(new TRemoveOAPlaylistReq()
//                .setOaID(1921897)
//                .setPlaylistID(1489750476)
//        ));

//        ThriftUtils.prettyPrint(TZMP3PublisherMWClient.INST.getAssetSlice(new TGetAssetSliceMWReq()
//                .setPublisherId(1921897)
//                .setAssetType(TPublisherAssetType.PLAYLIST.getValue())
//                .setStart(0)
//                .setCount(100)
//        ));
        ThriftUtils.prettyPrint(OA_SERVICE_STG.getOAPlaylist(new TGetOAPlaylistReq()
                .setOaID(1921897)
                .setPlaylistID(1489750476)
        ).value.storageMeta);
    }

    private static void test() {
//        ThriftUtils.prettyPrint(OA_SERVICE.getOAAccountSlice(new TGetOAAccountSliceReq()
//                .setUserID(LUONGPC_ZMP3_ID)
//                .setStart(0)
//                .setCount(1)
//        ));

        System.out.println(BitUtils.hasBit(18, TUserInfoBoolAttribute.IS_OA_MANAGER.getValue()));
    }

    private static void testPermission() {
        PrintUtils.printOAAccountPermission(OA_SERVICE.getOAAccountPermission(new TGetOAAccountPermissionReq()
                .setOaID(VED_DNARB)
                .setUserID(NGUYENLT4_ZMP3_ID)
        ).values);
    }
}
