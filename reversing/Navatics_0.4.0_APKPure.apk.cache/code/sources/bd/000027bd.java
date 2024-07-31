package org.mp4parser.streaming.input.h264.spspps;

import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

/* compiled from: ByteBufferBitreader.java */
/* renamed from: org.mp4parser.streaming.input.h264.spspps.b, reason: use source file name */
/* loaded from: classes2.dex */
public class ByteBufferBitreader {

    /* renamed from: a */
    ByteBuffer f12288a;

    /* renamed from: b */
    int f12289b;

    /* renamed from: c */
    private int f12290c = m12389a();

    /* renamed from: d */
    private int f12291d = m12389a();

    public ByteBufferBitreader(ByteBuffer byteBuffer) {
        this.f12288a = byteBuffer;
    }

    /* renamed from: a */
    public int m12389a() {
        try {
            byte b = this.f12288a.get();
            return b < 0 ? b + 256 : b;
        } catch (BufferUnderflowException unused) {
            return -1;
        }
    }

    /* renamed from: b */
    public int m12391b() throws IOException {
        if (this.f12289b == 8) {
            m12388g();
            if (this.f12290c == -1) {
                return -1;
            }
        }
        int i = this.f12290c;
        int i2 = this.f12289b;
        int i3 = (i >> (7 - i2)) & 1;
        this.f12289b = i2 + 1;
        return i3;
    }

    /* renamed from: g */
    private void m12388g() throws IOException {
        this.f12290c = this.f12291d;
        this.f12291d = m12389a();
        this.f12289b = 0;
    }

    /* renamed from: c */
    public int m12392c() throws IOException {
        int i = 0;
        while (m12391b() == 0) {
            i++;
        }
        if (i > 0) {
            return (int) (((1 << i) - 1) + m12390a(i));
        }
        return 0;
    }

    /* renamed from: a */
    public long m12390a(int i) throws IOException {
        if (i > 64) {
            throw new IllegalArgumentException("Can not readByte more then 64 bit");
        }
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 1) | m12391b();
        }
        return j;
    }

    /* renamed from: d */
    public boolean m12393d() throws IOException {
        return m12391b() != 0;
    }

    /* renamed from: e */
    public int m12394e() throws IOException {
        int m12392c = m12392c();
        return ((m12392c >> 1) + (m12392c & 1)) * ((r1 << 1) - 1);
    }

    /* renamed from: f */
    public boolean m12395f() throws IOException {
        if (this.f12289b == 8) {
            m12388g();
        }
        int i = 1 << ((8 - this.f12289b) - 1);
        return (this.f12290c == -1 || (this.f12291d == -1 && ((((i << 1) - 1) & this.f12290c) == i))) ? false : true;
    }
}