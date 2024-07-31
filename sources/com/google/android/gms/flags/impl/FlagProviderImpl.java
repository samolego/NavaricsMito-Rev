package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.flags.impl.zza;
import com.google.android.gms.internal.zzuz;

@DynamiteApi
/* loaded from: classes.dex */
public class FlagProviderImpl extends zzuz.zza {
    private boolean zzaom = false;
    private SharedPreferences zzbak;

    @Override // com.google.android.gms.internal.zzuz
    public boolean getBooleanFlagValue(String str, boolean z, int i) {
        return !this.zzaom ? z : zza.C3248zza.zza(this.zzbak, str, Boolean.valueOf(z)).booleanValue();
    }

    @Override // com.google.android.gms.internal.zzuz
    public int getIntFlagValue(String str, int i, int i2) {
        return !this.zzaom ? i : zza.zzb.zza(this.zzbak, str, Integer.valueOf(i)).intValue();
    }

    @Override // com.google.android.gms.internal.zzuz
    public long getLongFlagValue(String str, long j, int i) {
        return !this.zzaom ? j : zza.zzc.zza(this.zzbak, str, Long.valueOf(j)).longValue();
    }

    @Override // com.google.android.gms.internal.zzuz
    public String getStringFlagValue(String str, String str2, int i) {
        return !this.zzaom ? str2 : zza.zzd.zza(this.zzbak, str, str2);
    }

    @Override // com.google.android.gms.internal.zzuz
    public void init(zzd zzdVar) {
        Context context = (Context) zze.zzae(zzdVar);
        if (this.zzaom) {
            return;
        }
        try {
            this.zzbak = zzb.zzn(context.createPackageContext("com.google.android.gms", 0));
            this.zzaom = true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
