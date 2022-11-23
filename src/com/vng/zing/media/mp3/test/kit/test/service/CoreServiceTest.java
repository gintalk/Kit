package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/03/2021
 */

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.profiler.ZMProfiler;
import com.vng.zing.media.commonlib.utils.ConvertUtils;
import com.vng.zing.media.commonlib.utils.LogUtils;
import com.vng.zing.media.mp3.commonlib.thrift.core.TGenericArtist;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.core.thrift.client.TZMP3CoreServiceClient;
import com.vng.zing.media.mp3.service.core.thrift.req.TGetPlaylistReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;
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

    //
    public static void main(String[] args) throws IOException {
        PrintUtils.printTBase(CORE_SERVICE.getPlaylist(new TGetPlaylistReq()
                .setPlaylistId(1494640785)
        ).value.storageMeta);

        System.exit(0);
    }
}
