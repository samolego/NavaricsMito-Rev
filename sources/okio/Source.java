package okio;

import java.io.Closeable;
import java.io.IOException;

/* renamed from: okio.q */
/* loaded from: classes2.dex */
public interface Source extends Closeable {
    /* renamed from: a */
    long mo130a(Buffer buffer, long j) throws IOException;

    /* renamed from: a */
    Timeout mo2214a();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close() throws IOException;
}
