package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.util.f */
/* loaded from: classes.dex */
public class MarkEnforcingInputStream extends FilterInputStream {

    /* renamed from: a */
    private int f1302a;

    public MarkEnforcingInputStream(@NonNull InputStream inputStream) {
        super(inputStream);
        this.f1302a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void mark(int i) {
        super.mark(i);
        this.f1302a = i;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (m11584a(1L) == -1) {
            return -1;
        }
        int read = super.read();
        m11583b(1L);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(@NonNull byte[] bArr, int i, int i2) throws IOException {
        int m11584a = (int) m11584a(i2);
        if (m11584a == -1) {
            return -1;
        }
        int read = super.read(bArr, i, m11584a);
        m11583b(read);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized void reset() throws IOException {
        super.reset();
        this.f1302a = Integer.MIN_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j) throws IOException {
        long m11584a = m11584a(j);
        if (m11584a == -1) {
            return 0L;
        }
        long skip = super.skip(m11584a);
        m11583b(skip);
        return skip;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        int i = this.f1302a;
        return i == Integer.MIN_VALUE ? super.available() : Math.min(i, super.available());
    }

    /* renamed from: a */
    private long m11584a(long j) {
        int i = this.f1302a;
        if (i == 0) {
            return -1L;
        }
        return (i == Integer.MIN_VALUE || j <= ((long) i)) ? j : i;
    }

    /* renamed from: b */
    private void m11583b(long j) {
        int i = this.f1302a;
        if (i == Integer.MIN_VALUE || j == -1) {
            return;
        }
        this.f1302a = (int) (i - j);
    }
}
