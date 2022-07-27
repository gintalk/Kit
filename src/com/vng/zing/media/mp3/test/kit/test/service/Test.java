/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.common.thrift.TCMSClient;
import com.vng.zing.media.common.thrift.TCMSHeader;

import java.util.function.BiFunction;

/**
 * @author namnh16
 */
public class Test {

    protected static final int NAMNH16_ZMP3_ID = 1049058769;
    protected static final int NAMNH16_ZALO_ID = 260902907;
    protected static final int TRUONGDT_ZMP3_ID = 1013522712;
    protected static final int NAMNH16_INDIE_ARTIST_ID = 1866305;
    protected static final int XONE_RADIO_INDIE = 1873062;
    protected static final int XONE_RADIO_USER = 1059620050;
    protected static final int LUONGPC_ZMP3_ID = 1037491098;
    protected static final int XONE_RADIO = 947376;
    protected static final int QUYENDB2_ZMP3_ID = 1014483768;
    protected static final int NIENDT_ZMP3_ID = 1036815003;
    protected static final int NGUYENLT4_ZMP3_ID = 1032126223;
    protected static final int BAO_QUYEN_OA_ID = 1921897;
    protected static final int VED_DNARB = 1144229;
    protected static final int ON_AIR_OA_ID = 1223281;
    protected static final int DEMO = 1921897;
    protected static final int DEMO_4_DEV = 1001371;
    protected static final int PETER_SERKIN = 6980;
    protected static final BiFunction<Integer, Integer, TCMSHeader> CMS_HEADER = (oaID, userID) ->
            new TCMSHeader().setClientPlatformID(TCMSClient.OA_CMS.getValue()).setObjectID(oaID).setUserID(userID);
}
