package com.senseplay.sdk;

import android.content.Context;
import android.util.Log;
import com.adapt.SPM_Keymap;
import com.adapt.SPM_Manager;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.log.SPDebug;
import com.senseplay.sdk.model.keymap.Category;
import com.senseplay.sdk.model.keymap.KeyMapData;
import com.senseplay.sdk.model.keymap.KeyMapParse;
import com.senseplay.sdk.model.keymap.OpStyle;
import com.senseplay.sdk.model.keymap.PackUtil;
import com.senseplay.sdk.tool.HandleOpe;

/* loaded from: classes2.dex */
public class SPKeyMap {
    private static SPKeyMap spKeyMap;
    private KeyMapData data;
    private SPM_Manager spm_manager = SPM_Manager.GetInstance();
    private Context mContext = SPManager.getContent();

    public static SPKeyMap getInstance() {
        if (spKeyMap == null) {
            synchronized (SPKeyMap.class) {
                if (spKeyMap == null) {
                    spKeyMap = new SPKeyMap();
                }
            }
        }
        return spKeyMap;
    }

    private SPKeyMap() {
    }

    public void init(String str) {
        this.data = new KeyMapData(SPManager.getContent(), "");
        this.data.init(SPManager.getClientId(), "", str);
    }

    public void init(String str, String str2) {
        this.data = new KeyMapData(SPManager.getContent(), "");
        this.data.init(SPManager.getClientId(), str, str2);
    }

    public boolean isChg() {
        String str = KeyMapData.get(this.mContext, KeyMapData.KEY_MAP_TIME);
        String str2 = KeyMapData.get(this.mContext, KeyMapData.KEY_MAP_TIME_CHG);
        Log.w("isChg", "time   : " + str);
        Log.w("isChg", "timeChg: " + str2);
        if ("".equals(str2) || str2 == null) {
            KeyMapData.save(this.mContext, KeyMapData.KEY_MAP_TIME_CHG, str);
            return true;
        } else if (str2.equals(str)) {
            return !KeyMapData.getB(this.mContext, KeyMapData.IS_WRITE);
        } else {
            KeyMapData.save(this.mContext, KeyMapData.KEY_MAP_TIME_CHG, str);
            return true;
        }
    }

    public String getKeyMapJson(Category category, OpStyle opStyle) {
        try {
            return KeyMapParse.parse(KeyMapData.get(this.mContext, KeyMapData.FILE_RC), KeyMapData.get(this.mContext, KeyMapData.SP_KEYCODES), KeyMapData.get(this.mContext, KeyMapData.SP_COMMANDS), KeyMapData.get(this.mContext, category.toString()), category.toString(), opStyle.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void writeKeyMap(String str, final MCallBack<Boolean> mCallBack) {
        if (str == null || "".equals(str)) {
            SPDebug.m5816d("no keymap");
            mCallBack.onResult(false);
        }
        final SPM_Keymap GetKeymap = this.spm_manager.GetKeymap();
        GetKeymap.Write(PackUtil.pack(str));
        HandleOpe.postDelayed(new HandleOpe.OpeListener() { // from class: com.senseplay.sdk.SPKeyMap.1
            @Override // com.senseplay.sdk.tool.HandleOpe.OpeListener
            public void run() {
                boolean WriteResult = GetKeymap.WriteResult();
                if (WriteResult) {
                    KeyMapData.saveB(SPKeyMap.this.mContext, KeyMapData.IS_WRITE, true);
                }
                mCallBack.onResult(Boolean.valueOf(WriteResult));
            }
        }, 2000);
    }
}
