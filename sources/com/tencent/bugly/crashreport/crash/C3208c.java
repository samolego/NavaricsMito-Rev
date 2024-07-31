package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.AppInfo;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.anr.C2432b;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.C2486p;
import com.tencent.bugly.proguard.C2489r;
import com.tencent.bugly.proguard.C2492u;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import com.tencent.bugly.proguard.InterfaceC2485o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.c */
/* loaded from: classes2.dex */
public final class C2437c {

    /* renamed from: a */
    public static int f7419a = 0;

    /* renamed from: b */
    public static boolean f7420b = false;

    /* renamed from: c */
    public static int f7421c = 2;

    /* renamed from: d */
    public static boolean f7422d = true;

    /* renamed from: e */
    public static int f7423e = 20480;

    /* renamed from: f */
    public static int f7424f = 20480;

    /* renamed from: g */
    public static long f7425g = 604800000;

    /* renamed from: h */
    public static String f7426h = null;

    /* renamed from: i */
    public static boolean f7427i = false;

    /* renamed from: j */
    public static String f7428j = null;

    /* renamed from: k */
    public static int f7429k = 5000;

    /* renamed from: l */
    public static boolean f7430l = true;

    /* renamed from: m */
    public static boolean f7431m = false;

    /* renamed from: n */
    public static String f7432n;

    /* renamed from: o */
    public static String f7433o;

    /* renamed from: r */
    private static C2437c f7434r;

    /* renamed from: p */
    public final C2435b f7435p;

    /* renamed from: q */
    private final Context f7436q;

    /* renamed from: s */
    private final C2443e f7437s;

    /* renamed from: t */
    private final NativeCrashHandler f7438t;

    /* renamed from: u */
    private C2422a f7439u;

    /* renamed from: v */
    private C2497w f7440v;

    /* renamed from: w */
    private final C2432b f7441w;

    /* renamed from: x */
    private Boolean f7442x;

    private C2437c(int i, Context context, C2497w c2497w, boolean z, BuglyStrategy.C2402a c2402a, InterfaceC2485o interfaceC2485o, String str) {
        f7419a = i;
        Context m5057a = C2503z.m5057a(context);
        this.f7436q = m5057a;
        this.f7439u = C2422a.m5399a();
        this.f7440v = c2497w;
        this.f7435p = new C2435b(i, m5057a, C2492u.m5135a(), C2486p.m5175a(), this.f7439u, c2402a, interfaceC2485o);
        C2419a m5474a = C2419a.m5474a(m5057a);
        this.f7437s = new C2443e(m5057a, this.f7435p, this.f7439u, m5474a);
        this.f7438t = NativeCrashHandler.getInstance(m5057a, m5474a, this.f7435p, this.f7439u, c2497w, z, str);
        m5474a.f7207D = this.f7438t;
        this.f7441w = new C2432b(m5057a, this.f7439u, m5474a, c2497w, this.f7435p);
    }

    /* renamed from: a */
    public static synchronized C2437c m5342a(int i, Context context, boolean z, BuglyStrategy.C2402a c2402a, InterfaceC2485o interfaceC2485o, String str) {
        C2437c c2437c;
        synchronized (C2437c.class) {
            if (f7434r == null) {
                f7434r = new C2437c(1004, context, C2497w.m5098a(), z, c2402a, null, null);
            }
            c2437c = f7434r;
        }
        return c2437c;
    }

    /* renamed from: a */
    public static synchronized C2437c m5343a() {
        C2437c c2437c;
        synchronized (C2437c.class) {
            c2437c = f7434r;
        }
        return c2437c;
    }

    /* renamed from: a */
    public final void m5340a(StrategyBean strategyBean) {
        this.f7437s.m5316a(strategyBean);
        this.f7438t.onStrategyChanged(strategyBean);
        this.f7441w.m5376a(strategyBean);
        C2497w.m5098a().m5096a(new C24392(), 3000L);
    }

    /* renamed from: b */
    public final boolean m5335b() {
        Boolean bool = this.f7442x;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = C2419a.m5470b().f7258d;
        List<C2489r> m5174a = C2486p.m5175a().m5174a(1);
        ArrayList arrayList = new ArrayList();
        if (m5174a != null && m5174a.size() > 0) {
            for (C2489r c2489r : m5174a) {
                if (str.equals(c2489r.f7703c)) {
                    this.f7442x = true;
                    arrayList.add(c2489r);
                }
            }
            if (arrayList.size() > 0) {
                C2486p.m5175a().m5153a(arrayList);
            }
            return true;
        }
        this.f7442x = false;
        return false;
    }

    /* renamed from: c */
    public final synchronized void m5333c() {
        this.f7437s.m5317a();
        this.f7438t.setUserOpened(true);
        this.f7441w.m5372a(true);
    }

    /* renamed from: d */
    public final synchronized void m5332d() {
        this.f7437s.m5311b();
        this.f7438t.setUserOpened(false);
        this.f7441w.m5372a(false);
    }

    /* renamed from: e */
    public final void m5331e() {
        this.f7437s.m5317a();
    }

    /* renamed from: f */
    public final void m5330f() {
        this.f7438t.setUserOpened(false);
    }

    /* renamed from: g */
    public final void m5329g() {
        this.f7438t.setUserOpened(true);
    }

    /* renamed from: h */
    public final void m5328h() {
        this.f7441w.m5372a(true);
    }

    /* renamed from: i */
    public final void m5327i() {
        this.f7441w.m5372a(false);
    }

    /* renamed from: a */
    public final synchronized void m5336a(boolean z, boolean z2, boolean z3) {
        this.f7438t.testNativeCrash(z, z2, z3);
    }

    /* renamed from: j */
    public final synchronized void m5326j() {
        C2432b c2432b = this.f7441w;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i < 30) {
                C2499x.m5090a("try main sleep for make a test anr! try:%d/30 , kill it if you don't want to wait!", Integer.valueOf(i2));
                C2503z.m5030b(5000L);
                i = i2;
            }
        }
    }

    /* renamed from: k */
    public final boolean m5325k() {
        return this.f7441w.m5377a();
    }

    /* renamed from: a */
    public final void m5337a(final Thread thread, final Throwable th, boolean z, String str, byte[] bArr, final boolean z2) {
        this.f7440v.m5097a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.c.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C2499x.m5085c("post a throwable %b", Boolean.valueOf(r2));
                    C2437c.this.f7437s.m5313a(thread, th, false, r5, r6);
                    if (z2) {
                        C2499x.m5090a("clear user datas", new Object[0]);
                        C2419a.m5474a(C2437c.this.f7436q).m5494C();
                    }
                } catch (Throwable th2) {
                    if (!C2499x.m5086b(th2)) {
                        th2.printStackTrace();
                    }
                    C2499x.m5083e("java catch error: %s", th.toString());
                }
            }
        });
    }

    /* renamed from: a */
    public final void m5339a(CrashDetailBean crashDetailBean) {
        this.f7435p.m5346d(crashDetailBean);
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.c$2 */
    /* loaded from: classes2.dex */
    final class C24392 extends Thread {
        C24392() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            ArrayList arrayList;
            if (C2503z.m5054a(C2437c.this.f7436q, "local_crash_lock", 10000L)) {
                List<CrashDetailBean> m5364a = C2437c.this.f7435p.m5364a();
                if (m5364a != null && m5364a.size() > 0) {
                    C2499x.m5085c("Size of crash list: %s", Integer.valueOf(m5364a.size()));
                    int size = m5364a.size();
                    if (size > 100) {
                        ArrayList arrayList2 = new ArrayList();
                        Collections.sort(m5364a);
                        for (int i = 0; i < 100; i++) {
                            arrayList2.add(m5364a.get((size - 1) - i));
                        }
                        arrayList = arrayList2;
                    } else {
                        arrayList = m5364a;
                    }
                    C2437c.this.f7435p.m5355a(arrayList, 0L, false, false, false);
                }
                C2503z.m5029b(C2437c.this.f7436q, "local_crash_lock");
            }
        }
    }

    /* renamed from: a */
    public final void m5341a(long j) {
        C2497w.m5098a().m5096a(new C24392(), j);
    }

    /* renamed from: l */
    public final void m5324l() {
        this.f7438t.checkUploadRecordCrash();
    }

    /* renamed from: m */
    public final void m5323m() {
        if (C2419a.m5470b().f7258d.equals(AppInfo.m5508a(this.f7436q))) {
            this.f7438t.removeEmptyNativeRecordFiles();
        }
    }
}
