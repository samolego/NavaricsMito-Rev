package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.internal.zzqe;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class Batch extends zzqe<BatchResult> {

    /* renamed from: vo */
    private int f2651vo;

    /* renamed from: vp */
    private boolean f2652vp;

    /* renamed from: vq */
    private boolean f2653vq;

    /* renamed from: vr */
    private final PendingResult<?>[] f2654vr;
    private final Object zzakd;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: kv */
        private GoogleApiClient f2656kv;

        /* renamed from: vt */
        private List<PendingResult<?>> f2657vt = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.f2656kv = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.f2657vt.size());
            this.f2657vt.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.f2657vt, this.f2656kv);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzakd = new Object();
        this.f2651vo = list.size();
        this.f2654vr = new PendingResult[this.f2651vo];
        if (list.isEmpty()) {
            zzc((Batch) new BatchResult(Status.f2684vY, this.f2654vr));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult<?> pendingResult = list.get(i);
            this.f2654vr[i] = pendingResult;
            pendingResult.zza(new PendingResult.zza() { // from class: com.google.android.gms.common.api.Batch.1
                @Override // com.google.android.gms.common.api.PendingResult.zza
                public void zzv(Status status) {
                    synchronized (Batch.this.zzakd) {
                        if (Batch.this.isCanceled()) {
                            return;
                        }
                        if (status.isCanceled()) {
                            Batch.this.f2653vq = true;
                        } else if (!status.isSuccess()) {
                            Batch.this.f2652vp = true;
                        }
                        Batch.zzb(Batch.this);
                        if (Batch.this.f2651vo == 0) {
                            if (Batch.this.f2653vq) {
                                Batch.super.cancel();
                            } else {
                                Batch.this.zzc((Batch) new BatchResult(Batch.this.f2652vp ? new Status(13) : Status.f2684vY, Batch.this.f2654vr));
                            }
                        }
                    }
                }
            });
        }
    }

    static /* synthetic */ int zzb(Batch batch) {
        int i = batch.f2651vo;
        batch.f2651vo = i - 1;
        return i;
    }

    @Override // com.google.android.gms.internal.zzqe, com.google.android.gms.common.api.PendingResult
    public void cancel() {
        super.cancel();
        for (PendingResult<?> pendingResult : this.f2654vr) {
            pendingResult.cancel();
        }
    }

    @Override // com.google.android.gms.internal.zzqe
    /* renamed from: createFailedResult */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.f2654vr);
    }
}
