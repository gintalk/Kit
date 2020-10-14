/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import com.vng.zing.media.common.client.ZMediaClientPoolManager;
import com.vng.zing.media.common.client.ZaloIdMWClient;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.EncryptUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.wrapper.zidb.ZiDBTBaseClient;
import com.vng.zing.media.profile.thrift.TProfile;
import com.vng.zing.media.profile.thrift.TProfileResult;
import com.vng.zing.media.profile.thrift.client.ZMediaProfileMWClient;
import com.vng.zing.zcommon.thrift.ECode;
import com.vng.zing.zidb.thrift.wrapper.ZiDBClient;
import java.io.File;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author namnh16
 */
public class ProfileMWTest extends BaseTest {

    private static final ZMediaProfileMWClient PROFILE_CLI = ZMediaClientPoolManager.getZMProfileMWClient();
//    private static final ZiDBTBaseClient ZIDB = new ZiDBTBaseClient(String.class, TProfile.class, "profile");
    private static final ZaloIdMWClient ZALO_CLI = new ZaloIdMWClient("main");

    public static void main(String[] args) throws Exception {
//        File file = FileUtils.getFile("data/zuser_100k_most_recent.csv");
//        List<String> lines = FileUtils.readLines(file, "UTF-8");
//
//        for (String line : lines) {
//            int userId = ConvertUtils.toInteger(line);
//            String key = _getKey(userId);
//            
//            TProfile result = new TProfile();
//            int eCode = ZIDB.get(key, result);
//            
//            if(eCode == -ECode.NOT_EXIST.getValue()){
//                System.out.println(userId + "\t" + eCode);
//            }
//            System.out.println(result.id + "\t" + eCode);
//        }
//
//        System.out.println("Finished");

        int userId = 72519474;
        TProfile profile = PROFILE_CLI.getProfile(userId).value;
        System.out.println(ThriftUtils.getStructAsString(profile));
//        System.out.println(ThriftUtils.getStructAsString(ZALO_CLI.getCompactZProfile(userId).profile.profile));
//        System.out.println(EncryptUtils.denoiseString("KE8CJ1eikKHEoW1R70El2sDlRG"));
//        System.out.println(EncryptUtils.denoiseLong("2c5511a39843621d3b52"));
    }

    private static String _getKey(int userId) {
        return String.format("profile.%d", userId);
    }
}
