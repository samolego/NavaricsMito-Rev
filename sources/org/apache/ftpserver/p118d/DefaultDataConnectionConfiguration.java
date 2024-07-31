package org.apache.ftpserver.p118d;

import org.apache.ftpserver.DataConnectionConfiguration;
import org.apache.ftpserver.ssl.SslConfiguration;

/* renamed from: org.apache.ftpserver.d.b */
/* loaded from: classes2.dex */
public class DefaultDataConnectionConfiguration implements DataConnectionConfiguration {

    /* renamed from: a */
    private final int f10970a;

    /* renamed from: b */
    private final SslConfiguration f10971b;

    /* renamed from: c */
    private final boolean f10972c;

    /* renamed from: d */
    private final String f10973d;

    /* renamed from: e */
    private final int f10974e;

    /* renamed from: f */
    private final boolean f10975f;

    /* renamed from: g */
    private final String f10976g;

    /* renamed from: h */
    private final String f10977h;

    /* renamed from: i */
    private final PassivePorts f10978i;

    /* renamed from: j */
    private final boolean f10979j;

    /* renamed from: k */
    private final boolean f10980k;

    public DefaultDataConnectionConfiguration(int i, SslConfiguration sslConfiguration, boolean z, boolean z2, String str, int i2, String str2, PassivePorts passivePorts, String str3, boolean z3, boolean z4) {
        this.f10970a = i;
        this.f10971b = sslConfiguration;
        this.f10972c = z;
        this.f10975f = z2;
        this.f10973d = str;
        this.f10974e = i2;
        this.f10976g = str2;
        this.f10978i = passivePorts;
        this.f10977h = str3;
        this.f10979j = z3;
        this.f10980k = z4;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: a */
    public int mo1948a() {
        return this.f10970a;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: b */
    public boolean mo1946b() {
        return this.f10972c;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: c */
    public boolean mo1945c() {
        return this.f10975f;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: d */
    public String mo1944d() {
        return this.f10973d;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: e */
    public int mo1943e() {
        return this.f10974e;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: f */
    public String mo1942f() {
        return this.f10976g;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: g */
    public String mo1941g() {
        return this.f10977h;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: h */
    public boolean mo1940h() {
        return this.f10979j;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: i */
    public synchronized int mo1939i() {
        return this.f10978i.m1837a();
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: a */
    public synchronized void mo1947a(int i) {
        this.f10978i.m1836a(i);
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: j */
    public SslConfiguration mo1938j() {
        return this.f10971b;
    }

    @Override // org.apache.ftpserver.DataConnectionConfiguration
    /* renamed from: k */
    public boolean mo1937k() {
        return this.f10980k;
    }
}
