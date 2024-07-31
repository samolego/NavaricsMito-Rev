package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;

/* renamed from: com.twitter.sdk.android.core.a */
/* loaded from: classes2.dex */
public abstract class AuthToken {
    @SerializedName("created_at")

    /* renamed from: a */
    protected final long f8436a;

    public AuthToken() {
        this(System.currentTimeMillis());
    }

    protected AuthToken(long j) {
        this.f8436a = j;
    }
}
