package org.apache.commons.pool2.impl;

import java.io.PrintWriter;

/* renamed from: org.apache.commons.pool2.impl.a */
/* loaded from: classes2.dex */
public class AbandonedConfig {

    /* renamed from: a */
    private boolean f10733a;

    /* renamed from: b */
    private boolean f10734b;

    /* renamed from: c */
    private int f10735c;

    /* renamed from: d */
    private boolean f10736d;

    /* renamed from: e */
    private boolean f10737e;

    /* renamed from: f */
    private PrintWriter f10738f;

    /* renamed from: g */
    private boolean f10739g;

    /* renamed from: a */
    public boolean m2170a() {
        return this.f10733a;
    }

    /* renamed from: b */
    public boolean m2169b() {
        return this.f10734b;
    }

    /* renamed from: c */
    public int m2168c() {
        return this.f10735c;
    }

    /* renamed from: d */
    public boolean m2167d() {
        return this.f10736d;
    }

    /* renamed from: e */
    public boolean m2166e() {
        return this.f10737e;
    }

    /* renamed from: f */
    public PrintWriter m2165f() {
        return this.f10738f;
    }

    public String toString() {
        return "AbandonedConfig [removeAbandonedOnBorrow=" + this.f10733a + ", removeAbandonedOnMaintenance=" + this.f10734b + ", removeAbandonedTimeout=" + this.f10735c + ", logAbandoned=" + this.f10736d + ", logWriter=" + this.f10738f + ", useUsageTracking=" + this.f10739g + "]";
    }
}
