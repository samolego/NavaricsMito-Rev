package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.p008v4.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class zzpy {

    /* renamed from: lN */
    public final int f3073lN;

    /* renamed from: wf */
    public final int f3074wf;

    /* loaded from: classes.dex */
    private static abstract class zza extends zzpy {

        /* renamed from: wg */
        protected final SparseArray<Map<zzrd.zzb<?>, zzri>> f3075wg;

        /* renamed from: wh */
        protected final TaskCompletionSource<Void> f3076wh;

        public zza(int i, int i2, TaskCompletionSource<Void> taskCompletionSource, SparseArray<Map<zzrd.zzb<?>, zzri>> sparseArray) {
            super(i, i2);
            this.f3075wg = sparseArray;
            this.f3076wh = taskCompletionSource;
        }

        private void zza(RemoteException remoteException) {
            zzx(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @Override // com.google.android.gms.internal.zzpy
        public boolean cancel() {
            this.f3076wh.setException(new com.google.android.gms.common.api.zza(Status.f2688wc));
            return true;
        }

        @Override // com.google.android.gms.internal.zzpy
        public void zza(SparseArray<zzrq> sparseArray) {
        }

        protected abstract void zza(Api.zzb zzbVar) throws RemoteException;

        @Override // com.google.android.gms.internal.zzpy
        public final void zzb(Api.zzb zzbVar) throws DeadObjectException {
            try {
                zza(zzbVar);
            } catch (DeadObjectException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.zzpy
        public void zzx(@NonNull Status status) {
            this.f3076wh.setException(new com.google.android.gms.common.api.zza(status));
        }
    }

    /* loaded from: classes.dex */
    public static class zzb<A extends zzqc.zza<? extends Result, Api.zzb>> extends zzpy {

        /* renamed from: wi */
        protected final A f3077wi;

        public zzb(int i, int i2, A a) {
            super(i, i2);
            this.f3077wi = a;
        }

        @Override // com.google.android.gms.internal.zzpy
        public boolean cancel() {
            return this.f3077wi.zzaqq();
        }

        @Override // com.google.android.gms.internal.zzpy
        public void zza(SparseArray<zzrq> sparseArray) {
            zzrq zzrqVar = sparseArray.get(this.f3074wf);
            if (zzrqVar != null) {
                zzrqVar.zzb(this.f3077wi);
            }
        }

        @Override // com.google.android.gms.internal.zzpy
        public void zzb(Api.zzb zzbVar) throws DeadObjectException {
            this.f3077wi.zzb(zzbVar);
        }

        @Override // com.google.android.gms.internal.zzpy
        public void zzx(@NonNull Status status) {
            this.f3077wi.zzz(status);
        }
    }

    /* loaded from: classes.dex */
    public static final class zzc extends zza {

        /* renamed from: wj */
        public final zzrh<Api.zzb> f3078wj;

        /* renamed from: wk */
        public final zzrr<Api.zzb> f3079wk;

        public zzc(int i, zzri zzriVar, TaskCompletionSource<Void> taskCompletionSource, SparseArray<Map<zzrd.zzb<?>, zzri>> sparseArray) {
            super(i, 3, taskCompletionSource, sparseArray);
            this.f3078wj = zzriVar.f3294wj;
            this.f3079wk = zzriVar.f3295wk;
        }

        @Override // com.google.android.gms.internal.zzpy.zza, com.google.android.gms.internal.zzpy
        public /* bridge */ /* synthetic */ boolean cancel() {
            return super.cancel();
        }

        @Override // com.google.android.gms.internal.zzpy.zza, com.google.android.gms.internal.zzpy
        public /* bridge */ /* synthetic */ void zza(SparseArray sparseArray) {
            super.zza(sparseArray);
        }

        @Override // com.google.android.gms.internal.zzpy.zza
        public void zza(Api.zzb zzbVar) throws DeadObjectException {
            this.f3078wj.zza(zzbVar, this.f3076wh);
            Map<zzrd.zzb<?>, zzri> map = this.f3075wg.get(this.f3074wf);
            if (map == null) {
                map = new ArrayMap<>(1);
                this.f3075wg.put(this.f3074wf, map);
            }
            String valueOf = String.valueOf(this.f3078wj.zzasr());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 12);
            sb.append("registered: ");
            sb.append(valueOf);
            Log.d("reg", sb.toString());
            if (this.f3078wj.zzasr() != null) {
                map.put(this.f3078wj.zzasr(), new zzri(this.f3078wj, this.f3079wk));
            }
        }

        @Override // com.google.android.gms.internal.zzpy.zza, com.google.android.gms.internal.zzpy
        public /* bridge */ /* synthetic */ void zzx(@NonNull Status status) {
            super.zzx(status);
        }
    }

    /* loaded from: classes.dex */
    public static final class zzd<TResult> extends zzpy {

        /* renamed from: wm */
        private static final Status f3080wm = new Status(8, "Connection to Google Play services was lost while executing the API call.");

        /* renamed from: wh */
        private final TaskCompletionSource<TResult> f3081wh;

        /* renamed from: wl */
        private final zzro<Api.zzb, TResult> f3082wl;

        public zzd(int i, int i2, zzro<Api.zzb, TResult> zzroVar, TaskCompletionSource<TResult> taskCompletionSource) {
            super(i, i2);
            this.f3081wh = taskCompletionSource;
            this.f3082wl = zzroVar;
        }

        @Override // com.google.android.gms.internal.zzpy
        public void zzb(Api.zzb zzbVar) throws DeadObjectException {
            try {
                this.f3082wl.zzb(zzbVar, this.f3081wh);
            } catch (DeadObjectException e) {
                zzx(f3080wm);
                throw e;
            } catch (RemoteException unused) {
                zzx(f3080wm);
            }
        }

        @Override // com.google.android.gms.internal.zzpy
        public void zzx(@NonNull Status status) {
            TaskCompletionSource<TResult> taskCompletionSource;
            Exception firebaseApiNotAvailableException;
            if (status.getStatusCode() == 8) {
                taskCompletionSource = this.f3081wh;
                firebaseApiNotAvailableException = new FirebaseException(status.getStatusMessage());
            } else {
                taskCompletionSource = this.f3081wh;
                firebaseApiNotAvailableException = new FirebaseApiNotAvailableException(status.getStatusMessage());
            }
            taskCompletionSource.setException(firebaseApiNotAvailableException);
        }
    }

    /* loaded from: classes.dex */
    public static final class zze extends zza {

        /* renamed from: wn */
        public final zzrr<Api.zzb> f3083wn;

        public zze(int i, zzrr<Api.zzb> zzrrVar, TaskCompletionSource<Void> taskCompletionSource, SparseArray<Map<zzrd.zzb<?>, zzri>> sparseArray) {
            super(i, 4, taskCompletionSource, sparseArray);
            this.f3083wn = zzrrVar;
        }

        @Override // com.google.android.gms.internal.zzpy.zza, com.google.android.gms.internal.zzpy
        public /* bridge */ /* synthetic */ boolean cancel() {
            return super.cancel();
        }

        @Override // com.google.android.gms.internal.zzpy.zza, com.google.android.gms.internal.zzpy
        public /* bridge */ /* synthetic */ void zza(SparseArray sparseArray) {
            super.zza(sparseArray);
        }

        @Override // com.google.android.gms.internal.zzpy.zza
        public void zza(Api.zzb zzbVar) throws DeadObjectException {
            Map<zzrd.zzb<?>, zzri> map = this.f3075wg.get(this.f3074wf);
            if (map == null || this.f3083wn.zzasr() == null) {
                Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
                this.f3076wh.setException(new com.google.android.gms.common.api.zza(Status.f2686wa));
                return;
            }
            map.remove(this.f3083wn.zzasr());
            this.f3083wn.zzc(zzbVar, this.f3076wh);
        }

        @Override // com.google.android.gms.internal.zzpy.zza, com.google.android.gms.internal.zzpy
        public /* bridge */ /* synthetic */ void zzx(@NonNull Status status) {
            super.zzx(status);
        }
    }

    public zzpy(int i, int i2) {
        this.f3074wf = i;
        this.f3073lN = i2;
    }

    public boolean cancel() {
        return true;
    }

    public void zza(SparseArray<zzrq> sparseArray) {
    }

    public abstract void zzb(Api.zzb zzbVar) throws DeadObjectException;

    public abstract void zzx(@NonNull Status status);
}
