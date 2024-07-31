package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.p125a.ObjectRenderer;
import org.apache.log4j.p125a.RendererMap;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;

/* renamed from: org.apache.log4j.h */
/* loaded from: classes2.dex */
public class Hierarchy implements LoggerRepository, RendererSupport, ThrowableRendererSupport {

    /* renamed from: b */
    C3044k f11179b;

    /* renamed from: c */
    RendererMap f11180c;

    /* renamed from: d */
    int f11181d;

    /* renamed from: e */
    Level f11182e;

    /* renamed from: h */
    private LoggerFactory f11185h;

    /* renamed from: f */
    boolean f11183f = false;

    /* renamed from: g */
    boolean f11184g = false;

    /* renamed from: j */
    private ThrowableRenderer f11187j = null;

    /* renamed from: a */
    Hashtable f11178a = new Hashtable();

    /* renamed from: i */
    private Vector f11186i = new Vector(1);

    public Hierarchy(C3044k c3044k) {
        this.f11179b = c3044k;
        mo1490a(Level.ALL);
        this.f11179b.m1635a((LoggerRepository) this);
        this.f11180c = new RendererMap();
        this.f11185h = new DefaultCategoryFactory();
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public void mo1489a(Category category) {
        if (this.f11183f) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("No appenders could be found for logger (");
        stringBuffer.append(category.m1631e());
        stringBuffer.append(").");
        LogLog.m1595c(stringBuffer.toString());
        LogLog.m1595c("Please initialize the log4j system properly.");
        LogLog.m1595c("See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.");
        this.f11183f = true;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public void mo1490a(Level level) {
        if (level != null) {
            this.f11181d = level.level;
            this.f11182e = level;
        }
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public void mo1488a(Category category, Appender appender) {
        Vector vector = this.f11186i;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((HierarchyEventListener) this.f11186i.elementAt(i)).m1515a(category, appender);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m1614b(Category category, Appender appender) {
        Vector vector = this.f11186i;
        if (vector != null) {
            int size = vector.size();
            for (int i = 0; i < size; i++) {
                ((HierarchyEventListener) this.f11186i.elementAt(i)).m1514b(category, appender);
            }
        }
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public Level mo1494a() {
        return this.f11182e;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public C3044k mo1492a(String str) {
        return mo1491a(str, this.f11185h);
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public C3044k mo1491a(String str, LoggerFactory loggerFactory) {
        CategoryKey categoryKey = new CategoryKey(str);
        synchronized (this.f11178a) {
            Object obj = this.f11178a.get(categoryKey);
            if (obj == null) {
                C3044k mo1513a = loggerFactory.mo1513a(str);
                mo1513a.m1635a((LoggerRepository) this);
                this.f11178a.put(categoryKey, mo1513a);
                m1616a(mo1513a);
                return mo1513a;
            } else if (obj instanceof C3044k) {
                return (C3044k) obj;
            } else if (obj instanceof ProvisionNode) {
                C3044k mo1513a2 = loggerFactory.mo1513a(str);
                mo1513a2.m1635a((LoggerRepository) this);
                this.f11178a.put(categoryKey, mo1513a2);
                m1617a((ProvisionNode) obj, mo1513a2);
                m1616a(mo1513a2);
                return mo1513a2;
            } else {
                return null;
            }
        }
    }

    /* renamed from: b */
    public Enumeration m1615b() {
        Vector vector = new Vector(this.f11178a.size());
        Enumeration elements = this.f11178a.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof C3044k) {
                vector.addElement(nextElement);
            }
        }
        return vector.elements();
    }

    @Override // org.apache.log4j.spi.RendererSupport
    /* renamed from: c */
    public RendererMap mo1484c() {
        return this.f11180c;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: d */
    public C3044k mo1487d() {
        return this.f11179b;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: a */
    public boolean mo1493a(int i) {
        return this.f11181d > i;
    }

    @Override // org.apache.log4j.spi.LoggerRepository
    /* renamed from: e */
    public void mo1486e() {
        mo1487d().mo1482a(Level.DEBUG);
        this.f11179b.mo1509a((ResourceBundle) null);
        mo1490a(Level.ALL);
        synchronized (this.f11178a) {
            m1613g();
            Enumeration m1615b = m1615b();
            while (m1615b.hasMoreElements()) {
                C3044k c3044k = (C3044k) m1615b.nextElement();
                c3044k.mo1482a((Level) null);
                c3044k.m1634a(true);
                c3044k.mo1509a((ResourceBundle) null);
            }
        }
        this.f11180c.m1652a();
        this.f11187j = null;
    }

    @Override // org.apache.log4j.spi.RendererSupport
    /* renamed from: a */
    public void mo1485a(Class cls, ObjectRenderer objectRenderer) {
        this.f11180c.m1650a(cls, objectRenderer);
    }

    @Override // org.apache.log4j.spi.ThrowableRendererSupport
    /* renamed from: a */
    public void mo1480a(ThrowableRenderer throwableRenderer) {
        this.f11187j = throwableRenderer;
    }

    @Override // org.apache.log4j.spi.ThrowableRendererSupport
    /* renamed from: f */
    public ThrowableRenderer mo1479f() {
        return this.f11187j;
    }

    /* renamed from: g */
    public void m1613g() {
        C3044k mo1487d = mo1487d();
        mo1487d.m1638a();
        synchronized (this.f11178a) {
            Enumeration m1615b = m1615b();
            while (m1615b.hasMoreElements()) {
                ((C3044k) m1615b.nextElement()).m1638a();
            }
            mo1487d.mo1496i();
            Enumeration m1615b2 = m1615b();
            while (m1615b2.hasMoreElements()) {
                ((C3044k) m1615b2.nextElement()).mo1496i();
            }
        }
    }

    /* renamed from: a */
    private final void m1616a(C3044k c3044k) {
        String str = c3044k.f11158a;
        boolean z = true;
        int lastIndexOf = str.lastIndexOf(46, str.length() - 1);
        while (true) {
            if (lastIndexOf < 0) {
                z = false;
                break;
            }
            CategoryKey categoryKey = new CategoryKey(str.substring(0, lastIndexOf));
            Object obj = this.f11178a.get(categoryKey);
            if (obj == null) {
                this.f11178a.put(categoryKey, new ProvisionNode(c3044k));
            } else if (obj instanceof Category) {
                c3044k.f11160c = (Category) obj;
                break;
            } else if (obj instanceof ProvisionNode) {
                ((ProvisionNode) obj).addElement(c3044k);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("unexpected object type ");
                stringBuffer.append(obj.getClass());
                stringBuffer.append(" in ht.");
                new IllegalStateException(stringBuffer.toString()).printStackTrace();
            }
            lastIndexOf = str.lastIndexOf(46, lastIndexOf - 1);
        }
        if (z) {
            return;
        }
        c3044k.f11160c = this.f11179b;
    }

    /* renamed from: a */
    private final void m1617a(ProvisionNode provisionNode, C3044k c3044k) {
        int size = provisionNode.size();
        for (int i = 0; i < size; i++) {
            C3044k c3044k2 = (C3044k) provisionNode.elementAt(i);
            if (!c3044k2.f11160c.f11158a.startsWith(c3044k.f11158a)) {
                c3044k.f11160c = c3044k2.f11160c;
                c3044k2.f11160c = c3044k;
            }
        }
    }
}
