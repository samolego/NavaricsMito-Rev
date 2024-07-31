package com.navatics.app.widget.avloading;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.navatics.app.R;

/* loaded from: classes.dex */
public class AVLoadingIndicatorView extends View {

    /* renamed from: e */
    private static final BallPulseIndicator f5552e = new BallPulseIndicator();

    /* renamed from: a */
    int f5553a;

    /* renamed from: b */
    int f5554b;

    /* renamed from: c */
    int f5555c;

    /* renamed from: d */
    int f5556d;

    /* renamed from: f */
    private long f5557f;

    /* renamed from: g */
    private boolean f5558g;

    /* renamed from: h */
    private boolean f5559h;

    /* renamed from: i */
    private boolean f5560i;

    /* renamed from: j */
    private final Runnable f5561j;

    /* renamed from: k */
    private final Runnable f5562k;

    /* renamed from: l */
    private Indicator f5563l;

    /* renamed from: m */
    private int f5564m;

    /* renamed from: n */
    private boolean f5565n;

    public AVLoadingIndicatorView(Context context) {
        super(context);
        this.f5557f = -1L;
        this.f5558g = false;
        this.f5559h = false;
        this.f5560i = false;
        this.f5561j = new Runnable() { // from class: com.navatics.app.widget.avloading.AVLoadingIndicatorView.1
            @Override // java.lang.Runnable
            public void run() {
                AVLoadingIndicatorView.this.f5558g = false;
                AVLoadingIndicatorView.this.f5557f = -1L;
                AVLoadingIndicatorView.this.setVisibility(8);
            }
        };
        this.f5562k = new Runnable() { // from class: com.navatics.app.widget.avloading.AVLoadingIndicatorView.2
            @Override // java.lang.Runnable
            public void run() {
                AVLoadingIndicatorView.this.f5559h = false;
                if (AVLoadingIndicatorView.this.f5560i) {
                    return;
                }
                AVLoadingIndicatorView.this.f5557f = System.currentTimeMillis();
                AVLoadingIndicatorView.this.setVisibility(0);
            }
        };
        m7056a(context, null, 0, 0);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5557f = -1L;
        this.f5558g = false;
        this.f5559h = false;
        this.f5560i = false;
        this.f5561j = new Runnable() { // from class: com.navatics.app.widget.avloading.AVLoadingIndicatorView.1
            @Override // java.lang.Runnable
            public void run() {
                AVLoadingIndicatorView.this.f5558g = false;
                AVLoadingIndicatorView.this.f5557f = -1L;
                AVLoadingIndicatorView.this.setVisibility(8);
            }
        };
        this.f5562k = new Runnable() { // from class: com.navatics.app.widget.avloading.AVLoadingIndicatorView.2
            @Override // java.lang.Runnable
            public void run() {
                AVLoadingIndicatorView.this.f5559h = false;
                if (AVLoadingIndicatorView.this.f5560i) {
                    return;
                }
                AVLoadingIndicatorView.this.f5557f = System.currentTimeMillis();
                AVLoadingIndicatorView.this.setVisibility(0);
            }
        };
        m7056a(context, attributeSet, 0, R.style.AVLoadingIndicatorView);
    }

    public AVLoadingIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5557f = -1L;
        this.f5558g = false;
        this.f5559h = false;
        this.f5560i = false;
        this.f5561j = new Runnable() { // from class: com.navatics.app.widget.avloading.AVLoadingIndicatorView.1
            @Override // java.lang.Runnable
            public void run() {
                AVLoadingIndicatorView.this.f5558g = false;
                AVLoadingIndicatorView.this.f5557f = -1L;
                AVLoadingIndicatorView.this.setVisibility(8);
            }
        };
        this.f5562k = new Runnable() { // from class: com.navatics.app.widget.avloading.AVLoadingIndicatorView.2
            @Override // java.lang.Runnable
            public void run() {
                AVLoadingIndicatorView.this.f5559h = false;
                if (AVLoadingIndicatorView.this.f5560i) {
                    return;
                }
                AVLoadingIndicatorView.this.f5557f = System.currentTimeMillis();
                AVLoadingIndicatorView.this.setVisibility(0);
            }
        };
        m7056a(context, attributeSet, i, R.style.AVLoadingIndicatorView);
    }

    /* renamed from: a */
    private void m7056a(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f5553a = 24;
        this.f5554b = 48;
        this.f5555c = 24;
        this.f5556d = 48;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AVLoadingIndicatorView, i, i2);
        this.f5553a = obtainStyledAttributes.getDimensionPixelSize(5, this.f5553a);
        this.f5554b = obtainStyledAttributes.getDimensionPixelSize(3, this.f5554b);
        this.f5555c = obtainStyledAttributes.getDimensionPixelSize(4, this.f5555c);
        this.f5556d = obtainStyledAttributes.getDimensionPixelSize(2, this.f5556d);
        String string = obtainStyledAttributes.getString(1);
        this.f5564m = obtainStyledAttributes.getColor(0, -1);
        setIndicator(string);
        if (this.f5563l == null) {
            setIndicator(f5552e);
        }
        obtainStyledAttributes.recycle();
    }

    public Indicator getIndicator() {
        return this.f5563l;
    }

    public void setIndicator(Indicator indicator) {
        Indicator indicator2 = this.f5563l;
        if (indicator2 != indicator) {
            if (indicator2 != null) {
                indicator2.setCallback(null);
                unscheduleDrawable(this.f5563l);
            }
            this.f5563l = indicator;
            setIndicatorColor(this.f5564m);
            if (indicator != null) {
                indicator.setCallback(this);
            }
            postInvalidate();
        }
    }

    public void setIndicatorColor(int i) {
        this.f5564m = i;
        this.f5563l.m7042a(i);
    }

    public void setIndicator(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        if (!str.contains(".")) {
            sb.append(getClass().getPackage().getName());
            sb.append(".");
        }
        sb.append(str);
        try {
            setIndicator((Indicator) Class.forName(sb.toString()).newInstance());
        } catch (ClassNotFoundException unused) {
            Log.e("AVLoadingIndicatorView", "Didn't find your class , check the name again !");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public boolean m7058a() {
        return this.f5560i;
    }

    /* renamed from: b */
    public void m7051b() {
        this.f5560i = true;
        removeCallbacks(this.f5562k);
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.f5557f;
        long j2 = currentTimeMillis - j;
        if (j2 >= 500 || j == -1) {
            setVisibility(8);
        } else if (this.f5558g) {
        } else {
            postDelayed(this.f5561j, 500 - j2);
            this.f5558g = true;
        }
    }

    /* renamed from: c */
    public void m7049c() {
        this.f5557f = -1L;
        this.f5560i = false;
        removeCallbacks(this.f5561j);
        if (this.f5559h) {
            return;
        }
        postDelayed(this.f5562k, 500L);
        this.f5559h = true;
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return drawable == this.f5563l || super.verifyDrawable(drawable);
    }

    /* renamed from: d */
    void m7048d() {
        if (getVisibility() != 0) {
            return;
        }
        if (this.f5563l instanceof Animatable) {
            this.f5565n = true;
        }
        postInvalidate();
    }

    /* renamed from: e */
    void m7047e() {
        Indicator indicator = this.f5563l;
        if (indicator instanceof Animatable) {
            indicator.stop();
            this.f5565n = false;
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        if (getVisibility() != i) {
            super.setVisibility(i);
            if (i == 8 || i == 4) {
                m7047e();
            } else {
                m7048d();
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 8 || i == 4) {
            m7047e();
        } else {
            m7048d();
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        if (verifyDrawable(drawable)) {
            Rect bounds = drawable.getBounds();
            int scrollX = getScrollX() + getPaddingLeft();
            int scrollY = getScrollY() + getPaddingTop();
            invalidate(bounds.left + scrollX, bounds.top + scrollY, bounds.right + scrollX, bounds.bottom + scrollY);
            return;
        }
        super.invalidateDrawable(drawable);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        m7057a(i, i2);
    }

    /* renamed from: a */
    private void m7057a(int i, int i2) {
        Indicator indicator;
        int i3;
        int i4;
        int paddingRight = i - (getPaddingRight() + getPaddingLeft());
        int paddingTop = i2 - (getPaddingTop() + getPaddingBottom());
        if (this.f5563l != null) {
            float intrinsicWidth = indicator.getIntrinsicWidth() / this.f5563l.getIntrinsicHeight();
            float f = paddingRight;
            float f2 = paddingTop;
            float f3 = f / f2;
            int i5 = 0;
            if (intrinsicWidth == f3) {
                i3 = paddingTop;
                i4 = 0;
            } else if (f3 > intrinsicWidth) {
                int i6 = (int) (f2 * intrinsicWidth);
                int i7 = (paddingRight - i6) / 2;
                i5 = i7;
                paddingRight = i6 + i7;
                i3 = paddingTop;
                i4 = 0;
            } else {
                int i8 = (int) (f * (1.0f / intrinsicWidth));
                i4 = (paddingTop - i8) / 2;
                i3 = i8 + i4;
            }
            this.f5563l.setBounds(i5, i4, paddingRight, i3);
        }
    }

    @Override // android.view.View
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m7055a(canvas);
    }

    /* renamed from: a */
    void m7055a(Canvas canvas) {
        Indicator indicator = this.f5563l;
        if (indicator != null) {
            int save = canvas.save();
            canvas.translate(getPaddingLeft(), getPaddingTop());
            indicator.draw(canvas);
            canvas.restoreToCount(save);
            if (this.f5565n && (indicator instanceof Animatable)) {
                indicator.start();
                this.f5565n = false;
            }
        }
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        int i3;
        int i4;
        Indicator indicator = this.f5563l;
        if (indicator != null) {
            i4 = Math.max(this.f5553a, Math.min(this.f5554b, indicator.getIntrinsicWidth()));
            i3 = Math.max(this.f5555c, Math.min(this.f5556d, indicator.getIntrinsicHeight()));
        } else {
            i3 = 0;
            i4 = 0;
        }
        m7046f();
        setMeasuredDimension(resolveSizeAndState(i4 + getPaddingLeft() + getPaddingRight(), i, 0), resolveSizeAndState(i3 + getPaddingTop() + getPaddingBottom(), i2, 0));
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        m7046f();
    }

    /* renamed from: f */
    private void m7046f() {
        int[] drawableState = getDrawableState();
        Indicator indicator = this.f5563l;
        if (indicator == null || !indicator.isStateful()) {
            return;
        }
        this.f5563l.setState(drawableState);
    }

    @Override // android.view.View
    @TargetApi(21)
    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Indicator indicator = this.f5563l;
        if (indicator != null) {
            indicator.setHotspot(f, f2);
        }
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m7048d();
        m7045g();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        m7047e();
        super.onDetachedFromWindow();
        m7045g();
    }

    /* renamed from: g */
    private void m7045g() {
        removeCallbacks(this.f5561j);
        removeCallbacks(this.f5562k);
    }
}
