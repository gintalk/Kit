package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/03/2021
 */

import com.vng.zing.media.common.utils.EncodeUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.client.ClientPoolManager;
import com.vng.zing.media.mp3.common.thrift.TMP3ItemType;
import com.vng.zing.media.mp3.common.thrift.TMP3ListType;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.mw.thrift.TListInfo;
import com.vng.zing.media.mp3.mw.thrift.client.TZingMP3MWClient;
import com.vng.zing.media.mp3.service.core.thrift.client.TZMP3CoreServiceClient;
import com.vng.zing.media.mp3.service.core.thrift.req.TGetPlaylistReq;
import com.vng.zing.media.mp3.service.user.thrift.client.TZMP3UserServiceClient;

public class CoreServiceTest extends BaseTest {

    private static final TZingMP3MWClient MP3_MW = ClientPoolManager.getZingMP3MWClient();
    private static final TZMP3CoreServiceClient CORE_SERVICE = TZMP3CoreServiceClient.INST;
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;
    private static final TZMP3UserServiceClient USER_SERVICE = TZMP3UserServiceClient.INST;

    public static void main(String[] args) {
//        System.out.println(EncodeUtils.numberDecode("67BAWUUI"));
        ThriftUtils.prettyPrint(CORE_SERVICE.getPlaylist(new TGetPlaylistReq().setPlaylistId(1425486291)).value.storageMeta);
//        System.out.println(MP3_MW.getSliceIds(MP3Utils.buildListInfo(1430509701, TMP3ListType.LIST_BY_PLAYLIST, TMP3ItemType.MEDIA, 84), 0, 5));
//        System.out.println(MP3_MW.getSliceIds(new TListInfo()
//                        .setId(1430509701)
//                        .setType(TMP3ListType.LIST_BY_PLAYLIST.getValue())
//                        .setItemType(TMP3ItemType.MEDIA.getValue()).setCountryCode(84),
//                0, 0)
//        );
//
//
//        System.out.println(CORE_MW.getSliceIds(
//                new com.vng.zing.media.mp3.common.thrift.core.TListInfo()
//                        .setId(1430509701)
//                        .setType(TMP3ListType.LIST_BY_PLAYLIST.getValue())
//                        .setItemType(TMP3ItemType.MEDIA.getValue())
//                        .setNotiUpdateData(true),
//                0, 200)
//        );

        System.exit(0);
    }
}
