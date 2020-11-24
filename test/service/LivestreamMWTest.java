/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.media.common.thrift.live.streaming.TLiveStream;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamProgram;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamRequestMedia;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.media.common.wrapper.zdn.ZMLivePlaylistWrapper;
import com.vng.zing.media.livestreaming.mw.thrift.client.ZMediaLiveStreamMWClient;

/**
 *
 * @author namnh16
 */
public class LivestreamMWTest extends BaseTest {

    private static final ZMediaLiveStreamMWClient CLI = new ZMediaLiveStreamMWClient("main");
//    private static final ZMLiveStreamMwWrapper ZCLI = new ZMLiveStreamMwWrapper("main");
    private static final ZMLivePlaylistWrapper LIVE_PLAYLIST_CLI = new ZMLivePlaylistWrapper("main");

    public static void main(String[] args) {
//        TLiveStream livestream = CLI.getLiveStream(10929).value;
//        System.out.println(ThriftUtils.getStructAsString(livestream));
        
//        TLiveStreamProgram program = CLI.getLiveStreamProgram(livestream.programId).value;
//        program.setPlayingItemId(156);
//        System.out.println(CLI.systemPutLiveStreamProgram(program));
//        System.out.println(ThriftUtils.getStructAsString(program));
//        
//        System.out.println(LIVE_PLAYLIST_CLI.setMediaList(program.livePlaylistId, Arrays.asList(
//                new TLiveMediaWrapper().setName("bai 1").setUrl("abc"),
//                new TLiveMediaWrapper().setName("bai 2").setUrl("def")
//        )));
//        TLiveStreamProgram program = new TLiveStreamProgram();
//        program.setId(10105)
//                .setAppId(1)
//                .setLiveSteamType(2)
//                .setLiveSteamId(10926)
//                .setRadioStationId("")
//                .setProgramItems(Arrays.asList(
//                        new TLiveStreamProgramItem(61, 3),
//                        new TLiveStreamProgramItem(73, 3)
//                )).setBeginBroadcastTime(1601436600)
//                .setEndBroadcastTime(1603990800)
//                .setLivePlaylistId("ba34fde7c1a228fc71b3")
//                .setStationType(2)
//                .setName("Hello moto");
//        
//        System.out.println(CLI.systemPutLiveStreamProgram(program));
//        System.out.println(CLI.putRequestMediaToListPromote(new TLiveStreamMedia().setLivestreamId(10926).setMediaId(1073744000)));
//        System.out.println(CLI.selectPlayRequestMedia(new TLiveStreamMedia().setLivestreamId(10926).setMediaId(1073741852)));
//        System.out.println(CLI.getListPromoteRequestMedia(new TLiveStreamGetListRequestMediaReq().setLivestreamId(10926).setStart(0).setCount(200)));
//        System.out.println(CLI.putRequestMedia(new TLiveStreamRequestMedia().setLivestreamId(10929).setMediaId(1073744242).setUserId(WhiteListUserUtils.NAMNH16)));
//        System.out.println(CLI.getListTopRequestMedia(new TLiveStreamGetListRequestMediaReq().setLivestreamId(10929).setStart(0).setCount(200)));
//        TLiveStreamListInfo info = new TLiveStreamListInfo()
//                .setType(TLiveStreamListType.LIST_BY_CUSTOM.getValue())
//                .setAppId(TLiveStreamingApp.ZMP3.getValue())
//                .setId(TLiveStreamCustomListID.PROMOTE_TOPIC_RADIO.getValue());
//
//        System.out.println(ThriftUtils.getStructAsString(CLI.getLiveRoom(10553).value));
//        TLivePlaylistInfoResultWrapper livePlaylist = LIVE_PLAYLIST_CLI.getLivePlaylistInfo("5b68310c0449ed17b458");
//        System.out.println(ThriftUtils.getStructAsString(livePlaylist));
//        System.out.println(ThriftUtils.getStructAsString(LIVE_PLAYLIST_CLI.getListMediaSlice("5b68310c0449ed17b458", livePlaylist.currentMediaIdx, 2)));
//        for(TLiveMediaWrapper media: LIVE_PLAYLIST_CLI.getListMediaSlice("0ebed9daf39f1ac1438e", livePlaylist.currentMediaIdx, 2).values){
//            System.out.println(ThriftUtils.getStructAsString(media));
//        }
//        System.out.println(ZCLI.getStreamInfo("99edb12a8d6f64313d7e"));
        System.exit(0);
    }
}
