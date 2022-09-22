/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    public static void main(String[] args) {
        System.out.println("a?b<c>v\\g/b\"s".replaceAll("[*:<>?|\\\\/\"]", " "));

        System.exit(0);
    }
}
