package org.apache.log4j.helpers;

import com.tencent.bugly.BUGLY;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.C3046r;
import org.apache.log4j.Level;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.LoggerRepository;

/* renamed from: org.apache.log4j.helpers.h */
/* loaded from: classes2.dex */
public class OptionConverter {

    /* renamed from: a */
    static String f11207a = "${";

    /* renamed from: b */
    static char f11208b = '}';

    /* renamed from: c */
    static int f11209c = 2;

    /* renamed from: d */
    static int f11210d = 1;

    /* renamed from: e */
    static Class f11211e;

    /* renamed from: f */
    static Class f11212f;

    /* renamed from: g */
    static Class f11213g;

    /* renamed from: a */
    public static String m1589a(String str, String str2) {
        try {
            return System.getProperty(str, str2);
        } catch (Throwable unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Was not allowed to read system property \"");
            stringBuffer.append(str);
            stringBuffer.append("\".");
            LogLog.m1600a(stringBuffer.toString());
            return str2;
        }
    }

    /* renamed from: a */
    public static Object m1584a(Properties properties, String str, Class cls, Object obj) {
        String m1588a = m1588a(str, properties);
        if (m1588a == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not find value for key ");
            stringBuffer.append(str);
            LogLog.m1597b(stringBuffer.toString());
            return obj;
        }
        return m1590a(m1588a.trim(), cls, obj);
    }

    /* renamed from: a */
    public static boolean m1586a(String str, boolean z) {
        if (str == null) {
            return z;
        }
        String trim = str.trim();
        if ("true".equalsIgnoreCase(trim)) {
            return true;
        }
        if (BUGLY.SDK_IS_DEV.equalsIgnoreCase(trim)) {
            return false;
        }
        return z;
    }

    /* renamed from: a */
    public static Level m1587a(String str, Level level) {
        Class<?> cls;
        Class<?> cls2;
        if (str == null) {
            return level;
        }
        String trim = str.trim();
        int indexOf = trim.indexOf(35);
        if (indexOf == -1) {
            if ("NULL".equalsIgnoreCase(trim)) {
                return null;
            }
            return Level.toLevel(trim, level);
        }
        String substring = trim.substring(indexOf + 1);
        String substring2 = trim.substring(0, indexOf);
        if ("NULL".equalsIgnoreCase(substring2)) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("toLevel:class=[");
        stringBuffer.append(substring);
        stringBuffer.append("]");
        stringBuffer.append(":pri=[");
        stringBuffer.append(substring2);
        stringBuffer.append("]");
        LogLog.m1600a(stringBuffer.toString());
        try {
            Class m1602b = Loader.m1602b(substring);
            Class<?>[] clsArr = new Class[2];
            if (f11211e == null) {
                cls = m1591a("java.lang.String");
                f11211e = cls;
            } else {
                cls = f11211e;
            }
            clsArr[0] = cls;
            if (f11212f == null) {
                cls2 = m1591a("org.apache.log4j.Level");
                f11212f = cls2;
            } else {
                cls2 = f11212f;
            }
            clsArr[1] = cls2;
            return (Level) m1602b.getMethod("toLevel", clsArr).invoke(null, substring2, level);
        } catch (ClassCastException e) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("class [");
            stringBuffer2.append(substring);
            stringBuffer2.append("] is not a subclass of org.apache.log4j.Level");
            LogLog.m1594c(stringBuffer2.toString(), e);
            return level;
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("custom level class [");
            stringBuffer3.append(substring);
            stringBuffer3.append("] not found.");
            LogLog.m1595c(stringBuffer3.toString());
            return level;
        } catch (IllegalAccessException e2) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("class [");
            stringBuffer4.append(substring);
            stringBuffer4.append("] cannot be instantiated due to access restrictions");
            LogLog.m1594c(stringBuffer4.toString(), e2);
            return level;
        } catch (NoSuchMethodException e3) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("custom level class [");
            stringBuffer5.append(substring);
            stringBuffer5.append("]");
            stringBuffer5.append(" does not have a class function toLevel(String, Level)");
            LogLog.m1594c(stringBuffer5.toString(), e3);
            return level;
        } catch (RuntimeException e4) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("class [");
            stringBuffer6.append(substring);
            stringBuffer6.append("], level [");
            stringBuffer6.append(substring2);
            stringBuffer6.append("] conversion failed.");
            LogLog.m1594c(stringBuffer6.toString(), e4);
            return level;
        } catch (InvocationTargetException e5) {
            if ((e5.getTargetException() instanceof InterruptedException) || (e5.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            StringBuffer stringBuffer7 = new StringBuffer();
            stringBuffer7.append("custom level class [");
            stringBuffer7.append(substring);
            stringBuffer7.append("]");
            stringBuffer7.append(" could not be instantiated");
            LogLog.m1594c(stringBuffer7.toString(), e5);
            return level;
        }
    }

    /* renamed from: a */
    static Class m1591a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: a */
    public static String m1588a(String str, Properties properties) {
        String property = properties.getProperty(str);
        if (property == null) {
            return null;
        }
        try {
            return m1583b(property, properties);
        } catch (IllegalArgumentException e) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Bad option value [");
            stringBuffer.append(property);
            stringBuffer.append("].");
            LogLog.m1596b(stringBuffer.toString(), e);
            return property;
        }
    }

    /* renamed from: a */
    public static Object m1590a(String str, Class cls, Object obj) {
        if (str != null) {
            try {
                Class<?> m1602b = Loader.m1602b(str);
                if (!cls.isAssignableFrom(m1602b)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("A \"");
                    stringBuffer.append(str);
                    stringBuffer.append("\" object is not assignable to a \"");
                    stringBuffer.append(cls.getName());
                    stringBuffer.append("\" variable.");
                    LogLog.m1597b(stringBuffer.toString());
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("The class \"");
                    stringBuffer2.append(cls.getName());
                    stringBuffer2.append("\" was loaded by ");
                    LogLog.m1597b(stringBuffer2.toString());
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("[");
                    stringBuffer3.append(cls.getClassLoader());
                    stringBuffer3.append("] whereas object of type ");
                    LogLog.m1597b(stringBuffer3.toString());
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("\"");
                    stringBuffer4.append(m1602b.getName());
                    stringBuffer4.append("\" was loaded by [");
                    stringBuffer4.append(m1602b.getClassLoader());
                    stringBuffer4.append("].");
                    LogLog.m1597b(stringBuffer4.toString());
                    return obj;
                }
                return m1602b.newInstance();
            } catch (ClassNotFoundException e) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Could not instantiate class [");
                stringBuffer5.append(str);
                stringBuffer5.append("].");
                LogLog.m1596b(stringBuffer5.toString(), e);
            } catch (IllegalAccessException e2) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append("Could not instantiate class [");
                stringBuffer6.append(str);
                stringBuffer6.append("].");
                LogLog.m1596b(stringBuffer6.toString(), e2);
            } catch (InstantiationException e3) {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append("Could not instantiate class [");
                stringBuffer7.append(str);
                stringBuffer7.append("].");
                LogLog.m1596b(stringBuffer7.toString(), e3);
            } catch (RuntimeException e4) {
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append("Could not instantiate class [");
                stringBuffer8.append(str);
                stringBuffer8.append("].");
                LogLog.m1596b(stringBuffer8.toString(), e4);
            }
        }
        return obj;
    }

    /* renamed from: b */
    public static String m1583b(String str, Properties properties) throws IllegalArgumentException {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        while (true) {
            int indexOf = str.indexOf(f11207a, i);
            if (indexOf == -1) {
                if (i == 0) {
                    return str;
                }
                stringBuffer.append(str.substring(i, str.length()));
                return stringBuffer.toString();
            }
            stringBuffer.append(str.substring(i, indexOf));
            int indexOf2 = str.indexOf(f11208b, indexOf);
            if (indexOf2 == -1) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append('\"');
                stringBuffer2.append(str);
                stringBuffer2.append("\" has no closing brace. Opening brace at position ");
                stringBuffer2.append(indexOf);
                stringBuffer2.append('.');
                throw new IllegalArgumentException(stringBuffer2.toString());
            }
            String substring = str.substring(indexOf + f11209c, indexOf2);
            String m1589a = m1589a(substring, (String) null);
            if (m1589a == null && properties != null) {
                m1589a = properties.getProperty(substring);
            }
            if (m1589a != null) {
                stringBuffer.append(m1583b(m1589a, properties));
            }
            i = indexOf2 + f11210d;
        }
    }

    /* renamed from: a */
    public static void m1585a(URL url, String str, LoggerRepository loggerRepository) {
        Configurator c3046r;
        String file = url.getFile();
        if (str == null && file != null && file.endsWith(".xml")) {
            str = "org.apache.log4j.xml.DOMConfigurator";
        }
        if (str != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Preferred configurator class: ");
            stringBuffer.append(str);
            LogLog.m1600a(stringBuffer.toString());
            Class cls = f11213g;
            if (cls == null) {
                cls = m1591a("org.apache.log4j.spi.b");
                f11213g = cls;
            }
            c3046r = (Configurator) m1590a(str, cls, (Object) null);
            if (c3046r == null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not instantiate configurator [");
                stringBuffer2.append(str);
                stringBuffer2.append("].");
                LogLog.m1597b(stringBuffer2.toString());
                return;
            }
        } else {
            c3046r = new C3046r();
        }
        c3046r.mo1523a(url, loggerRepository);
    }
}
