package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 15/04/2022
 */

import com.vng.zing.media.mp3.searchmw.thrift.client.TZMP3SearchMWClient;
import com.vng.zing.media.mp3.searchmw.thrift.req.TSearchEventESReq;

public class SearchTest extends Test {

    public static void main(String[] args) {
//        System.out.println(TZMP3SearchServiceClient.INST.searchEventDetail(new TSearchEventDetailReq()
//                        .setHostId(1144229)
//                        .setStart(0)
//                        .setCount(10)
//                        .setQuery("aaa")
//        ));

        System.out.println(TZMP3SearchMWClient.INST.searchEventES(new TSearchEventESReq()
                        .setStart(0)
                        .setLength(20)
//                        .setCityCode("")
                        .setGuestId(105615)
//                        .setHostId(73473)
                        .setFrom(1658496600)
                        .setTo(1663816138)
        ));

        System.exit(0);
    }
}
