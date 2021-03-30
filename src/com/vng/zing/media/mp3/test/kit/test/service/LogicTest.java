/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author namnh16
 */
public class LogicTest extends BaseTest {

    public static void main(String[] args) {
        List<Boolean> list = Stream.of(true, false, false, true).map(LogicTest::flip).collect(Collectors.toList());
        System.out.println(list);
    }

    public static boolean flip(boolean value){
        return !value;
    }
}
