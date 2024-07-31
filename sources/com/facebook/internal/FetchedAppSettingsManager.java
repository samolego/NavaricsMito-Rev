package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.internal.UnityReflection;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.appevents.internal.Constants;
import com.facebook.appevents.internal.InAppPurchaseActivityLifecycleTracker;
import com.facebook.internal.FetchedAppSettings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class FetchedAppSettingsManager {

    /* renamed from: a */
    private static final String f1894a = "FetchedAppSettingsManager";

    /* renamed from: b */
    private static final String[] f1895b = {"supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting"};

    /* renamed from: c */
    private static final Map<String, FetchedAppSettings> f1896c = new ConcurrentHashMap();

    /* renamed from: d */
    private static final AtomicReference<FetchAppSettingState> f1897d = new AtomicReference<>(FetchAppSettingState.NOT_LOADED);

    /* renamed from: e */
    private static final ConcurrentLinkedQueue<InterfaceC0930a> f1898e = new ConcurrentLinkedQueue<>();

    /* renamed from: f */
    private static boolean f1899f = false;

    /* renamed from: g */
    private static boolean f1900g = false;
    @Nullable

    /* renamed from: h */
    private static JSONArray f1901h = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum FetchAppSettingState {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR
    }

    /* renamed from: com.facebook.internal.FetchedAppSettingsManager$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0930a {
        /* renamed from: a */
        void m10794a();

        /* renamed from: a */
        void m10793a(FetchedAppSettings fetchedAppSettings);
    }

    /* renamed from: a */
    public static void m10809a() {
        final Context m10869h = FacebookSdk.m10869h();
        final String m10865l = FacebookSdk.m10865l();
        if (Utility.m10530a(m10865l)) {
            f1897d.set(FetchAppSettingState.ERROR);
            m10795g();
        } else if (f1896c.containsKey(m10865l)) {
            f1897d.set(FetchAppSettingState.SUCCESS);
            m10795g();
        } else {
            if (!(f1897d.compareAndSet(FetchAppSettingState.NOT_LOADED, FetchAppSettingState.LOADING) || f1897d.compareAndSet(FetchAppSettingState.ERROR, FetchAppSettingState.LOADING))) {
                m10795g();
                return;
            }
            final String format = String.format("com.facebook.internal.APP_SETTINGS.%s", m10865l);
            FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.internal.FetchedAppSettingsManager.1
                @Override // java.lang.Runnable
                public void run() {
                    JSONObject jSONObject;
                    SharedPreferences sharedPreferences = m10869h.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
                    FetchedAppSettings fetchedAppSettings = null;
                    String string = sharedPreferences.getString(format, null);
                    if (!Utility.m10530a(string)) {
                        try {
                            jSONObject = new JSONObject(string);
                        } catch (JSONException e) {
                            Utility.m10528a("FacebookSDK", (Exception) e);
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            fetchedAppSettings = FetchedAppSettingsManager.m10801b(m10865l, jSONObject);
                        }
                    }
                    JSONObject m10799c = FetchedAppSettingsManager.m10799c(m10865l);
                    if (m10799c != null) {
                        FetchedAppSettingsManager.m10801b(m10865l, m10799c);
                        sharedPreferences.edit().putString(format, m10799c.toString()).apply();
                    }
                    if (fetchedAppSettings != null) {
                        String m10682j = fetchedAppSettings.m10682j();
                        if (!FetchedAppSettingsManager.f1899f && m10682j != null && m10682j.length() > 0) {
                            boolean unused = FetchedAppSettingsManager.f1899f = true;
                            Log.w(FetchedAppSettingsManager.f1894a, m10682j);
                        }
                    }
                    FetchedAppGateKeepersManager.m10700a(m10865l, true);
                    AutomaticAnalyticsLogger.m11013a();
                    InAppPurchaseActivityLifecycleTracker.m11004a();
                    FetchedAppSettingsManager.f1897d.set(FetchedAppSettingsManager.f1896c.containsKey(m10865l) ? FetchAppSettingState.SUCCESS : FetchAppSettingState.ERROR);
                    FetchedAppSettingsManager.m10795g();
                }
            });
        }
    }

    @Nullable
    /* renamed from: a */
    public static FetchedAppSettings m10808a(String str) {
        if (str != null) {
            return f1896c.get(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static synchronized void m10795g() {
        synchronized (FetchedAppSettingsManager.class) {
            FetchAppSettingState fetchAppSettingState = f1897d.get();
            if (!FetchAppSettingState.NOT_LOADED.equals(fetchAppSettingState) && !FetchAppSettingState.LOADING.equals(fetchAppSettingState)) {
                final FetchedAppSettings fetchedAppSettings = f1896c.get(FacebookSdk.m10865l());
                Handler handler = new Handler(Looper.getMainLooper());
                if (FetchAppSettingState.ERROR.equals(fetchAppSettingState)) {
                    while (!f1898e.isEmpty()) {
                        final InterfaceC0930a poll = f1898e.poll();
                        handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppSettingsManager.2
                            @Override // java.lang.Runnable
                            public void run() {
                                InterfaceC0930a.this.m10794a();
                            }
                        });
                    }
                    return;
                }
                while (!f1898e.isEmpty()) {
                    final InterfaceC0930a poll2 = f1898e.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.FetchedAppSettingsManager.3
                        @Override // java.lang.Runnable
                        public void run() {
                            InterfaceC0930a.this.m10793a(fetchedAppSettings);
                        }
                    });
                }
            }
        }
    }

    @Nullable
    /* renamed from: a */
    public static FetchedAppSettings m10806a(String str, boolean z) {
        if (!z && f1896c.containsKey(str)) {
            return f1896c.get(str);
        }
        JSONObject m10799c = m10799c(str);
        if (m10799c == null) {
            return null;
        }
        FetchedAppSettings m10801b = m10801b(str, m10799c);
        if (str.equals(FacebookSdk.m10865l())) {
            f1897d.set(FetchAppSettingState.SUCCESS);
            m10795g();
        }
        return m10801b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static FetchedAppSettings m10801b(String str, JSONObject jSONObject) {
        FacebookRequestErrorClassification m10713a;
        JSONArray optJSONArray = jSONObject.optJSONArray("android_sdk_error_categories");
        if (optJSONArray == null) {
            m10713a = FacebookRequestErrorClassification.m10716a();
        } else {
            m10713a = FacebookRequestErrorClassification.m10713a(optJSONArray);
        }
        int optInt = jSONObject.optInt("app_events_feature_bitmask", 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("auto_event_mapping_android");
        f1901h = optJSONArray2;
        if (f1901h != null && InternalSettings.m10643b()) {
            UnityReflection.m11110a(optJSONArray2.toString());
        }
        FetchedAppSettings fetchedAppSettings = new FetchedAppSettings(jSONObject.optBoolean("supports_implicit_sdk_logging", false), jSONObject.optString("gdpv4_nux_content", ""), jSONObject.optBoolean("gdpv4_nux_enabled", false), jSONObject.optInt("app_events_session_timeout", Constants.m11007a()), SmartLoginOption.parseOptions(jSONObject.optLong("seamless_login")), m10805a(jSONObject.optJSONObject("android_dialog_configs")), z, m10713a, jSONObject.optString("smart_login_bookmark_icon_url"), jSONObject.optString("smart_login_menu_icon_url"), z2, z3, optJSONArray2, jSONObject.optString("sdk_update_message"), z4, jSONObject.optString("aam_rules"), jSONObject.optString("suggested_events_setting"), jSONObject.optString("restrictive_data_filter_params"));
        f1896c.put(str, fetchedAppSettings);
        return fetchedAppSettings;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static JSONObject m10799c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", TextUtils.join(",", new ArrayList(Arrays.asList(f1895b))));
        GraphRequest m11395a = GraphRequest.m11395a((AccessToken) null, str, (GraphRequest.InterfaceC0829b) null);
        m11395a.m11373a(true);
        m11395a.m11397a(bundle);
        return m11395a.m11349i().m10824b();
    }

    /* renamed from: a */
    private static Map<String, Map<String, FetchedAppSettings.C0957a>> m10805a(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                FetchedAppSettings.C0957a m10676a = FetchedAppSettings.C0957a.m10676a(optJSONArray.optJSONObject(i));
                if (m10676a != null) {
                    String m10678a = m10676a.m10678a();
                    Map map = (Map) hashMap.get(m10678a);
                    if (map == null) {
                        map = new HashMap();
                        hashMap.put(m10678a, map);
                    }
                    map.put(m10676a.m10675b(), m10676a);
                }
            }
        }
        return hashMap;
    }
}
