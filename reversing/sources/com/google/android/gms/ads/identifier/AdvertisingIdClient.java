package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzci;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AdvertisingIdClient {
    private final Context mContext;
    com.google.android.gms.common.zza zzaku;
    zzci zzakv;
    boolean zzakw;
    Object zzakx;
    zza zzaky;
    final long zzakz;

    /* loaded from: classes.dex */
    public static final class Info {
        private final String zzale;
        private final boolean zzalf;

        public Info(String str, boolean z) {
            this.zzale = str;
            this.zzalf = z;
        }

        public String getId() {
            return this.zzale;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.zzalf;
        }

        public String toString() {
            String str = this.zzale;
            boolean z = this.zzalf;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza extends Thread {
        private WeakReference<AdvertisingIdClient> zzala;
        private long zzalb;
        CountDownLatch zzalc = new CountDownLatch(1);
        boolean zzald = false;

        public zza(AdvertisingIdClient advertisingIdClient, long j) {
            this.zzala = new WeakReference<>(advertisingIdClient);
            this.zzalb = j;
            start();
        }

        private void disconnect() {
            AdvertisingIdClient advertisingIdClient = this.zzala.get();
            if (advertisingIdClient != null) {
                advertisingIdClient.finish();
                this.zzald = true;
            }
        }

        public void cancel() {
            this.zzalc.countDown();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.zzalc.await(this.zzalb, TimeUnit.MILLISECONDS)) {
                    return;
                }
                disconnect();
            } catch (InterruptedException unused) {
                disconnect();
            }
        }

        public boolean zzdo() {
            return this.zzald;
        }
    }

    public AdvertisingIdClient(Context context) {
        this(context, 30000L);
    }

    public AdvertisingIdClient(Context context, long j) {
        this.zzakx = new Object();
        zzac.zzy(context);
        this.mContext = context;
        this.zzakw = false;
        this.zzakz = j;
    }

    public static Info getAdvertisingIdInfo(Context context) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(context, -1L);
        try {
            advertisingIdClient.zze(false);
            return advertisingIdClient.getInfo();
        } finally {
            advertisingIdClient.finish();
        }
    }

    public static void setShouldSkipGmsCoreVersionCheck(boolean z) {
    }

    static zzci zza(Context context, com.google.android.gms.common.zza zzaVar) throws IOException {
        try {
            return zzci.zza.zzf(zzaVar.zza(10000L, TimeUnit.MILLISECONDS));
        } catch (InterruptedException unused) {
            throw new IOException("Interrupted exception");
        } catch (Throwable th) {
            throw new IOException(th);
        }
    }

    private void zzdn() {
        synchronized (this.zzakx) {
            if (this.zzaky != null) {
                this.zzaky.cancel();
                try {
                    this.zzaky.join();
                } catch (InterruptedException unused) {
                }
            }
            if (this.zzakz > 0) {
                this.zzaky = new zza(this, this.zzakz);
            }
        }
    }

    static com.google.android.gms.common.zza zzg(Context context) throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        try {
            context.getPackageManager().getPackageInfo("com.android.vending", 0);
            int isGooglePlayServicesAvailable = zzc.zzapd().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0 || isGooglePlayServicesAvailable == 2) {
                com.google.android.gms.common.zza zzaVar = new com.google.android.gms.common.zza();
                Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                intent.setPackage("com.google.android.gms");
                try {
                    if (zzb.zzawu().zza(context, intent, zzaVar, 1)) {
                        return zzaVar;
                    }
                    throw new IOException("Connection failure");
                } catch (Throwable th) {
                    throw new IOException(th);
                }
            }
            throw new IOException("Google Play services not available");
        } catch (PackageManager.NameNotFoundException unused) {
            throw new GooglePlayServicesNotAvailableException(9);
        }
    }

    protected void finalize() throws Throwable {
        finish();
        super.finalize();
    }

    public void finish() {
        zzac.zzhr("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.mContext == null || this.zzaku == null) {
                return;
            }
            try {
                if (this.zzakw) {
                    zzb.zzawu().zza(this.mContext, this.zzaku);
                }
            } catch (IllegalArgumentException e) {
                Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", e);
            }
            this.zzakw = false;
            this.zzakv = null;
            this.zzaku = null;
        }
    }

    public Info getInfo() throws IOException {
        Info info;
        zzac.zzhr("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (!this.zzakw) {
                synchronized (this.zzakx) {
                    if (this.zzaky == null || !this.zzaky.zzdo()) {
                        throw new IOException("AdvertisingIdClient is not connected.");
                    }
                }
                try {
                    zze(false);
                    if (!this.zzakw) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.");
                    }
                } catch (Exception e) {
                    throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                }
            }
            zzac.zzy(this.zzaku);
            zzac.zzy(this.zzakv);
            try {
                info = new Info(this.zzakv.getId(), this.zzakv.zzf(true));
            } catch (RemoteException e2) {
                Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                throw new IOException("Remote exception");
            }
        }
        zzdn();
        return info;
    }

    public void start() throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zze(true);
    }

    protected void zze(boolean z) throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException {
        zzac.zzhr("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            if (this.zzakw) {
                finish();
            }
            this.zzaku = zzg(this.mContext);
            this.zzakv = zza(this.mContext, this.zzaku);
            this.zzakw = true;
            if (z) {
                zzdn();
            }
        }
    }
}
