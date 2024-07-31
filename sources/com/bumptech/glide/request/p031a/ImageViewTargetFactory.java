package com.bumptech.glide.request.p031a;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.widget.ImageView;

/* renamed from: com.bumptech.glide.request.a.e */
/* loaded from: classes.dex */
public class ImageViewTargetFactory {
    @NonNull
    /* renamed from: a */
    public <Z> ViewTarget<ImageView, Z> m11724a(@NonNull ImageView imageView, @NonNull Class<Z> cls) {
        if (Bitmap.class.equals(cls)) {
            return new BitmapImageViewTarget(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new DrawableImageViewTarget(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
