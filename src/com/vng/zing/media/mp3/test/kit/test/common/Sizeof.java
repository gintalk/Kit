package com.vng.zing.media.mp3.test.kit.test.common;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 24/02/2021
 */

import com.vng.zing.media.common.thrift.comment.TComment;

import java.util.Arrays;

public class Sizeof
{
    public static void main (String [] args) throws Exception
    {
        // Warm up all classes/methods we will use
        runGC ();
        usedMemory ();
        // Array to keep strong references to allocated objects
        final int count = 100000;
        Object [] objects = new Object [count];

        long heap1 = 0;
        // Allocate count+1 objects, discard the first one
        for (int i = -1; i < count; ++ i)
        {
            Object object = null;

            // Instantiate your data here and assign it to object

//            object = new TComment()
//                    .setAppId(Integer.MAX_VALUE)
//                    .setObjectId(Integer.MAX_VALUE)
//                    .setCommentId(Integer.MAX_VALUE)
//                    .setContent("enum TCommentApp:\n" +
//                            "    ZINGMP3_SONG -> ZMP3_SONG\n" +
//                            "    ZINGMP3_VIDEO -> ZMP3_VIDEO\n" +
//                            "    ZINGMP3_ARTIST -> ZMP3_ARTIST\n" +
//                            "    ZINGTV_PROGRAME -> ZTV_PROGRAMME\n" +
//                            "    ZINGTV_VIDEO -> ZTV_VIDEO\n" +
//                            "    ZINGTV_ARTIST -> ZTV_ARTIST\n" +
//                            "    ZINGMP3_PLAYLIST -> ZMP3_PLAYLIST\n" +
//                            "    ZINGTV_PLAYLIST -> ZTV_PLAYLIST\n" +
//                            "    ZINGMP3_NEWS_FEED -> ZMP3_NEWS_FEED\n" +
//                            "\n" +
//                            "enum TStatus: NEW = 0\n" +
//                            "    -> enum TCommentStatus: NEW = 8\n" +
//                            "\n" +
//                            "enum TPublicStatus -> enum TCommentPublicStatus\n" +
//                            "\n" +
//                            "enum TSortBy: NEW=0, TOP=1, OLD=2\n" +
//                            "    -> enum TCommentSortBy: NEW=1, TOP=2\n" +
//                            "\n" +
//                            "enum TActionHistoryType:\n" +
//                            "    DISLIKE = 0 -> DISLIKE = 4\n" +
//                            "\n" +
//                            "enum TGetType -> enum TCommentGetType\n" +
//                            "\n" +
//                            "struct TComment:\n" +
//                            "    TCommentApp app -> i32 appId\n" +
//                            "    i32 time -> i32 createdTime\n" +
//                            "    TStatus status -> i32 status\n" +
//                            "    i32 replyOnId -> i32 parentId\n" +
//                            "    i16 numReply -> i32 numReply\n" +
//                            "    i16 numUpVotes -> i32 numLike\n" +
//                            "    i16 numDownVotes -> i32 numDislike\n" +
//                            "    i32 mentionUserId -> i32 mentionedUserId\n" +
//                            "    i32 mentionCmtId -> i32 mentionedCmtId\n" +
//                            "    list<i32> forbiddenRuleIds -> list<i32> forbiddenKeywordIds\n" +
//                            "    TPublicStatus publicStatus -> i32 publicStatus\n" +
//                            "\n" +
//                            "struct TActionHistoryInfo:\n" +
//                            "    TActionHistoryType typeActionHistory -> i32 actionHistoryType")
//                    .setCreatedTime(Integer.MAX_VALUE)
//                    .setForbiddenKeywordIds(Arrays.asList(Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE))
//                    .setMentionedCmtId(Integer.MAX_VALUE)
//                    .setMentionedUserId(Integer.MAX_VALUE)
//                    .setNote("enum TCommentApp:\\n\" +\n" +
//                            "                            \"    ZINGMP3_SONG -> ZMP3_SONG\\n\" +\n" +
//                            "                            \"    ZINGMP3_VIDEO -> ZMP3_VIDEO\\n\" +\n" +
//                            "                            \"    ZINGMP3_ARTIST -> ZMP3_ARTIST\\n\" +\n" +
//                            "                            \"    ZINGTV_PROGRAME -> ZTV_PROGRAMME\\n\" +\n" +
//                            "                            \"    ZINGTV_VIDEO -> ZTV_VIDEO\\n\" +\n" +
//                            "                            \"    ZINGTV_ARTIST -> ZTV_ARTIST\\n\" +\n" +
//                            "                            \"    ZINGMP3_PLAYLIST -> ZMP3_PLAYLIST\\n\" +\n" +
//                            "                            \"    ZINGTV_PLAYLIST -> ZTV_PLAYLIST\\n\" +\n" +
//                            "                            \"    ZINGMP3_NEWS_FEED -> ZMP3_NEWS_FEED\\n\" +\n" +
//                            "                            \"\\n\" +\n" +
//                            "                            \"enum TStatus: NEW = 0\\n\" +\n" +
//                            "                            \"    -> enum TCommentStatus: NEW = 8\\n\" +\n" +
//                            "                            \"\\n\" +\n" +
//                            "                            \"enum TPublicStatus -> enum TCommentPublicStatus\\n\" +\n" +
//                            "                            \"\\n\" +\n" +
//                            "                            \"enum TSortBy: NEW=0, TOP=1, OLD=2\\n\" +\n" +
//                            "                            \"    -> enum TCommentSortBy: NEW=1, TOP=2\\n\" +\n" +
//                            "                            \"\\n\" +\n" +
//                            "                            \"enum TActionHistoryType:\\n\" +\n" +
//                            "                            \"    DISLIKE = 0 -> DISLIKE = 4\\n\" +\n" +
//                            "                            \"\\n\" +\n" +
//                            "                            \"enum TGetType -> enum TCommentGetType\\n\" +\n" +
//                            "                            \"\\n\" +\n" +
//                            "                            \"struct TComment:\\n\" +\n" +
//                            "                            \"    TCommentApp app -> i32 appId\\n\" +\n" +
//                            "                            \"    i32 time -> i32 createdTime\\n\" +\n" +
//                            "                            \"    TStatus status -> i32 status\\n\" +\n" +
//                            "                            \"    i32 replyOnId -> i32 parentId\\n\" +\n" +
//                            "                            \"    i16 numReply -> i32 numReply\\n\" +\n" +
//                            "                            \"    i16 numUpVotes -> i32 numLike\\n\" +\n" +
//                            "                            \"    i16 numDownVotes -> i32 numDislike\\n\" +\n" +
//                            "                            \"    i32 mentionUserId -> i32 mentionedUserId\\n\" +\n" +
//                            "                            \"    i32 mentionCmtId -> i32 mentionedCmtId\\n\" +\n" +
//                            "                            \"    list<i32> forbiddenRuleIds -> list<i32> forbiddenKeywordIds\\n\" +\n" +
//                            "                            \"    TPublicStatus publicStatus -> i32 publicStatus\\n\" +\n" +
//                            "                            \"\\n\" +\n" +
//                            "                            \"struct TActionHistoryInfo:\\n\" +\n" +
//                            "                            \"    TActionHistoryType typeActionHistory -> i32 actionHistoryType")
//                    .setNumDislike(Integer.MAX_VALUE)
//                    .setNumLike(Integer.MAX_VALUE)
//                    .setNumReply(Integer.MAX_VALUE)
//                    .setParentId(Integer.MAX_VALUE)
//                    .setPlatform(Integer.MAX_VALUE)
//                    .setPublicStatus(Integer.MAX_VALUE)
//                    .setScore(Integer.MAX_VALUE)
//                    .setUserId(Integer.MAX_VALUE)
//                    .setStatus(Integer.MAX_VALUE)
//                    .setTimestamp(Long.MAX_VALUE);

            if (i >= 0)
                objects [i] = object;
            else
            {
                object = null; // Discard the warm up object
                runGC ();
                heap1 = usedMemory (); // Take a before heap snapshot
            }
        }
        runGC ();
        long heap2 = usedMemory (); // Take an after heap snapshot:

        final int size = Math.round (((float)(heap2 - heap1))/count);
        System.out.println ("'before' heap: " + heap1 +
                ", 'after' heap: " + heap2);
        System.out.println ("heap delta: " + (heap2 - heap1) +
                ", {" + objects [0].getClass () + "} size = " + size + " bytes");
        for (int i = 0; i < count; ++ i) objects [i] = null;
        objects = null;
    }
    private static void runGC () throws Exception
    {
        // It helps to call Runtime.gc()
        // using several method calls:
        for (int r = 0; r < 4; ++ r) _runGC ();
    }
    private static void _runGC () throws Exception
    {
        long usedMem1 = usedMemory (), usedMem2 = Long.MAX_VALUE;
        for (int i = 0; (usedMem1 < usedMem2) && (i < 500); ++ i)
        {
            s_runtime.runFinalization ();
            s_runtime.gc ();
            Thread.currentThread ().yield ();

            usedMem2 = usedMem1;
            usedMem1 = usedMemory ();
        }
    }
    private static long usedMemory ()
    {
        return s_runtime.totalMemory () - s_runtime.freeMemory ();
    }

    private static final Runtime s_runtime = Runtime.getRuntime ();
} // End of class