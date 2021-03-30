/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.common.thrift.comment.TComment;
import com.vng.zing.media.common.thrift.comment.TCommentApp;
import com.vng.zing.media.common.utils.ThriftUtils;
import com.vng.zing.media.mw.comment.thrift.client.TZMediaCommentMWClient;
import com.vng.zing.media.mw.comment.thrift.req.TGetCommentIdSliceMWReq;
import com.vng.zing.media.mw.comment.thrift.req.TGetCommentMWReq;
import com.vng.zing.media.mw.comment.thrift.req.TPutCommentMWReq;
import com.vng.zing.media.mw.comment.thrift.res.TGetCommentIdSliceMWRes;

import java.util.List;

/**
 *
 * @author namnh16
 */
public class CommentMWTest extends BaseTest {

    private static final TZMediaCommentMWClient DEF_MW = TZMediaCommentMWClient.DEFAULT_INST;
    private static final TZMediaCommentMWClient FEED_MW = TZMediaCommentMWClient.FEED_INST;

    public static void main(String[] args) {
        List<Integer> list = DEF_MW.getCommentIdSlice(new TGetCommentIdSliceMWReq()
                .setAppId(1)
                .setObjectId(1091011926)
                .setGetType(1)
                .setSortBy(1)
                .setStart(0)
                .setCount(200)
        ).values;
        for(int i: list){
            System.out.println(i);
        }

        System.exit(0);
    }
}
