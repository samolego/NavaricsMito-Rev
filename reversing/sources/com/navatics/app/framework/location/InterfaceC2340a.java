package com.navatics.app.framework.location;

import android.location.Address;
import android.location.Location;
import io.reactivex.Observable;

/* renamed from: com.navatics.app.framework.location.a */
/* loaded from: classes.dex */
public interface INvLocationProvider {
    /* renamed from: a */
    Observable<Address> mo8012a(Location location);

    /* renamed from: a */
    void mo8011a(NvLocationManager nvLocationManager);

    /* renamed from: b */
    int mo8010b();

    /* renamed from: c */
    void mo8009c();
}
