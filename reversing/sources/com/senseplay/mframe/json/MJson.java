package com.senseplay.mframe.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.senseplay.mframe.tool.MUtilTool;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class MJson {
    public static String toJson(Object obj) {
        try {
            return new Gson().toJson(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static <T> T jsonToObj(JSONObject jSONObject, Class<T> cls) {
        if (jSONObject != null) {
            try {
                return (T) new Gson().fromJson(jSONObject.toString(), (Class<Object>) cls);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static <T> T jsonToObj(String str, Class<T> cls) {
        try {
            return (T) new Gson().fromJson(str, (Class<Object>) cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> List<T> jsonToList(JSONObject jSONObject, Class<T> cls) {
        if (jSONObject != null) {
            try {
                return (List) new Gson().fromJson(jSONObject.toString(), new TypeToken<ArrayList<T>>() { // from class: com.senseplay.mframe.json.MJson.1
                }.getType());
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public static <T> List<T> jsonToList(String str, Type type) {
        try {
            return (List) new Gson().fromJson(str, type);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonObject parseObj(String str) {
        try {
            return new JsonParser().parse(str).getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JsonArray parseArray(String str) {
        try {
            return new JsonParser().parse(str).getAsJsonArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getJson(String str) {
        JsonObject parseObj;
        return (MUtilTool.isNull(str) || (parseObj = parseObj(str)) == null) ? "" : parseObj.get("data").toString();
    }
}
