package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ad */
/* loaded from: classes2.dex */
public final class RunnableC2529ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7930a;

    /* renamed from: b */
    final /* synthetic */ int f7931b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2529ad(Context context, int i) {
        this.f7930a = context;
        this.f7931b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        try {
            StatServiceImpl.flushDataToDB(this.f7930a);
            C2546au.m4916a(this.f7930a).m4918a(this.f7931b);
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f7930a, th);
        }
    }
}
