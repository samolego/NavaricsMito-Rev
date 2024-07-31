package com.google.android.gms.internal;

import android.app.Activity;
import android.support.p008v4.app.FragmentActivity;

/* loaded from: classes.dex */
public class zzqz {

    /* renamed from: yX */
    private final Object f3280yX;

    public zzqz(Activity activity) {
        com.google.android.gms.common.internal.zzac.zzb(activity, "Activity must not be null");
        com.google.android.gms.common.internal.zzac.zzb(com.google.android.gms.common.util.zzs.zzaxk() || (activity instanceof FragmentActivity), "This Activity is not supported before platform version 11 (3.0 Honeycomb). Please use FragmentActivity instead.");
        this.f3280yX = activity;
    }

    public boolean zzasn() {
        return this.f3280yX instanceof FragmentActivity;
    }

    public Activity zzaso() {
        return (Activity) this.f3280yX;
    }

    public FragmentActivity zzasp() {
        return (FragmentActivity) this.f3280yX;
    }
}
