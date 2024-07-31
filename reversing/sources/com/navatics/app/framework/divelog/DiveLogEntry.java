package com.navatics.app.framework.divelog;

import com.example.divelog.dao.entity.DiveLogItem;
import io.objectbox.BoxStore;
import io.objectbox.annotation.Entity;
import io.objectbox.annotation.InterfaceC2825Id;
import io.objectbox.relation.ToOne;

@Entity
/* loaded from: classes.dex */
public class DiveLogEntry {
    transient BoxStore __boxStore;
    float airTemperature;
    int batteryState;
    int buoyBattery;
    float buoyLatitude;
    float buoyLongitude;
    String detailIndex;
    @InterfaceC2825Id

    /* renamed from: id */
    long f4353id;
    int ledState;
    public ToOne<DiveLog> parent = new ToOne<>(this, DiveLogEntry_.parent);
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
    long timestamp;
    float waterTemperature;
    String weather;
    float windDirection;
    float windVelocity;

    public DiveLogEntry() {
    }

    public DiveLogEntry(long j, long j2, float f, float f2, String str, float f3, float f4, float f5, float f6, float f7, float f8, short s, short s2, short s3, short s4, short s5, short s6, short s7, short s8, int i, int i2, int i3, short s9, short s10, short s11, short s12, int i4, int i5, int i6, int i7, int i8, int i9, int i10, boolean z, int i11, int i12, int i13, long j3) {
        this.f4353id = j;
        this.timestamp = j2;
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
        this.remoteLinkState = z;
        this.remotePER = i11;
        this.remotePER = i12;
        this.remotePER = i13;
        this.parent.setTargetId(j3);
    }

    public String getDetailIndex() {
        return this.detailIndex;
    }

    public void setDetailIndex(String str) {
        this.detailIndex = str;
    }

    public long getId() {
        return this.f4353id;
    }

    public void setId(long j) {
        this.f4353id = j;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
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

    public boolean getRemoteLinkState() {
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

    public String getPhotoUri() {
        return this.photoUri;
    }

    public void setPhotoUri(String str) {
        this.photoUri = str;
    }

    public DiveLogItem buildDivelogItem(String str, String str2) {
        DiveLogItem diveLogItem = new DiveLogItem();
        diveLogItem.setStartTime(str);
        diveLogItem.setIndex(str2);
        diveLogItem.setId(this.f4353id);
        diveLogItem.setWeather(this.weather);
        diveLogItem.setAirTemperature(this.airTemperature);
        diveLogItem.setBatteryState(this.batteryState);
        diveLogItem.setBuoyBattery(this.buoyBattery);
        diveLogItem.setBuoyLatitude(this.buoyLatitude);
        diveLogItem.setBuoyLongitude(this.buoyLongitude);
        diveLogItem.setLedState(this.ledState);
        diveLogItem.setPhoneBattery(this.phoneBattery);
        diveLogItem.setPhoneLatitude(this.phoneLatitude);
        diveLogItem.setPhoneLongitude(this.phoneLongitude);
        diveLogItem.setPhotoUri(this.photoUri);
        diveLogItem.setRefStateDepth(this.refStateDepth);
        diveLogItem.setRefStateQuaternionW(this.refStateQuaternionW);
        diveLogItem.setRefStateQuaternionX(this.refStateQuaternionX);
        diveLogItem.setRefStateQuaternionY(this.refStateQuaternionY);
        diveLogItem.setRefStateQuaternionZ(this.refStateQuaternionZ);
        diveLogItem.setRemoteBattery(this.remoteBattery);
        if (this.remoteLinkState) {
            diveLogItem.setRemoteLinkState(1);
        } else {
            diveLogItem.setRemoteLinkState(0);
        }
        diveLogItem.setRemotePER(this.remotePER);
        diveLogItem.setRemoteRSSI(this.remoteRSSI);
        diveLogItem.setRemoteSNR(this.remoteSNR);
        diveLogItem.setRobotOperationState(this.robotOperationState);
        diveLogItem.setRpmMotor0(this.rpmMotor0);
        diveLogItem.setRpmMotor1(this.rpmMotor1);
        diveLogItem.setRpmMotor2(this.rpmMotor2);
        diveLogItem.setRpmMotor3(this.rpmMotor3);
        diveLogItem.setSensorsState(this.sensorsState);
        diveLogItem.setStateDepth(this.stateDepth);
        diveLogItem.setLedState(this.ledState);
        diveLogItem.setStateQuaternionW(this.stateQuaternionW);
        diveLogItem.setStateQuaternionX(this.stateQuaternionX);
        diveLogItem.setStateQuaternionY(this.stateQuaternionY);
        diveLogItem.setStateQuaternionZ(this.stateQuaternionZ);
        diveLogItem.setTemperature(this.temperature);
        diveLogItem.setTimestamp(this.timestamp);
        diveLogItem.setWaterTemperature(this.waterTemperature);
        diveLogItem.setWindDirection(this.windDirection);
        diveLogItem.setWindVelocity(this.windVelocity);
        return diveLogItem;
    }

    public static DiveLogEntry buildByDiveLogItem(DiveLogItem diveLogItem) {
        DiveLogEntry diveLogEntry = new DiveLogEntry();
        diveLogEntry.setDetailIndex(diveLogItem.getIndex());
        diveLogEntry.setWeather(diveLogItem.getWeather());
        diveLogEntry.setAirTemperature(diveLogItem.getAirTemperature());
        diveLogEntry.setBatteryState(diveLogItem.getBatteryState());
        diveLogEntry.setBuoyBattery(diveLogItem.getBuoyBattery());
        diveLogEntry.setBuoyLatitude(diveLogItem.getBuoyLatitude());
        diveLogEntry.setBuoyLongitude(diveLogItem.getBuoyLongitude());
        diveLogEntry.setLedState(diveLogItem.getLedState());
        diveLogEntry.setPhoneBattery(diveLogItem.getPhoneBattery());
        diveLogEntry.setPhoneLatitude(diveLogItem.getPhoneLatitude());
        diveLogEntry.setPhoneLongitude(diveLogItem.getPhoneLongitude());
        diveLogEntry.setPhotoUri(diveLogItem.getPhotoUri());
        diveLogEntry.setRefStateDepth(diveLogItem.getRefStateDepth());
        diveLogEntry.setRefStateQuaternionW(diveLogItem.getRefStateQuaternionW());
        diveLogEntry.setRefStateQuaternionX(diveLogItem.getRefStateQuaternionX());
        diveLogEntry.setRefStateQuaternionY(diveLogItem.getRefStateQuaternionY());
        diveLogEntry.setRefStateQuaternionZ(diveLogItem.getRefStateQuaternionZ());
        diveLogEntry.setRemoteBattery(diveLogItem.getRemoteBattery());
        if (diveLogItem.getRemoteLinkState() > 0) {
            diveLogEntry.setRemoteLinkState(true);
        } else {
            diveLogEntry.setRemoteLinkState(false);
        }
        diveLogEntry.setRemotePER(diveLogItem.getRemotePER());
        diveLogEntry.setRemoteRSSI(diveLogItem.getRemoteRSSI());
        diveLogEntry.setRemoteSNR(diveLogItem.getRemoteSNR());
        diveLogEntry.setRobotOperationState(diveLogItem.getRobotOperationState());
        diveLogEntry.setRpmMotor0(diveLogItem.getRpmMotor0());
        diveLogEntry.setRpmMotor1(diveLogItem.getRpmMotor1());
        diveLogEntry.setRpmMotor2(diveLogItem.getRpmMotor2());
        diveLogEntry.setRpmMotor3(diveLogItem.getRpmMotor3());
        diveLogEntry.setSensorsState(diveLogItem.getSensorsState());
        diveLogEntry.setStateDepth(diveLogItem.getStateDepth());
        diveLogEntry.setLedState(diveLogItem.getLedState());
        diveLogEntry.setStateQuaternionW(diveLogItem.getStateQuaternionW());
        diveLogEntry.setStateQuaternionX(diveLogItem.getStateQuaternionX());
        diveLogEntry.setStateQuaternionY(diveLogItem.getStateQuaternionY());
        diveLogEntry.setStateQuaternionZ(diveLogItem.getStateQuaternionZ());
        diveLogEntry.setTemperature(diveLogItem.getTemperature());
        diveLogEntry.setTimestamp(diveLogItem.getTimestamp());
        diveLogEntry.setWaterTemperature(diveLogItem.getWaterTemperature());
        diveLogEntry.setWindDirection(diveLogItem.getWindDirection());
        diveLogEntry.setWindVelocity(diveLogItem.getWindVelocity());
        return diveLogEntry;
    }
}
