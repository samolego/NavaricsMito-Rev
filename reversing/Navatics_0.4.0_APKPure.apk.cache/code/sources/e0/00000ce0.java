package com.facebook.appevents.codeless.internal;

import android.util.Log;

/* compiled from: UnityReflection.java */
/* renamed from: com.facebook.appevents.codeless.internal.c, reason: use source file name */
/* loaded from: classes.dex */
public class UnityReflection {

    /* renamed from: a */
    private static final String f1697a = UnityReflection.class.getCanonicalName();

    /* renamed from: b */
    private static Class<?> f1698b;

    /* renamed from: a */
    public static void m1855a(String str, String str2, String str3) {
        try {
            if (f1698b == null) {
                f1698b = Class.forName("com.unity3d.player.UnityPlayer");
            }
            f1698b.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(f1698b, str, str2, str3);
        } catch (Exception e) {
            Log.e(f1697a, "Failed to send message to Unity", e);
        }
    }

    /* renamed from: a */
    public static void m1853a() {
        m1855a("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    /* renamed from: a */
    public static void m1854a(String str) {
        m1855a("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }
}