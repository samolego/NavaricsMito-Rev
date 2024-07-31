package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class zzrp<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {

    /* renamed from: wI */
    private final WeakReference<GoogleApiClient> f3304wI;

    /* renamed from: zp */
    private final zza f3310zp;

    /* renamed from: zk */
    private ResultTransform<? super R, ? extends Result> f3305zk = null;

    /* renamed from: zl */
    private zzrp<? extends Result> f3306zl = null;

    /* renamed from: zm */
    private volatile ResultCallbacks<? super R> f3307zm = null;

    /* renamed from: zn */
    private PendingResult<R> f3308zn = null;

    /* renamed from: wG */
    private final Object f3303wG = new Object();

    /* renamed from: zo */
    private Status f3309zo = null;

    /* renamed from: zq */
    private boolean f3311zq = false;

    /* loaded from: classes.dex */
    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    PendingResult<?> pendingResult = (PendingResult) message.obj;
                    synchronized (zzrp.this.f3303wG) {
                        if (pendingResult == null) {
                            zzrp.this.f3306zl.zzac(new Status(13, "Transform returned null"));
                        } else if (pendingResult instanceof zzrk) {
                            zzrp.this.f3306zl.zzac(((zzrk) pendingResult).getStatus());
                        } else {
                            zzrp.this.f3306zl.zza(pendingResult);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                    throw runtimeException;
                default:
                    int i = message.what;
                    StringBuilder sb = new StringBuilder(70);
                    sb.append("TransformationResultHandler received unknown message type: ");
                    sb.append(i);
                    Log.e("TransformedResultImpl", sb.toString());
                    return;
            }
        }
    }

    public zzrp(WeakReference<GoogleApiClient> weakReference) {
        com.google.android.gms.common.internal.zzac.zzb(weakReference, "GoogleApiClient reference must not be null");
        this.f3304wI = weakReference;
        GoogleApiClient googleApiClient = this.f3304wI.get();
        this.f3310zp = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzac(Status status) {
        synchronized (this.f3303wG) {
            this.f3309zo = status;
            zzad(this.f3309zo);
        }
    }

    private void zzad(Status status) {
        synchronized (this.f3303wG) {
            if (this.f3305zk != null) {
                Status onFailure = this.f3305zk.onFailure(status);
                com.google.android.gms.common.internal.zzac.zzb(onFailure, "onFailure must not return null");
                this.f3306zl.zzac(onFailure);
            } else if (zzasv()) {
                this.f3307zm.onFailure(status);
            }
        }
    }

    private void zzast() {
        if (this.f3305zk == null && this.f3307zm == null) {
            return;
        }
        GoogleApiClient googleApiClient = this.f3304wI.get();
        if (!this.f3311zq && this.f3305zk != null && googleApiClient != null) {
            googleApiClient.zza(this);
            this.f3311zq = true;
        }
        Status status = this.f3309zo;
        if (status != null) {
            zzad(status);
            return;
        }
        PendingResult<R> pendingResult = this.f3308zn;
        if (pendingResult != null) {
            pendingResult.setResultCallback(this);
        }
    }

    private boolean zzasv() {
        return (this.f3307zm == null || this.f3304wI.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        synchronized (this.f3303wG) {
            boolean z = true;
            com.google.android.gms.common.internal.zzac.zza(this.f3307zm == null, "Cannot call andFinally() twice.");
            if (this.f3305zk != null) {
                z = false;
            }
            com.google.android.gms.common.internal.zzac.zza(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f3307zm = resultCallbacks;
            zzast();
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public void onResult(final R r) {
        synchronized (this.f3303wG) {
            if (!r.getStatus().isSuccess()) {
                zzac(r.getStatus());
                zze(r);
            } else if (this.f3305zk != null) {
                zzrj.zzarz().submit(new Runnable() { // from class: com.google.android.gms.internal.zzrp.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    @WorkerThread
                    public void run() {
                        GoogleApiClient googleApiClient;
                        try {
                            try {
                                zzqe.f3105wF.set(true);
                                zzrp.this.f3310zp.sendMessage(zzrp.this.f3310zp.obtainMessage(0, zzrp.this.f3305zk.onSuccess(r)));
                                zzqe.f3105wF.set(false);
                                zzrp.this.zze(r);
                                googleApiClient = (GoogleApiClient) zzrp.this.f3304wI.get();
                                if (googleApiClient == null) {
                                    return;
                                }
                            } catch (RuntimeException e) {
                                zzrp.this.f3310zp.sendMessage(zzrp.this.f3310zp.obtainMessage(1, e));
                                zzqe.f3105wF.set(false);
                                zzrp.this.zze(r);
                                googleApiClient = (GoogleApiClient) zzrp.this.f3304wI.get();
                                if (googleApiClient == null) {
                                    return;
                                }
                            }
                            googleApiClient.zzb(zzrp.this);
                        } catch (Throwable th) {
                            zzqe.f3105wF.set(false);
                            zzrp.this.zze(r);
                            GoogleApiClient googleApiClient2 = (GoogleApiClient) zzrp.this.f3304wI.get();
                            if (googleApiClient2 != null) {
                                googleApiClient2.zzb(zzrp.this);
                            }
                            throw th;
                        }
                    }
                });
            } else if (zzasv()) {
                this.f3307zm.onSuccess(r);
            }
        }
    }

    @Override // com.google.android.gms.common.api.TransformedResult
    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zzrp<? extends Result> zzrpVar;
        synchronized (this.f3303wG) {
            boolean z = true;
            com.google.android.gms.common.internal.zzac.zza(this.f3305zk == null, "Cannot call then() twice.");
            if (this.f3307zm != null) {
                z = false;
            }
            com.google.android.gms.common.internal.zzac.zza(z, "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f3305zk = resultTransform;
            zzrpVar = new zzrp<>(this.f3304wI);
            this.f3306zl = zzrpVar;
            zzast();
        }
        return zzrpVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.f3303wG) {
            this.f3308zn = pendingResult;
            zzast();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzasu() {
        this.f3307zm = null;
    }
}
