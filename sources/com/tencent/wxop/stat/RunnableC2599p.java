package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2581d;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.p */
/* loaded from: classes2.dex */
public final class RunnableC2599p implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f8157a;

    /* renamed from: b */
    final /* synthetic */ Context f8158b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f8159c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2599p(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f8157a = str;
        this.f8158b = context;
        this.f8159c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        StatLogger statLogger2;
        try {
            if (!StatServiceImpl.m4966a(this.f8157a)) {
                new C2542aq(new C2581d(this.f8158b, StatServiceImpl.m4967a(this.f8158b, false, this.f8159c), this.f8157a, 0, StatConfig.getMaxReportEventLength(), null, this.f8159c)).m4927a();
                return;
            }
            statLogger2 = StatServiceImpl.f7905q;
            statLogger2.error("Error message in StatService.reportError() is empty.");
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f8158b, th);
        }
    }
}
