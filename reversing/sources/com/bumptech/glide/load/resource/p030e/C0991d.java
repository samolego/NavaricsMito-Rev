package com.bumptech.glide.load.resource.p030e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.p026a.BytesResource;
import com.bumptech.glide.load.resource.p029d.GifDrawable;
import com.bumptech.glide.util.ByteBufferUtil;

/* renamed from: com.bumptech.glide.load.resource.e.d */
/* loaded from: classes.dex */
public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    @Override // com.bumptech.glide.load.resource.p030e.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<byte[]> mo11812a(@NonNull Resource<GifDrawable> resource, @NonNull Options options) {
        return new BytesResource(ByteBufferUtil.m11624a(resource.mo11898d().m11867c()));
    }
}
