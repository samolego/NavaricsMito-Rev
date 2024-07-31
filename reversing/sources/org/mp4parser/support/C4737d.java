package org.mp4parser.support;

import com.github.mikephil.charting.utils.Utils;
import java.nio.ByteBuffer;
import org.mp4parser.p144a.IsoTypeReader;
import org.mp4parser.p144a.IsoTypeWriter;

/* renamed from: org.mp4parser.support.d */
/* loaded from: classes2.dex */
public class Matrix {

    /* renamed from: a */
    public static final Matrix f12385a = new Matrix(1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);

    /* renamed from: b */
    public static final Matrix f12386b = new Matrix(Utils.DOUBLE_EPSILON, 1.0d, -1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);

    /* renamed from: c */
    public static final Matrix f12387c = new Matrix(-1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, -1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);

    /* renamed from: d */
    public static final Matrix f12388d = new Matrix(Utils.DOUBLE_EPSILON, -1.0d, 1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON, 1.0d, Utils.DOUBLE_EPSILON, Utils.DOUBLE_EPSILON);

    /* renamed from: e */
    double f12389e;

    /* renamed from: f */
    double f12390f;

    /* renamed from: g */
    double f12391g;

    /* renamed from: h */
    double f12392h;

    /* renamed from: i */
    double f12393i;

    /* renamed from: j */
    double f12394j;

    /* renamed from: k */
    double f12395k;

    /* renamed from: l */
    double f12396l;

    /* renamed from: m */
    double f12397m;

    public Matrix(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        this.f12389e = d5;
        this.f12390f = d6;
        this.f12391g = d7;
        this.f12392h = d;
        this.f12393i = d2;
        this.f12394j = d3;
        this.f12395k = d4;
        this.f12396l = d8;
        this.f12397m = d9;
    }

    /* renamed from: a */
    public static Matrix m391a(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        return new Matrix(d, d2, d4, d5, d3, d6, d9, d7, d8);
    }

    /* renamed from: a */
    public static Matrix m390a(ByteBuffer byteBuffer) {
        return m391a(IsoTypeReader.m732f(byteBuffer), IsoTypeReader.m732f(byteBuffer), IsoTypeReader.m731g(byteBuffer), IsoTypeReader.m732f(byteBuffer), IsoTypeReader.m732f(byteBuffer), IsoTypeReader.m731g(byteBuffer), IsoTypeReader.m732f(byteBuffer), IsoTypeReader.m732f(byteBuffer), IsoTypeReader.m731g(byteBuffer));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Matrix matrix = (Matrix) obj;
        return Double.compare(matrix.f12392h, this.f12392h) == 0 && Double.compare(matrix.f12393i, this.f12393i) == 0 && Double.compare(matrix.f12394j, this.f12394j) == 0 && Double.compare(matrix.f12395k, this.f12395k) == 0 && Double.compare(matrix.f12396l, this.f12396l) == 0 && Double.compare(matrix.f12397m, this.f12397m) == 0 && Double.compare(matrix.f12389e, this.f12389e) == 0 && Double.compare(matrix.f12390f, this.f12390f) == 0 && Double.compare(matrix.f12391g, this.f12391g) == 0;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f12389e);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f12390f);
        long doubleToLongBits3 = Double.doubleToLongBits(this.f12391g);
        long doubleToLongBits4 = Double.doubleToLongBits(this.f12392h);
        long doubleToLongBits5 = Double.doubleToLongBits(this.f12393i);
        long doubleToLongBits6 = Double.doubleToLongBits(this.f12394j);
        long doubleToLongBits7 = Double.doubleToLongBits(this.f12395k);
        long doubleToLongBits8 = Double.doubleToLongBits(this.f12396l);
        long doubleToLongBits9 = Double.doubleToLongBits(this.f12397m);
        return (((((((((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + ((int) (doubleToLongBits3 ^ (doubleToLongBits3 >>> 32)))) * 31) + ((int) (doubleToLongBits4 ^ (doubleToLongBits4 >>> 32)))) * 31) + ((int) (doubleToLongBits5 ^ (doubleToLongBits5 >>> 32)))) * 31) + ((int) (doubleToLongBits6 ^ (doubleToLongBits6 >>> 32)))) * 31) + ((int) (doubleToLongBits7 ^ (doubleToLongBits7 >>> 32)))) * 31) + ((int) (doubleToLongBits8 ^ (doubleToLongBits8 >>> 32)))) * 31) + ((int) (doubleToLongBits9 ^ (doubleToLongBits9 >>> 32)));
    }

    public String toString() {
        if (equals(f12385a)) {
            return "Rotate 0°";
        }
        if (equals(f12386b)) {
            return "Rotate 90°";
        }
        if (equals(f12387c)) {
            return "Rotate 180°";
        }
        if (equals(f12388d)) {
            return "Rotate 270°";
        }
        return "Matrix{u=" + this.f12389e + ", v=" + this.f12390f + ", w=" + this.f12391g + ", a=" + this.f12392h + ", b=" + this.f12393i + ", c=" + this.f12394j + ", d=" + this.f12395k + ", tx=" + this.f12396l + ", ty=" + this.f12397m + '}';
    }

    /* renamed from: b */
    public void m389b(ByteBuffer byteBuffer) {
        IsoTypeWriter.m726a(byteBuffer, this.f12392h);
        IsoTypeWriter.m726a(byteBuffer, this.f12393i);
        IsoTypeWriter.m722b(byteBuffer, this.f12389e);
        IsoTypeWriter.m726a(byteBuffer, this.f12394j);
        IsoTypeWriter.m726a(byteBuffer, this.f12395k);
        IsoTypeWriter.m722b(byteBuffer, this.f12390f);
        IsoTypeWriter.m726a(byteBuffer, this.f12396l);
        IsoTypeWriter.m726a(byteBuffer, this.f12397m);
        IsoTypeWriter.m722b(byteBuffer, this.f12391g);
    }
}
