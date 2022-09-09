/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    private static final String PHOTO_DOMAIN = "https://photo-zmp3.zmdcdn.me/";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String firstLine = reader.readLine();
        String[] firstLineSplit = firstLine.split(" +");

        int nodeCount = Integer.parseInt(firstLineSplit[0]);
        int pathCount = Integer.parseInt(firstLineSplit[1]);

        Map<String, Set<String>> pathMap = new HashMap<>(nodeCount);
        for (int i = 0; i < pathCount; i++) {
            String line = reader.readLine();
            String[] lineSplit = line.split(" +");

            Set<String> dests = pathMap.computeIfAbsent(lineSplit[0], k -> new HashSet<>());
            dests.add(lineSplit[1]);
        }

        String central = reader.readLine().trim();

        System.out.println(pathMap);
        System.out.println(central);



        System.exit(0);
    }
}
