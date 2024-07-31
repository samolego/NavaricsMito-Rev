package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;
import com.twitter.sdk.android.core.AuthToken;

/* renamed from: com.twitter.sdk.android.core.k */
/* loaded from: classes2.dex */
public class Session<T extends AuthToken> {
    @SerializedName("auth_token")

    /* renamed from: a */
    private final T f8690a;
    @SerializedName("id")

    /* renamed from: b */
    private final long f8691b;

    public Session(T t, long j) {
        if (t == null) {
            throw new IllegalArgumentException("AuthToken must not be null.");
        }
        this.f8690a = t;
        this.f8691b = j;
    }

    /* renamed from: a */
    public T m4270a() {
        return this.f8690a;
    }

    /* renamed from: b */
    public long m4269b() {
        return this.f8691b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Session session = (Session) obj;
        if (this.f8691b != session.f8691b) {
            return false;
        }
        T t = this.f8690a;
        return t != null ? t.equals(session.f8690a) : session.f8690a == null;
    }

    public int hashCode() {
        T t = this.f8690a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f8691b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }
}
