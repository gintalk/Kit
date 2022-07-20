/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

//    private static final String PHOTO_DOMAIN = "https://photo-zmp3.zmdcdn.me/";
//
//    public static void main(String[] args) {
//        try {
//            List<String> lines = FileUtils.readLines(new File("data/map"), "UTF-8");
//            String mapAsString = lines.get(0);
//
//            Map<String, String> map = Arrays.stream(mapAsString.split(","))
//                    .map(entry -> entry.split("="))
//                    .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
//
//            map.forEach((key, value) -> System.out.println(key + " | " + value));
//        } catch (Exception e) {
//            System.err.println(Arrays.toString(e.getStackTrace()));
//        }
//
////        try {
////            List<String> lines = FileUtils.readLines(new File("data/media_url.csv"), "UTF-8");
////            for (String line : lines) {
////                String[] tokens = line.split(",");
////
////                String name = tokens[0];
////                String encodedID = tokens[1];
////
////                _downloadSource(name, encodedID);
////                _downloadThumb(name, encodedID);
////            }
////        } catch (Exception e) {
////            System.err.println(e.getMessage());
////        }
//
//        System.exit(0);
//    }
//
//    private static void _downloadSource(String name, String encodedID) {
//        int id = EncodeUtils.numberDecode(encodedID);
//
//        TBuildLinkRes res = ZMP3BuildLinkServiceClient.INST.getAudioBigFileLinks(new TBuildLinkReq().setCountryCode(TCountryCode.VIETNAM.getValue()).setFormats(Arrays.asList(TMediaSourceFormat.AudioLossless.getValue(), TMediaSourceFormat.Audio320.getValue(), TMediaSourceFormat.Audio128.getValue())).setMediaId(id));
//        if (ZErrorHelper.isFail(res.error)) {
//            System.err.println("BUILD_LINK_SERVICE.FAIL" + " | " + res.error + " | " + encodedID + " | " + id);
//            return;
//        }
//        Map<Integer, TStreamingLink> values = res.values;
//
//        String link = "", extension = "";
//        if (values.containsKey(TMediaSourceFormat.AudioLossless.getValue())) {
//            link = values.get(TMediaSourceFormat.AudioLossless.getValue()).link;
//            extension = ".flac";
//        } else if (values.containsKey(TMediaSourceFormat.Audio320.getValue())) {
//            link = values.get(TMediaSourceFormat.Audio320.getValue()).link;
//            extension = ".mp3";
//        } else if (values.containsKey(TMediaSourceFormat.Audio128.getValue())) {
//            link = values.get(TMediaSourceFormat.Audio128.getValue()).link;
//            extension = ".mp3";
//        }
//
//        if (CommonUtils.isEmpty(link)) {
//            System.err.println("Lossless, 320, 128 not available" + " | " + encodedID + " | " + id);
//            return;
//        }
//
//        HttpUtils.downloadFile(link, "/home/namnh16/Data/source/" + name + extension);
//    }
//
//    private static void _downloadThumb(String name, String encodedID) {
//        int id = EncodeUtils.numberDecode(encodedID);
//
//        TMediaResult mediaResult = TZMP3CoreMWClient.INST.getMedia(id);
//        if (ZErrorHelper.isFail(mediaResult.error)) {
//            System.err.println("CORE_MW_FAIL" + " | " + mediaResult.error + " | " + encodedID + " | " + id);
//            return;
//        }
//        TMedia media = mediaResult.value;
//
//        String link = CommonUtils.isEmpty(media.audio.thumbnail) ? "" : PHOTO_DOMAIN + media.audio.thumbnail;
//        if (CommonUtils.isEmpty(link)) {
//            System.err.println("Thumbnail not available" + " | " + encodedID + " | " + id);
//            return;
//        }
//
//        HttpUtils.downloadFile(link, "/home/namnh16/Data/thumb/" + name + ".jpg");
//    }
}
