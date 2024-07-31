package com.google.android.gms.common.util;

import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzac;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzv {
    public static String[] zza(Scope[] scopeArr) {
        zzac.zzb(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i = 0; i < scopeArr.length; i++) {
            strArr[i] = scopeArr[i].zzaqg();
        }
        return strArr;
    }

    public static String[] zzd(Set<Scope> set) {
        zzac.zzb(set, "scopes can't be null.");
        return zza((Scope[]) set.toArray(new Scope[set.size()]));
    }
}
