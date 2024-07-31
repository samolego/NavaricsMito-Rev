package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import com.facebook.AccessToken;

/* loaded from: classes.dex */
public class AppEventsLogger {

    /* renamed from: a */
    private static final String f1526a = AppEventsLogger.class.getCanonicalName();

    /* renamed from: b */
    private AppEventsLoggerImpl f1527b;

    /* loaded from: classes.dex */
    public enum FlushBehavior {
        AUTO,
        EXPLICIT_ONLY
    }

    /* renamed from: a */
    public static void m11291a(Application application, String str) {
        AppEventsLoggerImpl.m11085a(application, str);
    }

    /* renamed from: a */
    public static void m11289a(Context context, String str) {
        AppEventsLoggerImpl.m11083a(context, str);
    }

    /* renamed from: a */
    public static AppEventsLogger m11290a(Context context) {
        return new AppEventsLogger(context, null, null);
    }

    private AppEventsLogger(Context context, String str, AccessToken accessToken) {
        this.f1527b = new AppEventsLoggerImpl(context, str, accessToken);
    }

    /* renamed from: a */
    public static FlushBehavior m11292a() {
        return AppEventsLoggerImpl.m11086a();
    }

    /* renamed from: a */
    public void m11287a(String str, Bundle bundle) {
        this.f1527b.m11079a(str, bundle);
    }

    /* renamed from: b */
    public void m11286b() {
        this.f1527b.m11072b();
    }

    /* renamed from: c */
    public static void m11284c() {
        AppEventsLoggerImpl.m11070c();
    }

    /* renamed from: d */
    public static String m11283d() {
        return AnalyticsUserIDStore.m11281b();
    }

    /* renamed from: b */
    public static String m11285b(Context context) {
        return AppEventsLoggerImpl.m11084a(context);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* renamed from: a */
    public static void m11288a(String str) {
        AppEventsLoggerImpl.m11081a(str);
    }
}
