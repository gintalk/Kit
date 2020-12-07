/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.common.utils.EncryptUtils;
import com.vng.zing.media.mp3.engine.model.EZingChartModel;

/**
 *
 * @author namnh16
 */
public class LogicTest extends BaseTest {

    private static final Logger LOG = ZLogger.getLogger(LogicTest.class);

    public static void main(String[] args) {
    }

    private static void _prepareMediaSessionsKeyFile() {
        try {
            File out = FileUtils.getFile("data/mediaParams.csv");
            FileUtils.write(out, "mediaSessionsKey,mediaId\n", "UTF-8", true);

            File inSessionsKey = FileUtils.getFile("data/params.csv");
            List<String> sessionsKeyLines = FileUtils.readLines(inSessionsKey, "UTF-8");
            sessionsKeyLines = sessionsKeyLines.subList(1, sessionsKeyLines.size());

            File inMediaId = FileUtils.getFile("data/mediaIds.csv");
            List<String> mediaIdLines = FileUtils.readLines(inMediaId, "UTF-8");
            mediaIdLines = mediaIdLines.subList(1, mediaIdLines.size());

            for (String sesssionsKeyLine : sessionsKeyLines) {
                String sessionsKey = sesssionsKeyLine.split(",")[0];

                for (String mediaIdLine : mediaIdLines) {
                    FileUtils.write(out, sessionsKey + "," + mediaIdLine + "\n", "UTF-8", true);
                }
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            System.exit(1);
        }
    }
    
    private static void _prepareMediaSessionsKeySigFile(){
        try {
            File out = FileUtils.getFile("data/mediaIdParams.csv");
            FileUtils.write(out, "mediaSessionsKey,mediaId,sig\n", "UTF-8", true);
            
            File in = FileUtils.getFile("data/mediaParams.csv");
            List<String> lines = FileUtils.readLines(in, "UTF-8");
            lines = lines.subList(1, lines.size());
            
            for(String line: lines){
                String[] params = line.split(",");
                String sessionsKey = params[0];
                String mediaId = params[1];
                
                String sb = "appVersion=200503&cTime=1606735384517&deviceId=3cc4651f9a6d74aa&mediaId=" + mediaId + "&oId=10610&" + "os=ios&osVersion=25&" + "sessionsKey=" + sessionsKey + "&" + "userId=1037491098&zDeviceId=3000.3670989560568997676&92cebd08ba137aac6c0ec803ce38c111fd736426";
                String sig = EncryptUtils.genMD5(sb);
                line = line + "," + sig;
                
                FileUtils.write(out, line + "\n", "UTF-8", true);
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}
