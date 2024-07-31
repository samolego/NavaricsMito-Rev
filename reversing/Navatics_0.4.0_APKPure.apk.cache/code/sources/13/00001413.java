package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* loaded from: classes.dex */
public class ResultPoint {

    /* renamed from: x */
    private final float f3422x;

    /* renamed from: y */
    private final float f3423y;

    public ResultPoint(float f, float f2) {
        this.f3422x = f;
        this.f3423y = f2;
    }

    public final float getX() {
        return this.f3422x;
    }

    public final float getY() {
        return this.f3423y;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof ResultPoint)) {
            return false;
        }
        ResultPoint resultPoint = (ResultPoint) obj;
        return this.f3422x == resultPoint.f3422x && this.f3423y == resultPoint.f3423y;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f3422x) * 31) + Float.floatToIntBits(this.f3423y);
    }

    public final String toString() {
        return "(" + this.f3422x + ',' + this.f3423y + ')';
    }

    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (distance3 >= distance2 && distance3 >= distance) {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        } else {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f3422x, resultPoint.f3423y, resultPoint2.f3422x, resultPoint2.f3423y);
    }

    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f = resultPoint2.f3422x;
        float f2 = resultPoint2.f3423y;
        return ((resultPoint3.f3422x - f) * (resultPoint.f3423y - f2)) - ((resultPoint3.f3423y - f2) * (resultPoint.f3422x - f));
    }
}