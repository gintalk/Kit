//package com.vng.zing.media.mp3.test.kit.test.service;
//
///*
// * Copyright (c) 2012-2016 by Zalo Group.
// * All Rights Reserved.
// *
// * @author namnh16 on 25/01/2021
// */
//
//import com.vng.zing.media.common.thrift.comment.TComment;
//import com.vng.zing.media.common.thrift.comment.TCommentApp;
//import com.vng.zing.media.common.thrift.comment.TCommentStatus;
//import com.vng.zing.media.common.thrift.comment.TStatus;
//import com.vng.zing.media.mw.comment.thrift.client.TZMediaCommentMWClient;
//import com.vng.zing.media.mw.comment.thrift.req.TGetCommentMWReq;
//import com.vng.zing.media.mw.comment.thrift.req.TMGetCommentMWReq;
//import com.vng.zing.media.mw.comment.thrift.req.TPutCommentMWReq;
//
//import java.util.Arrays;
//
//public class NewCommentMWTest extends BaseTest{
//
//    private static final TZMediaCommentMWClient DEFAULT = TZMediaCommentMWClient.DEFAULT_INST;
//    private static final TZMediaCommentMWClient FEED = TZMediaCommentMWClient.FEED_INST;
//
//    public static void main(String[] args) {
////        TComment comment = new TComment()
////                .setCommentId(4)
////                .setApp(TCommentApp.ZMP3_SONG)
////                .setContent("Test comment 4")
////                .setObjectId(2)
////                .setStatus(TStatus.AUTO_APPROVED)
////                .setUserId(4);
//
////        System.out.println(DEFAULT.putComment(new TPutCommentMWReq().setComment(comment)));
//        System.out.println(FEED.getComment(new TGetCommentMWReq().setCommentId(4)));
////        System.out.println(FEED.mgetComment(new TMGetCommentMWReq().setCommentIds(Arrays.asList(1,2))));
//    }
//}
