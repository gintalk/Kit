/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import com.vng.zing.media.mp3.common.thrift.TUserListType;
import com.vng.zing.media.mp3.common.thrift.user.TUserReadAssetReq;
import com.vng.zing.media.mp3.usermw.thrift.client.TZMP3UserMWClient;

/**
 *
 * @author namnh16
 */
public class UserMWTest extends BaseTest {

    private static final TZMP3UserMWClient CLI = TZMP3UserMWClient.INST;

    public static void main(String[] args) {
//        System.out.println(CLI.getAssetSliceWithScore(
//                new TUserReadAssetReq()
//                        .setUserId(1158513)
//                        .setAssetType(TUserListType.LIBRARY_SONG.getValue())
//                        .setCount(200)
//                        .setStart(0))
//        );
        System.out.println(CLI.getAssetSlice(
                new TUserReadAssetReq()
                .setUserId(123)
                .setAssetType(TUserListType.CREATE_PLAYLIST.getValue())
                .setStart(0)
                .setCount(200)
        ));
    }
}
