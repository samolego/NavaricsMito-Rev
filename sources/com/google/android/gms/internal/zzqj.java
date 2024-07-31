package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.zzrd;

/* loaded from: classes.dex */
public abstract class zzqj<L> implements zzrd.zzc<L> {

    /* renamed from: xi */
    private final DataHolder f3138xi;

    protected zzqj(DataHolder dataHolder) {
        this.f3138xi = dataHolder;
    }

    protected abstract void zza(L l, DataHolder dataHolder);

    @Override // com.google.android.gms.internal.zzrd.zzc
    public void zzarg() {
        DataHolder dataHolder = this.f3138xi;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // com.google.android.gms.internal.zzrd.zzc
    public final void zzt(L l) {
        zza(l, this.f3138xi);
    }
}
