package com.bumptech.glide.request.p031a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import com.bumptech.glide.request.p032b.Transition;

/* renamed from: com.bumptech.glide.request.a.d */
/* loaded from: classes.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.InterfaceC0778a {
    @Nullable

    /* renamed from: b */
    private Animatable f1219b;

    /* renamed from: a */
    protected abstract void mo11728a(@Nullable Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* renamed from: e */
    public void m11725e(Drawable drawable) {
        ((ImageView) this.f1224a).setImageDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.p031a.ViewTarget, com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.request.p031a.Target
    /* renamed from: b */
    public void mo11697b(@Nullable Drawable drawable) {
        super.mo11697b(drawable);
        m11727b((ImageViewTarget<Z>) null);
        m11725e(drawable);
    }

    @Override // com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.request.p031a.Target
    /* renamed from: c */
    public void mo11694c(@Nullable Drawable drawable) {
        super.mo11694c(drawable);
        m11727b((ImageViewTarget<Z>) null);
        m11725e(drawable);
    }

    @Override // com.bumptech.glide.request.p031a.ViewTarget, com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11703a(@Nullable Drawable drawable) {
        super.mo11703a(drawable);
        Animatable animatable = this.f1219b;
        if (animatable != null) {
            animatable.stop();
        }
        m11727b((ImageViewTarget<Z>) null);
        m11725e(drawable);
    }

    @Override // com.bumptech.glide.request.p031a.Target
    /* renamed from: a */
    public void mo11699a(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.mo11706a(z, this)) {
            m11727b((ImageViewTarget<Z>) z);
        } else {
            m11726c((ImageViewTarget<Z>) z);
        }
    }

    @Override // com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    /* renamed from: c */
    public void mo11695c() {
        Animatable animatable = this.f1219b;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.p031a.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    /* renamed from: d */
    public void mo11693d() {
        Animatable animatable = this.f1219b;
        if (animatable != null) {
            animatable.stop();
        }
    }

    /* renamed from: b */
    private void m11727b(@Nullable Z z) {
        mo11728a((ImageViewTarget<Z>) z);
        m11726c((ImageViewTarget<Z>) z);
    }

    /* renamed from: c */
    private void m11726c(@Nullable Z z) {
        if (z instanceof Animatable) {
            this.f1219b = (Animatable) z;
            this.f1219b.start();
            return;
        }
        this.f1219b = null;
    }
}
