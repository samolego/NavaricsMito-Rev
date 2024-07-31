package com.navatics.common.base;

/* loaded from: classes.dex */
public class DiveLogEntry {
    float airTemperature;
    int batteryState;
    int buoyBattery;
    float buoyLatitude;
    float buoyLongitude;
    long currentTime;
    int ledState;
    int phoneBattery;
    float phoneLatitude;
    float phoneLongitude;
    int refStateDepth;
    short refStateQuaternionW;
    short refStateQuaternionX;
    short refStateQuaternionY;
    short refStateQuaternionZ;
    int remoteBattery;
    boolean remoteLinkState;
    int remotePER;
    int remoteRSSI;
    int remoteSNR;
    int robotOperationState;
    short rpmMotor0;
    short rpmMotor1;
    short rpmMotor2;
    short rpmMotor3;
    int sensorsState;
    int stateDepth;
    short stateQuaternionW;
    short stateQuaternionX;
    short stateQuaternionY;
    short stateQuaternionZ;
    int temperature;
    float waterTemperature;
    float windDirection;
    float windVelocity;

    public long getCurrentTime() {
        return this.currentTime;
    }

    public void setCurrentTime(long j) {
        this.currentTime = j;
    }

    public float getAirTemperature() {
        return this.airTemperature;
    }

    public void setAirTemperature(float f) {
        this.airTemperature = f;
    }

    public float getWaterTemperature() {
        return this.waterTemperature;
    }

    public void setWaterTemperature(float f) {
        this.waterTemperature = f;
    }

    public float getWindVelocity() {
        return this.windVelocity;
    }

    public void setWindVelocity(float f) {
        this.windVelocity = f;
    }

    public float getWindDirection() {
        return this.windDirection;
    }

    public void setWindDirection(float f) {
        this.windDirection = f;
    }

    public float getBuoyLongitude() {
        return this.buoyLongitude;
    }

    public void setBuoyLongitude(float f) {
        this.buoyLongitude = f;
    }

    public float getBuoyLatitude() {
        return this.buoyLatitude;
    }

    public void setBuoyLatitude(float f) {
        this.buoyLatitude = f;
    }

    public float getPhoneLongitude() {
        return this.phoneLongitude;
    }

    public void setPhoneLongitude(float f) {
        this.phoneLongitude = f;
    }

    public float getPhoneLatitude() {
        return this.phoneLatitude;
    }

    public void setPhoneLatitude(float f) {
        this.phoneLatitude = f;
    }

    public short getStateQuaternionW() {
        return this.stateQuaternionW;
    }

    public void setStateQuaternionW(short s) {
        this.stateQuaternionW = s;
    }

    public short getStateQuaternionX() {
        return this.stateQuaternionX;
    }

    public void setStateQuaternionX(short s) {
        this.stateQuaternionX = s;
    }

    public short getStateQuaternionY() {
        return this.stateQuaternionY;
    }

    public void setStateQuaternionY(short s) {
        this.stateQuaternionY = s;
    }

    public short getStateQuaternionZ() {
        return this.stateQuaternionZ;
    }

    public void setStateQuaternionZ(short s) {
        this.stateQuaternionZ = s;
    }

    public short getRefStateQuaternionW() {
        return this.refStateQuaternionW;
    }

    public void setRefStateQuaternionW(short s) {
        this.refStateQuaternionW = s;
    }

    public short getRefStateQuaternionX() {
        return this.refStateQuaternionX;
    }

    public void setRefStateQuaternionX(short s) {
        this.refStateQuaternionX = s;
    }

    public short getRefStateQuaternionY() {
        return this.refStateQuaternionY;
    }

    public void setRefStateQuaternionY(short s) {
        this.refStateQuaternionY = s;
    }

    public short getRefStateQuaternionZ() {
        return this.refStateQuaternionZ;
    }

    public void setRefStateQuaternionZ(short s) {
        this.refStateQuaternionZ = s;
    }

    public int getStateDepth() {
        return this.stateDepth;
    }

    public void setStateDepth(int i) {
        this.stateDepth = i;
    }

    public int getRefStateDepth() {
        return this.refStateDepth;
    }

    public void setRefStateDepth(int i) {
        this.refStateDepth = i;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public void setTemperature(int i) {
        this.temperature = i;
    }

    public short getRpmMotor0() {
        return this.rpmMotor0;
    }

    public void setRpmMotor0(short s) {
        this.rpmMotor0 = s;
    }

    public short getRpmMotor1() {
        return this.rpmMotor1;
    }

    public void setRpmMotor1(short s) {
        this.rpmMotor1 = s;
    }

    public short getRpmMotor2() {
        return this.rpmMotor2;
    }

    public void setRpmMotor2(short s) {
        this.rpmMotor2 = s;
    }

    public short getRpmMotor3() {
        return this.rpmMotor3;
    }

    public void setRpmMotor3(short s) {
        this.rpmMotor3 = s;
    }

    public int getLedState() {
        return this.ledState;
    }

    public void setLedState(int i) {
        this.ledState = i;
    }

    public int getBatteryState() {
        return this.batteryState;
    }

    public void setBatteryState(int i) {
        this.batteryState = i;
    }

    public int getSensorsState() {
        return this.sensorsState;
    }

    public void setSensorsState(int i) {
        this.sensorsState = i;
    }

    public int getRobotOperationState() {
        return this.robotOperationState;
    }

    public void setRobotOperationState(int i) {
        this.robotOperationState = i;
    }

    public int getRemoteBattery() {
        return this.remoteBattery;
    }

    public void setRemoteBattery(int i) {
        this.remoteBattery = i;
    }

    public int getBuoyBattery() {
        return this.buoyBattery;
    }

    public void setBuoyBattery(int i) {
        this.buoyBattery = i;
    }

    public int getPhoneBattery() {
        return this.phoneBattery;
    }

    public void setPhoneBattery(int i) {
        this.phoneBattery = i;
    }

    public boolean isRemoteLinkState() {
        return this.remoteLinkState;
    }

    public void setRemoteLinkState(boolean z) {
        this.remoteLinkState = z;
    }

    public int getRemotePER() {
        return this.remotePER;
    }

    public void setRemotePER(int i) {
        this.remotePER = i;
    }

    public int getRemoteRSSI() {
        return this.remoteRSSI;
    }

    public void setRemoteRSSI(int i) {
        this.remoteRSSI = i;
    }

    public int getRemoteSNR() {
        return this.remoteSNR;
    }

    public void setRemoteSNR(int i) {
        this.remoteSNR = i;
    }
}
