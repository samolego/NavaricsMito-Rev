package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2581d;
import com.tencent.wxop.stat.event.C2585h;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.q */
/* loaded from: classes2.dex */
public final class RunnableC2600q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8160a;

    /* renamed from: b */
    final /* synthetic */ Throwable f8161b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2600q(Context context, Throwable th) {
        this.f8160a = context;
        this.f8161b = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            if (StatConfig.isEnableStatService()) {
                new C2542aq(new C2581d(this.f8160a, StatServiceImpl.m4967a(this.f8160a, false, (StatSpecifyReportedInfo) null), 99, this.f8161b, C2585h.f8128a)).m4927a();
            }
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4879e("reportSdkSelfException error: " + th);
        }
    }
}
