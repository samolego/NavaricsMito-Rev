package okhttp3;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import okhttp3.internal.p103a.C2925d;
import okhttp3.internal.p103a.InternalCache;

/* compiled from: Cache.java */
/* renamed from: okhttp3.c */
/* loaded from: classes2.dex */
public final class C2916c implements Closeable, Flushable {

    /* renamed from: a */
    final InternalCache f9952a;

    /* renamed from: b */
    final C2925d f9953b;

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.f9953b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9953b.close();
    }
}
