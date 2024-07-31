package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.util.C0791i;
import com.bumptech.glide.util.Preconditions;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.bumptech.glide.load.resource.bitmap.r */
/* loaded from: classes.dex */
public final class RoundedCorners extends BitmapTransformation {

    /* renamed from: b */
    private static final byte[] f1070b = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(f695a);

    /* renamed from: c */
    private final int f1071c;

    public RoundedCorners(int i) {
        Preconditions.m11576a(i > 0, "roundingRadius must be greater than 0.");
        this.f1071c = i;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /* renamed from: a */
    protected Bitmap mo7404a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return TransformationUtils.m11905b(bitmapPool, bitmap, this.f1071c);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return (obj instanceof RoundedCorners) && this.f1071c == ((RoundedCorners) obj).f1071c;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return C0791i.m11559b("com.bumptech.glide.load.resource.bitmap.RoundedCorners".hashCode(), C0791i.m11560b(this.f1071c));
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f1070b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f1071c).array());
    }
}
