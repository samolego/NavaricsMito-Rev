package com.yayandroid.locationmanager.p082a;

import com.google.android.gms.location.LocationRequest;

/* renamed from: com.yayandroid.locationmanager.a.b */
/* loaded from: classes2.dex */
public final class Defaults {

    /* renamed from: a */
    public static final String[] f9323a = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};

    /* renamed from: a */
    public static LocationRequest m3679a() {
        return LocationRequest.create().setPriority(102).setInterval(300000L).setFastestInterval(60000L);
    }
}
