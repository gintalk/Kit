/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamCustomListID;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamListInfo;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamListType;
import com.vng.zing.media.common.thrift.live.streaming.TLiveStreamingApp;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.livestreaming.mw.thrift.client.ZMediaLiveStreamMWClient;
import com.vng.zing.zmliveplaylist.client.ZMLivePlaylistClient;

/**
 *
 * @author namnh16
 */
public class LivestreamMWTest extends BaseTest {

    private static final ZMediaLiveStreamMWClient CLI = new ZMediaLiveStreamMWClient("main");
//    private static final ZMLiveStreamMwWrapper ZCLI = new ZMLiveStreamMwWrapper("main");
    private static final ZMLivePlaylistClient LIVE_PLAYLIST_CLI = new ZMLivePlaylistClient("main");

    public static void main(String[] args) {
//        TLiveStream livestream = CLI.getLiveStream(10610).value;
//        System.out.println(ThriftUtils.getStructAsString(livestream));

//        TLiveStreamProgram program = CLI.getLiveStreamProgram(14521).value;
//        program.setPlayingItemId(156);
//        System.out.println(CLI.systemPutLiveStreamProgram(program));
//        System.out.println(ThriftUtils.getStructAsString(program));
//        for(TLiveStreamProgramItem item: program.programItems){
//            System.out.println(item.id);
//        }
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
//        System.out.println(CLI.getListPromoteRequestMedia(new TLiveStreamGetListRequestMediaReq().setLivestreamId(10610).setStart(0).setCount(200)));
//        System.out.println(CLI.putRequestMedia(new TLiveStreamRequestMedia().setLivestreamId(10610).setMediaId(1085283096).setUserId(WhiteListUserUtils.LOCNT3)));
//        TLiveStreamSystemGetListRequestMediaResult res = CLI.systemGetListTopRequestMedia(new TLiveStreamGetListRequestMediaReq().setLivestreamId(10610).setStart(0).setCount(200));
//        for(TLiveStreamRequestMediaStatInfo info: res.values){
////            if(info.requestNum != 3){
//                System.out.println(info.mediaId);
////            }
//        }
//        TI32PairListResult result = CLI.getListRequestMediaUser(new TLiveStreamGetListRequestMediaUserReq().setLivestreamId(10610).setUserId(WhiteListUserUtils.TRUONGDT).setStart(0).setCount(0));
//        System.out.println(result.total);
        TLiveStreamListInfo info = new TLiveStreamListInfo()
                .setType(TLiveStreamListType.LIST_BY_CUSTOM.getValue())
                .setAppId(TLiveStreamingApp.ZMP3.getValue())
                .setId(TLiveStreamCustomListID.PROMOTE_CAR_RADIO.getValue());
        System.out.println(ThriftUtils.getStructAsString(CLI.getSliceIds(info, 0, 200)));
//
//        System.out.println(ThriftUtils.getStructAsString(CLI.getLiveRoom(10553).value));
//        TLivePlaylistRes livePlaylist = LIVE_PLAYLIST_CLI.getLivePlaylistInfo(program.livePlaylistId);
//        System.out.println(ThriftUtils.getStructAsString(livePlaylist.livePlaylist));
//        System.out.println(ThriftUtils.getStructAsString(LIVE_PLAYLIST_CLI.getListMediaSlice(program.livePlaylistId, 0, 5)));
//        for(TLiveMediaWrapper media: LIVE_PLAYLIST_CLI.getListMediaSlice("0ebed9daf39f1ac1438e", livePlaylist.currentMediaIdx, 2).values){
//            System.out.println(ThriftUtils.getStructAsString(media));
//        }
//        System.out.println(ZCLI.getStreamInfo("99edb12a8d6f64313d7e"));
        System.exit(0);
    }
}
