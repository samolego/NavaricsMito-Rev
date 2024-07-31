package com.google.android.gms.internal;

import android.os.RemoteException;

/* loaded from: classes.dex */
public abstract class zzuw<T> {
    private final int zzbae;
    private final String zzbaf;
    private final T zzbag;

    /* loaded from: classes.dex */
    public static class zza extends zzuw<Boolean> {
        public zza(int i, String str, Boolean bool) {
            super(i, str, bool);
        }

        @Override // com.google.android.gms.internal.zzuw
        /* renamed from: zzb */
        public Boolean zza(zzuz zzuzVar) {
            try {
                return Boolean.valueOf(zzuzVar.getBooleanFlagValue(getKey(), zzkq().booleanValue(), getSource()));
            } catch (RemoteException unused) {
                return zzkq();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zzb extends zzuw<Integer> {
        public zzb(int i, String str, Integer num) {
            super(i, str, num);
        }

        @Override // com.google.android.gms.internal.zzuw
        /* renamed from: zzc */
        public Integer zza(zzuz zzuzVar) {
            try {
                return Integer.valueOf(zzuzVar.getIntFlagValue(getKey(), zzkq().intValue(), getSource()));
            } catch (RemoteException unused) {
                return zzkq();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zzc extends zzuw<Long> {
        public zzc(int i, String str, Long l) {
            super(i, str, l);
        }

        @Override // com.google.android.gms.internal.zzuw
        /* renamed from: zzd */
        public Long zza(zzuz zzuzVar) {
            try {
                return Long.valueOf(zzuzVar.getLongFlagValue(getKey(), zzkq().longValue(), getSource()));
            } catch (RemoteException unused) {
                return zzkq();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class zzd extends zzuw<String> {
        public zzd(int i, String str, String str2) {
            super(i, str, str2);
        }

        @Override // com.google.android.gms.internal.zzuw
        /* renamed from: zze */
        public String zza(zzuz zzuzVar) {
            try {
                return zzuzVar.getStringFlagValue(getKey(), zzkq(), getSource());
            } catch (RemoteException unused) {
                return zzkq();
            }
        }
    }

    private zzuw(int i, String str, T t) {
        this.zzbae = i;
        this.zzbaf = str;
        this.zzbag = t;
        zzva.zzbhm().zza(this);
    }

    public static zza zzb(int i, String str, Boolean bool) {
        return new zza(i, str, bool);
    }

    public static zzb zzb(int i, String str, int i2) {
        return new zzb(i, str, Integer.valueOf(i2));
    }

    public static zzc zzb(int i, String str, long j) {
        return new zzc(i, str, Long.valueOf(j));
    }

    public static zzd zzc(int i, String str, String str2) {
        return new zzd(i, str, str2);
    }

    public T get() {
        return (T) zzva.zzbhn().zzb(this);
    }

    public String getKey() {
        return this.zzbaf;
    }

    public int getSource() {
        return this.zzbae;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract T zza(zzuz zzuzVar);

    public T zzkq() {
        return this.zzbag;
    }
}
