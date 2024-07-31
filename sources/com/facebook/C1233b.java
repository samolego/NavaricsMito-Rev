package com.facebook;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p008v4.app.NotificationCompat;
import android.support.p008v4.content.LocalBroadcastManager;
import android.util.Log;
import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestBatch;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.senseplay.sdk.constant.SPWebConstant;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.b */
/* loaded from: classes.dex */
public final class AccessTokenManager {

    /* renamed from: a */
    private static volatile AccessTokenManager f1809a;

    /* renamed from: b */
    private final LocalBroadcastManager f1810b;

    /* renamed from: c */
    private final AccessTokenCache f1811c;

    /* renamed from: d */
    private AccessToken f1812d;

    /* renamed from: e */
    private AtomicBoolean f1813e = new AtomicBoolean(false);

    /* renamed from: f */
    private Date f1814f = new Date(0);

    AccessTokenManager(LocalBroadcastManager localBroadcastManager, AccessTokenCache accessTokenCache) {
        Validate.m10469a(localBroadcastManager, "localBroadcastManager");
        Validate.m10469a(accessTokenCache, "accessTokenCache");
        this.f1810b = localBroadcastManager;
        this.f1811c = accessTokenCache;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static AccessTokenManager m10905a() {
        if (f1809a == null) {
            synchronized (AccessTokenManager.class) {
                if (f1809a == null) {
                    f1809a = new AccessTokenManager(LocalBroadcastManager.getInstance(FacebookSdk.m10869h()), new AccessTokenCache());
                }
            }
        }
        return f1809a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public AccessToken m10897b() {
        return this.f1812d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean m10894c() {
        AccessToken m11313a = this.f1811c.m11313a();
        if (m11313a != null) {
            m10900a(m11313a, false);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m10903a(AccessToken accessToken) {
        m10900a(accessToken, true);
    }

    /* renamed from: a */
    private void m10900a(AccessToken accessToken, boolean z) {
        AccessToken accessToken2 = this.f1812d;
        this.f1812d = accessToken;
        this.f1813e.set(false);
        this.f1814f = new Date(0L);
        if (z) {
            if (accessToken != null) {
                this.f1811c.m11312a(accessToken);
            } else {
                this.f1811c.m11311b();
                Utility.m10508b(FacebookSdk.m10869h());
            }
        }
        if (Utility.m10533a(accessToken2, accessToken)) {
            return;
        }
        m10902a(accessToken2, accessToken);
        m10891f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m10893d() {
        AccessToken accessToken = this.f1812d;
        m10902a(accessToken, accessToken);
    }

    /* renamed from: a */
    private void m10902a(AccessToken accessToken, AccessToken accessToken2) {
        Intent intent = new Intent(FacebookSdk.m10869h(), CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_ACCESS_TOKEN", accessToken);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_ACCESS_TOKEN", accessToken2);
        this.f1810b.sendBroadcast(intent);
    }

    /* renamed from: f */
    private void m10891f() {
        Context m10869h = FacebookSdk.m10869h();
        AccessToken m11457a = AccessToken.m11457a();
        AlarmManager alarmManager = (AlarmManager) m10869h.getSystemService(NotificationCompat.CATEGORY_ALARM);
        if (!AccessToken.m11451b() || m11457a.m11447e() == null || alarmManager == null) {
            return;
        }
        Intent intent = new Intent(m10869h, CurrentAccessTokenExpirationBroadcastReceiver.class);
        intent.setAction("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED");
        try {
            alarmManager.set(1, m11457a.m11447e().getTime(), PendingIntent.getBroadcast(m10869h, 0, intent, 0));
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m10892e() {
        if (m10890g()) {
            m10904a((AccessToken.InterfaceC0816a) null);
        }
    }

    /* renamed from: g */
    private boolean m10890g() {
        if (this.f1812d == null) {
            return false;
        }
        Long valueOf = Long.valueOf(new Date().getTime());
        return this.f1812d.m11442j().canExtendToken() && valueOf.longValue() - this.f1814f.getTime() > 3600000 && valueOf.longValue() - this.f1812d.m11441k().getTime() > 86400000;
    }

    /* renamed from: a */
    private static GraphRequest m10901a(AccessToken accessToken, GraphRequest.InterfaceC0829b interfaceC0829b) {
        return new GraphRequest(accessToken, "me/permissions", new Bundle(), HttpMethod.GET, interfaceC0829b);
    }

    /* renamed from: b */
    private static GraphRequest m10895b(AccessToken accessToken, GraphRequest.InterfaceC0829b interfaceC0829b) {
        Bundle bundle = new Bundle();
        bundle.putString("grant_type", "fb_extend_sso_token");
        return new GraphRequest(accessToken, "oauth/access_token", bundle, HttpMethod.GET, interfaceC0829b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AccessTokenManager.java */
    /* renamed from: com.facebook.b$a */
    /* loaded from: classes.dex */
    public static class C0903a {

        /* renamed from: a */
        public String f1832a;

        /* renamed from: b */
        public int f1833b;

        /* renamed from: c */
        public Long f1834c;

        private C0903a() {
        }
    }

    /* renamed from: a */
    void m10904a(final AccessToken.InterfaceC0816a interfaceC0816a) {
        if (Looper.getMainLooper().equals(Looper.myLooper())) {
            m10896b(interfaceC0816a);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.facebook.b.1
                @Override // java.lang.Runnable
                public void run() {
                    AccessTokenManager.this.m10896b(interfaceC0816a);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m10896b(final AccessToken.InterfaceC0816a interfaceC0816a) {
        final AccessToken accessToken = this.f1812d;
        if (accessToken == null) {
            if (interfaceC0816a != null) {
                interfaceC0816a.m11432a(new FacebookException("No current access token to refresh"));
            }
        } else if (!this.f1813e.compareAndSet(false, true)) {
            if (interfaceC0816a != null) {
                interfaceC0816a.m11432a(new FacebookException("Refresh already in progress"));
            }
        } else {
            this.f1814f = new Date();
            final HashSet hashSet = new HashSet();
            final HashSet hashSet2 = new HashSet();
            final HashSet hashSet3 = new HashSet();
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            final C0903a c0903a = new C0903a();
            GraphRequestBatch graphRequestBatch = new GraphRequestBatch(m10901a(accessToken, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.b.2
                @Override // com.facebook.GraphRequest.InterfaceC0829b
                /* renamed from: a */
                public void mo10080a(GraphResponse graphResponse) {
                    JSONArray optJSONArray;
                    JSONObject m10824b = graphResponse.m10824b();
                    if (m10824b == null || (optJSONArray = m10824b.optJSONArray("data")) == null) {
                        return;
                    }
                    atomicBoolean.set(true);
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString(SPWebConstant.Permission);
                            String optString2 = optJSONObject.optString(NotificationCompat.CATEGORY_STATUS);
                            if (!Utility.m10530a(optString) && !Utility.m10530a(optString2)) {
                                String lowerCase = optString2.toLowerCase(Locale.US);
                                if (lowerCase.equals("granted")) {
                                    hashSet.add(optString);
                                } else if (lowerCase.equals("declined")) {
                                    hashSet2.add(optString);
                                } else if (lowerCase.equals("expired")) {
                                    hashSet3.add(optString);
                                } else {
                                    Log.w("AccessTokenManager", "Unexpected status: " + lowerCase);
                                }
                            }
                        }
                    }
                }
            }), m10895b(accessToken, new GraphRequest.InterfaceC0829b() { // from class: com.facebook.b.3
                @Override // com.facebook.GraphRequest.InterfaceC0829b
                /* renamed from: a */
                public void mo10080a(GraphResponse graphResponse) {
                    JSONObject m10824b = graphResponse.m10824b();
                    if (m10824b == null) {
                        return;
                    }
                    c0903a.f1832a = m10824b.optString("access_token");
                    c0903a.f1833b = m10824b.optInt("expires_at");
                    c0903a.f1834c = Long.valueOf(m10824b.optLong("data_access_expiration_time"));
                }
            }));
            graphRequestBatch.m10844a(new GraphRequestBatch.InterfaceC0919a() { // from class: com.facebook.b.4
                @Override // com.facebook.GraphRequestBatch.InterfaceC0919a
                /* renamed from: a */
                public void mo10082a(GraphRequestBatch graphRequestBatch2) {
                    AccessToken accessToken2;
                    try {
                        if (AccessTokenManager.m10905a().m10897b() != null && AccessTokenManager.m10905a().m10897b().m11439m() == accessToken.m11439m()) {
                            if (!atomicBoolean.get() && c0903a.f1832a == null && c0903a.f1833b == 0) {
                                if (interfaceC0816a != null) {
                                    interfaceC0816a.m11432a(new FacebookException("Failed to refresh access token"));
                                }
                                AccessTokenManager.this.f1813e.set(false);
                                AccessToken.InterfaceC0816a interfaceC0816a2 = interfaceC0816a;
                                return;
                            }
                            AccessToken accessToken3 = new AccessToken(c0903a.f1832a != null ? c0903a.f1832a : accessToken.m11448d(), accessToken.m11440l(), accessToken.m11439m(), atomicBoolean.get() ? hashSet : accessToken.m11445g(), atomicBoolean.get() ? hashSet2 : accessToken.m11444h(), atomicBoolean.get() ? hashSet3 : accessToken.m11443i(), accessToken.m11442j(), c0903a.f1833b != 0 ? new Date(c0903a.f1833b * 1000) : accessToken.m11447e(), new Date(), c0903a.f1834c != null ? new Date(1000 * c0903a.f1834c.longValue()) : accessToken.m11446f());
                            try {
                                AccessTokenManager.m10905a().m10903a(accessToken3);
                                AccessTokenManager.this.f1813e.set(false);
                                AccessToken.InterfaceC0816a interfaceC0816a3 = interfaceC0816a;
                                if (interfaceC0816a3 != null) {
                                    interfaceC0816a3.m11433a(accessToken3);
                                    return;
                                }
                                return;
                            } catch (Throwable th) {
                                th = th;
                                accessToken2 = accessToken3;
                                AccessTokenManager.this.f1813e.set(false);
                                AccessToken.InterfaceC0816a interfaceC0816a4 = interfaceC0816a;
                                if (interfaceC0816a4 != null && accessToken2 != null) {
                                    interfaceC0816a4.m11433a(accessToken2);
                                }
                                throw th;
                            }
                        }
                        if (interfaceC0816a != null) {
                            interfaceC0816a.m11432a(new FacebookException("No current access token to refresh"));
                        }
                        AccessTokenManager.this.f1813e.set(false);
                        AccessToken.InterfaceC0816a interfaceC0816a5 = interfaceC0816a;
                    } catch (Throwable th2) {
                        th = th2;
                        accessToken2 = null;
                    }
                }
            });
            graphRequestBatch.m10835h();
        }
    }
}
