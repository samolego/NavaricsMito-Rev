package com.tencent.bugly.crashreport.common.strategy;

import android.content.Context;
import com.tencent.bugly.AbstractC2403a;
import com.tencent.bugly.crashreport.biz.C2415b;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.proguard.C2466ap;
import com.tencent.bugly.proguard.C2486p;
import com.tencent.bugly.proguard.C2489r;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import com.tencent.bugly.proguard.InterfaceC2485o;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.strategy.a */
/* loaded from: classes2.dex */
public final class C2422a {

    /* renamed from: a */
    public static int f7311a = 1000;

    /* renamed from: b */
    private static C2422a f7312b;

    /* renamed from: h */
    private static String f7313h;

    /* renamed from: c */
    private final List<AbstractC2403a> f7314c;

    /* renamed from: g */
    private Context f7318g;

    /* renamed from: f */
    private StrategyBean f7317f = null;

    /* renamed from: e */
    private final StrategyBean f7316e = new StrategyBean();

    /* renamed from: d */
    private final C2497w f7315d = C2497w.m5098a();

    /* renamed from: e */
    static /* synthetic */ String m5388e() {
        return null;
    }

    private C2422a(Context context, List<AbstractC2403a> list) {
        this.f7318g = context;
        this.f7314c = list;
    }

    /* renamed from: a */
    public static synchronized C2422a m5397a(Context context, List<AbstractC2403a> list) {
        C2422a c2422a;
        synchronized (C2422a.class) {
            if (f7312b == null) {
                f7312b = new C2422a(context, list);
            }
            c2422a = f7312b;
        }
        return c2422a;
    }

    /* renamed from: a */
    public final void m5398a(long j) {
        this.f7315d.m5096a(new Thread() { // from class: com.tencent.bugly.crashreport.common.strategy.a.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    Map<String, byte[]> m5172a = C2486p.m5175a().m5172a(C2422a.f7311a, (InterfaceC2485o) null, true);
                    if (m5172a != null) {
                        byte[] bArr = m5172a.get("device");
                        byte[] bArr2 = m5172a.get("gateway");
                        if (bArr != null) {
                            C2419a.m5474a(C2422a.this.f7318g).m5459e(new String(bArr));
                        }
                        if (bArr2 != null) {
                            C2419a.m5474a(C2422a.this.f7318g).m5461d(new String(bArr2));
                        }
                    }
                    C2422a c2422a = C2422a.this;
                    C2422a c2422a2 = C2422a.this;
                    c2422a.f7317f = C2422a.m5389d();
                    if (C2422a.this.f7317f != null && !C2503z.m5043a(C2422a.m5388e()) && C2503z.m5017c(C2422a.m5388e())) {
                        C2422a.this.f7317f.f7303r = C2422a.m5388e();
                        C2422a.this.f7317f.f7304s = C2422a.m5388e();
                    }
                } catch (Throwable th) {
                    if (!C2499x.m5089a(th)) {
                        th.printStackTrace();
                    }
                }
                C2422a c2422a3 = C2422a.this;
                c2422a3.m5396a(c2422a3.f7317f, false);
            }
        }, j);
    }

    /* renamed from: a */
    public static synchronized C2422a m5399a() {
        C2422a c2422a;
        synchronized (C2422a.class) {
            c2422a = f7312b;
        }
        return c2422a;
    }

    /* renamed from: b */
    public final synchronized boolean m5392b() {
        return this.f7317f != null;
    }

    /* renamed from: c */
    public final StrategyBean m5390c() {
        StrategyBean strategyBean = this.f7317f;
        return strategyBean != null ? strategyBean : this.f7316e;
    }

    /* renamed from: a */
    protected final void m5396a(StrategyBean strategyBean, boolean z) {
        C2499x.m5085c("[Strategy] Notify %s", C2415b.class.getName());
        C2415b.m5526a(strategyBean, z);
        for (AbstractC2403a abstractC2403a : this.f7314c) {
            try {
                C2499x.m5085c("[Strategy] Notify %s", abstractC2403a.getClass().getName());
                abstractC2403a.onServerStrategyChanged(strategyBean);
            } catch (Throwable th) {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public final void m5393a(C2466ap c2466ap) {
        if (c2466ap == null) {
            return;
        }
        if (this.f7317f == null || c2466ap.f7609h != this.f7317f.f7301p) {
            StrategyBean strategyBean = new StrategyBean();
            strategyBean.f7292g = c2466ap.f7602a;
            strategyBean.f7294i = c2466ap.f7604c;
            strategyBean.f7293h = c2466ap.f7603b;
            if (C2503z.m5043a((String) null) || !C2503z.m5017c((String) null)) {
                if (C2503z.m5017c(c2466ap.f7605d)) {
                    C2499x.m5085c("[Strategy] Upload url changes to %s", c2466ap.f7605d);
                    strategyBean.f7303r = c2466ap.f7605d;
                }
                if (C2503z.m5017c(c2466ap.f7606e)) {
                    C2499x.m5085c("[Strategy] Exception upload url changes to %s", c2466ap.f7606e);
                    strategyBean.f7304s = c2466ap.f7606e;
                }
            }
            if (c2466ap.f7607f != null && !C2503z.m5043a(c2466ap.f7607f.f7597a)) {
                strategyBean.f7306u = c2466ap.f7607f.f7597a;
            }
            if (c2466ap.f7609h != 0) {
                strategyBean.f7301p = c2466ap.f7609h;
            }
            if (c2466ap.f7608g != null && c2466ap.f7608g.size() > 0) {
                strategyBean.f7307v = c2466ap.f7608g;
                String str = c2466ap.f7608g.get("B11");
                if (str != null && str.equals("1")) {
                    strategyBean.f7295j = true;
                } else {
                    strategyBean.f7295j = false;
                }
                String str2 = c2466ap.f7608g.get("B3");
                if (str2 != null) {
                    strategyBean.f7310y = Long.valueOf(str2).longValue();
                }
                strategyBean.f7302q = c2466ap.f7610i;
                strategyBean.f7309x = c2466ap.f7610i;
                String str3 = c2466ap.f7608g.get("B27");
                if (str3 != null && str3.length() > 0) {
                    try {
                        int parseInt = Integer.parseInt(str3);
                        if (parseInt > 0) {
                            strategyBean.f7308w = parseInt;
                        }
                    } catch (Exception e) {
                        if (!C2499x.m5089a(e)) {
                            e.printStackTrace();
                        }
                    }
                }
                String str4 = c2466ap.f7608g.get("B25");
                if (str4 != null && str4.equals("1")) {
                    strategyBean.f7297l = true;
                } else {
                    strategyBean.f7297l = false;
                }
            }
            C2499x.m5090a("[Strategy] enableCrashReport:%b, enableQuery:%b, enableUserInfo:%b, enableAnr:%b, enableBlock:%b, enableSession:%b, enableSessionTimer:%b, sessionOverTime:%d, enableCocos:%b, strategyLastUpdateTime:%d", Boolean.valueOf(strategyBean.f7292g), Boolean.valueOf(strategyBean.f7294i), Boolean.valueOf(strategyBean.f7293h), Boolean.valueOf(strategyBean.f7295j), Boolean.valueOf(strategyBean.f7296k), Boolean.valueOf(strategyBean.f7299n), Boolean.valueOf(strategyBean.f7300o), Long.valueOf(strategyBean.f7302q), Boolean.valueOf(strategyBean.f7297l), Long.valueOf(strategyBean.f7301p));
            this.f7317f = strategyBean;
            C2486p.m5175a().m5151b(2);
            C2489r c2489r = new C2489r();
            c2489r.f7702b = 2;
            c2489r.f7701a = strategyBean.f7290e;
            c2489r.f7705e = strategyBean.f7291f;
            c2489r.f7707g = C2503z.m5051a(strategyBean);
            C2486p.m5175a().m5159a(c2489r);
            m5396a(strategyBean, true);
        }
    }

    /* renamed from: d */
    public static StrategyBean m5389d() {
        List<C2489r> m5174a = C2486p.m5175a().m5174a(2);
        if (m5174a == null || m5174a.size() <= 0) {
            return null;
        }
        C2489r c2489r = m5174a.get(0);
        if (c2489r.f7707g != null) {
            return (StrategyBean) C2503z.m5033a(c2489r.f7707g, StrategyBean.CREATOR);
        }
        return null;
    }
}
