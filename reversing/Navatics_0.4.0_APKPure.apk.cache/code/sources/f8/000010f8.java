package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzvb;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class zzb {

    /* renamed from: UF */
    private static SharedPreferences f3079UF;

    public static SharedPreferences zzn(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f3079UF == null) {
                f3079UF = (SharedPreferences) zzvb.zzb(new Callable<SharedPreferences>() { // from class: com.google.android.gms.flags.impl.zzb.1
                    @Override // java.util.concurrent.Callable
                    /* renamed from: zzbhq, reason: merged with bridge method [inline-methods] */
                    public SharedPreferences call() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = f3079UF;
        }
        return sharedPreferences;
    }
}