package com.p034dd.morphingbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

/* renamed from: com.dd.morphingbutton.a */
/* loaded from: classes.dex */
public class MorphingAnimation {

    /* renamed from: a */
    private C0807b f1347a;

    /* compiled from: MorphingAnimation.java */
    /* renamed from: com.dd.morphingbutton.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0806a {
        /* renamed from: a */
        void mo11528a();
    }

    /* compiled from: MorphingAnimation.java */
    /* renamed from: com.dd.morphingbutton.a$b */
    /* loaded from: classes.dex */
    public static class C0807b {

        /* renamed from: a */
        private float f1351a;

        /* renamed from: b */
        private float f1352b;

        /* renamed from: c */
        private int f1353c;

        /* renamed from: d */
        private int f1354d;

        /* renamed from: e */
        private int f1355e;

        /* renamed from: f */
        private int f1356f;

        /* renamed from: g */
        private int f1357g;

        /* renamed from: h */
        private int f1358h;

        /* renamed from: i */
        private int f1359i;

        /* renamed from: j */
        private int f1360j;

        /* renamed from: k */
        private int f1361k;

        /* renamed from: l */
        private int f1362l;

        /* renamed from: m */
        private int f1363m;

        /* renamed from: n */
        private MorphingButton f1364n;

        /* renamed from: o */
        private InterfaceC0806a f1365o;

        private C0807b(@NonNull MorphingButton morphingButton) {
            this.f1364n = morphingButton;
        }

        /* renamed from: a */
        public static C0807b m11525a(@NonNull MorphingButton morphingButton) {
            return new C0807b(morphingButton);
        }

        /* renamed from: a */
        public C0807b m11527a(int i) {
            this.f1359i = i;
            return this;
        }

        /* renamed from: a */
        public C0807b m11524a(@NonNull InterfaceC0806a interfaceC0806a) {
            this.f1365o = interfaceC0806a;
            return this;
        }

        /* renamed from: a */
        public C0807b m11526a(int i, int i2) {
            this.f1357g = i;
            this.f1358h = i2;
            return this;
        }

        /* renamed from: b */
        public C0807b m11522b(int i, int i2) {
            this.f1351a = i;
            this.f1352b = i2;
            return this;
        }

        /* renamed from: c */
        public C0807b m11520c(int i, int i2) {
            this.f1353c = i;
            this.f1354d = i2;
            return this;
        }

        /* renamed from: d */
        public C0807b m11518d(int i, int i2) {
            this.f1355e = i;
            this.f1356f = i2;
            return this;
        }

        /* renamed from: e */
        public C0807b m11516e(int i, int i2) {
            this.f1360j = i;
            this.f1361k = i2;
            return this;
        }

        /* renamed from: f */
        public C0807b m11514f(int i, int i2) {
            this.f1362l = i;
            this.f1363m = i2;
            return this;
        }
    }

    public MorphingAnimation(@NonNull C0807b c0807b) {
        this.f1347a = c0807b;
    }

    /* renamed from: a */
    public void m11530a() {
        StrokeGradientDrawable drawableNormal = this.f1347a.f1364n.getDrawableNormal();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(drawableNormal, "cornerRadius", this.f1347a.f1351a, this.f1347a.f1352b);
        ObjectAnimator ofInt = ObjectAnimator.ofInt(drawableNormal, "strokeWidth", this.f1347a.f1360j, this.f1347a.f1361k);
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(drawableNormal, "strokeColor", this.f1347a.f1362l, this.f1347a.f1363m);
        ofInt2.setEvaluator(new ArgbEvaluator());
        ObjectAnimator ofInt3 = ObjectAnimator.ofInt(drawableNormal, "color", this.f1347a.f1357g, this.f1347a.f1358h);
        ofInt3.setEvaluator(new ArgbEvaluator());
        ValueAnimator ofInt4 = ValueAnimator.ofInt(this.f1347a.f1353c, this.f1347a.f1354d);
        ofInt4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dd.morphingbutton.a.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = MorphingAnimation.this.f1347a.f1364n.getLayoutParams();
                layoutParams.height = intValue;
                MorphingAnimation.this.f1347a.f1364n.setLayoutParams(layoutParams);
            }
        });
        ValueAnimator ofInt5 = ValueAnimator.ofInt(this.f1347a.f1355e, this.f1347a.f1356f);
        ofInt5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.dd.morphingbutton.a.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                ViewGroup.LayoutParams layoutParams = MorphingAnimation.this.f1347a.f1364n.getLayoutParams();
                layoutParams.width = intValue;
                MorphingAnimation.this.f1347a.f1364n.setLayoutParams(layoutParams);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(this.f1347a.f1359i);
        animatorSet.playTogether(ofInt, ofInt2, ofFloat, ofInt3, ofInt4, ofInt5);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: com.dd.morphingbutton.a.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (MorphingAnimation.this.f1347a.f1365o != null) {
                    MorphingAnimation.this.f1347a.f1365o.mo11528a();
                }
            }
        });
        animatorSet.start();
    }
}
