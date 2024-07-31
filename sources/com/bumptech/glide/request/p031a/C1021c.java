package com.bumptech.glide.request.p031a;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.widget.ImageView;

/* renamed from: com.bumptech.glide.request.a.c */
/* loaded from: classes.dex */
public class DrawableImageViewTarget extends ImageViewTarget<Drawable> {
    public DrawableImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.p031a.ImageViewTarget
    /* renamed from: d */
    public void mo11728a(@Nullable Drawable drawable) {
        ((ImageView) this.f1224a).setImageDrawable(drawable);
    }
}
