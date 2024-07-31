package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
final class zzaos<T> extends zzaot<T> {
    private zzaot<T> bkU;
    private final zzaop<T> blj;
    private final zzaog<T> blk;
    private final zzaob bll;
    private final zzapx<T> blm;
    private final zzaou bln;

    /* loaded from: classes.dex */
    private static class zza implements zzaou {
        private final zzaop<?> blj;
        private final zzaog<?> blk;
        private final zzapx<?> blo;
        private final boolean blp;
        private final Class<?> blq;

        private zza(Object obj, zzapx<?> zzapxVar, boolean z, Class<?> cls) {
            this.blj = obj instanceof zzaop ? (zzaop) obj : null;
            this.blk = obj instanceof zzaog ? (zzaog) obj : null;
            zzaoz.zzbs((this.blj == null && this.blk == null) ? false : true);
            this.blo = zzapxVar;
            this.blp = z;
            this.blq = cls;
        }

        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            zzapx<?> zzapxVar2 = this.blo;
            if (zzapxVar2 != null ? zzapxVar2.equals(zzapxVar) || (this.blp && this.blo.m9637bz() == zzapxVar.m9638by()) : this.blq.isAssignableFrom(zzapxVar.m9638by())) {
                return new zzaos(this.blj, this.blk, zzaobVar, zzapxVar, this);
            }
            return null;
        }
    }

    private zzaos(zzaop<T> zzaopVar, zzaog<T> zzaogVar, zzaob zzaobVar, zzapx<T> zzapxVar, zzaou zzaouVar) {
        this.blj = zzaopVar;
        this.blk = zzaogVar;
        this.bll = zzaobVar;
        this.blm = zzapxVar;
        this.bln = zzaouVar;
    }

    /* renamed from: bd */
    private zzaot<T> m9655bd() {
        zzaot<T> zzaotVar = this.bkU;
        if (zzaotVar != null) {
            return zzaotVar;
        }
        zzaot<T> zza2 = this.bll.zza(this.bln, this.blm);
        this.bkU = zza2;
        return zza2;
    }

    public static zzaou zza(zzapx<?> zzapxVar, Object obj) {
        return new zza(obj, zzapxVar, false, null);
    }

    public static zzaou zzb(zzapx<?> zzapxVar, Object obj) {
        return new zza(obj, zzapxVar, zzapxVar.m9637bz() == zzapxVar.m9638by(), null);
    }

    @Override // com.google.android.gms.internal.zzaot
    public void zza(zzaqa zzaqaVar, T t) throws IOException {
        zzaop<T> zzaopVar = this.blj;
        if (zzaopVar == null) {
            m9655bd().zza(zzaqaVar, t);
        } else if (t == null) {
            zzaqaVar.mo9616bx();
        } else {
            zzapi.zzb(zzaopVar.zza(t, this.blm.m9637bz(), this.bll.bkS), zzaqaVar);
        }
    }

    @Override // com.google.android.gms.internal.zzaot
    public T zzb(zzapy zzapyVar) throws IOException {
        if (this.blk == null) {
            return m9655bd().zzb(zzapyVar);
        }
        zzaoh zzh = zzapi.zzh(zzapyVar);
        if (zzh.m9665aV()) {
            return null;
        }
        try {
            return this.blk.zzb(zzh, this.blm.m9637bz(), this.bll.bkR);
        } catch (zzaol e) {
            throw e;
        } catch (Exception e2) {
            throw new zzaol(e2);
        }
    }
}
