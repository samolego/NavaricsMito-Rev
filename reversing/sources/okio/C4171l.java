package okio;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: okio.l */
/* loaded from: classes2.dex */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: a */
    public final Buffer f10696a = new Buffer();

    /* renamed from: b */
    public final Sink f10697b;

    /* renamed from: c */
    boolean f10698c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealBufferedSink(Sink sink) {
        if (sink == null) {
            throw new NullPointerException("sink == null");
        }
        this.f10697b = sink;
    }

    @Override // okio.BufferedSink, okio.BufferedSource
    /* renamed from: c */
    public Buffer mo2238c() {
        return this.f10696a;
    }

    @Override // okio.Sink
    /* renamed from: a_ */
    public void mo2215a_(Buffer buffer, long j) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2215a_(buffer, j);
        mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: b */
    public BufferedSink mo2256b(ByteString byteString) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2256b(byteString);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: b */
    public BufferedSink mo2257b(String str) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2257b(str);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: c */
    public BufferedSink mo2255c(byte[] bArr) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2255c(bArr);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: c */
    public BufferedSink mo2254c(byte[] bArr, int i, int i2) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2254c(bArr, i, i2);
        return mo2248w();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        int write = this.f10696a.write(byteBuffer);
        mo2248w();
        return write;
    }

    @Override // okio.BufferedSink
    /* renamed from: a */
    public long mo2258a(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long mo130a = source.mo130a(this.f10696a, 8192L);
            if (mo130a == -1) {
                return j;
            }
            j += mo130a;
            mo2248w();
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: i */
    public BufferedSink mo2251i(int i) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2251i(i);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: h */
    public BufferedSink mo2252h(int i) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2252h(i);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: g */
    public BufferedSink mo2253g(int i) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2253g(i);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: m */
    public BufferedSink mo2249m(long j) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2249m(j);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: l */
    public BufferedSink mo2250l(long j) throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        this.f10696a.mo2250l(j);
        return mo2248w();
    }

    @Override // okio.BufferedSink
    /* renamed from: w */
    public BufferedSink mo2248w() throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        long m2289h = this.f10696a.m2289h();
        if (m2289h > 0) {
            this.f10697b.mo2215a_(this.f10696a, m2289h);
        }
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f10698c) {
            throw new IllegalStateException("closed");
        }
        if (this.f10696a.f10675b > 0) {
            Sink sink = this.f10697b;
            Buffer buffer = this.f10696a;
            sink.mo2215a_(buffer, buffer.f10675b);
        }
        this.f10697b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f10698c;
    }

    @Override // java.nio.channels.Channel, java.io.Closeable, java.lang.AutoCloseable, okio.Sink
    public void close() throws IOException {
        if (this.f10698c) {
            return;
        }
        Throwable th = null;
        try {
            if (this.f10696a.f10675b > 0) {
                this.f10697b.mo2215a_(this.f10696a, this.f10696a.f10675b);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f10697b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f10698c = true;
        if (th != null) {
            C3006s.m2203a(th);
        }
    }

    @Override // okio.Sink
    /* renamed from: a */
    public Timeout mo2216a() {
        return this.f10697b.mo2216a();
    }

    public String toString() {
        return "buffer(" + this.f10697b + ")";
    }
}
