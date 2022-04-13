/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAHome;
import com.vng.zing.media.mp3.mw.oa.stats.thrift.client.TZMP3OAStatsMWClient;
import com.vng.zing.media.mp3.mw.oa.stats.thrift.req.TGetZCPositionStatsMWReq;
import com.vng.zing.media.mp3.mw.oa.thrift.client.TZMP3OAMWClient;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TGetOABoxMWReq;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TGetOAHomeMWReq;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TMRemoveOABoxMWReq;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TPutOAHomeMWReq;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TRemoveOAMWReq;
import com.vng.zing.media.mp3.mw.oa.thrift.req.TRemoveOAOwnerMWReq;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author namnh16
 */
public class OAMWTest extends Test {

    private static final TZMP3OAMWClient OA_MW = TZMP3OAMWClient.INST;
    private static final TZMP3OAStatsMWClient OA_STATS_MW = TZMP3OAStatsMWClient.INST;

    public static void main(String[] args) {
        _testOA();
//        _testOABox();
//        _testOAHome();
//        _testOAOwner();
//        _testStats();

        System.exit(0);
    }

    private static void _testOA() {
//        TZMP3OA oa = OA_MW.getOA(new TGetOAMWReq()
//                .setOaId(Constant.OA_PETER_SERKIN)
//                .setIsOrigin(true)
//        ).value;
//        ThriftUtils.prettyPrint(oa);

//        oa.setType(TZMP3OAType.BRAND.getValue());
//        System.out.println(CLIENT.putZMP3OA(oa));

//        oa.setShortDescription("OA của nghệ sĩ Peter Serkin");
//        oa.setDescription("Peter Serkin sinh ra ở New York City, là con trai của nghệ sĩ dương cầm Rudolf Serkin , và là cháu nội của nghệ sĩ vĩ cầm có ảnh hưởng Adolf Busch , người con gái Irene đã kết hôn với Rudolf Serkin. Peter được đặt tên Adolf để vinh danh ông nội của ông.\n" +
//                "Năm 1958, ở tuổi 11, Serkin bắt đầu học tại Học viện Âm nhạc Curtis, giáo viên của ông bao gồm các nghệ sĩ dương cầm Ba Lan Mieczysław Horszowski, các bậc thầy người Mỹ Lee Luvisi, cũng như cha của mình. Ông tốt nghiệp vào năm 1965. Buổi hòa nhạc của ông bắt đầu sự nghiệp vào năm 1959, khi ông lần đầu tiên biểu diễn tại Liên hoan Âm nhạc Marlboro.");
//        System.out.println(CLIENT.putOA(new TPutOAMWReq()
//                .setValue(oa)
//        ));

//        Map<Integer, TZMP3OA> oas = CLIENT.multiGetZMP3OA(Arrays.asList(PETER_SERKIN, RALPH_FELIX)).values;
//        for(Map.Entry<Integer, TZMP3OA> entry: oas.entrySet()){
//            System.out.println(ThriftUtils.getStructAsString(entry.getValue()));
//        }

        List<Integer> oaIDs = Arrays.asList(637886, 637887, 637888, 637889, 637990, 638098, 638199, 638200, 638201, 638331);
        for (int oaID : oaIDs) {
            ThriftUtils.prettyPrint(OA_MW.removeOA(new TRemoveOAMWReq().setOaId(oaID)));

            TZMP3OAHome home = OA_MW.getOAHome(new TGetOAHomeMWReq().setOaId(oaID)).value;
            if(home == null || home.boxIds == null) continue;
            ThriftUtils.prettyPrint(OA_MW.mremoveOABox(new TMRemoveOABoxMWReq().setBoxIds(home.boxIds)));
        }
    }

    private static void _testOABox() {
        TZMP3OABox box = OA_MW.getOABox(new TGetOABoxMWReq().setBoxId(14788)).value;
        ThriftUtils.prettyPrint(box);

//        Map<Integer, TZMP3OABox> boxes = CLIENT.multiGetZMP3OABox(Arrays.asList(10807, 10808, 10809)).values;
//        for(Map.Entry<Integer, TZMP3OABox> entry: boxes.entrySet()){
//            System.out.println(ThriftUtils.getStructAsString(entry.getValue()));
//        }

//        ThriftUtils.prettyPrint(OA_MW.removeOABox(new TRemoveOABoxMWReq().setBoxId(14688)));
//        ThriftUtils.prettyPrint(OA_MW.removeOABox(new TRemoveOABoxMWReq().setBoxId(14695)));
    }

    private static void _testOAHome() {
        TZMP3OAHome home = OA_MW.getOAHome(new TGetOAHomeMWReq()
                .setOaId(947376)
        ).value;
        ThriftUtils.prettyPrint(home);

        Map<Integer, Integer> boxMap = new HashMap<>();
        boxMap.put(1, 1);
        boxMap.put(7, 1);
        boxMap.put(13, 1);

        home.setBoxMap(boxMap);

        System.out.println(OA_MW.putOAHome(new TPutOAHomeMWReq()
                .setValue(home)
        ));
    }

    private static void _testOAOwner() {
//        List<TZMP3OAOwner> owners = CLIENT.getZMP3OAOwners(953266, 0, 100).values;
//        for(TZMP3OAOwner owner: owners){
//            System.out.println(ThriftUtils.getStructAsString(owner));
//        }

//        System.out.println(CLIENT.putZMP3OAOwner(new TZMP3OAOwner().setZmp3oaId(RALPH_FELIX).setUserId(1009291998).setRole(1)));

//        List<TZMP3OAOwner> owners = OA_MW.getOAOwnerSliceByUserId(new TGetOAOwnerSliceByUserIdMWReq()
//                .setUserId(1014483768)
//                .setStart(0)
//                .setCount(20)
//        ).values;
//        owners.forEach(ThriftUtils::prettyPrint);
    }

    private static void _testStats() {
//        Map<Integer, Map<Integer, Integer>> values = OA_STATS_MW.getZCPositionStats(new TGetZCPositionStatsMWReq()
//                .setItemType(TZMP3OAStatsItemType.AUDIO.getValue())
//                .setItemIds(Arrays.asList(1104927692, 1107857638, 1107452799))
//                .setFromSeconds(1630429200)
//                .setToSeconds(1632848400)
//        ).values;
//        values.forEach((k, v) -> System.out.printf("key: %d, value: %s\n", k, v));

//        System.out.println(OA_STATS_MW.getFollowerAgeGenderStats(new TGetFollowerAgeGenderStatsMWReq()
//                .setItemType(1)
//                .setOaId(1009)
//                .setFromSeconds(1633021200)
//                .setToSeconds(1640365200)
//        ).dataMap);
//
//        System.out.println(OA_STATS_MW.getFollowerProvinceStats(new TGetFollowerProvinceStatsMWReq()
//                .setItemType(1)
//                .setOaId(1009)
//                .setFromSeconds(1633021200)
//                .setToSeconds(1640365200)
//        ).dataMap);

//        ThriftUtils.prettyPrint(OA_STATS_MW.mgetUniqueListenCount(new TMGetUniqueListenCountMWReq()
//                .setCountryCode(84)
//                .setItemType(1)
//                .setItemIds(Collections.singletonList(1083030837))
//                .setFromSeconds(1633021200)
//                .setToSeconds(1634144400)
//        ));

//        Map<Integer, Map<Integer, Integer>> values = OA_STATS_MW.getZCPositionStats(new TGetZCPositionStatsMWReq()
//                .setItemIds(Collections.singletonList(1107857638))
//                .setItemType(TZMP3OAStatsItemType.AUDIO.getValue())
//                .setFromSeconds(1634317200)
//                .setToSeconds(1634403600)
//        ).values;
//        values.forEach((key, value) -> System.out.printf("%d: %d\n", key, value.get(1107857638)));

        ThriftUtils.prettyPrint(OA_STATS_MW.getZCPositionStats(new TGetZCPositionStatsMWReq()
                .setItemIds(Collections.singletonList(1111279705))
                .setItemType(1)
                .setFromSeconds(0)
                .setToSeconds(0)
        ));
    }
}
