package com.navatics.app;

import android.content.Context;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;

/* renamed from: com.navatics.app.b */
/* loaded from: classes.dex */
public class GlideRequest<TranscodeType> extends RequestBuilder<TranscodeType> implements Cloneable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GlideRequest(@NonNull Glide glide, @NonNull RequestManager requestManager, @NonNull Class<TranscodeType> cls, @NonNull Context context) {
        super(glide, requestManager, cls, context);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @CheckResult
    @NonNull
    /* renamed from: b */
    public GlideRequest<TranscodeType> mo8828a(@NonNull RequestOptions requestOptions) {
        return (GlideRequest) super.mo8828a(requestOptions);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @CheckResult
    @NonNull
    /* renamed from: b */
    public GlideRequest<TranscodeType> mo8829a(@Nullable RequestListener<TranscodeType> requestListener) {
        return (GlideRequest) super.mo8829a((RequestListener) requestListener);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @CheckResult
    @NonNull
    /* renamed from: b */
    public GlideRequest<TranscodeType> mo8826a(@Nullable Object obj) {
        return (GlideRequest) super.mo8826a(obj);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @CheckResult
    @NonNull
    /* renamed from: b */
    public GlideRequest<TranscodeType> mo8825a(@Nullable String str) {
        return (GlideRequest) super.mo8825a(str);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @CheckResult
    @NonNull
    /* renamed from: b */
    public GlideRequest<TranscodeType> mo8827a(@RawRes @DrawableRes @Nullable Integer num) {
        return (GlideRequest) super.mo8827a(num);
    }

    @Override // com.bumptech.glide.RequestBuilder
    @CheckResult
    /* renamed from: c */
    public GlideRequest<TranscodeType> clone() {
        return (GlideRequest) super.clone();
    }
}
