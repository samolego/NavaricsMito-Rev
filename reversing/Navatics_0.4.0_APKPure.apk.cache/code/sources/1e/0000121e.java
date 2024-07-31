package com.google.android.gms.internal;

/* loaded from: classes.dex */
public class zzr extends Exception {
    private long zzab;
    public final zzi zzbi;

    public zzr() {
        this.zzbi = null;
    }

    public zzr(zzi zziVar) {
        this.zzbi = zziVar;
    }

    public zzr(Throwable th) {
        super(th);
        this.zzbi = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(long j) {
        this.zzab = j;
    }
}