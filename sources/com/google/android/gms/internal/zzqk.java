package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

/* loaded from: classes.dex */
public abstract class zzqk implements Releasable, Result {

    /* renamed from: fp */
    protected final Status f3139fp;

    /* renamed from: xi */
    protected final DataHolder f3140xi;

    protected zzqk(DataHolder dataHolder, Status status) {
        this.f3139fp = status;
        this.f3140xi = dataHolder;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f3139fp;
    }

    @Override // com.google.android.gms.common.api.Releasable
    public void release() {
        DataHolder dataHolder = this.f3140xi;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }
}
