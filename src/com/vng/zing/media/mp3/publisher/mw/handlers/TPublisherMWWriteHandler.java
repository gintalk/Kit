/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.publisher.mw.handlers;

import com.vng.zing.common.ZErrorDef;
import com.vng.zing.media.common.thrift.TThriftAuth;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq;
import com.vng.zing.media.mp3.publisher.mw.model.TPublisherAssetModel;
import com.vng.zing.media.mp3.publisher.mw.thrift.TPublisherMWWriteService;

/**
 *
 * @author namnh16
 */
public class TPublisherMWWriteHandler extends TPublisherMWReadHandler implements TPublisherMWWriteService.Iface {

    public TPublisherMWWriteHandler(String name) {
        super(name);
    }

    @Override
    public int putAsset(TThriftAuth auth, TPublisherAssetWriteReq req) {
        return process(auth, () -> TPublisherAssetModel.INST.putAsset(req), ZErrorDef.FAIL);
    }

}
