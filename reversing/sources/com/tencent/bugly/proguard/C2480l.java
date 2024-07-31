package com.tencent.bugly.proguard;

import com.adapt.SPM_Rc;
import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.l */
/* loaded from: classes2.dex */
public final class C2480l {
    /* renamed from: a */
    public static boolean m5196a(int i, int i2) {
        return i == i2;
    }

    /* renamed from: a */
    public static boolean m5195a(long j, long j2) {
        return j == j2;
    }

    /* renamed from: a */
    public static boolean m5192a(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: a */
    public static boolean m5194a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static byte[] m5193a(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.position()];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, bArr.length);
        return bArr;
    }

    static {
        byte[] bArr = {SPM_Rc.VIBRATION_MODE.CYCLE_MODE, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
    }
}
