package com.bumptech.glide.load;

import android.content.Context;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;

/* renamed from: com.bumptech.glide.load.i */
/* loaded from: classes.dex */
public interface Transformation<T> extends Key {
    @NonNull
    /* renamed from: a */
    Resource<T> mo11850a(@NonNull Context context, @NonNull Resource<T> resource, int i, int i2);
}
