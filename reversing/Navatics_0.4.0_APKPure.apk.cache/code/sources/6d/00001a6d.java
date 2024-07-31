package com.navatics.app.widget.dialog;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.navatics.app.R;
import com.navatics.robot.utils.DpiUtils;
import io.reactivex.annotations.NonNull;

/* loaded from: classes.dex */
public class MiniLoadingView extends View {

    /* renamed from: a */
    private int f5674a;

    /* renamed from: b */
    private int f5675b;

    /* renamed from: c */
    private int f5676c;

    /* renamed from: d */
    private ValueAnimator f5677d;

    /* renamed from: e */
    private Paint f5678e;

    /* renamed from: f */
    private ValueAnimator.AnimatorUpdateListener f5679f;

    public MiniLoadingView(Context context) {
        this(context, null);
    }

    public MiniLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MiniLoadingStyle);
    }

    public MiniLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5676c = 0;
        this.f5679f = new ValueAnimator.AnimatorUpdateListener() { // from class: com.navatics.app.widget.dialog.MiniLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MiniLoadingView.this.f5676c = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                MiniLoadingView.this.invalidate();
            }
        };
        m5887a(context, attributeSet, i);
        m5889c();
    }

    /* renamed from: a */
    private void m5887a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MiniLoadingView, i, 0);
        this.f5674a = obtainStyledAttributes.getDimensionPixelSize(1, DpiUtils.m6962a(context, 32.0f));
        this.f5675b = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    private void m5889c() {
        this.f5678e = new Paint();
        this.f5678e.setColor(this.f5675b);
        this.f5678e.setAntiAlias(true);
        this.f5678e.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setColor(int i) {
        this.f5675b = i;
        this.f5678e.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.f5674a = i;
        requestLayout();
    }

    /* renamed from: a */
    public void m5890a() {
        ValueAnimator valueAnimator = this.f5677d;
        if (valueAnimator == null) {
            this.f5677d = ValueAnimator.ofInt(0, 11);
            this.f5677d.addUpdateListener(this.f5679f);
            this.f5677d.setDuration(600L);
            this.f5677d.setRepeatMode(1);
            this.f5677d.setRepeatCount(-1);
            this.f5677d.setInterpolator(new LinearInterpolator());
            this.f5677d.start();
            return;
        }
        if (valueAnimator.isStarted()) {
            return;
        }
        this.f5677d.start();
    }

    /* renamed from: b */
    public void m5891b() {
        ValueAnimator valueAnimator = this.f5677d;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.f5679f);
            this.f5677d.removeAllUpdateListeners();
            this.f5677d.cancel();
            this.f5677d = null;
        }
    }

    /* renamed from: a */
    private void m5888a(Canvas canvas, int i) {
        int i2 = this.f5674a;
        int i3 = i2 / 12;
        int i4 = i2 / 6;
        this.f5678e.setStrokeWidth(i3);
        int i5 = this.f5674a;
        canvas.rotate(i, i5 / 2, i5 / 2);
        int i6 = this.f5674a;
        canvas.translate(i6 / 2, i6 / 2);
        int i7 = 0;
        while (i7 < 12) {
            canvas.rotate(30.0f);
            i7++;
            this.f5678e.setAlpha((int) ((i7 * 255.0f) / 12.0f));
            int i8 = i3 / 2;
            canvas.translate(0.0f, ((-this.f5674a) / 2) + i8);
            canvas.drawLine(0.0f, 0.0f, 0.0f, i4, this.f5678e);
            canvas.translate(0.0f, (this.f5674a / 2) - i8);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.f5674a;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        m5888a(canvas, this.f5676c * 30);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m5890a();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m5891b();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            m5890a();
        } else {
            m5891b();
        }
    }
}