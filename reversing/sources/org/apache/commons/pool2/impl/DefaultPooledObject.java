package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.util.Deque;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.TrackedUse;

/* renamed from: org.apache.commons.pool2.impl.g */
/* loaded from: classes2.dex */
public class DefaultPooledObject<T> implements PooledObject<T> {

    /* renamed from: a */
    private final T f10806a;

    /* renamed from: b */
    private PooledObjectState f10807b = PooledObjectState.IDLE;

    /* renamed from: c */
    private final long f10808c = System.currentTimeMillis();

    /* renamed from: d */
    private volatile long f10809d;

    /* renamed from: e */
    private volatile long f10810e;

    /* renamed from: f */
    private volatile long f10811f;

    /* renamed from: g */
    private volatile boolean f10812g;

    /* renamed from: h */
    private volatile CallStack f10813h;

    /* renamed from: i */
    private volatile CallStack f10814i;

    /* renamed from: j */
    private volatile long f10815j;

    public DefaultPooledObject(T t) {
        long j = this.f10808c;
        this.f10809d = j;
        this.f10810e = j;
        this.f10811f = j;
        this.f10812g = false;
        this.f10813h = NoOpCallStack.f10857a;
        this.f10814i = NoOpCallStack.f10857a;
        this.f10815j = 0L;
        this.f10806a = t;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: a */
    public T mo2097a() {
        return this.f10806a;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: b */
    public long mo2092b() {
        long j = this.f10811f;
        long j2 = this.f10809d;
        return j > j2 ? j - j2 : System.currentTimeMillis() - j2;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: c */
    public long mo2090c() {
        long currentTimeMillis = System.currentTimeMillis() - this.f10811f;
        if (currentTimeMillis >= 0) {
            return currentTimeMillis;
        }
        return 0L;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: d */
    public long mo2089d() {
        return this.f10811f;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: e */
    public long mo2088e() {
        T t = this.f10806a;
        if (t instanceof TrackedUse) {
            return Math.max(((TrackedUse) t).m1996a(), this.f10810e);
        }
        return this.f10810e;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(PooledObject<T> pooledObject) {
        long mo2089d = mo2089d() - pooledObject.mo2089d();
        if (mo2089d == 0) {
            return System.identityHashCode(this) - System.identityHashCode(pooledObject);
        }
        return (int) Math.min(Math.max(mo2089d, -2147483648L), 2147483647L);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Object: ");
        sb.append(this.f10806a.toString());
        sb.append(", State: ");
        synchronized (this) {
            sb.append(this.f10807b.toString());
        }
        return sb.toString();
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: f */
    public synchronized boolean mo2087f() {
        if (this.f10807b == PooledObjectState.IDLE) {
            this.f10807b = PooledObjectState.EVICTION;
            return true;
        }
        return false;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: a */
    public synchronized boolean mo2095a(Deque<PooledObject<T>> deque) {
        if (this.f10807b == PooledObjectState.EVICTION) {
            this.f10807b = PooledObjectState.IDLE;
            return true;
        }
        if (this.f10807b == PooledObjectState.EVICTION_RETURN_TO_HEAD) {
            this.f10807b = PooledObjectState.IDLE;
            deque.offerFirst(this);
        }
        return false;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: g */
    public synchronized boolean mo2086g() {
        if (this.f10807b == PooledObjectState.IDLE) {
            this.f10807b = PooledObjectState.ALLOCATED;
            this.f10809d = System.currentTimeMillis();
            this.f10810e = this.f10809d;
            this.f10815j++;
            if (this.f10812g) {
                this.f10813h.mo2005a();
            }
            return true;
        } else if (this.f10807b == PooledObjectState.EVICTION) {
            this.f10807b = PooledObjectState.EVICTION_RETURN_TO_HEAD;
            return false;
        } else {
            return false;
        }
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: h */
    public synchronized boolean mo2085h() {
        if (this.f10807b == PooledObjectState.ALLOCATED || this.f10807b == PooledObjectState.RETURNING) {
            this.f10807b = PooledObjectState.IDLE;
            this.f10811f = System.currentTimeMillis();
            this.f10813h.mo2003b();
            return true;
        }
        return false;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: i */
    public synchronized void mo2084i() {
        this.f10807b = PooledObjectState.INVALID;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: a */
    public void mo2096a(PrintWriter printWriter) {
        if (this.f10813h.mo2004a(printWriter) || this.f10814i.mo2004a(printWriter)) {
            printWriter.flush();
        }
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: j */
    public synchronized PooledObjectState mo2083j() {
        return this.f10807b;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: k */
    public synchronized void mo2082k() {
        this.f10807b = PooledObjectState.ABANDONED;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: l */
    public synchronized void mo2081l() {
        this.f10807b = PooledObjectState.RETURNING;
    }

    @Override // org.apache.commons.pool2.PooledObject
    /* renamed from: a */
    public void mo2093a(boolean z) {
        this.f10812g = z;
    }

    /* renamed from: b */
    public void m2091b(boolean z) {
        this.f10813h = CallStackUtils.m2098a("'Pooled object created' yyyy-MM-dd HH:mm:ss Z 'by the following code has not been returned to the pool:'", true, z);
        this.f10814i = CallStackUtils.m2098a("The last code to use this object was:", false, z);
    }
}
