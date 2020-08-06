/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.publisher.mw.model;

import org.apache.log4j.Logger;

import com.vng.zing.common.ZErrorDef;
import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.common.thrift.TI32ListResult;
import com.vng.zing.media.common.thrift.TI32Score32ListResult;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ECodeUtils;
import com.vng.zing.media.common.wrapper.list.StrList32Score32ClientWrapper;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetReadReq;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq;
import com.vng.zing.stats.Profiler;
import com.vng.zing.stats.ThreadProfiler;
import com.vng.zing.zcommon.thrift.ECode;

/**
 *
 * @author namnh16
 */
public class TPublisherAssetModel {

    private static final Logger LOG = ZLogger.getLogger(TPublisherAssetModel.class);
    public static final TPublisherAssetModel INST = new TPublisherAssetModel();

    private static final StrList32Score32ClientWrapper LIST_SCORE = new StrList32Score32ClientWrapper("publisher-asset");

    private static final String PUBLISHER_ASSET_LIST_KEY_FORMAT = "publisher.%d.%d";

    private TPublisherAssetModel() {

    }

    /// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /// Private methods
    /// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private String _getKey(int publisherId, int assetType) {
        return String.format(PUBLISHER_ASSET_LIST_KEY_FORMAT, publisherId, assetType);
    }

    /// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /// Public methods
    /// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int exists(TPublisherAssetReadReq req){
        ThreadProfiler profiler = Profiler.getThreadProfiler();
        profiler.push(this.getClass(), "exists");
        
        try {
            String key = _getKey(req.publisherId, req.assetType);
            
            int eCode = LIST_SCORE.existEntry(key, req.assetId);
            if (ZErrorHelper.isFail(eCode) && eCode != -ECode.NOT_EXIST.getValue()) {
                CommonUtils.profilerCount(this.getClass(), "exists", "StrList32Score", "existEntry", "fail", ECodeUtils.toString(eCode));
                LOG.error(CommonUtils.buildTabLog("StrList32Score", "existEntry", "fail", ECodeUtils.toString(eCode), req));
                
                return eCode;
            }
            
            return eCode;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return -ECode.EXCEPTION.getValue();
        } finally{
            profiler.pop(this.getClass(), "exists");
        }
    }
    
    public TI32ListResult getSlice(TPublisherAssetReadReq req) {
        ThreadProfiler profiler = Profiler.getThreadProfiler();
        profiler.push(this.getClass(), "getSlice");

        try {
            String key = _getKey(req.publisherId, req.assetType);

            TI32ListResult listResult = LIST_SCORE.getSlice(key, req.start, req.count);
            if (ZErrorHelper.isFail(listResult.error)) {
                CommonUtils.profilerCount(this.getClass(), "getSlice", "StrList32Score", "getSlice", "fail", ECodeUtils.toString(listResult.error));
                LOG.error(CommonUtils.buildTabLog("StrList32Score", "getSlice", "fail", ECodeUtils.toString(listResult.error), req));

                return listResult;
            }

            return listResult;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return new TI32ListResult(-ECode.EXCEPTION.getValue());
        } finally {
            profiler.pop(this.getClass(), "getSlice");
        }
    }
    
    public TI32Score32ListResult getSliceWithScore(TPublisherAssetReadReq req) {
        ThreadProfiler profiler = Profiler.getThreadProfiler();
        profiler.push(this.getClass(), "getSlice");

        try {
            String key = _getKey(req.publisherId, req.assetType);

            TI32Score32ListResult listResult = LIST_SCORE.getSliceWithScores(key, req.start, req.count);
            if (ZErrorHelper.isFail(listResult.error)) {
                CommonUtils.profilerCount(this.getClass(), "getSlice", "StrList32Score", "getSlice", "fail", ECodeUtils.toString(listResult.error));
                LOG.error(CommonUtils.buildTabLog("StrList32Score", "getSlice", "fail", ECodeUtils.toString(listResult.error), req));

                return listResult;
            }

            return listResult;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return new TI32Score32ListResult(-ECode.EXCEPTION.getValue());
        } finally {
            profiler.pop(this.getClass(), "getSlice");
        }
    }

    public int putAsset(TPublisherAssetWriteReq req) {
        ThreadProfiler profiler = Profiler.getThreadProfiler();
        profiler.push(this.getClass(), "putAssetId");

        try {
            String key = _getKey(req.publisherId, req.assetType);
            int eCode = LIST_SCORE.putEntry(key, req.assetId, req.score);
            if (ZErrorHelper.isFail(eCode)) {
                CommonUtils.profilerCount(this.getClass(), "putAssetId", "StrList32Score", "putEntry", "fail", ECodeUtils.toString(eCode));
                LOG.error(CommonUtils.buildTabLog("StrList32Score", "putEntry", "fail", ECodeUtils.toString(eCode), req));

                return eCode;
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return -ECode.EXCEPTION.getValue();
        } finally {
            profiler.pop(this.getClass(), "putAssetId");
        }
    }
}
