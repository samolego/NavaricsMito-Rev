package org.apache.mina.util;

import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.util.a */
/* loaded from: classes2.dex */
public class DefaultExceptionMonitor extends ExceptionMonitor {

    /* renamed from: a */
    private static final InterfaceC3153b f11663a = C3154c.m262a(DefaultExceptionMonitor.class);

    @Override // org.apache.mina.util.ExceptionMonitor
    /* renamed from: a */
    public void mo807a(Throwable th) {
        if (th instanceof Error) {
            throw ((Error) th);
        }
        f11663a.warn("Unexpected exception.", th);
    }
}
