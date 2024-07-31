package com.yayandroid.locationmanager.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.p008v4.app.Fragment;
import com.yayandroid.locationmanager.LocationManager;
import com.yayandroid.locationmanager.p082a.LocationConfiguration;
import com.yayandroid.locationmanager.p085c.LocationListener;

/* loaded from: classes2.dex */
public abstract class LocationBaseFragment extends Fragment implements LocationListener {

    /* renamed from: a */
    private LocationManager f9370a;

    /* renamed from: a */
    public abstract LocationConfiguration m3617a();

    @Override // android.support.p008v4.app.Fragment
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9370a = new LocationManager.C2808a(getContext().getApplicationContext()).m3700a(m3617a()).m3702a((Fragment) this).m3699a((LocationListener) this).m3704a();
    }

    @Override // android.support.p008v4.app.Fragment
    @CallSuper
    public void onDestroy() {
        this.f9370a.m3708d();
        super.onDestroy();
    }

    @Override // android.support.p008v4.app.Fragment
    @CallSuper
    public void onPause() {
        this.f9370a.m3711b();
        super.onPause();
    }

    @Override // android.support.p008v4.app.Fragment
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f9370a.m3709c();
    }

    @Override // android.support.p008v4.app.Fragment
    @CallSuper
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f9370a.m3714a(i, i2, intent);
    }

    @Override // android.support.p008v4.app.Fragment
    @CallSuper
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f9370a.m3713a(i, strArr, iArr);
    }
}
