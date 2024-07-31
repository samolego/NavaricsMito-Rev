package com.facebook;

import android.content.SharedPreferences;
import com.facebook.internal.Validate;
import com.google.android.gms.common.Scopes;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.k */
/* loaded from: classes.dex */
public final class ProfileCache {

    /* renamed from: a */
    private final SharedPreferences f2122a = FacebookSdk.m10869h().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public Profile m10406a() {
        String string = this.f2122a.getString("com.facebook.ProfileManager.CachedProfile", null);
        if (string != null) {
            try {
                return new Profile(new JSONObject(string));
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10405a(Profile profile) {
        Validate.m10469a(profile, Scopes.PROFILE);
        JSONObject m11317c = profile.m11317c();
        if (m11317c != null) {
            this.f2122a.edit().putString("com.facebook.ProfileManager.CachedProfile", m11317c.toString()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m10404b() {
        this.f2122a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
    }
}
