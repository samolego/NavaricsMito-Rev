package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;

/* loaded from: classes.dex */
public abstract class zzg<T> {

    /* renamed from: Ot */
    private final String f3056Ot;

    /* renamed from: Ou */
    private T f3057Ou;

    /* loaded from: classes.dex */
    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzg(String str) {
        this.f3056Ot = str;
    }

    protected abstract T zzc(IBinder iBinder);

    /* JADX INFO: Access modifiers changed from: protected */
    public final T zzcu(Context context) throws zza {
        if (this.f3057Ou == null) {
            zzac.zzy(context);
            Context remoteContext = com.google.android.gms.common.zze.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.f3057Ou = zzc((IBinder) remoteContext.getClassLoader().loadClass(this.f3056Ot).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zza("Could not load creator class.", e);
            } catch (IllegalAccessException e2) {
                throw new zza("Could not access creator.", e2);
            } catch (InstantiationException e3) {
                throw new zza("Could not instantiate creator.", e3);
            }
        }
        return this.f3057Ou;
    }
}
