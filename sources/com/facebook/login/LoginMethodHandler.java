package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookException;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Utility;
import com.facebook.login.LoginClient;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class LoginMethodHandler implements Parcelable {

    /* renamed from: a */
    Map<String, String> f2204a;

    /* renamed from: b */
    protected LoginClient f2205b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract String mo10256a();

    /* renamed from: a */
    void mo10272a(JSONObject jSONObject) throws JSONException {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo10269a(int i, int i2, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public abstract boolean mo10255a(LoginClient.Request request);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo10254b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo10251e() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginMethodHandler(LoginClient loginClient) {
        this.f2205b = loginClient;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LoginMethodHandler(Parcel parcel) {
        this.f2204a = Utility.m10541a(parcel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10276a(LoginClient loginClient) {
        if (this.f2205b != null) {
            throw new FacebookException("Can't set LoginClient if it is already set.");
        }
        this.f2205b = loginClient;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public String m10275a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", mo10256a());
            mo10272a(jSONObject);
        } catch (JSONException e) {
            Log.w("LoginMethodHandler", "Error creating client state json: " + e.getMessage());
        }
        return jSONObject.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m10274a(String str, Object obj) {
        if (this.f2204a == null) {
            this.f2204a = new HashMap();
        }
        this.f2204a.put(str, obj == null ? null : obj.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m10271b(String str) {
        String m10301d = this.f2205b.m10323c().m10301d();
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(this.f2205b.m10326b(), m10301d);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString("app_id", m10301d);
        internalAppEventsLogger.m11059a("fb_dialogs_web_login_dialog_complete", (Double) null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static AccessToken m10277a(Bundle bundle, AccessTokenSource accessTokenSource, String str) {
        Date m10542a = Utility.m10542a(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
        ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
        String string = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
        Date m10542a2 = Utility.m10542a(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
        if (Utility.m10530a(string)) {
            return null;
        }
        return new AccessToken(string, str, bundle.getString("com.facebook.platform.extra.USER_ID"), stringArrayList, null, null, accessTokenSource, m10542a, new Date(), m10542a2);
    }

    /* renamed from: a */
    public static AccessToken m10273a(Collection<String> collection, Bundle bundle, AccessTokenSource accessTokenSource, String str) throws FacebookException {
        Date m10542a = Utility.m10542a(bundle, "expires_in", new Date());
        String string = bundle.getString("access_token");
        Date m10542a2 = Utility.m10542a(bundle, "data_access_expiration_time", new Date(0L));
        String string2 = bundle.getString("granted_scopes");
        ArrayList arrayList = !Utility.m10530a(string2) ? new ArrayList(Arrays.asList(string2.split(","))) : collection;
        String string3 = bundle.getString("denied_scopes");
        ArrayList arrayList2 = !Utility.m10530a(string3) ? new ArrayList(Arrays.asList(string3.split(","))) : null;
        String string4 = bundle.getString("expired_scopes");
        ArrayList arrayList3 = !Utility.m10530a(string4) ? new ArrayList(Arrays.asList(string4.split(","))) : null;
        if (Utility.m10530a(string)) {
            return null;
        }
        return new AccessToken(string, str, m10270c(bundle.getString("signed_request")), arrayList, arrayList2, arrayList3, accessTokenSource, m10542a, new Date(), m10542a2);
    }

    /* renamed from: c */
    static String m10270c(String str) throws FacebookException {
        if (str == null || str.isEmpty()) {
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
        try {
            String[] split = str.split("\\.");
            if (split.length == 2) {
                return new JSONObject(new String(Base64.decode(split[1], 0), "UTF-8")).getString("user_id");
            }
        } catch (UnsupportedEncodingException | JSONException unused) {
        }
        throw new FacebookException("Failed to retrieve user_id from signed_request");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        Utility.m10540a(parcel, this.f2204a);
    }
}
