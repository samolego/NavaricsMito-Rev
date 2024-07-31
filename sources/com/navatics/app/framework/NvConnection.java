package com.navatics.app.framework;

import com.navatics.app.framework.p050b.C2188l;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.robot.protocol.C2730ae;
import com.navatics.robot.protocol.InterfaceC2727ab;
import com.navatics.robot.protocol.InterfaceC2728ac;
import com.navatics.robot.transport.AbstractC2857t;
import com.navatics.robot.transport.C2830m;
import com.navatics.robot.transport.C2834q;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvException;
import com.navatics.robot.transport.ProtoMeta;
import com.navatics.robot.transport.p063b.InterfaceC2803d;
import com.navatics.robot.utils.C2905n;
import com.navatics.xlog.WLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/* compiled from: NvConnection.java */
/* renamed from: com.navatics.app.framework.s */
/* loaded from: classes.dex */
public abstract class AbstractC2362s {

    /* renamed from: h */
    private static final String f4785h = "s";

    /* renamed from: i */
    private static final Logger f4786i = Logger.m1561a(AbstractC2362s.class);

    /* renamed from: a */
    long f4787a;

    /* renamed from: b */
    protected C2326g f4788b;

    /* renamed from: c */
    protected List f4789c;

    /* renamed from: d */
    protected AbstractC2857t f4790d;

    /* renamed from: e */
    protected InterfaceC2338k f4791e;

    /* renamed from: f */
    protected InterfaceC2337j f4792f;

    /* renamed from: g */
    protected List f4793g = new ArrayList();

    /* renamed from: j */
    private C2188l f4794j;

    public static /* synthetic */ void lambda$8NRwqHbGRce0dfTT1twijC7Td9U(AbstractC2362s abstractC2362s, InterfaceC2363t interfaceC2363t) {
        abstractC2362s.m7883d(interfaceC2363t);
    }

    public static /* synthetic */ void lambda$96UKP7XmLaC8uhZjV6tdJe9wztk(AbstractC2362s abstractC2362s, InterfaceC2363t interfaceC2363t) {
        abstractC2362s.m7881e(interfaceC2363t);
    }

    /* renamed from: lambda$v8a-a3ty6SayZNNpVpIX6lQvu2Y */
    public static /* synthetic */ void m13074lambda$v8aa3ty6SayZNNpVpIX6lQvu2Y(AbstractC2362s abstractC2362s, InterfaceC2363t interfaceC2363t) {
        abstractC2362s.m7886c(interfaceC2363t);
    }

    /* renamed from: a */
    abstract InterfaceC2338k mo7896a(InterfaceC2727ab interfaceC2727ab);

    /* renamed from: a */
    abstract List mo7900a();

    /* renamed from: b */
    abstract InterfaceC2337j mo7889b(InterfaceC2727ab interfaceC2727ab);

    public AbstractC2362s(C2326g c2326g, AbstractC2857t abstractC2857t) {
        this.f4787a = abstractC2857t.m6030a();
        this.f4788b = c2326g;
        this.f4790d = abstractC2857t;
        NvDeviceInfo m6025b = abstractC2857t.m6025b();
        if (m6025b == null) {
            throw new NvException("device no deviceinfo", new C2830m(49, "device no deviceinfo"));
        }
        List<ProtoMeta> supportedProtoList = m6025b.getSupportedProtoList();
        if (supportedProtoList.isEmpty()) {
            throw new NvException("device supported protocol list is empty", new C2830m(49, "device supported protocol list is empty"));
        }
        ProtoMeta protoMeta = null;
        Iterator<ProtoMeta> it = supportedProtoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ProtoMeta next = it.next();
            if (m7895a(next)) {
                protoMeta = next;
                break;
            }
        }
        if (protoMeta == null) {
            throw new NvException("device is incompatible", new C2830m(49, "device is incompatible"));
        }
        f4786i.mo1508a((Object) ("choose protocol, name " + protoMeta.getName() + ", version " + protoMeta.getVersionCode()));
        InterfaceC2727ab m6533a = C2730ae.m6533a(protoMeta.getName(), protoMeta.getVersionCode());
        if (m6533a == null) {
            String str = "create protocol " + protoMeta.getName() + " failed.";
            throw new NvException(str, new C2830m(49, str));
        }
        m6533a.mo6413a(abstractC2857t);
        f4786i.mo1497c((Object) ("New connection : " + m7882e()));
        this.f4791e = mo7896a(m6533a);
        this.f4792f = mo7889b(m6533a);
        this.f4789c = mo7900a();
        this.f4794j = new C2188l();
    }

    /* renamed from: c */
    public C2326g m7887c() {
        return this.f4788b;
    }

    /* renamed from: a */
    private boolean m7895a(ProtoMeta protoMeta) {
        if (protoMeta == null || C2905n.m5850a((CharSequence) protoMeta.getName())) {
            return false;
        }
        for (InterfaceC2728ac interfaceC2728ac : C2730ae.m6532b()) {
            if (!C2905n.m5850a((CharSequence) interfaceC2728ac.mo6381a()) && interfaceC2728ac.mo6381a().equals(protoMeta.getName()) && interfaceC2728ac.mo6379b(protoMeta.getVersionCode())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public C2188l m7884d() {
        return this.f4794j;
    }

    /* renamed from: e */
    public long m7882e() {
        return this.f4787a;
    }

    /* renamed from: f */
    public AbstractC2857t m7880f() {
        return this.f4790d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m7879g() {
        Logger logger = f4786i;
        logger.mo1508a((Object) ("conn " + m7882e() + " switch to foreground"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m7878h() {
        Logger logger = f4786i;
        logger.mo1508a((Object) ("conn " + m7882e() + " switch to background"));
    }

    /* renamed from: i */
    public NvDeviceInfo m7877i() {
        return this.f4790d.m6025b();
    }

    /* renamed from: j */
    public boolean m7876j() {
        return this.f4790d.m6019e();
    }

    /* renamed from: a */
    public void m7893a(Map map) {
        this.f4790d.mo6027a(map);
    }

    /* renamed from: k */
    public void m7875k() {
        try {
            this.f4790d.mo6014j();
            C2174ag m8619a = C2174ag.m8619a();
            NvDeviceInfo m8603j = m8619a.m8603j();
            if (m8603j == null || !m8603j.getSerialNumber().equals(m7877i().getSerialNumber())) {
                return;
            }
            m8619a.m8602k();
        } catch (IOException e) {
            e.printStackTrace();
            Logger logger = f4786i;
            logger.log((Object) ("close connection error : " + e.getMessage()));
        }
    }

    /* renamed from: b */
    public void m7888b(Map map) {
        this.f4788b.m8123b(this.f4790d.m6025b().getSerialNumber());
        this.f4790d.mo6024b(map);
    }

    /* renamed from: r */
    private SSUsrInfo m7868r() {
        NvUser user = NvUserManager.m7829b().getUser();
        if (user == null) {
            f4786i.log((Object) "user is null");
            return null;
        } else if (user.getSsUsrInfo() == null) {
            f4786i.log((Object) "user doesn't have ss info");
            return null;
        } else {
            return user.getSsUsrInfo().getTarget();
        }
    }

    /* renamed from: l */
    public void m7874l() {
        C2326g m7932h;
        AbstractC2362s m7931i;
        SSUsrInfo m7868r = m7868r();
        if (m7868r == null) {
            f4786i.log((Object) "ssUsrInfo is null");
        } else if (m7876j() && (m7932h = C2353p.m7932h()) != null && m7932h.m8121c() && (m7931i = C2353p.m7931i()) != null && m7931i.m7876j()) {
            String serialNumber = m7931i.m7877i().getSerialNumber();
            String uuid = m7868r.getUuid();
            String accessToken = m7868r.getAccessToken();
            HashMap hashMap = new HashMap();
            hashMap.put("sn", serialNumber);
            hashMap.put("uuid", uuid);
            hashMap.put("access_token", accessToken);
            this.f4790d.mo6021c(hashMap);
        }
    }

    /* renamed from: c */
    public void m7885c(Map map) {
        this.f4790d.mo6021c(map);
    }

    /* renamed from: a */
    public AbstractC2364u m7899a(int i) {
        for (AbstractC2364u abstractC2364u : this.f4789c) {
            if (abstractC2364u.m7858c() == i) {
                return abstractC2364u;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public void m7873m() {
        m7864v();
        this.f4794j.m8576b(65543, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public void m7872n() {
        m7863w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m7871o() {
        m7867s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m7870p() {
        m7866t();
        this.f4794j.m8584a(65543);
        this.f4794j.m8582a(65541, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public void m7869q() {
        m7865u();
        this.f4794j.m8582a(65567, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7894a(C2830m c2830m) {
        this.f4794j.m8582a(16711688, this, c2830m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7898a(int i, C2830m c2830m) {
        m7891b(i, c2830m);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7892b() {
        String str = f4785h;
        WLog.m5845d(str, getClass().getSimpleName() + " onDestroyed");
    }

    /* renamed from: a */
    public void m7897a(final InterfaceC2363t interfaceC2363t) {
        this.f4793g.add(interfaceC2363t);
        if (interfaceC2363t instanceof AbstractC2165a) {
            ((AbstractC2165a) interfaceC2363t).m6324a(new InterfaceC2803d() { // from class: com.navatics.app.framework.-$$Lambda$s$96UKP7XmLaC8uhZjV6tdJe9wztk
                @Override // com.navatics.robot.transport.p063b.InterfaceC2803d
                public final void run() {
                    AbstractC2362s.lambda$96UKP7XmLaC8uhZjV6tdJe9wztk(AbstractC2362s.this, interfaceC2363t);
                }
            });
        }
        if (!this.f4790d.m6015i()) {
            C2834q.m6227a().mo6286a(new Runnable() { // from class: com.navatics.app.framework.-$$Lambda$s$8NRwqHbGRce0dfTT1twijC7Td9U
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2362s.lambda$8NRwqHbGRce0dfTT1twijC7Td9U(AbstractC2362s.this, interfaceC2363t);
                }
            });
        }
        if (this.f4790d.m6019e()) {
            C2834q.m6227a().mo6286a(new Runnable() { // from class: com.navatics.app.framework.-$$Lambda$s$v8a-a3ty6SayZNNpVpIX6lQvu2Y
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractC2362s.m13074lambda$v8aa3ty6SayZNNpVpIX6lQvu2Y(AbstractC2362s.this, interfaceC2363t);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m7883d(InterfaceC2363t interfaceC2363t) {
        interfaceC2363t.mo7859d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m7886c(InterfaceC2363t interfaceC2363t) {
        interfaceC2363t.mo7512b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7881e(InterfaceC2363t interfaceC2363t) {
        f4786i.mo1508a((Object) "unregisterConnectionHandler");
        this.f4793g.remove(interfaceC2363t);
    }

    /* renamed from: s */
    private void m7867s() {
        for (InterfaceC2363t interfaceC2363t : this.f4793g) {
            interfaceC2363t.mo7859d(this);
        }
    }

    /* renamed from: t */
    private void m7866t() {
        for (InterfaceC2363t interfaceC2363t : this.f4793g) {
            interfaceC2363t.mo7510e(this);
        }
    }

    /* renamed from: u */
    private void m7865u() {
        for (InterfaceC2363t interfaceC2363t : this.f4793g) {
            interfaceC2363t.mo7860c(this);
        }
    }

    /* renamed from: v */
    private void m7864v() {
        for (InterfaceC2363t interfaceC2363t : this.f4793g) {
            interfaceC2363t.mo7512b(this);
        }
    }

    /* renamed from: w */
    private void m7863w() {
        for (InterfaceC2363t interfaceC2363t : this.f4793g) {
            interfaceC2363t.mo7862a(this);
        }
    }

    /* renamed from: b */
    private void m7891b(int i, C2830m c2830m) {
        for (InterfaceC2363t interfaceC2363t : this.f4793g) {
            interfaceC2363t.mo7861a(this, i, c2830m);
        }
    }
}
