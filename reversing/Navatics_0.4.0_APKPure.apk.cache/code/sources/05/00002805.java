package org.slf4j.helpers;

/* compiled from: Util.java */
/* renamed from: org.slf4j.helpers.g */
/* loaded from: classes2.dex */
public final class C3498g {

    /* renamed from: a */
    private static a f12605a = null;

    /* renamed from: b */
    private static boolean f12606b = false;

    private C3498g() {
    }

    /* renamed from: a */
    public static String m12624a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null input");
        }
        try {
            return System.getProperty(str);
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static boolean m12627b(String str) {
        String m12624a = m12624a(str);
        if (m12624a == null) {
            return false;
        }
        return m12624a.equalsIgnoreCase("true");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Util.java */
    /* renamed from: org.slf4j.helpers.g$a */
    /* loaded from: classes2.dex */
    public static final class a extends SecurityManager {
        private a() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    /* renamed from: b */
    private static a m12626b() {
        a aVar = f12605a;
        if (aVar != null) {
            return aVar;
        }
        if (f12606b) {
            return null;
        }
        f12605a = m12628c();
        f12606b = true;
        return f12605a;
    }

    /* renamed from: c */
    private static a m12628c() {
        try {
            return new a();
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m12623a() {
        int i;
        a m12626b = m12626b();
        if (m12626b == null) {
            return null;
        }
        Class<?>[] classContext = m12626b.getClassContext();
        String name = C3498g.class.getName();
        int i2 = 0;
        while (i2 < classContext.length && !name.equals(classContext[i2].getName())) {
            i2++;
        }
        if (i2 >= classContext.length || (i = i2 + 2) >= classContext.length) {
            throw new IllegalStateException("Failed to find org.slf4j.helpers.Util or its caller in the stack; this should not happen");
        }
        return classContext[i];
    }

    /* renamed from: a */
    public static final void m12625a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* renamed from: c */
    public static final void m12629c(String str) {
        System.err.println("SLF4J: " + str);
    }
}