package com.google.android.gms.internal;

import com.google.android.gms.common.ConnectionResult;
import java.util.Iterator;

/* loaded from: classes.dex */
public class zzqi extends zzqd {
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.zzqt, com.google.android.gms.common.util.zza] */
    @Override // com.google.android.gms.internal.zzqd, com.google.android.gms.internal.zzra
    public void onStop() {
        super.onStop();
        ?? r0 = 0;
        Iterator it = r0.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.zzd) it.next()).release();
        }
        r0.clear();
        r0.zza(this);
    }

    @Override // com.google.android.gms.internal.zzqd
    protected void zza(ConnectionResult connectionResult, int i) {
        zzqt zzqtVar = null;
        zzqtVar.zza(connectionResult, i);
    }

    @Override // com.google.android.gms.internal.zzqd
    protected void zzaqk() {
        zzqt zzqtVar = null;
        zzqtVar.zzaqk();
    }
}
