package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;

/* renamed from: com.facebook.appevents.internal.j */
/* loaded from: classes.dex */
class SourceApplicationInfo {

    /* renamed from: a */
    private String f1765a;

    /* renamed from: b */
    private boolean f1766b;

    private SourceApplicationInfo(String str, boolean z) {
        this.f1765a = str;
        this.f1766b = z;
    }

    /* renamed from: a */
    public static SourceApplicationInfo m10963a() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h());
        if (defaultSharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
            return new SourceApplicationInfo(defaultSharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
        }
        return null;
    }

    /* renamed from: b */
    public static void m10962b() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h()).edit();
        edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        edit.apply();
    }

    public String toString() {
        String str = this.f1766b ? "Applink" : "Unclassified";
        if (this.f1765a != null) {
            return str + "(" + this.f1765a + ")";
        }
        return str;
    }

    /* renamed from: c */
    public void m10961c() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.m10869h()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.f1765a);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.f1766b);
        edit.apply();
    }
}
