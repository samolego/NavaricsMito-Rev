package com.navatics.cv.p051a;

import android.graphics.Bitmap;

/* compiled from: NAVideoFrameYUV.java */
/* renamed from: com.navatics.cv.a.c, reason: use source file name */
/* loaded from: classes.dex */
public class NAVideoFrameYUV {

    /* renamed from: a */
    public int f5832a;

    /* renamed from: b */
    public int f5833b;

    /* renamed from: c */
    private Bitmap f5834c;

    /* renamed from: a */
    public static NAVideoFrameYUV m6010a(Bitmap bitmap) {
        return new NAVideoFrameYUV(bitmap);
    }

    private NAVideoFrameYUV(Bitmap bitmap) {
        this.f5834c = bitmap;
        this.f5833b = bitmap.getHeight();
        this.f5832a = bitmap.getWidth();
    }

    /* renamed from: a */
    public Bitmap m6011a() {
        return this.f5834c;
    }
}