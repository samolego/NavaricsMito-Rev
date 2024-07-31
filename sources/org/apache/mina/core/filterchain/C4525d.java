package org.apache.mina.core.filterchain;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;

/* renamed from: org.apache.mina.core.filterchain.d */
/* loaded from: classes2.dex */
public class IoFilterAdapter implements IoFilter {
    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo845a(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws Exception {
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo906b(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws Exception {
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: c */
    public void mo902c(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws Exception {
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public void mo839d(IoFilterChain ioFilterChain, String str, IoFilter.InterfaceC3073a interfaceC3073a) throws Exception {
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo818a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        interfaceC3073a.mo1115a(ioSession);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: c */
    public void mo810c(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        interfaceC3073a.mo1110b(ioSession);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public void mo809d(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        interfaceC3073a.mo1108c(ioSession);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo815a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, IdleStatus idleStatus) throws Exception {
        interfaceC3073a.mo1112a(ioSession, idleStatus);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo816a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Throwable th) throws Exception {
        interfaceC3073a.mo1113a(ioSession, th);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws Exception {
        interfaceC3073a.mo1114a(ioSession, obj);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo811b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
        interfaceC3073a.mo1111a(ioSession, interfaceC3088b);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo827a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
        interfaceC3073a.mo1109b(ioSession, interfaceC3088b);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public void mo826b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        interfaceC3073a.mo1106e(ioSession);
    }

    @Override // org.apache.mina.core.filterchain.IoFilter
    /* renamed from: e */
    public void mo1105e(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        interfaceC3073a.mo1107d(ioSession);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
