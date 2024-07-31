package com.bumptech.glide.load.resource.p030e;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.p029d.GifDrawable;

/* renamed from: com.bumptech.glide.load.resource.e.c */
/* loaded from: classes.dex */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a */
    private final BitmapPool f1142a;

    /* renamed from: b */
    private final ResourceTranscoder<Bitmap, byte[]> f1143b;

    /* renamed from: c */
    private final ResourceTranscoder<GifDrawable, byte[]> f1144c;

    /* JADX WARN: Multi-variable type inference failed */
    @NonNull
    /* renamed from: a */
    private static Resource<GifDrawable> m11818a(@NonNull Resource<Drawable> resource) {
        return resource;
    }

    public DrawableBytesTranscoder(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f1142a = bitmapPool;
        this.f1143b = resourceTranscoder;
        this.f1144c = resourceTranscoder2;
    }

    @Override // com.bumptech.glide.load.resource.p030e.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<byte[]> mo11812a(@NonNull Resource<Drawable> resource, @NonNull Options options) {
        Drawable mo11898d = resource.mo11898d();
        if (mo11898d instanceof BitmapDrawable) {
            return this.f1143b.mo11812a(BitmapResource.m11980a(((BitmapDrawable) mo11898d).getBitmap(), this.f1142a), options);
        }
        if (mo11898d instanceof GifDrawable) {
            return this.f1144c.mo11812a(m11818a(resource), options);
        }
        return null;
    }
}
