package com.facebook.appevents.p041c;

import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.view.View;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.internal.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* renamed from: com.facebook.appevents.c.b */
/* loaded from: classes.dex */
final class PredictionHistoryManager {

    /* renamed from: b */
    private static SharedPreferences f1581b;

    /* renamed from: a */
    private static final Map<String, String> f1580a = new HashMap();

    /* renamed from: c */
    private static final AtomicBoolean f1582c = new AtomicBoolean(false);

    /* renamed from: a */
    private static void m11210a() {
        if (f1582c.get()) {
            return;
        }
        f1581b = FacebookSdk.m10869h().getSharedPreferences("com.facebook.internal.SUGGESTED_EVENTS_HISTORY", 0);
        f1580a.putAll(Utility.m10486e(f1581b.getString("SUGGESTED_EVENTS_HISTORY", "")));
        f1582c.set(true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11207a(String str, String str2) {
        if (!f1582c.get()) {
            m11210a();
        }
        f1580a.put(str, str2);
        f1581b.edit().putString("SUGGESTED_EVENTS_HISTORY", Utility.m10518a(f1580a)).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static String m11209a(View view) {
        JSONObject jSONObject = new JSONObject();
        while (view != null) {
            SuggestedEventViewHierarchy.m11204a(view, jSONObject);
            view = ViewHierarchy.m11107a(view);
        }
        return Utility.m10497c(jSONObject.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static String m11208a(String str) {
        if (f1580a.containsKey(str)) {
            return f1580a.get(str);
        }
        return null;
    }
}
