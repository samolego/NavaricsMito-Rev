package org.apache.log4j;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.helpers.C4407a;
import org.apache.log4j.helpers.C4412f;
import org.apache.log4j.spi.InterfaceC4439a;
import org.apache.log4j.spi.InterfaceC4444f;
import org.apache.log4j.spi.InterfaceC4446h;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.c */
/* loaded from: classes2.dex */
public class C4400c implements InterfaceC4439a {

    /* renamed from: h */
    static Class f11156h;

    /* renamed from: i */
    private static final String f11157i;

    /* renamed from: a */
    protected String f11158a;

    /* renamed from: b */
    protected volatile Level f11159b;

    /* renamed from: c */
    protected volatile C4400c f11160c;

    /* renamed from: d */
    protected ResourceBundle f11161d;

    /* renamed from: e */
    protected InterfaceC4446h f11162e;

    /* renamed from: f */
    C4407a f11163f;

    /* renamed from: g */
    protected boolean f11164g = true;

    static {
        Class cls = f11156h;
        if (cls == null) {
            cls = m1634a("org.apache.log4j.c");
            f11156h = cls;
        }
        f11157i = cls.getName();
    }

    /* renamed from: a */
    static Class m1634a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public C4400c(String str) {
        this.f11158a = str;
    }

    /* renamed from: a */
    public synchronized void mo1505a(InterfaceC4395a interfaceC4395a) {
        if (this.f11163f == null) {
            this.f11163f = new C4407a();
        }
        this.f11163f.m1608a(interfaceC4395a);
        this.f11162e.mo1485a(this, interfaceC4395a);
    }

    /* renamed from: a */
    public void mo1503a(LoggingEvent loggingEvent) {
        int i = 0;
        C4400c c4400c = this;
        while (true) {
            if (c4400c == null) {
                break;
            }
            synchronized (c4400c) {
                if (c4400c.f11163f != null) {
                    i += c4400c.f11163f.m1607a(loggingEvent);
                }
                if (!c4400c.f11164g) {
                    break;
                }
            }
            c4400c = c4400c.f11160c;
        }
        if (i == 0) {
            this.f11162e.mo1486a(this);
        }
    }

    /* renamed from: a */
    public synchronized void m1635a() {
        Enumeration mo1502b = mo1502b();
        if (mo1502b != null) {
            while (mo1502b.hasMoreElements()) {
                InterfaceC4395a interfaceC4395a = (InterfaceC4395a) mo1502b.nextElement();
                if (interfaceC4395a instanceof InterfaceC4439a) {
                    interfaceC4395a.mo1475a();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1508a(Object obj) {
        if (!this.f11162e.mo1490a(C4436q.DEBUG_INT) && Level.DEBUG.isGreaterOrEqual(mo1498c())) {
            m1633a(f11157i, Level.DEBUG, obj, null);
        }
    }

    /* renamed from: a */
    public void mo1507a(Object obj, Throwable th) {
        if (!this.f11162e.mo1490a(C4436q.DEBUG_INT) && Level.DEBUG.isGreaterOrEqual(mo1498c())) {
            m1633a(f11157i, Level.DEBUG, obj, th);
        }
    }

    /* renamed from: b */
    public void log(Object obj) {
        if (!this.f11162e.mo1490a(C4436q.ERROR_INT) && Level.ERROR.isGreaterOrEqual(mo1498c())) {
            m1633a(f11157i, Level.ERROR, obj, null);
        }
    }

    /* renamed from: b */
    public void mo1500b(Object obj, Throwable th) {
        if (!this.f11162e.mo1490a(C4436q.ERROR_INT) && Level.ERROR.isGreaterOrEqual(mo1498c())) {
            m1633a(f11157i, Level.ERROR, obj, th);
        }
    }

    /* renamed from: a */
    protected void m1633a(String str, C4436q c4436q, Object obj, Throwable th) {
        mo1503a(new LoggingEvent(str, this, c4436q, obj, th));
    }

    /* renamed from: b */
    public synchronized Enumeration mo1502b() {
        if (this.f11163f == null) {
            return C4412f.m1590a();
        }
        return this.f11163f.m1609a();
    }

    /* renamed from: c */
    public Level mo1498c() {
        for (C4400c c4400c = this; c4400c != null; c4400c = c4400c.f11160c) {
            if (c4400c.f11159b != null) {
                return c4400c.f11159b;
            }
        }
        return null;
    }

    /* renamed from: d */
    public InterfaceC4446h m1629d() {
        return this.f11162e;
    }

    /* renamed from: e */
    public final String m1628e() {
        return this.f11158a;
    }

    /* renamed from: f */
    public final Level m1627f() {
        return this.f11159b;
    }

    /* renamed from: c */
    public void mo1497c(Object obj) {
        if (!this.f11162e.mo1490a(C4436q.INFO_INT) && Level.INFO.isGreaterOrEqual(mo1498c())) {
            m1633a(f11157i, Level.INFO, obj, null);
        }
    }

    /* renamed from: g */
    public boolean mo1495g() {
        if (this.f11162e.mo1490a(C4436q.DEBUG_INT)) {
            return false;
        }
        return Level.DEBUG.isGreaterOrEqual(mo1498c());
    }

    /* renamed from: a */
    public boolean mo1504a(C4436q c4436q) {
        if (this.f11162e.mo1490a(c4436q.level)) {
            return false;
        }
        return c4436q.isGreaterOrEqual(mo1498c());
    }

    /* renamed from: h */
    public boolean mo1494h() {
        if (this.f11162e.mo1490a(C4436q.INFO_INT)) {
            return false;
        }
        return Level.INFO.isGreaterOrEqual(mo1498c());
    }

    /* renamed from: b */
    public void mo1499b(String str, C4436q c4436q, Object obj, Throwable th) {
        if (!this.f11162e.mo1490a(c4436q.level) && c4436q.isGreaterOrEqual(mo1498c())) {
            m1633a(str, c4436q, obj, th);
        }
    }

    /* renamed from: b */
    private void m1630b(InterfaceC4395a interfaceC4395a) {
        if (interfaceC4395a != null) {
            InterfaceC4446h interfaceC4446h = this.f11162e;
            if (interfaceC4446h instanceof C4406h) {
                ((C4406h) interfaceC4446h).m1611b(this, interfaceC4395a);
            } else if (interfaceC4446h instanceof InterfaceC4444f) {
                ((InterfaceC4444f) interfaceC4446h).m1511b(this, interfaceC4395a);
            }
        }
    }

    /* renamed from: i */
    public synchronized void mo1493i() {
        if (this.f11163f != null) {
            Vector vector = new Vector();
            Enumeration m1609a = this.f11163f.m1609a();
            while (m1609a != null && m1609a.hasMoreElements()) {
                vector.add(m1609a.nextElement());
            }
            this.f11163f.m1606b();
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                m1630b((InterfaceC4395a) elements.nextElement());
            }
            this.f11163f = null;
        }
    }

    /* renamed from: a */
    public void m1631a(boolean z) {
        this.f11164g = z;
    }

    /* renamed from: a */
    public final void m1632a(InterfaceC4446h interfaceC4446h) {
        this.f11162e = interfaceC4446h;
    }

    /* renamed from: a */
    public void mo1479a(Level level) {
        this.f11159b = level;
    }

    /* renamed from: a */
    public void mo1506a(ResourceBundle resourceBundle) {
        this.f11161d = resourceBundle;
    }

    /* renamed from: d */
    public void mo1496d(Object obj) {
        if (!this.f11162e.mo1490a(30000) && Level.WARN.isGreaterOrEqual(mo1498c())) {
            m1633a(f11157i, Level.WARN, obj, null);
        }
    }
}
