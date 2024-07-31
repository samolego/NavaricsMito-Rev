package com.navatics.app.framework.p054f;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.nio.channels.Channels;
import java.util.Collections;
import org.apache.log4j.C3044k;
import org.mp4parser.streaming.input.h264.H264AnnexBTrack;
import org.mp4parser.streaming.p149b.p150a.StandardMp4Writer;

/* renamed from: com.navatics.app.framework.f.f */
/* loaded from: classes.dex */
public class MPEG4Recorder implements OnH264DataAvailableCallback {

    /* renamed from: a */
    private static final C3044k f4470a = C3044k.m1564a(MPEG4Recorder.class);

    /* renamed from: b */
    private PipedInputStream f4471b = new PipedInputStream();

    /* renamed from: c */
    private PipedOutputStream f4472c = new PipedOutputStream(this.f4471b);

    /* renamed from: d */
    private File f4473d;

    /* renamed from: e */
    private OutputStream f4474e;

    /* renamed from: f */
    private StandardMp4Writer f4475f;

    /* renamed from: g */
    private boolean f4476g;

    /* renamed from: h */
    private C1797b f4477h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MPEG4Recorder.java */
    /* renamed from: com.navatics.app.framework.f.f$b */
    /* loaded from: classes.dex */
    public class C1797b extends Thread {
        C1797b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v17, types: [org.apache.log4j.k] */
        /* JADX WARN: Type inference failed for: r0v20 */
        /* JADX WARN: Type inference failed for: r0v5 */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            NalUnit m8399a;
            MPEG4Recorder.f4470a.mo1511a((Object) "MPEG4Recorder running");
            NalStreamExtractor nalStreamExtractor = new NalStreamExtractor(MPEG4Recorder.this.f4471b, false);
            do {
                try {
                    m8399a = nalStreamExtractor.m8399a();
                } catch (IOException e) {
                    e.printStackTrace();
                    MPEG4Recorder.f4470a.mo1504b((Object) "MPEG4Recorder read sps error.");
                    return;
                }
            } while (m8399a.m8394a().f12222b != 7);
            MPEG4Recorder.f4470a.mo1511a((Object) "sps wrote.");
            C1796a c1796a = new C1796a(m8399a.m8390b(), nalStreamExtractor.m8398a(false), MPEG4Recorder.this.f4471b);
            boolean z = 1;
            z = 1;
            try {
                try {
                    try {
                        try {
                            H264AnnexBTrack h264AnnexBTrack = new H264AnnexBTrack(c1796a);
                            MPEG4Recorder.this.f4475f = new StandardMp4Writer(Collections.singletonList(h264AnnexBTrack), Channels.newChannel(MPEG4Recorder.this.f4474e));
                            h264AnnexBTrack.call();
                            synchronized (MPEG4Recorder.this) {
                                MPEG4Recorder.this.f4476g = true;
                                MPEG4Recorder.this.notifyAll();
                            }
                        } catch (InterruptedIOException e2) {
                            e2.printStackTrace();
                            synchronized (MPEG4Recorder.this) {
                                MPEG4Recorder.this.f4476g = true;
                                MPEG4Recorder.this.notifyAll();
                            }
                        } catch (IOException e3) {
                            e3.printStackTrace();
                            synchronized (MPEG4Recorder.this) {
                                MPEG4Recorder.this.f4476g = true;
                                MPEG4Recorder.this.notifyAll();
                            }
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        synchronized (MPEG4Recorder.this) {
                            MPEG4Recorder.this.f4476g = true;
                            MPEG4Recorder.this.notifyAll();
                        }
                    }
                } catch (InterruptedException e5) {
                    e5.printStackTrace();
                    synchronized (MPEG4Recorder.this) {
                        MPEG4Recorder.this.f4476g = true;
                        MPEG4Recorder.this.notifyAll();
                    }
                }
                z = MPEG4Recorder.f4470a;
                z.mo1504b("MPEG4Recorder end");
            } catch (Throwable th) {
                synchronized (MPEG4Recorder.this) {
                    MPEG4Recorder.this.f4476g = z;
                    MPEG4Recorder.this.notifyAll();
                    throw th;
                }
            }
        }
    }

    /* compiled from: MPEG4Recorder.java */
    /* renamed from: com.navatics.app.framework.f.f$a */
    /* loaded from: classes.dex */
    class C1796a extends InputStream {

        /* renamed from: a */
        byte[] f4478a;

        /* renamed from: b */
        int f4479b;

        /* renamed from: c */
        InputStream f4480c;

        @Override // java.io.InputStream
        public boolean markSupported() {
            return false;
        }

        C1796a(byte[] bArr, byte[] bArr2, InputStream inputStream) {
            this.f4478a = new byte[bArr.length + bArr2.length];
            System.arraycopy(bArr, 0, this.f4478a, 0, bArr.length);
            System.arraycopy(bArr2, 0, this.f4478a, bArr.length, bArr2.length);
            this.f4480c = inputStream;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            int i = this.f4479b;
            byte[] bArr = this.f4478a;
            if (i < bArr.length) {
                this.f4479b = i + 1;
                return bArr[i];
            }
            return this.f4480c.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.f4479b;
            byte[] bArr2 = this.f4478a;
            if (i3 < bArr2.length) {
                int min = Math.min(bArr2.length - i3, i2);
                System.arraycopy(this.f4478a, this.f4479b, bArr, i, min);
                this.f4479b += min;
                return min;
            }
            return this.f4480c.read(bArr, i, i2);
        }

        @Override // java.io.InputStream
        public long skip(long j) throws IOException {
            int i = this.f4479b;
            byte[] bArr = this.f4478a;
            if (i < bArr.length) {
                long length = bArr.length - i;
                if (length > j) {
                    this.f4479b = (int) (i + j);
                    return j;
                }
                this.f4479b = bArr.length;
                return this.f4480c.skip(j - length) + length;
            }
            return this.f4480c.skip(j);
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            int length = this.f4478a.length - this.f4479b;
            if (length < 0) {
                length = 0;
            }
            return this.f4480c.available() + length;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f4480c.close();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            throw new UnsupportedOperationException("don't support mark");
        }

        @Override // java.io.InputStream
        public synchronized void reset() throws IOException {
            throw new UnsupportedOperationException("don't support reset");
        }
    }

    /* renamed from: c */
    private void m8400c() {
        try {
            this.f4475f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.f4474e.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        try {
            this.f4472c.close();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
        try {
            this.f4471b.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    public MPEG4Recorder(File file) throws IOException {
        this.f4473d = file;
        this.f4474e = new FileOutputStream(this.f4473d);
    }

    @Override // com.navatics.app.framework.p054f.OnH264DataAvailableCallback
    /* renamed from: a */
    public void mo8328a(byte[] bArr, int i, int i2) {
        if (this.f4477h == null) {
            this.f4477h = new C1797b();
            this.f4477h.start();
        }
        try {
            this.f4472c.write(bArr, i, i2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m8406a() {
        if (this.f4477h == null) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.f4476g) {
                    this.f4477h.interrupt();
                    wait();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m8400c();
    }
}
