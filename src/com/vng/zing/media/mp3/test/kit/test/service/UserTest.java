package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 26/04/2021
 */

import com.vng.zing.media.commonlib.utils.ConvertUtils;
import com.vng.zing.media.mp3.commonlib.thrift.TUserListType;
import com.vng.zing.media.mp3.service.user.thrift.client.TZMP3UserServiceClient;
import com.vng.zing.media.mp3.service.user.thrift.req.TIsAssetReq;
import com.vng.zing.media.mp3.service.user.thrift.req.TRemoveAssetReq;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserTest extends Test {

    private static final TZMP3UserServiceClient USER_SERVICE = TZMP3UserServiceClient.INST;

    public static void main(String[] args) throws IOException {
        System.out.println(USER_SERVICE.isAsset(new TIsAssetReq()
                .setUserId(1428558)
                .setAssetType(TUserListType.FAVORITE_PLAYLIST.getValue())
                .setAssetId(1001138981)
        ));

//        rollbackFollower();

        System.exit(0);
    }

    private static void rollbackFollower() throws IOException {
        List<String> lines = FileUtils.readLines(new File("data/tbo-cctl-artist-ids.log.csv"), StandardCharsets.UTF_8);

        Set<Integer> removeFromThese = new HashSet<>(Arrays.asList(
                1088999209,
                1090207683,
                1381873722
        ));

        for (String line : lines) {
            String[] split = line.split("¸");

            String action = split[0];
            if (!"f".equals(action)) {
                continue;
            }

            int destPlaylistID = ConvertUtils.toInteger(split[2]);
            int srcPlaylistID = ConvertUtils.toInteger(split[3]);
            int userID = ConvertUtils.toInteger(split[4]);

            if (!removeFromThese.contains(destPlaylistID)) {
                continue;
            }

            int error = USER_SERVICE.removeAsset(new TRemoveAssetReq()
                    .setUserId(userID)
                    .setAssetType(TUserListType.FAVORITE_PLAYLIST.getValue())
                    .setAssetId(destPlaylistID)
            ).error;
            if (error < 0) {
                System.out.println(destPlaylistID + " " + userID);
            }
        }
    }
}
