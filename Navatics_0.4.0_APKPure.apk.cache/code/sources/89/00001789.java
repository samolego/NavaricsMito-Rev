package com.navatics.app;

import android.location.Address;
import android.location.Location;
import com.navatics.app.activities.LocationActivity;
import com.navatics.app.framework.location.INvLocationProvider;
import com.navatics.app.framework.location.NvLocationManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import org.apache.log4j.Logger;

/* compiled from: PhoneLocationProvider.java */
/* renamed from: com.navatics.app.e, reason: use source file name */
/* loaded from: classes.dex */
public class PhoneLocationProvider implements INvLocationProvider {

    /* renamed from: a */
    private static final Logger f4058a = Logger.getLogger(PhoneLocationProvider.class);

    /* renamed from: e */
    private static PhoneLocationProvider f4059e;

    /* renamed from: b */
    private NvLocationManager f4060b;

    /* renamed from: c */
    private Location f4061c;

    /* renamed from: d */
    private boolean f4062d;

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: b */
    public int mo4158b() {
        return 1;
    }

    private PhoneLocationProvider() {
    }

    /* renamed from: a */
    public static PhoneLocationProvider m4152a() {
        if (f4059e == null) {
            f4059e = new PhoneLocationProvider();
        }
        return f4059e;
    }

    /* renamed from: a */
    public void m4155a(int i, Location location) {
        f4058a.conditionalLog3((Object) "updatePhoneLocation");
        this.f4061c = location;
        this.f4060b.m4936a(this, 1, i, location);
    }

    /* renamed from: a */
    public void m4156a(LocationActivity locationActivity) {
        f4058a.conditionalLog3((Object) (locationActivity.getClass().getSimpleName() + " : handleRequestIfAny 1"));
        if (this.f4062d) {
            f4058a.conditionalLog3((Object) (locationActivity.getClass().getSimpleName() + " : handleRequestIfAny, getLocation"));
            locationActivity.m3541a();
            this.f4062d = false;
        }
    }

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: a */
    public void mo4157a(NvLocationManager nvLocationManager) {
        this.f4060b = nvLocationManager;
    }

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: c */
    public void mo4159c() {
        LocationActivity m3360a = NavaticsApplication.m3359b().m3360a();
        if (m3360a != null) {
            m3360a.m3541a();
            this.f4062d = false;
            f4058a.conditionalLog3((Object) ("requestLocationUpdate with active LocationActivity : " + m3360a.getClass().getSimpleName()));
            return;
        }
        this.f4062d = true;
        f4058a.conditionalLog3((Object) "requestLocationUpdate");
    }

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: a */
    public Observable<Address> mo4154a(final Location location) {
        return Observable.create(new ObservableOnSubscribe() { // from class: com.navatics.app.-$$Lambda$e$fHImF8mnmCro7I_ATkHzPMmiDyc
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                PhoneLocationProvider.m4153a(location, observableEmitter);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m4153a(Location location, ObservableEmitter observableEmitter) throws Exception {
        LocationActivity m3360a = NavaticsApplication.m3359b().m3360a();
        if (m3360a == null) {
            throw new RuntimeException("No LocationActivity available");
        }
        Address m3547b = m3360a.m3547b(location);
        if (m3547b == null) {
            throw new RuntimeException("Can't resolve address for location.");
        }
        observableEmitter.onNext(m3547b);
        observableEmitter.onComplete();
    }
}