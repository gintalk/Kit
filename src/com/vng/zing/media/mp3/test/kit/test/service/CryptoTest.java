package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 18/04/2022
 */

import com.vng.zing.media.commonlib.utils.EncryptUtils;

public class CryptoTest extends Test {

    public static void main(String[] args) {
        System.out.println(EncryptUtils.decryptAES("wbjHORBahNvkDt7KqpiYmg==", "aoDMO2daTn8rwXFGicHwJQ==", "RqrFQ1e/lGBaUFs1HlhXe92r/d3ppO3zbFbwqvWD5g0="));
    }
}
