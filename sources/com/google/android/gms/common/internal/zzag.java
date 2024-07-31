package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.zzg;

/* loaded from: classes.dex */
public final class zzag extends com.google.android.gms.dynamic.zzg<zzy> {

    /* renamed from: Da */
    private static final zzag f2803Da = new zzag();

    private zzag() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zzb(Context context, int i, int i2) throws zzg.zza {
        return f2803Da.zzc(context, i, i2);
    }

    private View zzc(Context context, int i, int i2) throws zzg.zza {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, null);
            return (View) com.google.android.gms.dynamic.zze.zzae(zzcu(context).zza(com.google.android.gms.dynamic.zze.zzac(context), signInButtonConfig));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i);
            sb.append(" and color ");
            sb.append(i2);
            throw new zzg.zza(sb.toString(), e);
        }
    }

    @Override // com.google.android.gms.dynamic.zzg
    /* renamed from: zzdz */
    public zzy zzc(IBinder iBinder) {
        return zzy.zza.zzdy(iBinder);
    }
}
