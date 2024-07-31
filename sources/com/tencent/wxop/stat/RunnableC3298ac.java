package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2579b;
import com.tencent.wxop.stat.event.C2580c;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ac */
/* loaded from: classes2.dex */
public final class RunnableC2528ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7926a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f7927b;

    /* renamed from: c */
    final /* synthetic */ C2580c f7928c;

    /* renamed from: d */
    final /* synthetic */ int f7929d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2528ac(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo, C2580c c2580c, int i) {
        this.f7926a = context;
        this.f7927b = statSpecifyReportedInfo;
        this.f7928c = c2580c;
        this.f7929d = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            C2579b c2579b = new C2579b(this.f7926a, StatServiceImpl.m4967a(this.f7926a, false, this.f7927b), this.f7928c.f8105a, this.f7927b);
            c2579b.m4774b().f8107c = this.f7928c.f8107c;
            Long valueOf = Long.valueOf(this.f7929d);
            c2579b.m4775a(Long.valueOf(valueOf.longValue() <= 0 ? 1L : valueOf.longValue()).longValue());
            new C2542aq(c2579b).m4927a();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f7926a, th);
        }
    }
}
