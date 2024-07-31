package org.opencv.core;

import com.github.mikephil.charting.utils.Utils;

/* compiled from: Size.java */
/* renamed from: org.opencv.core.b */
/* loaded from: classes2.dex */
public class C3482b {

    /* renamed from: a */
    public double f12569a;

    /* renamed from: b */
    public double f12570b;

    public C3482b(double d, double d2) {
        this.f12569a = d;
        this.f12570b = d2;
    }

    public C3482b() {
        this(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public C3482b clone() {
        return new C3482b(this.f12569a, this.f12570b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f12570b);
        int i = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31;
        long doubleToLongBits2 = Double.doubleToLongBits(this.f12569a);
        return (i * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3482b)) {
            return false;
        }
        C3482b c3482b = (C3482b) obj;
        return this.f12569a == c3482b.f12569a && this.f12570b == c3482b.f12570b;
    }

    public String toString() {
        return ((int) this.f12569a) + "x" + ((int) this.f12570b);
    }
}