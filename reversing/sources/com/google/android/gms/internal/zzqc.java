package com.google.android.gms.internal;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class zzqc {

    /* loaded from: classes.dex */
    public static abstract class zza<R extends Result, A extends Api.zzb> extends zzqe<R> implements zzb<R> {

        /* renamed from: tv */
        private final Api<?> f3095tv;

        /* renamed from: wx */
        private final Api.zzc<A> f3096wx;

        @Deprecated
        protected zza(Api.zzc<A> zzcVar, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzac.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.f3096wx = (Api.zzc) com.google.android.gms.common.internal.zzac.zzy(zzcVar);
            this.f3095tv = null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(Api<?> api, GoogleApiClient googleApiClient) {
            super((GoogleApiClient) com.google.android.gms.common.internal.zzac.zzb(googleApiClient, "GoogleApiClient must not be null"));
            this.f3096wx = (Api.zzc<A>) api.zzapp();
            this.f3095tv = api;
        }

        private void zza(RemoteException remoteException) {
            zzz(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.internal.zzqc.zzb
        public /* synthetic */ void setResult(Object obj) {
            super.zzc((zza<R, A>) ((Result) obj));
        }

        protected abstract void zza(A a) throws RemoteException;

        public final Api.zzc<A> zzapp() {
            return this.f3096wx;
        }

        public final Api<?> zzaqn() {
            return this.f3095tv;
        }

        public final void zzb(A a) throws DeadObjectException {
            try {
                zza((zza<R, A>) a);
            } catch (DeadObjectException e) {
                zza(e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        protected void zzb(R r) {
        }

        @Override // com.google.android.gms.internal.zzqc.zzb
        public final void zzz(Status status) {
            com.google.android.gms.common.internal.zzac.zzb(!status.isSuccess(), "Failed result must not be success");
            R zzc = zzc(status);
            zzc((zza<R, A>) zzc);
            zzb((zza<R, A>) zzc);
        }
    }

    /* loaded from: classes.dex */
    public interface zzb<R> {
        void setResult(R r);

        void zzz(Status status);
    }
}
