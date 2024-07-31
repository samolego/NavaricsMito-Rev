package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.bumptech.glide.util.c */
/* loaded from: classes.dex */
public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: a */
    private static final Queue<ExceptionCatchingInputStream> f1294a = C0791i.m11572a(0);

    /* renamed from: b */
    private InputStream f1295b;

    /* renamed from: c */
    private IOException f1296c;

    @NonNull
    /* renamed from: a */
    public static ExceptionCatchingInputStream m11598a(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        synchronized (f1294a) {
            poll = f1294a.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.m11596b(inputStream);
        return poll;
    }

    ExceptionCatchingInputStream() {
    }

    /* renamed from: b */
    void m11596b(@NonNull InputStream inputStream) {
        this.f1295b = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f1295b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1295b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f1295b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f1295b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f1295b.read(bArr);
        } catch (IOException e) {
            this.f1296c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f1295b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f1296c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f1295b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f1295b.skip(j);
        } catch (IOException e) {
            this.f1296c = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f1295b.read();
        } catch (IOException e) {
            this.f1296c = e;
            return -1;
        }
    }

    @Nullable
    /* renamed from: a */
    public IOException m11599a() {
        return this.f1296c;
    }

    /* renamed from: b */
    public void m11597b() {
        this.f1296c = null;
        this.f1295b = null;
        synchronized (f1294a) {
            f1294a.offer(this);
        }
    }
}
