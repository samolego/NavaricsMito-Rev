package org.apache.mina.util;

/* renamed from: org.apache.mina.util.b */
/* loaded from: classes2.dex */
public abstract class ExceptionMonitor {

    /* renamed from: a */
    private static ExceptionMonitor f11664a = new DefaultExceptionMonitor();

    /* renamed from: a */
    public abstract void mo807a(Throwable th);

    /* renamed from: a */
    public static ExceptionMonitor m808a() {
        return f11664a;
    }
}
