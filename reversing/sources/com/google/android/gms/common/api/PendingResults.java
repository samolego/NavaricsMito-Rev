package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrm;

/* loaded from: classes.dex */
public final class PendingResults {

    /* loaded from: classes.dex */
    private static final class zza<R extends Result> extends zzqe<R> {

        /* renamed from: vT */
        private final R f2680vT;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.f2680vT = r;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzqe
        public R zzc(Status status) {
            if (status.getStatusCode() == this.f2680vT.getStatus().getStatusCode()) {
                return this.f2680vT;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    /* loaded from: classes.dex */
    private static final class zzb<R extends Result> extends zzqe<R> {

        /* renamed from: vU */
        private final R f2681vU;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f2681vU = r;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzqe
        public R zzc(Status status) {
            return this.f2681vU;
        }
    }

    /* loaded from: classes.dex */
    private static final class zzc<R extends Result> extends zzqe<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.zzqe
        public R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzrm zzrmVar = new zzrm(Looper.getMainLooper());
        zzrmVar.cancel();
        return zzrmVar;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzac.zzb(r, "Result must not be null");
        zzac.zzb(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        zza zzaVar = new zza(r);
        zzaVar.cancel();
        return zzaVar;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzac.zzb(r, "Result must not be null");
        zzc zzcVar = new zzc(null);
        zzcVar.zzc((zzc) r);
        return new zzrg(zzcVar);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzac.zzb(status, "Result must not be null");
        zzrm zzrmVar = new zzrm(Looper.getMainLooper());
        zzrmVar.zzc((zzrm) status);
        return zzrmVar;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzac.zzb(r, "Result must not be null");
        zzac.zzb(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        zzb zzbVar = new zzb(googleApiClient, r);
        zzbVar.zzc((zzb) r);
        return zzbVar;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzac.zzb(status, "Result must not be null");
        zzrm zzrmVar = new zzrm(googleApiClient);
        zzrmVar.zzc((zzrm) status);
        return zzrmVar;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzac.zzb(r, "Result must not be null");
        zzc zzcVar = new zzc(googleApiClient);
        zzcVar.zzc((zzc) r);
        return new zzrg(zzcVar);
    }
}
