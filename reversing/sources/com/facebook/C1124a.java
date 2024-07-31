package com.facebook;

import android.content.SharedPreferences;
import android.os.Bundle;
import com.facebook.internal.Validate;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.facebook.a */
/* loaded from: classes.dex */
public class AccessTokenCache {

    /* renamed from: a */
    private final SharedPreferences f1518a;

    /* renamed from: b */
    private final C0836a f1519b;

    /* renamed from: c */
    private LegacyTokenHelper f1520c;

    AccessTokenCache(SharedPreferences sharedPreferences, C0836a c0836a) {
        this.f1518a = sharedPreferences;
        this.f1519b = c0836a;
    }

    public AccessTokenCache() {
        this(FacebookSdk.m10869h().getSharedPreferences("com.facebook.AccessTokenManager.SharedPreferences", 0), new C0836a());
    }

    /* renamed from: a */
    public AccessToken m11313a() {
        if (m11310c()) {
            return m11309d();
        }
        if (m11308e()) {
            AccessToken m11307f = m11307f();
            if (m11307f != null) {
                m11312a(m11307f);
                m11306g().m10410b();
                return m11307f;
            }
            return m11307f;
        }
        return null;
    }

    /* renamed from: a */
    public void m11312a(AccessToken accessToken) {
        Validate.m10469a(accessToken, "accessToken");
        try {
            this.f1518a.edit().putString("com.facebook.AccessTokenManager.CachedAccessToken", accessToken.m11437o().toString()).apply();
        } catch (JSONException unused) {
        }
    }

    /* renamed from: b */
    public void m11311b() {
        this.f1518a.edit().remove("com.facebook.AccessTokenManager.CachedAccessToken").apply();
        if (m11308e()) {
            m11306g().m10410b();
        }
    }

    /* renamed from: c */
    private boolean m11310c() {
        return this.f1518a.contains("com.facebook.AccessTokenManager.CachedAccessToken");
    }

    /* renamed from: d */
    private AccessToken m11309d() {
        String string = this.f1518a.getString("com.facebook.AccessTokenManager.CachedAccessToken", null);
        if (string != null) {
            try {
                return AccessToken.m11452a(new JSONObject(string));
            } catch (JSONException unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: e */
    private boolean m11308e() {
        return FacebookSdk.m10872e();
    }

    /* renamed from: f */
    private AccessToken m11307f() {
        Bundle m10414a = m11306g().m10414a();
        if (m10414a == null || !LegacyTokenHelper.m10413a(m10414a)) {
            return null;
        }
        return AccessToken.m11456a(m10414a);
    }

    /* renamed from: g */
    private LegacyTokenHelper m11306g() {
        if (this.f1520c == null) {
            synchronized (this) {
                if (this.f1520c == null) {
                    this.f1520c = this.f1519b.m11305a();
                }
            }
        }
        return this.f1520c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AccessTokenCache.java */
    /* renamed from: com.facebook.a$a */
    /* loaded from: classes.dex */
    public static class C0836a {
        C0836a() {
        }

        /* renamed from: a */
        public LegacyTokenHelper m11305a() {
            return new LegacyTokenHelper(FacebookSdk.m10869h());
        }
    }
}
