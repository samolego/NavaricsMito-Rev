package com.google.android.gms.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes.dex */
public final class zzapb {
    private final Map<Type, zzaod<?>> bkY;

    public zzapb(Map<Type, zzaod<?>> map) {
        this.bkY = map;
    }

    private <T> zzapg<T> zzc(final Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.7
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) new TreeSet();
                }
            } : EnumSet.class.isAssignableFrom(cls) ? new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.8
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    Type type2 = type;
                    if (!(type2 instanceof ParameterizedType)) {
                        String valueOf = String.valueOf(type2.toString());
                        throw new zzaoi(valueOf.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf) : new String("Invalid EnumSet type: "));
                    }
                    Type type3 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                    if (type3 instanceof Class) {
                        return (T) EnumSet.noneOf((Class) type3);
                    }
                    String valueOf2 = String.valueOf(type.toString());
                    throw new zzaoi(valueOf2.length() != 0 ? "Invalid EnumSet type: ".concat(valueOf2) : new String("Invalid EnumSet type: "));
                }
            } : Set.class.isAssignableFrom(cls) ? new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.9
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.10
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) new LinkedList();
                }
            } : new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.11
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) new ArrayList();
                }
            };
        } else if (Map.class.isAssignableFrom(cls)) {
            return SortedMap.class.isAssignableFrom(cls) ? new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.12
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(zzapx.zzl(((ParameterizedType) type).getActualTypeArguments()[0]).m9638by())) ? new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.3
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) new zzapf();
                }
            } : new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.2
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) new LinkedHashMap();
                }
            };
        } else {
            return null;
        }
    }

    private <T> zzapg<T> zzd(final Type type, final Class<? super T> cls) {
        return new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.4
            private final zzapj blB = zzapj.m9645bl();

            @Override // com.google.android.gms.internal.zzapg
            /* renamed from: bg */
            public T mo9646bg() {
                try {
                    return (T) this.blB.zzf(cls);
                } catch (Exception e) {
                    String valueOf = String.valueOf(type);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 116);
                    sb.append("Unable to invoke no-args constructor for ");
                    sb.append(valueOf);
                    sb.append(". ");
                    sb.append("Register an InstanceCreator with Gson for this type may fix this problem.");
                    throw new RuntimeException(sb.toString(), e);
                }
            }
        };
    }

    private <T> zzapg<T> zzl(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                declaredConstructor.setAccessible(true);
            }
            return new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.6
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    try {
                        return (T) declaredConstructor.newInstance(null);
                    } catch (IllegalAccessException e) {
                        throw new AssertionError(e);
                    } catch (InstantiationException e2) {
                        String valueOf = String.valueOf(declaredConstructor);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 30);
                        sb.append("Failed to invoke ");
                        sb.append(valueOf);
                        sb.append(" with no args");
                        throw new RuntimeException(sb.toString(), e2);
                    } catch (InvocationTargetException e3) {
                        String valueOf2 = String.valueOf(declaredConstructor);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 30);
                        sb2.append("Failed to invoke ");
                        sb2.append(valueOf2);
                        sb2.append(" with no args");
                        throw new RuntimeException(sb2.toString(), e3.getTargetException());
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public String toString() {
        return this.bkY.toString();
    }

    public <T> zzapg<T> zzb(zzapx<T> zzapxVar) {
        final Type m9637bz = zzapxVar.m9637bz();
        Class<? super T> m9638by = zzapxVar.m9638by();
        final zzaod<?> zzaodVar = this.bkY.get(m9637bz);
        if (zzaodVar != null) {
            return new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.1
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) zzaodVar.zza(m9637bz);
                }
            };
        }
        final zzaod<?> zzaodVar2 = this.bkY.get(m9638by);
        if (zzaodVar2 != null) {
            return new zzapg<T>() { // from class: com.google.android.gms.internal.zzapb.5
                @Override // com.google.android.gms.internal.zzapg
                /* renamed from: bg */
                public T mo9646bg() {
                    return (T) zzaodVar2.zza(m9637bz);
                }
            };
        }
        zzapg<T> zzl = zzl(m9638by);
        if (zzl != null) {
            return zzl;
        }
        zzapg<T> zzc = zzc(m9637bz, m9638by);
        return zzc != null ? zzc : zzd(m9637bz, m9638by);
    }
}
