package com.example.divelog.dao.entity;

import com.navatics.robot.utils.StringUtils;
import java.io.Serializable;

/* loaded from: classes.dex */
public class DiveLogItem implements Serializable {
    float airTemperature;
    int batteryState;
    int buoyBattery;
    float buoyLatitude;
    float buoyLongitude;
    long currentTime;

    /* renamed from: id */
    transient long f1419id;
    String index;
    int ledState;
    String modityTime;
    int phoneBattery;
    float phoneLatitude;
    float phoneLongitude;
    String photoUri;
    int refStateDepth;
    short refStateQuaternionW;
    short refStateQuaternionX;
    short refStateQuaternionY;
    short refStateQuaternionZ;
    int remoteBattery;
    int remoteLinkState;
    int remotePER;
    int remoteRSSI;
    int remoteSNR;
    int robotOperationState;
    short rpmMotor0;
    short rpmMotor1;
    short rpmMotor2;
    short rpmMotor3;
    int sensorsState;
    String startTime;
    int stateDepth;
    short stateQuaternionW;
    short stateQuaternionX;
    short stateQuaternionY;
    short stateQuaternionZ;
    int temperature;
    float waterTemperature;
    String weather;
    float windDirection;
    float windVelocity;

    public String getIndex() {
        return this.index;
    }

    public void setIndex(String str) {
        this.index = str;
    }

    public String getModityTime() {
        return this.modityTime;
    }

    public void setModityTime(String str) {
        this.modityTime = str;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String str) {
        this.startTime = str;
    }

    public DiveLogItem() {
    }

    public DiveLogItem(long j, long j2, float f, float f2, String str, float f3, float f4, float f5, float f6, float f7, float f8, short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8, int i, int i2, int i3, short s9, short s10, short s11, short s12, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, long j3) {
        this.f1419id = j;
        this.currentTime = j2;
        this.airTemperature = f;
        this.waterTemperature = f2;
        this.weather = str;
        this.windVelocity = f3;
        this.windDirection = f4;
        this.buoyLongitude = f5;
        this.buoyLatitude = f6;
        this.phoneLongitude = f7;
        this.phoneLatitude = f8;
        this.stateQuaternionW = s;
        this.stateQuaternionX = s2;
        this.stateQuaternionY = s3;
        this.stateQuaternionZ = s4;
        this.refStateQuaternionW = s5;
        this.refStateQuaternionX = s6;
        this.refStateQuaternionY = s7;
        this.refStateQuaternionZ = s8;
        this.temperature = i;
        this.stateDepth = i2;
        this.refStateDepth = i3;
        this.rpmMotor0 = s9;
        this.rpmMotor1 = s10;
        this.rpmMotor2 = s11;
        this.rpmMotor3 = s12;
        this.ledState = i4;
        this.batteryState = i5;
        this.sensorsState = i6;
        this.robotOperationState = i7;
        this.remoteBattery = i8;
        this.buoyBattery = i9;
        this.phoneBattery = i10;
        this.remoteLinkState = i11;
        this.remotePER = i12;
        this.remotePER = i13;
        this.remotePER = i14;
    }

    public long getId() {
        return this.f1419id;
    }

    public void setId(long j) {
        this.f1419id = j;
    }

    public long getTimestamp() {
        return this.currentTime;
    }

    public void setTimestamp(long j) {
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

    public String getWeather() {
        return this.weather;
    }

    public void setWeather(String str) {
        this.weather = str;
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
        if (getWaterTemperature() != 0.0f) {
            return (int) this.waterTemperature;
        }
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

    public int getRemoteLinkState() {
        return this.remoteLinkState;
    }

    public void setRemoteLinkState(int i) {
        this.remoteLinkState = i;
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

    public String getPhotoUri() {
        return this.photoUri;
    }

    public void setPhotoUri(String str) {
        this.photoUri = str;
    }

    public void update(DiveLogItem diveLogItem) {
        if (diveLogItem != null) {
            if (!StringUtils.isEmpty((CharSequence) diveLogItem.getModityTime())) {
                this.modityTime = diveLogItem.getModityTime();
            }
            if (!StringUtils.isEmpty((CharSequence) diveLogItem.getPhotoUri())) {
                this.photoUri = diveLogItem.getPhotoUri();
            }
            if (StringUtils.isEmpty((CharSequence) diveLogItem.getWeather())) {
                return;
            }
            this.weather = diveLogItem.getWeather();
        }
    }
}