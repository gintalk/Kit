/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OA;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OABox;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAHome;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAOwner;
import com.vng.zing.media.mp3.oa.mw.thrift.client.TZMP3OAMWClient;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 *
 * @author namnh16
 */
public class OAMWTest extends BaseTest {

    private static final TZMP3OAMWClient CLIENT = TZMP3OAMWClient.INST;

    private static final int PETER_SERKIN = 6980;
    private static final int RALPH_FELIX = 620304;

    public static void main(String[] args) {
//        _testOA();
//        _testOABox();
//        _testOAHome();
        _testOAOwner();
    }
    
    private static void _testOA(){
//        TZMP3OA oa = CLIENT.getZMP3OA(PETER_SERKIN).value;
//        System.out.println(ThriftUtils.getStructAsString(oa));
        
        Map<Integer, TZMP3OA> oas = CLIENT.multiGetZMP3OA(Arrays.asList(PETER_SERKIN, RALPH_FELIX)).values;
        for(Map.Entry<Integer, TZMP3OA> entry: oas.entrySet()){
            System.out.println(ThriftUtils.getStructAsString(entry.getValue()));
        }
    }
    
    private static void _testOABox(){
//        TZMP3OABox box = CLIENT.getZMP3OABox(10807).value;
//        System.out.println(ThriftUtils.getStructAsString(box));
        
        Map<Integer, TZMP3OABox> boxes = CLIENT.multiGetZMP3OABox(Arrays.asList(10807, 10808, 10809)).values;
        for(Map.Entry<Integer, TZMP3OABox> entry: boxes.entrySet()){
            System.out.println(ThriftUtils.getStructAsString(entry.getValue()));
        }
    }

    private static void _testOAHome(){
//        TZMP3OAHome home = CLIENT.getZMP3OAHome(PETER_SERKIN).value;
//        System.out.println(ThriftUtils.getStructAsString(home));
        
        Map<Integer, TZMP3OAHome> homes = CLIENT.multiGetZMP3OAHome(Arrays.asList(PETER_SERKIN, RALPH_FELIX)).values;
        for(Map.Entry<Integer, TZMP3OAHome> entry: homes.entrySet()){
            System.out.println(ThriftUtils.getStructAsString(entry.getValue()));
        }
    }
    
    private static void _testOAOwner(){
//        List<TZMP3OAOwner> owners = CLIENT.getZMP3OAOwners(953266, 0, 100).values;
//        for(TZMP3OAOwner owner: owners){
//            System.out.println(ThriftUtils.getStructAsString(owner));
//        }
        
//        System.out.println(CLIENT.putZMP3OAOwner(new TZMP3OAOwner().setZmp3oaId(RALPH_FELIX).setUserId(1009291998).setRole(1)));

//        TZMP3OAOwner owner = CLIENT.getZMP3OAOwner(954707, 2526857);
//        System.out.println(ThriftUtils.getStructAsString(owner));

        List<TZMP3OAOwner> owners = CLIENT.getZMP3OAOwned(222486632, 0, 100).values;
        for(TZMP3OAOwner owner: owners){
            System.out.println(ThriftUtils.getStructAsString(owner));
        }
    }
}
