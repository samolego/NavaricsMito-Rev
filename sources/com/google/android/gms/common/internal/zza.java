package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzr;

/* loaded from: classes.dex */
public class zza extends zzr.zza {

    /* renamed from: AV */
    int f2799AV;

    public static Account zza(zzr zzrVar) {
        if (zzrVar != null) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzrVar.getAccount();
            } catch (RemoteException unused) {
                Log.w("AccountAccessor", "Remote account accessor probably died");
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zza) {
            zza zzaVar = (zza) obj;
            Account account = null;
            return account.equals(null);
        }
        return false;
    }

    @Override // com.google.android.gms.common.internal.zzr
    public Account getAccount() {
        int callingUid = Binder.getCallingUid();
        if (callingUid == this.f2799AV) {
            return null;
        }
        if (com.google.android.gms.common.zze.zzf(null, callingUid)) {
            this.f2799AV = callingUid;
            return null;
        }
        throw new SecurityException("Caller is not GooglePlayServices");
    }
}
