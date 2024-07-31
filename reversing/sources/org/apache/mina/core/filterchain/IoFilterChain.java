package org.apache.mina.core.filterchain;

import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;

/* renamed from: org.apache.mina.core.filterchain.e */
/* loaded from: classes2.dex */
public interface IoFilterChain {

    /* compiled from: IoFilterChain.java */
    /* renamed from: org.apache.mina.core.filterchain.e$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC3074a {
        /* renamed from: a */
        String mo1087a();

        /* renamed from: b */
        IoFilter mo1086b();

        /* renamed from: c */
        IoFilter.InterfaceC3073a mo1085c();
    }

    /* renamed from: a */
    IoSession mo1104a();

    /* renamed from: a */
    void mo1103a(Object obj);

    /* renamed from: a */
    void mo1102a(String str, IoFilter ioFilter);

    /* renamed from: a */
    void mo1101a(Throwable th);

    /* renamed from: a */
    void mo1100a(IdleStatus idleStatus);

    /* renamed from: a */
    void mo1099a(InterfaceC3088b interfaceC3088b);

    /* renamed from: b */
    IoFilter mo1097b(Class<? extends IoFilter> cls);

    /* renamed from: b */
    void mo1098b() throws Exception;

    /* renamed from: b */
    void mo1096b(String str, IoFilter ioFilter);

    /* renamed from: b */
    void mo1094b(InterfaceC3088b interfaceC3088b);

    /* renamed from: b */
    boolean mo1095b(IoFilter ioFilter);

    /* renamed from: c */
    void mo1093c();

    /* renamed from: c */
    boolean mo1092c(Class<? extends IoFilter> cls);

    /* renamed from: d */
    void mo1091d();

    /* renamed from: e */
    void mo1090e();

    /* renamed from: f */
    void mo1089f();

    /* renamed from: g */
    void mo1088g();
}
