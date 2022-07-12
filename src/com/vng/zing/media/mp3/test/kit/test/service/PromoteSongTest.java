/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.common.thrift.TPlatform;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.media.mp3.common.thrift.TUserTargetPromoteSong;
import com.vng.zing.media.mp3.common.thrift.api.THomeSectionLayout;
import com.vng.zing.media.mp3.common.thrift.core.TPromoteSongStatus;
import com.vng.zing.media.mp3.engine.model.EHomeSectionAppModel;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mp3.service.promotesong.thrift.client.TZMP3PromoteSongServiceClient;
import com.vng.zing.media.mp3.service.promotesong.thrift.req.TGetPromotedSongDeliveredCountReq;
import com.vng.zing.media.mp3.service.promotesong.thrift.req.TGetPromotedSongReq;
import com.vng.zing.media.mp3.service.promotesong.thrift.req.TIncreasePromotedSongDeliveredCountReq;
import com.vng.zing.media.mp3.service.promotesong.thrift.req.TMGetPromotedSongDeliveredCountReq;
import com.vng.zing.media.mp3.service.promotesong.thrift.req.TPutPromotedSongReq;
import com.vng.zing.media.mw.vip.thrift.client.ZMVIPMWReadClient;
import com.vng.zing.media.vip.common.thrift.TProductType;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author namnh16
 */
public class PromoteSongTest extends Test {

    private static final TZMP3PromoteSongServiceClient SERVICE = TZMP3PromoteSongServiceClient.INST;

    public static void main(String[] args) {
//        System.out.println(TZMP3PromoteSongServiceClient.INST.putPromotedSong(new TPutPromotedSongReq()
//                .setPromoteID(1)
//                .setMediaID(1079305089)
//                .setStatus(TPromoteSongStatus.ACTIVE.getValue())
//                .setQuota(10000)
//                .setStartTime(1655781120)
//                .setExpireTime(1655782320)
//                .setPlatformIDs(Arrays.asList(-2))
//                .setAgeSegmentIDs(Arrays.asList(-1))
//        ));

//        System.out.println(TZMP3CoreMWClient.INST.getMedia(1080856394).value.genreIds);

//        ThriftUtils.prettyPrint(ZMVIPMWReadClient.INST.getVipProfile(WhiteListUserUtils.NAMNH16, TProductType.ZMP3).value);

        System.out.println(TZMP3PromoteSongServiceClient.INST.getPromotedSong(new TGetPromotedSongReq()
                .setMediaID(1132410997)
                .setUserID(0)
                .setPlatformID(TPlatform.CAR_IOS.getValue())
        ));

//        System.out.println(SERVICE.increasePromotedSongDeliveredCount(new TIncreasePromotedSongDeliveredCountReq()
//                .setMediaID(1106794817)
//                .setCount(2000)
//        ));

//        System.out.println(SERVICE.getPromotedSongDeliveredCount(new TGetPromotedSongDeliveredCountReq()
//                .setMediaID(1106794817)
//                .setPromoteID(5)
//        ));

//        Map<Integer, Integer> map = new HashMap<>();
//        map.put(5, 1106794817);
//        map.put(4, 1106794817);
//        System.out.println(SERVICE.mgetPromotedSongDeliveredCount(new TMGetPromotedSongDeliveredCountReq()
//                .setDataMap(map)
//        ));

//        System.out.println(SERVICE.testGet(1, TPlatform.WEB.getValue(), TUserTargetPromoteSong.AGE_UNDER_18.getValue()));

        System.exit(0);
    }
}
