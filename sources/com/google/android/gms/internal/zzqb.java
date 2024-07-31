package com.google.android.gms.internal;

import android.support.p008v4.util.SimpleArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzqb extends zzqe<com.google.android.gms.common.api.zzc> {

    /* renamed from: wv */
    private int f3093wv;

    /* renamed from: ww */
    private boolean f3094ww;

    private void zza(ConnectionResult connectionResult) {
        int i = 0;
        while (true) {
            SimpleArrayMap simpleArrayMap = null;
            if (i >= simpleArrayMap.size()) {
                return;
            }
            zza((zzpz) simpleArrayMap.keyAt(i), connectionResult);
            i++;
        }
    }

    public void zza(zzpz<?> zzpzVar, ConnectionResult connectionResult) {
        SimpleArrayMap simpleArrayMap = null;
        synchronized (simpleArrayMap) {
            simpleArrayMap.put(zzpzVar, connectionResult);
            this.f3093wv--;
            if (!connectionResult.isSuccess()) {
                this.f3094ww = true;
            }
            if (this.f3093wv == 0) {
                Status status = this.f3094ww ? new Status(13) : Status.f2684vY;
                zzc((zzqb) (simpleArrayMap.size() == 1 ? new com.google.android.gms.common.api.zzb(status, null) : new com.google.android.gms.common.api.zzc(status, null)));
            }
        }
    }

    public Set<zzpz<?>> zzaqm() {
        Map map = null;
        return map.keySet();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzqe
    /* renamed from: zzy */
    public com.google.android.gms.common.api.zzc zzc(Status status) {
        com.google.android.gms.common.api.zzc zzbVar;
        SimpleArrayMap simpleArrayMap = null;
        synchronized (simpleArrayMap) {
            zza(new ConnectionResult(8));
            zzbVar = simpleArrayMap.size() == 1 ? new com.google.android.gms.common.api.zzb(status, null) : new com.google.android.gms.common.api.zzc(status, null);
        }
        return zzbVar;
    }
}
