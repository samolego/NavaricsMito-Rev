package com.yayandroid.locationmanager.p082a;

import android.support.annotation.Nullable;
import com.yayandroid.locationmanager.p082a.PermissionConfiguration;
import com.yayandroid.locationmanager.p086d.p089c.StubPermissionProvider;

/* renamed from: com.yayandroid.locationmanager.a.d */
/* loaded from: classes2.dex */
public class LocationConfiguration {

    /* renamed from: a */
    private final boolean f9342a;

    /* renamed from: b */
    private final PermissionConfiguration f9343b;

    /* renamed from: c */
    private final GooglePlayServicesConfiguration f9344c;

    /* renamed from: d */
    private final DefaultProviderConfiguration f9345d;

    private LocationConfiguration(C2814a c2814a) {
        this.f9342a = c2814a.f9346a;
        this.f9343b = c2814a.f9347b;
        this.f9344c = c2814a.f9348c;
        this.f9345d = c2814a.f9349d;
    }

    /* renamed from: a */
    public boolean m3658a() {
        return this.f9342a;
    }

    /* renamed from: b */
    public PermissionConfiguration m3657b() {
        return this.f9343b;
    }

    @Nullable
    /* renamed from: c */
    public GooglePlayServicesConfiguration m3656c() {
        return this.f9344c;
    }

    @Nullable
    /* renamed from: d */
    public DefaultProviderConfiguration m3655d() {
        return this.f9345d;
    }

    /* compiled from: LocationConfiguration.java */
    /* renamed from: com.yayandroid.locationmanager.a.d$a */
    /* loaded from: classes2.dex */
    public static class C2814a {

        /* renamed from: a */
        private boolean f9346a = false;

        /* renamed from: b */
        private PermissionConfiguration f9347b;

        /* renamed from: c */
        private GooglePlayServicesConfiguration f9348c;

        /* renamed from: d */
        private DefaultProviderConfiguration f9349d;

        /* renamed from: a */
        public C2814a m3650a(PermissionConfiguration permissionConfiguration) {
            this.f9347b = permissionConfiguration;
            return this;
        }

        /* renamed from: a */
        public C2814a m3652a(GooglePlayServicesConfiguration googlePlayServicesConfiguration) {
            this.f9348c = googlePlayServicesConfiguration;
            return this;
        }

        /* renamed from: a */
        public C2814a m3653a(DefaultProviderConfiguration defaultProviderConfiguration) {
            this.f9349d = defaultProviderConfiguration;
            return this;
        }

        /* renamed from: a */
        public LocationConfiguration m3654a() {
            if (this.f9348c == null && this.f9349d == null) {
                throw new IllegalStateException("You need to specify one of the provider configurations. Please see GooglePlayServicesConfiguration and DefaultProviderConfiguration");
            }
            if (this.f9347b == null) {
                this.f9347b = new PermissionConfiguration.C2816a().m3643a(new StubPermissionProvider()).m3645a();
            }
            return new LocationConfiguration(this);
        }
    }
}
