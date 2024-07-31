package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class zze implements zzn {
    private final Executor zzr;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class zza implements Runnable {
        private final zzk zzu;
        private final zzm zzv;
        private final Runnable zzw;

        public zza(zzk zzkVar, zzm zzmVar, Runnable runnable) {
            this.zzu = zzkVar;
            this.zzv = zzmVar;
            this.zzw = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.zzu.isCanceled()) {
                this.zzu.zzd("canceled-at-delivery");
                return;
            }
            if (this.zzv.isSuccess()) {
                this.zzu.zza((zzk) this.zzv.result);
            } else {
                this.zzu.zzc(this.zzv.zzbg);
            }
            if (this.zzv.zzbh) {
                this.zzu.zzc("intermediate-response");
            } else {
                this.zzu.zzd("done");
            }
            Runnable runnable = this.zzw;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public zze(final Handler handler) {
        this.zzr = new Executor() { // from class: com.google.android.gms.internal.zze.1
            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    @Override // com.google.android.gms.internal.zzn
    public void zza(zzk<?> zzkVar, zzm<?> zzmVar) {
        zza(zzkVar, zzmVar, null);
    }

    @Override // com.google.android.gms.internal.zzn
    public void zza(zzk<?> zzkVar, zzm<?> zzmVar, Runnable runnable) {
        zzkVar.zzu();
        zzkVar.zzc("post-response");
        this.zzr.execute(new zza(zzkVar, zzmVar, runnable));
    }

    @Override // com.google.android.gms.internal.zzn
    public void zza(zzk<?> zzkVar, zzr zzrVar) {
        zzkVar.zzc("post-error");
        this.zzr.execute(new zza(zzkVar, zzm.zzd(zzrVar), null));
    }
}
