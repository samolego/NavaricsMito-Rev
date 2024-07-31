package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import com.facebook.AccessToken;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.internal.k */
/* loaded from: classes.dex */
public final class FetchedAppGateKeepersManager {

    /* renamed from: a */
    private static final String f1958a = FetchedAppGateKeepersManager.class.getCanonicalName();

    /* renamed from: b */
    private static final AtomicBoolean f1959b = new AtomicBoolean(false);

    /* renamed from: c */
    private static final ConcurrentLinkedQueue<InterfaceC0956a> f1960c = new ConcurrentLinkedQueue<>();

    /* renamed from: d */
    private static final Map<String, JSONObject> f1961d = new ConcurrentHashMap();
    @Nullable

    /* renamed from: e */
    private static Long f1962e;

    /* compiled from: FetchedAppGateKeepersManager.java */
    /* renamed from: com.facebook.internal.k$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0956a {
        /* renamed from: a */
        void mo10693a();
    }

    /* renamed from: a */
    static void m10706a() {
        m10705a((InterfaceC0956a) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized void m10705a(@Nullable InterfaceC0956a interfaceC0956a) {
        synchronized (FetchedAppGateKeepersManager.class) {
            if (interfaceC0956a != null) {
                f1960c.add(interfaceC0956a);
            }
            if (m10698b(f1962e)) {
                m10694d();
                return;
            }
            final Context m10869h = FacebookSdk.m10869h();
            final String m10865l = FacebookSdk.m10865l();
            final String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", m10865l);
            if (m10869h == null) {
                return;
            }
            JSONObject jSONObject = null;
            String string = m10869h.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(format, null);
            if (!Utility.m10530a(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e) {
                    Utility.m10528a("FacebookSDK", (Exception) e);
                }
                if (jSONObject != null) {
                    m10696b(m10865l, jSONObject);
                }
            }
            Executor m10871f = FacebookSdk.m10871f();
            if (m10871f == null) {
                return;
            }
            if (f1959b.compareAndSet(false, true)) {
                m10871f.execute(new Runnable() { // from class: com.facebook.internal.k.1
                    @Override // java.lang.Runnable
                    public void run() {
                        JSONObject m10697b = FetchedAppGateKeepersManager.m10697b(m10865l);
                        if (m10697b != null) {
                            FetchedAppGateKeepersManager.m10696b(m10865l, m10697b);
                            m10869h.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(format, m10697b.toString()).apply();
                            Long unused = FetchedAppGateKeepersManager.f1962e = Long.valueOf(System.currentTimeMillis());
                        }
                        FetchedAppGateKeepersManager.m10694d();
                        FetchedAppGateKeepersManager.f1959b.set(false);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m10694d() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (!f1960c.isEmpty()) {
            final InterfaceC0956a poll = f1960c.poll();
            if (poll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.k.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InterfaceC0956a.this.mo10693a();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static JSONObject m10700a(String str, boolean z) {
        if (!z && f1961d.containsKey(str)) {
            return f1961d.get(str);
        }
        JSONObject m10697b = m10697b(str);
        if (m10697b == null) {
            return null;
        }
        FacebookSdk.m10869h().getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(String.format("com.facebook.internal.APP_GATEKEEPERS.%s", str), m10697b.toString()).apply();
        return m10696b(str, m10697b);
    }

    /* renamed from: a */
    public static boolean m10702a(String str, String str2, boolean z) {
        m10706a();
        return (str2 == null || !f1961d.containsKey(str2)) ? z : f1961d.get(str2).optBoolean(str, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    /* renamed from: b */
    public static JSONObject m10697b(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        bundle.putString("sdk_version", FacebookSdk.m10867j());
        bundle.putString("fields", "gatekeepers");
        GraphRequest m11395a = GraphRequest.m11395a((AccessToken) null, String.format("%s/%s", str, "mobile_sdk_gk"), (GraphRequest.InterfaceC0829b) null);
        m11395a.m11373a(true);
        m11395a.m11397a(bundle);
        return m11395a.m11349i().m10824b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static synchronized JSONObject m10696b(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        synchronized (FetchedAppGateKeepersManager.class) {
            if (f1961d.containsKey(str)) {
                jSONObject2 = f1961d.get(str);
            } else {
                jSONObject2 = new JSONObject();
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONObject optJSONObject = optJSONArray != null ? optJSONArray.optJSONObject(0) : null;
            if (optJSONObject != null && optJSONObject.optJSONArray("gatekeepers") != null) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("gatekeepers");
                for (int i = 0; i < optJSONArray2.length(); i++) {
                    try {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i);
                        jSONObject2.put(jSONObject3.getString("key"), jSONObject3.getBoolean("value"));
                    } catch (JSONException e) {
                        Utility.m10528a("FacebookSDK", (Exception) e);
                    }
                }
            }
            f1961d.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    /* renamed from: b */
    private static boolean m10698b(@Nullable Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < 3600000;
    }
}
