package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import org.slf4j.event.SubstituteLoggingEvent;
import org.slf4j.helpers.C3156g;
import org.slf4j.helpers.NOPLoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.impl.StaticLoggerBinder;

/* compiled from: LoggerFactory.java */
/* renamed from: org.slf4j.c */
/* loaded from: classes2.dex */
public final class C3154c {

    /* renamed from: a */
    static volatile int f12530a;

    /* renamed from: b */
    static final SubstituteLoggerFactory f12531b = new SubstituteLoggerFactory();

    /* renamed from: c */
    static final NOPLoggerFactory f12532c = new NOPLoggerFactory();

    /* renamed from: d */
    static boolean f12533d = C3156g.m187b("slf4j.detectLoggerNameMismatch");

    /* renamed from: e */
    private static final String[] f12534e = {"1.6", "1.7"};

    /* renamed from: f */
    private static String f12535f = "org/slf4j/impl/StaticLoggerBinder.class";

    private C3154c() {
    }

    /* renamed from: c */
    private static final void m252c() {
        m250d();
        if (f12530a == 3) {
            m246h();
        }
    }

    /* renamed from: b */
    private static boolean m254b(String str) {
        if (str == null) {
            return false;
        }
        return str.contains("org/slf4j/impl/StaticLoggerBinder") || str.contains("org.slf4j.impl.StaticLoggerBinder");
    }

    /* renamed from: d */
    private static final void m250d() {
        Set<URL> set = null;
        try {
            if (!m245i()) {
                set = m264a();
                m253b(set);
            }
            StaticLoggerBinder.m178a();
            f12530a = 3;
            m251c(set);
            m249e();
            m248f();
            f12531b.m192d();
        } catch (Exception e) {
            m259a(e);
            throw new IllegalStateException("Unexpected initialization failure", e);
        } catch (NoClassDefFoundError e2) {
            if (m254b(e2.getMessage())) {
                f12530a = 4;
                C3156g.m185c("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
                C3156g.m185c("Defaulting to no-operation (NOP) logger implementation");
                C3156g.m185c("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
                return;
            }
            m259a(e2);
            throw e2;
        } catch (NoSuchMethodError e3) {
            String message = e3.getMessage();
            if (message != null && message.contains("org.slf4j.impl.StaticLoggerBinder.getSingleton()")) {
                f12530a = 2;
                C3156g.m185c("slf4j-api 1.6.x (or later) is incompatible with this binding.");
                C3156g.m185c("Your binding is version 1.5.5 or earlier.");
                C3156g.m185c("Upgrade your binding to version 1.6.x.");
            }
            throw e3;
        }
    }

    /* renamed from: e */
    private static void m249e() {
        synchronized (f12531b) {
            f12531b.m193c();
            for (SubstituteLogger substituteLogger : f12531b.m195a()) {
                substituteLogger.m201a(m260a(substituteLogger.getName()));
            }
        }
    }

    /* renamed from: a */
    static void m259a(Throwable th) {
        f12530a = 2;
        C3156g.m189a("Failed to instantiate SLF4J LoggerFactory", th);
    }

    /* renamed from: f */
    private static void m248f() {
        LinkedBlockingQueue<SubstituteLoggingEvent> m194b = f12531b.m194b();
        int size = m194b.size();
        ArrayList<SubstituteLoggingEvent> arrayList = new ArrayList(128);
        int i = 0;
        while (m194b.drainTo(arrayList, 128) != 0) {
            for (SubstituteLoggingEvent substituteLoggingEvent : arrayList) {
                m257a(substituteLoggingEvent);
                int i2 = i + 1;
                if (i == 0) {
                    m256a(substituteLoggingEvent, size);
                }
                i = i2;
            }
            arrayList.clear();
        }
    }

    /* renamed from: a */
    private static void m256a(SubstituteLoggingEvent substituteLoggingEvent, int i) {
        if (substituteLoggingEvent.m224g().m199b()) {
            m263a(i);
        } else if (substituteLoggingEvent.m224g().m197d()) {
        } else {
            m247g();
        }
    }

    /* renamed from: a */
    private static void m257a(SubstituteLoggingEvent substituteLoggingEvent) {
        if (substituteLoggingEvent == null) {
            return;
        }
        SubstituteLogger m224g = substituteLoggingEvent.m224g();
        String name = m224g.getName();
        if (m224g.m198c()) {
            throw new IllegalStateException("Delegate logger cannot be null at this state.");
        }
        if (m224g.m197d()) {
            return;
        }
        if (m224g.m199b()) {
            m224g.m200a(substituteLoggingEvent);
        } else {
            C3156g.m185c(name);
        }
    }

    /* renamed from: g */
    private static void m247g() {
        C3156g.m185c("The following set of substitute loggers may have been accessed");
        C3156g.m185c("during the initialization phase. Logging calls during this");
        C3156g.m185c("phase were not honored. However, subsequent logging calls to these");
        C3156g.m185c("loggers will work as normally expected.");
        C3156g.m185c("See also http://www.slf4j.org/codes.html#substituteLogger");
    }

    /* renamed from: a */
    private static void m263a(int i) {
        C3156g.m185c("A number (" + i + ") of logging calls during the initialization phase have been intercepted and are");
        C3156g.m185c("now being replayed. These are subject to the filtering rules of the underlying logging system.");
        C3156g.m185c("See also http://www.slf4j.org/codes.html#replay");
    }

    /* renamed from: h */
    private static final void m246h() {
        try {
            String str = StaticLoggerBinder.f12567a;
            boolean z = false;
            for (String str2 : f12534e) {
                if (str.startsWith(str2)) {
                    z = true;
                }
            }
            if (z) {
                return;
            }
            C3156g.m185c("The requested version " + str + " by your slf4j binding is not compatible with " + Arrays.asList(f12534e).toString());
            C3156g.m185c("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        } catch (NoSuchFieldError unused) {
        } catch (Throwable th) {
            C3156g.m189a("Unexpected problem occured during version sanity check", th);
        }
    }

    /* renamed from: a */
    static Set<URL> m264a() {
        Enumeration<URL> resources;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        try {
            ClassLoader classLoader = C3154c.class.getClassLoader();
            if (classLoader == null) {
                resources = ClassLoader.getSystemResources(f12535f);
            } else {
                resources = classLoader.getResources(f12535f);
            }
            while (resources.hasMoreElements()) {
                linkedHashSet.add(resources.nextElement());
            }
        } catch (IOException e) {
            C3156g.m189a("Error getting resources from path", e);
        }
        return linkedHashSet;
    }

    /* renamed from: a */
    private static boolean m258a(Set<URL> set) {
        return set.size() > 1;
    }

    /* renamed from: b */
    private static void m253b(Set<URL> set) {
        if (m258a(set)) {
            C3156g.m185c("Class path contains multiple SLF4J bindings.");
            Iterator<URL> it = set.iterator();
            while (it.hasNext()) {
                C3156g.m185c("Found binding in [" + it.next() + "]");
            }
            C3156g.m185c("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        }
    }

    /* renamed from: i */
    private static boolean m245i() {
        String m190a = C3156g.m190a("java.vendor.url");
        if (m190a == null) {
            return false;
        }
        return m190a.toLowerCase().contains("android");
    }

    /* renamed from: c */
    private static void m251c(Set<URL> set) {
        if (set == null || !m258a(set)) {
            return;
        }
        C3156g.m185c("Actual binding is of type [" + StaticLoggerBinder.m178a().m176c() + "]");
    }

    /* renamed from: a */
    public static InterfaceC3153b m260a(String str) {
        return m255b().mo181a(str);
    }

    /* renamed from: a */
    public static InterfaceC3153b m262a(Class<?> cls) {
        Class<?> m191a;
        InterfaceC3153b m260a = m260a(cls.getName());
        if (f12533d && (m191a = C3156g.m191a()) != null && m261a(cls, m191a)) {
            C3156g.m185c(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", m260a.getName(), m191a.getName()));
            C3156g.m185c("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
        }
        return m260a;
    }

    /* renamed from: a */
    private static boolean m261a(Class<?> cls, Class<?> cls2) {
        return !cls2.isAssignableFrom(cls);
    }

    /* renamed from: b */
    public static ILoggerFactory m255b() {
        if (f12530a == 0) {
            synchronized (C3154c.class) {
                if (f12530a == 0) {
                    f12530a = 1;
                    m252c();
                }
            }
        }
        switch (f12530a) {
            case 1:
                return f12531b;
            case 2:
                throw new IllegalStateException("org.slf4j.LoggerFactory in failed state. Original exception was thrown EARLIER. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
            case 3:
                return StaticLoggerBinder.m178a().m177b();
            case 4:
                return f12532c;
            default:
                throw new IllegalStateException("Unreachable code");
        }
    }
}
