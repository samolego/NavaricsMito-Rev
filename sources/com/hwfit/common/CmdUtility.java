package com.hwfit.common;

import com.common.SP_Util;
import com.jnilib.CppSDKConnectors;
import com.log.C1513log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CmdUtility {
    private static int AOA_PKT_DATA_LIMIT = 400;
    private static final String TAG = "CMD_UTILITY";
    private static List<byte[]> cmdList;

    public static byte[] getSingleCmd(int i) {
        byte[] bArr = new byte[5120];
        int RcRead = CppSDKConnectors.RcRead(bArr);
        if (RcRead == 0) {
            return null;
        }
        int i2 = RcRead % 4;
        byte[] bArr2 = new byte[(i2 == 0 ? 0 : 4 - i2) + RcRead];
        System.arraycopy(bArr, 0, bArr2, 0, RcRead);
        return bArr2;
    }

    public static byte[] creatSingleAOA_Pkts() {
        if (cmdList == null) {
            cmdList = new ArrayList();
        }
        while (true) {
            byte[] singleCmd = getSingleCmd(13);
            if (singleCmd == null) {
                break;
            }
            cmdList.add(singleCmd);
        }
        if (cmdList.size() == 0) {
            return null;
        }
        if (C1513log.CMD_DG) {
            C1513log.send(TAG, "List Size: " + cmdList.size());
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= cmdList.size()) {
                break;
            } else if (cmdList.get(i).length + i2 < AOA_PKT_DATA_LIMIT) {
                i2 += cmdList.get(i).length;
                i++;
            } else if (i == 0) {
                i2 += cmdList.get(i).length;
            }
        }
        if (C1513log.CMD_DG) {
            C1513log.send(TAG, "totalSize: " + i2);
        }
        byte[] bArr = new byte[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            System.arraycopy(cmdList.get(i4), 0, bArr, i3, cmdList.get(i4).length);
            i3 += cmdList.get(i4).length;
        }
        if (C1513log.CMD_DG) {
            C1513log.send(TAG, "temp size: " + bArr.length);
        }
        for (int i5 = 0; i5 < i; i5++) {
            cmdList.remove(0);
        }
        if (C1513log.SEND_CMD_HEX_DG) {
            C1513log.send(TAG, "DATA: " + SP_Util.byte2str(bArr));
        }
        byte[] createProtocolPkt = createProtocolPkt(133, (byte) 1, (byte) 0, bArr, bArr.length);
        int length = createProtocolPkt.length % 4;
        byte[] bArr2 = new byte[createProtocolPkt.length + (length == 0 ? 0 : 4 - length)];
        System.arraycopy(createProtocolPkt, 0, bArr2, 0, createProtocolPkt.length);
        return bArr2;
    }

    public static byte[] createProtocolPkt(int i, byte b, byte b2, byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2 + 10];
        bArr2[0] = -1;
        bArr2[1] = 90;
        bArr2[2] = (byte) (i & 255);
        bArr2[3] = (byte) ((i >> 8) & 255);
        bArr2[4] = b;
        bArr2[5] = b2;
        bArr2[6] = (byte) (i2 & 255);
        bArr2[7] = (byte) ((i2 >> 8) & 255);
        if (bArr != null && i2 != 0) {
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 += bArr[i4] & 255;
                bArr2[i4 + 10] = bArr[i4];
            }
            int i5 = i3 & 65535;
            bArr2[8] = (byte) (i5 & 255);
            bArr2[9] = (byte) ((i5 >> 8) & 255);
        } else {
            bArr2[8] = 0;
            bArr2[9] = 0;
        }
        return bArr2;
    }

    public static byte[] createProtocolPkt(int i, byte b, byte b2) {
        return createProtocolPkt(i, b, b2, null, 0);
    }
}
