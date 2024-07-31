package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzapc implements zzaou, Cloneable {
    public static final zzapc blF = new zzapc();
    private double blG = -1.0d;
    private int blH = 136;
    private boolean blI = true;
    private List<zzanx> blJ = Collections.emptyList();
    private List<zzanx> blK = Collections.emptyList();

    private boolean zza(zzaox zzaoxVar) {
        return zzaoxVar == null || zzaoxVar.m9653bf() <= this.blG;
    }

    private boolean zza(zzaox zzaoxVar, zzaoy zzaoyVar) {
        return zza(zzaoxVar) && zza(zzaoyVar);
    }

    private boolean zza(zzaoy zzaoyVar) {
        return zzaoyVar == null || zzaoyVar.m9652bf() > this.blG;
    }

    private boolean zzm(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean zzn(Class<?> cls) {
        return cls.isMemberClass() && !zzo(cls);
    }

    private boolean zzo(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: bh */
    public zzapc clone() {
        try {
            return (zzapc) super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new AssertionError();
        }
    }

    @Override // com.google.android.gms.internal.zzaou
    public <T> zzaot<T> zza(final zzaob zzaobVar, final zzapx<T> zzapxVar) {
        Class<? super T> m9638by = zzapxVar.m9638by();
        final boolean zza = zza((Class<?>) m9638by, true);
        final boolean zza2 = zza((Class<?>) m9638by, false);
        if (zza || zza2) {
            return new zzaot<T>() { // from class: com.google.android.gms.internal.zzapc.1
                private zzaot<T> bkU;

                /* renamed from: bd */
                private zzaot<T> m9650bd() {
                    zzaot<T> zzaotVar = this.bkU;
                    if (zzaotVar != null) {
                        return zzaotVar;
                    }
                    zzaot<T> zza3 = zzaobVar.zza(zzapc.this, zzapxVar);
                    this.bkU = zza3;
                    return zza3;
                }

                @Override // com.google.android.gms.internal.zzaot
                public void zza(zzaqa zzaqaVar, T t) throws IOException {
                    if (zza) {
                        zzaqaVar.mo9616bx();
                    } else {
                        m9650bd().zza(zzaqaVar, t);
                    }
                }

                @Override // com.google.android.gms.internal.zzaot
                public T zzb(zzapy zzapyVar) throws IOException {
                    if (zza2) {
                        zzapyVar.skipValue();
                        return null;
                    }
                    return m9650bd().zzb(zzapyVar);
                }
            };
        }
        return null;
    }

    public zzapc zza(zzanx zzanxVar, boolean z, boolean z2) {
        zzapc clone = clone();
        if (z) {
            clone.blJ = new ArrayList(this.blJ);
            clone.blJ.add(zzanxVar);
        }
        if (z2) {
            clone.blK = new ArrayList(this.blK);
            clone.blK.add(zzanxVar);
        }
        return clone;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.blG == -1.0d || zza((zzaox) cls.getAnnotation(zzaox.class), (zzaoy) cls.getAnnotation(zzaoy.class))) {
            if ((this.blI || !zzn(cls)) && !zzm(cls)) {
                for (zzanx zzanxVar : z ? this.blJ : this.blK) {
                    if (zzanxVar.zzh(cls)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.blH & field.getModifiers()) != 0) {
            return true;
        }
        if ((this.blG == -1.0d || zza((zzaox) field.getAnnotation(zzaox.class), (zzaoy) field.getAnnotation(zzaoy.class))) && !field.isSynthetic()) {
            if ((this.blI || !zzn(field.getType())) && !zzm(field.getType())) {
                List<zzanx> list = z ? this.blJ : this.blK;
                if (list.isEmpty()) {
                    return false;
                }
                zzany zzanyVar = new zzany(field);
                for (zzanx zzanxVar : list) {
                    if (zzanxVar.zza(zzanyVar)) {
                        return true;
                    }
                }
                return false;
            }
            return true;
        }
        return true;
    }

    public zzapc zzg(int... iArr) {
        zzapc clone = clone();
        clone.blH = 0;
        for (int i : iArr) {
            clone.blH = i | clone.blH;
        }
        return clone;
    }
}
