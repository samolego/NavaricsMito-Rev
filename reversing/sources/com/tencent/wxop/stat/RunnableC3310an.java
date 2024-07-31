package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.an */
/* loaded from: classes2.dex */
public final class RunnableC2539an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7953a;

    /* renamed from: b */
    final /* synthetic */ StatSpecifyReportedInfo f7954b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2539an(Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7953a = context;
        this.f7954b = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            StatServiceImpl.m4967a(this.f7953a, false, this.f7954b);
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
        }
    }
}
