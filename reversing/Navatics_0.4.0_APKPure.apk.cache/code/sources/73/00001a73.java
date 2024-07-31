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

/* compiled from: ShadowDrawable.java */
/* renamed from: com.navatics.app.widget.f, reason: use source file name */
/* loaded from: classes.dex */
public class ShadowDrawable extends Drawable {

    /* renamed from: a */
    public static final int f5713a = Color.parseColor("#1f000000");

    /* renamed from: b */
    private Paint f5714b;

    /* renamed from: c */
    private Paint f5715c;

    /* renamed from: d */
    private int f5716d;

    /* renamed from: e */
    private int f5717e;

    /* renamed from: f */
    private int f5718f;

    /* renamed from: g */
    private int f5719g;

    /* renamed from: h */
    private int f5720h;

    /* renamed from: i */
    private int[] f5721i;

    /* renamed from: j */
    private RectF f5722j;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    private ShadowDrawable(int i, int[] iArr, int i2, int i3, int i4, int i5, int i6) {
        this.f5717e = i;
        this.f5721i = iArr;
        this.f5718f = i2;
        this.f5716d = i4;
        this.f5719g = i5;
        this.f5720h = i6;
        this.f5714b = new Paint();
        this.f5714b.setColor(0);
        this.f5714b.setAntiAlias(true);
        this.f5714b.setShadowLayer(i4, i5, i6, i3);
        this.f5714b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.f5715c = new Paint();
        this.f5715c.setAntiAlias(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        int i5 = this.f5716d;
        int i6 = this.f5719g;
        int i7 = this.f5720h;
        this.f5722j = new RectF((i + i5) - i6, (i2 + i5) - i7, (i3 - i5) - i6, (i4 - i5) - i7);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        int[] iArr = this.f5721i;
        if (iArr != null) {
            if (iArr.length == 1) {
                this.f5715c.setColor(iArr[0]);
            } else {
                this.f5715c.setShader(new LinearGradient(this.f5722j.left, this.f5722j.height() / 2.0f, this.f5722j.right, this.f5722j.height() / 2.0f, this.f5721i, (float[]) null, Shader.TileMode.CLAMP));
            }
        }
        if (this.f5717e == 0) {
            RectF rectF = this.f5722j;
            int i = this.f5718f;
            canvas.drawRoundRect(rectF, i, i, this.f5714b);
            RectF rectF2 = this.f5722j;
            int i2 = this.f5718f;
            canvas.drawRoundRect(rectF2, i2, i2, this.f5715c);
            return;
        }
        canvas.drawCircle(this.f5722j.centerX(), this.f5722j.centerY(), Math.min(this.f5722j.width(), this.f5722j.height()) / 2.0f, this.f5714b);
        canvas.drawCircle(this.f5722j.centerX(), this.f5722j.centerY(), Math.min(this.f5722j.width(), this.f5722j.height()) / 2.0f, this.f5715c);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5714b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.f5714b.setColorFilter(colorFilter);
    }

    /* compiled from: ShadowDrawable.java */
    /* renamed from: com.navatics.app.widget.f$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public static final int f5723a = Color.parseColor("#4d000000");

        /* renamed from: f */
        private int f5728f;

        /* renamed from: g */
        private int f5729g;

        /* renamed from: b */
        private int f5724b = 0;

        /* renamed from: c */
        private int f5725c = 10;

        /* renamed from: d */
        private int f5726d = f5723a;

        /* renamed from: e */
        private int f5727e = 16;

        /* renamed from: h */
        private int[] f5730h = new int[1];

        public a() {
            this.f5728f = 0;
            this.f5729g = 0;
            this.f5728f = 0;
            this.f5729g = 0;
            this.f5730h[0] = 0;
        }

        /* renamed from: a */
        public a m5911a(int i) {
            this.f5724b = i;
            return this;
        }

        /* renamed from: b */
        public a m5914b(int i) {
            this.f5725c = i;
            return this;
        }

        /* renamed from: c */
        public a m5915c(int i) {
            this.f5726d = i;
            return this;
        }

        /* renamed from: d */
        public a m5916d(int i) {
            this.f5727e = i;
            return this;
        }

        /* renamed from: e */
        public a m5917e(int i) {
            this.f5728f = i;
            return this;
        }

        /* renamed from: f */
        public a m5918f(int i) {
            this.f5729g = i;
            return this;
        }

        /* renamed from: g */
        public a m5919g(int i) {
            this.f5730h[0] = i;
            return this;
        }

        /* renamed from: a */
        public a m5912a(int[] iArr) {
            this.f5730h = iArr;
            return this;
        }

        /* renamed from: a */
        public ShadowDrawable m5913a() {
            return new ShadowDrawable(this.f5724b, this.f5730h, this.f5725c, this.f5726d, this.f5727e, this.f5728f, this.f5729g);
        }
    }

    /* renamed from: a */
    public static ShadowDrawable m5910a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShadowDrawable);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(5, DpiUtils.m6962a(context, 8.0f));
        int color = obtainStyledAttributes.getColor(4, f5713a);
        int i = obtainStyledAttributes.getInt(7, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(6, DpiUtils.m6962a(context, 5.0f));
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        int color2 = obtainStyledAttributes.getColor(0, context.getResources().getColor(R.color.white));
        int color3 = obtainStyledAttributes.getColor(3, -1);
        obtainStyledAttributes.recycle();
        a m5918f = new a().m5911a(i).m5914b(dimensionPixelSize2).m5915c(color).m5916d(dimensionPixelSize).m5917e(dimensionPixelSize3).m5918f(dimensionPixelSize4);
        if (color3 != -1) {
            m5918f.m5912a(new int[]{color2, color3});
        } else {
            m5918f.m5919g(color2);
        }
        return m5918f.m5913a();
    }
}