package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ak */
/* loaded from: classes2.dex */
public final class RunnableC2536ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f7944a;

    /* renamed from: b */
    final /* synthetic */ Context f7945b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f7946c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2536ak(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7944a = str;
        this.f7945b = context;
        this.f7946c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        String str = this.f7944a;
        if (str == null || str.trim().length() == 0) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4875w("qq num is null or empty.");
            return;
        }
        String str2 = this.f7944a;
        StatConfig.f7863f = str2;
        StatServiceImpl.m4962b(this.f7945b, new StatAccount(str2), this.f7946c);
    }
}
