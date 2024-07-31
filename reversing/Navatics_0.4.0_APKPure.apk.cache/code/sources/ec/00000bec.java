package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ContentLengthInputStream.java */
/* renamed from: com.bumptech.glide.util.b, reason: use source file name */
/* loaded from: classes.dex */
public final class ContentLengthInputStream extends FilterInputStream {

    /* renamed from: a */
    private final long f1296a;

    /* renamed from: b */
    private int f1297b;

    @NonNull
    /* renamed from: a */
    public static InputStream m1344a(@NonNull InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    private ContentLengthInputStream(@NonNull InputStream inputStream, long j) {
        super(inputStream);
        this.f1296a = j;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        return (int) Math.max(this.f1296a - this.f1297b, this.in.available());
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        int read;
        read = super.read();
        m1343a(read >= 0 ? 1 : -1);
        return read;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return m1343a(super.read(bArr, i, i2));
    }

    /* renamed from: a */
    private int m1343a(int i) throws IOException {
        if (i >= 0) {
            this.f1297b += i;
        } else if (this.f1296a - this.f1297b > 0) {
            throw new IOException("Failed to read all expected data, expected: " + this.f1296a + ", but read: " + this.f1297b);
        }
        return i;
    }
}