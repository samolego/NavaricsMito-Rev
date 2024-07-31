package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.m */
/* loaded from: classes.dex */
public class DrawableTransformation implements Transformation<Drawable> {

    /* renamed from: b */
    private final Transformation<Bitmap> f1059b;

    /* renamed from: c */
    private final boolean f1060c;

    /* renamed from: a */
    public Transformation<BitmapDrawable> m11930a() {
        return this;
    }

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.f1059b = transformation;
        this.f1060c = z;
    }

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<Drawable> mo11850a(@NonNull Context context, @NonNull Resource<Drawable> resource, int i, int i2) {
        BitmapPool m12525a = Glide.m12523a(context).m12525a();
        Drawable mo11898d = resource.mo11898d();
        Resource<Bitmap> m11933a = DrawableToBitmapConverter.m11933a(m12525a, mo11898d, i, i2);
        if (m11933a == null) {
            if (this.f1060c) {
                throw new IllegalArgumentException("Unable to convert " + mo11898d + " to a Bitmap");
            }
            return resource;
        }
        Resource<Bitmap> mo11850a = this.f1059b.mo11850a(context, m11933a, i, i2);
        if (mo11850a.equals(m11933a)) {
            mo11850a.mo11851f();
            return resource;
        }
        return m11929a(context, mo11850a);
    }

    /* renamed from: a */
    private Resource<Drawable> m11929a(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.m11925a(context.getResources(), resource);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.f1059b.equals(((DrawableTransformation) obj).f1059b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.f1059b.hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        this.f1059b.mo7353a(messageDigest);
    }
}
