package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.util.Property;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* compiled from: SwipeToDismissTouchListener.java */
/* renamed from: com.twitter.sdk.android.tweetui.internal.f */
/* loaded from: classes2.dex */
public class ViewOnTouchListenerC2689f implements View.OnTouchListener {

    /* renamed from: a */
    private int f9122a;

    /* renamed from: b */
    private float f9123b;

    /* renamed from: c */
    private final float f9124c;

    /* renamed from: d */
    private final float f9125d;

    /* renamed from: e */
    private a f9126e;

    /* renamed from: f */
    private float f9127f;

    /* renamed from: g */
    private float f9128g;

    /* renamed from: h */
    private int f9129h;

    /* renamed from: i */
    private boolean f9130i;

    /* compiled from: SwipeToDismissTouchListener.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.f$a */
    /* loaded from: classes2.dex */
    public interface a {
        /* renamed from: a */
        void mo8706a();

        /* renamed from: a */
        void mo8707a(float f);
    }

    /* compiled from: SwipeToDismissTouchListener.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.f$b */
    /* loaded from: classes2.dex */
    public interface b {
        /* renamed from: f */
        boolean mo8814f();
    }

    /* renamed from: a */
    public static ViewOnTouchListenerC2689f m8912a(View view, a aVar) {
        return new ViewOnTouchListenerC2689f(aVar, ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), view.getContext().getResources().getDisplayMetrics().heightPixels * 0.5f);
    }

    ViewOnTouchListenerC2689f(a aVar, int i, float f) {
        this(aVar, i, f, 0.2f * f);
    }

    ViewOnTouchListenerC2689f(a aVar, int i, float f, float f2) {
        m8914a(aVar);
        this.f9122a = i;
        this.f9124c = f;
        this.f9125d = f2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return ((!(view instanceof b) || ((b) view).mo8814f() || m8915a()) ? m8920a(view, motionEvent) : false) || view.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: a */
    boolean m8920a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 5) {
            switch (actionMasked) {
                case 0:
                    this.f9127f = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.f9128g = rawY;
                    this.f9123b = rawY;
                    this.f9130i = false;
                    this.f9129h = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                    break;
                case 1:
                case 3:
                    boolean m8919a = (m8918a(motionEvent) && this.f9130i) ? m8919a(view) : false;
                    this.f9130i = false;
                    return m8919a;
                case 2:
                    float rawX = motionEvent.getRawX();
                    float rawY2 = motionEvent.getRawY();
                    float f = rawY2 - this.f9123b;
                    float f2 = rawX - this.f9127f;
                    float f3 = rawY2 - this.f9128g;
                    this.f9127f = rawX;
                    this.f9128g = rawY2;
                    if (m8918a(motionEvent) && (this.f9130i || (m8916a(f) && m8917a(f2, f3)))) {
                        this.f9130i = true;
                        m8913a(view, f3);
                        break;
                    }
                    break;
            }
        } else {
            m8922b(view);
            this.f9130i = false;
            this.f9129h = -1;
        }
        return false;
    }

    /* renamed from: a */
    boolean m8916a(float f) {
        return Math.abs(f) > ((float) this.f9122a);
    }

    /* renamed from: a */
    boolean m8917a(float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }

    /* renamed from: a */
    boolean m8915a() {
        return this.f9130i;
    }

    /* renamed from: a */
    boolean m8918a(MotionEvent motionEvent) {
        return this.f9129h >= 0 && motionEvent.getPointerCount() == 1;
    }

    /* renamed from: a */
    boolean m8919a(View view) {
        float translationY = view.getTranslationY();
        float f = this.f9125d;
        if (translationY > f || translationY < (-f)) {
            a aVar = this.f9126e;
            if (aVar == null) {
                return true;
            }
            aVar.mo8706a();
            return true;
        }
        m8922b(view);
        return false;
    }

    /* renamed from: b */
    void m8922b(View view) {
        if (view.getTranslationY() != 0.0f) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, 0.0f).setDuration(100L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.f.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (ViewOnTouchListenerC2689f.this.f9126e != null) {
                        ViewOnTouchListenerC2689f.this.f9126e.mo8707a(floatValue);
                    }
                }
            });
            duration.start();
        }
    }

    /* renamed from: a */
    void m8913a(View view, float f) {
        float translationY = view.getTranslationY();
        float m8923c = m8923c(translationY + ((float) (f * m8921b(translationY))));
        view.setTranslationY(m8923c);
        a aVar = this.f9126e;
        if (aVar != null) {
            aVar.mo8707a(m8923c);
        }
    }

    /* renamed from: b */
    double m8921b(float f) {
        return 1.0d - (Math.pow(Math.abs(f), 2.0d) / Math.pow(this.f9125d * 2.0f, 2.0d));
    }

    /* renamed from: c */
    float m8923c(float f) {
        float f2 = this.f9124c;
        return f < (-f2) ? -f2 : f > f2 ? f2 : f;
    }

    /* renamed from: a */
    public void m8914a(a aVar) {
        this.f9126e = aVar;
    }
}