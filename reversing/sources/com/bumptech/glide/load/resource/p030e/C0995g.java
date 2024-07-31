package com.bumptech.glide.load.resource.p030e;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.resource.e.g */
/* loaded from: classes.dex */
public class UnitTranscoder<Z> implements ResourceTranscoder<Z, Z> {

    /* renamed from: a */
    private static final UnitTranscoder<?> f1149a = new UnitTranscoder<>();

    @Override // com.bumptech.glide.load.resource.p030e.ResourceTranscoder
    @Nullable
    /* renamed from: a */
    public Resource<Z> mo11812a(@NonNull Resource<Z> resource, @NonNull Options options) {
        return resource;
    }

    /* renamed from: a */
    public static <Z> ResourceTranscoder<Z, Z> m11813a() {
        return f1149a;
    }
}
