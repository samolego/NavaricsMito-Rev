package com.navatics.robot.math;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Vector2 implements Vector<Vector2>, Serializable {

    /* renamed from: X */
    public static final Vector2 f6118X = new Vector2(1.0f, 0.0f);

    /* renamed from: Y */
    public static final Vector2 f6119Y = new Vector2(0.0f, 1.0f);
    public static final Vector2 Zero = new Vector2(0.0f, 0.0f);
    private static final long serialVersionUID = 913902788239530931L;

    /* renamed from: x */
    public float f6120x;

    /* renamed from: y */
    public float f6121y;

    public static float dot(float f, float f2, float f3, float f4) {
        return (f * f3) + (f2 * f4);
    }

    public static float dst2(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (f5 * f5) + (f6 * f6);
    }

    public static float len2(float f, float f2) {
        return (f * f) + (f2 * f2);
    }

    public Vector2() {
    }

    public Vector2(float f, float f2) {
        this.f6120x = f;
        this.f6121y = f2;
    }

    public Vector2(Vector2 vector2) {
        set(vector2);
    }

    /* renamed from: cpy */
    public Vector2 m13101cpy() {
        return new Vector2(this);
    }

    public static float len(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public float len() {
        float f = this.f6120x;
        float f2 = this.f6121y;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public float len2() {
        float f = this.f6120x;
        float f2 = this.f6121y;
        return (f * f) + (f2 * f2);
    }

    public Vector2 set(Vector2 vector2) {
        this.f6120x = vector2.f6120x;
        this.f6121y = vector2.f6121y;
        return this;
    }

    public Vector2 set(float f, float f2) {
        this.f6120x = f;
        this.f6121y = f2;
        return this;
    }

    public Vector2 sub(Vector2 vector2) {
        this.f6120x -= vector2.f6120x;
        this.f6121y -= vector2.f6121y;
        return this;
    }

    public Vector2 sub(float f, float f2) {
        this.f6120x -= f;
        this.f6121y -= f2;
        return this;
    }

    /* renamed from: nor */
    public Vector2 m13104nor() {
        float len = len();
        if (len != 0.0f) {
            this.f6120x /= len;
            this.f6121y /= len;
        }
        return this;
    }

    public Vector2 add(Vector2 vector2) {
        this.f6120x += vector2.f6120x;
        this.f6121y += vector2.f6121y;
        return this;
    }

    public Vector2 add(float f, float f2) {
        this.f6120x += f;
        this.f6121y += f2;
        return this;
    }

    public float dot(Vector2 vector2) {
        return (this.f6120x * vector2.f6120x) + (this.f6121y * vector2.f6121y);
    }

    public float dot(float f, float f2) {
        return (this.f6120x * f) + (this.f6121y * f2);
    }

    /* renamed from: scl */
    public Vector2 m13105scl(float f) {
        this.f6120x *= f;
        this.f6121y *= f;
        return this;
    }

    public Vector2 scl(float f, float f2) {
        this.f6120x *= f;
        this.f6121y *= f2;
        return this;
    }

    public Vector2 scl(Vector2 vector2) {
        this.f6120x *= vector2.f6120x;
        this.f6121y *= vector2.f6121y;
        return this;
    }

    public Vector2 mulAdd(Vector2 vector2, float f) {
        this.f6120x += vector2.f6120x * f;
        this.f6121y += vector2.f6121y * f;
        return this;
    }

    public Vector2 mulAdd(Vector2 vector2, Vector2 vector22) {
        this.f6120x += vector2.f6120x * vector22.f6120x;
        this.f6121y += vector2.f6121y * vector22.f6121y;
        return this;
    }

    public static float dst(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    public float dst(Vector2 vector2) {
        float f = vector2.f6120x - this.f6120x;
        float f2 = vector2.f6121y - this.f6121y;
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    public float dst(float f, float f2) {
        float f3 = f - this.f6120x;
        float f4 = f2 - this.f6121y;
        return (float) Math.sqrt((f3 * f3) + (f4 * f4));
    }

    public float dst2(Vector2 vector2) {
        float f = vector2.f6120x - this.f6120x;
        float f2 = vector2.f6121y - this.f6121y;
        return (f * f) + (f2 * f2);
    }

    public float dst2(float f, float f2) {
        float f3 = f - this.f6120x;
        float f4 = f2 - this.f6121y;
        return (f3 * f3) + (f4 * f4);
    }

    /* renamed from: limit */
    public Vector2 m13102limit(float f) {
        return m13103limit2(f * f);
    }

    /* renamed from: limit2 */
    public Vector2 m13103limit2(float f) {
        float len2 = len2();
        return len2 > f ? m13105scl((float) Math.sqrt(f / len2)) : this;
    }

    /* renamed from: clamp */
    public Vector2 m13100clamp(float f, float f2) {
        float len2 = len2();
        if (len2 == 0.0f) {
            return this;
        }
        float f3 = f2 * f2;
        if (len2 > f3) {
            return m13105scl((float) Math.sqrt(f3 / len2));
        }
        float f4 = f * f;
        return len2 < f4 ? m13105scl((float) Math.sqrt(f4 / len2)) : this;
    }

    /* renamed from: setLength */
    public Vector2 m13106setLength(float f) {
        return m13107setLength2(f * f);
    }

    /* renamed from: setLength2 */
    public Vector2 m13107setLength2(float f) {
        float len2 = len2();
        return (len2 == 0.0f || len2 == f) ? this : m13105scl((float) Math.sqrt(f / len2));
    }

    public String toString() {
        return "(" + this.f6120x + "," + this.f6121y + ")";
    }

    public Vector2 fromString(String str) {
        int indexOf = str.indexOf(44, 1);
        if (indexOf != -1 && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            try {
                return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(indexOf + 1, str.length() - 1)));
            } catch (NumberFormatException unused) {
            }
        }
        throw new RuntimeException("Malformed Vector2: " + str);
    }

    public float crs(Vector2 vector2) {
        return (this.f6120x * vector2.f6121y) - (this.f6121y * vector2.f6120x);
    }

    public float crs(float f, float f2) {
        return (this.f6120x * f2) - (this.f6121y * f);
    }

    public float angle() {
        float atan2 = ((float) Math.atan2(this.f6121y, this.f6120x)) * 57.295776f;
        return atan2 < 0.0f ? atan2 + 360.0f : atan2;
    }

    public float angle(Vector2 vector2) {
        return ((float) Math.atan2(crs(vector2), dot(vector2))) * 57.295776f;
    }

    public float angleRad() {
        return (float) Math.atan2(this.f6121y, this.f6120x);
    }

    public float angleRad(Vector2 vector2) {
        return (float) Math.atan2(crs(vector2), dot(vector2));
    }

    public Vector2 setAngle(float f) {
        return setAngleRad(f * 0.017453292f);
    }

    public Vector2 setAngleRad(float f) {
        set(len(), 0.0f);
        rotateRad(f);
        return this;
    }

    public Vector2 rotate(float f) {
        return rotateRad(f * 0.017453292f);
    }

    public Vector2 rotateRad(float f) {
        double d = f;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float f2 = this.f6120x;
        float f3 = this.f6121y;
        this.f6120x = (f2 * cos) - (f3 * sin);
        this.f6121y = (f2 * sin) + (f3 * cos);
        return this;
    }

    public Vector2 rotate90(int i) {
        float f = this.f6120x;
        if (i >= 0) {
            this.f6120x = -this.f6121y;
            this.f6121y = f;
        } else {
            this.f6120x = this.f6121y;
            this.f6121y = -f;
        }
        return this;
    }

    public Vector2 lerp(Vector2 vector2, float f) {
        float f2 = 1.0f - f;
        this.f6120x = (this.f6120x * f2) + (vector2.f6120x * f);
        this.f6121y = (this.f6121y * f2) + (vector2.f6121y * f);
        return this;
    }

    public Vector2 interpolate(Vector2 vector2, float f, Interpolation interpolation) {
        return lerp(vector2, interpolation.mo6581a(f));
    }

    /* renamed from: setToRandomDirection */
    public Vector2 m13108setToRandomDirection() {
        float m6575b = C2090b.m6575b(0.0f, 6.2831855f);
        return set(C2090b.m6576b(m6575b), C2090b.m6579a(m6575b));
    }

    public int hashCode() {
        return ((NumberUtils.m6568a(this.f6120x) + 31) * 31) + NumberUtils.m6568a(this.f6121y);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Vector2 vector2 = (Vector2) obj;
            return NumberUtils.m6568a(this.f6120x) == NumberUtils.m6568a(vector2.f6120x) && NumberUtils.m6568a(this.f6121y) == NumberUtils.m6568a(vector2.f6121y);
        }
        return false;
    }

    public boolean epsilonEquals(Vector2 vector2, float f) {
        return vector2 != null && Math.abs(vector2.f6120x - this.f6120x) <= f && Math.abs(vector2.f6121y - this.f6121y) <= f;
    }

    public boolean epsilonEquals(float f, float f2, float f3) {
        return Math.abs(f - this.f6120x) <= f3 && Math.abs(f2 - this.f6121y) <= f3;
    }

    public boolean epsilonEquals(Vector2 vector2) {
        return epsilonEquals(vector2, 1.0E-6f);
    }

    public boolean epsilonEquals(float f, float f2) {
        return epsilonEquals(f, f2, 1.0E-6f);
    }

    public boolean isUnit() {
        return isUnit(1.0E-9f);
    }

    public boolean isUnit(float f) {
        return Math.abs(len2() - 1.0f) < f;
    }

    public boolean isZero() {
        return this.f6120x == 0.0f && this.f6121y == 0.0f;
    }

    public boolean isZero(float f) {
        return len2() < f;
    }

    public boolean isOnLine(Vector2 vector2) {
        return C2090b.m6569e((this.f6120x * vector2.f6121y) - (this.f6121y * vector2.f6120x));
    }

    public boolean isOnLine(Vector2 vector2, float f) {
        return C2090b.m6572c((this.f6120x * vector2.f6121y) - (this.f6121y * vector2.f6120x), f);
    }

    public boolean isCollinear(Vector2 vector2, float f) {
        return isOnLine(vector2, f) && dot(vector2) > 0.0f;
    }

    public boolean isCollinear(Vector2 vector2) {
        return isOnLine(vector2) && dot(vector2) > 0.0f;
    }

    public boolean isCollinearOpposite(Vector2 vector2, float f) {
        return isOnLine(vector2, f) && dot(vector2) < 0.0f;
    }

    public boolean isCollinearOpposite(Vector2 vector2) {
        return isOnLine(vector2) && dot(vector2) < 0.0f;
    }

    public boolean isPerpendicular(Vector2 vector2) {
        return C2090b.m6569e(dot(vector2));
    }

    public boolean isPerpendicular(Vector2 vector2, float f) {
        return C2090b.m6572c(dot(vector2), f);
    }

    public boolean hasSameDirection(Vector2 vector2) {
        return dot(vector2) > 0.0f;
    }

    public boolean hasOppositeDirection(Vector2 vector2) {
        return dot(vector2) < 0.0f;
    }

    /* renamed from: setZero */
    public Vector2 m13109setZero() {
        this.f6120x = 0.0f;
        this.f6121y = 0.0f;
        return this;
    }
}
