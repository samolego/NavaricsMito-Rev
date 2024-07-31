package okio;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/* renamed from: okio.p */
/* loaded from: classes2.dex */
public interface Sink extends Closeable, Flushable {
    /* renamed from: a */
    Timeout mo2216a();

    /* renamed from: a_ */
    void mo2215a_(Buffer buffer, long j) throws IOException;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;

    void flush() throws IOException;
}
