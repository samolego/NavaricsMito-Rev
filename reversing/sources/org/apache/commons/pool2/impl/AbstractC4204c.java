package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.BaseObject;

/* renamed from: org.apache.commons.pool2.impl.c */
/* loaded from: classes2.dex */
public abstract class BaseObjectPoolConfig<T> extends BaseObject implements Cloneable {

    /* renamed from: a */
    public static final String f10785a = null;

    /* renamed from: b */
    public static final String f10786b = DefaultEvictionPolicy.class.getName();

    /* renamed from: c */
    private boolean f10787c = true;

    /* renamed from: d */
    private boolean f10788d = false;

    /* renamed from: e */
    private long f10789e = -1;

    /* renamed from: f */
    private long f10790f = 1800000;

    /* renamed from: g */
    private long f10791g = 10000;

    /* renamed from: h */
    private long f10792h = -1;

    /* renamed from: i */
    private int f10793i = 3;

    /* renamed from: j */
    private EvictionPolicy<T> f10794j = null;

    /* renamed from: k */
    private String f10795k = f10786b;

    /* renamed from: l */
    private boolean f10796l = false;

    /* renamed from: m */
    private boolean f10797m = false;

    /* renamed from: n */
    private boolean f10798n = false;

    /* renamed from: o */
    private boolean f10799o = false;

    /* renamed from: p */
    private long f10800p = -1;

    /* renamed from: q */
    private boolean f10801q = true;

    /* renamed from: r */
    private boolean f10802r = true;

    /* renamed from: s */
    private String f10803s = "pool";

    /* renamed from: t */
    private String f10804t = f10785a;

    /* renamed from: a */
    public boolean m2118a() {
        return this.f10787c;
    }

    /* renamed from: b */
    public boolean m2116b() {
        return this.f10788d;
    }

    /* renamed from: c */
    public long m2115c() {
        return this.f10789e;
    }

    /* renamed from: d */
    public long m2114d() {
        return this.f10790f;
    }

    /* renamed from: e */
    public long m2113e() {
        return this.f10792h;
    }

    /* renamed from: f */
    public int m2112f() {
        return this.f10793i;
    }

    /* renamed from: g */
    public long m2111g() {
        return this.f10791g;
    }

    /* renamed from: h */
    public boolean m2110h() {
        return this.f10796l;
    }

    /* renamed from: i */
    public boolean m2109i() {
        return this.f10797m;
    }

    /* renamed from: j */
    public boolean m2108j() {
        return this.f10798n;
    }

    /* renamed from: k */
    public boolean m2107k() {
        return this.f10799o;
    }

    /* renamed from: l */
    public long m2106l() {
        return this.f10800p;
    }

    /* renamed from: m */
    public EvictionPolicy<T> m2105m() {
        return this.f10794j;
    }

    /* renamed from: n */
    public String m2104n() {
        return this.f10795k;
    }

    /* renamed from: o */
    public boolean m2103o() {
        return this.f10801q;
    }

    /* renamed from: p */
    public boolean m2102p() {
        return this.f10802r;
    }

    /* renamed from: a */
    public void m2117a(boolean z) {
        this.f10802r = z;
    }

    /* renamed from: q */
    public String m2101q() {
        return this.f10804t;
    }

    /* renamed from: r */
    public String m2100r() {
        return this.f10803s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.commons.pool2.BaseObject
    /* renamed from: a */
    public void mo2010a(StringBuilder sb) {
        sb.append("lifo=");
        sb.append(this.f10787c);
        sb.append(", fairness=");
        sb.append(this.f10788d);
        sb.append(", maxWaitMillis=");
        sb.append(this.f10789e);
        sb.append(", minEvictableIdleTimeMillis=");
        sb.append(this.f10790f);
        sb.append(", softMinEvictableIdleTimeMillis=");
        sb.append(this.f10792h);
        sb.append(", numTestsPerEvictionRun=");
        sb.append(this.f10793i);
        sb.append(", evictionPolicyClassName=");
        sb.append(this.f10795k);
        sb.append(", testOnCreate=");
        sb.append(this.f10796l);
        sb.append(", testOnBorrow=");
        sb.append(this.f10797m);
        sb.append(", testOnReturn=");
        sb.append(this.f10798n);
        sb.append(", testWhileIdle=");
        sb.append(this.f10799o);
        sb.append(", timeBetweenEvictionRunsMillis=");
        sb.append(this.f10800p);
        sb.append(", blockWhenExhausted=");
        sb.append(this.f10801q);
        sb.append(", jmxEnabled=");
        sb.append(this.f10802r);
        sb.append(", jmxNamePrefix=");
        sb.append(this.f10803s);
        sb.append(", jmxNameBase=");
        sb.append(this.f10804t);
    }
}
