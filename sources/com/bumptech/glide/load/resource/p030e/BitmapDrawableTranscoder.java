package com.bumptech.glide.load.resource.p030e;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

/* renamed from: com.bumptech.glide.load.resource.e.b */
/* loaded from: classes.dex */
public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {

    /* renamed from: a */
    private final Resources f1141a;

    public BitmapDrawableTranscoder(@NonNull Resources resources) {
        this.f1141a = (Resources) Preconditions.m11580a(resources);
    }

    @Override // com.bumptech.glide.load.resource.p030e.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<BitmapDrawable> mo11812a(@NonNull Resource<Bitmap> resource, @NonNull Options options) {
        return LazyBitmapDrawableResource.m11925a(this.f1141a, resource);
    }
}
