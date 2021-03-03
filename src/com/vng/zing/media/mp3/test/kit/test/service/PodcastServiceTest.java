package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 14/01/2021
 */

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCategory;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisode;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgram;
import com.vng.zing.media.mp3.service.podcast.thrift.client.TZMP3PodcastServiceClient;
import com.vng.zing.media.mp3.service.podcast.thrift.req.*;

import java.util.Arrays;
import java.util.List;

public class PodcastServiceTest extends BaseTest {

    private static final TZMP3PodcastServiceClient SERVICE = TZMP3PodcastServiceClient.INST;

    public static void main(String[] args) {
//        _testEpisode();
//        _testProgram();
        _testCategory();
    }

    private static void _testEpisode() {
//        TPodcastEpisode episode = SERVICE.getEpisode(new TGetEpisodeReq().setEpisodeId(1078188998)).episode;
//        System.out.println(ThriftUtils.getStructAsString(episode));

//        episode.setDescription("");
//        System.out.println(SERVICE.putEpisode(new TPutEpisodeReq().setEpisode(episode)));

        List<TPodcastEpisode> episodes = SERVICE.mgetEpisode(new TMGetEpisodeReq().setEpisodeIds(Arrays.asList(1078188998, 1078189022)).setAsList(true)).dataList;
        for (TPodcastEpisode ep : episodes) {
            System.out.println(ThriftUtils.INST.toString(ep));
//            ep.setDescription("");
        }

//        System.out.println(SERVICE.mputEpisode(new TMPutEpisodeReq().setEpisodes(episodes)));
    }

    private static void _testProgram(){
//        TPodcastProgram program = SERVICE.getProgram(new TGetProgramReq().setProgramId(1078188986)).program;
//        System.out.println(ThriftUtils.getStructAsString(program));

//        program.setTitle("Breakfast Xone");
//        System.out.println(SERVICE.putProgram(new TPutProgramReq().setProgram(program)));

        List<TPodcastProgram> programs = SERVICE.mgetProgram(new TMGetProgramReq().setProgramIds(Arrays.asList(1078188986, 1094011204)).setAsList(true)).dataList;
        for(TPodcastProgram pro: programs){
            System.out.println(ThriftUtils.INST.toString(pro));
//            pro.setTitle("Lorem Ipsum");
        }

//        System.out.println(SERVICE.mputProgram(new TMPutProgramReq().setPrograms(programs)));
    }

    private static void _testCategory(){
        TPodcastCategory category = SERVICE.getCategory(new TGetCateforyReq().setCategoryId(12219)).category;
        System.out.println(ThriftUtils.INST.toString(category));

//        category.setName("Thể loại");
//        System.out.println(SERVICE.putCategory(new TPutCategoryReq().setCategory(category)));
    }
}
