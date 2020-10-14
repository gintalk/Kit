/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.comment.thrift.TComment;
import com.vng.zing.media.comment.thrift.TCommentAddReq;
import com.vng.zing.media.comment.thrift.TCommentApp;
import com.vng.zing.media.comment.thrift.TCommentGetReq;
import com.vng.zing.media.comment.thrift.TCommentGetSliceReq;
import com.vng.zing.media.comment.thrift.TCommentMultiGetReq;
import com.vng.zing.media.comment.thrift.TCommentResult;
import com.vng.zing.media.comment.thrift.TGetType;
import com.vng.zing.media.comment.thrift.TListCommentResult;
import com.vng.zing.media.comment.thrift.TSortBy;
import com.vng.zing.media.comment.thrift.TStatus;
import com.vng.zing.media.comment.thrift.TVoteResult;
import com.vng.zing.media.comment.thrift.client.ZMediaCommentMWClient;
import com.vng.zing.media.common.thrift.TCountry;
import com.vng.zing.media.common.thrift.TCountryCode;
import com.vng.zing.media.common.thrift.TI32ListResult;
import com.vng.zing.media.common.thrift.TI32Result;
import com.vng.zing.media.common.thrift.TUpdateSourceType;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.common.utils.WhiteListUserUtils;
import com.vng.zing.media.mp3.common.thrift.TMP3ItemType;

/**
 *
 * @author namnh16
 */
public class CommentMWTest extends BaseTest {

    private static final ZMediaCommentMWClient defaultClient = ZMediaCommentMWClient.INST_DEFAULT;
    private static final ZMediaCommentMWClient feedClient = ZMediaCommentMWClient.INST_FEED;

    public static void main(String[] args) {
        ZMediaCommentMWClient client = defaultClient;

        TCommentApp app = TCommentApp.ZINGMP3_SONG;
        int objectId = 1079234134;

//        System.out.println(ThriftUtils.getStructAsString(client.fullGet(app, 18210410).comment));
//        System.out.println(client.getSliceReplies(new TCommentGetSliceReq().setApp(app).setStart(0).setCount(200).setSortBy(TSortBy.NEW).setGetType(TGetType.ALL).setCommentId(16961390)));
        _printAll(client.getSlice(new TCommentGetSliceReq().setApp(app).setCount(200).setStart(0).setSortBy(TSortBy.TOP).setGetType(TGetType.N_DAYS).setObjectId(objectId)));
//        System.out.println(client.approve(app, 17844684));
//        System.out.println(client.systemMultiRemove(app, Arrays.asList(17424381)));
//        System.out.println(client.reject(app, 17925798));

//        for(int i=1; i<2; i++){
//            TComment comment = new TComment()
//                    .setContent("A lô 1 2 3 4")
//                    .setApp(app)
//                    .setObjectId(objectId)
//                    .setStatus(TStatus.AUTO_APPROVED)
//                    .setUserId(WhiteListUserUtils.NAMNH16);
//            
//            TCommentAddReq req = new TCommentAddReq()
//                    .setComment(comment)
//                    .setIpCode(TCountry.VIETNAM.getValue());
//            
//            System.out.println(client.add(req));
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

        System.out.println(listCommentResult);
        System.out.println(CommonUtils.buildTabLog("success", listCommentResult.getTotal()));

        if (listCommentResult.getComments() == null) {
            return;
        }

//        int i=0;
        for (TComment comment : listCommentResult.getComments()) {
            System.out.println(comment);
//            i++;
        }
//        System.out.println(i);
//        return i;
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

    protected static void _printAll(int errorCode) {
        _printAll(new TI32Result(errorCode));
    }
}
