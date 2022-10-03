/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.utils.ConvertUtils;
import com.vng.zing.media.mp3.commonlib.thrift.oa.TZMP3OABox;
import com.vng.zing.media.mp3.service.oa.thrift.client.TZMP3OAServiceClient;
import com.vng.zing.media.mp3.service.oa.thrift.req.TGetOABoxReq;
import com.vng.zing.media.mp3.service.oa.thrift.req.TPutOABoxReq;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    private static final Logger LOG = ZLogger.getLogger(CommonTest.class);

    public static void main(String[] args) {
        try {
            List<String> lines = FileUtils.readLines(new File("data/podcast-boxes.csv"), StandardCharsets.UTF_8);
            Map<Integer, Set<Integer>> boxMap = new HashMap<>();
            for (String line : lines) {
                String[] split = line.split(",");
                int boxID = ConvertUtils.toInteger(split[0]);
                int oaID = ConvertUtils.toInteger(split[1]);
                Set<Integer> set = boxMap.getOrDefault(oaID, new HashSet<>());
                set.add(boxID);
                boxMap.put(oaID, set);
            }

            lines = FileUtils.readLines(new File("data/podcast-episode.csv"), StandardCharsets.UTF_8);
            Map<Integer, List<Integer>> epMap = new HashMap<>();
            for (String line : lines) {
                String[] split = line.split("¸");
                int oaID = ConvertUtils.toInteger(split[0]);
                int epID = ConvertUtils.toInteger(split[1]);

                List<Integer> epIDs = epMap.getOrDefault(oaID, new ArrayList<>());
                epIDs.add(epID);
                epMap.put(oaID, epIDs);
            }

            for (Map.Entry<Integer, List<Integer>> entry : epMap.entrySet()) {
                int oaID = entry.getKey();
                List<Integer> epIDs = entry.getValue().subList(0, Math.min(entry.getValue().size(), 50));

                for (int boxID : boxMap.get(oaID)) {
                    TZMP3OABox box = TZMP3OAServiceClient.INST.getOABox(new TGetOABoxReq()
                            .setBoxId(boxID)
                            .setIsOrigin(true)
                    ).value;
                    if (box != null) {
                        box.setItemIds(epIDs);
                    }
                    System.out.println(TZMP3OAServiceClient.INST.putOABox(new TPutOABoxReq()
                            .setBox(box)
                            .setIsFromSystem(false)
                    ));
                }
            }
        } catch (Throwable e) {
            LOG.error(e.getMessage(), e);
        }

        System.exit(0);
    }
}
