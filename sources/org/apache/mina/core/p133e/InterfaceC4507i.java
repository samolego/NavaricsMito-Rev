package org.apache.mina.core.p133e;

import java.util.Map;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.filterchain.IoFilterChainBuilder;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.session.IoSessionConfig;
import org.apache.mina.core.session.IoSessionDataStructureFactory;

/* renamed from: org.apache.mina.core.e.i */
/* loaded from: classes2.dex */
public interface IoService {
    /* renamed from: a */
    void mo1197a(InterfaceC3064f interfaceC3064f);

    /* renamed from: i */
    IoSessionConfig mo1031i();

    /* renamed from: n */
    IoFilterChainBuilder mo1196n();

    /* renamed from: o */
    DefaultIoFilterChainBuilder mo1195o();

    /* renamed from: r */
    void mo1194r();

    /* renamed from: s */
    Map<Long, IoSession> mo1193s();

    /* renamed from: u */
    InterfaceC3064f mo1192u();

    /* renamed from: v */
    IoSessionDataStructureFactory mo1191v();

    /* renamed from: z */
    TransportMetadata mo1030z();
}
