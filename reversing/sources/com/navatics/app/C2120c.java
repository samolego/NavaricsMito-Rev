package com.navatics.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.request.RequestOptions;

/* renamed from: com.navatics.app.c */
/* loaded from: classes.dex */
public class GlideRequests extends RequestManager {
    public GlideRequests(@NonNull Glide glide, @NonNull Lifecycle lifecycle, @NonNull RequestManagerTreeNode requestManagerTreeNode, @NonNull Context context) {
        super(glide, lifecycle, requestManagerTreeNode, context);
    }

    @Override // com.bumptech.glide.RequestManager
    @CheckResult
    @NonNull
    /* renamed from: c */
    public <ResourceType> GlideRequest<ResourceType> mo8816a(@NonNull Class<ResourceType> cls) {
        return new GlideRequest<>(this.f533a, this, cls, this.f534b);
    }

    @Override // com.bumptech.glide.RequestManager
    @CheckResult
    @NonNull
    /* renamed from: i */
    public GlideRequest<Bitmap> mo8810f() {
        return (GlideRequest) super.mo8810f();
    }

    @Override // com.bumptech.glide.RequestManager
    @CheckResult
    @NonNull
    /* renamed from: j */
    public GlideRequest<Drawable> mo8809g() {
        return (GlideRequest) super.mo8809g();
    }

    @Override // com.bumptech.glide.RequestManager
    @CheckResult
    @NonNull
    /* renamed from: b */
    public GlideRequest<Drawable> mo8814a(@Nullable String str) {
        return (GlideRequest) super.mo8814a(str);
    }

    @Override // com.bumptech.glide.RequestManager
    @CheckResult
    @NonNull
    /* renamed from: b */
    public GlideRequest<Drawable> mo8815a(@RawRes @DrawableRes @Nullable Integer num) {
        return (GlideRequest) super.mo8815a(num);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.RequestManager
    /* renamed from: a */
    public void mo8817a(@NonNull RequestOptions requestOptions) {
        if (requestOptions instanceof GlideOptions) {
            super.mo8817a(requestOptions);
        } else {
            super.mo8817a(new GlideOptions().mo9546a(requestOptions));
        }
    }
}
