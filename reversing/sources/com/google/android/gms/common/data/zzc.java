package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;

/* loaded from: classes.dex */
public abstract class zzc {

    /* renamed from: xi */
    protected final DataHolder f2730xi;

    /* renamed from: zK */
    protected int f2731zK;

    /* renamed from: zL */
    private int f2732zL;

    public zzc(DataHolder dataHolder, int i) {
        this.f2730xi = (DataHolder) zzac.zzy(dataHolder);
        zzfz(i);
    }

    public boolean equals(Object obj) {
        if (obj instanceof zzc) {
            zzc zzcVar = (zzc) obj;
            return zzab.equal(Integer.valueOf(zzcVar.f2731zK), Integer.valueOf(this.f2731zK)) && zzab.equal(Integer.valueOf(zzcVar.f2732zL), Integer.valueOf(this.f2732zL)) && zzcVar.f2730xi == this.f2730xi;
        }
        return false;
    }

    protected boolean getBoolean(String str) {
        return this.f2730xi.zze(str, this.f2731zK, this.f2732zL);
    }

    protected byte[] getByteArray(String str) {
        return this.f2730xi.zzg(str, this.f2731zK, this.f2732zL);
    }

    protected float getFloat(String str) {
        return this.f2730xi.zzf(str, this.f2731zK, this.f2732zL);
    }

    protected int getInteger(String str) {
        return this.f2730xi.zzc(str, this.f2731zK, this.f2732zL);
    }

    protected long getLong(String str) {
        return this.f2730xi.zzb(str, this.f2731zK, this.f2732zL);
    }

    protected String getString(String str) {
        return this.f2730xi.zzd(str, this.f2731zK, this.f2732zL);
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.f2731zK), Integer.valueOf(this.f2732zL), this.f2730xi);
    }

    public boolean isDataValid() {
        return !this.f2730xi.isClosed();
    }

    protected void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.f2730xi.zza(str, this.f2731zK, this.f2732zL, charArrayBuffer);
    }

    protected int zzatc() {
        return this.f2731zK;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzfz(int i) {
        zzac.zzbr(i >= 0 && i < this.f2730xi.getCount());
        this.f2731zK = i;
        this.f2732zL = this.f2730xi.zzgb(this.f2731zK);
    }

    public boolean zzhm(String str) {
        return this.f2730xi.zzhm(str);
    }

    protected Uri zzhn(String str) {
        return this.f2730xi.zzh(str, this.f2731zK, this.f2732zL);
    }

    protected boolean zzho(String str) {
        return this.f2730xi.zzi(str, this.f2731zK, this.f2732zL);
    }
}
