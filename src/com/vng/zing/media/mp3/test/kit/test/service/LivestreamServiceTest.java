package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 15/01/2021
 */

import com.vng.zing.media.common.thrift.TI32Pair;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStream;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamApp;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamMedia;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamRequestMedia;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.livestation.service.thrift.TGetLiveProgramMediaReq;
import com.vng.zing.media.livestation.service.thrift.TGetLiveProgramReq;
import com.vng.zing.media.livestation.service.thrift.TGetTLiveProgramReq;
import com.vng.zing.media.livestation.service.thrift.client.TZMediaLiveStationServiceClient;
import com.vng.zing.media.livestream.service.thrift.*;
import com.vng.zing.media.livestream.service.thrift.client.TZMediaLiveStreamServiceClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LivestreamServiceTest extends BaseTest {

//    private static final TZMediaLiveStreamServiceClient LIVESTREAM_SERVICE = TZMediaLiveStreamServiceClient.INST;
    private static final TZMediaLiveStationServiceClient LIVE_STATION_SERVICE = TZMediaLiveStationServiceClient.INST;

    public static void main(String[] args) {
//        massReject();
//        System.out.println(ThriftUtils.INST.toString(LIVE_STATION_SERVICE.getLiveProgram(new TGetLiveProgramReq().setId(10443))));
//        ThriftUtils.prettyPrint(LIVESTREAM_SERVICE.getPinMessage(new TGetPinMessageReq().setAppId(1).setMsgId(10932)).value);
//        ThriftUtils.prettyPrint(LIVESTREAM_SERVICE.getStreamInfo(new TGetStreamInfoReq().setAppId(1).setStreamId(10634)).value);
//        System.out.println(ThriftUtils.INST.toString(LIVESTREAM_SERVICE.getLiveStream(new TGetLiveStreamReq().setAppId(1).setStreamId(10634)).value));
//        LIVESTREAM_SERVICE.setBlackListRequestMedia(new TSetBlackListRequestMediaReq().setLivestreamId(10931).setMediaIds(new ArrayList<>()));
//        System.out.println(LIVESTREAM_SERVICE.getWhiteListRequestMedia(new TGetWhiteListRequestMediaReq().setLivestreamId(10931)));
//        System.out.println(LIVESTREAM_SERVICE.putRequestMedia(new TPutRequestMediaReq().setRequestMedia(new TLiveStreamRequestMedia().setLivestreamId(10931).setMediaId(1078196370).setUserId(NAMNH16_ZMP3_ID))));
        ThriftUtils.prettyPrint(LIVE_STATION_SERVICE.getTLiveProgram(new TGetTLiveProgramReq().setId(14814)).value);

        System.exit(0);
    }

    private static void massReject() {
//        List<TI32Pair> pairList = LIVESTREAM_SERVICE.getListTopRequestMedia(new TGetListTopRequestMediaReq().setLivestreamId(10443).setStart(0).setCount(2)).values;
//        for (TI32Pair pair : pairList) {
//            System.out.println(LIVESTREAM_SERVICE.selectPlayRequestMedia(new TSelectPlayRequestMediaReq().setRequestMedia(new TLiveStreamMedia().setLivestreamId(10443).setMediaId(pair.key))));
//        }


//        TMGetLiveStreamRs rs = LIVESTREAM_SERVICE.mGetLiveStream(new TMGetLiveStreamReq()
//                .setAppId(TLiveStreamApp.ZMP3.getValue())
//                .setStreamIds(Arrays.asList(10634, 10633))
//        );
//        Map<Integer, TLiveStream> livestreams = rs.mapValues;
//        System.out.println(livestreams);

//        TMGetLiveStreamRs rs = LIVESTREAM_SERVICE.mGetLiveStream(new TMGetLiveStreamReq()
//                .setAppId(TLiveStreamApp.ZMP3.getValue())
//                .setStreamIds(Arrays.asList(10634, 10633))
//                .setAsList(true)
//        );
//        List<TLiveStream> livestreams = rs.listValues;
//        System.out.println(livestreams);
    }
}
