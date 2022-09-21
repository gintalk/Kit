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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author namnh16
 */
public class SourceAndThumbFetcher extends Test {

    private static final Logger LOG = ZLogger.getLogger(SourceAndThumbFetcher.class);
    private static final String PHOTO_DOMAIN = "https://photo-zmp3.zmdcdn.me/";
    private static final String MEDIA_OUTPUT_FOLDER = "/home/namnh16/Data/Media/%s - %s - %s/";
    private static final String ALBUM_OUTPUT_FOLDER = "/home/namnh16/Data/Albums/%s - %s - %s/";
    private static final String MEDIA_OUTPUT_SOURCE_NAME = "%s - %s - %s.%s";
    private static final String ALBUM_MEDIA_OUTPUT_SOURCE_NAME = "%d - %s - %s - %s.%s";
    private static final String MEDIA_OUTPUT_THUMB_NAME = "%s - %s - %s.%s";
    private static final String ALBUM_OUTPUT_THUMB_NAME = "%s - %s - %s.%s";
    private static final String SEPARATOR = "¸";
    private static final Executor EXECUTOR = Executors.newFixedThreadPool(12);
    private static final int MAX_CONCURRENCY = 5;
    private static final ZMP3BuildLinkServiceClient BUILD_LINK_SERVICE = ZMP3BuildLinkServiceClient.INST;
    private static final TZMP3CoreMWClient CORE_MW = TZMP3CoreMWClient.INST;

    public static void main(String[] args) throws IOException {
        ZMProfiler.open("ThumbAndSourceFetcher");
        try {
            List<String> lines = FileUtils.readLines(new File("data/media.csv"), StandardCharsets.UTF_8);
            lines = lines.subList(0, 5);

            int total = lines.size();

            List<List<String>> batches = ZUtil.splitList(lines, MAX_CONCURRENCY);
            new Thread(() -> {
                ZMProfiler.open("SourceFetcher");
                try {
                    ZMProfiler.count(SourceAndThumbFetcher.class, "main", "SOURCE", "TOTAL", total);

                    for (List<String> batch : batches) {
                        List<CompletableFuture<Void>> cfs = new ArrayList<>();
                        for (String line : batch) {
                            String[] split = line.split(SEPARATOR);
                            cfs.add(CompletableFuture.runAsync(() -> _downloadAlbumSource(split[0], split[1], split[2]), EXECUTOR));
                        }
                        for (CompletableFuture<Void> cf : cfs) {
                            cf.get();

                            ZMProfiler.count(SourceAndThumbFetcher.class, "main", "SOURCE", "PROGRESS");
                        }
                    }
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }).start();

            new Thread(() -> {
                ZMProfiler.open("ThumbFetcher");
                try {
                    ZMProfiler.count(SourceAndThumbFetcher.class, "main", "THUMB", "TOTAL", total);

                    for (List<String> batch : batches) {
                        List<CompletableFuture<Void>> cfs = new ArrayList<>();
                        for (String line : batch) {
                            String[] split = line.split(SEPARATOR);
                            cfs.add(CompletableFuture.runAsync(() -> _downloadAlbumThumb(split[0], split[1], split[2]), EXECUTOR));
                        }
                        for (CompletableFuture<Void> cf : cfs) {
                            cf.get();

                            ZMProfiler.count(SourceAndThumbFetcher.class, "main", "THUMB", "PROGRESS");
                        }
                    }
                } catch (Exception e) {
                    LOG.error(e.getMessage(), e);
                }
            }).start();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
        } finally {
            ZMProfiler.close();
        }
    }

    private static void _downloadAlbumSource(String albumID, String albumTitle, String artistNames) {
        TI32ListResult listResult = CORE_MW.getMediaIdsOfPlaylist(ConvertUtils.toInteger(albumID));
        if (ZErrorHelper.isFail(listResult.error)) {
            LOG.error(LogUtils.buildTabLog("CORE_MW.getMediaIdsOfPlaylist.FAIL", listResult.error, albumID, albumTitle, artistNames));
            return;
        }

        TMediaMapResult mapResult = CORE_MW.mgetMedia(listResult.values);
        if (ZErrorHelper.isFail(mapResult.error)) {
            LOG.error(LogUtils.buildTabLog("CORE_MW.mgetMedia.FAIL", mapResult.error, listResult.values));
            return;
        }
        for (int i = 0; i < listResult.values.size(); i++) {
            TMedia media = mapResult.values.get(listResult.values.get(i));
            if (media == null) {
                continue;
            }

            TBuildLinkRes res = BUILD_LINK_SERVICE.fullGetAudioBigFileLinks(new TBuildLinkReq()
                    .setCountryCode(TCountryCode.VIETNAM.getValue())
                    .setFormats(Arrays.asList(
                            TMediaSourceFormat.AudioLossless.getValue(),
                            TMediaSourceFormat.Audio320.getValue(),
                            TMediaSourceFormat.Audio128.getValue())
                    )
                    .setMediaId(ConvertUtils.toInteger(media.id))
            );
            if (ZErrorHelper.isFail(res.error)) {
                LOG.info(LogUtils.buildTabLog("BUILD_LINK_SERVICE.getAudioBigFileLinks.FAIL", media.id, media.title, media.artists, res));
                continue;
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
                LOG.info(LogUtils.buildTabLog("NO_SOURCE_AVAILABLE", media.id, media.title, media.artists, res));
                continue;
            }

            _downloadSource(link, String.format(ALBUM_OUTPUT_FOLDER, albumID, albumTitle, artistNames) + String.format(ALBUM_MEDIA_OUTPUT_SOURCE_NAME, (i + 1), media.id, media.title, artistNames, extension));
        }
    }

    private static void _downloadSource(String mediaID, String mediaTitle, String artistNames) {
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
            LOG.info(LogUtils.buildTabLog("NO_SOURCE_AVAILABLE", mediaID, mediaTitle, artistNames, res));
            return;
        }

        _downloadSource(link, String.format(MEDIA_OUTPUT_FOLDER, mediaID, mediaTitle, artistNames) + String.format(MEDIA_OUTPUT_SOURCE_NAME, mediaID, mediaTitle, artistNames, extension));
    }

    private static void _downloadSource(String url, String outputPath) {
        if (CommonUtils.isEmpty(url)) {
            return;
        }

        HttpRequestHelper.newGet()
                .setUrl(url)
                .downloadToFile(new File(outputPath));
    }

    private static void _downloadSongThumb(String mediaID, String mediaTitle, String artistNames) {
        TMediaResult res = CORE_MW.getMedia(ConvertUtils.toInteger(mediaID));
        if (ZErrorHelper.isFail(res.error) || res.value == null) {
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

        _downloadThumb(thumbnail, String.format(MEDIA_OUTPUT_FOLDER, mediaID, mediaTitle, artistNames) + String.format(MEDIA_OUTPUT_THUMB_NAME, mediaID, mediaTitle, artistNames, "jpg"));
    }

    private static void _downloadAlbumThumb(String albumID, String albumTitle, String artistNames) {
        TPlaylistResult res = CORE_MW.getPlaylist(ConvertUtils.toInteger(albumID));
        if (ZErrorHelper.isFail(res.error) || res.value == null) {
            LOG.error(LogUtils.buildTabLog("CORE_MW.getPlaylist.FAIL", res.error, albumID, albumTitle, artistNames));
            return;
        }
        TPlaylist album = res.value;

        String thumbnail = "";
        if (album.storageMeta != null) {
            thumbnail = album.storageMeta.coverImage;
        }

        _downloadThumb(thumbnail, String.format(ALBUM_OUTPUT_FOLDER, albumID, albumTitle, artistNames) + String.format(ALBUM_OUTPUT_THUMB_NAME, albumID, albumTitle, artistNames, "jpg"));
    }

    private static void _downloadThumb(String thumbnail, String outputPath) {
        String url = CommonUtils.isEmpty(thumbnail) ? "" : PHOTO_DOMAIN + thumbnail;
        if (CommonUtils.isEmpty(url)) {
            return;
        }

        HttpRequestHelper.newGet()
                .setUrl(url)
                .downloadToFile(new File(outputPath));
    }
}
