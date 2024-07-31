package com.p030dd.morphingbutton;

import android.graphics.drawable.GradientDrawable;

/* compiled from: StrokeGradientDrawable.java */
/* renamed from: com.dd.morphingbutton.b, reason: use source file name */
/* loaded from: classes.dex */
public class StrokeGradientDrawable {

    /* renamed from: a */
    private int f1371a;

    /* renamed from: b */
    private int f1372b;

    /* renamed from: c */
    private GradientDrawable f1373c;

    /* renamed from: d */
    private float f1374d;

    /* renamed from: e */
    private int f1375e;

    public StrokeGradientDrawable(GradientDrawable gradientDrawable) {
        this.f1373c = gradientDrawable;
    }

    /* renamed from: a */
    public int m1440a() {
        return this.f1371a;
    }

    /* renamed from: a */
    public void m1442a(int i) {
        this.f1371a = i;
        this.f1373c.setStroke(i, m1443b());
    }

    /* renamed from: b */
    public int m1443b() {
        return this.f1372b;
    }

    /* renamed from: b */
    public void m1444b(int i) {
        this.f1372b = i;
        this.f1373c.setStroke(m1440a(), i);
    }

    /* renamed from: a */
    public void m1441a(float f) {
        this.f1374d = f;
        this.f1373c.setCornerRadius(f);
    }

    /* renamed from: c */
    public void m1446c(int i) {
        this.f1375e = i;
        this.f1373c.setColor(i);
    }

    /* renamed from: c */
    public GradientDrawable m1445c() {
        return this.f1373c;
    }
}