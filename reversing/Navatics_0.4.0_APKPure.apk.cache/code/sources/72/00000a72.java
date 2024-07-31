package com.bumptech.glide.load.p014a;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.p018a.InterfaceC0624b;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BufferedOutputStream.java */
/* renamed from: com.bumptech.glide.load.a.c, reason: use source file name */
/* loaded from: classes.dex */
public final class BufferedOutputStream extends OutputStream {

    /* renamed from: a */
    @NonNull
    private final OutputStream f572a;

    /* renamed from: b */
    private byte[] f573b;

    /* renamed from: c */
    private InterfaceC0624b f574c;

    /* renamed from: d */
    private int f575d;

    public BufferedOutputStream(@NonNull OutputStream outputStream, @NonNull InterfaceC0624b interfaceC0624b) {
        this(outputStream, interfaceC0624b, 65536);
    }

    @VisibleForTesting
    BufferedOutputStream(@NonNull OutputStream outputStream, InterfaceC0624b interfaceC0624b, int i) {
        this.f572a = outputStream;
        this.f574c = interfaceC0624b;
        this.f573b = (byte[]) interfaceC0624b.mo756a(i, byte[].class);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.f573b;
        int i2 = this.f575d;
        this.f575d = i2 + 1;
        bArr[i2] = (byte) i;
        m591b();
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
            if (this.f575d == 0 && i4 >= this.f573b.length) {
                this.f572a.write(bArr, i5, i4);
                return;
            }
            int min = Math.min(i4, this.f573b.length - this.f575d);
            System.arraycopy(bArr, i5, this.f573b, this.f575d, min);
            this.f575d += min;
            i3 += min;
            m591b();
        } while (i3 < i2);
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        m590a();
        this.f572a.flush();
    }

    /* renamed from: a */
    private void m590a() throws IOException {
        int i = this.f575d;
        if (i > 0) {
            this.f572a.write(this.f573b, 0, i);
            this.f575d = 0;
        }
    }

    /* renamed from: b */
    private void m591b() throws IOException {
        if (this.f575d == this.f573b.length) {
            m590a();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            flush();
            this.f572a.close();
            m592c();
        } catch (Throwable th) {
            this.f572a.close();
            throw th;
        }
    }

    /* renamed from: c */
    private void m592c() {
        byte[] bArr = this.f573b;
        if (bArr != null) {
            this.f574c.mo759a((InterfaceC0624b) bArr);
            this.f573b = null;
        }
    }
}