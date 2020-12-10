/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.common.ZUtil;
import com.vng.zing.media.common.thrift.THeaderReq;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamStatus;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.service.publisher.thrift.client.TZMP3PublisherServiceClient;
import com.vng.zing.media.mp3.service.publisher.thrift.req.TExistsReq;
import com.vng.zing.media.mp3.service.publisher.thrift.req.TGetAssetSliceReq;

/**
 *
 * @author namnh16
 */
public class PublisherServiceTest {

    private static final TZMP3PublisherServiceClient CLIENT = TZMP3PublisherServiceClient.INST;

    private static final THeaderReq HEADER = new THeaderReq(ZUtil.getIpAddr(), "", 1, 1);
    private static final int PETER_SERKIN = 6980;
    private static final int RALPH_FELIX = 620304;
    private static final int JEDWARD = 8640;

    public static void main(String[] args) {
        System.out.println(CLIENT.getAssetSlice(new TGetAssetSliceReq(HEADER).setPublisherId(PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setStart(0).setCount(200)));
//        System.out.println(CLIENT.exists(new TExistsReq(HEADER).setPublisherId(PETER_SERKIN).setAssetType(TPublisherAssetType.EVENT.getValue()).setAssetId(999)));
    }
}
