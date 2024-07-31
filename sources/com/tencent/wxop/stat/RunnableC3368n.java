package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.C2569l;
import com.tencent.wxop.stat.common.StatLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.n */
/* loaded from: classes2.dex */
public final class RunnableC2597n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f8155a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2597n(Context context) {
        this.f8155a = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        Context context = this.f8155a;
        if (context == null) {
            statLogger2 = StatServiceImpl.f7905q;
            statLogger2.error("The Context of StatService.onStop() can not be null!");
            return;
        }
        StatServiceImpl.flushDataToDB(context);
        if (StatServiceImpl.m4973a()) {
            return;
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (C2569l.m4804z(this.f8155a)) {
            if (StatConfig.isDebugEnable()) {
                statLogger = StatServiceImpl.f7905q;
                statLogger.m4877i("onStop isBackgroundRunning flushDataToDB");
            }
            StatServiceImpl.commitEvents(this.f8155a, -1);
        }
    }
}
