/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import com.vng.zing.common.ZUtil;
import com.vng.zing.media.common.thrift.THeaderReq;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.media.mp3.common.thrift.TZMP3OABoxStatus;
import com.vng.zing.media.mp3.common.thrift.TZMP3OABoxType;
import com.vng.zing.media.mp3.common.thrift.TZMP3OARole;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OA;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABoxItemType;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OALogQuery;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAOwner;
import com.vng.zing.media.mp3.oa.service.thrift.client.ZMP3OAServiceClient;
import com.vng.zing.media.mp3.oa.service.thrift.req.TAddOrUpdateOABoxReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetMyOAsReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOAActivityLogsReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOABoxReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOABoxesByTypeReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOAHomeReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOAOwnerPermissionReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOAOwnersReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TGetOAReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TMGetOABoxReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TMGetOAHomeReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TMGetOAReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TMPutOAReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TPutOABoxReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TPutOAReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TRemoveOABoxReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TRemoveOAOwnerReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TSetOAOwnerReq;
import com.vng.zing.media.mp3.oa.service.thrift.req.TUpdateOAReq;
import com.vng.zing.media.mp3.oa.service.thrift.res.TAddOrUpdateOABoxRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetMyOAsRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetOAActivityLogsRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetOABoxRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetOABoxesByTypeRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetOAHomeRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetOAOwnerPermissionRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetOAOwnersRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TGetOARes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TMGetOABoxRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TMGetOAHomeRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TMGetOARes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TMPutOARes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TPutOABoxRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TPutOARes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TRemoveOABoxRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TRemoveOAOwnerRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TSetOAOwnerRes;
import com.vng.zing.media.mp3.oa.service.thrift.res.TUpdateOARes;

/**
 *
 * @author namnh16
 */
public class OAServiceTest extends BaseTest {

    private static final ZMP3OAServiceClient CLIENT = new ZMP3OAServiceClient("main");

    private static final THeaderReq HEADER = new THeaderReq(ZUtil.getIpAddr(), "", 1, 1);
    private static final int PETER_SERKIN = 6980;
    private static final int RALPH_FELIX = 620304;
    private static final int JEDWARD = 8640;

    public static void main(String[] args) {
//        _testGetOa();
//        _testMGetOa();
//        _testGetOABox();
//        _testMGetOABox();
//        _testGetOABoxesByType();
//        _testGetOAHome();
//        _testMGetOAHome();
//        _testGetOAActivityLogs();
//        _testGetOAOwners();
//        _testGetOAOwnerPermission();
//        _testGetMyOAs();

//        _testUpdateOA();
//        _testPutOA();
//        _testMPutOA();
//        _testAddOrUpdateOABox();
//        _testPutOABox();
        _testRemoveOABox();
//        _testSetOAOwner();
//        _testRemoveOAOwner();
    }

    private static void _testGetOa() {
        TGetOAReq req = new TGetOAReq();
        req.setHeader(HEADER);
        TGetOARes res;

        req.setId(648192);
        req.setIsOrigin(true);
        res = CLIENT.getOA(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(ThriftUtils.getStructAsString(res.value));
    }

    private static void _testMGetOa() {
        TMGetOAReq req = new TMGetOAReq();
        req.setHeader(HEADER);
        TMGetOARes res;

        req.setIds(Arrays.asList(PETER_SERKIN, JEDWARD));
        req.setAsList(true);
        req.setIsOrigin(true);
        req.setAliasNames(Arrays.asList("Peter-Serkin", "Jedward"));
        res = CLIENT.mgetOA(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(res.dataList);
    }

    private static void _testGetOABox() {
        TGetOABoxReq req = new TGetOABoxReq();
        req.setHeader(HEADER);
        TGetOABoxRes res;

        req.setId(10807);
        req.setIsOrigin(true);
        res = CLIENT.getOABox(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(ThriftUtils.getStructAsString(res.value));
    }

    private static void _testMGetOABox() {
        TMGetOABoxReq req = new TMGetOABoxReq();
        req.setHeader(HEADER);
        TMGetOABoxRes res;

        req.setIds(Arrays.asList(10618, 10619, 10620));
        req.setAsList(true);
        res = CLIENT.mgetOABox(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(res.dataList);
    }

    private static void _testGetOABoxesByType() {
        TGetOABoxesByTypeReq req = new TGetOABoxesByTypeReq();
        req.setHeader(HEADER);
        TGetOABoxesByTypeRes res;

        req.setOaId(PETER_SERKIN);
        req.setBoxType(TZMP3OABoxType.POPULAR_SONG.getValue());
        res = CLIENT.getOABoxesByType(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(res.values);
    }

    private static void _testGetOAHome() {
        TGetOAHomeReq req = new TGetOAHomeReq();
        req.setHeader(HEADER);
        TGetOAHomeRes res;

        req.setId(PETER_SERKIN);
        res = CLIENT.getOAHome(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(ThriftUtils.getStructAsString(res.value));
    }

    private static void _testMGetOAHome() {
        TMGetOAHomeReq req = new TMGetOAHomeReq();
        req.setHeader(HEADER);
        TMGetOAHomeRes res;

        req.setIds(Arrays.asList(PETER_SERKIN, JEDWARD));
        req.setAsList(true);
        res = CLIENT.mgetOAHome(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(res.dataList);
    }

    private static void _testGetOAActivityLogs() {
        TGetOAActivityLogsReq req = new TGetOAActivityLogsReq();
        req.setHeader(HEADER);
        TGetOAActivityLogsRes res;

        req.setOaId(PETER_SERKIN);
        req.setUserId(1025829998);
        req.setQuery(new TZMP3OALogQuery().setActionId(2).setUserId(PETER_SERKIN).setFrom(1561450365).setTo(1606099930));
        req.setStart(0);
        req.setCount(10);
        res = CLIENT.getOAActivityLogs(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(res.values);
    }

    private static void _testGetOAOwners() {
        TGetOAOwnersReq req = new TGetOAOwnersReq();
        req.setHeader(HEADER);
        TGetOAOwnersRes res;

        req.setOaId(PETER_SERKIN);
        req.setUserId(1025829998);
        req.setStart(0);
        req.setCount(10);
        res = CLIENT.getOAOwners(req);
        System.out.println(ThriftUtils.getStructAsString(res));
        System.out.println(res.values);
    }

    private static void _testGetOAOwnerPermission() {
        TGetOAOwnerPermissionReq req = new TGetOAOwnerPermissionReq();
        req.setHeader(HEADER);
        TGetOAOwnerPermissionRes res;

        req.setOaId(PETER_SERKIN);
        req.setUserId(1025829998);
        res = CLIENT.getOAOwnerPermission(req);
        System.out.println(res);
        for (Map.Entry<Integer, Set<Integer>> entry : res.values.entrySet()) {
            System.out.println(entry);
        }
    }

    private static void _testGetMyOAs() {
        TGetMyOAsReq req = new TGetMyOAsReq();
        req.setHeader(HEADER);
        TGetMyOAsRes res;

        req.setUserId(1025829998);
        req.setStart(0);
        req.setCount(10);
        res = CLIENT.getMyOAs(req);
        System.out.println(res);
        for (TZMP3OAOwner item : res.values) {
            System.out.println(ThriftUtils.getStructAsString(item));
        }
    }

    private static void _testUpdateOA() {
        TGetOAReq getReq = new TGetOAReq();
        getReq.setHeader(HEADER);
        TGetOARes getRes;

        getReq.setId(PETER_SERKIN);
        getRes = CLIENT.getOA(getReq);
        System.out.println(ThriftUtils.getStructAsString(getRes));
        System.out.println(ThriftUtils.getStructAsString(getRes.value));

        TUpdateOAReq updateReq = new TUpdateOAReq();
        updateReq.setHeader(HEADER);
        TUpdateOARes updateRes;

        getRes.value.setDescription("Thử set description mới cho Peter Serkin");
        updateReq.setOa(getRes.value);
        updateReq.setUserId(WhiteListUserUtils.NAMNH16);
        updateRes = CLIENT.updateOA(updateReq);
        System.out.println(updateRes);
        System.out.println(ThriftUtils.getStructAsString(updateRes));
    }

    private static void _testPutOA() {
        TGetOAReq getReq = new TGetOAReq();
        getReq.setHeader(HEADER);
        TGetOARes getRes;

        getReq.setId(PETER_SERKIN);
        getRes = CLIENT.getOA(getReq);
        System.out.println(ThriftUtils.getStructAsString(getRes));
        System.out.println(ThriftUtils.getStructAsString(getRes.value));

        TPutOAReq putReq = new TPutOAReq();
        putReq.setHeader(HEADER);
        TPutOARes putRes;

        getRes.value.setDescription("Peter Serkin sinh ra ở New York City, là con trai của nghệ sĩ dương cầm Rudolf Serkin , và là cháu nội của nghệ sĩ vĩ cầm có ảnh hưởng Adolf Busch , người con gái Irene đã kết hôn với Rudolf Serkin. Peter được đặt tên Adolf để vinh danh ông nội của ông. Năm 1958, ở tuổi 11, Serkin bắt đầu học tại Học viện Âm nhạc Curtis, giáo viên của ông bao gồm các nghệ sĩ dương cầm Ba Lan Mieczysław Horszowski, các bậc thầy người Mỹ Lee Luvisi, cũng như cha của mình. Ông tốt nghiệp vào năm 1965. Buổi hòa nhạc của ông bắt đầu sự nghiệp vào năm 1959, khi ông lần đầu tiên biểu diễn tại Liên hoan Âm nhạc Marlboro.");
        putReq.setOa(getRes.value);
        putReq.setIsFromSystem(false);
        putRes = CLIENT.putOA(putReq);
        System.out.println(putRes);
    }

    private static void _testMPutOA() {
        TMGetOAReq getReq = new TMGetOAReq();
        getReq.setHeader(HEADER);
        TMGetOARes getRes;

        getReq.setIds(Arrays.asList(JEDWARD));
        getReq.setAsList(true);
        getRes = CLIENT.mgetOA(getReq);
        System.out.println(getRes);
        for (TZMP3OA oa : getRes.dataList) {
            System.out.println(ThriftUtils.getStructAsString(oa));
            oa.setDescription("John Paul Henry Daniel Richard Grimes và Edward Peter Anthony Kevin Patrick Grimes (sinh ngày 16 tháng 10 năm 1991 tại Dublin, Ireland) là một bộ đô ihát pop rap người Ai-len. Họ là anh em song sinh cùng trứng và biểu diễn dưới nghệ danh Jedward.Single đầu tay của Jedward \"Under Pressure (Ice Ice Baby)\" được phát hành vào ngày 1 tháng 2 năm 2010. Họ trình diễn ca khúc này đầu tiên với Vanilla Ice tại lễ trao giải National Television Awards 2010 vào ngày 20 tháng 2. Được phát hành bởi Sony Music, single này xếp hạng 2 trong bàng xếp hạng UK Singles Chart và dành vị trí thứ 1 trong bảng xếp hạng single của Ai-len. Việc đã phát hành 1 single đã khiến Sony dừng hợp đồng với Jeward vào ngày 1 tháng 3 nhưng sau đó họ tiếp tục kí hợp đồng với Universal Records. Sau đó họ tiếp tục phát hành single thứ 2 của mình, một bản cover của ban nhạc Blink-182's \"All the Small Things\", vào ngày 16 tháng 7 và album đầu tay Planet Jedward vào ngày 26 tháng 7. Planet Jedward xếp vị trí thứ nhất trong bản xếp hạng album của Ai-len và xếp thứ 17 tại Anh. Album này được chứng nhận là album bạch kim tại phía Bắc Ai-len.");
        }

        TMPutOAReq putReq = new TMPutOAReq();
        putReq.setHeader(HEADER);
        TMPutOARes putRes;

        putReq.setOas(getRes.dataList);
        putRes = CLIENT.mputOA(putReq);
        System.out.println(ThriftUtils.getStructAsString(putRes));
    }

    private static void _testAddOrUpdateOABox() {
//        TGetOABoxReq getReq = new TGetOABoxReq();
//        getReq.setHeader(HEADER);
//        TGetOABoxRes getRes;
//        
//        getReq.setId(12451);
//        getRes = CLIENT.getOABox(getReq);
//        System.out.println(getRes);
//        System.out.println(ThriftUtils.getStructAsString(getRes.value));

        TAddOrUpdateOABoxReq putReq = new TAddOrUpdateOABoxReq();
        putReq.setHeader(HEADER);
        TAddOrUpdateOABoxRes putRes;

        TZMP3OABox box = new TZMP3OABox()
                .setId(10984)
                .setZmp3OAId(18252)
                .setTitle("Related Artists (allowed")
                .setType(TZMP3OABoxType.RELATED_ARTIST.getValue())
                .setItemType(TZMP3OABoxItemType.MEDIA.getValue())
                .setStatus(TZMP3OABoxStatus.SHOW.getValue())
                .setItemIds(Arrays.asList(100))
                .setDescription("Related Artists của OA Jedward (edited)")
                .setThumb("");

        putReq.setBox(box);
        putReq.setUserId(52518162);
        putRes = CLIENT.addOrUpdateOABox(putReq);
        System.out.println(ThriftUtils.getStructAsString(putRes));
    }

    private static void _testRemoveOABox() {
        TRemoveOABoxReq req = new TRemoveOABoxReq();
        req.setHeader(HEADER);
        TRemoveOABoxRes res;

        req.setBoxId(10984);
        req.setUserId(52518162);
        res = CLIENT.removeOABox(req);
        System.out.println(ThriftUtils.getStructAsString(res));
    }

    private static void _testSetOAOwner() {
        TSetOAOwnerReq req = new TSetOAOwnerReq();
        req.setHeader(HEADER);
        TSetOAOwnerRes res;

        req.setActorId(1049058769);
        req.setOaId(PETER_SERKIN);
        req.setRoleId(TZMP3OARole.MANAGER.getValue());
        req.setUserId(WhiteListUserUtils.NAMNH16);
        res = CLIENT.setOAOwner(req);
        System.out.println(res);
    }

    private static void _testRemoveOAOwner() {
        TRemoveOAOwnerReq req = new TRemoveOAOwnerReq();
        req.setHeader(HEADER);
        TRemoveOAOwnerRes res;

        req.setActorId(1049058769);
        req.setOaId(PETER_SERKIN);
        req.setUserId(WhiteListUserUtils.NAMNH16);
        res = CLIENT.removeOAOwner(req);
        System.out.println(res);
    }
    
}
