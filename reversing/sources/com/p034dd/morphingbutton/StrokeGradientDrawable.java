package com.p034dd.morphingbutton;

import android.graphics.drawable.GradientDrawable;

/* renamed from: com.dd.morphingbutton.b */
/* loaded from: classes.dex */
public class StrokeGradientDrawable {

    /* renamed from: a */
    private int f1366a;

    /* renamed from: b */
    private int f1367b;

    /* renamed from: c */
    private GradientDrawable f1368c;

    /* renamed from: d */
    private float f1369d;

    /* renamed from: e */
    private int f1370e;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.f1368c = gradientDrawable;
    }

    /* renamed from: a */
    public int m11503a() {
        return this.f1366a;
    }

    /* renamed from: a */
    public void m11501a(int i) {
        this.f1366a = i;
        this.f1368c.setStroke(i, m11500b());
    }

    /* renamed from: b */
    public int m11500b() {
        return this.f1367b;
    }

    /* renamed from: b */
    public void m11499b(int i) {
        this.f1367b = i;
        this.f1368c.setStroke(m11503a(), i);
    }

    /* renamed from: a */
    public void m11502a(float f) {
        this.f1369d = f;
        this.f1368c.setCornerRadius(f);
    }

    /* renamed from: c */
    public void m11497c(int i) {
        this.f1370e = i;
        this.f1368c.setColor(i);
    }

    /* renamed from: c */
    public GradientDrawable m11498c() {
        return this.f1368c;
    }
}
