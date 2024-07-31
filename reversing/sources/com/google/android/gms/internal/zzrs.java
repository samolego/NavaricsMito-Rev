package com.google.android.gms.internal;

import android.os.Binder;

/* loaded from: classes.dex */
public abstract class zzrs<T> {

    /* renamed from: zD */
    private T f3327zD = null;
    protected final String zzbaf;
    protected final T zzbag;
    private static final Object zzaok = new Object();

    /* renamed from: zB */
    private static zza f3325zB = null;

    /* renamed from: zC */
    private static int f3326zC = 0;
    private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzrs(String str, T t) {
        this.zzbaf = str;
        this.zzbag = t;
    }

    public static zzrs<Float> zza(String str, Float f) {
        return new zzrs<Float>(str, f) { // from class: com.google.android.gms.internal.zzrs.4
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzrs
            /* renamed from: zzhk */
            public Float zzhg(String str2) {
                return zzrs.zzasy().zzb(this.zzbaf, (Float) this.zzbag);
            }
        };
    }

    public static zzrs<Integer> zza(String str, Integer num) {
        return new zzrs<Integer>(str, num) { // from class: com.google.android.gms.internal.zzrs.3
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzrs
            /* renamed from: zzhj */
            public Integer zzhg(String str2) {
                return zzrs.zzasy().zzb(this.zzbaf, (Integer) this.zzbag);
            }
        };
    }

    public static zzrs<Long> zza(String str, Long l) {
        return new zzrs<Long>(str, l) { // from class: com.google.android.gms.internal.zzrs.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzrs
            /* renamed from: zzhi */
            public Long zzhg(String str2) {
                return zzrs.zzasy().getLong(this.zzbaf, (Long) this.zzbag);
            }
        };
    }

    public static zzrs<String> zzab(String str, String str2) {
        return new zzrs<String>(str, str2) { // from class: com.google.android.gms.internal.zzrs.5
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzrs
            /* renamed from: zzhl */
            public String zzhg(String str3) {
                return zzrs.zzasy().getString(this.zzbaf, (String) this.zzbag);
            }
        };
    }

    static /* synthetic */ zza zzasy() {
        return null;
    }

    public static zzrs<Boolean> zzm(String str, boolean z) {
        return new zzrs<Boolean>(str, Boolean.valueOf(z)) { // from class: com.google.android.gms.internal.zzrs.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.android.gms.internal.zzrs
            /* renamed from: zzhh */
            public Boolean zzhg(String str2) {
                return zzrs.zzasy().zza(this.zzbaf, (Boolean) this.zzbag);
            }
        };
    }

    public final T get() {
        try {
            return zzhg(this.zzbaf);
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return zzhg(this.zzbaf);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    protected abstract T zzhg(String str);
}
