/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.mp3.common.thrift.TStringConfigKey;
import com.vng.zing.media.mp3.mw.thrift.TListInfo;
import com.vng.zing.media.mp3.mw.thrift.client.TZingMP3MWClient;

/**
 *
 * @author namnh16
 */
public class ZingMP3MWTest extends BaseTest{
    
    private static final TZingMP3MWClient CLI = TZingMP3MWClient.INST;
    
    public static void main(String[] args) {
//        System.out.println(CLI.getStringConfig(84, TStringConfigKey.RADIO_BANNER.name()));
    }
}
