package com.google.android.gms.common.internal;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzo extends zzn implements Handler.Callback {

    /* renamed from: CB */
    private final HashMap<zza, zzb> f2891CB = new HashMap<>();

    /* renamed from: CC */
    private final com.google.android.gms.common.stats.zzb f2892CC = com.google.android.gms.common.stats.zzb.zzawu();

    /* renamed from: CD */
    private final long f2893CD = 5000;
    private final Handler mHandler;
    private final Context zzask;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: CE */
        private final String f2894CE;

        /* renamed from: CF */
        private final ComponentName f2895CF;

        /* renamed from: V */
        private final String f2896V;

        public zza(ComponentName componentName) {
            this.f2896V = null;
            this.f2894CE = null;
            this.f2895CF = (ComponentName) zzac.zzy(componentName);
        }

        public zza(String str, String str2) {
            this.f2896V = zzac.zzhz(str);
            this.f2894CE = zzac.zzhz(str2);
            this.f2895CF = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof zza) {
                zza zzaVar = (zza) obj;
                return zzab.equal(this.f2896V, zzaVar.f2896V) && zzab.equal(this.f2895CF, zzaVar.f2895CF);
            }
            return false;
        }

        public int hashCode() {
            return zzab.hashCode(this.f2896V, this.f2895CF);
        }

        public String toString() {
            String str = this.f2896V;
            return str == null ? this.f2895CF.flattenToString() : str;
        }

        public Intent zzauv() {
            String str = this.f2896V;
            return str != null ? new Intent(str).setPackage(this.f2894CE) : new Intent().setComponent(this.f2895CF);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class zzb {

        /* renamed from: Bz */
        private IBinder f2897Bz;

        /* renamed from: CF */
        private ComponentName f2898CF;

        /* renamed from: CI */
        private boolean f2901CI;

        /* renamed from: CJ */
        private final zza f2902CJ;

        /* renamed from: CG */
        private final zza f2899CG = new zza();

        /* renamed from: CH */
        private final Set<ServiceConnection> f2900CH = new HashSet();
        private int mState = 2;

        /* loaded from: classes.dex */
        public class zza implements ServiceConnection {
            public zza() {
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                synchronized (zzo.this.f2891CB) {
                    zzb.this.f2897Bz = iBinder;
                    zzb.this.f2898CF = componentName;
                    for (ServiceConnection serviceConnection : zzb.this.f2900CH) {
                        serviceConnection.onServiceConnected(componentName, iBinder);
                    }
                    zzb.this.mState = 1;
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                synchronized (zzo.this.f2891CB) {
                    zzb.this.f2897Bz = null;
                    zzb.this.f2898CF = componentName;
                    for (ServiceConnection serviceConnection : zzb.this.f2900CH) {
                        serviceConnection.onServiceDisconnected(componentName);
                    }
                    zzb.this.mState = 2;
                }
            }
        }

        public zzb(zza zzaVar) {
            this.f2902CJ = zzaVar;
        }

        public IBinder getBinder() {
            return this.f2897Bz;
        }

        public ComponentName getComponentName() {
            return this.f2898CF;
        }

        public int getState() {
            return this.mState;
        }

        public boolean isBound() {
            return this.f2901CI;
        }

        public void zza(ServiceConnection serviceConnection, String str) {
            zzo.this.f2892CC.zza(zzo.this.zzask, serviceConnection, str, this.f2902CJ.zzauv());
            this.f2900CH.add(serviceConnection);
        }

        public boolean zza(ServiceConnection serviceConnection) {
            return this.f2900CH.contains(serviceConnection);
        }

        public boolean zzauw() {
            return this.f2900CH.isEmpty();
        }

        public void zzb(ServiceConnection serviceConnection, String str) {
            zzo.this.f2892CC.zzb(zzo.this.zzask, serviceConnection);
            this.f2900CH.remove(serviceConnection);
        }

        @TargetApi(14)
        public void zzhu(String str) {
            this.mState = 3;
            this.f2901CI = zzo.this.f2892CC.zza(zzo.this.zzask, str, this.f2902CJ.zzauv(), this.f2899CG, 129);
            if (this.f2901CI) {
                return;
            }
            this.mState = 2;
            try {
                zzo.this.f2892CC.zza(zzo.this.zzask, this.f2899CG);
            } catch (IllegalArgumentException unused) {
            }
        }

        public void zzhv(String str) {
            zzo.this.f2892CC.zza(zzo.this.zzask, this.f2899CG);
            this.f2901CI = false;
            this.mState = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(Context context) {
        this.zzask = context.getApplicationContext();
        this.mHandler = new Handler(context.getMainLooper(), this);
    }

    private boolean zza(zza zzaVar, ServiceConnection serviceConnection, String str) {
        boolean isBound;
        zzac.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f2891CB) {
            zzb zzbVar = this.f2891CB.get(zzaVar);
            if (zzbVar == null) {
                zzbVar = new zzb(zzaVar);
                zzbVar.zza(serviceConnection, str);
                zzbVar.zzhu(str);
                this.f2891CB.put(zzaVar, zzbVar);
            } else {
                this.mHandler.removeMessages(0, zzbVar);
                if (!zzbVar.zza(serviceConnection)) {
                    zzbVar.zza(serviceConnection, str);
                    switch (zzbVar.getState()) {
                        case 1:
                            serviceConnection.onServiceConnected(zzbVar.getComponentName(), zzbVar.getBinder());
                            break;
                        case 2:
                            zzbVar.zzhu(str);
                            break;
                    }
                } else {
                    String valueOf = String.valueOf(zzaVar);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 81);
                    sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                    sb.append(valueOf);
                    throw new IllegalStateException(sb.toString());
                }
            }
            isBound = zzbVar.isBound();
        }
        return isBound;
    }

    private void zzb(zza zzaVar, ServiceConnection serviceConnection, String str) {
        zzac.zzb(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f2891CB) {
            zzb zzbVar = this.f2891CB.get(zzaVar);
            if (zzbVar == null) {
                String valueOf = String.valueOf(zzaVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 50);
                sb.append("Nonexistent connection status for service config: ");
                sb.append(valueOf);
                throw new IllegalStateException(sb.toString());
            } else if (!zzbVar.zza(serviceConnection)) {
                String valueOf2 = String.valueOf(zzaVar);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 76);
                sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                sb2.append(valueOf2);
                throw new IllegalStateException(sb2.toString());
            } else {
                zzbVar.zzb(serviceConnection, str);
                if (zzbVar.zzauw()) {
                    this.mHandler.sendMessageDelayed(this.mHandler.obtainMessage(0, zzbVar), this.f2893CD);
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
            return false;
        }
        zzb zzbVar = (zzb) message.obj;
        synchronized (this.f2891CB) {
            if (zzbVar.zzauw()) {
                if (zzbVar.isBound()) {
                    zzbVar.zzhv("GmsClientSupervisor");
                }
                this.f2891CB.remove(zzbVar.f2902CJ);
            }
        }
        return true;
    }

    @Override // com.google.android.gms.common.internal.zzn
    public boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        return zza(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzn
    public boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return zza(new zza(str, str2), serviceConnection, str3);
    }

    @Override // com.google.android.gms.common.internal.zzn
    public void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str) {
        zzb(new zza(componentName), serviceConnection, str);
    }

    @Override // com.google.android.gms.common.internal.zzn
    public void zzb(String str, String str2, ServiceConnection serviceConnection, String str3) {
        zzb(new zza(str, str2), serviceConnection, str3);
    }
}
