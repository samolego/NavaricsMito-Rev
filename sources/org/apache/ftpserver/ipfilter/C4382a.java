package org.apache.ftpserver.ipfilter;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

/* renamed from: org.apache.ftpserver.ipfilter.a */
/* loaded from: classes2.dex */
public class MinaSessionFilter extends IoFilterAdapter {

    /* renamed from: a */
    private final SessionFilter f11139a;

    public MinaSessionFilter(SessionFilter sessionFilter) {
        this.f11139a = sessionFilter;
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public void mo818a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) {
        if (!this.f11139a.accept(ioSession)) {
            ioSession.mo1011a(true);
        } else {
            interfaceC3073a.mo1115a(ioSession);
        }
    }
}
