/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.common;

import com.vng.zing.common.ZErrorDef;
import com.vng.zing.media.commonlib.utils.CommonUtils;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author locnt3
 */
public class HttpUtils {

    private static HttpURLConnection sendJSONData(String url, JSONObject data, String proxyHost, int proxyPort, int readTimeOutInMili) throws Exception {
        String srtParams = data.toString();
        byte[] postData = srtParams.getBytes(StandardCharsets.UTF_8);
        int postDataLength = postData.length;

        URL obj = new URL(url);
        HttpURLConnection conn = null;
        if (CommonUtils.isEmpty(proxyHost) || proxyPort < 1) {
            conn = (HttpURLConnection) obj.openConnection();
        } else {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));
            conn = (HttpURLConnection) obj.openConnection(proxy);
        }

        //add request header
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
        conn.setUseCaches(false);
        if (readTimeOutInMili > 0) {
            conn.setReadTimeout(readTimeOutInMili);
        }

        // Send post request
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.write(postData);
        wr.flush();
        wr.close();
        return conn;
    }

    private static HttpURLConnection sendJSONData(String url, JSONObject data, String proxyHost, int proxyPort) throws Exception {
        return sendJSONData(url, data, proxyHost, proxyPort, 0);
    }

    private static String getResponseStream(InputStreamReader stream) throws Exception {
        BufferedReader in = new BufferedReader(stream);
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }

    public static int sendPostJSON(String url, JSONObject data, String proxyHost, int proxyPort) throws Exception {
        HttpURLConnection conn = sendJSONData(url, data, proxyHost, proxyPort);
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            return ZErrorDef.FAIL;
        }
        return ZErrorDef.SUCCESS;
    }

    public static String sendPostJSON(String url, JSONObject data) throws Exception {
        return sendPostJSON(url, "", 0, data);
    }

    public static String sendPostJSON(String url, JSONObject data, int readTimeoutInMili) throws Exception {
        return sendPostJSON(url, "", 0, data, readTimeoutInMili);
    }

    public static String sendPostJSON(String url, String proxyHost, int proxyPort, JSONObject data) throws Exception {
        return sendPostJSON(url, proxyHost, proxyPort, data, 0);
    }

    public static String sendPostJSON(String url, String proxyHost, int proxyPort, JSONObject data, int readTimeoutInMili) throws Exception {
        HttpURLConnection conn = sendJSONData(url, data, proxyHost, proxyPort, readTimeoutInMili);
        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            return String.valueOf(responseCode);
        }
        //print result
        return getResponseStream(new InputStreamReader(conn.getInputStream()));
    }
}
