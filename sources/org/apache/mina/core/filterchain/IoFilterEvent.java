package org.apache.mina.core.filterchain;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoEvent;
import org.apache.mina.core.session.IoEventType;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.core.filterchain.g */
/* loaded from: classes2.dex */
public class IoFilterEvent extends IoEvent {

    /* renamed from: a */
    private static final InterfaceC3153b f11464a = C3154c.m262a(IoFilterEvent.class);

    /* renamed from: b */
    private static final boolean f11465b = f11464a.isDebugEnabled();

    /* renamed from: c */
    private final IoFilter.InterfaceC3073a f11466c;

    public IoFilterEvent(IoFilter.InterfaceC3073a interfaceC3073a, IoEventType ioEventType, IoSession ioSession, Object obj) {
        super(ioEventType, ioSession, obj);
        if (interfaceC3073a == null) {
            throw new IllegalArgumentException("nextFilter must not be null");
        }
        this.f11466c = interfaceC3073a;
    }

    /* renamed from: a */
    public IoFilter.InterfaceC3073a m1083a() {
        return this.f11466c;
    }

    @Override // org.apache.mina.core.session.IoEvent
    /* renamed from: b */
    public void mo1023b() {
        IoSession d = m1021d();
        IoFilter.InterfaceC3073a m1083a = m1083a();
        IoEventType c = m1022c();
        if (f11465b) {
            f11464a.debug("Firing a {} event for session {}", c, Long.valueOf(d.mo999g()));
        }
        switch (c) {
            case MESSAGE_RECEIVED:
                m1083a.mo1114a(d, m1020e());
                break;
            case MESSAGE_SENT:
                m1083a.mo1111a(d, (InterfaceC3088b) m1020e());
                break;
            case WRITE:
                m1083a.mo1109b(d, (InterfaceC3088b) m1020e());
                break;
            case CLOSE:
                m1083a.mo1106e(d);
                break;
            case EXCEPTION_CAUGHT:
                m1083a.mo1113a(d, (Throwable) m1020e());
                break;
            case SESSION_IDLE:
                m1083a.mo1112a(d, (IdleStatus) m1020e());
                break;
            case SESSION_OPENED:
                m1083a.mo1110b(d);
                break;
            case SESSION_CREATED:
                m1083a.mo1115a(d);
                break;
            case SESSION_CLOSED:
                m1083a.mo1108c(d);
                break;
            default:
                throw new IllegalArgumentException("Unknown event type: " + c);
        }
        if (f11465b) {
            f11464a.debug("Event {} has been fired for session {}", c, Long.valueOf(d.mo999g()));
        }
    }
}
