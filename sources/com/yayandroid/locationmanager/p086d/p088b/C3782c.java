package com.yayandroid.locationmanager.p086d.p088b;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.yayandroid.locationmanager.p083b.LogUtils;
import com.yayandroid.locationmanager.p083b.p084a.ContinuousTask;
import com.yayandroid.locationmanager.p085c.FallbackListener;

/* renamed from: com.yayandroid.locationmanager.d.b.c */
/* loaded from: classes2.dex */
public class DispatcherLocationProvider extends LocationProvider implements ContinuousTask.InterfaceC2817a, FallbackListener {

    /* renamed from: a */
    private Dialog f9379a;

    /* renamed from: b */
    private LocationProvider f9380b;

    /* renamed from: c */
    private DispatcherLocationSource f9381c;

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: c */
    public void mo3532c() {
        super.mo3532c();
        m3570k().m3565a((ContinuousTask.InterfaceC2817a) this);
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: f */
    public void mo3529f() {
        super.mo3529f();
        LocationProvider locationProvider = this.f9380b;
        if (locationProvider != null) {
            locationProvider.mo3529f();
        }
        m3570k().m3563b().m3637a();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: g */
    public void mo3528g() {
        super.mo3528g();
        LocationProvider locationProvider = this.f9380b;
        if (locationProvider != null) {
            locationProvider.mo3528g();
        }
        m3570k().m3563b().m3635b();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: d */
    public void mo3531d() {
        super.mo3531d();
        LocationProvider locationProvider = this.f9380b;
        if (locationProvider != null) {
            locationProvider.mo3531d();
        }
        m3570k().m3563b().m3633c();
        this.f9381c = null;
        this.f9379a = null;
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: e */
    public void mo3530e() {
        LocationProvider locationProvider = this.f9380b;
        if (locationProvider != null) {
            locationProvider.mo3530e();
        }
        m3570k().m3563b().m3633c();
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: b */
    public boolean mo3535b() {
        LocationProvider locationProvider = this.f9380b;
        return locationProvider != null && locationProvider.mo3535b();
    }

    @Override // com.yayandroid.locationmanager.p083b.p084a.ContinuousTask.InterfaceC2817a
    /* renamed from: a */
    public void mo3575a(@NonNull String str) {
        if (str.equals("googlePlayServiceSwitchTask")) {
            LocationProvider locationProvider = this.f9380b;
            if ((locationProvider instanceof GooglePlayServicesLocationProvider) && locationProvider.mo3535b()) {
                LogUtils.m3638b("We couldn't receive location from GooglePlayServices, so switching default providers...");
                mo3530e();
                m3571j();
            }
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: a */
    public void mo3538a(int i, int i2, Intent intent) {
        super.mo3538a(i, i2, intent);
        if (i == 24) {
            m3574a(false);
            return;
        }
        LocationProvider locationProvider = this.f9380b;
        if (locationProvider != null) {
            locationProvider.mo3538a(i, i2, intent);
        }
    }

    @Override // com.yayandroid.locationmanager.p086d.p088b.LocationProvider
    /* renamed from: i */
    public void mo3527i() {
        if (m3526p().m3656c() != null) {
            m3574a(true);
            return;
        }
        LogUtils.m3638b("Configuration requires not to use Google Play Services, so skipping that step to Default Location Providers");
        m3571j();
    }

    @Override // com.yayandroid.locationmanager.p085c.FallbackListener
    /* renamed from: a */
    public void mo3578a() {
        mo3530e();
        m3571j();
    }

    /* renamed from: a */
    void m3574a(boolean z) {
        int m3566a = m3570k().m3566a(m3524r());
        if (m3566a == 0) {
            LogUtils.m3638b("GooglePlayServices is available on device.");
            m3572h();
            return;
        }
        LogUtils.m3638b("GooglePlayServices is NOT available on device.");
        if (z) {
            m3577a(m3566a);
            return;
        }
        LogUtils.m3638b("GooglePlayServices is NOT available and even though we ask user to handle error, it is still NOT available.");
        m3571j();
    }

    /* renamed from: a */
    void m3577a(int i) {
        if (m3526p().m3656c().m3676c() && m3570k().m3568a(i)) {
            m3573b(i);
            return;
        }
        LogUtils.m3638b("Either GooglePlayServices error is not resolvable or the configuration doesn't wants us to bother user.");
        m3571j();
    }

    /* renamed from: b */
    void m3573b(int i) {
        LogUtils.m3638b("Asking user to handle GooglePlayServices error...");
        this.f9379a = m3570k().m3567a(m3523s(), i, 24, new DialogInterface.OnCancelListener() { // from class: com.yayandroid.locationmanager.d.b.c.1
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                LogUtils.m3638b("GooglePlayServices error could've been resolved, but user canceled it.");
                DispatcherLocationProvider.this.m3571j();
            }
        });
        Dialog dialog = this.f9379a;
        if (dialog != null) {
            dialog.show();
            return;
        }
        LogUtils.m3638b("GooglePlayServices error could've been resolved, but since LocationManager is not running on an Activity, dialog cannot be displayed.");
        m3571j();
    }

    /* renamed from: h */
    void m3572h() {
        LogUtils.m3638b("Attempting to get location from Google Play Services providers...");
        m3576a(m3570k().m3564a((FallbackListener) this));
        m3570k().m3563b().m3636a(m3526p().m3656c().m3671h());
        this.f9380b.mo3527i();
    }

    /* renamed from: j */
    void m3571j() {
        if (m3526p().m3655d() == null) {
            LogUtils.m3638b("Configuration requires not to use default providers, abort!");
            if (m3525q() != null) {
                m3525q().mo3611b(4);
                return;
            }
            return;
        }
        LogUtils.m3638b("Attempting to get location from default providers...");
        m3576a(m3570k().m3569a());
        this.f9380b.mo3527i();
    }

    /* renamed from: a */
    void m3576a(LocationProvider locationProvider) {
        this.f9380b = locationProvider;
        this.f9380b.m3534b(this);
    }

    /* renamed from: k */
    private DispatcherLocationSource m3570k() {
        if (this.f9381c == null) {
            this.f9381c = new DispatcherLocationSource();
        }
        return this.f9381c;
    }
}
