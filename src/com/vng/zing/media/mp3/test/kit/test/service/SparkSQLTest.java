package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 15/02/2022
 */

import com.vng.zing.media.commonlib.helper.DateTimeHelper;
import com.vng.zing.media.commonlib.utils.ConvertUtils;
import com.vng.zing.media.mp3.test.kit.test.common.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.io.Serializable;
import java.util.List;

import static org.apache.spark.sql.functions.count;

public class SparkSQLTest extends Test {

    public static void main(String[] args) {
        SparkSession spark = SparkSession
                .builder()
                .appName("Spark SQL basic example")
                .config("spark.master", "local")
                .getOrCreate();

        Dataset<Row> ds = spark
                .read()
                .parquet("data/active-user.parquet");

        Dataset<Row> agged = ds.groupBy("platform")
                .agg(
                        count("*").as("total")
                );

        List<Row> rows = agged.collectAsList();

        int android = 0, ios = 0;
        for (Row row : rows) {
            if (row.getString(0).equals("APP_ANDROID")) {
                android = ConvertUtils.toInteger(row.getLong(1));
            } else if (row.getString(0).equals("APP_IOS")) {
                ios = ConvertUtils.toInteger(row.getLong(1));
            }
        }

        int finalAndroid = android;
        int finalIos = ios;
        Dataset<Row> mapped = agged.map((MapFunction<Row, Entity>) row -> {
            Entity ett = new Entity();

            ett.setTime(ConvertUtils.toInteger(DateTimeHelper.ofEpocMilli(1672229599000L).format("yyMMddHH")));
            ett.setApp_android(finalAndroid);
            ett.setApp_ios(finalIos);

            return ett;
        }, Encoders.bean(Entity.class)).select("*").limit(1);

        mapped.show();

        System.exit(0);
    }
}
