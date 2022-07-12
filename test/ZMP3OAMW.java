/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 30/06/2022
 */

import com.vng.zing.media.mp3.mw.oa.thrift.client.TZMP3OAMWClient;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TGetOABoxMWReq;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TGetOAMWReq;
import com.vng.zing.media.mp3.test.kit.test.common.PrintUtils;

public class ZMP3OAMW {

    private static final TZMP3OAMWClient MW = TZMP3OAMWClient.INST;

    public static void main(String[] args) {
//        testOA();
        testOABox();

        System.exit(0);
    }

    public static void testOA() {
        PrintUtils.printTBase(MW.getOA(new TGetOAMWReq().setOaId(6980)).value);
    }

    public static void testOABox() {
        PrintUtils.printTBase(MW.getOABox(new TGetOABoxMWReq().setBoxId(10528)).value);
    }
}
