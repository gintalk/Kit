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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    private static final Logger LOG = ZLogger.getLogger(CommonTest.class);
    private static final String PHOTO_DOMAIN = "https://photo-zmp3.zmdcdn.me/";

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLines(new File("data/cctl.csv"), StandardCharsets.UTF_8);

        for (String line : lines) {
            String[] split = line.split("\t", -1);

            String imageURL = PHOTO_DOMAIN + (split.length > 4 ? split[4] : "");

            _download(imageURL, "/home/namnh16/Data/sampv4/" + split[1] + ".jpg");
        }

        System.exit(0);
    }

    private static void _download(String url, String outputPath) throws IOException {
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
