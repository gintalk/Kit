/*
 * Copyright (c) 2012-2016 by Zalo Group.
 * All Rights Reserved.
 */
package com.vng.zing.media.mp3.test.kit.test.common;

import com.vng.zing.media.common.utils.CommonUtils;
import com.vng.zing.media.common.utils.ConvertUtils;
import com.vng.zing.media.mp3.common.thrift.TZMP3OAAction;
import com.vng.zing.media.mp3.common.thrift.oa.core.TZMP3OAFeature;
import org.apache.thrift.TBase;
import org.apache.thrift.TFieldIdEnum;
import org.apache.thrift.TFieldRequirementType;
import org.apache.thrift.meta_data.FieldMetaData;
import org.apache.thrift.meta_data.FieldValueMetaData;
import org.apache.thrift.protocol.TType;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author namnh16
 */
public class PrintUtils {

    private static final Map<Byte, String> MAP_TYPE_STRING = new HashMap<Byte, String>() {
        {
            put(TType.VOID, "void");
            put(TType.BOOL, "boolean");
            put(TType.BYTE, "byte");
            put(TType.DOUBLE, "double");
            put(TType.I16, "short");
            put(TType.I32, "int");
            put(TType.I64, "long");
            put(TType.STRING, "String");
            put(TType.STRUCT, "STRUCT");
            put(TType.MAP, "Map");
            put(TType.SET, "Set");
            put(TType.LIST, "List");
            put(TType.ENUM, "ENUM");
        }
    };
    private static short MAX_TYPE_STRING_LENGTH = 0;

    private PrintUtils() {

    }

    public static void printTBase(TBase thriftObject) {
        System.out.println(_getStructAsString(0, thriftObject));
    }

    public static void printOAAccountPermission(Map<Integer, Set<Integer>> featureMap) {
        featureMap.forEach((featureID, actionSet) -> {
            TZMP3OAFeature feature = TZMP3OAFeature.findByValue(featureID);
            if (feature != null) {
                System.out.printf("%s:", feature.name());
                actionSet.forEach(actionID -> {
                    TZMP3OAAction action = TZMP3OAAction.findByValue(actionID);
                    if (action != null) {
                        System.out.printf(" %s", action.name());
                    }
                });
                System.out.println();
            }
        });
    }

    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    // Private
    // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    private static String _getStructAsString(int level, TBase thriftObject) {
        if (thriftObject == null) {
            return "";
        }

        try {
            Class clazz = thriftObject.getClass();
            StringBuilder sBuilder = new StringBuilder(clazz.getSimpleName());
            sBuilder.append(":\n");

            Map metaDataMap = (Map) clazz.getDeclaredField("metaDataMap").get(null);
            if (CommonUtils.isEmpty(metaDataMap)) {
                sBuilder.append("[fields empty]\n");
                return sBuilder.toString();
            }

            for (Object obj : metaDataMap.keySet()) {
                FieldMetaData fieldMetaData = (FieldMetaData) metaDataMap.get(obj);
                FieldValueMetaData valueMetadata = fieldMetaData.valueMetaData;

                String typeName = _getTTypeAsString(clazz, fieldMetaData, valueMetadata).trim();
                if (typeName.length() - 2 > MAX_TYPE_STRING_LENGTH) {
                    MAX_TYPE_STRING_LENGTH = ConvertUtils.toShort(typeName.length() - 2);
                }
            }

            for (Object obj : metaDataMap.keySet()) {
                TFieldIdEnum fieldEnum = (TFieldIdEnum) obj;
                FieldMetaData fieldMetaData = (FieldMetaData) metaDataMap.get(obj);
                FieldValueMetaData valueMetadata = fieldMetaData.valueMetaData;

                sBuilder.append("    ");
                sBuilder.append(_getTRequirementTypeAsString(fieldMetaData.requirementType));
                sBuilder.append(" ");
                sBuilder.append(_getTTypeAsString(clazz, fieldMetaData, valueMetadata));
                sBuilder.append(" ");

                sBuilder.append(fieldEnum.getFieldName());
                sBuilder.append(": ");
                sBuilder.append(thriftObject.getFieldValue(thriftObject.fieldForId(fieldEnum.getThriftFieldId())));
                sBuilder.append("\n");
            }

            return sBuilder.toString();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return "";
        }
    }

    private static String _getTRequirementTypeAsString(int requirementTypeValue) {
        switch (requirementTypeValue) {
            case TFieldRequirementType.REQUIRED:
                return "(REQUIRED)";
            case TFieldRequirementType.OPTIONAL:
                return "(OPTIONAL)";
            case TFieldRequirementType.DEFAULT:
                return "(DEFAULT) ";
            default:
                return "()        ";
        }
    }

    private static String _getTTypeAsString(Class<TBase> clazz, FieldMetaData fieldMetaData, FieldValueMetaData valueMetaData) throws NoSuchFieldException {
        byte typeValue = valueMetaData.type;

        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("(");

        String typeName;
        switch (typeValue) {
            case TType.STRUCT:
            case TType.ENUM:
                typeName = clazz.getDeclaredField(fieldMetaData.fieldName).getType().getSimpleName();
                break;
            case TType.LIST:
            case TType.SET:
                Field field = clazz.getDeclaredField(fieldMetaData.fieldName);
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();

                String parameterName;
                if (parameterizedType.getActualTypeArguments()[0] instanceof ParameterizedType) {
                    parameterName = parameterizedType.getActualTypeArguments()[0].getTypeName();
                } else {
                    parameterName = ((Class) parameterizedType.getActualTypeArguments()[0]).getSimpleName();
                }

                typeName = MAP_TYPE_STRING.get(typeValue) + "<" + parameterName + ">";
                break;
            case TType.MAP:
                Field mapField = clazz.getDeclaredField(fieldMetaData.fieldName);
                ParameterizedType mapPT = (ParameterizedType) mapField.getGenericType();

                String keyParameterName;
                if (mapPT.getActualTypeArguments()[0] instanceof ParameterizedType) {
                    keyParameterName = mapPT.getActualTypeArguments()[0].getTypeName();
                } else {
                    keyParameterName = ((Class) mapPT.getActualTypeArguments()[0]).getSimpleName();
                }

                String valueParameterName;
                if (mapPT.getActualTypeArguments()[1] instanceof ParameterizedType) {
                    valueParameterName = mapPT.getActualTypeArguments()[1].getTypeName();
                } else {
                    valueParameterName = ((Class) mapPT.getActualTypeArguments()[1]).getSimpleName();
                }

                typeName = MAP_TYPE_STRING.get(typeValue) + "<" + keyParameterName + ", " + valueParameterName + ">";
                break;
            default:
                typeName = MAP_TYPE_STRING.get(typeValue);
                break;
        }

        sBuilder.append(typeName);
        sBuilder.append(")");
        for (int i = 0; i < (MAX_TYPE_STRING_LENGTH - typeName.length()); i++) {
            sBuilder.append(" ");
        }

        return sBuilder.toString();
    }
}
