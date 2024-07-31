package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import org.apache.commons.pool2.BaseObject;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.SwallowedExceptionListener;

/* renamed from: org.apache.commons.pool2.impl.b */
/* loaded from: classes2.dex */
public abstract class BaseGenericObjectPool<T> extends BaseObject {

    /* renamed from: i */
    private static final String f10740i = EvictionPolicy.class.getName();

    /* renamed from: A */
    private final ObjectName f10741A;

    /* renamed from: B */
    private final String f10742B;

    /* renamed from: n */
    private final boolean f10762n;

    /* renamed from: w */
    private volatile EvictionPolicy<T> f10771w;

    /* renamed from: z */
    private final WeakReference<ClassLoader> f10774z;

    /* renamed from: j */
    private volatile int f10758j = -1;

    /* renamed from: k */
    private volatile boolean f10759k = true;

    /* renamed from: l */
    private volatile long f10760l = -1;

    /* renamed from: m */
    private volatile boolean f10761m = true;

    /* renamed from: o */
    private volatile boolean f10763o = false;

    /* renamed from: p */
    private volatile boolean f10764p = false;

    /* renamed from: q */
    private volatile boolean f10765q = false;

    /* renamed from: r */
    private volatile boolean f10766r = false;

    /* renamed from: s */
    private volatile long f10767s = -1;

    /* renamed from: t */
    private volatile int f10768t = 3;

    /* renamed from: u */
    private volatile long f10769u = 1800000;

    /* renamed from: v */
    private volatile long f10770v = -1;

    /* renamed from: x */
    private volatile long f10772x = 10000;

    /* renamed from: a */
    final Object f10750a = new Object();

    /* renamed from: b */
    volatile boolean f10751b = false;

    /* renamed from: c */
    final Object f10752c = new Object();

    /* renamed from: y */
    private BaseGenericObjectPool<T>.RunnableC3014b f10773y = null;

    /* renamed from: d */
    BaseGenericObjectPool<T>.C3013a f10753d = null;

    /* renamed from: C */
    private final AtomicLong f10743C = new AtomicLong(0);

    /* renamed from: D */
    private final AtomicLong f10744D = new AtomicLong(0);

    /* renamed from: e */
    final AtomicLong f10754e = new AtomicLong(0);

    /* renamed from: f */
    final AtomicLong f10755f = new AtomicLong(0);

    /* renamed from: g */
    final AtomicLong f10756g = new AtomicLong(0);

    /* renamed from: h */
    final AtomicLong f10757h = new AtomicLong(0);

    /* renamed from: E */
    private final BaseGenericObjectPool<T>.C3016d f10745E = new C3016d(100);

    /* renamed from: F */
    private final BaseGenericObjectPool<T>.C3016d f10746F = new C3016d(100);

    /* renamed from: G */
    private final BaseGenericObjectPool<T>.C3016d f10747G = new C3016d(100);

    /* renamed from: H */
    private final AtomicLong f10748H = new AtomicLong(0);

    /* renamed from: I */
    private volatile SwallowedExceptionListener f10749I = null;

    /* renamed from: n */
    public abstract void mo2020n() throws Exception;

    /* renamed from: q */
    abstract void mo2019q() throws Exception;

    public BaseGenericObjectPool(BaseObjectPoolConfig<T> baseObjectPoolConfig, String str, String str2) {
        if (baseObjectPoolConfig.m2102p()) {
            this.f10741A = m2156a(baseObjectPoolConfig, str, str2);
        } else {
            this.f10741A = null;
        }
        this.f10742B = m2150b(new Exception());
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            this.f10774z = null;
        } else {
            this.f10774z = new WeakReference<>(contextClassLoader);
        }
        this.f10762n = baseObjectPoolConfig.m2116b();
    }

    /* renamed from: b */
    public final int m2153b() {
        return this.f10758j;
    }

    /* renamed from: a */
    public final void m2164a(int i) {
        this.f10758j = i;
    }

    /* renamed from: c */
    public final boolean m2147c() {
        return this.f10759k;
    }

    /* renamed from: a */
    public final void m2154a(boolean z) {
        this.f10759k = z;
    }

    /* renamed from: d */
    public final long m2144d() {
        return this.f10760l;
    }

    /* renamed from: a */
    public final void m2163a(long j) {
        this.f10760l = j;
    }

    /* renamed from: e */
    public final boolean m2141e() {
        return this.f10761m;
    }

    /* renamed from: b */
    public final void m2148b(boolean z) {
        this.f10761m = z;
    }

    /* renamed from: f */
    public final boolean m2138f() {
        return this.f10763o;
    }

    /* renamed from: c */
    public final void m2145c(boolean z) {
        this.f10763o = z;
    }

    /* renamed from: g */
    public final boolean m2135g() {
        return this.f10764p;
    }

    /* renamed from: d */
    public final void m2142d(boolean z) {
        this.f10764p = z;
    }

    /* renamed from: h */
    public final boolean m2133h() {
        return this.f10765q;
    }

    /* renamed from: e */
    public final void m2139e(boolean z) {
        this.f10765q = z;
    }

    /* renamed from: i */
    public final boolean m2132i() {
        return this.f10766r;
    }

    /* renamed from: f */
    public final void m2136f(boolean z) {
        this.f10766r = z;
    }

    /* renamed from: b */
    public final void m2151b(long j) {
        this.f10767s = j;
        m2137f(j);
    }

    /* renamed from: j */
    public final int m2131j() {
        return this.f10768t;
    }

    /* renamed from: b */
    public final void m2152b(int i) {
        this.f10768t = i;
    }

    /* renamed from: k */
    public final long m2130k() {
        return this.f10769u;
    }

    /* renamed from: c */
    public final void m2146c(long j) {
        this.f10769u = j;
    }

    /* renamed from: l */
    public final long m2129l() {
        return this.f10770v;
    }

    /* renamed from: d */
    public final void m2143d(long j) {
        this.f10770v = j;
    }

    /* renamed from: a */
    public void m2155a(EvictionPolicy<T> evictionPolicy) {
        this.f10771w = evictionPolicy;
    }

    /* renamed from: a */
    public final void m2160a(String str, ClassLoader classLoader) {
        ClassLoader classLoader2 = EvictionPolicy.class.getClassLoader();
        try {
            try {
                try {
                    m2149b(str, classLoader);
                } catch (IllegalAccessException e) {
                    e = e;
                    throw new IllegalArgumentException("Unable to create " + f10740i + " instance of type " + str, e);
                } catch (InstantiationException e2) {
                    e = e2;
                    throw new IllegalArgumentException("Unable to create " + f10740i + " instance of type " + str, e);
                } catch (NoSuchMethodException e3) {
                    e = e3;
                    throw new IllegalArgumentException("Unable to create " + f10740i + " instance of type " + str, e);
                } catch (InvocationTargetException e4) {
                    e = e4;
                    throw new IllegalArgumentException("Unable to create " + f10740i + " instance of type " + str, e);
                }
            } catch (ClassCastException unused) {
                throw new IllegalArgumentException("Class " + str + " from class loaders [" + classLoader + ", " + classLoader2 + "] do not implement " + f10740i);
            } catch (ClassNotFoundException e5) {
                e = e5;
                throw new IllegalArgumentException("Unable to create " + f10740i + " instance of type " + str, e);
            }
        } catch (ClassCastException | ClassNotFoundException unused2) {
            m2149b(str, classLoader2);
        }
    }

    /* renamed from: b */
    private void m2149b(String str, ClassLoader classLoader) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        this.f10771w = (EvictionPolicy) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0]);
    }

    /* renamed from: a */
    public final void m2161a(String str) {
        m2160a(str, Thread.currentThread().getContextClassLoader());
    }

    /* renamed from: e */
    public final void m2140e(long j) {
        this.f10772x = j;
    }

    /* renamed from: m */
    public final boolean m2128m() {
        return this.f10751b;
    }

    /* renamed from: o */
    public EvictionPolicy<T> m2127o() {
        return this.f10771w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public final void m2126p() throws IllegalStateException {
        if (m2128m()) {
            throw new IllegalStateException("Pool not open");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public final void m2137f(long j) {
        synchronized (this.f10752c) {
            if (this.f10773y != null) {
                EvictionTimer.m2075a((BaseGenericObjectPool<?>.RunnableC3014b) this.f10773y, this.f10772x, TimeUnit.MILLISECONDS);
                this.f10773y = null;
                this.f10753d = null;
            }
            if (j > 0) {
                this.f10773y = new RunnableC3014b();
                EvictionTimer.m2076a((BaseGenericObjectPool<?>.RunnableC3014b) this.f10773y, j, j);
            }
        }
    }

    /* renamed from: r */
    public final SwallowedExceptionListener m2125r() {
        return this.f10749I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2162a(Exception exc) {
        SwallowedExceptionListener m2125r = m2125r();
        if (m2125r == null) {
            return;
        }
        try {
            m2125r.m1997a(exc);
        } catch (VirtualMachineError e) {
            throw e;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public final void m2158a(PooledObject<T> pooledObject, long j) {
        long j2;
        this.f10743C.incrementAndGet();
        this.f10746F.m2119a(pooledObject.mo2090c());
        this.f10747G.m2119a(j);
        do {
            j2 = this.f10748H.get();
            if (j2 >= j) {
                return;
            }
        } while (!this.f10748H.compareAndSet(j2, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public final void m2134g(long j) {
        this.f10744D.incrementAndGet();
        this.f10745E.m2119a(j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m2159a(PooledObject<T> pooledObject) {
        synchronized (pooledObject) {
            if (pooledObject.mo2083j() != PooledObjectState.ALLOCATED) {
                throw new IllegalStateException("Object has already been returned to this pool or is invalid");
            }
            pooledObject.mo2081l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: s */
    public final void m2124s() {
        if (this.f10741A != null) {
            try {
                ManagementFactory.getPlatformMBeanServer().unregisterMBean(this.f10741A);
            } catch (InstanceNotFoundException | MBeanRegistrationException e) {
                m2162a((Exception) e);
            }
        }
    }

    /* renamed from: a */
    private ObjectName m2156a(BaseObjectPoolConfig<T> baseObjectPoolConfig, String str, String str2) {
        String str3;
        String str4;
        int i;
        ObjectName objectName;
        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        String m2101q = baseObjectPoolConfig.m2101q();
        ObjectName objectName2 = null;
        boolean z = false;
        if (m2101q == null) {
            str3 = str2;
            i = 1;
            str4 = str;
        } else {
            str3 = str2;
            str4 = m2101q;
            i = 1;
        }
        while (!z) {
            if (i == 1) {
                try {
                    objectName = new ObjectName(str4 + str3);
                } catch (InstanceAlreadyExistsException unused) {
                    i++;
                } catch (MalformedObjectNameException unused2) {
                    if ("pool".equals(str3) && str.equals(str4)) {
                        z = true;
                    } else {
                        str3 = "pool";
                        str4 = str;
                    }
                } catch (MBeanRegistrationException | NotCompliantMBeanException unused3) {
                }
            } else {
                objectName = new ObjectName(str4 + str3 + i);
            }
            platformMBeanServer.registerMBean(this, objectName);
            objectName2 = objectName;
            z = true;
        }
        return objectName2;
    }

    /* renamed from: b */
    private String m2150b(Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseGenericObjectPool.java */
    /* renamed from: org.apache.commons.pool2.impl.b$b */
    /* loaded from: classes2.dex */
    public class RunnableC3014b implements Runnable {

        /* renamed from: b */
        private ScheduledFuture<?> f10779b;

        RunnableC3014b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            try {
                if (BaseGenericObjectPool.this.f10774z != null) {
                    ClassLoader classLoader = (ClassLoader) BaseGenericObjectPool.this.f10774z.get();
                    if (classLoader == null) {
                        m2121a();
                        return;
                    }
                    Thread.currentThread().setContextClassLoader(classLoader);
                }
                try {
                    BaseGenericObjectPool.this.mo2020n();
                } catch (Exception e) {
                    BaseGenericObjectPool.this.m2162a(e);
                } catch (OutOfMemoryError e2) {
                    e2.printStackTrace(System.err);
                }
                try {
                    BaseGenericObjectPool.this.mo2019q();
                } catch (Exception e3) {
                    BaseGenericObjectPool.this.m2162a(e3);
                }
            } finally {
                Thread.currentThread().setContextClassLoader(contextClassLoader);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m2120a(ScheduledFuture<?> scheduledFuture) {
            this.f10779b = scheduledFuture;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: a */
        public void m2121a() {
            this.f10779b.cancel(false);
        }
    }

    /* compiled from: BaseGenericObjectPool.java */
    /* renamed from: org.apache.commons.pool2.impl.b$d */
    /* loaded from: classes2.dex */
    private class C3016d {

        /* renamed from: b */
        private final AtomicLong[] f10782b;

        /* renamed from: c */
        private final int f10783c;

        /* renamed from: d */
        private int f10784d;

        public C3016d(int i) {
            this.f10783c = i;
            this.f10782b = new AtomicLong[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f10782b[i2] = new AtomicLong(-1L);
            }
        }

        /* renamed from: a */
        public synchronized void m2119a(long j) {
            this.f10782b[this.f10784d].set(j);
            this.f10784d++;
            if (this.f10784d == this.f10783c) {
                this.f10784d = 0;
            }
        }

        public String toString() {
            return "StatsStore [values=" + Arrays.toString(this.f10782b) + ", size=" + this.f10783c + ", index=" + this.f10784d + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseGenericObjectPool.java */
    /* renamed from: org.apache.commons.pool2.impl.b$a */
    /* loaded from: classes2.dex */
    public class C3013a implements Iterator<PooledObject<T>> {

        /* renamed from: b */
        private final Deque<PooledObject<T>> f10776b;

        /* renamed from: c */
        private final Iterator<PooledObject<T>> f10777c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public C3013a(Deque<PooledObject<T>> deque) {
            this.f10776b = deque;
            if (BaseGenericObjectPool.this.m2141e()) {
                this.f10777c = deque.descendingIterator();
            } else {
                this.f10777c = deque.iterator();
            }
        }

        /* renamed from: a */
        public Deque<PooledObject<T>> m2123a() {
            return this.f10776b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10777c.hasNext();
        }

        @Override // java.util.Iterator
        /* renamed from: b */
        public PooledObject<T> next() {
            return this.f10777c.next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f10777c.remove();
        }
    }

    /* compiled from: BaseGenericObjectPool.java */
    /* renamed from: org.apache.commons.pool2.impl.b$c */
    /* loaded from: classes2.dex */
    static class C3015c<T> {

        /* renamed from: a */
        private final T f10780a;

        public C3015c(T t) {
            this.f10780a = t;
        }

        public int hashCode() {
            return System.identityHashCode(this.f10780a);
        }

        public boolean equals(Object obj) {
            return (obj instanceof C3015c) && ((C3015c) obj).f10780a == this.f10780a;
        }

        public String toString() {
            return "IdentityWrapper [instance=" + this.f10780a + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.pool2.BaseObject
    /* renamed from: a */
    public void mo2010a(StringBuilder sb) {
        sb.append("maxTotal=");
        sb.append(this.f10758j);
        sb.append(", blockWhenExhausted=");
        sb.append(this.f10759k);
        sb.append(", maxWaitMillis=");
        sb.append(this.f10760l);
        sb.append(", lifo=");
        sb.append(this.f10761m);
        sb.append(", fairness=");
        sb.append(this.f10762n);
        sb.append(", testOnCreate=");
        sb.append(this.f10763o);
        sb.append(", testOnBorrow=");
        sb.append(this.f10764p);
        sb.append(", testOnReturn=");
        sb.append(this.f10765q);
        sb.append(", testWhileIdle=");
        sb.append(this.f10766r);
        sb.append(", timeBetweenEvictionRunsMillis=");
        sb.append(this.f10767s);
        sb.append(", numTestsPerEvictionRun=");
        sb.append(this.f10768t);
        sb.append(", minEvictableIdleTimeMillis=");
        sb.append(this.f10769u);
        sb.append(", softMinEvictableIdleTimeMillis=");
        sb.append(this.f10770v);
        sb.append(", evictionPolicy=");
        sb.append(this.f10771w);
        sb.append(", closeLock=");
        sb.append(this.f10750a);
        sb.append(", closed=");
        sb.append(this.f10751b);
        sb.append(", evictionLock=");
        sb.append(this.f10752c);
        sb.append(", evictor=");
        sb.append(this.f10773y);
        sb.append(", evictionIterator=");
        sb.append(this.f10753d);
        sb.append(", factoryClassLoader=");
        sb.append(this.f10774z);
        sb.append(", oname=");
        sb.append(this.f10741A);
        sb.append(", creationStackTrace=");
        sb.append(this.f10742B);
        sb.append(", borrowedCount=");
        sb.append(this.f10743C);
        sb.append(", returnedCount=");
        sb.append(this.f10744D);
        sb.append(", createdCount=");
        sb.append(this.f10754e);
        sb.append(", destroyedCount=");
        sb.append(this.f10755f);
        sb.append(", destroyedByEvictorCount=");
        sb.append(this.f10756g);
        sb.append(", destroyedByBorrowValidationCount=");
        sb.append(this.f10757h);
        sb.append(", activeTimes=");
        sb.append(this.f10745E);
        sb.append(", idleTimes=");
        sb.append(this.f10746F);
        sb.append(", waitTimes=");
        sb.append(this.f10747G);
        sb.append(", maxBorrowWaitTimeMillis=");
        sb.append(this.f10748H);
        sb.append(", swallowedExceptionListener=");
        sb.append(this.f10749I);
    }
}
