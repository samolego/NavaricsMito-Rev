package com.facebook.appevents.codeless;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.appevents.codeless.ViewIndexingTrigger;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.codeless.b */
/* loaded from: classes.dex */
public final class CodelessManager {
    @Nullable

    /* renamed from: b */
    private static SensorManager f1620b;
    @Nullable

    /* renamed from: c */
    private static ViewIndexer f1621c;
    @Nullable

    /* renamed from: d */
    private static String f1622d;

    /* renamed from: a */
    private static final ViewIndexingTrigger f1619a = new ViewIndexingTrigger();

    /* renamed from: e */
    private static final AtomicBoolean f1623e = new AtomicBoolean(true);

    /* renamed from: f */
    private static Boolean f1624f = false;

    /* renamed from: g */
    private static volatile Boolean f1625g = false;

    /* renamed from: a */
    public static void m11175a(Activity activity) {
        if (f1623e.get()) {
            CodelessMatcher.m11161a().m11160a(activity);
            Context applicationContext = activity.getApplicationContext();
            final String m10865l = FacebookSdk.m10865l();
            final FetchedAppSettings m10808a = FetchedAppSettingsManager.m10808a(m10865l);
            if (m10808a == null || !m10808a.m10684h()) {
                return;
            }
            f1620b = (SensorManager) applicationContext.getSystemService("sensor");
            SensorManager sensorManager = f1620b;
            if (sensorManager == null) {
                return;
            }
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            f1621c = new ViewIndexer(activity);
            f1619a.setOnShakeListener(new ViewIndexingTrigger.InterfaceC0869a() { // from class: com.facebook.appevents.codeless.b.1
                @Override // com.facebook.appevents.codeless.ViewIndexingTrigger.InterfaceC0869a
                /* renamed from: a */
                public void mo11125a() {
                    FetchedAppSettings fetchedAppSettings = FetchedAppSettings.this;
                    boolean z = fetchedAppSettings != null && fetchedAppSettings.m10684h();
                    boolean z2 = FacebookSdk.m10860q();
                    if (z && z2) {
                        CodelessManager.m11165c(m10865l);
                    }
                }
            });
            f1620b.registerListener(f1619a, defaultSensor, 2);
            if (m10808a == null || !m10808a.m10684h()) {
                return;
            }
            f1621c.m11138a();
        }
    }

    /* renamed from: b */
    public static void m11171b(Activity activity) {
        if (f1623e.get()) {
            CodelessMatcher.m11161a().m11156b(activity);
            ViewIndexer viewIndexer = f1621c;
            if (viewIndexer != null) {
                viewIndexer.m11132b();
            }
            SensorManager sensorManager = f1620b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(f1619a);
            }
        }
    }

    /* renamed from: c */
    public static void m11167c(Activity activity) {
        CodelessMatcher.m11161a().m11154c(activity);
    }

    /* renamed from: a */
    public static void m11176a() {
        f1623e.set(true);
    }

    /* renamed from: b */
    public static void m11172b() {
        f1623e.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m11165c(final String str) {
        if (f1625g.booleanValue()) {
            return;
        }
        f1625g = true;
        FacebookSdk.m10871f().execute(new Runnable() { // from class: com.facebook.appevents.codeless.b.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                GraphRequest m11394a = GraphRequest.m11394a((AccessToken) null, String.format(Locale.US, "%s/app_indexing_session", str), (JSONObject) null, (GraphRequest.InterfaceC0829b) null);
                Bundle m11358e = m11394a.m11358e();
                if (m11358e == null) {
                    m11358e = new Bundle();
                }
                AttributionIdentifiers m10751b = AttributionIdentifiers.m10751b(FacebookSdk.m10869h());
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(Build.MODEL != null ? Build.MODEL : "");
                if (m10751b != null && m10751b.m10752b() != null) {
                    jSONArray.put(m10751b.m10752b());
                } else {
                    jSONArray.put("");
                }
                jSONArray.put("0");
                jSONArray.put(AppEventUtility.m11015c() ? "1" : "0");
                Locale m10500c = Utility.m10500c();
                jSONArray.put(m10500c.getLanguage() + "_" + m10500c.getCountry());
                String jSONArray2 = jSONArray.toString();
                m11358e.putString("device_session_id", CodelessManager.m11168c());
                m11358e.putString("extinfo", jSONArray2);
                m11394a.m11397a(m11358e);
                JSONObject m10824b = m11394a.m11349i().m10824b();
                Boolean unused = CodelessManager.f1624f = Boolean.valueOf((m10824b == null || !m10824b.optBoolean("is_app_indexing_enabled", false)) ? false : false);
                if (!CodelessManager.f1624f.booleanValue()) {
                    String unused2 = CodelessManager.f1622d = null;
                } else if (CodelessManager.f1621c != null) {
                    CodelessManager.f1621c.m11138a();
                }
                Boolean unused3 = CodelessManager.f1625g = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m11168c() {
        if (f1622d == null) {
            f1622d = UUID.randomUUID().toString();
        }
        return f1622d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static boolean m11164d() {
        return f1624f.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11174a(Boolean bool) {
        f1624f = bool;
    }
}
