package com.yayandroid.locationmanager.p083b;

import android.location.LocationListener;
import android.location.LocationManager;

/* renamed from: com.yayandroid.locationmanager.b.c */
/* loaded from: classes2.dex */
public class UpdateRequest {

    /* renamed from: a */
    private final LocationManager f9364a;

    /* renamed from: b */
    private final LocationListener f9365b;

    /* renamed from: c */
    private String f9366c;

    /* renamed from: d */
    private long f9367d;

    /* renamed from: e */
    private float f9368e;

    public UpdateRequest(LocationManager locationManager, LocationListener locationListener) {
        this.f9364a = locationManager;
        this.f9365b = locationListener;
    }

    /* renamed from: a */
    public boolean m3622a() {
        return this.f9367d == 0;
    }

    /* renamed from: a */
    public void m3621a(String str, long j, float f) {
        this.f9366c = str;
        this.f9367d = j;
        this.f9368e = f;
        m3620b();
    }

    /* renamed from: b */
    public void m3620b() {
        if (C2818b.m3623a(this.f9366c)) {
            this.f9364a.requestLocationUpdates(this.f9366c, this.f9367d, this.f9368e, this.f9365b);
        }
    }

    /* renamed from: c */
    public void m3619c() {
        this.f9364a.removeUpdates(this.f9365b);
    }
}
