package com.bumptech.glide.request.p031a;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.p032b.Transition;

/* renamed from: com.bumptech.glide.request.a.h */
/* loaded from: classes.dex */
public interface Target<R> extends LifecycleListener {
    @Nullable
    /* renamed from: a */
    Request mo11704a();

    /* renamed from: a */
    void mo11703a(@Nullable Drawable drawable);

    /* renamed from: a */
    void mo11702a(@NonNull SizeReadyCallback sizeReadyCallback);

    /* renamed from: a */
    void mo11701a(@Nullable Request request);

    /* renamed from: a */
    void mo11699a(@NonNull R r, @Nullable Transition<? super R> transition);

    /* renamed from: b */
    void mo11697b(@Nullable Drawable drawable);

    /* renamed from: b */
    void mo11696b(@NonNull SizeReadyCallback sizeReadyCallback);

    /* renamed from: c */
    void mo11694c(@Nullable Drawable drawable);
}
