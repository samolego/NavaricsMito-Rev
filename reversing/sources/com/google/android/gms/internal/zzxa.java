package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class zzxa implements Api.ApiOptions.Optional {
    public static final zzxa aAa = new zza().zzcdf();
    private final boolean aAb;
    private final boolean aAc;
    private final Long aAd;
    private final Long aAe;

    /* renamed from: hh */
    private final boolean f3382hh;

    /* renamed from: hj */
    private final boolean f3383hj;

    /* renamed from: hk */
    private final String f3384hk;

    /* renamed from: hl */
    private final String f3385hl;

    /* loaded from: classes.dex */
    public static final class zza {
        public zzxa zzcdf() {
            return new zzxa(false, false, null, false, null, false, null, null);
        }
    }

    private zzxa(boolean z, boolean z2, String str, boolean z3, String str2, boolean z4, Long l, Long l2) {
        this.aAb = z;
        this.f3382hh = z2;
        this.f3384hk = str;
        this.f3383hj = z3;
        this.aAc = z4;
        this.f3385hl = str2;
        this.aAd = l;
        this.aAe = l2;
    }

    public boolean zzahk() {
        return this.f3382hh;
    }

    public boolean zzahm() {
        return this.f3383hj;
    }

    public String zzahn() {
        return this.f3384hk;
    }

    @Nullable
    public String zzaho() {
        return this.f3385hl;
    }

    public boolean zzcdb() {
        return this.aAb;
    }

    public boolean zzcdc() {
        return this.aAc;
    }

    @Nullable
    public Long zzcdd() {
        return this.aAd;
    }

    @Nullable
    public Long zzcde() {
        return this.aAe;
    }
}
