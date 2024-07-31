package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.al */
/* loaded from: classes2.dex */
public final class RunnableC2537al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ StatAccount f7947a;

    /* renamed from: b */
    final /* synthetic */ Context f7948b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f7949c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2537al(StatAccount statAccount, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7947a = statAccount;
        this.f7948b = context;
        this.f7949c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        StatAccount statAccount = this.f7947a;
        if (statAccount == null || statAccount.getAccount().trim().length() == 0) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4875w("account is null or empty.");
            return;
        }
        StatConfig.setQQ(this.f7948b, this.f7947a.getAccount());
        StatServiceImpl.m4962b(this.f7948b, this.f7947a, this.f7949c);
    }
}
