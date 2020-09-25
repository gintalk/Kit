/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamStatus;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.oa.core.TAssetReadInput;
import com.vng.zing.media.mp3.common.thrift.oa.core.TAssetWriteInput;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OA;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAAssetType;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAHome;
import com.vng.zing.media.mp3.oa.mw.thrift.client.TZMP3OAMWClient;
import java.util.Arrays;

/**
 *
 * @author namnh16
 */
public class OAMWTest extends BaseTest{

    private static final TZMP3OAMWClient client = TZMP3OAMWClient.INST;

    public static void main(String[] args) {
//        TZMP3OA oa = client.getZMP3OA(6980).value;
//        System.out.println(ThriftUtils.getStructAsString(oa));
//        TZMP3OA oa1 = client.getZMP3OA(946816).value;
//        oa.setBirthday(0);
//        oa1.setBirthday(0);
//        client.userMultiPutZMP3OA(Arrays.asList(oa, oa1));

        TZMP3OABox box = client.getOABox(12194).value;
        System.out.println(ThriftUtils.getStructAsString(box));
//        TZMP3OABox box1 = client.getOABox(12194).value;
//        box.setDescription("");
//        box1.setDescription("");
//        client.userMultiPutOABox(Arrays.asList(box, box1));

//        TZMP3OAHome home = client.getOAHome(6980).value;
//        home.setBoxIds(Arrays.asList(10807,10808,10809,12198,12194));
//        System.out.println(home);
//        client.userMultiPutZMP3OAHome(Arrays.asList(home, home));

        
    }
}
