package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/02/2022
 */

import com.vng.zing.media.commonlib.utils.CommonUtils;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SourceTest extends Test {

    private static final ZMP3BuildLinkServiceClient BUILD_LINK_SERVICE = ZMP3BuildLinkServiceClient.INST;

    public static void main(String[] args) throws IOException {
        List<String> lines = FileUtils.readLines(new File("data/artist-cctl-tbo-cover.csv"), StandardCharsets.UTF_8);

        for (String line : lines) {
            String[] split = line.split("\t", -1);

            String artistID = split[0];
            String artistName = split[1];
            String cctlCover = split[2];
            String tboCover = split.length > 3 ? split[3] : "";

            if (CommonUtils.isEmpty(cctlCover)) {
                FileUtils.touch(new File(String.format("/home/namnh16/Data/sampv/CCTL Cover/%s - CCTL không có cover.jpg", artistName)));
            } else {
                download(PHOTO_DOMAIN + cctlCover, String.format("/home/namnh16/Data/sampv/CCTL Cover/%s.jpg", artistName));
            }

            if (CommonUtils.isEmpty(tboCover)) {
                FileUtils.touch(new File(String.format("/home/namnh16/Data/sampv/TBO Cover/%s - TBO không có cover.jpg", artistName)));
            } else {
                download(PHOTO_DOMAIN + tboCover, String.format("/home/namnh16/Data/sampv/TBO Cover/%s.jpg", artistName));
            }
        }

        System.exit(0);
    }
}
