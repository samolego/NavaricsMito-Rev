package org.apache.log4j.helpers;

import java.io.PrintStream;

/* renamed from: org.apache.log4j.helpers.e */
/* loaded from: classes2.dex */
public class LogLog {

    /* renamed from: a */
    protected static boolean f11201a = false;

    /* renamed from: b */
    private static boolean f11202b = false;

    static {
        String m1589a = OptionConverter.m1589a("log4j.debug", (String) null);
        if (m1589a == null) {
            m1589a = OptionConverter.m1589a("log4j.configDebug", (String) null);
        }
        if (m1589a != null) {
            f11201a = OptionConverter.m1586a(m1589a, true);
        }
    }

    /* renamed from: a */
    public static void m1598a(boolean z) {
        f11201a = z;
    }

    /* renamed from: a */
    public static void m1600a(String str) {
        if (!f11201a || f11202b) {
            return;
        }
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j: ");
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    /* renamed from: a */
    public static void m1599a(String str, Throwable th) {
        if (!f11201a || f11202b) {
            return;
        }
        PrintStream printStream = System.out;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j: ");
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace(System.out);
        }
    }

    /* renamed from: b */
    public static void m1597b(String str) {
        if (f11202b) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j:ERROR ");
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    /* renamed from: b */
    public static void m1596b(String str, Throwable th) {
        if (f11202b) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j:ERROR ");
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m1595c(String str) {
        if (f11202b) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j:WARN ");
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
    }

    /* renamed from: c */
    public static void m1594c(String str, Throwable th) {
        if (f11202b) {
            return;
        }
        PrintStream printStream = System.err;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j:WARN ");
        stringBuffer.append(str);
        printStream.println(stringBuffer.toString());
        if (th != null) {
            th.printStackTrace();
        }
    }
}
