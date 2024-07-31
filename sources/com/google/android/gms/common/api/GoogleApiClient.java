package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.app.FragmentActivity;
import android.support.p008v4.util.ArrayMap;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.internal.zzqa;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqf;
import com.google.android.gms.internal.zzqp;
import com.google.android.gms.internal.zzqz;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.internal.zzrl;
import com.google.android.gms.internal.zzrp;
import com.google.android.gms.internal.zzwy;
import com.google.android.gms.internal.zzwz;
import com.google.android.gms.internal.zzxa;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class GoogleApiClient {
    public static final int SIGN_IN_MODE_OPTIONAL = 2;
    public static final int SIGN_IN_MODE_REQUIRED = 1;

    /* renamed from: vE */
    private static final Set<GoogleApiClient> f2663vE = Collections.newSetFromMap(new WeakHashMap());

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: ec */
        private Account f2664ec;

        /* renamed from: fo */
        private String f2665fo;
        private final Context mContext;

        /* renamed from: vF */
        private final Set<Scope> f2666vF;

        /* renamed from: vG */
        private final Set<Scope> f2667vG;

        /* renamed from: vH */
        private int f2668vH;

        /* renamed from: vI */
        private View f2669vI;

        /* renamed from: vJ */
        private String f2670vJ;

        /* renamed from: vK */
        private final Map<Api<?>, zzh.zza> f2671vK;

        /* renamed from: vL */
        private final Map<Api<?>, Api.ApiOptions> f2672vL;

        /* renamed from: vM */
        private zzqz f2673vM;

        /* renamed from: vN */
        private int f2674vN;

        /* renamed from: vO */
        private OnConnectionFailedListener f2675vO;

        /* renamed from: vP */
        private GoogleApiAvailability f2676vP;

        /* renamed from: vQ */
        private Api.zza<? extends zzwz, zzxa> f2677vQ;

        /* renamed from: vR */
        private final ArrayList<ConnectionCallbacks> f2678vR;

        /* renamed from: vS */
        private final ArrayList<OnConnectionFailedListener> f2679vS;
        private Looper zzajn;

        public Builder(@NonNull Context context) {
            this.f2666vF = new HashSet();
            this.f2667vG = new HashSet();
            this.f2671vK = new ArrayMap();
            this.f2672vL = new ArrayMap();
            this.f2674vN = -1;
            this.f2676vP = GoogleApiAvailability.getInstance();
            this.f2677vQ = zzwy.f3379fb;
            this.f2678vR = new ArrayList<>();
            this.f2679vS = new ArrayList<>();
            this.mContext = context;
            this.zzajn = context.getMainLooper();
            this.f2665fo = context.getPackageName();
            this.f2670vJ = context.getClass().getName();
        }

        public Builder(@NonNull Context context, @NonNull ConnectionCallbacks connectionCallbacks, @NonNull OnConnectionFailedListener onConnectionFailedListener) {
            this(context);
            zzac.zzb(connectionCallbacks, "Must provide a connected listener");
            this.f2678vR.add(connectionCallbacks);
            zzac.zzb(onConnectionFailedListener, "Must provide a connection failed listener");
            this.f2679vS.add(onConnectionFailedListener);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zze, O> C zza(Api.zza<C, O> zzaVar, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzaVar.zza(context, looper, zzhVar, obj, connectionCallbacks, onConnectionFailedListener);
        }

        private Builder zza(@NonNull zzqz zzqzVar, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            zzac.zzb(i >= 0, "clientId must be non-negative");
            this.f2674vN = i;
            this.f2675vO = onConnectionFailedListener;
            this.f2673vM = zzqzVar;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <C extends Api.zzg, O> zzai zza(Api.zzh<C, O> zzhVar, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zzh zzhVar2, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzai(context, looper, zzhVar.zzapt(), connectionCallbacks, onConnectionFailedListener, zzhVar2, zzhVar.zzr(obj));
        }

        private <O extends Api.ApiOptions> void zza(Api<O> api, O o, int i, Scope... scopeArr) {
            boolean z = true;
            if (i != 1) {
                if (i != 2) {
                    StringBuilder sb = new StringBuilder(90);
                    sb.append("Invalid resolution mode: '");
                    sb.append(i);
                    sb.append("', use a constant from GoogleApiClient.ResolutionMode");
                    throw new IllegalArgumentException(sb.toString());
                }
                z = false;
            }
            HashSet hashSet = new HashSet(api.zzapm().zzp(o));
            for (Scope scope : scopeArr) {
                hashSet.add(scope);
            }
            this.f2671vK.put(api, new zzh.zza(hashSet, z));
        }

        private GoogleApiClient zzaqe() {
            Api<?> api;
            Api.zze zza;
            com.google.android.gms.common.internal.zzh zzaqd = zzaqd();
            Map<Api<?>, zzh.zza> zzaui = zzaqd.zzaui();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            Iterator<Api<?>> it = this.f2672vL.keySet().iterator();
            Api<?> api2 = null;
            Api<?> api3 = null;
            while (true) {
                if (!it.hasNext()) {
                    if (api3 != null) {
                        if (api2 != null) {
                            String valueOf = String.valueOf(api3.getName());
                            String valueOf2 = String.valueOf(api2.getName());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21 + String.valueOf(valueOf2).length());
                            sb.append(valueOf);
                            sb.append(" cannot be used with ");
                            sb.append(valueOf2);
                            throw new IllegalStateException(sb.toString());
                        }
                        zzac.zza(this.f2664ec == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", api3.getName());
                        zzac.zza(this.f2666vF.equals(this.f2667vG), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", api3.getName());
                    }
                    return new zzqp(this.mContext, new ReentrantLock(), this.zzajn, zzaqd, this.f2676vP, this.f2677vQ, arrayMap, this.f2678vR, this.f2679vS, arrayMap2, this.f2674vN, zzqp.zza(arrayMap2.values(), true), arrayList);
                }
                Api<?> next = it.next();
                Api.ApiOptions apiOptions = this.f2672vL.get(next);
                int i = zzaui.get(next) != null ? zzaui.get(next).f2873Cb ? 1 : 2 : 0;
                arrayMap.put(next, Integer.valueOf(i));
                zzqf zzqfVar = new zzqf(next, i);
                arrayList.add(zzqfVar);
                if (next.zzapq()) {
                    Api.zzh<?, ?> zzapo = next.zzapo();
                    api = zzapo.getPriority() == 1 ? next : api2;
                    zza = zza(zzapo, apiOptions, this.mContext, this.zzajn, zzaqd, zzqfVar, zzqfVar);
                } else {
                    Api.zza<?, ?> zzapn = next.zzapn();
                    api = zzapn.getPriority() == 1 ? next : api2;
                    zza = zza((Api.zza<Api.zze, O>) zzapn, (Object) apiOptions, this.mContext, this.zzajn, zzaqd, (ConnectionCallbacks) zzqfVar, (OnConnectionFailedListener) zzqfVar);
                }
                arrayMap2.put(next.zzapp(), zza);
                if (zza.zzahs()) {
                    if (api3 != null) {
                        String valueOf3 = String.valueOf(next.getName());
                        String valueOf4 = String.valueOf(api3.getName());
                        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 21 + String.valueOf(valueOf4).length());
                        sb2.append(valueOf3);
                        sb2.append(" cannot be used with ");
                        sb2.append(valueOf4);
                        throw new IllegalStateException(sb2.toString());
                    }
                    api3 = next;
                }
                api2 = api;
            }
        }

        private void zzf(GoogleApiClient googleApiClient) {
            zzqa.zza(this.f2673vM).zza(this.f2674vN, googleApiClient, this.f2675vO);
        }

        public Builder addApi(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api) {
            zzac.zzb(api, "Api must not be null");
            this.f2672vL.put(api, null);
            List<Scope> zzp = api.zzapm().zzp(null);
            this.f2667vG.addAll(zzp);
            this.f2666vF.addAll(zzp);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApi(@NonNull Api<O> api, @NonNull O o) {
            zzac.zzb(api, "Api must not be null");
            zzac.zzb(o, "Null options are not permitted for this Api");
            this.f2672vL.put(api, o);
            List<Scope> zzp = api.zzapm().zzp(o);
            this.f2667vG.addAll(zzp);
            this.f2666vF.addAll(zzp);
            return this;
        }

        public <O extends Api.ApiOptions.HasOptions> Builder addApiIfAvailable(@NonNull Api<O> api, @NonNull O o, Scope... scopeArr) {
            zzac.zzb(api, "Api must not be null");
            zzac.zzb(o, "Null options are not permitted for this Api");
            this.f2672vL.put(api, o);
            zza(api, o, 1, scopeArr);
            return this;
        }

        public Builder addApiIfAvailable(@NonNull Api<? extends Api.ApiOptions.NotRequiredOptions> api, Scope... scopeArr) {
            zzac.zzb(api, "Api must not be null");
            this.f2672vL.put(api, null);
            zza(api, null, 1, scopeArr);
            return this;
        }

        public Builder addConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks) {
            zzac.zzb(connectionCallbacks, "Listener must not be null");
            this.f2678vR.add(connectionCallbacks);
            return this;
        }

        public Builder addOnConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener) {
            zzac.zzb(onConnectionFailedListener, "Listener must not be null");
            this.f2679vS.add(onConnectionFailedListener);
            return this;
        }

        public Builder addScope(@NonNull Scope scope) {
            zzac.zzb(scope, "Scope must not be null");
            this.f2666vF.add(scope);
            return this;
        }

        public GoogleApiClient build() {
            zzac.zzb(!this.f2672vL.isEmpty(), "must call addApi() to add at least one API");
            GoogleApiClient zzaqe = zzaqe();
            synchronized (GoogleApiClient.f2663vE) {
                GoogleApiClient.f2663vE.add(zzaqe);
            }
            if (this.f2674vN >= 0) {
                zzf(zzaqe);
            }
            return zzaqe;
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, int i, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return zza(new zzqz(fragmentActivity), i, onConnectionFailedListener);
        }

        public Builder enableAutoManage(@NonNull FragmentActivity fragmentActivity, @Nullable OnConnectionFailedListener onConnectionFailedListener) {
            return enableAutoManage(fragmentActivity, 0, onConnectionFailedListener);
        }

        public Builder setAccountName(String str) {
            this.f2664ec = str == null ? null : new Account(str, "com.google");
            return this;
        }

        public Builder setGravityForPopups(int i) {
            this.f2668vH = i;
            return this;
        }

        public Builder setHandler(@NonNull Handler handler) {
            zzac.zzb(handler, "Handler must not be null");
            this.zzajn = handler.getLooper();
            return this;
        }

        public Builder setViewForPopups(@NonNull View view) {
            zzac.zzb(view, "View must not be null");
            this.f2669vI = view;
            return this;
        }

        public Builder useDefaultAccount() {
            return setAccountName("<<default account>>");
        }

        public com.google.android.gms.common.internal.zzh zzaqd() {
            zzxa zzxaVar = zzxa.aAa;
            if (this.f2672vL.containsKey(zzwy.API)) {
                zzxaVar = (zzxa) this.f2672vL.get(zzwy.API);
            }
            return new com.google.android.gms.common.internal.zzh(this.f2664ec, this.f2666vF, this.f2671vK, this.f2668vH, this.f2669vI, this.f2665fo, this.f2670vJ, zzxaVar);
        }
    }

    /* loaded from: classes.dex */
    public interface ConnectionCallbacks {
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* loaded from: classes.dex */
    public interface OnConnectionFailedListener {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    public static void dumpAll(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        synchronized (f2663vE) {
            int i = 0;
            String concat = String.valueOf(str).concat("  ");
            for (GoogleApiClient googleApiClient : f2663vE) {
                printWriter.append((CharSequence) str).append("GoogleApiClient#").println(i);
                googleApiClient.dump(concat, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public static Set<GoogleApiClient> zzaqa() {
        Set<GoogleApiClient> set;
        synchronized (f2663vE) {
            set = f2663vE;
        }
        return set;
    }

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit);

    public abstract PendingResult<Status> clearDefaultAccountAndReconnect();

    public abstract void connect();

    public void connect(int i) {
        throw new UnsupportedOperationException();
    }

    public abstract void disconnect();

    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    @NonNull
    public abstract ConnectionResult getConnectionResult(@NonNull Api<?> api);

    public Context getContext() {
        throw new UnsupportedOperationException();
    }

    public Looper getLooper() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean hasConnectedApi(@NonNull Api<?> api);

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract boolean isConnectionCallbacksRegistered(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract boolean isConnectionFailedListenerRegistered(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void reconnect();

    public abstract void registerConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void registerConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    public abstract void stopAutoManage(@NonNull FragmentActivity fragmentActivity);

    public abstract void unregisterConnectionCallbacks(@NonNull ConnectionCallbacks connectionCallbacks);

    public abstract void unregisterConnectionFailedListener(@NonNull OnConnectionFailedListener onConnectionFailedListener);

    @NonNull
    public <C extends Api.zze> C zza(@NonNull Api.zzc<C> zzcVar) {
        throw new UnsupportedOperationException();
    }

    public void zza(zzrp zzrpVar) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(@NonNull Api<?> api) {
        throw new UnsupportedOperationException();
    }

    public boolean zza(zzrl zzrlVar) {
        throw new UnsupportedOperationException();
    }

    public void zzaqb() {
        throw new UnsupportedOperationException();
    }

    public void zzb(zzrp zzrpVar) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    public <L> zzrd<L> zzs(@NonNull L l) {
        throw new UnsupportedOperationException();
    }
}
