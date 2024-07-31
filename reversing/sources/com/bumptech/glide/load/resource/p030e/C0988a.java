package com.bumptech.glide.load.resource.p030e;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.p026a.BytesResource;
import java.io.ByteArrayOutputStream;

/* renamed from: com.bumptech.glide.load.resource.e.a */
/* loaded from: classes.dex */
public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {

    /* renamed from: a */
    private final Bitmap.CompressFormat f1139a;

    /* renamed from: b */
    private final int f1140b;

    public BitmapBytesTranscoder() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    public BitmapBytesTranscoder(@NonNull Bitmap.CompressFormat compressFormat, int i) {
        this.f1139a = compressFormat;
        this.f1140b = i;
    }

    @Override // com.bumptech.glide.load.resource.p030e.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<byte[]> mo11812a(@NonNull Resource<Bitmap> resource, @NonNull Options options) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        resource.mo11898d().compress(this.f1139a, this.f1140b, byteArrayOutputStream);
        resource.mo11851f();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }
}
