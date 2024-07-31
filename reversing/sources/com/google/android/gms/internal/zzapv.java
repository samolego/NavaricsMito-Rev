package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaps;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzapv<T> extends zzaot<T> {
    private final zzaot<T> bkU;
    private final zzaob bmQ;
    private final Type bmR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzapv(zzaob zzaobVar, zzaot<T> zzaotVar, Type type) {
        this.bmQ = zzaobVar;
        this.bkU = zzaotVar;
        this.bmR = type;
    }

    private Type zzb(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    @Override // com.google.android.gms.internal.zzaot
    public void zza(zzaqa zzaqaVar, T t) throws IOException {
        zzaot<T> zzaotVar = this.bkU;
        Type zzb = zzb(this.bmR, t);
        if (zzb != this.bmR) {
            zzaotVar = this.bmQ.zza(zzapx.zzl(zzb));
            if (zzaotVar instanceof zzaps.zza) {
                zzaot<T> zzaotVar2 = this.bkU;
                if (!(zzaotVar2 instanceof zzaps.zza)) {
                    zzaotVar = zzaotVar2;
                }
            }
        }
        zzaotVar.zza(zzaqaVar, t);
    }

    @Override // com.google.android.gms.internal.zzaot
    public T zzb(zzapy zzapyVar) throws IOException {
        return this.bkU.zzb(zzapyVar);
    }
}
