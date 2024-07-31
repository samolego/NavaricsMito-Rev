package com.navatics.cv.p051a;

/* compiled from: CGSize.java */
/* renamed from: com.navatics.cv.a.a, reason: use source file name */
/* loaded from: classes.dex */
public class CGSize {

    /* renamed from: a */
    public int f5826a;

    /* renamed from: b */
    public int f5827b;

    private CGSize(int i, int i2) {
        this.f5826a = i;
        this.f5827b = i2;
    }

    /* renamed from: a */
    public static final CGSize of(int i, int i2) {
        return new CGSize(i, i2);
    }

    /* renamed from: a */
    public static final CGSize of(double d, double d2) {
        return new CGSize((int) d, (int) d2);
    }
}