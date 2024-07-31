package org.apache.ftpserver.p107d;

import org.apache.ftpserver.InterfaceC3042a;

/* compiled from: DefaultConnectionConfig.java */
/* renamed from: org.apache.ftpserver.d.a, reason: use source file name */
/* loaded from: classes2.dex */
public class DefaultConnectionConfig implements InterfaceC3042a {

    /* renamed from: a */
    private final int f11005a;

    /* renamed from: b */
    private final boolean f11006b;

    /* renamed from: c */
    private final int f11007c;

    /* renamed from: d */
    private final int f11008d;

    /* renamed from: e */
    private final int f11009e;

    /* renamed from: f */
    private final int f11010f;

    public DefaultConnectionConfig() {
        this(true, 500, 10, 10, 3, 0);
    }

    public DefaultConnectionConfig(boolean z, int i, int i2, int i3, int i4, int i5) {
        this.f11006b = z;
        this.f11009e = i;
        this.f11005a = i2;
        this.f11007c = i3;
        this.f11008d = i4;
        this.f11010f = i5;
    }

    @Override // org.apache.ftpserver.InterfaceC3042a
    /* renamed from: b */
    public int mo10835b() {
        return this.f11009e;
    }

    @Override // org.apache.ftpserver.InterfaceC3042a
    /* renamed from: c */
    public int mo10836c() {
        return this.f11007c;
    }

    @Override // org.apache.ftpserver.InterfaceC3042a
    /* renamed from: a */
    public int mo10834a() {
        return this.f11008d;
    }

    @Override // org.apache.ftpserver.InterfaceC3042a
    /* renamed from: d */
    public int mo10837d() {
        return this.f11005a;
    }

    @Override // org.apache.ftpserver.InterfaceC3042a
    /* renamed from: e */
    public boolean mo10838e() {
        return this.f11006b;
    }

    @Override // org.apache.ftpserver.InterfaceC3042a
    /* renamed from: f */
    public int mo10839f() {
        return this.f11010f;
    }
}