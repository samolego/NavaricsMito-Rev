package org.apache.mina.core.filterchain;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterChain;
import org.apache.mina.core.p129a.AbstractC3054b;
import org.apache.mina.core.p131c.ConnectFuture;
import org.apache.mina.core.p133e.AbstractIoService;
import org.apache.mina.core.session.AbstractIoSession;
import org.apache.mina.core.session.AttributeKey;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.InterfaceC3088b;
import org.apache.mina.core.write.WriteRequestQueue;
import org.slf4j.C3154c;
import org.slf4j.InterfaceC3153b;

/* renamed from: org.apache.mina.core.filterchain.a */
/* loaded from: classes2.dex */
public class DefaultIoFilterChain implements IoFilterChain {

    /* renamed from: a */
    public static final AttributeKey f11443a = new AttributeKey(DefaultIoFilterChain.class, "connectFuture");

    /* renamed from: f */
    private static final InterfaceC3153b f11444f = C3154c.m262a(DefaultIoFilterChain.class);

    /* renamed from: b */
    private final AbstractIoSession f11445b;

    /* renamed from: c */
    private final Map<String, IoFilterChain.InterfaceC3074a> f11446c = new ConcurrentHashMap();

    /* renamed from: d */
    private final C3067a f11447d;

    /* renamed from: e */
    private final C3067a f11448e;

    public DefaultIoFilterChain(AbstractIoSession abstractIoSession) {
        if (abstractIoSession == null) {
            throw new IllegalArgumentException("session");
        }
        this.f11445b = abstractIoSession;
        this.f11447d = new C3067a(null, null, "head", new C3069b());
        this.f11448e = new C3067a(this.f11447d, null, "tail", new C3070c());
        this.f11447d.f11451c = this.f11448e;
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: a */
    public IoSession mo1104a() {
        return this.f11445b;
    }

    /* renamed from: a */
    public IoFilterChain.InterfaceC3074a m1142a(IoFilter ioFilter) {
        for (C3067a c3067a = this.f11447d.f11451c; c3067a != this.f11448e; c3067a = c3067a.f11451c) {
            if (c3067a.mo1086b() == ioFilter) {
                return c3067a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public IoFilterChain.InterfaceC3074a m1151a(Class<? extends IoFilter> cls) {
        for (C3067a c3067a = this.f11447d.f11451c; c3067a != this.f11448e; c3067a = c3067a.f11451c) {
            if (cls.isAssignableFrom(c3067a.mo1086b().getClass())) {
                return c3067a;
            }
        }
        return null;
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: b */
    public IoFilter mo1097b(Class<? extends IoFilter> cls) {
        IoFilterChain.InterfaceC3074a m1151a = m1151a(cls);
        if (m1151a == null) {
            return null;
        }
        return m1151a.mo1086b();
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: a */
    public synchronized void mo1102a(String str, IoFilter ioFilter) {
        m1150a(str);
        m1148a(this.f11447d, str, ioFilter);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: b */
    public synchronized void mo1096b(String str, IoFilter ioFilter) {
        m1150a(str);
        m1148a(this.f11448e.f11450b, str, ioFilter);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: b */
    public synchronized void mo1098b() throws Exception {
        for (IoFilterChain.InterfaceC3074a interfaceC3074a : new ArrayList(this.f11446c.values())) {
            try {
                m1149a((C3067a) interfaceC3074a);
            } catch (Exception e) {
                throw new IoFilterLifeCycleException("clear(): " + interfaceC3074a.mo1087a() + " in " + mo1104a(), e);
            }
        }
    }

    /* renamed from: a */
    private void m1148a(C3067a c3067a, String str, IoFilter ioFilter) {
        C3067a c3067a2 = new C3067a(c3067a, c3067a.f11451c, str, ioFilter);
        try {
            ioFilter.mo845a(this, str, c3067a2.mo1085c());
            c3067a.f11451c.f11450b = c3067a2;
            c3067a.f11451c = c3067a2;
            this.f11446c.put(str, c3067a2);
            try {
                ioFilter.mo906b(this, str, c3067a2.mo1085c());
            } catch (Exception e) {
                m1136b(c3067a2);
                throw new IoFilterLifeCycleException("onPostAdd(): " + str + ':' + ioFilter + " in " + mo1104a(), e);
            }
        } catch (Exception e2) {
            throw new IoFilterLifeCycleException("onPreAdd(): " + str + ':' + ioFilter + " in " + mo1104a(), e2);
        }
    }

    /* renamed from: a */
    private void m1149a(C3067a c3067a) {
        IoFilter mo1086b = c3067a.mo1086b();
        try {
            mo1086b.mo902c(this, c3067a.mo1087a(), c3067a.mo1085c());
            m1136b(c3067a);
            try {
                mo1086b.mo839d(this, c3067a.mo1087a(), c3067a.mo1085c());
            } catch (Exception e) {
                throw new IoFilterLifeCycleException("onPostRemove(): " + c3067a.mo1087a() + ':' + mo1086b + " in " + mo1104a(), e);
            }
        } catch (Exception e2) {
            throw new IoFilterLifeCycleException("onPreRemove(): " + c3067a.mo1087a() + ':' + mo1086b + " in " + mo1104a(), e2);
        }
    }

    /* renamed from: b */
    private void m1136b(C3067a c3067a) {
        C3067a c3067a2 = c3067a.f11450b;
        C3067a c3067a3 = c3067a.f11451c;
        c3067a2.f11451c = c3067a3;
        c3067a3.f11450b = c3067a2;
        this.f11446c.remove(c3067a.f11452d);
    }

    /* renamed from: a */
    private void m1150a(String str) {
        if (this.f11446c.containsKey(str)) {
            throw new IllegalArgumentException("Other filter is using the same name '" + str + "'");
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: c */
    public void mo1093c() {
        m1141a(this.f11447d, this.f11445b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1141a(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession) {
        try {
            interfaceC3074a.mo1086b().mo818a(interfaceC3074a.mo1085c(), ioSession);
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: d */
    public void mo1091d() {
        m1133b(this.f11447d, this.f11445b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1133b(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession) {
        try {
            interfaceC3074a.mo1086b().mo810c(interfaceC3074a.mo1085c(), ioSession);
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: e */
    public void mo1090e() {
        try {
            this.f11445b.mo1010b().mo1332b();
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
        m1130c(this.f11447d, this.f11445b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1130c(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession) {
        try {
            interfaceC3074a.mo1086b().mo809d(interfaceC3074a.mo1085c(), ioSession);
        } catch (Error e) {
            mo1101a((Throwable) e);
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: a */
    public void mo1100a(IdleStatus idleStatus) {
        this.f11445b.m1065a(idleStatus, System.currentTimeMillis());
        m1138a((IoFilterChain.InterfaceC3074a) this.f11447d, (IoSession) this.f11445b, idleStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1138a(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession, IdleStatus idleStatus) {
        try {
            interfaceC3074a.mo1086b().mo815a(interfaceC3074a.mo1085c(), ioSession, idleStatus);
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: a */
    public void mo1103a(Object obj) {
        if (obj instanceof AbstractC3054b) {
            this.f11445b.m1071a(((AbstractC3054b) obj).mo1357l(), System.currentTimeMillis());
        }
        m1140a(this.f11447d, this.f11445b, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1140a(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession, Object obj) {
        try {
            interfaceC3074a.mo1086b().mo817a(interfaceC3074a.mo1085c(), ioSession, obj);
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: a */
    public void mo1099a(InterfaceC3088b interfaceC3088b) {
        try {
            interfaceC3088b.mo955a().mo964a();
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
        if (interfaceC3088b.mo837e()) {
            return;
        }
        m1137a((IoFilterChain.InterfaceC3074a) this.f11447d, (IoSession) this.f11445b, interfaceC3088b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1137a(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession, InterfaceC3088b interfaceC3088b) {
        try {
            interfaceC3074a.mo1086b().mo811b(interfaceC3074a.mo1085c(), ioSession, interfaceC3088b);
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: a */
    public void mo1101a(Throwable th) {
        m1139a((IoFilterChain.InterfaceC3074a) this.f11447d, (IoSession) this.f11445b, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1139a(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession, Throwable th) {
        ConnectFuture connectFuture = (ConnectFuture) ioSession.mo1006c(f11443a);
        if (connectFuture == null) {
            try {
                interfaceC3074a.mo1086b().mo816a(interfaceC3074a.mo1085c(), ioSession, th);
                return;
            } catch (Throwable th2) {
                f11444f.warn("Unexpected exception from exceptionCaught handler.", th2);
                return;
            }
        }
        if (!ioSession.mo991o()) {
            ioSession.mo1016a();
        }
        connectFuture.m1336a(th);
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: f */
    public void mo1089f() {
        m1128d(this.f11447d, this.f11445b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m1128d(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession) {
        try {
            interfaceC3074a.mo1086b().mo1105e(interfaceC3074a.mo1085c(), ioSession);
        } catch (Throwable th) {
            mo1101a(th);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: b */
    public void mo1094b(InterfaceC3088b interfaceC3088b) {
        m1132b(this.f11448e, this.f11445b, interfaceC3088b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1132b(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession, InterfaceC3088b interfaceC3088b) {
        try {
            interfaceC3074a.mo1086b().mo827a(interfaceC3074a.mo1085c(), ioSession, interfaceC3088b);
        } catch (Error e) {
            interfaceC3088b.mo955a().mo962a(e);
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            interfaceC3088b.mo955a().mo962a(e2);
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: g */
    public void mo1088g() {
        m1126e(this.f11448e, this.f11445b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1126e(IoFilterChain.InterfaceC3074a interfaceC3074a, IoSession ioSession) {
        try {
            interfaceC3074a.mo1086b().mo826b(interfaceC3074a.mo1085c(), ioSession);
        } catch (Error e) {
            mo1101a((Throwable) e);
            throw e;
        } catch (Exception e2) {
            mo1101a((Throwable) e2);
        }
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: b */
    public boolean mo1095b(IoFilter ioFilter) {
        return m1142a(ioFilter) != null;
    }

    @Override // org.apache.mina.core.filterchain.IoFilterChain
    /* renamed from: c */
    public boolean mo1092c(Class<? extends IoFilter> cls) {
        return m1151a(cls) != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");
        boolean z = true;
        for (C3067a c3067a = this.f11447d.f11451c; c3067a != this.f11448e; c3067a = c3067a.f11451c) {
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append('(');
            sb.append(c3067a.mo1087a());
            sb.append(':');
            sb.append(c3067a.mo1086b());
            sb.append(')');
        }
        if (z) {
            sb.append("empty");
        }
        sb.append(" }");
        return sb.toString();
    }

    /* compiled from: DefaultIoFilterChain.java */
    /* renamed from: org.apache.mina.core.filterchain.a$b */
    /* loaded from: classes2.dex */
    private class C3069b extends IoFilterAdapter {
        private C3069b() {
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: a */
        public void mo827a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
            AbstractIoSession abstractIoSession = (AbstractIoSession) ioSession;
            if (interfaceC3088b.mo836b() instanceof AbstractC3054b) {
                AbstractC3054b abstractC3054b = (AbstractC3054b) interfaceC3088b.mo836b();
                abstractC3054b.mo1363h();
                int mo1357l = abstractC3054b.mo1357l();
                if (mo1357l > 0) {
                    abstractIoSession.m1074a(mo1357l);
                }
            } else {
                abstractIoSession.m1044z();
            }
            WriteRequestQueue mo1018P = abstractIoSession.mo1018P();
            if (!abstractIoSession.mo1017Q()) {
                if (mo1018P.mo957b(ioSession)) {
                    abstractIoSession.mo1035r().mo1027a(abstractIoSession, interfaceC3088b);
                    return;
                }
                abstractIoSession.mo1018P().mo958a(abstractIoSession, interfaceC3088b);
                abstractIoSession.mo1035r().mo1025b(abstractIoSession);
                return;
            }
            abstractIoSession.mo1018P().mo958a(abstractIoSession, interfaceC3088b);
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: b */
        public void mo826b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
            ((AbstractIoSession) ioSession).mo1035r().mo1028a(ioSession);
        }
    }

    /* compiled from: DefaultIoFilterChain.java */
    /* renamed from: org.apache.mina.core.filterchain.a$c */
    /* loaded from: classes2.dex */
    private static class C3070c extends IoFilterAdapter {
        private C3070c() {
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: a */
        public void mo818a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
            try {
                ioSession.mo1000f().mo1201b(ioSession);
            } finally {
                ConnectFuture connectFuture = (ConnectFuture) ioSession.mo1006c(DefaultIoFilterChain.f11443a);
                if (connectFuture != null) {
                    connectFuture.m1335a(ioSession);
                }
            }
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: c */
        public void mo810c(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
            ioSession.mo1000f().mo1199c(ioSession);
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: d */
        public void mo809d(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
            AbstractIoSession abstractIoSession = (AbstractIoSession) ioSession;
            try {
                abstractIoSession.mo1000f().mo1205a(ioSession);
                try {
                    abstractIoSession.mo1018P().mo959a(ioSession);
                    try {
                        abstractIoSession.m1046x().mo988a(ioSession);
                        try {
                            ioSession.mo1002e().mo1098b();
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    } catch (Throwable th) {
                        try {
                            ioSession.mo1002e().mo1098b();
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                            throw th;
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    }
                } catch (Throwable th2) {
                    try {
                        abstractIoSession.m1046x().mo988a(ioSession);
                        try {
                            ioSession.mo1002e().mo1098b();
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                            throw th2;
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    } catch (Throwable th3) {
                        try {
                            ioSession.mo1002e().mo1098b();
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                            throw th3;
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    }
                }
            } catch (Throwable th4) {
                try {
                    abstractIoSession.mo1018P().mo959a(ioSession);
                    try {
                        abstractIoSession.m1046x().mo988a(ioSession);
                        try {
                            ioSession.mo1002e().mo1098b();
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                            throw th4;
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    } catch (Throwable th5) {
                        try {
                            ioSession.mo1002e().mo1098b();
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                            throw th5;
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    }
                } catch (Throwable th6) {
                    try {
                        abstractIoSession.m1046x().mo988a(ioSession);
                        try {
                            ioSession.mo1002e().mo1098b();
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                            throw th6;
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    } catch (Throwable th7) {
                        try {
                            ioSession.mo1002e().mo1098b();
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                            throw th7;
                        } finally {
                            if (abstractIoSession.mo1007c().mo971f()) {
                                abstractIoSession.m1047w();
                            }
                        }
                    }
                }
            }
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: a */
        public void mo815a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, IdleStatus idleStatus) throws Exception {
            ioSession.mo1000f().mo1202a(ioSession, idleStatus);
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: a */
        public void mo816a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Throwable th) throws Exception {
            AbstractIoSession abstractIoSession = (AbstractIoSession) ioSession;
            try {
                abstractIoSession.mo1000f().mo1203a((IoSession) abstractIoSession, th);
            } finally {
                if (abstractIoSession.mo1007c().mo971f()) {
                    abstractIoSession.m1069a(th);
                }
            }
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: e */
        public void mo1105e(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
            ioSession.mo1000f().mo1198d(ioSession);
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: a */
        public void mo817a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, Object obj) throws Exception {
            AbstractIoSession abstractIoSession = (AbstractIoSession) ioSession;
            if (!(obj instanceof AbstractC3054b)) {
                abstractIoSession.m1072a(System.currentTimeMillis());
            } else if (!((AbstractC3054b) obj).mo1356m()) {
                abstractIoSession.m1072a(System.currentTimeMillis());
            }
            if (ioSession.mo993m() instanceof AbstractIoService) {
                ((AbstractIoService) ioSession.mo993m()).m1215w().m1168c(System.currentTimeMillis());
            }
            try {
                ioSession.mo1000f().mo1204a(abstractIoSession, obj);
            } finally {
                if (abstractIoSession.mo1007c().mo971f()) {
                    abstractIoSession.m1052f(obj);
                }
            }
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: b */
        public void mo811b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
            ((AbstractIoSession) ioSession).m1061a(interfaceC3088b, System.currentTimeMillis());
            if (ioSession.mo993m() instanceof AbstractIoService) {
                ((AbstractIoService) ioSession.mo993m()).m1215w().m1168c(System.currentTimeMillis());
            }
            ioSession.mo1000f().mo1200b(ioSession, interfaceC3088b.mo836b());
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: a */
        public void mo827a(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession, InterfaceC3088b interfaceC3088b) throws Exception {
            interfaceC3073a.mo1109b(ioSession, interfaceC3088b);
        }

        @Override // org.apache.mina.core.filterchain.IoFilterAdapter, org.apache.mina.core.filterchain.IoFilter
        /* renamed from: b */
        public void mo826b(IoFilter.InterfaceC3073a interfaceC3073a, IoSession ioSession) throws Exception {
            interfaceC3073a.mo1106e(ioSession);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DefaultIoFilterChain.java */
    /* renamed from: org.apache.mina.core.filterchain.a$a */
    /* loaded from: classes2.dex */
    public final class C3067a implements IoFilterChain.InterfaceC3074a {

        /* renamed from: b */
        private C3067a f11450b;

        /* renamed from: c */
        private C3067a f11451c;

        /* renamed from: d */
        private final String f11452d;

        /* renamed from: e */
        private IoFilter f11453e;

        /* renamed from: f */
        private final IoFilter.InterfaceC3073a f11454f;

        private C3067a(C3067a c3067a, C3067a c3067a2, String str, IoFilter ioFilter) {
            if (ioFilter == null) {
                throw new IllegalArgumentException("filter");
            }
            if (str == null) {
                throw new IllegalArgumentException("name");
            }
            this.f11450b = c3067a;
            this.f11451c = c3067a2;
            this.f11452d = str;
            this.f11453e = ioFilter;
            this.f11454f = new IoFilter.InterfaceC3073a() { // from class: org.apache.mina.core.filterchain.a.a.1
                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: a */
                public void mo1115a(IoSession ioSession) {
                    DefaultIoFilterChain.this.m1141a(C3067a.this.f11451c, ioSession);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: b */
                public void mo1110b(IoSession ioSession) {
                    DefaultIoFilterChain.this.m1133b(C3067a.this.f11451c, ioSession);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: c */
                public void mo1108c(IoSession ioSession) {
                    DefaultIoFilterChain.this.m1130c(C3067a.this.f11451c, ioSession);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: a */
                public void mo1112a(IoSession ioSession, IdleStatus idleStatus) {
                    DefaultIoFilterChain.this.m1138a((IoFilterChain.InterfaceC3074a) C3067a.this.f11451c, ioSession, idleStatus);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: a */
                public void mo1113a(IoSession ioSession, Throwable th) {
                    DefaultIoFilterChain.this.m1139a((IoFilterChain.InterfaceC3074a) C3067a.this.f11451c, ioSession, th);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: d */
                public void mo1107d(IoSession ioSession) {
                    DefaultIoFilterChain.this.m1128d(C3067a.this.f11451c, ioSession);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: a */
                public void mo1114a(IoSession ioSession, Object obj) {
                    DefaultIoFilterChain.this.m1140a(C3067a.this.f11451c, ioSession, obj);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: a */
                public void mo1111a(IoSession ioSession, InterfaceC3088b interfaceC3088b) {
                    DefaultIoFilterChain.this.m1137a((IoFilterChain.InterfaceC3074a) C3067a.this.f11451c, ioSession, interfaceC3088b);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: b */
                public void mo1109b(IoSession ioSession, InterfaceC3088b interfaceC3088b) {
                    DefaultIoFilterChain.this.m1132b(C3067a.this.f11450b, ioSession, interfaceC3088b);
                }

                @Override // org.apache.mina.core.filterchain.IoFilter.InterfaceC3073a
                /* renamed from: e */
                public void mo1106e(IoSession ioSession) {
                    DefaultIoFilterChain.this.m1126e(C3067a.this.f11450b, ioSession);
                }

                public String toString() {
                    return C3067a.this.f11451c.f11452d;
                }
            };
        }

        @Override // org.apache.mina.core.filterchain.IoFilterChain.InterfaceC3074a
        /* renamed from: a */
        public String mo1087a() {
            return this.f11452d;
        }

        @Override // org.apache.mina.core.filterchain.IoFilterChain.InterfaceC3074a
        /* renamed from: b */
        public IoFilter mo1086b() {
            return this.f11453e;
        }

        @Override // org.apache.mina.core.filterchain.IoFilterChain.InterfaceC3074a
        /* renamed from: c */
        public IoFilter.InterfaceC3073a mo1085c() {
            return this.f11454f;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("('");
            sb.append(mo1087a());
            sb.append('\'');
            sb.append(", prev: '");
            C3067a c3067a = this.f11450b;
            if (c3067a != null) {
                sb.append(c3067a.f11452d);
                sb.append(':');
                sb.append(this.f11450b.mo1086b().getClass().getSimpleName());
            } else {
                sb.append("null");
            }
            sb.append("', next: '");
            C3067a c3067a2 = this.f11451c;
            if (c3067a2 != null) {
                sb.append(c3067a2.f11452d);
                sb.append(':');
                sb.append(this.f11451c.mo1086b().getClass().getSimpleName());
            } else {
                sb.append("null");
            }
            sb.append("')");
            return sb.toString();
        }
    }
}
