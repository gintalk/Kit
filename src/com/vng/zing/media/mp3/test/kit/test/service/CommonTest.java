/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.service;

import com.vng.zing.media.commonlib.utils.ConvertUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author namnh16
 */
public class CommonTest extends Test {

    private static final String SEPARATOR = "¸";
    private static final List<String> SONG_SOURCES = Arrays.asList(
            "mFavSong", "mSong", "mPlaylist", "mRecent", "mFavAlbum", "mAlbum", "aSong", "mMV", "mUpload",
            "cZC", "cZCW",
            "mArtist", "offSong", "offPlaylist", "zChart", "hZC", "hNewRelPl", "hRecent", "hSuggestPl", "hsTop100", "hsTopNewSong", "h100",
            "hTheme", "hDailyTheme", "hSlider", "hsHub", "hsVip", "hRetargeting", "hNewReleases", "hNewReleasesDetail", "hSuggestAlbum",
            "hPersonalized", "hDm", "hGenre", "hOnRepeat", "hDiscovery", "hRewind", "hFavoriteMix", "hSuggestByPlaylist", "hSuggestByArtist",
            "hMix", "hAutoTheme1", "hAutoTheme2", "hRadio", "hAutoGenre1", "hAutoGenre2", "hXONE", "hAlbum", "search", "searchRecent",
            "searchACSuggested", "searchSuggestedResult", "searchFullSong", "searchFullArtist", "searchFullPlaylist",
            "searchACLocal", "searchFull", "searchOff", "searchHub", "searchGenreMood", "mpSimSong", "riSimilarSongs", "unknown"
    );

    public static void main(String[] args) throws IOException {
//        List<String> lines = FileUtils.readLines(new File("data/artist-cctl-ids.csv"), StandardCharsets.UTF_8);
//
//        Map<Integer, List<Integer>> map = new HashMap<>();
//
//        for (String line : lines) {
//            String[] split = line.split(",");
//
//            int artistID = ConvertUtils.toInteger(split[0]);
//            int playlistID = ConvertUtils.toInteger(split[1]);
//
//            List<Integer> artistIDs = map.getOrDefault(playlistID, new ArrayList<>());
//            artistIDs.add(artistID);
//            map.put(playlistID, artistIDs);
//        }
//
//        map.forEach((k, v) -> {
//            if(v.size() > 1){
//                StringBuilder sb = new StringBuilder();
//                v.forEach(z -> sb.append(String.format("https://adm.zingmp3.vn/artist/detail?id=%s", z)).append(" "));
//                System.out.println(k + ": " + String.format("https://adm.zingmp3.vn/playlist/detail?id=%s&tab=2", k) + " " + sb);
//            }
//        });


//        List<String> lines = FileUtils.readLines(new File("data/artist-cctl-compare.csv"), StandardCharsets.UTF_8);
//
//        for (String line : lines) {
//            String[] split = line.split(",");
//
//            int artistID = ConvertUtils.toInteger(split[0]);
//            String artistName = split[1];
//            int cctlID = ConvertUtils.toInteger(split[2]);
//            String cctlTitle = split[3];
//            int tboID = ConvertUtils.toInteger(split[4]);
//
//            if (!cctlTitle.toLowerCase().contains(artistName.toLowerCase())) {
//                System.out.printf("Artist: %s | CCTL Playlist: %s\n", artistName, cctlTitle);
//                System.out.printf("\thttps://adm.zingmp3.vn/artist/detail?id=%d | https://adm.zingmp3.vn/playlist/detail?id=%d | https://adm.zingmp3.vn/playlist/detail?id=%d\n", artistID, cctlID, tboID);
//            }
//        }


//        List<String> lines = FileUtils.readLines(new File("data/artist-cctl-tbo-media-compare.csv"), StandardCharsets.UTF_8);
//
//        for (String line : lines) {
//            String[] split = line.split("\t");
//
//            int artistID = ConvertUtils.toInteger(split[0]);
//            String artistName = split[1];
//            int cctlID = ConvertUtils.toInteger(split[2]);
//            String cctlMediaIDs = split[3];
//            int tboID = ConvertUtils.toInteger(split[4]);
//            String tboMediaIDs = split[5];
//
//            if (cctlMediaIDs.equals(tboMediaIDs)) {
//                continue;
//            }
//
//            System.out.printf("CCTL: https://adm.zingmp3.vn/playlist/detail?id=%d&tab=2 | TBO: https://adm.zingmp3.vn/playlist/detail?id=%d&tab=2 | Artist: %d %s\n", cctlID, tboID, artistID, artistName);
//        }


        List<String> lines = FileUtils.readLines(new File("data/artist-cctl-media-verify.csv"), StandardCharsets.UTF_8);

        List<String> list = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split("\t");

            int artistID = ConvertUtils.toInteger(split[0]);
            String artistName = split[1];
            String cctlID = split[2];
            List<Integer> artistIDs = ConvertUtils.strToListInt(split[4], ",");
            String artistNames = split[5];
            String mediaTitle = split[6];

            if (artistIDs.contains(artistID)) {
                continue;
            }

            list.add(String.format("%s | CCTL: https://adm.zingmp3.vn/playlist/detail?id=%s&tab=2 | Media: %s | Artists in Media: %s", artistName, cctlID, mediaTitle, artistNames));
        }

        list.forEach(System.out::println);

        System.exit(0);
    }
}
