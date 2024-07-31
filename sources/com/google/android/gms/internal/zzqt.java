package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class zzqt implements Handler.Callback {

    /* renamed from: yu */
    private static zzqt f3236yu;
    private static final Object zzaok = new Object();
    private final Context mContext;
    private final Handler mHandler;

    /* renamed from: vP */
    private final GoogleApiAvailability f3237vP;

    /* renamed from: xS */
    private long f3238xS;

    /* renamed from: xT */
    private long f3239xT;

    /* renamed from: yA */
    private final Set<zzpz<?>> f3240yA;

    /* renamed from: yB */
    private final ReferenceQueue<com.google.android.gms.common.api.zzd<?>> f3241yB;

    /* renamed from: yC */
    private final SparseArray<zza> f3242yC;

    /* renamed from: yD */
    private zzb f3243yD;

    /* renamed from: yt */
    private long f3244yt;

    /* renamed from: yv */
    private int f3245yv;

    /* renamed from: yw */
    private final AtomicInteger f3246yw;

    /* renamed from: yx */
    private final SparseArray<zzc<?>> f3247yx;

    /* renamed from: yy */
    private final Map<zzpz<?>, zzc<?>> f3248yy;

    /* renamed from: yz */
    private zzqi f3249yz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class zza extends PhantomReference<com.google.android.gms.common.api.zzd<?>> {

        /* renamed from: wf */
        private final int f3250wf;

        public zza(com.google.android.gms.common.api.zzd zzdVar, int i, ReferenceQueue<com.google.android.gms.common.api.zzd<?>> referenceQueue) {
            super(zzdVar, referenceQueue);
            this.f3250wf = i;
        }

        public void zzasd() {
            zzqt.this.mHandler.sendMessage(zzqt.this.mHandler.obtainMessage(2, this.f3250wf, 2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class zzb extends Thread {

        /* renamed from: yB */
        private final ReferenceQueue<com.google.android.gms.common.api.zzd<?>> f3252yB;

        /* renamed from: yC */
        private final SparseArray<zza> f3253yC;

        /* renamed from: yF */
        private final AtomicBoolean f3254yF;

        public zzb(ReferenceQueue<com.google.android.gms.common.api.zzd<?>> referenceQueue, SparseArray<zza> sparseArray) {
            super("GoogleApiCleanup");
            this.f3254yF = new AtomicBoolean();
            this.f3252yB = referenceQueue;
            this.f3253yC = sparseArray;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f3254yF.set(true);
            Process.setThreadPriority(10);
            while (this.f3254yF.get()) {
                try {
                    zza zzaVar = (zza) this.f3252yB.remove();
                    this.f3253yC.remove(zzaVar.f3250wf);
                    zzaVar.zzasd();
                } catch (InterruptedException unused) {
                } catch (Throwable th) {
                    this.f3254yF.set(false);
                    throw th;
                }
            }
            this.f3254yF.set(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class zzc<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzqg {

        /* renamed from: vC */
        private final Api.zze f3255vC;

        /* renamed from: vx */
        private final zzpz<O> f3256vx;

        /* renamed from: xR */
        private boolean f3258xR;

        /* renamed from: yH */
        private final Api.zzb f3261yH;

        /* renamed from: yG */
        private final Queue<zzpy> f3260yG = new LinkedList();

        /* renamed from: yI */
        private final SparseArray<zzrq> f3262yI = new SparseArray<>();

        /* renamed from: yJ */
        private final Set<zzqb> f3263yJ = new HashSet();

        /* renamed from: wg */
        private final SparseArray<Map<zzrd.zzb<?>, zzri>> f3257wg = new SparseArray<>();

        /* renamed from: yK */
        private ConnectionResult f3264yK = null;

        @WorkerThread
        public zzc(com.google.android.gms.common.api.zzd<O> zzdVar) {
            this.f3255vC = zzdVar.zza(zzqt.this.mHandler.getLooper(), this, this);
            Api.zzb zzbVar = this.f3255vC;
            this.f3261yH = zzbVar instanceof zzai ? ((zzai) zzbVar).zzavk() : zzbVar;
            this.f3256vx = zzdVar.zzapx();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void connect() {
            if (this.f3255vC.isConnected() || this.f3255vC.isConnecting()) {
                return;
            }
            if (this.f3255vC.zzapr() && zzqt.this.f3245yv != 0) {
                zzqt zzqtVar = zzqt.this;
                zzqtVar.f3245yv = zzqtVar.f3237vP.isGooglePlayServicesAvailable(zzqt.this.mContext);
                if (zzqt.this.f3245yv != 0) {
                    onConnectionFailed(new ConnectionResult(zzqt.this.f3245yv, null));
                    return;
                }
            }
            Api.zze zzeVar = this.f3255vC;
            zzeVar.zza(new zzd(zzeVar, this.f3256vx));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void resume() {
            if (this.f3258xR) {
                connect();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void zzab(Status status) {
            for (zzpy zzpyVar : this.f3260yG) {
                zzpyVar.zzx(status);
            }
            this.f3260yG.clear();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @WorkerThread
        public void zzarr() {
            if (this.f3258xR) {
                zzash();
                zzab(zzqt.this.f3237vP.isGooglePlayServicesAvailable(zzqt.this.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f3255vC.disconnect();
            }
        }

        @WorkerThread
        private void zzash() {
            if (this.f3258xR) {
                zzqt.this.mHandler.removeMessages(10, this.f3256vx);
                zzqt.this.mHandler.removeMessages(9, this.f3256vx);
                this.f3258xR = false;
            }
        }

        private void zzasi() {
            zzqt.this.mHandler.removeMessages(11, this.f3256vx);
            zzqt.this.mHandler.sendMessageDelayed(zzqt.this.mHandler.obtainMessage(11, this.f3256vx), zzqt.this.f3244yt);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void zzasj() {
            if (this.f3255vC.isConnected() && this.f3257wg.size() == 0) {
                for (int i = 0; i < this.f3262yI.size(); i++) {
                    SparseArray<zzrq> sparseArray = this.f3262yI;
                    if (sparseArray.get(sparseArray.keyAt(i)).zzasx()) {
                        zzasi();
                        return;
                    }
                }
                this.f3255vC.disconnect();
            }
        }

        @WorkerThread
        private void zzc(zzpy zzpyVar) {
            zzpyVar.zza(this.f3262yI);
            try {
                zzpyVar.zzb(this.f3261yH);
            } catch (DeadObjectException unused) {
                this.f3255vC.disconnect();
                onConnectionSuspended(1);
            }
        }

        @WorkerThread
        private void zzj(ConnectionResult connectionResult) {
            for (zzqb zzqbVar : this.f3263yJ) {
                zzqbVar.zza(this.f3256vx, connectionResult);
            }
            this.f3263yJ.clear();
        }

        boolean isConnected() {
            return this.f3255vC.isConnected();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        @WorkerThread
        public void onConnected(@Nullable Bundle bundle) {
            zzasf();
            zzj(ConnectionResult.f2638uJ);
            zzash();
            for (int i = 0; i < this.f3257wg.size(); i++) {
                SparseArray<Map<zzrd.zzb<?>, zzri>> sparseArray = this.f3257wg;
                for (zzri zzriVar : sparseArray.get(sparseArray.keyAt(i)).values()) {
                    try {
                        zzriVar.f3294wj.zza(this.f3261yH, new TaskCompletionSource<>());
                    } catch (DeadObjectException unused) {
                        this.f3255vC.disconnect();
                        onConnectionSuspended(1);
                    }
                }
            }
            zzase();
            zzasi();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        @WorkerThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzasf();
            zzqt.this.f3245yv = -1;
            zzj(connectionResult);
            int keyAt = this.f3262yI.keyAt(0);
            if (this.f3260yG.isEmpty()) {
                this.f3264yK = connectionResult;
                return;
            }
            synchronized (zzqt.zzaok) {
                if (zzqt.zzd(zzqt.this) != null && zzqt.this.f3240yA.contains(this.f3256vx)) {
                    zzqt.zzd(zzqt.this).zzb(connectionResult, keyAt);
                } else if (zzqt.this.zzc(connectionResult, keyAt)) {
                } else {
                    if (connectionResult.getErrorCode() == 18) {
                        this.f3258xR = true;
                    }
                    if (this.f3258xR) {
                        zzqt.this.mHandler.sendMessageDelayed(Message.obtain(zzqt.this.mHandler, 9, this.f3256vx), zzqt.this.f3239xT);
                        return;
                    }
                    String valueOf = String.valueOf(this.f3256vx.zzaqj());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 38);
                    sb.append("API: ");
                    sb.append(valueOf);
                    sb.append(" is not available on this device.");
                    zzab(new Status(17, sb.toString()));
                }
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        @WorkerThread
        public void onConnectionSuspended(int i) {
            zzasf();
            this.f3258xR = true;
            zzqt.this.mHandler.sendMessageDelayed(Message.obtain(zzqt.this.mHandler, 9, this.f3256vx), zzqt.this.f3239xT);
            zzqt.this.mHandler.sendMessageDelayed(Message.obtain(zzqt.this.mHandler, 10, this.f3256vx), zzqt.this.f3238xS);
            zzqt.this.f3245yv = -1;
        }

        @Override // com.google.android.gms.internal.zzqg
        public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
            onConnectionFailed(connectionResult);
        }

        @WorkerThread
        public void zzase() {
            while (this.f3255vC.isConnected() && !this.f3260yG.isEmpty()) {
                zzc(this.f3260yG.remove());
            }
        }

        @WorkerThread
        public void zzasf() {
            this.f3264yK = null;
        }

        ConnectionResult zzasg() {
            return this.f3264yK;
        }

        @WorkerThread
        public void zzb(int i, @NonNull zzrd.zzb<?> zzbVar, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
            Map<zzrd.zzb<?>, zzri> map = this.f3257wg.get(i);
            if (map != null && map.get(zzbVar) != null) {
                zzb(new zzpy.zze(i, map.get(zzbVar).f3295wk, taskCompletionSource, this.f3257wg));
                return;
            }
            taskCompletionSource.setException(new com.google.android.gms.common.api.zza(Status.f2686wa));
            Log.wtf("GoogleApiManager", "Received call to unregister a listener without a matching registration call.", new Exception());
        }

        @WorkerThread
        public void zzb(int i, @NonNull zzri zzriVar, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
            zzb(new zzpy.zzc(i, zzriVar, taskCompletionSource, this.f3257wg));
        }

        @WorkerThread
        public void zzb(zzpy zzpyVar) {
            if (this.f3255vC.isConnected()) {
                zzc(zzpyVar);
                zzasi();
                return;
            }
            this.f3260yG.add(zzpyVar);
            ConnectionResult connectionResult = this.f3264yK;
            if (connectionResult == null || !connectionResult.hasResolution()) {
                connect();
            } else {
                onConnectionFailed(this.f3264yK);
            }
        }

        @WorkerThread
        public void zzb(zzqb zzqbVar) {
            this.f3263yJ.add(zzqbVar);
        }

        @WorkerThread
        public void zzf(int i, boolean z) {
            Iterator<zzpy> it = this.f3260yG.iterator();
            while (it.hasNext()) {
                zzpy next = it.next();
                if (next.f3074wf == i && next.f3073lN != 1 && next.cancel()) {
                    it.remove();
                }
            }
            this.f3262yI.get(i).release();
            this.f3257wg.delete(i);
            if (z) {
                return;
            }
            this.f3262yI.remove(i);
            zzqt.this.f3242yC.remove(i);
            if (this.f3262yI.size() == 0 && this.f3260yG.isEmpty()) {
                zzash();
                this.f3255vC.disconnect();
                zzqt.this.f3248yy.remove(this.f3256vx);
                synchronized (zzqt.zzaok) {
                    zzqt.this.f3240yA.remove(this.f3256vx);
                }
            }
        }

        @WorkerThread
        public void zzfw(int i) {
            this.f3262yI.put(i, new zzrq(this.f3255vC));
        }

        @WorkerThread
        public void zzfx(final int i) {
            this.f3262yI.get(i).zza(new zzrq.zzc() { // from class: com.google.android.gms.internal.zzqt.zzc.1
                @Override // com.google.android.gms.internal.zzrq.zzc
                public void zzask() {
                    if (zzc.this.f3260yG.isEmpty()) {
                        zzc.this.zzf(i, false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class zzd implements zze.zzf {

        /* renamed from: vC */
        private final Api.zze f3267vC;

        /* renamed from: vx */
        private final zzpz<?> f3268vx;

        public zzd(Api.zze zzeVar, zzpz<?> zzpzVar) {
            this.f3267vC = zzeVar;
            this.f3268vx = zzpzVar;
        }

        @Override // com.google.android.gms.common.internal.zze.zzf
        @WorkerThread
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.f3267vC.zza(null, Collections.emptySet());
            } else {
                ((zzc) zzqt.this.f3248yy.get(this.f3268vx)).onConnectionFailed(connectionResult);
            }
        }
    }

    private zzqt(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    private zzqt(Context context, GoogleApiAvailability googleApiAvailability) {
        this.f3239xT = 5000L;
        this.f3238xS = 120000L;
        this.f3244yt = 10000L;
        this.f3245yv = -1;
        this.f3246yw = new AtomicInteger(1);
        this.f3247yx = new SparseArray<>();
        this.f3248yy = new ConcurrentHashMap(5, 0.75f, 1);
        this.f3249yz = null;
        this.f3240yA = new com.google.android.gms.common.util.zza();
        this.f3241yB = new ReferenceQueue<>();
        this.f3242yC = new SparseArray<>();
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        this.f3237vP = googleApiAvailability;
    }

    private int zza(com.google.android.gms.common.api.zzd<?> zzdVar) {
        int andIncrement = this.f3246yw.getAndIncrement();
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(6, andIncrement, 0, zzdVar));
        return andIncrement;
    }

    public static Pair<zzqt, Integer> zza(Context context, com.google.android.gms.common.api.zzd<?> zzdVar) {
        Pair<zzqt, Integer> create;
        synchronized (zzaok) {
            if (f3236yu == null) {
                f3236yu = new zzqt(context.getApplicationContext());
            }
            create = Pair.create(f3236yu, Integer.valueOf(f3236yu.zza(zzdVar)));
        }
        return create;
    }

    @WorkerThread
    private void zza(int i, zzrd.zzb<?> zzbVar, TaskCompletionSource<Void> taskCompletionSource) {
        this.f3247yx.get(i).zzb(i, zzbVar, taskCompletionSource);
    }

    @WorkerThread
    private void zza(int i, zzri zzriVar, TaskCompletionSource<Void> taskCompletionSource) {
        this.f3247yx.get(i).zzb(i, zzriVar, taskCompletionSource);
    }

    @WorkerThread
    private void zza(com.google.android.gms.common.api.zzd<?> zzdVar, int i) {
        zzpz<?> zzapx = zzdVar.zzapx();
        if (!this.f3248yy.containsKey(zzapx)) {
            this.f3248yy.put(zzapx, new zzc<>(zzdVar));
        }
        zzc<?> zzcVar = this.f3248yy.get(zzapx);
        zzcVar.zzfw(i);
        this.f3247yx.put(i, zzcVar);
        zzcVar.connect();
        this.f3242yC.put(i, new zza(zzdVar, i, this.f3241yB));
        zzb zzbVar = this.f3243yD;
        if (zzbVar == null || !zzbVar.f3254yF.get()) {
            this.f3243yD = new zzb(this.f3241yB, this.f3242yC);
            this.f3243yD.start();
        }
    }

    @WorkerThread
    private void zza(zzpy zzpyVar) {
        this.f3247yx.get(zzpyVar.f3074wf).zzb(zzpyVar);
    }

    public static zzqt zzasa() {
        zzqt zzqtVar;
        synchronized (zzaok) {
            zzqtVar = f3236yu;
        }
        return zzqtVar;
    }

    @WorkerThread
    private void zzasb() {
        for (zzc<?> zzcVar : this.f3248yy.values()) {
            zzcVar.zzasf();
            zzcVar.connect();
        }
    }

    static /* synthetic */ zzqi zzd(zzqt zzqtVar) {
        return null;
    }

    @WorkerThread
    private void zze(int i, boolean z) {
        zzc<?> zzcVar = this.f3247yx.get(i);
        if (zzcVar != null) {
            if (!z) {
                this.f3247yx.delete(i);
            }
            zzcVar.zzf(i, z);
            return;
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("onRelease received for unknown instance: ");
        sb.append(i);
        Log.wtf("GoogleApiManager", sb.toString(), new Exception());
    }

    @WorkerThread
    private void zzfv(int i) {
        zzc<?> zzcVar = this.f3247yx.get(i);
        if (zzcVar != null) {
            this.f3247yx.delete(i);
            zzcVar.zzfx(i);
            return;
        }
        StringBuilder sb = new StringBuilder(64);
        sb.append("onCleanupLeakInternal received for unknown instance: ");
        sb.append(i);
        Log.wtf("GoogleApiManager", sb.toString(), new Exception());
    }

    @Override // android.os.Handler.Callback
    @WorkerThread
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                zza((zzqb) message.obj);
                break;
            case 2:
                zzfv(message.arg1);
                break;
            case 3:
                zzasb();
                break;
            case 4:
                zza((zzpy) message.obj);
                break;
            case 5:
                if (this.f3247yx.get(message.arg1) != null) {
                    this.f3247yx.get(message.arg1).zzab(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                zza((com.google.android.gms.common.api.zzd) message.obj, message.arg1);
                break;
            case 7:
                Pair pair = (Pair) message.obj;
                zza(message.arg1, (zzri) pair.first, (TaskCompletionSource) pair.second);
                break;
            case 8:
                zze(message.arg1, message.arg2 == 1);
                break;
            case 9:
                if (this.f3248yy.containsKey(message.obj)) {
                    this.f3248yy.get(message.obj).resume();
                    break;
                }
                break;
            case 10:
                if (this.f3248yy.containsKey(message.obj)) {
                    this.f3248yy.get(message.obj).zzarr();
                    break;
                }
                break;
            case 11:
                if (this.f3248yy.containsKey(message.obj)) {
                    this.f3248yy.get(message.obj).zzasj();
                    break;
                }
                break;
            case 12:
                Pair pair2 = (Pair) message.obj;
                zza(message.arg1, (zzrd.zzb) pair2.first, (TaskCompletionSource) pair2.second);
                break;
            default:
                int i = message.what;
                StringBuilder sb = new StringBuilder(31);
                sb.append("Unknown message id: ");
                sb.append(i);
                Log.w("GoogleApiManager", sb.toString());
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (zzc(connectionResult, i)) {
            return;
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(5, i, 0));
    }

    public <O extends Api.ApiOptions> void zza(com.google.android.gms.common.api.zzd<O> zzdVar, int i, zzqc.zza<? extends Result, Api.zzb> zzaVar) {
        zzpy.zzb zzbVar = new zzpy.zzb(zzdVar.getInstanceId(), i, zzaVar);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, zzbVar));
    }

    public <O extends Api.ApiOptions, TResult> void zza(com.google.android.gms.common.api.zzd<O> zzdVar, int i, zzro<Api.zzb, TResult> zzroVar, TaskCompletionSource<TResult> taskCompletionSource) {
        zzpy.zzd zzdVar2 = new zzpy.zzd(zzdVar.getInstanceId(), i, zzroVar, taskCompletionSource);
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, zzdVar2));
    }

    @WorkerThread
    public void zza(zzqb zzqbVar) {
        ConnectionResult connectionResult;
        for (zzpz<?> zzpzVar : zzqbVar.zzaqm()) {
            zzc<?> zzcVar = this.f3248yy.get(zzpzVar);
            if (zzcVar == null) {
                zzqbVar.cancel();
                return;
            }
            if (zzcVar.isConnected()) {
                connectionResult = ConnectionResult.f2638uJ;
            } else if (zzcVar.zzasg() != null) {
                connectionResult = zzcVar.zzasg();
            } else {
                zzcVar.zzb(zzqbVar);
            }
            zzqbVar.zza(zzpzVar, connectionResult);
        }
    }

    public void zza(zzqi zzqiVar) {
        synchronized (zzaok) {
            if (zzqiVar == null) {
                this.f3249yz = null;
                this.f3240yA.clear();
            }
        }
    }

    public void zzaqk() {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3));
    }

    boolean zzc(ConnectionResult connectionResult, int i) {
        if (connectionResult.hasResolution() || this.f3237vP.isUserResolvableError(connectionResult.getErrorCode())) {
            this.f3237vP.zza(this.mContext, connectionResult, i);
            return true;
        }
        return false;
    }

    public void zzd(int i, boolean z) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(8, i, z ? 1 : 2));
    }
}
