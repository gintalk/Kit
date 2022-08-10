package com.vng.zing.media.mp3.test.kit.test.service;

/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 *
 * @author namnh16 on 09/08/2022
 */

import com.jsoniter.output.JsonStream;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.mp3.commonlib.entity.Track;
import com.vng.zing.media.mp3.commonlib.entity.wrapper.GetAlbumTracks;
import com.vng.zing.media.mp3.commonlib.entity.wrapper.GetNewReleases;
import com.vng.zing.media.mp3.commonlib.entity.wrapper.SearchAlbum;
import com.vng.zing.media.mp3.commonlib.entity.wrapper.SearchArtist;
import com.vng.zing.media.mp3.commonlib.entity.wrapper.SearchTrack;
import com.vng.zing.media.mp3.commonlib.wrapper.STAPIWrapper;
import org.apache.log4j.Logger;

import java.util.List;

public class CrawlerTest extends Test {

    private static final Logger LOG = ZLogger.getLogger(CrawlerTest.class);

    public static void main(String[] args) {
//        ZMProfiler.open("Crawler");
//        try {
//            int totalRequests = 20000, successesSinceLastFail = 0;
//
//            for (int i = 0; i < totalRequests; i++) {
//                int idx = new Random().ints(0, STAPIWrapper.Country.values().length).findFirst().getAsInt();
//
//                Track track = STAPIWrapper.INST.getTrack("05q818DMytsevHWSAqkyUU", STAPIWrapper.Country.values()[idx]);
//                if (CommonUtils.isEmpty(track.id)) {
//                    LOG.error(LogUtils.buildTabLog("GET_TRACK.FAIL", "successes since last fail: ", successesSinceLastFail));
//                    successesSinceLastFail = 0;
//                } else {
//                    successesSinceLastFail++;
//                }
//            }
//
//            Map<String, Integer> failMap = new HashMap<>(), successMap = new HashMap<>();
//
//            int then = DateTimeHelper.currentTimeSeconds();
//            for (int i = 0; i < totalRequests; i++) {
//                int idx = new Random().ints(0, STAPIWrapper.Country.values().length - 1).findFirst().getAsInt();
//                STAPIWrapper.Country country = STAPIWrapper.Country.values()[idx];
//
//                GetNewReleases gnr = STAPIWrapper.INST.getNewReleases(country, 0, 50);
//                if (gnr.albums == null) {
//                    LOG.error(LogUtils.buildTabLog("GET_NEW_RELEASES.FAIL", "successes since last fail: ", successesSinceLastFail));
//
//                    successesSinceLastFail = 0;
//                    successMap.put("getNewReleases", 0);
//                    failMap.put("getNewReleases", failMap.getOrDefault("getNewReleases", 0) + 1);
//                } else {
//                    LOG.info(LogUtils.buildTabLog("GET_NEW_RELEASES.INFO", gnr.albums.items.size()));
//                    successesSinceLastFail++;
//                    successMap.put("getNewReleases", successMap.getOrDefault("getNewReleases", 0) + 1);
//
//                    for (Album album : gnr.albums.items) {
//                        for (Artist artist : album.artists) {
//                            Artist apiArtist = STAPIWrapper.INST.getArtist(artist.id);
//                            LOG.info(LogUtils.buildTabLog("GET_ARTIST.INFO", apiArtist.id, apiArtist.name));
//                            if (CommonUtils.isEmpty(apiArtist.id)) {
//                                LOG.error(LogUtils.buildTabLog("GET_ARTIST.FAIL", artist.id, "successes since last fail: ", successesSinceLastFail));
//
//                                successesSinceLastFail = 0;
//                                successMap.put("getArtist", 0);
//                                failMap.put("getArtist", failMap.getOrDefault("getArtist", 0) + 1);
//                            } else {
//                                successesSinceLastFail++;
//                                successMap.put("getArtist", successMap.getOrDefault("getArtist", 0) + 1);
//                            }
//                        }
//
//                        GetAlbumTracks albumTracks = STAPIWrapper.INST.getAlbumTracks(album.id, country, 0, 20);
//                        if (albumTracks.items == null) {
//                            LOG.error(LogUtils.buildTabLog("GET_ALBUM_TRACKS.FAIL", album.id, "successes since last fail: ", successesSinceLastFail));
//
//                            successesSinceLastFail = 0;
//                            successMap.put("getAlbumTracks", 0);
//                            failMap.put("getAlbumTracks", failMap.getOrDefault("getAlbumTracks", 0) + 1);
//                        } else {
//                            LOG.info(LogUtils.buildTabLog("GET_ALBUM_TRACKS.INFO", album.id, albumTracks.items.size()));
//                            successesSinceLastFail++;
//                            successMap.put("getAlbumTracks", successMap.getOrDefault("getAlbumTracks", 0) + 1);
//
//                            for (Track track : albumTracks.items) {
//                                Track apiTrack = STAPIWrapper.INST.getTrack(track.id, country);
//                                LOG.info(LogUtils.buildTabLog("GET_TRACK.INFO", apiTrack.id, apiTrack.name));
//                                if (CommonUtils.isEmpty(apiTrack.id)) {
//                                    LOG.error(LogUtils.buildTabLog("GET_TRACK.FAIL", "successes since last fail: ", successesSinceLastFail));
//
//                                    successesSinceLastFail = 0;
//                                    successMap.put("getTrack", 0);
//                                    failMap.put("getTrack", failMap.getOrDefault("getTrack", 0) + 1);
//                                } else {
//                                    successesSinceLastFail++;
//                                    successMap.put("getTrack", successMap.getOrDefault("getTrack", 0) + 1);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            int now = DateTimeHelper.currentTimeSeconds();
//
//            LOG.error(LogUtils.buildTabLog("TRACE", (now - then) + " seconds", failMap));
//        } finally {
//            ZMProfiler.close();
//        }

//        WebDriverManager.chromedriver().setup();
//        ChromeDriver driver = new ChromeDriver(new ChromeOptions()
//                .addArguments("--incognito")
//        );
//        driver.get("https://accounts.spotify.com/vi-VN/login?continue=https%3A%2F%2Fopen.spotify.com%2F");
//
//        WebElement usernameInput = new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-username']")));
//        usernameInput.sendKeys("hnam3094@gmail.com");
//
//        WebElement passwordInput = new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='login-password']")));
//        passwordInput.sendKeys("4:DqgzMA_!4+wDX");
//
//        WebElement loginButton = new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='login-button']")));
//        loginButton.click();
//
//        WebElement configScript = new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//script[@id='config']")));
//        JsonWrapper jw = JsonWrapper.build(configScript.getAttribute("innerHTML"));
//        System.out.println("anonymous: " + jw.getString("accessToken", ""));
//
//        WebElement userDropdown = new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='user-widget-link']")));
//        userDropdown.click();
//
//        WebElement logoutButton = new WebDriverWait(driver, Duration.ofSeconds(5))
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='user-widget-dropdown-logout']")));
//        logoutButton.click();



//        SearchTrack st = STAPIWrapper.INST.searchTrack("godzilla", "", "eminem", STAPIWrapper.Country.UNITED_STATED, 0, 10);
//        System.out.println(st);

//        SearchAlbum sa = STAPIWrapper.INST.searchAlbum("kamikaze", "", STAPIWrapper.Country.UNITED_STATED, 0, 1);
//        System.out.println(sa);

//        SearchArtist sa = STAPIWrapper.INST.searchArtist("emi", STAPIWrapper.Country.UNITED_STATED, 1001, 10);
//        System.out.println(JsonStream.serialize(sa));

        GetNewReleases gnr = STAPIWrapper.INST.getNewReleases(STAPIWrapper.Country.UNITED_STATED, 0, 1);
        System.out.println(gnr);

        GetAlbumTracks gat = STAPIWrapper.INST.getAlbumTracks("49DV9eFp2xTdtO7veew5xS", STAPIWrapper.Country.UNITED_STATED, 1000, 1);
        System.out.println(gat);
    }
}
