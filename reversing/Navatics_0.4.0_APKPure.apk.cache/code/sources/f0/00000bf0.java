package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkEnforcingInputStream.java */
/* renamed from: com.bumptech.glide.util.f, reason: use source file name */
/* loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a */
    private int f1306a;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f1306a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f1306a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m1358a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        m1359b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int m1358a = (int) m1358a(i2);
        if (m1358a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, m1358a);
        m1359b(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f1306a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long m1358a = m1358a(j);
        if (m1358a == -1) {
            return 0L;
        }
        long skip = super.skip(m1358a);
        m1359b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f1306a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    /* renamed from: a */
    private long m1358a(long j) {
        int i = this.f1306a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    /* renamed from: b */
    private void m1359b(long j) {
        int i = this.f1306a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f1306a = (int) (i - j);
    }
}