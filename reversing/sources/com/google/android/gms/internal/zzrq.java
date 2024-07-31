package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class zzrq {

    /* renamed from: zt */
    private static final zzqe<?>[] f3315zt = new zzqe[0];

    /* renamed from: vC */
    private final Api.zze f3316vC;

    /* renamed from: xW */
    private final Map<Api.zzc<?>, Api.zze> f3317xW;

    /* renamed from: zu */
    final Set<zzqe<?>> f3318zu;

    /* renamed from: zv */
    private final zzb f3319zv;

    /* renamed from: zw */
    private zzc f3320zw;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class zza implements IBinder.DeathRecipient, zzb {

        /* renamed from: zA */
        private final WeakReference<IBinder> f3322zA;

        /* renamed from: zy */
        private final WeakReference<zzqe<?>> f3323zy;

        /* renamed from: zz */
        private final WeakReference<com.google.android.gms.common.api.zzf> f3324zz;

        private zza(zzqe<?> zzqeVar, com.google.android.gms.common.api.zzf zzfVar, IBinder iBinder) {
            this.f3324zz = new WeakReference<>(zzfVar);
            this.f3323zy = new WeakReference<>(zzqeVar);
            this.f3322zA = new WeakReference<>(iBinder);
        }

        private void zzasd() {
            zzqe<?> zzqeVar = this.f3323zy.get();
            com.google.android.gms.common.api.zzf zzfVar = this.f3324zz.get();
            if (zzfVar != null && zzqeVar != null) {
                zzfVar.remove(zzqeVar.zzaqf().intValue());
            }
            IBinder iBinder = this.f3322zA.get();
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            zzasd();
        }

        @Override // com.google.android.gms.internal.zzrq.zzb
        public void zzc(zzqe<?> zzqeVar) {
            zzasd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface zzb {
        void zzc(zzqe<?> zzqeVar);
    }

    /* loaded from: classes.dex */
    interface zzc {
        void zzask();
    }

    public zzrq(Api.zze zzeVar) {
        this.f3318zu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f3319zv = new zzb() { // from class: com.google.android.gms.internal.zzrq.1
            @Override // com.google.android.gms.internal.zzrq.zzb
            public void zzc(zzqe<?> zzqeVar) {
                zzrq.this.f3318zu.remove(zzqeVar);
                if (zzqeVar.zzaqf() != null && zzrq.zza(zzrq.this) != null) {
                    zzrq.zza(zzrq.this).remove(zzqeVar.zzaqf().intValue());
                }
                if (zzrq.this.f3320zw == null || !zzrq.this.f3318zu.isEmpty()) {
                    return;
                }
                zzrq.this.f3320zw.zzask();
            }
        };
        this.f3320zw = null;
        this.f3317xW = null;
        this.f3316vC = zzeVar;
    }

    public zzrq(Map<Api.zzc<?>, Api.zze> map) {
        this.f3318zu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f3319zv = new zzb() { // from class: com.google.android.gms.internal.zzrq.1
            @Override // com.google.android.gms.internal.zzrq.zzb
            public void zzc(zzqe<?> zzqeVar) {
                zzrq.this.f3318zu.remove(zzqeVar);
                if (zzqeVar.zzaqf() != null && zzrq.zza(zzrq.this) != null) {
                    zzrq.zza(zzrq.this).remove(zzqeVar.zzaqf().intValue());
                }
                if (zzrq.this.f3320zw == null || !zzrq.this.f3318zu.isEmpty()) {
                    return;
                }
                zzrq.this.f3320zw.zzask();
            }
        };
        this.f3320zw = null;
        this.f3317xW = map;
        this.f3316vC = null;
    }

    static /* synthetic */ com.google.android.gms.common.api.zzf zza(zzrq zzrqVar) {
        return null;
    }

    private static void zza(zzqe<?> zzqeVar, com.google.android.gms.common.api.zzf zzfVar, IBinder iBinder) {
        if (zzqeVar.isReady()) {
            zzqeVar.zza(new zza(zzqeVar, zzfVar, iBinder));
            return;
        }
        if (iBinder == null || !iBinder.isBinderAlive()) {
            zzqeVar.zza((zzb) null);
        } else {
            zza zzaVar = new zza(zzqeVar, zzfVar, iBinder);
            zzqeVar.zza(zzaVar);
            try {
                iBinder.linkToDeath(zzaVar, 0);
                return;
            } catch (RemoteException unused) {
            }
        }
        zzqeVar.cancel();
        zzfVar.remove(zzqeVar.zzaqf().intValue());
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f3318zu.size());
    }

    public void release() {
        int i;
        IBinder iBinder;
        zzqe[] zzqeVarArr = (zzqe[]) this.f3318zu.toArray(f3315zt);
        int length = zzqeVarArr.length;
        while (i < length) {
            zzqe zzqeVar = zzqeVarArr[i];
            zzqeVar.zza((zzb) null);
            if (zzqeVar.zzaqf() == null) {
                i = zzqeVar.zzaqq() ? 0 : i + 1;
            } else {
                zzqeVar.zzaqs();
                Api.zze zzeVar = this.f3316vC;
                if (zzeVar == null) {
                    Map<Api.zzc<?>, Api.zze> map = this.f3317xW;
                    if (map != null) {
                        zzeVar = map.get(((zzqc.zza) zzqeVar).zzapp());
                    } else {
                        Log.wtf("UnconsumedApiCalls", "Could not get service broker binder", new Exception());
                        iBinder = null;
                        zza(zzqeVar, null, iBinder);
                    }
                }
                iBinder = zzeVar.zzaps();
                zza(zzqeVar, null, iBinder);
            }
            this.f3318zu.remove(zzqeVar);
        }
    }

    public void zza(zzc zzcVar) {
        if (this.f3318zu.isEmpty()) {
            zzcVar.zzask();
        }
        this.f3320zw = zzcVar;
    }

    public void zzasw() {
        for (zzqe zzqeVar : (zzqe[]) this.f3318zu.toArray(f3315zt)) {
            zzqeVar.zzaa(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzasx() {
        for (zzqe zzqeVar : (zzqe[]) this.f3318zu.toArray(f3315zt)) {
            if (!zzqeVar.isReady()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzb(zzqe<? extends Result> zzqeVar) {
        this.f3318zu.add(zzqeVar);
        zzqeVar.zza(this.f3319zv);
    }
}
