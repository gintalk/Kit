/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.publisher.mw.thrift.client;

import com.vng.zing.common.ZCommonDef;
import com.vng.zing.common.ZErrorDef;
import com.vng.zing.common.ZSystemProp;
import com.vng.zing.common.ZUtil;
import com.vng.zing.configer.ZConfig;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.common.thrift.TI32ListResult;
import com.vng.zing.media.common.thrift.TI32Score32ListResult;
import com.vng.zing.media.common.thrift.TThriftAuth;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetReadReq;
import com.vng.zing.media.mp3.common.thrift.publisher.TPublisherAssetWriteReq;
import com.vng.zing.media.mp3.publisher.mw.thrift.TPublisherMWWriteService;
import com.vng.zing.thriftpool.TClientPool;
import com.vng.zing.thriftpool.ZClientPoolUtil;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author namnh16
 */
public class TZMP3PublisherMWClient {

    private static final Logger LOG = ZLogger.getLogger(TZMP3PublisherMWClient.class);
    private final String _name;
    protected TClientPool.BizzConfig _bizzCfg;
    protected TThriftAuth auth;
    
    public static final TZMP3PublisherMWClient INST = new TZMP3PublisherMWClient("main");
    
    private TZMP3PublisherMWClient(String name) {
        assert (name != null && !name.isEmpty());
        _name = name;
        _initialize();
        _initAuth();
    }
    
    public String getName() {
        return _name;
    }
    
    private void _initAuth() {
        String source = ZConfig.Instance.getString(this.getClass(), _name, "source", "");
        String key = ZConfig.Instance.getString(this.getClass(), _name, "key", "");
        if (source.isEmpty() || key.isEmpty()) {
            throw new RuntimeException("Missing authen config!");
        }
        String ip = ZUtil.getIpAddr();
        String app = ZSystemProp.GetAppName();
        auth = new TThriftAuth(source, key, ip, app);
    }
    
    private void _initialize() {
        ZClientPoolUtil.SetDefaultPoolProp(this.getClass() //clazzOfCfg
                ,
                 _name //instName
                ,
                 null //host
                ,
                 null //auth
                ,
                 ZCommonDef.TClientTimeoutMilisecsDefault //timeout
                ,
                 ZCommonDef.TClientNRetriesDefault //nretry
                ,
                 ZCommonDef.TClientMaxRdAtimeDefault //maxRdAtime
                ,
                 ZCommonDef.TClientMaxWrAtimeDefault //maxWrAtime
        );
        ZClientPoolUtil.GetListPools(this.getClass(), _name, new TPublisherMWWriteService.Client.Factory()); //auto create pools
        _bizzCfg = ZClientPoolUtil.GetBizzCfg(this.getClass(), _name);
    }
    
    protected TClientPool<TPublisherMWWriteService.Client> getClientPool() {
        return (TClientPool<TPublisherMWWriteService.Client>) ZClientPoolUtil.GetPool(this.getClass(), _name);
    }

    protected TClientPool.BizzConfig getBizzCfg() {
        return _bizzCfg;
    }
    
    private static void Log(Priority level, Throwable t) {
        LOG.log(level, null, t);
    }

    private static void Log(Priority level, Throwable t, int retry) {
        if (retry > 0) {
            String message = "Request's still failed at retry " + retry;
            LOG.log(level, message, t);
        } else {
            LOG.log(level, null, t);
        }
    }
    
    /// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /// Client methods
    /// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    public int exists(TPublisherAssetReadReq req){
        TClientPool.BizzConfig bCfg = getBizzCfg();
        for (int retry = 0; retry < bCfg.getNRetry(); ++retry) {
            TClientPool<TPublisherMWWriteService.Client> pool = getClientPool();
            TPublisherMWWriteService.Client cli = pool.borrowClient();
            if (cli == null) {
                return ZErrorDef.NO_CONNECTION;
            }
            try {
                int result = cli.exists(auth, req);
                pool.returnClient(cli);
                return result;
            } catch (TTransportException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                continue;
            } catch (TException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return ZErrorDef.BAD_REQUEST;
            } catch (Exception ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return ZErrorDef.BAD_REQUEST;
            }
        }
        return ZErrorDef.BAD_CONNECTION;
    }
    
    public TI32ListResult getAssetSlice(TPublisherAssetReadReq req){
        TClientPool.BizzConfig bCfg = getBizzCfg();
        for (int retry = 0; retry < bCfg.getNRetry(); ++retry) {
            TClientPool<TPublisherMWWriteService.Client> pool = getClientPool();
            TPublisherMWWriteService.Client cli = pool.borrowClient();
            if (cli == null) {
                return new TI32ListResult(ZErrorDef.NO_CONNECTION);
            }
            try {
                TI32ListResult result = cli.getAssetSlice(auth, req);
                pool.returnClient(cli);
                return result;
            } catch (TTransportException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                continue;
            } catch (TException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return new TI32ListResult(ZErrorDef.BAD_REQUEST);
            } catch (Exception ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return new TI32ListResult(ZErrorDef.BAD_REQUEST);
            }
        }
        return new TI32ListResult(ZErrorDef.BAD_CONNECTION);
    }
    
    public TI32Score32ListResult getAssetSliceWithScore(TPublisherAssetReadReq req){
        TClientPool.BizzConfig bCfg = getBizzCfg();
        for (int retry = 0; retry < bCfg.getNRetry(); ++retry) {
            TClientPool<TPublisherMWWriteService.Client> pool = getClientPool();
            TPublisherMWWriteService.Client cli = pool.borrowClient();
            if (cli == null) {
                return new TI32Score32ListResult(ZErrorDef.NO_CONNECTION);
            }
            try {
                TI32Score32ListResult result = cli.getAssetSliceWithScore(auth, req);
                pool.returnClient(cli);
                return result;
            } catch (TTransportException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                continue;
            } catch (TException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return new TI32Score32ListResult(ZErrorDef.BAD_REQUEST);
            } catch (Exception ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return new TI32Score32ListResult(ZErrorDef.BAD_REQUEST);
            }
        }
        return new TI32Score32ListResult(ZErrorDef.BAD_CONNECTION);
    }
    
    public int putAsset(TPublisherAssetWriteReq req) {
        TClientPool.BizzConfig bCfg = getBizzCfg();
        for (int retry = 0; retry < bCfg.getNRetry(); ++retry) {
            TClientPool<TPublisherMWWriteService.Client> pool = getClientPool();
            TPublisherMWWriteService.Client cli = pool.borrowClient();
            if (cli == null) {
                return ZErrorDef.NO_CONNECTION;
            }
            try {
                int eCode = cli.putAsset(auth, req);
                pool.returnClient(cli);
                return eCode;
            } catch (TTransportException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                continue;
            } catch (TException ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return ZErrorDef.BAD_REQUEST;
            } catch (Exception ex) {
                pool.invalidateClient(cli, ex);
                Log(Priority.ERROR, ex, retry);
                return ZErrorDef.BAD_REQUEST;
            }
        }
        return ZErrorDef.BAD_CONNECTION;
    }
}
