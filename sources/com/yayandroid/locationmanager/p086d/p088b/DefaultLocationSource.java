package com.yayandroid.locationmanager.p086d.p088b;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import com.yayandroid.locationmanager.p083b.UpdateRequest;
import com.yayandroid.locationmanager.p083b.p084a.ContinuousTask;
import java.util.Date;

/* renamed from: com.yayandroid.locationmanager.d.b.b */
/* loaded from: classes2.dex */
class DefaultLocationSource {

    /* renamed from: a */
    private LocationManager f9376a;

    /* renamed from: b */
    private UpdateRequest f9377b;

    /* renamed from: c */
    private ContinuousTask f9378c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3588a(Context context) {
        this.f9376a = (LocationManager) context.getSystemService("location");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3586a(LocationListener locationListener) {
        this.f9377b = new UpdateRequest(this.f9376a, locationListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3585a(ContinuousTask.InterfaceC2817a interfaceC2817a) {
        this.f9378c = new ContinuousTask("providerSwitchTask", interfaceC2817a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3584a(String str) {
        return this.f9376a.isProviderEnabled(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public Location m3581b(String str) {
        return this.f9376a.getLastKnownLocation(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3582b(LocationListener locationListener) {
        this.f9376a.removeUpdates(locationListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3589a() {
        this.f9377b.m3619c();
        this.f9377b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3583b() {
        this.f9378c.m3633c();
        this.f9378c = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public ContinuousTask m3580c() {
        return this.f9378c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public UpdateRequest m3579d() {
        return this.f9377b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3587a(Location location, long j, float f) {
        if (location == null) {
            return false;
        }
        return new Date().getTime() - j <= location.getTime() && f >= location.getAccuracy();
    }
}
