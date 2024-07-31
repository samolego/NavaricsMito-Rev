package com.google.android.gms.common.api;

import android.support.p008v4.util.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpz;

/* loaded from: classes.dex */
public class zzb extends zzc {

    /* renamed from: vm */
    private final ConnectionResult f2694vm;

    public zzb(Status status, ArrayMap<zzpz<?>, ConnectionResult> arrayMap) {
        super(status, arrayMap);
        this.f2694vm = arrayMap.get(arrayMap.keyAt(0));
    }
}
