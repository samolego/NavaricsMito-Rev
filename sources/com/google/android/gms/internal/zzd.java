package com.google.android.gms.internal;

/* loaded from: classes.dex */
public class zzd implements zzo {
    private int zzn;
    private int zzo;
    private final int zzp;
    private final float zzq;

    public zzd() {
        this(2500, 1, 1.0f);
    }

    public zzd(int i, int i2, float f) {
        this.zzn = i;
        this.zzp = i2;
        this.zzq = f;
    }

    @Override // com.google.android.gms.internal.zzo
    public void zza(zzr zzrVar) throws zzr {
        this.zzo++;
        int i = this.zzn;
        this.zzn = (int) (i + (i * this.zzq));
        if (!zze()) {
            throw zzrVar;
        }
    }

    @Override // com.google.android.gms.internal.zzo
    public int zzc() {
        return this.zzn;
    }

    @Override // com.google.android.gms.internal.zzo
    public int zzd() {
        return this.zzo;
    }

    protected boolean zze() {
        return this.zzo <= this.zzp;
    }
}
