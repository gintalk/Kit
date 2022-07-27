package com.vng.zing.media.mp3.test.kit.test.common;

import com.vng.zing.common.ZErrorDef;
import com.vng.zing.common.ZErrorHelper;
import com.vng.zing.configer.ZConfig;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.commonlib.helper.HttpRequestHelperHelper;
import com.vng.zing.media.commonlib.helper.ProxyHelper;
import com.vng.zing.media.commonlib.utils.CommonUtils;
import com.vng.zing.media.commonlib.utils.LogUtils;
import com.vng.zing.media.commonlib.wrapper.JsonWrapper;
import com.vng.zing.zalooauth.ZCypher;
import com.vng.zing.zcommon.thrift.ECode;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author lamtd
 */
public class OAMsgUtils {
    private static final Logger LOG = ZLogger.getLogger(OAMsgUtils.class);
    private static final String API_OA_MESSAGE = "https://openapi.zalo.me/v2.0/oa/message?access_token=";
    private static final String API_OA_UPLOAD_FILE = "https://openapi.zalo.me/v2.0/oa/upload/file?access_token=";

    private static final Integer MESSAGE_LENGTH = ZConfig.Instance.getInt(OAMsgUtils.class, "main", "message_length", 2000);
    private static final Long SLEEP_BETWEEN_SEND_LIST_MESSAGE = ZConfig.Instance.getLong(OAMsgUtils.class, "main", "sleep", 100);
    private static final Integer N_RETRY = ZConfig.Instance.getInt(OAMsgUtils.class, "main", "n_retry", 2);
    private static final Integer SLEEP_RETRY = ZConfig.Instance.getInt(OAMsgUtils.class, "main", "sleep_retry", 1000);
    private static final Integer READ_TIMEOUT = ZConfig.Instance.getInt(OAMsgUtils.class, "main", "read_timeout", 2000);

    private final int oaIdRaw;
    private final String accessToken;
    private String proxyHost;
    private int proxyPort;
    private final String secretKey;
    private boolean useProxy;
    private String instName;

    private OAMsgUtils(String instanceName) {
        instName = instanceName;
        oaIdRaw = ZConfig.Instance.getInt(OAMsgUtils.class, instanceName, "oa_id_raw", 226243058);
        accessToken = ZConfig.Instance.getString(OAMsgUtils.class, instanceName, "accesstoken", "");
        useProxy = ZConfig.Instance.getBoolean(OAMsgUtils.class, instanceName, "use_proxy", false);
        if (useProxy) {
            ProxyHelper.ProxyConfig proxy = ProxyHelper.getProxy();
            this.proxyHost = proxy.getHost();
            this.proxyPort = proxy.getPort();
        }
        secretKey = ZConfig.Instance.getString(OAMsgUtils.class, instanceName, "secret_key", "");
    }

    public OAMsgUtils(int oaIdRaw, String accessToken, String secretKey) {
        this.oaIdRaw = oaIdRaw;
        this.accessToken = accessToken;
        this.secretKey = secretKey;
        ProxyHelper.ProxyConfig proxy = ProxyHelper.getProxy();
        this.proxyHost = proxy.getHost();
        this.proxyPort = proxy.getPort();
    }

    public OAMsgUtils(int oaIdRaw, String accessToken, String secretKey, String proxyHost, int proxyPort) {
        this(oaIdRaw, accessToken, secretKey);
        this.useProxy = true;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
    }

    @Override
    public String toString() {
        return "OAMessageUtils{" + "OA_ID_RAW=" + oaIdRaw + ", ACCESS_TOKEN=" + accessToken + ", PROXY_PORT=" + proxyPort + ", SECRET_KEY=" + secretKey + '}';
    }

    public static final OAMsgUtils ZM_SERVER_DEV_INST = new OAMsgUtils("zmediaserverdev");
    public static final OAMsgUtils ZMP3_OPERATION_INST = new OAMsgUtils("operation");
    public static final OAMsgUtils ZM_QoS_INST = new OAMsgUtils("zmediaqos");
    public static final OAMsgUtils XONE_OPERATION_INST = new OAMsgUtils("xoneoperation");

    public static final OAMsgUtils ZMP3_INST = new OAMsgUtils("main");

    public int getOAIdRaw() {
        return oaIdRaw;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public MessageResult sendMessage(_BaseOAMessage message, boolean useProxy) {
        try {
            if (!(message instanceof TextOAMessage)) {
                return _sendMessage(message, useProxy);
            }
            TextOAMessage textOAMsg = (TextOAMessage) message;
            String contentMessage = textOAMsg.text;
            if (CommonUtils.isEmpty(contentMessage)) {
                contentMessage = "";
            }
            if (contentMessage.length() < MESSAGE_LENGTH) {
                return _sendMessage(message, useProxy);
            }

            if (!contentMessage.endsWith("\n")) {
                contentMessage += "\n";
            }

            int lengthMsg = contentMessage.length();
            for (int start = 0; start < contentMessage.length(); ) {
                int end = start + MESSAGE_LENGTH;
                if (end > lengthMsg) {
                    end = lengthMsg;
                }

                String messageChild = contentMessage.substring(start, end);
                if (!messageChild.endsWith("\n")) {
                    int lastIndexEndLine = messageChild.lastIndexOf("\n");
                    if (lastIndexEndLine == -1) {
                        return new MessageResult(-ECode.INVALID_DATA.getValue(), "Message content invalid");
                    }
                    end = start + lastIndexEndLine + 1;
                    messageChild = contentMessage.substring(start, end);

                }
                start = end;

                Integer nRetry = N_RETRY;
                while (nRetry > 0) {
                    MessageResult sendRs = _sendMessage(new TextOAMessage(message.zaloId, messageChild.trim()), useProxy);
                    if (ZErrorHelper.isFail(sendRs.getErrorCode())) {
                        LOG.error(LogUtils.buildTabLog("SendTextMessageFail", nRetry, message.zaloId, messageChild));
                        Thread.sleep(SLEEP_RETRY);
                        nRetry--;
                    } else {
                        break;
                    }
                }

                Thread.sleep(SLEEP_BETWEEN_SEND_LIST_MESSAGE);
            }
            return new MessageResult(ZErrorDef.SUCCESS);
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return new MessageResult(-ECode.EXCEPTION.getValue(), "");
        }
    }

    public MessageResult sendMessage(_BaseOAMessage message) {
        return sendMessage(message, true);
    }

    private MessageResult _sendMessage(_BaseOAMessage message, boolean useProxy) {
        MessageResult sendResult = new MessageResult(0);
        try {
            message.oaIdRaw = this.oaIdRaw;
//            String sendRs = useProxy ?
//                    HttpUtils.sendPostJSON(API_OA_MESSAGE + this.accessToken, this.proxyHost, this.proxyPort, message.getJson(), READ_TIMEOUT) :
//                    HttpUtils.sendPostJSON(API_OA_MESSAGE + this.accessToken, message.getJson(), READ_TIMEOUT);
            HttpRequestHelperHelper.Response sendRs =
//                    useProxy ?
//                    HttpRequestHelper.newPost().setUrl(API_OA_MESSAGE + this.accessToken).setProxy(this.proxyHost, this.proxyPort).setContentType(HttpRequestHelper.ContentType.APPLICATION_JSON).setBody(message.getMap()).setTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS).execute() :
                    HttpRequestHelperHelper.newPost().setUrl(API_OA_MESSAGE + this.accessToken).setContentType(HttpRequestHelperHelper.ContentType.APPLICATION_JSON).setBody(message.getMap()).setTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS).execute();
            LOG.info(LogUtils.buildTabLog("sendRs", sendRs));
            if (sendRs.getCode() != 200) {
                sendResult.errorCode = sendRs.getCode();
                LOG.error(LogUtils.buildTabLog("sendOAMessageError", sendRs));
            }
            sendResult.setErrorMsg(sendRs.getMsg());
        } catch (Throwable e) {
            LOG.error(e.getMessage(), e);
            sendResult.setErrorCode(-ECode.EXCEPTION.getValue());
        }
        return sendResult;
    }

    public MessageResult sendTextMessage(String message, List<Integer> zaloIds) {
        if (CommonUtils.isEmpty(message) || CommonUtils.isEmpty(zaloIds)) {
            LOG.error(LogUtils.buildTabLog("invalidParam", message, zaloIds));
            return new MessageResult(-ECode.INVALID_PARAM.getValue());
        }
        for (Integer zaloId : zaloIds) {
            MessageResult rsSend = sendMessage(new TextOAMessage(zaloId, message));
            if (ZErrorHelper.isFail(rsSend.errorCode)) {
                LOG.error(LogUtils.buildTabLog("sendTextMessageFail", rsSend, zaloId, message));
            }
        }
        return new MessageResult(ECode.C_SUCCESS.getValue());
    }

    static class _BaseOAMessage {

        private int oaIdRaw = 0;
        private final int zaloId;

        protected JsonWrapper message = JsonWrapper.createObj();
        protected String user_id;

        public JsonWrapper getJson() {
            long encodedUserID = ZCypher.encodeUserIdByPage(this.zaloId, this.oaIdRaw);
            this.user_id = String.valueOf(encodedUserID);

            return JsonWrapper.createObj()
                    .put("recipient", JsonWrapper.createObj().put("user_id", user_id))
                    .put("message", message);
        }

        public Map<String, String> getMap() {
            long encodedUserID = ZCypher.encodeUserIdByPage(this.zaloId, this.oaIdRaw);
            this.user_id = String.valueOf(encodedUserID);

            Map<String, String> map = new HashMap<>();
            map.put("recipient", JsonWrapper.createObj().put("user_id", user_id).toString());
            map.put("message", message.toString());

            return map;
        }

        public _BaseOAMessage(int zaloId) {
            this.zaloId = zaloId;
        }

    }

    public static class TextOAMessage extends _BaseOAMessage {

        String text;

        public TextOAMessage(int zaloId, String text) {
            super(zaloId);
            this.text = text;
        }

        @Override
        public JsonWrapper getJson() {
            this.message.put("text", this.text);

            return super.getJson();
        }

        @Override
        public Map<String, String> getMap() {
            this.message.put("text", this.text);

            return super.getMap();
        }

    }

    public static class OAActionItem {

        String title;
        String subTitle;
        String image;
        String actionLink;

        public OAActionItem(String title, String subTitle, String image, String actionLink) {
            this.title = title;
            this.subTitle = subTitle;
            this.image = image;
            this.actionLink = actionLink;
        }

    }

    public final static class ListButtonOAMessage extends _BaseOAMessage {

        List<ButtonOA> buttons;
        String title;

        public ListButtonOAMessage(int zaloId, String title, List<ButtonOA> buttons) {
            super(zaloId);
            this.buttons = new ArrayList<>(buttons);
            this.title = title;
        }

        @Override
        public JsonWrapper getJson() {
            JsonWrapper buttons = JsonWrapper.createObj();
            if (!CommonUtils.isEmpty(this.buttons)) {
                this.buttons.forEach(item -> {
                    JsonWrapper button = JsonWrapper.createObj()
                            .put("title", item.title)
                            .put("type", item.type)
                            .put("payload", item.payload);

                    buttons.add(button);
                });
            }

            JsonWrapper payload = JsonWrapper.createObj()
                    .put("buttons", buttons);
            JsonWrapper attachment = JsonWrapper.createObj()
                    .put("type", "template")
                    .put("payload", payload);
            message.put("attachment", attachment)
                    .put("text", title);

            return super.getJson();
        }

        @Override
        public Map<String, String> getMap() {
            JsonWrapper buttons = JsonWrapper.createObj();
            if (!CommonUtils.isEmpty(this.buttons)) {
                this.buttons.forEach(item -> {
                    JsonWrapper button = JsonWrapper.createObj()
                            .put("title", item.title)
                            .put("type", item.type)
                            .put("payload", item.payload);

                    buttons.add(button);
                });
            }

            JsonWrapper payload = JsonWrapper.createObj()
                    .put("buttons", buttons);
            JsonWrapper attachment = JsonWrapper.createObj()
                    .put("type", "template")
                    .put("payload", payload);
            message.put("attachment", attachment)
                    .put("text", title);

            return super.getMap();
        }
    }

    public static class MessageResult {

        private int errorCode;
        private String errorMsg;

        public MessageResult(int errorCode, String errorMsg) {
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }

        public MessageResult(int errorCode) {
            this.errorCode = errorCode;
        }

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMsg() {
            return errorMsg;
        }

        public void setErrorMsg(String errorMsg) {
            this.errorMsg = errorMsg;
        }

        @Override
        public String toString() {
            return "MessageResult{" + "errorCode=" + errorCode + ", errorMsg=" + errorMsg + '}';
        }
    }

    public static class UploadResult {

        public int error;
        public String message = "";
        public String attachmentId = "";

        public UploadResult(int error) {
            this.error = error;
        }

        @Override
        public String toString() {
            return "UploadResult{" + "error=" + error + ", message=" + message + ", attachmentId=" + attachmentId + '}';
        }

    }

    public static abstract class ButtonOA {

        protected final Logger LOG = ZLogger.getLogger(this.getClass());
        String title;
        String type;
        Object payload;

        public ButtonOA(String title, String type, Object payload) {
            this.title = title;
            this.type = type;
            this.payload = payload;
        }

        public JsonWrapper getJson() {
            return JsonWrapper.createObj()
                    .put("title", title)
                    .put("type", type)
                    .put("payload", payload);
        }

        public static final class OpenURLButton extends ButtonOA {
            public OpenURLButton(String title, String url) {
                super(title, "oa.open.url", JsonWrapper.createObj());
                try {
                    ((JsonWrapper) payload).put("url", url);
                } catch (Exception ex) {
                    LOG.error(ex.getMessage(), ex);
                }
            }
        }

        public static final class QueryShowButton extends ButtonOA {
            public QueryShowButton(String title) {
                super(title, "oa.query.show", "#callback_data");
            }
        }

        public static final class QueryHideButton extends ButtonOA {
            public QueryHideButton(String title) {
                super(title, "oa.query.hide", "#callback_data");
            }
        }

        public static final class OpenSmsButton extends ButtonOA {
            public OpenSmsButton(String title, String content, String phoneNumber) {
                super(title, "oa.open.sms", JsonWrapper.createObj());
                try {
                    ((JsonWrapper) payload).put("content", content);
                    ((JsonWrapper) payload).put("phone_code", phoneNumber);
                } catch (Exception ex) {
                    LOG.error(ex.getMessage(), ex);
                }
            }
        }

        public static final class OpenCallButton extends ButtonOA {
            public OpenCallButton(String title, String phoneNumber) {
                super(title, "oa.open.phone", JsonWrapper.createObj());
                try {
                    ((JsonWrapper) payload).put("phone_code", phoneNumber);
                } catch (Exception ex) {
                    LOG.error(ex.getMessage(), ex);
                }
            }
        }
    }
}