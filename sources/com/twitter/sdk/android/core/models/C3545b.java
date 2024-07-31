package com.twitter.sdk.android.core.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* renamed from: com.twitter.sdk.android.core.models.b */
/* loaded from: classes2.dex */
public class ApiErrors {
    @SerializedName("errors")

    /* renamed from: a */
    public final List<ApiError> f8708a;

    private ApiErrors() {
        this(null);
    }

    public ApiErrors(List<ApiError> list) {
        this.f8708a = ModelUtils.m4248a(list);
    }
}
