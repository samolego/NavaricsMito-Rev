package com.navatics.robot.utils.p065a;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.navatics.robot.utils.a.h */
/* loaded from: classes2.dex */
class LoggerPrinter implements Printer {

    /* renamed from: a */
    private final ThreadLocal<String> f6736a = new ThreadLocal<>();

    /* renamed from: b */
    private final List<LogAdapter> f6737b = new ArrayList();

    public LoggerPrinter() {
        this.f6737b.add(new AndroidLogAdapter());
    }

    @Override // com.navatics.robot.utils.p065a.Printer
    /* renamed from: a */
    public Printer mo5915a(String str) {
        if (str != null) {
            this.f6736a.set(str);
        }
        return this;
    }

    @Override // com.navatics.robot.utils.p065a.Printer
    /* renamed from: a */
    public void mo5913a(Throwable th, String str, Object... objArr) {
        m5936a(6, th, str, objArr);
    }

    @Override // com.navatics.robot.utils.p065a.Printer
    /* renamed from: a */
    public void mo5914a(String str, Object... objArr) {
        m5936a(4, (Throwable) null, str, objArr);
    }

    /* renamed from: a */
    public synchronized void m5937a(int i, String str, String str2, Throwable th) {
        if (th != null && str2 != null) {
            str2 = str2 + " : " + C2155l.m5910a(th);
        }
        if (th != null && str2 == null) {
            str2 = C2155l.m5910a(th);
        }
        if (C2155l.m5912a(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (LogAdapter logAdapter : this.f6737b) {
            if (logAdapter.mo5944a(i, str)) {
                logAdapter.mo5943a(i, str, str2);
            }
        }
    }

    /* renamed from: a */
    private synchronized void m5936a(int i, Throwable th, String str, Object... objArr) {
        m5937a(i, m5938a(), m5935b(str, objArr), th);
    }

    /* renamed from: a */
    private String m5938a() {
        String str = this.f6736a.get();
        if (str != null) {
            this.f6736a.remove();
            return str;
        }
        return null;
    }

    /* renamed from: b */
    private String m5935b(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }
}
