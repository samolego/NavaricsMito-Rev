package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.zzf;
import com.google.android.gms.location.zzg;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzk {
    private final zzp<zzi> ahK;
    private final Context mContext;
    private ContentProviderClient ahX = null;
    private boolean ahY = false;

    /* renamed from: Tx */
    private Map<LocationListener, zzc> f3402Tx = new HashMap();
    private Map<LocationCallback, zza> ahZ = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class zza extends zzf.zza {
        private Handler aia;

        zza(final LocationCallback locationCallback, Looper looper) {
            if (looper == null) {
                looper = Looper.myLooper();
                zzac.zza(looper != null, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.aia = new Handler(looper) { // from class: com.google.android.gms.location.internal.zzk.zza.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    switch (message.what) {
                        case 0:
                            locationCallback.onLocationResult((LocationResult) message.obj);
                            return;
                        case 1:
                            locationCallback.onLocationAvailability((LocationAvailability) message.obj);
                            return;
                        default:
                            return;
                    }
                }
            };
        }

        private synchronized void zzb(int i, Object obj) {
            if (this.aia == null) {
                Log.e("LocationClientHelper", "Received a data in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.obj = obj;
            this.aia.sendMessage(obtain);
        }

        @Override // com.google.android.gms.location.zzf
        public void onLocationAvailability(LocationAvailability locationAvailability) {
            zzb(1, locationAvailability);
        }

        @Override // com.google.android.gms.location.zzf
        public void onLocationResult(LocationResult locationResult) {
            zzb(0, locationResult);
        }

        public synchronized void release() {
            this.aia = null;
        }
    }

    /* loaded from: classes.dex */
    private static class zzb extends Handler {
        private final LocationListener aic;

        public zzb(LocationListener locationListener) {
            this.aic = locationListener;
        }

        public zzb(LocationListener locationListener, Looper looper) {
            super(looper);
            this.aic = locationListener;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
                return;
            }
            this.aic.onLocationChanged(new Location((Location) message.obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class zzc extends zzg.zza {
        private Handler aia;

        zzc(LocationListener locationListener, Looper looper) {
            if (looper == null) {
                zzac.zza(Looper.myLooper() != null, "Can't create handler inside thread that has not called Looper.prepare()");
            }
            this.aia = looper == null ? new zzb(locationListener) : new zzb(locationListener, looper);
        }

        @Override // com.google.android.gms.location.zzg
        public synchronized void onLocationChanged(Location location) {
            if (this.aia == null) {
                Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = location;
            this.aia.sendMessage(obtain);
        }

        public synchronized void release() {
            this.aia = null;
        }
    }

    public zzk(Context context, zzp<zzi> zzpVar) {
        this.mContext = context;
        this.ahK = zzpVar;
    }

    private zza zza(LocationCallback locationCallback, Looper looper) {
        zza zzaVar;
        synchronized (this.ahZ) {
            zzaVar = this.ahZ.get(locationCallback);
            if (zzaVar == null) {
                zzaVar = new zza(locationCallback, looper);
            }
            this.ahZ.put(locationCallback, zzaVar);
        }
        return zzaVar;
    }

    private zzc zza(LocationListener locationListener, Looper looper) {
        zzc zzcVar;
        synchronized (this.f3402Tx) {
            zzcVar = this.f3402Tx.get(locationListener);
            if (zzcVar == null) {
                zzcVar = new zzc(locationListener, looper);
            }
            this.f3402Tx.put(locationListener, zzcVar);
        }
        return zzcVar;
    }

    public Location getLastLocation() {
        this.ahK.zzatw();
        try {
            return this.ahK.zzatx().zzkx(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void removeAllListeners() {
        try {
            synchronized (this.f3402Tx) {
                for (zzc zzcVar : this.f3402Tx.values()) {
                    if (zzcVar != null) {
                        this.ahK.zzatx().zza(LocationRequestUpdateData.zza(zzcVar, (zzg) null));
                    }
                }
                this.f3402Tx.clear();
            }
            synchronized (this.ahZ) {
                for (zza zzaVar : this.ahZ.values()) {
                    if (zzaVar != null) {
                        this.ahK.zzatx().zza(LocationRequestUpdateData.zza(zzaVar, (zzg) null));
                    }
                }
                this.ahZ.clear();
            }
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zza(PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.ahK.zzatw();
        this.ahK.zzatx().zza(LocationRequestUpdateData.zzb(pendingIntent, zzgVar));
    }

    public void zza(LocationCallback locationCallback, zzg zzgVar) throws RemoteException {
        this.ahK.zzatw();
        zzac.zzb(locationCallback, "Invalid null callback");
        synchronized (this.ahZ) {
            zza remove = this.ahZ.remove(locationCallback);
            if (remove != null) {
                remove.release();
                this.ahK.zzatx().zza(LocationRequestUpdateData.zza(remove, zzgVar));
            }
        }
    }

    public void zza(LocationListener locationListener, zzg zzgVar) throws RemoteException {
        this.ahK.zzatw();
        zzac.zzb(locationListener, "Invalid null listener");
        synchronized (this.f3402Tx) {
            zzc remove = this.f3402Tx.remove(locationListener);
            if (remove != null) {
                remove.release();
                this.ahK.zzatx().zza(LocationRequestUpdateData.zza(remove, zzgVar));
            }
        }
    }

    public void zza(LocationRequest locationRequest, PendingIntent pendingIntent, zzg zzgVar) throws RemoteException {
        this.ahK.zzatw();
        this.ahK.zzatx().zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), pendingIntent, zzgVar));
    }

    public void zza(LocationRequest locationRequest, LocationListener locationListener, Looper looper, zzg zzgVar) throws RemoteException {
        this.ahK.zzatw();
        this.ahK.zzatx().zza(LocationRequestUpdateData.zza(LocationRequestInternal.zzb(locationRequest), zza(locationListener, looper), zzgVar));
    }

    public void zza(LocationRequestInternal locationRequestInternal, LocationCallback locationCallback, Looper looper, zzg zzgVar) throws RemoteException {
        this.ahK.zzatw();
        this.ahK.zzatx().zza(LocationRequestUpdateData.zza(locationRequestInternal, zza(locationCallback, looper), zzgVar));
    }

    public void zza(zzg zzgVar) throws RemoteException {
        this.ahK.zzatw();
        this.ahK.zzatx().zza(zzgVar);
    }

    public LocationAvailability zzbpl() {
        this.ahK.zzatw();
        try {
            return this.ahK.zzatx().zzky(this.mContext.getPackageName());
        } catch (RemoteException e) {
            throw new IllegalStateException(e);
        }
    }

    public void zzbpm() {
        if (this.ahY) {
            try {
                zzcc(false);
            } catch (RemoteException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    public void zzcc(boolean z) throws RemoteException {
        this.ahK.zzatw();
        this.ahK.zzatx().zzcc(z);
        this.ahY = z;
    }

    public void zzd(Location location) throws RemoteException {
        this.ahK.zzatw();
        this.ahK.zzatx().zzd(location);
    }
}
