package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.p008v4.content.ContextCompat;

/* renamed from: com.yanzhenjie.recyclerview.k */
/* loaded from: classes2.dex */
public class SwipeMenuItem {

    /* renamed from: a */
    private Context f9245a;

    /* renamed from: b */
    private Drawable f9246b;

    /* renamed from: c */
    private Drawable f9247c;

    /* renamed from: d */
    private String f9248d;

    /* renamed from: e */
    private ColorStateList f9249e;

    /* renamed from: f */
    private int f9250f;

    /* renamed from: g */
    private Typeface f9251g;

    /* renamed from: h */
    private int f9252h;

    /* renamed from: i */
    private int f9253i = -2;

    /* renamed from: j */
    private int f9254j = -2;

    /* renamed from: k */
    private int f9255k = 0;

    public SwipeMenuItem(Context context) {
        this.f9245a = context;
    }

    /* renamed from: a */
    public SwipeMenuItem m3796a(@DrawableRes int i) {
        return m3795a(ContextCompat.getDrawable(this.f9245a, i));
    }

    /* renamed from: a */
    public SwipeMenuItem m3795a(Drawable drawable) {
        this.f9246b = drawable;
        return this;
    }

    /* renamed from: a */
    public Drawable m3797a() {
        return this.f9246b;
    }

    /* renamed from: b */
    public SwipeMenuItem m3793b(@DrawableRes int i) {
        return m3792b(ContextCompat.getDrawable(this.f9245a, i));
    }

    /* renamed from: b */
    public SwipeMenuItem m3792b(Drawable drawable) {
        this.f9247c = drawable;
        return this;
    }

    /* renamed from: b */
    public Drawable m3794b() {
        return this.f9247c;
    }

    /* renamed from: c */
    public String m3791c() {
        return this.f9248d;
    }

    /* renamed from: d */
    public ColorStateList m3789d() {
        return this.f9249e;
    }

    /* renamed from: e */
    public int m3787e() {
        return this.f9250f;
    }

    /* renamed from: f */
    public int m3786f() {
        return this.f9252h;
    }

    /* renamed from: g */
    public Typeface m3785g() {
        return this.f9251g;
    }

    /* renamed from: c */
    public SwipeMenuItem m3790c(int i) {
        this.f9253i = i;
        return this;
    }

    /* renamed from: h */
    public int m3784h() {
        return this.f9253i;
    }

    /* renamed from: d */
    public SwipeMenuItem m3788d(int i) {
        this.f9254j = i;
        return this;
    }

    /* renamed from: i */
    public int m3783i() {
        return this.f9254j;
    }

    /* renamed from: j */
    public int m3782j() {
        return this.f9255k;
    }
}
