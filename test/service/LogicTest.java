/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.vng.zing.logger.ZLogger;
import java.util.LinkedHashMap;

/**
 *
 * @author namnh16
 */
public class LogicTest extends BaseTest {

    private static final Logger LOG = ZLogger.getLogger(LogicTest.class);

    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(4654987, 1);
        hashMap.put(194659787, 1);
        hashMap.put(48654, 1);
        hashMap.put(35467, 1);
        
        System.out.println(hashMap.keySet());
        
        Map<Integer, Integer> linkedMap = new LinkedHashMap<>();
        linkedMap.put(4654987, 1);
        linkedMap.put(194659787, 1);
        linkedMap.put(48654, 1);
        linkedMap.put(35467, 1);
        
        System.out.println(linkedMap.keySet());
    }
}
