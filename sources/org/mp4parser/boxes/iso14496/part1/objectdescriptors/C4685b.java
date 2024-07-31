package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import android.support.p008v4.view.InputDeviceCompat;
import java.nio.ByteBuffer;

/* renamed from: org.mp4parser.boxes.iso14496.part1.objectdescriptors.b */
/* loaded from: classes2.dex */
public class BitWriterBuffer {

    /* renamed from: c */
    static final /* synthetic */ boolean f12098c = !BitWriterBuffer.class.desiredAssertionStatus();

    /* renamed from: a */
    int f12099a;

    /* renamed from: b */
    int f12100b = 0;

    /* renamed from: d */
    private ByteBuffer f12101d;

    public BitWriterBuffer(ByteBuffer byteBuffer) {
        this.f12101d = byteBuffer;
        this.f12099a = byteBuffer.position();
    }

    /* renamed from: a */
    public void m527a(int i, int i2) {
        int i3;
        if (!f12098c && i > (i3 = (1 << i2) - 1)) {
            throw new AssertionError(String.format("Trying to write a value bigger (%s) than the number bits (%s) allows. Please mask the value before writing it and make your code is really working as intended.", Integer.valueOf(i), Integer.valueOf(i3)));
        }
        int i4 = this.f12100b;
        int i5 = 8 - (i4 % 8);
        if (i2 <= i5) {
            int i6 = this.f12101d.get(this.f12099a + (i4 / 8));
            if (i6 < 0) {
                i6 += 256;
            }
            int i7 = i6 + (i << (i5 - i2));
            ByteBuffer byteBuffer = this.f12101d;
            int i8 = this.f12099a + (this.f12100b / 8);
            if (i7 > 127) {
                i7 += InputDeviceCompat.SOURCE_ANY;
            }
            byteBuffer.put(i8, (byte) i7);
            this.f12100b += i2;
        } else {
            int i9 = i2 - i5;
            m527a(i >> i9, i5);
            m527a(i & ((1 << i9) - 1), i9);
        }
        ByteBuffer byteBuffer2 = this.f12101d;
        int i10 = this.f12099a;
        int i11 = this.f12100b;
        byteBuffer2.position(i10 + (i11 / 8) + (i11 % 8 > 0 ? 1 : 0));
    }
}
