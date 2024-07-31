package com.senseplay.sdk;

import com.senseplay.mframe.client.MCallBack;
import com.senseplay.sdk.model.location.LocationHttp;
import com.senseplay.sdk.model.location.LocationUser;
import java.util.List;

/* loaded from: classes2.dex */
public class SPLocation {
    private static SPLocation spLocation;
    private LocationHttp locationHttp = new LocationHttp(SPManager.getContent());

    public static SPLocation getInstance() {
        if (spLocation == null) {
            synchronized (SPLocation.class) {
                if (spLocation == null) {
                    spLocation = new SPLocation();
                }
            }
        }
        return spLocation;
    }

    private SPLocation() {
    }

    public void getNearbyUser(String str, MCallBack<List<LocationUser>> mCallBack) {
        this.locationHttp.getNearbyUser(SPManager.getClientId(), str, mCallBack);
    }

    public void getNearbyUserJson(String str, MCallBack<String> mCallBack) {
        this.locationHttp.getNearbyUserJson(SPManager.getClientId(), str, mCallBack);
    }
}
