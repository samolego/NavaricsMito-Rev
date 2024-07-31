package com.tencent.bugly.crashreport.biz;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.biz.C2409a;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.b */
/* loaded from: classes2.dex */
public class C2415b {

    /* renamed from: a */
    public static C2409a f7184a = null;

    /* renamed from: b */
    private static boolean f7185b = false;

    /* renamed from: c */
    private static int f7186c = 10;

    /* renamed from: d */
    private static long f7187d = 300000;

    /* renamed from: e */
    private static long f7188e = 30000;

    /* renamed from: f */
    private static long f7189f = 0;

    /* renamed from: g */
    private static int f7190g = 0;

    /* renamed from: h */
    private static long f7191h = 0;

    /* renamed from: i */
    private static long f7192i = 0;

    /* renamed from: j */
    private static long f7193j = 0;

    /* renamed from: k */
    private static Application.ActivityLifecycleCallbacks f7194k = null;

    /* renamed from: l */
    private static Class<?> f7195l = null;

    /* renamed from: m */
    private static boolean f7196m = true;

    /* renamed from: a */
    static /* synthetic */ String m5525a(String str, String str2) {
        return C2503z.m5062a() + "  " + str + "  " + str2 + "\n";
    }

    /* renamed from: g */
    static /* synthetic */ int m5515g() {
        int i = f7190g;
        f7190g = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0069  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m5519c(android.content.Context r14, com.tencent.bugly.BuglyStrategy r15) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.biz.C2415b.m5519c(android.content.Context, com.tencent.bugly.BuglyStrategy):void");
    }

    /* renamed from: a */
    public static void m5527a(final Context context, final BuglyStrategy buglyStrategy) {
        long j;
        if (f7185b) {
            return;
        }
        f7196m = C2419a.m5474a(context).f7259e;
        f7184a = new C2409a(context, f7196m);
        f7185b = true;
        if (buglyStrategy != null) {
            f7195l = buglyStrategy.getUserInfoActivity();
            j = buglyStrategy.getAppReportDelay();
        } else {
            j = 0;
        }
        if (j <= 0) {
            m5519c(context, buglyStrategy);
        } else {
            C2497w.m5098a().m5096a(new Runnable() { // from class: com.tencent.bugly.crashreport.biz.b.1
                @Override // java.lang.Runnable
                public final void run() {
                    C2415b.m5519c(context, buglyStrategy);
                }
            }, j);
        }
    }

    /* renamed from: a */
    public static void m5529a(long j) {
        if (j < 0) {
            j = C2422a.m5399a().m5390c().f7302q;
        }
        f7189f = j;
    }

    /* renamed from: a */
    public static void m5526a(StrategyBean strategyBean, boolean z) {
        C2497w m5098a;
        C2409a c2409a = f7184a;
        if (c2409a != null && !z && (m5098a = C2497w.m5098a()) != null) {
            m5098a.m5097a(new C2409a.RunnableC24112());
        }
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.f7302q > 0) {
            f7188e = strategyBean.f7302q;
        }
        if (strategyBean.f7308w > 0) {
            f7186c = strategyBean.f7308w;
        }
        if (strategyBean.f7309x > 0) {
            f7187d = strategyBean.f7309x;
        }
    }

    /* renamed from: a */
    public static void m5530a() {
        C2409a c2409a = f7184a;
        if (c2409a != null) {
            c2409a.m5540a(2, false, 0L);
        }
    }

    /* renamed from: a */
    public static void m5528a(Context context) {
        if (!f7185b || context == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 14) {
            Application application = context.getApplicationContext() instanceof Application ? (Application) context.getApplicationContext() : null;
            if (application != null) {
                try {
                    if (f7194k != null) {
                        application.unregisterActivityLifecycleCallbacks(f7194k);
                    }
                } catch (Exception e) {
                    if (!C2499x.m5089a(e)) {
                        e.printStackTrace();
                    }
                }
            }
        }
        f7185b = false;
    }
}
