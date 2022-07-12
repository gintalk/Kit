package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/06/2021
 */

import com.vng.zing.media.common.utils.DateTimeUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.engine.entity.pagination.IEPaging;
import com.vng.zing.media.mp3.common.thrift.core.TEvent;
import com.vng.zing.media.mp3.engine.model.EEventModel;
import com.vng.zing.media.mp3.service.event.thrift.client.TZMP3EventServiceClient;
import com.vng.zing.media.mp3.service.event.thrift.req.TGetEventByDateReq;
import com.vng.zing.media.mp3.service.event.thrift.req.TGetEventFollowerCountReq;
import com.vng.zing.media.mp3.service.event.thrift.req.TGetEventFollowerIdSliceReq;
import com.vng.zing.media.mp3.service.event.thrift.req.TGetEventReq;
import com.vng.zing.media.mp3.service.event.thrift.req.TGetEventTypeReq;
import com.vng.zing.media.mp3.service.event.thrift.req.TGetHostedEventSliceReq;
import com.vng.zing.media.mp3.service.event.thrift.req.TGetSimilarEventSliceReq;
import com.vng.zing.media.mp3.service.event.thrift.req.TMGetEventReq;
import com.vng.zing.media.mp3.service.promotesong.thrift.client.TZMP3PromoteSongServiceClient;
import com.vng.zing.media.mp3.service.promotesong.thrift.req.TPutPromotedSongReq;
import com.vng.zing.media.mp3.test.kit.test.common.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EventServiceTest extends Test {

    private static final TZMP3EventServiceClient SERVICE = TZMP3EventServiceClient.INST;

    public static void main(String[] args) {
//        _testGetEvent();
//        _testMGetEvent();
//        _testGetEventByDate();
//        _testGetEventFollowerIdSlice();
//        _testGetSimilarEventSlice();
        _testGetDiscoverEventSlice();
//        _testType();
//        _testSlice();

        System.exit(0);
    }

    private static void _testGetEvent() {
        ThriftUtils.prettyPrint(SERVICE.getEvent(new TGetEventReq()
                .setEventId(11412)
        ).value);
    }

    private static void _testMGetEvent() {
        Map<Integer, TEvent> events = SERVICE.mgetEvent(new TMGetEventReq()
                .setEventIds(Arrays.asList(10415, 10450))
                .setAsList(false)
        ).mapValues;
        events.forEach((key, value) -> ThriftUtils.prettyPrint(value));
    }

    private static void _testGetEventByDate() {
        List<TEvent> events = SERVICE.getEventByDate(new TGetEventByDateReq()
                .setDate("20210819")
        ).values;
        events.forEach(ThriftUtils::prettyPrint);
    }

    private static void _testGetEventFollowerIdSlice() {
        ThriftUtils.prettyPrint(SERVICE.getEventFollowerIdSlice(new TGetEventFollowerIdSliceReq()
                .setEventId(10647)
                .setStart(0)
                .setCount(0)
        ));

        ThriftUtils.prettyPrint(SERVICE.getEventFollowerCount(new TGetEventFollowerCountReq()
                .setEventId(10647)
        ));
    }

    private static void _testGetSimilarEventSlice() {
        List<TEvent> events = SERVICE.getSimilarEventSlice(new TGetSimilarEventSliceReq()
                .setEventId(10415)
                .setStart(0)
                .setCount(10)
        ).values;
        events.forEach(e -> System.out.println(e.title + " | " + DateTimeUtils.format(e.startTime, "yyyy/MM/dd HH:mm")));
    }

    private static void _testGetDiscoverEventSlice() {
//        TGetDiscoverEventSliceRes res = EVENT_SERVICE.getDiscoverEventSlice(new TGetDiscoverEventSliceReq()
//                .setFromTime(1651338000)
//                .setToTime(1652979600)
//                .setStart(0)
//                .setCount(20)
//                .setTypeId(4)
//        );
//        res.values.forEach(e -> System.out.println(e.title + " | " + e.type));

        IEPaging<TEvent> paging = EEventModel.INST.getDiscoverEvents(
                1654016400, 1656522000,
                "", "", 0, 20,
                0, 0, 72762
        );
        System.out.println(paging.getTotal());
        paging.getValues().forEach(e -> System.out.println(e.title + " | " + e.type));

//        TI32ListResult listResult = TZMP3SearchMWClient.INST.searchEventESV2(new TSearchEventESV2Req()
//                .setFrom(1643216400)
//                .setTo(1645894800)
//                .setStart(0)
//                .setLength(20)
//                .setOrderBy(TSearchEventOrderType.START_TIME_ASC.getValue())
//        );
//        System.out.println(listResult);

//        List<Integer> eventIds = TZMP3SearchMWClient.INST.searchEventES(new TSearchEventReq()
//                .setFrom(1640278800)
//                .setTo(1642996090)
//                .setStart(0)
//                .setLength(20)
//                .setOrderBy(TSearchEventOrderType.START_TIME_ASC.getValue())
//        ).values;
//        List<TEvent> events = EEventModel.INST.multiGetAsList(eventIds);
//        events.forEach(e -> System.out.println(e.title));

        System.exit(0);
    }

    private static void _testType(){
        ThriftUtils.prettyPrint(SERVICE.getEventType(new TGetEventTypeReq()
                .setTypeId(1)
        ));

//        ThriftUtils.prettyPrint(EVENT_SERVICE.getEventIdSliceByType(new TGetEventIdSliceByTypeReq()
//                .setType(10)
//                .setStart(0)
//                .setCount(20)
//        ));
//        ThriftUtils.prettyPrint(EVENT_SERVICE.getEventIdSliceByType(new TGetEventIdSliceByTypeReq()
//                .setType(9)
//                .setStart(0)
//                .setCount(20)
//        ));
    }

    private static void _testSlice(){
//        IEPaging<TEvent> paging = EEventModel.INST.getPublisherEvents(Constant.OA_PETER_SERKIN, 20, 10);
//        System.out.println(paging.getValues().stream().map(e -> e.id).collect(Collectors.toList()));
//        System.out.println(paging.getLastIndex());
//        System.out.println(paging.getTotal());
//        ThriftUtils.prettyPrint(SERVICE.getHostedEventSlice(new TGetHostedEventSliceReq()
//                .setHostId(Constant.OA_PETER_SERKIN)
//                .setStart(20)
//                .setCount(10)
//        ));

//        IEPaging<TEvent> paging = EEventModel.INST.getGuestEvents(Constant.OA_PETER_SERKIN, 20, 10);
//        System.out.println(paging.getValues().stream().map(e -> e.id).collect(Collectors.toList()));
//        System.out.println(paging.getLastIndex());
//        System.out.println(paging.getTotal());
//        ThriftUtils.prettyPrint(SERVICE.getHostedEventSlice(new TGetHostedEventSliceReq()
//                .setHostId(Constant.OA_PETER_SERKIN)
//                .setStart(20)
//                .setCount(10)
//        ));

        ThriftUtils.prettyPrint(SERVICE.getEventFollowerIdSlice(new TGetEventFollowerIdSliceReq()
                .setEventId(11890)
                .setStart(0)
                .setCount(10)
        ));
    }
}
