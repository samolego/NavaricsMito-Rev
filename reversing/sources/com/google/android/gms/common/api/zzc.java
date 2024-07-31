package com.google.android.gms.common.api;

import android.support.p008v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpz;

/* loaded from: classes.dex */
public class zzc implements Result {

    /* renamed from: fp */
    private final Status f2695fp;

    /* renamed from: vn */
    private final ArrayMap<zzpz<?>, ConnectionResult> f2696vn;

    public zzc(Status status, ArrayMap<zzpz<?>, ConnectionResult> arrayMap) {
        this.f2695fp = status;
        this.f2696vn = arrayMap;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f2695fp;
    }
}
