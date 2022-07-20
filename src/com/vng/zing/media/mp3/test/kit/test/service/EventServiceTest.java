package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/06/2021
 */

public class EventServiceTest extends Test {

//    private static final TZMP3EventServiceClient EVENT_SERVICE = TZMP3EventServiceClient.INST;
//
//    public static void main(String[] args) {
////        _testGetEvent();
////        _testMGetEvent();
////        _testGetEventByDate();
////        _testGetEventFollowerIdSlice();
//        _testGetSimilarEventSlice();
////        _testGetDiscoverEventSlice();
//
//        System.exit(0);
//    }
//
//    private static void _testGetEvent() {
//        ThriftUtils.prettyPrint(EVENT_SERVICE.getEvent(new TGetEventReq()
//                .setEventId(11442)
//        ).value);
//    }
//
//    private static void _testMGetEvent() {
//        Map<Integer, TEvent> events = EVENT_SERVICE.mgetEvent(new TMGetEventReq()
//                .setEventIds(Arrays.asList(10415, 10450))
//                .setAsList(false)
//        ).mapValues;
//        events.forEach((key, value) -> ThriftUtils.prettyPrint(value));
//    }
//
//    private static void _testGetEventByDate() {
//        List<TEvent> events = EVENT_SERVICE.getEventByDate(new TGetEventByDateReq()
//                .setDate("20210819")
//        ).values;
//        events.forEach(ThriftUtils::prettyPrint);
//    }
//
//    private static void _testGetEventFollowerIdSlice() {
//        ThriftUtils.prettyPrint(EVENT_SERVICE.getEventFollowerIdSlice(new TGetEventFollowerIdSliceReq()
//                .setEventId(10647)
//                .setStart(0)
//                .setCount(0)
//        ));
//
//        ThriftUtils.prettyPrint(EVENT_SERVICE.getEventFollowerCount(new TGetEventFollowerCountReq()
//                .setEventId(10647)
//        ));
//    }
//
//    private static void _testGetSimilarEventSlice() {
//        List<TEvent> events = EVENT_SERVICE.getSimilarEventSlice(new TGetSimilarEventSliceReq()
//                .setEventId(10415)
//                .setStart(0)
//                .setCount(10)
//        ).values;
//        events.forEach(e -> System.out.println(e.title + " | " + DateTimeUtils.format(e.startTime, "yyyy/MM/dd HH:mm")));
//    }
//
//    private static void _testGetDiscoverEventSlice() {
//        TGetDiscoverEventSliceRes res = EVENT_SERVICE.getDiscoverEventSlice(new TGetDiscoverEventSliceReq()
//                .setFromTime(1643271443)
//                .setToTime(1645894800)
//                .setStart(0)
//                .setCount(20)
//        );
//        System.out.println(res);
//        res.values.forEach(e -> System.out.println(e.title));
//
//        TI32ListResult listResult = TZMP3SearchMWClient.INST.searchEventESV2(new TSearchEventESV2Req()
//                .setFrom(1643216400)
//                .setTo(1645894800)
//                .setStart(0)
//                .setLength(20)
//                .setOrderBy(TSearchEventOrderType.START_TIME_ASC.getValue())
//        );
//        System.out.println(listResult);
//
////        List<Integer> eventIds = TZMP3SearchMWClient.INST.searchEventES(new TSearchEventReq()
////                .setFrom(1640278800)
////                .setTo(1642996090)
////                .setStart(0)
////                .setLength(20)
////                .setOrderBy(TSearchEventOrderType.START_TIME_ASC.getValue())
////        ).values;
////        List<TEvent> events = EEventModel.INST.multiGetAsList(eventIds);
////        events.forEach(e -> System.out.println(e.title));
//
//        System.exit(0);
//    }
}
