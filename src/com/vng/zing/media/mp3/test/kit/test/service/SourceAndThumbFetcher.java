/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.common.ZUtil;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author namnh16
 */
public class SourceAndThumbFetcher extends Test {

    private static final Logger LOG = ZLogger.getLogger(SourceAndThumbFetcher.class);
    private static final String BASE_FOLDER = "/media/namnh16/Transcend/2022-10-17/";
    private static final String MEDIA_OUTPUT_BASE_FOLDER = BASE_FOLDER + "Singles/";
    private static final String ALBUM_OUTPUT_BASE_FOLDER = BASE_FOLDER + "Albums/";
    private static final String SEPARATOR = "¸";
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(30);
    private static final int MAX_CONCURRENCY = 5;

    public static void main(String[] args) {
//        _fetchMediaSourceAndThumb();
        _fetchAlbumSourceAndThumb();
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Private
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static void _fetchAlbumSourceAndThumb() {
        new Thread(() -> {
            ZMProfiler.open("AlbumSource");
            try {
                _fetch("data/album-sources-pp.csv", "SOURCE.ALBUM", ALBUM_OUTPUT_BASE_FOLDER, 2, 3);
            } catch (Throwable e) {
                LOG.error(e.getMessage(), e);
            } finally {
                ZMProfiler.close();
            }
        }).start();

//        new Thread(() -> {
//            ZMProfiler.open("AlbumThumb");
//            try {
//                _fetch("data/album-thumbs-pp.csv", "THUMB.ALBUM", ALBUM_OUTPUT_BASE_FOLDER, 1, 2);
//            } catch (Throwable e) {
//                LOG.error(e.getMessage(), e);
//            } finally {
//                ZMProfiler.close();
//            }
//        }).start();
    }

    private static void _fetchMediaSourceAndThumb() {
        new Thread(() -> {
            ZMProfiler.open("MediaSource");
            try {
                _fetch("data/media-sources-pp.csv", "SOURCE.SINGLE", MEDIA_OUTPUT_BASE_FOLDER, 1, 2);
            } catch (Throwable e) {
                LOG.error(e.getMessage(), e);
            } finally {
                ZMProfiler.close();
            }
        }).start();

        new Thread(() -> {
            ZMProfiler.open("MediaThumb");
            try {
                _fetch("data/media-thumbs-pp.csv", "THUMB.SINGLE", MEDIA_OUTPUT_BASE_FOLDER, 1, 2);
            } catch (Throwable e) {
                LOG.error(e.getMessage(), e);
            } finally {
                ZMProfiler.close();
            }
        }).start();
    }

    private static void _fetch(String inputFile, String profilerLabel, String outputBaseFolder, int outputPathIndex, int urlIndex) throws IOException, ExecutionException, InterruptedException {
        List<String> lines = FileUtils.readLines(new File(inputFile), StandardCharsets.UTF_8);
        lines = lines.subList(1, lines.size());     // Bỏ header, nếu không có header thì comment dòng này

        lines = lines.subList(30000, lines.size());  // Album đợt trước, đừng xóa

        ZMProfiler.count(SourceAndThumbFetcher.class, "_fetch", profilerLabel, "TOTAL", lines.size());

        List<String> errors = new LinkedList<>();

        List<List<String>> batches = ZUtil.splitList(lines, MAX_CONCURRENCY);
        for (List<String> batch : batches) {
            List<CompletableFuture<List<String>>> cfs = new ArrayList<>(batch.size());
            for (String line : batch) {
                cfs.add(CompletableFuture.supplyAsync(() -> {
                    ZMProfiler.open(profilerLabel);
                    try {
                        ZMProfiler.count(SourceAndThumbFetcher.class, "_fetch", profilerLabel, "PROGRESS");

                        String[] split = line.split(SEPARATOR, -1);

                        String outputPath = split[outputPathIndex], url = split[urlIndex];

                        outputPath = outputPath.replace("$BASE$/", BASE_FOLDER);

                        List<String> es = new LinkedList<>();
                        if (CommonUtils.isEmpty(url)) {
                            es.add(line);
                        } else {
                            _download(url, outputPath);
                        }

                        return es;
                    } catch (Exception e) {
                        LOG.error(e.getMessage(), e);
                        return Collections.emptyList();
                    } finally {
                        ZMProfiler.close();
                    }
                }, EXECUTOR));
            }
            for (CompletableFuture<List<String>> cf : cfs) {
                errors.addAll(cf.get());
            }
        }

        StringBuilder errorSB = new StringBuilder();
        for (String error : errors) {
            errorSB.append(error).append('\n');
        }

        FileUtils.writeStringToFile(new File(outputBaseFolder + profilerLabel + ".error.csv"), errorSB.toString(), StandardCharsets.UTF_8, true);
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
