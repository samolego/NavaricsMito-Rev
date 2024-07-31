package com.google.android.gms.internal;

/* loaded from: classes.dex */
public final class zzapn implements zzaou {
    private final zzapb bkM;

    public zzapn(zzapb zzapbVar) {
        this.bkM = zzapbVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzaot<?> zza(zzapb zzapbVar, zzaob zzaobVar, zzapx<?> zzapxVar, zzaov zzaovVar) {
        Class<?> value = zzaovVar.value();
        if (zzaot.class.isAssignableFrom(value)) {
            return (zzaot) zzapbVar.zzb(zzapx.zzr(value)).mo9646bg();
        }
        if (zzaou.class.isAssignableFrom(value)) {
            return ((zzaou) zzapbVar.zzb(zzapx.zzr(value)).mo9646bg()).zza(zzaobVar, zzapxVar);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    @Override // com.google.android.gms.internal.zzaou
    public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
        zzaov zzaovVar = (zzaov) zzapxVar.m9638by().getAnnotation(zzaov.class);
        if (zzaovVar == null) {
            return null;
        }
        return (zzaot<T>) zza(this.bkM, zzaobVar, zzapxVar, zzaovVar);
    }
}
