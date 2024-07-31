package com.tencent.wxop.stat;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.o */
/* loaded from: classes2.dex */
public final class RunnableC2598o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8156a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2598o(Context context) {
        this.f8156a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatServiceImpl.flushDataToDB(this.f8156a);
    }
}
