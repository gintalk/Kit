/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.TMP3CustomListID;
import com.vng.zing.media.mp3.common.thrift.TMP3ItemType;
import com.vng.zing.media.mp3.common.thrift.TMP3ListType;
import com.vng.zing.media.mp3.common.thrift.TStringConfigKey;
import com.vng.zing.media.mp3.engine.stringconfig.StringConfigKeyUtils;
import com.vng.zing.media.mp3.mw.thrift.TListInfo;
import com.vng.zing.media.mp3.mw.thrift.client.TZingMP3MWClient;

/**
 *
 * @author namnh16
 */
public class ZingMP3MWTest extends BaseTest {

    private static final TZingMP3MWClient CLI = new TZingMP3MWClient("main");

    public static void main(String[] args) {
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonParser jp = new JsonParser();
//        JsonElement je = jp.parse(CLI.getStringConfig(84, StringConfigKeyUtils.getRadioHomeSectionLayoutConfigKey()).value);
//        System.out.println(gson.toJson(je));
//        System.out.println(ThriftUtils.getStructAsString(CLI.getStringConfig(84, TStringConfigKey.RADIO_PROMOTE_CHANNEL.name())));
//        System.out.println(ThriftUtils.getStructAsString(CLI.getSliceIds(new TListInfo().setCountryCode(84).setItemType(TMP3ItemType.EVENT.getValue()).setType(TMP3ListType.LIST_BY_CUSTOM.getValue()).setId(TMP3CustomListID.EVENT_PROMOTE.getValue()), 0, 200)));
    }
}
