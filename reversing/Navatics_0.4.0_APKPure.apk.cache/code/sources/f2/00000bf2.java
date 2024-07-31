package com.bumptech.glide.util;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import java.util.Collection;

/* compiled from: Preconditions.java */
/* renamed from: com.bumptech.glide.util.h */
/* loaded from: classes.dex */
public final class C0780h {
    /* renamed from: a */
    public static void m1366a(boolean z, @NonNull String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    @NonNull
    /* renamed from: a */
    public static <T> T m1362a(@Nullable T t) {
        return (T) m1363a(t, "Argument must not be null");
    }

    @NonNull
    /* renamed from: a */
    public static <T> T m1363a(@Nullable T t, @NonNull String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    @NonNull
    /* renamed from: a */
    public static String m1364a(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must not be null or empty");
        }
        return str;
    }

    @NonNull
    /* renamed from: a */
    public static <T extends Collection<Y>, Y> T m1365a(@NonNull T t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Must not be empty.");
        }
        return t;
    }
}