package com.facebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.q */
/* loaded from: classes.dex */
public final class UserSettingsManager {

    /* renamed from: a */
    private static final String f2242a = "com.facebook.q";

    /* renamed from: b */
    private static AtomicBoolean f2243b = new AtomicBoolean(false);

    /* renamed from: c */
    private static AtomicBoolean f2244c = new AtomicBoolean(false);

    /* renamed from: d */
    private static C1027a f2245d = new C1027a(true, "com.facebook.sdk.AutoInitEnabled");

    /* renamed from: e */
    private static C1027a f2246e = new C1027a(true, "com.facebook.sdk.AutoLogAppEventsEnabled");

    /* renamed from: f */
    private static C1027a f2247f = new C1027a(true, "com.facebook.sdk.AdvertiserIDCollectionEnabled");

    /* renamed from: g */
    private static C1027a f2248g = new C1027a(false, "auto_event_setup_enabled");

    /* renamed from: h */
    private static SharedPreferences f2249h;

    UserSettingsManager() {
    }

    /* renamed from: a */
    public static void m10223a() {
        if (FacebookSdk.m10885a() && f2243b.compareAndSet(false, true)) {
            f2249h = FacebookSdk.m10869h().getSharedPreferences("com.facebook.sdk.USER_SETTINGS", 0);
            m10221a(f2246e, f2247f, f2245d);
            m10210i();
            m10209j();
            m10208k();
            m10207l();
        }
    }

    /* renamed from: a */
    private static void m10221a(C1027a... c1027aArr) {
        for (C1027a c1027a : c1027aArr) {
            if (c1027a == f2248g) {
                m10210i();
            } else if (c1027a.f2252b == null) {
                m10217c(c1027a);
                if (c1027a.f2252b == null) {
                    m10215d(c1027a);
                }
            } else {
                m10219b(c1027a);
            }
        }
    }

    /* renamed from: i */
    private static void m10210i() {
        m10217c(f2248g);
        final long currentTimeMillis = System.currentTimeMillis();
        if (f2248g.f2252b == null || currentTimeMillis - f2248g.f2254d >= 604800000) {
            C1027a c1027a = f2248g;
            c1027a.f2252b = null;
            c1027a.f2254d = 0L;
            if (f2244c.compareAndSet(false, true)) {
                FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.q.1
                    @Override // java.lang.Runnable
                    public void run() {
                        FetchedAppSettings m10806a;
                        if (UserSettingsManager.f2247f.m10205a() && (m10806a = FetchedAppSettingsManager.m10806a(FacebookSdk.m10865l(), false)) != null && m10806a.m10684h()) {
                            AttributionIdentifiers m10751b = AttributionIdentifiers.m10751b(FacebookSdk.m10869h());
                            if (((m10751b == null || m10751b.m10752b() == null) ? null : m10751b.m10752b()) != null) {
                                Bundle bundle = new Bundle();
                                bundle.putString("advertiser_id", m10751b.m10752b());
                                bundle.putString("fields", "auto_event_setup_enabled");
                                GraphRequest m11395a = GraphRequest.m11395a((AccessToken) null, FacebookSdk.m10865l(), (GraphRequest.InterfaceC0829b) null);
                                m11395a.m11373a(true);
                                m11395a.m11397a(bundle);
                                JSONObject m10824b = m11395a.m11349i().m10824b();
                                if (m10824b != null) {
                                    UserSettingsManager.f2248g.f2252b = Boolean.valueOf(m10824b.optBoolean("auto_event_setup_enabled", false));
                                    UserSettingsManager.f2248g.f2254d = currentTimeMillis;
                                    UserSettingsManager.m10219b(UserSettingsManager.f2248g);
                                }
                            }
                        }
                        UserSettingsManager.f2244c.set(false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m10219b(C1027a c1027a) {
        m10206m();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", c1027a.f2252b);
            jSONObject.put("last_timestamp", c1027a.f2254d);
            f2249h.edit().putString(c1027a.f2251a, jSONObject.toString()).commit();
            m10208k();
        } catch (Exception e) {
            Utility.m10528a(f2242a, e);
        }
    }

    /* renamed from: c */
    private static void m10217c(C1027a c1027a) {
        m10206m();
        try {
            String string = f2249h.getString(c1027a.f2251a, "");
            if (string.isEmpty()) {
                return;
            }
            JSONObject jSONObject = new JSONObject(string);
            c1027a.f2252b = Boolean.valueOf(jSONObject.getBoolean("value"));
            c1027a.f2254d = jSONObject.getLong("last_timestamp");
        } catch (JSONException e) {
            Utility.m10528a(f2242a, (Exception) e);
        }
    }

    /* renamed from: d */
    private static void m10215d(C1027a c1027a) {
        m10206m();
        try {
            Context m10869h = FacebookSdk.m10869h();
            ApplicationInfo applicationInfo = m10869h.getPackageManager().getApplicationInfo(m10869h.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.containsKey(c1027a.f2251a)) {
                return;
            }
            c1027a.f2252b = Boolean.valueOf(applicationInfo.metaData.getBoolean(c1027a.f2251a, c1027a.f2253c));
        } catch (PackageManager.NameNotFoundException e) {
            Utility.m10528a(f2242a, (Exception) e);
        }
    }

    /* renamed from: j */
    private static void m10209j() {
        try {
            Context m10869h = FacebookSdk.m10869h();
            ApplicationInfo applicationInfo = m10869h.getPackageManager().getApplicationInfo(m10869h.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null) {
                return;
            }
            if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AutoLogAppEventsEnabled")) {
                Log.w(f2242a, "Please set a value for AutoLogAppEventsEnabled. Set the flag to TRUE if you want to collect app install, app launch and in-app purchase events automatically. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
            }
            if (!applicationInfo.metaData.containsKey("com.facebook.sdk.AdvertiserIDCollectionEnabled")) {
                Log.w(f2242a, "You haven't set a value for AdvertiserIDCollectionEnabled. Set the flag to TRUE if you want to collect Advertiser ID for better advertising and analytics results. To request user consent before collecting data, set the flag value to FALSE, then change to TRUE once user consent is received. Learn more: https://developers.facebook.com/docs/app-events/getting-started-app-events-android#disable-auto-events.");
            }
            if (m10216d()) {
                return;
            }
            Log.w(f2242a, "The value for AdvertiserIDCollectionEnabled is currently set to FALSE so you're sending app events without collecting Advertiser ID. This can affect the quality of your advertising and analytics results.");
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: k */
    private static void m10208k() {
        int i;
        ApplicationInfo applicationInfo;
        if (f2243b.get() && FacebookSdk.m10885a()) {
            Context m10869h = FacebookSdk.m10869h();
            int i2 = 0;
            int i3 = ((f2245d.m10205a() ? 1 : 0) << 0) | 0 | ((f2246e.m10205a() ? 1 : 0) << 1) | ((f2247f.m10205a() ? 1 : 0) << 2);
            int i4 = f2249h.getInt("com.facebook.sdk.USER_SETTINGS_BITMASK", 0);
            if (i4 != i3) {
                f2249h.edit().putInt("com.facebook.sdk.USER_SETTINGS_BITMASK", i3).commit();
                try {
                    applicationInfo = m10869h.getPackageManager().getApplicationInfo(m10869h.getPackageName(), 128);
                } catch (PackageManager.NameNotFoundException unused) {
                }
                if (applicationInfo != null && applicationInfo.metaData != null) {
                    String[] strArr = {"com.facebook.sdk.AutoInitEnabled", "com.facebook.sdk.AutoLogAppEventsEnabled", "com.facebook.sdk.AdvertiserIDCollectionEnabled"};
                    boolean[] zArr = {true, true, true};
                    int i5 = 0;
                    i = 0;
                    for (int i6 = 0; i6 < strArr.length; i6++) {
                        try {
                            i5 |= (applicationInfo.metaData.containsKey(strArr[i6]) ? 1 : 0) << i6;
                            i |= (applicationInfo.metaData.getBoolean(strArr[i6], zArr[i6]) ? 1 : 0) << i6;
                        } catch (PackageManager.NameNotFoundException unused2) {
                            i2 = i5;
                        }
                    }
                    i2 = i5;
                    InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(m10869h);
                    Bundle bundle = new Bundle();
                    bundle.putInt("usage", i2);
                    bundle.putInt("initial", i);
                    bundle.putInt("previous", i4);
                    bundle.putInt("current", i3);
                    internalAppEventsLogger.m11053b("fb_sdk_settings_changed", bundle);
                }
                i = 0;
                InternalAppEventsLogger internalAppEventsLogger2 = new InternalAppEventsLogger(m10869h);
                Bundle bundle2 = new Bundle();
                bundle2.putInt("usage", i2);
                bundle2.putInt("initial", i);
                bundle2.putInt("previous", i4);
                bundle2.putInt("current", i3);
                internalAppEventsLogger2.m11053b("fb_sdk_settings_changed", bundle2);
            }
        }
    }

    /* renamed from: l */
    private static void m10207l() {
        try {
            Context m10869h = FacebookSdk.m10869h();
            ApplicationInfo applicationInfo = m10869h.getPackageManager().getApplicationInfo(m10869h.getPackageName(), 128);
            if (applicationInfo == null || applicationInfo.metaData == null || !applicationInfo.metaData.getBoolean("com.facebook.sdk.AutoAppLinkEnabled", false)) {
                return;
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(m10869h);
            Bundle bundle = new Bundle();
            if (!Utility.m10493d()) {
                bundle.putString("SchemeWarning", "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
                Log.w(f2242a, "You haven't set the Auto App Link URL scheme: fb<YOUR APP ID> in AndroidManifest");
            }
            internalAppEventsLogger.m11060a("fb_auto_applink", bundle);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: m */
    private static void m10206m() {
        if (!f2243b.get()) {
            throw new FacebookSdkNotInitializedException("The UserSettingManager has not been initialized successfully");
        }
    }

    /* renamed from: b */
    public static boolean m10220b() {
        m10223a();
        return f2245d.m10205a();
    }

    /* renamed from: c */
    public static boolean m10218c() {
        m10223a();
        return f2246e.m10205a();
    }

    /* renamed from: d */
    public static boolean m10216d() {
        m10223a();
        return f2247f.m10205a();
    }

    /* renamed from: e */
    public static boolean m10214e() {
        m10223a();
        return f2248g.m10205a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UserSettingsManager.java */
    /* renamed from: com.facebook.q$a */
    /* loaded from: classes.dex */
    public static class C1027a {

        /* renamed from: a */
        String f2251a;

        /* renamed from: b */
        Boolean f2252b;

        /* renamed from: c */
        boolean f2253c;

        /* renamed from: d */
        long f2254d;

        C1027a(boolean z, String str) {
            this.f2253c = z;
            this.f2251a = str;
        }

        /* renamed from: a */
        boolean m10205a() {
            Boolean bool = this.f2252b;
            return bool == null ? this.f2253c : bool.booleanValue();
        }
    }
}
