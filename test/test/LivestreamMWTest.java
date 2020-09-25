/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.common.thrift.live.streaming.TLiveMediaWrapper;
import com.vng.zing.media.common.thrift.live.streaming.TLivePlaylistInfoResultWrapper;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.wrapper.zdn.ZMLivePlaylistWrapper;
import com.vng.zing.media.livestreaming.mw.thrift.client.ZMediaLiveStreamMWClient;

/**
 *
 * @author namnh16
 */
public class LivestreamMWTest {

    private static final ZMediaLiveStreamMWClient CLI = new ZMediaLiveStreamMWClient("main");
    private static final ZMLivePlaylistWrapper LIVE_PLAYLIST_CLI = new ZMLivePlaylistWrapper("main");

    public static void main(String[] args) {
        System.out.println(CLI.getLiveStream(10565).value.webViews);
        
//        TLiveStreamListInfo info = new TLiveStreamListInfo()
//                .setType(TLiveStreamListType.LIST_BY_CUSTOM.getValue())
//                .setAppId(TLiveStreamingApp.ZMP3.getValue())
//                .setId(TLiveStreamCustomListID.PROMOTE_TOPIC_RADIO.getValue());
//
//        System.out.println(ThriftUtils.getStructAsString(CLI.getLiveRoom(10553).value));

//        TLivePlaylistInfoResultWrapper livePlaylist = LIVE_PLAYLIST_CLI.getLivePlaylistInfo("c26843d575909ccec581");
//        System.out.println(ThriftUtils.getStructAsString(livePlaylist));
        
//        for(TLiveMediaWrapper media: LIVE_PLAYLIST_CLI.getListMediaSlice("c26843d575909ccec581", livePlaylist.currentMediaIdx, 2).values){
//            System.out.println(ThriftUtils.getStructAsString(media));
//        }
        
        System.exit(0);
    }
}
