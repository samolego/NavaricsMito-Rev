package com.bumptech.glide.load.p014a.p015a;

import android.net.Uri;

/* compiled from: MediaStoreUtil.java */
/* renamed from: com.bumptech.glide.load.a.a.b, reason: use source file name */
/* loaded from: classes.dex */
public final class MediaStoreUtil {
    /* renamed from: a */
    public static boolean m570a(int i, int i2) {
        return i != Integer.MIN_VALUE && i2 != Integer.MIN_VALUE && i <= 512 && i2 <= 384;
    }

    /* renamed from: a */
    public static boolean m571a(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }

    /* renamed from: d */
    private static boolean m574d(Uri uri) {
        return uri.getPathSegments().contains("video");
    }

    /* renamed from: b */
    public static boolean m572b(Uri uri) {
        return m571a(uri) && m574d(uri);
    }

    /* renamed from: c */
    public static boolean m573c(Uri uri) {
        return m571a(uri) && !m574d(uri);
    }
}