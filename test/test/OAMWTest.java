/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OA;
import com.vng.zing.media.mp3.oa.mw.thrift.client.TZMP3OAMWClient;

/**
 *
 * @author namnh16
 */
public class OAMWTest extends BaseTest{

    private static final TZMP3OAMWClient oaClient = TZMP3OAMWClient.INST;

    public static void main(String[] args) {
        TZMP3OA oa = oaClient.getZMP3OA(6980).value;
        System.out.println(oa);

//        System.out.println(oaClient.putAssetId(new TAssetWriteInput().setZmp3oaId(819278).setType(TZMP3OAAssetType.LIVESTREAM.getValue()).setStatus(TLiveStreamStatus.REPLAY.getValue()).setId(10511).setScore(1594718927)));
//        System.out.println(oaClient.getAssetIdSlice(new TAssetReadInput().setZmp3oaId(819278).setType(TZMP3OAAssetType.LIVESTREAM.getValue()).setStatus(TLiveStreamStatus.REPLAY.getValue()).setFrom(0).setCount(200)));
    }
}
