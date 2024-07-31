package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzre;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class zzd<O extends Api.ApiOptions> {
    private final Context mContext;
    private final int mId;

    /* renamed from: tv */
    private final Api<O> f2697tv;

    /* renamed from: vA */
    private final AtomicBoolean f2698vA;

    /* renamed from: vB */
    private final AtomicInteger f2699vB;

    /* renamed from: vC */
    private Api.zze f2700vC;

    /* renamed from: vv */
    private final zzre f2701vv;

    /* renamed from: vw */
    private final O f2702vw;

    /* renamed from: vx */
    private final zzpz<O> f2703vx;

    /* renamed from: vy */
    private final zzqt f2704vy;

    /* renamed from: vz */
    private final GoogleApiClient f2705vz;
    private final Looper zzajn;

    public zzd(@NonNull Context context, Api<O> api, O o) {
        this(context, api, o, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    public zzd(@NonNull Context context, Api<O> api, O o, Looper looper) {
        this.f2698vA = new AtomicBoolean(false);
        this.f2699vB = new AtomicInteger(0);
        zzac.zzb(context, "Null context is not permitted.");
        zzac.zzb(api, "Api must not be null.");
        zzac.zzb(looper, "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.f2697tv = api;
        this.f2702vw = o;
        this.zzajn = looper;
        this.f2701vv = new zzre();
        this.f2703vx = zzpz.zza(this.f2697tv, this.f2702vw);
        this.f2705vz = new zzqu(this);
        Pair<zzqt, Integer> zza = zzqt.zza(this.mContext, (zzd<?>) this);
        this.f2704vy = (zzqt) zza.first;
        this.mId = ((Integer) zza.second).intValue();
    }

    private <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zza(int i, @NonNull T t) {
        t.zzaqt();
        this.f2704vy.zza(this, i, (zzqc.zza<? extends Result, Api.zzb>) t);
        return t;
    }

    private <TResult, A extends Api.zzb> Task<TResult> zza(int i, @NonNull zzro<A, TResult> zzroVar) {
        TaskCompletionSource<TResult> taskCompletionSource = new TaskCompletionSource<>();
        this.f2704vy.zza(this, i, zzroVar, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public int getInstanceId() {
        return this.mId;
    }

    public Looper getLooper() {
        return this.zzajn;
    }

    public void release() {
        if (this.f2698vA.getAndSet(true)) {
            return;
        }
        this.f2701vv.release();
        this.f2704vy.zzd(this.mId, this.f2699vB.get() > 0);
    }

    /* JADX WARN: Type inference failed for: r11v2, types: [com.google.android.gms.common.api.Api$zze] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.common.api.Api$zzg] */
    @WorkerThread
    public Api.zze zza(Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (!zzapw()) {
            if (this.f2697tv.zzapq()) {
                Api.zzh<?, O> zzapo = this.f2697tv.zzapo();
                this.f2700vC = new zzai(this.mContext, looper, zzapo.zzapt(), connectionCallbacks, onConnectionFailedListener, com.google.android.gms.common.internal.zzh.zzcd(this.mContext), zzapo.zzr(this.f2702vw));
            } else {
                Api.zza<?, O> zzapn = this.f2697tv.zzapn();
                Context context = this.mContext;
                this.f2700vC = zzapn.zza(context, looper, com.google.android.gms.common.internal.zzh.zzcd(context), this.f2702vw, connectionCallbacks, onConnectionFailedListener);
            }
        }
        return this.f2700vC;
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zza(@NonNull T t) {
        return (T) zza(0, (int) t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zza(zzro<A, TResult> zzroVar) {
        return zza(0, zzroVar);
    }

    public void zzapu() {
        this.f2699vB.incrementAndGet();
    }

    public void zzapv() {
        if (this.f2699vB.decrementAndGet() == 0 && this.f2698vA.get()) {
            this.f2704vy.zzd(this.mId, false);
        }
    }

    public boolean zzapw() {
        return this.f2700vC != null;
    }

    public zzpz<O> zzapx() {
        return this.f2703vx;
    }

    public GoogleApiClient zzapy() {
        return this.f2705vz;
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzb(@NonNull T t) {
        return (T) zza(1, (int) t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zzb(zzro<A, TResult> zzroVar) {
        return zza(1, zzroVar);
    }
}
