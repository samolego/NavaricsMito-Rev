package org.apache.commons.pool2;

import java.io.PrintWriter;
import java.util.Deque;

/* renamed from: org.apache.commons.pool2.h */
/* loaded from: classes2.dex */
public interface PooledObject<T> extends Comparable<PooledObject<T>> {
    /* renamed from: a */
    T mo2097a();

    /* renamed from: a */
    void mo2096a(PrintWriter printWriter);

    /* renamed from: a */
    void mo2093a(boolean z);

    /* renamed from: a */
    boolean mo2095a(Deque<PooledObject<T>> deque);

    /* renamed from: b */
    long mo2092b();

    /* renamed from: c */
    long mo2090c();

    /* renamed from: d */
    long mo2089d();

    /* renamed from: e */
    long mo2088e();

    /* renamed from: f */
    boolean mo2087f();

    /* renamed from: g */
    boolean mo2086g();

    /* renamed from: h */
    boolean mo2085h();

    /* renamed from: i */
    void mo2084i();

    /* renamed from: j */
    PooledObjectState mo2083j();

    /* renamed from: k */
    void mo2082k();

    /* renamed from: l */
    void mo2081l();
}
