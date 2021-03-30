/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.mp3.common.client.ClientPoolManager;
import com.vng.zing.media.mp3.common.thrift.TMP3ItemType;
import com.vng.zing.media.mp3.common.thrift.TMP3ListType;
import com.vng.zing.media.mp3.common.thrift.core.TListInfo;
import com.vng.zing.media.mp3.common.utils.MP3Utils;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.mw.thrift.client.TZingMP3MWClient;

/**
 * @author namnh16
 */
public class ZingMP3MWTest extends BaseTest {

    private static final TZingMP3MWClient MP3_MW = ClientPoolManager.getZingMP3MWClient();
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;

    public static void main(String[] args) {
        System.out.println(MP3_MW.getSliceIds(MP3Utils.buildListInfo(1073741824, TMP3ListType.LIST_BY_PLAYLIST, TMP3ItemType.MEDIA, 84), 0,0).values);
        System.out.println(CORE_MW.getSliceIds(new TListInfo().setId(1073741824).setType(TMP3ListType.LIST_BY_PLAYLIST.getValue()).setItemType(TMP3ItemType.MEDIA.getValue()), 0, 0).values);

        System.exit(0);
    }
}
