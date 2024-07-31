package com.google.android.gms.internal;

import android.app.Activity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public class zzrf extends zzqd {

    /* renamed from: wh */
    private TaskCompletionSource<Void> f3292wh;

    private zzrf(zzrb zzrbVar) {
        super(zzrbVar);
        this.f3292wh = new TaskCompletionSource<>();
        this.f3281yY.zza("GmsAvailabilityHelper", this);
    }

    public static zzrf zzu(Activity activity) {
        zzrb zzs = zzs(activity);
        zzrf zzrfVar = (zzrf) zzs.zza("GmsAvailabilityHelper", zzrf.class);
        if (zzrfVar != null) {
            if (zzrfVar.f3292wh.getTask().isComplete()) {
                zzrfVar.f3292wh = new TaskCompletionSource<>();
            }
            return zzrfVar;
        }
        return new zzrf(zzs);
    }

    public Task<Void> getTask() {
        return this.f3292wh.getTask();
    }

    @Override // com.google.android.gms.internal.zzra
    public void onDestroy() {
        super.onDestroy();
        this.f3292wh.setException(new CancellationException("Host activity was destroyed before Google Play services could be made available."));
    }

    @Override // com.google.android.gms.internal.zzqd
    protected void zza(ConnectionResult connectionResult, int i) {
        this.f3292wh.setException(com.google.android.gms.common.internal.zzb.zzl(connectionResult));
    }

    @Override // com.google.android.gms.internal.zzqd
    protected void zzaqk() {
        int isGooglePlayServicesAvailable = this.f3097vP.isGooglePlayServicesAvailable(this.f3281yY.zzasq());
        if (isGooglePlayServicesAvailable == 0) {
            this.f3292wh.setResult(null);
        } else {
            zzk(new ConnectionResult(isGooglePlayServicesAvailable, null));
        }
    }

    public void zzk(ConnectionResult connectionResult) {
        zzb(connectionResult, 0);
    }
}
