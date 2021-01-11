/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamStatus;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.oa.service.thrift.client.TZMP3OACMSServiceClient;
import com.vng.zing.media.mp3.oa.service.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetAssetSliceReq;
import com.vng.zing.media.mp3.test.kit.test.common.Constant;

/**
 *
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
//        System.out.println(SERVICE_CLIENT.getOA(new TGetOAReq(Constant.HEADER).setId(Constant.OA_PETER_SERKIN)));
//        System.out.println(SERVICE_CLIENT.getOABox(new TGetOABoxReq(Constant.HEADER).setId(10618)));
//        System.out.println(SERVICE_CLIENT.getOAHome(new TGetOAHomeReq(Constant.HEADER).setId(Constant.OA_TANG_CHI_KIEU)));
//        System.out.println(SERVICE_CLIENT.getOABoxesByType(new TGetOABoxesByTypeReq(Constant.HEADER).setOaId(Constant.OA_PETER_SERKIN).setBoxType(10)));
//        System.out.println(SERVICE_CLIENT.getMyOAs(new TGetMyOAsReq(Constant.HEADER).setUserId(NAMNH16_ZMP3_ID).setStart(0).setCount(100)));
//        System.out.println(SERVICE_CLIENT.mgetOA(new TMGetOAReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, Constant.OA_JEDWARD))));
//        System.out.println(SERVICE_CLIENT.mgetOABox(new TMGetOABoxReq(Constant.HEADER).setIds(Arrays.asList(10620, 10619))));
//        System.out.println(SERVICE_CLIENT.mgetOAHome(new TMGetOAHomeReq(Constant.HEADER).setIds(Arrays.asList(Constant.OA_PETER_SERKIN, 638327))));
        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(0).setStart(0).setCount(100)));
        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.LIVE.getValue()).setStart(0).setCount(100)));
        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.REPLAY.getValue()).setStart(0).setCount(100)));
        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.DRAFT.getValue()).setStart(0).setCount(100)));
        System.out.println(SERVICE_CLIENT.getAssetSlice(new TGetAssetSliceReq(Constant.HEADER).setOaId(638323).setAssetType(TPublisherAssetType.LIVESTREAM.getValue()).setAssetStatus(TLiveStreamStatus.ENDED.getValue()).setStart(0).setCount(100)));
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
    }
}
