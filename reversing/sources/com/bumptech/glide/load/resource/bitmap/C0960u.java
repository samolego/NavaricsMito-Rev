package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.C0791i;

/* renamed from: com.bumptech.glide.load.resource.bitmap.u */
/* loaded from: classes.dex */
public final class UnitBitmapDecoder implements ResourceDecoder<Bitmap, Bitmap> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public boolean mo11819a(@NonNull Bitmap bitmap, @NonNull Options options) {
        return true;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public Resource<Bitmap> mo11820a(@NonNull Bitmap bitmap, int i, int i2, @NonNull Options options) {
        return new C0753a(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UnitBitmapDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.u$a */
    /* loaded from: classes.dex */
    public static final class C0753a implements Resource<Bitmap> {

        /* renamed from: a */
        private final Bitmap f1081a;

        @Override // com.bumptech.glide.load.engine.Resource
        /* renamed from: f */
        public void mo11851f() {
        }

        C0753a(@NonNull Bitmap bitmap) {
            this.f1081a = bitmap;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        /* renamed from: c */
        public Class<Bitmap> mo11853c() {
            return Bitmap.class;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        @NonNull
        /* renamed from: a */
        public Bitmap mo11898d() {
            return this.f1081a;
        }

        @Override // com.bumptech.glide.load.engine.Resource
        /* renamed from: e */
        public int mo11852e() {
            return C0791i.m11568a(this.f1081a);
        }
    }
}
