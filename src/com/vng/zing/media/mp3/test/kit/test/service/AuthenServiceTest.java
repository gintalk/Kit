package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 26/03/2021
 */

import com.vng.zing.media.commonlib.thrift.profile.TProfile;
import com.vng.zing.media.commonlib.thrift.profile.TProfileType;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;
import com.vng.zing.media.service.authen.thrift.client.TZMediaAuthenClient;

public class AuthenServiceTest extends Test {

    private static final TZMediaAuthenClient SERVICE = TZMediaAuthenClient.INST;

    public static void main(String[] args) {
        TProfile profile = SERVICE.getProfile(1088741342).value;
        PrintUtils.printTBase(profile);

        System.exit(0);
    }
}
