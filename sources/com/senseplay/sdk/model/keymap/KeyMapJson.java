package com.senseplay.sdk.model.keymap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.senseplay.sdk.tool.SPUtilTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class KeyMapJson {
    public static final String ver = "_ver";

    private static void log(Map<String, String> map, String str) {
    }

    public static List<KeyMapSet> toKeySetMap(String str) throws Exception {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(str).getJSONObject("RC_TYPE").getJSONObject("KEYSET_SPECIAL");
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            KeyMapSet keyMapSet = new KeyMapSet();
            keyMapSet.setKeymap_type(next);
            JSONObject jSONObject2 = jSONObject.getJSONObject(next);
            Iterator<String> keys2 = jSONObject2.keys();
            ArrayList arrayList2 = new ArrayList();
            while (keys2.hasNext()) {
                String next2 = keys2.next();
                KeyMapSetVal keyMapSetVal = new KeyMapSetVal();
                keyMapSetVal.setKey(next2);
                keyMapSetVal.setValue(jSONObject2.getString(next2));
                arrayList2.add(keyMapSetVal);
            }
            keyMapSet.setValArray(arrayList2);
            keyMapSet.setKey_count(arrayList2.size());
            arrayList.add(keyMapSet);
        }
        return arrayList;
    }

    public static Map<String, String> toKeyCodeMap(String str) throws Exception {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, jSONObject.getJSONObject(next).getString("CODE"));
        }
        return hashMap;
    }

    public static Map<String, String> toCommandMap(String str) throws Exception {
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if ("COMMAND".equals(next)) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                Iterator<String> keys2 = jSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    hashMap.put(next2, jSONObject2.getJSONObject(next2).getString("CODE"));
                    hashMap.put(next2 + ver, jSONObject2.getJSONObject(next2).getString("VER"));
                    log(hashMap, next2);
                }
            } else {
                JSONObject jSONObject3 = jSONObject.getJSONObject(next);
                Iterator<String> keys3 = jSONObject3.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    hashMap.put(next3, jSONObject3.getString(next3));
                    log(hashMap, next3);
                }
            }
        }
        return hashMap;
    }

    public static List<KeyMap> toKeymapList(String str) {
        if (SPUtilTool.isNull(str) || "[]".equals(str)) {
            return new ArrayList();
        }
        return (List) new Gson().fromJson(str, new TypeToken<ArrayList<KeyMap>>() { // from class: com.senseplay.sdk.model.keymap.KeyMapJson.1
        }.getType());
    }
}
