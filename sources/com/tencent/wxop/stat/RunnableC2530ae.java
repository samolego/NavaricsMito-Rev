package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ae */
/* loaded from: classes2.dex */
public final class RunnableC2530ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7932a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2530ae(Context context) {
        this.f7932a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            new Thread(new RunnableC2541ap(this.f7932a, null, null), "NetworkMonitorTask").start();
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f7932a, th);
        }
    }
}
