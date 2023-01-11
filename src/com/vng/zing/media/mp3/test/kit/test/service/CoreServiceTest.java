package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/03/2021
 */

import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.utils.CommonUtils;
import com.vng.zing.media.mp3.commonlib.thrift.TMP3ItemType;
import com.vng.zing.media.mp3.commonlib.thrift.TMP3ListType;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.core.thrift.client.TZMP3CoreServiceClient;
import com.vng.zing.media.mp3.service.core.thrift.req.TGetSliceIdsReq;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CoreServiceTest extends Test {

    private static final TZMP3CoreServiceClient CORE_SERVICE = TZMP3CoreServiceClient.INST;
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;
    private static final Logger LOG = ZLogger.getLogger(CoreServiceTest.class);
    private static final String SEPARATOR = "¸";

    //
    public static void main(String[] args) throws IOException {
        List<Integer> ids = Arrays.asList(1101181203, 1095512100,1095484536,  1095484537);

        int start = 0;
        while (true) {
            Set<Integer> mediaIDs = new HashSet<>(CORE_SERVICE.getSliceIds(new TGetSliceIdsReq()
                    .setId(620304)
                    .setStart(start)
                    .setCount(200)
                    .setType(TMP3ListType.LIST_BY_ARTIST.getValue())
                    .setItemType(TMP3ItemType.MEDIA.getValue())
            ).value.values);
            if (CommonUtils.isEmpty(mediaIDs)) {
                break;
            }

            for (int mediaID : ids) {
                if (mediaIDs.contains(mediaID)) {
                    System.out.println(mediaID);
                }
            }

            start += 200;
        }

        System.exit(0);
    }
}
