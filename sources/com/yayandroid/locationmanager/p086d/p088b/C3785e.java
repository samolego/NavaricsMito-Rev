package com.yayandroid.locationmanager.p086d.p088b;

import android.content.Intent;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationSettingsResult;
import com.yayandroid.locationmanager.p083b.LogUtils;
import com.yayandroid.locationmanager.p085c.FallbackListener;
import com.yayandroid.locationmanager.p086d.p088b.GooglePlayServicesLocationSource;
import java.lang.ref.WeakReference;

/* renamed from: com.yayandroid.locationmanager.d.b.e */
/* loaded from: classes2.dex */
public class GooglePlayServicesLocationProvider extends LocationProvider implements GooglePlayServicesLocationSource.InterfaceC2820a {

    /* renamed from: a */
    private final WeakReference<FallbackListener> f9384a;

    /* renamed from: b */
    private boolean f9385b = false;

    /* renamed from: c */
    private boolean f9386c = true;

    /* renamed from: d */
    private int f9387d = 0;

    /* renamed from: e */
    private GooglePlayServicesLocationSource f9388e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GooglePlayServicesLocationProvider(FallbackListener fallbackListener) {
        this.f9384a = new WeakReference<>(fallbackListener);
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: g */
    public void mo3528g() {
        if (this.f9385b || this.f9388e == null) {
            return;
        }
        if (mo3535b() || m3526p().m3658a()) {
            this.f9388e.m3551b();
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: f */
    public void mo3529f() {
        GooglePlayServicesLocationSource googlePlayServicesLocationSource;
        if (this.f9385b || (googlePlayServicesLocationSource = this.f9388e) == null || !googlePlayServicesLocationSource.m3554a()) {
            return;
        }
        this.f9388e.m3550c();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: d */
    public void mo3531d() {
        super.mo3531d();
        GooglePlayServicesLocationSource googlePlayServicesLocationSource = this.f9388e;
        if (googlePlayServicesLocationSource != null) {
            googlePlayServicesLocationSource.m3549d();
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: i */
    public void mo3527i() {
        m3533b(true);
        if (m3524r() != null) {
            m3555k().m3551b();
        } else {
            m3558c(8);
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: e */
    public void mo3530e() {
        LogUtils.m3638b("Canceling GooglePlayServiceLocationProvider...");
        GooglePlayServicesLocationSource googlePlayServicesLocationSource = this.f9388e;
        if (googlePlayServicesLocationSource == null || !googlePlayServicesLocationSource.m3554a()) {
            return;
        }
        this.f9388e.m3546g();
        this.f9388e.m3550c();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: a */
    public void mo3538a(int i, int i2, Intent intent) {
        super.mo3538a(i, i2, intent);
        if (i == 26) {
            this.f9385b = false;
            if (i2 == -1) {
                LogUtils.m3638b("We got settings changed, requesting location update...");
                m3556j();
                return;
            }
            LogUtils.m3638b("User denied settingsApi dialog, GooglePlayServices SettingsApi failing...");
            m3559b(7);
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.GooglePlayServicesLocationSource.InterfaceC2820a
    /* renamed from: a */
    public void mo3541a(Bundle bundle) {
        boolean m3562a;
        LogUtils.m3638b("GoogleApiClient is connected.");
        if (m3526p().m3656c().m3672g()) {
            LogUtils.m3638b("Configuration requires to ignore last know location from GooglePlayServices Api.");
            m3562a = false;
        } else {
            m3562a = m3562a();
        }
        if (m3526p().m3658a() || !m3562a || this.f9386c) {
            m3560a(false);
            m3557h();
            return;
        }
        LogUtils.m3638b("We got location, no need to ask for location updates.");
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.GooglePlayServicesLocationSource.InterfaceC2820a
    /* renamed from: a */
    public void mo3543a(int i) {
        if (!m3526p().m3656c().m3674e() && this.f9387d < m3526p().m3656c().m3670i()) {
            LogUtils.m3638b("GoogleApiClient connection is suspended, try to connect again.");
            this.f9387d++;
            m3555k().m3551b();
            return;
        }
        LogUtils.m3638b("GoogleApiClient connection is suspended, calling fail...");
        m3558c(5);
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.GooglePlayServicesLocationSource.InterfaceC2820a
    /* renamed from: a */
    public void mo3540a(@NonNull ConnectionResult connectionResult) {
        LogUtils.m3638b("GoogleApiClient connection is failed.");
        m3558c(5);
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.GooglePlayServicesLocationSource.InterfaceC2820a
    /* renamed from: a */
    public void mo3542a(Location location) {
        if (m3525q() != null) {
            m3525q().mo3615a(location);
        }
        m3533b(false);
        if (m3526p().m3658a() || !m3555k().m3554a()) {
            return;
        }
        LogUtils.m3638b("We got location and no need to keep tracking, so location update is removed.");
        m3555k().m3546g();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.GooglePlayServicesLocationSource.InterfaceC2820a
    /* renamed from: a */
    public void mo3539a(@NonNull LocationSettingsResult locationSettingsResult) {
        Status status = locationSettingsResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode == 0) {
            LogUtils.m3638b("We got GPS, Wifi and/or Cell network providers enabled enough to receive location as we needed. Requesting location update...");
            m3556j();
        } else if (statusCode == 6) {
            m3561a(status);
        } else if (statusCode != 8502) {
        } else {
            LogUtils.m3640a("Settings change is not available, SettingsApi failing...");
            m3559b(6);
        }
    }

    /* renamed from: a */
    void m3561a(Status status) {
        try {
            LogUtils.m3638b("We need settingsApi dialog to switch required settings on.");
            if (m3523s() != null) {
                LogUtils.m3638b("Displaying the dialog...");
                m3555k().m3553a(status, m3523s());
                this.f9385b = true;
            } else {
                LogUtils.m3638b("Settings Api cannot show dialog if LocationManager is not running on an activity!");
                m3559b(9);
            }
        } catch (IntentSender.SendIntentException unused) {
            LogUtils.m3640a("Error on displaying SettingsApi dialog, SettingsApi failing...");
            m3559b(6);
        }
    }

    /* renamed from: a */
    boolean m3562a() {
        if (m3555k().m3545h()) {
            Location m3544i = m3555k().m3544i();
            if (m3544i != null) {
                LogUtils.m3638b("LastKnowLocation is available.");
                mo3542a(m3544i);
                return true;
            }
            LogUtils.m3638b("LastKnowLocation is not available.");
            return false;
        }
        LogUtils.m3638b("LastKnowLocation is not available.");
        return false;
    }

    /* renamed from: h */
    void m3557h() {
        LogUtils.m3638b("Ask for location update...");
        if (m3526p().m3656c().m3675d()) {
            LogUtils.m3638b("Asking for SettingsApi...");
            m3555k().m3548e();
            return;
        }
        LogUtils.m3638b("SettingsApi is not enabled, requesting for location update...");
        m3556j();
    }

    /* renamed from: j */
    void m3556j() {
        if (m3525q() != null) {
            m3525q().mo3616a(2);
        }
        if (m3555k().m3554a()) {
            LogUtils.m3638b("Requesting location update...");
            m3555k().m3547f();
            return;
        }
        LogUtils.m3638b("Tried to requestLocationUpdate, but GoogleApiClient wasn't connected. Trying to connect...");
        m3560a(true);
        m3555k().m3551b();
    }

    /* renamed from: b */
    void m3559b(int i) {
        if (m3526p().m3656c().m3673f()) {
            m3558c(i);
            return;
        }
        LogUtils.m3640a("Even though settingsApi failed, configuration requires moving on. So requesting location update...");
        if (m3555k().m3554a()) {
            m3556j();
            return;
        }
        LogUtils.m3640a("GoogleApiClient is not connected. Aborting...");
        m3558c(i);
    }

    /* renamed from: c */
    void m3558c(int i) {
        if (m3526p().m3656c().m3677b() && this.f9384a.get() != null) {
            this.f9384a.get().mo3578a();
        } else if (m3525q() != null) {
            m3525q().mo3611b(i);
        }
        m3533b(false);
    }

    /* renamed from: a */
    void m3560a(boolean z) {
        this.f9386c = z;
    }

    /* renamed from: k */
    private GooglePlayServicesLocationSource m3555k() {
        if (this.f9388e == null) {
            this.f9388e = new GooglePlayServicesLocationSource(m3524r(), m3526p().m3656c().m3678a(), this);
        }
        return this.f9388e;
    }
}
