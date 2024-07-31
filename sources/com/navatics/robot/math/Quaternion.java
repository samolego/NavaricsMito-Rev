package com.navatics.robot.math;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Quaternion implements Serializable {

    /* renamed from: a */
    private static Quaternion f6112a = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: b */
    private static Quaternion f6113b = new Quaternion(0.0f, 0.0f, 0.0f, 0.0f);
    private static final long serialVersionUID = -7661875440774897168L;

    /* renamed from: w */
    public float f6114w;

    /* renamed from: x */
    public float f6115x;

    /* renamed from: y */
    public float f6116y;

    /* renamed from: z */
    public float f6117z;

    public static final float dot(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        return (f * f5) + (f2 * f6) + (f3 * f7) + (f4 * f8);
    }

    public static final float len2(float f, float f2, float f3, float f4) {
        return (f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4);
    }

    public Quaternion(float f, float f2, float f3, float f4) {
        set(f, f2, f3, f4);
    }

    public Quaternion() {
        idt();
    }

    public Quaternion(Quaternion quaternion) {
        set(quaternion);
    }

    public Quaternion(Vector3 vector3, float f) {
        set(vector3, f);
    }

    public Quaternion set(float f, float f2, float f3, float f4) {
        this.f6115x = f;
        this.f6116y = f2;
        this.f6117z = f3;
        this.f6114w = f4;
        return this;
    }

    public Quaternion set(Quaternion quaternion) {
        return set(quaternion.f6115x, quaternion.f6116y, quaternion.f6117z, quaternion.f6114w);
    }

    public Quaternion set(Vector3 vector3, float f) {
        return setFromAxis(vector3.f6126x, vector3.f6127y, vector3.f6128z, f);
    }

    public Quaternion cpy() {
        return new Quaternion(this);
    }

    public static final float len(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4));
    }

    public float len() {
        float f = this.f6115x;
        float f2 = this.f6116y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f6117z;
        float f5 = f3 + (f4 * f4);
        float f6 = this.f6114w;
        return (float) Math.sqrt(f5 + (f6 * f6));
    }

    public String toString() {
        return "[" + this.f6115x + "|" + this.f6116y + "|" + this.f6117z + "|" + this.f6114w + "]";
    }

    public Quaternion setEulerAngles(float f, float f2, float f3) {
        return setEulerAnglesRad(f * 0.017453292f, f2 * 0.017453292f, f3 * 0.017453292f);
    }

    public Quaternion setEulerAnglesRad(float f, float f2, float f3) {
        double d = f3 * 0.5f;
        float sin = (float) Math.sin(d);
        float cos = (float) Math.cos(d);
        double d2 = f2 * 0.5f;
        float sin2 = (float) Math.sin(d2);
        float cos2 = (float) Math.cos(d2);
        double d3 = f * 0.5f;
        float sin3 = (float) Math.sin(d3);
        float cos3 = (float) Math.cos(d3);
        float f4 = cos3 * sin2;
        float f5 = sin3 * cos2;
        float f6 = cos3 * cos2;
        float f7 = sin3 * sin2;
        this.f6115x = (f4 * cos) + (f5 * sin);
        this.f6116y = (f5 * cos) - (f4 * sin);
        this.f6117z = (f6 * sin) - (f7 * cos);
        this.f6114w = (f6 * cos) + (f7 * sin);
        return this;
    }

    public int getGimbalPole() {
        float f = (this.f6116y * this.f6115x) + (this.f6117z * this.f6114w);
        if (f > 0.499f) {
            return 1;
        }
        return f < -0.499f ? -1 : 0;
    }

    public float getRollRad() {
        int gimbalPole = getGimbalPole();
        if (gimbalPole == 0) {
            float f = this.f6114w;
            float f2 = this.f6117z;
            float f3 = this.f6116y;
            float f4 = this.f6115x;
            return C2090b.m6578a(((f * f2) + (f3 * f4)) * 2.0f, 1.0f - (((f4 * f4) + (f2 * f2)) * 2.0f));
        }
        return gimbalPole * 2.0f * C2090b.m6578a(this.f6116y, this.f6114w);
    }

    public float getRoll() {
        return getRollRad() * 57.295776f;
    }

    public float getPitchRad() {
        int gimbalPole = getGimbalPole();
        return gimbalPole == 0 ? (float) Math.asin(C2090b.m6577a(((this.f6114w * this.f6115x) - (this.f6117z * this.f6116y)) * 2.0f, -1.0f, 1.0f)) : gimbalPole * 3.1415927f * 0.5f;
    }

    public float getPitch() {
        return getPitchRad() * 57.295776f;
    }

    public float getYawRad() {
        if (getGimbalPole() == 0) {
            float f = this.f6116y;
            float f2 = this.f6115x;
            return C2090b.m6578a(((this.f6114w * f) + (this.f6117z * f2)) * 2.0f, 1.0f - (((f * f) + (f2 * f2)) * 2.0f));
        }
        return 0.0f;
    }

    public float getYaw() {
        return getYawRad() * 57.295776f;
    }

    public float len2() {
        float f = this.f6115x;
        float f2 = this.f6116y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f6117z;
        float f5 = f3 + (f4 * f4);
        float f6 = this.f6114w;
        return f5 + (f6 * f6);
    }

    public Quaternion nor() {
        float len2 = len2();
        if (len2 != 0.0f && !C2090b.m6570d(len2, 1.0f)) {
            float sqrt = (float) Math.sqrt(len2);
            this.f6114w /= sqrt;
            this.f6115x /= sqrt;
            this.f6116y /= sqrt;
            this.f6117z /= sqrt;
        }
        return this;
    }

    public Quaternion conjugate() {
        this.f6115x = -this.f6115x;
        this.f6116y = -this.f6116y;
        this.f6117z = -this.f6117z;
        return this;
    }

    public Vector3 transform(Vector3 vector3) {
        f6113b.set(this);
        f6113b.conjugate();
        f6113b.mulLeft(f6112a.set(vector3.f6126x, vector3.f6127y, vector3.f6128z, 0.0f)).mulLeft(this);
        Quaternion quaternion = f6113b;
        vector3.f6126x = quaternion.f6115x;
        vector3.f6127y = quaternion.f6116y;
        vector3.f6128z = quaternion.f6117z;
        return vector3;
    }

    public Quaternion mul(Quaternion quaternion) {
        float f = this.f6114w;
        float f2 = quaternion.f6115x;
        float f3 = this.f6115x;
        float f4 = quaternion.f6114w;
        float f5 = this.f6116y;
        float f6 = quaternion.f6117z;
        float f7 = this.f6117z;
        float f8 = quaternion.f6116y;
        this.f6115x = (((f * f2) + (f3 * f4)) + (f5 * f6)) - (f7 * f8);
        this.f6116y = (((f * f8) + (f5 * f4)) + (f7 * f2)) - (f3 * f6);
        this.f6117z = (((f * f6) + (f7 * f4)) + (f3 * f8)) - (f5 * f2);
        this.f6114w = (((f * f4) - (f3 * f2)) - (f5 * f8)) - (f7 * f6);
        return this;
    }

    public Quaternion mul(float f, float f2, float f3, float f4) {
        float f5 = this.f6114w;
        float f6 = this.f6115x;
        float f7 = this.f6116y;
        float f8 = this.f6117z;
        this.f6115x = (((f5 * f) + (f6 * f4)) + (f7 * f3)) - (f8 * f2);
        this.f6116y = (((f5 * f2) + (f7 * f4)) + (f8 * f)) - (f6 * f3);
        this.f6117z = (((f5 * f3) + (f8 * f4)) + (f6 * f2)) - (f7 * f);
        this.f6114w = (((f5 * f4) - (f6 * f)) - (f7 * f2)) - (f8 * f3);
        return this;
    }

    public Quaternion mulLeft(Quaternion quaternion) {
        float f = quaternion.f6114w;
        float f2 = this.f6115x;
        float f3 = quaternion.f6115x;
        float f4 = this.f6114w;
        float f5 = quaternion.f6116y;
        float f6 = this.f6117z;
        float f7 = quaternion.f6117z;
        float f8 = this.f6116y;
        this.f6115x = (((f * f2) + (f3 * f4)) + (f5 * f6)) - (f7 * f8);
        this.f6116y = (((f * f8) + (f5 * f4)) + (f7 * f2)) - (f3 * f6);
        this.f6117z = (((f * f6) + (f7 * f4)) + (f3 * f8)) - (f5 * f2);
        this.f6114w = (((f * f4) - (f3 * f2)) - (f5 * f8)) - (f7 * f6);
        return this;
    }

    public Quaternion mulLeft(float f, float f2, float f3, float f4) {
        float f5 = this.f6115x;
        float f6 = this.f6114w;
        float f7 = this.f6117z;
        float f8 = this.f6116y;
        this.f6115x = (((f4 * f5) + (f * f6)) + (f2 * f7)) - (f3 * f8);
        this.f6116y = (((f4 * f8) + (f2 * f6)) + (f3 * f5)) - (f * f7);
        this.f6117z = (((f4 * f7) + (f3 * f6)) + (f * f8)) - (f2 * f5);
        this.f6114w = (((f4 * f6) - (f * f5)) - (f2 * f8)) - (f3 * f7);
        return this;
    }

    public Quaternion add(Quaternion quaternion) {
        this.f6115x += quaternion.f6115x;
        this.f6116y += quaternion.f6116y;
        this.f6117z += quaternion.f6117z;
        this.f6114w += quaternion.f6114w;
        return this;
    }

    public Quaternion add(float f, float f2, float f3, float f4) {
        this.f6115x += f;
        this.f6116y += f2;
        this.f6117z += f3;
        this.f6114w += f4;
        return this;
    }

    public void toMatrix(float[] fArr) {
        float f = this.f6115x;
        float f2 = f * f;
        float f3 = this.f6116y;
        float f4 = f * f3;
        float f5 = this.f6117z;
        float f6 = f * f5;
        float f7 = this.f6114w;
        float f8 = f * f7;
        float f9 = f3 * f3;
        float f10 = f3 * f5;
        float f11 = f3 * f7;
        float f12 = f5 * f5;
        float f13 = f5 * f7;
        fArr[0] = 1.0f - ((f9 + f12) * 2.0f);
        fArr[4] = (f4 - f13) * 2.0f;
        fArr[8] = (f6 + f11) * 2.0f;
        fArr[12] = 0.0f;
        fArr[1] = (f4 + f13) * 2.0f;
        fArr[5] = 1.0f - ((f12 + f2) * 2.0f);
        fArr[9] = (f10 - f8) * 2.0f;
        fArr[13] = 0.0f;
        fArr[2] = (f6 - f11) * 2.0f;
        fArr[6] = (f10 + f8) * 2.0f;
        fArr[10] = 1.0f - ((f2 + f9) * 2.0f);
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
    }

    public Quaternion idt() {
        return set(0.0f, 0.0f, 0.0f, 1.0f);
    }

    public boolean isIdentity() {
        return C2090b.m6569e(this.f6115x) && C2090b.m6569e(this.f6116y) && C2090b.m6569e(this.f6117z) && C2090b.m6570d(this.f6114w, 1.0f);
    }

    public boolean isIdentity(float f) {
        return C2090b.m6572c(this.f6115x, f) && C2090b.m6572c(this.f6116y, f) && C2090b.m6572c(this.f6117z, f) && C2090b.m6574b(this.f6114w, 1.0f, f);
    }

    public Quaternion setFromAxis(Vector3 vector3, float f) {
        return setFromAxis(vector3.f6126x, vector3.f6127y, vector3.f6128z, f);
    }

    public Quaternion setFromAxisRad(Vector3 vector3, float f) {
        return setFromAxisRad(vector3.f6126x, vector3.f6127y, vector3.f6128z, f);
    }

    public Quaternion setFromAxis(float f, float f2, float f3, float f4) {
        return setFromAxisRad(f, f2, f3, f4 * 0.017453292f);
    }

    public Quaternion setFromAxisRad(float f, float f2, float f3, float f4) {
        float len = Vector3.len(f, f2, f3);
        if (len == 0.0f) {
            return idt();
        }
        float f5 = 1.0f / len;
        double d = (f4 < 0.0f ? 6.2831855f - ((-f4) % 6.2831855f) : f4 % 6.2831855f) / 2.0f;
        float sin = (float) Math.sin(d);
        return set(f * f5 * sin, f2 * f5 * sin, f5 * f3 * sin, (float) Math.cos(d)).nor();
    }

    public Quaternion setFromMatrix(boolean z, Matrix4 matrix4) {
        return setFromAxes(z, matrix4.val[0], matrix4.val[4], matrix4.val[8], matrix4.val[1], matrix4.val[5], matrix4.val[9], matrix4.val[2], matrix4.val[6], matrix4.val[10]);
    }

    public Quaternion setFromMatrix(Matrix4 matrix4) {
        return setFromMatrix(false, matrix4);
    }

    public Quaternion setFromMatrix(boolean z, Matrix3 matrix3) {
        return setFromAxes(z, matrix3.val[0], matrix3.val[3], matrix3.val[6], matrix3.val[1], matrix3.val[4], matrix3.val[7], matrix3.val[2], matrix3.val[5], matrix3.val[8]);
    }

    public Quaternion setFromMatrix(Matrix3 matrix3) {
        return setFromMatrix(false, matrix3);
    }

    public Quaternion setFromAxes(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        return setFromAxes(false, f, f2, f3, f4, f5, f6, f7, f8, f9);
    }

    public Quaternion setFromAxes(boolean z, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9) {
        if (z) {
            float len = 1.0f / Vector3.len(f, f2, f3);
            float len2 = 1.0f / Vector3.len(f4, f5, f6);
            float len3 = 1.0f / Vector3.len(f7, f8, f9);
            f *= len;
            f2 *= len;
            f3 *= len;
            f4 *= len2;
            f5 *= len2;
            f6 *= len2;
            f7 *= len3;
            f8 *= len3;
            f9 *= len3;
        }
        float f10 = f + f5 + f9;
        if (f10 >= 0.0f) {
            float sqrt = (float) Math.sqrt(f10 + 1.0f);
            this.f6114w = sqrt * 0.5f;
            float f11 = 0.5f / sqrt;
            this.f6115x = (f8 - f6) * f11;
            this.f6116y = (f3 - f7) * f11;
            this.f6117z = (f4 - f2) * f11;
        } else if (f > f5 && f > f9) {
            float sqrt2 = (float) Math.sqrt(((f + 1.0d) - f5) - f9);
            this.f6115x = sqrt2 * 0.5f;
            float f12 = 0.5f / sqrt2;
            this.f6116y = (f4 + f2) * f12;
            this.f6117z = (f3 + f7) * f12;
            this.f6114w = (f8 - f6) * f12;
        } else if (f5 > f9) {
            float sqrt3 = (float) Math.sqrt(((f5 + 1.0d) - f) - f9);
            this.f6116y = sqrt3 * 0.5f;
            float f13 = 0.5f / sqrt3;
            this.f6115x = (f4 + f2) * f13;
            this.f6117z = (f8 + f6) * f13;
            this.f6114w = (f3 - f7) * f13;
        } else {
            float sqrt4 = (float) Math.sqrt(((f9 + 1.0d) - f) - f5);
            this.f6117z = sqrt4 * 0.5f;
            float f14 = 0.5f / sqrt4;
            this.f6115x = (f3 + f7) * f14;
            this.f6116y = (f8 + f6) * f14;
            this.f6114w = (f4 - f2) * f14;
        }
        return this;
    }

    public Quaternion setFromCross(Vector3 vector3, Vector3 vector32) {
        return setFromAxisRad((vector3.f6127y * vector32.f6128z) - (vector3.f6128z * vector32.f6127y), (vector3.f6128z * vector32.f6126x) - (vector3.f6126x * vector32.f6128z), (vector3.f6126x * vector32.f6127y) - (vector3.f6127y * vector32.f6126x), (float) Math.acos(C2090b.m6577a(vector3.dot(vector32), -1.0f, 1.0f)));
    }

    public Quaternion setFromCross(float f, float f2, float f3, float f4, float f5, float f6) {
        return setFromAxisRad((f2 * f6) - (f3 * f5), (f3 * f4) - (f6 * f), (f * f5) - (f2 * f4), (float) Math.acos(C2090b.m6577a(Vector3.dot(f, f2, f3, f4, f5, f6), -1.0f, 1.0f)));
    }

    public Quaternion slerp(Quaternion quaternion, float f) {
        float f2 = (this.f6115x * quaternion.f6115x) + (this.f6116y * quaternion.f6116y) + (this.f6117z * quaternion.f6117z) + (this.f6114w * quaternion.f6114w);
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i < 0) {
            f2 = -f2;
        }
        float f3 = 1.0f - f;
        if (1.0f - f2 > 0.1d) {
            float acos = (float) Math.acos(f2);
            float sin = 1.0f / ((float) Math.sin(acos));
            f3 = ((float) Math.sin(f3 * acos)) * sin;
            f = ((float) Math.sin(f * acos)) * sin;
        }
        if (i < 0) {
            f = -f;
        }
        this.f6115x = (this.f6115x * f3) + (quaternion.f6115x * f);
        this.f6116y = (this.f6116y * f3) + (quaternion.f6116y * f);
        this.f6117z = (this.f6117z * f3) + (quaternion.f6117z * f);
        this.f6114w = (f3 * this.f6114w) + (f * quaternion.f6114w);
        return this;
    }

    public Quaternion slerp(Quaternion[] quaternionArr) {
        float length = 1.0f / quaternionArr.length;
        set(quaternionArr[0]).exp(length);
        for (int i = 1; i < quaternionArr.length; i++) {
            mul(f6112a.set(quaternionArr[i]).exp(length));
        }
        nor();
        return this;
    }

    public Quaternion slerp(Quaternion[] quaternionArr, float[] fArr) {
        set(quaternionArr[0]).exp(fArr[0]);
        for (int i = 1; i < quaternionArr.length; i++) {
            mul(f6112a.set(quaternionArr[i]).exp(fArr[i]));
        }
        nor();
        return this;
    }

    public Quaternion exp(float f) {
        float len = len();
        double d = len;
        float pow = (float) Math.pow(d, f);
        float acos = (float) Math.acos(this.f6114w / len);
        float sin = ((double) Math.abs(acos)) < 0.001d ? (pow * f) / len : (float) ((pow * Math.sin(f * acos)) / (d * Math.sin(acos)));
        this.f6114w = (float) (pow * Math.cos(f * acos));
        this.f6115x *= sin;
        this.f6116y *= sin;
        this.f6117z *= sin;
        nor();
        return this;
    }

    public int hashCode() {
        return ((((((NumberUtils.m6567b(this.f6114w) + 31) * 31) + NumberUtils.m6567b(this.f6115x)) * 31) + NumberUtils.m6567b(this.f6116y)) * 31) + NumberUtils.m6567b(this.f6117z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof Quaternion)) {
            Quaternion quaternion = (Quaternion) obj;
            return NumberUtils.m6567b(this.f6114w) == NumberUtils.m6567b(quaternion.f6114w) && NumberUtils.m6567b(this.f6115x) == NumberUtils.m6567b(quaternion.f6115x) && NumberUtils.m6567b(this.f6116y) == NumberUtils.m6567b(quaternion.f6116y) && NumberUtils.m6567b(this.f6117z) == NumberUtils.m6567b(quaternion.f6117z);
        }
        return false;
    }

    public float dot(Quaternion quaternion) {
        return (this.f6115x * quaternion.f6115x) + (this.f6116y * quaternion.f6116y) + (this.f6117z * quaternion.f6117z) + (this.f6114w * quaternion.f6114w);
    }

    public float dot(float f, float f2, float f3, float f4) {
        return (this.f6115x * f) + (this.f6116y * f2) + (this.f6117z * f3) + (this.f6114w * f4);
    }

    public Quaternion mul(float f) {
        this.f6115x *= f;
        this.f6116y *= f;
        this.f6117z *= f;
        this.f6114w *= f;
        return this;
    }

    public float getAxisAngle(Vector3 vector3) {
        return getAxisAngleRad(vector3) * 57.295776f;
    }

    public float getAxisAngleRad(Vector3 vector3) {
        if (this.f6114w > 1.0f) {
            nor();
        }
        float acos = (float) (Math.acos(this.f6114w) * 2.0d);
        float f = this.f6114w;
        double sqrt = Math.sqrt(1.0f - (f * f));
        if (sqrt < 9.999999974752427E-7d) {
            vector3.f6126x = this.f6115x;
            vector3.f6127y = this.f6116y;
            vector3.f6128z = this.f6117z;
        } else {
            vector3.f6126x = (float) (this.f6115x / sqrt);
            vector3.f6127y = (float) (this.f6116y / sqrt);
            vector3.f6128z = (float) (this.f6117z / sqrt);
        }
        return acos;
    }

    public float getAngleRad() {
        float f = this.f6114w;
        if (f > 1.0f) {
            f /= len();
        }
        return (float) (Math.acos(f) * 2.0d);
    }

    public float getAngle() {
        return getAngleRad() * 57.295776f;
    }

    public void getSwingTwist(float f, float f2, float f3, Quaternion quaternion, Quaternion quaternion2) {
        float dot = Vector3.dot(this.f6115x, this.f6116y, this.f6117z, f, f2, f3);
        quaternion2.set(f * dot, f2 * dot, f3 * dot, this.f6114w).nor();
        if (dot < 0.0f) {
            quaternion2.mul(-1.0f);
        }
        quaternion.set(quaternion2).conjugate().mulLeft(this);
    }

    public void getSwingTwist(Vector3 vector3, Quaternion quaternion, Quaternion quaternion2) {
        getSwingTwist(vector3.f6126x, vector3.f6127y, vector3.f6128z, quaternion, quaternion2);
    }

    public float getAngleAroundRad(float f, float f2, float f3) {
        float dot = Vector3.dot(this.f6115x, this.f6116y, this.f6117z, f, f2, f3);
        float len2 = len2(f * dot, f2 * dot, f3 * dot, this.f6114w);
        if (C2090b.m6569e(len2)) {
            return 0.0f;
        }
        return (float) (Math.acos(C2090b.m6577a((float) ((dot < 0.0f ? -this.f6114w : this.f6114w) / Math.sqrt(len2)), -1.0f, 1.0f)) * 2.0d);
    }

    public float getAngleAroundRad(Vector3 vector3) {
        return getAngleAroundRad(vector3.f6126x, vector3.f6127y, vector3.f6128z);
    }

    public float getAngleAround(float f, float f2, float f3) {
        return getAngleAroundRad(f, f2, f3) * 57.295776f;
    }

    public float getAngleAround(Vector3 vector3) {
        return getAngleAround(vector3.f6126x, vector3.f6127y, vector3.f6128z);
    }
}
