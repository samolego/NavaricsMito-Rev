package com.navatics.p057cv.p058a;

import android.graphics.Bitmap;

/* renamed from: com.navatics.cv.a.c */
/* loaded from: classes.dex */
public class NAVideoFrameYUV {

    /* renamed from: a */
    public int f5808a;

    /* renamed from: b */
    public int f5809b;

    /* renamed from: c */
    private Bitmap f5810c;

    /* renamed from: a */
    public static NAVideoFrameYUV m6850a(Bitmap bitmap) {
        return new NAVideoFrameYUV(bitmap);
    }

    private NAVideoFrameYUV(Bitmap bitmap) {
        this.f5810c = bitmap;
        this.f5809b = bitmap.getHeight();
        this.f5808a = bitmap.getWidth();
    }

    /* renamed from: a */
    public Bitmap m6851a() {
        return this.f5810c;
    }
}
