package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* compiled from: ApiErrors.java */
/* renamed from: com.twitter.sdk.android.core.models.b, reason: use source file name */
/* loaded from: classes2.dex */
public class ApiErrors {

    /* renamed from: a */
    @SerializedName("errors")
    public final List<ApiError> f8748a;

    private ApiErrors() {
        this(null);
    }

    public ApiErrors(List<ApiError> list) {
        this.f8748a = ModelUtils.m8607a(list);
    }
}