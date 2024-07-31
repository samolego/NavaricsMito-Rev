package com.bumptech.glide.request.p031a;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.bumptech.glide.request.Request;

/* renamed from: com.bumptech.glide.request.a.a */
/* loaded from: classes.dex */
public abstract class BaseTarget<Z> implements Target<Z> {

    /* renamed from: a */
    private Request f1218a;

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11703a(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: b */
    public void mo11697b(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: c */
    public void mo11695c() {
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: c */
    public void mo11694c(@Nullable Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: d */
    public void mo11693d() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    /* renamed from: e */
    public void mo11692e() {
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11701a(@Nullable Request request) {
        this.f1218a = request;
    }

    @Override // com.bumptech.glide.request.p031a.Target
    @Nullable
    /* renamed from: a */
    public Request mo11704a() {
        return this.f1218a;
    }
}
