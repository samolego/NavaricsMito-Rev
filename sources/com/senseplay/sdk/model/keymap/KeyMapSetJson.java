package com.senseplay.sdk.model.keymap;

import com.senseplay.sdk.tool.SPUtilTool;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class KeyMapSetJson {
    private static final String HAS_CLICK = "_CLICK";
    private static final String HAS_DOUBLE_CLICK = "_DOUBLE_CLICK";
    private static final String HAS_LONG_PRESSE = "_PRESSED";
    private static final String JOYSTICK_KEY = "JOYSTICK_KEY";
    private static final String PRESSED = "_PRESSED";
    private static final String VIRTUL_GYRO = "VIRTUL_GYRO";
    private static final String WHEEL_KEY = "WHEEL_KEY";

    public static List<KeyMapSet> toKeySetSpecial(List<KeyMap> list, String str) throws Exception {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject(str).getJSONObject("RC_TYPE").getJSONObject("KEYSET");
        if (jSONObject == null || "{\"\":[\"\"]}".equals(jSONObject.toString())) {
            return arrayList;
        }
        List<String> specialKeyList = toSpecialKeyList(list);
        arrayList.add(getKeyMapSet(jSONObject, specialKeyList));
        if (jSONObject.has("JOYSTICK")) {
            arrayList.add(getKeyMapSet(jSONObject, specialKeyList, JOYSTICK_KEY, "JOYSTICK"));
        }
        if (jSONObject.has("GYRO")) {
            arrayList.add(getKeyMapSet(jSONObject, specialKeyList, VIRTUL_GYRO, "GYRO"));
        }
        if (jSONObject.has("WHEEL")) {
            arrayList.add(getKeyMapSet(jSONObject, specialKeyList, WHEEL_KEY, "WHEEL"));
        }
        return arrayList;
    }

    private static List<String> toSpecialKeyList(List<KeyMap> list) {
        ArrayList arrayList = new ArrayList();
        if (SPUtilTool.isExtNull(list)) {
            return arrayList;
        }
        for (int i = 0; i < list.size(); i++) {
            KeyMap keyMap = list.get(i);
            arrayList.add(keyMap.getEVENT());
            List<KeyMapConditions> conditions = keyMap.getCONDITIONS();
            if (!SPUtilTool.isExtNull(conditions)) {
                for (KeyMapConditions keyMapConditions : conditions) {
                    arrayList.add(keyMapConditions.getCONDITION_TYPE());
                }
            }
            List<KeyMapParams> params = keyMap.getPARAMS();
            if (!SPUtilTool.isExtNull(params)) {
                for (KeyMapParams keyMapParams : params) {
                    String value = keyMapParams.getVALUE();
                    if ("ANALOG".equals(keyMapParams.getTYPE())) {
                        arrayList.add(value);
                    }
                }
            }
        }
        return arrayList;
    }

    private static KeyMapSet getKeyMapSet(JSONObject jSONObject, List<String> list) throws JSONException {
        KeyMapSet keyMapSet = new KeyMapSet();
        keyMapSet.setKeymap_type("BUTTON_KEY");
        JSONArray jSONArray = jSONObject.getJSONArray("KEY");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            KeyMapSetVal keyMapSetVal = new KeyMapSetVal();
            keyMapSetVal.setKey(jSONArray.getString(i) + "_PRESSED");
            keyMapSetVal.setValue(toValue(list, jSONArray.getString(i)));
            arrayList.add(keyMapSetVal);
        }
        JSONArray jSONArray2 = jSONObject.getJSONArray("KEY_JOYSTICK");
        for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
            KeyMapSetVal keyMapSetVal2 = new KeyMapSetVal();
            String string = jSONArray2.getString(i2);
            keyMapSetVal2.setKey(string + "_PRESSED");
            keyMapSetVal2.setValue(toValue(list, string));
            arrayList.add(keyMapSetVal2);
        }
        keyMapSet.setValArray(arrayList);
        return keyMapSet;
    }

    private static KeyMapSet getKeyMapSet(JSONObject jSONObject, List<String> list, String str, String str2) throws JSONException {
        KeyMapSet keyMapSet = new KeyMapSet();
        keyMapSet.setKeymap_type(str);
        JSONArray jSONArray = jSONObject.getJSONArray(str2);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            KeyMapSetVal keyMapSetVal = new KeyMapSetVal();
            String string = jSONArray.getString(i);
            keyMapSetVal.setKey(string);
            if (JOYSTICK_KEY.equals(str)) {
                keyMapSetVal.setValue(toJostickValue(list, string));
            } else if (VIRTUL_GYRO.equals(str)) {
                keyMapSetVal.setValue(toGyroValue(list, string));
            } else if (WHEEL_KEY.equals(str)) {
                keyMapSetVal.setValue(toValue(list, string));
            }
            arrayList.add(keyMapSetVal);
        }
        keyMapSet.setValArray(arrayList);
        return keyMapSet;
    }

    private static String toValue(List<String> list, String str) {
        String str2 = hasEvent(list, str, HAS_CLICK) ? "01" : "00";
        String str3 = hasEvent(list, str, HAS_DOUBLE_CLICK) ? "01" : "00";
        String str4 = hasEvent(list, str, "_PRESSED") ? "01" : "00";
        return str2 + str3 + str4;
    }

    private static String toGyroValue(List<String> list, String str) {
        if ("G0".equals(str)) {
            return "000001";
        }
        String str2 = hasGyroPress(list, str) ? "01" : "00";
        return "0000" + str2;
    }

    private static String toJostickValue(List<String> list, String str) {
        if (SPUtilTool.isExtNull(list) || SPUtilTool.isNull(str)) {
            return "000000";
        }
        String str2 = "";
        String str3 = "";
        String[] strArr = {"UP", "UR", "RT", "RD", "DN", "DL", "LT", "LU"};
        for (int length = strArr.length - 1; length >= 0; length--) {
            Map<String, String> jostickClick = toJostickClick(list, str, strArr[length]);
            str2 = str2 + jostickClick.get("clickStr");
            str3 = str3 + jostickClick.get("longPressStr");
        }
        return KeyMapTool.binTo16Hex(str2) + "00" + KeyMapTool.binTo16Hex(str3);
    }

    private static boolean hasEvent(List<String> list, String str, String str2) {
        if (SPUtilTool.isExtNull(list) || SPUtilTool.isNull(str)) {
            return false;
        }
        return list.contains(str + str2);
    }

    private static Map<String, String> toJostickClick(List<String> list, String str, String str2) {
        String str3;
        String str4;
        HashMap hashMap = new HashMap();
        if (SPUtilTool.isExtNull(list) || SPUtilTool.isNull(str)) {
            str3 = "0";
            str4 = "0";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append("_");
            sb.append(str2);
            sb.append(HAS_CLICK);
            str3 = list.contains(sb.toString()) ? "1" : "0";
            if (!list.contains(str + "_" + str2 + "_LONG_PRESS")) {
                if (!list.contains(str + "_" + str2 + "_PRESSED")) {
                    str4 = "0";
                }
            }
            str4 = "1";
        }
        hashMap.put("clickStr", str3);
        hashMap.put("longPressStr", str4);
        return hashMap;
    }

    private static boolean hasGyroPress(List<String> list, String str) {
        if (SPUtilTool.isExtNull(list) || SPUtilTool.isNull(str)) {
            return false;
        }
        if (!list.contains(str + "_X")) {
            if (!list.contains(str + "_Y")) {
                if (!list.contains(str + "_Z")) {
                    return false;
                }
            }
        }
        return true;
    }
}
