package com.navatics.app.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.p008v4.view.InputDeviceCompat;
import com.navatics.app.framework.annotation.SearchState;
import com.navatics.app.framework.p050b.EventPipeline;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.robot.transport.INvGroundStation;
import com.navatics.robot.transport.KeyMapProvider;
import com.navatics.robot.transport.NvBatteryInfo;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.NvError;
import com.navatics.robot.transport.NvEvent;
import com.navatics.robot.transport.NvEventHandler;
import com.navatics.robot.transport.NvSocket;
import com.navatics.robot.transport.p063b.NvAction;
import com.navatics.robot.utils.C2160n;
import com.navatics.xlog.WLog;
import com.takisoft.fix.support.p069v7.preference.PreferenceFragmentCompatDividers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.g */
/* loaded from: classes.dex */
public class GroundStation implements NvEventHandler {

    /* renamed from: a */
    private static final String f4649a = "g";

    /* renamed from: b */
    private static final C3044k f4650b = C3044k.m1564a(GroundStation.class);

    /* renamed from: c */
    private INvGroundStation f4651c;

    /* renamed from: d */
    private NvUser f4652d;

    /* renamed from: f */
    private int f4654f;

    /* renamed from: h */
    private NvConnection f4656h;

    /* renamed from: r */
    private EventPipeline f4666r;

    /* renamed from: s */
    private boolean f4667s;

    /* renamed from: t */
    private boolean f4668t;

    /* renamed from: u */
    private boolean f4669u;

    /* renamed from: v */
    private boolean f4670v;

    /* renamed from: e */
    private GroundStationStatus f4653e = new GroundStationStatus(this);

    /* renamed from: g */
    private NvBatteryInfo f4655g = new NvBatteryInfo();

    /* renamed from: i */
    private List<NvConnection> f4657i = new ArrayList();

    /* renamed from: j */
    private HashMap<NvSocket, NvConnection> f4658j = new HashMap<>();

    /* renamed from: k */
    private List<NvGroundStationHandler> f4659k = new CopyOnWriteArrayList();

    /* renamed from: l */
    private HashMap<String, NvDeviceEntry> f4660l = new HashMap<>();

    /* renamed from: m */
    private List<NvDeviceEntry> f4661m = new ArrayList();

    /* renamed from: n */
    private List<NvDeviceEntry> f4662n = new ArrayList();

    /* renamed from: o */
    private List<NvDeviceEntry> f4663o = new ArrayList();

    /* renamed from: p */
    private List<GroundStationDeviceItemUpdateHandler> f4664p = new ArrayList();
    @SearchState

    /* renamed from: q */
    private int f4665q = 2;

    public static /* synthetic */ void lambda$5TCDHtbJo04F1lQlhMWznJXMP_c(GroundStation groundStation, GroundStationDeviceItemUpdateHandler groundStationDeviceItemUpdateHandler) {
        groundStation.m8119c(groundStationDeviceItemUpdateHandler);
    }

    /* renamed from: n */
    public void m8097n() {
    }

    /* renamed from: o */
    public void m8096o() {
    }

    public GroundStation(INvGroundStation iNvGroundStation) {
        this.f4651c = iNvGroundStation;
        this.f4651c.mo6184a(this);
        this.f4654f = 0;
        this.f4666r = new EventPipeline();
        m8089v();
    }

    /* renamed from: a */
    public EventPipeline m8146a() {
        return this.f4666r;
    }

    /* renamed from: v */
    private void m8089v() {
        Context m7935e = Navatics.m7935e();
        SharedPreferences sharedPreferences = m7935e.getSharedPreferences("developer_setting", 0);
        this.f4667s = sharedPreferences.getBoolean("enableAuth", m7935e.getResources().getBoolean(R.bool.enable_auth));
        this.f4668t = sharedPreferences.getBoolean("controllerAutoLogin", m7935e.getResources().getBoolean(R.bool.controller_auto_login));
        this.f4669u = sharedPreferences.getBoolean("rollerAutoLogin", m7935e.getResources().getBoolean(R.bool.roller_auto_login));
        this.f4670v = sharedPreferences.getBoolean("enableAutoConn", m7935e.getResources().getBoolean(R.bool.enable_auto_connect));
    }

    @NonNull
    public String toString() {
        return "GroundStation[id=" + this.f4651c.mo6194a() + "]";
    }

    /* renamed from: b */
    public long m8129b() {
        return this.f4651c.mo6194a();
    }

    /* renamed from: c */
    public boolean m8120c() {
        return this.f4651c.mo6093n();
    }

    /* renamed from: d */
    public boolean m8113d() {
        return this.f4651c.mo6091o();
    }

    /* renamed from: e */
    public boolean m8109e() {
        return this.f4651c.mo6099k();
    }

    /* renamed from: a */
    public void m8131a(Map<String, Object> map) {
        this.f4651c.mo6142a(map);
        m8087x();
    }

    /* renamed from: b */
    public void m8121b(Map<String, Object> map) {
        this.f4651c.mo6128b(map);
        m8087x();
    }

    /* renamed from: c */
    public void m8114c(Map<String, Object> map) {
        this.f4651c.mo6117c(map);
    }

    /* renamed from: w */
    private SSUsrInfo m8088w() {
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            f4650b.mo1504b((Object) "user is null");
            return null;
        } else if (m7806d.getSsUsrInfo() == null) {
            f4650b.mo1504b((Object) "user doesn't have ss info");
            return null;
        } else {
            return m7806d.getSsUsrInfo().getTarget();
        }
    }

    /* renamed from: f */
    public void m8106f() {
        SSUsrInfo m8088w = m8088w();
        if (m8088w == null) {
            f4650b.mo1504b((Object) "ssUsrInfo is null");
            m8144a(16711686, new NvError(49, "ss usr info is empty", this.f4651c));
            return;
        }
        String serialNumber = m8104g().getSerialNumber();
        String uuid = m8088w.getUuid();
        String accessToken = m8088w.getAccessToken();
        HashMap hashMap = new HashMap();
        hashMap.put("sn", serialNumber);
        hashMap.put("uuid", uuid);
        hashMap.put("access_token", accessToken);
        this.f4651c.mo6117c(hashMap);
    }

    /* renamed from: a */
    public void m8143a(long j) {
        this.f4651c.mo6189a(j);
    }

    /* renamed from: a */
    public void m8138a(NvUser nvUser) {
        this.f4652d = nvUser;
    }

    /* renamed from: g */
    public NvDeviceInfo m8104g() {
        return this.f4651c.mo6141b();
    }

    /* renamed from: h */
    public GroundStationStatus m8103h() {
        return this.f4653e;
    }

    /* renamed from: i */
    public int m8102i() {
        return this.f4654f;
    }

    /* renamed from: x */
    private void m8087x() {
        m8130a(false);
    }

    /* renamed from: a */
    private synchronized void m8130a(boolean z) {
        if (!this.f4651c.mo6099k()) {
            this.f4654f = -1;
        } else {
            switch (this.f4654f) {
                case 0:
                    if (this.f4651c.mo6103i()) {
                        this.f4654f = 1;
                        break;
                    }
                    break;
                case 1:
                    if (this.f4651c.mo6093n()) {
                        this.f4654f = 4;
                        break;
                    } else if (!this.f4651c.mo6091o()) {
                        this.f4654f = 2;
                        break;
                    } else {
                        this.f4654f = 0;
                        break;
                    }
                case 2:
                    if (this.f4651c.mo6105h()) {
                        this.f4654f = 3;
                        break;
                    }
                    break;
                case 3:
                    if (z) {
                        this.f4654f = 2;
                        break;
                    } else if (this.f4651c.mo6091o()) {
                        this.f4654f = 0;
                        break;
                    }
                    break;
                case 4:
                    if (this.f4651c.mo6101j() || !this.f4657i.isEmpty() || !this.f4661m.isEmpty()) {
                        this.f4654f = 5;
                        break;
                    }
                    break;
                case 5:
                    if (!this.f4651c.mo6101j() && this.f4657i.isEmpty() && this.f4661m.isEmpty()) {
                        this.f4654f = 4;
                        break;
                    }
                    break;
            }
        }
        C3044k c3044k = f4650b;
        c3044k.mo1500c((Object) ("GND State : " + this.f4654f));
    }

    /* renamed from: a */
    private void m8133a(NvSocket nvSocket) {
        if (this.f4658j.get(nvSocket) == null) {
            f4650b.mo1504b((Object) "handleDeviceAuthSuccess can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvSocket.m6030b().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceAuthSuccess can't find NvDeviceEntry");
        }
        this.f4662n.remove(nvDeviceEntry);
        nvDeviceEntry.m7736q();
        Settings.m8618a().m8616a(nvSocket.m6030b());
    }

    /* renamed from: b */
    private void m8123b(NvSocket nvSocket) {
        NvConnection nvConnection = this.f4658j.get(nvSocket);
        if (nvConnection == null) {
            f4650b.mo1504b((Object) "handleDeviceAuthSuccess can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvSocket.m6030b().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceAuthSuccess can't find NvDeviceEntry");
        }
        nvDeviceEntry.m7739n();
        if (this.f4669u) {
            m8140a(nvConnection);
        }
    }

    /* renamed from: c */
    private void m8115c(NvSocket nvSocket) {
        NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvSocket.m6030b().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceConnected can't find NvDeviceEntry");
        }
        f4650b.mo1511a((Object) "handleDeviceConnected 1");
        MitoConnection mitoConnection = new MitoConnection(this, nvSocket);
        this.f4657i.add(mitoConnection);
        this.f4658j.put(nvSocket, mitoConnection);
        f4650b.mo1511a((Object) "handleDeviceConnected 2");
        this.f4661m.remove(nvDeviceEntry);
        nvDeviceEntry.m7753a(mitoConnection);
        f4650b.mo1511a((Object) "handleDeviceConnected 3");
        if (this.f4656h == null) {
            m8126b(mitoConnection);
        }
        f4650b.mo1511a((Object) "handleDeviceConnected 4");
        m8140a(mitoConnection);
    }

    /* renamed from: a */
    private void m8140a(NvConnection nvConnection) {
        NvUser m7806d = NvUserManager.m7828b().m7806d();
        if (m7806d == null) {
            f4650b.mo1511a((Object) "handlerGNDSTAConnected, no active user now");
            return;
        }
        NvDeviceInfo m7876i = nvConnection.m7876i();
        f4650b.mo1511a((Object) "handleDeviceConnected new device");
        f4650b.mo1511a((Object) m7876i.toString());
        if (m7806d.getSsUsrInfo() == null) {
            f4650b.mo1499d("user not bind to sensethink account");
            m8144a(16711681, new NvError(255, "user not bind to sensethink account"));
            return;
        }
        SSUsrInfo target = m7806d.getSsUsrInfo().getTarget();
        if (target == null) {
            f4650b.mo1499d("user not bind to sensethink account or db is corrupt.");
            m8144a(16711681, new NvError(255, "user not bind to sensethink account or db is corrupt."));
        } else if (C2160n.m5855a((CharSequence) target.uuid)) {
            f4650b.mo1499d("user sensethink uuid is null");
            m8144a(16711681, new NvError(255, "user sensethink uuid is null."));
        } else {
            NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvConnection.m7876i().getSerialNumber());
            if (nvDeviceEntry == null) {
                throw new RuntimeException("wtf?! handleDeviceConnected can't find NvDeviceEntry");
            }
            nvDeviceEntry.m7737p();
            this.f4662n.add(nvDeviceEntry);
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", target.uuid);
            nvConnection.m7892a(hashMap);
        }
    }

    /* renamed from: a */
    public KeyMapProvider m8142a(Context context) {
        return this.f4651c.mo6188a(context);
    }

    /* renamed from: d */
    private void m8110d(NvSocket nvSocket) {
        NvConnection nvConnection = this.f4658j.get(nvSocket);
        if (nvConnection == null) {
            f4650b.mo1504b((Object) "handleDeviceDisConnected can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvSocket.m6030b().getSerialNumber());
        if (nvDeviceEntry == null) {
            f4650b.mo1504b((Object) "handleDeviceDisConnected can't find NvDeviceEntry");
            return;
        }
        if (nvConnection == this.f4656h) {
            m8126b((NvConnection) null);
        }
        this.f4657i.remove(nvConnection);
        this.f4658j.remove(nvSocket);
        this.f4660l.remove(nvSocket.m6030b().getSerialNumber());
        this.f4663o.remove(nvDeviceEntry);
        nvDeviceEntry.m7735r();
        m8118c(nvConnection);
        nvConnection.mo7891b();
        List<NvSocket> mo6095m = this.f4651c.mo6095m();
        if (mo6095m == null || mo6095m.isEmpty()) {
            WLog.m5844i(f4649a, "enter search because of device disconnect");
            m8099l();
            return;
        }
        throw new RuntimeException("Oops! Shouldn't reach here, please check your code");
    }

    /* renamed from: y */
    private void m8086y() {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7725c(this);
        }
        List<NvSocket> mo6095m = this.f4651c.mo6095m();
        if (mo6095m == null || mo6095m.isEmpty()) {
            f4650b.mo1511a((Object) "we don't have a active conn");
            m8099l();
            return;
        }
        for (NvSocket nvSocket : mo6095m) {
            NvDeviceInfo m6030b = nvSocket.m6030b();
            String serialNumber = m6030b.getSerialNumber();
            NvDeviceEntry nvDeviceEntry = new NvDeviceEntry(this, m6030b);
            this.f4660l.put(serialNumber, nvDeviceEntry);
            this.f4663o.add(nvDeviceEntry);
            m8115c(nvSocket);
        }
    }

    /* renamed from: z */
    private void m8085z() {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7730a(this);
        }
        if (this.f4668t) {
            Navatics.m7954a(this);
        }
    }

    /* renamed from: A */
    private void m8152A() {
        this.f4666r.m8581a(65566, this);
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7724d(this);
        }
    }

    /* renamed from: e */
    private void m8107e(NvSocket nvSocket) {
        NvConnection nvConnection = this.f4658j.get(nvSocket);
        if (nvConnection == null) {
            f4650b.mo1504b((Object) "handleDeviceUnbindSuccess can not find connection for socket");
            return;
        }
        NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvSocket.m6030b().getSerialNumber());
        if (nvDeviceEntry == null) {
            throw new RuntimeException("wtf?! handleDeviceUnbindSuccess can't find NvDeviceEntry");
        }
        nvDeviceEntry.m7738o();
        nvConnection.m7868q();
        nvConnection.m7874k();
    }

    /* renamed from: b */
    private void m8126b(NvConnection nvConnection) {
        NvConnection nvConnection2 = this.f4656h;
        if (nvConnection2 != null) {
            nvConnection2.m7877h();
        } else {
            nvConnection2 = null;
        }
        this.f4656h = nvConnection;
        NvConnection nvConnection3 = this.f4656h;
        if (nvConnection3 != null) {
            nvConnection3.m7878g();
        }
        m8139a(nvConnection2, this.f4656h);
    }

    /* renamed from: a */
    private void m8139a(NvConnection nvConnection, NvConnection nvConnection2) {
        this.f4666r.m8575b(196610, nvConnection, nvConnection2);
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7507a(this, nvConnection, nvConnection2);
        }
    }

    /* renamed from: a */
    public NvConnection m8132a(String str) {
        for (NvConnection nvConnection : this.f4657i) {
            if (nvConnection.m7876i().getSerialNumber().equals(str)) {
                return nvConnection;
            }
        }
        return null;
    }

    /* renamed from: b */
    public NvConnection m8128b(long j) {
        for (NvConnection nvConnection : this.f4657i) {
            if (nvConnection.m7881e() == j) {
                return nvConnection;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m8141a(final GroundStationDeviceItemUpdateHandler groundStationDeviceItemUpdateHandler) {
        if (groundStationDeviceItemUpdateHandler == null) {
            throw new RuntimeException("handle is null");
        }
        this.f4664p.add(groundStationDeviceItemUpdateHandler);
        if (groundStationDeviceItemUpdateHandler instanceof AbstractGndStaDeviceItemUpdateHandler) {
            ((AbstractGndStaDeviceItemUpdateHandler) groundStationDeviceItemUpdateHandler).m6324a(new NvAction() { // from class: com.navatics.app.framework.-$$Lambda$g$5TCDHtbJo04F1lQlhMWznJXMP_c
                @Override // com.navatics.robot.transport.p063b.NvAction
                public final void run() {
                    GroundStation.lambda$5TCDHtbJo04F1lQlhMWznJXMP_c(GroundStation.this, groundStationDeviceItemUpdateHandler);
                }
            });
        }
        if (this.f4663o.isEmpty()) {
            return;
        }
        groundStationDeviceItemUpdateHandler.mo8062a(this.f4663o);
    }

    /* renamed from: b */
    public void m8119c(GroundStationDeviceItemUpdateHandler groundStationDeviceItemUpdateHandler) {
        this.f4664p.remove(groundStationDeviceItemUpdateHandler);
    }

    /* renamed from: a */
    public void m8137a(final NvGroundStationHandler nvGroundStationHandler) {
        if (nvGroundStationHandler == null) {
            throw new RuntimeException("handle is null");
        }
        this.f4659k.add(nvGroundStationHandler);
        if (nvGroundStationHandler instanceof AbstractGroundStationHandler) {
            ((AbstractGroundStationHandler) nvGroundStationHandler).m6324a(new NvAction() { // from class: com.navatics.app.framework.-$$Lambda$g$theq5WPtZDBqAvuS5eYHPQ0K7R0
                @Override // com.navatics.robot.transport.p063b.NvAction
                public final void run() {
                    GroundStation.this.m8117c(nvGroundStationHandler);
                }
            });
        }
        C3044k c3044k = f4650b;
        c3044k.mo1511a((Object) ("1 notifySearchStateChanged " + this.f4665q));
        nvGroundStationHandler.mo7729a(this, this.f4665q);
        for (NvDeviceEntry nvDeviceEntry : this.f4663o) {
            if (nvDeviceEntry.m7743j() == 2) {
                nvGroundStationHandler.mo7506a(this, nvDeviceEntry.m7757a());
            }
        }
        for (NvDeviceEntry nvDeviceEntry2 : this.f4663o) {
            if (nvDeviceEntry2.m7743j() == 7) {
                nvGroundStationHandler.mo7507a(this, (NvConnection) null, nvDeviceEntry2.m7734s());
            }
        }
    }

    /* renamed from: b */
    public void m8117c(NvGroundStationHandler nvGroundStationHandler) {
        this.f4659k.remove(nvGroundStationHandler);
    }

    /* renamed from: j */
    public boolean m8101j() {
        for (NvConnection nvConnection : this.f4657i) {
            if (nvConnection.m7875j()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: k */
    public void m8100k() {
        for (GroundStationDeviceItemUpdateHandler groundStationDeviceItemUpdateHandler : this.f4664p) {
            groundStationDeviceItemUpdateHandler.mo8062a(this.f4663o);
        }
    }

    /* renamed from: b */
    public void m8122b(String str) {
        NvDeviceEntry nvDeviceEntry = this.f4660l.get(str);
        if (nvDeviceEntry == null) {
            f4650b.mo1504b((Object) "onItemBinding item is null");
        } else {
            nvDeviceEntry.m7740m();
        }
    }

    /* renamed from: b */
    private void m8124b(NvEvent nvEvent) {
        switch (nvEvent.f6562b) {
            case 65538:
                if (m8101j() || m8090u()) {
                    return;
                }
                m8099l();
                return;
            case PreferenceFragmentCompatDividers.DIVIDER_DEFAULT /* 65539 */:
                List<NvDeviceInfo> list = (List) nvEvent.f6566f;
                if (list == null) {
                    list = new ArrayList();
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = false;
                for (NvDeviceInfo nvDeviceInfo : list) {
                    String serialNumber = nvDeviceInfo.getSerialNumber();
                    NvDeviceEntry nvDeviceEntry = this.f4660l.get(serialNumber);
                    if (nvDeviceEntry == null) {
                        C3044k c3044k = f4650b;
                        c3044k.mo1500c((Object) ("new device : " + nvDeviceInfo));
                        nvDeviceEntry = new NvDeviceEntry(this, nvDeviceInfo);
                        this.f4660l.put(serialNumber, nvDeviceEntry);
                        this.f4663o.add(nvDeviceEntry);
                        z = true;
                    }
                    nvDeviceEntry.m7754a(currentTimeMillis);
                }
                Iterator<NvDeviceEntry> it = this.f4663o.iterator();
                while (it.hasNext()) {
                    NvDeviceEntry next = it.next();
                    if (next.m7752b() && currentTimeMillis - next.m7733t() > 5000) {
                        String serialNumber2 = next.m7757a().getSerialNumber();
                        C3044k c3044k2 = f4650b;
                        c3044k2.mo1499d("remove inactive device : " + serialNumber2);
                        this.f4660l.remove(serialNumber2);
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    m8100k();
                }
                NvDeviceInfo m8602j = Settings.m8618a().m8602j();
                if (!this.f4670v || m8602j == null) {
                    return;
                }
                NvDeviceEntry nvDeviceEntry2 = this.f4660l.get(m8602j.getSerialNumber());
                if (nvDeviceEntry2 == null || !nvDeviceEntry2.m7752b()) {
                    return;
                }
                f4650b.mo1511a((Object) "we found one idle item we met before, initialize the connection to it");
                m8134a(nvDeviceEntry2.m7757a(), null, false);
                return;
            default:
                return;
        }
    }

    /* renamed from: B */
    private void m8151B() {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7726b(this);
        }
    }

    /* renamed from: C */
    private void m8150C() {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7727a(this.f4651c.mo6141b());
        }
    }

    /* renamed from: a */
    private void m8145a(@SearchState int i) {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7729a(this, i);
        }
    }

    /* renamed from: a */
    private void m8136a(NvDeviceInfo nvDeviceInfo) {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7506a(this, nvDeviceInfo);
        }
    }

    /* renamed from: c */
    private void m8118c(NvConnection nvConnection) {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7504b(this, nvConnection);
        }
    }

    /* renamed from: l */
    public void m8099l() {
        if (this.f4651c.mo6099k()) {
            this.f4651c.mo6107g();
            m8087x();
        }
    }

    /* renamed from: a */
    public void m8135a(NvDeviceInfo nvDeviceInfo, Map<String, Object> map) {
        m8134a(nvDeviceInfo, map, true);
    }

    /* renamed from: a */
    public void m8134a(NvDeviceInfo nvDeviceInfo, Map<String, Object> map, boolean z) {
        if (!nvDeviceInfo.isValid()) {
            f4650b.mo1504b((Object) ("NvDeviceInfo is not valid : " + nvDeviceInfo));
        } else if (!this.f4661m.isEmpty() && m8091t() < 2) {
            f4650b.mo1504b((Object) "The underlying ground station implementation only allow to connect to 1 device at the same time. ");
        } else {
            NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvDeviceInfo.getSerialNumber());
            if (nvDeviceEntry == null) {
                String str = "connect met unknown device : " + nvDeviceInfo.getSerialNumber();
                f4650b.mo1504b((Object) str);
                if (z) {
                    m8144a(16711681, new NvError(56, str, nvDeviceInfo));
                }
            } else if (!this.f4651c.mo6099k()) {
                f4650b.mo1504b((Object) "connect : GroundStation is already invalid.");
            } else if (this.f4661m.contains(nvDeviceEntry)) {
                f4650b.mo1499d("trying to connect to device already in connecting list : " + nvDeviceInfo.getSerialNumber());
            } else {
                this.f4661m.add(nvDeviceEntry);
                nvDeviceEntry.m7741l();
                m8087x();
                m8136a(nvDeviceInfo);
                this.f4651c.mo6185a(nvDeviceInfo, map);
            }
        }
    }

    /* renamed from: m */
    public NvConnection m8098m() {
        return this.f4656h;
    }

    /* renamed from: p */
    public NvBatteryInfo m8095p() {
        return this.f4655g;
    }

    /* renamed from: q */
    public int m8094q() {
        return this.f4651c.mo6127c();
    }

    /* renamed from: r */
    public int m8093r() {
        return this.f4651c.mo6116d();
    }

    /* renamed from: s */
    public int m8092s() {
        return this.f4651c.mo6111e();
    }

    /* renamed from: t */
    public int m8091t() {
        return this.f4651c.mo6097l();
    }

    /* renamed from: u */
    public boolean m8090u() {
        return !this.f4661m.isEmpty();
    }

    /* renamed from: c */
    private void m8116c(NvEvent nvEvent) {
        int i = nvEvent.f6562b;
        if (i != 65549) {
            switch (i) {
                case 65537:
                    this.f4665q = 0;
                    C3044k c3044k = f4650b;
                    c3044k.mo1511a((Object) ("2 notifySearchStateChanged " + this.f4665q));
                    m8145a(this.f4665q);
                    m8124b(nvEvent);
                    return;
                case 65538:
                    this.f4665q = 2;
                    C3044k c3044k2 = f4650b;
                    c3044k2.mo1511a((Object) ("3 notifySearchStateChanged " + this.f4665q));
                    m8145a(this.f4665q);
                    m8124b(nvEvent);
                    return;
                case PreferenceFragmentCompatDividers.DIVIDER_DEFAULT /* 65539 */:
                    m8124b(nvEvent);
                    return;
                case InputDeviceCompat.SOURCE_TRACKBALL /* 65540 */:
                    f4650b.mo1511a((Object) "DEVICE_CONNECTED");
                    m8115c((NvSocket) nvEvent.f6566f);
                    return;
                case 65541:
                    f4650b.mo1511a((Object) "DEVICE_DISCONNECTED");
                    m8110d((NvSocket) nvEvent.f6566f);
                    return;
                default:
                    switch (i) {
                        case 65543:
                            f4650b.mo1511a((Object) "DEVICE_AUTH_SUCCESS");
                            m8133a((NvSocket) nvEvent.f6566f);
                            return;
                        case 65544:
                            f4650b.mo1511a((Object) "DEVICE_BIND_SUCCESS");
                            m8123b((NvSocket) ((NvError) nvEvent.f6566f).m6262c());
                            return;
                        case 65545:
                            f4650b.mo1511a((Object) "GNDSTA_BIND_SUCCESS");
                            m8085z();
                            return;
                        case 65546:
                            f4650b.mo1511a((Object) "GNDSTA_AUTH_SUCCESS");
                            m8086y();
                            return;
                        default:
                            switch (i) {
                                case 65566:
                                    f4650b.mo1511a((Object) "GNDSTA_UNBIND_SUCCESS");
                                    m8152A();
                                    return;
                                case 65567:
                                    f4650b.mo1511a((Object) "DEVICE_UNBIND_SUCCESS");
                                    m8107e((NvSocket) ((NvError) nvEvent.f6566f).m6262c());
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
        f4650b.mo1511a((Object) "GNDSTA_DESTROYED");
        m8148E();
    }

    /* renamed from: D */
    private void m8149D() {
        for (NvConnection nvConnection : this.f4657i) {
            nvConnection.mo7891b();
        }
    }

    /* renamed from: E */
    private void m8148E() {
        m8149D();
        m8150C();
    }

    /* renamed from: d */
    private void m8111d(NvEvent nvEvent) {
        this.f4655g.setLevel(this.f4651c.mo6109f());
        m8151B();
    }

    /* renamed from: e */
    private void m8108e(NvEvent nvEvent) {
        if (nvEvent.f6562b != 131075) {
            return;
        }
        m8111d(nvEvent);
    }

    /* renamed from: f */
    private void m8105f(NvEvent nvEvent) {
        switch (nvEvent.f6562b) {
            case 16711681:
                NvError nvError = (NvError) nvEvent.f6566f;
                NvDeviceInfo nvDeviceInfo = (NvDeviceInfo) nvError.m6262c();
                NvDeviceEntry nvDeviceEntry = this.f4660l.get(nvDeviceInfo.getSerialNumber());
                if (nvDeviceEntry == null) {
                    C3044k c3044k = f4650b;
                    c3044k.mo1504b((Object) ("can't find device for sn " + nvDeviceInfo.getSerialNumber()));
                    return;
                }
                nvDeviceEntry.m7755a(16711681, nvError);
                this.f4661m.remove(nvDeviceEntry);
                f4650b.mo1499d("handleErrorEvent DEVICE_CONN_ERR");
                m8144a(16711681, (NvError) nvEvent.f6566f);
                m8099l();
                return;
            case 16711682:
                f4650b.mo1499d("handleErrorEvent DEVICE_AUTH_ERR");
                NvError nvError2 = (NvError) nvEvent.f6566f;
                NvSocket nvSocket = (NvSocket) nvError2.m6262c();
                if (nvSocket == null) {
                    f4650b.mo1504b((Object) "DEVICE_AUTH_ERR can't get socket from extra of NvError");
                    return;
                }
                NvConnection nvConnection = this.f4658j.get(nvSocket);
                if (nvConnection == null) {
                    C3044k c3044k2 = f4650b;
                    c3044k2.mo1504b((Object) ("handleErrorEvent can not find connection for socket" + nvSocket.m6035a()));
                    return;
                }
                NvDeviceEntry nvDeviceEntry2 = this.f4660l.get(nvSocket.m6030b().getSerialNumber());
                if (nvDeviceEntry2 == null) {
                    C3044k c3044k3 = f4650b;
                    c3044k3.mo1504b((Object) ("can't find device for sn " + nvSocket.m6030b().getSerialNumber()));
                    return;
                }
                this.f4662n.remove(nvDeviceEntry2);
                if (nvError2.m6266a() == 52) {
                    nvDeviceEntry2.m7738o();
                    m8112d(nvConnection);
                    return;
                }
                nvError2.m6264a(nvSocket.m6030b());
                nvDeviceEntry2.m7755a(16711682, nvError2);
                return;
            case 16711683:
                f4650b.mo1499d("handleErrorEvent DEVICE_BIND_ERR");
                NvError nvError3 = (NvError) nvEvent.f6566f;
                NvSocket nvSocket2 = (NvSocket) nvError3.m6262c();
                if (nvSocket2 == null) {
                    f4650b.mo1504b((Object) "DEVICE_BIND_ERR can't get socket from extra of NvError");
                    return;
                } else if (this.f4658j.get(nvSocket2) == null) {
                    C3044k c3044k4 = f4650b;
                    c3044k4.mo1504b((Object) ("handleErrorEvent can not find connection for socket " + nvSocket2.m6035a()));
                    return;
                } else {
                    NvDeviceEntry nvDeviceEntry3 = this.f4660l.get(nvSocket2.m6030b().getSerialNumber());
                    if (nvDeviceEntry3 == null) {
                        C3044k c3044k5 = f4650b;
                        c3044k5.mo1504b((Object) ("can't find device for sn " + nvSocket2.m6030b().getSerialNumber()));
                        return;
                    }
                    f4650b.mo1504b((Object) "notify conn bind err");
                    nvDeviceEntry3.m7755a(16711683, nvError3);
                    return;
                }
            case 16711684:
            default:
                return;
            case 16711685:
                f4650b.mo1499d("handleErrorEvent GNDSTA_AUTH_ERR");
                if (((NvError) nvEvent.f6566f).m6266a() == 52) {
                    m8147F();
                    return;
                } else {
                    m8144a(16711685, (NvError) nvEvent.f6566f);
                    return;
                }
            case 16711686:
                m8144a(16711686, (NvError) nvEvent.f6566f);
                return;
            case 16711687:
                NvError nvError4 = (NvError) nvEvent.f6566f;
                this.f4666r.m8581a(16711687, this, nvError4);
                m8144a(16711687, nvError4);
                return;
            case 16711688:
                NvError nvError5 = (NvError) nvEvent.f6566f;
                NvSocket nvSocket3 = (NvSocket) nvError5.m6262c();
                if (nvSocket3 == null) {
                    f4650b.mo1504b((Object) "DEVICE_AUTH_ERR can't get socket from extra of NvError");
                    return;
                }
                NvConnection nvConnection2 = this.f4658j.get(nvSocket3);
                if (nvConnection2 == null) {
                    C3044k c3044k6 = f4650b;
                    c3044k6.mo1504b((Object) ("handleErrorEvent can not find connection for socket" + nvSocket3.m6035a()));
                    return;
                }
                nvConnection2.m7893a(nvError5);
                return;
        }
    }

    /* renamed from: F */
    private void m8147F() {
        Navatics.m7946b(this);
    }

    /* renamed from: d */
    private void m8112d(NvConnection nvConnection) {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7508a(this, nvConnection);
        }
    }

    /* renamed from: a */
    private void m8144a(int i, NvError nvError) {
        for (NvGroundStationHandler nvGroundStationHandler : this.f4659k) {
            nvGroundStationHandler.mo7728a(this, i, nvError);
        }
    }

    @Override // com.navatics.robot.transport.NvEventHandler
    /* renamed from: a */
    public void mo6007a(NvEvent nvEvent) {
        m8087x();
        int i = nvEvent.f6561a;
        if (i != 255) {
            switch (i) {
                case 1:
                    m8116c(nvEvent);
                    return;
                case 2:
                    m8108e(nvEvent);
                    return;
                default:
                    return;
            }
        }
        m8105f(nvEvent);
    }
}
