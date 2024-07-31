package com.twitter.sdk.android.tweetui.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* compiled from: AnimationUtils.java */
/* renamed from: com.twitter.sdk.android.tweetui.internal.a */
/* loaded from: classes2.dex */
class C2682a {
    /* renamed from: a */
    public static ViewPropertyAnimator m8889a(final View view, int i) {
        if (view.getVisibility() != 0) {
            return null;
        }
        view.clearAnimation();
        ViewPropertyAnimator animate = view.animate();
        animate.alpha(0.0f).setDuration(i).setListener(new AnimatorListenerAdapter() { // from class: com.twitter.sdk.android.tweetui.internal.a.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                view.setVisibility(4);
                view.setAlpha(1.0f);
            }
        });
        return animate;
    }

    /* renamed from: b */
    public static ViewPropertyAnimator m8890b(View view, int i) {
        if (view.getVisibility() != 0) {
            view.setAlpha(0.0f);
            view.setVisibility(0);
        }
        view.clearAnimation();
        ViewPropertyAnimator animate = view.animate();
        animate.alpha(1.0f).setDuration(i).setListener(null);
        return animate;
    }
}