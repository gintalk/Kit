package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/03/2022
 */

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.commonlib.helper.DateTimeHelper;
import com.vng.zing.media.commonlib.vip.thrift.common.TLastTransactionInfo;
import com.vng.zing.media.commonlib.vip.thrift.common.TProductType;
import com.vng.zing.media.commonlib.vip.thrift.common.TVipProfileResult;
import com.vng.zing.media.commonlib.vip.thrift.common.TVipTransactionChannel;
import com.vng.zing.media.mw.vip.thrift.client.ZMVIPMWReadClient;

public class VipTest extends Test {

    public static void main(String[] args) {
        System.out.println(isValidVIPUser(QUYENDB2_ZMP3_ID));

        System.exit(0);
    }

    //
    protected static boolean isValidVIPUser(int userID) {
        TVipProfileResult profileResult = ZMVIPMWReadClient.INST.getVipProfile(userID, TProductType.ZMP3);
        if (ZErrorHelper.isFail(profileResult.error)
                || profileResult.value == null
                || profileResult.value.expireTimeMils < System.currentTimeMillis()
        ) {
            return false;
        }

        /*
         * If lastTransaction does not exist, approve. Else, reject if last transaction was done through VAS channel and
         * VIP expires in less than 24 hours; approve otherwise
         * https://trello.com/c/hXeckceV
         */
        TLastTransactionInfo lastTransaction = profileResult.value.lastTransactionInfo;
        if (lastTransaction == null) {
            return true;
        }

        TVipTransactionChannel lastTransactionChannel = TVipTransactionChannel.findByValue(lastTransaction.channel);
        if (lastTransactionChannel == null) {
            return false;
        }

        return !TVipTransactionChannel.VAS.equals(lastTransactionChannel) || profileResult.value.expireTimeMils - System.currentTimeMillis() >= 86400000;
    }
}
