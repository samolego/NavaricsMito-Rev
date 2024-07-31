package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2581d;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.r */
/* loaded from: classes2.dex */
public final class RunnableC2601r implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Throwable f8162a;

    /* renamed from: b */
    final /* synthetic */ Context f8163b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f8164c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2601r(Throwable th, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f8162a = th;
        this.f8163b = context;
        this.f8164c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        if (this.f8162a == null) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.error("The Throwable error message of StatService.reportException() can not be null!");
            return;
        }
        Context context = this.f8163b;
        new C2542aq(new C2581d(context, StatServiceImpl.m4967a(context, false, this.f8164c), 1, this.f8162a, this.f8164c)).m4927a();
    }
}
