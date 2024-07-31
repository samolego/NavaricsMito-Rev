package com.facebook.appevents;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.h */
/* loaded from: classes.dex */
public class InternalAppEventsLogger {

    /* renamed from: a */
    private AppEventsLoggerImpl f1710a;

    public InternalAppEventsLogger(Context context) {
        this.f1710a = new AppEventsLoggerImpl(context, (String) null, (AccessToken) null);
    }

    public InternalAppEventsLogger(Context context, String str) {
        this.f1710a = new AppEventsLoggerImpl(context, str, (AccessToken) null);
    }

    public InternalAppEventsLogger(String str, String str2, AccessToken accessToken) {
        this.f1710a = new AppEventsLoggerImpl(str, str2, accessToken);
    }

    /* renamed from: a */
    public void m11060a(String str, Bundle bundle) {
        if (FacebookSdk.m10861p()) {
            this.f1710a.m11079a(str, bundle);
        }
    }

    /* renamed from: a */
    public void m11061a(String str, double d, Bundle bundle) {
        if (FacebookSdk.m10861p()) {
            this.f1710a.m11080a(str, d, bundle);
        }
    }

    /* renamed from: a */
    public void m11056a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (FacebookSdk.m10861p()) {
            this.f1710a.m11074a(bigDecimal, currency, bundle);
        }
    }

    /* renamed from: a */
    public void m11058a(String str, String str2) {
        this.f1710a.m11076a(str, str2);
    }

    /* renamed from: a */
    public void m11057a(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (FacebookSdk.m10861p()) {
            this.f1710a.m11075a(str, bigDecimal, currency, bundle);
        }
    }

    /* renamed from: a */
    public void m11062a(String str) {
        if (FacebookSdk.m10861p()) {
            this.f1710a.m11078a(str, (Double) null, (Bundle) null);
        }
    }

    /* renamed from: a */
    public void m11059a(String str, Double d, Bundle bundle) {
        if (FacebookSdk.m10861p()) {
            this.f1710a.m11078a(str, d, bundle);
        }
    }

    /* renamed from: b */
    public void m11053b(String str, Bundle bundle) {
        if (FacebookSdk.m10861p()) {
            this.f1710a.m11078a(str, (Double) null, bundle);
        }
    }

    /* renamed from: a */
    public static AppEventsLogger.FlushBehavior m11063a() {
        return AppEventsLoggerImpl.m11086a();
    }

    /* renamed from: b */
    public void m11054b() {
        this.f1710a.m11072b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static Executor m11052c() {
        return AppEventsLoggerImpl.m11066g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static String m11051d() {
        return AppEventsLoggerImpl.m11069d();
    }

    @RestrictTo({RestrictTo.Scope.GROUP_ID})
    /* renamed from: a */
    public static void m11055a(Map<String, String> map) {
        UserDataStore.m10957a(map);
    }
}
