/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.common.thrift.comment.TComment;
import com.vng.zing.media.common.thrift.comment.TCommentGetType;
import com.vng.zing.media.mw.comment.thrift.client.TZMediaCommentMWClient;
import com.vng.zing.media.mw.comment.thrift.req.TGetCommentCountMWReq;
import com.vng.zing.media.mw.comment.thrift.req.TGetCommentMWReq;
import com.vng.zing.media.mw.comment.thrift.req.TMGetCommentCountMWReq;

import java.util.Arrays;

/**
 * @author namnh16
 */
public class CommentMWTest extends Test {

//    private static final TZMediaCommentMWClient DEF_MW = TZMediaCommentMWClient.DEFAULT_INST;
//    private static final TZMediaCommentMWClient DEF_MW_325 = new TZMediaCommentMWClient("def-3.25");
//    private static final TZMediaCommentMWClient DEF_MW_326 = new TZMediaCommentMWClient("def-3.26");
    private static final TZMediaCommentMWClient FEED_MW = TZMediaCommentMWClient.FEED_INST;

    public static void main(String[] args) {
        System.out.println(FEED_MW.mgetCommentCount(new TMGetCommentCountMWReq()
                .setAppId(10)
                .setGetType(TCommentGetType.N_DAYS.getValue())
                .setObjectIds(Arrays.asList(1984461, 1984423, 1984442, 1984435, 1984494, 1984481, 1984474, 1984469, 1984458, 1984452))
        ));

        System.out.println(FEED_MW.getCommentCount(new TGetCommentCountMWReq()
                .setAppId(10)
                .setGetType(TCommentGetType.N_DAYS.getValue())
                .setObjectId(1983810)
        ));

        System.exit(0);
    }
}
