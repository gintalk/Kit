/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import java.util.Arrays;
import java.util.List;

import com.vng.zing.media.mp3.common.thrift.TZMP3OABoxType;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABoxItemType;
import com.vng.zing.media.mp3.oa.mw.thrift.client.TZMP3OAMWClient;

/**
 *
 * @author namnh16
 */
public class OAMWTest extends BaseTest {

    private static final TZMP3OAMWClient client = TZMP3OAMWClient.INST;

    private static final int PETER_SERKIN = 6980;
    private static final int RALPH_FELIX = 620304;

    public static void main(String[] args) {
        System.out.println(_setItemIdsToOABox(PETER_SERKIN, TZMP3OABoxType.SPOTLIGHT.getValue(), TZMP3OABoxItemType.LIVESTREAM.getValue(), Arrays.asList(10574)));
    }

    private static int _setItemIdsToOABox(int oaId, int boxType, int boxItemType, List<Integer> itemIds) {
        TZMP3OABox box = client.getOABoxesByType(oaId, boxType).values.get(0);

        box.setItemType(boxItemType);
        box.setItemIds(itemIds);

        return client.putOABox(box, NAMNH16_ZMP3_ID);
    }
}
