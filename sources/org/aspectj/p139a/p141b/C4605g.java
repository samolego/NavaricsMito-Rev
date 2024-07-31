package org.aspectj.p139a.p141b;

import org.aspectj.lang.p142a.SourceLocation;

/* renamed from: org.aspectj.a.b.g */
/* loaded from: classes2.dex */
class SourceLocationImpl implements SourceLocation {

    /* renamed from: a */
    Class f11700a;

    /* renamed from: b */
    String f11701b;

    /* renamed from: c */
    int f11702c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SourceLocationImpl(Class cls, String str, int i) {
        this.f11700a = cls;
        this.f11701b = str;
        this.f11702c = i;
    }

    /* renamed from: a */
    public String m772a() {
        return this.f11701b;
    }

    /* renamed from: b */
    public int m771b() {
        return this.f11702c;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m772a());
        stringBuffer.append(":");
        stringBuffer.append(m771b());
        return stringBuffer.toString();
    }
}
