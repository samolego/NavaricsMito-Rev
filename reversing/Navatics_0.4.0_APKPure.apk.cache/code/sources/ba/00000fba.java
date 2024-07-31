package com.google.android.gms.auth.api.signin.internal;

/* loaded from: classes.dex */
public class zze {

    /* renamed from: hy */
    static int f2640hy = 31;

    /* renamed from: hz */
    private int f2641hz = 1;

    public int zzahv() {
        return this.f2641hz;
    }

    public zze zzbd(boolean z) {
        this.f2641hz = (f2640hy * this.f2641hz) + (z ? 1 : 0);
        return this;
    }

    public zze zzq(Object obj) {
        this.f2641hz = (f2640hy * this.f2641hz) + (obj == null ? 0 : obj.hashCode());
        return this;
    }
}