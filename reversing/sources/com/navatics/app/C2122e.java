package com.navatics.app;

import android.location.Address;
import android.location.Location;
import com.navatics.app.activities.LocationActivity;
import com.navatics.app.framework.location.INvLocationProvider;
import com.navatics.app.framework.location.NvLocationManager;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.e */
/* loaded from: classes.dex */
public class PhoneLocationProvider implements INvLocationProvider {

    /* renamed from: a */
    private static final C3044k f4037a = C3044k.m1564a(PhoneLocationProvider.class);

    /* renamed from: e */
    private static PhoneLocationProvider f4038e;

    /* renamed from: b */
    private NvLocationManager f4039b;

    /* renamed from: c */
    private Location f4040c;

    /* renamed from: d */
    private boolean f4041d;

    public static /* synthetic */ void lambda$fHImF8mnmCro7I_ATkHzPMmiDyc(Location location, ObservableEmitter observableEmitter) {
        m8801a(location, observableEmitter);
    }

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: b */
    public int mo8010b() {
        return 1;
    }

    private PhoneLocationProvider() {
    }

    /* renamed from: a */
    public static PhoneLocationProvider m8803a() {
        if (f4038e == null) {
            f4038e = new PhoneLocationProvider();
        }
        return f4038e;
    }

    /* renamed from: a */
    public void m8802a(int i, Location location) {
        f4037a.mo1511a((Object) "updatePhoneLocation");
        this.f4040c = location;
        this.f4039b.m8000a(this, 1, i, location);
    }

    /* renamed from: a */
    public void m8800a(LocationActivity locationActivity) {
        C3044k c3044k = f4037a;
        c3044k.mo1511a((Object) (locationActivity.getClass().getSimpleName() + " : handleRequestIfAny 1"));
        if (this.f4041d) {
            C3044k c3044k2 = f4037a;
            c3044k2.mo1511a((Object) (locationActivity.getClass().getSimpleName() + " : handleRequestIfAny, getLocation"));
            locationActivity.m9387a();
            this.f4041d = false;
        }
    }

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: a */
    public void mo8011a(NvLocationManager nvLocationManager) {
        this.f4039b = nvLocationManager;
    }

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: c */
    public void mo8009c() {
        LocationActivity m9570a = NavaticsApplication.m9567b().m9570a();
        if (m9570a != null) {
            m9570a.m9387a();
            this.f4041d = false;
            C3044k c3044k = f4037a;
            c3044k.mo1511a((Object) ("requestLocationUpdate with active LocationActivity : " + m9570a.getClass().getSimpleName()));
            return;
        }
        this.f4041d = true;
        f4037a.mo1511a((Object) "requestLocationUpdate");
    }

    @Override // com.navatics.app.framework.location.INvLocationProvider
    /* renamed from: a */
    public Observable<Address> mo8012a(final Location location) {
        return Observable.m3097a(new ObservableOnSubscribe() { // from class: com.navatics.app.-$$Lambda$e$fHImF8mnmCro7I_ATkHzPMmiDyc
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                PhoneLocationProvider.lambda$fHImF8mnmCro7I_ATkHzPMmiDyc(location, observableEmitter);
            }
        });
    }

    /* renamed from: a */
    public static /* synthetic */ void m8801a(Location location, ObservableEmitter observableEmitter) throws Exception {
        LocationActivity m9570a = NavaticsApplication.m9567b().m9570a();
        if (m9570a == null) {
            throw new RuntimeException("No LocationActivity available");
        }
        Address m9385b = m9570a.m9385b(location);
        if (m9385b == null) {
            throw new RuntimeException("Can't resolve address for location.");
        }
        observableEmitter.onNext(m9385b);
        observableEmitter.onComplete();
    }
}
