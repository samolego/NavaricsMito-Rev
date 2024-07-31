package com.navatics.robot.math;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Matrix3 implements Serializable {
    public static final int M00 = 0;
    public static final int M01 = 3;
    public static final int M02 = 6;
    public static final int M10 = 1;
    public static final int M11 = 4;
    public static final int M12 = 7;
    public static final int M20 = 2;
    public static final int M21 = 5;
    public static final int M22 = 8;
    private static final long serialVersionUID = 7907569533774959788L;
    private float[] tmp;
    public float[] val;

    public Matrix3() {
        this.val = new float[9];
        this.tmp = new float[9];
        idt();
    }

    public Matrix3(Matrix3 matrix3) {
        this.val = new float[9];
        this.tmp = new float[9];
        set(matrix3);
    }

    public Matrix3(float[] fArr) {
        this.val = new float[9];
        this.tmp = new float[9];
        set(fArr);
    }

    public Matrix3 idt() {
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 mul(Matrix3 matrix3) {
        float[] fArr = this.val;
        float f = fArr[0];
        float[] fArr2 = matrix3.val;
        float f2 = (f * fArr2[0]) + (fArr[3] * fArr2[1]) + (fArr[6] * fArr2[2]);
        float f3 = (fArr[0] * fArr2[3]) + (fArr[3] * fArr2[4]) + (fArr[6] * fArr2[5]);
        float f4 = (fArr[0] * fArr2[6]) + (fArr[3] * fArr2[7]) + (fArr[6] * fArr2[8]);
        float f5 = (fArr[1] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[7] * fArr2[2]);
        float f6 = (fArr[1] * fArr2[3]) + (fArr[4] * fArr2[4]) + (fArr[7] * fArr2[5]);
        float f7 = (fArr[1] * fArr2[6]) + (fArr[4] * fArr2[7]) + (fArr[7] * fArr2[8]);
        float f8 = (fArr[2] * fArr2[0]) + (fArr[5] * fArr2[1]) + (fArr[8] * fArr2[2]);
        float f9 = (fArr[2] * fArr2[3]) + (fArr[5] * fArr2[4]) + (fArr[8] * fArr2[5]);
        fArr[0] = f2;
        fArr[1] = f5;
        fArr[2] = f8;
        fArr[3] = f3;
        fArr[4] = f6;
        fArr[5] = f9;
        fArr[6] = f4;
        fArr[7] = f7;
        fArr[8] = (fArr[2] * fArr2[6]) + (fArr[5] * fArr2[7]) + (fArr[8] * fArr2[8]);
        return this;
    }

    public Matrix3 mulLeft(Matrix3 matrix3) {
        float[] fArr = this.val;
        float[] fArr2 = matrix3.val;
        float f = (fArr2[0] * fArr[0]) + (fArr2[3] * fArr[1]) + (fArr2[6] * fArr[2]);
        float f2 = (fArr2[0] * fArr[3]) + (fArr2[3] * fArr[4]) + (fArr2[6] * fArr[5]);
        float f3 = (fArr2[0] * fArr[6]) + (fArr2[3] * fArr[7]) + (fArr2[6] * fArr[8]);
        float f4 = (fArr2[1] * fArr[0]) + (fArr2[4] * fArr[1]) + (fArr2[7] * fArr[2]);
        float f5 = (fArr2[1] * fArr[3]) + (fArr2[4] * fArr[4]) + (fArr2[7] * fArr[5]);
        float f6 = (fArr2[1] * fArr[6]) + (fArr2[4] * fArr[7]) + (fArr2[7] * fArr[8]);
        float f7 = (fArr2[2] * fArr[0]) + (fArr2[5] * fArr[1]) + (fArr2[8] * fArr[2]);
        float f8 = (fArr2[2] * fArr[3]) + (fArr2[5] * fArr[4]) + (fArr2[8] * fArr[5]);
        fArr[0] = f;
        fArr[1] = f4;
        fArr[2] = f7;
        fArr[3] = f2;
        fArr[4] = f5;
        fArr[5] = f8;
        fArr[6] = f3;
        fArr[7] = f6;
        fArr[8] = (fArr2[2] * fArr[6]) + (fArr2[5] * fArr[7]) + (fArr2[8] * fArr[8]);
        return this;
    }

    public Matrix3 setToRotation(float f) {
        return setToRotationRad(f * 0.017453292f);
    }

    public Matrix3 setToRotationRad(float f) {
        double d = f;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float[] fArr = this.val;
        fArr[0] = cos;
        fArr[1] = sin;
        fArr[2] = 0.0f;
        fArr[3] = -sin;
        fArr[4] = cos;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 setToRotation(Vector3 vector3, float f) {
        return setToRotation(vector3, C2090b.m6571d(f), C2090b.m6573c(f));
    }

    public Matrix3 setToRotation(Vector3 vector3, float f, float f2) {
        float[] fArr = this.val;
        float f3 = 1.0f - f;
        fArr[0] = (vector3.f6126x * f3 * vector3.f6126x) + f;
        fArr[1] = ((vector3.f6126x * f3) * vector3.f6127y) - (vector3.f6128z * f2);
        fArr[2] = (vector3.f6128z * f3 * vector3.f6126x) + (vector3.f6127y * f2);
        fArr[3] = (vector3.f6126x * f3 * vector3.f6127y) + (vector3.f6128z * f2);
        fArr[4] = (vector3.f6127y * f3 * vector3.f6127y) + f;
        fArr[5] = ((vector3.f6127y * f3) * vector3.f6128z) - (vector3.f6126x * f2);
        fArr[6] = ((vector3.f6128z * f3) * vector3.f6126x) - (vector3.f6127y * f2);
        fArr[7] = (vector3.f6127y * f3 * vector3.f6128z) + (vector3.f6126x * f2);
        fArr[8] = (f3 * vector3.f6128z * vector3.f6128z) + f;
        return this;
    }

    public Matrix3 setToTranslation(float f, float f2) {
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = f;
        fArr[7] = f2;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 setToTranslation(Vector2 vector2) {
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = 0.0f;
        fArr[6] = vector2.f6120x;
        fArr[7] = vector2.f6121y;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 setToScaling(float f, float f2) {
        float[] fArr = this.val;
        fArr[0] = f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = f2;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 setToScaling(Vector2 vector2) {
        float[] fArr = this.val;
        fArr[0] = vector2.f6120x;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = vector2.f6121y;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        return this;
    }

    public String toString() {
        float[] fArr = this.val;
        return "[" + fArr[0] + "|" + fArr[3] + "|" + fArr[6] + "]\n[" + fArr[1] + "|" + fArr[4] + "|" + fArr[7] + "]\n[" + fArr[2] + "|" + fArr[5] + "|" + fArr[8] + "]";
    }

    public float det() {
        float[] fArr = this.val;
        return ((((((fArr[0] * fArr[4]) * fArr[8]) + ((fArr[3] * fArr[7]) * fArr[2])) + ((fArr[6] * fArr[1]) * fArr[5])) - ((fArr[0] * fArr[7]) * fArr[5])) - ((fArr[3] * fArr[1]) * fArr[8])) - ((fArr[6] * fArr[4]) * fArr[2]);
    }

    public Matrix3 inv() {
        float det = det();
        if (det == 0.0f) {
            throw new RuntimeException("Can't invert a singular matrix");
        }
        float f = 1.0f / det;
        float[] fArr = this.tmp;
        float[] fArr2 = this.val;
        fArr[0] = (fArr2[4] * fArr2[8]) - (fArr2[5] * fArr2[7]);
        fArr[1] = (fArr2[2] * fArr2[7]) - (fArr2[1] * fArr2[8]);
        fArr[2] = (fArr2[1] * fArr2[5]) - (fArr2[2] * fArr2[4]);
        fArr[3] = (fArr2[5] * fArr2[6]) - (fArr2[3] * fArr2[8]);
        fArr[4] = (fArr2[0] * fArr2[8]) - (fArr2[2] * fArr2[6]);
        fArr[5] = (fArr2[2] * fArr2[3]) - (fArr2[0] * fArr2[5]);
        fArr[6] = (fArr2[3] * fArr2[7]) - (fArr2[4] * fArr2[6]);
        fArr[7] = (fArr2[1] * fArr2[6]) - (fArr2[0] * fArr2[7]);
        fArr[8] = (fArr2[0] * fArr2[4]) - (fArr2[1] * fArr2[3]);
        fArr2[0] = fArr[0] * f;
        fArr2[1] = fArr[1] * f;
        fArr2[2] = fArr[2] * f;
        fArr2[3] = fArr[3] * f;
        fArr2[4] = fArr[4] * f;
        fArr2[5] = fArr[5] * f;
        fArr2[6] = fArr[6] * f;
        fArr2[7] = fArr[7] * f;
        fArr2[8] = f * fArr[8];
        return this;
    }

    public Matrix3 set(Matrix3 matrix3) {
        float[] fArr = matrix3.val;
        float[] fArr2 = this.val;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public Matrix3 set(Affine2 affine2) {
        float[] fArr = this.val;
        fArr[0] = affine2.m00;
        fArr[1] = affine2.m10;
        fArr[2] = 0.0f;
        fArr[3] = affine2.m01;
        fArr[4] = affine2.m11;
        fArr[5] = 0.0f;
        fArr[6] = affine2.m02;
        fArr[7] = affine2.m12;
        fArr[8] = 1.0f;
        return this;
    }

    public Matrix3 set(Matrix4 matrix4) {
        float[] fArr = this.val;
        fArr[0] = matrix4.val[0];
        fArr[1] = matrix4.val[1];
        fArr[2] = matrix4.val[2];
        fArr[3] = matrix4.val[4];
        fArr[4] = matrix4.val[5];
        fArr[5] = matrix4.val[6];
        fArr[6] = matrix4.val[8];
        fArr[7] = matrix4.val[9];
        fArr[8] = matrix4.val[10];
        return this;
    }

    public Matrix3 set(float[] fArr) {
        float[] fArr2 = this.val;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public Matrix3 trn(Vector2 vector2) {
        float[] fArr = this.val;
        fArr[6] = fArr[6] + vector2.f6120x;
        float[] fArr2 = this.val;
        fArr2[7] = fArr2[7] + vector2.f6121y;
        return this;
    }

    public Matrix3 trn(float f, float f2) {
        float[] fArr = this.val;
        fArr[6] = fArr[6] + f;
        fArr[7] = fArr[7] + f2;
        return this;
    }

    public Matrix3 trn(Vector3 vector3) {
        float[] fArr = this.val;
        fArr[6] = fArr[6] + vector3.f6126x;
        float[] fArr2 = this.val;
        fArr2[7] = fArr2[7] + vector3.f6127y;
        return this;
    }

    public Matrix3 translate(float f, float f2) {
        float[] fArr = this.val;
        float[] fArr2 = this.tmp;
        fArr2[0] = 1.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 1.0f;
        fArr2[5] = 0.0f;
        fArr2[6] = f;
        fArr2[7] = f2;
        fArr2[8] = 1.0f;
        m6584a(fArr, fArr2);
        return this;
    }

    public Matrix3 translate(Vector2 vector2) {
        float[] fArr = this.val;
        float[] fArr2 = this.tmp;
        fArr2[0] = 1.0f;
        fArr2[1] = 0.0f;
        fArr2[2] = 0.0f;
        fArr2[3] = 0.0f;
        fArr2[4] = 1.0f;
        fArr2[5] = 0.0f;
        fArr2[6] = vector2.f6120x;
        this.tmp[7] = vector2.f6121y;
        float[] fArr3 = this.tmp;
        fArr3[8] = 1.0f;
        m6584a(fArr, fArr3);
        return this;
    }

    public Matrix3 rotate(float f) {
        return rotateRad(f * 0.017453292f);
    }

    public Matrix3 rotateRad(float f) {
        if (f == 0.0f) {
            return this;
        }
        double d = f;
        float cos = (float) Math.cos(d);
        float sin = (float) Math.sin(d);
        float[] fArr = this.tmp;
        fArr[0] = cos;
        fArr[1] = sin;
        fArr[2] = 0.0f;
        fArr[3] = -sin;
        fArr[4] = cos;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        m6584a(this.val, fArr);
        return this;
    }

    public Matrix3 scale(float f, float f2) {
        float[] fArr = this.tmp;
        fArr[0] = f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = f2;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        m6584a(this.val, fArr);
        return this;
    }

    public Matrix3 scale(Vector2 vector2) {
        float[] fArr = this.tmp;
        fArr[0] = vector2.f6120x;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = vector2.f6121y;
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
        m6584a(this.val, fArr);
        return this;
    }

    public float[] getValues() {
        return this.val;
    }

    public Vector2 getTranslation(Vector2 vector2) {
        float[] fArr = this.val;
        vector2.f6120x = fArr[6];
        vector2.f6121y = fArr[7];
        return vector2;
    }

    public Vector2 getScale(Vector2 vector2) {
        float[] fArr = this.val;
        vector2.f6120x = (float) Math.sqrt((fArr[0] * fArr[0]) + (fArr[3] * fArr[3]));
        vector2.f6121y = (float) Math.sqrt((fArr[1] * fArr[1]) + (fArr[4] * fArr[4]));
        return vector2;
    }

    public float getRotation() {
        float[] fArr = this.val;
        return ((float) Math.atan2(fArr[1], fArr[0])) * 57.295776f;
    }

    public float getRotationRad() {
        float[] fArr = this.val;
        return (float) Math.atan2(fArr[1], fArr[0]);
    }

    public Matrix3 scl(float f) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * f;
        fArr[4] = fArr[4] * f;
        return this;
    }

    public Matrix3 scl(Vector2 vector2) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * vector2.f6120x;
        float[] fArr2 = this.val;
        fArr2[4] = fArr2[4] * vector2.f6121y;
        return this;
    }

    public Matrix3 scl(Vector3 vector3) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * vector3.f6126x;
        float[] fArr2 = this.val;
        fArr2[4] = fArr2[4] * vector3.f6127y;
        return this;
    }

    public Matrix3 transpose() {
        float[] fArr = this.val;
        float f = fArr[1];
        float f2 = fArr[2];
        float f3 = fArr[3];
        float f4 = fArr[5];
        float f5 = fArr[6];
        float f6 = fArr[7];
        fArr[3] = f;
        fArr[6] = f2;
        fArr[1] = f3;
        fArr[7] = f4;
        fArr[2] = f5;
        fArr[5] = f6;
        return this;
    }

    /* renamed from: a */
    private static void m6584a(float[] fArr, float[] fArr2) {
        float f = (fArr[0] * fArr2[0]) + (fArr[3] * fArr2[1]) + (fArr[6] * fArr2[2]);
        float f2 = (fArr[0] * fArr2[3]) + (fArr[3] * fArr2[4]) + (fArr[6] * fArr2[5]);
        float f3 = (fArr[0] * fArr2[6]) + (fArr[3] * fArr2[7]) + (fArr[6] * fArr2[8]);
        float f4 = (fArr[1] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[7] * fArr2[2]);
        float f5 = (fArr[1] * fArr2[3]) + (fArr[4] * fArr2[4]) + (fArr[7] * fArr2[5]);
        float f6 = (fArr[1] * fArr2[6]) + (fArr[4] * fArr2[7]) + (fArr[7] * fArr2[8]);
        float f7 = (fArr[2] * fArr2[0]) + (fArr[5] * fArr2[1]) + (fArr[8] * fArr2[2]);
        float f8 = (fArr[2] * fArr2[3]) + (fArr[5] * fArr2[4]) + (fArr[8] * fArr2[5]);
        fArr[0] = f;
        fArr[1] = f4;
        fArr[2] = f7;
        fArr[3] = f2;
        fArr[4] = f5;
        fArr[5] = f8;
        fArr[6] = f3;
        fArr[7] = f6;
        fArr[8] = (fArr[2] * fArr2[6]) + (fArr[5] * fArr2[7]) + (fArr[8] * fArr2[8]);
    }
}
