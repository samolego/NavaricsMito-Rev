package com.google.android.gms.common.internal;

import android.util.Log;

/* loaded from: classes.dex */
public final class zzq {

    /* renamed from: CO */
    public static final int f2907CO = 15;

    /* renamed from: CP */
    private static final String f2908CP = null;

    /* renamed from: CQ */
    private final String f2909CQ;

    /* renamed from: CR */
    private final String f2910CR;

    public zzq(String str) {
        this(str, null);
    }

    public zzq(String str, String str2) {
        zzac.zzb(str, "log tag cannot be null");
        zzac.zzb(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.f2909CQ = str;
        if (str2 == null || str2.length() <= 0) {
            this.f2910CR = null;
        } else {
            this.f2910CR = str2;
        }
    }

    private String zzhx(String str) {
        String str2 = this.f2910CR;
        return str2 == null ? str : str2.concat(str);
    }

    public void zzae(String str, String str2) {
        if (zzgp(3)) {
            Log.d(str, zzhx(str2));
        }
    }

    public void zzaf(String str, String str2) {
        if (zzgp(5)) {
            Log.w(str, zzhx(str2));
        }
    }

    public void zzag(String str, String str2) {
        if (zzgp(6)) {
            Log.e(str, zzhx(str2));
        }
    }

    public void zzb(String str, String str2, Throwable th) {
        if (zzgp(4)) {
            Log.i(str, zzhx(str2), th);
        }
    }

    public void zzc(String str, String str2, Throwable th) {
        if (zzgp(5)) {
            Log.w(str, zzhx(str2), th);
        }
    }

    public void zzd(String str, String str2, Throwable th) {
        if (zzgp(6)) {
            Log.e(str, zzhx(str2), th);
        }
    }

    public void zze(String str, String str2, Throwable th) {
        if (zzgp(7)) {
            Log.e(str, zzhx(str2), th);
            Log.wtf(str, zzhx(str2), th);
        }
    }

    public boolean zzgp(int i) {
        return Log.isLoggable(this.f2909CQ, i);
    }
}
