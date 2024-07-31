package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.common.StatLogger;
import com.tencent.wxop.stat.event.AbstractC2582e;
import com.tencent.wxop.stat.event.C2581d;
import java.lang.Thread;

/* renamed from: com.tencent.wxop.stat.ao */
/* loaded from: classes2.dex */
class C2540ao implements Thread.UncaughtExceptionHandler {
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Context context;
        Context context2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        StatLogger statLogger;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler3;
        Context context3;
        Context context4;
        Context context5;
        StatLogger statLogger2;
        StatLogger statLogger3;
        if (StatConfig.isEnableStatService()) {
            context = StatServiceImpl.f7908t;
            if (context == null) {
                return;
            }
            if (StatConfig.isAutoExceptionCaught()) {
                context3 = StatServiceImpl.f7908t;
                C2546au m4916a = C2546au.m4916a(context3);
                context4 = StatServiceImpl.f7908t;
                context5 = StatServiceImpl.f7908t;
                m4916a.m4908a((AbstractC2582e) new C2581d(context4, StatServiceImpl.m4967a(context5, false, (StatSpecifyReportedInfo) null), 2, th, thread, null), (InterfaceC2591h) null, false, true);
                statLogger2 = StatServiceImpl.f7905q;
                statLogger2.debug("MTA has caught the following uncaught exception:");
                statLogger3 = StatServiceImpl.f7905q;
                statLogger3.error(th);
            }
            context2 = StatServiceImpl.f7908t;
            StatServiceImpl.flushDataToDB(context2);
            uncaughtExceptionHandler = StatServiceImpl.f7906r;
            if (uncaughtExceptionHandler != null) {
                statLogger = StatServiceImpl.f7905q;
                statLogger.m4880d("Call the original uncaught exception handler.");
                uncaughtExceptionHandler2 = StatServiceImpl.f7906r;
                if (uncaughtExceptionHandler2 instanceof C2540ao) {
                    return;
                }
                uncaughtExceptionHandler3 = StatServiceImpl.f7906r;
                uncaughtExceptionHandler3.uncaughtException(thread, th);
            }
        }
    }
}
