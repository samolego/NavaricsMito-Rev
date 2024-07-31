package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.squareup.picasso.o */
/* loaded from: classes2.dex */
public final class PicassoDrawable extends BitmapDrawable {

    /* renamed from: e */
    private static final Paint f6967e = new Paint();

    /* renamed from: a */
    Drawable f6968a;

    /* renamed from: b */
    long f6969b;

    /* renamed from: c */
    boolean f6970c;

    /* renamed from: d */
    int f6971d;

    /* renamed from: f */
    private final boolean f6972f;

    /* renamed from: g */
    private final float f6973g;

    /* renamed from: h */
    private final Picasso.LoadedFrom f6974h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5675a(ImageView imageView, Context context, Bitmap bitmap, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new PicassoDrawable(context, bitmap, drawable, loadedFrom, z, z2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m5674a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    PicassoDrawable(Context context, Bitmap bitmap, Drawable drawable, Picasso.LoadedFrom loadedFrom, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f6971d = 255;
        this.f6972f = z2;
        this.f6973g = context.getResources().getDisplayMetrics().density;
        this.f6974h = loadedFrom;
        if ((loadedFrom == Picasso.LoadedFrom.MEMORY || z) ? false : true) {
            this.f6968a = drawable;
            this.f6970c = true;
            this.f6969b = SystemClock.uptimeMillis();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.f6970c) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f6969b)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f6970c = false;
                this.f6968a = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f6968a;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (this.f6971d * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f6971d);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        }
        if (this.f6972f) {
            m5677a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f6971d = i;
        Drawable drawable = this.f6968a;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f6968a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f6968a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    /* renamed from: a */
    private void m5677a(Canvas canvas) {
        f6967e.setColor(-1);
        canvas.drawPath(m5676a(new Point(0, 0), (int) (this.f6973g * 16.0f)), f6967e);
        f6967e.setColor(this.f6974h.debugColor);
        canvas.drawPath(m5676a(new Point(0, 0), (int) (this.f6973g * 15.0f)), f6967e);
    }

    /* renamed from: a */
    private static Path m5676a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }
}
