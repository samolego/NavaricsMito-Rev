package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.af */
/* loaded from: classes2.dex */
public final class RunnableC2531af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7933a;

    /* renamed from: b */
    final /* synthetic */ Map f7934b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f7935c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2531af(Context context, Map map, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7933a = context;
        this.f7934b = map;
        this.f7935c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            new Thread(new RunnableC2541ap(this.f7933a, this.f7934b, this.f7935c), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f7933a, th);
        }
    }
}
