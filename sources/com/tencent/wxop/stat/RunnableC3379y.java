package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.C2580c;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.tencent.wxop.stat.y */
/* loaded from: classes2.dex */
public final class RunnableC2608y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f8181a;

    /* renamed from: b */
    final /* synthetic */ C2580c f8182b;

    /* renamed from: c */
    final /* synthetic */ Context f8183c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2608y(String str, C2580c c2580c, Context context) {
        this.f8181a = str;
        this.f8182b = c2580c;
        this.f8183c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StatLogger statLogger;
        Map map;
        Map map2;
        StatLogger statLogger2;
        Map map3;
        StatLogger statLogger3;
        StatLogger statLogger4;
        StatLogger statLogger5;
        try {
            if (StatServiceImpl.m4966a(this.f8181a)) {
                statLogger5 = StatServiceImpl.f7905q;
                statLogger5.error("The event_id of StatService.trackCustomBeginEvent() can not be null or empty.");
                return;
            }
            if (StatConfig.isDebugEnable()) {
                statLogger4 = StatServiceImpl.f7905q;
                statLogger4.m4877i("add begin key:" + this.f8182b);
            }
            map = StatServiceImpl.f7893e;
            if (map.containsKey(this.f8182b)) {
                statLogger3 = StatServiceImpl.f7905q;
                statLogger3.warn("Duplicate CustomEvent key: " + this.f8182b.toString() + ", trackCustomBeginKVEvent() repeated?");
                return;
            }
            map2 = StatServiceImpl.f7893e;
            if (map2.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                map3 = StatServiceImpl.f7893e;
                map3.put(this.f8182b, Long.valueOf(System.currentTimeMillis()));
                return;
            }
            statLogger2 = StatServiceImpl.f7905q;
            statLogger2.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
        } catch (Throwable th) {
            statLogger = StatServiceImpl.f7905q;
            statLogger.m4878e(th);
            StatServiceImpl.m4968a(this.f8183c, th);
        }
    }
}
