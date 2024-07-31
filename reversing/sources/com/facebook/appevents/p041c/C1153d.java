package com.facebook.appevents.p041c;

import android.app.Activity;
import android.support.annotation.RestrictTo;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.ActivityLifecycleTracker;
import com.facebook.appevents.p042ml.ModelManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* renamed from: com.facebook.appevents.c.d */
/* loaded from: classes.dex */
public final class SuggestedEventsManager {

    /* renamed from: a */
    private static final AtomicBoolean f1585a = new AtomicBoolean(false);

    /* renamed from: b */
    private static final Set<String> f1586b = new HashSet();

    /* renamed from: c */
    private static final Set<String> f1587c = new HashSet();

    /* renamed from: a */
    public static synchronized void m11203a() {
        synchronized (SuggestedEventsManager.class) {
            if (f1585a.get()) {
                return;
            }
            f1585a.set(true);
            m11200b();
        }
    }

    /* renamed from: b */
    private static void m11200b() {
        String m10680l;
        File m10934a;
        try {
            FetchedAppSettings m10806a = FetchedAppSettingsManager.m10806a(FacebookSdk.m10865l(), false);
            if (m10806a == null || (m10680l = m10806a.m10680l()) == null) {
                return;
            }
            JSONObject jSONObject = new JSONObject(m10680l);
            if (jSONObject.has("production_events")) {
                JSONArray jSONArray = jSONObject.getJSONArray("production_events");
                for (int i = 0; i < jSONArray.length(); i++) {
                    f1586b.add(jSONArray.getString(i));
                }
            }
            if (jSONObject.has("eligible_for_prediction_events")) {
                JSONArray jSONArray2 = jSONObject.getJSONArray("eligible_for_prediction_events");
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    f1587c.add(jSONArray2.getString(i2));
                }
            }
            if ((f1586b.isEmpty() && f1587c.isEmpty()) || (m10934a = ModelManager.m10934a("SUGGEST_EVENT")) == null) {
                return;
            }
            FeatureExtractor.m11223a(m10934a);
            Activity m11036c = ActivityLifecycleTracker.m11036c();
            if (m11036c != null) {
                m11202a(m11036c);
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m11202a(Activity activity) {
        try {
            if (f1585a.get() && FeatureExtractor.m11224a() && (!f1586b.isEmpty() || !f1587c.isEmpty())) {
                ViewObserver.m11197a(activity);
            } else {
                ViewObserver.m11194b(activity);
            }
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static boolean m11201a(String str) {
        return f1586b.contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static boolean m11199b(String str) {
        return f1587c.contains(str);
    }
}
