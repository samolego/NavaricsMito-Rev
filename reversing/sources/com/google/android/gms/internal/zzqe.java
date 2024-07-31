package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.internal.zzrq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zzqe<R extends Result> extends PendingResult<R> {

    /* renamed from: wF */
    static final ThreadLocal<Boolean> f3105wF = new ThreadLocal<Boolean>() { // from class: com.google.android.gms.internal.zzqe.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: zzaqv */
        public Boolean initialValue() {
            return false;
        }
    };

    /* renamed from: vU */
    private R f3106vU;

    /* renamed from: wG */
    private final Object f3107wG;

    /* renamed from: wH */
    protected final zza<R> f3108wH;

    /* renamed from: wI */
    protected final WeakReference<GoogleApiClient> f3109wI;

    /* renamed from: wJ */
    private final ArrayList<PendingResult.zza> f3110wJ;

    /* renamed from: wK */
    private ResultCallback<? super R> f3111wK;

    /* renamed from: wL */
    private final AtomicReference<zzrq.zzb> f3112wL;

    /* renamed from: wM */
    private zzb f3113wM;

    /* renamed from: wN */
    private volatile boolean f3114wN;

    /* renamed from: wO */
    private boolean f3115wO;

    /* renamed from: wP */
    private com.google.android.gms.common.internal.zzs f3116wP;

    /* renamed from: wQ */
    private volatile zzrp<R> f3117wQ;

    /* renamed from: wR */
    private boolean f3118wR;
    private boolean zzak;
    private final CountDownLatch zzamx;

    /* loaded from: classes.dex */
    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzqe) message.obj).zzaa(Status.f2687wb);
                    return;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzqe<R> zzqeVar, long j) {
            sendMessageDelayed(obtainMessage(2, zzqeVar), j);
        }

        public void zzaqw() {
            removeMessages(2);
        }

        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzqe.zze(r);
                throw e;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class zzb {
        private zzb() {
        }

        protected void finalize() throws Throwable {
            zzqe.zze(zzqe.this.f3106vU);
            super.finalize();
        }
    }

    @Deprecated
    zzqe() {
        this.f3107wG = new Object();
        this.zzamx = new CountDownLatch(1);
        this.f3110wJ = new ArrayList<>();
        this.f3112wL = new AtomicReference<>();
        this.f3118wR = false;
        this.f3108wH = new zza<>(Looper.getMainLooper());
        this.f3109wI = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public zzqe(Looper looper) {
        this.f3107wG = new Object();
        this.zzamx = new CountDownLatch(1);
        this.f3110wJ = new ArrayList<>();
        this.f3112wL = new AtomicReference<>();
        this.f3118wR = false;
        this.f3108wH = new zza<>(looper);
        this.f3109wI = new WeakReference<>(null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzqe(GoogleApiClient googleApiClient) {
        this.f3107wG = new Object();
        this.zzamx = new CountDownLatch(1);
        this.f3110wJ = new ArrayList<>();
        this.f3112wL = new AtomicReference<>();
        this.f3118wR = false;
        this.f3108wH = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.f3109wI = new WeakReference<>(googleApiClient);
    }

    private R get() {
        R r;
        synchronized (this.f3107wG) {
            com.google.android.gms.common.internal.zzac.zza(!this.f3114wN, "Result has already been consumed.");
            com.google.android.gms.common.internal.zzac.zza(isReady(), "Result is not ready.");
            r = this.f3106vU;
            this.f3106vU = null;
            this.f3111wK = null;
            this.f3114wN = true;
        }
        zzaqr();
        return r;
    }

    private void zzaqr() {
        zzrq.zzb andSet = this.f3112wL.getAndSet(null);
        if (andSet != null) {
            andSet.zzc(this);
        }
    }

    private void zzd(R r) {
        this.f3106vU = r;
        this.f3116wP = null;
        this.zzamx.countDown();
        Status status = this.f3106vU.getStatus();
        if (this.zzak) {
            this.f3111wK = null;
        } else if (this.f3111wK != null) {
            this.f3108wH.zzaqw();
            this.f3108wH.zza((ResultCallback<? super ResultCallback<? super R>>) this.f3111wK, (ResultCallback<? super R>) get());
        } else if (this.f3106vU instanceof Releasable) {
            this.f3113wM = new zzb();
        }
        Iterator<PendingResult.zza> it = this.f3110wJ.iterator();
        while (it.hasNext()) {
            it.next().zzv(status);
        }
        this.f3110wJ.clear();
    }

    public static void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        com.google.android.gms.common.internal.zzac.zza(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        com.google.android.gms.common.internal.zzac.zza(!this.f3114wN, "Result has already been consumed");
        com.google.android.gms.common.internal.zzac.zza(this.f3117wQ == null, "Cannot await if then() has been called.");
        try {
            this.zzamx.await();
        } catch (InterruptedException unused) {
            zzaa(Status.f2685vZ);
        }
        com.google.android.gms.common.internal.zzac.zza(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzac.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
        com.google.android.gms.common.internal.zzac.zza(!this.f3114wN, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzac.zza(this.f3117wQ == null, "Cannot await if then() has been called.");
        try {
            if (!this.zzamx.await(j, timeUnit)) {
                zzaa(Status.f2687wb);
            }
        } catch (InterruptedException unused) {
            zzaa(Status.f2685vZ);
        }
        com.google.android.gms.common.internal.zzac.zza(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.f3107wG) {
            if (!this.zzak && !this.f3114wN) {
                if (this.f3116wP != null) {
                    try {
                        this.f3116wP.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                zze(this.f3106vU);
                this.zzak = true;
                zzd(zzc(Status.f2688wc));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.f3107wG) {
            z = this.zzak;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzamx.getCount() == 0;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        synchronized (this.f3107wG) {
            if (resultCallback == null) {
                this.f3111wK = null;
                return;
            }
            boolean z = true;
            com.google.android.gms.common.internal.zzac.zza(!this.f3114wN, "Result has already been consumed.");
            if (this.f3117wQ != null) {
                z = false;
            }
            com.google.android.gms.common.internal.zzac.zza(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.f3108wH.zza((ResultCallback<? super ResultCallback<? super R>>) resultCallback, (ResultCallback<? super R>) get());
            } else {
                this.f3111wK = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        synchronized (this.f3107wG) {
            if (resultCallback == null) {
                this.f3111wK = null;
                return;
            }
            boolean z = true;
            com.google.android.gms.common.internal.zzac.zza(!this.f3114wN, "Result has already been consumed.");
            if (this.f3117wQ != null) {
                z = false;
            }
            com.google.android.gms.common.internal.zzac.zza(z, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.f3108wH.zza((ResultCallback<? super ResultCallback<? super R>>) resultCallback, (ResultCallback<? super R>) get());
            } else {
                this.f3111wK = resultCallback;
                this.f3108wH.zza(this, timeUnit.toMillis(j));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        com.google.android.gms.common.internal.zzac.zza(!this.f3114wN, "Result has already been consumed.");
        synchronized (this.f3107wG) {
            com.google.android.gms.common.internal.zzac.zza(this.f3117wQ == null, "Cannot call then() twice.");
            com.google.android.gms.common.internal.zzac.zza(this.f3111wK == null, "Cannot call then() if callbacks are set.");
            this.f3118wR = true;
            this.f3117wQ = new zzrp<>(this.f3109wI);
            then = this.f3117wQ.then(resultTransform);
            if (isReady()) {
                this.f3108wH.zza(this.f3117wQ, (zzrp<R>) get());
            } else {
                this.f3111wK = this.f3117wQ;
            }
        }
        return then;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void zza(PendingResult.zza zzaVar) {
        com.google.android.gms.common.internal.zzac.zza(!this.f3114wN, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzac.zzb(zzaVar != null, "Callback cannot be null.");
        synchronized (this.f3107wG) {
            if (isReady()) {
                zzaVar.zzv(this.f3106vU.getStatus());
            } else {
                this.f3110wJ.add(zzaVar);
            }
        }
    }

    protected final void zza(com.google.android.gms.common.internal.zzs zzsVar) {
        synchronized (this.f3107wG) {
            this.f3116wP = zzsVar;
        }
    }

    public void zza(zzrq.zzb zzbVar) {
        this.f3112wL.set(zzbVar);
    }

    public final void zzaa(Status status) {
        synchronized (this.f3107wG) {
            if (!isReady()) {
                zzc((zzqe<R>) zzc(status));
                this.f3115wO = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public Integer zzaqf() {
        return null;
    }

    public boolean zzaqq() {
        boolean isCanceled;
        synchronized (this.f3107wG) {
            if (this.f3109wI.get() == null || !this.f3118wR) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public void zzaqs() {
        setResultCallback(null);
    }

    public void zzaqt() {
        this.f3118wR = this.f3118wR || f3105wF.get().booleanValue();
    }

    boolean zzaqu() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract R zzc(Status status);

    public final void zzc(R r) {
        synchronized (this.f3107wG) {
            if (!this.f3115wO && !this.zzak && (!isReady() || !zzaqu())) {
                boolean z = true;
                com.google.android.gms.common.internal.zzac.zza(!isReady(), "Results have already been set");
                if (this.f3114wN) {
                    z = false;
                }
                com.google.android.gms.common.internal.zzac.zza(z, "Result has already been consumed");
                zzd(r);
                return;
            }
            zze(r);
        }
    }
}
