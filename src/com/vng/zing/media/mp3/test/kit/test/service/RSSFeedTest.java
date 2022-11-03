package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 03/11/2021
 */

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.vng.zing.media.mp3.engine.utils.HttpUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Safelist;

import java.io.IOException;
import java.net.URL;

public class RSSFeedTest extends Test {

    public static void main(String[] args) {
        _getEnclosures();
//        _escapeHtml();
    }

    private static void _escapeHtml() {
        try {
            String url = "https://anchor.fm/s/6b9f15bc/podcast/rss";

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(new URL(url)));
            System.out.println(feed.getEntries().size());

//            _getEnclosures();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.exit(0);
    }

    //
//    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
//    // Private
//    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static void _getEnclosures() {
        try {
            String url = "https://feeds.transistor.fm/coffee-around";
            String targetEpTitle = "[Quyển 1 – Tập 1] Mao Sơn Quỷ Môn Thuật – Truyện Ma Có Thật Diễn Đọc MC Đình Soạn";

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(new URL(url)));

            for (SyndEntry entry : feed.getEntries()) {
                if (targetEpTitle.equals(entry.getTitle()) || entry.getTitle().contains(targetEpTitle)) {
                    HttpUtils.downloadFile(
                            entry.getEnclosures().get(0).getUrl(),
                            "/home/namnh16/Music/Enclosures/" + entry.getTitle().replaceAll("\\s+", "").replaceAll("[^A-Za-z0-9]", "") + ".mp3"
                    );
                    break;
                }
            }
        } catch (IOException | FeedException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        System.exit(0);
    }

    private static String _convertHTMLText(String htmlText) {
        Document.OutputSettings jsoupOutputSettings = new Document.OutputSettings();
        jsoupOutputSettings.prettyPrint(false);

        Document jsoupDoc = Jsoup.parse(htmlText);
        jsoupDoc.outputSettings(jsoupOutputSettings);
        jsoupDoc.select("br").before("\\n");
        jsoupDoc.select("p:gt(0)").before("\\n");

        String str = jsoupDoc.html().replaceAll("\\\\n", "\n");

        return Jsoup.clean(str, "", Safelist.none(), jsoupOutputSettings);
    }
}
