package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzh<TResult> extends Task<TResult> {
    private boolean aJK;
    private TResult aJL;
    private Exception aJM;
    private final Object zzakd = new Object();
    private final zzg<TResult> aJJ = new zzg<>();

    /* loaded from: classes.dex */
    private static class zza extends zzra {
        private final List<WeakReference<zzf<?>>> mListeners;

        private zza(zzrb zzrbVar) {
            super(zzrbVar);
            this.mListeners = new ArrayList();
            this.f3281yY.zza("TaskOnStopCallback", this);
        }

        public static zza zzv(Activity activity) {
            zzrb zzs = zzs(activity);
            zza zzaVar = (zza) zzs.zza("TaskOnStopCallback", zza.class);
            return zzaVar == null ? new zza(zzs) : zzaVar;
        }

        @Override // com.google.android.gms.internal.zzra
        @MainThread
        public void onStop() {
            synchronized (this.mListeners) {
                for (WeakReference<zzf<?>> weakReference : this.mListeners) {
                    zzf<?> zzfVar = weakReference.get();
                    if (zzfVar != null) {
                        zzfVar.cancel();
                    }
                }
                this.mListeners.clear();
            }
        }

        public <T> void zzb(zzf<T> zzfVar) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference<>(zzfVar));
            }
        }
    }

    private void zzclh() {
        zzac.zza(this.aJK, "Task is not yet complete");
    }

    private void zzcli() {
        zzac.zza(!this.aJK, "Task is already complete");
    }

    private void zzclj() {
        synchronized (this.zzakd) {
            if (this.aJK) {
                this.aJJ.zza(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzc zzcVar = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.aJJ.zza(zzcVar);
        zza.zzv(activity).zzb(zzcVar);
        zzclj();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.aJJ.zza(new zzc(executor, onCompleteListener));
        zzclj();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzd zzdVar = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.aJJ.zza(zzdVar);
        zza.zzv(activity).zzb(zzdVar);
        zzclj();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.aJJ.zza(new zzd(executor, onFailureListener));
        zzclj();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zze zzeVar = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.aJJ.zza(zzeVar);
        zza.zzv(activity).zzb(zzeVar);
        zzclj();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.aJJ.zza(new zze(executor, onSuccessListener));
        zzclj();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzh zzhVar = new zzh();
        this.aJJ.zza(new com.google.android.gms.tasks.zza(executor, continuation, zzhVar));
        zzclj();
        return zzhVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzh zzhVar = new zzh();
        this.aJJ.zza(new zzb(executor, continuation, zzhVar));
        zzclj();
        return zzhVar;
    }

    @Override // com.google.android.gms.tasks.Task
    @Nullable
    public Exception getException() {
        Exception exc;
        synchronized (this.zzakd) {
            exc = this.aJM;
        }
        return exc;
    }

    @Override // com.google.android.gms.tasks.Task
    public TResult getResult() {
        TResult tresult;
        synchronized (this.zzakd) {
            zzclh();
            if (this.aJM != null) {
                throw new RuntimeExecutionException(this.aJM);
            }
            tresult = this.aJL;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zzakd) {
            zzclh();
            if (cls.isInstance(this.aJM)) {
                throw cls.cast(this.aJM);
            }
            if (this.aJM != null) {
                throw new RuntimeExecutionException(this.aJM);
            }
            tresult = this.aJL;
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.aJK;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.aJK && this.aJM == null;
        }
        return z;
    }

    public void setException(@NonNull Exception exc) {
        zzac.zzb(exc, "Exception must not be null");
        synchronized (this.zzakd) {
            zzcli();
            this.aJK = true;
            this.aJM = exc;
        }
        this.aJJ.zza(this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.zzakd) {
            zzcli();
            this.aJK = true;
            this.aJL = tresult;
        }
        this.aJJ.zza(this);
    }
}
