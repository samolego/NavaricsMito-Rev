package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzuz;

/* loaded from: classes.dex */
public class zzuy {
    private boolean zzaom = false;

    /* renamed from: Uv */
    private zzuz f3373Uv = null;

    public void initialize(Context context) {
        synchronized (this) {
            if (this.zzaom) {
                return;
            }
            try {
                this.f3373Uv = zzuz.zza.asInterface(zzsu.zza(context, zzsu.f3366Oy, ModuleDescriptor.MODULE_ID).zzjd("com.google.android.gms.flags.impl.FlagProviderImpl"));
                this.f3373Uv.init(com.google.android.gms.dynamic.zze.zzac(context));
                this.zzaom = true;
            } catch (RemoteException | zzsu.zza e) {
                Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
            }
        }
    }

    public <T> T zzb(zzuw<T> zzuwVar) {
        synchronized (this) {
            if (this.zzaom) {
                return zzuwVar.zza(this.f3373Uv);
            }
            return zzuwVar.zzkq();
        }
    }
}
