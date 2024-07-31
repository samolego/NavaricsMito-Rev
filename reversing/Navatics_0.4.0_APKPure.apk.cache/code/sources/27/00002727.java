package org.aspectj.p128a.p130b;

import java.lang.reflect.Modifier;

/* compiled from: StringMaker.java */
/* renamed from: org.aspectj.a.b.h, reason: use source file name */
/* loaded from: classes2.dex */
class StringMaker {

    /* renamed from: j */
    static StringMaker f11744j = new StringMaker();

    /* renamed from: k */
    static StringMaker f11745k;

    /* renamed from: l */
    static StringMaker f11746l;

    /* renamed from: a */
    boolean f11747a = true;

    /* renamed from: b */
    boolean f11748b = true;

    /* renamed from: c */
    boolean f11749c = false;

    /* renamed from: d */
    boolean f11750d = false;

    /* renamed from: e */
    boolean f11751e = false;

    /* renamed from: f */
    boolean f11752f = true;

    /* renamed from: g */
    boolean f11753g = true;

    /* renamed from: h */
    boolean f11754h = true;

    /* renamed from: i */
    int f11755i;

    StringMaker() {
    }

    static {
        StringMaker stringMaker = f11744j;
        stringMaker.f11747a = true;
        stringMaker.f11748b = false;
        stringMaker.f11749c = false;
        stringMaker.f11750d = false;
        stringMaker.f11751e = true;
        stringMaker.f11752f = false;
        stringMaker.f11753g = false;
        stringMaker.f11755i = 0;
        f11745k = new StringMaker();
        StringMaker stringMaker2 = f11745k;
        stringMaker2.f11747a = true;
        stringMaker2.f11748b = true;
        stringMaker2.f11749c = false;
        stringMaker2.f11750d = false;
        stringMaker2.f11751e = false;
        f11744j.f11755i = 1;
        f11746l = new StringMaker();
        StringMaker stringMaker3 = f11746l;
        stringMaker3.f11747a = false;
        stringMaker3.f11748b = true;
        stringMaker3.f11749c = false;
        stringMaker3.f11750d = true;
        stringMaker3.f11751e = false;
        stringMaker3.f11754h = false;
        stringMaker3.f11755i = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m12046a(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m12042a(int i) {
        if (!this.f11750d) {
            return "";
        }
        String modifier = Modifier.toString(i);
        if (modifier.length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(modifier);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    /* renamed from: b */
    String m12048b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* renamed from: a */
    String m12045a(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            if (z) {
                return m12048b(str).replace('$', '.');
            }
            return str.replace('$', '.');
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m12045a(componentType, componentType.getName(), z));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String m12043a(Class cls) {
        return m12045a(cls, cls.getName(), this.f11747a);
    }

    /* renamed from: a */
    public String m12044a(Class cls, String str) {
        return m12045a(cls, str, this.f11751e);
    }

    /* renamed from: a */
    public void m12047a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(m12043a(clsArr[i]));
        }
    }

    /* renamed from: b */
    public void m12049b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.f11748b) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        m12047a(stringBuffer, clsArr);
        stringBuffer.append(")");
    }

    /* renamed from: c */
    public void m12050c(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.f11749c || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        m12047a(stringBuffer, clsArr);
    }
}