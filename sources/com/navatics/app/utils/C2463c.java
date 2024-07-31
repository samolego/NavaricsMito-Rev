package com.navatics.app.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.security.MessageDigest;

/* renamed from: com.navatics.app.utils.c */
/* loaded from: classes.dex */
public class CircleCropWithBorder extends BitmapTransformation {

    /* renamed from: d */
    private static final byte[] f5123d = "com.bumptech.glide.load.resource.bitmap.CircleCropWithBorder.1".getBytes(f695a);

    /* renamed from: b */
    int f5124b;

    /* renamed from: c */
    int f5125c;

    public CircleCropWithBorder(int i, int i2) {
        this.f5124b = i;
        this.f5125c = i2;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    /* renamed from: a */
    protected Bitmap mo7404a(@NonNull BitmapPool bitmapPool, @NonNull Bitmap bitmap, int i, int i2) {
        return m7405a(TransformationUtils.m11902d(bitmapPool, bitmap, i, i2), this.f5124b, this.f5125c);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        return obj instanceof CircleCropWithBorder;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return "com.bumptech.glide.load.resource.bitmap.CircleCropWithBorder.1".hashCode();
    }

    @Override // com.bumptech.glide.load.Key
    /* renamed from: a */
    public void mo7353a(@NonNull MessageDigest messageDigest) {
        messageDigest.update(f5123d);
    }

    /* renamed from: a */
    protected Bitmap m7405a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth() + (i * 2);
        Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        float f = i;
        canvas.drawBitmap(bitmap, f, f, (Paint) null);
        Paint paint = new Paint();
        paint.setColor(i2);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(f);
        paint.setAntiAlias(true);
        canvas.drawCircle(canvas.getWidth() / 2, canvas.getWidth() / 2, (canvas.getWidth() / 2) - (i / 2), paint);
        bitmap.recycle();
        return createBitmap;
    }
}
