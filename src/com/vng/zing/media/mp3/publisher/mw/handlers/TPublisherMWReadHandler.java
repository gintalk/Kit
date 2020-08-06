/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.publisher.mw.handlers;

import com.vng.zing.common.ZErrorDef;
import com.vng.zing.media.common.thrift.TBaseHandler;
import com.vng.zing.media.common.thrift.TI32ListResult;
import com.vng.zing.media.common.thrift.TI32Score32ListResult;
import com.vng.zing.media.common.thrift.TThriftAuth;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetReadReq;
import com.vng.zing.media.mp3.publisher.mw.model.TPublisherAssetModel;
import com.vng.zing.media.mp3.publisher.mw.thrift.TPublisherMWReadService;

/**
 *
 * @author namnh16
 */
public class TPublisherMWReadHandler extends TBaseHandler implements TPublisherMWReadService.Iface {

    public TPublisherMWReadHandler(String name) {
        super(name);
    }
    
    @Override
    public int exists(TThriftAuth auth, TPublisherAssetReadReq req){
        return process(auth, () -> TPublisherAssetModel.INST.exists(req), ZErrorDef.FAIL);
    }

    @Override
    public TI32ListResult getAssetSlice(TThriftAuth auth, TPublisherAssetReadReq req) {
        return process(auth, () -> TPublisherAssetModel.INST.getSlice(req), new TI32ListResult(ZErrorDef.FAIL));
    }

    @Override
    public TI32Score32ListResult getAssetSliceWithScore(TThriftAuth auth, TPublisherAssetReadReq req) {
        return process(auth, () -> TPublisherAssetModel.INST.getSliceWithScore(req), new TI32Score32ListResult(ZErrorDef.FAIL));
    }
}
