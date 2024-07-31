package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2579b;
import com.tencent.wxop.stat.event.C2580c;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.z */
/* loaded from: classes2.dex */
public final class RunnableC2609z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f8184a;

    /* renamed from: b */
    final /* synthetic */ C2580c f8185b;

    /* renamed from: c */
    final /* synthetic */ Context f8186c;

    /* renamed from: d */
    final /* synthetic */ StatSpecifyReportedInfo f8187d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2609z(String str, C2580c c2580c, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f8184a = str;
        this.f8185b = c2580c;
        this.f8186c = context;
        this.f8187d = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        Map map;
        StatLogger statLogger2;
        StatLogger statLogger3;
        try {
            if (StatServiceImpl.m4966a(this.f8184a)) {
                statLogger3 = StatServiceImpl.f7905q;
                statLogger3.error("The event_id of StatService.trackCustomEndEvent() can not be null or empty.");
                return;
            }
            map = StatServiceImpl.f7893e;
            Long l = (Long) map.remove(this.f8185b);
            if (l != null) {
                C2579b c2579b = new C2579b(this.f8186c, StatServiceImpl.m4967a(this.f8186c, false, this.f8187d), this.f8185b.f8105a, this.f8187d);
                c2579b.m4774b().f8107c = this.f8185b.f8107c;
                Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
                c2579b.m4775a(Long.valueOf(valueOf.longValue() <= 0 ? 1L : valueOf.longValue()).longValue());
                new C2542aq(c2579b).m4927a();
                return;
            }
            statLogger2 = StatServiceImpl.f7905q;
            statLogger2.warn("No start time found for custom event: " + this.f8185b.toString() + ", lost trackCustomBeginKVEvent()?");
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f8186c, th);
        }
    }
}
