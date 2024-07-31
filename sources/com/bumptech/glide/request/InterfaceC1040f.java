package com.bumptech.glide.request;

import android.support.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.p031a.Target;

/* renamed from: com.bumptech.glide.request.f */
/* loaded from: classes.dex */
public interface RequestListener<R> {
    /* renamed from: a */
    boolean mo8724a(@Nullable GlideException glideException, Object obj, Target<R> target, boolean z);

    /* renamed from: a */
    boolean mo8723a(R r, Object obj, Target<R> target, DataSource dataSource, boolean z);
}
