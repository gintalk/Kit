/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisodeGetReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgramGetEpisodeIdsReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgramGetReq;
import com.vng.zing.media.mp3.podcast.mw.thrift.client.TZMP3PodcastMWClient;

/**
 *
 * @author namnh16
 */
public class PodcastMWTest extends BaseTest {

    private static final TZMP3PodcastMWClient CLI = TZMP3PodcastMWClient.INST;

    public static void main(String[] args) {
//        System.out.println(CLI.getEpisodeIdsOfProgram(new TPodcastProgramGetEpisodeIdsReq().setProgramId(1078188986)));
        System.out.println(ThriftUtils.getStructAsString(CLI.getEpisode(new TPodcastEpisodeGetReq().setId(1078188987)).value));
//        System.out.println(CLI.getProgram(new TPodcastProgramGetReq().setId(1094011204)));
    }
}
