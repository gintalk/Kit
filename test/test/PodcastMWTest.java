/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCategory;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCategoryGetReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCategoryMGetReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCategoryMPutReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCategoryPutReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCategoryStatus;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastCustomListID;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisodeGetReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastGetSliceReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastListType;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgramGetEpisodeIdsReq;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgramGetReq;
import com.vng.zing.media.mp3.podcast.mw.thrift.client.TZMP3PodcastMWClient;
import java.util.Arrays;

/**
 *
 * @author namnh16
 */
public class PodcastMWTest extends BaseTest {

    private static final TZMP3PodcastMWClient CLI = TZMP3PodcastMWClient.INST;

    public static void main(String[] args) {
//        System.out.println(CLI.getEpisodeIdsOfProgram(new TPodcastProgramGetEpisodeIdsReq().setProgramId(1078188986)));
        System.out.println(ThriftUtils.getStructAsString(CLI.getEpisode(new TPodcastEpisodeGetReq().setId(1078188997)).value));
//        System.out.println(CLI.getProgram(new TPodcastProgramGetReq().setId(1331068752)));
//        System.out.println(CLI.getCategory(new TPodcastCategoryGetReq().setId(12316)));
//        System.out.println(CLI.putCategory(new TPodcastCategoryPutReq().setData(new TPodcastCategory().setId(-11).setName("Test category").setStatus(TPodcastCategoryStatus.SHOW.getValue()))));
//        System.out.println(CLI.removeCategory(-1));
//        System.out.println(CLI.mPutCategory(new TPodcastCategoryMPutReq().setDatas(Arrays.asList(
//                new TPodcastCategory().setId(1).setName("Category 1").setStatus(TPodcastCategoryStatus.SHOW.getValue()),
//                new TPodcastCategory().setId(2).setName("Category 2").setStatus(TPodcastCategoryStatus.SHOW.getValue()),
//                new TPodcastCategory().setId(3).setName("Category 3").setStatus(TPodcastCategoryStatus.SHOW.getValue())
//        ))));
//        System.out.println(CLI.mRemoveCategory(Arrays.asList(1,2,3)));
//        System.out.println(CLI.mGetCategory(new TPodcastCategoryMGetReq().setIds(Arrays.asList(1,3,2))));

//        System.out.println(CLI.getSliceIds(new TPodcastGetSliceReq().setListId(TPodcastCustomListID.PROMOTE_EPISODE.getValue()).setListType(TPodcastListType.CUSTOM_LIST.getValue()).setStart(0).setCount(200)));
    }
}
