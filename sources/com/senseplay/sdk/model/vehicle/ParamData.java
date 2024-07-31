package com.senseplay.sdk.model.vehicle;

import android.content.Context;
import com.senseplay.sdk.tool.FileTool;
import com.senseplay.sdk.tool.IniEditor;
import java.io.File;

/* loaded from: classes2.dex */
public class ParamData {
    private Context context;
    private IniEditor inieditor = new IniEditor();

    public ParamData(Context context) {
        this.context = context;
    }

    public boolean open(String str, ParamEnum paramEnum) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            IniEditor iniEditor = new IniEditor();
            String str2 = "0000000001_A.ini";
            if (paramEnum == ParamEnum.NEW) {
                str2 = "0000000001_A.ini";
            } else if (paramEnum == ParamEnum.NORMAL) {
                str2 = "0000000003_A.ini";
            } else if (paramEnum == ParamEnum.MAJOR) {
                str2 = "0000000004_A.ini";
            }
            iniEditor.load(this.context.getResources().getAssets().open(str2));
            iniEditor.save(file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean load(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            IniEditor iniEditor = new IniEditor();
            iniEditor.load(this.context.getResources().getAssets().open("0000000001_B.ini"));
            iniEditor.save(file);
            this.inieditor.load(file);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public String get(String str, String str2) {
        IniEditor iniEditor = this.inieditor;
        return iniEditor == null ? "" : iniEditor.get(str, str2);
    }

    public boolean set(String str, String str2, String str3) {
        IniEditor iniEditor = this.inieditor;
        if (iniEditor == null) {
            return false;
        }
        try {
            iniEditor.set(str, str2, str3);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean save(String str, String str2) {
        if (this.inieditor == null) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdirs();
            }
            File file2 = new File(str, str2);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            this.inieditor.save(file2);
            FileTool.refreshFile(this.context, file2.getAbsolutePath());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
