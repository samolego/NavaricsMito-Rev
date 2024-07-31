package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.resource.bitmap.p */
/* loaded from: classes.dex */
public final class LazyBitmapDrawableResource implements Initializable, Resource<BitmapDrawable> {

    /* renamed from: a */
    private final Resources f1066a;

    /* renamed from: b */
    private final Resource<Bitmap> f1067b;

    @Nullable
    /* renamed from: a */
    public static Resource<BitmapDrawable> m11925a(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    private LazyBitmapDrawableResource(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        this.f1066a = (Resources) Preconditions.m11580a(resources);
        this.f1067b = (Resource) Preconditions.m11580a(resource);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<BitmapDrawable> mo11853c() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public BitmapDrawable mo11898d() {
        return new BitmapDrawable(this.f1066a, this.f1067b.mo11898d());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public int mo11852e() {
        return this.f1067b.mo11852e();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public void mo11851f() {
        this.f1067b.mo11851f();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo11854a() {
        Resource<Bitmap> resource = this.f1067b;
        if (resource instanceof Initializable) {
            ((Initializable) resource).mo11854a();
        }
    }
}
