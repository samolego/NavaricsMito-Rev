package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Executor aBG;
    private final Continuation<TResult, TContinuationResult> aJu;
    private final zzh<TContinuationResult> aJv;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> zzhVar) {
        this.aBG = executor;
        this.aJu = continuation;
        this.aJv = zzhVar;
    }

    @Override // com.google.android.gms.tasks.zzf
    public void cancel() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.tasks.zzf
    public void onComplete(@NonNull final Task<TResult> task) {
        this.aBG.execute(new Runnable() { // from class: com.google.android.gms.tasks.zza.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Exception] */
            /* JADX WARN: Type inference failed for: r1v11, types: [com.google.android.gms.tasks.zzh] */
            @Override // java.lang.Runnable
            public void run() {
                zzh zzhVar;
                RuntimeExecutionException runtimeExecutionException;
                try {
                    zza.this.aJv.setResult(zza.this.aJu.then(task));
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzh zzhVar2 = zza.this.aJv;
                        runtimeExecutionException = (Exception) e.getCause();
                        zzhVar = zzhVar2;
                    } else {
                        runtimeExecutionException = e;
                        zzhVar = zza.this.aJv;
                    }
                    zzhVar.setException(runtimeExecutionException);
                } catch (Exception e2) {
                    zza.this.aJv.setException(e2);
                }
            }
        });
    }
}
