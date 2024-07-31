package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ai */
/* loaded from: classes2.dex */
public final class RunnableC2534ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7940a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f7941b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2534ai(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7940a = context;
        this.f7941b = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            StatServiceImpl.stopSession();
            StatServiceImpl.m4967a(this.f7940a, true, this.f7941b);
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f7940a, th);
        }
    }
}
