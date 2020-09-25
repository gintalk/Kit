/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.vng.zing.common.ZUtil;

/**
 *
 * @author namnh16
 */
public class ConcurrencyTest extends BaseTest{
    
    private static final ExecutorService EXECUTOR = Executors.newSingleThreadExecutor();
    
    public static void main(String[] args) throws Exception{
        Future<Integer> future = ConcurrencyTest.doStuff(10);
        
        System.out.println(future.get());
    }
    
    private static Future<Integer> doStuff(int input){
        return EXECUTOR.submit(() -> {
            ZUtil.sleep(5000);
            return input*100;
        });
    }
}
