package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.bugly.crashreport.biz.C2415b;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.info.C2420b;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.proguard.C2492u;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d */
    private static BuglyBroadcastReceiver f7320d;

    /* renamed from: b */
    private Context f7322b;

    /* renamed from: c */
    private String f7323c;

    /* renamed from: e */
    private boolean f7324e = true;

    /* renamed from: a */
    private IntentFilter f7321a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f7320d == null) {
                f7320d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f7320d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.f7321a.hasAction(str)) {
            this.f7321a.addAction(str);
        }
        C2499x.m5085c("add action %s", str);
    }

    public synchronized void register(Context context) {
        this.f7322b = context;
        C2503z.m5045a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    C2499x.m5091a(BuglyBroadcastReceiver.f7320d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.f7322b.registerReceiver(BuglyBroadcastReceiver.f7320d, BuglyBroadcastReceiver.this.f7321a);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            C2499x.m5091a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.f7322b = context;
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            m5386a(context, intent);
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private synchronized boolean m5386a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f7324e) {
                    this.f7324e = false;
                    return true;
                }
                String m5429c = C2420b.m5429c(this.f7322b);
                C2499x.m5085c("is Connect BC " + m5429c, new Object[0]);
                C2499x.m5090a("network %s changed to %s", this.f7323c, m5429c);
                if (m5429c == null) {
                    this.f7323c = null;
                    return true;
                }
                String str = this.f7323c;
                this.f7323c = m5429c;
                long currentTimeMillis = System.currentTimeMillis();
                C2422a m5399a = C2422a.m5399a();
                C2492u m5135a = C2492u.m5135a();
                C2419a m5474a = C2419a.m5474a(context);
                if (m5399a != null && m5135a != null && m5474a != null) {
                    if (!m5429c.equals(str)) {
                        if (currentTimeMillis - m5135a.m5134a(C2437c.f7419a) > 30000) {
                            C2499x.m5090a("try to upload crash on network changed.", new Object[0]);
                            C2437c m5343a = C2437c.m5343a();
                            if (m5343a != null) {
                                m5343a.m5341a(0L);
                            }
                        }
                        if (currentTimeMillis - m5135a.m5134a(1001) > 30000) {
                            C2499x.m5090a("try to upload userinfo on network changed.", new Object[0]);
                            C2415b.f7184a.m5533b();
                        }
                    }
                    return true;
                }
                C2499x.m5084d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
