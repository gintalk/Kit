package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 22/02/2022
 */

import com.vng.zing.media.commonlib.thrift.TCountryCode;
import com.vng.zing.media.commonlib.utils.CommonUtils;
import com.vng.zing.media.commonlib.utils.ConvertUtils;
import com.vng.zing.media.mp3.commonlib.thrift.TMediaSourceFormat;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkReq;
import com.vng.zing.media.mp3.service.buildlink.thrift.TBuildLinkRes;
import com.vng.zing.media.mp3.service.buildlink.thrift.client.ZMP3BuildLinkServiceClient;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class SourceTest extends Test {

    public static void main(String[] args) throws IOException {
//        List<String> lines = FileUtils.readLines(new File("data/artist-avatar.csv"), StandardCharsets.UTF_8);
//        for (String line : lines) {
//            String[] split = line.split("\t", -1);
//
//            String artistID = split[0];
//            String artistName = split[1];
//            String avatar = split[2];
//
//            ByteBuffer byteBuffer = TZMediaPhotoMakerClient.INST.buildCoverPlaylistByArtist(avatar, artistName);
//            byte[] bytes = new byte[byteBuffer.remaining()];
//            byteBuffer.get(bytes);
//            FileUtils.writeByteArrayToFile(new File("/home/namnh16/Data/sampv/" + artistID + " - " + artistName.replaceAll("/", " ") + ".jpeg"), bytes);
//        }

        List<String> lines = FileUtils.readLines(new File("data/artist-spot-avatar.csv"), StandardCharsets.UTF_8);
        for (String line : lines) {
            String[] split = line.split(SEPARATOR);
            download(split[1], "/home/namnh16/Data/artist-spot-avatar/" + split[0] + ".jpg");
        }

//        Collection<File> files = FileUtils.listFiles(new File("/media/namnh16/Extreme SSD/Data đợt 3/Done/Part 3"), new WildcardFileFilter("*"), TrueFileFilter.TRUE);
//        for (File file : files) {
//            String[] split = file.getName().split("[.\\s+]");
//
//            int mediaID = ConvertUtils.toInteger(split[0].replaceAll("\\D", ""));
//
//            TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.fullGetAudioBigFileLinks(new TBuildLinkReq()
//                    .setCountryCode(TCountryCode.VIETNAM.getValue())
//                    .setFormats(Arrays.asList(
//                            TMediaSourceFormat.AudioLossless.getValue(),
//                            TMediaSourceFormat.Audio320.getValue(),
//                            TMediaSourceFormat.Audio128.getValue())
//                    )
//                    .setMediaId(mediaID)
//            );
//            if (CommonUtils.isEmpty(res.values)) {
//                System.err.println(mediaID);
//            }
//        }

//        List<String> lines = FileUtils.readLines(new File("/home/namnh16/Workspace/zmp3-new/worker/ZMP3ContentCollectingWorker/data/nct-song-worker/nct-priority-0.csv"), StandardCharsets.UTF_8);
//        int count = 0;
//        for (String line : lines) {
//            String[] split = line.split(SEPARATOR);
//
//            int mediaID = ConvertUtils.toInteger(split[0]);
//
//            TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.fullGetAudioBigFileLinks(new TBuildLinkReq()
//                    .setCountryCode(TCountryCode.VIETNAM.getValue())
//                    .setFormats(Arrays.asList(
//                            TMediaSourceFormat.AudioLossless.getValue(),
//                            TMediaSourceFormat.Audio320.getValue(),
//                            TMediaSourceFormat.Audio128.getValue())
//                    )
//                    .setMediaId(mediaID)
//            );
//            if (CommonUtils.isEmpty(res.values)) {
//                System.err.println(line);
//                count++;
//            }
//        }
//        System.out.println(count);

        System.exit(0);
    }
}
