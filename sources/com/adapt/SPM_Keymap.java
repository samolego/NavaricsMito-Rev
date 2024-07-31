package com.adapt;

import com.jnilib.CppSDKConnectors;

/* loaded from: classes.dex */
public class SPM_Keymap {
    public boolean Write(byte[] bArr) {
        return CppSDKConnectors.KeymapWrite(bArr);
    }

    public boolean WriteResult() {
        return CppSDKConnectors.KeymapWriteResult();
    }
}
