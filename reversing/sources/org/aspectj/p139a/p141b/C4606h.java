package org.aspectj.p139a.p141b;

import java.lang.reflect.Modifier;

/* renamed from: org.aspectj.a.b.h */
/* loaded from: classes2.dex */
class StringMaker {

    /* renamed from: j */
    static StringMaker f11703j = new StringMaker();

    /* renamed from: k */
    static StringMaker f11704k;

    /* renamed from: l */
    static StringMaker f11705l;

    /* renamed from: a */
    boolean f11706a = true;

    /* renamed from: b */
    boolean f11707b = true;

    /* renamed from: c */
    boolean f11708c = false;

    /* renamed from: d */
    boolean f11709d = false;

    /* renamed from: e */
    boolean f11710e = false;

    /* renamed from: f */
    boolean f11711f = true;

    /* renamed from: g */
    boolean f11712g = true;

    /* renamed from: h */
    boolean f11713h = true;

    /* renamed from: i */
    int f11714i;

    StringMaker() {
    }

    static {
        StringMaker stringMaker = f11703j;
        stringMaker.f11706a = true;
        stringMaker.f11707b = false;
        stringMaker.f11708c = false;
        stringMaker.f11709d = false;
        stringMaker.f11710e = true;
        stringMaker.f11711f = false;
        stringMaker.f11712g = false;
        stringMaker.f11714i = 0;
        f11704k = new StringMaker();
        StringMaker stringMaker2 = f11704k;
        stringMaker2.f11706a = true;
        stringMaker2.f11707b = true;
        stringMaker2.f11708c = false;
        stringMaker2.f11709d = false;
        stringMaker2.f11710e = false;
        f11703j.f11714i = 1;
        f11705l = new StringMaker();
        StringMaker stringMaker3 = f11705l;
        stringMaker3.f11706a = false;
        stringMaker3.f11707b = true;
        stringMaker3.f11708c = false;
        stringMaker3.f11709d = true;
        stringMaker3.f11710e = false;
        stringMaker3.f11713h = false;
        stringMaker3.f11714i = 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m766a(String str) {
        int lastIndexOf = str.lastIndexOf(45);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public String m770a(int i) {
        if (this.f11709d) {
            String modifier = Modifier.toString(i);
            if (modifier.length() == 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(modifier);
            stringBuffer.append(" ");
            return stringBuffer.toString();
        }
        return "";
    }

    /* renamed from: b */
    String m764b(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    /* renamed from: a */
    String m767a(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            if (z) {
                return m764b(str).replace('$', '.');
            }
            return str.replace('$', '.');
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m767a(componentType, componentType.getName(), z));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public String m769a(Class cls) {
        return m767a(cls, cls.getName(), this.f11706a);
    }

    /* renamed from: a */
    public String m768a(Class cls, String str) {
        return m767a(cls, str, this.f11710e);
    }

    /* renamed from: a */
    public void m765a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(m769a(clsArr[i]));
        }
    }

    /* renamed from: b */
    public void m763b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.f11707b) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        m765a(stringBuffer, clsArr);
        stringBuffer.append(")");
    }

    /* renamed from: c */
    public void m762c(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.f11708c || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        m765a(stringBuffer, clsArr);
    }
}
