/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetReadReq;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq;
import com.vng.zing.media.mp3.publisher.mw.thrift.client.TZMP3PublisherMWClient;

/**
 *
 * @author namnh16
 */
public class PublisherMWTest extends BaseTest {

    private static final TZMP3PublisherMWClient CLI = TZMP3PublisherMWClient.INST;

    public static void main(String[] args) {
        TPublisherAssetReadReq readReq = new TPublisherAssetReadReq()
                .setPublisherId(638327)
                .setAssetType(TPublisherAssetType.PODCAST_PROGRAM.getValue())
                .setStart(0)
                .setCount(200);
        System.out.println(CLI.getAssetSliceWithScore(readReq));
        
//        TPublisherAssetWriteReq req = new TPublisherAssetWriteReq()
//                .setPublisherId(6980)
//                .setAssetType(TPublisherAssetType.PODCAST_PROGRAM.getValue())
//                .setAssetId(3)
//                .setScore(1);
////        System.out.println(CLI.putAsset(req));
//        System.out.println(CLI.removeAsset(req));
        
//        System.out.println(CLI.getAssetCount(new TPublisherAssetReadReq().setPublisherId(NAMNH16_ZMP3_ID).setAssetType(TPublisherAssetType.LIVESTREAM.getValue())));
    }
}
