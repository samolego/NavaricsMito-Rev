package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p008v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzqh implements zzqy {
    private final Context mContext;

    /* renamed from: wV */
    private final zzqp f3123wV;

    /* renamed from: wW */
    private final zzqr f3124wW;

    /* renamed from: wX */
    private final zzqr f3125wX;

    /* renamed from: wY */
    private final Map<Api.zzc<?>, zzqr> f3126wY;

    /* renamed from: xa */
    private final Api.zze f3128xa;

    /* renamed from: xb */
    private Bundle f3129xb;

    /* renamed from: xf */
    private final Lock f3133xf;
    private final Looper zzajn;

    /* renamed from: wZ */
    private final Set<zzrl> f3127wZ = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: xc */
    private ConnectionResult f3130xc = null;

    /* renamed from: xd */
    private ConnectionResult f3131xd = null;

    /* renamed from: xe */
    private boolean f3132xe = false;

    /* renamed from: xg */
    private int f3134xg = 0;

    /* loaded from: classes.dex */
    private class zza implements zzqy.zza {
        private zza() {
        }

        @Override // com.google.android.gms.internal.zzqy.zza
        public void zzc(int i, boolean z) {
            zzqh.this.f3133xf.lock();
            try {
                if (!zzqh.this.f3132xe && zzqh.this.f3131xd != null && zzqh.this.f3131xd.isSuccess()) {
                    zzqh.this.f3132xe = true;
                    zzqh.this.f3125wX.onConnectionSuspended(i);
                    return;
                }
                zzqh.this.f3132xe = false;
                zzqh.this.zzb(i, z);
            } finally {
                zzqh.this.f3133xf.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqy.zza
        public void zzd(@NonNull ConnectionResult connectionResult) {
            zzqh.this.f3133xf.lock();
            try {
                zzqh.this.f3130xc = connectionResult;
                zzqh.this.zzarb();
            } finally {
                zzqh.this.f3133xf.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqy.zza
        public void zzn(@Nullable Bundle bundle) {
            zzqh.this.f3133xf.lock();
            try {
                zzqh.this.zzm(bundle);
                zzqh.this.f3130xc = ConnectionResult.f2638uJ;
                zzqh.this.zzarb();
            } finally {
                zzqh.this.f3133xf.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    private class zzb implements zzqy.zza {
        private zzb() {
        }

        @Override // com.google.android.gms.internal.zzqy.zza
        public void zzc(int i, boolean z) {
            zzqh.this.f3133xf.lock();
            try {
                if (zzqh.this.f3132xe) {
                    zzqh.this.f3132xe = false;
                    zzqh.this.zzb(i, z);
                    return;
                }
                zzqh.this.f3132xe = true;
                zzqh.this.f3124wW.onConnectionSuspended(i);
            } finally {
                zzqh.this.f3133xf.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqy.zza
        public void zzd(@NonNull ConnectionResult connectionResult) {
            zzqh.this.f3133xf.lock();
            try {
                zzqh.this.f3131xd = connectionResult;
                zzqh.this.zzarb();
            } finally {
                zzqh.this.f3133xf.unlock();
            }
        }

        @Override // com.google.android.gms.internal.zzqy.zza
        public void zzn(@Nullable Bundle bundle) {
            zzqh.this.f3133xf.lock();
            try {
                zzqh.this.f3131xd = ConnectionResult.f2638uJ;
                zzqh.this.zzarb();
            } finally {
                zzqh.this.f3133xf.unlock();
            }
        }
    }

    private zzqh(Context context, zzqp zzqpVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zze> map, Map<Api.zzc<?>, Api.zze> map2, com.google.android.gms.common.internal.zzh zzhVar, Api.zza<? extends zzwz, zzxa> zzaVar, Api.zze zzeVar, ArrayList<zzqf> arrayList, ArrayList<zzqf> arrayList2, Map<Api<?>, Integer> map3, Map<Api<?>, Integer> map4) {
        this.mContext = context;
        this.f3123wV = zzqpVar;
        this.f3133xf = lock;
        this.zzajn = looper;
        this.f3128xa = zzeVar;
        this.f3124wW = new zzqr(context, this.f3123wV, lock, looper, zzcVar, map2, null, map4, null, arrayList2, new zza());
        this.f3125wX = new zzqr(context, this.f3123wV, lock, looper, zzcVar, map, zzhVar, map3, zzaVar, arrayList, new zzb());
        ArrayMap arrayMap = new ArrayMap();
        for (Api.zzc<?> zzcVar2 : map2.keySet()) {
            arrayMap.put(zzcVar2, this.f3124wW);
        }
        for (Api.zzc<?> zzcVar3 : map.keySet()) {
            arrayMap.put(zzcVar3, this.f3125wX);
        }
        this.f3126wY = Collections.unmodifiableMap(arrayMap);
    }

    public static zzqh zza(Context context, zzqp zzqpVar, Lock lock, Looper looper, com.google.android.gms.common.zzc zzcVar, Map<Api.zzc<?>, Api.zze> map, com.google.android.gms.common.internal.zzh zzhVar, Map<Api<?>, Integer> map2, Api.zza<? extends zzwz, zzxa> zzaVar, ArrayList<zzqf> arrayList) {
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        Api.zze zzeVar = null;
        for (Map.Entry<Api.zzc<?>, Api.zze> entry : map.entrySet()) {
            Api.zze value = entry.getValue();
            if (value.zzahs()) {
                zzeVar = value;
            }
            if (value.zzahd()) {
                arrayMap.put(entry.getKey(), value);
            } else {
                arrayMap2.put(entry.getKey(), value);
            }
        }
        com.google.android.gms.common.internal.zzac.zza(!arrayMap.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        ArrayMap arrayMap3 = new ArrayMap();
        ArrayMap arrayMap4 = new ArrayMap();
        for (Api<?> api : map2.keySet()) {
            Api.zzc<?> zzapp = api.zzapp();
            if (arrayMap.containsKey(zzapp)) {
                arrayMap3.put(api, map2.get(api));
            } else if (!arrayMap2.containsKey(zzapp)) {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            } else {
                arrayMap4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator<zzqf> it = arrayList.iterator();
        while (it.hasNext()) {
            zzqf next = it.next();
            if (arrayMap3.containsKey(next.f3120tv)) {
                arrayList2.add(next);
            } else if (!arrayMap4.containsKey(next.f3120tv)) {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            } else {
                arrayList3.add(next);
            }
        }
        return new zzqh(context, zzqpVar, lock, looper, zzcVar, arrayMap, arrayMap2, zzhVar, zzaVar, zzeVar, arrayList2, arrayList3, arrayMap3, arrayMap4);
    }

    private void zzara() {
        this.f3131xd = null;
        this.f3130xc = null;
        this.f3124wW.connect();
        this.f3125wX.connect();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzarb() {
        ConnectionResult connectionResult;
        if (!zzc(this.f3130xc)) {
            if (this.f3130xc == null || !zzc(this.f3131xd)) {
                connectionResult = this.f3130xc;
                if (connectionResult == null || this.f3131xd == null) {
                    return;
                }
                if (this.f3125wX.f3231yo < this.f3124wW.f3231yo) {
                    connectionResult = this.f3131xd;
                }
            } else {
                this.f3125wX.disconnect();
                connectionResult = this.f3130xc;
            }
            zzb(connectionResult);
        } else if (zzc(this.f3131xd) || zzare()) {
            zzarc();
        } else {
            ConnectionResult connectionResult2 = this.f3131xd;
            if (connectionResult2 != null) {
                if (this.f3134xg == 1) {
                    zzard();
                    return;
                }
                zzb(connectionResult2);
                this.f3124wW.disconnect();
            }
        }
    }

    private void zzarc() {
        switch (this.f3134xg) {
            case 2:
                this.f3123wV.zzn(this.f3129xb);
            case 1:
                zzard();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        this.f3134xg = 0;
    }

    private void zzard() {
        for (zzrl zzrlVar : this.f3127wZ) {
            zzrlVar.zzahr();
        }
        this.f3127wZ.clear();
    }

    private boolean zzare() {
        ConnectionResult connectionResult = this.f3131xd;
        return connectionResult != null && connectionResult.getErrorCode() == 4;
    }

    @Nullable
    private PendingIntent zzarf() {
        if (this.f3128xa == null) {
            return null;
        }
        return PendingIntent.getActivity(this.mContext, this.f3123wV.getSessionId(), this.f3128xa.zzaht(), 134217728);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(int i, boolean z) {
        this.f3123wV.zzc(i, z);
        this.f3131xd = null;
        this.f3130xc = null;
    }

    private void zzb(ConnectionResult connectionResult) {
        switch (this.f3134xg) {
            case 2:
                this.f3123wV.zzd(connectionResult);
            case 1:
                zzard();
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        this.f3134xg = 0;
    }

    private static boolean zzc(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private boolean zze(zzqc.zza<? extends Result, ? extends Api.zzb> zzaVar) {
        Api.zzc<? extends Api.zzb> zzapp = zzaVar.zzapp();
        com.google.android.gms.common.internal.zzac.zzb(this.f3126wY.containsKey(zzapp), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f3126wY.get(zzapp).equals(this.f3125wX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzm(Bundle bundle) {
        Bundle bundle2 = this.f3129xb;
        if (bundle2 == null) {
            this.f3129xb = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    @Override // com.google.android.gms.internal.zzqy
    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.zzqy
    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.zzqy
    public void connect() {
        this.f3134xg = 2;
        this.f3132xe = false;
        zzara();
    }

    @Override // com.google.android.gms.internal.zzqy
    public void disconnect() {
        this.f3131xd = null;
        this.f3130xc = null;
        this.f3134xg = 0;
        this.f3124wW.disconnect();
        this.f3125wX.disconnect();
        zzard();
    }

    @Override // com.google.android.gms.internal.zzqy
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f3125wX.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f3124wW.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.internal.zzqy
    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        return this.f3126wY.get(api.zzapp()).equals(this.f3125wX) ? zzare() ? new ConnectionResult(4, zzarf()) : this.f3125wX.getConnectionResult(api) : this.f3124wW.getConnectionResult(api);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
        if (r2.f3134xg == 1) goto L12;
     */
    @Override // com.google.android.gms.internal.zzqy
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isConnected() {
        /*
            r2 = this;
            java.util.concurrent.locks.Lock r0 = r2.f3133xf
            r0.lock()
            com.google.android.gms.internal.zzqr r0 = r2.f3124wW     // Catch: java.lang.Throwable -> L26
            boolean r0 = r0.isConnected()     // Catch: java.lang.Throwable -> L26
            r1 = 1
            if (r0 == 0) goto L1f
            boolean r0 = r2.zzaqz()     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L20
            boolean r0 = r2.zzare()     // Catch: java.lang.Throwable -> L26
            if (r0 != 0) goto L20
            int r0 = r2.f3134xg     // Catch: java.lang.Throwable -> L26
            if (r0 != r1) goto L1f
            goto L20
        L1f:
            r1 = 0
        L20:
            java.util.concurrent.locks.Lock r0 = r2.f3133xf
            r0.unlock()
            return r1
        L26:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r2.f3133xf
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqh.isConnected():boolean");
    }

    @Override // com.google.android.gms.internal.zzqy
    public boolean isConnecting() {
        this.f3133xf.lock();
        try {
            return this.f3134xg == 2;
        } finally {
            this.f3133xf.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqy
    public boolean zza(zzrl zzrlVar) {
        this.f3133xf.lock();
        try {
            if ((!isConnecting() && !isConnected()) || zzaqz()) {
                this.f3133xf.unlock();
                return false;
            }
            this.f3127wZ.add(zzrlVar);
            if (this.f3134xg == 0) {
                this.f3134xg = 1;
            }
            this.f3131xd = null;
            this.f3125wX.connect();
            return true;
        } finally {
            this.f3133xf.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqy
    public void zzaqb() {
        this.f3133xf.lock();
        try {
            boolean isConnecting = isConnecting();
            this.f3125wX.disconnect();
            this.f3131xd = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.zzajn).post(new Runnable() { // from class: com.google.android.gms.internal.zzqh.1
                    @Override // java.lang.Runnable
                    public void run() {
                        zzqh.this.f3133xf.lock();
                        try {
                            zzqh.this.zzarb();
                        } finally {
                            zzqh.this.f3133xf.unlock();
                        }
                    }
                });
            } else {
                zzard();
            }
        } finally {
            this.f3133xf.unlock();
        }
    }

    @Override // com.google.android.gms.internal.zzqy
    public void zzaqy() {
        this.f3124wW.zzaqy();
        this.f3125wX.zzaqy();
    }

    public boolean zzaqz() {
        return this.f3125wX.isConnected();
    }

    @Override // com.google.android.gms.internal.zzqy
    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(@NonNull T t) {
        if (zze((zzqc.zza<? extends Result, ? extends Api.zzb>) t)) {
            if (zzare()) {
                t.zzz(new Status(4, null, zzarf()));
                return t;
            }
            return (T) this.f3125wX.zzc(t);
        }
        return (T) this.f3124wW.zzc(t);
    }

    @Override // com.google.android.gms.internal.zzqy
    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(@NonNull T t) {
        if (zze((zzqc.zza<? extends Result, ? extends Api.zzb>) t)) {
            if (zzare()) {
                t.zzz(new Status(4, null, zzarf()));
                return t;
            }
            return (T) this.f3125wX.zzd(t);
        }
        return (T) this.f3124wW.zzd(t);
    }
}
