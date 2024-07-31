package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class zzark {
    protected volatile int bqE = -1;

    public static final <T extends zzark> T zza(T t, byte[] bArr) throws zzarj {
        return (T) zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzark zzarkVar, byte[] bArr, int i, int i2) {
        try {
            zzard zzc = zzard.zzc(bArr, i, i2);
            zzarkVar.zza(zzc);
            zzc.m9597cO();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzark> T zzb(T t, byte[] bArr, int i, int i2) throws zzarj {
        try {
            zzarc zzb = zzarc.zzb(bArr, i, i2);
            t.zzb(zzb);
            zzb.zzagz(0);
            return t;
        } catch (zzarj e) {
            throw e;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzark zzarkVar) {
        byte[] bArr = new byte[zzarkVar.m9584db()];
        zza(zzarkVar, bArr, 0, bArr.length);
        return bArr;
    }

    @Override // 
    /* renamed from: cQ */
    public zzark clone() throws CloneNotSupportedException {
        return (zzark) super.clone();
    }

    /* renamed from: da */
    public int m9585da() {
        if (this.bqE < 0) {
            m9584db();
        }
        return this.bqE;
    }

    /* renamed from: db */
    public int m9584db() {
        int zzx = zzx();
        this.bqE = zzx;
        return zzx;
    }

    public String toString() {
        return zzarl.zzg(this);
    }

    public void zza(zzard zzardVar) throws IOException {
    }

    public abstract zzark zzb(zzarc zzarcVar) throws IOException;

    protected int zzx() {
        return 0;
    }
}
