package com.navatics.app.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.p011v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/* loaded from: classes.dex */
public class RotatingImageView extends AppCompatImageView {

    /* renamed from: a */
    private boolean f5505a;

    /* renamed from: b */
    private ObjectAnimator f5506b;

    /* renamed from: c */
    private int f5507c;

    /* renamed from: d */
    private int f5508d;

    public RotatingImageView(Context context) {
        this(context, null);
    }

    public RotatingImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public RotatingImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5505a = false;
        this.f5507c = 500;
        this.f5508d = -1;
    }

    /* renamed from: a */
    public void m7103a() {
        if (this.f5505a) {
            return;
        }
        ObjectAnimator objectAnimator = this.f5506b;
        if (objectAnimator == null || !objectAnimator.isRunning()) {
            this.f5506b = ObjectAnimator.ofFloat(this, "rotation", 0.0f, 360.0f);
            this.f5506b.setDuration(this.f5507c);
            this.f5506b.setRepeatCount(this.f5508d);
            this.f5506b.start();
            this.f5505a = true;
        }
    }

    /* renamed from: a */
    public RotatingImageView m7102a(int i) {
        this.f5507c = i;
        return this;
    }

    /* renamed from: b */
    public void m7101b() {
        ObjectAnimator objectAnimator;
        if (this.f5505a && (objectAnimator = this.f5506b) != null && objectAnimator.isRunning()) {
            this.f5506b.cancel();
        }
    }

    /* renamed from: c */
    public void m7100c() {
        m7101b();
        setVisibility(8);
    }
}
