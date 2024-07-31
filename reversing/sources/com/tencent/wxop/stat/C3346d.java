package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.StatLogger;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.tencent.wxop.stat.d */
/* loaded from: classes2.dex */
public class C2576d {

    /* renamed from: b */
    private static volatile C2576d f8096b;

    /* renamed from: a */
    private Timer f8097a;

    /* renamed from: c */
    private Context f8098c;

    private C2576d(Context context) {
        this.f8097a = null;
        this.f8098c = null;
        this.f8098c = context.getApplicationContext();
        this.f8097a = new Timer(false);
    }

    /* renamed from: a */
    public static C2576d m4779a(Context context) {
        if (f8096b == null) {
            synchronized (C2576d.class) {
                if (f8096b == null) {
                    f8096b = new C2576d(context);
                }
            }
        }
        return f8096b;
    }

    /* renamed from: a */
    public void m4780a() {
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.PERIOD) {
            long sendPeriodMinutes = StatConfig.getSendPeriodMinutes() * 60 * 1000;
            if (StatConfig.isDebugEnable()) {
                C2569l.m4837b().m4877i("setupPeriodTimer delay:" + sendPeriodMinutes);
            }
            m4777a(new C2577e(this), sendPeriodMinutes);
        }
    }

    /* renamed from: a */
    public void m4777a(TimerTask timerTask, long j) {
        if (this.f8097a == null) {
            if (StatConfig.isDebugEnable()) {
                C2569l.m4837b().m4875w("setupPeriodTimer schedule timer == null");
                return;
            }
            return;
        }
        if (StatConfig.isDebugEnable()) {
            StatLogger m4837b = C2569l.m4837b();
            m4837b.m4877i("setupPeriodTimer schedule delay:" + j);
        }
        this.f8097a.schedule(timerTask, j);
    }
}
