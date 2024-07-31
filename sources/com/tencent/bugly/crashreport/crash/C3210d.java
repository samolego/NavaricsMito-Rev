package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.info.C2420b;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2500y;
import com.tencent.bugly.proguard.C2503z;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.d */
/* loaded from: classes2.dex */
public final class C2440d {

    /* renamed from: a */
    private static C2440d f7451a;

    /* renamed from: b */
    private C2422a f7452b;

    /* renamed from: c */
    private C2419a f7453c;

    /* renamed from: d */
    private C2435b f7454d;

    /* renamed from: e */
    private Context f7455e;

    /* renamed from: a */
    static /* synthetic */ void m5320a(C2440d c2440d) {
        C2499x.m5085c("[ExtraCrashManager] Trying to notify Bugly agents.", new Object[0]);
        try {
            Class<?> cls = Class.forName("com.tencent.bugly.agent.GameAgent");
            String str = "com.tencent.bugly";
            c2440d.f7453c.getClass();
            if (!"".equals("")) {
                str = "com.tencent.bugly.";
            }
            C2503z.m5046a(cls, "sdkPackageName", str, (Object) null);
            C2499x.m5085c("[ExtraCrashManager] Bugly game agent has been notified.", new Object[0]);
        } catch (Throwable unused) {
            C2499x.m5090a("[ExtraCrashManager] no game agent", new Object[0]);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m5319a(C2440d c2440d, Thread thread, int i, String str, String str2, String str3, Map map) {
        String str4;
        String str5;
        String str6;
        if (thread == null) {
            thread = Thread.currentThread();
        }
        switch (i) {
            case 4:
                str4 = "Unity";
                break;
            case 5:
            case 6:
                str4 = "Cocos";
                break;
            case 7:
            default:
                C2499x.m5084d("[ExtraCrashManager] Unknown extra crash type: %d", Integer.valueOf(i));
                return;
            case 8:
                str4 = "H5";
                break;
        }
        String str7 = str4;
        C2499x.m5083e("[ExtraCrashManager] %s Crash Happen", str7);
        try {
            if (!c2440d.f7452b.m5392b()) {
                C2499x.m5084d("[ExtraCrashManager] There is no remote strategy, but still store it.", new Object[0]);
            }
            StrategyBean m5390c = c2440d.f7452b.m5390c();
            if (!m5390c.f7292g && c2440d.f7452b.m5392b()) {
                C2499x.m5083e("[ExtraCrashManager] Crash report was closed by remote , will not upload to Bugly , print local for helpful!", new Object[0]);
                String m5062a = C2503z.m5062a();
                String str8 = c2440d.f7453c.f7258d;
                String name = thread.getName();
                C2435b.m5357a(str7, m5062a, str8, name, str + "\n" + str2 + "\n" + str3, null);
                C2499x.m5083e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                return;
            }
            switch (i) {
                case 5:
                case 6:
                    if (!m5390c.f7297l) {
                        C2499x.m5083e("[ExtraCrashManager] %s report is disabled.", str7);
                        C2499x.m5083e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                        return;
                    }
                    break;
                case 8:
                    if (!m5390c.f7298m) {
                        C2499x.m5083e("[ExtraCrashManager] %s report is disabled.", str7);
                        C2499x.m5083e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                        return;
                    }
                    break;
            }
            if (i == 8) {
                i = 5;
            }
            CrashDetailBean crashDetailBean = new CrashDetailBean();
            crashDetailBean.f7329C = C2420b.m5414k();
            crashDetailBean.f7330D = C2420b.m5418i();
            crashDetailBean.f7331E = C2420b.m5410m();
            crashDetailBean.f7332F = c2440d.f7453c.m5446p();
            crashDetailBean.f7333G = c2440d.f7453c.m5447o();
            crashDetailBean.f7334H = c2440d.f7453c.m5445q();
            crashDetailBean.f7372w = C2503z.m5056a(c2440d.f7455e, C2437c.f7423e, (String) null);
            crashDetailBean.f7351b = i;
            crashDetailBean.f7354e = c2440d.f7453c.m5454h();
            crashDetailBean.f7355f = c2440d.f7453c.f7264j;
            crashDetailBean.f7356g = c2440d.f7453c.m5439w();
            crashDetailBean.f7362m = c2440d.f7453c.m5456g();
            crashDetailBean.f7363n = str;
            crashDetailBean.f7364o = str2;
            str5 = "";
            if (str3 != null) {
                String[] split = str3.split("\n");
                str5 = split.length > 0 ? split[0] : "";
                str6 = str3;
            } else {
                str6 = "";
            }
            crashDetailBean.f7365p = str5;
            crashDetailBean.f7366q = str6;
            crashDetailBean.f7367r = System.currentTimeMillis();
            crashDetailBean.f7370u = C2503z.m5023b(crashDetailBean.f7366q.getBytes());
            crashDetailBean.f7375z = C2503z.m5060a(C2437c.f7424f, false);
            crashDetailBean.f7327A = c2440d.f7453c.f7258d;
            crashDetailBean.f7328B = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f7335I = c2440d.f7453c.m5437y();
            crashDetailBean.f7357h = c2440d.f7453c.m5440v();
            crashDetailBean.f7339M = c2440d.f7453c.f7230a;
            crashDetailBean.f7340N = c2440d.f7453c.m5476a();
            crashDetailBean.f7342P = c2440d.f7453c.m5489H();
            crashDetailBean.f7343Q = c2440d.f7453c.m5488I();
            crashDetailBean.f7344R = c2440d.f7453c.m5495B();
            crashDetailBean.f7345S = c2440d.f7453c.m5490G();
            c2440d.f7454d.m5348c(crashDetailBean);
            crashDetailBean.f7374y = C2500y.m5082a();
            if (crashDetailBean.f7341O == null) {
                crashDetailBean.f7341O = new LinkedHashMap();
            }
            if (map != null) {
                crashDetailBean.f7341O.putAll(map);
            }
            String m5062a2 = C2503z.m5062a();
            String str9 = c2440d.f7453c.f7258d;
            String name2 = thread.getName();
            C2435b.m5357a(str7, m5062a2, str9, name2, str + "\n" + str2 + "\n" + str3, crashDetailBean);
            if (!c2440d.f7454d.m5361a(crashDetailBean)) {
                c2440d.f7454d.m5359a(crashDetailBean, 3000L, false);
            }
            C2499x.m5083e("[ExtraCrashManager] Successfully handled.", new Object[0]);
        } catch (Throwable th) {
            try {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
                C2499x.m5083e("[ExtraCrashManager] Successfully handled.", new Object[0]);
            } catch (Throwable th2) {
                C2499x.m5083e("[ExtraCrashManager] Successfully handled.", new Object[0]);
                throw th2;
            }
        }
    }

    private C2440d(Context context) {
        C2437c m5343a = C2437c.m5343a();
        if (m5343a == null) {
            return;
        }
        this.f7452b = C2422a.m5399a();
        this.f7453c = C2419a.m5474a(context);
        this.f7454d = m5343a.f7435p;
        this.f7455e = context;
        C2497w.m5098a().m5097a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.1
            @Override // java.lang.Runnable
            public final void run() {
                C2440d.m5320a(C2440d.this);
            }
        });
    }

    /* renamed from: a */
    public static C2440d m5321a(Context context) {
        if (f7451a == null) {
            f7451a = new C2440d(context);
        }
        return f7451a;
    }

    /* renamed from: a */
    public static void m5318a(final Thread thread, final int i, final String str, final String str2, final String str3, final Map<String, String> map) {
        C2497w.m5098a().m5097a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.d.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    if (C2440d.f7451a != null) {
                        C2440d.m5319a(C2440d.f7451a, thread, i, str, str2, str3, map);
                    } else {
                        C2499x.m5083e("[ExtraCrashManager] Extra crash manager has not been initialized.", new Object[0]);
                    }
                } catch (Throwable th) {
                    if (!C2499x.m5086b(th)) {
                        th.printStackTrace();
                    }
                    C2499x.m5083e("[ExtraCrashManager] Crash error %s %s %s", str, str2, str3);
                }
            }
        });
    }
}
