package com.github.mikephil.charting.animation;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Build;
import com.github.mikephil.charting.animation.Easing;

/* loaded from: classes.dex */
public class ChartAnimator {
    private ValueAnimator.AnimatorUpdateListener mListener;
    protected float mPhaseY = 1.0f;
    protected float mPhaseX = 1.0f;

    public ChartAnimator() {
    }

    public ChartAnimator(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.mListener = animatorUpdateListener;
    }

    public void animateXY(int i, int i2, EasingFunction easingFunction, EasingFunction easingFunction2) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction2);
        ofFloat.setDuration(i2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat2.setInterpolator(easingFunction);
        ofFloat2.setDuration(i);
        if (i > i2) {
            ofFloat2.addUpdateListener(this.mListener);
        } else {
            ofFloat.addUpdateListener(this.mListener);
        }
        ofFloat2.start();
        ofFloat.start();
    }

    public void animateX(int i, EasingFunction easingFunction) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateY(int i, EasingFunction easingFunction) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(easingFunction);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateXY(int i, int i2, Easing.EasingOption easingOption, Easing.EasingOption easingOption2) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption2));
        ofFloat.setDuration(i2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat2.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        ofFloat2.setDuration(i);
        if (i > i2) {
            ofFloat2.addUpdateListener(this.mListener);
        } else {
            ofFloat.addUpdateListener(this.mListener);
        }
        ofFloat2.start();
        ofFloat.start();
    }

    public void animateX(int i, Easing.EasingOption easingOption) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateY(int i, Easing.EasingOption easingOption) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setInterpolator(Easing.getEasingFunctionFromOption(easingOption));
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateXY(int i, int i2) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setDuration(i2);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat2.setDuration(i);
        if (i > i2) {
            ofFloat2.addUpdateListener(this.mListener);
        } else {
            ofFloat.addUpdateListener(this.mListener);
        }
        ofFloat2.start();
        ofFloat.start();
    }

    public void animateX(int i) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseX", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public void animateY(int i) {
        if (Build.VERSION.SDK_INT < 11) {
            return;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "phaseY", 0.0f, 1.0f);
        ofFloat.setDuration(i);
        ofFloat.addUpdateListener(this.mListener);
        ofFloat.start();
    }

    public float getPhaseY() {
        return this.mPhaseY;
    }

    public void setPhaseY(float f) {
        this.mPhaseY = f;
    }

    public float getPhaseX() {
        return this.mPhaseX;
    }

    public void setPhaseX(float f) {
        this.mPhaseX = f;
    }
}
