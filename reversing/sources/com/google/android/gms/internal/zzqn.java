package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public class zzqn implements zzqq {
    private final Context mContext;

    /* renamed from: vQ */
    private final Api.zza<? extends zzwz, zzxa> f3146vQ;

    /* renamed from: xA */
    private boolean f3147xA;

    /* renamed from: xB */
    private final com.google.android.gms.common.internal.zzh f3148xB;

    /* renamed from: xC */
    private final Map<Api<?>, Integer> f3149xC;

    /* renamed from: xf */
    private final Lock f3151xf;

    /* renamed from: xk */
    private final zzqr f3152xk;

    /* renamed from: xn */
    private final com.google.android.gms.common.zzc f3153xn;

    /* renamed from: xo */
    private ConnectionResult f3154xo;

    /* renamed from: xp */
    private int f3155xp;

    /* renamed from: xr */
    private int f3157xr;

    /* renamed from: xu */
    private zzwz f3160xu;

    /* renamed from: xv */
    private int f3161xv;

    /* renamed from: xw */
    private boolean f3162xw;

    /* renamed from: xx */
    private boolean f3163xx;

    /* renamed from: xy */
    private com.google.android.gms.common.internal.zzr f3164xy;

    /* renamed from: xz */
    private boolean f3165xz;

    /* renamed from: xq */
    private int f3156xq = 0;

    /* renamed from: xs */
    private final Bundle f3158xs = new Bundle();

    /* renamed from: xt */
    private final Set<Api.zzc> f3159xt = new HashSet();

    /* renamed from: xD */
    private ArrayList<Future<?>> f3150xD = new ArrayList<>();

    /* loaded from: classes.dex */
    private static class zza implements zze.zzf {

        /* renamed from: tv */
        private final Api<?> f3167tv;

        /* renamed from: wT */
        private final int f3168wT;

        /* renamed from: xF */
        private final WeakReference<zzqn> f3169xF;

        public zza(zzqn zzqnVar, Api<?> api, int i) {
            this.f3169xF = new WeakReference<>(zzqnVar);
            this.f3167tv = api;
            this.f3168wT = i;
        }

        @Override // com.google.android.gms.common.internal.zze.zzf
        public void zzh(@NonNull ConnectionResult connectionResult) {
            zzqn zzqnVar = this.f3169xF.get();
            if (zzqnVar == null) {
                return;
            }
            com.google.android.gms.common.internal.zzac.zza(Looper.myLooper() == zzqnVar.f3152xk.f3220wV.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzqnVar.f3151xf.lock();
            try {
                if (zzqnVar.zzfr(0)) {
                    if (!connectionResult.isSuccess()) {
                        zzqnVar.zzb(connectionResult, this.f3167tv, this.f3168wT);
                    }
                    if (zzqnVar.zzarj()) {
                        zzqnVar.zzark();
                    }
                }
            } finally {
                zzqnVar.f3151xf.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    private class zzb extends zzf {

        /* renamed from: xG */
        private final Map<Api.zze, zza> f3171xG;

        public zzb(Map<Api.zze, zza> map) {
            super();
            this.f3171xG = map;
        }

        @Override // com.google.android.gms.internal.zzqn.zzf
        @WorkerThread
        public void zzari() {
            boolean z;
            Iterator<Api.zze> it = this.f3171xG.keySet().iterator();
            boolean z2 = true;
            boolean z3 = false;
            boolean z4 = true;
            while (true) {
                if (!it.hasNext()) {
                    z2 = z3;
                    z = false;
                    break;
                }
                Api.zze next = it.next();
                if (!next.zzapr()) {
                    z4 = false;
                } else if (this.f3171xG.get(next).f3168wT == 0) {
                    z = true;
                    break;
                } else {
                    z3 = true;
                }
            }
            int isGooglePlayServicesAvailable = z2 ? zzqn.this.f3153xn.isGooglePlayServicesAvailable(zzqn.this.mContext) : 0;
            if (isGooglePlayServicesAvailable != 0 && (z || z4)) {
                final ConnectionResult connectionResult = new ConnectionResult(isGooglePlayServicesAvailable, null);
                zzqn.this.f3152xk.zza(new zzqr.zza(zzqn.this) { // from class: com.google.android.gms.internal.zzqn.zzb.1
                    @Override // com.google.android.gms.internal.zzqr.zza
                    public void zzari() {
                        zzqn.this.zzg(connectionResult);
                    }
                });
                return;
            }
            if (zzqn.this.f3162xw) {
                zzqn.this.f3160xu.connect();
            }
            for (Api.zze zzeVar : this.f3171xG.keySet()) {
                final zza zzaVar = this.f3171xG.get(zzeVar);
                if (!zzeVar.zzapr() || isGooglePlayServicesAvailable == 0) {
                    zzeVar.zza(zzaVar);
                } else {
                    zzqn.this.f3152xk.zza(new zzqr.zza(zzqn.this) { // from class: com.google.android.gms.internal.zzqn.zzb.2
                        @Override // com.google.android.gms.internal.zzqr.zza
                        public void zzari() {
                            zzaVar.zzh(new ConnectionResult(16, null));
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class zzc extends zzf {

        /* renamed from: xK */
        private final ArrayList<Api.zze> f3177xK;

        public zzc(ArrayList<Api.zze> arrayList) {
            super();
            this.f3177xK = arrayList;
        }

        @Override // com.google.android.gms.internal.zzqn.zzf
        @WorkerThread
        public void zzari() {
            zzqn.this.f3152xk.f3220wV.f3199xX = zzqn.this.zzarp();
            Iterator<Api.zze> it = this.f3177xK.iterator();
            while (it.hasNext()) {
                it.next().zza(zzqn.this.f3164xy, zzqn.this.f3152xk.f3220wV.f3199xX);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class zzd extends com.google.android.gms.signin.internal.zzb {

        /* renamed from: xF */
        private final WeakReference<zzqn> f3178xF;

        zzd(zzqn zzqnVar) {
            this.f3178xF = new WeakReference<>(zzqnVar);
        }

        @Override // com.google.android.gms.signin.internal.zzb, com.google.android.gms.signin.internal.zzd
        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzqn zzqnVar = this.f3178xF.get();
            if (zzqnVar == null) {
                return;
            }
            zzqnVar.f3152xk.zza(new zzqr.zza(zzqnVar) { // from class: com.google.android.gms.internal.zzqn.zzd.1
                @Override // com.google.android.gms.internal.zzqr.zza
                public void zzari() {
                    zzqnVar.zza(signInResponse);
                }
            });
        }
    }

    /* loaded from: classes.dex */
    private class zze implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zze() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnected(Bundle bundle) {
            zzqn.this.f3160xu.zza(new zzd(zzqn.this));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzqn.this.f3151xf.lock();
            try {
                if (zzqn.this.zzf(connectionResult)) {
                    zzqn.this.zzarn();
                    zzqn.this.zzark();
                } else {
                    zzqn.this.zzg(connectionResult);
                }
            } finally {
                zzqn.this.f3151xf.unlock();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void onConnectionSuspended(int i) {
        }
    }

    /* loaded from: classes.dex */
    private abstract class zzf implements Runnable {
        private zzf() {
        }

        @Override // java.lang.Runnable
        @WorkerThread
        public void run() {
            zzqn.this.f3151xf.lock();
            try {
                try {
                } catch (RuntimeException e) {
                    zzqn.this.f3152xk.zza(e);
                }
                if (Thread.interrupted()) {
                    return;
                }
                zzari();
            } finally {
                zzqn.this.f3151xf.unlock();
            }
        }

        @WorkerThread
        protected abstract void zzari();
    }

    public zzqn(zzqr zzqrVar, com.google.android.gms.common.internal.zzh zzhVar, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc zzcVar, Api.zza<? extends zzwz, zzxa> zzaVar, Lock lock, Context context) {
        this.f3152xk = zzqrVar;
        this.f3148xB = zzhVar;
        this.f3149xC = map;
        this.f3153xn = zzcVar;
        this.f3146vQ = zzaVar;
        this.f3151xf = lock;
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(SignInResponse signInResponse) {
        if (zzfr(0)) {
            ConnectionResult zzave = signInResponse.zzave();
            if (zzave.isSuccess()) {
                ResolveAccountResponse zzcdl = signInResponse.zzcdl();
                ConnectionResult zzave2 = zzcdl.zzave();
                if (!zzave2.isSuccess()) {
                    String valueOf = String.valueOf(zzave2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    zzg(zzave2);
                    return;
                }
                this.f3163xx = true;
                this.f3164xy = zzcdl.zzavd();
                this.f3165xz = zzcdl.zzavf();
                this.f3147xA = zzcdl.zzavg();
            } else if (!zzf(zzave)) {
                zzg(zzave);
                return;
            } else {
                zzarn();
            }
            zzark();
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zze(connectionResult)) {
            return this.f3154xo == null || i < this.f3155xp;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzarj() {
        ConnectionResult connectionResult;
        this.f3157xr--;
        int i = this.f3157xr;
        if (i > 0) {
            return false;
        }
        if (i < 0) {
            Log.w("GoogleApiClientConnecting", this.f3152xk.f3220wV.zzarv());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            connectionResult = new ConnectionResult(8, null);
        } else {
            connectionResult = this.f3154xo;
            if (connectionResult == null) {
                return true;
            }
            this.f3152xk.f3231yo = this.f3155xp;
        }
        zzg(connectionResult);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzark() {
        if (this.f3157xr != 0) {
            return;
        }
        if (!this.f3162xw || this.f3163xx) {
            zzarl();
        }
    }

    private void zzarl() {
        ArrayList arrayList = new ArrayList();
        this.f3156xq = 1;
        this.f3157xr = this.f3152xk.f3223xW.size();
        for (Api.zzc<?> zzcVar : this.f3152xk.f3223xW.keySet()) {
            if (!this.f3152xk.f3228yl.containsKey(zzcVar)) {
                arrayList.add(this.f3152xk.f3223xW.get(zzcVar));
            } else if (zzarj()) {
                zzarm();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f3150xD.add(zzqs.zzarz().submit(new zzc(arrayList)));
    }

    private void zzarm() {
        this.f3152xk.zzarx();
        zzqs.zzarz().execute(new Runnable() { // from class: com.google.android.gms.internal.zzqn.1
            @Override // java.lang.Runnable
            public void run() {
                zzqn.this.f3153xn.zzbq(zzqn.this.mContext);
            }
        });
        zzwz zzwzVar = this.f3160xu;
        if (zzwzVar != null) {
            if (this.f3165xz) {
                zzwzVar.zza(this.f3164xy, this.f3147xA);
            }
            zzbq(false);
        }
        for (Api.zzc<?> zzcVar : this.f3152xk.f3228yl.keySet()) {
            this.f3152xk.f3223xW.get(zzcVar).disconnect();
        }
        this.f3152xk.f3232yp.zzn(this.f3158xs.isEmpty() ? null : this.f3158xs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzarn() {
        this.f3162xw = false;
        this.f3152xk.f3220wV.f3199xX = Collections.emptySet();
        for (Api.zzc<?> zzcVar : this.f3159xt) {
            if (!this.f3152xk.f3228yl.containsKey(zzcVar)) {
                this.f3152xk.f3228yl.put(zzcVar, new ConnectionResult(17, null));
            }
        }
    }

    private void zzaro() {
        Iterator<Future<?>> it = this.f3150xD.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.f3150xD.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<Scope> zzarp() {
        com.google.android.gms.common.internal.zzh zzhVar = this.f3148xB;
        if (zzhVar == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(zzhVar.zzaug());
        Map<Api<?>, zzh.zza> zzaui = this.f3148xB.zzaui();
        for (Api<?> api : zzaui.keySet()) {
            if (!this.f3152xk.f3228yl.containsKey(api.zzapp())) {
                hashSet.addAll(zzaui.get(api).f2874hm);
            }
        }
        return hashSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzapm().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.f3154xo = connectionResult;
                this.f3155xp = priority;
            }
        }
        this.f3152xk.f3228yl.put(api.zzapp(), connectionResult);
    }

    private void zzbq(boolean z) {
        zzwz zzwzVar = this.f3160xu;
        if (zzwzVar != null) {
            if (zzwzVar.isConnected() && z) {
                this.f3160xu.zzcda();
            }
            this.f3160xu.disconnect();
            this.f3164xy = null;
        }
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.f3153xn.zzfl(connectionResult.getErrorCode()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzf(ConnectionResult connectionResult) {
        int i = this.f3161xv;
        if (i != 2) {
            return i == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzfr(int i) {
        if (this.f3156xq != i) {
            Log.w("GoogleApiClientConnecting", this.f3152xk.f3220wV.zzarv());
            String valueOf = String.valueOf(this);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Unexpected callback in ");
            sb.append(valueOf);
            Log.w("GoogleApiClientConnecting", sb.toString());
            int i2 = this.f3157xr;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("mRemainingConnections=");
            sb2.append(i2);
            Log.w("GoogleApiClientConnecting", sb2.toString());
            String valueOf2 = String.valueOf(zzfs(this.f3156xq));
            String valueOf3 = String.valueOf(zzfs(i));
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 70 + String.valueOf(valueOf3).length());
            sb3.append("GoogleApiClient connecting is in step ");
            sb3.append(valueOf2);
            sb3.append(" but received callback for step ");
            sb3.append(valueOf3);
            Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
            zzg(new ConnectionResult(8, null));
            return false;
        }
        return true;
    }

    private String zzfs(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzg(ConnectionResult connectionResult) {
        zzaro();
        zzbq(!connectionResult.hasResolution());
        this.f3152xk.zzi(connectionResult);
        this.f3152xk.f3232yp.zzd(connectionResult);
    }

    @Override // com.google.android.gms.internal.zzqq
    public void begin() {
        this.f3152xk.f3228yl.clear();
        this.f3162xw = false;
        this.f3154xo = null;
        this.f3156xq = 0;
        this.f3161xv = 2;
        this.f3163xx = false;
        this.f3165xz = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.f3149xC.keySet()) {
            Api.zze zzeVar = this.f3152xk.f3223xW.get(api.zzapp());
            int intValue = this.f3149xC.get(api).intValue();
            z |= api.zzapm().getPriority() == 1;
            if (zzeVar.zzahd()) {
                this.f3162xw = true;
                if (intValue < this.f3161xv) {
                    this.f3161xv = intValue;
                }
                if (intValue != 0) {
                    this.f3159xt.add(api.zzapp());
                }
            }
            hashMap.put(zzeVar, new zza(this, api, intValue));
        }
        if (z) {
            this.f3162xw = false;
        }
        if (this.f3162xw) {
            this.f3148xB.zzc(Integer.valueOf(this.f3152xk.f3220wV.getSessionId()));
            zze zzeVar2 = new zze();
            Api.zza<? extends zzwz, zzxa> zzaVar = this.f3146vQ;
            Context context = this.mContext;
            Looper looper = this.f3152xk.f3220wV.getLooper();
            com.google.android.gms.common.internal.zzh zzhVar = this.f3148xB;
            this.f3160xu = zzaVar.zza(context, looper, zzhVar, zzhVar.zzaum(), zzeVar2, zzeVar2);
        }
        this.f3157xr = this.f3152xk.f3223xW.size();
        this.f3150xD.add(zzqs.zzarz().submit(new zzb(hashMap)));
    }

    @Override // com.google.android.gms.internal.zzqq
    public void connect() {
    }

    @Override // com.google.android.gms.internal.zzqq
    public boolean disconnect() {
        zzaro();
        zzbq(true);
        this.f3152xk.zzi(null);
        return true;
    }

    @Override // com.google.android.gms.internal.zzqq
    public void onConnected(Bundle bundle) {
        if (zzfr(1)) {
            if (bundle != null) {
                this.f3158xs.putAll(bundle);
            }
            if (zzarj()) {
                zzarm();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqq
    public void onConnectionSuspended(int i) {
        zzg(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.internal.zzqq
    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzfr(1)) {
            zzb(connectionResult, api, i);
            if (zzarj()) {
                zzarm();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqq
    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(T t) {
        this.f3152xk.f3220wV.f3192xQ.add(t);
        return t;
    }

    @Override // com.google.android.gms.internal.zzqq
    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
