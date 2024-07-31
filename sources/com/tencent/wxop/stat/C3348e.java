package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2569l;
import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.e */
/* loaded from: classes2.dex */
public class C2577e extends TimerTask {

    /* renamed from: a */
    final /* synthetic */ C2576d f8099a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2577e(C2576d c2576d) {
        this.f8099a = c2576d;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Context context;
        if (StatConfig.isDebugEnable()) {
            C2569l.m4837b().m4877i("TimerTask run");
        }
        context = this.f8099a.f8098c;
        StatServiceImpl.m4954e(context);
        cancel();
        this.f8099a.m4780a();
    }
}
