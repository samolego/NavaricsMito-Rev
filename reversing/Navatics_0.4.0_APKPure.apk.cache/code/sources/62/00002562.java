package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/* loaded from: classes2.dex */
public class ThrowableCallStack implements InterfaceC3027d {

    /* renamed from: a */
    private final String f10771a;

    /* renamed from: b */
    private final DateFormat f10772b;

    /* renamed from: c */
    private volatile Snapshot f10773c;

    public ThrowableCallStack(String str, boolean z) {
        this.f10771a = str;
        this.f10772b = z ? new SimpleDateFormat(str) : null;
    }

    @Override // org.apache.commons.pool2.impl.InterfaceC3027d
    /* renamed from: a */
    public synchronized boolean mo10680a(PrintWriter printWriter) {
        String format;
        String str;
        Snapshot snapshot = this.f10773c;
        if (snapshot == null) {
            return false;
        }
        if (this.f10772b == null) {
            str = this.f10771a;
        } else {
            synchronized (this.f10772b) {
                format = this.f10772b.format(Long.valueOf(snapshot.timestamp));
            }
            str = format;
        }
        printWriter.println(str);
        snapshot.printStackTrace(printWriter);
        return true;
    }

    @Override // org.apache.commons.pool2.impl.InterfaceC3027d
    /* renamed from: a */
    public void mo10679a() {
        this.f10773c = new Snapshot();
    }

    @Override // org.apache.commons.pool2.impl.InterfaceC3027d
    /* renamed from: b */
    public void mo10681b() {
        this.f10773c = null;
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