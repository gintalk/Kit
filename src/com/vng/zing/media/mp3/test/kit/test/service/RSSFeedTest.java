package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 03/11/2021
 */

public class RSSFeedTest extends Test {

//    public static void main(String[] args) {
////        _getEnclosures();
//        _escapeHtml();
//    }
//
//    private static void _escapeHtml() {
//        try {
////            String url = "https://anchor.fm/s/39118fa8/podcast/rss";
////
////            SyndFeedInput input = new SyndFeedInput();
////            SyndFeed feed = input.build(new XmlReader(new URL(url)));
////            SyndEntry entry = feed.getEntries().get(0);
////
////            String description = "abc &amp; &nbsp; jhwuiq";
////
////            System.out.println(Parser.unescapeEntities(_convertHTMLText(description), false));
//
//            _getEnclosures();
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
//        System.exit(0);
//    }
//
//    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    // Private
//    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    private static void _getEnclosures() {
//        try {
//            String url = "https://anchor.fm/s/39118fa8/podcast/rss";
//            String targetEpTitle = "[Quyển 1 – Tập 1] Mao Sơn Quỷ Môn Thuật – Truyện Ma Có Thật Diễn Đọc MC Đình Soạn";
//
//            SyndFeedInput input = new SyndFeedInput();
//            SyndFeed feed = input.build(new XmlReader(new URL(url)));
//
//            for (SyndEntry entry : feed.getEntries()) {
//                if (targetEpTitle.equals(entry.getTitle()) || entry.getTitle().contains(targetEpTitle)) {
//                    HttpUtils.downloadFile(
//                            entry.getEnclosures().get(0).getUrl(),
//                            "/home/namnh16/Music/Enclosures/" + entry.getTitle().replaceAll("\\s+", "").replaceAll("[^A-Za-z0-9]", "") + ".mp3"
//                    );
//                    break;
//                }
//            }
//        } catch (IOException | FeedException e) {
//            System.err.println(e.getMessage());
//            System.exit(1);
//        }
//        System.exit(0);
//    }
//
//    private static String _convertHTMLText(String htmlText) {
//        Document.OutputSettings jsoupOutputSettings = new Document.OutputSettings();
//        jsoupOutputSettings.prettyPrint(false);
//
//        Document jsoupDoc = Jsoup.parse(htmlText);
//        jsoupDoc.outputSettings(jsoupOutputSettings);
//        jsoupDoc.select("br").before("\\n");
//        jsoupDoc.select("p:gt(0)").before("\\n");
//
//        String str = jsoupDoc.html().replaceAll("\\\\n", "\n");
//
//        return Jsoup.clean(str, "", Whitelist.none(), jsoupOutputSettings);
//    }
}
