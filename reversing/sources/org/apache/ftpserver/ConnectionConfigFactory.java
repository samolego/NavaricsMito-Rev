package org.apache.ftpserver;

import org.apache.ftpserver.p118d.DefaultConnectionConfig;

/* renamed from: org.apache.ftpserver.b */
/* loaded from: classes2.dex */
public class ConnectionConfigFactory {

    /* renamed from: a */
    private int f10925a = 10;

    /* renamed from: b */
    private boolean f10926b = true;

    /* renamed from: c */
    private int f10927c = 10;

    /* renamed from: d */
    private int f10928d = 3;

    /* renamed from: e */
    private int f10929e = 500;

    /* renamed from: f */
    private int f10930f = 0;

    /* renamed from: a */
    public ConnectionConfig m1968a() {
        return new DefaultConnectionConfig(this.f10926b, this.f10929e, this.f10925a, this.f10927c, this.f10928d, this.f10930f);
    }

    /* renamed from: a */
    public void m1966a(boolean z) {
        this.f10926b = z;
    }

    /* renamed from: a */
    public void m1967a(int i) {
        this.f10928d = i;
    }

    /* renamed from: b */
    public void m1965b(int i) {
        this.f10929e = i;
    }
}
