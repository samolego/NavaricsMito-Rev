package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.p008v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.internal.zzrq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class zzqp extends GoogleApiClient implements zzqy.zza {
    private final Context mContext;

    /* renamed from: vN */
    private final int f3185vN;

    /* renamed from: vP */
    private final GoogleApiAvailability f3186vP;

    /* renamed from: vQ */
    final Api.zza<? extends zzwz, zzxa> f3187vQ;

    /* renamed from: xB */
    final com.google.android.gms.common.internal.zzh f3188xB;

    /* renamed from: xC */
    final Map<Api<?>, Integer> f3189xC;

    /* renamed from: xO */
    private final com.google.android.gms.common.internal.zzm f3190xO;

    /* renamed from: xR */
    private volatile boolean f3193xR;

    /* renamed from: xU */
    private final zza f3196xU;

    /* renamed from: xV */
    zzqv f3197xV;

    /* renamed from: xW */
    final Map<Api.zzc<?>, Api.zze> f3198xW;

    /* renamed from: xZ */
    private final ArrayList<zzqf> f3201xZ;

    /* renamed from: xf */
    private final Lock f3202xf;

    /* renamed from: ya */
    private Integer f3203ya;

    /* renamed from: yc */
    final zzrq f3205yc;
    private final Looper zzajn;

    /* renamed from: xP */
    private zzqy f3191xP = null;

    /* renamed from: xQ */
    final Queue<zzqc.zza<?, ?>> f3192xQ = new LinkedList();

    /* renamed from: xS */
    private long f3194xS = 120000;

    /* renamed from: xT */
    private long f3195xT = 5000;

    /* renamed from: xX */
    Set<Scope> f3199xX = new HashSet();

    /* renamed from: xY */
    private final zzre f3200xY = new zzre();

    /* renamed from: yb */
    Set<zzrp> f3204yb = null;

    /* renamed from: yd */
    private final zzm.zza f3206yd = new zzm.zza() { // from class: com.google.android.gms.internal.zzqp.1
        @Override // com.google.android.gms.common.internal.zzm.zza
        public boolean isConnected() {
            return zzqp.this.isConnected();
        }

        @Override // com.google.android.gms.common.internal.zzm.zza
        public Bundle zzaoe() {
            return null;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzqp.this.zzarr();
                    return;
                case 2:
                    zzqp.this.resume();
                    return;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(31);
                    sb.append("Unknown message id: ");
                    sb.append(i);
                    Log.w("GoogleApiClientImpl", sb.toString());
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zzb extends zzqv.zza {

        /* renamed from: yi */
        private WeakReference<zzqp> f3218yi;

        zzb(zzqp zzqpVar) {
            this.f3218yi = new WeakReference<>(zzqpVar);
        }

        @Override // com.google.android.gms.internal.zzqv.zza
        public void zzaqp() {
            zzqp zzqpVar = this.f3218yi.get();
            if (zzqpVar == null) {
                return;
            }
            zzqpVar.resume();
        }
    }

    public zzqp(Context context, Lock lock, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzwz, zzxa> zzaVar, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zze> map2, int i, int i2, ArrayList<zzqf> arrayList) {
        this.f3203ya = null;
        this.mContext = context;
        this.f3202xf = lock;
        this.f3190xO = new com.google.android.gms.common.internal.zzm(looper, this.f3206yd);
        this.zzajn = looper;
        this.f3196xU = new zza(looper);
        this.f3186vP = googleApiAvailability;
        this.f3185vN = i;
        if (this.f3185vN >= 0) {
            this.f3203ya = Integer.valueOf(i2);
        }
        this.f3189xC = map;
        this.f3198xW = map2;
        this.f3201xZ = arrayList;
        this.f3205yc = new zzrq(this.f3198xW);
        for (GoogleApiClient.ConnectionCallbacks connectionCallbacks : list) {
            this.f3190xO.registerConnectionCallbacks(connectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener : list2) {
            this.f3190xO.registerConnectionFailedListener(onConnectionFailedListener);
        }
        this.f3188xB = zzhVar;
        this.f3187vQ = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.f3202xf.lock();
        try {
            if (isResuming()) {
                zzarq();
            }
        } finally {
            this.f3202xf.unlock();
        }
    }

    public static int zza(Iterable<Api.zze> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zze zzeVar : iterable) {
            if (zzeVar.zzahd()) {
                z2 = true;
            }
            if (zzeVar.zzahs()) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzrm zzrmVar, final boolean z) {
        zzrx.f3348Dh.zzg(googleApiClient).setResultCallback(new ResultCallback<Status>() { // from class: com.google.android.gms.internal.zzqp.4
            @Override // com.google.android.gms.common.api.ResultCallback
            /* renamed from: zzp */
            public void onResult(@NonNull Status status) {
                com.google.android.gms.auth.api.signin.internal.zzk.zzbd(zzqp.this.mContext).zzaie();
                if (status.isSuccess() && zzqp.this.isConnected()) {
                    zzqp.this.reconnect();
                }
                zzrmVar.zzc((zzrm) status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private void zzarq() {
        this.f3190xO.zzauu();
        this.f3191xP.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzarr() {
        this.f3202xf.lock();
        try {
            if (zzart()) {
                zzarq();
            }
        } finally {
            this.f3202xf.unlock();
        }
    }

    private void zzb(@NonNull zzqz zzqzVar) {
        if (this.f3185vN < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zzqa.zza(zzqzVar).zzfq(this.f3185vN);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void zzft(int i) {
        zzqy zzqrVar;
        Integer num = this.f3203ya;
        if (num == null) {
            this.f3203ya = Integer.valueOf(i);
        } else if (num.intValue() != i) {
            String valueOf = String.valueOf(zzfu(i));
            String valueOf2 = String.valueOf(zzfu(this.f3203ya.intValue()));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(valueOf2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(valueOf);
            sb.append(". Mode was already set to ");
            sb.append(valueOf2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f3191xP != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.zze zzeVar : this.f3198xW.values()) {
            if (zzeVar.zzahd()) {
                z = true;
            }
            if (zzeVar.zzahs()) {
                z2 = true;
            }
        }
        switch (this.f3203ya.intValue()) {
            case 1:
                if (!z) {
                    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                }
                if (z2) {
                    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
                zzqrVar = new zzqr(this.mContext, this, this.f3202xf, this.zzajn, this.f3186vP, this.f3198xW, this.f3188xB, this.f3189xC, this.f3187vQ, this.f3201xZ, this);
                break;
            case 2:
                if (z) {
                    zzqrVar = zzqh.zza(this.mContext, this, this.f3202xf, this.zzajn, this.f3186vP, this.f3198xW, this.f3188xB, this.f3189xC, this.f3187vQ, this.f3201xZ);
                    break;
                }
                zzqrVar = new zzqr(this.mContext, this, this.f3202xf, this.zzajn, this.f3186vP, this.f3198xW, this.f3188xB, this.f3189xC, this.f3187vQ, this.f3201xZ, this);
                break;
            case 3:
            default:
                zzqrVar = new zzqr(this.mContext, this, this.f3202xf, this.zzajn, this.f3186vP, this.f3198xW, this.f3188xB, this.f3189xC, this.f3187vQ, this.f3201xZ, this);
                break;
        }
        this.f3191xP = zzqrVar;
    }

    static String zzfu(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        boolean z = true;
        com.google.android.gms.common.internal.zzac.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f3202xf.lock();
        try {
            if (this.f3185vN >= 0) {
                if (this.f3203ya == null) {
                    z = false;
                }
                com.google.android.gms.common.internal.zzac.zza(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f3203ya == null) {
                this.f3203ya = Integer.valueOf(zza(this.f3198xW.values(), false));
            } else if (this.f3203ya.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzft(this.f3203ya.intValue());
            this.f3190xO.zzauu();
            return this.f3191xP.blockingConnect();
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzac.zza(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        com.google.android.gms.common.internal.zzac.zzb(timeUnit, "TimeUnit must not be null");
        this.f3202xf.lock();
        try {
            if (this.f3203ya == null) {
                this.f3203ya = Integer.valueOf(zza(this.f3198xW.values(), false));
            } else if (this.f3203ya.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzft(this.f3203ya.intValue());
            this.f3190xO.zzauu();
            return this.f3191xP.blockingConnect(j, timeUnit);
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        com.google.android.gms.common.internal.zzac.zza(isConnected(), "GoogleApiClient is not connected yet.");
        com.google.android.gms.common.internal.zzac.zza(this.f3203ya.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzrm zzrmVar = new zzrm(this);
        if (this.f3198xW.containsKey(zzrx.f3349fa)) {
            zza(this, zzrmVar, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(zzrx.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() { // from class: com.google.android.gms.internal.zzqp.2
                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnected(Bundle bundle) {
                    zzqp.this.zza((GoogleApiClient) atomicReference.get(), zzrmVar, true);
                }

                @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() { // from class: com.google.android.gms.internal.zzqp.3
                @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    zzrmVar.zzc((zzrm) new Status(8));
                }
            }).setHandler(this.f3196xU).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzrmVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        this.f3202xf.lock();
        try {
            if (this.f3185vN >= 0) {
                com.google.android.gms.common.internal.zzac.zza(this.f3203ya != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f3203ya == null) {
                this.f3203ya = Integer.valueOf(zza(this.f3198xW.values(), false));
            } else if (this.f3203ya.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.f3203ya.intValue());
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect(int i) {
        this.f3202xf.lock();
        boolean z = true;
        if (i != 3 && i != 1 && i != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i);
            com.google.android.gms.common.internal.zzac.zzb(z, sb.toString());
            zzft(i);
            zzarq();
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        this.f3202xf.lock();
        try {
            this.f3205yc.release();
            if (this.f3191xP != null) {
                this.f3191xP.disconnect();
            }
            this.f3200xY.release();
            for (zzqc.zza<?, ?> zzaVar : this.f3192xQ) {
                zzaVar.zza((zzrq.zzb) null);
                zzaVar.cancel();
            }
            this.f3192xQ.clear();
            if (this.f3191xP == null) {
                return;
            }
            zzart();
            this.f3190xO.zzaut();
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.mContext);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f3193xR);
        printWriter.append(" mWorkQueue.size()=").print(this.f3192xQ.size());
        this.f3205yc.dump(printWriter);
        zzqy zzqyVar = this.f3191xP;
        if (zzqyVar != null) {
            zzqyVar.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        ConnectionResult connectionResult;
        this.f3202xf.lock();
        try {
            if (!isConnected() && !isResuming()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (this.f3198xW.containsKey(api.zzapp())) {
                ConnectionResult connectionResult2 = this.f3191xP.getConnectionResult(api);
                if (connectionResult2 == null) {
                    if (isResuming()) {
                        connectionResult = ConnectionResult.f2638uJ;
                    } else {
                        Log.w("GoogleApiClientImpl", zzarv());
                        Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                        connectionResult = new ConnectionResult(8, null);
                    }
                    return connectionResult;
                }
                return connectionResult2;
            }
            throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.zzajn;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.zze zzeVar = this.f3198xW.get(api.zzapp());
        return zzeVar != null && zzeVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        zzqy zzqyVar = this.f3191xP;
        return zzqyVar != null && zzqyVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        zzqy zzqyVar = this.f3191xP;
        return zzqyVar != null && zzqyVar.isConnecting();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f3190xO.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f3190xO.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    boolean isResuming() {
        return this.f3193xR;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f3190xO.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f3190xO.registerConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        zzb(new zzqz(fragmentActivity));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f3190xO.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f3190xO.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    @NonNull
    public <C extends Api.zze> C zza(@NonNull Api.zzc<C> zzcVar) {
        C c = (C) this.f3198xW.get(zzcVar);
        com.google.android.gms.common.internal.zzac.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zza(zzrp zzrpVar) {
        this.f3202xf.lock();
        try {
            if (this.f3204yb == null) {
                this.f3204yb = new HashSet();
            }
            this.f3204yb.add(zzrpVar);
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(@NonNull Api<?> api) {
        return this.f3198xW.containsKey(api.zzapp());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(zzrl zzrlVar) {
        zzqy zzqyVar = this.f3191xP;
        return zzqyVar != null && zzqyVar.zza(zzrlVar);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzaqb() {
        zzqy zzqyVar = this.f3191xP;
        if (zzqyVar != null) {
            zzqyVar.zzaqb();
        }
    }

    void zzars() {
        if (isResuming()) {
            return;
        }
        this.f3193xR = true;
        if (this.f3197xV == null) {
            this.f3197xV = this.f3186vP.zza(this.mContext.getApplicationContext(), new zzb(this));
        }
        zza zzaVar = this.f3196xU;
        zzaVar.sendMessageDelayed(zzaVar.obtainMessage(1), this.f3194xS);
        zza zzaVar2 = this.f3196xU;
        zzaVar2.sendMessageDelayed(zzaVar2.obtainMessage(2), this.f3195xT);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zzart() {
        if (isResuming()) {
            this.f3193xR = false;
            this.f3196xU.removeMessages(2);
            this.f3196xU.removeMessages(1);
            zzqv zzqvVar = this.f3197xV;
            if (zzqvVar != null) {
                zzqvVar.unregister();
                this.f3197xV = null;
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zzaru() {
        this.f3202xf.lock();
        try {
            if (this.f3204yb != null) {
                return !this.f3204yb.isEmpty();
            }
            this.f3202xf.unlock();
            return false;
        } finally {
            this.f3202xf.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zzarv() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <C extends Api.zze> C zzb(Api.zzc<?> zzcVar) {
        C c = (C) this.f3198xW.get(zzcVar);
        com.google.android.gms.common.internal.zzac.zzb(c, "Appropriate Api was not requested.");
        return c;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void zzb(zzrp zzrpVar) {
        String str;
        String str2;
        Exception exc;
        this.f3202xf.lock();
        try {
            if (this.f3204yb == null) {
                str = "GoogleApiClientImpl";
                str2 = "Attempted to remove pending transform when no transforms are registered.";
                exc = new Exception();
            } else if (this.f3204yb.remove(zzrpVar)) {
                if (!zzaru()) {
                    this.f3191xP.zzaqy();
                }
            } else {
                str = "GoogleApiClientImpl";
                str2 = "Failed to remove pending transform - this may lead to memory leaks!";
                exc = new Exception();
            }
            Log.wtf(str, str2, exc);
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(@NonNull T t) {
        com.google.android.gms.common.internal.zzac.zzb(t.zzapp() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f3198xW.containsKey(t.zzapp());
        String name = t.zzaqn() != null ? t.zzaqn().getName() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(name);
        sb.append(" required for this call.");
        com.google.android.gms.common.internal.zzac.zzb(containsKey, sb.toString());
        this.f3202xf.lock();
        try {
            if (this.f3191xP == null) {
                this.f3192xQ.add(t);
            } else {
                t = (T) this.f3191xP.zzc(t);
            }
            return t;
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqy.zza
    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzars();
        }
        this.f3205yc.zzasw();
        this.f3190xO.zzgo(i);
        this.f3190xO.zzaut();
        if (i == 2) {
            zzarq();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(@NonNull T t) {
        com.google.android.gms.common.internal.zzac.zzb(t.zzapp() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f3198xW.containsKey(t.zzapp());
        String name = t.zzaqn() != null ? t.zzaqn().getName() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(name);
        sb.append(" required for this call.");
        com.google.android.gms.common.internal.zzac.zzb(containsKey, sb.toString());
        this.f3202xf.lock();
        try {
            if (this.f3191xP != null) {
                if (isResuming()) {
                    this.f3192xQ.add(t);
                    while (!this.f3192xQ.isEmpty()) {
                        zzqc.zza<?, ?> remove = this.f3192xQ.remove();
                        this.f3205yc.zzb(remove);
                        remove.zzz(Status.f2686wa);
                    }
                } else {
                    t = (T) this.f3191xP.zzd(t);
                }
                return t;
            }
            throw new IllegalStateException("GoogleApiClient is not connected yet.");
        } finally {
            this.f3202xf.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqy.zza
    public void zzd(ConnectionResult connectionResult) {
        if (!this.f3186vP.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzart();
        }
        if (isResuming()) {
            return;
        }
        this.f3190xO.zzn(connectionResult);
        this.f3190xO.zzaut();
    }

    @Override // com.google.android.gms.internal.zzqy.zza
    public void zzn(Bundle bundle) {
        while (!this.f3192xQ.isEmpty()) {
            zzd((zzqp) this.f3192xQ.remove());
        }
        this.f3190xO.zzp(bundle);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <L> zzrd<L> zzs(@NonNull L l) {
        this.f3202xf.lock();
        try {
            return this.f3200xY.zzb(l, this.zzajn);
        } finally {
            this.f3202xf.unlock();
        }
    }
}
