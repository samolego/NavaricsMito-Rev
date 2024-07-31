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
import com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener;

/* loaded from: classes2.dex */
public class MultiTouchImageView extends ImageView implements SwipeToDismissTouchListener.InterfaceC2760b {

    /* renamed from: a */
    final ScaleGestureDetector f8976a;

    /* renamed from: b */
    final GestureDetector f8977b;

    /* renamed from: c */
    final Matrix f8978c;

    /* renamed from: d */
    final Matrix f8979d;

    /* renamed from: e */
    final Matrix f8980e;

    /* renamed from: f */
    final RectF f8981f;

    /* renamed from: g */
    final RectF f8982g;

    /* renamed from: h */
    final float[] f8983h;

    /* renamed from: i */
    boolean f8984i;

    public MultiTouchImageView(Context context) {
        this(context, null);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MultiTouchImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8978c = new Matrix();
        this.f8979d = new Matrix();
        this.f8980e = new Matrix();
        this.f8981f = new RectF();
        this.f8982g = new RectF();
        this.f8983h = new float[9];
        this.f8976a = new ScaleGestureDetector(context, new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.1
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                MultiTouchImageView.this.m4052a(scaleGestureDetector.getScaleFactor(), scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                MultiTouchImageView.this.m4044e();
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                if (MultiTouchImageView.this.getScale() < 1.0f) {
                    MultiTouchImageView.this.m4046c();
                    MultiTouchImageView.this.m4044e();
                }
            }
        });
        this.f8977b = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                MultiTouchImageView.this.m4053a(-f, -f2);
                MultiTouchImageView.this.m4044e();
                if (!MultiTouchImageView.this.f8984i || MultiTouchImageView.this.f8976a.isInProgress()) {
                    return true;
                }
                MultiTouchImageView.this.m4048a(false);
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (MultiTouchImageView.this.getScale() > 1.0f) {
                    MultiTouchImageView multiTouchImageView = MultiTouchImageView.this;
                    multiTouchImageView.m4051a(multiTouchImageView.getScale(), 1.0f, motionEvent.getX(), motionEvent.getY());
                    return true;
                }
                MultiTouchImageView multiTouchImageView2 = MultiTouchImageView.this;
                multiTouchImageView2.m4051a(multiTouchImageView2.getScale(), 2.0f, motionEvent.getX(), motionEvent.getY());
                return true;
            }
        });
    }

    /* renamed from: a */
    boolean m4054a() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.getIntrinsicWidth() > 0;
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (m4054a()) {
            m4047b();
            m4049a(getDrawable());
            m4044e();
        }
    }

    /* renamed from: b */
    void m4047b() {
        this.f8981f.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
    }

    /* renamed from: a */
    void m4049a(Drawable drawable) {
        RectF rectF = new RectF(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f8979d.reset();
        this.f8979d.setRectToRect(rectF, this.f8981f, Matrix.ScaleToFit.CENTER);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m4054a()) {
            m4048a(true);
            return (this.f8977b.onTouchEvent(motionEvent) || this.f8976a.onTouchEvent(motionEvent)) || super.onTouchEvent(motionEvent);
        }
        return false;
    }

    /* renamed from: a */
    void m4048a(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    /* renamed from: a */
    void m4052a(float f, float f2, float f3) {
        this.f8980e.postScale(f, f, f2, f3);
    }

    float getScale() {
        this.f8980e.getValues(this.f8983h);
        return this.f8983h[0];
    }

    /* renamed from: a */
    void m4053a(float f, float f2) {
        this.f8980e.postTranslate(f, f2);
    }

    /* renamed from: c */
    void m4046c() {
        this.f8980e.reset();
    }

    /* renamed from: d */
    void m4045d() {
        float height;
        RectF m4050a = m4050a(getDrawMatrix());
        float f = 0.0f;
        if (m4050a.height() <= this.f8981f.height()) {
            height = ((this.f8981f.height() - m4050a.height()) / 2.0f) - m4050a.top;
        } else if (m4050a.top > 0.0f) {
            height = -m4050a.top;
        } else {
            height = m4050a.bottom < this.f8981f.height() ? this.f8981f.height() - m4050a.bottom : 0.0f;
        }
        if (m4050a.width() <= this.f8981f.width()) {
            this.f8984i = true;
            f = ((this.f8981f.width() - m4050a.width()) / 2.0f) - m4050a.left;
        } else if (m4050a.left > 0.0f) {
            this.f8984i = true;
            f = -m4050a.left;
        } else if (m4050a.right < this.f8981f.width()) {
            this.f8984i = true;
            f = this.f8981f.width() - m4050a.right;
        } else {
            this.f8984i = false;
        }
        m4053a(f, height);
    }

    /* renamed from: a */
    RectF m4050a(Matrix matrix) {
        Drawable drawable = getDrawable();
        if (drawable != null) {
            this.f8982g.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.f8982g);
        }
        return this.f8982g;
    }

    Matrix getDrawMatrix() {
        this.f8978c.set(this.f8979d);
        this.f8978c.postConcat(this.f8980e);
        return this.f8978c;
    }

    /* renamed from: e */
    void m4044e() {
        m4045d();
        setScaleType(ImageView.ScaleType.MATRIX);
        setImageMatrix(getDrawMatrix());
    }

    /* renamed from: a */
    void m4051a(float f, float f2, final float f3, final float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.MultiTouchImageView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MultiTouchImageView.this.m4052a(((Float) valueAnimator.getAnimatedValue()).floatValue() / MultiTouchImageView.this.getScale(), f3, f4);
                MultiTouchImageView.this.m4044e();
            }
        });
        ofFloat.start();
    }

    @Override // com.twitter.sdk.android.tweetui.internal.SwipeToDismissTouchListener.InterfaceC2760b
    /* renamed from: f */
    public boolean mo3930f() {
        return getScale() == 1.0f;
    }
}
