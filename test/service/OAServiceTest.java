/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import java.util.Arrays;
import java.util.List;

import com.vng.zing.common.ZUtil;
import com.vng.zing.media.common.thrift.THeaderReq;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAHome;
import com.vng.zing.media.mp3.oa.service.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetMyOAsReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOABoxesByTypeReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TMGetOAHomeReq;

/**
 *
 * @author namnh16
 */
public class OAServiceTest extends BaseTest {

    private static final TZMP3OAServiceClient CLIENT = TZMP3OAServiceClient.INST;

    private static final THeaderReq HEADER = new THeaderReq(ZUtil.getIpAddr(), "", 1, 1);
    private static final int PETER_SERKIN = 6980;
    private static final int RALPH_FELIX = 620304;
    private static final int JEDWARD = 8640;

    public static void main(String[] args) {
        _testOA();
//        _testOABox();
//        _testOAHome();
    }

    private static void _testOA() {
//        TZMP3OA oa = CLIENT.getOA(new TGetOAReq(HEADER).setAliasName("Peter-Serkin")).value;
//        System.out.println(ThriftUtils.getStructAsString(oa));

//        Map<Integer, TZMP3OA> oas = CLIENT.mgetOA(new TMGetOAReq(HEADER).setIds(Arrays.asList(PETER_SERKIN, RALPH_FELIX))).dataMap;
//        for(Map.Entry<Integer, TZMP3OA> entry: oas.entrySet()){
//            System.out.println(ThriftUtils.getStructAsString(entry.getValue()));
//        }
        System.out.println(CLIENT.getMyOAs(new TGetMyOAsReq(HEADER).setUserId(WhiteListUserUtils.NAMNH16).setStart(0).setCount(0)));
    }

    private static void _testOABox() {
//        TZMP3OABox box = CLIENT.getOABox(new TGetOABoxReq(HEADER).setId(10807)).value;
//        System.out.println(ThriftUtils.getStructAsString(box));

        List<TZMP3OABox> boxes = CLIENT.getOABoxesByType(new TGetOABoxesByTypeReq(HEADER).setBoxType(1).setOaId(PETER_SERKIN)).values;
        for (TZMP3OABox box : boxes) {
            System.out.println(ThriftUtils.getStructAsString(box));
        }

//        Map<Integer, TZMP3OABox> boxes = CLIENT.mgetOABox(new TMGetOABoxReq(HEADER).setIds(Arrays.asList(10807, 10808))).dataMap;
//        for(Map.Entry<Integer, TZMP3OABox> entry: boxes.entrySet()){
//            System.out.println(ThriftUtils.getStructAsString(entry.getValue()));
//        }
    }

    private static void _testOAHome() {
//        TZMP3OAHome home = CLIENT.getOAHome(new TGetOAHomeReq(HEADER).setId(PETER_SERKIN)).value;
//        System.out.println(ThriftUtils.getStructAsString(home));

        List<TZMP3OAHome> homes = CLIENT.mgetOAHome(new TMGetOAHomeReq(HEADER).setIds(Arrays.asList(PETER_SERKIN, RALPH_FELIX)).setAsList(true)).dataList;
        for (TZMP3OAHome home : homes) {
            System.out.println(ThriftUtils.getStructAsString(home));
        }
    }
}
