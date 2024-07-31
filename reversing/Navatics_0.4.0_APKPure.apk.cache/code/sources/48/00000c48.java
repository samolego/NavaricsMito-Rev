package com.config;

import android.util.Log;
import com.adapt.SPM_Manager;
import java.io.File;

/* loaded from: classes.dex */
public class ConfigManager {
    private static ConfigManager mInatance;
    private SysConfigs mSysConfigs;

    private ConfigManager() {
        SpSdkDirectory.folderCreated();
    }

    public static ConfigManager GetInstance() {
        synchronized (SPM_Manager.class) {
            if (mInatance == null) {
                mInatance = new ConfigManager();
            }
        }
        return mInatance;
    }

    public SysConfigs GetConfigsFormFile() {
        String sdkConfigsString = SpSdkDirectory.getSdkConfigsString();
        Log.v("SYS_CONFIG", "read file: - \n" + sdkConfigsString);
        if (sdkConfigsString != null) {
            SysConfigs configsFormJson = SysConfigs.getConfigsFormJson(sdkConfigsString);
            if (configsFormJson != null) {
                this.mSysConfigs = configsFormJson;
                Log.v("SYS_CONFIG", "Get sys info form json  file - \n" + this.mSysConfigs.toString());
            } else {
                this.mSysConfigs = SysConfigs.getDefault();
                Log.v("SYS_CONFIG", "Get sys default info  - \n" + this.mSysConfigs.toString());
            }
        } else {
            this.mSysConfigs = SysConfigs.getDefault();
            Log.v("SYS_CONFIG", "Get sys default info  - \n" + this.mSysConfigs.toString());
        }
        File file = new File(SpSdkDirectory.sdkEnvironmentVariableFile);
        if (file.exists()) {
            file.delete();
        }
        SpSdkDirectory.saveSdkConfigToFile(SysConfigs.convertObjectToJsonString(this.mSysConfigs));
        return this.mSysConfigs;
    }

    public SysConfigs getConfig() {
        return this.mSysConfigs;
    }
}