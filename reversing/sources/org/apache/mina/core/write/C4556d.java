package org.apache.mina.core.write;

import java.net.SocketAddress;
import org.apache.mina.core.p131c.WriteFuture;

/* renamed from: org.apache.mina.core.write.d */
/* loaded from: classes2.dex */
public class WriteRequestWrapper implements InterfaceC3088b {

    /* renamed from: a */
    private final InterfaceC3088b f11548a;

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: e */
    public boolean mo837e() {
        return false;
    }

    public WriteRequestWrapper(InterfaceC3088b interfaceC3088b) {
        if (interfaceC3088b == null) {
            throw new IllegalArgumentException("parentRequest");
        }
        this.f11548a = interfaceC3088b;
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: d */
    public SocketAddress mo953d() {
        return this.f11548a.mo953d();
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: a */
    public WriteFuture mo955a() {
        return this.f11548a.mo955a();
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: b */
    public Object mo836b() {
        return this.f11548a.mo836b();
    }

    @Override // org.apache.mina.core.write.InterfaceC3088b
    /* renamed from: c */
    public InterfaceC3088b mo954c() {
        return this.f11548a.mo954c();
    }

    /* renamed from: f */
    public InterfaceC3088b m952f() {
        return this.f11548a;
    }

    public String toString() {
        return "WR Wrapper" + this.f11548a.toString();
    }
}
