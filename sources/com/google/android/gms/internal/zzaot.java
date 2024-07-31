package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzaot<T> {
    public abstract void zza(zzaqa zzaqaVar, T t) throws IOException;

    public abstract T zzb(zzapy zzapyVar) throws IOException;

    public final zzaoh zzco(T t) {
        try {
            zzapp zzappVar = new zzapp();
            zza(zzappVar, t);
            return zzappVar.m9640br();
        } catch (IOException e) {
            throw new zzaoi(e);
        }
    }
}
