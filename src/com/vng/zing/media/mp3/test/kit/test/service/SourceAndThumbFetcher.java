/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.common.ZUtil;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.helper.HttpRequestHelper;
import com.vng.zing.media.commonlib.profiler.ZMProfiler;
import com.vng.zing.media.commonlib.thrift.TCountryCode;
import com.vng.zing.media.commonlib.thrift.TI32ListResult;
import com.vng.zing.media.commonlib.utils.CommonUtils;
import com.vng.zing.media.commonlib.utils.ConvertUtils;
import com.vng.zing.media.commonlib.utils.LogUtils;
import com.vng.zing.media.mp3.commonlib.thrift.TMediaSourceFormat;
import com.vng.zing.media.mp3.commonlib.thrift.core.TMedia;
import com.vng.zing.media.mp3.commonlib.thrift.core.TMediaMapResult;
import com.vng.zing.media.mp3.commonlib.thrift.core.TMediaResult;
import com.vng.zing.media.mp3.commonlib.thrift.core.TPlaylist;
import com.vng.zing.media.mp3.commonlib.thrift.core.TPlaylistResult;
import com.vng.zing.media.mp3.commonlib.thrift.core.TStreamingLink;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkReq;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkRes;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author namnh16
 */
public class SourceAndThumbFetcher extends Test {

    private static final Logger LOG = ZLogger.getLogger(SourceAndThumbFetcher.class);
    private static final String PHOTO_DOMAIN = "https://photo-zmp3.zmdcdn.me/";
    private static final String BASE_FOLDER = "/media/namnh16/Transcend/2022-10-17/";
    private static final String MEDIA_OUTPUT_BASE_FOLDER = BASE_FOLDER + "Singles/";
    private static final String MEDIA_OUTPUT_FOLDER = MEDIA_OUTPUT_BASE_FOLDER + "%s - %s - %s/";
    private static final String ALBUM_OUTPUT_BASE_FOLDER = BASE_FOLDER + "Albums/";
    private static final String ALBUM_OUTPUT_FOLDER = ALBUM_OUTPUT_BASE_FOLDER + "%s - %s - %s/";
    private static final String MEDIA_OUTPUT_SOURCE_NAME = "%s - %s - %s.%s";
    private static final String ALBUM_MEDIA_OUTPUT_SOURCE_NAME = "%d - %s - %s - %s.%s";
    private static final String MEDIA_OUTPUT_THUMB_NAME = "%s - %s - %s.%s";
    private static final String ALBUM_OUTPUT_THUMB_NAME = "%s - %s - %s.%s";
    private static final String SEPARATOR = "¸";
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(30);
    private static final int MAX_CONCURRENCY = 5;
    private static final ZMP3BuildLinkServiceClient BUILD_LINK_SERVICE = ZMP3BuildLinkServiceClient.INST;
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;

    public static void main(String[] args) {
        _fetchMediaSourceAndThumb();
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Private
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static void _fetchAlbumSourceAndThumb() {
        ZMProfiler.open("AlbumSourceAndThumb");
        try {
            List<String> lines = FileUtils.readLines(new File("data/albums.csv"), StandardCharsets.UTF_8);
            lines = lines.subList(0, 100);

            int total = lines.size();
            ZMProfiler.count(SourceAndThumbFetcher.class, "_fetchAlbumSourceAndThumb", "ALBUMS", "TOTAL", total);

            List<List<String>> batches = ZUtil.splitList(lines, MAX_CONCURRENCY);

            new Thread(() -> {
                ZMProfiler.open("AlbumSource");
                try {
                    _fetchAlbumSource(batches);
                } catch (Throwable e) {
                    LOG.error(e.getMessage(), e);
                } finally {
                    ZMProfiler.close();
                }
            }).start();

            new Thread(() -> {
                ZMProfiler.open("AlbumThumb");
                try {
                    _fetchAlbumThumb(batches);
                } catch (Throwable e) {
                    LOG.error(e.getMessage(), e);
                } finally {
                    ZMProfiler.close();
                }
            }).start();
        } catch (Throwable e) {
            LOG.error(e.getMessage(), e);
        } finally {
            ZMProfiler.close();
        }
    }

    private static void _fetchAlbumSource(List<List<String>> batches) throws IOException, ExecutionException, InterruptedException {
        Set<String> sourcelessAlbums = Collections.synchronizedSet(new HashSet<>());
        for (List<String> batch : batches) {
            List<CompletableFuture<Void>> cfs = new ArrayList<>();
            for (String line : batch) {
                String[] split = line.split(SEPARATOR);
                cfs.add(CompletableFuture.runAsync(() -> _downloadAlbumSource(sourcelessAlbums, split[0], split[1].replaceAll("[*:<>?|\\\\/\"]", " "), split[2].replaceAll("[*:<>?|\\\\/\"]", " ")), EXECUTOR));
            }
            for (CompletableFuture<Void> cf : cfs) {
                cf.get();

                ZMProfiler.count(SourceAndThumbFetcher.class, "main", "SOURCE", "PROGRESS");
            }
        }

        if (!CommonUtils.isEmpty(sourcelessAlbums)) {
            StringBuilder sb = new StringBuilder();
            for (String s : sourcelessAlbums) {
                sb.append(s).append('\n');
            }
            FileUtils.writeStringToFile(new File(ALBUM_OUTPUT_BASE_FOLDER + "sourceless-albums.csv"), sb.toString(), StandardCharsets.UTF_8, true);
        }
    }

    private static void _fetchAlbumThumb(List<List<String>> batches) throws IOException, ExecutionException, InterruptedException {
        Set<String> thumblessAlbums = Collections.synchronizedSet(new HashSet<>());
        for (List<String> batch : batches) {
            List<CompletableFuture<Void>> cfs = new ArrayList<>();
            for (String line : batch) {
                String[] split = line.split(SEPARATOR);
                cfs.add(CompletableFuture.runAsync(() -> _downloadAlbumThumb(thumblessAlbums, split[0], split[1].replaceAll("[*:<>?|\\\\/\"]", " "), split[2].replaceAll("[*:<>?|\\\\/\"]", " ")), EXECUTOR));
            }
            for (CompletableFuture<Void> cf : cfs) {
                cf.get();

                ZMProfiler.count(SourceAndThumbFetcher.class, "main", "THUMB", "PROGRESS");
            }
        }

        if (!CommonUtils.isEmpty(thumblessAlbums)) {
            StringBuilder sb = new StringBuilder();
            for (String s : thumblessAlbums) {
                sb.append(s).append('\n');
            }
            FileUtils.writeStringToFile(new File(ALBUM_OUTPUT_BASE_FOLDER + "thumbless-albums.csv"), sb.toString(), StandardCharsets.UTF_8, true);
        }
    }

    private static void _fetchMediaSourceAndThumb() {
        ZMProfiler.open("MediaSourceAndThumb");
        try {
            List<String> lines = FileUtils.readLines(new File("data/singles.csv"), StandardCharsets.UTF_8);

            int total = lines.size();
            ZMProfiler.count(SourceAndThumbFetcher.class, "MediaSourceAndThumb", "MEDIA", "TOTAL", total);

            List<List<String>> batches = ZUtil.splitList(lines, MAX_CONCURRENCY);

            new Thread(() -> {
                ZMProfiler.open("MediaSource");
                try {
                    _fetchMediaSource(batches);
                } catch (Throwable e) {
                    LOG.error(e.getMessage(), e);
                } finally {
                    ZMProfiler.close();
                }
            }).start();

            new Thread(() -> {
                ZMProfiler.open("MediaThumb");
                try {
                    _fetchMediaThumb(batches);
                } catch (Throwable e) {
                    LOG.error(e.getMessage(), e);
                } finally {
                    ZMProfiler.close();
                }
            }).start();
        } catch (Throwable e) {
            LOG.error(e.getMessage(), e);
        } finally {
            ZMProfiler.close();
        }
    }

    private static void _fetchMediaSource(List<List<String>> batches) {
        new Thread(() -> {
            ZMProfiler.open("MediaSource");
            try {
                Set<String> sourcelessMedia = Collections.synchronizedSet(new HashSet<>());
                for (List<String> batch : batches) {
                    List<CompletableFuture<Void>> cfs = new ArrayList<>();
                    for (String line : batch) {
                        String[] split = line.split(SEPARATOR);
                        cfs.add(CompletableFuture.runAsync(() -> _downloadSource(sourcelessMedia, split[0], split[1].replaceAll("[*:<>?|\\\\/\"]", " "), split[2].replaceAll("[*:<>?|\\\\/\"]", " ")), EXECUTOR));
                    }
                    for (CompletableFuture<Void> cf : cfs) {
                        cf.get();

                        ZMProfiler.count(SourceAndThumbFetcher.class, "MediaSource", "MEDIA", "SOURCE", "PROGRESS");
                    }
                }

                if (!CommonUtils.isEmpty(sourcelessMedia)) {
                    StringBuilder sb = new StringBuilder();
                    for (String s : sourcelessMedia) {
                        sb.append(s).append('\n');
                    }
                    FileUtils.writeStringToFile(new File(MEDIA_OUTPUT_BASE_FOLDER + "sourceless-media.csv"), sb.toString(), StandardCharsets.UTF_8, true);
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }).start();
    }


    private static void _fetchMediaThumb(List<List<String>> batches) {
        new Thread(() -> {
            ZMProfiler.open("MediaThumb");
            try {
                Set<String> thumblessAlbums = Collections.synchronizedSet(new HashSet<>());
                for (List<String> batch : batches) {
                    List<CompletableFuture<Void>> cfs = new ArrayList<>();
                    for (String line : batch) {
                        String[] split = line.split(SEPARATOR);
                        cfs.add(CompletableFuture.runAsync(() -> _downloadSongThumb(thumblessAlbums, split[0], split[1].replaceAll("[*:<>?|\\\\/\"]", " "), split[2].replaceAll("[*:<>?|\\\\/\"]", " ")), EXECUTOR));
                    }
                    for (CompletableFuture<Void> cf : cfs) {
                        cf.get();

                        ZMProfiler.count(SourceAndThumbFetcher.class, "MediaThumb", "MEDIA", "THUMB", "PROGRESS");
                    }
                }

                if (!CommonUtils.isEmpty(thumblessAlbums)) {
                    StringBuilder sb = new StringBuilder();
                    for (String s : thumblessAlbums) {
                        sb.append(s).append('\n');
                    }
                    FileUtils.writeStringToFile(new File(MEDIA_OUTPUT_BASE_FOLDER + "thumbless-media.csv"), sb.toString(), StandardCharsets.UTF_8, true);
                }
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
        }).start();
    }

    private static void _downloadAlbumSource(Set<String> sourcelessAlbums, String albumID, String albumTitle, String artistNames) {
        Path path = Paths.get(String.format(ALBUM_OUTPUT_FOLDER, albumID, albumTitle, artistNames));
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }

        TI32ListResult listResult = CORE_MW.getMediaIdsOfPlaylist(ConvertUtils.toInteger(albumID));
        if (ZErrorHelper.isFail(listResult.error)) {
            sourcelessAlbums.add(String.format("%s - %s - %s (%s)", albumID, albumTitle, artistNames, "CORE_MW.getMediaIdsOfPlaylist." + listResult.error));

            LOG.error(LogUtils.buildTabLog("CORE_MW.getMediaIdsOfPlaylist.FAIL", listResult.error, albumID, albumTitle, artistNames));
            return;
        }

        TMediaMapResult mapResult = CORE_MW.mgetMedia(listResult.values);
        if (ZErrorHelper.isFail(mapResult.error)) {
            sourcelessAlbums.add(String.format("%s - %s - %s (%s)", albumID, albumTitle, artistNames, "CORE_MW.mgetMedia." + mapResult.error));

            LOG.error(LogUtils.buildTabLog("CORE_MW.mgetMedia.FAIL", mapResult.error, listResult.values));
            return;
        }

        Set<String> sourcelessMedia = Collections.synchronizedSet(new HashSet<>());

        int i = 0;
        List<List<Integer>> batches = ZUtil.splitList(listResult.values, MAX_CONCURRENCY);
        for (List<Integer> batch : batches) {
            List<CompletableFuture<Void>> cfs = new ArrayList<>();
            for (int mediaID : batch) {
                int idx = i;
                cfs.add(CompletableFuture.runAsync(() -> {
                    TMedia media = mapResult.values.get(mediaID);
                    if (media == null) {
                        sourcelessMedia.add(String.format("%d - %d (%s)", (idx + 1), mediaID, "NULL_MEDIA"));

                        return;
                    }

                    TBuildLinkRes res = BUILD_LINK_SERVICE.fullGetAudioBigFileLinks(new TBuildLinkReq()
                            .setCountryCode(TCountryCode.VIETNAM.getValue())
                            .setFormats(Arrays.asList(
                                    TMediaSourceFormat.AudioLossless.getValue(),
                                    TMediaSourceFormat.Audio320.getValue(),
                                    TMediaSourceFormat.Audio128.getValue())
                            )
                            .setMediaId(media.id)
                    );
                    if (ZErrorHelper.isFail(res.error)) {
                        sourcelessMedia.add(String.format("%d - %d - %s - %s (%s)", (idx + 1), media.id, media.title, media.artists, "BUILD_LINK_SERVICE.fullGetAudioBigFileLinks." + res.error));

                        LOG.info(LogUtils.buildTabLog("BUILD_LINK_SERVICE.getAudioBigFileLinks.FAIL", media.id, media.title, media.artists, res));
                        return;
                    }

                    Map<Integer, TStreamingLink> values = res.values;

                    String link = "", extension = "";
                    if (values.containsKey(TMediaSourceFormat.AudioLossless.getValue())) {
                        link = values.get(TMediaSourceFormat.AudioLossless.getValue()).link;
                        extension = "flac";
                    } else if (values.containsKey(TMediaSourceFormat.Audio320.getValue())) {
                        link = values.get(TMediaSourceFormat.Audio320.getValue()).link;
                        extension = "mp3";
                    } else if (values.containsKey(TMediaSourceFormat.Audio128.getValue())) {
                        link = values.get(TMediaSourceFormat.Audio128.getValue()).link;
                        extension = "mp3";
                    }

                    if (CommonUtils.isEmpty(link)) {
                        sourcelessMedia.add(String.format("%d - %d - %s - %s (%s)", (idx + 1), media.id, media.title, media.artists, "NO_SOURCE_AVAILABLE"));

                        LOG.info(LogUtils.buildTabLog("NO_SOURCE_AVAILABLE", media.id, media.title, media.artists, res));
                    }

                    _downloadSource(link, String.format(ALBUM_OUTPUT_FOLDER, albumID, albumTitle, artistNames) + String.format(ALBUM_MEDIA_OUTPUT_SOURCE_NAME, (idx + 1), media.id, media.title, artistNames, extension));
                }));

                i++;
            }
            for (CompletableFuture<Void> cf : cfs) {
                try {
                    cf.get();
                } catch (InterruptedException | ExecutionException e) {
                    LOG.error(e.getMessage(), e);
                }
            }
        }

        if (!CommonUtils.isEmpty(sourcelessMedia)) {
            StringBuilder sb = new StringBuilder();
            for (String s : sourcelessMedia) {
                sb.append(s).append('\n');
            }

            try {
                FileUtils.writeStringToFile(new File(String.format(ALBUM_OUTPUT_FOLDER, albumID, albumTitle, artistNames) + "sourceless-album-media.csv"), sb.toString(), StandardCharsets.UTF_8, true);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }

    private static void _downloadSource(Set<String> sourcelessMedia, String mediaID, String mediaTitle, String artistNames) {
        Path outputFolder = Paths.get(String.format(MEDIA_OUTPUT_FOLDER, mediaID, mediaTitle, artistNames));
        if (!Files.exists(outputFolder)) {
            try {
                Files.createDirectories(outputFolder);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }

        TBuildLinkRes res = BUILD_LINK_SERVICE.fullGetAudioBigFileLinks(new TBuildLinkReq()
                .setCountryCode(TCountryCode.VIETNAM.getValue())
                .setFormats(Arrays.asList(
                        TMediaSourceFormat.AudioLossless.getValue(),
                        TMediaSourceFormat.Audio320.getValue(),
                        TMediaSourceFormat.Audio128.getValue())
                )
                .setMediaId(ConvertUtils.toInteger(mediaID))
        );
        if (ZErrorHelper.isFail(res.error)) {
            sourcelessMedia.add(String.format("%s - %s - %s (%s)", mediaID, mediaTitle, artistNames, "BUILD_LINK_SERVICE.fullGetAudioBigFileLinks." + res.error));

            LOG.info(LogUtils.buildTabLog("BUILD_LINK_SERVICE.getAudioBigFileLinks.FAIL", mediaID, mediaTitle, artistNames, res));
            return;
        }

        Map<Integer, TStreamingLink> values = res.values;

        String link = "", extension = "";
        if (values.containsKey(TMediaSourceFormat.AudioLossless.getValue())) {
            link = values.get(TMediaSourceFormat.AudioLossless.getValue()).link;
            extension = "flac";
        } else if (values.containsKey(TMediaSourceFormat.Audio320.getValue())) {
            link = values.get(TMediaSourceFormat.Audio320.getValue()).link;
            extension = "mp3";
        } else if (values.containsKey(TMediaSourceFormat.Audio128.getValue())) {
            link = values.get(TMediaSourceFormat.Audio128.getValue()).link;
            extension = "mp3";
        }

        if (CommonUtils.isEmpty(link)) {
            sourcelessMedia.add(String.format("%s - %s - %s (%s)", mediaID, mediaTitle, artistNames, "NO_SOURCE_AVAILABLE"));

            LOG.info(LogUtils.buildTabLog("NO_SOURCE_AVAILABLE", mediaID, mediaTitle, artistNames, res));
        }

        _downloadSource(link, String.format(MEDIA_OUTPUT_FOLDER, mediaID, mediaTitle, artistNames) + String.format(MEDIA_OUTPUT_SOURCE_NAME, mediaID, mediaTitle, artistNames, extension));
    }

    private static void _downloadSource(String url, String outputPath) {
        if (CommonUtils.isEmpty(url)) {
            return;
        }

        File outputFile = new File(outputPath);
        if (outputFile.exists()) {
            ZMProfiler.count(SourceAndThumbFetcher.class, "_downloadSource", "PROCESSED", "SKIP");
            return;
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

    private static void _downloadSongThumb(Set<String> thumblessMedia, String mediaID, String mediaTitle, String artistNames) {
        Path path = Paths.get(String.format(MEDIA_OUTPUT_FOLDER, mediaID, mediaTitle, artistNames));
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }

        TMediaResult res = CORE_MW.getMedia(ConvertUtils.toInteger(mediaID));
        if (ZErrorHelper.isFail(res.error) || res.value == null) {
            thumblessMedia.add(String.format("%s - %s - %s (%s)", mediaID, mediaTitle, artistNames, "CORE_MW.getMedia." + res.error));
            LOG.info(LogUtils.buildTabLog("CORE_MW.getMedia.FAIL", mediaID, mediaTitle, artistNames, res));
            return;
        }
        TMedia media = res.value;

        String thumbnail = "";
        if (media.audio != null) {
            thumbnail = media.audio.thumbnail;
        }
        if (CommonUtils.isEmpty(thumbnail) && media.video != null) {
            thumbnail = media.video.thumbnail;
        }
        if (CommonUtils.isEmpty(thumbnail)) {
            thumblessMedia.add(String.format("%s - %s - %s (%s)", mediaID, mediaTitle, artistNames, "NO_THUMB_AVAILABLE"));

        }

        _downloadThumb(thumbnail, String.format(MEDIA_OUTPUT_FOLDER, mediaID, mediaTitle, artistNames) + String.format(MEDIA_OUTPUT_THUMB_NAME, mediaID, mediaTitle, artistNames, "jpg"));
    }

    private static void _downloadAlbumThumb(Set<String> thumblessAlbums, String albumID, String albumTitle, String artistNames) {
        Path path = Paths.get(String.format(ALBUM_OUTPUT_FOLDER, albumID, albumTitle, artistNames));
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }

        TPlaylistResult res = CORE_MW.getPlaylist(ConvertUtils.toInteger(albumID));
        if (ZErrorHelper.isFail(res.error) || res.value == null) {
            thumblessAlbums.add(String.format("%s - %s - %s (%s)", albumID, albumTitle, artistNames, "CORE_MW.getPlaylist." + res.error));

            LOG.error(LogUtils.buildTabLog("CORE_MW.getPlaylist.FAIL", res.error, albumID, albumTitle, artistNames));
            return;
        }
        TPlaylist album = res.value;

        String thumbnail = "";
        if (album.storageMeta != null) {
            thumbnail = album.storageMeta.coverImage;
        }
        if (CommonUtils.isEmpty(thumbnail)) {
            thumblessAlbums.add(String.format("%s - %s - %s (%s)", albumID, albumTitle, artistNames, "NO_THUMB_AVAILABLE"));

            return;
        }

        String extension = "";
        if (thumbnail.toLowerCase().endsWith("jpg")) {
            extension = "jpg";
        } else if (thumbnail.toLowerCase().endsWith("gif")) {
            extension = "gif";
        }

        _downloadThumb(thumbnail, String.format(ALBUM_OUTPUT_FOLDER, albumID, albumTitle, artistNames) + String.format(ALBUM_OUTPUT_THUMB_NAME, albumID, albumTitle, artistNames, extension));
    }

    private static void _downloadThumb(String thumbnail, String outputPath) {
        String url = CommonUtils.isEmpty(thumbnail) ? "" : PHOTO_DOMAIN + thumbnail;
        if (CommonUtils.isEmpty(url)) {
            return;
        }

        File outputFile = new File(outputPath);
        if (outputFile.exists()) {
            ZMProfiler.count(SourceAndThumbFetcher.class, "_downloadThumb", "PROCESSED", "SKIP");
            return;
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
