package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C2437c;
import com.tencent.bugly.proguard.C2499x;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class CrashModule extends AbstractC2403a {
    public static final int MODULE_ID = 1004;

    /* renamed from: c */
    private static int f7138c;

    /* renamed from: e */
    private static CrashModule f7139e = new CrashModule();

    /* renamed from: a */
    private long f7140a;

    /* renamed from: b */
    private BuglyStrategy.C2402a f7141b;

    /* renamed from: d */
    private boolean f7142d = false;

    public static CrashModule getInstance() {
        CrashModule crashModule = f7139e;
        crashModule.f7143id = 1004;
        return crashModule;
    }

    public synchronized boolean hasInitialized() {
        return this.f7142d;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x006a A[Catch: all -> 0x0094, TryCatch #0 {, blocks: (B:4:0x0003, B:7:0x0009, B:9:0x003c, B:12:0x0043, B:15:0x0053, B:18:0x005a, B:21:0x006a, B:23:0x0071, B:19:0x0065, B:13:0x004e), top: B:31:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006f  */
    @Override // com.tencent.bugly.AbstractC2403a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void init(android.content.Context r12, boolean r13, com.tencent.bugly.BuglyStrategy r14) {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r12 == 0) goto L97
            boolean r0 = r11.f7142d     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L9
            goto L97
        L9:
            java.lang.String r0 = "Initializing crash module."
            r1 = 0
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.proguard.C2499x.m5090a(r0, r2)     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.proguard.n r0 = com.tencent.bugly.proguard.C2482n.m5191a()     // Catch: java.lang.Throwable -> L94
            int r2 = com.tencent.bugly.CrashModule.f7138c     // Catch: java.lang.Throwable -> L94
            r3 = 1
            int r2 = r2 + r3
            com.tencent.bugly.CrashModule.f7138c = r2     // Catch: java.lang.Throwable -> L94
            r4 = 1004(0x3ec, float:1.407E-42)
            r0.m5189a(r4, r2)     // Catch: java.lang.Throwable -> L94
            r11.f7142d = r3     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.crashreport.CrashReport.setContext(r12)     // Catch: java.lang.Throwable -> L94
            r11.m5553a(r12, r14)     // Catch: java.lang.Throwable -> L94
            r5 = 1004(0x3ec, float:1.407E-42)
            com.tencent.bugly.BuglyStrategy$a r8 = r11.f7141b     // Catch: java.lang.Throwable -> L94
            r9 = 0
            r10 = 0
            r6 = r12
            r7 = r13
            com.tencent.bugly.crashreport.crash.c r13 = com.tencent.bugly.crashreport.crash.C2437c.m5342a(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L94
            r13.m5331e()     // Catch: java.lang.Throwable -> L94
            r13.m5323m()     // Catch: java.lang.Throwable -> L94
            if (r14 == 0) goto L4e
            boolean r0 = r14.isEnableNativeCrashMonitor()     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L43
            goto L4e
        L43:
            java.lang.String r0 = "[crash] Closed native crash monitor!"
            java.lang.Object[] r2 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.proguard.C2499x.m5090a(r0, r2)     // Catch: java.lang.Throwable -> L94
            r13.m5330f()     // Catch: java.lang.Throwable -> L94
            goto L51
        L4e:
            r13.m5329g()     // Catch: java.lang.Throwable -> L94
        L51:
            if (r14 == 0) goto L65
            boolean r0 = r14.isEnableANRCrashMonitor()     // Catch: java.lang.Throwable -> L94
            if (r0 == 0) goto L5a
            goto L65
        L5a:
            java.lang.String r0 = "[crash] Closed ANR monitor!"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.proguard.C2499x.m5090a(r0, r1)     // Catch: java.lang.Throwable -> L94
            r13.m5327i()     // Catch: java.lang.Throwable -> L94
            goto L68
        L65:
            r13.m5328h()     // Catch: java.lang.Throwable -> L94
        L68:
            if (r14 == 0) goto L6f
            long r0 = r14.getAppReportDelay()     // Catch: java.lang.Throwable -> L94
            goto L71
        L6f:
            r0 = 0
        L71:
            r13.m5341a(r0)     // Catch: java.lang.Throwable -> L94
            r13.m5324l()     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.crashreport.crash.C2440d.m5321a(r12)     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver r13 = com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.getInstance()     // Catch: java.lang.Throwable -> L94
            java.lang.String r14 = "android.net.conn.CONNECTIVITY_CHANGE"
            r13.addFilter(r14)     // Catch: java.lang.Throwable -> L94
            r13.register(r12)     // Catch: java.lang.Throwable -> L94
            com.tencent.bugly.proguard.n r12 = com.tencent.bugly.proguard.C2482n.m5191a()     // Catch: java.lang.Throwable -> L94
            int r13 = com.tencent.bugly.CrashModule.f7138c     // Catch: java.lang.Throwable -> L94
            int r13 = r13 - r3
            com.tencent.bugly.CrashModule.f7138c = r13     // Catch: java.lang.Throwable -> L94
            r12.m5189a(r4, r13)     // Catch: java.lang.Throwable -> L94
            monitor-exit(r11)
            return
        L94:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        L97:
            monitor-exit(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    /* renamed from: a */
    private synchronized void m5553a(Context context, BuglyStrategy buglyStrategy) {
        if (buglyStrategy == null) {
            return;
        }
        String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
        if (!TextUtils.isEmpty(libBuglySOFilePath)) {
            C2419a.m5474a(context).f7267m = libBuglySOFilePath;
            C2499x.m5090a("setted libBugly.so file path :%s", libBuglySOFilePath);
        }
        if (buglyStrategy.getCrashHandleCallback() != null) {
            this.f7141b = buglyStrategy.getCrashHandleCallback();
            C2499x.m5090a("setted CrashHanldeCallback", new Object[0]);
        }
        if (buglyStrategy.getAppReportDelay() > 0) {
            this.f7140a = buglyStrategy.getAppReportDelay();
            C2499x.m5090a("setted delay: %d", Long.valueOf(this.f7140a));
        }
    }

    @Override // com.tencent.bugly.AbstractC2403a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        C2437c m5343a;
        if (strategyBean == null || (m5343a = C2437c.m5343a()) == null) {
            return;
        }
        m5343a.m5340a(strategyBean);
    }

    @Override // com.tencent.bugly.AbstractC2403a
    public String[] getTables() {
        return new String[]{"t_cr"};
    }
}
