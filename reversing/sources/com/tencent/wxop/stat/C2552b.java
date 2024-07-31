package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.wxop.stat.common.C2562e;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.b */
/* loaded from: classes2.dex */
public class C2552b extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ C2525a f7998a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2552b(C2525a c2525a) {
        this.f7998a = c2525a;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        C2562e c2562e;
        C2562e c2562e2;
        c2562e = this.f7998a.f7919e;
        if (c2562e != null) {
            c2562e2 = this.f7998a.f7919e;
            c2562e2.m4865a(new RunnableC2557c(this));
        }
    }
}
