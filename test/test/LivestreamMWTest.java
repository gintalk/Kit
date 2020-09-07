/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamCustomListID;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamListInfo;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamListType;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamingApp;
import com.vng.zing.media.livestreaming.mw.thrift.client.ZMediaLiveStreamMWClient;

/**
 *
 * @author namnh16
 */
public class LivestreamMWTest {
    
    
    private static final ZMediaLiveStreamMWClient client = new ZMediaLiveStreamMWClient("main");
    
    public static void main(String[] args) {
        TLiveStreamListInfo info = new TLiveStreamListInfo()
                .setType(TLiveStreamListType.LIST_BY_CUSTOM.getValue())
                .setAppId(TLiveStreamingApp.ZMP3.getValue())
                .setId(TLiveStreamCustomListID.PROMOTE_TOPIC_RADIO.getValue());
        
        System.out.println(client.getSliceIds(info, 0, 200));
    }
}
