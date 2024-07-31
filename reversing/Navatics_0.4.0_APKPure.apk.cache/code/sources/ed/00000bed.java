package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* compiled from: ExceptionCatchingInputStream.java */
/* renamed from: com.bumptech.glide.util.c, reason: use source file name */
/* loaded from: classes.dex */
public class ExceptionCatchingInputStream extends InputStream {

    /* renamed from: a */
    private static final Queue<ExceptionCatchingInputStream> f1298a = C0781i.m1377a(0);

    /* renamed from: b */
    private InputStream f1299b;

    /* renamed from: c */
    private IOException f1300c;

    @NonNull
    /* renamed from: a */
    public static ExceptionCatchingInputStream m1345a(@NonNull InputStream inputStream) {
        ExceptionCatchingInputStream poll;
        synchronized (f1298a) {
            poll = f1298a.poll();
        }
        if (poll == null) {
            poll = new ExceptionCatchingInputStream();
        }
        poll.m1348b(inputStream);
        return poll;
    }

    ExceptionCatchingInputStream() {
    }

    /* renamed from: b */
    void m1348b(@NonNull InputStream inputStream) {
        this.f1299b = inputStream;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f1299b.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f1299b.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f1299b.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f1299b.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f1299b.read(bArr);
        } catch (IOException e) {
            this.f1300c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        try {
            return this.f1299b.read(bArr, i, i2);
        } catch (IOException e) {
            this.f1300c = e;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f1299b.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        try {
            return this.f1299b.skip(j);
        } catch (IOException e) {
            this.f1300c = e;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f1299b.read();
        } catch (IOException e) {
            this.f1300c = e;
            return -1;
        }
    }

    @Nullable
    /* renamed from: a */
    public IOException m1346a() {
        return this.f1300c;
    }

    /* renamed from: b */
    public void m1347b() {
        this.f1300c = null;
        this.f1299b = null;
        synchronized (f1298a) {
            f1298a.offer(this);
        }
    }
}