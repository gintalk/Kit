/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.common.thrift.TSliceReq;
import com.vng.zing.media.mp3.common.thrift.TListI32Type;
import com.vng.zing.media.mp3.common.thrift.core.TEventGetReq;
import com.vng.zing.media.mp3.core.mw.thrift.client.TZMP3CoreMWClient;

/**
 *
 * @author namnh16
 */
public class CoreMWTest extends BaseTest {

    private static final TZMP3CoreMWClient CLI = TZMP3CoreMWClient.INST;

    public static void main(String[] args) {
        TEventGetReq req = new TEventGetReq()
                .setId(10118);
        System.out.println(CLI.getEvent(req));

        System.out.println(CLI.getSliceListI32(new TSliceReq().setStart(0).setCount(200).setType(TListI32Type.EVENT_FOLLOW_BY_USER.getValue()).setId(10141)));
    }
}
