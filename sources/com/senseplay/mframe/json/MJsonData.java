package com.senseplay.mframe.json;

import com.google.gson.JsonObject;
import com.senseplay.mframe.tool.MUtilTool;

/* loaded from: classes2.dex */
public class MJsonData {
    public static String getJson(String str) {
        JsonObject parseObj;
        return (MUtilTool.isNull(str) || (parseObj = MJson.parseObj(str)) == null) ? "" : parseObj.get("data").toString();
    }

    public static String getJsonString(String str) {
        JsonObject parseObj;
        return (MUtilTool.isNull(str) || (parseObj = MJson.parseObj(str)) == null) ? "" : parseObj.getAsJsonObject("data").get("data").toString();
    }

    public static JsonObject getJsonObj(String str) {
        JsonObject parseObj;
        if (MUtilTool.isNull(str) || (parseObj = MJson.parseObj(str)) == null) {
            return null;
        }
        return parseObj.getAsJsonObject("data");
    }

    public static JsonObject getJsonObject(String str) {
        JsonObject parseObj;
        if (MUtilTool.isNull(str) || (parseObj = MJson.parseObj(str)) == null) {
            return null;
        }
        return parseObj.getAsJsonObject("data").getAsJsonObject("data");
    }
}
