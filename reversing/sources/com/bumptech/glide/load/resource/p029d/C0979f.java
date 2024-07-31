package com.bumptech.glide.load.resource.p029d;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.d.f */
/* loaded from: classes.dex */
public class GifDrawableTransformation implements Transformation<GifDrawable> {

    /* renamed from: b */
    private final Transformation<Bitmap> f1111b;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.f1111b = (Transformation) Preconditions.m11580a(transformation);
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<GifDrawable> mo11850a(@NonNull Context context, @NonNull Resource<GifDrawable> resource, int i, int i2) {
        GifDrawable mo11898d = resource.mo11898d();
        Resource<Bitmap> bitmapResource = new BitmapResource(mo11898d.m11868b(), Glide.m12523a(context).m12525a());
        Resource<Bitmap> mo11850a = this.f1111b.mo11850a(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(mo11850a)) {
            bitmapResource.mo11851f();
        }
        mo11898d.m11869a(this.f1111b, mo11850a.mo11898d());
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.f1111b.equals(((GifDrawableTransformation) obj).f1111b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f1111b.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        this.f1111b.mo7353a(messageDigest);
    }
}
