package com.senseplay.control.model;

/* loaded from: classes2.dex */
public class VechileInfo {
    private int brake;
    private int curSpeed;
    private String majorGear = "";
    private int minorGear;
    private int motorRotateSpeed;
    private float steerAngle;
    private int throttle;
    private int warning;

    public int getCurSpeed() {
        return this.curSpeed;
    }

    public void setCurSpeed(int i) {
        this.curSpeed = i;
    }

    public String getMajorGear() {
        return this.majorGear;
    }

    public void setMajorGear(String str) {
        this.majorGear = str;
    }

    public int getMinorGear() {
        return this.minorGear;
    }

    public void setMinorGear(int i) {
        this.minorGear = i;
    }

    public float getSteerAngle() {
        return this.steerAngle;
    }

    public void setSteerAngle(float f) {
        this.steerAngle = f;
    }

    public int getThrottle() {
        return this.throttle;
    }

    public void setThrottle(int i) {
        this.throttle = i;
    }

    public int getBrake() {
        return this.brake;
    }

    public void setBrake(int i) {
        this.brake = i;
    }

    public int getMotorRotateSpeed() {
        return this.motorRotateSpeed;
    }

    public void setMotorRotateSpeed(int i) {
        this.motorRotateSpeed = i;
    }

    public int getWarning() {
        return this.warning;
    }

    public void setWarning(int i) {
        this.warning = i;
    }
}