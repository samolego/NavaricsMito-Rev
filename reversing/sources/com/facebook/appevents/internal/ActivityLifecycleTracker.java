package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.codeless.CodelessManager;
import com.facebook.appevents.p039a.MetadataIndexer;
import com.facebook.appevents.p041c.SuggestedEventsManager;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.lang.ref.WeakReference;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.facebook.appevents.internal.a */
/* loaded from: classes.dex */
public class ActivityLifecycleTracker {

    /* renamed from: c */
    private static volatile ScheduledFuture f1721c;

    /* renamed from: f */
    private static volatile SessionInfo f1724f;

    /* renamed from: h */
    private static String f1726h;

    /* renamed from: i */
    private static long f1727i;

    /* renamed from: k */
    private static WeakReference<Activity> f1729k;

    /* renamed from: a */
    private static final String f1719a = ActivityLifecycleTracker.class.getCanonicalName();

    /* renamed from: b */
    private static final ScheduledExecutorService f1720b = Executors.newSingleThreadScheduledExecutor();

    /* renamed from: d */
    private static final Object f1722d = new Object();

    /* renamed from: e */
    private static AtomicInteger f1723e = new AtomicInteger(0);

    /* renamed from: g */
    private static AtomicBoolean f1725g = new AtomicBoolean(false);

    /* renamed from: j */
    private static int f1728j = 0;

    /* renamed from: e */
    static /* synthetic */ int m11032e() {
        int i = f1728j;
        f1728j = i + 1;
        return i;
    }

    /* renamed from: f */
    static /* synthetic */ int m11030f() {
        int i = f1728j;
        f1728j = i - 1;
        return i;
    }

    /* renamed from: i */
    static /* synthetic */ int m11026i() {
        return m11021n();
    }

    /* renamed from: a */
    public static void m11041a(Application application, String str) {
        if (f1725g.compareAndSet(false, true)) {
            FeatureManager.m10812a(FeatureManager.Feature.CodelessEvents, new FeatureManager.InterfaceC0926a() { // from class: com.facebook.appevents.internal.a.1
                @Override // com.facebook.internal.FeatureManager.InterfaceC0926a
                /* renamed from: a */
                public void mo10784a(boolean z) {
                    if (z) {
                        CodelessManager.m11176a();
                    } else {
                        CodelessManager.m11172b();
                    }
                }
            });
            f1726h = str;
            application.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() { // from class: com.facebook.appevents.internal.a.2
                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity, Bundle bundle) {
                    Logger.m10634a(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.f1719a, "onActivityCreated");
                    AppEventUtility.m11016b();
                    ActivityLifecycleTracker.m11042a(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStarted(Activity activity) {
                    ActivityLifecycleTracker.m11032e();
                    Logger.m10634a(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.f1719a, "onActivityStarted");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityResumed(Activity activity) {
                    Logger.m10634a(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.f1719a, "onActivityResumed");
                    AppEventUtility.m11016b();
                    ActivityLifecycleTracker.m11037b(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityPaused(Activity activity) {
                    Logger.m10634a(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.f1719a, "onActivityPaused");
                    AppEventUtility.m11016b();
                    ActivityLifecycleTracker.m11031e(activity);
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityStopped(Activity activity) {
                    Logger.m10634a(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.f1719a, "onActivityStopped");
                    AppEventsLogger.m11284c();
                    ActivityLifecycleTracker.m11030f();
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
                    Logger.m10634a(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.f1719a, "onActivitySaveInstanceState");
                }

                @Override // android.app.Application.ActivityLifecycleCallbacks
                public void onActivityDestroyed(Activity activity) {
                    Logger.m10634a(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.f1719a, "onActivityDestroyed");
                    ActivityLifecycleTracker.m11029f(activity);
                }
            });
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: a */
    public static boolean m11043a() {
        return f1728j == 0;
    }

    /* renamed from: b */
    public static UUID m11038b() {
        if (f1724f != null) {
            return f1724f.m10972g();
        }
        return null;
    }

    /* renamed from: a */
    public static void m11042a(Activity activity) {
        f1720b.execute(new Runnable() { // from class: com.facebook.appevents.internal.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (ActivityLifecycleTracker.f1724f == null) {
                    SessionInfo unused = ActivityLifecycleTracker.f1724f = SessionInfo.m10979a();
                }
            }
        });
    }

    /* renamed from: b */
    public static void m11037b(Activity activity) {
        f1729k = new WeakReference<>(activity);
        f1723e.incrementAndGet();
        m11020o();
        final long currentTimeMillis = System.currentTimeMillis();
        f1727i = currentTimeMillis;
        final String m10499c = Utility.m10499c(activity);
        CodelessManager.m11175a(activity);
        MetadataIndexer.m11277a(activity);
        SuggestedEventsManager.m11202a(activity);
        final Context applicationContext = activity.getApplicationContext();
        f1720b.execute(new Runnable() { // from class: com.facebook.appevents.internal.a.4
            @Override // java.lang.Runnable
            public void run() {
                if (ActivityLifecycleTracker.f1724f == null) {
                    SessionInfo unused = ActivityLifecycleTracker.f1724f = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    SessionLogger.m10964a(m10499c, null, ActivityLifecycleTracker.f1726h, applicationContext);
                } else if (ActivityLifecycleTracker.f1724f.m10976c() != null) {
                    long longValue = currentTimeMillis - ActivityLifecycleTracker.f1724f.m10976c().longValue();
                    if (longValue > ActivityLifecycleTracker.m11026i() * 1000) {
                        SessionLogger.m10965a(m10499c, ActivityLifecycleTracker.f1724f, ActivityLifecycleTracker.f1726h);
                        SessionLogger.m10964a(m10499c, null, ActivityLifecycleTracker.f1726h, applicationContext);
                        SessionInfo unused2 = ActivityLifecycleTracker.f1724f = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                    } else if (longValue > 1000) {
                        ActivityLifecycleTracker.f1724f.m10974e();
                    }
                }
                ActivityLifecycleTracker.f1724f.m10978a(Long.valueOf(currentTimeMillis));
                ActivityLifecycleTracker.f1724f.m10969j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static void m11031e(Activity activity) {
        if (f1723e.decrementAndGet() < 0) {
            f1723e.set(0);
            Log.w(f1719a, "Unexpected activity pause without a matching activity resume. Logging data may be incorrect. Make sure you call activateApp from your Application's onCreate method");
        }
        m11020o();
        final long currentTimeMillis = System.currentTimeMillis();
        final String m10499c = Utility.m10499c(activity);
        CodelessManager.m11171b(activity);
        f1720b.execute(new Runnable() { // from class: com.facebook.appevents.internal.a.5
            @Override // java.lang.Runnable
            public void run() {
                if (ActivityLifecycleTracker.f1724f == null) {
                    SessionInfo unused = ActivityLifecycleTracker.f1724f = new SessionInfo(Long.valueOf(currentTimeMillis), null);
                }
                ActivityLifecycleTracker.f1724f.m10978a(Long.valueOf(currentTimeMillis));
                if (ActivityLifecycleTracker.f1723e.get() <= 0) {
                    Runnable runnable = new Runnable() { // from class: com.facebook.appevents.internal.a.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ActivityLifecycleTracker.f1723e.get() <= 0) {
                                SessionLogger.m10965a(m10499c, ActivityLifecycleTracker.f1724f, ActivityLifecycleTracker.f1726h);
                                SessionInfo.m10977b();
                                SessionInfo unused2 = ActivityLifecycleTracker.f1724f = null;
                            }
                            synchronized (ActivityLifecycleTracker.f1722d) {
                                ScheduledFuture unused3 = ActivityLifecycleTracker.f1721c = null;
                            }
                        }
                    };
                    synchronized (ActivityLifecycleTracker.f1722d) {
                        ScheduledFuture unused2 = ActivityLifecycleTracker.f1721c = ActivityLifecycleTracker.f1720b.schedule(runnable, ActivityLifecycleTracker.m11026i(), TimeUnit.SECONDS);
                    }
                }
                long j = ActivityLifecycleTracker.f1727i;
                AutomaticAnalyticsLogger.m11012a(m10499c, j > 0 ? (currentTimeMillis - j) / 1000 : 0L);
                ActivityLifecycleTracker.f1724f.m10969j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static void m11029f(Activity activity) {
        CodelessManager.m11167c(activity);
    }

    /* renamed from: n */
    private static int m11021n() {
        FetchedAppSettings m10808a = FetchedAppSettingsManager.m10808a(FacebookSdk.m10865l());
        if (m10808a == null) {
            return Constants.m11007a();
        }
        return m10808a.m10690b();
    }

    /* renamed from: o */
    private static void m11020o() {
        synchronized (f1722d) {
            if (f1721c != null) {
                f1721c.cancel(false);
            }
            f1721c = null;
        }
    }

    @Nullable
    /* renamed from: c */
    public static Activity m11036c() {
        WeakReference<Activity> weakReference = f1729k;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
}
