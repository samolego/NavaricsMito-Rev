package com.navatics.app.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.navatics.app.R;
import com.navatics.robot.utils.DpiUtils;

/* renamed from: com.navatics.app.widget.f */
/* loaded from: classes.dex */
public class ShadowDrawable extends Drawable {

    /* renamed from: a */
    public static final int f5691a = Color.parseColor("#1f000000");

    /* renamed from: b */
    private Paint f5692b;

    /* renamed from: c */
    private Paint f5693c;

    /* renamed from: d */
    private int f5694d;

    /* renamed from: e */
    private int f5695e;

    /* renamed from: f */
    private int f5696f;

    /* renamed from: g */
    private int f5697g;

    /* renamed from: h */
    private int f5698h;

    /* renamed from: i */
    private int[] f5699i;

    /* renamed from: j */
    private RectF f5700j;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private ShadowDrawable(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.f5695e = i;
        this.f5699i = iArr;
        this.f5696f = i2;
        this.f5694d = i4;
        this.f5697g = i5;
        this.f5698h = i6;
        this.f5692b = new Paint();
        this.f5692b.setColor(0);
        this.f5692b.setAntiAlias(true);
        this.f5692b.setShadowLayer(i4, i5, i6, i3);
        this.f5692b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.f5693c = new Paint();
        this.f5693c.setAntiAlias(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.f5694d;
        int i6 = this.f5697g;
        int i7 = this.f5698h;
        this.f5700j = new RectF((i + i5) - i6, (i2 + i5) - i7, (i3 - i5) - i6, (i4 - i5) - i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] iArr = this.f5699i;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f5693c.setColor(iArr[0]);
            } else {
                this.f5693c.setShader(new LinearGradient(this.f5700j.left, this.f5700j.height() / 2.0f, this.f5700j.right, this.f5700j.height() / 2.0f, this.f5699i, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f5695e == 0) {
            RectF rectF = this.f5700j;
            int i = this.f5696f;
            canvas.drawRoundRect(rectF, i, i, this.f5692b);
            RectF rectF2 = this.f5700j;
            int i2 = this.f5696f;
            canvas.drawRoundRect(rectF2, i2, i2, this.f5693c);
            return;
        }
        canvas.drawCircle(this.f5700j.centerX(), this.f5700j.centerY(), Math.min(this.f5700j.width(), this.f5700j.height()) / 2.0f, this.f5692b);
        canvas.drawCircle(this.f5700j.centerX(), this.f5700j.centerY(), Math.min(this.f5700j.width(), this.f5700j.height()) / 2.0f, this.f5693c);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5692b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f5692b.setColorFilter(colorFilter);
    }

    /* compiled from: ShadowDrawable.java */
    /* renamed from: com.navatics.app.widget.f$a */
    /* loaded from: classes.dex */
    public static class C1973a {

        /* renamed from: a */
        public static final int f5701a = Color.parseColor("#4d000000");

        /* renamed from: f */
        private int f5706f;

        /* renamed from: g */
        private int f5707g;

        /* renamed from: b */
        private int f5702b = 0;

        /* renamed from: c */
        private int f5703c = 10;

        /* renamed from: d */
        private int f5704d = f5701a;

        /* renamed from: e */
        private int f5705e = 16;

        /* renamed from: h */
        private int[] f5708h = new int[1];

        public C1973a() {
            this.f5706f = 0;
            this.f5707g = 0;
            this.f5706f = 0;
            this.f5707g = 0;
            this.f5708h[0] = 0;
        }

        /* renamed from: a */
        public C1973a m6953a(int i) {
            this.f5702b = i;
            return this;
        }

        /* renamed from: b */
        public C1973a m6951b(int i) {
            this.f5703c = i;
            return this;
        }

        /* renamed from: c */
        public C1973a m6950c(int i) {
            this.f5704d = i;
            return this;
        }

        /* renamed from: d */
        public C1973a m6949d(int i) {
            this.f5705e = i;
            return this;
        }

        /* renamed from: e */
        public C1973a m6948e(int i) {
            this.f5706f = i;
            return this;
        }

        /* renamed from: f */
        public C1973a m6947f(int i) {
            this.f5707g = i;
            return this;
        }

        /* renamed from: g */
        public C1973a m6946g(int i) {
            this.f5708h[0] = i;
            return this;
        }

        /* renamed from: a */
        public C1973a m6952a(int[] iArr) {
            this.f5708h = iArr;
            return this;
        }

        /* renamed from: a */
        public ShadowDrawable m6954a() {
            return new ShadowDrawable(this.f5702b, this.f5708h, this.f5703c, this.f5704d, this.f5705e, this.f5706f, this.f5707g);
        }
    }

    /* renamed from: a */
    public static ShadowDrawable m6955a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShadowDrawable);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(5, DpiUtils.m5887a(context, 8.0f));
        int color = obtainStyledAttributes.getColor(4, f5691a);
        int i = obtainStyledAttributes.getInt(7, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(6, DpiUtils.m5887a(context, 5.0f));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        int color2 = obtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.white));
        int color3 = obtainStyledAttributes.getColor(3, -1);
        obtainStyledAttributes.recycle();
        C1973a m6947f = new C1973a().m6953a(i).m6951b(dimensionPixelSize2).m6950c(color).m6949d(dimensionPixelSize).m6948e(dimensionPixelSize3).m6947f(dimensionPixelSize4);
        if (color3 != -1) {
            m6947f.m6952a(new int[]{color2, color3});
        } else {
            m6947f.m6946g(color2);
        }
        return m6947f.m6954a();
    }
}
