package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

/* loaded from: classes2.dex */
public class OverlayImageView extends ImageView {

    /* renamed from: a */
    C2735a f8990a;

    public OverlayImageView(Context context) {
        super(context);
        this.f8990a = new C2735a(null);
    }

    public OverlayImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8990a = new C2735a(null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8990a.m4042a(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f8990a.m4040a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8990a.m4043a(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f8990a.m4043a(i, i2);
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (drawable == this.f8990a.f8991a) {
            invalidate();
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void setOverlayDrawable(Drawable drawable) {
        if (drawable != this.f8990a.f8991a) {
            this.f8990a.m4041a(this);
            if (drawable != null) {
                drawable.setCallback(this);
            }
            this.f8990a = new C2735a(drawable);
            this.f8990a.m4040a(getDrawableState());
            requestLayout();
        }
    }

    /* renamed from: com.twitter.sdk.android.tweetui.internal.OverlayImageView$a */
    /* loaded from: classes2.dex */
    protected static class C2735a {

        /* renamed from: a */
        final Drawable f8991a;

        C2735a(Drawable drawable) {
            this.f8991a = drawable;
        }

        /* renamed from: a */
        protected void m4041a(ImageView imageView) {
            Drawable drawable = this.f8991a;
            if (drawable != null) {
                drawable.setCallback(null);
                imageView.unscheduleDrawable(this.f8991a);
            }
        }

        /* renamed from: a */
        protected void m4043a(int i, int i2) {
            Drawable drawable = this.f8991a;
            if (drawable != null) {
                drawable.setBounds(0, 0, i, i2);
            }
        }

        /* renamed from: a */
        protected void m4040a(int[] iArr) {
            Drawable drawable = this.f8991a;
            if (drawable == null || !drawable.isStateful()) {
                return;
            }
            this.f8991a.setState(iArr);
        }

        /* renamed from: a */
        protected void m4042a(Canvas canvas) {
            Drawable drawable = this.f8991a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }
    }
}
