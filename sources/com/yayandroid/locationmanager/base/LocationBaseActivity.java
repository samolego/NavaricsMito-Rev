package com.yayandroid.locationmanager.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.p011v7.app.AppCompatActivity;
import com.yayandroid.locationmanager.LocationManager;
import com.yayandroid.locationmanager.p082a.LocationConfiguration;
import com.yayandroid.locationmanager.p085c.LocationListener;

/* loaded from: classes2.dex */
public abstract class LocationBaseActivity extends AppCompatActivity implements LocationListener {

    /* renamed from: a */
    private LocationManager f9369a;

    /* renamed from: a */
    public abstract LocationConfiguration m3618a();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9369a = new LocationManager.C2808a(getApplicationContext()).m3700a(m3618a()).m3703a((Activity) this).m3699a((LocationListener) this).m3704a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onDestroy() {
        this.f9369a.m3708d();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onPause() {
        this.f9369a.m3711b();
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f9369a.m3709c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f9369a.m3714a(i, i2, intent);
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity, android.support.p008v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    @CallSuper
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f9369a.m3713a(i, strArr, iArr);
    }
}
