/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetReadReq;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetType;
import com.vng.zing.media.mp3.publisher.mw.thrift.client.TZMP3PublisherMWClient;

/**
 *
 * @author namnh16
 */
public class PublisherMWTest extends BaseTest {

    private static final TZMP3PublisherMWClient CLI = TZMP3PublisherMWClient.INST;

    public static void main(String[] args) {
        TPublisherAssetReadReq readReq = new TPublisherAssetReadReq()
                .setPublisherId(10139)
                .setAssetType(TPublisherAssetType.EVENT.getValue())
                .setStart(0)
                .setCount(200);
        System.out.println(CLI.getAssetSliceWithScore(readReq));
    }
}
