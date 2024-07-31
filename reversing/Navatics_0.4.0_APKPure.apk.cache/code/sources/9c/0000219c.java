package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AbstractC2507a;

/* compiled from: Session.java */
/* renamed from: com.twitter.sdk.android.core.k */
/* loaded from: classes2.dex */
public class C2593k<T extends AbstractC2507a> {

    /* renamed from: a */
    @SerializedName("auth_token")
    private final T f8730a;

    /* renamed from: b */
    @SerializedName("id")
    private final long f8731b;

    public C2593k(T t, long j) {
        if (t == null) {
            throw new IllegalArgumentException("AuthToken must not be null.");
        }
        this.f8730a = t;
        this.f8731b = j;
    }

    /* renamed from: a */
    public T m8590a() {
        return this.f8730a;
    }

    /* renamed from: b */
    public long m8591b() {
        return this.f8731b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2593k c2593k = (C2593k) obj;
        if (this.f8731b != c2593k.f8731b) {
            return false;
        }
        T t = this.f8730a;
        return t != null ? t.equals(c2593k.f8730a) : c2593k.f8730a == null;
    }

    public int hashCode() {
        T t = this.f8730a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f8731b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}