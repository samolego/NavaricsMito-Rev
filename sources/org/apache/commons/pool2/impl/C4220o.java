package org.apache.commons.pool2.impl;

import java.io.PrintWriter;

/* renamed from: org.apache.commons.pool2.impl.o */
/* loaded from: classes2.dex */
public class NoOpCallStack implements CallStack {

    /* renamed from: a */
    public static final CallStack f10857a = new NoOpCallStack();

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: a */
    public void mo2005a() {
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: a */
    public boolean mo2004a(PrintWriter printWriter) {
        return false;
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: b */
    public void mo2003b() {
    }

    private NoOpCallStack() {
    }
}
