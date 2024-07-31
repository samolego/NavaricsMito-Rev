package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2583f;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.am */
/* loaded from: classes2.dex */
public final class RunnableC2538am implements Runnable {

    /* renamed from: a */
    final /* synthetic */ StatGameUser f7950a;

    /* renamed from: b */
    final /* synthetic */ Context f7951b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f7952c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2538am(StatGameUser statGameUser, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7950a = statGameUser;
        this.f7951b = context;
        this.f7952c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        StatLogger statLogger3;
        StatGameUser statGameUser = this.f7950a;
        if (statGameUser == null) {
            statLogger3 = StatServiceImpl.f7905q;
            statLogger3.error("The gameUser of StatService.reportGameUser() can not be null!");
        } else if (statGameUser.getAccount() == null || this.f7950a.getAccount().length() == 0) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.error("The account of gameUser on StatService.reportGameUser() can not be null or empty!");
        } else {
            try {
                new C2542aq(new C2583f(this.f7951b, StatServiceImpl.m4967a(this.f7951b, false, this.f7952c), this.f7950a, this.f7952c)).m4927a();
            } catch (Throwable th) {
                statLogger2 = StatServiceImpl.f7905q;
                statLogger2.m4878e(th);
                StatServiceImpl.m4968a(this.f7951b, th);
            }
        }
    }
}
