package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2579b;
import com.tencent.wxop.stat.event.C2580c;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.x */
/* loaded from: classes2.dex */
public final class RunnableC2607x implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f8177a;

    /* renamed from: b */
    final /* synthetic */ C2580c f8178b;

    /* renamed from: c */
    final /* synthetic */ Context f8179c;

    /* renamed from: d */
    final /* synthetic */ StatSpecifyReportedInfo f8180d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2607x(String str, C2580c c2580c, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f8177a = str;
        this.f8178b = c2580c;
        this.f8179c = context;
        this.f8180d = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        Map map;
        StatLogger statLogger2;
        StatLogger statLogger3;
        try {
            if (StatServiceImpl.m4966a(this.f8177a)) {
                statLogger3 = StatServiceImpl.f7905q;
                statLogger3.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            map = StatServiceImpl.f7893e;
            Long l = (Long) map.remove(this.f8178b);
            if (l != null) {
                C2579b c2579b = new C2579b(this.f8179c, StatServiceImpl.m4967a(this.f8179c, false, this.f8180d), this.f8178b.f8105a, this.f8180d);
                c2579b.m4774b().f8106b = this.f8178b.f8106b;
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c2579b.m4775a(Long.valueOf(valueOf.longValue() == 0 ? 1L : valueOf.longValue()).longValue());
                new C2542aq(c2579b).m4927a();
                return;
            }
            statLogger2 = StatServiceImpl.f7905q;
            statLogger2.error("No start time found for custom event: " + this.f8178b.toString() + ", lost trackCustomBeginEvent()?");
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f8179c, th);
        }
    }
}
