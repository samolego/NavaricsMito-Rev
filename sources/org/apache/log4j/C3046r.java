package org.apache.log4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.log4j.config.PropertySetter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.p125a.RendererMap;
import org.apache.log4j.spi.Configurator;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;

/* compiled from: PropertyConfigurator.java */
/* renamed from: org.apache.log4j.r */
/* loaded from: classes2.dex */
public class C3046r implements Configurator {

    /* renamed from: c */
    static Class f11260c;

    /* renamed from: d */
    static Class f11261d;

    /* renamed from: e */
    static Class f11262e;

    /* renamed from: f */
    static Class f11263f;

    /* renamed from: g */
    static Class f11264g;

    /* renamed from: h */
    static Class f11265h;

    /* renamed from: a */
    protected Hashtable f11266a = new Hashtable(11);

    /* renamed from: b */
    protected LoggerFactory f11267b = new DefaultCategoryFactory();

    /* renamed from: i */
    private LoggerRepository f11268i;

    /* renamed from: a */
    public void m1537a(Properties properties, LoggerRepository loggerRepository) {
        this.f11268i = loggerRepository;
        String property = properties.getProperty("log4j.debug");
        if (property == null && (property = properties.getProperty("log4j.configDebug")) != null) {
            LogLog.m1595c("[log4j.configDebug] is deprecated. Use [log4j.debug] instead.");
        }
        if (property != null) {
            LogLog.m1598a(OptionConverter.m1586a(property, true));
        }
        String property2 = properties.getProperty("log4j.reset");
        if (property2 != null && OptionConverter.m1586a(property2, false)) {
            loggerRepository.mo1486e();
        }
        String m1588a = OptionConverter.m1588a("log4j.threshold", properties);
        if (m1588a != null) {
            loggerRepository.mo1490a(OptionConverter.m1587a(m1588a, Level.ALL));
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Hierarchy threshold set to [");
            stringBuffer.append(loggerRepository.mo1494a());
            stringBuffer.append("].");
            LogLog.m1600a(stringBuffer.toString());
        }
        m1533b(properties, loggerRepository);
        m1542a(properties);
        m1532c(properties, loggerRepository);
        LogLog.m1600a("Finished configuring.");
        this.f11266a.clear();
    }

    @Override // org.apache.log4j.spi.Configurator
    /* renamed from: a */
    public void mo1523a(URL url, LoggerRepository loggerRepository) {
        Properties properties = new Properties();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Reading configuration from URL ");
        stringBuffer.append(url);
        LogLog.m1600a(stringBuffer.toString());
        InputStream inputStream = null;
        try {
            try {
                URLConnection openConnection = url.openConnection();
                openConnection.setUseCaches(false);
                inputStream = openConnection.getInputStream();
                properties.load(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (InterruptedIOException unused) {
                        Thread.currentThread().interrupt();
                    } catch (IOException | RuntimeException unused2) {
                    }
                }
                m1537a(properties, loggerRepository);
            } catch (Exception e) {
                if ((e instanceof InterruptedIOException) || (e instanceof InterruptedException)) {
                    Thread.currentThread().interrupt();
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Could not read configuration file from URL [");
                stringBuffer2.append(url);
                stringBuffer2.append("].");
                LogLog.m1596b(stringBuffer2.toString(), e);
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Ignoring configuration file [");
                stringBuffer3.append(url);
                stringBuffer3.append("].");
                LogLog.m1597b(stringBuffer3.toString());
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (InterruptedIOException unused3) {
                        Thread.currentThread().interrupt();
                    } catch (IOException | RuntimeException unused4) {
                    }
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (InterruptedIOException unused5) {
                    Thread.currentThread().interrupt();
                } catch (IOException | RuntimeException unused6) {
                }
            }
            throw th;
        }
    }

    /* renamed from: a */
    protected void m1542a(Properties properties) {
        String m1588a = OptionConverter.m1588a("log4j.loggerFactory", properties);
        if (m1588a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Setting category factory to [");
            stringBuffer.append(m1588a);
            stringBuffer.append("].");
            LogLog.m1600a(stringBuffer.toString());
            Class cls = f11260c;
            if (cls == null) {
                cls = m1534b("org.apache.log4j.spi.g");
                f11260c = cls;
            }
            this.f11267b = (LoggerFactory) OptionConverter.m1590a(m1588a, cls, this.f11267b);
            PropertySetter.m1627a(this.f11267b, properties, "log4j.factory.");
        }
    }

    /* renamed from: b */
    static Class m1534b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* renamed from: b */
    void m1533b(Properties properties, LoggerRepository loggerRepository) {
        String str;
        String str2;
        String m1588a = OptionConverter.m1588a("log4j.rootLogger", properties);
        if (m1588a == null) {
            str = "log4j.rootCategory";
            str2 = OptionConverter.m1588a("log4j.rootCategory", properties);
        } else {
            str = "log4j.rootLogger";
            str2 = m1588a;
        }
        if (str2 == null) {
            LogLog.m1600a("Could not find root logger information. Is this OK?");
            return;
        }
        C3044k mo1487d = loggerRepository.mo1487d();
        synchronized (mo1487d) {
            m1538a(properties, mo1487d, str, "root", str2);
        }
    }

    /* renamed from: c */
    protected void m1532c(Properties properties, LoggerRepository loggerRepository) {
        String substring;
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            if (str.startsWith("log4j.category.") || str.startsWith("log4j.logger.")) {
                if (str.startsWith("log4j.category.")) {
                    substring = str.substring(15);
                } else {
                    substring = str.startsWith("log4j.logger.") ? str.substring(13) : null;
                }
                String m1588a = OptionConverter.m1588a(str, properties);
                C3044k mo1491a = loggerRepository.mo1491a(substring, this.f11267b);
                synchronized (mo1491a) {
                    m1538a(properties, mo1491a, str, substring, m1588a);
                    m1539a(properties, mo1491a, substring);
                }
            } else if (str.startsWith("log4j.renderer.")) {
                String substring2 = str.substring(15);
                String m1588a2 = OptionConverter.m1588a(str, properties);
                if (loggerRepository instanceof RendererSupport) {
                    RendererMap.m1647a((RendererSupport) loggerRepository, substring2, m1588a2);
                }
            } else if (str.equals("log4j.throwableRenderer") && (loggerRepository instanceof ThrowableRendererSupport)) {
                Class cls = f11261d;
                if (cls == null) {
                    cls = m1534b("org.apache.log4j.spi.o");
                    f11261d = cls;
                }
                ThrowableRenderer throwableRenderer = (ThrowableRenderer) OptionConverter.m1584a(properties, "log4j.throwableRenderer", cls, null);
                if (throwableRenderer == null) {
                    LogLog.m1597b("Could not instantiate throwableRenderer.");
                } else {
                    new PropertySetter(throwableRenderer).m1623a(properties, "log4j.throwableRenderer.");
                    ((ThrowableRendererSupport) loggerRepository).mo1480a(throwableRenderer);
                }
            }
        }
    }

    /* renamed from: a */
    void m1539a(Properties properties, C3044k c3044k, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j.additivity.");
        stringBuffer.append(str);
        String m1588a = OptionConverter.m1588a(stringBuffer.toString(), properties);
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Handling log4j.additivity.");
        stringBuffer2.append(str);
        stringBuffer2.append("=[");
        stringBuffer2.append(m1588a);
        stringBuffer2.append("]");
        LogLog.m1600a(stringBuffer2.toString());
        if (m1588a == null || m1588a.equals("")) {
            return;
        }
        boolean m1586a = OptionConverter.m1586a(m1588a, true);
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Setting additivity for \"");
        stringBuffer3.append(str);
        stringBuffer3.append("\" to ");
        stringBuffer3.append(m1586a);
        LogLog.m1600a(stringBuffer3.toString());
        c3044k.m1634a(m1586a);
    }

    /* renamed from: a */
    void m1538a(Properties properties, C3044k c3044k, String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Parsing for [");
        stringBuffer.append(str2);
        stringBuffer.append("] with value=[");
        stringBuffer.append(str3);
        stringBuffer.append("].");
        LogLog.m1600a(stringBuffer.toString());
        StringTokenizer stringTokenizer = new StringTokenizer(str3, ",");
        if (!str3.startsWith(",") && !str3.equals("")) {
            if (!stringTokenizer.hasMoreTokens()) {
                return;
            }
            String nextToken = stringTokenizer.nextToken();
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Level token is [");
            stringBuffer2.append(nextToken);
            stringBuffer2.append("].");
            LogLog.m1600a(stringBuffer2.toString());
            if ("inherited".equalsIgnoreCase(nextToken) || "null".equalsIgnoreCase(nextToken)) {
                if (str2.equals("root")) {
                    LogLog.m1595c("The root logger cannot be set to null.");
                } else {
                    c3044k.mo1482a((Level) null);
                }
            } else {
                c3044k.mo1482a(OptionConverter.m1587a(nextToken, Level.DEBUG));
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Category ");
            stringBuffer3.append(str2);
            stringBuffer3.append(" set to ");
            stringBuffer3.append(c3044k.m1630f());
            LogLog.m1600a(stringBuffer3.toString());
        }
        c3044k.mo1496i();
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim != null && !trim.equals(",")) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Parsing appender named \"");
                stringBuffer4.append(trim);
                stringBuffer4.append("\".");
                LogLog.m1600a(stringBuffer4.toString());
                Appender m1541a = m1541a(properties, trim);
                if (m1541a != null) {
                    c3044k.mo1508a(m1541a);
                }
            }
        }
    }

    /* renamed from: a */
    Appender m1541a(Properties properties, String str) {
        Appender m1543a = m1543a(str);
        if (m1543a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Appender \"");
            stringBuffer.append(str);
            stringBuffer.append("\" was already parsed.");
            LogLog.m1600a(stringBuffer.toString());
            return m1543a;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("log4j.appender.");
        stringBuffer2.append(str);
        String stringBuffer3 = stringBuffer2.toString();
        StringBuffer stringBuffer4 = new StringBuffer();
        stringBuffer4.append(stringBuffer3);
        stringBuffer4.append(".layout");
        String stringBuffer5 = stringBuffer4.toString();
        Class cls = f11262e;
        if (cls == null) {
            cls = m1534b("org.apache.log4j.a");
            f11262e = cls;
        }
        Appender appender = (Appender) OptionConverter.m1584a(properties, stringBuffer3, cls, null);
        if (appender == null) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Could not instantiate appender named \"");
            stringBuffer6.append(str);
            stringBuffer6.append("\".");
            LogLog.m1597b(stringBuffer6.toString());
            return null;
        }
        appender.mo1645a(str);
        if (appender instanceof OptionHandler) {
            if (appender.mo1473b()) {
                Class cls2 = f11263f;
                if (cls2 == null) {
                    cls2 = m1534b("org.apache.log4j.i");
                    f11263f = cls2;
                }
                Layout layout = (Layout) OptionConverter.m1584a(properties, stringBuffer5, cls2, null);
                if (layout != null) {
                    appender.mo1644a(layout);
                    StringBuffer stringBuffer7 = new StringBuffer();
                    stringBuffer7.append("Parsing layout options for \"");
                    stringBuffer7.append(str);
                    stringBuffer7.append("\".");
                    LogLog.m1600a(stringBuffer7.toString());
                    StringBuffer stringBuffer8 = new StringBuffer();
                    stringBuffer8.append(stringBuffer5);
                    stringBuffer8.append(".");
                    PropertySetter.m1627a(layout, properties, stringBuffer8.toString());
                    StringBuffer stringBuffer9 = new StringBuffer();
                    stringBuffer9.append("End of parsing for \"");
                    stringBuffer9.append(str);
                    stringBuffer9.append("\".");
                    LogLog.m1600a(stringBuffer9.toString());
                }
            }
            StringBuffer stringBuffer10 = new StringBuffer();
            stringBuffer10.append(stringBuffer3);
            stringBuffer10.append(".errorhandler");
            String stringBuffer11 = stringBuffer10.toString();
            if (OptionConverter.m1588a(stringBuffer11, properties) != null) {
                Class cls3 = f11264g;
                if (cls3 == null) {
                    cls3 = m1534b("org.apache.log4j.spi.d");
                    f11264g = cls3;
                }
                ErrorHandler errorHandler = (ErrorHandler) OptionConverter.m1584a(properties, stringBuffer11, cls3, null);
                if (errorHandler != null) {
                    appender.mo1475a(errorHandler);
                    StringBuffer stringBuffer12 = new StringBuffer();
                    stringBuffer12.append("Parsing errorhandler options for \"");
                    stringBuffer12.append(str);
                    stringBuffer12.append("\".");
                    LogLog.m1600a(stringBuffer12.toString());
                    m1535a(errorHandler, stringBuffer11, properties, this.f11268i);
                    Properties properties2 = new Properties();
                    StringBuffer stringBuffer13 = new StringBuffer();
                    stringBuffer13.append(stringBuffer11);
                    stringBuffer13.append(".");
                    stringBuffer13.append("root-ref");
                    StringBuffer stringBuffer14 = new StringBuffer();
                    stringBuffer14.append(stringBuffer11);
                    stringBuffer14.append(".");
                    stringBuffer14.append("logger-ref");
                    StringBuffer stringBuffer15 = new StringBuffer();
                    stringBuffer15.append(stringBuffer11);
                    stringBuffer15.append(".");
                    stringBuffer15.append("appender-ref");
                    String[] strArr = {stringBuffer13.toString(), stringBuffer14.toString(), stringBuffer15.toString()};
                    for (Map.Entry entry : properties.entrySet()) {
                        int i = 0;
                        while (i < strArr.length && !strArr[i].equals(entry.getKey())) {
                            i++;
                        }
                        if (i == strArr.length) {
                            properties2.put(entry.getKey(), entry.getValue());
                        }
                    }
                    StringBuffer stringBuffer16 = new StringBuffer();
                    stringBuffer16.append(stringBuffer11);
                    stringBuffer16.append(".");
                    PropertySetter.m1627a(errorHandler, properties2, stringBuffer16.toString());
                    StringBuffer stringBuffer17 = new StringBuffer();
                    stringBuffer17.append("End of errorhandler parsing for \"");
                    stringBuffer17.append(str);
                    stringBuffer17.append("\".");
                    LogLog.m1600a(stringBuffer17.toString());
                }
            }
            StringBuffer stringBuffer18 = new StringBuffer();
            stringBuffer18.append(stringBuffer3);
            stringBuffer18.append(".");
            PropertySetter.m1627a(appender, properties, stringBuffer18.toString());
            StringBuffer stringBuffer19 = new StringBuffer();
            stringBuffer19.append("Parsed \"");
            stringBuffer19.append(str);
            stringBuffer19.append("\" options.");
            LogLog.m1600a(stringBuffer19.toString());
        }
        m1540a(properties, str, appender);
        m1536a(appender);
        return appender;
    }

    /* renamed from: a */
    private void m1535a(ErrorHandler errorHandler, String str, Properties properties, LoggerRepository loggerRepository) {
        Appender m1541a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append("root-ref");
        if (OptionConverter.m1586a(OptionConverter.m1588a(stringBuffer.toString(), properties), false)) {
            errorHandler.mo1519a(loggerRepository.mo1487d());
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(str);
        stringBuffer2.append("logger-ref");
        String m1588a = OptionConverter.m1588a(stringBuffer2.toString(), properties);
        if (m1588a != null) {
            LoggerFactory loggerFactory = this.f11267b;
            errorHandler.mo1519a(loggerFactory == null ? loggerRepository.mo1492a(m1588a) : loggerRepository.mo1491a(m1588a, loggerFactory));
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(str);
        stringBuffer3.append("appender-ref");
        String m1588a2 = OptionConverter.m1588a(stringBuffer3.toString(), properties);
        if (m1588a2 == null || (m1541a = m1541a(properties, m1588a2)) == null) {
            return;
        }
        errorHandler.mo1520a(m1541a);
    }

    /* renamed from: a */
    void m1540a(Properties properties, String str, Appender appender) {
        String str2;
        String str3;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("log4j.appender.");
        stringBuffer.append(str);
        stringBuffer.append(".filter.");
        String stringBuffer2 = stringBuffer.toString();
        int length = stringBuffer2.length();
        Hashtable hashtable = new Hashtable();
        Enumeration keys = properties.keys();
        String str4 = "";
        while (keys.hasMoreElements()) {
            String str5 = (String) keys.nextElement();
            if (str5.startsWith(stringBuffer2)) {
                int indexOf = str5.indexOf(46, length);
                if (indexOf != -1) {
                    str3 = str5.substring(0, indexOf);
                    str2 = str5.substring(indexOf + 1);
                } else {
                    str2 = str4;
                    str3 = str5;
                }
                Vector vector = (Vector) hashtable.get(str3);
                if (vector == null) {
                    vector = new Vector();
                    hashtable.put(str3, vector);
                }
                if (indexOf != -1) {
                    vector.add(new PropertyConfigurator(str2, OptionConverter.m1588a(str5, properties)));
                }
                str4 = str2;
            }
        }
        C3047t c3047t = new C3047t(hashtable);
        while (c3047t.hasMoreElements()) {
            String str6 = (String) c3047t.nextElement();
            String property = properties.getProperty(str6);
            if (property != null) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Filter key: [");
                stringBuffer3.append(str6);
                stringBuffer3.append("] class: [");
                stringBuffer3.append(properties.getProperty(str6));
                stringBuffer3.append("] props: ");
                stringBuffer3.append(hashtable.get(str6));
                LogLog.m1600a(stringBuffer3.toString());
                Class cls = f11265h;
                if (cls == null) {
                    cls = m1534b("org.apache.log4j.spi.e");
                    f11265h = cls;
                }
                Filter filter = (Filter) OptionConverter.m1590a(property, cls, (Object) null);
                if (filter != null) {
                    PropertySetter propertySetter = new PropertySetter(filter);
                    Enumeration elements = ((Vector) hashtable.get(str6)).elements();
                    while (elements.hasMoreElements()) {
                        PropertyConfigurator propertyConfigurator = (PropertyConfigurator) elements.nextElement();
                        propertySetter.m1624a(propertyConfigurator.f11253a, propertyConfigurator.f11254b);
                    }
                    propertySetter.m1622b();
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append("Adding filter of type [");
                    stringBuffer4.append(filter.getClass());
                    stringBuffer4.append("] to appender named [");
                    stringBuffer4.append(appender.mo1640d());
                    stringBuffer4.append("].");
                    LogLog.m1600a(stringBuffer4.toString());
                    appender.mo1642a(filter);
                }
            } else {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("Missing class definition for filter: [");
                stringBuffer5.append(str6);
                stringBuffer5.append("]");
                LogLog.m1595c(stringBuffer5.toString());
            }
        }
    }

    /* renamed from: a */
    void m1536a(Appender appender) {
        this.f11266a.put(appender.mo1640d(), appender);
    }

    /* renamed from: a */
    Appender m1543a(String str) {
        return (Appender) this.f11266a.get(str);
    }
}
