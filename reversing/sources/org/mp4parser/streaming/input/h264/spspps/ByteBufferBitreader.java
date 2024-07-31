package org.mp4parser.streaming.input.h264.spspps;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* renamed from: org.mp4parser.streaming.input.h264.spspps.b */
/* loaded from: classes2.dex */
public class ByteBufferBitreader {

    /* renamed from: a */
    ByteBuffer f12247a;

    /* renamed from: b */
    int f12248b;

    /* renamed from: c */
    private int f12249c = m429a();

    /* renamed from: d */
    private int f12250d = m429a();

    public ByteBufferBitreader(ByteBuffer byteBuffer) {
        this.f12247a = byteBuffer;
    }

    /* renamed from: a */
    public int m429a() {
        try {
            byte b = this.f12247a.get();
            return b < 0 ? b + 256 : b;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public int m427b() throws IOException {
        if (this.f12248b == 8) {
            m422g();
            if (this.f12249c == -1) {
                return -1;
            }
        }
        int i = this.f12249c;
        int i2 = this.f12248b;
        int i3 = (i >> (7 - i2)) & 1;
        this.f12248b = i2 + 1;
        return i3;
    }

    /* renamed from: g */
    private void m422g() throws IOException {
        this.f12249c = this.f12250d;
        this.f12250d = m429a();
        this.f12248b = 0;
    }

    /* renamed from: c */
    public int m426c() throws IOException {
        int i = 0;
        while (m427b() == 0) {
            i++;
        }
        if (i > 0) {
            return (int) (((1 << i) - 1) + m428a(i));
        }
        return 0;
    }

    /* renamed from: a */
    public long m428a(int i) throws IOException {
        if (i <= 64) {
            long j = 0;
            for (int i2 = 0; i2 < i; i2++) {
                j = (j << 1) | m427b();
            }
            return j;
        }
        throw new IllegalArgumentException("Can not readByte more then 64 bit");
    }

    /* renamed from: d */
    public boolean m425d() throws IOException {
        return m427b() != 0;
    }

    /* renamed from: e */
    public int m424e() throws IOException {
        int m426c = m426c();
        int i = m426c & 1;
        return ((m426c >> 1) + i) * ((i << 1) - 1);
    }

    /* renamed from: f */
    public boolean m423f() throws IOException {
        if (this.f12248b == 8) {
            m422g();
        }
        int i = 1 << ((8 - this.f12248b) - 1);
        return (this.f12249c == -1 || (this.f12250d == -1 && ((((i << 1) - 1) & this.f12249c) == i))) ? false : true;
    }
}
