package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 26/03/2021
 */

import com.vng.zing.media.service.authen.thrift.client.TZMediaAuthenClient;

public class AuthenServiceTest extends BaseTest {

    private static final TZMediaAuthenClient SERVICE = TZMediaAuthenClient.INST;

    public static void main(String[] args) {
        System.out.println(SERVICE.getProfile(1049058769));

        System.exit(0);
    }
}
