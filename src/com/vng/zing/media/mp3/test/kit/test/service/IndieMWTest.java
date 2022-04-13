package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 05/08/2021
 */

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.mw.indie.thrift.client.TZMP3IndieMWClient;

public class IndieMWTest extends Test{

    private static final TZMP3IndieMWClient INDIE_MW = TZMP3IndieMWClient.INST;

    public static void main(String[] args) {
        ThriftUtils.prettyPrint(INDIE_MW.getIndieArtistByAlias("Phan-Tran-Cong-Hieu"));
        ThriftUtils.prettyPrint(INDIE_MW.getIndieArtist(1042194));

        System.exit(0);
    }
}
