package com.navatics.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import com.navatics.app.NvBaseActivity;
import com.navatics.app.PhoneLocationProvider;
import com.yayandroid.locationmanager.LocationManager;
import com.yayandroid.locationmanager.p082a.DefaultProviderConfiguration;
import com.yayandroid.locationmanager.p082a.GooglePlayServicesConfiguration;
import com.yayandroid.locationmanager.p082a.LocationConfiguration;
import com.yayandroid.locationmanager.p082a.PermissionConfiguration;
import com.yayandroid.locationmanager.p085c.LocationListener;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import org.apache.log4j.C3044k;

/* loaded from: classes.dex */
public abstract class LocationActivity extends NvBaseActivity implements LocationListener {

    /* renamed from: a */
    private static final C3044k f3609a = C3044k.m1564a(LocationActivity.class);

    /* renamed from: b */
    private LocationManager f3610b;

    /* renamed from: c */
    private int f3611c = 0;

    /* renamed from: lambda$1CiiaJQtmqJ-LMQ_T-8G8FO-xYQ */
    public static /* synthetic */ void m12977lambda$1CiiaJQtmqJLMQ_T8G8FOxYQ(LocationActivity locationActivity) {
        locationActivity.m9384c();
    }

    @Override // com.yayandroid.locationmanager.p085c.LocationListener
    /* renamed from: a */
    public void mo3614a(String str) {
    }

    @Override // com.yayandroid.locationmanager.p085c.LocationListener
    /* renamed from: a */
    public void mo3613a(String str, int i, Bundle bundle) {
    }

    @Override // com.yayandroid.locationmanager.p085c.LocationListener
    /* renamed from: a */
    public void mo3612a(boolean z) {
    }

    @Override // com.yayandroid.locationmanager.p085c.LocationListener
    /* renamed from: b */
    public void mo3610b(String str) {
    }

    /* renamed from: a */
    public void m9387a() {
        runOnUiThread(new Runnable() { // from class: com.navatics.app.activities.-$$Lambda$LocationActivity$1CiiaJQtmqJ-LMQ_T-8G8FO-xYQ
            @Override // java.lang.Runnable
            public final void run() {
                LocationActivity.m12977lambda$1CiiaJQtmqJLMQ_T8G8FOxYQ(LocationActivity.this);
            }
        });
    }

    /* renamed from: c */
    public /* synthetic */ void m9384c() {
        LocationManager locationManager = this.f3610b;
        if (locationManager != null) {
            locationManager.m3707e();
            return;
        }
        throw new IllegalStateException("locationManager is null. Make sure you call super.initialize before attempting to getLocation");
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.support.p008v4.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3610b = new LocationManager.C2808a(getApplicationContext()).m3700a(m9386b()).m3703a((Activity) this).m3699a((LocationListener) this).m3704a();
    }

    @Override // com.navatics.app.NvBaseActivity, android.support.p011v7.app.AppCompatActivity, android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onDestroy() {
        this.f3610b.m3708d();
        super.onDestroy();
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onPause() {
        this.f3610b.m3711b();
        super.onPause();
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onResume() {
        super.onResume();
        this.f3610b.m3709c();
        PhoneLocationProvider.m8803a().m8800a(this);
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.f3610b.m3714a(i, i2, intent);
    }

    @Override // android.support.p008v4.app.FragmentActivity, android.app.Activity, android.support.p008v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    @CallSuper
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f3610b.m3713a(i, strArr, iArr);
    }

    @Override // com.yayandroid.locationmanager.p085c.LocationListener
    /* renamed from: a */
    public void mo3616a(int i) {
        switch (i) {
            case 2:
                f3609a.mo1500c((Object) "Getting Location from Google Play Services...");
                this.f3611c = 3;
                return;
            case 3:
                f3609a.mo1500c((Object) "Getting Location from GPS...");
                this.f3611c = 1;
                return;
            case 4:
                f3609a.mo1500c((Object) "Getting Location from Network...");
                this.f3611c = 2;
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    public LocationConfiguration m9386b() {
        return new LocationConfiguration.C2814a().m3650a(new PermissionConfiguration.C2816a().m3642a("Navatics needs the GPS location for recording dive log").m3645a()).m3652a(new GooglePlayServicesConfiguration.C2812a().m3667a(false).m3669a()).m3653a(new DefaultProviderConfiguration.C2810a().m3687a()).m3654a();
    }

    @Override // com.yayandroid.locationmanager.p085c.LocationListener
    /* renamed from: a */
    public void mo3615a(Location location) {
        C3044k c3044k = f3609a;
        c3044k.mo1511a((Object) ("Longitude " + location.getLongitude() + ", Latitude " + location.getLatitude()));
        PhoneLocationProvider.m8803a().m8802a(this.f3611c, location);
    }

    @Override // com.yayandroid.locationmanager.p085c.LocationListener
    /* renamed from: b */
    public void mo3611b(int i) {
        if (i != -1) {
            switch (i) {
                case 1:
                    f3609a.mo1504b((Object) "Couldn't get location, and timeout!");
                    return;
                case 2:
                    f3609a.mo1504b((Object) "Couldn't get location, because user didn't give permission!");
                    return;
                case 3:
                    f3609a.mo1504b((Object) "Couldn't get location, because network is not accessible!");
                    return;
                case 4:
                    f3609a.mo1504b((Object) "Couldn't get location, because Google Play Services not available!");
                    return;
                case 5:
                    f3609a.mo1504b((Object) "Couldn't get location, because Google Play Services connection failed!");
                    return;
                case 6:
                    f3609a.mo1504b((Object) "Couldn't display settingsApi dialog!");
                    return;
                case 7:
                    f3609a.mo1504b((Object) "Couldn't get location, because user didn't activate providers via settingsApi!");
                    return;
                case 8:
                    f3609a.mo1504b((Object) "Couldn't get location, because in the process view was detached!");
                    return;
                case 9:
                    f3609a.mo1504b((Object) "Couldn't get location, because view wasn't sufficient enough to fulfill given configuration!");
                    return;
                default:
                    return;
            }
        }
        f3609a.mo1504b((Object) "Ops! Something went wrong!");
    }

    /* renamed from: b */
    public Address m9385b(Location location) throws IOException {
        C3044k c3044k = f3609a;
        c3044k.mo1511a((Object) ("Thread : " + Thread.currentThread().getName()));
        if (Geocoder.isPresent()) {
            try {
                List<Address> fromLocation = new Geocoder(this, Locale.ENGLISH).getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                if (fromLocation.size() > 0) {
                    return fromLocation.get(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }
}
