package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.resource.bitmap.a */
/* loaded from: classes.dex */
public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a */
    private final ResourceDecoder<DataType, Bitmap> f1027a;

    /* renamed from: b */
    private final Resources f1028b;

    public BitmapDrawableDecoder(@NonNull Resources resources, @NonNull ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.f1028b = (Resources) Preconditions.m11580a(resources);
        this.f1027a = (ResourceDecoder) Preconditions.m11580a(resourceDecoder);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a */
    public boolean mo11819a(@NonNull DataType datatype, @NonNull Options options) throws IOException {
        return this.f1027a.mo11819a(datatype, options);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a */
    public Resource<BitmapDrawable> mo11820a(@NonNull DataType datatype, int i, int i2, @NonNull Options options) throws IOException {
        return LazyBitmapDrawableResource.m11925a(this.f1028b, this.f1027a.mo11820a(datatype, i, i2, options));
    }
}
