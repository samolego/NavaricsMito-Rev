package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzapq implements zzaou {
    private final zzapb bkM;
    private final boolean bmB;

    /* loaded from: classes.dex */
    private final class zza<K, V> extends zzaot<Map<K, V>> {
        private final zzaot<K> bmC;
        private final zzaot<V> bmD;
        private final zzapg<? extends Map<K, V>> bmt;

        public zza(zzaob zzaobVar, Type type, zzaot<K> zzaotVar, Type type2, zzaot<V> zzaotVar2, zzapg<? extends Map<K, V>> zzapgVar) {
            this.bmC = new zzapv(zzaobVar, zzaotVar, type);
            this.bmD = new zzapv(zzaobVar, zzaotVar2, type2);
            this.bmt = zzapgVar;
        }

        private String zze(zzaoh zzaohVar) {
            if (!zzaohVar.m9666aU()) {
                if (zzaohVar.m9665aV()) {
                    return "null";
                }
                throw new AssertionError();
            }
            zzaon m9662aY = zzaohVar.m9662aY();
            if (m9662aY.m9657bb()) {
                return String.valueOf(m9662aY.mo9661aQ());
            }
            if (m9662aY.m9658ba()) {
                return Boolean.toString(m9662aY.getAsBoolean());
            }
            if (m9662aY.m9656bc()) {
                return m9662aY.mo9660aR();
            }
            throw new AssertionError();
        }

        @Override // com.google.android.gms.internal.zzaot
        public /* bridge */ /* synthetic */ void zza(zzaqa zzaqaVar, Object obj) throws IOException {
            zza(zzaqaVar, (Map) ((Map) obj));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void zza(zzaqa zzaqaVar, Map<K, V> map) throws IOException {
            if (map == null) {
                zzaqaVar.mo9616bx();
            } else if (!zzapq.this.bmB) {
                zzaqaVar.mo9618bv();
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    zzaqaVar.zzus(String.valueOf(entry.getKey()));
                    this.bmD.zza(zzaqaVar, entry.getValue());
                }
                zzaqaVar.mo9617bw();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                int i = 0;
                boolean z = false;
                for (Map.Entry<K, V> entry2 : map.entrySet()) {
                    zzaoh zzco = this.bmC.zzco(entry2.getKey());
                    arrayList.add(zzco);
                    arrayList2.add(entry2.getValue());
                    z |= zzco.m9668aS() || zzco.m9667aT();
                }
                if (!z) {
                    zzaqaVar.mo9618bv();
                    while (i < arrayList.size()) {
                        zzaqaVar.zzus(zze((zzaoh) arrayList.get(i)));
                        this.bmD.zza(zzaqaVar, arrayList2.get(i));
                        i++;
                    }
                    zzaqaVar.mo9617bw();
                    return;
                }
                zzaqaVar.mo9620bt();
                while (i < arrayList.size()) {
                    zzaqaVar.mo9620bt();
                    zzapi.zzb((zzaoh) arrayList.get(i), zzaqaVar);
                    this.bmD.zza(zzaqaVar, arrayList2.get(i));
                    zzaqaVar.mo9619bu();
                    i++;
                }
                zzaqaVar.mo9619bu();
            }
        }

        @Override // com.google.android.gms.internal.zzaot
        /* renamed from: zzl */
        public Map<K, V> zzb(zzapy zzapyVar) throws IOException {
            zzapz mo9627bn = zzapyVar.mo9627bn();
            if (mo9627bn == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            Map<K, V> mo9646bg = this.bmt.mo9646bg();
            if (mo9627bn == zzapz.BEGIN_ARRAY) {
                zzapyVar.beginArray();
                while (zzapyVar.hasNext()) {
                    zzapyVar.beginArray();
                    K zzb = this.bmC.zzb(zzapyVar);
                    if (mo9646bg.put(zzb, this.bmD.zzb(zzapyVar)) != null) {
                        String valueOf = String.valueOf(zzb);
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
                        sb.append("duplicate key: ");
                        sb.append(valueOf);
                        throw new zzaoq(sb.toString());
                    }
                    zzapyVar.endArray();
                }
                zzapyVar.endArray();
            } else {
                zzapyVar.beginObject();
                while (zzapyVar.hasNext()) {
                    zzapd.blQ.zzi(zzapyVar);
                    K zzb2 = this.bmC.zzb(zzapyVar);
                    if (mo9646bg.put(zzb2, this.bmD.zzb(zzapyVar)) != null) {
                        String valueOf2 = String.valueOf(zzb2);
                        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 15);
                        sb2.append("duplicate key: ");
                        sb2.append(valueOf2);
                        throw new zzaoq(sb2.toString());
                    }
                }
                zzapyVar.endObject();
            }
            return mo9646bg;
        }
    }

    public zzapq(zzapb zzapbVar, boolean z) {
        this.bkM = zzapbVar;
        this.bmB = z;
    }

    private zzaot<?> zza(zzaob zzaobVar, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzapw.bmX : zzaobVar.zza(zzapx.zzl(type));
    }

    @Override // com.google.android.gms.internal.zzaou
    public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
        Type m9637bz = zzapxVar.m9637bz();
        if (Map.class.isAssignableFrom(zzapxVar.m9638by())) {
            Type[] zzb = zzapa.zzb(m9637bz, zzapa.zzf(m9637bz));
            return new zza(zzaobVar, zzb[0], zza(zzaobVar, zzb[0]), zzb[1], zzaobVar.zza(zzapx.zzl(zzb[1])), this.bkM.zzb(zzapxVar));
        }
        return null;
    }
}
