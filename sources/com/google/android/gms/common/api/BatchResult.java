package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class BatchResult implements Result {

    /* renamed from: fp */
    private final Status f2658fp;

    /* renamed from: vr */
    private final PendingResult<?>[] f2659vr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f2658fp = status;
        this.f2659vr = pendingResultArr;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f2658fp;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzac.zzb(batchResultToken.mId < this.f2659vr.length, "The result token does not belong to this batch");
        return (R) this.f2659vr[batchResultToken.mId].await(0L, TimeUnit.MILLISECONDS);
    }
}
