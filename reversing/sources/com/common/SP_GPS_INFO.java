package com.common;

import android.util.Log;

/* loaded from: classes.dex */
public class SP_GPS_INFO {
    public double Altitude;
    public byte DeterminationSatelliteCnt;
    public byte DiscoveredSatelliteCnt;
    public double Latitude;
    public double Longitude;
    public double Speed;
    private String tag = "HDR_N";

    public void fill(byte[] bArr, double[] dArr, float[] fArr) {
        this.DiscoveredSatelliteCnt = bArr[0];
        this.DeterminationSatelliteCnt = bArr[1];
        this.Latitude = dArr[0];
        this.Longitude = dArr[1];
        this.Speed = fArr[0];
        this.Altitude = fArr[1];
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[发现卫星:  " + (this.DiscoveredSatelliteCnt & 255));
        sb.append("] [定位卫星:  " + (this.DeterminationSatelliteCnt & 255));
        sb.append("] [经度:  " + this.Latitude);
        sb.append("] [纬度:  " + this.Longitude);
        sb.append("] [速度:  " + this.Speed);
        sb.append("][ 海拔:  " + this.Altitude + " ]");
        Log.e(this.tag, sb.toString());
    }
}
