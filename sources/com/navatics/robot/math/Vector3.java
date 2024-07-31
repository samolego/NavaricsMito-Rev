package com.navatics.robot.math;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Vector3 implements Vector<Vector3>, Serializable {

    /* renamed from: X */
    public static final Vector3 f6122X = new Vector3(1.0f, 0.0f, 0.0f);

    /* renamed from: Y */
    public static final Vector3 f6123Y = new Vector3(0.0f, 1.0f, 0.0f);

    /* renamed from: Z */
    public static final Vector3 f6124Z = new Vector3(0.0f, 0.0f, 1.0f);
    public static final Vector3 Zero = new Vector3(0.0f, 0.0f, 0.0f);

    /* renamed from: a */
    private static final Matrix4 f6125a = new Matrix4();
    private static final long serialVersionUID = 3840054589595372522L;

    /* renamed from: x */
    public float f6126x;

    /* renamed from: y */
    public float f6127y;

    /* renamed from: z */
    public float f6128z;

    public static float dot(float f, float f2, float f3, float f4, float f5, float f6) {
        return (f * f4) + (f2 * f5) + (f3 * f6);
    }

    public static float dst2(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 - f;
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        return (f7 * f7) + (f8 * f8) + (f9 * f9);
    }

    public static float len2(float f, float f2, float f3) {
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public Vector3() {
    }

    public Vector3(float f, float f2, float f3) {
        set(f, f2, f3);
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(Vector2 vector2, float f) {
        set(vector2.f6120x, vector2.f6121y, f);
    }

    public Vector3 set(float f, float f2, float f3) {
        this.f6126x = f;
        this.f6127y = f2;
        this.f6128z = f3;
        return this;
    }

    public Vector3 set(Vector3 vector3) {
        return set(vector3.f6126x, vector3.f6127y, vector3.f6128z);
    }

    public Vector3 set(float[] fArr) {
        return set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3 set(Vector2 vector2, float f) {
        return set(vector2.f6120x, vector2.f6121y, f);
    }

    public Vector3 setFromSpherical(float f, float f2) {
        float m6576b = C2090b.m6576b(f2);
        float m6579a = C2090b.m6579a(f2);
        return set(C2090b.m6576b(f) * m6579a, C2090b.m6579a(f) * m6579a, m6576b);
    }

    /* renamed from: setToRandomDirection */
    public Vector3 m13118setToRandomDirection() {
        return setFromSpherical(C2090b.m6580a() * 6.2831855f, (float) Math.acos((C2090b.m6580a() * 2.0f) - 1.0f));
    }

    /* renamed from: cpy */
    public Vector3 m13111cpy() {
        return new Vector3(this);
    }

    public Vector3 add(Vector3 vector3) {
        return add(vector3.f6126x, vector3.f6127y, vector3.f6128z);
    }

    public Vector3 add(float f, float f2, float f3) {
        return set(this.f6126x + f, this.f6127y + f2, this.f6128z + f3);
    }

    public Vector3 add(float f) {
        return set(this.f6126x + f, this.f6127y + f, this.f6128z + f);
    }

    public Vector3 sub(Vector3 vector3) {
        return sub(vector3.f6126x, vector3.f6127y, vector3.f6128z);
    }

    public Vector3 sub(float f, float f2, float f3) {
        return set(this.f6126x - f, this.f6127y - f2, this.f6128z - f3);
    }

    public Vector3 sub(float f) {
        return set(this.f6126x - f, this.f6127y - f, this.f6128z - f);
    }

    /* renamed from: scl */
    public Vector3 m13115scl(float f) {
        return set(this.f6126x * f, this.f6127y * f, this.f6128z * f);
    }

    public Vector3 scl(Vector3 vector3) {
        return set(this.f6126x * vector3.f6126x, this.f6127y * vector3.f6127y, this.f6128z * vector3.f6128z);
    }

    public Vector3 scl(float f, float f2, float f3) {
        return set(this.f6126x * f, this.f6127y * f2, this.f6128z * f3);
    }

    public Vector3 mulAdd(Vector3 vector3, float f) {
        this.f6126x += vector3.f6126x * f;
        this.f6127y += vector3.f6127y * f;
        this.f6128z += vector3.f6128z * f;
        return this;
    }

    public Vector3 mulAdd(Vector3 vector3, Vector3 vector32) {
        this.f6126x += vector3.f6126x * vector32.f6126x;
        this.f6127y += vector3.f6127y * vector32.f6127y;
        this.f6128z += vector3.f6128z * vector32.f6128z;
        return this;
    }

    public static float len(float f, float f2, float f3) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public float len() {
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f6128z;
        return (float) Math.sqrt(f3 + (f4 * f4));
    }

    public float len2() {
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f6128z;
        return f3 + (f4 * f4);
    }

    public boolean idt(Vector3 vector3) {
        return this.f6126x == vector3.f6126x && this.f6127y == vector3.f6127y && this.f6128z == vector3.f6128z;
    }

    public static float dst(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f4 - f;
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        return (float) Math.sqrt((f7 * f7) + (f8 * f8) + (f9 * f9));
    }

    public float dst(Vector3 vector3) {
        float f = vector3.f6126x - this.f6126x;
        float f2 = vector3.f6127y - this.f6127y;
        float f3 = vector3.f6128z - this.f6128z;
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
    }

    public float dst(float f, float f2, float f3) {
        float f4 = f - this.f6126x;
        float f5 = f2 - this.f6127y;
        float f6 = f3 - this.f6128z;
        return (float) Math.sqrt((f4 * f4) + (f5 * f5) + (f6 * f6));
    }

    public float dst2(Vector3 vector3) {
        float f = vector3.f6126x - this.f6126x;
        float f2 = vector3.f6127y - this.f6127y;
        float f3 = vector3.f6128z - this.f6128z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public float dst2(float f, float f2, float f3) {
        float f4 = f - this.f6126x;
        float f5 = f2 - this.f6127y;
        float f6 = f3 - this.f6128z;
        return (f4 * f4) + (f5 * f5) + (f6 * f6);
    }

    /* renamed from: nor */
    public Vector3 m13114nor() {
        float len2 = len2();
        return (len2 == 0.0f || len2 == 1.0f) ? this : m13115scl(1.0f / ((float) Math.sqrt(len2)));
    }

    public float dot(Vector3 vector3) {
        return (this.f6126x * vector3.f6126x) + (this.f6127y * vector3.f6127y) + (this.f6128z * vector3.f6128z);
    }

    public float dot(float f, float f2, float f3) {
        return (this.f6126x * f) + (this.f6127y * f2) + (this.f6128z * f3);
    }

    public Vector3 crs(Vector3 vector3) {
        float f = this.f6127y;
        float f2 = vector3.f6128z;
        float f3 = this.f6128z;
        float f4 = vector3.f6127y;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = vector3.f6126x;
        float f7 = this.f6126x;
        return set(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6));
    }

    public Vector3 crs(float f, float f2, float f3) {
        float f4 = this.f6127y;
        float f5 = this.f6128z;
        float f6 = (f4 * f3) - (f5 * f2);
        float f7 = this.f6126x;
        return set(f6, (f5 * f) - (f3 * f7), (f7 * f2) - (f4 * f));
    }

    public Vector3 mul4x3(float[] fArr) {
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[3] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[6] * f4) + fArr[9], (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f4) + fArr[10], (f * fArr[2]) + (f2 * fArr[5]) + (f4 * fArr[8]) + fArr[11]);
    }

    public Vector3 mul(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[4] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[8] * f4) + fArr[12], (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f4) + fArr[13], (f * fArr[2]) + (f2 * fArr[6]) + (f4 * fArr[10]) + fArr[14]);
    }

    public Vector3 traMul(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[1] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[2] * f4) + fArr[3], (fArr[4] * f) + (fArr[5] * f2) + (fArr[6] * f4) + fArr[7], (f * fArr[8]) + (f2 * fArr[9]) + (f4 * fArr[10]) + fArr[11]);
    }

    public Vector3 mul(Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[3] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[6] * f4), (fArr[1] * f) + (fArr[4] * f2) + (fArr[7] * f4), (f * fArr[2]) + (f2 * fArr[5]) + (f4 * fArr[8]));
    }

    public Vector3 traMul(Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[1] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[2] * f4), (fArr[3] * f) + (fArr[4] * f2) + (fArr[5] * f4), (f * fArr[6]) + (f2 * fArr[7]) + (f4 * fArr[8]));
    }

    public Vector3 mul(Quaternion quaternion) {
        return quaternion.transform(this);
    }

    public Vector3 prj(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[3] * f) + (fArr[7] * f2);
        float f4 = this.f6128z;
        float f5 = 1.0f / ((f3 + (fArr[11] * f4)) + fArr[15]);
        return set(((fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f4) + fArr[12]) * f5, ((fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f4) + fArr[13]) * f5, ((f * fArr[2]) + (f2 * fArr[6]) + (f4 * fArr[10]) + fArr[14]) * f5);
    }

    public Vector3 rot(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[4] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[8] * f4), (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f4), (f * fArr[2]) + (f2 * fArr[6]) + (f4 * fArr[10]));
    }

    public Vector3 unrotate(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[1] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[2] * f4), (fArr[4] * f) + (fArr[5] * f2) + (fArr[6] * f4), (f * fArr[8]) + (f2 * fArr[9]) + (f4 * fArr[10]));
    }

    public Vector3 untransform(Matrix4 matrix4) {
        float[] fArr = matrix4.val;
        this.f6126x -= fArr[12];
        this.f6127y -= fArr[12];
        this.f6128z -= fArr[12];
        float f = this.f6126x;
        float f2 = this.f6127y;
        float f3 = (fArr[0] * f) + (fArr[1] * f2);
        float f4 = this.f6128z;
        return set(f3 + (fArr[2] * f4), (fArr[4] * f) + (fArr[5] * f2) + (fArr[6] * f4), (f * fArr[8]) + (f2 * fArr[9]) + (f4 * fArr[10]));
    }

    public Vector3 rotate(float f, float f2, float f3, float f4) {
        return mul(f6125a.setToRotation(f2, f3, f4, f));
    }

    public Vector3 rotateRad(float f, float f2, float f3, float f4) {
        return mul(f6125a.setToRotationRad(f2, f3, f4, f));
    }

    public Vector3 rotate(Vector3 vector3, float f) {
        f6125a.setToRotation(vector3, f);
        return mul(f6125a);
    }

    public Vector3 rotateRad(Vector3 vector3, float f) {
        f6125a.setToRotationRad(vector3, f);
        return mul(f6125a);
    }

    public boolean isUnit() {
        return isUnit(1.0E-9f);
    }

    public boolean isUnit(float f) {
        return Math.abs(len2() - 1.0f) < f;
    }

    public boolean isZero() {
        return this.f6126x == 0.0f && this.f6127y == 0.0f && this.f6128z == 0.0f;
    }

    public boolean isZero(float f) {
        return len2() < f;
    }

    public boolean isOnLine(Vector3 vector3, float f) {
        float f2 = this.f6127y;
        float f3 = vector3.f6128z;
        float f4 = this.f6128z;
        float f5 = vector3.f6127y;
        float f6 = (f2 * f3) - (f4 * f5);
        float f7 = vector3.f6126x;
        float f8 = this.f6126x;
        return len2(f6, (f4 * f7) - (f3 * f8), (f8 * f5) - (f2 * f7)) <= f;
    }

    public boolean isOnLine(Vector3 vector3) {
        float f = this.f6127y;
        float f2 = vector3.f6128z;
        float f3 = this.f6128z;
        float f4 = vector3.f6127y;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = vector3.f6126x;
        float f7 = this.f6126x;
        return len2(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6)) <= 1.0E-6f;
    }

    public boolean isCollinear(Vector3 vector3, float f) {
        return isOnLine(vector3, f) && hasSameDirection(vector3);
    }

    public boolean isCollinear(Vector3 vector3) {
        return isOnLine(vector3) && hasSameDirection(vector3);
    }

    public boolean isCollinearOpposite(Vector3 vector3, float f) {
        return isOnLine(vector3, f) && hasOppositeDirection(vector3);
    }

    public boolean isCollinearOpposite(Vector3 vector3) {
        return isOnLine(vector3) && hasOppositeDirection(vector3);
    }

    public boolean isPerpendicular(Vector3 vector3) {
        return C2090b.m6569e(dot(vector3));
    }

    public boolean isPerpendicular(Vector3 vector3, float f) {
        return C2090b.m6572c(dot(vector3), f);
    }

    public boolean hasSameDirection(Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }

    public boolean hasOppositeDirection(Vector3 vector3) {
        return dot(vector3) < 0.0f;
    }

    public Vector3 lerp(Vector3 vector3, float f) {
        float f2 = this.f6126x;
        this.f6126x = f2 + ((vector3.f6126x - f2) * f);
        float f3 = this.f6127y;
        this.f6127y = f3 + ((vector3.f6127y - f3) * f);
        float f4 = this.f6128z;
        this.f6128z = f4 + (f * (vector3.f6128z - f4));
        return this;
    }

    public Vector3 interpolate(Vector3 vector3, float f, Interpolation interpolation) {
        return lerp(vector3, interpolation.m6583a(0.0f, 1.0f, f));
    }

    public Vector3 slerp(Vector3 vector3, float f) {
        float dot = dot(vector3);
        double d = dot;
        if (d > 0.9995d || d < -0.9995d) {
            return lerp(vector3, f);
        }
        double acos = ((float) Math.acos(d)) * f;
        float sin = (float) Math.sin(acos);
        float f2 = vector3.f6126x - (this.f6126x * dot);
        float f3 = vector3.f6127y - (this.f6127y * dot);
        float f4 = vector3.f6128z - (this.f6128z * dot);
        float f5 = (f2 * f2) + (f3 * f3) + (f4 * f4);
        float sqrt = sin * (f5 >= 1.0E-4f ? 1.0f / ((float) Math.sqrt(f5)) : 1.0f);
        return m13115scl((float) Math.cos(acos)).add(f2 * sqrt, f3 * sqrt, f4 * sqrt).m13114nor();
    }

    public String toString() {
        return "(" + this.f6126x + "," + this.f6127y + "," + this.f6128z + ")";
    }

    public Vector3 fromString(String str) {
        int indexOf = str.indexOf(44, 1);
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(44, i);
        if (indexOf != -1 && indexOf2 != -1 && str.charAt(0) == '(' && str.charAt(str.length() - 1) == ')') {
            try {
                return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(i, indexOf2)), Float.parseFloat(str.substring(indexOf2 + 1, str.length() - 1)));
            } catch (NumberFormatException unused) {
            }
        }
        throw new RuntimeException("Malformed Vector3: " + str);
    }

    /* renamed from: limit */
    public Vector3 m13112limit(float f) {
        return m13113limit2(f * f);
    }

    /* renamed from: limit2 */
    public Vector3 m13113limit2(float f) {
        float len2 = len2();
        if (len2 > f) {
            m13115scl((float) Math.sqrt(f / len2));
        }
        return this;
    }

    /* renamed from: setLength */
    public Vector3 m13116setLength(float f) {
        return m13117setLength2(f * f);
    }

    /* renamed from: setLength2 */
    public Vector3 m13117setLength2(float f) {
        float len2 = len2();
        return (len2 == 0.0f || len2 == f) ? this : m13115scl((float) Math.sqrt(f / len2));
    }

    /* renamed from: clamp */
    public Vector3 m13110clamp(float f, float f2) {
        float len2 = len2();
        if (len2 == 0.0f) {
            return this;
        }
        float f3 = f2 * f2;
        if (len2 > f3) {
            return m13115scl((float) Math.sqrt(f3 / len2));
        }
        float f4 = f * f;
        return len2 < f4 ? m13115scl((float) Math.sqrt(f4 / len2)) : this;
    }

    public int hashCode() {
        return ((((NumberUtils.m6568a(this.f6126x) + 31) * 31) + NumberUtils.m6568a(this.f6127y)) * 31) + NumberUtils.m6568a(this.f6128z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            Vector3 vector3 = (Vector3) obj;
            return NumberUtils.m6568a(this.f6126x) == NumberUtils.m6568a(vector3.f6126x) && NumberUtils.m6568a(this.f6127y) == NumberUtils.m6568a(vector3.f6127y) && NumberUtils.m6568a(this.f6128z) == NumberUtils.m6568a(vector3.f6128z);
        }
        return false;
    }

    public boolean epsilonEquals(Vector3 vector3, float f) {
        return vector3 != null && Math.abs(vector3.f6126x - this.f6126x) <= f && Math.abs(vector3.f6127y - this.f6127y) <= f && Math.abs(vector3.f6128z - this.f6128z) <= f;
    }

    public boolean epsilonEquals(float f, float f2, float f3, float f4) {
        return Math.abs(f - this.f6126x) <= f4 && Math.abs(f2 - this.f6127y) <= f4 && Math.abs(f3 - this.f6128z) <= f4;
    }

    public boolean epsilonEquals(Vector3 vector3) {
        return epsilonEquals(vector3, 1.0E-6f);
    }

    public boolean epsilonEquals(float f, float f2, float f3) {
        return epsilonEquals(f, f2, f3, 1.0E-6f);
    }

    /* renamed from: setZero */
    public Vector3 m13119setZero() {
        this.f6126x = 0.0f;
        this.f6127y = 0.0f;
        this.f6128z = 0.0f;
        return this;
    }
}
