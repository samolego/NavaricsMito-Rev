package com.bumptech.glide.load.p018a;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.p022a.ArrayPool;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.bumptech.glide.load.a.c */
/* loaded from: classes.dex */
public final class BufferedOutputStream extends OutputStream {
    @NonNull

    /* renamed from: a */
    private final OutputStream f568a;

    /* renamed from: b */
    private byte[] f569b;

    /* renamed from: c */
    private ArrayPool f570c;

    /* renamed from: d */
    private int f571d;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull ArrayPool arrayPool) {
        this(outputStream, arrayPool, 65536);
    }

    @VisibleForTesting
    BufferedOutputStream(@NonNull OutputStream outputStream, ArrayPool arrayPool, int i) {
        this.f568a = outputStream;
        this.f570c = arrayPool;
        this.f569b = (byte[]) arrayPool.mo12200a(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f569b;
        int i2 = this.f571d;
        this.f571d = i2 + 1;
        bArr[i2] = (byte) i;
        m12408b();
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public void write(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        do {
            int i4 = i2 - i3;
            int i5 = i + i3;
            if (this.f571d == 0 && i4 >= this.f569b.length) {
                this.f568a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f569b.length - this.f571d);
            System.arraycopy(bArr, i5, this.f569b, this.f571d, min);
            this.f571d += min;
            i3 += min;
            m12408b();
        } while (i3 < i2);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        m12409a();
        this.f568a.flush();
    }

    /* renamed from: a */
    private void m12409a() throws IOException {
        int i = this.f571d;
        if (i > 0) {
            this.f568a.write(this.f569b, 0, i);
            this.f571d = 0;
        }
    }

    /* renamed from: b */
    private void m12408b() throws IOException {
        if (this.f571d == this.f569b.length) {
            m12409a();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f568a.close();
            m12407c();
        } catch (Throwable th) {
            this.f568a.close();
            throw th;
        }
    }

    /* renamed from: c */
    private void m12407c() {
        byte[] bArr = this.f569b;
        if (bArr != null) {
            this.f570c.mo12195a((ArrayPool) bArr);
            this.f569b = null;
        }
    }
}
