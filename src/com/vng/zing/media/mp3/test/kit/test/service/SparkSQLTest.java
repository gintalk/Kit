package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 15/02/2022
 */

import org.apache.spark.sql.SparkSession;

public class SparkSQLTest {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();

        System.exit(0);
    }
}
