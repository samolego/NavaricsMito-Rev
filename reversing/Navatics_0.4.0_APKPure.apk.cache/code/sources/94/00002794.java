package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import android.support.v4.view.InputDeviceCompat;
import java.nio.ByteBuffer;

/* compiled from: BitWriterBuffer.java */
/* renamed from: org.mp4parser.boxes.iso14496.part1.objectdescriptors.b, reason: use source file name */
/* loaded from: classes2.dex */
public class BitWriterBuffer {

    /* renamed from: c */
    static final /* synthetic */ boolean f12139c = !BitWriterBuffer.class.desiredAssertionStatus();

    /* renamed from: a */
    int f12140a;

    /* renamed from: b */
    int f12141b = 0;

    /* renamed from: d */
    private ByteBuffer f12142d;

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        this.f12142d = byteBuffer;
        this.f12140a = byteBuffer.position();
    }

    /* renamed from: a */
    public void m12292a(int i, int i2) {
        int i3;
        if (!f12139c && i > (i3 = (1 << i2) - 1)) {
            throw new AssertionError(String.format("Trying to write a value bigger (%s) than the number bits (%s) allows. Please mask the value before writing it and make your code is really working as intended.", Integer.valueOf(i), Integer.valueOf(i3)));
        }
        int i4 = this.f12141b;
        int i5 = 8 - (i4 % 8);
        if (i2 <= i5) {
            int i6 = this.f12142d.get(this.f12140a + (i4 / 8));
            if (i6 < 0) {
                i6 += 256;
            }
            int i7 = i6 + (i << (i5 - i2));
            ByteBuffer byteBuffer = this.f12142d;
            int i8 = this.f12140a + (this.f12141b / 8);
            if (i7 > 127) {
                i7 += InputDeviceCompat.SOURCE_ANY;
            }
            byteBuffer.put(i8, (byte) i7);
            this.f12141b += i2;
        } else {
            int i9 = i2 - i5;
            m12292a(i >> i9, i5);
            m12292a(i & ((1 << i9) - 1), i9);
        }
        ByteBuffer byteBuffer2 = this.f12142d;
        int i10 = this.f12140a;
        int i11 = this.f12141b;
        byteBuffer2.position(i10 + (i11 / 8) + (i11 % 8 > 0 ? 1 : 0));
    }
}