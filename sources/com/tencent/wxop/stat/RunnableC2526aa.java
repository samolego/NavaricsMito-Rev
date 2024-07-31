package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2584g;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.aa */
/* loaded from: classes2.dex */
public final class RunnableC2526aa implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7923a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f7924b;

    /* renamed from: c */
    final /* synthetic */ StatAppMonitor f7925c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2526aa(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, StatAppMonitor statAppMonitor) {
        this.f7923a = context;
        this.f7924b = statSpecifyReportedInfo;
        this.f7925c = statAppMonitor;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            new C2542aq(new C2584g(this.f7923a, StatServiceImpl.m4967a(this.f7923a, false, this.f7924b), this.f7925c, this.f7924b)).m4927a();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f7923a, th);
        }
    }
}
