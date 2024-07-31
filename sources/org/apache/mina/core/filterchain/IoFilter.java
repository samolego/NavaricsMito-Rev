package org.apache.mina.core.filterchain;

import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;

/* renamed from: org.apache.mina.core.filterchain.c */
/* loaded from: classes2.dex */
public interface IoFilter {

    /* compiled from: IoFilter.java */
    /* renamed from: org.apache.mina.core.filterchain.c$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC3073a {
        /* renamed from: a */
        void mo1115a(IoSession ioSession);

        /* renamed from: a */
        void mo1114a(IoSession ioSession, Object obj);

        /* renamed from: a */
        void mo1113a(IoSession ioSession, Throwable th);

        /* renamed from: a */
        void mo1112a(IoSession ioSession, IdleStatus idleStatus);

        /* renamed from: a */
        void mo1111a(IoSession ioSession, InterfaceC3088b interfaceC3088b);

        /* renamed from: b */
        void mo1110b(IoSession ioSession);

        /* renamed from: b */
        void mo1109b(IoSession ioSession, InterfaceC3088b interfaceC3088b);

        /* renamed from: c */
        void mo1108c(IoSession ioSession);

        /* renamed from: d */
        void mo1107d(IoSession ioSession);

        /* renamed from: e */
        void mo1106e(IoSession ioSession);
    }

    /* renamed from: a */
    void mo818a(InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception;

    /* renamed from: a */
    void mo817a(InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws Exception;

    /* renamed from: a */
    void mo816a(InterfaceC3073a interfaceC3073a, IoSession ioSession, Throwable th) throws Exception;

    /* renamed from: a */
    void mo815a(InterfaceC3073a interfaceC3073a, IoSession ioSession, IdleStatus idleStatus) throws Exception;

    /* renamed from: a */
    void mo827a(InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception;

    /* renamed from: a */
    void mo845a(IoFilterChain ioFilterChain, String str, InterfaceC3073a interfaceC3073a) throws Exception;

    /* renamed from: b */
    void mo826b(InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception;

    /* renamed from: b */
    void mo811b(InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception;

    /* renamed from: b */
    void mo906b(IoFilterChain ioFilterChain, String str, InterfaceC3073a interfaceC3073a) throws Exception;

    /* renamed from: c */
    void mo810c(InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception;

    /* renamed from: c */
    void mo902c(IoFilterChain ioFilterChain, String str, InterfaceC3073a interfaceC3073a) throws Exception;

    /* renamed from: d */
    void mo809d(InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception;

    /* renamed from: d */
    void mo839d(IoFilterChain ioFilterChain, String str, InterfaceC3073a interfaceC3073a) throws Exception;

    /* renamed from: e */
    void mo1105e(InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception;
}
