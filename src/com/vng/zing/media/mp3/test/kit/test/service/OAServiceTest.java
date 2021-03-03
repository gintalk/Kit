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
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAAssetType;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABoxResult;
import com.vng.zing.media.mp3.common.thrift.podcast.TPodcastEpisodeStatus;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OACMSServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.req.*;
import com.vng.zing.media.mp3.service.oa.thrift.res.res.TGetOABoxRes;
import com.vng.zing.media.mp3.test.kit.test.common.Constant;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
    }

    private static void testOAService() {
//        System.out.println(SERVICE_CLIENT.getOA(new TGetOAReq().setId(6980)));
//        System.out.println(SERVICE_CLIENT.getOABox(new TGetOABoxReq().setId(10610)));
//        System.out.println(SERVICE_CLIENT.getOAHome(new TGetOAHomeReq().setId(Constant.OA_TANG_CHI_KIEU)));
//        System.out.println(ThriftUtils.getStructAsString(SERVICE_CLIENT.getOABoxesByType(new TGetOABoxesByTypeReq().setOaId(Constant.OA_MR_SIRO).setBoxType(TZMP3OABoxType.RELATED_ARTIST.getValue()))));
//        System.out.println(SERVICE_CLIENT.getMyOAs(new TGetMyOAsReq(Constant.HEADER).setUserId(NAMNH16_ZMP3_ID).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.mgetOA(new TMGetOAReq().setIds(Arrays.asList(Constant.OA_PETER_SERKIN, Constant.OA_JEDWARD))));
//        System.out.println(SERVICE_CLIENT.mgetOABox(new TMGetOABoxReq(Constant.HEADER).setIds(Arrays.asList(10620, 10619))));
//        System.out.println(SERVICE_CLIENT.mgetOAHome(new TMGetOAHomeReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, 638327))));
        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq().setOaId(Constant.OA_PETER_SERKIN).setAssetType(TPublisherAssetType.PODCAST_EPISODE.getValue()).setAssetStatus(0).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.LIVE.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq().setOaId(946941).setAssetType(TZMP3OAAssetType.PODCAST_EPISODE.getValue()).setAssetStatus(TPodcastEpisodeStatus.SHOW.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.DRAFT.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.ENDED.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.getAssetSliceWithScore(new TGetAssetSliceWithScoreReq(Constant.HEADER).setOaId(Constant.OA_PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setAssetStatus(TEventStatus.HIDE.getValue()).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.putAsset(new TPutAssetReq(Constant.HEADER).setOaId(Constant.OA_PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setAssetStatus(TEventStatus.SHOW.getValue()).setAssetId(8888).setScore(8181)));
//        System.out.println(SERVICE_CLIENT.removeAsset(new TRemoveAssetReq(Constant.HEADER).setOaId(Constant.OA_PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setAssetStatus(TEventStatus.SHOW.getValue()).setAssetId(8888)));
    }

    private static void testOACMSService() {
//        System.out.println(CMS_SERVICE_CLIENT.getOA(new TGetOAReq(Constant.HEADER).setId(Constant.OA_PETER_SERKIN)));
//        System.out.println(CMS_SERVICE_CLIENT.getOABox(new TGetOABoxReq(Constant.HEADER).setId(10618)));
//        System.out.println(CMS_SERVICE_CLIENT.getOAHome(new TGetOAHomeReq(Constant.HEADER).setId(638327)));
//        System.out.println(CMS_SERVICE_CLIENT.mgetOA(new TMGetOAReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, Constant.OA_JEDWARD))));
//        System.out.println(CMS_SERVICE_CLIENT.mgetOABox(new TMGetOABoxReq(Constant.HEADER).setIds(Arrays.asList(10620, 10619))));
//        System.out.println(CMS_SERVICE_CLIENT.mgetOAHome(new TMGetOAHomeReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, 638327))));

//        TZMP3OA oa = CMS_SERVICE_CLIENT.getOA(new TGetOAReq(Constant.HEADER).setId(Constant.OA_PETER_SERKIN).setIsOrigin(true)).value;
//        oa.setShortDescription("Nghệ sĩ Peter Serkin");
//        System.out.println(CMS_SERVICE_CLIENT.updateOA(new TUpdateOAReq(Constant.HEADER).setOa(oa).setUserId(NAMNH16_ZMP3_ID)));

        try{
            File file = FileUtils.getFile("data/zmp3oa_box.csv");
            List<String> lines = FileUtils.readLines(file, "UTF-8");

            for(String line: lines){
                line = line.replace("\"", "");
                int boxId = ConvertUtils.toInteger(line);
                if(boxId <= 0){
                    continue;
                }
                TGetOABoxRes result = CMS_SERVICE_CLIENT.getOABox(new TGetOABoxReq().setId(boxId));
                if(ZErrorHelper.isFail(result.error)){
                    continue;
                }
                TZMP3OABox box = result.value;
                if(CommonUtils.isEmpty(box.title) && box.zmp3OAType == TZMP3OAType.ARTIST.getValue()){
                    System.out.println("Empty box title " + box.id);
                }
            }
        } catch(IOException e){
            e.printStackTrace(System.err);
        }
//        TZMP3OABox box = CMS_SERVICE_CLIENT.getOABox(new TGetOABoxReq().setId(10610)).value;
//        System.out.println(CMS_SERVICE_CLIENT.putOABox(new TPutOABoxReq().setBox(box)));
    }
}
