package com.navatics.app.widget.avloading;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: Indicator.java */
/* renamed from: com.navatics.app.widget.avloading.b */
/* loaded from: classes.dex */
public abstract class Indicator extends Drawable implements Animatable {

    /* renamed from: e */
    private static final Rect f5593e = new Rect();

    /* renamed from: c */
    private ArrayList<ValueAnimator> f5596c;

    /* renamed from: f */
    private boolean f5598f;

    /* renamed from: b */
    private HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f5595b = new HashMap<>();

    /* renamed from: d */
    private int f5597d = 255;

    /* renamed from: a */
    protected Rect f5594a = f5593e;

    /* renamed from: g */
    private Paint paint = new Paint();

    /* renamed from: a */
    public abstract ArrayList<ValueAnimator> mo5822a();

    /* renamed from: a */
    public abstract void mo5823a(Canvas canvas, Paint paint);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public Indicator() {
        this.paint.setColor(-1);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
    }

    /* renamed from: a */
    public void setColor(int color) {
        this.paint.setColor(color);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5597d = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5597d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        mo5823a(canvas, this.paint);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        m5826g();
        if (this.f5596c == null || m5827h()) {
            return;
        }
        m5824e();
        invalidateSelf();
    }

    /* renamed from: e */
    private void m5824e() {
        for (int i = 0; i < this.f5596c.size(); i++) {
            ValueAnimator valueAnimator = this.f5596c.get(i);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f5595b.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
    }

    /* renamed from: f */
    private void m5825f() {
        ArrayList<ValueAnimator> arrayList = this.f5596c;
        if (arrayList != null) {
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null && next.isStarted()) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
    }

    /* renamed from: g */
    private void m5826g() {
        if (this.f5598f) {
            return;
        }
        this.f5596c = mo5822a();
        this.f5598f = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m5825f();
    }

    /* renamed from: h */
    private boolean m5827h() {
        Iterator<ValueAnimator> it = this.f5596c.iterator();
        if (it.hasNext()) {
            return it.next().isStarted();
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Iterator<ValueAnimator> it = this.f5596c.iterator();
        if (it.hasNext()) {
            return it.next().isRunning();
        }
        return false;
    }

    /* renamed from: a */
    public void m5830a(ValueAnimator valueAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f5595b.put(valueAnimator, animatorUpdateListener);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m5831a(rect);
    }

    /* renamed from: a */
    public void m5831a(Rect rect) {
        m5829a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    public void m5829a(int i, int i2, int i3, int i4) {
        this.f5594a = new Rect(i, i2, i3, i4);
    }

    /* renamed from: b */
    public void m5832b() {
        invalidateSelf();
    }

    /* renamed from: c */
    public int m5833c() {
        return this.f5594a.width();
    }

    /* renamed from: d */
    public int m5834d() {
        return this.f5594a.height();
    }
}