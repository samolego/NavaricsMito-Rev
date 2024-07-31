package com.yanzhenjie.recyclerview.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

/* renamed from: com.yanzhenjie.recyclerview.widget.b */
/* loaded from: classes2.dex */
class Drawer {

    /* renamed from: a */
    private final Drawable f9286a;

    /* renamed from: b */
    private final int f9287b;

    /* renamed from: c */
    private final int f9288c;

    public Drawer(Drawable drawable, int i, int i2) {
        this.f9286a = drawable;
        this.f9287b = i;
        this.f9288c = i2;
    }

    /* renamed from: a */
    public void m3738a(View view, Canvas canvas) {
        int left = view.getLeft() - this.f9287b;
        int bottom = view.getBottom() + this.f9288c;
        this.f9286a.setBounds(left, view.getTop() - this.f9288c, this.f9287b + left, bottom);
        this.f9286a.draw(canvas);
    }

    /* renamed from: b */
    public void m3737b(View view, Canvas canvas) {
        int left = view.getLeft() - this.f9287b;
        int top = view.getTop() - this.f9288c;
        this.f9286a.setBounds(left, top, view.getRight() + this.f9287b, this.f9288c + top);
        this.f9286a.draw(canvas);
    }

    /* renamed from: c */
    public void m3736c(View view, Canvas canvas) {
        int right = view.getRight();
        int bottom = view.getBottom() + this.f9288c;
        this.f9286a.setBounds(right, view.getTop() - this.f9288c, this.f9287b + right, bottom);
        this.f9286a.draw(canvas);
    }

    /* renamed from: d */
    public void m3735d(View view, Canvas canvas) {
        int left = view.getLeft() - this.f9287b;
        int bottom = view.getBottom();
        this.f9286a.setBounds(left, bottom, view.getRight() + this.f9287b, this.f9288c + bottom);
        this.f9286a.draw(canvas);
    }
}
