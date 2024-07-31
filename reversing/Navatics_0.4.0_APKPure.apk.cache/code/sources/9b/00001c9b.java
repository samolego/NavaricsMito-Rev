package com.navatics.robot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: RingBuf.java */
/* renamed from: com.navatics.robot.utils.l, reason: use source file name */
/* loaded from: classes2.dex */
public class RingBuf {

    /* renamed from: a */
    private LockFreeRingBufferImpl f6807a;

    /* renamed from: b */
    private a f6808b;

    /* renamed from: c */
    private b f6809c;

    /* renamed from: d */
    private boolean f6810d;

    public RingBuf(int i) {
        this.f6807a = new LockFreeRingBufferImpl(i);
    }

    /* renamed from: a */
    public synchronized InputStream m6984a() {
        if (this.f6808b == null) {
            this.f6808b = new a();
        }
        return this.f6808b;
    }

    /* renamed from: b */
    public synchronized OutputStream m6985b() {
        if (this.f6809c == null) {
            this.f6809c = new b();
        }
        return this.f6809c;
    }

    /* renamed from: c */
    public int m6986c() {
        try {
            return m6984a().available();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: d */
    public boolean m6987d() {
        try {
            return m6984a().available() <= 0;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: e */
    public int m6988e() {
        return this.f6807a.m6970a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RingBuf.java */
    /* renamed from: com.navatics.robot.utils.l$a */
    /* loaded from: classes2.dex */
    public class a extends InputStream {

        /* renamed from: a */
        byte[] f6811a = new byte[1];

        a() {
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!RingBuf.this.f6810d) {
                return RingBuf.this.f6807a.m6973b(bArr, i, i2);
            }
            throw new IOException("stream already been closed");
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (!RingBuf.this.f6810d) {
                return RingBuf.this.f6807a.m6972b();
            }
            throw new IOException("stream already been closed");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int m6973b;
            if (RingBuf.this.f6810d) {
                throw new IOException("stream already been closed");
            }
            do {
                m6973b = RingBuf.this.f6807a.m6973b(this.f6811a, 0, 1);
                if (RingBuf.this.f6810d) {
                    break;
                }
            } while (m6973b <= 0);
            if (RingBuf.this.f6810d) {
                throw new IOException("stream already been closed");
            }
            if (m6973b > 1) {
                throw new IOException("expect 1 but got 2");
            }
            return this.f6811a[0] & 255;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            RingBuf.this.f6810d = true;
        }
    }

    /* compiled from: RingBuf.java */
    /* renamed from: com.navatics.robot.utils.l$b */
    /* loaded from: classes2.dex */
    class b extends OutputStream {
        b() {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (!RingBuf.this.f6810d && i3 < i2) {
                i3 += RingBuf.this.f6807a.m6971a(bArr, i + i3, i2 - i3);
            }
            if (RingBuf.this.f6810d && i2 != i3) {
                throw new IOException("stream already been closed.");
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            throw new IOException("not supported");
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            RingBuf.this.f6810d = true;
        }
    }
}