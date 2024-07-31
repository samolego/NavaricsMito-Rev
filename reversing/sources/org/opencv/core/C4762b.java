package org.opencv.core;

import com.github.mikephil.charting.utils.Utils;

/* renamed from: org.opencv.core.b */
/* loaded from: classes2.dex */
public class Size {

    /* renamed from: a */
    public double f12528a;

    /* renamed from: b */
    public double f12529b;

    public Size(double d, double d2) {
        this.f12528a = d;
        this.f12529b = d2;
    }

    public Size() {
        this(Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);
    }

    /* renamed from: a */
    public Size clone() {
        return new Size(this.f12528a, this.f12529b);
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f12529b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f12528a);
        return ((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Size) {
            Size size = (Size) obj;
            return this.f12528a == size.f12528a && this.f12529b == size.f12529b;
        }
        return false;
    }

    public String toString() {
        return ((int) this.f12528a) + "x" + ((int) this.f12529b);
    }
}
