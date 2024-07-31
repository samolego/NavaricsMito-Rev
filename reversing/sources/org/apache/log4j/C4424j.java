package org.apache.log4j;

import com.tencent.bugly.BUGLY;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.log4j.helpers.C4406d;
import org.apache.log4j.helpers.C4407e;
import org.apache.log4j.helpers.C4410h;
import org.apache.log4j.spi.C4437c;
import org.apache.log4j.spi.C4444j;
import org.apache.log4j.spi.C4448n;
import org.apache.log4j.spi.InterfaceC4442h;
import org.apache.log4j.spi.InterfaceC4447m;

/* renamed from: org.apache.log4j.j */
/* loaded from: classes2.dex */
public class C4424j {

    /* renamed from: a */
    private static Object f11241a;

    /* renamed from: b */
    private static InterfaceC4447m f11242b = new C4437c(new C4402h(new C4448n(Level.DEBUG)));

    static {
        URL m1601a;
        String m1586a = C4410h.m1586a("log4j.defaultInitOverride", (String) null);
        if (m1586a == null || BUGLY.SDK_IS_DEV.equalsIgnoreCase(m1586a)) {
            String m1586a2 = C4410h.m1586a("log4j.configuration", (String) null);
            String m1586a3 = C4410h.m1586a("log4j.configuratorClass", (String) null);
            if (m1586a2 == null) {
                m1601a = C4406d.m1601a("log4j.xml");
                if (m1601a == null) {
                    m1601a = C4406d.m1601a("log4j.properties");
                }
            } else {
                try {
                    m1601a = new URL(m1586a2);
                } catch (MalformedURLException unused) {
                    m1601a = C4406d.m1601a(m1586a2);
                }
            }
            if (m1601a != null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Using URL [");
                stringBuffer.append(m1601a);
                stringBuffer.append("] for automatic log4j configuration.");
                C4407e.m1597a(stringBuffer.toString());
                try {
                    C4410h.m1582a(m1601a, m1586a3, m1565a());
                    return;
                } catch (NoClassDefFoundError e) {
                    C4407e.m1591c("Error during default initialization", e);
                    return;
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not find resource: [");
            stringBuffer2.append(m1586a2);
            stringBuffer2.append("].");
            C4407e.m1597a(stringBuffer2.toString());
            return;
        }
        C4407e.m1597a("Default initialization of overridden by log4j.defaultInitOverrideproperty.");
    }

    /* renamed from: a */
    private static boolean m1564a(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString().indexOf("org.apache.catalina.loader.WebappClassLoader.stop") != -1;
    }

    /* renamed from: a */
    public static InterfaceC4442h m1565a() {
        if (f11242b == null) {
            f11242b = new C4437c(new C4444j());
            f11241a = null;
            IllegalStateException illegalStateException = new IllegalStateException("Class invariant violation");
            if (m1564a(illegalStateException)) {
                C4407e.m1596a("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            } else {
                C4407e.m1593b("log4j called after unloading, see http://logging.apache.org/log4j/1.2/faq.html#unload.", illegalStateException);
            }
        }
        return f11242b.mo1480a();
    }

    /* renamed from: b */
    public static Logger m1562b() {
        return m1565a().mo1484d();
    }

    /* renamed from: a */
    public static Logger m1563a(String str) {
        return m1565a().mo1489a(str);
    }
}
