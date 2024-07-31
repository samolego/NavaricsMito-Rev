package com.facebook.appevents;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashSet;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.appevents.e */
/* loaded from: classes.dex */
public class AppEventsLoggerImpl {

    /* renamed from: d */
    private static ScheduledThreadPoolExecutor f1698d;

    /* renamed from: g */
    private static String f1701g;

    /* renamed from: h */
    private static boolean f1702h;

    /* renamed from: i */
    private static String f1703i;

    /* renamed from: b */
    private final String f1704b;

    /* renamed from: c */
    private final AccessTokenAppIdPair f1705c;

    /* renamed from: a */
    private static final String f1697a = AppEventsLoggerImpl.class.getCanonicalName();

    /* renamed from: e */
    private static AppEventsLogger.FlushBehavior f1699e = AppEventsLogger.FlushBehavior.AUTO;

    /* renamed from: f */
    private static final Object f1700f = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11085a(Application application, String str) {
        if (!FacebookSdk.m10885a()) {
            throw new FacebookException("The Facebook sdk must be initialized before calling activateApp");
        }
        AnalyticsUserIDStore.m11282a();
        UserDataStore.m10960a();
        if (str == null) {
            str = FacebookSdk.m10865l();
        }
        FacebookSdk.m10881a(application, str);
        ActivityLifecycleTracker.m11041a(application, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11083a(final Context context, String str) {
        if (FacebookSdk.m10861p()) {
            final AppEventsLoggerImpl appEventsLoggerImpl = new AppEventsLoggerImpl(context, str, (AccessToken) null);
            f1698d.execute(new Runnable() { // from class: com.facebook.appevents.e.1
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle = new Bundle();
                    String[] strArr = {"com.facebook.core.Core", "com.facebook.login.Login", "com.facebook.share.Share", "com.facebook.places.Places", "com.facebook.messenger.Messenger", "com.facebook.applinks.AppLinks", "com.facebook.marketing.Marketing", "com.facebook.all.All", "com.android.billingclient.api.BillingClient", "com.android.vending.billing.IInAppBillingService"};
                    String[] strArr2 = {"core_lib_included", "login_lib_included", "share_lib_included", "places_lib_included", "messenger_lib_included", "applinks_lib_included", "marketing_lib_included", "all_lib_included", "billing_client_lib_included", "billing_service_lib_included"};
                    if (strArr.length != strArr2.length) {
                        throw new FacebookException("Number of class names and key names should match");
                    }
                    int i = 0;
                    for (int i2 = 0; i2 < strArr.length; i2++) {
                        String str2 = strArr[i2];
                        String str3 = strArr2[i2];
                        try {
                            Class.forName(str2);
                            bundle.putInt(str3, 1);
                            i |= 1 << i2;
                        } catch (ClassNotFoundException unused) {
                        }
                    }
                    SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
                    if (sharedPreferences.getInt("kitsBitmask", 0) != i) {
                        sharedPreferences.edit().putInt("kitsBitmask", i).apply();
                        appEventsLoggerImpl.m11078a("fb_sdk_initialize", (Double) null, bundle);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static AppEventsLogger.FlushBehavior m11086a() {
        AppEventsLogger.FlushBehavior flushBehavior;
        synchronized (f1700f) {
            flushBehavior = f1699e;
        }
        return flushBehavior;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11079a(String str, Bundle bundle) {
        m11077a(str, null, bundle, false, ActivityLifecycleTracker.m11038b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11080a(String str, double d, Bundle bundle) {
        m11077a(str, Double.valueOf(d), bundle, false, ActivityLifecycleTracker.m11038b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11076a(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString("_is_suggested_event", "1");
        bundle.putString("_button_text", str2);
        m11079a(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11074a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        m11073a(bigDecimal, currency, bundle, true);
    }

    /* renamed from: a */
    void m11073a(BigDecimal bigDecimal, Currency currency, Bundle bundle, boolean z) {
        if (bigDecimal == null) {
            m11071b("purchaseAmount cannot be null");
        } else if (currency == null) {
            m11071b("currency cannot be null");
        } else {
            Bundle bundle2 = bundle == null ? new Bundle() : bundle;
            bundle2.putString("fb_currency", currency.getCurrencyCode());
            m11077a("fb_mobile_purchase", Double.valueOf(bigDecimal.doubleValue()), bundle2, z, ActivityLifecycleTracker.m11038b());
            m11067f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m11072b() {
        AppEventQueue.m11235a(FlushReason.EXPLICIT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m11070c() {
        AppEventQueue.m11239a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static String m11069d() {
        String str;
        synchronized (f1700f) {
            str = f1703i;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11081a(String str) {
        SharedPreferences sharedPreferences = FacebookSdk.m10869h().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
        if (str != null) {
            sharedPreferences.edit().putString("install_referrer", str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: e */
    public static String m11068e() {
        return FacebookSdk.m10869h().getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("install_referrer", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppEventsLoggerImpl(Context context, String str, AccessToken accessToken) {
        this(Utility.m10499c(context), str, accessToken);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppEventsLoggerImpl(String str, String str2, AccessToken accessToken) {
        Validate.m10472a();
        this.f1704b = str;
        accessToken = accessToken == null ? AccessToken.m11457a() : accessToken;
        if (accessToken != null && !accessToken.m11438n() && (str2 == null || str2.equals(accessToken.m11440l()))) {
            this.f1705c = new AccessTokenAppIdPair(accessToken);
        } else {
            this.f1705c = new AccessTokenAppIdPair(null, str2 == null ? Utility.m10548a(FacebookSdk.m10869h()) : str2);
        }
        m11065h();
    }

    /* renamed from: h */
    private static void m11065h() {
        synchronized (f1700f) {
            if (f1698d != null) {
                return;
            }
            f1698d = new ScheduledThreadPoolExecutor(1);
            f1698d.scheduleAtFixedRate(new Runnable() { // from class: com.facebook.appevents.e.2
                @Override // java.lang.Runnable
                public void run() {
                    HashSet<String> hashSet = new HashSet();
                    for (AccessTokenAppIdPair accessTokenAppIdPair : AppEventQueue.m11231b()) {
                        hashSet.add(accessTokenAppIdPair.getApplicationId());
                    }
                    for (String str : hashSet) {
                        FetchedAppSettingsManager.m10806a(str, true);
                    }
                }
            }, 0L, 86400L, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11078a(String str, Double d, Bundle bundle) {
        m11077a(str, d, bundle, true, ActivityLifecycleTracker.m11038b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m11075a(String str, BigDecimal bigDecimal, Currency currency, Bundle bundle) {
        if (bigDecimal == null || currency == null) {
            Utility.m10505b(f1697a, "purchaseAmount and currency cannot be null");
            return;
        }
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putString("fb_currency", currency.getCurrencyCode());
        m11077a(str, Double.valueOf(bigDecimal.doubleValue()), bundle2, true, ActivityLifecycleTracker.m11038b());
    }

    /* renamed from: a */
    void m11077a(String str, Double d, Bundle bundle, boolean z, @Nullable UUID uuid) {
        if (str == null || str.isEmpty()) {
            return;
        }
        if (FetchedAppGateKeepersManager.m10702a("app_events_killswitch", FacebookSdk.m10865l(), false)) {
            Logger.m10633a(LoggingBehavior.APP_EVENTS, "AppEvents", "KillSwitch is enabled and fail to log app event: %s", str);
            return;
        }
        try {
            m11082a(new AppEvent(this.f1704b, str, d, bundle, z, ActivityLifecycleTracker.m11043a(), uuid), this.f1705c);
        } catch (FacebookException e) {
            Logger.m10633a(LoggingBehavior.APP_EVENTS, "AppEvents", "Invalid app event: %s", e.toString());
        } catch (JSONException e2) {
            Logger.m10633a(LoggingBehavior.APP_EVENTS, "AppEvents", "JSON encoding for app event failed: '%s'", e2.toString());
        }
    }

    /* renamed from: a */
    private static void m11082a(AppEvent appEvent, AccessTokenAppIdPair accessTokenAppIdPair) {
        AppEventQueue.m11237a(accessTokenAppIdPair, appEvent);
        if (appEvent.getIsImplicit() || f1702h) {
            return;
        }
        if (appEvent.getName().equals("fb_mobile_activate_app")) {
            f1702h = true;
        } else {
            Logger.m10634a(LoggingBehavior.APP_EVENTS, "AppEvents", "Warning: Please call AppEventsLogger.activateApp(...)from the long-lived activity's onResume() methodbefore logging other app events.");
        }
    }

    /* renamed from: f */
    static void m11067f() {
        if (m11086a() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            AppEventQueue.m11235a(FlushReason.EAGER_FLUSHING_EVENT);
        }
    }

    /* renamed from: b */
    private static void m11071b(String str) {
        Logger.m10634a(LoggingBehavior.DEVELOPER_ERRORS, "AppEvents", str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static Executor m11066g() {
        if (f1698d == null) {
            m11065h();
        }
        return f1698d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m11084a(Context context) {
        if (f1701g == null) {
            synchronized (f1700f) {
                if (f1701g == null) {
                    f1701g = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).getString("anonymousAppDeviceGUID", null);
                    if (f1701g == null) {
                        f1701g = "XZ" + UUID.randomUUID().toString();
                        context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0).edit().putString("anonymousAppDeviceGUID", f1701g).apply();
                    }
                }
            }
        }
        return f1701g;
    }
}
