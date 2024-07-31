package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

/* loaded from: classes.dex */
public abstract class zzn {

    /* renamed from: CA */
    private static zzn f2889CA;

    /* renamed from: Cz */
    private static final Object f2890Cz = new Object();

    public static zzn zzcf(Context context) {
        synchronized (f2890Cz) {
            if (f2889CA == null) {
                f2889CA = new zzo(context.getApplicationContext());
            }
        }
        return f2889CA;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, String str2, ServiceConnection serviceConnection, String str3);
}
