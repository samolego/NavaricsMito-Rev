package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2587j;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.ah */
/* loaded from: classes2.dex */
public final class RunnableC2533ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f7937a;

    /* renamed from: b */
    final /* synthetic */ String f7938b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f7939c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2533ah(Context context, String str, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f7937a = context;
        this.f7938b = str;
        this.f7939c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        Map map;
        Map map2;
        Long l;
        StatLogger statLogger2;
        String str;
        String str2;
        StatLogger statLogger3;
        try {
            StatServiceImpl.flushDataToDB(this.f7937a);
            map = StatServiceImpl.f7903o;
            synchronized (map) {
                map2 = StatServiceImpl.f7903o;
                l = (Long) map2.remove(this.f7938b);
            }
            if (l == null) {
                statLogger2 = StatServiceImpl.f7905q;
                statLogger2.m4879e("Starttime for PageID:" + this.f7938b + " not found, lost onResume()?");
                return;
            }
            Long valueOf = Long.valueOf((System.currentTimeMillis() - l.longValue()) / 1000);
            if (valueOf.longValue() <= 0) {
                valueOf = 1L;
            }
            Long l2 = valueOf;
            str = StatServiceImpl.f7902n;
            if (str != null && str.equals(this.f7938b)) {
                str = "-";
            }
            C2587j c2587j = new C2587j(this.f7937a, str, this.f7938b, StatServiceImpl.m4967a(this.f7937a, false, this.f7939c), l2, this.f7939c);
            String str3 = this.f7938b;
            str2 = StatServiceImpl.f7901m;
            if (!str3.equals(str2)) {
                statLogger3 = StatServiceImpl.f7905q;
                statLogger3.warn("Invalid invocation since previous onResume on diff page.");
            }
            new C2542aq(c2587j).m4927a();
            String unused = StatServiceImpl.f7902n = this.f7938b;
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f7937a, th);
        }
    }
}
