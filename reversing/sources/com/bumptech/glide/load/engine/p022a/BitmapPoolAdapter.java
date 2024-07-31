package com.bumptech.glide.load.engine.p022a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/* renamed from: com.bumptech.glide.load.engine.a.f */
/* loaded from: classes.dex */
public class BitmapPoolAdapter implements BitmapPool {
    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    /* renamed from: a */
    public void mo12183a() {
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    /* renamed from: a */
    public void mo12182a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    /* renamed from: a */
    public void mo11931a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    @NonNull
    /* renamed from: a */
    public Bitmap mo12181a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.p022a.BitmapPool
    @NonNull
    /* renamed from: b */
    public Bitmap mo12177b(int i, int i2, Bitmap.Config config) {
        return mo12181a(i, i2, config);
    }
}
