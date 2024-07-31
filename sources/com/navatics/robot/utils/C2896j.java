package com.navatics.robot.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.navatics.robot.utils.j */
/* loaded from: classes2.dex */
public class PipelineOutputStream extends OutputStream {

    /* renamed from: a */
    final CircularByteBuffer f6770a;

    /* renamed from: b */
    boolean f6771b;

    /* renamed from: c */
    boolean f6772c;

    /* renamed from: d */
    private final C2156a f6773d;

    public PipelineOutputStream() {
        this(8192);
    }

    public PipelineOutputStream(int i) {
        this.f6770a = new CircularByteBuffer(i);
        this.f6773d = new C2156a();
    }

    /* renamed from: a */
    public InputStream m5873a() {
        return this.f6773d;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 != i2) {
            m5870d();
            int m5889b = this.f6770a.m5889b(bArr, i + i3, i2 - i3);
            if (m5889b > 0) {
                i3 += m5889b;
                m5871c();
            } else {
                m5872b();
            }
        }
    }

    /* renamed from: d */
    private void m5870d() throws IOException {
        if (this.f6772c) {
            throw new IOException("PipelineInputStream was closed (broken pipeline)");
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) throws IOException {
        m5870d();
        while (!this.f6770a.m5893a((byte) i)) {
            m5872b();
            m5870d();
        }
        m5871c();
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f6771b = true;
        m5871c();
    }

    /* renamed from: b */
    void m5872b() throws IOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new IOException(e);
        }
    }

    /* renamed from: c */
    void m5871c() {
        notifyAll();
    }

    /* compiled from: PipelineOutputStream.java */
    /* renamed from: com.navatics.robot.utils.j$a */
    /* loaded from: classes2.dex */
    protected class C2156a extends InputStream {
        protected C2156a() {
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int m5891a;
            if (i2 == 0) {
                return PipelineOutputStream.this.f6771b ? -1 : 0;
            }
            synchronized (PipelineOutputStream.this) {
                do {
                    m5891a = PipelineOutputStream.this.f6770a.m5891a(bArr, i, i2);
                    if (m5891a == 0) {
                        if (PipelineOutputStream.this.f6771b) {
                            return -1;
                        }
                        PipelineOutputStream.this.m5872b();
                        continue;
                    }
                } while (m5891a == 0);
                PipelineOutputStream.this.m5871c();
                return m5891a;
            }
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            synchronized (PipelineOutputStream.this) {
                int m5894a = PipelineOutputStream.this.f6770a.m5894a();
                while (m5894a == -1) {
                    if (PipelineOutputStream.this.f6771b) {
                        return -1;
                    }
                    PipelineOutputStream.this.m5872b();
                    m5894a = PipelineOutputStream.this.f6770a.m5894a();
                }
                PipelineOutputStream.this.m5871c();
                return m5894a;
            }
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            return PipelineOutputStream.this.f6770a.m5890b();
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            int min = (int) Math.min(j, 2147483647L);
            synchronized (PipelineOutputStream.this) {
                int i = 0;
                while (i < min) {
                    int m5892a = PipelineOutputStream.this.f6770a.m5892a(min - i);
                    if (m5892a == 0) {
                        if (PipelineOutputStream.this.f6771b) {
                            return i;
                        }
                        PipelineOutputStream.this.m5872b();
                    } else {
                        i += m5892a;
                        PipelineOutputStream.this.m5871c();
                    }
                }
                return i;
            }
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            PipelineOutputStream.this.f6772c = true;
        }
    }
}
