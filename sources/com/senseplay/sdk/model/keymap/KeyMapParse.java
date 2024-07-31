package com.senseplay.sdk.model.keymap;

import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.tool.SPUtilTool;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class KeyMapParse {
    private static final String ANALOG = "ANALOG";
    private static final String COMMAND_DRIVE = "COMMAND_DRIVE";
    private static final String EVENT_DRIVE = "EVENT_DRIVE";
    public static final String SET_KEYMAP = "SET_KEYMAP";
    private static final String TRANSPARENT = "TRANSPARENT";
    public static final String style_china = "CHINA";
    public static final String style_japan = "JAPAN";
    public static final String style_usa = "USA";

    private static Map<String, String> getJsonMap(String str, String str2) throws Exception {
        HashMap hashMap = new HashMap();
        hashMap.putAll(KeyMapJson.toKeyCodeMap(str));
        hashMap.putAll(KeyMapJson.toCommandMap(str2));
        return hashMap;
    }

    public static String parse(String str, String str2, String str3, String str4, String str5, String str6) throws Exception {
        SPDebug.m5807w("keymap", "rc_settings: " + str);
        SPDebug.m5807w("keymap", "keycodeStr: " + str2);
        SPDebug.m5807w("keymap", "commandStr: " + str3);
        SPDebug.m5807w("keymap", "oprateStr: " + str4);
        SPDebug.m5807w("keymap", "category: " + str5);
        SPDebug.m5807w("keymap", "style: " + str6);
        if (SPUtilTool.isNull(str2) || SPUtilTool.isNull(str3) || SPUtilTool.isNull(str6) || SPUtilTool.isNull(str4)) {
            SPDebug.m5807w("keymap", "keymap data error");
            return "";
        }
        Map<String, String> jsonMap = getJsonMap(str2, str3);
        List<KeyMap> keymapList = KeyMapJson.toKeymapList(str4);
        String str7 = toString(jsonMap, SET_KEYMAP) + toString(jsonMap, "SET_KEYMAP_ver") + toString(jsonMap, str5);
        Map<String, Object> keyMapSet = setKeyMapSet(keymapList, jsonMap, str);
        int integer = SPUtilTool.toInteger(keyMapSet.get("set_size"));
        String str8 = "" + SPUtilTool.toString(keyMapSet.get("set_result"));
        for (KeyMap keyMap : keymapList) {
            KeyMapFormat keyMapFormat = new KeyMapFormat();
            keyMapFormat.setCommand(toString(jsonMap, keyMap.getCOMMAND()));
            keyMapFormat.setCommand_ver(toString(jsonMap, keyMap.getCOMMAND() + KeyMapJson.ver));
            if (EVENT_DRIVE.equals(keyMap.getKEYMAP_TYPE())) {
                keyMapFormat.setKeymap_type(toString(jsonMap, keyMap.getKEYMAP_TYPE()));
                keyMapFormat.setEvent(toString(jsonMap, keyMap.getEVENT()));
                setConditions(jsonMap, keyMap.getCONDITIONS(), keyMapFormat);
                setParam(jsonMap, keyMap.getPARAMS(), str6, keyMapFormat);
                str8 = str8 + keyMapFormat.toKeyMapString();
                SPDebug.m5807w("keymap", keyMapFormat.toKeyMapString());
            } else if (COMMAND_DRIVE.equals(keyMap.getKEYMAP_TYPE())) {
                keyMapFormat.setKeymap_type(toString(jsonMap, keyMap.getKEYMAP_TYPE()));
                setConditions(jsonMap, keyMap.getCONDITIONS(), keyMapFormat);
                setParam(jsonMap, keyMap.getPARAMS(), str6, keyMapFormat);
                str8 = str8 + keyMapFormat.toKeyMapString();
                SPDebug.m5807w("keymap", keyMapFormat.toKeyMapString());
            }
        }
        String keyMap2 = CommandTool.toKeyMap(str7, keymapList.size() + integer, str8);
        SPDebug.m5807w("keymap string ", keyMap2);
        return keyMap2;
    }

    private static Map<String, Object> setKeyMapSet(List<KeyMap> list, Map<String, String> map, String str) throws Exception {
        HashMap hashMap = new HashMap();
        String str2 = "";
        List<KeyMapSet> keySetSpecial = KeyMapSetJson.toKeySetSpecial(list, str);
        for (KeyMapSet keyMapSet : keySetSpecial) {
            keyMapSet.setKeymap_type(toString(map, keyMapSet.getKeymap_type()));
            List<KeyMapSetVal> valArray = keyMapSet.getValArray();
            String str3 = "";
            for (KeyMapSetVal keyMapSetVal : valArray) {
                str3 = str3 + toString(map, keyMapSetVal.getKey()) + keyMapSetVal.getValue();
                SPDebug.m5807w("values", toString(map, keyMapSetVal.getKey()) + keyMapSetVal.getValue());
            }
            keyMapSet.setKey_count(valArray.size());
            keyMapSet.setValues(str3);
            str2 = str2 + keyMapSet.toKeymapSetString();
            SPDebug.m5807w("keymapset", keyMapSet.toKeymapSetString());
        }
        hashMap.put("set_size", Integer.valueOf(keySetSpecial.size()));
        hashMap.put("set_result", str2);
        return hashMap;
    }

    private static void setConditions(Map<String, String> map, List<KeyMapConditions> list, KeyMapFormat keyMapFormat) {
        if (list == null || list.isEmpty()) {
            return;
        }
        keyMapFormat.setCondition_count(list.size());
        String str = "";
        for (KeyMapConditions keyMapConditions : list) {
            str = ((str + toString(map, keyMapConditions.getCONDITION_JUDGE_TYPE())) + toString(map, keyMapConditions.getCONDITION_TYPE())) + toString(map, keyMapConditions.getCONDITION_VALUE());
        }
        keyMapFormat.setOptional_conditions(str);
    }

    private static void setParam(Map<String, String> map, List<KeyMapParams> list, String str, KeyMapFormat keyMapFormat) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String str2 = "";
        int i = 0;
        String str3 = "";
        int i2 = 0;
        for (KeyMapParams keyMapParams : list) {
            String value = keyMapParams.getVALUE();
            if (ANALOG.equals(keyMapParams.getTYPE())) {
                i++;
                str2 = str2 + toString(map, value);
            } else if (TRANSPARENT.equals(keyMapParams.getTYPE())) {
                i2++;
                str3 = str3 + value;
            } else if (keyMapParams.getOP_STYLE() != null) {
                if (style_japan.equals(str)) {
                    keyMapParams.getOP_STYLE().getJAPAN();
                } else if (style_usa.equals(str)) {
                    keyMapParams.getOP_STYLE().getUSA();
                } else if (style_china.equals(str)) {
                    keyMapParams.getOP_STYLE().getCHINA();
                }
            }
        }
        keyMapFormat.setAnalog_count(i);
        keyMapFormat.setAnalog_params(str2);
        keyMapFormat.setTransparent_count(i2);
        keyMapFormat.setTransparent_params(str3);
    }

    private static String toString(Map<String, String> map, String str) {
        if (map == null || str == null || "".equals(str)) {
            return null;
        }
        String str2 = map.get(str);
        return str2 == null ? "" : str2.replace("0x", "");
    }
}
