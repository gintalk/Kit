/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.media.common.builder.BlockBuilder;
import com.vng.zing.media.common.builder.HelperBuilder;
import com.vng.zing.media.common.thrift.THeaderReq;
import com.vng.zing.media.common.thrift.TI32Pair;
import com.vng.zing.media.common.thrift.comment.TCommentApp;
import com.vng.zing.media.common.thrift.comment.TCommentGetType;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.LogUtils;
import com.vng.zing.media.engine.entity.pagination.IEPaging;
import com.vng.zing.media.engine.servlet.api.ZMResponse;
import com.vng.zing.media.mp3.common.thrift.TZCRealtimeType;
import com.vng.zing.media.mp3.common.thrift.core.TMedia;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OA;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAAccount;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAFeature;
import com.vng.zing.media.mp3.engine.model.EZMP3OAModel;
import com.vng.zing.media.mp3.engine.model.EZingChartModel;
import com.vng.zing.media.mp3.mw.core.thrift.client.TZMP3CoreMWClient;
import com.vng.zing.media.mw.comment.thrift.client.TZMediaCommentMWClient;
import com.vng.zing.media.mw.comment.thrift.req.TGetCommentCountMWReq;
import com.vng.zing.media.mw.comment.thrift.res.TGetCommentCountMWRes;
import com.vng.zing.zcommon.thrift.ECode;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author namnh16
 */
public class EModelTest extends Test {

    public static void main(String[] args) throws IOException {
        IEPaging<TZMP3OAAccount> delegatedOAs = EZMP3OAModel.INST.getDelegateOAAccount(
                new THeaderReq(), 1071064070, 0, 0);
        System.out.println(delegatedOAs);

        System.exit(0);
    }
}
