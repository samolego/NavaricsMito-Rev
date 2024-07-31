package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzrs;

/* loaded from: classes.dex */
public final class zzc {

    /* renamed from: Ef */
    public static zzrs<Integer> f2972Ef = zzrs.zza("gms:common:stats:max_num_of_events", (Integer) 100);

    /* renamed from: Eg */
    public static zzrs<Integer> f2973Eg = zzrs.zza("gms:common:stats:max_chunk_size", (Integer) 100);

    /* loaded from: classes.dex */
    public static final class zza {

        /* renamed from: Eh */
        public static zzrs<Integer> f2974Eh = zzrs.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));

        /* renamed from: Ei */
        public static zzrs<String> f2975Ei = zzrs.zzab("gms:common:stats:connections:ignored_calling_processes", "");

        /* renamed from: Ej */
        public static zzrs<String> f2976Ej = zzrs.zzab("gms:common:stats:connections:ignored_calling_services", "");

        /* renamed from: Ek */
        public static zzrs<String> f2977Ek = zzrs.zzab("gms:common:stats:connections:ignored_target_processes", "");

        /* renamed from: El */
        public static zzrs<String> f2978El = zzrs.zzab("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");

        /* renamed from: Em */
        public static zzrs<Long> f2979Em = zzrs.zza("gms:common:stats:connections:time_out_duration", (Long) 600000L);
    }

    /* loaded from: classes.dex */
    public static final class zzb {

        /* renamed from: Eh */
        public static zzrs<Integer> f2980Eh = zzrs.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));

        /* renamed from: Em */
        public static zzrs<Long> f2981Em = zzrs.zza("gms:common:stats:wakelocks:time_out_duration", (Long) 600000L);
    }
}
