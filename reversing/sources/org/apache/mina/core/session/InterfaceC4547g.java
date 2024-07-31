package org.apache.mina.core.session;

import java.net.SocketAddress;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p131c.CloseFuture;
import org.apache.mina.core.p131c.WriteFuture;
import org.apache.mina.core.p133e.InterfaceC3064f;
import org.apache.mina.core.p133e.IoService;
import org.apache.mina.core.p133e.TransportMetadata;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestQueue;

/* renamed from: org.apache.mina.core.session.g */
/* loaded from: classes2.dex */
public interface IoSession {
    /* renamed from: N */
    InterfaceC3088b mo1019N();

    /* renamed from: P */
    WriteRequestQueue mo1018P();

    /* renamed from: Q */
    boolean mo1017Q();

    /* renamed from: a */
    long mo1013a(IdleStatus idleStatus);

    /* renamed from: a */
    Object mo1014a(Object obj, Object obj2);

    /* renamed from: a */
    CloseFuture mo1016a();

    /* renamed from: a */
    CloseFuture mo1011a(boolean z);

    /* renamed from: a */
    void mo1012a(InterfaceC3088b interfaceC3088b);

    /* renamed from: a */
    boolean mo1015a(Object obj);

    /* renamed from: b */
    Object mo1009b(Object obj);

    /* renamed from: b */
    Object mo1008b(Object obj, Object obj2);

    /* renamed from: b */
    CloseFuture mo1010b();

    /* renamed from: c */
    Object mo1006c(Object obj);

    /* renamed from: c */
    Object mo1005c(Object obj, Object obj2);

    /* renamed from: c */
    IoSessionConfig mo1007c();

    /* renamed from: d */
    long mo1004d();

    /* renamed from: d */
    Object mo1003d(Object obj);

    /* renamed from: e */
    WriteFuture mo1001e(Object obj);

    /* renamed from: e */
    IoFilterChain mo1002e();

    /* renamed from: f */
    InterfaceC3064f mo1000f();

    /* renamed from: g */
    long mo999g();

    /* renamed from: h */
    long mo998h();

    /* renamed from: i */
    long mo997i();

    /* renamed from: j */
    long mo996j();

    /* renamed from: k */
    SocketAddress mo995k();

    /* renamed from: l */
    SocketAddress mo994l();

    /* renamed from: m */
    IoService mo993m();

    /* renamed from: n */
    TransportMetadata mo992n();

    /* renamed from: o */
    boolean mo991o();

    /* renamed from: p */
    boolean mo990p();

    /* renamed from: q */
    boolean mo989q();
}
