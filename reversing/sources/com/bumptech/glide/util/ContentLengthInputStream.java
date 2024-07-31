package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.util.b */
/* loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a */
    private final long f1292a;

    /* renamed from: b */
    private int f1293b;

    @NonNull
    /* renamed from: a */
    public static InputStream m11600a(@NonNull InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f1292a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f1292a - this.f1293b, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        m11601a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return m11601a(super.read(bArr, i, i2));
    }

    /* renamed from: a */
    private int m11601a(int i) throws IOException {
        if (i >= 0) {
            this.f1293b += i;
        } else if (this.f1292a - this.f1293b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f1292a + ", but read: " + this.f1293b);
        }
        return i;
    }
}
