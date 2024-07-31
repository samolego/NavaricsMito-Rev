package com.navatics.app.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.p008v4.view.InputDeviceCompat;
import com.navatics.app.framework.annotation.SearchState;
import com.navatics.app.framework.p050b.C2188l;
import com.navatics.app.framework.user.NvUser;
import com.navatics.app.framework.user.NvUserManager;
import com.navatics.app.framework.user.SSUsrInfo;
import com.navatics.robot.transport.AbstractC2857t;
import com.navatics.robot.transport.C2830m;
import com.navatics.robot.transport.C2831n;
import com.navatics.robot.transport.InterfaceC2818e;
import com.navatics.robot.transport.InterfaceC2823j;
import com.navatics.robot.transport.InterfaceC2833p;
import com.navatics.robot.transport.NvBatteryInfo;
import com.navatics.robot.transport.NvDeviceInfo;
import com.navatics.robot.transport.p063b.InterfaceC2803d;
import com.navatics.robot.utils.C2905n;
import com.navatics.xlog.WLog;
import com.takisoft.fix.support.p069v7.preference.PreferenceFragmentCompatDividers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.log4j.Logger;

/* compiled from: GroundStation.java */
/* renamed from: com.navatics.app.framework.g */
/* loaded from: classes.dex */
public class C2326g implements InterfaceC2833p {

    /* renamed from: a */
    private static final String f4649a = "g";

    /* renamed from: b */
    private static final Logger f4650b = Logger.m1561a(C2326g.class);

    /* renamed from: c */
    private InterfaceC2818e f4651c;

    /* renamed from: d */
    private NvUser f4652d;

    /* renamed from: f */
    private int f4653f;

    /* renamed from: h */
    private AbstractC2362s f4654h;

    /* renamed from: r */
    private C2188l f4655r;

    /* renamed from: s */
    private boolean f4656s;

    /* renamed from: t */
    private boolean f4657t;

    /* renamed from: u */
    private boolean f4658u;

    /* renamed from: v */
    private boolean f4659v;

    /* renamed from: e */
    private C2334i f4660e = new C2334i(this);

    /* renamed from: g */
    private NvBatteryInfo f4661g = new NvBatteryInfo();

    /* renamed from: i */
    private List f4662i = new ArrayList();

    /* renamed from: j */
    private HashMap f4663j = new HashMap();

    /* renamed from: k */
    private List f4664k = new CopyOnWriteArrayList();

    /* renamed from: l */
    private HashMap f4665l = new HashMap();

    /* renamed from: m */
    private List f4666m = new ArrayList();

    /* renamed from: n */
    private List f4667n = new ArrayList();

    /* renamed from: o */
    private List f4668o = new ArrayList();

    /* renamed from: p */
    private List f4669p = new ArrayList();
    @SearchState

    /* renamed from: q */
    private int f4670q = 2;

    public static /* synthetic */ void lambda$5TCDHtbJo04F1lQlhMWznJXMP_c(C2326g c2326g, InterfaceC2333h interfaceC2333h) {
        c2326g.m8120c(interfaceC2333h);
    }

    public static /* synthetic */ void lambda$theq5WPtZDBqAvuS5eYHPQ0K7R0(C2326g c2326g, InterfaceC2384x interfaceC2384x) {
        c2326g.m8118c(interfaceC2384x);
    }

    /* renamed from: n */
    public void m8098n() {
    }

    /* renamed from: o */
    public void m8097o() {
    }

    public C2326g(InterfaceC2818e interfaceC2818e) {
        this.f4651c = interfaceC2818e;
        this.f4651c.mo6179a(this);
        this.f4653f = 0;
        this.f4655r = new C2188l();
        m8090v();
    }

    /* renamed from: a */
    public C2188l m8147a() {
        return this.f4655r;
    }

    /* renamed from: v */
    private void m8090v() {
        Context m7936e = C2353p.m7936e();
        SharedPreferences sharedPreferences = m7936e.getSharedPreferences("developer_setting", 0);
        this.f4656s = sharedPreferences.getBoolean("enableAuth", m7936e.getResources().getBoolean(R.bool.enable_auth));
        this.f4657t = sharedPreferences.getBoolean("controllerAutoLogin", m7936e.getResources().getBoolean(R.bool.controller_auto_login));
        this.f4658u = sharedPreferences.getBoolean("rollerAutoLogin", m7936e.getResources().getBoolean(R.bool.roller_auto_login));
        this.f4659v = sharedPreferences.getBoolean("enableAutoConn", m7936e.getResources().getBoolean(R.bool.enable_auto_connect));
    }

    @NonNull
    public String toString() {
        return "GroundStation[id=" + this.f4651c.mo6189a() + "]";
    }

    /* renamed from: b */
    public long m8130b() {
        return this.f4651c.mo6189a();
    }

    /* renamed from: c */
    public boolean m8121c() {
        return this.f4651c.mo6088n();
    }

    /* renamed from: d */
    public boolean m8114d() {
        return this.f4651c.mo6086o();
    }

    /* renamed from: e */
    public boolean m8110e() {
        return this.f4651c.mo6094k();
    }

    /* renamed from: a */
    public void m8132a(Map map) {
        this.f4651c.mo6137a(map);
        m8088x();
    }

    /* renamed from: b */
    public void m8122b(Map map) {
        this.f4651c.mo6123b(map);
        m8088x();
    }

    /* renamed from: c */
    public void m8115c(Map map) {
        this.f4651c.mo6112c(map);
    }

    /* renamed from: w */
    private SSUsrInfo m8089w() {
        NvUser user = NvUserManager.m7829b().getUser();
        if (user == null) {
            f4650b.log((Object) "user is null");
            return null;
        } else if (user.getSsUsrInfo() == null) {
            f4650b.log((Object) "user doesn't have ss info");
            return null;
        } else {
            return user.getSsUsrInfo().getTarget();
        }
    }

    /* renamed from: f */
    public void m8107f() {
        SSUsrInfo m8089w = m8089w();
        if (m8089w == null) {
            f4650b.log((Object) "ssUsrInfo is null");
            m8145a(16711686, new C2830m(49, "ss usr info is empty", this.f4651c));
            return;
        }
        String serialNumber = m8105g().getSerialNumber();
        String uuid = m8089w.getUuid();
        String accessToken = m8089w.getAccessToken();
        HashMap hashMap = new HashMap();
        hashMap.put("sn", serialNumber);
        hashMap.put("uuid", uuid);
        hashMap.put("access_token", accessToken);
        this.f4651c.mo6112c(hashMap);
    }

    /* renamed from: a */
    public void m8144a(long j) {
        this.f4651c.mo6184a(j);
    }

    /* renamed from: a */
    public void m8139a(NvUser nvUser) {
        this.f4652d = nvUser;
    }

    /* renamed from: g */
    public NvDeviceInfo m8105g() {
        return this.f4651c.mo6136b();
    }

    /* renamed from: h */
    public C2334i m8104h() {
        return this.f4660e;
    }

    /* renamed from: i */
    public int m8103i() {
        return this.f4653f;
    }

    /* renamed from: x */
    private void m8088x() {
        m8131a(false);
    }

    /* renamed from: a */
    private synchronized void m8131a(boolean z) {
        if (!this.f4651c.mo6094k()) {
            this.f4653f = -1;
        } else {
            switch (this.f4653f) {
                case 0:
                    if (this.f4651c.mo6098i()) {
                        this.f4653f = 1;
                        break;
                    }
                    break;
                case 1:
                    if (this.f4651c.mo6088n()) {
                        this.f4653f = 4;
                        break;
                    } else if (!this.f4651c.mo6086o()) {
                        this.f4653f = 2;
                        break;
                    } else {
                        this.f4653f = 0;
                        break;
                    }
                case 2:
                    if (this.f4651c.mo6100h()) {
                        this.f4653f = 3;
                        break;
                    }
                    break;
                case 3:
                    if (z) {
                        this.f4653f = 2;
                        break;
                    } else if (this.f4651c.mo6086o()) {
                        this.f4653f = 0;
                        break;
                    }
                    break;
                case 4:
                    if (this.f4651c.mo6096j() || !this.f4662i.isEmpty() || !this.f4666m.isEmpty()) {
                        this.f4653f = 5;
                        break;
                    }
                    break;
                case 5:
                    if (!this.f4651c.mo6096j() && this.f4662i.isEmpty() && this.f4666m.isEmpty()) {
                        this.f4653f = 4;
                        break;
                    }
                    break;
            }
        }
        Logger logger = f4650b;
        logger.mo1497c((Object) ("GND State : " + this.f4653f));
    }

    /* renamed from: a */
    private void m8134a(AbstractC2857t abstractC2857t) {
        if (((AbstractC2362s) this.f4663j.get(abstractC2857t)) == null) {
            f4650b.log((Object) "handleDeviceAuthSuccess can not find connection for socket");
            return;
        }
        C2382v c2382v = (C2382v) this.f4665l.get(abstractC2857t.m6025b().getSerialNumber());
        if (c2382v == null) {
            throw new RuntimeException("wtf?! handleDeviceAuthSuccess can't find NvDeviceEntry");
        }
        this.f4667n.remove(c2382v);
        c2382v.m7737q();
        C2174ag.m8619a().m8617a(abstractC2857t.m6025b());
    }

    /* renamed from: b */
    private void m8124b(AbstractC2857t abstractC2857t) {
        AbstractC2362s abstractC2362s = (AbstractC2362s) this.f4663j.get(abstractC2857t);
        if (abstractC2362s == null) {
            f4650b.log((Object) "handleDeviceAuthSuccess can not find connection for socket");
            return;
        }
        C2382v c2382v = (C2382v) this.f4665l.get(abstractC2857t.m6025b().getSerialNumber());
        if (c2382v == null) {
            throw new RuntimeException("wtf?! handleDeviceAuthSuccess can't find NvDeviceEntry");
        }
        c2382v.m7740n();
        if (this.f4658u) {
            m8141a(abstractC2362s);
        }
    }

    /* renamed from: c */
    private void m8116c(AbstractC2857t abstractC2857t) {
        C2382v c2382v = (C2382v) this.f4665l.get(abstractC2857t.m6025b().getSerialNumber());
        if (c2382v == null) {
            throw new RuntimeException("wtf?! handleDeviceConnected can't find NvDeviceEntry");
        }
        f4650b.mo1508a((Object) "handleDeviceConnected 1");
        C2346m c2346m = new C2346m(this, abstractC2857t);
        this.f4662i.add(c2346m);
        this.f4663j.put(abstractC2857t, c2346m);
        f4650b.mo1508a((Object) "handleDeviceConnected 2");
        this.f4666m.remove(c2382v);
        c2382v.m7754a(c2346m);
        f4650b.mo1508a((Object) "handleDeviceConnected 3");
        if (this.f4654h == null) {
            m8127b(c2346m);
        }
        f4650b.mo1508a((Object) "handleDeviceConnected 4");
        m8141a(c2346m);
    }

    /* renamed from: a */
    private void m8141a(AbstractC2362s abstractC2362s) {
        NvUser user = NvUserManager.m7829b().getUser();
        if (user == null) {
            f4650b.mo1508a((Object) "handlerGNDSTAConnected, no active user now");
            return;
        }
        NvDeviceInfo m7877i = abstractC2362s.m7877i();
        f4650b.mo1508a((Object) "handleDeviceConnected new device");
        f4650b.mo1508a((Object) m7877i.toString());
        if (user.getSsUsrInfo() == null) {
            f4650b.mo1496d("user not bind to sensethink account");
            m8145a(16711681, new C2830m(255, "user not bind to sensethink account"));
            return;
        }
        SSUsrInfo target = user.getSsUsrInfo().getTarget();
        if (target == null) {
            f4650b.mo1496d("user not bind to sensethink account or db is corrupt.");
            m8145a(16711681, new C2830m(255, "user not bind to sensethink account or db is corrupt."));
        } else if (C2905n.m5850a((CharSequence) target.uuid)) {
            f4650b.mo1496d("user sensethink uuid is null");
            m8145a(16711681, new C2830m(255, "user sensethink uuid is null."));
        } else {
            C2382v c2382v = (C2382v) this.f4665l.get(abstractC2362s.m7877i().getSerialNumber());
            if (c2382v == null) {
                throw new RuntimeException("wtf?! handleDeviceConnected can't find NvDeviceEntry");
            }
            c2382v.m7738p();
            this.f4667n.add(c2382v);
            HashMap hashMap = new HashMap();
            hashMap.put("uuid", target.uuid);
            abstractC2362s.m7893a(hashMap);
        }
    }

    /* renamed from: a */
    public InterfaceC2823j m8143a(Context context) {
        return this.f4651c.mo6183a(context);
    }

    /* renamed from: d */
    private void m8111d(AbstractC2857t abstractC2857t) {
        AbstractC2362s abstractC2362s = (AbstractC2362s) this.f4663j.get(abstractC2857t);
        if (abstractC2362s == null) {
            f4650b.log((Object) "handleDeviceDisConnected can not find connection for socket");
            return;
        }
        C2382v c2382v = (C2382v) this.f4665l.get(abstractC2857t.m6025b().getSerialNumber());
        if (c2382v == null) {
            f4650b.log((Object) "handleDeviceDisConnected can't find NvDeviceEntry");
            return;
        }
        if (abstractC2362s == this.f4654h) {
            m8127b((AbstractC2362s) null);
        }
        this.f4662i.remove(abstractC2362s);
        this.f4663j.remove(abstractC2857t);
        this.f4665l.remove(abstractC2857t.m6025b().getSerialNumber());
        this.f4668o.remove(c2382v);
        c2382v.m7736r();
        m8119c(abstractC2362s);
        abstractC2362s.mo7892b();
        List<AbstractC2857t> mo6090m = this.f4651c.mo6090m();
        if (mo6090m == null || mo6090m.isEmpty()) {
            WLog.m5839i(f4649a, "enter search because of device disconnect");
            m8100l();
            return;
        }
        throw new RuntimeException("Oops! Shouldn't reach here, please check your code");
    }

    /* renamed from: y */
    private void m8087y() {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7726c(this);
        }
        List<AbstractC2857t> mo6090m = this.f4651c.mo6090m();
        if (mo6090m == null || mo6090m.isEmpty()) {
            f4650b.mo1508a((Object) "we don't have a active conn");
            m8100l();
            return;
        }
        for (AbstractC2857t abstractC2857t : mo6090m) {
            NvDeviceInfo m6025b = abstractC2857t.m6025b();
            String serialNumber = m6025b.getSerialNumber();
            C2382v c2382v = new C2382v(this, m6025b);
            this.f4665l.put(serialNumber, c2382v);
            this.f4668o.add(c2382v);
            m8116c(abstractC2857t);
        }
    }

    /* renamed from: z */
    private void m8086z() {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7731a(this);
        }
        if (this.f4657t) {
            C2353p.m7955a(this);
        }
    }

    /* renamed from: A */
    private void m8153A() {
        this.f4655r.m8582a(65566, this);
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7725d(this);
        }
    }

    /* renamed from: e */
    private void m8108e(AbstractC2857t abstractC2857t) {
        AbstractC2362s abstractC2362s = (AbstractC2362s) this.f4663j.get(abstractC2857t);
        if (abstractC2362s == null) {
            f4650b.log((Object) "handleDeviceUnbindSuccess can not find connection for socket");
            return;
        }
        C2382v c2382v = (C2382v) this.f4665l.get(abstractC2857t.m6025b().getSerialNumber());
        if (c2382v == null) {
            throw new RuntimeException("wtf?! handleDeviceUnbindSuccess can't find NvDeviceEntry");
        }
        c2382v.m7739o();
        abstractC2362s.m7869q();
        abstractC2362s.m7875k();
    }

    /* renamed from: b */
    private void m8127b(AbstractC2362s abstractC2362s) {
        AbstractC2362s abstractC2362s2 = this.f4654h;
        if (abstractC2362s2 != null) {
            abstractC2362s2.m7878h();
        } else {
            abstractC2362s2 = null;
        }
        this.f4654h = abstractC2362s;
        AbstractC2362s abstractC2362s3 = this.f4654h;
        if (abstractC2362s3 != null) {
            abstractC2362s3.m7879g();
        }
        m8140a(abstractC2362s2, this.f4654h);
    }

    /* renamed from: a */
    private void m8140a(AbstractC2362s abstractC2362s, AbstractC2362s abstractC2362s2) {
        this.f4655r.m8576b(196610, abstractC2362s, abstractC2362s2);
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7508a(this, abstractC2362s, abstractC2362s2);
        }
    }

    /* renamed from: a */
    public AbstractC2362s m8133a(String str) {
        for (AbstractC2362s abstractC2362s : this.f4662i) {
            if (abstractC2362s.m7877i().getSerialNumber().equals(str)) {
                return abstractC2362s;
            }
        }
        return null;
    }

    /* renamed from: b */
    public AbstractC2362s m8129b(long j) {
        for (AbstractC2362s abstractC2362s : this.f4662i) {
            if (abstractC2362s.m7882e() == j) {
                return abstractC2362s;
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m8142a(final InterfaceC2333h interfaceC2333h) {
        if (interfaceC2333h == null) {
            throw new RuntimeException("handle is null");
        }
        this.f4669p.add(interfaceC2333h);
        if (interfaceC2333h instanceof AbstractC2176b) {
            ((AbstractC2176b) interfaceC2333h).m6324a(new InterfaceC2803d() { // from class: com.navatics.app.framework.-$$Lambda$g$5TCDHtbJo04F1lQlhMWznJXMP_c
                @Override // com.navatics.robot.transport.p063b.InterfaceC2803d
                public final void run() {
                    C2326g.lambda$5TCDHtbJo04F1lQlhMWznJXMP_c(C2326g.this, interfaceC2333h);
                }
            });
        }
        if (this.f4668o.isEmpty()) {
            return;
        }
        interfaceC2333h.mo8063a(this.f4668o);
    }

    /* renamed from: b */
    public void m8120c(InterfaceC2333h interfaceC2333h) {
        this.f4669p.remove(interfaceC2333h);
    }

    /* renamed from: a */
    public void m8138a(final InterfaceC2384x interfaceC2384x) {
        if (interfaceC2384x == null) {
            throw new RuntimeException("handle is null");
        }
        this.f4664k.add(interfaceC2384x);
        if (interfaceC2384x instanceof AbstractC2208c) {
            ((AbstractC2208c) interfaceC2384x).m6324a(new InterfaceC2803d() { // from class: com.navatics.app.framework.-$$Lambda$g$theq5WPtZDBqAvuS5eYHPQ0K7R0
                @Override // com.navatics.robot.transport.p063b.InterfaceC2803d
                public final void run() {
                    C2326g.lambda$theq5WPtZDBqAvuS5eYHPQ0K7R0(C2326g.this, interfaceC2384x);
                }
            });
        }
        Logger logger = f4650b;
        logger.mo1508a((Object) ("1 notifySearchStateChanged " + this.f4670q));
        interfaceC2384x.mo7730a(this, this.f4670q);
        for (C2382v c2382v : this.f4668o) {
            if (c2382v.m7744j() == 2) {
                interfaceC2384x.mo7507a(this, c2382v.m7758a());
            }
        }
        for (C2382v c2382v2 : this.f4668o) {
            if (c2382v2.m7744j() == 7) {
                interfaceC2384x.mo7508a(this, (AbstractC2362s) null, c2382v2.m7735s());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m8118c(InterfaceC2384x interfaceC2384x) {
        this.f4664k.remove(interfaceC2384x);
    }

    /* renamed from: j */
    public boolean m8102j() {
        for (AbstractC2362s abstractC2362s : this.f4662i) {
            if (abstractC2362s.m7876j()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public void m8101k() {
        for (InterfaceC2333h interfaceC2333h : this.f4669p) {
            interfaceC2333h.mo8063a(this.f4668o);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m8123b(String str) {
        C2382v c2382v = (C2382v) this.f4665l.get(str);
        if (c2382v == null) {
            f4650b.log((Object) "onItemBinding item is null");
        } else {
            c2382v.m7741m();
        }
    }

    /* renamed from: b */
    private void m8125b(C2831n c2831n) {
        switch (c2831n.f6562b) {
            case 65538:
                if (m8102j() || m8091u()) {
                    return;
                }
                m8100l();
                return;
            case PreferenceFragmentCompatDividers.DIVIDER_DEFAULT /* 65539 */:
                List<NvDeviceInfo> list = (List) c2831n.f6566f;
                if (list == null) {
                    list = new ArrayList();
                }
                long currentTimeMillis = System.currentTimeMillis();
                boolean z = false;
                for (NvDeviceInfo nvDeviceInfo : list) {
                    String serialNumber = nvDeviceInfo.getSerialNumber();
                    C2382v c2382v = (C2382v) this.f4665l.get(serialNumber);
                    if (c2382v == null) {
                        Logger logger = f4650b;
                        logger.mo1497c((Object) ("new device : " + nvDeviceInfo));
                        c2382v = new C2382v(this, nvDeviceInfo);
                        this.f4665l.put(serialNumber, c2382v);
                        this.f4668o.add(c2382v);
                        z = true;
                    }
                    c2382v.m7755a(currentTimeMillis);
                }
                Iterator it = this.f4668o.iterator();
                while (it.hasNext()) {
                    C2382v c2382v2 = (C2382v) it.next();
                    if (c2382v2.m7753b() && currentTimeMillis - c2382v2.m7734t() > 5000) {
                        String serialNumber2 = c2382v2.m7758a().getSerialNumber();
                        Logger logger2 = f4650b;
                        logger2.mo1496d("remove inactive device : " + serialNumber2);
                        this.f4665l.remove(serialNumber2);
                        it.remove();
                        z = true;
                    }
                }
                if (z) {
                    m8101k();
                }
                NvDeviceInfo m8603j = C2174ag.m8619a().m8603j();
                if (!this.f4659v || m8603j == null) {
                    return;
                }
                C2382v c2382v3 = (C2382v) this.f4665l.get(m8603j.getSerialNumber());
                if (c2382v3 == null || !c2382v3.m7753b()) {
                    return;
                }
                f4650b.mo1508a((Object) "we found one idle item we met before, initialize the connection to it");
                m8135a(c2382v3.m7758a(), null, false);
                return;
            default:
                return;
        }
    }

    /* renamed from: B */
    private void m8152B() {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7727b(this);
        }
    }

    /* renamed from: C */
    private void m8151C() {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7728a(this.f4651c.mo6136b());
        }
    }

    /* renamed from: a */
    private void m8146a(@SearchState int i) {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7730a(this, i);
        }
    }

    /* renamed from: a */
    private void m8137a(NvDeviceInfo nvDeviceInfo) {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7507a(this, nvDeviceInfo);
        }
    }

    /* renamed from: c */
    private void m8119c(AbstractC2362s abstractC2362s) {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7505b(this, abstractC2362s);
        }
    }

    /* renamed from: l */
    public void m8100l() {
        if (this.f4651c.mo6094k()) {
            this.f4651c.mo6102g();
            m8088x();
        }
    }

    /* renamed from: a */
    public void m8136a(NvDeviceInfo nvDeviceInfo, Map map) {
        m8135a(nvDeviceInfo, map, true);
    }

    /* renamed from: a */
    public void m8135a(NvDeviceInfo nvDeviceInfo, Map map, boolean z) {
        if (!nvDeviceInfo.isValid()) {
            f4650b.log((Object) ("NvDeviceInfo is not valid : " + nvDeviceInfo));
        } else if (!this.f4666m.isEmpty() && m8092t() < 2) {
            f4650b.log((Object) "The underlying ground station implementation only allow to connect to 1 device at the same time. ");
        } else {
            C2382v c2382v = (C2382v) this.f4665l.get(nvDeviceInfo.getSerialNumber());
            if (c2382v == null) {
                String str = "connect met unknown device : " + nvDeviceInfo.getSerialNumber();
                f4650b.log((Object) str);
                if (z) {
                    m8145a(16711681, new C2830m(56, str, nvDeviceInfo));
                }
            } else if (!this.f4651c.mo6094k()) {
                f4650b.log((Object) "connect : GroundStation is already invalid.");
            } else if (this.f4666m.contains(c2382v)) {
                f4650b.mo1496d("trying to connect to device already in connecting list : " + nvDeviceInfo.getSerialNumber());
            } else {
                this.f4666m.add(c2382v);
                c2382v.m7742l();
                m8088x();
                m8137a(nvDeviceInfo);
                this.f4651c.mo6180a(nvDeviceInfo, map);
            }
        }
    }

    /* renamed from: m */
    public AbstractC2362s m8099m() {
        return this.f4654h;
    }

    /* renamed from: p */
    public NvBatteryInfo m8096p() {
        return this.f4661g;
    }

    /* renamed from: q */
    public int m8095q() {
        return this.f4651c.mo6122c();
    }

    /* renamed from: r */
    public int m8094r() {
        return this.f4651c.mo6111d();
    }

    /* renamed from: s */
    public int m8093s() {
        return this.f4651c.mo6106e();
    }

    /* renamed from: t */
    public int m8092t() {
        return this.f4651c.mo6092l();
    }

    /* renamed from: u */
    public boolean m8091u() {
        return !this.f4666m.isEmpty();
    }

    /* renamed from: c */
    private void m8117c(C2831n c2831n) {
        int i = c2831n.f6562b;
        if (i != 65549) {
            switch (i) {
                case 65537:
                    this.f4670q = 0;
                    Logger logger = f4650b;
                    logger.mo1508a((Object) ("2 notifySearchStateChanged " + this.f4670q));
                    m8146a(this.f4670q);
                    m8125b(c2831n);
                    return;
                case 65538:
                    this.f4670q = 2;
                    Logger logger2 = f4650b;
                    logger2.mo1508a((Object) ("3 notifySearchStateChanged " + this.f4670q));
                    m8146a(this.f4670q);
                    m8125b(c2831n);
                    return;
                case PreferenceFragmentCompatDividers.DIVIDER_DEFAULT /* 65539 */:
                    m8125b(c2831n);
                    return;
                case InputDeviceCompat.SOURCE_TRACKBALL /* 65540 */:
                    f4650b.mo1508a((Object) "DEVICE_CONNECTED");
                    m8116c((AbstractC2857t) c2831n.f6566f);
                    return;
                case 65541:
                    f4650b.mo1508a((Object) "DEVICE_DISCONNECTED");
                    m8111d((AbstractC2857t) c2831n.f6566f);
                    return;
                default:
                    switch (i) {
                        case 65543:
                            f4650b.mo1508a((Object) "DEVICE_AUTH_SUCCESS");
                            m8134a((AbstractC2857t) c2831n.f6566f);
                            return;
                        case 65544:
                            f4650b.mo1508a((Object) "DEVICE_BIND_SUCCESS");
                            m8124b((AbstractC2857t) ((C2830m) c2831n.f6566f).m6258c());
                            return;
                        case 65545:
                            f4650b.mo1508a((Object) "GNDSTA_BIND_SUCCESS");
                            m8086z();
                            return;
                        case 65546:
                            f4650b.mo1508a((Object) "GNDSTA_AUTH_SUCCESS");
                            m8087y();
                            return;
                        default:
                            switch (i) {
                                case 65566:
                                    f4650b.mo1508a((Object) "GNDSTA_UNBIND_SUCCESS");
                                    m8153A();
                                    return;
                                case 65567:
                                    f4650b.mo1508a((Object) "DEVICE_UNBIND_SUCCESS");
                                    m8108e((AbstractC2857t) ((C2830m) c2831n.f6566f).m6258c());
                                    return;
                                default:
                                    return;
                            }
                    }
            }
        }
        f4650b.mo1508a((Object) "GNDSTA_DESTROYED");
        m8149E();
    }

    /* renamed from: D */
    private void m8150D() {
        for (AbstractC2362s abstractC2362s : this.f4662i) {
            abstractC2362s.mo7892b();
        }
    }

    /* renamed from: E */
    private void m8149E() {
        m8150D();
        m8151C();
    }

    /* renamed from: d */
    private void m8112d(C2831n c2831n) {
        this.f4661g.setLevel(this.f4651c.mo6104f());
        m8152B();
    }

    /* renamed from: e */
    private void m8109e(C2831n c2831n) {
        if (c2831n.f6562b != 131075) {
            return;
        }
        m8112d(c2831n);
    }

    /* renamed from: f */
    private void m8106f(C2831n c2831n) {
        switch (c2831n.f6562b) {
            case 16711681:
                C2830m c2830m = (C2830m) c2831n.f6566f;
                NvDeviceInfo nvDeviceInfo = (NvDeviceInfo) c2830m.m6258c();
                C2382v c2382v = (C2382v) this.f4665l.get(nvDeviceInfo.getSerialNumber());
                if (c2382v == null) {
                    Logger logger = f4650b;
                    logger.log((Object) ("can't find device for sn " + nvDeviceInfo.getSerialNumber()));
                    return;
                }
                c2382v.m7756a(16711681, c2830m);
                this.f4666m.remove(c2382v);
                f4650b.mo1496d("handleErrorEvent DEVICE_CONN_ERR");
                m8145a(16711681, (C2830m) c2831n.f6566f);
                m8100l();
                return;
            case 16711682:
                f4650b.mo1496d("handleErrorEvent DEVICE_AUTH_ERR");
                C2830m c2830m2 = (C2830m) c2831n.f6566f;
                AbstractC2857t abstractC2857t = (AbstractC2857t) c2830m2.m6258c();
                if (abstractC2857t == null) {
                    f4650b.log((Object) "DEVICE_AUTH_ERR can't get socket from extra of NvError");
                    return;
                }
                AbstractC2362s abstractC2362s = (AbstractC2362s) this.f4663j.get(abstractC2857t);
                if (abstractC2362s == null) {
                    Logger logger2 = f4650b;
                    logger2.log((Object) ("handleErrorEvent can not find connection for socket" + abstractC2857t.m6030a()));
                    return;
                }
                C2382v c2382v2 = (C2382v) this.f4665l.get(abstractC2857t.m6025b().getSerialNumber());
                if (c2382v2 == null) {
                    Logger logger3 = f4650b;
                    logger3.log((Object) ("can't find device for sn " + abstractC2857t.m6025b().getSerialNumber()));
                    return;
                }
                this.f4667n.remove(c2382v2);
                if (c2830m2.m6262a() == 52) {
                    c2382v2.m7739o();
                    m8113d(abstractC2362s);
                    return;
                }
                c2830m2.m6260a(abstractC2857t.m6025b());
                c2382v2.m7756a(16711682, c2830m2);
                return;
            case 16711683:
                f4650b.mo1496d("handleErrorEvent DEVICE_BIND_ERR");
                C2830m c2830m3 = (C2830m) c2831n.f6566f;
                AbstractC2857t abstractC2857t2 = (AbstractC2857t) c2830m3.m6258c();
                if (abstractC2857t2 == null) {
                    f4650b.log((Object) "DEVICE_BIND_ERR can't get socket from extra of NvError");
                    return;
                } else if (((AbstractC2362s) this.f4663j.get(abstractC2857t2)) == null) {
                    Logger logger4 = f4650b;
                    logger4.log((Object) ("handleErrorEvent can not find connection for socket " + abstractC2857t2.m6030a()));
                    return;
                } else {
                    C2382v c2382v3 = (C2382v) this.f4665l.get(abstractC2857t2.m6025b().getSerialNumber());
                    if (c2382v3 == null) {
                        Logger logger5 = f4650b;
                        logger5.log((Object) ("can't find device for sn " + abstractC2857t2.m6025b().getSerialNumber()));
                        return;
                    }
                    f4650b.log((Object) "notify conn bind err");
                    c2382v3.m7756a(16711683, c2830m3);
                    return;
                }
            case 16711684:
            default:
                return;
            case 16711685:
                f4650b.mo1496d("handleErrorEvent GNDSTA_AUTH_ERR");
                if (((C2830m) c2831n.f6566f).m6262a() == 52) {
                    m8148F();
                    return;
                } else {
                    m8145a(16711685, (C2830m) c2831n.f6566f);
                    return;
                }
            case 16711686:
                m8145a(16711686, (C2830m) c2831n.f6566f);
                return;
            case 16711687:
                C2830m c2830m4 = (C2830m) c2831n.f6566f;
                this.f4655r.m8582a(16711687, this, c2830m4);
                m8145a(16711687, c2830m4);
                return;
            case 16711688:
                C2830m c2830m5 = (C2830m) c2831n.f6566f;
                AbstractC2857t abstractC2857t3 = (AbstractC2857t) c2830m5.m6258c();
                if (abstractC2857t3 == null) {
                    f4650b.log((Object) "DEVICE_AUTH_ERR can't get socket from extra of NvError");
                    return;
                }
                AbstractC2362s abstractC2362s2 = (AbstractC2362s) this.f4663j.get(abstractC2857t3);
                if (abstractC2362s2 == null) {
                    Logger logger6 = f4650b;
                    logger6.log((Object) ("handleErrorEvent can not find connection for socket" + abstractC2857t3.m6030a()));
                    return;
                }
                abstractC2362s2.m7894a(c2830m5);
                return;
        }
    }

    /* renamed from: F */
    private void m8148F() {
        C2353p.m7947b(this);
    }

    /* renamed from: d */
    private void m8113d(AbstractC2362s abstractC2362s) {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7509a(this, abstractC2362s);
        }
    }

    /* renamed from: a */
    private void m8145a(int i, C2830m c2830m) {
        for (InterfaceC2384x interfaceC2384x : this.f4664k) {
            interfaceC2384x.mo7729a(this, i, c2830m);
        }
    }

    /* renamed from: a */
    public void mo6228a(C2831n c2831n) {
        m8088x();
        int i = c2831n.f6561a;
        if (i != 255) {
            switch (i) {
                case 1:
                    m8117c(c2831n);
                    return;
                case 2:
                    m8109e(c2831n);
                    return;
                default:
                    return;
            }
        }
        m8106f(c2831n);
    }
}
