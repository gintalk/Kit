package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 01/04/2021
 */

import com.vng.zing.media.common.thrift.TApp;
import com.vng.zing.media.common.thrift.TUserUpdateInfo;
import com.vng.zing.media.common.thrift.TUserUpdateSubType;
import com.vng.zing.media.common.thrift.TUserUpdateType;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.zeventbus.Notifier;

import java.util.Arrays;

public class NotifierTest extends Test {

    private static final Notifier NOTIFIER = new Notifier("update-user-data-notify");
    private static final String EVENT_NAME = "zmp3.user.profile.update";

    public static void main(String[] args) {
        TUserUpdateInfo info = new TUserUpdateInfo()
                .setApp(TApp.ZING_MP3.getValue())
                .setType(TUserUpdateType.FOLLOW.getValue())
                .setUserId(WhiteListUserUtils.NAMNH16)
                .setSubType(TUserUpdateSubType.FOLLOW_INDIE_ARTIST.getValue())
                .setListId(Arrays.asList(100, 200, 300));

        System.out.println(NOTIFIER.notify(EVENT_NAME, info));
    }
}
