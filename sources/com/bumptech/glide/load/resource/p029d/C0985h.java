package com.bumptech.glide.load.resource.p029d;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

/* renamed from: com.bumptech.glide.load.resource.d.h */
/* loaded from: classes.dex */
public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {

    /* renamed from: a */
    private final BitmapPool f1133a;

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11819a(@NonNull GifDecoder gifDecoder, @NonNull Options options) {
        return true;
    }

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.f1133a = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Resource<Bitmap> mo11820a(@NonNull GifDecoder gifDecoder, int i, int i2, @NonNull Options options) {
        return BitmapResource.m11980a(gifDecoder.mo12456h(), this.f1133a);
    }
}
