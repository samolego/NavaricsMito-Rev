package com.senseplay.sdk.model.gps;

/* loaded from: classes2.dex */
public class GpsInfo {
    public double altitude;
    public int determinationSatelliteCnt;
    public int discoveredSatelliteCnt;
    public double latitude;
    public double longitude;
    public double speed;

    public int getDiscoveredSatelliteCnt() {
        return this.discoveredSatelliteCnt;
    }

    public void setDiscoveredSatelliteCnt(int i) {
        this.discoveredSatelliteCnt = i;
    }

    public int getDeterminationSatelliteCnt() {
        return this.determinationSatelliteCnt;
    }

    public void setDeterminationSatelliteCnt(int i) {
        this.determinationSatelliteCnt = i;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public double getSpeed() {
        return this.speed;
    }

    public void setSpeed(double d) {
        this.speed = d;
    }

    public double getAltitude() {
        return this.altitude;
    }

    public void setAltitude(double d) {
        this.altitude = d;
    }
}