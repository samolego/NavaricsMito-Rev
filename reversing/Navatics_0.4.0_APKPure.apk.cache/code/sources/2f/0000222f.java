package com.twitter.sdk.android.tweetui.internal;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import com.twitter.sdk.android.tweetui.internal.ViewOnTouchListenerC2689f;

/* loaded from: classes2.dex */
public class MultiTouchImageView extends ImageView implements ViewOnTouchListenerC2689f.b {

    /* renamed from: a */
    final ScaleGestureDetector f9016a;

    /* renamed from: b */
    final GestureDetector f9017b;

    /* renamed from: c */
    final Matrix f9018c;

    /* renamed from: d */
    final Matrix f9019d;

    /* renamed from: e */
    final Matrix f9020e;

    /* renamed from: f */
    final RectF f9021f;

    /* renamed from: g */
    final RectF f9022g;

    /* renamed from: h */
    final float[] f9023h;

    /* renamed from: i */
    boolean f9024i;

    public MultiTouchImageView(Context context) {
        this(context, null);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9018c = new Matrix();
        this.f9019d = new Matrix();
        this.f9020e = new Matrix();
        this.f9021f = new RectF();
        this.f9022g = new RectF();
        this.f9023h = new float[9];
        this.f9016a = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                MultiTouchImageView.this.m8805a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                MultiTouchImageView.this.m8813e();
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                if (MultiTouchImageView.this.getScale() < 1.0f) {
                    MultiTouchImageView.this.m8811c();
                    MultiTouchImageView.this.m8813e();
                }
            }
        });
        this.f9017b = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                MultiTouchImageView.this.m8804a(-f, -f2);
                MultiTouchImageView.this.m8813e();
                if (!MultiTouchImageView.this.f9024i || MultiTouchImageView.this.f9016a.isInProgress()) {
                    return true;
                }
                MultiTouchImageView.this.m8808a(false);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (MultiTouchImageView.this.getScale() > 1.0f) {
                    MultiTouchImageView multiTouchImageView = MultiTouchImageView.this;
                    multiTouchImageView.m8806a(multiTouchImageView.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
                    return true;
                }
                MultiTouchImageView multiTouchImageView2 = MultiTouchImageView.this;
                multiTouchImageView2.m8806a(multiTouchImageView2.getScale(), 2.0f, motionEvent.getX(), motionEvent.getY());
                return true;
            }
        });
    }

    /* renamed from: a */
    boolean m8809a() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.getIntrinsicWidth() > 0;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (m8809a()) {
            m8810b();
            m8807a(getDrawable());
            m8813e();
        }
    }

    /* renamed from: b */
    void m8810b() {
        this.f9021f.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    }

    /* renamed from: a */
    void m8807a(Drawable drawable) {
        RectF rectF = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f9019d.reset();
        this.f9019d.setRectToRect(rectF, this.f9021f, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m8809a()) {
            return false;
        }
        m8808a(true);
        return (this.f9017b.onTouchEvent(motionEvent) || this.f9016a.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    void m8808a(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: a */
    void m8805a(float f, float f2, float f3) {
        this.f9020e.postScale(f, f, f2, f3);
    }

    float getScale() {
        this.f9020e.getValues(this.f9023h);
        return this.f9023h[0];
    }

    /* renamed from: a */
    void m8804a(float f, float f2) {
        this.f9020e.postTranslate(f, f2);
    }

    /* renamed from: c */
    void m8811c() {
        this.f9020e.reset();
    }

    /* renamed from: d */
    void m8812d() {
        float height;
        RectF m8803a = m8803a(getDrawMatrix());
        float f = 0.0f;
        if (m8803a.height() <= this.f9021f.height()) {
            height = ((this.f9021f.height() - m8803a.height()) / 2.0f) - m8803a.top;
        } else if (m8803a.top > 0.0f) {
            height = -m8803a.top;
        } else {
            height = m8803a.bottom < this.f9021f.height() ? this.f9021f.height() - m8803a.bottom : 0.0f;
        }
        if (m8803a.width() <= this.f9021f.width()) {
            this.f9024i = true;
            f = ((this.f9021f.width() - m8803a.width()) / 2.0f) - m8803a.left;
        } else if (m8803a.left > 0.0f) {
            this.f9024i = true;
            f = -m8803a.left;
        } else if (m8803a.right < this.f9021f.width()) {
            this.f9024i = true;
            f = this.f9021f.width() - m8803a.right;
        } else {
            this.f9024i = false;
        }
        m8804a(f, height);
    }

    /* renamed from: a */
    RectF m8803a(Matrix matrix) {
        if (getDrawable() != null) {
            this.f9022g.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
            matrix.mapRect(this.f9022g);
        }
        return this.f9022g;
    }

    Matrix getDrawMatrix() {
        this.f9018c.set(this.f9019d);
        this.f9018c.postConcat(this.f9020e);
        return this.f9018c;
    }

    /* renamed from: e */
    void m8813e() {
        m8812d();
        setScaleType(ImageView.ScaleType.MATRIX);
        setImageMatrix(getDrawMatrix());
    }

    /* renamed from: a */
    void m8806a(float f, float f2, final float f3, final float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MultiTouchImageView.this.m8805a(((Float) valueAnimator.getAnimatedValue()).floatValue() / MultiTouchImageView.this.getScale(), f3, f4);
                MultiTouchImageView.this.m8813e();
            }
        });
        ofFloat.start();
    }

    @Override // com.twitter.sdk.android.tweetui.internal.ViewOnTouchListenerC2689f.b
    /* renamed from: f */
    public boolean mo8814f() {
        return getScale() == 1.0f;
    }
}