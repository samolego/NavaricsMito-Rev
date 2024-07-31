package com.facebook.appevents.internal;

import android.content.Context;
import android.support.p008v4.app.NotificationCompat;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.internal.Logger;
import com.facebook.internal.Utility;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class AppEventsLoggerUtility {

    /* renamed from: a */
    private static final Map<GraphAPIActivityType, String> f1717a = new HashMap<GraphAPIActivityType, String>() { // from class: com.facebook.appevents.internal.AppEventsLoggerUtility.1
        {
            put(GraphAPIActivityType.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL");
            put(GraphAPIActivityType.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS");
        }
    };

    /* loaded from: classes.dex */
    public enum GraphAPIActivityType {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS
    }

    /* renamed from: a */
    public static JSONObject m11044a(GraphAPIActivityType graphAPIActivityType, AttributionIdentifiers attributionIdentifiers, String str, boolean z, Context context) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(NotificationCompat.CATEGORY_EVENT, f1717a.get(graphAPIActivityType));
        String m11283d = AppEventsLogger.m11283d();
        if (m11283d != null) {
            jSONObject.put("app_user_id", m11283d);
        }
        Utility.m10514a(jSONObject, attributionIdentifiers, str, z);
        try {
            Utility.m10515a(jSONObject, context);
        } catch (Exception e) {
            Logger.m10633a(LoggingBehavior.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e.toString());
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
