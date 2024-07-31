package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;

/* loaded from: classes.dex */
public final class zzapl implements zzaou {
    private final zzapb bkM;

    /* loaded from: classes.dex */
    private static final class zza<E> extends zzaot<Collection<E>> {
        private final zzaot<E> bms;
        private final zzapg<? extends Collection<E>> bmt;

        public zza(zzaob zzaobVar, Type type, zzaot<E> zzaotVar, zzapg<? extends Collection<E>> zzapgVar) {
            this.bms = new zzapv(zzaobVar, zzaotVar, type);
            this.bmt = zzapgVar;
        }

        @Override // com.google.android.gms.internal.zzaot
        public /* bridge */ /* synthetic */ void zza(zzaqa zzaqaVar, Object obj) throws IOException {
            zza(zzaqaVar, (Collection) ((Collection) obj));
        }

        public void zza(zzaqa zzaqaVar, Collection<E> collection) throws IOException {
            if (collection == null) {
                zzaqaVar.mo9616bx();
                return;
            }
            zzaqaVar.mo9620bt();
            for (E e : collection) {
                this.bms.zza(zzaqaVar, e);
            }
            zzaqaVar.mo9619bu();
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzj */
        public Collection<E> zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            Collection<E> mo9646bg = this.bmt.mo9646bg();
            zzapyVar.beginArray();
            while (zzapyVar.hasNext()) {
                mo9646bg.add(this.bms.zzb(zzapyVar));
            }
            zzapyVar.endArray();
            return mo9646bg;
        }
    }

    public zzapl(zzapb zzapbVar) {
        this.bkM = zzapbVar;
    }

    @Override // com.google.android.gms.internal.zzaou
    public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
        Type m9637bz = zzapxVar.m9637bz();
        Class<? super T> m9638by = zzapxVar.m9638by();
        if (Collection.class.isAssignableFrom(m9638by)) {
            Type zza2 = zzapa.zza(m9637bz, (Class<?>) m9638by);
            return new zza(zzaobVar, zza2, zzaobVar.zza(zzapx.zzl(zza2)), this.bkM.zzb(zzapxVar));
        }
        return null;
    }
}
