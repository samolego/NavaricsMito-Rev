package org.apache.log4j;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.helpers.NullEnumeration;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

/* renamed from: org.apache.log4j.c */
/* loaded from: classes2.dex */
public class Category implements AppenderAttachable {

    /* renamed from: h */
    static Class f11156h;

    /* renamed from: i */
    private static final String f11157i;

    /* renamed from: a */
    protected String f11158a;

    /* renamed from: b */
    protected volatile Level f11159b;

    /* renamed from: c */
    protected volatile Category f11160c;

    /* renamed from: d */
    protected ResourceBundle f11161d;

    /* renamed from: e */
    protected LoggerRepository f11162e;

    /* renamed from: f */
    AppenderAttachableImpl f11163f;

    /* renamed from: g */
    protected boolean f11164g = true;

    static {
        Class cls = f11156h;
        if (cls == null) {
            cls = m1637a("org.apache.log4j.c");
            f11156h = cls;
        }
        f11157i = cls.getName();
    }

    /* renamed from: a */
    static Class m1637a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Category(String str) {
        this.f11158a = str;
    }

    /* renamed from: a */
    public synchronized void mo1508a(Appender appender) {
        if (this.f11163f == null) {
            this.f11163f = new AppenderAttachableImpl();
        }
        this.f11163f.m1611a(appender);
        this.f11162e.mo1488a(this, appender);
    }

    /* renamed from: a */
    public void mo1506a(LoggingEvent loggingEvent) {
        int i = 0;
        Category category = this;
        while (true) {
            if (category == null) {
                break;
            }
            synchronized (category) {
                if (category.f11163f != null) {
                    i += category.f11163f.m1610a(loggingEvent);
                }
                if (!category.f11164g) {
                    break;
                }
            }
            category = category.f11160c;
        }
        if (i == 0) {
            this.f11162e.mo1489a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void m1638a() {
        Enumeration mo1505b = mo1505b();
        if (mo1505b != null) {
            while (mo1505b.hasMoreElements()) {
                Appender appender = (Appender) mo1505b.nextElement();
                if (appender instanceof AppenderAttachable) {
                    appender.mo1478a();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo1511a(Object obj) {
        if (!this.f11162e.mo1493a(Priority.DEBUG_INT) && Level.DEBUG.isGreaterOrEqual(mo1501c())) {
            m1636a(f11157i, Level.DEBUG, obj, null);
        }
    }

    /* renamed from: a */
    public void mo1510a(Object obj, Throwable th) {
        if (!this.f11162e.mo1493a(Priority.DEBUG_INT) && Level.DEBUG.isGreaterOrEqual(mo1501c())) {
            m1636a(f11157i, Level.DEBUG, obj, th);
        }
    }

    /* renamed from: b */
    public void mo1504b(Object obj) {
        if (!this.f11162e.mo1493a(Priority.ERROR_INT) && Level.ERROR.isGreaterOrEqual(mo1501c())) {
            m1636a(f11157i, Level.ERROR, obj, null);
        }
    }

    /* renamed from: b */
    public void mo1503b(Object obj, Throwable th) {
        if (!this.f11162e.mo1493a(Priority.ERROR_INT) && Level.ERROR.isGreaterOrEqual(mo1501c())) {
            m1636a(f11157i, Level.ERROR, obj, th);
        }
    }

    /* renamed from: a */
    protected void m1636a(String str, Priority priority, Object obj, Throwable th) {
        mo1506a(new LoggingEvent(str, this, priority, obj, th));
    }

    /* renamed from: b */
    public synchronized Enumeration mo1505b() {
        if (this.f11163f == null) {
            return NullEnumeration.m1593a();
        }
        return this.f11163f.m1612a();
    }

    /* renamed from: c */
    public Level mo1501c() {
        for (Category category = this; category != null; category = category.f11160c) {
            if (category.f11159b != null) {
                return category.f11159b;
            }
        }
        return null;
    }

    /* renamed from: d */
    public LoggerRepository m1632d() {
        return this.f11162e;
    }

    /* renamed from: e */
    public final String m1631e() {
        return this.f11158a;
    }

    /* renamed from: f */
    public final Level m1630f() {
        return this.f11159b;
    }

    /* renamed from: c */
    public void mo1500c(Object obj) {
        if (!this.f11162e.mo1493a(Priority.INFO_INT) && Level.INFO.isGreaterOrEqual(mo1501c())) {
            m1636a(f11157i, Level.INFO, obj, null);
        }
    }

    /* renamed from: g */
    public boolean mo1498g() {
        if (this.f11162e.mo1493a(Priority.DEBUG_INT)) {
            return false;
        }
        return Level.DEBUG.isGreaterOrEqual(mo1501c());
    }

    /* renamed from: a */
    public boolean mo1507a(Priority priority) {
        if (this.f11162e.mo1493a(priority.level)) {
            return false;
        }
        return priority.isGreaterOrEqual(mo1501c());
    }

    /* renamed from: h */
    public boolean mo1497h() {
        if (this.f11162e.mo1493a(Priority.INFO_INT)) {
            return false;
        }
        return Level.INFO.isGreaterOrEqual(mo1501c());
    }

    /* renamed from: b */
    public void mo1502b(String str, Priority priority, Object obj, Throwable th) {
        if (!this.f11162e.mo1493a(priority.level) && priority.isGreaterOrEqual(mo1501c())) {
            m1636a(str, priority, obj, th);
        }
    }

    /* renamed from: b */
    private void m1633b(Appender appender) {
        if (appender != null) {
            LoggerRepository loggerRepository = this.f11162e;
            if (loggerRepository instanceof Hierarchy) {
                ((Hierarchy) loggerRepository).m1614b(this, appender);
            } else if (loggerRepository instanceof HierarchyEventListener) {
                ((HierarchyEventListener) loggerRepository).m1514b(this, appender);
            }
        }
    }

    /* renamed from: i */
    public synchronized void mo1496i() {
        if (this.f11163f != null) {
            Vector vector = new Vector();
            Enumeration m1612a = this.f11163f.m1612a();
            while (m1612a != null && m1612a.hasMoreElements()) {
                vector.add(m1612a.nextElement());
            }
            this.f11163f.m1609b();
            Enumeration elements = vector.elements();
            while (elements.hasMoreElements()) {
                m1633b((Appender) elements.nextElement());
            }
            this.f11163f = null;
        }
    }

    /* renamed from: a */
    public void m1634a(boolean z) {
        this.f11164g = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m1635a(LoggerRepository loggerRepository) {
        this.f11162e = loggerRepository;
    }

    /* renamed from: a */
    public void mo1482a(Level level) {
        this.f11159b = level;
    }

    /* renamed from: a */
    public void mo1509a(ResourceBundle resourceBundle) {
        this.f11161d = resourceBundle;
    }

    /* renamed from: d */
    public void mo1499d(Object obj) {
        if (!this.f11162e.mo1493a(30000) && Level.WARN.isGreaterOrEqual(mo1501c())) {
            m1636a(f11157i, Level.WARN, obj, null);
        }
    }
}
