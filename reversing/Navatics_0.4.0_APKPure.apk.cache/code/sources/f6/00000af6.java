package com.bumptech.glide.load.engine.p018a;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

/* compiled from: BitmapPoolAdapter.java */
/* renamed from: com.bumptech.glide.load.engine.a.f, reason: use source file name */
/* loaded from: classes.dex */
public class BitmapPoolAdapter implements InterfaceC0627e {
    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0627e
    /* renamed from: a */
    public void mo778a() {
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0627e
    /* renamed from: a */
    public void mo779a(int i) {
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0627e
    /* renamed from: a */
    public void mo780a(Bitmap bitmap) {
        bitmap.recycle();
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0627e
    @NonNull
    /* renamed from: a */
    public Bitmap mo777a(int i, int i2, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.p018a.InterfaceC0627e
    @NonNull
    /* renamed from: b */
    public Bitmap mo781b(int i, int i2, Bitmap.Config config) {
        return mo777a(i, i2, config);
    }
}