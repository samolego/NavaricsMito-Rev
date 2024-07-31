package com.google.android.gms.auth.api.signin.internal;

/* loaded from: classes.dex */
public class zze {

    /* renamed from: hy */
    static int f2632hy = 31;

    /* renamed from: hz */
    private int f2633hz = 1;

    public int zzahv() {
        return this.f2633hz;
    }

    public zze zzbd(boolean z) {
        this.f2633hz = (f2632hy * this.f2633hz) + (z ? 1 : 0);
        return this;
    }

    public zze zzq(Object obj) {
        this.f2633hz = (f2632hy * this.f2633hz) + (obj == null ? 0 : obj.hashCode());
        return this;
    }
}
