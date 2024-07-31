package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public class zzqa extends zzqd {

    /* renamed from: wq */
    private final SparseArray<zza> f3088wq;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class zza implements GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: wr */
        public final int f3089wr;

        /* renamed from: ws */
        public final GoogleApiClient f3090ws;

        /* renamed from: wt */
        public final GoogleApiClient.OnConnectionFailedListener f3091wt;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f3089wr = i;
            this.f3090ws = googleApiClient;
            this.f3091wt = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append((CharSequence) str).append("GoogleApiClient #").print(this.f3089wr);
            printWriter.println(":");
            this.f3090ws.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            zzqa.this.zzb(connectionResult, this.f3089wr);
        }

        public void zzaql() {
            this.f3090ws.unregisterConnectionFailedListener(this);
            this.f3090ws.disconnect();
        }
    }

    private zzqa(zzrb zzrbVar) {
        super(zzrbVar);
        this.f3088wq = new SparseArray<>();
        this.f3281yY.zza("AutoManageHelper", this);
    }

    public static zzqa zza(zzqz zzqzVar) {
        zzrb zzc = zzc(zzqzVar);
        zzqa zzqaVar = (zzqa) zzc.zza("AutoManageHelper", zzqa.class);
        return zzqaVar != null ? zzqaVar : new zzqa(zzc);
    }

    @Override // com.google.android.gms.internal.zzra
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f3088wq.size(); i++) {
            this.f3088wq.valueAt(i).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.internal.zzqd, com.google.android.gms.internal.zzra
    public void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.f3088wq);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f3100wy) {
            return;
        }
        for (int i = 0; i < this.f3088wq.size(); i++) {
            this.f3088wq.valueAt(i).f3090ws.connect();
        }
    }

    @Override // com.google.android.gms.internal.zzqd, com.google.android.gms.internal.zzra
    public void onStop() {
        super.onStop();
        for (int i = 0; i < this.f3088wq.size(); i++) {
            this.f3088wq.valueAt(i).f3090ws.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        com.google.android.gms.common.internal.zzac.zzb(googleApiClient, "GoogleApiClient instance cannot be null");
        boolean z = this.f3088wq.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        com.google.android.gms.common.internal.zzac.zza(z, sb.toString());
        boolean z2 = this.mStarted;
        boolean z3 = this.f3100wy;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(z3);
        Log.d("AutoManageHelper", sb2.toString());
        this.f3088wq.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (!this.mStarted || this.f3100wy) {
            return;
        }
        String valueOf = String.valueOf(googleApiClient);
        StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 11);
        sb3.append("connecting ");
        sb3.append(valueOf);
        Log.d("AutoManageHelper", sb3.toString());
        googleApiClient.connect();
    }

    @Override // com.google.android.gms.internal.zzqd
    protected void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza zzaVar = this.f3088wq.get(i);
        if (zzaVar != null) {
            zzfq(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zzaVar.f3091wt;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    @Override // com.google.android.gms.internal.zzqd
    protected void zzaqk() {
        for (int i = 0; i < this.f3088wq.size(); i++) {
            this.f3088wq.valueAt(i).f3090ws.connect();
        }
    }

    public void zzfq(int i) {
        zza zzaVar = this.f3088wq.get(i);
        this.f3088wq.remove(i);
        if (zzaVar != null) {
            zzaVar.zzaql();
        }
    }
}
