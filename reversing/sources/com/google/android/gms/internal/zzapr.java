package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class zzapr extends zzaot<Object> {
    public static final zzaou bmp = new zzaou() { // from class: com.google.android.gms.internal.zzapr.1
        @Override // com.google.android.gms.internal.zzaou
        public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
            if (zzapxVar.m9638by() == Object.class) {
                return new zzapr(zzaobVar);
            }
            return null;
        }
    };
    private final zzaob bll;

    private zzapr(zzaob zzaobVar) {
        this.bll = zzaobVar;
    }

    @Override // com.google.android.gms.internal.zzaot
    public void zza(zzaqa zzaqaVar, Object obj) throws IOException {
        if (obj == null) {
            zzaqaVar.mo9616bx();
            return;
        }
        zzaot zzk = this.bll.zzk(obj.getClass());
        if (!(zzk instanceof zzapr)) {
            zzk.zza(zzaqaVar, obj);
            return;
        }
        zzaqaVar.mo9618bv();
        zzaqaVar.mo9617bw();
    }

    @Override // com.google.android.gms.internal.zzaot
    public Object zzb(zzapy zzapyVar) throws IOException {
        switch (zzapyVar.mo9627bn()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                zzapyVar.beginArray();
                while (zzapyVar.hasNext()) {
                    arrayList.add(zzb(zzapyVar));
                }
                zzapyVar.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                zzapf zzapfVar = new zzapf();
                zzapyVar.beginObject();
                while (zzapyVar.hasNext()) {
                    zzapfVar.put(zzapyVar.nextName(), zzb(zzapyVar));
                }
                zzapyVar.endObject();
                return zzapfVar;
            case STRING:
                return zzapyVar.nextString();
            case NUMBER:
                return Double.valueOf(zzapyVar.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(zzapyVar.nextBoolean());
            case NULL:
                zzapyVar.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
