package org.mp4parser.streaming.input.h264.spspps;

import java.io.IOException;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.f */
/* loaded from: classes2.dex */
public class ScalingList {

    /* renamed from: a */
    public int[] f12295a;

    /* renamed from: b */
    public boolean f12296b;

    /* renamed from: a */
    public static ScalingList m416a(ByteBufferBitreader byteBufferBitreader, int i) throws IOException {
        ScalingList scalingList = new ScalingList();
        scalingList.f12295a = new int[i];
        int i2 = 0;
        int i3 = 8;
        int i4 = 8;
        while (i2 < i) {
            if (i3 != 0) {
                i3 = ((byteBufferBitreader.m424e() + i4) + 256) % 256;
                scalingList.f12296b = i2 == 0 && i3 == 0;
            }
            int[] iArr = scalingList.f12295a;
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i2] = i4;
            i4 = scalingList.f12295a[i2];
            i2++;
        }
        return scalingList;
    }

    public String toString() {
        return "ScalingList{scalingList=" + this.f12295a + ", useDefaultScalingMatrixFlag=" + this.f12296b + '}';
    }
}
