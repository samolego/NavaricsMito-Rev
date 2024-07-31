package com.yanzhenjie.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

/* renamed from: com.yanzhenjie.recyclerview.c */
/* loaded from: classes2.dex */
abstract class Horizontal {

    /* renamed from: a */
    protected C2798a f9236a = new C2798a();

    /* renamed from: b */
    private int f9237b;

    /* renamed from: c */
    private View f9238c;

    /* compiled from: Horizontal.java */
    /* renamed from: com.yanzhenjie.recyclerview.c$a */
    /* loaded from: classes2.dex */
    public static final class C2798a {

        /* renamed from: a */
        public int f9239a;

        /* renamed from: b */
        public int f9240b;

        /* renamed from: c */
        public boolean f9241c;
    }

    /* renamed from: a */
    public abstract C2798a mo3804a(int i, int i2);

    /* renamed from: a */
    public abstract void mo3803a(OverScroller overScroller, int i, int i2);

    /* renamed from: a */
    public abstract boolean mo3805a(int i, float f);

    /* renamed from: b */
    public abstract void mo3801b(OverScroller overScroller, int i, int i2);

    public Horizontal(int i, View view) {
        this.f9237b = i;
        this.f9238c = view;
    }

    /* renamed from: a */
    public boolean m3815a() {
        View view = this.f9238c;
        return (view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0;
    }

    /* renamed from: a */
    public boolean m3814a(int i) {
        return i == 0 && (-m3812c().getWidth()) * m3813b() != 0;
    }

    /* renamed from: b */
    public int m3813b() {
        return this.f9237b;
    }

    /* renamed from: c */
    public View m3812c() {
        return this.f9238c;
    }

    /* renamed from: d */
    public int m3811d() {
        return this.f9238c.getWidth();
    }
}
