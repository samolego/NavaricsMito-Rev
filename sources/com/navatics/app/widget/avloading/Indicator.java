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

/* renamed from: com.navatics.app.widget.avloading.b */
/* loaded from: classes.dex */
public abstract class Indicator extends Drawable implements Animatable {

    /* renamed from: e */
    private static final Rect f5571e = new Rect();

    /* renamed from: c */
    private ArrayList<ValueAnimator> f5574c;

    /* renamed from: f */
    private boolean f5576f;

    /* renamed from: b */
    private HashMap<ValueAnimator, ValueAnimator.AnimatorUpdateListener> f5573b = new HashMap<>();

    /* renamed from: d */
    private int f5575d = 255;

    /* renamed from: a */
    protected Rect f5572a = f5571e;

    /* renamed from: g */
    private Paint f5577g = new Paint();

    /* renamed from: a */
    public abstract ArrayList<ValueAnimator> mo7043a();

    /* renamed from: a */
    public abstract void mo7039a(Canvas canvas, Paint paint);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public Indicator() {
        this.f5577g.setColor(-1);
        this.f5577g.setStyle(Paint.Style.FILL);
        this.f5577g.setAntiAlias(true);
    }

    /* renamed from: a */
    public void m7042a(int i) {
        this.f5577g.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5575d = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f5575d;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        mo7039a(canvas, this.f5577g);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        m7032g();
        if (this.f5574c == null || m7031h()) {
            return;
        }
        m7034e();
        invalidateSelf();
    }

    /* renamed from: e */
    private void m7034e() {
        for (int i = 0; i < this.f5574c.size(); i++) {
            ValueAnimator valueAnimator = this.f5574c.get(i);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.f5573b.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
    }

    /* renamed from: f */
    private void m7033f() {
        ArrayList<ValueAnimator> arrayList = this.f5574c;
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
    private void m7032g() {
        if (this.f5576f) {
            return;
        }
        this.f5574c = mo7043a();
        this.f5576f = true;
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m7033f();
    }

    /* renamed from: h */
    private boolean m7031h() {
        Iterator<ValueAnimator> it = this.f5574c.iterator();
        if (it.hasNext()) {
            return it.next().isStarted();
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Iterator<ValueAnimator> it = this.f5574c.iterator();
        if (it.hasNext()) {
            return it.next().isRunning();
        }
        return false;
    }

    /* renamed from: a */
    public void m7040a(ValueAnimator valueAnimator, ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.f5573b.put(valueAnimator, animatorUpdateListener);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m7038a(rect);
    }

    /* renamed from: a */
    public void m7038a(Rect rect) {
        m7041a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* renamed from: a */
    public void m7041a(int i, int i2, int i3, int i4) {
        this.f5572a = new Rect(i, i2, i3, i4);
    }

    /* renamed from: b */
    public void m7037b() {
        invalidateSelf();
    }

    /* renamed from: c */
    public int m7036c() {
        return this.f5572a.width();
    }

    /* renamed from: d */
    public int m7035d() {
        return this.f5572a.height();
    }
}
