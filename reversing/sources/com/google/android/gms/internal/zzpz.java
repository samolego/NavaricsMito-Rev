package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;

/* loaded from: classes.dex */
public final class zzpz<O extends Api.ApiOptions> {

    /* renamed from: tv */
    private final Api<O> f3084tv;

    /* renamed from: vw */
    private final O f3085vw;

    /* renamed from: wo */
    private final boolean f3086wo = false;

    /* renamed from: wp */
    private final int f3087wp;

    private zzpz(Api<O> api, O o) {
        this.f3084tv = api;
        this.f3085vw = o;
        this.f3087wp = com.google.android.gms.common.internal.zzab.hashCode(this.f3084tv, this.f3085vw);
    }

    public static <O extends Api.ApiOptions> zzpz<O> zza(Api<O> api, O o) {
        return new zzpz<>(api, o);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzpz) {
            zzpz zzpzVar = (zzpz) obj;
            return com.google.android.gms.common.internal.zzab.equal(this.f3084tv, zzpzVar.f3084tv) && com.google.android.gms.common.internal.zzab.equal(this.f3085vw, zzpzVar.f3085vw);
        }
        return false;
    }

    public int hashCode() {
        return this.f3087wp;
    }

    public String zzaqj() {
        return this.f3084tv.getName();
    }
}
