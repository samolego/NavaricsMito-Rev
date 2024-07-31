package com.bumptech.glide.load.resource.p027b;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.resource.b.c */
/* loaded from: classes.dex */
final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public void mo11851f() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static Resource<Drawable> m11996a(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<Drawable> mo11853c() {
        return this.f1010a.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public int mo11852e() {
        return Math.max(1, this.f1010a.getIntrinsicWidth() * this.f1010a.getIntrinsicHeight() * 4);
    }
}
