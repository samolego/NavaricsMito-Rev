package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class OverlayImageView extends ImageView {

    /* renamed from: a */
    C2666a f9030a;

    public OverlayImageView(Context context) {
        super(context);
        this.f9030a = new C2666a(null);
    }

    public OverlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9030a = new C2666a(null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9030a.m8816a(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f9030a.m8818a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f9030a.m8815a(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f9030a.m8815a(i, i2);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f9030a.f9031a) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void setOverlayDrawable(Drawable drawable) {
        if (drawable != this.f9030a.f9031a) {
            this.f9030a.m8817a(this);
            if (drawable != null) {
                drawable.setCallback(this);
            }
            this.f9030a = new C2666a(drawable);
            this.f9030a.m8818a(getDrawableState());
            requestLayout();
        }
    }

    /* renamed from: com.twitter.sdk.android.tweetui.internal.OverlayImageView$a */
    /* loaded from: classes2.dex */
    protected static class C2666a {

        /* renamed from: a */
        final Drawable f9031a;

        C2666a(Drawable drawable) {
            this.f9031a = drawable;
        }

        /* renamed from: a */
        protected void m8817a(ImageView imageView) {
            Drawable drawable = this.f9031a;
            if (drawable != null) {
                drawable.setCallback(null);
                imageView.unscheduleDrawable(this.f9031a);
            }
        }

        /* renamed from: a */
        protected void m8815a(int i, int i2) {
            Drawable drawable = this.f9031a;
            if (drawable != null) {
                drawable.setBounds(0, 0, i, i2);
            }
        }

        /* renamed from: a */
        protected void m8818a(int[] iArr) {
            Drawable drawable = this.f9031a;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            this.f9031a.setState(iArr);
        }

        /* renamed from: a */
        protected void m8816a(Canvas canvas) {
            Drawable drawable = this.f9031a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }
}