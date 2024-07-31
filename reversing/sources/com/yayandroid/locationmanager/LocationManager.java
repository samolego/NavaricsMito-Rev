package com.yayandroid.locationmanager;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.p008v4.app.Fragment;
import com.yayandroid.locationmanager.p082a.LocationConfiguration;
import com.yayandroid.locationmanager.p083b.LogUtils;
import com.yayandroid.locationmanager.p085c.LocationListener;
import com.yayandroid.locationmanager.p085c.PermissionListener;
import com.yayandroid.locationmanager.p086d.p088b.DispatcherLocationProvider;
import com.yayandroid.locationmanager.p086d.p088b.LocationProvider;
import com.yayandroid.locationmanager.p086d.p089c.PermissionProvider;
import com.yayandroid.locationmanager.p090e.ContextProcessor;

/* renamed from: com.yayandroid.locationmanager.a */
/* loaded from: classes2.dex */
public class LocationManager implements PermissionListener {

    /* renamed from: a */
    private LocationListener f9300a;

    /* renamed from: b */
    private LocationConfiguration f9301b;

    /* renamed from: c */
    private LocationProvider f9302c;

    /* renamed from: d */
    private PermissionProvider f9303d;

    /* renamed from: a */
    public static void m3712a(boolean z) {
        LogUtils.m3639a(z);
    }

    private LocationManager(C2808a c2808a) {
        this.f9300a = c2808a.f9305b;
        this.f9301b = c2808a.f9306c;
        this.f9302c = c2808a.f9307d;
        this.f9303d = m3716a().m3657b().m3646a();
        this.f9303d.m3510a(c2808a.f9304a);
        this.f9303d.m3511a(this);
    }

    /* compiled from: LocationManager.java */
    /* renamed from: com.yayandroid.locationmanager.a$a */
    /* loaded from: classes2.dex */
    public static class C2808a {

        /* renamed from: a */
        private ContextProcessor f9304a;

        /* renamed from: b */
        private LocationListener f9305b;

        /* renamed from: c */
        private LocationConfiguration f9306c;

        /* renamed from: d */
        private LocationProvider f9307d;

        public C2808a(@NonNull Context context) {
            this.f9304a = new ContextProcessor(context);
        }

        /* renamed from: a */
        public C2808a m3703a(Activity activity) {
            this.f9304a.m3498a(activity);
            return this;
        }

        /* renamed from: a */
        public C2808a m3702a(Fragment fragment) {
            this.f9304a.m3497a(fragment);
            return this;
        }

        /* renamed from: a */
        public C2808a m3700a(@NonNull LocationConfiguration locationConfiguration) {
            this.f9306c = locationConfiguration;
            return this;
        }

        /* renamed from: a */
        public C2808a m3698a(@NonNull LocationProvider locationProvider) {
            this.f9307d = locationProvider;
            return this;
        }

        /* renamed from: a */
        public C2808a m3699a(LocationListener locationListener) {
            this.f9305b = locationListener;
            return this;
        }

        /* renamed from: a */
        public LocationManager m3704a() {
            if (this.f9304a == null) {
                throw new IllegalStateException("You must set a context to LocationManager.");
            }
            if (this.f9306c == null) {
                throw new IllegalStateException("You must set a configuration object.");
            }
            if (this.f9307d == null) {
                m3698a(new DispatcherLocationProvider());
            }
            this.f9307d.m3536a(this.f9304a, this.f9306c, this.f9305b);
            return new LocationManager(this);
        }
    }

    /* renamed from: a */
    public LocationConfiguration m3716a() {
        return this.f9301b;
    }

    /* renamed from: b */
    public void m3711b() {
        this.f9302c.mo3529f();
    }

    /* renamed from: c */
    public void m3709c() {
        this.f9302c.mo3528g();
    }

    /* renamed from: d */
    public void m3708d() {
        this.f9302c.mo3531d();
    }

    /* renamed from: a */
    public void m3714a(int i, int i2, Intent intent) {
        this.f9302c.mo3538a(i, i2, intent);
    }

    /* renamed from: a */
    public void m3713a(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        this.f9303d.mo3501a(i, strArr, iArr);
    }

    /* renamed from: e */
    public void m3707e() {
        m3706f();
    }

    /* renamed from: f */
    void m3706f() {
        if (this.f9303d.m3502m()) {
            m3710b(true);
            return;
        }
        LocationListener locationListener = this.f9300a;
        if (locationListener != null) {
            locationListener.mo3616a(1);
        }
        if (this.f9303d.mo3500c()) {
            LogUtils.m3638b("Waiting until we receive any callback from PermissionProvider...");
            return;
        }
        LogUtils.m3638b("Couldn't get permission, Abort!");
        m3715a(2);
    }

    /* renamed from: b */
    private void m3710b(boolean z) {
        LogUtils.m3638b("We got permission!");
        LocationListener locationListener = this.f9300a;
        if (locationListener != null) {
            locationListener.mo3612a(z);
        }
        this.f9302c.mo3527i();
    }

    /* renamed from: a */
    private void m3715a(int i) {
        LocationListener locationListener = this.f9300a;
        if (locationListener != null) {
            locationListener.mo3611b(i);
        }
    }

    @Override // com.yayandroid.locationmanager.p085c.PermissionListener
    /* renamed from: g */
    public void mo3609g() {
        m3710b(false);
    }

    @Override // com.yayandroid.locationmanager.p085c.PermissionListener
    /* renamed from: h */
    public void mo3608h() {
        m3715a(2);
    }
}
