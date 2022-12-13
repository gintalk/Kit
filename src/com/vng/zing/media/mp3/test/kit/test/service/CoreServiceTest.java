package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/03/2021
 */

import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.utils.ConvertUtils;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.core.thrift.client.TZMP3CoreServiceClient;
import com.vng.zing.media.mp3.service.core.thrift.req.TGetMediaIdsOfPlaylistReq;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class CoreServiceTest extends Test {

    private static final TZMP3CoreServiceClient CORE_SERVICE = TZMP3CoreServiceClient.INST;
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;
    private static final Logger LOG = ZLogger.getLogger(CoreServiceTest.class);
    private static final String SEPARATOR = "¸";

    //
    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLines(new File("data/artist-tbo-cctl.csv"), StandardCharsets.UTF_8);

        for (String line : lines) {
            String[] split = line.split(",");

            int tboPlaylistID = ConvertUtils.toInteger(split[1]);
            int cctlPlaylistID = ConvertUtils.toInteger(split[2]);

            List<Integer> tboIDs = CORE_SERVICE.getMediaIdsOfPlaylist(new TGetMediaIdsOfPlaylistReq()
                    .setPlaylistId(tboPlaylistID)
            ).values;
            List<Integer> cctlIDs = CORE_SERVICE.getMediaIdsOfPlaylist(new TGetMediaIdsOfPlaylistReq()
                    .setPlaylistId(cctlPlaylistID)
            ).values;

            if (!tboIDs.equals(cctlIDs)) {
                System.err.println(line);
            }
        }

        System.exit(0);
    }
}
