package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.internal.v */
/* loaded from: classes.dex */
public final class ServerProtocol {

    /* renamed from: a */
    public static final Collection<String> f2054a = Utility.m10510a("service_disabled", "AndroidAuthKillSwitchException");

    /* renamed from: b */
    public static final Collection<String> f2055b = Utility.m10510a("access_denied", "OAuthAccessDeniedException");

    /* renamed from: c */
    private static final String f2056c = "com.facebook.internal.v";

    /* renamed from: d */
    public static final String m10552d() {
        return "v5.0";
    }

    /* renamed from: a */
    public static final String m10556a() {
        return String.format("m.%s", FacebookSdk.m10870g());
    }

    /* renamed from: b */
    public static final String m10554b() {
        return String.format("https://graph.%s", FacebookSdk.m10870g());
    }

    /* renamed from: c */
    public static final String m10553c() {
        return String.format("https://graph-video.%s", FacebookSdk.m10870g());
    }

    /* renamed from: a */
    public static Bundle m10555a(String str, int i, Bundle bundle) {
        String m10873d = FacebookSdk.m10873d(FacebookSdk.m10869h());
        if (Utility.m10530a(m10873d)) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("android_key_hash", m10873d);
        bundle2.putString("app_id", FacebookSdk.m10865l());
        bundle2.putInt("version", i);
        bundle2.putString("display", "touch");
        Bundle bundle3 = new Bundle();
        bundle3.putString("action_id", str);
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            JSONObject m10740a = BundleJSONConverter.m10740a(bundle3);
            JSONObject m10740a2 = BundleJSONConverter.m10740a(bundle);
            if (m10740a != null && m10740a2 != null) {
                bundle2.putString("bridge_args", m10740a.toString());
                bundle2.putString("method_args", m10740a2.toString());
                return bundle2;
            }
            return null;
        } catch (JSONException e) {
            LoggingBehavior loggingBehavior = LoggingBehavior.DEVELOPER_ERRORS;
            String str2 = f2056c;
            Logger.m10636a(loggingBehavior, 6, str2, "Error creating Url -- " + e);
            return null;
        }
    }
}
