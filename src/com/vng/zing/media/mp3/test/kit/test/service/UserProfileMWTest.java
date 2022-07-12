package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 12/05/2021
 */

import com.vng.zing.media.common.client.ZMediaClientPoolManager;
import com.vng.zing.media.common.thrift.profile.TProfile;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.media.profile.thrift.client.ZMediaProfileMWClient;
import com.vng.zing.media.service.authen.thrift.client.TZMediaAuthenClient;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserProfileMWTest extends Test {

    private static final ZMediaProfileMWClient PROFILE_MW = ZMediaClientPoolManager.getZMProfileMWClient();
    private static final TZMediaAuthenClient AUTHEN = TZMediaAuthenClient.INST;

    public static void main(String[] args) {
        ThriftUtils.prettyPrint(AUTHEN.getProfile(1033003572	).value);

        System.exit(0);
    }
}
