package com.adapt;

import com.common.SP_ACK;
import com.jnilib.CppSDKConnectors;

/* loaded from: classes.dex */
public class SMP_UserCmd {
    public SP_ACK GetAckInfo() {
        byte[] bArr = new byte[256];
        if (CppSDKConnectors.GetAckData(bArr) == 0) {
            SP_ACK sp_ack = new SP_ACK();
            sp_ack.fill(bArr);
            return sp_ack;
        }
        return null;
    }

    public int SendCmd(byte b, byte[] bArr) {
        return CppSDKConnectors.SendUserCmd(b, bArr);
    }

    public int SendCmd(byte b, byte[] bArr, int i, int i2) {
        return CppSDKConnectors.SendUserCmd2(b, bArr, i, i2);
    }
}
