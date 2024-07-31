package com.senseplay.sdk.model.keymap;

import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.tool.SPUtilTool;

/* loaded from: classes2.dex */
public class CommandTool {
    private static int command_id = 0;
    private static int command_id_max = 127;

    private static String getCommandId() {
        int i = command_id;
        if (i >= command_id_max) {
            command_id = 0;
        } else {
            command_id = i + 1;
        }
        return KeyMapTool.to16Hex(command_id);
    }

    private static String getCommandLength(String str) {
        if (SPUtilTool.isNull(str)) {
            return "00";
        }
        int length = str.length() / 2;
        if (length > 255) {
            return "ff0" + KeyMapTool.to16Hex(length);
        } else if (length > 4095) {
            return "ff" + KeyMapTool.to16Hex(length);
        } else {
            return KeyMapTool.to16Hex(length);
        }
    }

    public static String toKeyMap(String str, int i, String str2) {
        SPDebug.m5807w("size ", "" + i);
        SPDebug.m5807w("head ", str);
        SPDebug.m5807w("head ", str + KeyMapTool.to16Hex(i));
        return str + KeyMapTool.to16Hex(i) + str2;
    }
}
