package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 16/04/2021
 */

import com.vng.zing.media.common.thrift.TI32ListResult;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.TAudioBoolAttribute;
import com.vng.zing.media.mp3.common.thrift.TMediaBoolAttribute;
import com.vng.zing.media.mp3.common.thrift.TPlaylistBoolAttribute;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisode;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisodeGetReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisodeMGetReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgramGetEpisodeIdsReq;
import com.vng.zing.media.mp3.engine.dal.GenreDal;
import com.vng.zing.media.mp3.engine.dal.PlaylistDal;
import com.vng.zing.media.mp3.engine.model.EPodcastEpisodeModel;
import com.vng.zing.media.mp3.mw.podcast.thrift.client.TZMP3PodcastMWClient;

import java.util.Arrays;
import java.util.List;

public class PodcastMWTest extends Test {

    private static final TZMP3PodcastMWClient PODCAST_MW = TZMP3PodcastMWClient.INST;

    public static void main(String[] args) {
        System.out.println(PODCAST_MW.removeEpisode(1129257375));

        System.exit(0);
    }
}