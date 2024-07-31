package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.resource.p027b.ResourceDrawableDecoder;

/* renamed from: com.bumptech.glide.load.resource.bitmap.q */
/* loaded from: classes.dex */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: a */
    private final ResourceDrawableDecoder f1068a;

    /* renamed from: b */
    private final BitmapPool f1069b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f1068a = resourceDrawableDecoder;
        this.f1069b = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11819a(@NonNull Uri uri, @NonNull Options options) {
        return "android.resource".equals(uri.getScheme());
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    @Nullable
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Resource<Bitmap> mo11820a(@NonNull Uri uri, int i, int i2, @NonNull Options options) {
        Resource<Drawable> mo11820a = this.f1068a.mo11820a(uri, i, i2, options);
        if (mo11820a == null) {
            return null;
        }
        return DrawableToBitmapConverter.m11933a(this.f1069b, mo11820a.mo11898d(), i, i2);
    }
}
