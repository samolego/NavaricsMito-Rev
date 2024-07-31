package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.m */
/* loaded from: classes2.dex */
public final class RunnableC2596m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8153a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f8154b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2596m(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f8153a = context;
        this.f8154b = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        Context context = this.f8153a;
        if (context != null) {
            StatServiceImpl.trackEndPage(context, C2569l.m4826f(context), this.f8154b);
            return;
        }
        statLogger = StatServiceImpl.f7905q;
        statLogger.error("The Context of StatService.onPause() can not be null!");
    }
}
