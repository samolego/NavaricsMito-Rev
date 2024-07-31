package com.bumptech.glide.load.p018a.p019a;

import android.net.Uri;

/* renamed from: com.bumptech.glide.load.a.a.b */
/* loaded from: classes.dex */
public final class MediaStoreUtil {
    /* renamed from: a */
    public static boolean m12423a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    /* renamed from: a */
    public static boolean m12422a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* renamed from: d */
    private static boolean m12419d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    /* renamed from: b */
    public static boolean m12421b(Uri uri) {
        return m12422a(uri) && m12419d(uri);
    }

    /* renamed from: c */
    public static boolean m12420c(Uri uri) {
        return m12422a(uri) && !m12419d(uri);
    }
}
