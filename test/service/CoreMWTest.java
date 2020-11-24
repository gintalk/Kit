/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.core.TEventGetReq;
import com.vng.zing.media.mp3.common.thrift.core.TEventMGetReq;
import com.vng.zing.media.mp3.core.mw.thrift.client.TZMP3CoreMWClient;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author namnh16
 */
public class CoreMWTest extends BaseTest {

    private static final TZMP3CoreMWClient CLI = TZMP3CoreMWClient.INST;

    public static void main(String[] args) {
//        TEventGetReq req = new TEventGetReq()
//                .setId(10330);
//        System.out.println(ThriftUtils.getStructAsString(CLI.getEvent(req).value));
//        System.out.println(CLI.getSliceListI32(new TSliceReq().setStart(0).setCount(200).setType(TListI32Type.EVENT_FOLLOW_BY_USER.getValue()).setId(10141)));

        TEventMGetReq req = new TEventMGetReq();
        req.setIds(Arrays.asList(10330, 10331));
        
        System.out.println(CLI.mgetEvent(req));
    }
}
