package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 15/12/2022
 */

import com.vng.zing.media.alert.service.thrift.TAlertMessageContentType;
import com.vng.zing.media.alert.service.thrift.TMessageListItem;
import com.vng.zing.media.alert.service.thrift.TMessageListItemActionType;
import com.vng.zing.media.alert.service.thrift.TMessageListItemType;
import com.vng.zing.media.alert.service.thrift.TMessageReq;
import com.vng.zing.media.alert.service.thrift.client.TZMediaAlertServiceClient;
import com.vng.zing.media.commonlib.thrift.TOA;

import java.util.Arrays;
import java.util.Collections;

public class AlertTest extends Test {

    private static final TZMediaAlertServiceClient SERVICE = TZMediaAlertServiceClient.INST;

    public static void main(String[] args) {
        System.out.println(TZMediaAlertServiceClient.INST.message(new TMessageReq()
                .setOa(TOA.ZING_MP3.getValue())
                .setContentType(TAlertMessageContentType.LIST.getValue())
                .setListItemType(TMessageListItemType.ELEMENT.getValue())
                .setListItems(Arrays.asList(
                        new TMessageListItem()
                                .setTitle("Official Account API")
                                .setSubtitle("There is no limit")
                                .setImageURL("https://stc-developers.zdn.vn/images/bg_1.jpg")
                                .setActionType(TMessageListItemActionType.OPEN_URL.getValue())
                                .setActionURL("https://developers.zalo.me/docs/api/official-account-api-147"),
                        new TMessageListItem()
                                .setTitle("Article API")
                                .setImageURL("https://stc-developers.zdn.vn/images/bg_1.jpg")
                                .setActionType(TMessageListItemActionType.OPEN_URL.getValue())
                                .setActionURL("https://developers.zalo.me/docs/api/article-api-151"),
                        new TMessageListItem()
                                .setTitle("Social API")
                                .setImageURL("https://stc-developers.zdn.vn/images/bg_1.jpg")
                                .setActionType(TMessageListItemActionType.OPEN_URL.getValue())
                                .setActionURL("https://developers.zalo.me/docs/api/article-api-151"),
                        new TMessageListItem()
                                .setTitle("Shop API")
                                .setImageURL("https://stc-developers.zdn.vn/images/bg_1.jpg")
                                .setActionType(TMessageListItemActionType.OPEN_URL.getValue())
                                .setActionURL("https://developers.zalo.me/docs/api/shop-api-124")
                ))
                .setIds(Collections.singletonList(NAMNH16_ZALO_ID))
                .setNoGrouping(true)
        ));

//        System.out.println(SERVICE.alert(new TAlertReq()
//                        .setOa(TOA.ZMP3_OPERATION.getValue())
//                        .setType(TAlertType.INFO.getValue())
//                        .setMessage("- [MSCM] Client ZMP3SearchStorage instance main get config service ZMP3CoreMW using auto config! Set permission at https://sys-adm.zingmp3.vn/mscm-permission/index?client-app=ZMP3SearchStorage")
//                        .setContentType(TAlertMessageContentType.TEXT.getValue())
//                        .setCustomTag("mScm")
//                        .setReceiverType(Integer.MIN_VALUE)
//                        .setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue())
//                        .setIds(Collections.singletonList(NAMNH16_ZALO_ID))
//        ));

//            System.out.println(SERVICE.alert(new TAlertReq()
//                    .setOaName("ZMediaServerDev")
//                    .setType(TAlertType.INFO.getValue())
//                    .setMessage("https://brcast-msg-photo.zadn.vn/4498930889561591141/3b91489bfad813864ac9.jpg")
//                    .setCustomTag("image.song.web_desktop")
//                    .setReceiverType(Integer.MIN_VALUE)
//                    .setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue())
//                    .setContentType(TAlertMessageContentType.IMAGE.getValue())
//                    .setIds(Arrays.asList(NAMNH16_ZALO_ID, 141302192))
//            ));
//
//            System.out.println(SERVICE.alert(new TAlertReq()
//                    .setOaName("ZMediaServerDev")
//                    .setType(TAlertType.INFO.getValue())
//                    .setMessage("https://brcast-msg-photo.zadn.vn/3247526593753160225/3c2a4d20ff63163d4f72.jpg")
//                    .setCustomTag("image.song.app_ios")
//                    .setReceiverType(Integer.MIN_VALUE)
//                    .setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue())
//                    .setContentType(TAlertMessageContentType.IMAGE.getValue())
//                    .setIds(Arrays.asList(NAMNH16_ZALO_ID, 141302192))
//            ));
//
//            System.out.println(SERVICE.alert(new TAlertReq()
//                    .setOaName("ZMediaServerDev")
//                    .setType(TAlertType.INFO.getValue())
//                    .setMessage("https://brcast-msg-photo.zadn.vn/4855503700124277626/59312f3b9d7874262d69.jpg")
//                    .setCustomTag("image.song.app_android")
//                    .setReceiverType(Integer.MIN_VALUE)
//                    .setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue())
//                    .setContentType(TAlertMessageContentType.IMAGE.getValue())
//                    .setIds(Arrays.asList(NAMNH16_ZALO_ID, 141302192))
//            ));
//
//            System.out.println(SERVICE.alert(new TAlertReq()
//                    .setOaName("ZMediaServerDev")
//                    .setType(TAlertType.INFO.getValue())
//                    .setMessage("https://brcast-msg-photo.zadn.vn/4696399144979048412/e3c594cf268ccfd2969d.jpg")
//                    .setCustomTag("image.song.app")
//                    .setReceiverType(Integer.MIN_VALUE)
//                    .setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue())
//                    .setContentType(TAlertMessageContentType.IMAGE.getValue())
//                    .setIds(Arrays.asList(NAMNH16_ZALO_ID, 141302192))
//            ));
//
//            System.out.println(SERVICE.alert(new TAlertReq()
//                    .setOaName("ZMediaServerDev")
//                    .setType(TAlertType.INFO.getValue())
//                    .setMessage("PLAY SOURCE\n" +
//                            "08:00-08:59 Saturday 17/12\n" +
//                            "----------------------------------------\n" +
//                            "LAST WEEK\n" +
//                            "\tDesk\n" +
//                            "\t\tMy Music: 2.5K (-3.4%) = 11.5K (+2.9%)\n" +
//                            "\t\tChart: 2.6K (+3.4%) = 9.3K (+8.1%)\n" +
//                            "\t\tHome: 8.8K (+12.6%) = 23.6K (+14.2%)\n" +
//                            "\t\tHome Monitor: 8.8K (+12.6%) = 23.6K (+14.2%)\n" +
//                            "\t\tSearch: 7.4K (+12.0%) = 25.1K (+8.8%)\n" +
//                            "\t\tSimilar: 12.4K (N/A) = 58.2K (N/A)\n" +
//                            "\t\tUnknown: 9.7K (-2.8%) = 31.3K (+4.5%)\n" +
//                            "\tAndroid\n" +
//                            "\t\tMy Music: 769.5K (+2.5%) = 5.5M (+7.8%)\n" +
//                            "\t\tChart: 77.5K (+2.4%) = 574.4K (+12.4%)\n" +
//                            "\t\tHome: 239.7K (+7.8%) = 1.5M (+15.0%)\n" +
//                            "\t\tHome Monitor: 67.4K (+11.1%) = 408K (+21.1%)\n" +
//                            "\t\tSearch: 175.7K (+3.6%) = 1.2M (+9.3%)\n" +
//                            "\t\tSimilar: 286.8K (+6.0%) = 2.2M (+10.7%)\n" +
//                            "\t\tUnknown: 36K (+11.6%) = 200.4K (+7.4%)\n" +
//                            "\tiOS\n" +
//                            "\t\tMy Music: 512.3K (+6.3%) = 3.3M (+10.2%)\n" +
//                            "\t\tChart: 57.5K (+4.0%) = 358K (+12.2%)\n" +
//                            "\t\tHome: 185.3K (+9.9%) = 1M (+15.7%)\n" +
//                            "\t\tHome Monitor: 55.3K (+11.1%) = 275.2K (+18.4%)\n" +
//                            "\t\tSearch: 120K (+8.1%) = 779.9K (+13.3%)\n" +
//                            "\t\tSimilar: 133.4K (+6.4%) = 984.4K (+14.5%)\n" +
//                            "\t\tUnknown: 20.9K (+10.2%) = 98.3K (+10.8%)")
//                    .setCustomTag("text.song.source")
//                    .setReceiverType(Integer.MIN_VALUE)
//                    .setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue())
//                    .setContentType(TAlertMessageContentType.TEXT.getValue())
//                    .setIds(Arrays.asList(NAMNH16_ZALO_ID, 141302192))
//            ));
//
//            System.out.println(SERVICE.alert(new TAlertReq()
//                    .setOaName("ZMediaServerDev")
//                    .setType(TAlertType.INFO.getValue())
//                    .setMessage("PLAY SONG\n" +
//                            "08:00-08:59 Saturday 17/12\n" +
//                            "----------------------------------------\n" +
//                            "LAST WEEK\n" +
//                            "\tTotal: 2.8M (+5.0%) = 18.4M (+10.2%)\n" +
//                            "\tDesk: 51.8K (+5.9%) = 189K (+6.4%)\n" +
//                            "\tAndroid: 1.7M (+3.9%) = 11.5M (+9.3%)\n" +
//                            "\tiOS: 1M (+6.8%) = 6.7M (+11.8%)\n" +
//                            "----------------------------------------\n" +
//                            "YESTERDAY\n" +
//                            "\tTotal: 2.8M (+3.8%) = 18.4M (+2.6%)\n" +
//                            "\tDesk: 51.8K (-16.2%) = 189K (-7.1%)\n" +
//                            "\tAndroid: 1.7M (+4.4%) = 11.5M (+3.9%)\n" +
//                            "\tiOS: 1M (+4.0%) = 6.7M (+0.8%)")
//                    .setCustomTag("text.song.all")
//                    .setReceiverType(Integer.MIN_VALUE)
//                    .setDetailType(TAlertMessageDetailType.CONTENT_MESSAGE.getValue())
//                    .setContentType(TAlertMessageContentType.TEXT.getValue())
//                    .setIds(Arrays.asList(NAMNH16_ZALO_ID, 141302192))
//            ));

        System.exit(0);
    }
}
