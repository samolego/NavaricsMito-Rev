package org.slf4j.helpers;

import java.io.PrintStream;

/* compiled from: Util.java */
/* renamed from: org.slf4j.helpers.g */
/* loaded from: classes2.dex */
public final class C3156g {

    /* renamed from: a */
    private static C3158a f12564a = null;

    /* renamed from: b */
    private static boolean f12565b = false;

    private C3156g() {
    }

    /* renamed from: a */
    public static String m190a(String str) {
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
    public static boolean m187b(String str) {
        String m190a = m190a(str);
        if (m190a == null) {
            return false;
        }
        return m190a.equalsIgnoreCase("true");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Util.java */
    /* renamed from: org.slf4j.helpers.g$a */
    /* loaded from: classes2.dex */
    public static final class C3158a extends SecurityManager {
        private C3158a() {
        }

        @Override // java.lang.SecurityManager
        protected Class<?>[] getClassContext() {
            return super.getClassContext();
        }
    }

    /* renamed from: b */
    private static C3158a m188b() {
        C3158a c3158a = f12564a;
        if (c3158a != null) {
            return c3158a;
        }
        if (f12565b) {
            return null;
        }
        f12564a = m186c();
        f12565b = true;
        return f12564a;
    }

    /* renamed from: c */
    private static C3158a m186c() {
        try {
            return new C3158a();
        } catch (SecurityException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m191a() {
        int i;
        C3158a m188b = m188b();
        if (m188b == null) {
            return null;
        }
        Class<?>[] classContext = m188b.getClassContext();
        String name = C3156g.class.getName();
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
    public static final void m189a(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    /* renamed from: c */
    public static final void m185c(String str) {
        PrintStream printStream = System.err;
        printStream.println("SLF4J: " + str);
    }
}
