package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.StatLogger;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.l */
/* loaded from: classes2.dex */
public final class RunnableC2595l implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8152a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2595l(Context context) {
        this.f8152a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        StatLogger statLogger;
        context = StatServiceImpl.f7908t;
        C2525a.m4944a(context).m4934h();
        C2569l.m4842a(this.f8152a, true);
        C2546au.m4916a(this.f8152a);
        C2592i.m4751b(this.f8152a);
        Thread.UncaughtExceptionHandler unused = StatServiceImpl.f7906r = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(new C2540ao());
        if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH) {
            StatServiceImpl.commitEvents(this.f8152a, -1);
        }
        if (StatConfig.isDebugEnable()) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4880d("Init MTA StatService success.");
        }
    }
}
