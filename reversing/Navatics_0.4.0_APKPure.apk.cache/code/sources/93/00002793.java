package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import java.nio.ByteBuffer;

/* compiled from: BitReaderBuffer.java */
/* renamed from: org.mp4parser.boxes.iso14496.part1.objectdescriptors.a, reason: use source file name */
/* loaded from: classes2.dex */
public class BitReaderBuffer {

    /* renamed from: a */
    int f12136a;

    /* renamed from: b */
    int f12137b;

    /* renamed from: c */
    private ByteBuffer f12138c;

    public BitReaderBuffer(ByteBuffer byteBuffer) {
        this.f12138c = byteBuffer;
        this.f12136a = byteBuffer.position();
    }

    /* renamed from: a */
    public int m12291a(int i) {
        int m12291a;
        int i2 = this.f12138c.get(this.f12136a + (this.f12137b / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = this.f12137b;
        int i4 = 8 - (i3 % 8);
        if (i <= i4) {
            m12291a = ((i2 << (i3 % 8)) & 255) >> ((i3 % 8) + (i4 - i));
            this.f12137b = i3 + i;
        } else {
            int i5 = i - i4;
            m12291a = (m12291a(i4) << i5) + m12291a(i5);
        }
        this.f12138c.position(this.f12136a + ((int) Math.ceil(this.f12137b / 8.0d)));
        return m12291a;
    }
}