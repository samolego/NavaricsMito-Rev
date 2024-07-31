package com.p034dd.morphingbutton.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.p008v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.p034dd.morphingbutton.MorphingButton;
import com.p034dd.morphingbutton.R;

/* renamed from: com.dd.morphingbutton.impl.IndeterminateProgressButton */
/* loaded from: classes.dex */
public class IndeterminateProgressButton extends MorphingButton {

    /* renamed from: b */
    private int f1371b;

    /* renamed from: c */
    private int f1372c;

    /* renamed from: d */
    private int f1373d;

    /* renamed from: e */
    private int f1374e;

    /* renamed from: f */
    private int f1375f;

    /* renamed from: g */
    private C0808a f1376g;

    /* renamed from: h */
    private boolean f1377h;

    public IndeterminateProgressButton(Context context) {
        super(context);
        m11495a(context);
    }

    public IndeterminateProgressButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11495a(context);
    }

    public IndeterminateProgressButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11495a(context);
    }

    /* renamed from: a */
    private void m11495a(Context context) {
        Resources resources = context.getResources();
        this.f1371b = resources.getColor(R.color.mb_gray);
        this.f1372c = resources.getColor(R.color.mb_blue);
        this.f1373d = resources.getColor(R.color.mb_gray);
        this.f1374e = resources.getColor(R.color.mb_blue);
        if (Build.VERSION.SDK_INT <= 18) {
            setLayerType(1, null);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        if (this.f1317a || !this.f1377h) {
            return;
        }
        if (this.f1376g == null) {
            this.f1376g = new C0808a(this);
            m11496a();
            this.f1376g.m11493a(this.f1371b, this.f1372c, this.f1373d, this.f1374e);
            this.f1376g.m11494a();
        }
        this.f1376g.m11491a(canvas);
    }

    @Override // com.p034dd.morphingbutton.MorphingButton
    /* renamed from: a */
    public void mo11488a(@NonNull MorphingButton.C0799b c0799b) {
        this.f1377h = false;
        super.mo11488a(c0799b);
    }

    /* renamed from: a */
    private void m11496a() {
        this.f1376g.m11492a(0, (int) (getMeasuredHeight() - getHeight()), getMeasuredWidth(), getMeasuredHeight(), this.f1375f);
    }

    /* renamed from: com.dd.morphingbutton.impl.IndeterminateProgressButton$a */
    /* loaded from: classes.dex */
    public static class C0808a {

        /* renamed from: a */
        private static final Interpolator f1378a = new AccelerateDecelerateInterpolator();

        /* renamed from: d */
        private float f1381d;

        /* renamed from: e */
        private long f1382e;

        /* renamed from: f */
        private long f1383f;

        /* renamed from: g */
        private boolean f1384g;

        /* renamed from: l */
        private int f1389l;

        /* renamed from: m */
        private View f1390m;

        /* renamed from: b */
        private final Paint f1379b = new Paint();

        /* renamed from: c */
        private final RectF f1380c = new RectF();

        /* renamed from: n */
        private RectF f1391n = new RectF();

        /* renamed from: h */
        private int f1385h = -1291845632;

        /* renamed from: i */
        private int f1386i = Integer.MIN_VALUE;

        /* renamed from: j */
        private int f1387j = 1291845632;

        /* renamed from: k */
        private int f1388k = 436207616;

        public C0808a(View view) {
            this.f1390m = view;
        }

        /* renamed from: a */
        void m11493a(int i, int i2, int i3, int i4) {
            this.f1385h = i;
            this.f1386i = i2;
            this.f1387j = i3;
            this.f1388k = i4;
        }

        /* renamed from: a */
        void m11494a() {
            if (this.f1384g) {
                return;
            }
            this.f1381d = 0.0f;
            this.f1382e = AnimationUtils.currentAnimationTimeMillis();
            this.f1384g = true;
            this.f1390m.postInvalidate();
        }

        /* renamed from: a */
        void m11491a(Canvas canvas) {
            long j;
            boolean z;
            Path path = new Path();
            RectF rectF = this.f1391n;
            int i = this.f1389l;
            path.addRoundRect(rectF, i, i, Path.Direction.CW);
            int height = (int) this.f1391n.height();
            int width = ((int) this.f1391n.width()) / 2;
            int i2 = height / 2;
            int save = canvas.save();
            canvas.clipPath(path);
            if (this.f1384g || this.f1383f > 0) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                long j2 = this.f1382e;
                long j3 = (currentAnimationTimeMillis - j2) / 2000;
                float f = ((float) ((currentAnimationTimeMillis - j2) % 2000)) / 20.0f;
                if (this.f1384g) {
                    j = j3;
                    z = false;
                } else {
                    long j4 = this.f1383f;
                    if (currentAnimationTimeMillis - j4 >= 1000) {
                        this.f1383f = 0L;
                        return;
                    }
                    j = j3;
                    float f2 = width;
                    float interpolation = f1378a.getInterpolation((((float) ((currentAnimationTimeMillis - j4) % 1000)) / 10.0f) / 100.0f) * f2;
                    this.f1380c.set(f2 - interpolation, 0.0f, f2 + interpolation, height);
                    canvas.saveLayerAlpha(this.f1380c, 0, 0);
                    z = true;
                }
                if (j == 0) {
                    canvas.drawColor(this.f1385h);
                } else if (f >= 0.0f && f < 25.0f) {
                    canvas.drawColor(this.f1388k);
                } else if (f >= 25.0f && f < 50.0f) {
                    canvas.drawColor(this.f1385h);
                } else if (f >= 50.0f && f < 75.0f) {
                    canvas.drawColor(this.f1386i);
                } else {
                    canvas.drawColor(this.f1387j);
                }
                int i3 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
                if (i3 >= 0 && f <= 25.0f) {
                    m11490a(canvas, width, i2, this.f1385h, ((f + 25.0f) * 2.0f) / 100.0f);
                }
                if (i3 >= 0 && f <= 50.0f) {
                    m11490a(canvas, width, i2, this.f1386i, (f * 2.0f) / 100.0f);
                }
                if (f >= 25.0f && f <= 75.0f) {
                    m11490a(canvas, width, i2, this.f1387j, ((f - 25.0f) * 2.0f) / 100.0f);
                }
                if (f >= 50.0f && f <= 100.0f) {
                    m11490a(canvas, width, i2, this.f1388k, ((f - 50.0f) * 2.0f) / 100.0f);
                }
                if (f >= 75.0f && f <= 100.0f) {
                    m11490a(canvas, width, i2, this.f1385h, ((f - 75.0f) * 2.0f) / 100.0f);
                }
                if (this.f1381d > 0.0f && z) {
                    canvas.restoreToCount(save);
                    int save2 = canvas.save();
                    canvas.clipPath(path);
                    m11489a(canvas, width, i2);
                    save = save2;
                }
                ViewCompat.postInvalidateOnAnimation(this.f1390m);
            } else {
                float f3 = this.f1381d;
                if (f3 > 0.0f && f3 <= 1.0d) {
                    m11489a(canvas, width, i2);
                }
            }
            canvas.restoreToCount(save);
        }

        /* renamed from: a */
        private void m11489a(Canvas canvas, int i, int i2) {
            this.f1379b.setColor(this.f1385h);
            float f = i;
            canvas.drawCircle(f, i2, this.f1381d * f, this.f1379b);
        }

        /* renamed from: a */
        private void m11490a(Canvas canvas, float f, float f2, int i, float f3) {
            this.f1379b.setColor(i);
            canvas.save();
            canvas.translate(f, f2);
            float interpolation = f1378a.getInterpolation(f3);
            canvas.scale(interpolation, interpolation);
            canvas.drawCircle(0.0f, 0.0f, f, this.f1379b);
            canvas.restore();
        }

        /* renamed from: a */
        void m11492a(int i, int i2, int i3, int i4, int i5) {
            RectF rectF = this.f1391n;
            rectF.left = i;
            rectF.top = i2;
            rectF.right = i3;
            rectF.bottom = i4;
            this.f1389l = i5;
        }
    }
}
