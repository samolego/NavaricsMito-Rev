package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
public class ThrowableCallStack implements CallStack {

    /* renamed from: a */
    private final String f10730a;

    /* renamed from: b */
    private final DateFormat f10731b;

    /* renamed from: c */
    private volatile Snapshot f10732c;

    public ThrowableCallStack(String str, boolean z) {
        this.f10730a = str;
        this.f10731b = z ? new SimpleDateFormat(str) : null;
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: a */
    public synchronized boolean mo2004a(PrintWriter printWriter) {
        String format;
        String str;
        Snapshot snapshot = this.f10732c;
        if (snapshot == null) {
            return false;
        }
        if (this.f10731b == null) {
            str = this.f10730a;
        } else {
            synchronized (this.f10731b) {
                format = this.f10731b.format(Long.valueOf(snapshot.timestamp));
            }
            str = format;
        }
        printWriter.println(str);
        snapshot.printStackTrace(printWriter);
        return true;
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: a */
    public void mo2005a() {
        this.f10732c = new Snapshot();
    }

    @Override // org.apache.commons.pool2.impl.CallStack
    /* renamed from: b */
    public void mo2003b() {
        this.f10732c = null;
    }

    /* loaded from: classes2.dex */
    private static class Snapshot extends Throwable {
        private static final long serialVersionUID = 1;
        private final long timestamp;

        private Snapshot() {
            this.timestamp = System.currentTimeMillis();
        }
    }
}
