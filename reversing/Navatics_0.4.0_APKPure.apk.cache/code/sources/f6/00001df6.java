package com.senseplay.sdk.model.gps;

/* loaded from: classes2.dex */
public class IMUData {
    public float EulerianAngles_P;
    public float EulerianAngles_R;
    public float EulerianAngles_Y;
    public float QuaternionQ0;
    public float QuaternionQ1;
    public float QuaternionQ2;
    public float QuaternionQ3;
    public int type;

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public float getQuaternionQ0() {
        return this.QuaternionQ0;
    }

    public void setQuaternionQ0(float f) {
        this.QuaternionQ0 = f;
    }

    public float getQuaternionQ1() {
        return this.QuaternionQ1;
    }

    public void setQuaternionQ1(float f) {
        this.QuaternionQ1 = f;
    }

    public float getQuaternionQ2() {
        return this.QuaternionQ2;
    }

    public void setQuaternionQ2(float f) {
        this.QuaternionQ2 = f;
    }

    public float getQuaternionQ3() {
        return this.QuaternionQ3;
    }

    public void setQuaternionQ3(float f) {
        this.QuaternionQ3 = f;
    }

    public float getEulerianAngles_P() {
        return this.EulerianAngles_P;
    }

    public void setEulerianAngles_P(float f) {
        this.EulerianAngles_P = f;
    }

    public float getEulerianAngles_Y() {
        return this.EulerianAngles_Y;
    }

    public void setEulerianAngles_Y(float f) {
        this.EulerianAngles_Y = f;
    }

    public float getEulerianAngles_R() {
        return this.EulerianAngles_R;
    }

    public void setEulerianAngles_R(float f) {
        this.EulerianAngles_R = f;
    }
}