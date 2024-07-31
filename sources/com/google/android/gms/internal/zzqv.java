package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* loaded from: classes.dex */
public final class zzqv extends BroadcastReceiver {
    protected Context mContext;

    /* renamed from: yO */
    private final zza f3271yO;

    /* loaded from: classes.dex */
    public static abstract class zza {
        public abstract void zzaqp();
    }

    public zzqv(zza zzaVar) {
        this.f3271yO = zzaVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f3271yO.zzaqp();
            unregister();
        }
    }

    public void setContext(Context context) {
        this.mContext = context;
    }

    public synchronized void unregister() {
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
    }
}
