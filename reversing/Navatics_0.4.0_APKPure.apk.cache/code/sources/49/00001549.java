package com.misc;

import com.adapt.SPM_Rc;

/* loaded from: classes.dex */
public class FakeCmd {
    public static int SendFakeCmd(byte[] bArr) {
        byte[] bArr2 = {-81, -82, 0, 9, 0, 7, 0, -17, -1, 0, 0, 2, SPM_Rc.VIBRATION_MODE.PLAY_ONCE, 1, -2, -2};
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        return bArr2.length;
    }
}