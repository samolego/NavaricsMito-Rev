package org.apache.log4j.helpers;

import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;

/* renamed from: org.apache.log4j.helpers.d */
/* loaded from: classes2.dex */
public class Loader {

    /* renamed from: a */
    static Class f11197a = null;

    /* renamed from: b */
    static Class f11198b = null;

    /* renamed from: c */
    private static boolean f11199c = true;

    /* renamed from: d */
    private static boolean f11200d = false;

    static {
        int indexOf;
        String m1589a = OptionConverter.m1589a("java.version", (String) null);
        if (m1589a != null && (indexOf = m1589a.indexOf(46)) != -1 && m1589a.charAt(indexOf + 1) != '1') {
            f11199c = false;
        }
        String m1589a2 = OptionConverter.m1589a("log4j.ignoreTCL", (String) null);
        if (m1589a2 != null) {
            f11200d = OptionConverter.m1586a(m1589a2, true);
        }
    }

    /* renamed from: a */
    public static URL m1604a(String str) {
        Class cls;
        ClassLoader m1603b;
        try {
            if (!f11199c && !f11200d && (m1603b = m1603b()) != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Trying to find [");
                stringBuffer.append(str);
                stringBuffer.append("] using context classloader ");
                stringBuffer.append(m1603b);
                stringBuffer.append(".");
                LogLog.m1600a(stringBuffer.toString());
                URL resource = m1603b.getResource(str);
                if (resource != null) {
                    return resource;
                }
            }
            if (f11197a == null) {
                cls = m1601c("org.apache.log4j.helpers.d");
                f11197a = cls;
            } else {
                cls = f11197a;
            }
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Trying to find [");
                stringBuffer2.append(str);
                stringBuffer2.append("] using ");
                stringBuffer2.append(classLoader);
                stringBuffer2.append(" class loader.");
                LogLog.m1600a(stringBuffer2.toString());
                URL resource2 = classLoader.getResource(str);
                if (resource2 != null) {
                    return resource2;
                }
            }
        } catch (IllegalAccessException e) {
            LogLog.m1594c("Caught Exception while in Loader.getResource. This may be innocuous.", e);
        } catch (InvocationTargetException e2) {
            if ((e2.getTargetException() instanceof InterruptedException) || (e2.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.m1594c("Caught Exception while in Loader.getResource. This may be innocuous.", e2);
        } catch (Throwable th) {
            LogLog.m1594c("Caught Exception while in Loader.getResource. This may be innocuous.", th);
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Trying to find [");
        stringBuffer3.append(str);
        stringBuffer3.append("] using ClassLoader.getSystemResource().");
        LogLog.m1600a(stringBuffer3.toString());
        return ClassLoader.getSystemResource(str);
    }

    /* renamed from: c */
    static Class m1601c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: a */
    public static boolean m1605a() {
        return f11199c;
    }

    /* renamed from: b */
    private static ClassLoader m1603b() throws IllegalAccessException, InvocationTargetException {
        Class cls;
        try {
            if (f11198b == null) {
                cls = m1601c("java.lang.Thread");
                f11198b = cls;
            } else {
                cls = f11198b;
            }
            return (ClassLoader) cls.getMethod("getContextClassLoader", null).invoke(Thread.currentThread(), null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* renamed from: b */
    public static Class m1602b(String str) throws ClassNotFoundException {
        if (f11199c || f11200d) {
            return Class.forName(str);
        }
        try {
            return m1603b().loadClass(str);
        } catch (InvocationTargetException e) {
            if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            return Class.forName(str);
        } catch (Throwable unused) {
            return Class.forName(str);
        }
    }
}
