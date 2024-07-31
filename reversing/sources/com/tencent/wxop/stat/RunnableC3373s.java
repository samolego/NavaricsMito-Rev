package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2579b;
import com.tencent.wxop.stat.event.C2580c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.s */
/* loaded from: classes2.dex */
public final class RunnableC2602s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8165a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f8166b;

    /* renamed from: c */
    final /* synthetic */ C2580c f8167c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2602s(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C2580c c2580c) {
        this.f8165a = context;
        this.f8166b = statSpecifyReportedInfo;
        this.f8167c = c2580c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            C2579b c2579b = new C2579b(this.f8165a, StatServiceImpl.m4967a(this.f8165a, false, this.f8166b), this.f8167c.f8105a, this.f8166b);
            c2579b.m4774b().f8106b = this.f8167c.f8106b;
            new C2542aq(c2579b).m4927a();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f8165a, th);
        }
    }
}
