/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

/**
 * @author namnh16
 */
public class EModelTest extends Test {

    public static void main(String[] args) throws IOException {
        IEPaging<TZMP3OAAccount> delegatedOAs = EZMP3OAModel.INST.getDelegateOAAccount(
                new THeaderReq(), 1071064070, 0, 0);
        System.out.println(delegatedOAs);

        System.exit(0);
    }
}
