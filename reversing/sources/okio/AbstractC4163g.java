package okio;

import java.io.IOException;

/* renamed from: okio.g */
/* loaded from: classes2.dex */
public abstract class ForwardingSource implements Source {

    /* renamed from: a */
    private final Source f10679a;

    public ForwardingSource(Source source) {
        if (source == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f10679a = source;
    }

    /* renamed from: b */
    public final Source m2279b() {
        return this.f10679a;
    }

    @Override // okio.Source
    /* renamed from: a */
    public long mo130a(Buffer buffer, long j) throws IOException {
        return this.f10679a.mo130a(buffer, j);
    }

    @Override // okio.Source
    /* renamed from: a */
    public Timeout mo2214a() {
        return this.f10679a.mo2214a();
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f10679a.close();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.f10679a.toString() + ")";
    }
}
