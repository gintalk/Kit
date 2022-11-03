package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 21/06/2021
 */

public class EventMWTest {

//    private static final TZMP3EventMWClient EVENT_MW = TZMP3EventMWClient.INST;
//
//    public static void main(String[] args) {
//        _testGet();
////        _testMGet();
////        _testGetIdByDate();
////        _testMGetEventIdsByDate();
////        _testSubscribe();
////        _testGetEventFollowerIdSlice();
//
//        System.exit(0);
//    }
//
//    private static void _testGet() {
//        ThriftUtils.prettyPrint(EVENT_MW.getEvent(new TGetEventMWReq()
//                .setEventId(11106)
//        ));
//    }
//
//    private static void _testMGet() {
//        Map<Integer, TEvent> values = EVENT_MW.mgetEvent(new TMGetEventMWReq()
//                .setEventIds(Arrays.asList(11130, 11118))
//        ).values;
//        values.forEach((key, value) -> ThriftUtils.prettyPrint(value));
//    }
//
//    private static void _testGetEventIdsByDate() {
//        List<Integer> values = EVENT_MW.getEventIdsByDate(new TGetEventIdsByDateMWReq()
//                .setDate("20210611")
//        ).values;
//        System.out.println(values);
//    }
//
//    private static void _testMGetEventIdsByDate() {
//        Map<String, List<Integer>> dataMap = EVENT_MW.mgetEventIdsByDate(new TMGetEventIdsByDateMWReq()
//                .setDates(Arrays.asList("20210611", "20210520"))
//        ).dataMap;
//        dataMap.forEach((key, value) -> System.out.printf("%s -> %s%n", key, value));
//    }
//
//    private static void _testSubscribe(){
//        int eCode = EVENT_MW.subscribeEvent(new TSubscribeEventMWReq()
//                .setEventId(10415)
//                .setUserId(WhiteListUserUtils.NAMNH16)
//                .setIsSubscribe(true)
//        );
//        System.out.println(eCode);
//    }
//
//    private static void _testGetEventFollowerIdSlice() {
//        TGetEventFollowerIdSliceMWRes res = EVENT_MW.getEventFollowerIdSlice(new TGetEventFollowerIdSliceMWReq()
//                .setEventId(10415)
//                .setStart(0)
//                .setStart(10)
//        );
//        ThriftUtils.prettyPrint(res);
//    }
}
