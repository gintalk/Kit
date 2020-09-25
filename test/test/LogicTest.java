/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;

import com.vng.zing.common.ZErrorDef;
import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.common.ZUtil;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.common.thrift.TUserUpdateSubType;
import com.vng.zing.media.common.thrift.TUserUpdateType;
import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.zcommon.thrift.ECode;

/**
 *
 * @author namnh16
 */
public class LogicTest extends BaseTest {

    private static final Logger LOG = ZLogger.getLogger(LogicTest.class);

    private static final int SNOOZE_DURATION = 2592000;
    private static final int WHITELIST_SNOOZE_DURATION = 900;

    private static final List<Integer> WHITELIST_SHORTTIME_AUTO_SNOOZE_USERS = Arrays.asList(
            1038043411, // HuyTQ11
            1009898929, // Ân
            1003795748, // Tú
            1025829998, // Kỳ
            1003296255, // QC1
            1029805841, // QC2
            1020642350 // QC3
    );

    public static class DataEntity {

        public int userId;
        public int type;

        public DataEntity(int userId, int type) {
            this.userId = userId;
            this.type = type;
        }
    }

    private static class ZUserAssetDal {

        private static final ZUserAssetDal INST = new ZUserAssetDal();

        private ZUserAssetDal() {

        }

        public int multiAddZUserAssetMedia(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_asset_media", Arrays.asList("user_id", "media_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserAssetMedia(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_asset_media", Arrays.asList("user_id", "media_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserAssetPlaylist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_asset_playlist", Arrays.asList("user_id", "playlist_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserAssetPlaylist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_asset_playlist", Arrays.asList("user_id", "playlist_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddFollowArtist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_follow_artist", Arrays.asList("user_id", "artist_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteFollowArtist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_follow_artist", Arrays.asList("user_id", "artist_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserLibArtist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_lib_artist", Arrays.asList("user_id", "artist_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserLibUnfollow(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_lib_artist_unfollow", Arrays.asList("user_id", "artist_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserLibArtist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_lib_artist", Arrays.asList("user_id", "artist_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserLibUnfollowArtist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_lib_artist_unfollow", Arrays.asList("user_id", "artist_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            return ZErrorDef.FAIL;
        }

        public int multiAddZUserLibPlaylist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_lib_playlist", Arrays.asList("user_id", "playlist_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
            }
            return ZErrorDef.FAIL;
        }

        public int multiDeleteZUserLibPlaylist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_lib_playlist", Arrays.asList("user_id", "playlist_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserLibSong(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_lib_song", Arrays.asList("user_id", "media_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserLibSong(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_lib_song", Arrays.asList("user_id", "media_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserLibVideo(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_lib_video", Arrays.asList("user_id", "media_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserLibVideo(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_lib_video", Arrays.asList("user_id", "media_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserLibAlbum(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_lib_album", Arrays.asList("user_id", "album_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserLibAlbum(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_lib_album", Arrays.asList("user_id", "album_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserBlockMedia(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_block_media", Arrays.asList("user_id", "media_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserBlockMedia(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_block_media", Arrays.asList("user_id", "media_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserBlockArtist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_block_artist", Arrays.asList("user_id", "artist_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserBlockArtist(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_block_artist", Arrays.asList("user_id", "artist_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserDislikeMedia(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_dislike_media", Arrays.asList("user_id", "media_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserDislikeMedia(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_dislike_media", Arrays.asList("user_id", "media_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserLibAutoSnoozeArtist(Map<Integer, Map<Integer, Integer>> dataMap) {
            try {
                Map<Integer, List<Integer>> data = new HashMap<>();
                for (Map.Entry<Integer, Map<Integer, Integer>> entry : dataMap.entrySet()) {
                    data.put(entry.getKey(), new ArrayList<>(entry.getValue().keySet()));
                }

                String sql = _buildMultiDeleteStatement("zuser_auto_lib_artist_snooze", Arrays.asList("user_id", "artist_id"), data);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserLibAutoSnoozeArtist(Map<Integer, Map<Integer, Integer>> dataMap) {
            try {
                StringBuilder sql = new StringBuilder("INSERT INTO zuser_auto_lib_artist_snooze (user_id, artist_id, unsnooze_time, timestamp) VALUES ");

                long now = System.currentTimeMillis();
                for (Map.Entry<Integer, Map<Integer, Integer>> entry : dataMap.entrySet()) {
                    if (CommonUtils.isEmpty(entry.getValue())) {
                        continue;
                    }

                    for (Map.Entry<Integer, Integer> innerEntry : entry.getValue().entrySet()) {
                        sql.append("(")
                                .append(entry.getKey()).append(",")
                                .append(innerEntry.getKey()).append(",")
                                .append((ConvertUtils.toInteger(now / 1000l)) + innerEntry.getValue()).append(",")
                                .append(now).append("),");
                    }
                }

                sql.replace(sql.length() - 1, sql.length(), " ON DUPLICATE KEY UPDATE "
                        + "timestamp=VALUES(timestamp)");

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserLibSnoozeArtist(Map<Integer, Map<Integer, Integer>> dataMap) {
            try {
                StringBuilder sql = new StringBuilder("INSERT INTO zuser_lib_artist_snooze (user_id, artist_id, unsnooze_time, timestamp) VALUES");

                long now = System.currentTimeMillis();
                for (Map.Entry<Integer, Map<Integer, Integer>> entry : dataMap.entrySet()) {
                    if (CommonUtils.isEmpty(entry.getValue())) {
                        continue;
                    }

                    for (Map.Entry<Integer, Integer> innerEntry : entry.getValue().entrySet()) {
                        sql.append("(")
                                .append(entry.getKey()).append(",")
                                .append(innerEntry.getKey()).append(",")
                                .append(ConvertUtils.toInteger(now/1000l) + innerEntry.getValue()).append(",")
                                .append(now).append("),");
                    }
                }

                sql.replace(sql.length() - 1, sql.length(), " ON DUPLICATE KEY UPDATE "
                        + "timestamp=VALUES(timestamp)");

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserLibSnoozeArtist(Map<Integer, Map<Integer, Integer>> dataMap) {
            try {
                Map<Integer, List<Integer>> data = new HashMap<>();
                for (Map.Entry<Integer, Map<Integer, Integer>> entry : dataMap.entrySet()) {
                    data.put(entry.getKey(), new ArrayList<>(entry.getValue().keySet()));
                }

                String sql = _buildMultiDeleteStatement("zuser_lib_artist_snooze", Arrays.asList("user_id", "artist_id"), data);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserFollowEvent(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_follow_event", Arrays.asList("user_id", "event_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserFollowEvent(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_follow_event", Arrays.asList("user_id", "event_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return ZErrorDef.FAIL;
            }
        }

        public int multiAddZUserFollowPodcastProgram(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_follow_podcast_program", Arrays.asList("user_id", "item_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserFollowPodcastProgram(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_follow_podcast_program", Arrays.asList("user_id", "item_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiAddZUserFavPodcastEpisode(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiInsertStatement("zuser_fav_podcast_episode", Arrays.asList("user_id", "item_id", "timestamp"), "timestamp", dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        public int multiDeleteZUserFavPodcastEpisode(Map<Integer, List<Integer>> dataMap) {
            try {
                String sql = _buildMultiDeleteStatement("zuser_fav_podcast_episode", Arrays.asList("user_id", "item_id"), dataMap);

                LOG.error(CommonUtils.buildTabLog(sql));

                return ZErrorDef.SUCCESS;
            } catch (Exception e) {
                LOG.error(e.getMessage(), e);
                return -ECode.EXCEPTION.getValue();
            }
        }

        private String _buildMultiInsertStatement(String tableName, List<String> columnNames, String onDuplicateKeyUpdate, Map<Integer, List<Integer>> dataMap) {
            StringBuilder sql = new StringBuilder("INSERT INTO ");
            sql.append(tableName).append(" (");

            for (String columnName : columnNames) {
                sql.append(columnName).append(",");
            }
            sql.replace(sql.length() - 1, sql.length(), ") VALUES ");

            long now = System.currentTimeMillis();
            for (Map.Entry<Integer, List<Integer>> entry : dataMap.entrySet()) {
                if (CommonUtils.isEmpty(entry.getValue())) {
                    continue;
                }

                for (int itemId : entry.getValue()) {
                    sql.append("(")
                            .append(entry.getKey()).append(",")
                            .append(itemId).append(",")
                            .append(now).append("),");
                }
            }

            sql.replace(sql.length() - 1, sql.length(), " ON DUPLICATE KEY UPDATE ");
            sql.append(onDuplicateKeyUpdate).append("=VALUES(").append(onDuplicateKeyUpdate).append(")");

            return sql.toString();
        }

        private String _buildMultiDeleteStatement(String tableName, List<String> columnNames, Map<Integer, List<Integer>> dataMap) {
            StringBuilder sql = new StringBuilder("DELETE FROM ");
            sql.append(tableName).append(" WHERE (");

            for (String columnName : columnNames) {
                sql.append(columnName).append(",");
            }
            sql.replace(sql.length() - 1, sql.length(), ") IN (");

            for (Map.Entry<Integer, List<Integer>> entry : dataMap.entrySet()) {
                if (CommonUtils.isEmpty(entry.getValue())) {
                    continue;
                }

                for (int itemId : entry.getValue()) {
                    sql.append("(")
                            .append(entry.getKey()).append(",")
                            .append(itemId).append("),");
                }
            }
            sql.replace(sql.length() - 1, sql.length(), ")");

            return sql.toString();
        }
    }

    public static void main(String[] args) {
        List<DataEntity> data = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            data.add(new DataEntity(i, new Random().nextInt(2)+1));
//            data.add(new DataEntity(i, 1));
        }

        int itemId = 99991111;
        List<TUserUpdateSubType> subTypes = Arrays.asList(
                //                        TUserUpdateSubType.ASSET_MEDIA
                //                ,
                //                        TUserUpdateSubType.ASSET_PLAYLIST
                //                ,
                //                        TUserUpdateSubType.BLOCKED_ARTIST
                //                ,
                //                        TUserUpdateSubType.BLOCKED_SONG
                //                ,
                //                        TUserUpdateSubType.FAV_PODCAST_EPISODE
                //                ,
                //                        TUserUpdateSubType.FOLLOW_PODCAST_PROGRAM
                //                ,
                //                        TUserUpdateSubType.LIBRARY_ALBUM
                //                ,
//                                        TUserUpdateSubType.LIBRARY_ARTIST
                //                ,
//                                        TUserUpdateSubType.LIBRARY_AUTO_SNOOZE_ARTIST
                //                ,
//                                        TUserUpdateSubType.LIBRARY_PLAYLIST
                //                ,
//                                        TUserUpdateSubType.LIBRARY_SNOOZE_ARTIST
                //                ,
//                                        TUserUpdateSubType.LIBRARY_SONG
                //                ,
//                                        TUserUpdateSubType.LIBRARY_VIDEO
                );

        for (TUserUpdateSubType subType : subTypes) {
            syncUserAsset(subType, itemId, data);
        }
    }

    private static final int BATCH_SIZE = 200;

    public static int syncUserAsset(TUserUpdateSubType subType, int itemId, List<DataEntity> data) {
        try {
            Map<Integer, Set<Integer>> typeToUserIdSetMap = new HashMap<>();
            typeToUserIdSetMap.put(TUserUpdateType.FOLLOW.getValue(), new HashSet<>());
            typeToUserIdSetMap.put(TUserUpdateType.UNFOLLOW.getValue(), new HashSet<>());

            for (DataEntity item : data) {
                if (item.type == TUserUpdateType.FOLLOW.getValue()) {
                    typeToUserIdSetMap.get(TUserUpdateType.FOLLOW.getValue()).add(item.userId);
                    typeToUserIdSetMap.get(TUserUpdateType.UNFOLLOW.getValue()).remove(item.userId);
                } else if (item.type == TUserUpdateType.UNFOLLOW.getValue()) {
                    typeToUserIdSetMap.get(TUserUpdateType.UNFOLLOW.getValue()).add(item.userId);
                    typeToUserIdSetMap.get(TUserUpdateType.FOLLOW.getValue()).remove(item.userId);
                }
            }

            LOG.error(CommonUtils.buildTabLog(typeToUserIdSetMap));

            for (Map.Entry<Integer, Set<Integer>> entry : typeToUserIdSetMap.entrySet()) {
                int dataSize = entry.getValue().size();
                if (dataSize > BATCH_SIZE) {
                    if (dataSize > 200) {
                        LOG.error(CommonUtils.buildTabLog("syncUserAsset", TUserUpdateType.findByValue(entry.getKey()), "LARGE_BATCH", ">50", subType));
                    } else if (dataSize > 1000) {
                        LOG.error(CommonUtils.buildTabLog("syncUserAsset", TUserUpdateType.findByValue(entry.getKey()), "LARGE_BATCH", "26-50", subType));
                    } else if (dataSize > 500) {
                        LOG.error(CommonUtils.buildTabLog("syncUserAsset", TUserUpdateType.findByValue(entry.getKey()), "LARGE_BATCH", "13-25", subType));
                    } else {
                        LOG.error(CommonUtils.buildTabLog("syncUserAsset", TUserUpdateType.findByValue(entry.getKey()), "LARGE_BATCH", "6-12", subType));
                    }
                }

                List<Set<Integer>> dataChunks = ZUtil.splitSet(entry.getValue(), BATCH_SIZE);
                for (Set<Integer> dataChunk : dataChunks) {
                    boolean isFollow = entry.getKey() == TUserUpdateType.FOLLOW.getValue();
                    switch (subType) {
                        case FOLLOW_EVENT:
                            processFollowEvent(itemId, dataChunk, isFollow);
                            break;
                        case FOLLOW_ARTIST:
                            processFollowArtist(itemId, dataChunk, isFollow);
                            break;
                        case FAVORITE_PLAYLIST:
                        case FAVORITE_SONG:
                        case FAVORITE_VIDEO:
                            break;
                        case ASSET_MEDIA:
                        case ASSET_PLAYLIST:
                            processZUserAsset(subType, itemId, dataChunk, isFollow);
                            break;
                        case LIBRARY_ARTIST:
                            processZUserSnoozeLibrary(TUserUpdateSubType.LIBRARY_AUTO_SNOOZE_ARTIST, itemId, dataChunk, isFollow);
                        case LIBRARY_PLAYLIST:
                        case LIBRARY_SONG:
                        case LIBRARY_VIDEO:
                        case LIBRARY_ALBUM:
                        case BLOCKED_SONG:
                        case BLOCKED_ARTIST:
                        case DISLIKE_SONG:
                            processZUserLibrary(subType, itemId, dataChunk, isFollow);
                            break;
                        case LIBRARY_SNOOZE_ARTIST:
                            processZUserSnoozeLibrary(subType, itemId, dataChunk, isFollow);
                            break;
                        case LIBRARY_AUTO_SNOOZE_ARTIST:
                            processZUserSnoozeLibrary(subType, itemId, dataChunk, !isFollow);
                            break;
                        case FOLLOW_PODCAST_PROGRAM:
                            processFollowPodcastProgram(itemId, dataChunk, isFollow);
                            break;
                        case FAV_PODCAST_EPISODE:
                            processFavPodcastEpisode(itemId, dataChunk, isFollow);
                            break;
                        default:
                            break;
                    }
                }
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return ZErrorDef.FAIL;
        }
    }

    private static int processZUserAsset(TUserUpdateSubType subType, int itemId, Set<Integer> userIds, boolean isFavorite) {
        try {
            if (CommonUtils.isEmpty(userIds)) {
                return ZErrorDef.SUCCESS;
            }

            Map<Integer, List<Integer>> data = new HashMap<>();
            for (int userId : userIds) {
                data.put(userId, Arrays.asList(itemId));
            }

            switch (subType) {
                case ASSET_MEDIA:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserAssetMedia(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserAssetMedia(data);
                    }
                    break;
                case ASSET_PLAYLIST:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserAssetPlaylist(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserAssetPlaylist(data);
                    }
                    break;
                default:
                    break;
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return ZErrorDef.FAIL;
        }
    }

    private static int processFollowArtist(int itemId, Set<Integer> userIds, boolean isFollow) {
        try {
            if (CommonUtils.isEmpty(userIds)) {
                return ZErrorDef.SUCCESS;
            }

            Map<Integer, List<Integer>> data = new HashMap<>();
            for (int userId : userIds) {
                data.put(userId, Arrays.asList(itemId));
            }

            int eCode;
            if (isFollow) {
                eCode = ZUserAssetDal.INST.multiAddFollowArtist(data);
            } else {
                eCode = ZUserAssetDal.INST.multiDeleteFollowArtist(data);
            }

            if (ZErrorHelper.isFail(eCode) && isFollow) {
                return eCode;
            } else if (ZErrorHelper.isFail(eCode) && !isFollow) {
                return eCode;
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return ZErrorDef.FAIL;
        }
    }

    private static int processZUserLibrary(TUserUpdateSubType subType, int itemId, Set<Integer> userIds, boolean isFavorite) {
        try {
            if (CommonUtils.isEmpty(userIds)) {
                return ZErrorDef.SUCCESS;
            }

            Map<Integer, List<Integer>> data = new HashMap<>();
            for (int userId : userIds) {
                data.put(userId, Arrays.asList(itemId));
            }

            switch (subType) {
                case LIBRARY_ARTIST:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserLibArtist(data);
                        ZUserAssetDal.INST.multiDeleteZUserLibUnfollow(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserLibArtist(data);
                        ZUserAssetDal.INST.multiAddZUserLibUnfollowArtist(data);
                    }
                    break;
                case LIBRARY_PLAYLIST:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserLibPlaylist(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserLibPlaylist(data);
                    }
                    break;
                case LIBRARY_SONG:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserLibSong(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserLibSong(data);
                    }
                    break;
                case LIBRARY_VIDEO:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserLibVideo(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserLibVideo(data);
                    }
                    break;
                case LIBRARY_ALBUM:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserLibAlbum(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserLibAlbum(data);
                    }
                    break;
                case BLOCKED_SONG:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserBlockMedia(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserBlockMedia(data);
                    }
                    break;
                case BLOCKED_ARTIST:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserBlockArtist(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserBlockArtist(data);
                    }
                    break;
                case DISLIKE_SONG:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserDislikeMedia(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserDislikeMedia(data);
                    }
                    break;
                default:
                    break;
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return ZErrorDef.FAIL;
        }
    }

    private static int processZUserSnoozeLibrary(TUserUpdateSubType subType, int itemId, Set<Integer> userIds, boolean isFavorite) {
        try {
            if (CommonUtils.isEmpty(userIds)) {
                return ZErrorDef.SUCCESS;
            }

            Map<Integer, Map<Integer, Integer>> data = new HashMap<>();
            for (int userId : userIds) {
                Map<Integer, Integer> innerdataMap = new HashMap<>();

                if (WHITELIST_SHORTTIME_AUTO_SNOOZE_USERS.contains(userId)) {
                    innerdataMap.put(itemId, WHITELIST_SNOOZE_DURATION);
                } else {
                    innerdataMap.put(itemId, SNOOZE_DURATION);
                }

                data.put(userId, innerdataMap);
            }

            switch (subType) {
                case LIBRARY_AUTO_SNOOZE_ARTIST:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiDeleteZUserLibAutoSnoozeArtist(data);
                    } else {
                        ZUserAssetDal.INST.multiAddZUserLibAutoSnoozeArtist(data);
                    }
                    break;
                case LIBRARY_SNOOZE_ARTIST:
                    if (isFavorite) {
                        ZUserAssetDal.INST.multiAddZUserLibSnoozeArtist(data);
                    } else {
                        ZUserAssetDal.INST.multiDeleteZUserLibSnoozeArtist(data);
                    }
                    break;
                default:
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return ZErrorDef.FAIL;
        }
    }

    private static int processFollowEvent(int itemId, Set<Integer> userIds, boolean isFollow) {
        try {
            if (CommonUtils.isEmpty(userIds)) {
                return ZErrorDef.SUCCESS;
            }

            Map<Integer, List<Integer>> data = new HashMap<>();
            for (int userId : userIds) {
                data.put(userId, Arrays.asList(itemId));
            }

            int eCode;
            if (isFollow) {
                eCode = ZUserAssetDal.INST.multiAddZUserFollowEvent(data);
            } else {
                eCode = ZUserAssetDal.INST.multiDeleteZUserFollowEvent(data);
            }

            if (ZErrorHelper.isFail(eCode) && isFollow) {
                return eCode;
            } else if (ZErrorHelper.isFail(eCode) && !isFollow) {
                return eCode;
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return ZErrorDef.FAIL;
        }
    }

    private static int processFollowPodcastProgram(int itemId, Set<Integer> userIds, boolean isFollow) {
        try {
            if (CommonUtils.isEmpty(userIds)) {
                return ZErrorDef.SUCCESS;
            }

            Map<Integer, List<Integer>> data = new HashMap<>();
            for (int userId : userIds) {
                data.put(userId, Arrays.asList(itemId));
            }

            int eCode;
            if (isFollow) {
                eCode = ZUserAssetDal.INST.multiAddZUserFollowPodcastProgram(data);
            } else {
                eCode = ZUserAssetDal.INST.multiDeleteZUserFollowPodcastProgram(data);
            }

            if (ZErrorHelper.isFail(eCode) && isFollow) {
                return eCode;
            } else if (ZErrorHelper.isFail(eCode) && !isFollow) {
                return eCode;
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return -ECode.EXCEPTION.getValue();
        }
    }

    private static int processFavPodcastEpisode(int itemId, Set<Integer> userIds, boolean isFollow) {
        try {
            if (CommonUtils.isEmpty(userIds)) {
                return ZErrorDef.SUCCESS;
            }

            Map<Integer, List<Integer>> data = new HashMap<>();
            for (int userId : userIds) {
                data.put(userId, Arrays.asList(itemId));
            }

            int eCode;
            if (isFollow) {
                eCode = ZUserAssetDal.INST.multiAddZUserFavPodcastEpisode(data);
            } else {
                eCode = ZUserAssetDal.INST.multiDeleteZUserFavPodcastEpisode(data);
            }

            if (ZErrorHelper.isFail(eCode) && isFollow) {
                return eCode;
            } else if (ZErrorHelper.isFail(eCode) && !isFollow) {
                return eCode;
            }

            return ZErrorDef.SUCCESS;
        } catch (Exception ex) {
            return -ECode.EXCEPTION.getValue();
        }
    }
}
