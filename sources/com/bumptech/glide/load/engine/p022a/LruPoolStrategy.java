package com.bumptech.glide.load.engine.p022a;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;

/* renamed from: com.bumptech.glide.load.engine.a.l */
/* loaded from: classes.dex */
interface LruPoolStrategy {
    @Nullable
    /* renamed from: a */
    Bitmap mo12165a();

    @Nullable
    /* renamed from: a */
    Bitmap mo12164a(int i, int i2, Bitmap.Config config);

    /* renamed from: a */
    void mo12161a(Bitmap bitmap);

    /* renamed from: b */
    String mo12159b(int i, int i2, Bitmap.Config config);

    /* renamed from: b */
    String mo12156b(Bitmap bitmap);

    /* renamed from: c */
    int mo12155c(Bitmap bitmap);
}
