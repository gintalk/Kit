package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/02/2021
 */

public class CommentServiceTest extends Test {

//    private static final TZMediaCommentServiceClient DEF_COMMENT_SERVICE = TZMediaCommentServiceClient.DEFAULT_INST;
//    private static final TZMediaCommentServiceClient FEED_COMMENT_SERVICE = TZMediaCommentServiceClient.FEED_INST;
//
//    public static void main(String[] args) {
////        _getComment();
////        _mgetComment();
//        _getCommentSlice();
////        _getReplySlice();
////        _getCommentCount();
////        _mgetCommentCount();
////        _getReplyCount();
////        _getCommentReaction();
////        _addComment();
////        _removeComment();
////        _mremoveComment();
////        _approveComment();
////        _rejectComment();
////        _mrejectComment();
////        _reactComment();
//
//        System.exit(0);
//    }
//
//    private static void _getComment() {
//        ThriftUtils.prettyPrint(DEF_COMMENT_SERVICE.getComment(new TGetCommentReq()
//                .setAppId(TCommentApp.ZMP3_SONG.getValue())
//                .setCommentId(20592017)
//                .setIsFull(true)
//        ).comment);
//    }
//
//    private static void _mgetComment() {
//        print(DEF_COMMENT_SERVICE.mgetComment(new TMGetCommentReq()
//                .setAppId(1)
//                .setCommentIds(Arrays.asList(17831517, 17830887, 17829469, 17481687, 18803918))
//                .setAsList(true)
//                .setIsFull(true)
//        ));
//    }
//
//    private static void _getCommentSlice() {
//        print(DEF_COMMENT_SERVICE.getCommentSlice(new TGetCommentSliceReq()
//                .setAppId(TCommentApp.ZMP3_PODCAST_EPISODE.getValue())
//                .setObjectId(1124595032)
//                .setStart(0)
//                .setCount(20)
//                .setGetType(TCommentGetType.N_DAYS.getValue())
//                .setSortBy(TCommentSortBy.NEW.getValue())
//        ));
//    }
//
//    private static void _getReplySlice() {
//        print(DEF_COMMENT_SERVICE.getReplySlice(new TGetReplySliceReq()
//                .setAppId(1)
//                .setParentId(1074764608)
//                .setStart(0)
//                .setCount(200)
//                .setGetType(TCommentGetType.N_DAYS.getValue())
//                .setSortBy(TCommentSortBy.NEW.getValue())
//        ));
//    }
//
//    private static void _getCommentCount() {
//        print(DEF_COMMENT_SERVICE.getCommentCount(new TGetCommentCountReq()
//                .setAppId(12)
//                .setObjectId(1127256743)
//                .setGetType(TCommentGetType.N_DAYS.getValue())
//        ));
//    }
//
//    private static void _mgetCommentCount() {
//        print(FEED_COMMENT_SERVICE.mgetCommentCount(new TMGetCommentCountReq()
//                .setAppId(10)
//                .setObjectIds(Arrays.asList(1739266, 1737550, 1738761, 1736712))
//                .setGetType(TCommentGetType.N_DAYS.getValue())
//        ));
//    }
//
//    private static void _getReplyCount() {
//        print(DEF_COMMENT_SERVICE.getReplyCount(new TGetReplyCountReq()
//                .setAppId(1)
//                .setParentId(18842171)
//                .setGetType(TCommentGetType.N_DAYS.getValue())
//        ));
//    }
//
//    private static void _getCommentReaction() {
//        print(DEF_COMMENT_SERVICE.getCommentReaction(new TGetCommentReactionReq()
//                .setAppId(1)
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setCommentIds(Arrays.asList(18815943))
//        ));
//    }
//
//    private static void _addComment() {
//        TComment comment = new TComment()
//                .setUserId(1063651908)
//                .setAppId(TCommentApp.ZMEDIA_TEST.getValue())
//                .setContent("nghe hoài ko chán hihi")
//                .setObjectId(1)
//                .setTime(DateTimeUtils.currentTimeSeconds());
//
//        print(DEF_COMMENT_SERVICE.addComment(new TAddCommentReq()
//                .setCountryCode(84)
//                .setValue(comment)
//        ));
//    }
//
//    private static void _removeComment() {
//        print(DEF_COMMENT_SERVICE.removeComment(new TRemoveCommentReq()
//                .setAppId(TCommentApp.ZMP3_SONG.getValue())
//                .setUserId(1060037713)
//                .setCommentId(19890605)
//        ));
//    }
//
//    private static void _mremoveComment() {
//        // Service chưa support
//    }
//
//    private static void _approveComment() {
//        for (int commentId : Arrays.asList(9021712, 9021711)) {
//            print(FEED_COMMENT_SERVICE.approveComment(new TApproveCommentReq()
//                    .setAppId(TCommentApp.ZMP3_NEWS_FEED.getValue())
//                    .setCommentId(commentId)
//            ));
//        }
//    }
//
//    private static void _mapproveComment() {
//        // Service chưa support
//    }
//
//    private static void _rejectComment() {
//        print(DEF_COMMENT_SERVICE.rejectComment(new TRejectCommentReq()
//                .setAppId(1)
//                .setCommentId(20399481)
//        ));
//    }
//
//    private static void _mrejectComment() {
//        print(DEF_COMMENT_SERVICE.mrejectComment(new TMRejectCommentReq()
//                .setAppId(9)
//                .setCommentIds(Arrays.asList(
//                        18843885, 18843883, 18843882, 18843881,
//                        18843886,
//                        18843901, 18843899, 18843898, 18843893
//                ))
//        ));
//    }
//
//    private static void _reactComment() {
//        print(FEED_COMMENT_SERVICE.reactComment(new TReactCommentReq()
//                .setAppId(10)
//                .setUserId(NAMNH16_ZMP3_ID)
//                .setCommentId(18823352) // 18823352
//                .setReactionType(TCommentReactionType.LIKE.getValue())
//                .setIsUndo(false)
//        ));
//    }
//
//    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    // Print
//    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    private static void print(TGetCommentRes res) {
//        System.out.println("Error " + res.error);
//        System.out.println("===== Comment =====");
//        System.out.println(res.comment.time);
//        ThriftUtils.prettyPrint(res.comment);
//        if (!CommonUtils.isEmpty(res.replies)) {
//            System.out.println("===== Reply =====");
//            for (TComment reply : res.replies) {
//                ThriftUtils.prettyPrint(reply);
//            }
//        }
//    }
//
//    private static void print(TMGetCommentRes res) {
//        System.out.println("Error " + res.error);
//        if (!CommonUtils.isEmpty(res.dataList)) {
//            for (TComment comment : res.dataList) {
//                ThriftUtils.prettyPrint(comment);
//            }
//            return;
//        }
//
//        if (!CommonUtils.isEmpty(res.dataMap)) {
//            for (Map.Entry<Integer, TComment> entry : res.dataMap.entrySet()) {
//                ThriftUtils.prettyPrint(entry.getValue());
//            }
//        }
//    }
//
//    private static void print(TGetCommentSliceRes res) {
//        System.out.println("Error " + res.error);
//        System.out.println("Total " + res.total);
//        int actualTotal = res.values.size();
//        for (Map.Entry<Integer, List<TComment>> entry : res.replyMap.entrySet()) {
//            actualTotal += entry.getValue().size();
//        }
//        System.out.println("Actual Total: Parent " + res.values.size() + ". Parent+Reply " + actualTotal);
//        for (TComment comment : res.values) {
//            System.out.println("===== Comment =====");
//            ThriftUtils.prettyPrint(comment);
//            List<TComment> replies = res.replyMap.get(comment.commentId);
//            if (!CommonUtils.isEmpty(replies)) {
//                System.out.println("========== Reply ==========");
//                for (TComment reply : replies) {
//                    ThriftUtils.prettyPrint(reply);
//                }
//            }
//        }
//    }
//
//    private static void print(TGetReplySliceRes res) {
//        System.out.println("Error " + res.error);
//        System.out.println("Total " + res.total);
//        System.out.println("Actual Total " + res.values.size());
//        for (TComment comment : res.values) {
//            ThriftUtils.prettyPrint(comment);
//        }
//    }
//
//    private static void print(TGetCommentCountRes res) {
//        System.out.println("Error " + res.error);
//        System.out.println("Value " + res.value);
//    }
//
//    private static void print(TMGetCommentCountRes res) {
//        System.out.println("Error " + res.error);
//        for (Map.Entry<Integer, Integer> entry : res.dataMap.entrySet()) {
//            System.out.println("Object " + entry.getKey() + " Total " + entry.getValue());
//        }
//    }
//
//    private static void print(TGetReplyCountRes res) {
//        System.out.println("Error " + res.error);
//        System.out.println("Value " + res.value);
//    }
//
//    private static void print(TGetCommentReactionRes res) {
//        System.out.println("Error " + res.error);
//        for (Map.Entry<Integer, List<Integer>> entry : res.dataMap.entrySet()) {
//            System.out.println(TCommentReactionType.findByValue(entry.getKey()) + ": " + entry.getValue());
//        }
//    }
//
//    private static void print(TAddCommentRes res) {
//        System.out.println("Error " + res.error);
//    }
//
//    private static void print(TRemoveCommentRes res) {
//        System.out.println("Error " + res.error);
//    }
//
//    private static void print(TMRemoveCommentRes res) {
//        System.out.println("Error " + res.error);
//    }
//
//    private static void print(TApproveCommentRes res) {
//        System.out.println("Error " + res.error);
//    }
//
//    private static void print(TRejectCommentRes res) {
//        System.out.println("Error " + res.error);
//    }
//
//    private static void print(TMRejectCommentRes res) {
//        System.out.println("Error " + res.error);
//    }
//
//    private static void print(TReactCommentRes res) {
//        System.out.println("Error " + res.error);
//    }
}
