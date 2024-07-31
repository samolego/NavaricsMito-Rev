package com.navatics.app;

import android.graphics.Bitmap;
import android.support.annotation.CheckResult;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.request.RequestOptions;

/* renamed from: com.navatics.app.a */
/* loaded from: classes.dex */
public final class GlideOptions extends RequestOptions implements Cloneable {
    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: a */
    public /* synthetic */ RequestOptions mo9548a(@NonNull Option option, @NonNull Object obj) {
        return m9538b((Option<Option>) option, (Option) obj);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: b */
    public /* synthetic */ RequestOptions mo9536b(@NonNull Transformation transformation) {
        return m9528c((Transformation<Bitmap>) transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: b */
    public final GlideOptions mo9552a(@FloatRange(from = 0.0d, m12847to = 1.0d) float f) {
        return (GlideOptions) super.mo9552a(f);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: c */
    public final GlideOptions mo9545a(boolean z) {
        return (GlideOptions) super.mo9545a(z);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: c */
    public final GlideOptions mo9537b(@NonNull DiskCacheStrategy diskCacheStrategy) {
        return (GlideOptions) super.mo9537b(diskCacheStrategy);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: b */
    public final GlideOptions mo9549a(@NonNull Priority priority) {
        return (GlideOptions) super.mo9549a(priority);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: c */
    public final GlideOptions mo9551a(@DrawableRes int i) {
        return (GlideOptions) super.mo9551a(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: d */
    public final GlideOptions mo9542b(@DrawableRes int i) {
        return (GlideOptions) super.mo9542b(i);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: d */
    public final GlideOptions mo9532b(boolean z) {
        return (GlideOptions) super.mo9532b(z);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: b */
    public final GlideOptions mo9550a(int i, int i2) {
        return (GlideOptions) super.mo9550a(i, i2);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: c */
    public final GlideOptions mo9539b(@NonNull Key key) {
        return (GlideOptions) super.mo9539b(key);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    /* renamed from: J */
    public final GlideOptions clone() {
        return (GlideOptions) super.clone();
    }

    @CheckResult
    @NonNull
    /* renamed from: b */
    public final <T> GlideOptions m9538b(@NonNull Option<T> option, @NonNull T t) {
        return (GlideOptions) super.mo9548a((Option<Option<T>>) option, (Option<T>) t);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: c */
    public final GlideOptions mo9533b(@NonNull Class<?> cls) {
        return (GlideOptions) super.mo9533b(cls);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: b */
    public final GlideOptions mo9547a(@NonNull DownsampleStrategy downsampleStrategy) {
        return (GlideOptions) super.mo9547a(downsampleStrategy);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: K */
    public final GlideOptions mo9523e() {
        return (GlideOptions) super.mo9523e();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: L */
    public final GlideOptions mo9522f() {
        return (GlideOptions) super.mo9522f();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: M */
    public final GlideOptions mo9521g() {
        return (GlideOptions) super.mo9521g();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: N */
    public final GlideOptions mo9520h() {
        return (GlideOptions) super.mo9520h();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: O */
    public final GlideOptions mo9519i() {
        return (GlideOptions) super.mo9519i();
    }

    @CheckResult
    @NonNull
    /* renamed from: c */
    public final GlideOptions m9528c(@NonNull Transformation<Bitmap> transformation) {
        return (GlideOptions) super.mo9536b(transformation);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @CheckResult
    @NonNull
    /* renamed from: b */
    public final GlideOptions mo9546a(@NonNull RequestOptions requestOptions) {
        return (GlideOptions) super.mo9546a(requestOptions);
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    /* renamed from: P */
    public final GlideOptions mo9518j() {
        return (GlideOptions) super.mo9518j();
    }

    @Override // com.bumptech.glide.request.RequestOptions
    @NonNull
    /* renamed from: Q */
    public final GlideOptions mo9517k() {
        return (GlideOptions) super.mo9517k();
    }
}
