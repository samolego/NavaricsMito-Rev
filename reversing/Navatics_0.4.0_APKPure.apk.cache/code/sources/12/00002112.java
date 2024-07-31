package com.twitter.sdk.android.core;

import com.google.gson.annotations.SerializedName;

/* compiled from: AuthToken.java */
/* renamed from: com.twitter.sdk.android.core.a */
/* loaded from: classes2.dex */
public abstract class AbstractC2507a {

    /* renamed from: a */
    @SerializedName("created_at")
    protected final long f8476a;

    public AbstractC2507a() {
        this(System.currentTimeMillis());
    }

    protected AbstractC2507a(long j) {
        this.f8476a = j;
    }
}