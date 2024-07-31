package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.e */
/* loaded from: classes.dex */
public final class Option<T> {

    /* renamed from: a */
    private static final InterfaceC0678a<Object> f697a = new InterfaceC0678a<Object>() { // from class: com.bumptech.glide.load.e.1
        @Override // com.bumptech.glide.load.Option.InterfaceC0678a
        /* renamed from: a */
        public void mo11890a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: b */
    private final T f698b;

    /* renamed from: c */
    private final InterfaceC0678a<T> f699c;

    /* renamed from: d */
    private final String f700d;

    /* renamed from: e */
    private volatile byte[] f701e;

    /* compiled from: Option.java */
    /* renamed from: com.bumptech.glide.load.e$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0678a<T> {
        /* renamed from: a */
        void mo11890a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    @NonNull
    /* renamed from: a */
    public static <T> Option<T> m12280a(@NonNull String str) {
        return new Option<>(str, null, m12276c());
    }

    @NonNull
    /* renamed from: a */
    public static <T> Option<T> m12279a(@NonNull String str, @NonNull T t) {
        return new Option<>(str, t, m12276c());
    }

    @NonNull
    /* renamed from: a */
    public static <T> Option<T> m12278a(@NonNull String str, @Nullable T t, @NonNull InterfaceC0678a<T> interfaceC0678a) {
        return new Option<>(str, t, interfaceC0678a);
    }

    private Option(@NonNull String str, @Nullable T t, @NonNull InterfaceC0678a<T> interfaceC0678a) {
        this.f700d = Preconditions.m11578a(str);
        this.f698b = t;
        this.f699c = (InterfaceC0678a) Preconditions.m11580a(interfaceC0678a);
    }

    @Nullable
    /* renamed from: a */
    public T m12282a() {
        return this.f698b;
    }

    /* renamed from: a */
    public void m12281a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f699c.mo11890a(m12277b(), t, messageDigest);
    }

    @NonNull
    /* renamed from: b */
    private byte[] m12277b() {
        if (this.f701e == null) {
            this.f701e = this.f700d.getBytes(Key.f695a);
        }
        return this.f701e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            return this.f700d.equals(((Option) obj).f700d);
        }
        return false;
    }

    public int hashCode() {
        return this.f700d.hashCode();
    }

    @NonNull
    /* renamed from: c */
    private static <T> InterfaceC0678a<T> m12276c() {
        return (InterfaceC0678a<T>) f697a;
    }

    public String toString() {
        return "Option{key='" + this.f700d + "'}";
    }
}
