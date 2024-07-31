package com.navatics.app.framework.location;

import android.location.Location;
import android.util.SparseArray;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.p096b.Cancellable;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.C3044k;

/* renamed from: com.navatics.app.framework.location.c */
/* loaded from: classes.dex */
public class NvLocationManager {

    /* renamed from: a */
    private static final C3044k f4700a = C3044k.m1564a(NvLocationManager.class);

    /* renamed from: b */
    private static NvLocationManager f4701b;

    /* renamed from: c */
    private List<INvLocationProvider> f4702c = new ArrayList();

    /* renamed from: d */
    private SparseArray<NvLocation> f4703d = new SparseArray<>();

    /* renamed from: e */
    private List<AbstractC1837a> f4704e = new ArrayList();

    /* renamed from: f */
    private SparseArray<INvLocationProvider> f4705f = new SparseArray<>();

    public static /* synthetic */ void lambda$A9zzK8r3SuySt5Q8KJfXuLn6aiI(NvLocationManager nvLocationManager, AbstractC1837a abstractC1837a) {
        nvLocationManager.m7994c(abstractC1837a);
    }

    /* renamed from: lambda$pZXgytq5p-sGCSZ5m6rqUQrdbeU */
    public static /* synthetic */ void m13069lambda$pZXgytq5psGCSZ5m6rqUQrdbeU(NvLocationManager nvLocationManager, int i, ObservableEmitter observableEmitter) {
        nvLocationManager.m8002a(i, observableEmitter);
    }

    /* renamed from: lambda$rNk2FsEOg-AAVDwpV_qeBp-ygU8 */
    public static /* synthetic */ void m13070lambda$rNk2FsEOgAAVDwpV_qeBpygU8(NvLocation nvLocation, ObservableEmitter observableEmitter) {
        m7999a(nvLocation, observableEmitter);
    }

    /* compiled from: NvLocationManager.java */
    /* renamed from: com.navatics.app.framework.location.c$a */
    /* loaded from: classes.dex */
    public abstract class AbstractC1837a {

        /* renamed from: c */
        int f4708c;

        /* renamed from: a */
        abstract void mo7992a(NvLocation nvLocation);

        AbstractC1837a(int i) {
            NvLocationManager.this = r1;
            this.f4708c = i;
        }

        /* renamed from: a */
        public int m7993a() {
            return this.f4708c;
        }
    }

    private NvLocationManager() {
    }

    /* renamed from: a */
    public static synchronized NvLocationManager m8005a() {
        NvLocationManager nvLocationManager;
        synchronized (NvLocationManager.class) {
            if (f4701b == null) {
                f4701b = new NvLocationManager();
            }
            nvLocationManager = f4701b;
        }
        return nvLocationManager;
    }

    /* renamed from: a */
    public void m8001a(INvLocationProvider iNvLocationProvider) {
        if (iNvLocationProvider == null || this.f4702c.contains(iNvLocationProvider)) {
            return;
        }
        this.f4702c.add(iNvLocationProvider);
        this.f4705f.put(iNvLocationProvider.mo8010b(), iNvLocationProvider);
        iNvLocationProvider.mo8011a(this);
        C3044k c3044k = f4700a;
        c3044k.mo1511a((Object) ("register LocationProvider : " + iNvLocationProvider.getClass().getSimpleName()));
    }

    /* renamed from: a */
    public void m8000a(INvLocationProvider iNvLocationProvider, int i, int i2, Location location) {
        C3044k c3044k = f4700a;
        c3044k.mo1511a((Object) ("onLocationUpdate, Longitude " + location.getLongitude() + ", Latitude " + location.getLatitude()));
        NvLocation nvLocation = this.f4703d.get(i);
        if (nvLocation == null) {
            nvLocation = new NvLocation(iNvLocationProvider, i, i2, location);
            this.f4703d.put(i, nvLocation);
        } else {
            nvLocation.m8007a(location);
        }
        m8003a(i, nvLocation);
        if (i == 1 && this.f4703d.get(4) == null) {
            this.f4703d.put(4, nvLocation);
            m8003a(4, nvLocation);
        }
    }

    /* renamed from: a */
    private void m7998a(AbstractC1837a abstractC1837a) {
        f4700a.mo1511a((Object) "registerLocationUpdateCallback");
        this.f4704e.add(abstractC1837a);
        NvLocation nvLocation = this.f4703d.get(abstractC1837a.m7993a());
        if (nvLocation != null) {
            f4700a.mo1511a((Object) "registerLocationUpdateCallback. use cached value");
            abstractC1837a.mo7992a(nvLocation);
            return;
        }
        INvLocationProvider m7995c = m7995c(abstractC1837a.m7993a());
        C3044k c3044k = f4700a;
        StringBuilder sb = new StringBuilder();
        sb.append("registerLocationUpdateCallback. requestLocationUpdate, provider=");
        sb.append(m7995c != null ? m7995c.getClass().getSimpleName() : "null");
        c3044k.mo1511a((Object) sb.toString());
        if (m7995c != null) {
            m7995c.mo8009c();
        }
    }

    /* renamed from: c */
    private INvLocationProvider m7995c(int i) {
        INvLocationProvider iNvLocationProvider = this.f4705f.get(i);
        return (iNvLocationProvider == null && i == 4) ? this.f4705f.get(1) : iNvLocationProvider;
    }

    /* renamed from: b */
    public void m7994c(AbstractC1837a abstractC1837a) {
        f4700a.mo1511a((Object) "unregisterLocationUpdateCallback");
        if (abstractC1837a != null) {
            this.f4704e.remove(abstractC1837a);
        }
    }

    /* renamed from: a */
    private void m8003a(int i, NvLocation nvLocation) {
        for (AbstractC1837a abstractC1837a : this.f4704e) {
            if (abstractC1837a.m7993a() == i) {
                abstractC1837a.mo7992a(nvLocation);
            }
        }
    }

    /* renamed from: a */
    public NvLocation m8004a(int i) {
        NvLocation nvLocation = this.f4703d.get(i);
        return (nvLocation == null && i == 4) ? this.f4703d.get(1) : nvLocation;
    }

    /* renamed from: b */
    public Observable<NvLocation> m7997b(final int i) {
        final NvLocation m8004a = m8004a(i);
        if (m8004a != null) {
            return Observable.m3097a(new ObservableOnSubscribe() { // from class: com.navatics.app.framework.location.-$$Lambda$c$rNk2FsEOg-AAVDwpV_qeBp-ygU8
                @Override // io.reactivex.ObservableOnSubscribe
                public final void subscribe(ObservableEmitter observableEmitter) {
                    NvLocationManager.m13070lambda$rNk2FsEOgAAVDwpV_qeBpygU8(NvLocation.this, observableEmitter);
                }
            });
        }
        return Observable.m3097a(new ObservableOnSubscribe() { // from class: com.navatics.app.framework.location.-$$Lambda$c$pZXgytq5p-sGCSZ5m6rqUQrdbeU
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                NvLocationManager.m13069lambda$pZXgytq5psGCSZ5m6rqUQrdbeU(NvLocationManager.this, i, observableEmitter);
            }
        });
    }

    /* renamed from: a */
    public static /* synthetic */ void m7999a(NvLocation nvLocation, ObservableEmitter observableEmitter) throws Exception {
        observableEmitter.onNext(nvLocation);
        observableEmitter.onComplete();
    }

    /* renamed from: a */
    public /* synthetic */ void m8002a(int i, final ObservableEmitter observableEmitter) throws Exception {
        final AbstractC1837a abstractC1837a = new AbstractC1837a(i) { // from class: com.navatics.app.framework.location.c.1
            {
                NvLocationManager.this = this;
            }

            @Override // com.navatics.app.framework.location.NvLocationManager.AbstractC1837a
            /* renamed from: a */
            public void mo7992a(NvLocation nvLocation) {
                observableEmitter.onNext(nvLocation);
                observableEmitter.onComplete();
            }
        };
        observableEmitter.setCancellable(new Cancellable() { // from class: com.navatics.app.framework.location.-$$Lambda$c$A9zzK8r3SuySt5Q8KJfXuLn6aiI
            @Override // io.reactivex.p096b.Cancellable
            public final void cancel() {
                NvLocationManager.lambda$A9zzK8r3SuySt5Q8KJfXuLn6aiI(NvLocationManager.this, abstractC1837a);
            }
        });
        m7998a(abstractC1837a);
    }
}
