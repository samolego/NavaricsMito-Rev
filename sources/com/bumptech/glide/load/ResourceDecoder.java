package com.bumptech.glide.load;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

/* renamed from: com.bumptech.glide.load.g */
/* loaded from: classes.dex */
public interface ResourceDecoder<T, Z> {
    @Nullable
    /* renamed from: a */
    Resource<Z> mo11820a(@NonNull T t, int i, int i2, @NonNull Options options) throws IOException;

    /* renamed from: a */
    boolean mo11819a(@NonNull T t, @NonNull Options options) throws IOException;
}
