package com.navatics.app.widget.badge;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

/* renamed from: com.navatics.app.widget.badge.b */
/* loaded from: classes.dex */
public class BadgeAnimator extends ValueAnimator {

    /* renamed from: a */
    private C1965a[][] f5626a;

    /* renamed from: b */
    private WeakReference<BadgeView> f5627b;

    public BadgeAnimator(Bitmap bitmap, PointF pointF, BadgeView badgeView) {
        this.f5627b = new WeakReference<>(badgeView);
        setFloatValues(0.0f, 1.0f);
        setDuration(500L);
        this.f5626a = m6999a(bitmap, pointF);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.navatics.app.widget.badge.b.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BadgeView badgeView2 = (BadgeView) BadgeAnimator.this.f5627b.get();
                if (badgeView2 == null || !badgeView2.isShown()) {
                    BadgeAnimator.this.cancel();
                } else {
                    badgeView2.invalidate();
                }
            }
        });
        addListener(new AnimatorListenerAdapter() { // from class: com.navatics.app.widget.badge.b.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BadgeView badgeView2 = (BadgeView) BadgeAnimator.this.f5627b.get();
                if (badgeView2 != null) {
                    badgeView2.m7013b();
                }
            }
        });
    }

    /* renamed from: a */
    public void m6998a(Canvas canvas) {
        for (int i = 0; i < this.f5626a.length; i++) {
            int i2 = 0;
            while (true) {
                C1965a[][] c1965aArr = this.f5626a;
                if (i2 < c1965aArr[i].length) {
                    c1965aArr[i][i2].m6996a(Float.parseFloat(getAnimatedValue().toString()), canvas);
                    i2++;
                }
            }
        }
    }

    /* renamed from: a */
    private C1965a[][] m6999a(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = Math.min(width, height) / 6.0f;
        float width2 = pointF.x - (bitmap.getWidth() / 2.0f);
        float height2 = pointF.y - (bitmap.getHeight() / 2.0f);
        C1965a[][] c1965aArr = (C1965a[][]) Array.newInstance(C1965a.class, (int) (height / min), (int) (width / min));
        for (int i = 0; i < c1965aArr.length; i++) {
            for (int i2 = 0; i2 < c1965aArr[i].length; i2++) {
                C1965a c1965a = new C1965a();
                float f = i2 * min;
                float f2 = i * min;
                c1965a.f5634e = bitmap.getPixel((int) f, (int) f2);
                c1965a.f5631b = f + width2;
                c1965a.f5632c = f2 + height2;
                c1965a.f5633d = min;
                c1965a.f5635f = Math.max(width, height);
                c1965aArr[i][i2] = c1965a;
            }
        }
        bitmap.recycle();
        return c1965aArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BadgeAnimator.java */
    /* renamed from: com.navatics.app.widget.badge.b$a */
    /* loaded from: classes.dex */
    public class C1965a {

        /* renamed from: a */
        Random f5630a;

        /* renamed from: b */
        float f5631b;

        /* renamed from: c */
        float f5632c;

        /* renamed from: d */
        float f5633d;

        /* renamed from: e */
        int f5634e;

        /* renamed from: f */
        int f5635f;

        /* renamed from: g */
        Paint f5636g = new Paint();

        public C1965a() {
            this.f5636g.setAntiAlias(true);
            this.f5636g.setStyle(Paint.Style.FILL);
            this.f5630a = new Random();
        }

        /* renamed from: a */
        public void m6996a(float f, Canvas canvas) {
            this.f5636g.setColor(this.f5634e);
            this.f5631b += this.f5630a.nextInt(this.f5635f) * 0.1f * (this.f5630a.nextFloat() - 0.5f);
            this.f5632c += this.f5630a.nextInt(this.f5635f) * 0.1f * (this.f5630a.nextFloat() - 0.5f);
            float f2 = this.f5631b;
            float f3 = this.f5632c;
            float f4 = this.f5633d;
            canvas.drawCircle(f2, f3, f4 - (f * f4), this.f5636g);
        }
    }
}
