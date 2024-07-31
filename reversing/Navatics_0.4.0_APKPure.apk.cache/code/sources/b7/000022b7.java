package com.yanzhenjie.recyclerview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.OverScroller;

/* compiled from: Horizontal.java */
/* renamed from: com.yanzhenjie.recyclerview.c */
/* loaded from: classes2.dex */
abstract class AbstractC2725c {

    /* renamed from: a */
    protected a f9276a = new a();

    /* renamed from: b */
    private int f9277b;

    /* renamed from: c */
    private View f9278c;

    /* compiled from: Horizontal.java */
    /* renamed from: com.yanzhenjie.recyclerview.c$a */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        public int f9279a;

        /* renamed from: b */
        public int f9280b;

        /* renamed from: c */
        public boolean f9281c;
    }

    /* renamed from: a */
    public abstract a mo9033a(int i, int i2);

    /* renamed from: a */
    public abstract void mo9034a(OverScroller overScroller, int i, int i2);

    /* renamed from: a */
    public abstract boolean mo9037a(int i, float f);

    /* renamed from: b */
    public abstract void mo9039b(OverScroller overScroller, int i, int i2);

    public AbstractC2725c(int i, View view) {
        this.f9277b = i;
        this.f9278c = view;
    }

    /* renamed from: a */
    public boolean m9035a() {
        View view = this.f9278c;
        return (view instanceof ViewGroup) && ((ViewGroup) view).getChildCount() > 0;
    }

    /* renamed from: a */
    public boolean m9036a(int i) {
        return i == 0 && (-m9040c().getWidth()) * m9038b() != 0;
    }

    /* renamed from: b */
    public int m9038b() {
        return this.f9277b;
    }

    /* renamed from: c */
    public View m9040c() {
        return this.f9278c;
    }

    /* renamed from: d */
    public int m9041d() {
        return this.f9278c.getWidth();
    }
}