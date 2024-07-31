package com.navatics.robot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: PipelineOutputStream.java */
/* renamed from: com.navatics.robot.utils.j, reason: use source file name */
/* loaded from: classes2.dex */
public class PipelineOutputStream extends OutputStream {

    /* renamed from: a */
    final CircularByteBuffer f6801a;

    /* renamed from: b */
    boolean f6802b;

    /* renamed from: c */
    boolean f6803c;

    /* renamed from: d */
    private final a f6804d;

    public PipelineOutputStream() {
        this(8192);
    }

    public PipelineOutputStream(int i) {
        this.f6801a = new CircularByteBuffer(i);
        this.f6804d = new a();
    }

    /* renamed from: a */
    public InputStream m6977a() {
        return this.f6804d;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 != i2) {
            m6976d();
            int m6960b = this.f6801a.m6960b(bArr, i + i3, i2 - i3);
            if (m6960b > 0) {
                i3 += m6960b;
                m6979c();
            } else {
                m6978b();
            }
        }
    }

    /* renamed from: d */
    private void m6976d() throws IOException {
        if (this.f6803c) {
            throw new IOException("PipelineInputStream was closed (broken pipeline)");
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        m6976d();
        while (!this.f6801a.m6958a((byte) i)) {
            m6978b();
            m6976d();
        }
        m6979c();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f6802b = true;
        m6979c();
    }

    /* renamed from: b */
    void m6978b() throws IOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new IOException(e);
        }
    }

    /* renamed from: c */
    void m6979c() {
        notifyAll();
    }

    /* compiled from: PipelineOutputStream.java */
    /* renamed from: com.navatics.robot.utils.j$a */
    /* loaded from: classes2.dex */
    protected class a extends InputStream {
        protected a() {
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int m6957a;
            if (i2 == 0) {
                return PipelineOutputStream.this.f6802b ? -1 : 0;
            }
            synchronized (PipelineOutputStream.this) {
                do {
                    m6957a = PipelineOutputStream.this.f6801a.m6957a(bArr, i, i2);
                    if (m6957a == 0) {
                        if (PipelineOutputStream.this.f6802b) {
                            return -1;
                        }
                        PipelineOutputStream.this.m6978b();
                    }
                } while (m6957a == 0);
                PipelineOutputStream.this.m6979c();
                return m6957a;
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            synchronized (PipelineOutputStream.this) {
                int m6955a = PipelineOutputStream.this.f6801a.m6955a();
                while (m6955a == -1) {
                    if (PipelineOutputStream.this.f6802b) {
                        return -1;
                    }
                    PipelineOutputStream.this.m6978b();
                    m6955a = PipelineOutputStream.this.f6801a.m6955a();
                }
                PipelineOutputStream.this.m6979c();
                return m6955a;
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return PipelineOutputStream.this.f6801a.m6959b();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            int min = (int) Math.min(j, 2147483647L);
            synchronized (PipelineOutputStream.this) {
                int i = 0;
                while (i < min) {
                    int m6956a = PipelineOutputStream.this.f6801a.m6956a(min - i);
                    if (m6956a == 0) {
                        if (PipelineOutputStream.this.f6802b) {
                            return i;
                        }
                        PipelineOutputStream.this.m6978b();
                    } else {
                        i += m6956a;
                        PipelineOutputStream.this.m6979c();
                    }
                }
                return i;
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            PipelineOutputStream.this.f6803c = true;
        }
    }
}