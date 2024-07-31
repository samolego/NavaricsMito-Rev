package org.apache.mina.core.p133e;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: org.apache.mina.core.e.l */
/* loaded from: classes2.dex */
public class IoServiceStatistics {

    /* renamed from: a */
    private AbstractIoService f11410a;

    /* renamed from: b */
    private double f11411b;

    /* renamed from: c */
    private double f11412c;

    /* renamed from: d */
    private double f11413d;

    /* renamed from: e */
    private double f11414e;

    /* renamed from: f */
    private double f11415f;

    /* renamed from: g */
    private double f11416g;

    /* renamed from: h */
    private double f11417h;

    /* renamed from: i */
    private double f11418i;

    /* renamed from: j */
    private long f11419j;

    /* renamed from: k */
    private long f11420k;

    /* renamed from: l */
    private long f11421l;

    /* renamed from: m */
    private long f11422m;

    /* renamed from: n */
    private long f11423n;

    /* renamed from: o */
    private long f11424o;

    /* renamed from: p */
    private long f11425p;

    /* renamed from: q */
    private long f11426q;

    /* renamed from: r */
    private long f11427r;

    /* renamed from: s */
    private long f11428s;

    /* renamed from: t */
    private long f11429t;

    /* renamed from: u */
    private int f11430u;

    /* renamed from: v */
    private int f11431v;

    /* renamed from: w */
    private final AtomicInteger f11432w = new AtomicInteger(3);

    /* renamed from: x */
    private final Lock f11433x = new ReentrantLock();

    public IoServiceStatistics(AbstractIoService abstractIoService) {
        this.f11410a = abstractIoService;
    }

    /* renamed from: a */
    public final long m1176a() {
        this.f11433x.lock();
        try {
            return this.f11423n;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: b */
    public final long m1171b() {
        this.f11433x.lock();
        try {
            return this.f11424o;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: c */
    public final long m1169c() {
        return this.f11432w.get() * 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m1173a(long j) {
        this.f11433x.lock();
        try {
            this.f11423n = j;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m1170b(long j) {
        this.f11433x.lock();
        try {
            this.f11424o = j;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: c */
    public void m1168c(long j) {
        this.f11433x.lock();
        try {
            int i = (int) (j - this.f11429t);
            long m1169c = m1169c();
            if (m1169c != 0 && i >= m1169c) {
                long j2 = this.f11419j;
                long j3 = this.f11420k;
                long j4 = this.f11421l;
                long j5 = this.f11422m;
                double d = i;
                this.f11411b = ((j2 - this.f11425p) * 1000.0d) / d;
                this.f11412c = ((j3 - this.f11426q) * 1000.0d) / d;
                this.f11413d = ((j4 - this.f11427r) * 1000.0d) / d;
                this.f11414e = ((j5 - this.f11428s) * 1000.0d) / d;
                if (this.f11411b > this.f11415f) {
                    this.f11415f = this.f11411b;
                }
                if (this.f11412c > this.f11416g) {
                    this.f11416g = this.f11412c;
                }
                if (this.f11413d > this.f11417h) {
                    this.f11417h = this.f11413d;
                }
                if (this.f11414e > this.f11418i) {
                    this.f11418i = this.f11414e;
                }
                this.f11425p = j2;
                this.f11426q = j3;
                this.f11427r = j4;
                this.f11428s = j5;
                this.f11429t = j;
            }
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: a */
    public final void m1172a(long j, long j2) {
        this.f11433x.lock();
        try {
            this.f11419j += j;
            this.f11423n = j2;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: d */
    public final void m1166d(long j) {
        this.f11433x.lock();
        try {
            this.f11421l++;
            this.f11423n = j;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: a */
    public final void m1174a(int i, long j) {
        this.f11433x.lock();
        try {
            this.f11420k += i;
            this.f11424o = j;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: e */
    public final void m1164e(long j) {
        this.f11433x.lock();
        try {
            this.f11422m++;
            this.f11424o = j;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: a */
    public final void m1175a(int i) {
        this.f11433x.lock();
        try {
            this.f11430u += i;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: d */
    public final void m1167d() {
        this.f11433x.lock();
        try {
            this.f11431v++;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* renamed from: e */
    public final void m1165e() {
        this.f11433x.lock();
        try {
            this.f11431v--;
        } finally {
            this.f11433x.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: f */
    public void m1163f(long j) {
        this.f11433x.lock();
        try {
            this.f11429t = j;
        } finally {
            this.f11433x.unlock();
        }
    }
}
