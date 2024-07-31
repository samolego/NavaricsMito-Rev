package com.adapt;

import com.jnilib.CppSDKConnectors;

/* loaded from: classes.dex */
public class SPM_Manager {
    private static SPM_Manager mInatance;
    private SPM_Device mSPM_Device = new SPM_Device();
    private SPM_Rc mSPM_Rc = new SPM_Rc();
    private SPM_Keymap mSPM_Key = new SPM_Keymap();
    private SPM_Camera mSPM_Cam = new SPM_Camera();
    private SPM_HeartbeatExt mSPM_HeartbeatExt = new SPM_HeartbeatExt();
    private SMP_UserCmd mSMP_UserCmd = new SMP_UserCmd();
    private SPM_DebugApis mSPM_DebugApis = new SPM_DebugApis();
    private SPM_Aircraft mSPM_Aircraft = new SPM_Aircraft();
    private SPM_Dfm mSPM_Dfm = new SPM_Dfm();
    private SPM_Ar mSPM_Ar = new SPM_Ar();

    private SPM_Manager() {
    }

    public static SPM_Manager GetInstance() {
        synchronized (SPM_Manager.class) {
            if (mInatance == null) {
                mInatance = new SPM_Manager();
            }
        }
        return mInatance;
    }

    public String GetSDKVersion() {
        return CppSDKConnectors.sdkVersion();
    }

    public String GetBuildDate() {
        return CppSDKConnectors.BuildDate();
    }

    public SPM_Device GetDevice() {
        return this.mSPM_Device;
    }

    public SPM_Rc GetRc() {
        return this.mSPM_Rc;
    }

    public SPM_Keymap GetKeymap() {
        return this.mSPM_Key;
    }

    public SPM_Camera GetCamera() {
        return this.mSPM_Cam;
    }

    public SMP_UserCmd GetUserCmd() {
        return this.mSMP_UserCmd;
    }

    public SPM_HeartbeatExt GetHeartbeatExt() {
        return this.mSPM_HeartbeatExt;
    }

    public SPM_DebugApis GetmDebugApis() {
        return this.mSPM_DebugApis;
    }

    public SPM_Dfm GetDfm() {
        return this.mSPM_Dfm;
    }

    public SPM_Ar GetAr() {
        return this.mSPM_Ar;
    }
}
