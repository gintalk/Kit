package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 26/04/2021
 */

import com.vng.zing.media.commonlib.utils.WhiteListUserIdUtils;
import com.vng.zing.media.mp3.commonlib.thrift.TUserListType;
import com.vng.zing.media.mp3.service.user.thrift.client.TZMP3UserServiceClient;
import com.vng.zing.media.mp3.service.user.thrift.req.TGetAssetSliceWithScoreReq;

import java.util.Arrays;
import java.util.List;

public class UserTest extends Test {

    private static final TZMP3UserServiceClient USER_SERVICE = TZMP3UserServiceClient.INST;

    public static void main(String[] args) {
        List<Integer> userIDs = Arrays.asList(
//                WhiteListUserIdUtils.KHAITQ2_USERID,
//                WhiteListUserIdUtils.KHOIDD,
//                WhiteListUserIdUtils.TAMNQT_USERID,
//                WhiteListUserIdUtils.TRUONGDT,
//                WhiteListUserIdUtils.NAMNH16,
                1023635027
        );

//        System.out.println(USER_SERVICE.multiAddAssets(new TMultiAddAssetsReq()
//                .setTime(System.currentTimeMillis())
//                .setAssetId(1091572488)
//                .setUserIds(userIDs)
//                .setAssetType(TUserListType.LIBRARY_PLAYLIST.getValue())
//        ));

        for (Integer userID : userIDs) {
            System.out.println(USER_SERVICE.getAssetSliceWithScore(new TGetAssetSliceWithScoreReq()
                    .setUserId(userID)
                    .setStart(0)
                    .setCount(200)
                    .setAssetType(TUserListType.LIBRARY_PLAYLIST.getValue())
            ).value.values);
        }

        System.exit(0);
    }
}
