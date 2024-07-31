package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2579b;
import com.tencent.wxop.stat.event.C2580c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.u */
/* loaded from: classes2.dex */
public final class RunnableC2604u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8168a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f8169b;

    /* renamed from: c */
    final /* synthetic */ C2580c f8170c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2604u(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C2580c c2580c) {
        this.f8168a = context;
        this.f8169b = statSpecifyReportedInfo;
        this.f8170c = c2580c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            C2579b c2579b = new C2579b(this.f8168a, StatServiceImpl.m4967a(this.f8168a, false, this.f8169b), this.f8170c.f8105a, this.f8169b);
            c2579b.m4774b().f8107c = this.f8170c.f8107c;
            new C2542aq(c2579b).m4927a();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f8168a, th);
        }
    }
}
