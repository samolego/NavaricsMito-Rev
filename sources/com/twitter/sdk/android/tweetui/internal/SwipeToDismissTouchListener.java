package com.twitter.sdk.android.tweetui.internal;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: com.twitter.sdk.android.tweetui.internal.f */
/* loaded from: classes2.dex */
public class SwipeToDismissTouchListener implements View.OnTouchListener {

    /* renamed from: a */
    private int f9082a;

    /* renamed from: b */
    private float f9083b;

    /* renamed from: c */
    private final float f9084c;

    /* renamed from: d */
    private final float f9085d;

    /* renamed from: e */
    private InterfaceC2759a f9086e;

    /* renamed from: f */
    private float f9087f;

    /* renamed from: g */
    private float f9088g;

    /* renamed from: h */
    private int f9089h;

    /* renamed from: i */
    private boolean f9090i;

    /* compiled from: SwipeToDismissTouchListener.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.f$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2759a {
        /* renamed from: a */
        void mo3932a();

        /* renamed from: a */
        void mo3931a(float f);
    }

    /* compiled from: SwipeToDismissTouchListener.java */
    /* renamed from: com.twitter.sdk.android.tweetui.internal.f$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC2760b {
        /* renamed from: f */
        boolean mo3930f();
    }

    /* renamed from: a */
    public static SwipeToDismissTouchListener m3938a(View view, InterfaceC2759a interfaceC2759a) {
        return new SwipeToDismissTouchListener(interfaceC2759a, ViewConfiguration.get(view.getContext()).getScaledTouchSlop(), view.getContext().getResources().getDisplayMetrics().heightPixels * 0.5f);
    }

    SwipeToDismissTouchListener(InterfaceC2759a interfaceC2759a, int i, float f) {
        this(interfaceC2759a, i, f, 0.2f * f);
    }

    SwipeToDismissTouchListener(InterfaceC2759a interfaceC2759a, int i, float f, float f2) {
        m3937a(interfaceC2759a);
        this.f9082a = i;
        this.f9084c = f;
        this.f9085d = f2;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return ((!(view instanceof InterfaceC2760b) || ((InterfaceC2760b) view).mo3930f() || m3945a()) ? m3939a(view, motionEvent) : false) || view.onTouchEvent(motionEvent);
    }

    /* renamed from: a */
    boolean m3939a(View view, MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 5) {
            switch (actionMasked) {
                case 0:
                    this.f9087f = motionEvent.getRawX();
                    float rawY = motionEvent.getRawY();
                    this.f9088g = rawY;
                    this.f9083b = rawY;
                    this.f9090i = false;
                    this.f9089h = motionEvent.getPointerId(motionEvent.getPointerCount() - 1);
                    break;
                case 1:
                case 3:
                    boolean m3941a = (m3942a(motionEvent) && this.f9090i) ? m3941a(view) : false;
                    this.f9090i = false;
                    return m3941a;
                case 2:
                    float rawX = motionEvent.getRawX();
                    float rawY2 = motionEvent.getRawY();
                    float f = rawY2 - this.f9083b;
                    float f2 = rawX - this.f9087f;
                    float f3 = rawY2 - this.f9088g;
                    this.f9087f = rawX;
                    this.f9088g = rawY2;
                    if (m3942a(motionEvent) && (this.f9090i || (m3944a(f) && m3943a(f2, f3)))) {
                        this.f9090i = true;
                        m3940a(view, f3);
                        break;
                    }
                    break;
            }
        } else {
            m3934b(view);
            this.f9090i = false;
            this.f9089h = -1;
        }
        return false;
    }

    /* renamed from: a */
    boolean m3944a(float f) {
        return Math.abs(f) > ((float) this.f9082a);
    }

    /* renamed from: a */
    boolean m3943a(float f, float f2) {
        return Math.abs(f2) > Math.abs(f);
    }

    /* renamed from: a */
    boolean m3945a() {
        return this.f9090i;
    }

    /* renamed from: a */
    boolean m3942a(MotionEvent motionEvent) {
        return this.f9089h >= 0 && motionEvent.getPointerCount() == 1;
    }

    /* renamed from: a */
    boolean m3941a(View view) {
        float translationY = view.getTranslationY();
        float f = this.f9085d;
        if (translationY > f || translationY < (-f)) {
            InterfaceC2759a interfaceC2759a = this.f9086e;
            if (interfaceC2759a != null) {
                interfaceC2759a.mo3932a();
                return true;
            }
            return true;
        }
        m3934b(view);
        return false;
    }

    /* renamed from: b */
    void m3934b(View view) {
        if (view.getTranslationY() != 0.0f) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, 0.0f).setDuration(100L);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.twitter.sdk.android.tweetui.internal.f.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (SwipeToDismissTouchListener.this.f9086e != null) {
                        SwipeToDismissTouchListener.this.f9086e.mo3931a(floatValue);
                    }
                }
            });
            duration.start();
        }
    }

    /* renamed from: a */
    void m3940a(View view, float f) {
        float translationY = view.getTranslationY();
        float m3933c = m3933c(translationY + ((float) (f * m3935b(translationY))));
        view.setTranslationY(m3933c);
        InterfaceC2759a interfaceC2759a = this.f9086e;
        if (interfaceC2759a != null) {
            interfaceC2759a.mo3931a(m3933c);
        }
    }

    /* renamed from: b */
    double m3935b(float f) {
        return 1.0d - (Math.pow(Math.abs(f), 2.0d) / Math.pow(this.f9085d * 2.0f, 2.0d));
    }

    /* renamed from: c */
    float m3933c(float f) {
        float f2 = this.f9084c;
        return f < (-f2) ? -f2 : f > f2 ? f2 : f;
    }

    /* renamed from: a */
    public void m3937a(InterfaceC2759a interfaceC2759a) {
        this.f9086e = interfaceC2759a;
    }
}
