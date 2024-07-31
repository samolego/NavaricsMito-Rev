package org.apache.commons.pool2.impl;

import java.io.PrintWriter;

/* compiled from: AbandonedConfig.java */
/* renamed from: org.apache.commons.pool2.impl.a, reason: use source file name */
/* loaded from: classes2.dex */
public class AbandonedConfig {

    /* renamed from: a */
    private boolean f10774a;

    /* renamed from: b */
    private boolean f10775b;

    /* renamed from: c */
    private int f10776c;

    /* renamed from: d */
    private boolean f10777d;

    /* renamed from: e */
    private boolean f10778e;

    /* renamed from: f */
    private PrintWriter f10779f;

    /* renamed from: g */
    private boolean f10780g;

    /* renamed from: a */
    public boolean m10682a() {
        return this.f10774a;
    }

    /* renamed from: b */
    public boolean m10683b() {
        return this.f10775b;
    }

    /* renamed from: c */
    public int m10684c() {
        return this.f10776c;
    }

    /* renamed from: d */
    public boolean m10685d() {
        return this.f10777d;
    }

    /* renamed from: e */
    public boolean m10686e() {
        return this.f10778e;
    }

    /* renamed from: f */
    public PrintWriter m10687f() {
        return this.f10779f;
    }

    public String toString() {
        return "AbandonedConfig [removeAbandonedOnBorrow=" + this.f10774a + ", removeAbandonedOnMaintenance=" + this.f10775b + ", removeAbandonedTimeout=" + this.f10776c + ", logAbandoned=" + this.f10777d + ", logWriter=" + this.f10779f + ", useUsageTracking=" + this.f10780g + "]";
    }
}