package org.apache.commons.pool2.impl;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.BaseGenericObjectPool;

/* renamed from: org.apache.commons.pool2.impl.k */
/* loaded from: classes2.dex */
public class GenericKeyedObjectPool<K, T> extends BaseGenericObjectPool<T> implements KeyedObjectPool<K, T> {

    /* renamed from: i */
    private volatile int f10822i;

    /* renamed from: j */
    private volatile int f10823j;

    /* renamed from: k */
    private volatile int f10824k;

    /* renamed from: l */
    private final KeyedPooledObjectFactory<K, T> f10825l;

    /* renamed from: m */
    private final boolean f10826m;

    /* renamed from: n */
    private final Map<K, GenericKeyedObjectPool<K, T>.C3020a<T>> f10827n;

    /* renamed from: o */
    private final List<K> f10828o;

    /* renamed from: p */
    private final ReadWriteLock f10829p;

    /* renamed from: q */
    private final AtomicInteger f10830q;

    /* renamed from: r */
    private Iterator<K> f10831r;

    /* renamed from: s */
    private K f10832s;

    public GenericKeyedObjectPool(KeyedPooledObjectFactory<K, T> keyedPooledObjectFactory, GenericKeyedObjectPoolConfig<T> genericKeyedObjectPoolConfig) {
        super(genericKeyedObjectPoolConfig, "org.apache.commons.pool2:type=GenericKeyedObjectPool,name=", genericKeyedObjectPoolConfig.m2100r());
        this.f10822i = 8;
        this.f10823j = 0;
        this.f10824k = 8;
        this.f10827n = new ConcurrentHashMap();
        this.f10828o = new ArrayList();
        this.f10829p = new ReentrantReadWriteLock(true);
        this.f10830q = new AtomicInteger(0);
        this.f10831r = null;
        this.f10832s = null;
        if (keyedPooledObjectFactory == null) {
            m2124s();
            throw new IllegalArgumentException("factory may not be null");
        }
        this.f10825l = keyedPooledObjectFactory;
        this.f10826m = genericKeyedObjectPoolConfig.m2116b();
        m2063a((GenericKeyedObjectPoolConfig) genericKeyedObjectPoolConfig);
    }

    /* renamed from: a */
    public int m2071a() {
        return this.f10824k;
    }

    /* renamed from: c */
    public void m2061c(int i) {
        this.f10824k = i;
    }

    /* renamed from: t */
    public int m2052t() {
        return this.f10822i;
    }

    /* renamed from: d */
    public void m2059d(int i) {
        this.f10822i = i;
    }

    /* renamed from: e */
    public void m2057e(int i) {
        this.f10823j = i;
    }

    /* renamed from: u */
    public int m2051u() {
        int m2052t = m2052t();
        return this.f10823j > m2052t ? m2052t : this.f10823j;
    }

    /* renamed from: a */
    public void m2063a(GenericKeyedObjectPoolConfig<T> genericKeyedObjectPoolConfig) {
        m2148b(genericKeyedObjectPoolConfig.m2118a());
        m2059d(genericKeyedObjectPoolConfig.m2033v());
        m2061c(genericKeyedObjectPoolConfig.m2035t());
        m2164a(genericKeyedObjectPoolConfig.m2036s());
        m2057e(genericKeyedObjectPoolConfig.m2034u());
        m2163a(genericKeyedObjectPoolConfig.m2115c());
        m2154a(genericKeyedObjectPoolConfig.m2103o());
        m2145c(genericKeyedObjectPoolConfig.m2110h());
        m2142d(genericKeyedObjectPoolConfig.m2109i());
        m2139e(genericKeyedObjectPoolConfig.m2108j());
        m2136f(genericKeyedObjectPoolConfig.m2107k());
        m2152b(genericKeyedObjectPoolConfig.m2112f());
        m2146c(genericKeyedObjectPoolConfig.m2114d());
        m2143d(genericKeyedObjectPoolConfig.m2113e());
        m2151b(genericKeyedObjectPoolConfig.m2106l());
        EvictionPolicy<T> m = genericKeyedObjectPoolConfig.m2105m();
        if (m == null) {
            m2161a(genericKeyedObjectPoolConfig.m2104n());
        } else {
            m2155a((EvictionPolicy) m);
        }
        m2140e(genericKeyedObjectPoolConfig.m2111g());
    }

    @Override // org.apache.commons.pool2.KeyedObjectPool
    /* renamed from: a */
    public T mo2070a(K k) throws Exception {
        return m2069a((GenericKeyedObjectPool<K, T>) k, m2144d());
    }

    /* renamed from: a */
    public T m2069a(K k, long j) throws Exception {
        boolean z;
        m2126p();
        boolean c = m2147c();
        long currentTimeMillis = System.currentTimeMillis();
        GenericKeyedObjectPool<K, T>.C3020a<T> m2055f = m2055f((GenericKeyedObjectPool<K, T>) k);
        PooledObject<T> pooledObject = null;
        while (pooledObject == null) {
            try {
                pooledObject = m2055f.m2045a().pollFirst();
                if (pooledObject == null) {
                    pooledObject = m2056e((GenericKeyedObjectPool<K, T>) k);
                    z = pooledObject != null;
                } else {
                    z = false;
                }
                if (c) {
                    if (pooledObject == null) {
                        if (j < 0) {
                            pooledObject = m2055f.m2045a().takeFirst();
                        } else {
                            pooledObject = m2055f.m2045a().pollFirst(j, TimeUnit.MILLISECONDS);
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
                        this.f10825l.mo2186d(k, pooledObject);
                    } catch (Exception e) {
                        try {
                            m2066a((GenericKeyedObjectPool<K, T>) k, (PooledObject) pooledObject, true);
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
                        if (this.f10825l.mo2187c(k, pooledObject)) {
                            continue;
                        } else {
                            try {
                                m2066a((GenericKeyedObjectPool<K, T>) k, (PooledObject) pooledObject, true);
                                this.f10757h.incrementAndGet();
                            } catch (Exception unused2) {
                            }
                            if (z) {
                                NoSuchElementException noSuchElementException2 = new NoSuchElementException("Unable to validate object");
                                noSuchElementException2.initCause(null);
                                throw noSuchElementException2;
                            }
                            pooledObject = null;
                        }
                    }
                }
            } catch (Throwable th) {
                m2054g((GenericKeyedObjectPool<K, T>) k);
                throw th;
            }
        }
        m2054g((GenericKeyedObjectPool<K, T>) k);
        m2158a((PooledObject) pooledObject, System.currentTimeMillis() - currentTimeMillis);
        return pooledObject.mo2097a();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:25|(8:32|(1:34)(1:43)|35|(1:37)|38|(1:40)|41|42)|44|45|38|(0)|41|42) */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0089, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x008a, code lost:
        m2162a(r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c9  */
    @Override // org.apache.commons.pool2.KeyedObjectPool
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo2068a(K r7, T r8) {
        /*
            r6 = this;
            java.util.Map<K, org.apache.commons.pool2.impl.k<K, T>$a<T>> r0 = r6.f10827n
            java.lang.Object r0 = r0.get(r7)
            org.apache.commons.pool2.impl.k$a r0 = (org.apache.commons.pool2.impl.GenericKeyedObjectPool.C3020a) r0
            java.util.Map r1 = r0.m2039d()
            org.apache.commons.pool2.impl.b$c r2 = new org.apache.commons.pool2.impl.b$c
            r2.<init>(r8)
            java.lang.Object r8 = r1.get(r2)
            org.apache.commons.pool2.h r8 = (org.apache.commons.pool2.PooledObject) r8
            if (r8 == 0) goto Ld0
            r6.m2159a(r8)
            long r1 = r8.mo2092b()
            boolean r3 = r6.m2133h()     // Catch: java.lang.Throwable -> Lc2
            r4 = 1
            if (r3 == 0) goto L4b
            org.apache.commons.pool2.e<K, T> r3 = r6.f10825l     // Catch: java.lang.Throwable -> Lc2
            boolean r3 = r3.mo2187c(r7, r8)     // Catch: java.lang.Throwable -> Lc2
            if (r3 != 0) goto L4b
            r6.m2066a(r7, r8, r4)     // Catch: java.lang.Exception -> L33 java.lang.Throwable -> Lc2
            goto L37
        L33:
            r8 = move-exception
            r6.m2162a(r8)     // Catch: java.lang.Throwable -> Lc2
        L37:
            org.apache.commons.pool2.impl.LinkedBlockingDeque r8 = org.apache.commons.pool2.impl.GenericKeyedObjectPool.C3020a.m2044a(r0)     // Catch: java.lang.Throwable -> Lc2
            r6.m2065a(r7, r8)     // Catch: java.lang.Throwable -> Lc2
            boolean r7 = r6.m2073A()
            if (r7 == 0) goto L47
            r6.m2046z()
        L47:
            r6.m2134g(r1)
            return
        L4b:
            org.apache.commons.pool2.e<K, T> r3 = r6.f10825l     // Catch: java.lang.Exception -> La2 java.lang.Throwable -> Lc2
            r3.mo2190a(r7, r8)     // Catch: java.lang.Exception -> La2 java.lang.Throwable -> Lc2
            boolean r3 = r8.mo2085h()     // Catch: java.lang.Throwable -> Lc2
            if (r3 == 0) goto L9a
            int r3 = r6.m2052t()     // Catch: java.lang.Throwable -> Lc2
            org.apache.commons.pool2.impl.LinkedBlockingDeque r0 = r0.m2045a()     // Catch: java.lang.Throwable -> Lc2
            boolean r5 = r6.m2128m()     // Catch: java.lang.Throwable -> Lc2
            if (r5 != 0) goto L85
            r5 = -1
            if (r3 <= r5) goto L6e
            int r5 = r0.size()     // Catch: java.lang.Throwable -> Lc2
            if (r3 > r5) goto L6e
            goto L85
        L6e:
            boolean r3 = r6.m2141e()     // Catch: java.lang.Throwable -> Lc2
            if (r3 == 0) goto L78
            r0.addFirst(r8)     // Catch: java.lang.Throwable -> Lc2
            goto L7b
        L78:
            r0.addLast(r8)     // Catch: java.lang.Throwable -> Lc2
        L7b:
            boolean r8 = r6.m2128m()     // Catch: java.lang.Throwable -> Lc2
            if (r8 == 0) goto L8d
            r6.m2062b(r7)     // Catch: java.lang.Throwable -> Lc2
            goto L8d
        L85:
            r6.m2066a(r7, r8, r4)     // Catch: java.lang.Exception -> L89 java.lang.Throwable -> Lc2
            goto L8d
        L89:
            r7 = move-exception
            r6.m2162a(r7)     // Catch: java.lang.Throwable -> Lc2
        L8d:
            boolean r7 = r6.m2073A()
            if (r7 == 0) goto L96
            r6.m2046z()
        L96:
            r6.m2134g(r1)
            return
        L9a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> Lc2
            java.lang.String r8 = "Object has already been returned to this pool"
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Lc2
            throw r7     // Catch: java.lang.Throwable -> Lc2
        La2:
            r3 = move-exception
            r6.m2162a(r3)     // Catch: java.lang.Throwable -> Lc2
            r6.m2066a(r7, r8, r4)     // Catch: java.lang.Exception -> Laa java.lang.Throwable -> Lc2
            goto Lae
        Laa:
            r8 = move-exception
            r6.m2162a(r8)     // Catch: java.lang.Throwable -> Lc2
        Lae:
            org.apache.commons.pool2.impl.LinkedBlockingDeque r8 = org.apache.commons.pool2.impl.GenericKeyedObjectPool.C3020a.m2044a(r0)     // Catch: java.lang.Throwable -> Lc2
            r6.m2065a(r7, r8)     // Catch: java.lang.Throwable -> Lc2
            boolean r7 = r6.m2073A()
            if (r7 == 0) goto Lbe
            r6.m2046z()
        Lbe:
            r6.m2134g(r1)
            return
        Lc2:
            r7 = move-exception
            boolean r8 = r6.m2073A()
            if (r8 == 0) goto Lcc
            r6.m2046z()
        Lcc:
            r6.m2134g(r1)
            throw r7
        Ld0:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Returned object not currently part of this pool"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.pool2.impl.GenericKeyedObjectPool.mo2068a(java.lang.Object, java.lang.Object):void");
    }

    /* renamed from: a */
    private void m2065a(K k, LinkedBlockingDeque<PooledObject<T>> linkedBlockingDeque) {
        if (linkedBlockingDeque.hasTakeWaiters()) {
            try {
                m2058d((GenericKeyedObjectPool<K, T>) k);
            } catch (Exception e) {
                m2162a(e);
            }
        }
    }

    /* renamed from: v */
    public void m2050v() {
        for (K k : this.f10827n.keySet()) {
            m2062b((GenericKeyedObjectPool<K, T>) k);
        }
    }

    /* renamed from: b */
    public void m2062b(K k) {
        try {
            LinkedBlockingDeque<PooledObject<T>> m2045a = m2055f((GenericKeyedObjectPool<K, T>) k).m2045a();
            for (PooledObject<T> poll = m2045a.poll(); poll != null; poll = m2045a.poll()) {
                try {
                    m2066a((GenericKeyedObjectPool<K, T>) k, (PooledObject) poll, true);
                    continue;
                } catch (Exception e) {
                    m2162a(e);
                    continue;
                }
            }
        } finally {
            m2054g((GenericKeyedObjectPool<K, T>) k);
        }
    }

    /* renamed from: w */
    public int m2049w() {
        return this.f10830q.get() - m2048x();
    }

    /* renamed from: x */
    public int m2048x() {
        int i = 0;
        for (GenericKeyedObjectPool<K, T>.C3020a<T> c3020a : this.f10827n.values()) {
            i += c3020a.m2045a().size();
        }
        return i;
    }

    /* renamed from: c */
    public int m2060c(K k) {
        GenericKeyedObjectPool<K, T>.C3020a<T> c3020a = this.f10827n.get(k);
        if (c3020a != null) {
            return c3020a.m2039d().size() - c3020a.m2045a().size();
        }
        return 0;
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
            m2050v();
            m2124s();
            for (GenericKeyedObjectPool<K, T>.C3020a<T> c3020a : this.f10827n.values()) {
                c3020a.m2045a().interuptTakeWaiters();
            }
            m2050v();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: y */
    public void m2047y() {
        boolean z;
        TreeMap treeMap = new TreeMap();
        for (Map.Entry<K, GenericKeyedObjectPool<K, T>.C3020a<T>> entry : this.f10827n.entrySet()) {
            K key = entry.getKey();
            GenericKeyedObjectPool<K, T>.C3020a<T> value = entry.getValue();
            if (value != null) {
                Iterator<PooledObject<T>> it = value.m2045a().iterator();
                while (it.hasNext()) {
                    treeMap.put(it.next(), key);
                }
            }
        }
        int size = ((int) (treeMap.size() * 0.15d)) + 1;
        Iterator it2 = treeMap.entrySet().iterator();
        while (it2.hasNext() && size > 0) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            try {
                z = m2066a((GenericKeyedObjectPool<K, T>) entry2.getValue(), (PooledObject) entry2.getKey(), false);
            } catch (Exception e) {
                m2162a(e);
                z = true;
            }
            if (z) {
                size--;
            }
        }
    }

    /* renamed from: z */
    private void m2046z() {
        int m2071a = m2071a();
        LinkedBlockingDeque<PooledObject<T>> linkedBlockingDeque = null;
        K k = null;
        int i = 0;
        for (Map.Entry<K, GenericKeyedObjectPool<K, T>.C3020a<T>> entry : this.f10827n.entrySet()) {
            K key = entry.getKey();
            GenericKeyedObjectPool<K, T>.C3020a<T> value = entry.getValue();
            if (value != null) {
                LinkedBlockingDeque<PooledObject<T>> m2045a = value.m2045a();
                int takeQueueLength = m2045a.getTakeQueueLength();
                if (m2060c((GenericKeyedObjectPool<K, T>) key) < m2071a && takeQueueLength > i) {
                    linkedBlockingDeque = m2045a;
                    k = key;
                    i = takeQueueLength;
                }
            }
        }
        if (linkedBlockingDeque != null) {
            m2055f((GenericKeyedObjectPool<K, T>) k);
            try {
                try {
                    PooledObject<T> m2056e = m2056e((GenericKeyedObjectPool<K, T>) k);
                    if (m2056e != null) {
                        m2067a((GenericKeyedObjectPool<K, T>) k, (PooledObject) m2056e);
                    }
                } catch (Exception e) {
                    m2162a(e);
                }
            } finally {
                m2054g((GenericKeyedObjectPool<K, T>) k);
            }
        }
    }

    /* renamed from: A */
    private boolean m2073A() {
        for (Map.Entry<K, GenericKeyedObjectPool<K, T>.C3020a<T>> entry : this.f10827n.entrySet()) {
            GenericKeyedObjectPool<K, T>.C3020a<T> value = entry.getValue();
            if (value != null && value.m2045a().hasTakeWaiters()) {
                return true;
            }
        }
        return false;
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    /* renamed from: n */
    public void mo2020n() throws Exception {
        boolean z;
        m2126p();
        if (m2048x() == 0) {
            return;
        }
        EvictionPolicy<T> o = m2127o();
        synchronized (this.f10752c) {
            EvictionConfig evictionConfig = new EvictionConfig(m2130k(), m2129l(), m2051u());
            boolean i = m2132i();
            int m2072B = m2072B();
            int i2 = 0;
            while (i2 < m2072B) {
                if (this.f10753d == null || !this.f10753d.hasNext()) {
                    if (this.f10831r == null || !this.f10831r.hasNext()) {
                        ArrayList arrayList = new ArrayList();
                        Lock readLock = this.f10829p.readLock();
                        readLock.lock();
                        arrayList.addAll(this.f10828o);
                        readLock.unlock();
                        this.f10831r = arrayList.iterator();
                    }
                    while (this.f10831r.hasNext()) {
                        this.f10832s = this.f10831r.next();
                        GenericKeyedObjectPool<K, T>.C3020a<T> c3020a = this.f10827n.get(this.f10832s);
                        if (c3020a != null) {
                            this.f10753d = new BaseGenericObjectPool.C3013a(c3020a.m2045a());
                            if (this.f10753d.hasNext()) {
                                break;
                            }
                            this.f10753d = null;
                        }
                    }
                }
                if (this.f10753d == null) {
                    return;
                }
                try {
                    PooledObject<T> next = this.f10753d.next();
                    Deque<PooledObject<T>> m2123a = this.f10753d.m2123a();
                    if (!next.mo2087f()) {
                        i2--;
                    } else if (o.mo2077a(evictionConfig, next, this.f10827n.get(this.f10832s).m2045a().size())) {
                        m2066a((GenericKeyedObjectPool<K, T>) this.f10832s, (PooledObject) next, true);
                        this.f10756g.incrementAndGet();
                    } else {
                        if (i) {
                            try {
                                this.f10825l.mo2186d(this.f10832s, next);
                                z = true;
                            } catch (Exception unused) {
                                m2066a((GenericKeyedObjectPool<K, T>) this.f10832s, (PooledObject) next, true);
                                this.f10756g.incrementAndGet();
                                z = false;
                            }
                            if (z) {
                                if (!this.f10825l.mo2187c(this.f10832s, next)) {
                                    m2066a((GenericKeyedObjectPool<K, T>) this.f10832s, (PooledObject) next, true);
                                    this.f10756g.incrementAndGet();
                                } else {
                                    try {
                                        this.f10825l.mo2190a(this.f10832s, next);
                                    } catch (Exception unused2) {
                                        m2066a((GenericKeyedObjectPool<K, T>) this.f10832s, (PooledObject) next, true);
                                        this.f10756g.incrementAndGet();
                                    }
                                }
                            }
                        }
                        next.mo2095a(m2123a);
                    }
                } catch (NoSuchElementException unused3) {
                    i2--;
                    this.f10753d = null;
                }
                i2++;
            }
        }
    }

    /* renamed from: e */
    private PooledObject<T> m2056e(K k) throws Exception {
        int m2071a = m2071a();
        if (m2071a < 0) {
            m2071a = Integer.MAX_VALUE;
        }
        int b = m2153b();
        GenericKeyedObjectPool<K, T>.C3020a<T> c3020a = this.f10827n.get(k);
        boolean z = true;
        while (z) {
            int incrementAndGet = this.f10830q.incrementAndGet();
            if (b <= -1 || incrementAndGet <= b) {
                z = false;
            } else {
                this.f10830q.decrementAndGet();
                if (m2048x() == 0) {
                    return null;
                }
                m2047y();
            }
        }
        Boolean bool = null;
        while (bool == null) {
            synchronized (((C3020a) c3020a).f10837e) {
                if (c3020a.m2043b().incrementAndGet() > m2071a) {
                    c3020a.m2043b().decrementAndGet();
                    if (((C3020a) c3020a).f10836d == 0) {
                        bool = Boolean.FALSE;
                    } else {
                        ((C3020a) c3020a).f10837e.wait();
                    }
                } else {
                    C3020a.m2038d(c3020a);
                    bool = Boolean.TRUE;
                }
            }
        }
        if (!bool.booleanValue()) {
            this.f10830q.decrementAndGet();
            return null;
        }
        try {
            try {
                PooledObject<T> mo2188c = this.f10825l.mo2188c(k);
                synchronized (((C3020a) c3020a).f10837e) {
                    C3020a.m2037e(c3020a);
                    ((C3020a) c3020a).f10837e.notifyAll();
                }
                this.f10754e.incrementAndGet();
                c3020a.m2039d().put(new BaseGenericObjectPool.C3015c<>(mo2188c.mo2097a()), mo2188c);
                return mo2188c;
            } catch (Exception e) {
                this.f10830q.decrementAndGet();
                c3020a.m2043b().decrementAndGet();
                throw e;
            }
        } catch (Throwable th) {
            synchronized (((C3020a) c3020a).f10837e) {
                C3020a.m2037e(c3020a);
                ((C3020a) c3020a).f10837e.notifyAll();
                throw th;
            }
        }
    }

    /* renamed from: a */
    private boolean m2066a(K k, PooledObject<T> pooledObject, boolean z) throws Exception {
        GenericKeyedObjectPool<K, T>.C3020a<T> m2055f = m2055f((GenericKeyedObjectPool<K, T>) k);
        try {
            if (m2055f.m2045a().remove(pooledObject) || z) {
                m2055f.m2039d().remove(new BaseGenericObjectPool.C3015c(pooledObject.mo2097a()));
                pooledObject.mo2084i();
                this.f10825l.mo2189b(k, pooledObject);
                m2055f.m2043b().decrementAndGet();
                this.f10755f.incrementAndGet();
                this.f10830q.decrementAndGet();
                return true;
            }
            return false;
        } finally {
            m2054g((GenericKeyedObjectPool<K, T>) k);
        }
    }

    /* renamed from: f */
    private GenericKeyedObjectPool<K, T>.C3020a<T> m2055f(K k) {
        Lock readLock = this.f10829p.readLock();
        try {
            readLock.lock();
            GenericKeyedObjectPool<K, T>.C3020a<T> c3020a = this.f10827n.get(k);
            if (c3020a == null) {
                readLock.unlock();
                readLock = this.f10829p.writeLock();
                readLock.lock();
                c3020a = this.f10827n.get(k);
                if (c3020a == null) {
                    c3020a = new C3020a<>(this.f10826m);
                    c3020a.m2041c().incrementAndGet();
                    this.f10827n.put(k, c3020a);
                    this.f10828o.add(k);
                } else {
                    c3020a.m2041c().incrementAndGet();
                }
            } else {
                c3020a.m2041c().incrementAndGet();
            }
            return c3020a;
        } finally {
            readLock.unlock();
        }
    }

    /* renamed from: g */
    private void m2054g(K k) {
        GenericKeyedObjectPool<K, T>.C3020a<T> c3020a = this.f10827n.get(k);
        if (c3020a.m2041c().decrementAndGet() == 0 && c3020a.m2043b().get() == 0) {
            Lock writeLock = this.f10829p.writeLock();
            writeLock.lock();
            try {
                if (c3020a.m2043b().get() == 0 && c3020a.m2041c().get() == 0) {
                    this.f10827n.remove(k);
                    this.f10828o.remove(k);
                }
            } finally {
                writeLock.unlock();
            }
        }
    }

    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool
    /* renamed from: q */
    void mo2019q() throws Exception {
        if (m2051u() < 1) {
            return;
        }
        for (K k : this.f10827n.keySet()) {
            m2053h(k);
        }
    }

    /* renamed from: h */
    private void m2053h(K k) throws Exception {
        GenericKeyedObjectPool<K, T>.C3020a<T> c3020a = this.f10827n.get(k);
        int m2064a = m2064a((C3020a) c3020a);
        for (int i = 0; i < m2064a && m2064a((C3020a) c3020a) > 0; i++) {
            m2058d((GenericKeyedObjectPool<K, T>) k);
            if (c3020a == null) {
                c3020a = this.f10827n.get(k);
            }
        }
    }

    /* renamed from: d */
    public void m2058d(K k) throws Exception {
        m2126p();
        m2055f((GenericKeyedObjectPool<K, T>) k);
        try {
            m2067a((GenericKeyedObjectPool<K, T>) k, (PooledObject) m2056e((GenericKeyedObjectPool<K, T>) k));
        } finally {
            m2054g((GenericKeyedObjectPool<K, T>) k);
        }
    }

    /* renamed from: a */
    private void m2067a(K k, PooledObject<T> pooledObject) throws Exception {
        if (pooledObject != null) {
            this.f10825l.mo2190a(k, pooledObject);
            LinkedBlockingDeque<PooledObject<T>> m2045a = this.f10827n.get(k).m2045a();
            if (m2141e()) {
                m2045a.addFirst(pooledObject);
            } else {
                m2045a.addLast(pooledObject);
            }
        }
    }

    /* renamed from: B */
    private int m2072B() {
        int m2048x = m2048x();
        int j = m2131j();
        if (j >= 0) {
            return Math.min(j, m2048x);
        }
        return (int) Math.ceil(m2048x / Math.abs(j));
    }

    /* renamed from: a */
    private int m2064a(GenericKeyedObjectPool<K, T>.C3020a<T> c3020a) {
        if (c3020a == null) {
            return m2051u();
        }
        int b = m2153b();
        int m2071a = m2071a();
        int m2051u = m2051u() - c3020a.m2045a().size();
        if (m2071a > 0) {
            m2051u = Math.min(m2051u, Math.max(0, m2071a - c3020a.m2045a().size()));
        }
        return b > 0 ? Math.min(m2051u, Math.max(0, (b - m2049w()) - m2048x())) : m2051u;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: GenericKeyedObjectPool.java */
    /* renamed from: org.apache.commons.pool2.impl.k$a */
    /* loaded from: classes2.dex */
    public class C3020a<S> {

        /* renamed from: b */
        private final LinkedBlockingDeque<PooledObject<S>> f10834b;

        /* renamed from: c */
        private final AtomicInteger f10835c = new AtomicInteger(0);

        /* renamed from: d */
        private long f10836d = 0;

        /* renamed from: e */
        private final Object f10837e = new Object();

        /* renamed from: f */
        private final Map<BaseGenericObjectPool.C3015c<S>, PooledObject<S>> f10838f = new ConcurrentHashMap();

        /* renamed from: g */
        private final AtomicLong f10839g = new AtomicLong(0);

        /* renamed from: d */
        static /* synthetic */ long m2038d(C3020a c3020a) {
            long j = c3020a.f10836d;
            c3020a.f10836d = 1 + j;
            return j;
        }

        /* renamed from: e */
        static /* synthetic */ long m2037e(C3020a c3020a) {
            long j = c3020a.f10836d;
            c3020a.f10836d = j - 1;
            return j;
        }

        public C3020a(boolean z) {
            this.f10834b = new LinkedBlockingDeque<>(z);
        }

        /* renamed from: a */
        public LinkedBlockingDeque<PooledObject<S>> m2045a() {
            return this.f10834b;
        }

        /* renamed from: b */
        public AtomicInteger m2043b() {
            return this.f10835c;
        }

        /* renamed from: c */
        public AtomicLong m2041c() {
            return this.f10839g;
        }

        /* renamed from: d */
        public Map<BaseGenericObjectPool.C3015c<S>, PooledObject<S>> m2039d() {
            return this.f10838f;
        }

        public String toString() {
            return "ObjectDeque [idleObjects=" + this.f10834b + ", createCount=" + this.f10835c + ", allObjects=" + this.f10838f + ", numInterested=" + this.f10839g + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.pool2.impl.BaseGenericObjectPool, org.apache.commons.pool2.BaseObject
    /* renamed from: a */
    public void mo2010a(StringBuilder sb) {
        super.mo2010a(sb);
        sb.append(", maxIdlePerKey=");
        sb.append(this.f10822i);
        sb.append(", minIdlePerKey=");
        sb.append(this.f10823j);
        sb.append(", maxTotalPerKey=");
        sb.append(this.f10824k);
        sb.append(", factory=");
        sb.append(this.f10825l);
        sb.append(", fairness=");
        sb.append(this.f10826m);
        sb.append(", poolMap=");
        sb.append(this.f10827n);
        sb.append(", poolKeyList=");
        sb.append(this.f10828o);
        sb.append(", keyLock=");
        sb.append(this.f10829p);
        sb.append(", numTotal=");
        sb.append(this.f10830q);
        sb.append(", evictionKeyIterator=");
        sb.append(this.f10831r);
        sb.append(", evictionKey=");
        sb.append(this.f10832s);
    }
}
