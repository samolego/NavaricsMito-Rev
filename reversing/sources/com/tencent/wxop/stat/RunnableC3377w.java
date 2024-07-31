package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.w */
/* loaded from: classes2.dex */
public final class RunnableC2606w implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f8174a;

    /* renamed from: b */
    final /* synthetic */ Context f8175b;

    /* renamed from: c */
    final /* synthetic */ StatSpecifyReportedInfo f8176c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2606w(String str, Context context, StatSpecifyReportedInfo statSpecifyReportedInfo) {
        this.f8174a = str;
        this.f8175b = context;
        this.f8176c = statSpecifyReportedInfo;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        Map map;
        Map map2;
        Map map3;
        String str;
        Map map4;
        String str2;
        StatLogger statLogger2;
        String str3;
        StatLogger statLogger3;
        try {
            map = StatServiceImpl.f7903o;
            synchronized (map) {
                map2 = StatServiceImpl.f7903o;
                if (map2.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    statLogger3 = StatServiceImpl.f7905q;
                    statLogger3.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    return;
                }
                String unused = StatServiceImpl.f7901m = this.f8174a;
                map3 = StatServiceImpl.f7903o;
                str = StatServiceImpl.f7901m;
                if (!map3.containsKey(str)) {
                    map4 = StatServiceImpl.f7903o;
                    str2 = StatServiceImpl.f7901m;
                    map4.put(str2, Long.valueOf(System.currentTimeMillis()));
                    StatServiceImpl.m4967a(this.f8175b, true, this.f8176c);
                    return;
                }
                statLogger2 = StatServiceImpl.f7905q;
                StringBuilder sb = new StringBuilder("Duplicate PageID : ");
                str3 = StatServiceImpl.f7901m;
                sb.append(str3);
                sb.append(", onResume() repeated?");
                statLogger2.m4879e(sb.toString());
            }
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f8175b, th);
        }
    }
}
