package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.aj */
/* loaded from: classes2.dex */
public final class RunnableC2535aj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7942a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f7943b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2535aj(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7942a = context;
        this.f7943b = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        Context context = this.f7942a;
        if (context != null) {
            StatServiceImpl.trackBeginPage(context, C2569l.m4826f(context), this.f7943b);
            return;
        }
        statLogger = StatServiceImpl.f7905q;
        statLogger.error("The Context of StatService.onResume() can not be null!");
    }
}
