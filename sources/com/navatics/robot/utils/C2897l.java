package com.navatics.robot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.navatics.robot.utils.l */
/* loaded from: classes2.dex */
public class RingBuf {

    /* renamed from: a */
    private LockFreeRingBufferImpl f6776a;

    /* renamed from: b */
    private C2157a f6777b;

    /* renamed from: c */
    private C2158b f6778c;

    /* renamed from: d */
    private boolean f6779d;

    public RingBuf(int i) {
        this.f6776a = new LockFreeRingBufferImpl(i);
    }

    /* renamed from: a */
    public synchronized InputStream m5868a() {
        if (this.f6777b == null) {
            this.f6777b = new C2157a();
        }
        return this.f6777b;
    }

    /* renamed from: b */
    public synchronized OutputStream m5865b() {
        if (this.f6778c == null) {
            this.f6778c = new C2158b();
        }
        return this.f6778c;
    }

    /* renamed from: c */
    public int m5863c() {
        try {
            return m5868a().available();
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: d */
    public boolean m5862d() {
        try {
            return m5868a().available() <= 0;
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
    }

    /* renamed from: e */
    public int m5861e() {
        return this.f6776a.m5881a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RingBuf.java */
    /* renamed from: com.navatics.robot.utils.l$a */
    /* loaded from: classes2.dex */
    public class C2157a extends InputStream {

        /* renamed from: a */
        byte[] f6780a = new byte[1];

        C2157a() {
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            if (!RingBuf.this.f6779d) {
                return RingBuf.this.f6776a.m5876b(bArr, i, i2);
            }
            throw new IOException("stream already been closed");
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            if (!RingBuf.this.f6779d) {
                return RingBuf.this.f6776a.m5878b();
            }
            throw new IOException("stream already been closed");
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int m5876b;
            if (!RingBuf.this.f6779d) {
                do {
                    m5876b = RingBuf.this.f6776a.m5876b(this.f6780a, 0, 1);
                    if (RingBuf.this.f6779d) {
                        break;
                    }
                } while (m5876b <= 0);
                if (RingBuf.this.f6779d) {
                    throw new IOException("stream already been closed");
                }
                if (m5876b > 1) {
                    throw new IOException("expect 1 but got 2");
                }
                return this.f6780a[0] & 255;
            }
            throw new IOException("stream already been closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            RingBuf.this.f6779d = true;
        }
    }

    /* compiled from: RingBuf.java */
    /* renamed from: com.navatics.robot.utils.l$b */
    /* loaded from: classes2.dex */
    class C2158b extends OutputStream {
        C2158b() {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            int i3 = 0;
            while (!RingBuf.this.f6779d && i3 < i2) {
                i3 += RingBuf.this.f6776a.m5879a(bArr, i + i3, i2 - i3);
            }
            if (RingBuf.this.f6779d && i2 != i3) {
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
            RingBuf.this.f6779d = true;
        }
    }
}
