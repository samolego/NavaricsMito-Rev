package org.mp4parser.boxes.iso14496.part1.objectdescriptors;

import java.nio.ByteBuffer;

/* renamed from: org.mp4parser.boxes.iso14496.part1.objectdescriptors.a */
/* loaded from: classes2.dex */
public class BitReaderBuffer {

    /* renamed from: a */
    int f12095a;

    /* renamed from: b */
    int f12096b;

    /* renamed from: c */
    private ByteBuffer f12097c;

    public BitReaderBuffer(ByteBuffer byteBuffer) {
        this.f12097c = byteBuffer;
        this.f12095a = byteBuffer.position();
    }

    /* renamed from: a */
    public int m528a(int i) {
        int m528a;
        int i2 = this.f12097c.get(this.f12095a + (this.f12096b / 8));
        if (i2 < 0) {
            i2 += 256;
        }
        int i3 = this.f12096b;
        int i4 = 8 - (i3 % 8);
        if (i <= i4) {
            m528a = ((i2 << (i3 % 8)) & 255) >> ((i3 % 8) + (i4 - i));
            this.f12096b = i3 + i;
        } else {
            int i5 = i - i4;
            m528a = (m528a(i4) << i5) + m528a(i5);
        }
        this.f12097c.position(this.f12095a + ((int) Math.ceil(this.f12096b / 8.0d)));
        return m528a;
    }
}
