package com.yayandroid.locationmanager.p086d.p088b;

import android.app.Dialog;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.yayandroid.locationmanager.p083b.LogUtils;
import com.yayandroid.locationmanager.p083b.p084a.ContinuousTask;
import com.yayandroid.locationmanager.p085c.DialogListener;
import com.yayandroid.locationmanager.p086d.p087a.DialogProvider;

/* renamed from: com.yayandroid.locationmanager.d.b.a */
/* loaded from: classes2.dex */
public class DefaultLocationProvider extends LocationProvider implements LocationListener, ContinuousTask.InterfaceC2817a, DialogListener {

    /* renamed from: a */
    private DefaultLocationSource f9373a;

    /* renamed from: b */
    private String f9374b;

    /* renamed from: c */
    private Dialog f9375c;

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: c */
    public void mo3532c() {
        super.mo3532c();
        m3590w().m3588a(m3524r());
        m3590w().m3585a((ContinuousTask.InterfaceC2817a) this);
        m3590w().m3586a((LocationListener) this);
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: d */
    public void mo3531d() {
        super.mo3531d();
        this.f9375c = null;
        m3590w().m3583b();
        m3590w().m3589a();
        m3590w().m3582b(this);
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: e */
    public void mo3530e() {
        m3590w().m3579d().m3619c();
        m3590w().m3580c().m3633c();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: f */
    public void mo3529f() {
        super.mo3529f();
        m3590w().m3579d().m3619c();
        m3590w().m3580c().m3637a();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: g */
    public void mo3528g() {
        super.mo3528g();
        m3590w().m3579d().m3620b();
        if (mo3535b()) {
            m3590w().m3580c().m3635b();
        }
        if (m3599h() && m3591v()) {
            this.f9375c.dismiss();
            m3597k();
        }
    }

    /* renamed from: h */
    public boolean m3599h() {
        Dialog dialog = this.f9375c;
        return dialog != null && dialog.isShowing();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: a */
    public void mo3538a(int i, int i2, Intent intent) {
        super.mo3538a(i, i2, intent);
        if (i == 25) {
            if (m3591v()) {
                m3597k();
                return;
            }
            LogUtils.m3638b("User didn't activate GPS, so continue with Network Provider");
            m3596l();
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: i */
    public void mo3527i() {
        m3533b(true);
        if (m3591v()) {
            LogUtils.m3638b("GPS is already enabled, getting location...");
            m3601b("gps");
        } else if (m3526p().m3655d().m3691e() && m3523s() != null) {
            LogUtils.m3638b("GPS is not enabled, asking user to enable it...");
            m3598j();
        } else {
            LogUtils.m3638b("GPS is not enabled, moving on with Network...");
            m3596l();
        }
    }

    /* renamed from: j */
    void m3598j() {
        DialogProvider m3690f = m3526p().m3655d().m3690f();
        m3690f.m3606a(this);
        this.f9375c = m3690f.mo3605a(m3523s());
        this.f9375c.show();
    }

    /* renamed from: k */
    void m3597k() {
        LogUtils.m3638b("User activated GPS, listen for location");
        m3601b("gps");
    }

    /* renamed from: l */
    void m3596l() {
        if (m3592u()) {
            LogUtils.m3638b("Network is enabled, getting location...");
            m3601b("network");
            return;
        }
        LogUtils.m3638b("Network is not enabled, calling fail...");
        m3604a(3);
    }

    /* renamed from: b */
    void m3601b(String str) {
        m3590w().m3580c().m3633c();
        m3600c(str);
        boolean m3595m = m3595m();
        if (m3526p().m3658a() || !m3595m) {
            LogUtils.m3638b("Ask for location update...");
            m3594n();
            m3603a(0L, 0L, !m3595m);
            return;
        }
        LogUtils.m3638b("We got location, no need to ask for location updates.");
    }

    /* renamed from: m */
    boolean m3595m() {
        Location m3581b = m3590w().m3581b(this.f9374b);
        if (m3590w().m3587a(m3581b, m3526p().m3655d().m3693d(), m3526p().m3655d().m3695c())) {
            LogUtils.m3638b("LastKnowLocation is usable.");
            m3602a(m3581b);
            return true;
        }
        LogUtils.m3638b("LastKnowLocation is not usable.");
        return false;
    }

    /* renamed from: c */
    void m3600c(String str) {
        this.f9374b = str;
    }

    /* renamed from: n */
    void m3594n() {
        if (m3525q() != null) {
            m3525q().mo3616a("gps".equals(this.f9374b) ? 3 : 4);
        }
    }

    /* renamed from: a */
    void m3603a(long j, long j2, boolean z) {
        if (z) {
            m3590w().m3580c().m3636a(m3593o());
        }
        m3590w().m3579d().m3621a(this.f9374b, j, (float) j2);
    }

    /* renamed from: o */
    long m3593o() {
        if ("gps".equals(this.f9374b)) {
            return m3526p().m3655d().m3689g();
        }
        return m3526p().m3655d().m3688h();
    }

    /* renamed from: u */
    private boolean m3592u() {
        return m3590w().m3584a("network");
    }

    /* renamed from: v */
    private boolean m3591v() {
        return m3590w().m3584a("gps");
    }

    /* renamed from: a */
    void m3602a(Location location) {
        if (m3525q() != null) {
            m3525q().mo3615a(location);
        }
        m3533b(false);
    }

    /* renamed from: a */
    void m3604a(int i) {
        if (m3525q() != null) {
            m3525q().mo3611b(i);
        }
        m3533b(false);
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        m3602a(location);
        m3590w().m3580c().m3633c();
        if (m3590w().m3579d().m3622a() || !m3526p().m3658a()) {
            m3590w().m3582b(this);
        }
        if (m3526p().m3658a()) {
            m3603a(m3526p().m3655d().m3705a(), m3526p().m3655d().m3697b(), false);
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
        if (m3525q() != null) {
            m3525q().mo3613a(str, i, bundle);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if (m3525q() != null) {
            m3525q().mo3614a(str);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if (m3525q() != null) {
            m3525q().mo3610b(str);
        }
    }

    @Override // com.yayandroid.locationmanager.p083b.p084a.ContinuousTask.InterfaceC2817a
    /* renamed from: a */
    public void mo3575a(@NonNull String str) {
        if (str.equals("providerSwitchTask")) {
            m3590w().m3579d().m3619c();
            if ("gps".equals(this.f9374b)) {
                LogUtils.m3638b("We waited enough for GPS, switching to Network provider...");
                m3596l();
                return;
            }
            LogUtils.m3638b("Network Provider is not provide location in required period, calling fail...");
            m3604a(1);
        }
    }

    @Override // com.yayandroid.locationmanager.p085c.DialogListener
    /* renamed from: a */
    public void mo3521a() {
        if (m3537a(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), 25)) {
            return;
        }
        m3604a(9);
    }

    @Override // com.yayandroid.locationmanager.p085c.DialogListener
    /* renamed from: f_ */
    public void mo3516f_() {
        LogUtils.m3638b("User didn't want to enable GPS, so continue with Network Provider");
        m3596l();
    }

    /* renamed from: w */
    private DefaultLocationSource m3590w() {
        if (this.f9373a == null) {
            this.f9373a = new DefaultLocationSource();
        }
        return this.f9373a;
    }
}
