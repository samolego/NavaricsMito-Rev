package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;

/* compiled from: SwipeMenuItem.java */
/* renamed from: com.yanzhenjie.recyclerview.k, reason: use source file name */
/* loaded from: classes2.dex */
public class SwipeMenuItem {

    /* renamed from: a */
    private Context f9285a;

    /* renamed from: b */
    private Drawable f9286b;

    /* renamed from: c */
    private Drawable f9287c;

    /* renamed from: d */
    private String f9288d;

    /* renamed from: e */
    private ColorStateList f9289e;

    /* renamed from: f */
    private int f9290f;

    /* renamed from: g */
    private Typeface f9291g;

    /* renamed from: h */
    private int f9292h;

    /* renamed from: i */
    private int f9293i = -2;

    /* renamed from: j */
    private int f9294j = -2;

    /* renamed from: k */
    private int f9295k = 0;

    public SwipeMenuItem(Context context) {
        this.f9285a = context;
    }

    /* renamed from: a */
    public SwipeMenuItem m9048a(@DrawableRes int i) {
        return m9049a(ContextCompat.getDrawable(this.f9285a, i));
    }

    /* renamed from: a */
    public SwipeMenuItem m9049a(Drawable drawable) {
        this.f9286b = drawable;
        return this;
    }

    /* renamed from: a */
    public Drawable m9047a() {
        return this.f9286b;
    }

    /* renamed from: b */
    public SwipeMenuItem m9051b(@DrawableRes int i) {
        return m9052b(ContextCompat.getDrawable(this.f9285a, i));
    }

    /* renamed from: b */
    public SwipeMenuItem m9052b(Drawable drawable) {
        this.f9287c = drawable;
        return this;
    }

    /* renamed from: b */
    public Drawable m9050b() {
        return this.f9287c;
    }

    /* renamed from: c */
    public String m9054c() {
        return this.f9288d;
    }

    /* renamed from: d */
    public ColorStateList m9055d() {
        return this.f9289e;
    }

    /* renamed from: e */
    public int m9057e() {
        return this.f9290f;
    }

    /* renamed from: f */
    public int m9058f() {
        return this.f9292h;
    }

    /* renamed from: g */
    public Typeface m9059g() {
        return this.f9291g;
    }

    /* renamed from: c */
    public SwipeMenuItem m9053c(int i) {
        this.f9293i = i;
        return this;
    }

    /* renamed from: h */
    public int m9060h() {
        return this.f9293i;
    }

    /* renamed from: d */
    public SwipeMenuItem m9056d(int i) {
        this.f9294j = i;
        return this;
    }

    /* renamed from: i */
    public int m9061i() {
        return this.f9294j;
    }

    /* renamed from: j */
    public int m9062j() {
        return this.f9295k;
    }
}