/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.jsoniter.JsonIterator;
import com.jsoniter.output.JsonStream;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.wrapper.JsonWrapper;
import com.vng.zing.media.mp3.commonlib.zmsql.dal.contentcollection.STMediaDal;
import com.vng.zing.media.mp3.commonlib.zmsql.entity.contentcollection.STMediaEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    public static void main(String[] args) {
//        System.out.println(ZCommonX.noise_withkey("https://api.spotify.com/v1/search", "Wm5itpSZX0"));

//        PrintUtils.printTBase(TZMP3ForbiddenFilterClient.INST.checkForbidden(new CheckForbiddenReq()
//                .setCountryCode(84)
//                .setType(TForbiddenType.COMMENT.getValue())
//                .setInput("dcm")
//        ));

        STMediaEntity e = STMediaDal.INST.getItemWithPrimaryKey("abc");
        System.out.println(e);

//        e.setAlbumID("pum");
        System.out.println(STMediaDal.INST.addOrUpdate(e));

//        String str = "[\n" +
//                "  {\n" +
//                "    \"url\": \"http\",\n" +
//                "    \"height\": 120,\n" +
//                "    \"width\": 232\n" +
//                "  },\n" +
//                "  {\n" +
//                "    \"url\": \"mppn\",\n" +
//                "    \"height\": 234,\n" +
//                "    \"width\": 124\n" +
//                "  }\n" +
//                "]";
//        try {
//            JsonIterator iter = JsonIterator.parse(str);
//            List<STMediaEntity.Image> list = new ArrayList<>();
//            while(iter.readArray()){
//                list.add(iter.read(STMediaEntity.Image.class));
//            }
//
//            STMediaEntity ett = new STMediaEntity();
//            ett.setImages(list);
//            System.out.println(ett);
//        } catch (Exception e) {
//            ZLogger.getLogger(CommonTest.class).error(e.getMessage(), e);
//        }

        System.exit(0);
    }
}
