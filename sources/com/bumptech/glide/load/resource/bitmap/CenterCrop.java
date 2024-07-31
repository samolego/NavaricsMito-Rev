package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.g */
/* loaded from: classes.dex */
public class CenterCrop extends BitmapTransformation {

    /* renamed from: b */
    private static final byte[] f1037b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(f695a);

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /* renamed from: a */
    protected Bitmap mo7404a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m11908a(bitmapPool, bitmap, i, i2);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof CenterCrop;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CenterCrop".hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f1037b);
    }
}
