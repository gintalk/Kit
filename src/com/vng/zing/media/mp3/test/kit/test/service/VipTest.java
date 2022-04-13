package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/03/2022
 */

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mw.vip.thrift.client.ZMVIPMWReadClient;
import com.vng.zing.media.vip.common.thrift.TLastTransactionInfo;
import com.vng.zing.media.vip.common.thrift.TProductType;
import com.vng.zing.media.vip.common.thrift.TVipProfileResult;
import com.vng.zing.media.vip.common.thrift.TVipTransactionChannel;

public class VipTest extends Test {

    private static final ZMVIPMWReadClient VIP_MW = ZMVIPMWReadClient.INST;

    public static void main(String[] args) {
        System.out.println(_isValidVIPUser(1019076810));

        System.exit(0);
    }

    private static boolean _isValidVIPUser(int userId) {
        TVipProfileResult profileResult = ZMVIPMWReadClient.INST.getVipProfile(userId, TProductType.ZMP3);
        if (ZErrorHelper.isFail(profileResult.error)
                || profileResult.value == null
                || profileResult.value.expireTimeMils < System.currentTimeMillis()
        ) {
            return false;
        }

        TLastTransactionInfo lastTransaction = profileResult.value.lastTransactionInfo;
        if (lastTransaction == null) {
            return true;
        }
        TVipTransactionChannel lastTransactionChannel = TVipTransactionChannel.findByValue(lastTransaction.channel);
        if (lastTransactionChannel == null) {
            return false;
        }

        return lastTransactionChannel != TVipTransactionChannel.VAS;
    }
}
