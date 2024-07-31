package org.apache.commons.pool2.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.impl.BaseGenericObjectPool;

/* renamed from: org.apache.commons.pool2.impl.m */
/* loaded from: classes2.dex */
public class GenericObjectPool<T> extends BaseGenericObjectPool<T> implements ObjectPool<T> {

    /* renamed from: i */
    private volatile String f10844i;

    /* renamed from: j */
    private volatile int f10845j;

    /* renamed from: k */
    private volatile int f10846k;

    /* renamed from: l */
    private final PooledObjectFactory<T> f10847l;

    /* renamed from: m */
    private final Map<BaseGenericObjectPool.C3015c<T>, PooledObject<T>> f10848m;

    /* renamed from: n */
    private final AtomicLong f10849n;

    /* renamed from: o */
    private long f10850o;

    /* renamed from: p */
    private final Object f10851p;

    /* renamed from: q */
    private final LinkedBlockingDeque<PooledObject<T>> f10852q;

    /* renamed from: r */
    private volatile AbandonedConfig f10853r;

    public GenericObjectPool(PooledObjectFactory<T> pooledObjectFactory, GenericObjectPoolConfig<T> genericObjectPoolConfig) {
        super(genericObjectPoolConfig, "org.apache.commons.pool2:type=GenericObjectPool,name=", genericObjectPoolConfig.m2100r());
        this.f10844i = null;
        this.f10845j = 8;
        this.f10846k = 0;
        this.f10848m = new ConcurrentHashMap();
        this.f10849n = new AtomicLong(0L);
        this.f10850o = 0L;
        this.f10851p = new Object();
        this.f10853r = null;
        if (pooledObjectFactory == null) {
            m2124s();
            throw new IllegalArgumentException("factory may not be null");
        }
        this.f10847l = pooledObjectFactory;
        this.f10852q = new LinkedBlockingDeque<>(genericObjectPoolConfig.m2116b());
        m2026a((GenericObjectPoolConfig) genericObjectPoolConfig);
    }

    /* renamed from: t */
    public int m2018t() {
        return this.f10845j;
    }

    /* renamed from: c */
    public void m2023c(int i) {
        this.f10845j = i;
    }

    /* renamed from: d */
    public void m2022d(int i) {
        this.f10846k = i;
    }

    /* renamed from: u */
    public int m2017u() {
        int m2018t = m2018t();
        return this.f10846k > m2018t ? m2018t : this.f10846k;
    }

    /* renamed from: v */
    public boolean m2016v() {
        return this.f10853r != null;
    }

    /* renamed from: a */
    public void m2026a(GenericObjectPoolConfig<T> genericObjectPoolConfig) {
        m2148b(genericObjectPoolConfig.m2118a());
        m2023c(genericObjectPoolConfig.m2008t());
        m2022d(genericObjectPoolConfig.m2007u());
        m2164a(genericObjectPoolConfig.m2009s());
        m2163a(genericObjectPoolConfig.m2115c());
        m2154a(genericObjectPoolConfig.m2103o());
        m2145c(genericObjectPoolConfig.m2110h());
        m2142d(genericObjectPoolConfig.m2109i());
        m2139e(genericObjectPoolConfig.m2108j());
        m2136f(genericObjectPoolConfig.m2107k());
        m2152b(genericObjectPoolConfig.m2112f());
        m2146c(genericObjectPoolConfig.m2114d());
        m2151b(genericObjectPoolConfig.m2106l());
        m2143d(genericObjectPoolConfig.m2113e());
        EvictionPolicy<T> m = genericObjectPoolConfig.m2105m();
        if (m == null) {
            m2161a(genericObjectPoolConfig.m2104n());
        } else {
            m2155a((EvictionPolicy) m);
        }
        m2140e(genericObjectPoolConfig.m2111g());
    }

    @Override // org.apache.commons.pool2.ObjectPool
    /* renamed from: a */
    public T mo2030a() throws Exception {
        return m2021h(m2144d());
    }

    /* renamed from: h */
    public T m2021h(long j) throws Exception {
        boolean z;
        m2126p();
        AbandonedConfig abandonedConfig = this.f10853r;
        if (abandonedConfig != null && abandonedConfig.m2170a() && m2013y() < 2 && m2014x() > m2153b() - 3) {
            m2027a(abandonedConfig);
        }
        boolean c = m2147c();
        long currentTimeMillis = System.currentTimeMillis();
        PooledObject<T> pooledObject = null;
        while (pooledObject == null) {
            pooledObject = this.f10852q.pollFirst();
            boolean z2 = false;
            if (pooledObject == null) {
                pooledObject = m2012z();
                z = pooledObject != null;
            } else {
                z = false;
            }
            if (c) {
                if (pooledObject == null) {
                    if (j < 0) {
                        pooledObject = this.f10852q.takeFirst();
                    } else {
                        pooledObject = this.f10852q.pollFirst(j, TimeUnit.MILLISECONDS);
                    }
                }
                if (pooledObject == null) {
                    throw new NoSuchElementException("Timeout waiting for idle object");
                }
            } else if (pooledObject == null) {
                throw new NoSuchElementException("Pool exhausted");
            }
            if (!pooledObject.mo2086g()) {
                pooledObject = null;
            }
            if (pooledObject != null) {
                try {
                    this.f10847l.mo2180d(pooledObject);
                } catch (Exception e) {
                    try {
                        m2024b((PooledObject) pooledObject);
                    } catch (Exception unused) {
                    }
                    if (z) {
                        NoSuchElementException noSuchElementException = new NoSuchElementException("Unable to activate object");
                        noSuchElementException.initCause(e);
                        throw noSuchElementException;
                    }
                    pooledObject = null;
                }
                if (pooledObject != null && (m2135g() || (z && m2138f()))) {
                    try {
                        z2 = this.f10847l.mo2181c(pooledObject);
                        th = null;
                    } catch (Throwable th) {
                        th = th;
                        PoolUtils.m2185a(th);
                    }
                    if (z2) {
                        continue;
                    } else {
                        try {
                            m2024b((PooledObject) pooledObject);
                            this.f10757h.incrementAndGet();
                        } catch (Exception unused2) {
                        }
                        if (z) {
                            NoSuchElementException noSuchElementException2 = new NoSuchElementException("Unable to validate object");
                            noSuchElementException2.initCause(th);
                            throw noSuchElementException2;
                        }
                        pooledObject = null;
                    }
                }
            }
        }
        m2158a(pooledObject, System.currentTimeMillis() - currentTimeMillis);
        return pooledObject.mo2097a();
    }

    @Override // org.apache.commons.pool2.ObjectPool
    /* renamed from: a */
    public void mo2028a(T t) {
        PooledObject<T> pooledObject = this.f10848m.get(new BaseGenericObjectPool.C3015c(t));
        if (pooledObject == null) {
            if (!m2016v()) {
                throw new IllegalStateException("Returned object not currently part of this pool");
            }
            return;
        }
        m2159a((PooledObject) pooledObject);
        long mo2092b = pooledObject.mo2092b();
        if (m2133h() && !this.f10847l.mo2181c(pooledObject)) {
            try {
                m2024b((PooledObject) pooledObject);
            } catch (Exception e) {
                m2162a(e);
            }
            try {
                m2029a(1, false);
            } catch (Exception e2) {
                m2162a(e2);
            }
            m2134g(mo2092b);
            return;
        }
        try {
            this.f10847l.mo2184a(pooledObject);
            if (!pooledObject.mo2085h()) {
                throw new IllegalStateException("Object has already been returned to this pool or is invalid");
            }
            int m2018t = m2018t();
            if (m2128m() || (m2018t > -1 && m2018t <= this.f10852q.size())) {
                try {
                    m2024b((PooledObject) pooledObject);
                } catch (Exception e3) {
                    m2162a(e3);
                }
            } else {
                if (m2141e()) {
                    this.f10852q.addFirst(pooledObject);
                } else {
                    this.f10852q.addLast(pooledObject);
                }
                if (m2128m()) {
                    m2015w();
                }
            }
            m2134g(mo2092b);
        } catch (Exception e4) {
            m2162a(e4);
            try {
                m2024b((PooledObject) pooledObject);
            } catch (Exception e5) {
                m2162a(e5);
            }
            try {
                m2029a(1, false);
            } catch (Exception e6) {
                m2162a(e6);
            }
            m2134g(mo2092b);
        }
    }

    /* renamed from: b */
    public void m2025b(T t) throws Exception {
        PooledObject<T> pooledObject = this.f10848m.get(new BaseGenericObjectPool.C3015c(t));
        if (pooledObject == null) {
            if (!m2016v()) {
                throw new IllegalStateException("Invalidated object not currently part of this pool");
            }
            return;
        }
        synchronized (pooledObject) {
            if (pooledObject.mo2083j() != PooledObjectState.INVALID) {
                m2024b((PooledObject) pooledObject);
            }
        }
        m2029a(1, false);
    }

    /* renamed from: w */
    public void m2015w() {
        PooledObject<T> poll = this.f10852q.poll();
        while (poll != null) {
            try {
                m2024b((PooledObject) poll);
            } catch (Exception e) {
                m2162a(e);
            }
            poll = this.f10852q.poll();
        }
    }

    /* renamed from: x */
    public int m2014x() {
        return this.f10848m.size() - this.f10852q.size();
    }

    /* renamed from: y */
    public int m2013y() {
        return this.f10852q.size();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (m2128m()) {
            return;
        }
        synchronized (this.f10750a) {
            if (m2128m()) {
                return;
            }
            m2137f(-1L);
            this.f10751b = true;
            m2015w();
            m2124s();
            this.f10852q.interuptTakeWaiters();
        }
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    /* renamed from: n */
    public void mo2020n() throws Exception {
        boolean z;
        m2126p();
        if (this.f10852q.size() > 0) {
            EvictionPolicy<T> o = m2127o();
            synchronized (this.f10752c) {
                EvictionConfig evictionConfig = new EvictionConfig(m2130k(), m2129l(), m2017u());
                boolean i = m2132i();
                int m2031A = m2031A();
                int i2 = 0;
                while (i2 < m2031A) {
                    if (this.f10753d == null || !this.f10753d.hasNext()) {
                        this.f10753d = new BaseGenericObjectPool.C3013a(this.f10852q);
                    }
                    if (!this.f10753d.hasNext()) {
                        return;
                    }
                    try {
                        PooledObject<T> next = this.f10753d.next();
                        if (!next.mo2087f()) {
                            i2--;
                        } else if (o.mo2077a(evictionConfig, next, this.f10852q.size())) {
                            m2024b((PooledObject) next);
                            this.f10756g.incrementAndGet();
                        } else {
                            if (i) {
                                try {
                                    this.f10847l.mo2180d(next);
                                    z = true;
                                } catch (Exception unused) {
                                    m2024b((PooledObject) next);
                                    this.f10756g.incrementAndGet();
                                    z = false;
                                }
                                if (z) {
                                    if (!this.f10847l.mo2181c(next)) {
                                        m2024b((PooledObject) next);
                                        this.f10756g.incrementAndGet();
                                    } else {
                                        try {
                                            this.f10847l.mo2184a(next);
                                        } catch (Exception unused2) {
                                            m2024b((PooledObject) next);
                                            this.f10756g.incrementAndGet();
                                        }
                                    }
                                }
                            }
                            next.mo2095a(this.f10852q);
                        }
                    } catch (NoSuchElementException unused3) {
                        i2--;
                        this.f10753d = null;
                    }
                    i2++;
                }
            }
        }
        AbandonedConfig abandonedConfig = this.f10853r;
        if (abandonedConfig == null || !abandonedConfig.m2169b()) {
            return;
        }
        m2027a(abandonedConfig);
    }

    /* renamed from: z */
    private PooledObject<T> m2012z() throws Exception {
        int b = m2153b();
        if (b < 0) {
            b = Integer.MAX_VALUE;
        }
        Boolean bool = null;
        while (bool == null) {
            synchronized (this.f10851p) {
                if (this.f10849n.incrementAndGet() > b) {
                    this.f10849n.decrementAndGet();
                    if (this.f10850o == 0) {
                        bool = Boolean.FALSE;
                    } else {
                        this.f10851p.wait();
                    }
                } else {
                    this.f10850o++;
                    bool = Boolean.TRUE;
                }
            }
        }
        if (bool.booleanValue()) {
            try {
                PooledObject<T> mo2182c = this.f10847l.mo2182c();
                synchronized (this.f10851p) {
                    this.f10850o--;
                    this.f10851p.notifyAll();
                }
                AbandonedConfig abandonedConfig = this.f10853r;
                if (abandonedConfig != null && abandonedConfig.m2167d()) {
                    mo2182c.mo2093a(true);
                    if (mo2182c instanceof DefaultPooledObject) {
                        ((DefaultPooledObject) mo2182c).m2091b(abandonedConfig.m2166e());
                    }
                }
                this.f10754e.incrementAndGet();
                this.f10848m.put(new BaseGenericObjectPool.C3015c<>(mo2182c.mo2097a()), mo2182c);
                return mo2182c;
            } catch (Throwable th) {
                try {
                    this.f10849n.decrementAndGet();
                    throw th;
                } catch (Throwable th2) {
                    synchronized (this.f10851p) {
                        this.f10850o--;
                        this.f10851p.notifyAll();
                        throw th2;
                    }
                }
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m2024b(PooledObject<T> pooledObject) throws Exception {
        pooledObject.mo2084i();
        this.f10852q.remove(pooledObject);
        this.f10848m.remove(new BaseGenericObjectPool.C3015c(pooledObject.mo2097a()));
        try {
            this.f10847l.mo2183b(pooledObject);
        } finally {
            this.f10755f.incrementAndGet();
            this.f10849n.decrementAndGet();
        }
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    /* renamed from: q */
    void mo2019q() throws Exception {
        m2029a(m2017u(), true);
    }

    /* renamed from: a */
    private void m2029a(int i, boolean z) throws Exception {
        PooledObject<T> m2012z;
        if (i < 1 || m2128m()) {
            return;
        }
        if (z || this.f10852q.hasTakeWaiters()) {
            while (this.f10852q.size() < i && (m2012z = m2012z()) != null) {
                if (m2141e()) {
                    this.f10852q.addFirst(m2012z);
                } else {
                    this.f10852q.addLast(m2012z);
                }
            }
            if (m2128m()) {
                m2015w();
            }
        }
    }

    /* renamed from: A */
    private int m2031A() {
        int j = m2131j();
        if (j >= 0) {
            return Math.min(j, this.f10852q.size());
        }
        return (int) Math.ceil(this.f10852q.size() / Math.abs(j));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    private void m2027a(AbandonedConfig abandonedConfig) {
        long currentTimeMillis = System.currentTimeMillis() - (abandonedConfig.m2168c() * 1000);
        ArrayList arrayList = new ArrayList();
        for (PooledObject<T> pooledObject : this.f10848m.values()) {
            synchronized (pooledObject) {
                if (pooledObject.mo2083j() == PooledObjectState.ALLOCATED && pooledObject.mo2088e() <= currentTimeMillis) {
                    pooledObject.mo2082k();
                    arrayList.add(pooledObject);
                }
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            PooledObject pooledObject2 = (PooledObject) it.next();
            if (abandonedConfig.m2167d()) {
                pooledObject2.mo2096a(abandonedConfig.m2165f());
            }
            try {
                m2025b((GenericObjectPool<T>) pooledObject2.mo2097a());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.BaseObject
    /* renamed from: a */
    public void mo2010a(StringBuilder sb) {
        super.mo2010a(sb);
        sb.append(", factoryType=");
        sb.append(this.f10844i);
        sb.append(", maxIdle=");
        sb.append(this.f10845j);
        sb.append(", minIdle=");
        sb.append(this.f10846k);
        sb.append(", factory=");
        sb.append(this.f10847l);
        sb.append(", allObjects=");
        sb.append(this.f10848m);
        sb.append(", createCount=");
        sb.append(this.f10849n);
        sb.append(", idleObjects=");
        sb.append(this.f10852q);
        sb.append(", abandonedConfig=");
        sb.append(this.f10853r);
    }
}
