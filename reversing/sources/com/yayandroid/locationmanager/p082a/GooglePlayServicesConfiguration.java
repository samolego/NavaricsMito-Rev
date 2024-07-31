package com.yayandroid.locationmanager.p082a;

import com.google.android.gms.location.LocationRequest;

/* renamed from: com.yayandroid.locationmanager.a.c */
/* loaded from: classes2.dex */
public class GooglePlayServicesConfiguration {

    /* renamed from: a */
    private final LocationRequest f9324a;

    /* renamed from: b */
    private final boolean f9325b;

    /* renamed from: c */
    private final boolean f9326c;

    /* renamed from: d */
    private final boolean f9327d;

    /* renamed from: e */
    private final boolean f9328e;

    /* renamed from: f */
    private final boolean f9329f;

    /* renamed from: g */
    private final boolean f9330g;

    /* renamed from: h */
    private final long f9331h;

    /* renamed from: i */
    private final int f9332i;

    private GooglePlayServicesConfiguration(C2812a c2812a) {
        this.f9324a = c2812a.f9333a;
        this.f9325b = c2812a.f9334b;
        this.f9326c = c2812a.f9335c;
        this.f9327d = c2812a.f9336d;
        this.f9328e = c2812a.f9337e;
        this.f9329f = c2812a.f9338f;
        this.f9330g = c2812a.f9339g;
        this.f9331h = c2812a.f9340h;
        this.f9332i = c2812a.f9341i;
    }

    /* renamed from: a */
    public LocationRequest m3678a() {
        return this.f9324a;
    }

    /* renamed from: b */
    public boolean m3677b() {
        return this.f9325b;
    }

    /* renamed from: c */
    public boolean m3676c() {
        return this.f9326c;
    }

    /* renamed from: d */
    public boolean m3675d() {
        return this.f9327d;
    }

    /* renamed from: e */
    public boolean m3674e() {
        return this.f9328e;
    }

    /* renamed from: f */
    public boolean m3673f() {
        return this.f9329f;
    }

    /* renamed from: g */
    public boolean m3672g() {
        return this.f9330g;
    }

    /* renamed from: h */
    public long m3671h() {
        return this.f9331h;
    }

    /* renamed from: i */
    public int m3670i() {
        return this.f9332i;
    }

    /* compiled from: GooglePlayServicesConfiguration.java */
    /* renamed from: com.yayandroid.locationmanager.a.c$a */
    /* loaded from: classes2.dex */
    public static class C2812a {

        /* renamed from: a */
        private LocationRequest f9333a = Defaults.m3679a();

        /* renamed from: b */
        private boolean f9334b = true;

        /* renamed from: c */
        private boolean f9335c = false;

        /* renamed from: d */
        private boolean f9336d = true;

        /* renamed from: e */
        private boolean f9337e = true;

        /* renamed from: f */
        private boolean f9338f = false;

        /* renamed from: g */
        private boolean f9339g = false;

        /* renamed from: h */
        private long f9340h = 20000;

        /* renamed from: i */
        private int f9341i = 2;

        /* renamed from: a */
        public C2812a m3667a(boolean z) {
            this.f9336d = z;
            return this;
        }

        /* renamed from: a */
        public GooglePlayServicesConfiguration m3669a() {
            return new GooglePlayServicesConfiguration(this);
        }
    }
}
