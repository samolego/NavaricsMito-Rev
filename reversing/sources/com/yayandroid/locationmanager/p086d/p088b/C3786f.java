package com.yayandroid.locationmanager.p086d.p088b;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;

/* renamed from: com.yayandroid.locationmanager.d.b.f */
/* loaded from: classes2.dex */
class GooglePlayServicesLocationSource implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, ResultCallback<LocationSettingsResult>, LocationListener {

    /* renamed from: a */
    private final GoogleApiClient f9389a;

    /* renamed from: b */
    private final LocationRequest f9390b;

    /* renamed from: c */
    private final InterfaceC2820a f9391c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GooglePlayServicesLocationSource.java */
    /* renamed from: com.yayandroid.locationmanager.d.b.f$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC2820a {
        /* renamed from: a */
        void mo3543a(int i);

        /* renamed from: a */
        void mo3542a(Location location);

        /* renamed from: a */
        void mo3541a(Bundle bundle);

        /* renamed from: a */
        void mo3540a(@NonNull ConnectionResult connectionResult);

        /* renamed from: a */
        void mo3539a(@NonNull LocationSettingsResult locationSettingsResult);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GooglePlayServicesLocationSource(Context context, LocationRequest locationRequest, InterfaceC2820a interfaceC2820a) {
        this.f9391c = interfaceC2820a;
        this.f9390b = locationRequest;
        this.f9389a = new GoogleApiClient.Builder(context).addApi(LocationServices.API).addConnectionCallbacks(this).addOnConnectionFailedListener(this).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m3554a() {
        return this.f9389a.isConnected();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m3551b() {
        this.f9389a.connect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public void m3550c() {
        this.f9389a.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public void m3549d() {
        this.f9389a.unregisterConnectionCallbacks(this);
        this.f9389a.unregisterConnectionFailedListener(this);
        if (this.f9389a.isConnected()) {
            m3546g();
        }
        this.f9389a.disconnect();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public void m3548e() {
        LocationServices.SettingsApi.checkLocationSettings(this.f9389a, new LocationSettingsRequest.Builder().addLocationRequest(this.f9390b).build()).setResultCallback(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m3553a(Status status, Activity activity) throws IntentSender.SendIntentException {
        status.startResolutionForResult(activity, 26);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m3547f() {
        LocationServices.FusedLocationApi.requestLocationUpdates(this.f9389a, this.f9390b, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public void m3546g() {
        LocationServices.FusedLocationApi.removeLocationUpdates(this.f9389a, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean m3545h() {
        LocationAvailability locationAvailability = LocationServices.FusedLocationApi.getLocationAvailability(this.f9389a);
        return locationAvailability != null && locationAvailability.isLocationAvailable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public Location m3544i() {
        return LocationServices.FusedLocationApi.getLastLocation(this.f9389a);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(@Nullable Bundle bundle) {
        InterfaceC2820a interfaceC2820a = this.f9391c;
        if (interfaceC2820a != null) {
            interfaceC2820a.mo3541a(bundle);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        InterfaceC2820a interfaceC2820a = this.f9391c;
        if (interfaceC2820a != null) {
            interfaceC2820a.mo3543a(i);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        InterfaceC2820a interfaceC2820a = this.f9391c;
        if (interfaceC2820a != null) {
            interfaceC2820a.mo3540a(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    /* renamed from: a */
    public void onResult(@NonNull LocationSettingsResult locationSettingsResult) {
        InterfaceC2820a interfaceC2820a = this.f9391c;
        if (interfaceC2820a != null) {
            interfaceC2820a.mo3539a(locationSettingsResult);
        }
    }

    @Override // com.google.android.gms.location.LocationListener
    public void onLocationChanged(Location location) {
        InterfaceC2820a interfaceC2820a = this.f9391c;
        if (interfaceC2820a != null) {
            interfaceC2820a.mo3542a(location);
        }
    }
}
