package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.Log;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.p022a.BitmapPool;
import com.bumptech.glide.load.engine.p022a.BitmapPoolAdapter;
import java.util.concurrent.locks.Lock;

/* renamed from: com.bumptech.glide.load.resource.bitmap.l */
/* loaded from: classes.dex */
final class DrawableToBitmapConverter {

    /* renamed from: a */
    private static final BitmapPool f1058a = new BitmapPoolAdapter() { // from class: com.bumptech.glide.load.resource.bitmap.l.1
        @Override // com.bumptech.glide.load.engine.p022a.BitmapPoolAdapter, com.bumptech.glide.load.engine.p022a.BitmapPool
        /* renamed from: a */
        public void mo11931a(Bitmap bitmap) {
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    /* renamed from: a */
    public static Resource<Bitmap> m11933a(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            bitmap = m11932b(bitmapPool, current, i, i2);
            z = true;
        }
        if (!z) {
            bitmapPool = f1058a;
        }
        return BitmapResource.m11980a(bitmap, bitmapPool);
    }

    @Nullable
    /* renamed from: b */
    private static Bitmap m11932b(BitmapPool bitmapPool, Drawable drawable, int i, int i2) {
        if (i == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicHeight() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + drawable + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        } else {
            if (drawable.getIntrinsicWidth() > 0) {
                i = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i2 = drawable.getIntrinsicHeight();
            }
            Lock m11917a = TransformationUtils.m11917a();
            m11917a.lock();
            Bitmap mo12181a = bitmapPool.mo12181a(i, i2, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(mo12181a);
                drawable.setBounds(0, 0, i, i2);
                drawable.draw(canvas);
                canvas.setBitmap(null);
                return mo12181a;
            } finally {
                m11917a.unlock();
            }
        }
    }
}
