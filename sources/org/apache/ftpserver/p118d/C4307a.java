package org.apache.ftpserver.p118d;

import org.apache.ftpserver.ConnectionConfig;

/* renamed from: org.apache.ftpserver.d.a */
/* loaded from: classes2.dex */
public class DefaultConnectionConfig implements ConnectionConfig {

    /* renamed from: a */
    private final int f10964a;

    /* renamed from: b */
    private final boolean f10965b;

    /* renamed from: c */
    private final int f10966c;

    /* renamed from: d */
    private final int f10967d;

    /* renamed from: e */
    private final int f10968e;

    /* renamed from: f */
    private final int f10969f;

    public DefaultConnectionConfig() {
        this(true, 500, 10, 10, 3, 0);
    }

    public DefaultConnectionConfig(boolean z, int i, int i2, int i3, int i4, int i5) {
        this.f10965b = z;
        this.f10968e = i;
        this.f10964a = i2;
        this.f10966c = i3;
        this.f10967d = i4;
        this.f10969f = i5;
    }

    @Override // org.apache.ftpserver.ConnectionConfig
    /* renamed from: b */
    public int mo1953b() {
        return this.f10968e;
    }

    @Override // org.apache.ftpserver.ConnectionConfig
    /* renamed from: c */
    public int mo1952c() {
        return this.f10966c;
    }

    @Override // org.apache.ftpserver.ConnectionConfig
    /* renamed from: a */
    public int mo1954a() {
        return this.f10967d;
    }

    @Override // org.apache.ftpserver.ConnectionConfig
    /* renamed from: d */
    public int mo1951d() {
        return this.f10964a;
    }

    @Override // org.apache.ftpserver.ConnectionConfig
    /* renamed from: e */
    public boolean mo1950e() {
        return this.f10965b;
    }

    @Override // org.apache.ftpserver.ConnectionConfig
    /* renamed from: f */
    public int mo1949f() {
        return this.f10969f;
    }
}
