package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import java.io.File;

/* renamed from: com.bumptech.glide.load.resource.bitmap.b */
/* loaded from: classes.dex */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a */
    private final BitmapPool f1029a;

    /* renamed from: b */
    private final ResourceEncoder<Bitmap> f1030b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f1029a = bitmapPool;
        this.f1030b = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.Encoder
    /* renamed from: a */
    public boolean mo11855a(@NonNull Resource<BitmapDrawable> resource, @NonNull File file, @NonNull Options options) {
        return this.f1030b.mo11855a(new BitmapResource(resource.mo11898d().getBitmap(), this.f1029a), file, options);
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    @NonNull
    /* renamed from: a */
    public EncodeStrategy mo11856a(@NonNull Options options) {
        return this.f1030b.mo11856a(options);
    }
}
