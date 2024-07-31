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
    private int f5652a;

    /* renamed from: b */
    private int f5653b;

    /* renamed from: c */
    private int f5654c;

    /* renamed from: d */
    private ValueAnimator f5655d;

    /* renamed from: e */
    private Paint f5656e;

    /* renamed from: f */
    private ValueAnimator.AnimatorUpdateListener f5657f;

    public MiniLoadingView(Context context) {
        this(context, null);
    }

    public MiniLoadingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.MiniLoadingStyle);
    }

    public MiniLoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5654c = 0;
        this.f5657f = new ValueAnimator.AnimatorUpdateListener() { // from class: com.navatics.app.widget.dialog.MiniLoadingView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MiniLoadingView.this.f5654c = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                MiniLoadingView.this.invalidate();
            }
        };
        m6978a(context, attributeSet, i);
        m6974c();
    }

    /* renamed from: a */
    private void m6978a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MiniLoadingView, i, 0);
        this.f5652a = obtainStyledAttributes.getDimensionPixelSize(1, DpiUtils.m5887a(context, 32.0f));
        this.f5653b = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: c */
    private void m6974c() {
        this.f5656e = new Paint();
        this.f5656e.setColor(this.f5653b);
        this.f5656e.setAntiAlias(true);
        this.f5656e.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setColor(int i) {
        this.f5653b = i;
        this.f5656e.setColor(i);
        invalidate();
    }

    public void setSize(int i) {
        this.f5652a = i;
        requestLayout();
    }

    /* renamed from: a */
    public void m6979a() {
        ValueAnimator valueAnimator = this.f5655d;
        if (valueAnimator == null) {
            this.f5655d = ValueAnimator.ofInt(0, 11);
            this.f5655d.addUpdateListener(this.f5657f);
            this.f5655d.setDuration(600L);
            this.f5655d.setRepeatMode(1);
            this.f5655d.setRepeatCount(-1);
            this.f5655d.setInterpolator(new LinearInterpolator());
            this.f5655d.start();
        } else if (valueAnimator.isStarted()) {
        } else {
            this.f5655d.start();
        }
    }

    /* renamed from: b */
    public void m6975b() {
        ValueAnimator valueAnimator = this.f5655d;
        if (valueAnimator != null) {
            valueAnimator.removeUpdateListener(this.f5657f);
            this.f5655d.removeAllUpdateListeners();
            this.f5655d.cancel();
            this.f5655d = null;
        }
    }

    /* renamed from: a */
    private void m6977a(Canvas canvas, int i) {
        int i2 = this.f5652a;
        int i3 = i2 / 12;
        int i4 = i2 / 6;
        this.f5656e.setStrokeWidth(i3);
        int i5 = this.f5652a;
        canvas.rotate(i, i5 / 2, i5 / 2);
        int i6 = this.f5652a;
        canvas.translate(i6 / 2, i6 / 2);
        int i7 = 0;
        while (i7 < 12) {
            canvas.rotate(30.0f);
            i7++;
            this.f5656e.setAlpha((int) ((i7 * 255.0f) / 12.0f));
            int i8 = i3 / 2;
            canvas.translate(0.0f, ((-this.f5652a) / 2) + i8);
            canvas.drawLine(0.0f, 0.0f, 0.0f, i4, this.f5656e);
            canvas.translate(0.0f, (this.f5652a / 2) - i8);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.f5652a;
        setMeasuredDimension(i3, i3);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        m6977a(canvas, this.f5654c * 30);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m6979a();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m6975b();
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            m6979a();
        } else {
            m6975b();
        }
    }
}
