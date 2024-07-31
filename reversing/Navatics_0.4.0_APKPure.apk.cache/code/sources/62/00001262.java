package com.google.android.gms.internal;

import android.content.Context;

/* loaded from: classes.dex */
public class zzsi {

    /* renamed from: Fj */
    private static zzsi f3367Fj = new zzsi();

    /* renamed from: Fi */
    private zzsh f3368Fi = null;

    public static zzsh zzcr(Context context) {
        return f3367Fj.zzcq(context);
    }

    public synchronized zzsh zzcq(Context context) {
        if (this.f3368Fi == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f3368Fi = new zzsh(context);
        }
        return this.f3368Fi;
    }
}