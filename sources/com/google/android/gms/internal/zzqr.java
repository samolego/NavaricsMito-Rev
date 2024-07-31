package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public class zzqr implements zzqg, zzqy {
    private final Context mContext;

    /* renamed from: vQ */
    final Api.zza<? extends zzwz, zzxa> f3219vQ;

    /* renamed from: wV */
    final zzqp f3220wV;

    /* renamed from: xB */
    final com.google.android.gms.common.internal.zzh f3221xB;

    /* renamed from: xC */
    final Map<Api<?>, Integer> f3222xC;

    /* renamed from: xW */
    final Map<Api.zzc<?>, Api.zze> f3223xW;

    /* renamed from: xf */
    private final Lock f3224xf;

    /* renamed from: xn */
    private final com.google.android.gms.common.zzc f3225xn;

    /* renamed from: yj */
    private final Condition f3226yj;

    /* renamed from: yk */
    private final zzb f3227yk;

    /* renamed from: ym */
    private volatile zzqq f3229ym;

    /* renamed from: yo */
    int f3231yo;

    /* renamed from: yp */
    final zzqy.zza f3232yp;

    /* renamed from: yl */
    final Map<Api.zzc<?>, ConnectionResult> f3228yl = new HashMap();

    /* renamed from: yn */
    private ConnectionResult f3230yn = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class zza {

        /* renamed from: yq */
        private final zzqq f3233yq;

        /* JADX INFO: Access modifiers changed from: protected */
        public zza(zzqq zzqqVar) {
            this.f3233yq = zzqqVar;
        }

        protected abstract void zzari();

        public final void zzc(zzqr zzqrVar) {
            zzqrVar.f3224xf.lock();
            try {
                if (zzqrVar.f3229ym != this.f3233yq) {
                    return;
                }
                zzari();
            } finally {
                zzqrVar.f3224xf.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((zza) message.obj).zzc(zzqr.this);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Unknown message id: ");
                    sb.append(i);
                    Log.w("GACStateManager", sb.toString());
                    return;
            }
        }
    }

    public zzqr(Context context, zzqp zzqpVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zze> map, com.google.android.gms.common.internal.zzh zzhVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzwz, zzxa> zzaVar, ArrayList<zzqf> arrayList, zzqy.zza zzaVar2) {
        this.mContext = context;
        this.f3224xf = lock;
        this.f3225xn = zzcVar;
        this.f3223xW = map;
        this.f3221xB = zzhVar;
        this.f3222xC = map2;
        this.f3219vQ = zzaVar;
        this.f3220wV = zzqpVar;
        this.f3232yp = zzaVar2;
        Iterator<zzqf> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.f3227yk = new zzb(looper);
        this.f3226yj = lock.newCondition();
        this.f3229ym = new zzqo(this);
    }

    @Override // com.google.android.gms.internal.zzqy
    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.f3226yj.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f2638uJ;
        }
        ConnectionResult connectionResult = this.f3230yn;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.internal.zzqy
    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                disconnect();
                return new ConnectionResult(14, null);
            }
            try {
                nanos = this.f3226yj.awaitNanos(nanos);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
            Thread.currentThread().interrupt();
            return new ConnectionResult(15, null);
        }
        if (isConnected()) {
            return ConnectionResult.f2638uJ;
        }
        ConnectionResult connectionResult = this.f3230yn;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    @Override // com.google.android.gms.internal.zzqy
    public void connect() {
        this.f3229ym.connect();
    }

    @Override // com.google.android.gms.internal.zzqy
    public void disconnect() {
        if (this.f3229ym.disconnect()) {
            this.f3228yl.clear();
        }
    }

    @Override // com.google.android.gms.internal.zzqy
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.f3229ym);
        for (Api<?> api : this.f3222xC.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.getName()).println(":");
            this.f3223xW.get(api.zzapp()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.internal.zzqy
    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.zzc<?> zzapp = api.zzapp();
        if (this.f3223xW.containsKey(zzapp)) {
            if (this.f3223xW.get(zzapp).isConnected()) {
                return ConnectionResult.f2638uJ;
            }
            if (this.f3228yl.containsKey(zzapp)) {
                return this.f3228yl.get(zzapp);
            }
            return null;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.zzqy
    public boolean isConnected() {
        return this.f3229ym instanceof zzqm;
    }

    @Override // com.google.android.gms.internal.zzqy
    public boolean isConnecting() {
        return this.f3229ym instanceof zzqn;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnected(@Nullable Bundle bundle) {
        this.f3224xf.lock();
        try {
            this.f3229ym.onConnected(bundle);
        } finally {
            this.f3224xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public void onConnectionSuspended(int i) {
        this.f3224xf.lock();
        try {
            this.f3229ym.onConnectionSuspended(i);
        } finally {
            this.f3224xf.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqg
    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        this.f3224xf.lock();
        try {
            this.f3229ym.zza(connectionResult, api, i);
        } finally {
            this.f3224xf.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(zza zzaVar) {
        this.f3227yk.sendMessage(this.f3227yk.obtainMessage(1, zzaVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(RuntimeException runtimeException) {
        this.f3227yk.sendMessage(this.f3227yk.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.internal.zzqy
    public boolean zza(zzrl zzrlVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.zzqy
    public void zzaqb() {
    }

    @Override // com.google.android.gms.internal.zzqy
    public void zzaqy() {
        if (isConnected()) {
            ((zzqm) this.f3229ym).zzarh();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzarw() {
        this.f3224xf.lock();
        try {
            this.f3229ym = new zzqn(this, this.f3221xB, this.f3222xC, this.f3225xn, this.f3219vQ, this.f3224xf, this.mContext);
            this.f3229ym.begin();
            this.f3226yj.signalAll();
        } finally {
            this.f3224xf.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzarx() {
        this.f3224xf.lock();
        try {
            this.f3220wV.zzart();
            this.f3229ym = new zzqm(this);
            this.f3229ym.begin();
            this.f3226yj.signalAll();
        } finally {
            this.f3224xf.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzary() {
        for (Api.zze zzeVar : this.f3223xW.values()) {
            zzeVar.disconnect();
        }
    }

    @Override // com.google.android.gms.internal.zzqy
    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(@NonNull T t) {
        t.zzaqt();
        return (T) this.f3229ym.zzc(t);
    }

    @Override // com.google.android.gms.internal.zzqy
    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(@NonNull T t) {
        t.zzaqt();
        return (T) this.f3229ym.zzd(t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzi(ConnectionResult connectionResult) {
        this.f3224xf.lock();
        try {
            this.f3230yn = connectionResult;
            this.f3229ym = new zzqo(this);
            this.f3229ym.begin();
            this.f3226yj.signalAll();
        } finally {
            this.f3224xf.unlock();
        }
    }
}
