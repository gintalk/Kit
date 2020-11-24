/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.TZMP3OABoxStatus;
import java.util.Arrays;
import java.util.List;

import com.vng.zing.media.mp3.common.thrift.TZMP3OABoxType;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABoxItemType;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OALogQuery;
import com.vng.zing.media.mp3.oa.mw.thrift.client.TZMP3OAMWClient;
import com.vng.zing.media.mp3.oa.service.thrift.client.ZMP3OAServiceClient;

/**
 *
 * @author namnh16
 */
public class OAMWTest extends BaseTest {

    private static final TZMP3OAMWClient CLIENT = new TZMP3OAMWClient("main");

    private static final int PETER_SERKIN = 6980;
    private static final int RALPH_FELIX = 620304;

    public static void main(String[] args) {
//        System.out.println(ThriftUtils.getStructAsString(CLIENT.getZMP3OA(PETER_SERKIN).value));
        System.out.println(ThriftUtils.getStructAsString(CLIENT.getOAHome(18252).value));
//        System.out.println(ThriftUtils.getStructAsString(CLIENT.getOABox(12462).value));
//        TZMP3OABox box = new TZMP3OABox()
//                .setZmp3OAId(PETER_SERKIN)
//                .setTitle("News Feed (allowed")
//                .setType(TZMP3OABoxType.NEWS_FEED.getValue())
//                .setItemType(TZMP3OABoxItemType.MEDIA.getValue())
//                .setStatus(TZMP3OABoxStatus.SHOW.getValue())
//                .setItemIds(Arrays.asList(100))
//                .setDescription("News Feed của OA Peter Serkin")
//                .setThumb("");
//        System.out.println(CLIENT.putOABox(box, 52518162));
    }

    private static int _setItemIdsToOABox(int oaId, int boxType, int boxItemType, List<Integer> itemIds) {
        TZMP3OABox box = CLIENT.getOABoxesByType(oaId, boxType).values.get(0);

        box.setItemType(boxItemType);
        box.setItemIds(itemIds);

        return CLIENT.putOABox(box, NAMNH16_ZMP3_ID);
    }
}
