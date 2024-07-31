package com.facebook.appevents.internal;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.FetchedAppGateKeepersManager;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Validate;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* renamed from: com.facebook.appevents.internal.c */
/* loaded from: classes.dex */
public class AutomaticAnalyticsLogger {

    /* renamed from: a */
    private static final String f1736a = AutomaticAnalyticsLogger.class.getCanonicalName();

    /* renamed from: b */
    private static final InternalAppEventsLogger f1737b = new InternalAppEventsLogger(FacebookSdk.m10869h());

    /* renamed from: a */
    public static void m11013a() {
        Context m10869h = FacebookSdk.m10869h();
        String m10865l = FacebookSdk.m10865l();
        boolean m10861p = FacebookSdk.m10861p();
        Validate.m10469a(m10869h, "context");
        if (m10861p) {
            if (m10869h instanceof Application) {
                AppEventsLogger.m11291a((Application) m10869h, m10865l);
            } else {
                Log.w(f1736a, "Automatic logging of basic events will not happen, because FacebookSdk.getApplicationContext() returns object that is not instance of android.app.Application. Make sure you call FacebookSdk.sdkInitialize() from Application class and pass application context.");
            }
        }
    }

    /* renamed from: a */
    public static void m11012a(String str, long j) {
        Context m10869h = FacebookSdk.m10869h();
        String m10865l = FacebookSdk.m10865l();
        Validate.m10469a(m10869h, "context");
        FetchedAppSettings m10806a = FetchedAppSettingsManager.m10806a(m10865l, false);
        if (m10806a == null || !m10806a.m10689c() || j <= 0) {
            return;
        }
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(m10869h);
        Bundle bundle = new Bundle(1);
        bundle.putCharSequence("fb_aa_time_spent_view_name", str);
        internalAppEventsLogger.m11061a("fb_aa_time_spent_on_view", j, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m11009a(String str, String str2, boolean z) {
        C0883a m11011a;
        if (m11008b() && (m11011a = m11011a(str, str2)) != null) {
            boolean z2 = false;
            if (z && FetchedAppGateKeepersManager.m10702a("app_events_if_auto_log_subs", FacebookSdk.m10865l(), false)) {
                z2 = true;
            }
            if (z2) {
                f1737b.m11057a(InAppPurchaseEventManager.m10988a(str2) ? "StartTrial" : "Subscribe", m11011a.f1738a, m11011a.f1739b, m11011a.f1740c);
            } else {
                f1737b.m11056a(m11011a.f1738a, m11011a.f1739b, m11011a.f1740c);
            }
        }
    }

    /* renamed from: b */
    public static boolean m11008b() {
        FetchedAppSettings m10808a = FetchedAppSettingsManager.m10808a(FacebookSdk.m10865l());
        return m10808a != null && FacebookSdk.m10861p() && m10808a.m10685g();
    }

    @Nullable
    /* renamed from: a */
    private static C0883a m11011a(String str, String str2) {
        return m11010a(str, str2, new HashMap());
    }

    @Nullable
    /* renamed from: a */
    private static C0883a m11010a(String str, String str2, Map<String, String> map) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = new JSONObject(str2);
            Bundle bundle = new Bundle(1);
            bundle.putCharSequence("fb_iap_product_id", jSONObject.getString("productId"));
            bundle.putCharSequence("fb_iap_purchase_time", jSONObject.getString("purchaseTime"));
            bundle.putCharSequence("fb_iap_purchase_token", jSONObject.getString("purchaseToken"));
            bundle.putCharSequence("fb_iap_package_name", jSONObject.optString("packageName"));
            bundle.putCharSequence("fb_iap_product_title", jSONObject2.optString("title"));
            bundle.putCharSequence("fb_iap_product_description", jSONObject2.optString("description"));
            String optString = jSONObject2.optString(IjkMediaMeta.IJKM_KEY_TYPE);
            bundle.putCharSequence("fb_iap_product_type", optString);
            if (optString.equals("subs")) {
                bundle.putCharSequence("fb_iap_subs_auto_renewing", Boolean.toString(jSONObject.optBoolean("autoRenewing", false)));
                bundle.putCharSequence("fb_iap_subs_period", jSONObject2.optString("subscriptionPeriod"));
                bundle.putCharSequence("fb_free_trial_period", jSONObject2.optString("freeTrialPeriod"));
                String optString2 = jSONObject2.optString("introductoryPriceCycles");
                if (!optString2.isEmpty()) {
                    bundle.putCharSequence("fb_intro_price_amount_micros", jSONObject2.optString("introductoryPriceAmountMicros"));
                    bundle.putCharSequence("fb_intro_price_cycles", optString2);
                }
            }
            for (String str3 : map.keySet()) {
                bundle.putCharSequence(str3, map.get(str3));
            }
            return new C0883a(new BigDecimal(jSONObject2.getLong("price_amount_micros") / 1000000.0d), Currency.getInstance(jSONObject2.getString("price_currency_code")), bundle);
        } catch (JSONException e) {
            Log.e(f1736a, "Error parsing in-app subscription data.", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AutomaticAnalyticsLogger.java */
    /* renamed from: com.facebook.appevents.internal.c$a */
    /* loaded from: classes.dex */
    public static class C0883a {

        /* renamed from: a */
        BigDecimal f1738a;

        /* renamed from: b */
        Currency f1739b;

        /* renamed from: c */
        Bundle f1740c;

        C0883a(BigDecimal bigDecimal, Currency currency, Bundle bundle) {
            this.f1738a = bigDecimal;
            this.f1739b = currency;
            this.f1740c = bundle;
        }
    }
}
