package org.apache.log4j;

import com.tencent.bugly.BUGLY;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OptionConverter;
import org.apache.log4j.spi.DefaultRepositorySelector;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.NOPLoggerRepository;
import org.apache.log4j.spi.RepositorySelector;
import org.apache.log4j.spi.RootLogger;

/* renamed from: org.apache.log4j.j */
/* loaded from: classes2.dex */
public class LogManager {

    /* renamed from: a */
    private static Object f11241a;

    /* renamed from: b */
    private static RepositorySelector f11242b = new DefaultRepositorySelector(new Hierarchy(new RootLogger(Level.DEBUG)));

    static {
        URL m1604a;
        String m1589a = OptionConverter.m1589a("log4j.defaultInitOverride", (String) null);
        if (m1589a == null || BUGLY.SDK_IS_DEV.equalsIgnoreCase(m1589a)) {
            String m1589a2 = OptionConverter.m1589a("log4j.configuration", (String) null);
            String m1589a3 = OptionConverter.m1589a("log4j.configuratorClass", (String) null);
            if (m1589a2 == null) {
                m1604a = Loader.m1604a("log4j.xml");
                if (m1604a == null) {
                    m1604a = Loader.m1604a("log4j.properties");
                }
            } else {
                try {
                    m1604a = new URL(m1589a2);
                } catch (MalformedURLException unused) {
                    m1604a = Loader.m1604a(m1589a2);
                }
            }
            if (m1604a != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Using URL [");
                stringBuffer.append(m1604a);
                stringBuffer.append("] for automatic log4j configuration.");
                LogLog.m1600a(stringBuffer.toString());
                try {
                    OptionConverter.m1585a(m1604a, m1589a3, m1568a());
                    return;
                } catch (NoClassDefFoundError e) {
                    LogLog.m1594c("Error during default initialization", e);
                    return;
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not find resource: [");
            stringBuffer2.append(m1589a2);
            stringBuffer2.append("].");
            LogLog.m1600a(stringBuffer2.toString());
            return;
        }
        LogLog.m1600a("Default initialization of overridden by log4j.defaultInitOverrideproperty.");
    }

    /* renamed from: a */
    private static boolean m1567a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().indexOf("org.apache.catalina.loader.WebappClassLoader.stop") != -1;
    }

    /* renamed from: a */
    public static LoggerRepository m1568a() {
        if (f11242b == null) {
            f11242b = new DefaultRepositorySelector(new NOPLoggerRepository());
            f11241a = null;
            IllegalStateException illegalStateException = new IllegalStateException("Class invariant violation");
            if (m1567a(illegalStateException)) {
                LogLog.m1599a("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            } else {
                LogLog.m1596b("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            }
        }
        return f11242b.mo1483a();
    }

    /* renamed from: b */
    public static C3044k m1565b() {
        return m1568a().mo1487d();
    }

    /* renamed from: a */
    public static C3044k m1566a(String str) {
        return m1568a().mo1492a(str);
    }
}
