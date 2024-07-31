package com.yayandroid.locationmanager.p086d.p088b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.p008v4.app.Fragment;
import com.yayandroid.locationmanager.p082a.LocationConfiguration;
import com.yayandroid.locationmanager.p083b.LogUtils;
import com.yayandroid.locationmanager.p085c.LocationListener;
import com.yayandroid.locationmanager.p090e.ContextProcessor;
import java.lang.ref.WeakReference;

/* renamed from: com.yayandroid.locationmanager.d.b.g */
/* loaded from: classes2.dex */
public abstract class LocationProvider {

    /* renamed from: a */
    private boolean f9392a = false;

    /* renamed from: b */
    private LocationConfiguration f9393b;

    /* renamed from: c */
    private ContextProcessor f9394c;

    /* renamed from: d */
    private WeakReference<LocationListener> f9395d;

    /* renamed from: a */
    public void mo3538a(int i, int i2, Intent intent) {
    }

    /* renamed from: c */
    public void mo3532c() {
    }

    /* renamed from: e */
    public abstract void mo3530e();

    /* renamed from: f */
    public void mo3529f() {
    }

    /* renamed from: g */
    public void mo3528g() {
    }

    /* renamed from: i */
    public abstract void mo3527i();

    @CallSuper
    /* renamed from: a */
    public void m3536a(ContextProcessor contextProcessor, LocationConfiguration locationConfiguration, LocationListener locationListener) {
        this.f9394c = contextProcessor;
        this.f9393b = locationConfiguration;
        this.f9395d = new WeakReference<>(locationListener);
        mo3532c();
    }

    @CallSuper
    /* renamed from: b */
    public void m3534b(LocationProvider locationProvider) {
        this.f9394c = locationProvider.f9394c;
        this.f9393b = locationProvider.f9393b;
        this.f9395d = locationProvider.f9395d;
        mo3532c();
    }

    /* renamed from: b */
    public void m3533b(boolean z) {
        this.f9392a = z;
    }

    /* renamed from: b */
    public boolean mo3535b() {
        return this.f9392a;
    }

    @CallSuper
    /* renamed from: d */
    public void mo3531d() {
        this.f9395d.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public LocationConfiguration m3526p() {
        return this.f9393b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: q */
    public LocationListener m3525q() {
        return this.f9395d.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: r */
    public Context m3524r() {
        return this.f9394c.m3495c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: s */
    public Activity m3523s() {
        return this.f9394c.m3496b();
    }

    @Nullable
    /* renamed from: t */
    protected Fragment m3522t() {
        return this.f9394c.m3499a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public boolean m3537a(Intent intent, int i) {
        if (m3522t() != null) {
            m3522t().startActivityForResult(intent, i);
            return true;
        } else if (m3523s() != null) {
            m3523s().startActivityForResult(intent, i);
            return true;
        } else {
            LogUtils.m3640a("Cannot startActivityForResult because host is neither Activity nor Fragment.");
            return false;
        }
    }
}
