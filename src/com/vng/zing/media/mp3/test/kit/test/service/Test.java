/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.helper.HttpRequestHelper;
import com.vng.zing.media.commonlib.profiler.ZMProfiler;
import com.vng.zing.media.commonlib.utils.CommonUtils;
import com.vng.zing.media.commonlib.utils.LogUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author namnh16
 */
public class Test {

    private static final Logger LOG = ZLogger.getLogger(Test.class);

    protected static final String PHOTO_DOMAIN = "https://photo-resize-zmp3.zmdcdn.me/";
    protected static final int NAMNH16_ZMP3_ID = 1049058769;
    protected static final int NAMNH16_ZALO_ID = 260902907;
    protected static final int TRUONGDT_ZMP3_ID = 1013522712;
    protected static final int NAMNH16_INDIE_ARTIST_ID = 1866305;
    protected static final int XONE_RADIO_INDIE = 1873062;
    protected static final int XONE_RADIO_USER = 1059620050;
    protected static final int LUONGPC_ZMP3_ID = 1037491098;
    protected static final int XONE_RADIO = 947376;
    protected static final int QUYENDB2_ZMP3_ID = 1014483768;
    protected static final int NIENDT_ZMP3_ID = 1036815003;
    protected static final int NGUYENLT4_ZMP3_ID = 1032126223;
    protected static final int BAO_QUYEN_OA_ID = 1921897;
    protected static final int PETER_SERKIN_OA_ID = 6980;
    protected static final String SEPARATOR = "¸";

    protected static void download(String url, String outputPath) throws IOException {
        if (CommonUtils.isEmpty(url)) {
            ZMProfiler.count(SourceAndThumbFetcher.class, "EMPTY_URL");
            return;
        }

        File outputFile = new File(outputPath);
        if (outputFile.exists()) {
            if (FileUtils.sizeOf(outputFile) > 0) {
                ZMProfiler.count(SourceAndThumbFetcher.class, "_download", "PROCESSED", "SKIP");
                return;
            } else {
                ZMProfiler.count(SourceAndThumbFetcher.class, "_download", "PROCESSED_BUT_0_BYTE", "RE_PROCESS");
                LOG.error(LogUtils.buildTabLog("PROCESSED_BUT_0_BYTE", url, outputPath));

                FileUtils.forceDelete(outputFile);
            }
        }

        Path path = Paths.get(outputPath);
        if (!Files.exists(path.getParent())) {
            Files.createDirectories(path.getParent());
        }
        try {
            outputFile.createNewFile();
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }

        HttpRequestHelper.newGet()
                .setUrl(url)
                .downloadToFile(new File(outputPath));
    }
}
