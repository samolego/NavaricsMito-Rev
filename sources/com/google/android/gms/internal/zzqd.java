package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzqv;

/* loaded from: classes.dex */
public abstract class zzqd extends zzra implements DialogInterface.OnCancelListener {
    protected boolean mStarted;

    /* renamed from: vP */
    protected final GoogleApiAvailability f3097vP;

    /* renamed from: wA */
    private int f3098wA;

    /* renamed from: wB */
    private final Handler f3099wB;

    /* renamed from: wy */
    protected boolean f3100wy;

    /* renamed from: wz */
    private ConnectionResult f3101wz;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class zza implements Runnable {
        private zza() {
        }

        @Override // java.lang.Runnable
        @MainThread
        public void run() {
            if (zzqd.this.mStarted) {
                if (zzqd.this.f3101wz.hasResolution()) {
                    zzqd.this.f3281yY.startActivityForResult(GoogleApiActivity.zzb(zzqd.this.getActivity(), zzqd.this.f3101wz.getResolution(), zzqd.this.f3098wA, false), 1);
                } else if (zzqd.this.f3097vP.isUserResolvableError(zzqd.this.f3101wz.getErrorCode())) {
                    zzqd.this.f3097vP.zza(zzqd.this.getActivity(), zzqd.this.f3281yY, zzqd.this.f3101wz.getErrorCode(), 2, zzqd.this);
                } else if (zzqd.this.f3101wz.getErrorCode() == 18) {
                    final Dialog zza = zzqd.this.f3097vP.zza(zzqd.this.getActivity(), zzqd.this);
                    zzqd.this.f3097vP.zza(zzqd.this.getActivity().getApplicationContext(), new zzqv.zza() { // from class: com.google.android.gms.internal.zzqd.zza.1
                        @Override // com.google.android.gms.internal.zzqv.zza
                        public void zzaqp() {
                            zzqd.this.zzaqo();
                            if (zza.isShowing()) {
                                zza.dismiss();
                            }
                        }
                    });
                } else {
                    zzqd zzqdVar = zzqd.this;
                    zzqdVar.zza(zzqdVar.f3101wz, zzqd.this.f3098wA);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzqd(zzrb zzrbVar) {
        this(zzrbVar, GoogleApiAvailability.getInstance());
    }

    zzqd(zzrb zzrbVar, GoogleApiAvailability googleApiAvailability) {
        super(zzrbVar);
        this.f3098wA = -1;
        this.f3099wB = new Handler(Looper.getMainLooper());
        this.f3097vP = googleApiAvailability;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.zzra
    public void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 != -1) {
                    if (i2 == 0) {
                        this.f3101wz = new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null);
                    }
                    r0 = false;
                    break;
                }
                break;
            case 2:
                int isGooglePlayServicesAvailable = this.f3097vP.isGooglePlayServicesAvailable(getActivity());
                r0 = isGooglePlayServicesAvailable == 0;
                if (this.f3101wz.getErrorCode() == 18 && isGooglePlayServicesAvailable == 18) {
                    return;
                }
                break;
            default:
                r0 = false;
                break;
        }
        if (r0) {
            zzaqo();
        } else {
            zza(this.f3101wz, this.f3098wA);
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, null), this.f3098wA);
        zzaqo();
    }

    @Override // com.google.android.gms.internal.zzra
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f3100wy = bundle.getBoolean("resolving_error", false);
            if (this.f3100wy) {
                this.f3098wA = bundle.getInt("failed_client_id", -1);
                this.f3101wz = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    @Override // com.google.android.gms.internal.zzra
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f3100wy);
        if (this.f3100wy) {
            bundle.putInt("failed_client_id", this.f3098wA);
            bundle.putInt("failed_status", this.f3101wz.getErrorCode());
            bundle.putParcelable("failed_resolution", this.f3101wz.getResolution());
        }
    }

    @Override // com.google.android.gms.internal.zzra
    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    @Override // com.google.android.gms.internal.zzra
    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    protected abstract void zza(ConnectionResult connectionResult, int i);

    protected abstract void zzaqk();

    protected void zzaqo() {
        this.f3098wA = -1;
        this.f3100wy = false;
        this.f3101wz = null;
        zzaqk();
    }

    public void zzb(ConnectionResult connectionResult, int i) {
        if (this.f3100wy) {
            return;
        }
        this.f3100wy = true;
        this.f3098wA = i;
        this.f3101wz = connectionResult;
        this.f3099wB.post(new zza());
    }
}
