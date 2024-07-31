package com.google.android.gms.internal;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes.dex */
public class zzapx<T> {
    final Type bmR;
    final Class<? super T> bnV;
    final int bnW;

    protected zzapx() {
        this.bmR = zzq(getClass());
        this.bnV = (Class<? super T>) zzapa.zzf(this.bmR);
        this.bnW = this.bmR.hashCode();
    }

    zzapx(Type type) {
        this.bmR = zzapa.zze((Type) zzaoz.zzy(type));
        this.bnV = (Class<? super T>) zzapa.zzf(this.bmR);
        this.bnW = this.bmR.hashCode();
    }

    public static zzapx<?> zzl(Type type) {
        return new zzapx<>(type);
    }

    static Type zzq(Class<?> cls) {
        Type genericSuperclass = cls.getGenericSuperclass();
        if (genericSuperclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        return zzapa.zze(((ParameterizedType) genericSuperclass).getActualTypeArguments()[0]);
    }

    public static <T> zzapx<T> zzr(Class<T> cls) {
        return new zzapx<>(cls);
    }

    /* renamed from: by */
    public final Class<? super T> m9638by() {
        return this.bnV;
    }

    /* renamed from: bz */
    public final Type m9637bz() {
        return this.bmR;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzapx) && zzapa.zza(this.bmR, ((zzapx) obj).bmR);
    }

    public final int hashCode() {
        return this.bnW;
    }

    public final String toString() {
        return zzapa.zzg(this.bmR);
    }
}
