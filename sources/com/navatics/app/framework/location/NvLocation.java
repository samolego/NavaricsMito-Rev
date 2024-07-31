package com.navatics.app.framework.location;

import android.location.Address;
import android.location.Location;
import io.reactivex.Observable;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.navatics.app.framework.location.b */
/* loaded from: classes.dex */
public class NvLocation {

    /* renamed from: a */
    INvLocationProvider f4694a;

    /* renamed from: b */
    int f4695b;

    /* renamed from: c */
    int f4696c;

    /* renamed from: e */
    Location f4698e;

    /* renamed from: f */
    List<InterfaceC1835a> f4699f = new ArrayList();

    /* renamed from: d */
    long f4697d = System.currentTimeMillis();

    /* compiled from: NvLocation.java */
    /* renamed from: com.navatics.app.framework.location.b$a */
    /* loaded from: classes.dex */
    interface InterfaceC1835a {
    }

    public NvLocation(INvLocationProvider iNvLocationProvider, int i, int i2, Location location) {
        this.f4694a = iNvLocationProvider;
        this.f4695b = i;
        this.f4696c = i2;
        this.f4698e = location;
    }

    /* renamed from: a */
    public Location m8008a() {
        return this.f4698e;
    }

    /* renamed from: b */
    public Observable<Address> m8006b() {
        return this.f4694a.mo8012a(this.f4698e);
    }

    public void addOnAddressAvailableListener(InterfaceC1835a interfaceC1835a) {
        if (interfaceC1835a != null) {
            this.f4699f.add(interfaceC1835a);
        }
    }

    /* renamed from: a */
    public void m8007a(Location location) {
        this.f4698e = location;
        this.f4697d = System.currentTimeMillis();
    }
}
