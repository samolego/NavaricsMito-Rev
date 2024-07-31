package com.navatics.app.utils;

import android.animation.Animator;

/* compiled from: AnimatorStartListener.java */
/* renamed from: com.navatics.app.utils.b, reason: use source file name */
/* loaded from: classes.dex */
public abstract class AnimatorStartListener implements Animator.AnimatorListener {
    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator, boolean z) {
        onAnimationStart(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator, boolean z) {
        onAnimationEnd(animator);
    }
}