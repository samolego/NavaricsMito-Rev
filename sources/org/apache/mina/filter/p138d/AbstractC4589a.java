package org.apache.mina.filter.p138d;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.filterchain.IoFilterEvent;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoEventType;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;

/* renamed from: org.apache.mina.filter.d.a */
/* loaded from: classes2.dex */
public abstract class CommonEventFilter extends IoFilterAdapter {
    /* renamed from: a */
    protected abstract void mo825a(IoFilterEvent ioFilterEvent) throws Exception;

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo818a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.SESSION_CREATED, ioSession, null));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: c */
    public final void mo810c(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.SESSION_OPENED, ioSession, null));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: d */
    public final void mo809d(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.SESSION_CLOSED, ioSession, null));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo815a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, IdleStatus idleStatus) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.SESSION_IDLE, ioSession, idleStatus));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo816a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Throwable th) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.EXCEPTION_CAUGHT, ioSession, th));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.MESSAGE_RECEIVED, ioSession, obj));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public final void mo811b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.MESSAGE_SENT, ioSession, interfaceC3088b));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: a */
    public final void mo827a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.WRITE, ioSession, interfaceC3088b));
    }

    @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
    /* renamed from: b */
    public final void mo826b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
        mo825a(new IoFilterEvent(interfaceC3073a, IoEventType.CLOSE, ioSession, null));
    }
}
