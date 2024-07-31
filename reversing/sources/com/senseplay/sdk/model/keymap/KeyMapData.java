package com.senseplay.sdk.model.keymap;

import android.content.Context;
import android.content.SharedPreferences;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.mframe.json.MJson;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.tool.SPUtilTool;

/* loaded from: classes2.dex */
public class KeyMapData {
    public static final String FILE_RC = "FILE_RC";
    public static final String IS_WRITE = "IS_WRITE";
    private static final String KEYMAP = "KeyMapData";
    public static final String KEY_MAP_TIME = "KEY_MAP_TIME";
    public static final String KEY_MAP_TIME_CHG = "KEY_MAP_TIME_CHG";
    public static final String SP_COMMANDS = "SP_COMMANDS";
    public static final String SP_FILE_JSON = "SP_FILE_JSON";
    public static final String SP_KEYCODES = "SP_KEYCODES";
    private KeyMapFileHttp http;
    private Context mContext;

    public KeyMapData(Context context, String str) {
        this.mContext = context;
        this.http = new KeyMapFileHttp(context);
    }

    public static void save(Context context, String str, String str2) {
        if (SPUtilTool.isNull(str2)) {
            SPDebug.m5816d("name: " + str + " value: " + str2);
            return;
        }
        context.getSharedPreferences(KEYMAP, 0).edit().putString(str, str2).commit();
    }

    public static String get(Context context, String str) {
        return context.getSharedPreferences(KEYMAP, 0).getString(str, "");
    }

    public static boolean getB(Context context, String str) {
        return context.getSharedPreferences(KEYMAP, 0).getBoolean(str, false);
    }

    public static void saveB(Context context, String str, boolean z) {
        context.getSharedPreferences(KEYMAP, 0).edit().putBoolean(str, z).commit();
    }

    public static boolean has(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(KEYMAP, 0);
        return (SPUtilTool.isNull(sharedPreferences.getString(SP_KEYCODES, "")) || SPUtilTool.isNull(sharedPreferences.getString(SP_COMMANDS, ""))) ? false : true;
    }

    public void init(String str, String str2, String str3) {
        if (SPUtilTool.isNull(str3)) {
            return;
        }
        if (this.http == null) {
            this.http = new KeyMapFileHttp(this.mContext);
        }
        this.http.getAllFile(str, str2, str3, new MCallBack<String>() { // from class: com.senseplay.sdk.model.keymap.KeyMapData.1
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(String str4) {
                KeyMapData.this.parse(str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void parse(String str) {
        try {
            save(this.mContext, SP_FILE_JSON, str);
            KeyMapFile keyMapFile = (KeyMapFile) MJson.jsonToObj(str, KeyMapFile.class);
            if (keyMapFile != null) {
                String str2 = "";
                if (keyMapFile.getFile_rc() != null) {
                    getFileJson(FILE_RC, keyMapFile.getFile_rc().getUrl());
                    str2 = "" + keyMapFile.getFile_rc().getLastupdate();
                }
                if (keyMapFile.getFile_keycode() != null) {
                    getFileJson(SP_KEYCODES, keyMapFile.getFile_keycode().getUrl());
                    str2 = str2 + keyMapFile.getFile_keycode().getLastupdate();
                }
                if (keyMapFile.getFile_command() != null) {
                    getFileJson(SP_COMMANDS, keyMapFile.getFile_command().getUrl());
                    str2 = str2 + keyMapFile.getFile_command().getLastupdate();
                }
                KeyMapFileType file_keymap = keyMapFile.getFile_keymap();
                if (file_keymap != null) {
                    if (file_keymap.getDEVICE() != null) {
                        getFileJson(Category.DEVICE.toString(), file_keymap.getDEVICE().getUrl());
                        str2 = str2 + file_keymap.getDEVICE().getLastupdate();
                    }
                    if (file_keymap.getVEHICLE() != null) {
                        getFileJson(Category.VEHICLE.toString(), file_keymap.getVEHICLE().getUrl());
                        str2 = str2 + file_keymap.getVEHICLE().getLastupdate();
                    }
                    if (file_keymap.getDRONE() != null) {
                        getFileJson(Category.DRONE.toString(), file_keymap.getDRONE().getUrl());
                        str2 = str2 + file_keymap.getDRONE().getLastupdate();
                    }
                    if (file_keymap.getMARINE() != null) {
                        getFileJson(Category.MARINE.toString(), file_keymap.getMARINE().getUrl());
                        str2 = str2 + file_keymap.getMARINE().getLastupdate();
                    }
                }
                save(this.mContext, KEY_MAP_TIME, str2);
                SPDebug.m5816d(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getFileJson(final String str, final String str2) {
        SPDebug.m5807w("url", str2);
        if (SPUtilTool.isNull(str2)) {
            return;
        }
        if (this.http == null) {
            this.http = new KeyMapFileHttp(this.mContext);
        }
        this.http.getFileJson(str2, new MCallBack<String>() { // from class: com.senseplay.sdk.model.keymap.KeyMapData.2
            @Override // com.senseplay.mframe.client.MCallBack
            public void onResult(String str3) {
                KeyMapData.save(KeyMapData.this.mContext, str, str3);
                SPDebug.m5807w("url", str);
                SPDebug.m5807w("url", str2);
                SPDebug.m5807w("getFileJson:  ", "" + str3);
            }
        });
    }
}
