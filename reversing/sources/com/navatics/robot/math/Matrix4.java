package com.navatics.robot.math;

import java.io.Serializable;

/* loaded from: classes.dex */
public class Matrix4 implements Serializable {
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    private static final long serialVersionUID = -1312461701113016581L;
    public final float[] val;

    /* renamed from: a */
    private static final float[] f6111a = new float[16];
    static Quaternion quat = new Quaternion();
    static Quaternion quat2 = new Quaternion();
    static final Vector3 l_vez = new Vector3();
    static final Vector3 l_vex = new Vector3();
    static final Vector3 l_vey = new Vector3();
    static final Vector3 tmpVec = new Vector3();
    static final Matrix4 tmpMat = new Matrix4();
    static final Vector3 right = new Vector3();
    static final Vector3 tmpForward = new Vector3();
    static final Vector3 tmpUp = new Vector3();

    public static native float det(float[] fArr);

    public static native boolean inv(float[] fArr);

    public static native void mul(float[] fArr, float[] fArr2);

    public static native void mulVec(float[] fArr, float[] fArr2);

    public static native void mulVec(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static native void prj(float[] fArr, float[] fArr2);

    public static native void prj(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static native void rot(float[] fArr, float[] fArr2);

    public static native void rot(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public Matrix4() {
        this.val = new float[16];
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
    }

    public Matrix4(Matrix4 matrix4) {
        this.val = new float[16];
        set(matrix4);
    }

    public Matrix4(float[] fArr) {
        this.val = new float[16];
        set(fArr);
    }

    public Matrix4(Quaternion quaternion) {
        this.val = new float[16];
        set(quaternion);
    }

    public Matrix4(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
        this.val = new float[16];
        set(vector3, quaternion, vector32);
    }

    public Matrix4 set(Matrix4 matrix4) {
        return set(matrix4.val);
    }

    public Matrix4 set(float[] fArr) {
        float[] fArr2 = this.val;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        return this;
    }

    public Matrix4 set(Quaternion quaternion) {
        return set(quaternion.f6115x, quaternion.f6116y, quaternion.f6117z, quaternion.f6114w);
    }

    public Matrix4 set(float f, float f2, float f3, float f4) {
        return set(0.0f, 0.0f, 0.0f, f, f2, f3, f4);
    }

    public Matrix4 set(Vector3 vector3, Quaternion quaternion) {
        return set(vector3.f6126x, vector3.f6127y, vector3.f6128z, quaternion.f6115x, quaternion.f6116y, quaternion.f6117z, quaternion.f6114w);
    }

    public Matrix4 set(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8 = f4 * 2.0f;
        float f9 = f5 * 2.0f;
        float f10 = 2.0f * f6;
        float f11 = f7 * f8;
        float f12 = f7 * f9;
        float f13 = f7 * f10;
        float f14 = f8 * f4;
        float f15 = f4 * f9;
        float f16 = f4 * f10;
        float f17 = f9 * f5;
        float f18 = f5 * f10;
        float f19 = f10 * f6;
        float[] fArr = this.val;
        fArr[0] = 1.0f - (f17 + f19);
        fArr[4] = f15 - f13;
        fArr[8] = f16 + f12;
        fArr[12] = f;
        fArr[1] = f15 + f13;
        fArr[5] = 1.0f - (f19 + f14);
        fArr[9] = f18 - f11;
        fArr[13] = f2;
        fArr[2] = f16 - f12;
        fArr[6] = f18 + f11;
        fArr[10] = 1.0f - (f14 + f17);
        fArr[14] = f3;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 set(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
        return set(vector3.f6126x, vector3.f6127y, vector3.f6128z, quaternion.f6115x, quaternion.f6116y, quaternion.f6117z, quaternion.f6114w, vector32.f6126x, vector32.f6127y, vector32.f6128z);
    }

    public Matrix4 set(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        float f11 = f4 * 2.0f;
        float f12 = f5 * 2.0f;
        float f13 = 2.0f * f6;
        float f14 = f7 * f11;
        float f15 = f7 * f12;
        float f16 = f7 * f13;
        float f17 = f11 * f4;
        float f18 = f4 * f12;
        float f19 = f4 * f13;
        float f20 = f12 * f5;
        float f21 = f5 * f13;
        float f22 = f13 * f6;
        float[] fArr = this.val;
        fArr[0] = (1.0f - (f20 + f22)) * f8;
        fArr[4] = (f18 - f16) * f9;
        fArr[8] = (f19 + f15) * f10;
        fArr[12] = f;
        fArr[1] = f8 * (f18 + f16);
        fArr[5] = (1.0f - (f22 + f17)) * f9;
        fArr[9] = (f21 - f14) * f10;
        fArr[13] = f2;
        fArr[2] = f8 * (f19 - f15);
        fArr[6] = f9 * (f21 + f14);
        fArr[10] = (1.0f - (f17 + f20)) * f10;
        fArr[14] = f3;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 set(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        this.val[0] = vector3.f6126x;
        this.val[4] = vector3.f6127y;
        this.val[8] = vector3.f6128z;
        this.val[1] = vector32.f6126x;
        this.val[5] = vector32.f6127y;
        this.val[9] = vector32.f6128z;
        this.val[2] = vector33.f6126x;
        this.val[6] = vector33.f6127y;
        this.val[10] = vector33.f6128z;
        this.val[12] = vector34.f6126x;
        this.val[13] = vector34.f6127y;
        this.val[14] = vector34.f6128z;
        float[] fArr = this.val;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 cpy() {
        return new Matrix4(this);
    }

    public Matrix4 trn(Vector3 vector3) {
        float[] fArr = this.val;
        fArr[12] = fArr[12] + vector3.f6126x;
        float[] fArr2 = this.val;
        fArr2[13] = fArr2[13] + vector3.f6127y;
        float[] fArr3 = this.val;
        fArr3[14] = fArr3[14] + vector3.f6128z;
        return this;
    }

    public Matrix4 trn(float f, float f2, float f3) {
        float[] fArr = this.val;
        fArr[12] = fArr[12] + f;
        fArr[13] = fArr[13] + f2;
        fArr[14] = fArr[14] + f3;
        return this;
    }

    public float[] getValues() {
        return this.val;
    }

    public Matrix4 mul(Matrix4 matrix4) {
        mul(this.val, matrix4.val);
        return this;
    }

    public Matrix4 mulLeft(Matrix4 matrix4) {
        tmpMat.set(matrix4);
        mul(tmpMat.val, this.val);
        return set(tmpMat);
    }

    public Matrix4 tra() {
        float[] fArr = f6111a;
        float[] fArr2 = this.val;
        fArr[0] = fArr2[0];
        fArr[4] = fArr2[1];
        fArr[8] = fArr2[2];
        fArr[12] = fArr2[3];
        fArr[1] = fArr2[4];
        fArr[5] = fArr2[5];
        fArr[9] = fArr2[6];
        fArr[13] = fArr2[7];
        fArr[2] = fArr2[8];
        fArr[6] = fArr2[9];
        fArr[10] = fArr2[10];
        fArr[14] = fArr2[11];
        fArr[3] = fArr2[12];
        fArr[7] = fArr2[13];
        fArr[11] = fArr2[14];
        fArr[15] = fArr2[15];
        return set(fArr);
    }

    public Matrix4 idt() {
        float[] fArr = this.val;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 inv() {
        float[] fArr = this.val;
        float f = (((((((((((((((((((((((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])) + (((fArr[1] * fArr[7]) * fArr[10]) * fArr[12])) + (((fArr[2] * fArr[5]) * fArr[11]) * fArr[12])) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])) + (((fArr[2] * fArr[7]) * fArr[8]) * fArr[13])) + (((fArr[3] * fArr[4]) * fArr[10]) * fArr[13])) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])) + (((fArr[0] * fArr[6]) * fArr[11]) * fArr[13])) + (((fArr[3] * fArr[5]) * fArr[8]) * fArr[14])) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])) + (((fArr[0] * fArr[7]) * fArr[9]) * fArr[14])) + (((fArr[1] * fArr[4]) * fArr[11]) * fArr[14])) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])) + (((fArr[1] * fArr[6]) * fArr[8]) * fArr[15])) + (((fArr[2] * fArr[4]) * fArr[9]) * fArr[15])) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[10] * fArr[15]);
        if (f == 0.0f) {
            throw new RuntimeException("non-invertible matrix");
        }
        float f2 = 1.0f / f;
        float[] fArr2 = f6111a;
        fArr2[0] = ((((((fArr[9] * fArr[14]) * fArr[7]) - ((fArr[13] * fArr[10]) * fArr[7])) + ((fArr[13] * fArr[6]) * fArr[11])) - ((fArr[5] * fArr[14]) * fArr[11])) - ((fArr[9] * fArr[6]) * fArr[15])) + (fArr[5] * fArr[10] * fArr[15]);
        fArr2[4] = ((((((fArr[12] * fArr[10]) * fArr[7]) - ((fArr[8] * fArr[14]) * fArr[7])) - ((fArr[12] * fArr[6]) * fArr[11])) + ((fArr[4] * fArr[14]) * fArr[11])) + ((fArr[8] * fArr[6]) * fArr[15])) - ((fArr[4] * fArr[10]) * fArr[15]);
        fArr2[8] = ((((((fArr[8] * fArr[13]) * fArr[7]) - ((fArr[12] * fArr[9]) * fArr[7])) + ((fArr[12] * fArr[5]) * fArr[11])) - ((fArr[4] * fArr[13]) * fArr[11])) - ((fArr[8] * fArr[5]) * fArr[15])) + (fArr[4] * fArr[9] * fArr[15]);
        fArr2[12] = ((((((fArr[12] * fArr[9]) * fArr[6]) - ((fArr[8] * fArr[13]) * fArr[6])) - ((fArr[12] * fArr[5]) * fArr[10])) + ((fArr[4] * fArr[13]) * fArr[10])) + ((fArr[8] * fArr[5]) * fArr[14])) - ((fArr[4] * fArr[9]) * fArr[14]);
        fArr2[1] = ((((((fArr[13] * fArr[10]) * fArr[3]) - ((fArr[9] * fArr[14]) * fArr[3])) - ((fArr[13] * fArr[2]) * fArr[11])) + ((fArr[1] * fArr[14]) * fArr[11])) + ((fArr[9] * fArr[2]) * fArr[15])) - ((fArr[1] * fArr[10]) * fArr[15]);
        fArr2[5] = ((((((fArr[8] * fArr[14]) * fArr[3]) - ((fArr[12] * fArr[10]) * fArr[3])) + ((fArr[12] * fArr[2]) * fArr[11])) - ((fArr[0] * fArr[14]) * fArr[11])) - ((fArr[8] * fArr[2]) * fArr[15])) + (fArr[0] * fArr[10] * fArr[15]);
        fArr2[9] = ((((((fArr[12] * fArr[9]) * fArr[3]) - ((fArr[8] * fArr[13]) * fArr[3])) - ((fArr[12] * fArr[1]) * fArr[11])) + ((fArr[0] * fArr[13]) * fArr[11])) + ((fArr[8] * fArr[1]) * fArr[15])) - ((fArr[0] * fArr[9]) * fArr[15]);
        fArr2[13] = ((((((fArr[8] * fArr[13]) * fArr[2]) - ((fArr[12] * fArr[9]) * fArr[2])) + ((fArr[12] * fArr[1]) * fArr[10])) - ((fArr[0] * fArr[13]) * fArr[10])) - ((fArr[8] * fArr[1]) * fArr[14])) + (fArr[0] * fArr[9] * fArr[14]);
        fArr2[2] = ((((((fArr[5] * fArr[14]) * fArr[3]) - ((fArr[13] * fArr[6]) * fArr[3])) + ((fArr[13] * fArr[2]) * fArr[7])) - ((fArr[1] * fArr[14]) * fArr[7])) - ((fArr[5] * fArr[2]) * fArr[15])) + (fArr[1] * fArr[6] * fArr[15]);
        fArr2[6] = ((((((fArr[12] * fArr[6]) * fArr[3]) - ((fArr[4] * fArr[14]) * fArr[3])) - ((fArr[12] * fArr[2]) * fArr[7])) + ((fArr[0] * fArr[14]) * fArr[7])) + ((fArr[4] * fArr[2]) * fArr[15])) - ((fArr[0] * fArr[6]) * fArr[15]);
        fArr2[10] = ((((((fArr[4] * fArr[13]) * fArr[3]) - ((fArr[12] * fArr[5]) * fArr[3])) + ((fArr[12] * fArr[1]) * fArr[7])) - ((fArr[0] * fArr[13]) * fArr[7])) - ((fArr[4] * fArr[1]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[15]);
        fArr2[14] = ((((((fArr[12] * fArr[5]) * fArr[2]) - ((fArr[4] * fArr[13]) * fArr[2])) - ((fArr[12] * fArr[1]) * fArr[6])) + ((fArr[0] * fArr[13]) * fArr[6])) + ((fArr[4] * fArr[1]) * fArr[14])) - ((fArr[0] * fArr[5]) * fArr[14]);
        fArr2[3] = ((((((fArr[9] * fArr[6]) * fArr[3]) - ((fArr[5] * fArr[10]) * fArr[3])) - ((fArr[9] * fArr[2]) * fArr[7])) + ((fArr[1] * fArr[10]) * fArr[7])) + ((fArr[5] * fArr[2]) * fArr[11])) - ((fArr[1] * fArr[6]) * fArr[11]);
        fArr2[7] = ((((((fArr[4] * fArr[10]) * fArr[3]) - ((fArr[8] * fArr[6]) * fArr[3])) + ((fArr[8] * fArr[2]) * fArr[7])) - ((fArr[0] * fArr[10]) * fArr[7])) - ((fArr[4] * fArr[2]) * fArr[11])) + (fArr[0] * fArr[6] * fArr[11]);
        fArr2[11] = ((((((fArr[8] * fArr[5]) * fArr[3]) - ((fArr[4] * fArr[9]) * fArr[3])) - ((fArr[8] * fArr[1]) * fArr[7])) + ((fArr[0] * fArr[9]) * fArr[7])) + ((fArr[4] * fArr[1]) * fArr[11])) - ((fArr[0] * fArr[5]) * fArr[11]);
        fArr2[15] = ((((((fArr[4] * fArr[9]) * fArr[2]) - ((fArr[8] * fArr[5]) * fArr[2])) + ((fArr[8] * fArr[1]) * fArr[6])) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10])) + (fArr[0] * fArr[5] * fArr[10]);
        fArr[0] = fArr2[0] * f2;
        fArr[4] = fArr2[4] * f2;
        fArr[8] = fArr2[8] * f2;
        fArr[12] = fArr2[12] * f2;
        fArr[1] = fArr2[1] * f2;
        fArr[5] = fArr2[5] * f2;
        fArr[9] = fArr2[9] * f2;
        fArr[13] = fArr2[13] * f2;
        fArr[2] = fArr2[2] * f2;
        fArr[6] = fArr2[6] * f2;
        fArr[10] = fArr2[10] * f2;
        fArr[14] = fArr2[14] * f2;
        fArr[3] = fArr2[3] * f2;
        fArr[7] = fArr2[7] * f2;
        fArr[11] = fArr2[11] * f2;
        fArr[15] = fArr2[15] * f2;
        return this;
    }

    public float det() {
        float[] fArr = this.val;
        return (((((((((((((((((((((((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])) + (((fArr[1] * fArr[7]) * fArr[10]) * fArr[12])) + (((fArr[2] * fArr[5]) * fArr[11]) * fArr[12])) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])) + (((fArr[2] * fArr[7]) * fArr[8]) * fArr[13])) + (((fArr[3] * fArr[4]) * fArr[10]) * fArr[13])) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])) + (((fArr[0] * fArr[6]) * fArr[11]) * fArr[13])) + (((fArr[3] * fArr[5]) * fArr[8]) * fArr[14])) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])) + (((fArr[0] * fArr[7]) * fArr[9]) * fArr[14])) + (((fArr[1] * fArr[4]) * fArr[11]) * fArr[14])) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])) + (((fArr[1] * fArr[6]) * fArr[8]) * fArr[15])) + (((fArr[2] * fArr[4]) * fArr[9]) * fArr[15])) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[10] * fArr[15]);
    }

    public float det3x3() {
        float[] fArr = this.val;
        return ((((((fArr[0] * fArr[5]) * fArr[10]) + ((fArr[4] * fArr[9]) * fArr[2])) + ((fArr[8] * fArr[1]) * fArr[6])) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10])) - ((fArr[8] * fArr[5]) * fArr[2]);
    }

    public Matrix4 setToProjection(float f, float f2, float f3, float f4) {
        idt();
        float tan = (float) (1.0d / Math.tan((f3 * 0.017453292519943295d) / 2.0d));
        float f5 = f - f2;
        float[] fArr = this.val;
        fArr[0] = tan / f4;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = tan;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (f2 + f) / f5;
        fArr[11] = -1.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = ((f2 * 2.0f) * f) / f5;
        fArr[15] = 0.0f;
        return this;
    }

    public Matrix4 setToProjection(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f5 * 2.0f;
        float f8 = f2 - f;
        float f9 = f4 - f3;
        float f10 = f5 - f6;
        float f11 = (f6 + f5) / f10;
        float f12 = ((f6 * 2.0f) * f5) / f10;
        float[] fArr = this.val;
        fArr[0] = f7 / f8;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = f7 / f9;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = (f2 + f) / f8;
        fArr[9] = (f4 + f3) / f9;
        fArr[10] = f11;
        fArr[11] = -1.0f;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = f12;
        fArr[15] = 0.0f;
        return this;
    }

    public Matrix4 setToOrtho2D(float f, float f2, float f3, float f4) {
        setToOrtho(f, f + f3, f2, f2 + f4, 0.0f, 1.0f);
        return this;
    }

    public Matrix4 setToOrtho2D(float f, float f2, float f3, float f4, float f5, float f6) {
        setToOrtho(f, f + f3, f2, f2 + f4, f5, f6);
        return this;
    }

    public Matrix4 setToOrtho(float f, float f2, float f3, float f4, float f5, float f6) {
        idt();
        float f7 = f2 - f;
        float f8 = f4 - f3;
        float f9 = f6 - f5;
        float[] fArr = this.val;
        fArr[0] = 2.0f / f7;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 2.0f / f8;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 0.0f;
        fArr[9] = 0.0f;
        fArr[10] = (-2.0f) / f9;
        fArr[11] = 0.0f;
        fArr[12] = (-(f2 + f)) / f7;
        fArr[13] = (-(f4 + f3)) / f8;
        fArr[14] = (-(f6 + f5)) / f9;
        fArr[15] = 1.0f;
        return this;
    }

    public Matrix4 setTranslation(Vector3 vector3) {
        this.val[12] = vector3.f6126x;
        this.val[13] = vector3.f6127y;
        this.val[14] = vector3.f6128z;
        return this;
    }

    public Matrix4 setTranslation(float f, float f2, float f3) {
        float[] fArr = this.val;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
        return this;
    }

    public Matrix4 setToTranslation(Vector3 vector3) {
        idt();
        this.val[12] = vector3.f6126x;
        this.val[13] = vector3.f6127y;
        this.val[14] = vector3.f6128z;
        return this;
    }

    public Matrix4 setToTranslation(float f, float f2, float f3) {
        idt();
        float[] fArr = this.val;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
        return this;
    }

    public Matrix4 setToTranslationAndScaling(Vector3 vector3, Vector3 vector32) {
        idt();
        this.val[12] = vector3.f6126x;
        this.val[13] = vector3.f6127y;
        this.val[14] = vector3.f6128z;
        this.val[0] = vector32.f6126x;
        this.val[5] = vector32.f6127y;
        this.val[10] = vector32.f6128z;
        return this;
    }

    public Matrix4 setToTranslationAndScaling(float f, float f2, float f3, float f4, float f5, float f6) {
        idt();
        float[] fArr = this.val;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
        fArr[0] = f4;
        fArr[5] = f5;
        fArr[10] = f6;
        return this;
    }

    public Matrix4 setToRotation(Vector3 vector3, float f) {
        if (f == 0.0f) {
            idt();
            return this;
        }
        return set(quat.set(vector3, f));
    }

    public Matrix4 setToRotationRad(Vector3 vector3, float f) {
        if (f == 0.0f) {
            idt();
            return this;
        }
        return set(quat.setFromAxisRad(vector3, f));
    }

    public Matrix4 setToRotation(float f, float f2, float f3, float f4) {
        if (f4 == 0.0f) {
            idt();
            return this;
        }
        return set(quat.setFromAxis(f, f2, f3, f4));
    }

    public Matrix4 setToRotationRad(float f, float f2, float f3, float f4) {
        if (f4 == 0.0f) {
            idt();
            return this;
        }
        return set(quat.setFromAxisRad(f, f2, f3, f4));
    }

    public Matrix4 setToRotation(Vector3 vector3, Vector3 vector32) {
        return set(quat.setFromCross(vector3, vector32));
    }

    public Matrix4 setToRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        return set(quat.setFromCross(f, f2, f3, f4, f5, f6));
    }

    public Matrix4 setFromEulerAngles(float f, float f2, float f3) {
        quat.setEulerAngles(f, f2, f3);
        return set(quat);
    }

    public Matrix4 setFromEulerAnglesRad(float f, float f2, float f3) {
        quat.setEulerAnglesRad(f, f2, f3);
        return set(quat);
    }

    public Matrix4 setToScaling(Vector3 vector3) {
        idt();
        this.val[0] = vector3.f6126x;
        this.val[5] = vector3.f6127y;
        this.val[10] = vector3.f6128z;
        return this;
    }

    public Matrix4 setToScaling(float f, float f2, float f3) {
        idt();
        float[] fArr = this.val;
        fArr[0] = f;
        fArr[5] = f2;
        fArr[10] = f3;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32) {
        l_vez.set(vector3).m13114nor();
        l_vex.set(vector3).m13114nor();
        l_vex.crs(vector32).m13114nor();
        l_vey.set(l_vex).crs(l_vez).m13114nor();
        idt();
        this.val[0] = l_vex.f6126x;
        this.val[4] = l_vex.f6127y;
        this.val[8] = l_vex.f6128z;
        this.val[1] = l_vey.f6126x;
        this.val[5] = l_vey.f6127y;
        this.val[9] = l_vey.f6128z;
        this.val[2] = -l_vez.f6126x;
        this.val[6] = -l_vez.f6127y;
        this.val[10] = -l_vez.f6128z;
        return this;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        tmpVec.set(vector32).sub(vector3);
        setToLookAt(tmpVec, vector33);
        mul(tmpMat.setToTranslation(-vector3.f6126x, -vector3.f6127y, -vector3.f6128z));
        return this;
    }

    public Matrix4 setToWorld(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        tmpForward.set(vector32).m13114nor();
        right.set(tmpForward).crs(vector33).m13114nor();
        tmpUp.set(right).crs(tmpForward).m13114nor();
        set(right, tmpUp, tmpForward.m13115scl(-1.0f), vector3);
        return this;
    }

    public String toString() {
        return "[" + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
    }

    public Matrix4 lerp(Matrix4 matrix4, float f) {
        for (int i = 0; i < 16; i++) {
            float[] fArr = this.val;
            fArr[i] = (fArr[i] * (1.0f - f)) + (matrix4.val[i] * f);
        }
        return this;
    }

    public Matrix4 avg(Matrix4 matrix4, float f) {
        getScale(tmpVec);
        matrix4.getScale(tmpForward);
        getRotation(quat);
        matrix4.getRotation(quat2);
        getTranslation(tmpUp);
        matrix4.getTranslation(right);
        float f2 = 1.0f - f;
        setToScaling(tmpVec.m13115scl(f).add(tmpForward.m13115scl(f2)));
        rotate(quat.slerp(quat2, f2));
        setTranslation(tmpUp.m13115scl(f).add(right.m13115scl(f2)));
        return this;
    }

    public Matrix4 avg(Matrix4[] matrix4Arr) {
        float length = 1.0f / matrix4Arr.length;
        tmpVec.set(matrix4Arr[0].getScale(tmpUp).m13115scl(length));
        quat.set(matrix4Arr[0].getRotation(quat2).exp(length));
        tmpForward.set(matrix4Arr[0].getTranslation(tmpUp).m13115scl(length));
        for (int i = 1; i < matrix4Arr.length; i++) {
            tmpVec.add(matrix4Arr[i].getScale(tmpUp).m13115scl(length));
            quat.mul(matrix4Arr[i].getRotation(quat2).exp(length));
            tmpForward.add(matrix4Arr[i].getTranslation(tmpUp).m13115scl(length));
        }
        quat.nor();
        setToScaling(tmpVec);
        rotate(quat);
        setTranslation(tmpForward);
        return this;
    }

    public Matrix4 avg(Matrix4[] matrix4Arr, float[] fArr) {
        tmpVec.set(matrix4Arr[0].getScale(tmpUp).m13115scl(fArr[0]));
        quat.set(matrix4Arr[0].getRotation(quat2).exp(fArr[0]));
        tmpForward.set(matrix4Arr[0].getTranslation(tmpUp).m13115scl(fArr[0]));
        for (int i = 1; i < matrix4Arr.length; i++) {
            tmpVec.add(matrix4Arr[i].getScale(tmpUp).m13115scl(fArr[i]));
            quat.mul(matrix4Arr[i].getRotation(quat2).exp(fArr[i]));
            tmpForward.add(matrix4Arr[i].getTranslation(tmpUp).m13115scl(fArr[i]));
        }
        quat.nor();
        setToScaling(tmpVec);
        rotate(quat);
        setTranslation(tmpForward);
        return this;
    }

    public Matrix4 set(Matrix3 matrix3) {
        this.val[0] = matrix3.val[0];
        this.val[1] = matrix3.val[1];
        this.val[2] = matrix3.val[2];
        float[] fArr = this.val;
        fArr[3] = 0.0f;
        fArr[4] = matrix3.val[3];
        this.val[5] = matrix3.val[4];
        this.val[6] = matrix3.val[5];
        float[] fArr2 = this.val;
        fArr2[7] = 0.0f;
        fArr2[8] = 0.0f;
        fArr2[9] = 0.0f;
        fArr2[10] = 1.0f;
        fArr2[11] = 0.0f;
        fArr2[12] = matrix3.val[6];
        this.val[13] = matrix3.val[7];
        float[] fArr3 = this.val;
        fArr3[14] = 0.0f;
        fArr3[15] = matrix3.val[8];
        return this;
    }

    public Matrix4 set(Affine2 affine2) {
        this.val[0] = affine2.m00;
        this.val[1] = affine2.m10;
        float[] fArr = this.val;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = affine2.m01;
        this.val[5] = affine2.m11;
        float[] fArr2 = this.val;
        fArr2[6] = 0.0f;
        fArr2[7] = 0.0f;
        fArr2[8] = 0.0f;
        fArr2[9] = 0.0f;
        fArr2[10] = 1.0f;
        fArr2[11] = 0.0f;
        fArr2[12] = affine2.m02;
        this.val[13] = affine2.m12;
        float[] fArr3 = this.val;
        fArr3[14] = 0.0f;
        fArr3[15] = 1.0f;
        return this;
    }

    public Matrix4 setAsAffine(Affine2 affine2) {
        this.val[0] = affine2.m00;
        this.val[1] = affine2.m10;
        this.val[4] = affine2.m01;
        this.val[5] = affine2.m11;
        this.val[12] = affine2.m02;
        this.val[13] = affine2.m12;
        return this;
    }

    public Matrix4 setAsAffine(Matrix4 matrix4) {
        float[] fArr = this.val;
        float[] fArr2 = matrix4.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[4] = fArr2[4];
        fArr[5] = fArr2[5];
        fArr[12] = fArr2[12];
        fArr[13] = fArr2[13];
        return this;
    }

    public Matrix4 scl(Vector3 vector3) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * vector3.f6126x;
        float[] fArr2 = this.val;
        fArr2[5] = fArr2[5] * vector3.f6127y;
        float[] fArr3 = this.val;
        fArr3[10] = fArr3[10] * vector3.f6128z;
        return this;
    }

    public Matrix4 scl(float f, float f2, float f3) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * f;
        fArr[5] = fArr[5] * f2;
        fArr[10] = fArr[10] * f3;
        return this;
    }

    public Matrix4 scl(float f) {
        float[] fArr = this.val;
        fArr[0] = fArr[0] * f;
        fArr[5] = fArr[5] * f;
        fArr[10] = fArr[10] * f;
        return this;
    }

    public Vector3 getTranslation(Vector3 vector3) {
        float[] fArr = this.val;
        vector3.f6126x = fArr[12];
        vector3.f6127y = fArr[13];
        vector3.f6128z = fArr[14];
        return vector3;
    }

    public Quaternion getRotation(Quaternion quaternion, boolean z) {
        return quaternion.setFromMatrix(z, this);
    }

    public Quaternion getRotation(Quaternion quaternion) {
        return quaternion.setFromMatrix(this);
    }

    public float getScaleXSquared() {
        float[] fArr = this.val;
        return (fArr[0] * fArr[0]) + (fArr[4] * fArr[4]) + (fArr[8] * fArr[8]);
    }

    public float getScaleYSquared() {
        float[] fArr = this.val;
        return (fArr[1] * fArr[1]) + (fArr[5] * fArr[5]) + (fArr[9] * fArr[9]);
    }

    public float getScaleZSquared() {
        float[] fArr = this.val;
        return (fArr[2] * fArr[2]) + (fArr[6] * fArr[6]) + (fArr[10] * fArr[10]);
    }

    public float getScaleX() {
        return (C2090b.m6569e(this.val[4]) && C2090b.m6569e(this.val[8])) ? Math.abs(this.val[0]) : (float) Math.sqrt(getScaleXSquared());
    }

    public float getScaleY() {
        return (C2090b.m6569e(this.val[1]) && C2090b.m6569e(this.val[9])) ? Math.abs(this.val[5]) : (float) Math.sqrt(getScaleYSquared());
    }

    public float getScaleZ() {
        return (C2090b.m6569e(this.val[2]) && C2090b.m6569e(this.val[6])) ? Math.abs(this.val[10]) : (float) Math.sqrt(getScaleZSquared());
    }

    public Vector3 getScale(Vector3 vector3) {
        return vector3.set(getScaleX(), getScaleY(), getScaleZ());
    }

    public Matrix4 toNormalMatrix() {
        float[] fArr = this.val;
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        return inv().tra();
    }

    public Matrix4 translate(Vector3 vector3) {
        return translate(vector3.f6126x, vector3.f6127y, vector3.f6128z);
    }

    public Matrix4 translate(float f, float f2, float f3) {
        float[] fArr = f6111a;
        fArr[0] = 1.0f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = f;
        fArr[1] = 0.0f;
        fArr[5] = 1.0f;
        fArr[9] = 0.0f;
        fArr[13] = f2;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = 1.0f;
        fArr[14] = f3;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        mul(this.val, fArr);
        return this;
    }

    public Matrix4 rotate(Vector3 vector3, float f) {
        if (f == 0.0f) {
            return this;
        }
        quat.set(vector3, f);
        return rotate(quat);
    }

    public Matrix4 rotateRad(Vector3 vector3, float f) {
        if (f == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(vector3, f);
        return rotate(quat);
    }

    public Matrix4 rotate(float f, float f2, float f3, float f4) {
        if (f4 == 0.0f) {
            return this;
        }
        quat.setFromAxis(f, f2, f3, f4);
        return rotate(quat);
    }

    public Matrix4 rotateRad(float f, float f2, float f3, float f4) {
        if (f4 == 0.0f) {
            return this;
        }
        quat.setFromAxisRad(f, f2, f3, f4);
        return rotate(quat);
    }

    public Matrix4 rotate(Quaternion quaternion) {
        quaternion.toMatrix(f6111a);
        mul(this.val, f6111a);
        return this;
    }

    public Matrix4 rotate(Vector3 vector3, Vector3 vector32) {
        return rotate(quat.setFromCross(vector3, vector32));
    }

    public Matrix4 scale(float f, float f2, float f3) {
        float[] fArr = f6111a;
        fArr[0] = f;
        fArr[4] = 0.0f;
        fArr[8] = 0.0f;
        fArr[12] = 0.0f;
        fArr[1] = 0.0f;
        fArr[5] = f2;
        fArr[9] = 0.0f;
        fArr[13] = 0.0f;
        fArr[2] = 0.0f;
        fArr[6] = 0.0f;
        fArr[10] = f3;
        fArr[14] = 0.0f;
        fArr[3] = 0.0f;
        fArr[7] = 0.0f;
        fArr[11] = 0.0f;
        fArr[15] = 1.0f;
        mul(this.val, fArr);
        return this;
    }

    public void extract4x3Matrix(float[] fArr) {
        float[] fArr2 = this.val;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = fArr2[4];
        fArr[4] = fArr2[5];
        fArr[5] = fArr2[6];
        fArr[6] = fArr2[8];
        fArr[7] = fArr2[9];
        fArr[8] = fArr2[10];
        fArr[9] = fArr2[12];
        fArr[10] = fArr2[13];
        fArr[11] = fArr2[14];
    }

    public boolean hasRotationOrScaling() {
        return (C2090b.m6570d(this.val[0], 1.0f) && C2090b.m6570d(this.val[5], 1.0f) && C2090b.m6570d(this.val[10], 1.0f) && C2090b.m6569e(this.val[4]) && C2090b.m6569e(this.val[8]) && C2090b.m6569e(this.val[1]) && C2090b.m6569e(this.val[9]) && C2090b.m6569e(this.val[2]) && C2090b.m6569e(this.val[6])) ? false : true;
    }
}
