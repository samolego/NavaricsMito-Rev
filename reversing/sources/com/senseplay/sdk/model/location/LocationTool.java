package com.senseplay.sdk.model.location;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.p008v4.app.ActivityCompat;
import com.github.mikephil.charting.utils.Utils;
import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.log.SPToast;

/* loaded from: classes2.dex */
public class LocationTool {
    private MCallBack<LocationBean> callBack;
    private LocationManager locationManager;
    private Context mContext;
    private double longitude = Utils.DOUBLE_EPSILON;
    private double latitude = Utils.DOUBLE_EPSILON;
    private LocationListener locationListener = new LocationListener() { // from class: com.senseplay.sdk.model.location.LocationTool.1
        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null) {
                LocationTool.this.latitude = location.getLatitude();
                LocationTool.this.longitude = location.getLongitude();
                LocationTool.this.onResult();
            }
        }
    };

    public LocationTool(Context context) {
        this.mContext = context;
        this.locationManager = (LocationManager) context.getSystemService("location");
    }

    public void setLocationManager(MCallBack<LocationBean> mCallBack) {
        this.callBack = mCallBack;
    }

    public boolean checkPermission() {
        if (ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            return true;
        }
        SPToast.shortShow(this.mContext, "no location permission");
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        this.mContext.startActivity(intent);
        return false;
    }

    public void startLocation() {
        if (checkPermission()) {
            if (this.locationManager.isProviderEnabled("gps")) {
                Location lastKnownLocation = this.locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation != null) {
                    this.latitude = lastKnownLocation.getLatitude();
                    this.longitude = lastKnownLocation.getLongitude();
                } else {
                    this.locationManager.requestLocationUpdates("network", 1000L, 0.0f, this.locationListener);
                    Location lastKnownLocation2 = this.locationManager.getLastKnownLocation("network");
                    if (lastKnownLocation2 != null) {
                        this.latitude = lastKnownLocation2.getLatitude();
                        this.longitude = lastKnownLocation2.getLongitude();
                    }
                }
            } else {
                this.locationManager.requestLocationUpdates("network", 1000L, 0.0f, this.locationListener);
                Location lastKnownLocation3 = this.locationManager.getLastKnownLocation("network");
                if (lastKnownLocation3 != null) {
                    this.latitude = lastKnownLocation3.getLatitude();
                    this.longitude = lastKnownLocation3.getLongitude();
                }
            }
            onResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onResult() {
        if ((this.longitude == Utils.DOUBLE_EPSILON && this.latitude == Utils.DOUBLE_EPSILON) || this.callBack == null) {
            return;
        }
        LocationBean locationBean = new LocationBean();
        locationBean.setLongitude(this.longitude);
        locationBean.setLatitude(this.latitude);
        this.callBack.onResult(locationBean);
    }

    public void stopLocation() {
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            locationManager.removeUpdates(this.locationListener);
        }
    }
}
