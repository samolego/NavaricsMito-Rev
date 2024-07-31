package com.google.android.gms.common.api;

import android.support.annotation.NonNull;

/* loaded from: classes.dex */
public class zza extends Exception {

    /* renamed from: fp */
    protected final Status f2693fp;

    public zza(@NonNull Status status) {
        super(status.getStatusMessage());
        this.f2693fp = status;
    }
}
