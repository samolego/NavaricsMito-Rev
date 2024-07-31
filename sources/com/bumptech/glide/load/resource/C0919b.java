package com.bumptech.glide.load.resource;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.b */
/* loaded from: classes.dex */
public final class UnitTransformation<T> implements Transformation<T> {

    /* renamed from: b */
    private static final Transformation<?> f1008b = new UnitTransformation();

    @Override // com.bumptech.glide.load.Transformation
    @NonNull
    /* renamed from: a */
    public Resource<T> mo11850a(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
    }

    @NonNull
    /* renamed from: a */
    public static <T> UnitTransformation<T> m12003a() {
        return (UnitTransformation) f1008b;
    }

    private UnitTransformation() {
    }
}
