package org.aspectj.p128a.p130b;

import org.aspectj.lang.p131a.InterfaceC3355d;

/* compiled from: SourceLocationImpl.java */
/* renamed from: org.aspectj.a.b.g, reason: use source file name */
/* loaded from: classes2.dex */
class SourceLocationImpl implements InterfaceC3355d {

    /* renamed from: a */
    Class f11741a;

    /* renamed from: b */
    String f11742b;

    /* renamed from: c */
    int f11743c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceLocationImpl(Class cls, String str, int i) {
        this.f11741a = cls;
        this.f11742b = str;
        this.f11743c = i;
    }

    /* renamed from: a */
    public String m12040a() {
        return this.f11742b;
    }

    /* renamed from: b */
    public int m12041b() {
        return this.f11743c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m12040a());
        stringBuffer.append(":");
        stringBuffer.append(m12041b());
        return stringBuffer.toString();
    }
}