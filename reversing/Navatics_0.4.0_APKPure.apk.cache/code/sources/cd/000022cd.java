package com.yanzhenjie.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: Drawer.java */
/* renamed from: com.yanzhenjie.recyclerview.widget.b */
/* loaded from: classes2.dex */
class C2741b {

    /* renamed from: a */
    private final Drawable f9326a;

    /* renamed from: b */
    private final int f9327b;

    /* renamed from: c */
    private final int f9328c;

    public C2741b(Drawable drawable, int i, int i2) {
        this.f9326a = drawable;
        this.f9327b = i;
        this.f9328c = i2;
    }

    /* renamed from: a */
    public void m9104a(View view, Canvas canvas) {
        int left = view.getLeft() - this.f9327b;
        this.f9326a.setBounds(left, view.getTop() - this.f9328c, this.f9327b + left, view.getBottom() + this.f9328c);
        this.f9326a.draw(canvas);
    }

    /* renamed from: b */
    public void m9105b(View view, Canvas canvas) {
        int left = view.getLeft() - this.f9327b;
        int top = view.getTop() - this.f9328c;
        this.f9326a.setBounds(left, top, view.getRight() + this.f9327b, this.f9328c + top);
        this.f9326a.draw(canvas);
    }

    /* renamed from: c */
    public void m9106c(View view, Canvas canvas) {
        int right = view.getRight();
        this.f9326a.setBounds(right, view.getTop() - this.f9328c, this.f9327b + right, view.getBottom() + this.f9328c);
        this.f9326a.draw(canvas);
    }

    /* renamed from: d */
    public void m9107d(View view, Canvas canvas) {
        int left = view.getLeft() - this.f9327b;
        int bottom = view.getBottom();
        this.f9326a.setBounds(left, bottom, view.getRight() + this.f9327b, this.f9328c + bottom);
        this.f9326a.draw(canvas);
    }
}