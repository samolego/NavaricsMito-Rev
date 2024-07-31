package com.yayandroid.locationmanager.p072b;

import android.location.LocationListener;
import android.location.LocationManager;

/* compiled from: UpdateRequest.java */
/* renamed from: com.yayandroid.locationmanager.b.c, reason: use source file name */
/* loaded from: classes2.dex */
public class UpdateRequest {

    /* renamed from: a */
    private final LocationManager f9405a;

    /* renamed from: b */
    private final LocationListener f9406b;

    /* renamed from: c */
    private String f9407c;

    /* renamed from: d */
    private long f9408d;

    /* renamed from: e */
    private float f9409e;

    public UpdateRequest(LocationManager locationManager, LocationListener locationListener) {
        this.f9405a = locationManager;
        this.f9406b = locationListener;
    }

    /* renamed from: a */
    public boolean m9224a() {
        return this.f9408d == 0;
    }

    /* renamed from: a */
    public void m9223a(String str, long j, float f) {
        this.f9407c = str;
        this.f9408d = j;
        this.f9409e = f;
        m9225b();
    }

    /* renamed from: b */
    public void m9225b() {
        if (C2755b.m9222a(this.f9407c)) {
            this.f9405a.requestLocationUpdates(this.f9407c, this.f9408d, this.f9409e, this.f9406b);
        }
    }

    /* renamed from: c */
    public void m9226c() {
        this.f9405a.removeUpdates(this.f9406b);
    }
}