package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzapk<E> extends zzaot<Object> {
    public static final zzaou bmp = new zzaou() { // from class: com.google.android.gms.internal.zzapk.1
        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            Type m9637bz = zzapxVar.m9637bz();
            if ((m9637bz instanceof GenericArrayType) || ((m9637bz instanceof Class) && ((Class) m9637bz).isArray())) {
                Type zzh = zzapa.zzh(m9637bz);
                return new zzapk(zzaobVar, zzaobVar.zza(zzapx.zzl(zzh)), zzapa.zzf(zzh));
            }
            return null;
        }
    };
    private final Class<E> bmq;
    private final zzaot<E> bmr;

    public zzapk(zzaob zzaobVar, zzaot<E> zzaotVar, Class<E> cls) {
        this.bmr = new zzapv(zzaobVar, zzaotVar, cls);
        this.bmq = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.zzaot
    public void zza(zzaqa zzaqaVar, Object obj) throws IOException {
        if (obj == null) {
            zzaqaVar.mo9616bx();
            return;
        }
        zzaqaVar.mo9620bt();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.bmr.zza(zzaqaVar, Array.get(obj, i));
        }
        zzaqaVar.mo9619bu();
    }

    @Override // com.google.android.gms.internal.zzaot
    public Object zzb(zzapy zzapyVar) throws IOException {
        if (zzapyVar.mo9627bn() == zzapz.NULL) {
            zzapyVar.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzapyVar.beginArray();
        while (zzapyVar.hasNext()) {
            arrayList.add(this.bmr.zzb(zzapyVar));
        }
        zzapyVar.endArray();
        Object newInstance = Array.newInstance((Class<?>) this.bmq, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
