package com.navatics.robot.utils;

import com.adapt.SPM_Rc;

/* compiled from: HexUtil.java */
/* renamed from: com.navatics.robot.utils.g, reason: use source file name */
/* loaded from: classes2.dex */
public class HexUtil {

    /* renamed from: a */
    private static final char[] f6795a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b */
    private static final char[] f6796b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static char[] m6964a(byte[] bArr) {
        return m6966a(bArr, 0, bArr.length, true);
    }

    /* renamed from: a */
    public static char[] m6965a(byte[] bArr, int i, int i2) {
        return m6966a(bArr, i, i2, true);
    }

    /* renamed from: a */
    public static char[] m6966a(byte[] bArr, int i, int i2, boolean z) {
        return m6967a(bArr, i, i2, z ? f6795a : f6796b);
    }

    /* renamed from: a */
    protected static char[] m6967a(byte[] bArr, int i, int i2, char[] cArr) {
        char[] cArr2 = new char[i2 << 1];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i3 + 1;
            int i6 = i + i4;
            cArr2[i3] = cArr[(bArr[i6] & 240) >>> 4];
            i3 = i5 + 1;
            cArr2[i5] = cArr[bArr[i6] & SPM_Rc.VIBRATION_MODE.MAX_VOLUME];
        }
        return cArr2;
    }
}