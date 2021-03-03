/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import java.util.List;
import java.util.Map;


import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.comment.thrift.*;
import com.vng.zing.media.comment.thrift.client.ZMediaCommentMWClient;
import com.vng.zing.media.common.thrift.TI32ListResult;
import com.vng.zing.media.common.thrift.TI32Result;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ThriftUtils;

/**
 *
 * @author namnh16
 */
public class CommentMWTest extends BaseTest {

    private static final ZMediaCommentMWClient defaultClient = new ZMediaCommentMWClient("main-default");
    private static final ZMediaCommentMWClient feedClient = new ZMediaCommentMWClient("main-feed");

    public static void main(String[] args) {
        ZMediaCommentMWClient client = defaultClient;
        TCommentApp app = TCommentApp.ZINGMP3_SONG;
        int objectId = 1093623782;

        System.out.println(ThriftUtils.INST.toString(client.get(app, 18847112).comment));
//        _printAll(client.getSlice(new TCommentGetSliceReq().setApp(app).setCount(200).setStart(0).setSortBy(TSortBy.NEW).setGetType(TGetType.N_DAYS).setObjectId(objectId)));
//        System.out.println(com.vng.zing.media.mp3.test.kit.test.client.multiGetCommentCount(new TCommentMultiGetReq().setApp(app).setGetType(TGetType.ALL).setObjectIds(Arrays.asList(2,3))));
//        for(int i=0; i<10000; i++){
//            int size = com.vng.zing.media.mp3.test.kit.test.client.getSlice(new TCommentGetSliceReq().setApp(app).setCount(200).setStart(0).setSortBy(TSortBy.NEW).setGetType(TGetType.N_DAYS).setObjectId(objectId)).comments.size();
//            if(size != 4){
//                System.out.println(size);
//            }
//        }
//        System.out.println(com.vng.zing.media.mp3.test.kit.test.client.getCommentCount(new TCommentGetReq().setApp(app).setObjectId(objectId).setGetType(TGetType.N_DAYS)));
//        System.out.println(com.vng.zing.media.mp3.test.kit.test.client.approve(app, 17844684));
//        System.out.println(com.vng.zing.media.mp3.test.kit.test.client.systemMultiRemove(app, Arrays.asList(9021399, 9021397)));
//        System.out.println(com.vng.zing.media.mp3.test.kit.test.client.reject(app, 17925798));
//        System.out.println(com.vng.zing.media.mp3.test.kit.test.client.unReact(app, TReactType.LIKE, WhiteListUserUtils.TRUONGDT, 18309028));

//        for (int i = 1; i <= 100; i++) {
//            TComment comment = new TComment()
//                    .setApp(app)
//                    .setContent("test 101")
//                    .setObjectId(objectId)
//                    .setStatus(TStatus.AUTO_APPROVED)
//                    .setTime((int) (1893430800))
//                    .setUserId(WhiteListUserUtils.NAMNH16);
//
//            System.out.println(com.vng.zing.media.mp3.test.kit.test.client.add(new TCommentAddReq().setComment(comment).setIpCode(84)));
//
//            ZUtil.sleep(1000);
//        }
    }

    protected static void _printAll(TVoteResult voteResult) {
        if (voteResult == null || ZErrorHelper.isFail(voteResult.getError())) {
            System.err.println(CommonUtils.buildTabLog("fail", voteResult));

            return;
        }

        System.out.println(CommonUtils.buildTabLog("success", voteResult.getVotes()));

        if (voteResult.getVotes() == null) {
            return;
        }

        for (Map.Entry<Integer, List<Integer>> mapVote : voteResult.getVotes().entrySet()) {
            System.out.println(mapVote.getKey() + ": " + mapVote.getValue());
        }
    }

    protected static void _printAll(TListCommentResult listCommentResult) {
        if (listCommentResult == null || ZErrorHelper.isFail(listCommentResult.getError())) {
            System.err.println(CommonUtils.buildTabLog("fail", listCommentResult));

            return;
        }

        System.out.println(CommonUtils.buildTabLog("success", listCommentResult.getTotal()));

        if (listCommentResult.getComments() == null) {
            return;
        }

        for (TComment comment : listCommentResult.getComments()) {
            System.out.printf("id: %d, replyOnId: %d, time: %d, numReply: %d, numUpvote: %d, score: %d, content: %s\n", comment.commentId, comment.replyOnId, comment.time, comment.numReply, comment.numUpVotes, comment.score, comment.content);
        }
    }

    protected static void _printAll(TCommentResult commentResult) {
        if (commentResult == null || ZErrorHelper.isFail(commentResult.getError())) {
            System.err.println(CommonUtils.buildTabLog("fail", commentResult));
            return;
        }

        System.out.println(CommonUtils.buildTabLog("success"));

        if (commentResult.getComment() == null) {
            return;
        }

        System.out.println(commentResult.getComment());

        if (commentResult.getReplies() == null || CommonUtils.isEmpty(commentResult.getReplies())) {
            return;
        }

        for (TComment reply : commentResult.getReplies()) {
            System.out.println("Reply: " + reply);
        }

    }

    protected static void _printAll(TI32ListResult result) {
        if (ZErrorHelper.isFail(result.getError())) {
            System.err.println(CommonUtils.buildTabLog("fail", result));

            return;
        }

        System.out.println(CommonUtils.buildTabLog("success", result.getTotal()));

        for (Integer integer : result.values) {
            System.out.println(integer);
        }
    }

    protected static void _printAll(List<TI32ListResult> listListResult) {
        for (TI32ListResult listResult : listListResult) {
            if (ZErrorHelper.isFail(listResult.error)) {
                System.err.println(CommonUtils.buildTabLog("fail", listResult));
            } else {
                System.out.println(CommonUtils.buildTabLog("success", listResult.total));

                for (Integer integer : listResult.values) {
                    System.out.println(integer);
                }
            }
        }
    }

    protected static void _printAll(TI32Result result) {
        if (ZErrorHelper.isFail(result.getError())) {
            System.err.println(CommonUtils.buildTabLog("fail", result));

            return;
        }

        System.out.println(CommonUtils.buildTabLog("success", result));
    }
}
