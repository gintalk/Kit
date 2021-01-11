package com.vng.zing.media.mp3.test.kit.test.common;

import com.jsoniter.JsonIterator;
import com.jsoniter.ValueType;
import com.jsoniter.any.Any;
import com.jsoniter.output.JsonStream;
import com.jsoniter.spi.TypeLiteral;
import com.vng.zing.logger.ZLogger;
import com.vng.zing.media.common.utils.LogUtils;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author locnt3
 */
public class JsonWrapper {
    private static final Logger LOG = ZLogger.getLogger(JsonWrapper.class);
    private Map<String, Any> _mData;

    public JsonWrapper put(String key, Object value) {
        _mData.put(key, Any.wrap(value));
        return this;
    }

    public static int getInt(Any any, String key, int defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.toInt();
    }

    public static String getString(Any any, String key, String defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.toString();
    }

    public static long getLong(Any any, String key, long defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.toLong();
    }

    public static double getDouble(Any any, String key, double defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.toDouble();
    }

    public static boolean getBool(Any any, String key, boolean defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.toBoolean();
    }

    public static List<Integer> getInts(Any any, String key, List<Integer> defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.as(new TypeLiteral<List<Integer>>() {
        });
    }

    public static List<Long> getLongs(Any any, String key, List<Long> defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.as(new TypeLiteral<List<Long>>() {
        });
    }

    public static List<String> getStrings(Any any, String key, List<String> defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.as(new TypeLiteral<List<String>>() {
        });
    }

    public static Set<Integer> getInts(Any any, String key, Set<Integer> defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.as(new TypeLiteral<Set<Integer>>() {
        });
    }

    public static Set<Long> getLongs(Any any, String key, Set<Long> defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.as(new TypeLiteral<Set<Long>>() {
        });
    }

    public static Set<String> getStrings(Any any, String key, Set<String> defaultValue) {
        Any get = any.get(key);
        if (ValueType.INVALID.equals(get.valueType())) {
            return defaultValue;
        }
        return get.as(new TypeLiteral<Set<String>>() {
        });
    }

    public String toString() {
        return JsonStream.serialize(_mData);
    }

    JsonWrapper() {
        _mData = new HashMap<>();
    }

    JsonWrapper(Map<String, Any> _mData) {
        this._mData = _mData;
    }
    
    

    public static JsonWrapper build(String jsonString) {
        try {
            Any rs = JsonIterator.deserialize(jsonString);
            return new JsonWrapper(rs.asMap());
        } catch (Exception ex) {
            LOG.error(LogUtils.buildTabLog("Exception"), ex);
            return null;
        }
    }

    public static JsonWrapper build() {
        return new JsonWrapper();
    }
}
