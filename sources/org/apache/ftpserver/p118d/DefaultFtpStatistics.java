package org.apache.ftpserver.p118d;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.ftpserver.ftplet.FtpFile;
import org.apache.ftpserver.ftplet.User;

/* renamed from: org.apache.ftpserver.d.h */
/* loaded from: classes2.dex */
public class DefaultFtpStatistics implements ServerFtpStatistics {

    /* renamed from: a */
    private StatisticsObserver f11006a = null;

    /* renamed from: b */
    private FileObserver f11007b = null;

    /* renamed from: c */
    private Date f11008c = new Date();

    /* renamed from: d */
    private AtomicInteger f11009d = new AtomicInteger(0);

    /* renamed from: e */
    private AtomicInteger f11010e = new AtomicInteger(0);

    /* renamed from: f */
    private AtomicInteger f11011f = new AtomicInteger(0);

    /* renamed from: g */
    private AtomicInteger f11012g = new AtomicInteger(0);

    /* renamed from: h */
    private AtomicInteger f11013h = new AtomicInteger(0);

    /* renamed from: i */
    private AtomicInteger f11014i = new AtomicInteger(0);

    /* renamed from: j */
    private AtomicInteger f11015j = new AtomicInteger(0);

    /* renamed from: k */
    private AtomicInteger f11016k = new AtomicInteger(0);

    /* renamed from: l */
    private AtomicInteger f11017l = new AtomicInteger(0);

    /* renamed from: m */
    private AtomicInteger f11018m = new AtomicInteger(0);

    /* renamed from: n */
    private AtomicInteger f11019n = new AtomicInteger(0);

    /* renamed from: o */
    private AtomicInteger f11020o = new AtomicInteger(0);

    /* renamed from: p */
    private AtomicLong f11021p = new AtomicLong(0);

    /* renamed from: q */
    private AtomicLong f11022q = new AtomicLong(0);

    /* renamed from: r */
    private Map<String, C3027a> f11023r = new ConcurrentHashMap();

    /* compiled from: DefaultFtpStatistics.java */
    /* renamed from: org.apache.ftpserver.d.h$a */
    /* loaded from: classes2.dex */
    private static class C3027a {

        /* renamed from: b */
        private Map<InetAddress, AtomicInteger> f11025b = new ConcurrentHashMap();

        /* renamed from: a */
        public AtomicInteger f11024a = new AtomicInteger(1);

        public C3027a(InetAddress inetAddress) {
            this.f11025b.put(inetAddress, new AtomicInteger(1));
        }

        /* renamed from: a */
        public AtomicInteger m1919a(InetAddress inetAddress) {
            AtomicInteger atomicInteger = this.f11025b.get(inetAddress);
            if (atomicInteger == null) {
                AtomicInteger atomicInteger2 = new AtomicInteger(0);
                this.f11025b.put(inetAddress, atomicInteger2);
                return atomicInteger2;
            }
            return atomicInteger;
        }
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: a */
    public Date mo1744a() {
        Date date = this.f11008c;
        if (date != null) {
            return (Date) date.clone();
        }
        return null;
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: b */
    public int mo1741b() {
        return this.f11009d.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: c */
    public int mo1740c() {
        return this.f11010e.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: d */
    public int mo1739d() {
        return this.f11011f.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: e */
    public long mo1738e() {
        return this.f11021p.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: f */
    public long mo1737f() {
        return this.f11022q.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: g */
    public int mo1736g() {
        return this.f11012g.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: h */
    public int mo1735h() {
        return this.f11013h.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: i */
    public int mo1734i() {
        return this.f11020o.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: j */
    public int mo1733j() {
        return this.f11019n.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: k */
    public int mo1732k() {
        return this.f11015j.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: l */
    public int mo1731l() {
        return this.f11014i.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: m */
    public int mo1730m() {
        return this.f11018m.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: n */
    public int mo1729n() {
        return this.f11017l.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: a */
    public synchronized int mo1743a(User user) {
        C3027a c3027a = this.f11023r.get(user.mo1717a());
        if (c3027a == null) {
            return 0;
        }
        return c3027a.f11024a.get();
    }

    @Override // org.apache.ftpserver.ftplet.FtpStatistics
    /* renamed from: a */
    public synchronized int mo1742a(User user, InetAddress inetAddress) {
        C3027a c3027a = this.f11023r.get(user.mo1717a());
        if (c3027a == null) {
            return 0;
        }
        return c3027a.m1919a(inetAddress).get();
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: a */
    public synchronized void mo1827a(FtpIoSession ftpIoSession, FtpFile ftpFile, long j) {
        this.f11009d.incrementAndGet();
        this.f11021p.addAndGet(j);
        m1929c(ftpIoSession, ftpFile, j);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: b */
    public synchronized void mo1824b(FtpIoSession ftpIoSession, FtpFile ftpFile, long j) {
        this.f11010e.incrementAndGet();
        this.f11022q.addAndGet(j);
        m1927d(ftpIoSession, ftpFile, j);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: a */
    public synchronized void mo1828a(FtpIoSession ftpIoSession, FtpFile ftpFile) {
        this.f11011f.incrementAndGet();
        m1928d(ftpIoSession, ftpFile);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: b */
    public synchronized void mo1825b(FtpIoSession ftpIoSession, FtpFile ftpFile) {
        this.f11012g.incrementAndGet();
        m1926e(ftpIoSession, ftpFile);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: c */
    public synchronized void mo1822c(FtpIoSession ftpIoSession, FtpFile ftpFile) {
        this.f11013h.incrementAndGet();
        m1924f(ftpIoSession, ftpFile);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: a */
    public synchronized void mo1829a(FtpIoSession ftpIoSession) {
        this.f11019n.incrementAndGet();
        this.f11020o.incrementAndGet();
        m1925f(ftpIoSession);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: b */
    public synchronized void mo1826b(FtpIoSession ftpIoSession) {
        if (this.f11019n.get() > 0) {
            this.f11019n.decrementAndGet();
        }
        m1923g(ftpIoSession);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: c */
    public synchronized void mo1823c(FtpIoSession ftpIoSession) {
        this.f11014i.incrementAndGet();
        this.f11015j.incrementAndGet();
        User m1876u = ftpIoSession.m1876u();
        if ("anonymous".equals(m1876u.mo1717a())) {
            this.f11017l.incrementAndGet();
            this.f11018m.incrementAndGet();
        }
        synchronized (m1876u) {
            C3027a c3027a = this.f11023r.get(m1876u.mo1717a());
            if (c3027a == null) {
                this.f11023r.put(m1876u.mo1717a(), new C3027a(ftpIoSession.mo994l() instanceof InetSocketAddress ? ((InetSocketAddress) ftpIoSession.mo994l()).getAddress() : null));
            } else {
                c3027a.f11024a.incrementAndGet();
                if (ftpIoSession.mo994l() instanceof InetSocketAddress) {
                    c3027a.m1919a(((InetSocketAddress) ftpIoSession.mo994l()).getAddress()).incrementAndGet();
                }
            }
        }
        m1922h(ftpIoSession);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: d */
    public synchronized void mo1821d(FtpIoSession ftpIoSession) {
        this.f11016k.incrementAndGet();
        m1921i(ftpIoSession);
    }

    @Override // org.apache.ftpserver.p118d.ServerFtpStatistics
    /* renamed from: e */
    public synchronized void mo1820e(FtpIoSession ftpIoSession) {
        User m1876u = ftpIoSession.m1876u();
        if (m1876u == null) {
            return;
        }
        this.f11014i.decrementAndGet();
        if ("anonymous".equals(m1876u.mo1717a())) {
            this.f11017l.decrementAndGet();
        }
        synchronized (m1876u) {
            C3027a c3027a = this.f11023r.get(m1876u.mo1717a());
            if (c3027a != null) {
                c3027a.f11024a.decrementAndGet();
                if (ftpIoSession.mo994l() instanceof InetSocketAddress) {
                    c3027a.m1919a(((InetSocketAddress) ftpIoSession.mo994l()).getAddress()).decrementAndGet();
                }
            }
        }
        m1920j(ftpIoSession);
    }

    /* renamed from: c */
    private void m1929c(FtpIoSession ftpIoSession, FtpFile ftpFile, long j) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            statisticsObserver.m1819a();
        }
        FileObserver fileObserver = this.f11007b;
        if (fileObserver != null) {
            fileObserver.m1917a(ftpIoSession, ftpFile, j);
        }
    }

    /* renamed from: d */
    private void m1927d(FtpIoSession ftpIoSession, FtpFile ftpFile, long j) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            statisticsObserver.m1816b();
        }
        FileObserver fileObserver = this.f11007b;
        if (fileObserver != null) {
            fileObserver.m1915b(ftpIoSession, ftpFile, j);
        }
    }

    /* renamed from: d */
    private void m1928d(FtpIoSession ftpIoSession, FtpFile ftpFile) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            statisticsObserver.m1814c();
        }
        FileObserver fileObserver = this.f11007b;
        if (fileObserver != null) {
            fileObserver.m1918a(ftpIoSession, ftpFile);
        }
    }

    /* renamed from: e */
    private void m1926e(FtpIoSession ftpIoSession, FtpFile ftpFile) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            statisticsObserver.m1813d();
        }
        FileObserver fileObserver = this.f11007b;
        if (fileObserver != null) {
            fileObserver.m1916b(ftpIoSession, ftpFile);
        }
    }

    /* renamed from: f */
    private void m1924f(FtpIoSession ftpIoSession, FtpFile ftpFile) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            statisticsObserver.m1812e();
        }
        FileObserver fileObserver = this.f11007b;
        if (fileObserver != null) {
            fileObserver.m1914c(ftpIoSession, ftpFile);
        }
    }

    /* renamed from: f */
    private void m1925f(FtpIoSession ftpIoSession) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            statisticsObserver.m1811f();
        }
    }

    /* renamed from: g */
    private void m1923g(FtpIoSession ftpIoSession) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            statisticsObserver.m1810g();
        }
    }

    /* renamed from: h */
    private void m1922h(FtpIoSession ftpIoSession) {
        String mo1717a;
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            User m1876u = ftpIoSession.m1876u();
            boolean z = false;
            if (m1876u != null && (mo1717a = m1876u.mo1717a()) != null && mo1717a.equals("anonymous")) {
                z = true;
            }
            statisticsObserver.m1817a(z);
        }
    }

    /* renamed from: i */
    private void m1921i(FtpIoSession ftpIoSession) {
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver == null || !(ftpIoSession.mo994l() instanceof InetSocketAddress)) {
            return;
        }
        statisticsObserver.m1818a(((InetSocketAddress) ftpIoSession.mo994l()).getAddress());
    }

    /* renamed from: j */
    private void m1920j(FtpIoSession ftpIoSession) {
        String mo1717a;
        StatisticsObserver statisticsObserver = this.f11006a;
        if (statisticsObserver != null) {
            User m1876u = ftpIoSession.m1876u();
            boolean z = false;
            if (m1876u != null && (mo1717a = m1876u.mo1717a()) != null && mo1717a.equals("anonymous")) {
                z = true;
            }
            statisticsObserver.m1815b(z);
        }
    }
}
