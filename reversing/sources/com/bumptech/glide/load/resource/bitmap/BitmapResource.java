package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.resource.bitmap.d */
/* loaded from: classes.dex */
public class BitmapResource implements Initializable, Resource<Bitmap> {

    /* renamed from: a */
    private final Bitmap f1034a;

    /* renamed from: b */
    private final BitmapPool f1035b;

    @Nullable
    /* renamed from: a */
    public static BitmapResource m11980a(@Nullable Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    public BitmapResource(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        this.f1034a = (Bitmap) Preconditions.m11579a(bitmap, "Bitmap must not be null");
        this.f1035b = (BitmapPool) Preconditions.m11579a(bitmapPool, "BitmapPool must not be null");
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: c */
    public Class<Bitmap> mo11853c() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    @NonNull
    /* renamed from: b */
    public Bitmap mo11898d() {
        return this.f1034a;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public int mo11852e() {
        return C0791i.m11568a(this.f1034a);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: f */
    public void mo11851f() {
        this.f1035b.mo11931a(this.f1034a);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    /* renamed from: a */
    public void mo11854a() {
        this.f1034a.prepareToDraw();
    }
}
