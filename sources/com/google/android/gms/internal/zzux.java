package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzuw;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class zzux {
    private final Collection<zzuw> zzbah = new ArrayList();
    private final Collection<zzuw.zzd> zzbai = new ArrayList();
    private final Collection<zzuw.zzd> zzbaj = new ArrayList();

    public static void initialize(Context context) {
        zzva.zzbhn().initialize(context);
    }

    public void zza(zzuw zzuwVar) {
        this.zzbah.add(zzuwVar);
    }
}
