package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.util.C0780h;
import java.security.MessageDigest;

/* compiled from: Option.java */
/* renamed from: com.bumptech.glide.load.e */
/* loaded from: classes.dex */
public final class C0614e<T> {

    /* renamed from: a */
    private static final a<Object> f701a = new a<Object>() { // from class: com.bumptech.glide.load.e.1
        @Override // com.bumptech.glide.load.C0614e.a
        /* renamed from: a */
        public void mo694a(@NonNull byte[] bArr, @NonNull Object obj, @NonNull MessageDigest messageDigest) {
        }
    };

    /* renamed from: b */
    private final T f702b;

    /* renamed from: c */
    private final a<T> f703c;

    /* renamed from: d */
    private final String f704d;

    /* renamed from: e */
    private volatile byte[] f705e;

    /* compiled from: Option.java */
    /* renamed from: com.bumptech.glide.load.e$a */
    /* loaded from: classes.dex */
    public interface a<T> {
        /* renamed from: a */
        void mo694a(@NonNull byte[] bArr, @NonNull T t, @NonNull MessageDigest messageDigest);
    }

    @NonNull
    /* renamed from: a */
    public static <T> C0614e<T> m687a(@NonNull String str) {
        return new C0614e<>(str, null, m691c());
    }

    @NonNull
    /* renamed from: a */
    public static <T> C0614e<T> m688a(@NonNull String str, @NonNull T t) {
        return new C0614e<>(str, t, m691c());
    }

    @NonNull
    /* renamed from: a */
    public static <T> C0614e<T> m689a(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        return new C0614e<>(str, t, aVar);
    }

    private C0614e(@NonNull String str, @Nullable T t, @NonNull a<T> aVar) {
        this.f704d = C0780h.m1364a(str);
        this.f702b = t;
        this.f703c = (a) C0780h.m1362a(aVar);
    }

    @Nullable
    /* renamed from: a */
    public T m692a() {
        return this.f702b;
    }

    /* renamed from: a */
    public void m693a(@NonNull T t, @NonNull MessageDigest messageDigest) {
        this.f703c.mo694a(m690b(), t, messageDigest);
    }

    @NonNull
    /* renamed from: b */
    private byte[] m690b() {
        if (this.f705e == null) {
            this.f705e = this.f704d.getBytes(InterfaceC0612c.f699a);
        }
        return this.f705e;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0614e) {
            return this.f704d.equals(((C0614e) obj).f704d);
        }
        return false;
    }

    public int hashCode() {
        return this.f704d.hashCode();
    }

    @NonNull
    /* renamed from: c */
    private static <T> a<T> m691c() {
        return (a<T>) f701a;
    }

    public String toString() {
        return "Option{key='" + this.f704d + "'}";
    }
}