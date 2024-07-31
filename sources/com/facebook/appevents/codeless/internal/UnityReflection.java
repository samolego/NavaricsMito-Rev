package com.facebook.appevents.codeless.internal;

import android.util.Log;

/* renamed from: com.facebook.appevents.codeless.internal.c */
/* loaded from: classes.dex */
public class UnityReflection {

    /* renamed from: a */
    private static final String f1691a = UnityReflection.class.getCanonicalName();

    /* renamed from: b */
    private static Class<?> f1692b;

    /* renamed from: a */
    public static void m11109a(String str, String str2, String str3) {
        try {
            if (f1692b == null) {
                f1692b = Class.forName("com.unity3d.player.UnityPlayer");
            }
            f1692b.getMethod("UnitySendMessage", String.class, String.class, String.class).invoke(f1692b, str, str2, str3);
        } catch (Exception e) {
            Log.e(f1691a, "Failed to send message to Unity", e);
        }
    }

    /* renamed from: a */
    public static void m11111a() {
        m11109a("UnityFacebookSDKPlugin", "CaptureViewHierarchy", "");
    }

    /* renamed from: a */
    public static void m11110a(String str) {
        m11109a("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }
}
