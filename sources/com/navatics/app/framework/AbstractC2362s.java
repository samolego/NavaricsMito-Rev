package com.navatics.app.framework;

import com.navatics.app.framework.p050b.EventPipeline;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.robot.protocol.INvProtocol;
import com.navatics.robot.protocol.IProtocolFactory;
import com.navatics.robot.protocol.NvProtocol;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEventLoop;
import com.navatics.robot.transport.NvException;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.transport.ProtoMeta;
import com.navatics.robot.transport.p063b.NvAction;
import com.navatics.robot.utils.C2160n;
import com.navatics.xlog.WLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.s */
/* loaded from: classes.dex */
public abstract class NvConnection {

    /* renamed from: h */
    private static final String f4785h = "s";

    /* renamed from: i */
    private static final C3044k f4786i = C3044k.m1564a(NvConnection.class);

    /* renamed from: a */
    long f4787a;

    /* renamed from: b */
    protected GroundStation f4788b;

    /* renamed from: c */
    protected List<NvDevice> f4789c;

    /* renamed from: d */
    protected NvSocket f4790d;

    /* renamed from: e */
    protected INvRobotAdapter f4791e;

    /* renamed from: f */
    protected INvBuoyAdapter f4792f;

    /* renamed from: g */
    protected List<NvConnectionHandler> f4793g = new ArrayList();

    /* renamed from: j */
    private EventPipeline f4794j;

    /* renamed from: a */
    abstract INvRobotAdapter mo7895a(INvProtocol iNvProtocol);

    /* renamed from: a */
    abstract List<NvDevice> mo7899a();

    /* renamed from: b */
    abstract INvBuoyAdapter mo7888b(INvProtocol iNvProtocol);

    public NvConnection(GroundStation groundStation, NvSocket nvSocket) {
        this.f4787a = nvSocket.m6035a();
        this.f4788b = groundStation;
        this.f4790d = nvSocket;
        NvDeviceInfo m6030b = nvSocket.m6030b();
        if (m6030b == null) {
            throw new NvException("device no deviceinfo", new NvError(49, "device no deviceinfo"));
        }
        List<ProtoMeta> supportedProtoList = m6030b.getSupportedProtoList();
        if (supportedProtoList.isEmpty()) {
            throw new NvException("device supported protocol list is empty", new NvError(49, "device supported protocol list is empty"));
        }
        ProtoMeta protoMeta = null;
        Iterator<ProtoMeta> it = supportedProtoList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ProtoMeta next = it.next();
            if (m7894a(next)) {
                protoMeta = next;
                break;
            }
        }
        if (protoMeta == null) {
            throw new NvException("device is incompatible", new NvError(49, "device is incompatible"));
        }
        f4786i.mo1511a((Object) ("choose protocol, name " + protoMeta.getName() + ", version " + protoMeta.getVersionCode()));
        INvProtocol m6531a = NvProtocol.m6531a(protoMeta.getName(), protoMeta.getVersionCode());
        if (m6531a == null) {
            String str = "create protocol " + protoMeta.getName() + " failed.";
            throw new NvException(str, new NvError(49, str));
        }
        m6531a.mo6411a(nvSocket);
        f4786i.mo1500c((Object) ("New connection : " + m7881e()));
        this.f4791e = mo7895a(m6531a);
        this.f4792f = mo7888b(m6531a);
        this.f4789c = mo7899a();
        this.f4794j = new EventPipeline();
    }

    /* renamed from: c */
    public GroundStation m7886c() {
        return this.f4788b;
    }

    /* renamed from: a */
    private boolean m7894a(ProtoMeta protoMeta) {
        if (protoMeta == null || C2160n.m5855a((CharSequence) protoMeta.getName())) {
            return false;
        }
        for (IProtocolFactory iProtocolFactory : NvProtocol.m6530b()) {
            if (!C2160n.m5855a((CharSequence) iProtocolFactory.mo6379a()) && iProtocolFactory.mo6379a().equals(protoMeta.getName()) && iProtocolFactory.mo6377b(protoMeta.getVersionCode())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public EventPipeline m7883d() {
        return this.f4794j;
    }

    /* renamed from: e */
    public long m7881e() {
        return this.f4787a;
    }

    /* renamed from: f */
    public NvSocket m7879f() {
        return this.f4790d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m7878g() {
        C3044k c3044k = f4786i;
        c3044k.mo1511a((Object) ("conn " + m7881e() + " switch to foreground"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public void m7877h() {
        C3044k c3044k = f4786i;
        c3044k.mo1511a((Object) ("conn " + m7881e() + " switch to background"));
    }

    /* renamed from: i */
    public NvDeviceInfo m7876i() {
        return this.f4790d.m6030b();
    }

    /* renamed from: j */
    public boolean m7875j() {
        return this.f4790d.m6024e();
    }

    /* renamed from: a */
    public void m7892a(Map<String, Object> map) {
        this.f4790d.mo6032a(map);
    }

    /* renamed from: k */
    public void m7874k() {
        try {
            this.f4790d.mo6019j();
            Settings m8618a = Settings.m8618a();
            NvDeviceInfo m8602j = m8618a.m8602j();
            if (m8602j == null || !m8602j.getSerialNumber().equals(m7876i().getSerialNumber())) {
                return;
            }
            m8618a.m8601k();
        } catch (IOException e) {
            e.printStackTrace();
            C3044k c3044k = f4786i;
            c3044k.mo1504b((Object) ("close connection error : " + e.getMessage()));
        }
    }

    /* renamed from: b */
    public void m7887b(Map<String, Object> map) {
        this.f4788b.m8122b(this.f4790d.m6030b().getSerialNumber());
        this.f4790d.mo6029b(map);
    }

    /* renamed from: r */
    private SSUsrInfo m7867r() {
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            f4786i.mo1504b((Object) "user is null");
            return null;
        } else if (m7806d.getSsUsrInfo() == null) {
            f4786i.mo1504b((Object) "user doesn't have ss info");
            return null;
        } else {
            return m7806d.getSsUsrInfo().getTarget();
        }
    }

    /* renamed from: l */
    public void m7873l() {
        GroundStation m7931h;
        NvConnection m7930i;
        SSUsrInfo m7867r = m7867r();
        if (m7867r == null) {
            f4786i.mo1504b((Object) "ssUsrInfo is null");
        } else if (m7875j() && (m7931h = Navatics.m7931h()) != null && m7931h.m8120c() && (m7930i = Navatics.m7930i()) != null && m7930i.m7875j()) {
            String serialNumber = m7930i.m7876i().getSerialNumber();
            String uuid = m7867r.getUuid();
            String accessToken = m7867r.getAccessToken();
            HashMap hashMap = new HashMap();
            hashMap.put("sn", serialNumber);
            hashMap.put("uuid", uuid);
            hashMap.put("access_token", accessToken);
            this.f4790d.mo6026c(hashMap);
        }
    }

    /* renamed from: c */
    public void m7884c(Map<String, Object> map) {
        this.f4790d.mo6026c(map);
    }

    /* renamed from: a */
    public NvDevice m7898a(int i) {
        for (NvDevice nvDevice : this.f4789c) {
            if (nvDevice.m7857c() == i) {
                return nvDevice;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m */
    public void m7872m() {
        m7863v();
        this.f4794j.m8575b(65543, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public void m7871n() {
        m7862w();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: o */
    public void m7870o() {
        m7866s();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public void m7869p() {
        m7865t();
        this.f4794j.m8583a(65543);
        this.f4794j.m8581a(65541, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: q */
    public void m7868q() {
        m7864u();
        this.f4794j.m8581a(65567, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7893a(NvError nvError) {
        this.f4794j.m8581a(16711688, this, nvError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m7897a(int i, NvError nvError) {
        m7890b(i, nvError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo7891b() {
        String str = f4785h;
        WLog.m5850d(str, getClass().getSimpleName() + " onDestroyed");
    }

    /* renamed from: a */
    public void m7896a(final NvConnectionHandler nvConnectionHandler) {
        this.f4793g.add(nvConnectionHandler);
        if (nvConnectionHandler instanceof AbstractConnectionHandler) {
            ((AbstractConnectionHandler) nvConnectionHandler).m6324a(new NvAction() { // from class: com.navatics.app.framework.-$$Lambda$s$96UKP7XmLaC8uhZjV6tdJe9wztk
                @Override // com.navatics.robot.transport.p063b.NvAction
                public final void run() {
                    NvConnection.this.m7880e(nvConnectionHandler);
                }
            });
        }
        if (!this.f4790d.m6020i()) {
            NvEventLoop.m6232a().mo6286a(new Runnable() { // from class: com.navatics.app.framework.-$$Lambda$s$8NRwqHbGRce0dfTT1twijC7Td9U
                @Override // java.lang.Runnable
                public final void run() {
                    NvConnection.this.m7882d(nvConnectionHandler);
                }
            });
        }
        if (this.f4790d.m6024e()) {
            NvEventLoop.m6232a().mo6286a(new Runnable() { // from class: com.navatics.app.framework.-$$Lambda$s$v8a-a3ty6SayZNNpVpIX6lQvu2Y
                @Override // java.lang.Runnable
                public final void run() {
                    NvConnection.this.m7885c(nvConnectionHandler);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m7882d(NvConnectionHandler nvConnectionHandler) {
        nvConnectionHandler.mo7858d(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m7885c(NvConnectionHandler nvConnectionHandler) {
        nvConnectionHandler.mo7511b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m7880e(NvConnectionHandler nvConnectionHandler) {
        f4786i.mo1511a((Object) "unregisterConnectionHandler");
        this.f4793g.remove(nvConnectionHandler);
    }

    /* renamed from: s */
    private void m7866s() {
        for (NvConnectionHandler nvConnectionHandler : this.f4793g) {
            nvConnectionHandler.mo7858d(this);
        }
    }

    /* renamed from: t */
    private void m7865t() {
        for (NvConnectionHandler nvConnectionHandler : this.f4793g) {
            nvConnectionHandler.mo7509e(this);
        }
    }

    /* renamed from: u */
    private void m7864u() {
        for (NvConnectionHandler nvConnectionHandler : this.f4793g) {
            nvConnectionHandler.mo7859c(this);
        }
    }

    /* renamed from: v */
    private void m7863v() {
        for (NvConnectionHandler nvConnectionHandler : this.f4793g) {
            nvConnectionHandler.mo7511b(this);
        }
    }

    /* renamed from: w */
    private void m7862w() {
        for (NvConnectionHandler nvConnectionHandler : this.f4793g) {
            nvConnectionHandler.mo7861a(this);
        }
    }

    /* renamed from: b */
    private void m7890b(int i, NvError nvError) {
        for (NvConnectionHandler nvConnectionHandler : this.f4793g) {
            nvConnectionHandler.mo7860a(this, i, nvError);
        }
    }
}
