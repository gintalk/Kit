package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/02/2021
 */

import com.vng.zing.media.common.thrift.comment.TComment;
import com.vng.zing.media.common.thrift.comment.TCommentApp;
import com.vng.zing.media.common.thrift.comment.TCommentGetType;
import com.vng.zing.media.common.thrift.comment.TCommentReactionType;
import com.vng.zing.media.common.thrift.comment.TCommentSortBy;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.DateTimeUtils;
import com.vng.zing.media.common.utils.EncodeUtils;
import com.vng.zing.media.common.utils.EncryptUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.service.comment.thrift.client.TZMediaCommentServiceClient;
import com.vng.zing.media.service.comment.thrift.req.TAddCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TApproveCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TGetCommentCountReq;
import com.vng.zing.media.service.comment.thrift.req.TGetCommentReactionReq;
import com.vng.zing.media.service.comment.thrift.req.TGetCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TGetCommentSliceReq;
import com.vng.zing.media.service.comment.thrift.req.TGetReplyCountReq;
import com.vng.zing.media.service.comment.thrift.req.TGetReplySliceReq;
import com.vng.zing.media.service.comment.thrift.req.TMGetCommentCountReq;
import com.vng.zing.media.service.comment.thrift.req.TMGetCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TMRejectCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TMRemoveCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TReactCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TRejectCommentReq;
import com.vng.zing.media.service.comment.thrift.req.TRemoveCommentReq;
import com.vng.zing.media.service.comment.thrift.res.TAddCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TApproveCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TGetCommentCountRes;
import com.vng.zing.media.service.comment.thrift.res.TGetCommentReactionRes;
import com.vng.zing.media.service.comment.thrift.res.TGetCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TGetCommentSliceRes;
import com.vng.zing.media.service.comment.thrift.res.TGetReplyCountRes;
import com.vng.zing.media.service.comment.thrift.res.TGetReplySliceRes;
import com.vng.zing.media.service.comment.thrift.res.TMGetCommentCountRes;
import com.vng.zing.media.service.comment.thrift.res.TMGetCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TMRejectCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TMRemoveCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TReactCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TRejectCommentRes;
import com.vng.zing.media.service.comment.thrift.res.TRemoveCommentRes;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CommentServiceTest extends Test {

    private static final TZMediaCommentServiceClient DEF_COMMENT_SERVICE = TZMediaCommentServiceClient.DEFAULT_INST;
    private static final TZMediaCommentServiceClient FEED_COMMENT_SERVICE = TZMediaCommentServiceClient.FEED_INST;

    public static void main(String[] args) {
//        _getComment();
//        _mgetComment();
//        _getCommentSlice();
//        _getReplySlice();
        _getCommentCount();
        _mgetCommentCount();
//        _getReplyCount();
//        _getCommentReaction();
//        _addComment();
//        _removeComment();
//        _mremoveComment();
//        _approveComment();
//        _rejectComment();
//        _mrejectComment();
//        _reactComment();

        System.exit(0);
    }

    private static void _getComment() {
        ThriftUtils.prettyPrint(DEF_COMMENT_SERVICE.getComment(new TGetCommentReq()
                .setAppId(TCommentApp.ZMP3_PLAYLIST.getValue())
                .setCommentId(20069387)
                .setIsFull(true)
        ).comment);
    }

    private static void _mgetComment() {
        print(DEF_COMMENT_SERVICE.mgetComment(new TMGetCommentReq()
                .setAppId(1)
                .setCommentIds(Arrays.asList(17831517, 17830887, 17829469, 17481687, 18803918))
                .setAsList(true)
                .setIsFull(true)
        ));
    }

    private static void _getCommentSlice() {
        print(FEED_COMMENT_SERVICE.getCommentSlice(new TGetCommentSliceReq()
                .setAppId(TCommentApp.ZMP3_NEWS_FEED.getValue())
                .setObjectId(1984461)
                .setStart(0)
                .setCount(100)
                .setGetType(TCommentGetType.N_DAYS.getValue())
                .setSortBy(TCommentSortBy.NEW.getValue())
        ));
    }

    private static void _getReplySlice() {
        print(DEF_COMMENT_SERVICE.getReplySlice(new TGetReplySliceReq()
                .setAppId(1)
                .setParentId(1074764608)
                .setStart(0)
                .setCount(200)
                .setGetType(TCommentGetType.N_DAYS.getValue())
                .setSortBy(TCommentSortBy.NEW.getValue())
        ));
    }

    private static void _getCommentCount() {
        System.out.println(FEED_COMMENT_SERVICE.getCommentCount(new TGetCommentCountReq()
                .setAppId(10)
                .setObjectId(1984461)
                .setGetType(TCommentGetType.N_DAYS.getValue())
        ));
    }

    private static void _mgetCommentCount() {
        System.out.println(FEED_COMMENT_SERVICE.mgetCommentCount(new TMGetCommentCountReq()
                .setAppId(10)
                .setObjectIds(Arrays.asList(1984461, 1984423, 1984442, 1984435, 1984494, 1984481, 1984474, 1984469, 1984458, 1984452))
                .setGetType(TCommentGetType.N_DAYS.getValue())
        ));
    }

    private static void _getReplyCount() {
        print(DEF_COMMENT_SERVICE.getReplyCount(new TGetReplyCountReq()
                .setAppId(1)
                .setParentId(18842171)
                .setGetType(TCommentGetType.N_DAYS.getValue())
        ));
    }

    private static void _getCommentReaction() {
        print(DEF_COMMENT_SERVICE.getCommentReaction(new TGetCommentReactionReq()
                .setAppId(1)
                .setUserId(NAMNH16_ZMP3_ID)
                .setCommentIds(Arrays.asList(18815943))
        ));
    }

    private static void _addComment() {
        TComment comment = new TComment()
                .setUserId(1063651908)
                .setAppId(TCommentApp.ZMEDIA_TEST.getValue())
                .setContent("nghe hoài ko chán hihi")
                .setObjectId(1)
                .setTime(DateTimeUtils.currentTimeSeconds());

        print(DEF_COMMENT_SERVICE.addComment(new TAddCommentReq()
                .setCountryCode(84)
                .setValue(comment)
        ));
    }

    private static void _removeComment() {
        print(DEF_COMMENT_SERVICE.removeComment(new TRemoveCommentReq()
                .setAppId(TCommentApp.ZMP3_SONG.getValue())
                .setUserId(1060037713)
                .setCommentId(19890605)
        ));
    }

    private static void _mremoveComment() {
        System.out.println(DEF_COMMENT_SERVICE.mremoveComment(new TMRemoveCommentReq()
                .setAppId(7)
                .setUserId(1063059252)
                .setCommentIds(Arrays.asList(18727780))
        ));
    }

    private static void _approveComment() {
        for (int commentId : Arrays.asList(9021712, 9021711)) {
            print(FEED_COMMENT_SERVICE.approveComment(new TApproveCommentReq()
                    .setAppId(TCommentApp.ZMP3_NEWS_FEED.getValue())
                    .setCommentId(commentId)
            ));
        }
    }

    private static void _mapproveComment() {
        // Service chưa support
    }

    private static void _rejectComment() {
        print(DEF_COMMENT_SERVICE.rejectComment(new TRejectCommentReq()
                .setAppId(1)
                .setCommentId(20399481)
        ));
    }

    private static void _mrejectComment() {
        print(DEF_COMMENT_SERVICE.mrejectComment(new TMRejectCommentReq()
                .setAppId(9)
                .setCommentIds(Arrays.asList(
                        18843885, 18843883, 18843882, 18843881,
                        18843886,
                        18843901, 18843899, 18843898, 18843893
                ))
        ));
    }

    private static void _reactComment() {
        print(FEED_COMMENT_SERVICE.reactComment(new TReactCommentReq()
                .setAppId(10)
                .setUserId(NAMNH16_ZMP3_ID)
                .setCommentId(18823352) // 18823352
                .setReactionType(TCommentReactionType.LIKE.getValue())
                .setIsUndo(false)
        ));
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Print
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static void print(TGetCommentRes res) {
        System.out.println("Error " + res.error);
        System.out.println("===== Comment =====");
        System.out.println(res.comment.time);
        ThriftUtils.prettyPrint(res.comment);
        if (!CommonUtils.isEmpty(res.replies)) {
            System.out.println("===== Reply =====");
            for (TComment reply : res.replies) {
                ThriftUtils.prettyPrint(reply);
            }
        }
    }

    private static void print(TMGetCommentRes res) {
        System.out.println("Error " + res.error);
        if (!CommonUtils.isEmpty(res.dataList)) {
            for (TComment comment : res.dataList) {
                ThriftUtils.prettyPrint(comment);
            }
            return;
        }

        if (!CommonUtils.isEmpty(res.dataMap)) {
            for (Map.Entry<Integer, TComment> entry : res.dataMap.entrySet()) {
                ThriftUtils.prettyPrint(entry.getValue());
            }
        }
    }

    private static void print(TGetCommentSliceRes res) {
        System.out.println("Error " + res.error);
        System.out.println("Total " + res.total);
        int actualTotal = res.values.size();
        for (Map.Entry<Integer, List<TComment>> entry : res.replyMap.entrySet()) {
            actualTotal += entry.getValue().size();
        }
        System.out.println("Actual Total: Parent " + res.values.size() + ". Parent+Reply " + actualTotal);
        for (TComment comment : res.values) {
            System.out.println("===== Comment =====");
            ThriftUtils.prettyPrint(comment);
            List<TComment> replies = res.replyMap.get(comment.commentId);
            if (!CommonUtils.isEmpty(replies)) {
                System.out.println("========== Reply ==========");
                for (TComment reply : replies) {
                    ThriftUtils.prettyPrint(reply);
                }
            }
        }
    }

    private static void print(TGetReplySliceRes res) {
        System.out.println("Error " + res.error);
        System.out.println("Total " + res.total);
        System.out.println("Actual Total " + res.values.size());
        for (TComment comment : res.values) {
            ThriftUtils.prettyPrint(comment);
        }
    }

    private static void print(TGetCommentCountRes res) {
        System.out.println("Error " + res.error);
        System.out.println("Value " + res.value);
    }

    private static void print(TMGetCommentCountRes res) {
        System.out.println("Error " + res.error);
        for (Map.Entry<Integer, Integer> entry : res.dataMap.entrySet()) {
            System.out.println("Object " + entry.getKey() + " Total " + entry.getValue());
        }
    }

    private static void print(TGetReplyCountRes res) {
        System.out.println("Error " + res.error);
        System.out.println("Value " + res.value);
    }

    private static void print(TGetCommentReactionRes res) {
        System.out.println("Error " + res.error);
        for (Map.Entry<Integer, List<Integer>> entry : res.dataMap.entrySet()) {
            System.out.println(TCommentReactionType.findByValue(entry.getKey()) + ": " + entry.getValue());
        }
    }

    private static void print(TAddCommentRes res) {
        System.out.println("Error " + res.error);
    }

    private static void print(TRemoveCommentRes res) {
        System.out.println("Error " + res.error);
    }

    private static void print(TMRemoveCommentRes res) {
        System.out.println("Error " + res.error);
    }

    private static void print(TApproveCommentRes res) {
        System.out.println("Error " + res.error);
    }

    private static void print(TRejectCommentRes res) {
        System.out.println("Error " + res.error);
    }

    private static void print(TMRejectCommentRes res) {
        System.out.println("Error " + res.error);
    }

    private static void print(TReactCommentRes res) {
        System.out.println("Error " + res.error);
    }
}
