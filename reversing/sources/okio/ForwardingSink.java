package okio;

import java.io.IOException;

/* renamed from: okio.f */
/* loaded from: classes2.dex */
public abstract class ForwardingSink implements Sink {

    /* renamed from: a */
    private final Sink f10678a;

    public ForwardingSink(Sink sink) {
        if (sink == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10678a = sink;
    }

    @Override // okio.Sink
    /* renamed from: a_ */
    public void mo2215a_(Buffer buffer, long j) throws IOException {
        this.f10678a.mo2215a_(buffer, j);
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        this.f10678a.flush();
    }

    @Override // okio.Sink
    /* renamed from: a */
    public Timeout mo2216a() {
        return this.f10678a.mo2216a();
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10678a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10678a.toString() + ")";
    }
}
