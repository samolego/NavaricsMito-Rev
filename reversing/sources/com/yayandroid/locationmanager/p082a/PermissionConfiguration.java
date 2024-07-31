package com.yayandroid.locationmanager.p082a;

import com.yayandroid.locationmanager.p083b.C2818b;
import com.yayandroid.locationmanager.p086d.p087a.DialogProvider;
import com.yayandroid.locationmanager.p086d.p087a.SimpleMessageDialogProvider;
import com.yayandroid.locationmanager.p086d.p089c.DefaultPermissionProvider;
import com.yayandroid.locationmanager.p086d.p089c.PermissionProvider;

/* renamed from: com.yayandroid.locationmanager.a.e */
/* loaded from: classes2.dex */
public class PermissionConfiguration {

    /* renamed from: a */
    private final PermissionProvider f9350a;

    private PermissionConfiguration(C2816a c2816a) {
        this.f9350a = c2816a.f9354d;
    }

    /* renamed from: a */
    public PermissionProvider m3646a() {
        return this.f9350a;
    }

    /* compiled from: PermissionConfiguration.java */
    /* renamed from: com.yayandroid.locationmanager.a.e$a */
    /* loaded from: classes2.dex */
    public static class C2816a {

        /* renamed from: a */
        private String f9351a = "";

        /* renamed from: b */
        private String[] f9352b = Defaults.f9323a;

        /* renamed from: c */
        private DialogProvider f9353c;

        /* renamed from: d */
        private PermissionProvider f9354d;

        /* renamed from: a */
        public C2816a m3642a(String str) {
            this.f9351a = str;
            return this;
        }

        /* renamed from: a */
        public C2816a m3643a(PermissionProvider permissionProvider) {
            this.f9354d = permissionProvider;
            return this;
        }

        /* renamed from: a */
        public PermissionConfiguration m3645a() {
            if (this.f9353c == null && C2818b.m3623a(this.f9351a)) {
                this.f9353c = new SimpleMessageDialogProvider(this.f9351a);
            }
            if (this.f9354d == null) {
                this.f9354d = new DefaultPermissionProvider(this.f9352b, this.f9353c);
            }
            return new PermissionConfiguration(this);
        }
    }
}
