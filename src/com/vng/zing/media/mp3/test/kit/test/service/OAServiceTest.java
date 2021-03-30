/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamStatus;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.TZMP3OABoxType;
import com.vng.zing.media.mp3.common.thrift.TZMP3OAType;
import com.vng.zing.media.mp3.common.thrift.core.TEventStatus;
import com.vng.zing.media.mp3.common.thrift.oa.core.*;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisodeStatus;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgram;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastProgramStatus;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.service.oa.thrift.res.TAddOrUpdateOABoxRes;
import com.vng.zing.media.mp3.service.oa.thrift.res.TGetOABoxRes;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OACMSServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.req.*;
import com.vng.zing.media.mp3.service.oa.thrift.res.TAddOrUpdateOABoxRes;
import com.vng.zing.media.mp3.test.kit.test.common.Constant;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author namnh16
 */
public class OAServiceTest extends BaseTest {

    private static final TZMP3OAServiceClient SERVICE_CLIENT = TZMP3OAServiceClient.INST;
    private static final TZMP3OACMSServiceClient CMS_SERVICE_CLIENT = TZMP3OACMSServiceClient.INST;

    public static void main(String[] args) {
        testOAService();
//        testOACMSService();

        System.exit(0);
    }

    private static void testOAService() {
//        ThriftUtils.prettyPrint(SERVICE_CLIENT.getOA(new TGetOAReq().setId(6980)).value);
//        System.out.println(SERVICE_CLIENT.getOABox(new TGetOABoxReq().setId(11006)));
        System.out.println(SERVICE_CLIENT.getOAHome(new TGetOAHomeReq().setId(638327)));
//        System.out.println(ThriftUtils.getStructAsString(SERVICE_CLIENT.getOABoxesByType(new TGetOABoxesByTypeReq().setOaId(Constant.OA_MR_SIRO).setBoxType(TZMP3OABoxType.RELATED_ARTIST.getValue()))));
//        System.out.println(SERVICE_CLIENT.getMyOAs(new TGetMyOAsReq(Constant.HEADER).setUserId(NAMNH16_ZMP3_ID).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.mgetOA(new TMGetOAReq().setIds(Arrays.asList(Constant.OA_PETER_SERKIN, Constant.OA_JEDWARD))));
//        System.out.println(SERVICE_CLIENT.mgetOABox(new TMGetOABoxReq(Constant.HEADER).setIds(Arrays.asList(10620, 10619))));
//        System.out.println(SERVICE_CLIENT.mgetOAHome(new TMGetOAHomeReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, 638327))));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq().setOaId(6980).setAssetType(TPublisherAssetType.PODCAST_PROGRAM.getValue()).setAssetStatus(1).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.LIVE.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq().setOaId(6980).setAssetType(TZMP3OAAssetType.PODCAST_EPISODE.getValue()).setAssetStatus(TPodcastEpisodeStatus.SHOW.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.DRAFT.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.ENDED.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSliceWithScore(new TGetAssetSliceWithScoreReq(Constant.HEADER).setOaId(Constant.OA_PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setAssetStatus(TEventStatus.HIDE.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.putAsset(new TPutAssetReq(Constant.HEADER).setOaId(Constant.OA_PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setAssetStatus(TEventStatus.SHOW.getValue()).setAssetId(8888).setScore(8181)));
//        System.out.println(SERVICE_CLIENT.removeAsset(new TRemoveAssetReq(Constant.HEADER).setOaId(Constant.OA_PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setAssetStatus(TEventStatus.SHOW.getValue()).setAssetId(8888)));
    }

    private static void testOACMSService() {
//        System.out.println(CMS_SERVICE_CLIENT.getOA(new TGetOAReq(Constant.HEADER).setId(Constant.OA_PETER_SERKIN)));
//        System.out.println(CMS_SERVICE_CLIENT.getOABox(new TGetOABoxReq().setId(11006)));
//        TZMP3OAHome home = CMS_SERVICE_CLIENT.getOAHome(new TGetOAHomeReq().setId(6980)).value;
//        home.boxMap.put(7, 0);
//        System.out.println(CMS_SERVICE_CLIENT.putOAHome(new TPutOAHomeReq().setHome(home)));
//        System.out.println(CMS_SERVICE_CLIENT.getOAHome(new TGetOAHomeReq().setId(6980)));
//        System.out.println(CMS_SERVICE_CLIENT.removeOABox(new TRemoveOABoxReq().setUserId(NAMNH16_ZMP3_ID).setBoxId(11004)));
//        System.out.println(CMS_SERVICE_CLIENT.mgetOA(new TMGetOAReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, Constant.OA_JEDWARD))));
//        System.out.println(CMS_SERVICE_CLIENT.mgetOABox(new TMGetOABoxReq().setIds(Arrays.asList(10620, 10619))));
//        System.out.println(CMS_SERVICE_CLIENT.mgetOAHome(new TMGetOAHomeReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, 638327))));

//        TZMP3OA oa = CMS_SERVICE_CLIENT.getOA(new TGetOAReq(Constant.HEADER).setId(Constant.OA_PETER_SERKIN).setIsOrigin(true)).value;
//        oa.setShortDescription("Nghệ sĩ Peter Serkin");
//        System.out.println(CMS_SERVICE_CLIENT.updateOA(new TUpdateOAReq(Constant.HEADER).setOa(oa).setUserId(NAMNH16_ZMP3_ID)));

        TZMP3OABox box = CMS_SERVICE_CLIENT.getOABox(new TGetOABoxReq().setId(11006)).value;
        box.setItemIds(new ArrayList<>());
        System.out.println(CMS_SERVICE_CLIENT.putOABox(new TPutOABoxReq().setBox(box)));

//        TZMP3OABox box = new TZMP3OABox()
//                .setZmp3OAId(6980)
//                .setItemIds(Arrays.asList(1094011205, 1094011204))
//                .setType(TZMP3OABoxType.PODCAST_EPISODE.getValue());
//        TAddOrUpdateOABoxRes res = CMS_SERVICE_CLIENT.addOrUpdateOABox(new TAddOrUpdateOABoxReq()
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setBox(box)
//        );
//        System.out.println(res);

//        TZMP3OAHome home = new TZMP3OAHome()
//                .setZmp3OAId(638201)
//                .setBoxIds(new ArrayList<>())
//                .setBoxMap(new HashMap<>());
//
//        System.out.println(CMS_SERVICE_CLIENT.putOAHome(new TPutOAHomeReq()
//                .setHome(home)
//        ));
    }
}
