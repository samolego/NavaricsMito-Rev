package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.util.C0791i;

/* renamed from: com.bumptech.glide.load.resource.bitmap.e */
/* loaded from: classes.dex */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    /* renamed from: a */
    protected abstract Bitmap mo7404a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public final Resource<Bitmap> mo11850a(@NonNull Context context, @NonNull Resource<Bitmap> resource, int i, int i2) {
        if (!C0791i.m11571a(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        BitmapPool m12525a = Glide.m12523a(context).m12525a();
        Bitmap mo11898d = resource.mo11898d();
        if (i == Integer.MIN_VALUE) {
            i = mo11898d.getWidth();
        }
        if (i2 == Integer.MIN_VALUE) {
            i2 = mo11898d.getHeight();
        }
        Bitmap mo7404a = mo7404a(m12525a, mo11898d, i, i2);
        return mo11898d.equals(mo7404a) ? resource : BitmapResource.m11980a(mo7404a, m12525a);
    }
}
