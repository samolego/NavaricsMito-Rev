package com.google.android.gms.internal;

/* loaded from: classes.dex */
public final class zzva {

    /* renamed from: Uw */
    private static zzva f3374Uw;

    /* renamed from: Ux */
    private final zzux f3375Ux = new zzux();

    /* renamed from: Uy */
    private final zzuy f3376Uy = new zzuy();

    static {
        zza(new zzva());
    }

    private zzva() {
    }

    protected static void zza(zzva zzvaVar) {
        synchronized (zzva.class) {
            f3374Uw = zzvaVar;
        }
    }

    private static zzva zzbhl() {
        zzva zzvaVar;
        synchronized (zzva.class) {
            zzvaVar = f3374Uw;
        }
        return zzvaVar;
    }

    public static zzux zzbhm() {
        return zzbhl().f3375Ux;
    }

    public static zzuy zzbhn() {
        return zzbhl().f3376Uy;
    }
}
