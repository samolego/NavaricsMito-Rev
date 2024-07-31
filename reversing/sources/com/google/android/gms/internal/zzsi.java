package com.google.android.gms.internal;

import android.content.Context;

/* loaded from: classes.dex */
public class zzsi {

    /* renamed from: Fj */
    private static zzsi f3359Fj = new zzsi();

    /* renamed from: Fi */
    private zzsh f3360Fi = null;

    public static zzsh zzcr(Context context) {
        return f3359Fj.zzcq(context);
    }

    public synchronized zzsh zzcq(Context context) {
        if (this.f3360Fi == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f3360Fi = new zzsh(context);
        }
        return this.f3360Fi;
    }
}
