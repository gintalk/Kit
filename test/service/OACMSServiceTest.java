/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import java.util.List;

import com.vng.zing.common.ZUtil;
import com.vng.zing.media.common.thrift.THeaderReq;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OA;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAActivityLog;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAHome;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OALogQuery;
import com.vng.zing.media.mp3.oa.cms.service.thrift.client.TZMP3OACMSServiceClient;
import com.vng.zing.media.mp3.oa.cms.service.thrift.req.TGetOAActivityLogsReq;
import com.vng.zing.media.mp3.oa.cms.service.thrift.req.TPutOAReq;
import com.vng.zing.media.mp3.oa.cms.service.thrift.req.TRemoveOABoxReq;
import com.vng.zing.media.mp3.oa.mw.thrift.client.TZMP3OAMWClient;

/**
 *
 * @author namnh16
 */
public class OACMSServiceTest {

    private static final TZMP3OAMWClient MW = TZMP3OAMWClient.INST;
    private static final TZMP3OACMSServiceClient CMS = TZMP3OACMSServiceClient.INST;

    private static final THeaderReq HEADER = new THeaderReq(ZUtil.getIpAddr(), "", 1, 1);
    private static final int PETER_SERKIN = 6980;
    private static final int RALPH_FELIX = 620304;
    private static final int JEDWARD = 8640;

    public static void main(String[] args) {
//        _testOA();
//        _testOABox();
//        _testOAHome();
//        _testActivityLogs();
        _testOwner();
    }

    private static void _testOA() {
        TZMP3OA oa = MW.getZMP3OA(PETER_SERKIN).value;
        System.out.println(ThriftUtils.getStructAsString(oa));

//        oa.setDescription("Test description");
        oa.setDescription("Peter Serkin sinh ra ở New York City, là con trai của nghệ sĩ dương cầm Rudolf Serkin , và là cháu nội của nghệ sĩ vĩ cầm có ảnh hưởng Adolf Busch , người con gái Irene đã kết hôn với Rudolf Serkin. Peter được đặt tên Adolf để vinh danh ông nội của ông. Năm 1958, ở tuổi 11, Serkin bắt đầu học tại Học viện Âm nhạc Curtis, giáo viên của ông bao gồm các nghệ sĩ dương cầm Ba Lan Mieczysław Horszowski, các bậc thầy người Mỹ Lee Luvisi, cũng như cha của mình. Ông tốt nghiệp vào năm 1965. Buổi hòa nhạc của ông bắt đầu sự nghiệp vào năm 1959, khi ông lần đầu tiên biểu diễn tại Liên hoan Âm nhạc Marlboro...");
        System.out.println(CMS.putOA(new TPutOAReq(HEADER).setOa(oa).setIsFromSystem(false)));
    }

    private static void _testOABox() {
//        TZMP3OABox box = new TZMP3OABox()
//                .setZmp3OAId(PETER_SERKIN)
//                .setTitle("Test Box")
//                .setType(TZMP3OABoxType.RELATED_ARTIST.getValue())
//                .setItemType(TZMP3OABoxItemType.ARTIST.getValue())
//                .setItemIds(Arrays.asList(68284))
//                .setStatus(TZMP3OABoxStatus.SHOW.getValue())
//                .setDescription("Test Box description");
//        System.out.println(CMS.addOrUpdateOABox(new TAddOrUpdateOABoxReq(HEADER).setBox(box).setUserId(WhiteListUserUtils.NAMNH16)));

//        TZMP3OABox box = MW.getZMP3OABox(12464).value;
//        box.setDescription("New Box description");
//        System.out.println(CMS.addOrUpdateOABox(new TAddOrUpdateOABoxReq(HEADER).setBox(box).setUserId(WhiteListUserUtils.NAMNH16)));
        System.out.println(CMS.removeOABox(new TRemoveOABoxReq(HEADER).setBoxId(12467).setUserId(WhiteListUserUtils.NAMNH16)));
    }

    private static void _testOAHome() {
        TZMP3OAHome home = MW.getZMP3OAHome(PETER_SERKIN).value;
        System.out.println(ThriftUtils.getStructAsString(home));

//        home.boxIds.remove(new Integer(12464));
//        System.out.println(CMS.putOAHome(new TPutOAHomeReq(HEADER).setHome(home)));
    }

    private static void _testActivityLogs() {
        List<TZMP3OAActivityLog> logs = CMS.getOAActivityLogs(new TGetOAActivityLogsReq(HEADER)
                .setOaId(PETER_SERKIN).setUserId(WhiteListUserUtils.NAMNH16).setStart(0).setCount(100)
                .setQuery(new TZMP3OALogQuery(393, 4, 1546275600, 1609434000))
        ).values;
        for (TZMP3OAActivityLog log : logs) {
            System.out.println(ThriftUtils.getStructAsString(log));
        }
    }

    private static void _testOwner() {
//        List<TZMP3OAOwner> owners = CMS.getOAOwners(new TGetOAOwnersReq(HEADER).setOaId(PETER_SERKIN).setUserId(WhiteListUserUtils.LUONGPC).setStart(0).setCount(100)).values;
//        for(TZMP3OAOwner owner: owners){
//            System.out.println(ThriftUtils.getStructAsString(owner));
//        }

//        System.out.println(CMS.getOAOwnerPermission(new TGetOAOwnerPermissionReq(HEADER).setOaId(16).setUserId(1005196778)).values);
//        System.out.println(CMS.setOAOwner(new TSetOAOwnerReq(HEADER).setOaId(PETER_SERKIN).setActorId(WhiteListUserUtils.NAMNH16).setUserId(WhiteListUserUtils.LUONGPC).setRoleId(1)));
//        System.out.println(CMS.removeOAOwner(new TRemoveOAOwnerReq(HEADER).setOaId(PETER_SERKIN).setActorId(WhiteListUserUtils.NAMNH16).setUserId(WhiteListUserUtils.LUONGPC)));
    }
}
