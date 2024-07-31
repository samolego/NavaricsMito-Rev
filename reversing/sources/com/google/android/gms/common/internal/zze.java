package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.support.annotation.BinderThread;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.common.internal.zzv;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class zze<T extends IInterface> {

    /* renamed from: Bs */
    public static final String[] f2807Bs = {"service_esmobile", "service_googleme"};

    /* renamed from: Ba */
    private int f2808Ba;

    /* renamed from: Bb */
    private long f2809Bb;

    /* renamed from: Bc */
    private long f2810Bc;

    /* renamed from: Bd */
    private int f2811Bd;

    /* renamed from: Be */
    private long f2812Be;

    /* renamed from: Bf */
    private final zzn f2813Bf;

    /* renamed from: Bg */
    private final Object f2814Bg;

    /* renamed from: Bh */
    private zzv f2815Bh;

    /* renamed from: Bi */
    private zzf f2816Bi;

    /* renamed from: Bj */
    private T f2817Bj;

    /* renamed from: Bk */
    private final ArrayList<AbstractC3235zze<?>> f2818Bk;

    /* renamed from: Bl */
    private zzh f2819Bl;

    /* renamed from: Bm */
    private int f2820Bm;

    /* renamed from: Bn */
    private final zzb f2821Bn;

    /* renamed from: Bo */
    private final zzc f2822Bo;

    /* renamed from: Bp */
    private final int f2823Bp;

    /* renamed from: Bq */
    private final String f2824Bq;

    /* renamed from: Br */
    protected AtomicInteger f2825Br;
    private final Context mContext;
    final Handler mHandler;

    /* renamed from: xn */
    private final com.google.android.gms.common.zzc f2826xn;
    private final Looper zzajn;
    private final Object zzakd;

    /* loaded from: classes.dex */
    private abstract class zza extends AbstractC3235zze<Boolean> {

        /* renamed from: Bt */
        public final Bundle f2827Bt;
        public final int statusCode;

        @BinderThread
        protected zza(int i, Bundle bundle) {
            super(true);
            this.statusCode = i;
            this.f2827Bt = bundle;
        }

        protected abstract boolean zzaua();

        @Override // com.google.android.gms.common.internal.zze.AbstractC3235zze
        protected void zzaub() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.internal.zze.AbstractC3235zze
        /* renamed from: zzc */
        public void zzv(Boolean bool) {
            ConnectionResult connectionResult;
            if (bool == null) {
                zze.this.zzb(1, null);
                return;
            }
            int i = this.statusCode;
            if (i != 0) {
                if (i == 10) {
                    zze.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                }
                zze.this.zzb(1, null);
                Bundle bundle = this.f2827Bt;
                connectionResult = new ConnectionResult(this.statusCode, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null);
            } else if (zzaua()) {
                return;
            } else {
                zze.this.zzb(1, null);
                connectionResult = new ConnectionResult(8, null);
            }
            zzm(connectionResult);
        }

        protected abstract void zzm(ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public interface zzb {
        void onConnected(@Nullable Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* loaded from: classes.dex */
    public interface zzc {
        void onConnectionFailed(@NonNull ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    final class zzd extends Handler {
        public zzd(Looper looper) {
            super(looper);
        }

        private void zza(Message message) {
            AbstractC3235zze abstractC3235zze = (AbstractC3235zze) message.obj;
            abstractC3235zze.zzaub();
            abstractC3235zze.unregister();
        }

        private boolean zzb(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (zze.this.f2825Br.get() != message.arg1) {
                if (zzb(message)) {
                    zza(message);
                }
            } else if ((message.what == 1 || message.what == 5) && !zze.this.isConnecting()) {
                zza(message);
            } else {
                if (message.what == 3) {
                    ConnectionResult connectionResult = new ConnectionResult(message.arg2, message.obj instanceof PendingIntent ? (PendingIntent) message.obj : null);
                    zze.this.f2816Bi.zzh(connectionResult);
                    zze.this.onConnectionFailed(connectionResult);
                } else if (message.what == 4) {
                    zze.this.zzb(4, null);
                    if (zze.this.f2821Bn != null) {
                        zze.this.f2821Bn.onConnectionSuspended(message.arg2);
                    }
                    zze.this.onConnectionSuspended(message.arg2);
                    zze.this.zza(4, 1, (int) null);
                } else if (message.what == 2 && !zze.this.isConnected()) {
                    zza(message);
                } else if (zzb(message)) {
                    ((AbstractC3235zze) message.obj).zzauc();
                } else {
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("GmsClient", sb.toString(), new Exception());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: com.google.android.gms.common.internal.zze$zze  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public abstract class AbstractC3235zze<TListener> {

        /* renamed from: Bv */
        private boolean f2831Bv = false;
        private TListener mListener;

        public AbstractC3235zze(TListener tlistener) {
            this.mListener = tlistener;
        }

        public void unregister() {
            zzaud();
            synchronized (zze.this.f2818Bk) {
                zze.this.f2818Bk.remove(this);
            }
        }

        protected abstract void zzaub();

        public void zzauc() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.mListener;
                if (this.f2831Bv) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    zzv(tlistener);
                } catch (RuntimeException e) {
                    zzaub();
                    throw e;
                }
            } else {
                zzaub();
            }
            synchronized (this) {
                this.f2831Bv = true;
            }
            unregister();
        }

        public void zzaud() {
            synchronized (this) {
                this.mListener = null;
            }
        }

        protected abstract void zzv(TListener tlistener);
    }

    /* loaded from: classes.dex */
    public interface zzf {
        void zzh(@NonNull ConnectionResult connectionResult);
    }

    /* loaded from: classes.dex */
    public static final class zzg extends zzu.zza {

        /* renamed from: Bw */
        private zze f2832Bw;

        /* renamed from: Bx */
        private final int f2833Bx;

        public zzg(@NonNull zze zzeVar, int i) {
            this.f2832Bw = zzeVar;
            this.f2833Bx = i;
        }

        private void zzaue() {
            this.f2832Bw = null;
        }

        @Override // com.google.android.gms.common.internal.zzu
        @BinderThread
        public void zza(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            zzac.zzb(this.f2832Bw, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f2832Bw.zza(i, iBinder, bundle, this.f2833Bx);
            zzaue();
        }

        @Override // com.google.android.gms.common.internal.zzu
        @BinderThread
        public void zzb(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }
    }

    /* loaded from: classes.dex */
    public final class zzh implements ServiceConnection {

        /* renamed from: Bx */
        private final int f2835Bx;

        public zzh(int i) {
            this.f2835Bx = i;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzac.zzb(iBinder, "Expecting a valid IBinder");
            synchronized (zze.this.f2814Bg) {
                zze.this.f2815Bh = zzv.zza.zzdv(iBinder);
            }
            zze.this.zza(0, (Bundle) null, this.f2835Bx);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (zze.this.f2814Bg) {
                zze.this.f2815Bh = null;
            }
            zze.this.mHandler.sendMessage(zze.this.mHandler.obtainMessage(4, this.f2835Bx, 1));
        }
    }

    /* loaded from: classes.dex */
    protected class zzi implements zzf {
        public zzi() {
        }

        @Override // com.google.android.gms.common.internal.zze.zzf
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                zze zzeVar = zze.this;
                zzeVar.zza((zzr) null, zzeVar.zzatz());
            } else if (zze.this.f2822Bo != null) {
                zze.this.f2822Bo.onConnectionFailed(connectionResult);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class zzj extends zza {

        /* renamed from: By */
        public final IBinder f2838By;

        @BinderThread
        public zzj(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.f2838By = iBinder;
        }

        @Override // com.google.android.gms.common.internal.zze.zza
        protected boolean zzaua() {
            try {
                String interfaceDescriptor = this.f2838By.getInterfaceDescriptor();
                if (zze.this.zziy().equals(interfaceDescriptor)) {
                    IInterface zzh = zze.this.zzh(this.f2838By);
                    if (zzh == null || !zze.this.zza(2, 3, (int) zzh)) {
                        return false;
                    }
                    Bundle zzaoe = zze.this.zzaoe();
                    if (zze.this.f2821Bn != null) {
                        zze.this.f2821Bn.onConnected(zzaoe);
                    }
                    return true;
                }
                String valueOf = String.valueOf(zze.this.zziy());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb.append("service descriptor mismatch: ");
                sb.append(valueOf);
                sb.append(" vs. ");
                sb.append(interfaceDescriptor);
                Log.e("GmsClient", sb.toString());
                return false;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }

        @Override // com.google.android.gms.common.internal.zze.zza
        protected void zzm(ConnectionResult connectionResult) {
            if (zze.this.f2822Bo != null) {
                zze.this.f2822Bo.onConnectionFailed(connectionResult);
            }
            zze.this.onConnectionFailed(connectionResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public final class zzk extends zza {
        @BinderThread
        public zzk(int i, Bundle bundle) {
            super(i, bundle);
        }

        @Override // com.google.android.gms.common.internal.zze.zza
        protected boolean zzaua() {
            zze.this.f2816Bi.zzh(ConnectionResult.f2638uJ);
            return true;
        }

        @Override // com.google.android.gms.common.internal.zze.zza
        protected void zzm(ConnectionResult connectionResult) {
            zze.this.f2816Bi.zzh(connectionResult);
            zze.this.onConnectionFailed(connectionResult);
        }
    }

    protected zze(Context context, Looper looper, int i, zzb zzbVar, zzc zzcVar, String str) {
        this(context, looper, zzn.zzcf(context), com.google.android.gms.common.zzc.zzapd(), i, (zzb) zzac.zzy(zzbVar), (zzc) zzac.zzy(zzcVar), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zze(Context context, Looper looper, zzn zznVar, com.google.android.gms.common.zzc zzcVar, int i, zzb zzbVar, zzc zzcVar2, String str) {
        this.zzakd = new Object();
        this.f2814Bg = new Object();
        this.f2818Bk = new ArrayList<>();
        this.f2820Bm = 1;
        this.f2825Br = new AtomicInteger(0);
        this.mContext = (Context) zzac.zzb(context, "Context must not be null");
        this.zzajn = (Looper) zzac.zzb(looper, "Looper must not be null");
        this.f2813Bf = (zzn) zzac.zzb(zznVar, "Supervisor must not be null");
        this.f2826xn = (com.google.android.gms.common.zzc) zzac.zzb(zzcVar, "API availability must not be null");
        this.mHandler = new zzd(looper);
        this.f2823Bp = i;
        this.f2821Bn = zzbVar;
        this.f2822Bo = zzcVar2;
        this.f2824Bq = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zza(int i, int i2, T t) {
        synchronized (this.zzakd) {
            if (this.f2820Bm != i) {
                return false;
            }
            zzb(i2, t);
            return true;
        }
    }

    private void zzats() {
        if (this.f2819Bl != null) {
            String valueOf = String.valueOf(zzix());
            String valueOf2 = String.valueOf(zzatq());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 70 + String.valueOf(valueOf2).length());
            sb.append("Calling connect() while still connected, missing disconnect() for ");
            sb.append(valueOf);
            sb.append(" on ");
            sb.append(valueOf2);
            Log.e("GmsClient", sb.toString());
            this.f2813Bf.zzb(zzix(), zzatq(), this.f2819Bl, zzatr());
            this.f2825Br.incrementAndGet();
        }
        this.f2819Bl = new zzh(this.f2825Br.get());
        if (this.f2813Bf.zza(zzix(), zzatq(), this.f2819Bl, zzatr())) {
            return;
        }
        String valueOf3 = String.valueOf(zzix());
        String valueOf4 = String.valueOf(zzatq());
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf3).length() + 34 + String.valueOf(valueOf4).length());
        sb2.append("unable to connect to service: ");
        sb2.append(valueOf3);
        sb2.append(" on ");
        sb2.append(valueOf4);
        Log.e("GmsClient", sb2.toString());
        zza(16, (Bundle) null, this.f2825Br.get());
    }

    private void zzatt() {
        if (this.f2819Bl != null) {
            this.f2813Bf.zzb(zzix(), zzatq(), this.f2819Bl, zzatr());
            this.f2819Bl = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(int i, T t) {
        zzac.zzbs((i == 3) == (t != null));
        synchronized (this.zzakd) {
            this.f2820Bm = i;
            this.f2817Bj = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzatt();
                    break;
                case 2:
                    zzats();
                    break;
                case 3:
                    zza((zze<T>) t);
                    break;
            }
        }
    }

    public void disconnect() {
        this.f2825Br.incrementAndGet();
        synchronized (this.f2818Bk) {
            int size = this.f2818Bk.size();
            for (int i = 0; i < size; i++) {
                this.f2818Bk.get(i).zzaud();
            }
            this.f2818Bk.clear();
        }
        synchronized (this.f2814Bg) {
            this.f2815Bh = null;
        }
        zzb(1, null);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        String str2;
        String str3;
        synchronized (this.zzakd) {
            i = this.f2820Bm;
            t = this.f2817Bj;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                str2 = "DISCONNECTED";
                break;
            case 2:
                str2 = "CONNECTING";
                break;
            case 3:
                str2 = "CONNECTED";
                break;
            case 4:
                str2 = "DISCONNECTING";
                break;
            default:
                str2 = "UNKNOWN";
                break;
        }
        printWriter.print(str2);
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append((CharSequence) zziy()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.f2810Bc > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.f2810Bc;
            String valueOf = String.valueOf(simpleDateFormat.format(new Date(j)));
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(valueOf);
            append.println(sb.toString());
        }
        if (this.f2809Bb > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.f2808Ba;
            switch (i2) {
                case 1:
                    str3 = "CAUSE_SERVICE_DISCONNECTED";
                    break;
                case 2:
                    str3 = "CAUSE_NETWORK_LOST";
                    break;
                default:
                    str3 = String.valueOf(i2);
                    break;
            }
            printWriter.append((CharSequence) str3);
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.f2809Bb;
            String valueOf2 = String.valueOf(simpleDateFormat.format(new Date(j2)));
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(valueOf2);
            append2.println(sb2.toString());
        }
        if (this.f2812Be > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.f2811Bd));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.f2812Be;
            String valueOf3 = String.valueOf(simpleDateFormat.format(new Date(j3)));
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(valueOf3);
            append3.println(sb3.toString());
        }
    }

    public Account getAccount() {
        return null;
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzajn;
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.f2820Bm == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.f2820Bm == 2;
        }
        return z;
    }

    @CallSuper
    protected void onConnectionFailed(ConnectionResult connectionResult) {
        this.f2811Bd = connectionResult.getErrorCode();
        this.f2812Be = System.currentTimeMillis();
    }

    @CallSuper
    protected void onConnectionSuspended(int i) {
        this.f2808Ba = i;
        this.f2809Bb = System.currentTimeMillis();
    }

    protected void zza(int i, @Nullable Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(5, i2, -1, new zzk(i, bundle)));
    }

    @BinderThread
    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzj(i, iBinder, bundle)));
    }

    @CallSuper
    protected void zza(@NonNull T t) {
        this.f2810Bc = System.currentTimeMillis();
    }

    public void zza(@NonNull zzf zzfVar) {
        this.f2816Bi = (zzf) zzac.zzb(zzfVar, "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    public void zza(zzf zzfVar, ConnectionResult connectionResult) {
        this.f2816Bi = (zzf) zzac.zzb(zzfVar, "Connection progress callbacks cannot be null.");
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.f2825Br.get(), connectionResult.getErrorCode(), connectionResult.getResolution()));
    }

    @WorkerThread
    public void zza(zzr zzrVar, Set<Scope> set) {
        try {
            GetServiceRequest zzo = new GetServiceRequest(this.f2823Bp).zzht(this.mContext.getPackageName()).zzo(zzagl());
            if (set != null) {
                zzo.zzf(set);
            }
            if (zzahd()) {
                zzo.zzd(zzatv()).zzb(zzrVar);
            } else if (zzaty()) {
                zzo.zzd(getAccount());
            }
            synchronized (this.f2814Bg) {
                if (this.f2815Bh != null) {
                    this.f2815Bh.zza(new zzg(this, this.f2825Br.get()), zzo);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException unused) {
            Log.w("GmsClient", "service died");
            zzgl(1);
        } catch (RemoteException e) {
            Log.w("GmsClient", "Remote exception occurred", e);
        }
    }

    protected Bundle zzagl() {
        return new Bundle();
    }

    public boolean zzahd() {
        return false;
    }

    public boolean zzahs() {
        return false;
    }

    public Intent zzaht() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    public Bundle zzaoe() {
        return null;
    }

    public boolean zzapr() {
        return true;
    }

    @Nullable
    public IBinder zzaps() {
        synchronized (this.f2814Bg) {
            if (this.f2815Bh == null) {
                return null;
            }
            return this.f2815Bh.asBinder();
        }
    }

    protected String zzatq() {
        return "com.google.android.gms";
    }

    @Nullable
    protected final String zzatr() {
        String str = this.f2824Bq;
        return str == null ? this.mContext.getClass().getName() : str;
    }

    public void zzatu() {
        int isGooglePlayServicesAvailable = this.f2826xn.isGooglePlayServicesAvailable(this.mContext);
        if (isGooglePlayServicesAvailable == 0) {
            zza(new zzi());
            return;
        }
        zzb(1, null);
        this.f2816Bi = new zzi();
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(3, this.f2825Br.get(), isGooglePlayServicesAvailable));
    }

    public final Account zzatv() {
        return getAccount() != null ? getAccount() : new Account("<<default account>>", "com.google");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzatw() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzatx() throws DeadObjectException {
        T t;
        synchronized (this.zzakd) {
            if (this.f2820Bm == 4) {
                throw new DeadObjectException();
            }
            zzatw();
            zzac.zza(this.f2817Bj != null, "Client is connected but service is null");
            t = this.f2817Bj;
        }
        return t;
    }

    public boolean zzaty() {
        return false;
    }

    protected Set<Scope> zzatz() {
        return Collections.EMPTY_SET;
    }

    void zzc(int i, T t) {
    }

    public void zzgl(int i) {
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(4, this.f2825Br.get(), i));
    }

    @Nullable
    protected abstract T zzh(IBinder iBinder);

    @NonNull
    protected abstract String zzix();

    @NonNull
    protected abstract String zziy();
}
