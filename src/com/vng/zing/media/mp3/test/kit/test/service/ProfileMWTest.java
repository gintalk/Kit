package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 11/03/2021
 */

import com.vng.zing.media.common.client.ZMediaClientPoolManager;
import com.vng.zing.media.common.thrift.profile.TProfile;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.profile.thrift.client.ZMediaProfileMWClient;

public class ProfileMWTest extends BaseTest{

    private static final ZMediaProfileMWClient PROFILE_MW = ZMediaClientPoolManager.getZMProfileMWClient();

    public static void main(String[] args) {
        TProfile profile = PROFILE_MW.getProfile(1061206100).value;
//        profile.type = 2;
//        profile.typeId = 620304;
//        System.out.println(PROFILE_MW.updateProfile(profile));
        ThriftUtils.prettyPrint(profile);

        System.exit(0);
    }
}
