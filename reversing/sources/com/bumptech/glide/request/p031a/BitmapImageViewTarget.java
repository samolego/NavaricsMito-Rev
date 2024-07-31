package com.bumptech.glide.request.p031a;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* renamed from: com.bumptech.glide.request.a.b */
/* loaded from: classes.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.p031a.ImageViewTarget
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public void mo11728a(Bitmap bitmap) {
        ((ImageView) this.f1224a).setImageBitmap(bitmap);
    }
}
