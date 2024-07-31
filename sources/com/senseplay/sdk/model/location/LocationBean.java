package com.senseplay.sdk.model.location;

import com.github.mikephil.charting.utils.Utils;

/* loaded from: classes2.dex */
public class LocationBean {
    private double longitude = Utils.DOUBLE_EPSILON;
    private double latitude = Utils.DOUBLE_EPSILON;

    public double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(double d) {
        this.longitude = d;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(double d) {
        this.latitude = d;
    }
}
