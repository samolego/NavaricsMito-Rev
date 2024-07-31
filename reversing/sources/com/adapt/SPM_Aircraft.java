package com.adapt;

import com.jnilib.CppSDKConnectors;

/* loaded from: classes.dex */
public class SPM_Aircraft {
    public int TakeOff() {
        return CppSDKConnectors.TakeOff();
    }

    public int Landing() {
        return CppSDKConnectors.Landing();
    }

    public int SetHomePosition(byte[] bArr) {
        return CppSDKConnectors.SetHomePosition(bArr);
    }

    public int ReturnHome() {
        return CppSDKConnectors.ReturnHome();
    }
}
