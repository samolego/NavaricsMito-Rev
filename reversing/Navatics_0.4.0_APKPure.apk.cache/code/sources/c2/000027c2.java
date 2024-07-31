package org.mp4parser.streaming.input.h264.spspps;

import java.io.IOException;

/* compiled from: ScalingList.java */
/* renamed from: org.mp4parser.streaming.input.h264.spspps.f, reason: use source file name */
/* loaded from: classes2.dex */
public class ScalingList {

    /* renamed from: a */
    public int[] f12336a;

    /* renamed from: b */
    public boolean f12337b;

    /* renamed from: a */
    public static ScalingList m12401a(ByteBufferBitreader byteBufferBitreader, int i) throws IOException {
        ScalingList scalingList = new ScalingList();
        scalingList.f12336a = new int[i];
        int i2 = 0;
        int i3 = 8;
        int i4 = 8;
        while (i2 < i) {
            if (i3 != 0) {
                i3 = ((byteBufferBitreader.m12394e() + i4) + 256) % 256;
                scalingList.f12337b = i2 == 0 && i3 == 0;
            }
            int[] iArr = scalingList.f12336a;
            if (i3 != 0) {
                i4 = i3;
            }
            iArr[i2] = i4;
            i4 = scalingList.f12336a[i2];
            i2++;
        }
        return scalingList;
    }

    public String toString() {
        return "ScalingList{scalingList=" + this.f12336a + ", useDefaultScalingMatrixFlag=" + this.f12337b + '}';
    }
}