package com.common;

import android.util.Log;

/* loaded from: classes.dex */
public class SP_IMU_DATA {
    public float EulerianAngles_P;
    public float EulerianAngles_R;
    public float EulerianAngles_Y;
    public float QuaternionQ0;
    public float QuaternionQ1;
    public float QuaternionQ2;
    public float QuaternionQ3;
    public IMU_DATA_TYPE Type;
    private String tag = "HDR_N";

    public void fill(byte b, float[] fArr) {
        if (b == 0) {
            this.Type = IMU_DATA_TYPE.QUATERNION;
        } else if (1 == b) {
            this.Type = IMU_DATA_TYPE.EULERIAN_ANGLES;
        }
        this.QuaternionQ0 = fArr[0];
        this.QuaternionQ1 = fArr[1];
        this.QuaternionQ2 = fArr[2];
        this.QuaternionQ3 = fArr[3];
        this.EulerianAngles_P = fArr[4];
        this.EulerianAngles_Y = fArr[5];
        this.EulerianAngles_R = fArr[6];
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[TYPE :  " + this.Type);
        if (this.Type == IMU_DATA_TYPE.EULERIAN_ANGLES) {
            sb.append("] [P:  " + this.EulerianAngles_P);
            sb.append("] [Y:  " + this.EulerianAngles_Y);
            sb.append("] [R:  " + this.EulerianAngles_R + " ]");
        } else if (this.Type == IMU_DATA_TYPE.QUATERNION) {
            sb.append("] [Q0:  " + this.QuaternionQ0);
            sb.append("] [Q1:  " + this.QuaternionQ1);
            sb.append("] [Q2:  " + this.QuaternionQ2);
            sb.append("] [Q3:  " + this.QuaternionQ3 + " ]");
        }
        Log.e(this.tag, sb.toString());
    }
}