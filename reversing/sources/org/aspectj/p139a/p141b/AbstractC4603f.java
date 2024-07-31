package org.aspectj.p139a.p141b;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;
import org.aspectj.lang.Signature;

/* renamed from: org.aspectj.a.b.f */
/* loaded from: classes2.dex */
abstract class SignatureImpl implements Signature {

    /* renamed from: a */
    private static boolean f11689a = true;

    /* renamed from: k */
    static String[] f11690k = new String[0];

    /* renamed from: l */
    static Class[] f11691l = new Class[0];

    /* renamed from: b */
    private String f11692b;

    /* renamed from: e */
    int f11693e;

    /* renamed from: f */
    String f11694f;

    /* renamed from: g */
    String f11695g;

    /* renamed from: h */
    Class f11696h;

    /* renamed from: i */
    InterfaceC3107a f11697i;

    /* renamed from: j */
    ClassLoader f11698j = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SignatureImpl.java */
    /* renamed from: org.aspectj.a.b.f$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC3107a {
        /* renamed from: a */
        String mo775a(int i);

        /* renamed from: a */
        void mo774a(int i, String str);
    }

    /* renamed from: a */
    protected abstract String mo785a(StringMaker stringMaker);

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignatureImpl(int i, String str, Class cls) {
        this.f11693e = -1;
        this.f11693e = i;
        this.f11694f = str;
        this.f11696h = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String m783b(org.aspectj.p139a.p141b.StringMaker r3) {
        /*
            r2 = this;
            boolean r0 = org.aspectj.p139a.p141b.SignatureImpl.f11689a
            if (r0 == 0) goto L1b
            org.aspectj.a.b.f$a r0 = r2.f11697i
            if (r0 != 0) goto L14
            org.aspectj.a.b.f$b r0 = new org.aspectj.a.b.f$b     // Catch: java.lang.Throwable -> L10
            r0.<init>()     // Catch: java.lang.Throwable -> L10
            r2.f11697i = r0     // Catch: java.lang.Throwable -> L10
            goto L1b
        L10:
            r0 = 0
            org.aspectj.p139a.p141b.SignatureImpl.f11689a = r0
            goto L1b
        L14:
            int r1 = r3.f11714i
            java.lang.String r0 = r0.mo775a(r1)
            goto L1c
        L1b:
            r0 = 0
        L1c:
            if (r0 != 0) goto L22
            java.lang.String r0 = r2.mo785a(r3)
        L22:
            boolean r1 = org.aspectj.p139a.p141b.SignatureImpl.f11689a
            if (r1 == 0) goto L2d
            org.aspectj.a.b.f$a r1 = r2.f11697i
            int r3 = r3.f11714i
            r1.mo774a(r3, r0)
        L2d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.aspectj.p139a.p141b.SignatureImpl.m783b(org.aspectj.a.b.h):java.lang.String");
    }

    public final String toString() {
        return m783b(StringMaker.f11704k);
    }

    /* renamed from: d */
    public int m781d() {
        if (this.f11693e == -1) {
            this.f11693e = m784b(0);
        }
        return this.f11693e;
    }

    /* renamed from: e */
    public String m779e() {
        if (this.f11694f == null) {
            this.f11694f = m786a(1);
        }
        return this.f11694f;
    }

    /* renamed from: f */
    public Class m778f() {
        if (this.f11696h == null) {
            this.f11696h = m782c(2);
        }
        return this.f11696h;
    }

    /* renamed from: g */
    public String m777g() {
        if (this.f11695g == null) {
            this.f11695g = m778f().getName();
        }
        return this.f11695g;
    }

    /* renamed from: a */
    private ClassLoader m787a() {
        if (this.f11698j == null) {
            this.f11698j = getClass().getClassLoader();
        }
        return this.f11698j;
    }

    /* renamed from: a */
    String m786a(int i) {
        int indexOf = this.f11692b.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = indexOf + 1;
            indexOf = this.f11692b.indexOf(45, i2);
            i = i3;
        }
        if (indexOf == -1) {
            indexOf = this.f11692b.length();
        }
        return this.f11692b.substring(i2, indexOf);
    }

    /* renamed from: b */
    int m784b(int i) {
        return Integer.parseInt(m786a(i), 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Class m782c(int i) {
        return C3105b.m797a(m786a(i), m787a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Class[] m780d(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(m786a(i), ":");
        int countTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[countTokens];
        for (int i2 = 0; i2 < countTokens; i2++) {
            clsArr[i2] = C3105b.m797a(stringTokenizer.nextToken(), m787a());
        }
        return clsArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SignatureImpl.java */
    /* renamed from: org.aspectj.a.b.f$b */
    /* loaded from: classes2.dex */
    public static final class C3108b implements InterfaceC3107a {

        /* renamed from: a */
        private SoftReference f11699a;

        public C3108b() {
            m773b();
        }

        @Override // org.aspectj.p139a.p141b.SignatureImpl.InterfaceC3107a
        /* renamed from: a */
        public String mo775a(int i) {
            String[] m776a = m776a();
            if (m776a == null) {
                return null;
            }
            return m776a[i];
        }

        @Override // org.aspectj.p139a.p141b.SignatureImpl.InterfaceC3107a
        /* renamed from: a */
        public void mo774a(int i, String str) {
            String[] m776a = m776a();
            if (m776a == null) {
                m776a = m773b();
            }
            m776a[i] = str;
        }

        /* renamed from: a */
        private String[] m776a() {
            return (String[]) this.f11699a.get();
        }

        /* renamed from: b */
        private String[] m773b() {
            String[] strArr = new String[3];
            this.f11699a = new SoftReference(strArr);
            return strArr;
        }
    }
}
