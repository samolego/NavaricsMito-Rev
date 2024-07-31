package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaob {
    private final ThreadLocal<Map<zzapx<?>, zza<?>>> bkJ;
    private final Map<zzapx<?>, zzaot<?>> bkK;
    private final List<zzaou> bkL;
    private final zzapb bkM;
    private final boolean bkN;
    private final boolean bkO;
    private final boolean bkP;
    private final boolean bkQ;
    final zzaof bkR;
    final zzaoo bkS;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class zza<T> extends zzaot<T> {
        private zzaot<T> bkU;

        zza() {
        }

        public void zza(zzaot<T> zzaotVar) {
            if (this.bkU != null) {
                throw new AssertionError();
            }
            this.bkU = zzaotVar;
        }

        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, T t) throws IOException {
            zzaot<T> zzaotVar = this.bkU;
            if (zzaotVar == null) {
                throw new IllegalStateException();
            }
            zzaotVar.zza(zzaqaVar, t);
        }

        @Override // com.google.android.gms.internal.zzaot
        public T zzb(zzapy zzapyVar) throws IOException {
            zzaot<T> zzaotVar = this.bkU;
            if (zzaotVar != null) {
                return zzaotVar.zzb(zzapyVar);
            }
            throw new IllegalStateException();
        }
    }

    public zzaob() {
        this(zzapc.blF, zzanz.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, zzaor.DEFAULT, Collections.emptyList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaob(zzapc zzapcVar, zzaoa zzaoaVar, Map<Type, zzaod<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzaor zzaorVar, List<zzaou> list) {
        this.bkJ = new ThreadLocal<>();
        this.bkK = Collections.synchronizedMap(new HashMap());
        this.bkR = new zzaof() { // from class: com.google.android.gms.internal.zzaob.1
        };
        this.bkS = new zzaoo() { // from class: com.google.android.gms.internal.zzaob.2
        };
        this.bkM = new zzapb(map);
        this.bkN = z;
        this.bkP = z3;
        this.bkO = z4;
        this.bkQ = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzapw.bnI);
        arrayList.add(zzapr.bmp);
        arrayList.add(zzapcVar);
        arrayList.addAll(list);
        arrayList.add(zzapw.bnp);
        arrayList.add(zzapw.bne);
        arrayList.add(zzapw.bmY);
        arrayList.add(zzapw.bna);
        arrayList.add(zzapw.bnc);
        arrayList.add(zzapw.zza(Long.TYPE, Long.class, zza(zzaorVar)));
        arrayList.add(zzapw.zza(Double.TYPE, Double.class, zzdd(z6)));
        arrayList.add(zzapw.zza(Float.TYPE, Float.class, zzde(z6)));
        arrayList.add(zzapw.bnj);
        arrayList.add(zzapw.bnl);
        arrayList.add(zzapw.bnr);
        arrayList.add(zzapw.bnt);
        arrayList.add(zzapw.zza(BigDecimal.class, zzapw.bnn));
        arrayList.add(zzapw.zza(BigInteger.class, zzapw.bno));
        arrayList.add(zzapw.bnv);
        arrayList.add(zzapw.bnx);
        arrayList.add(zzapw.bnB);
        arrayList.add(zzapw.bnG);
        arrayList.add(zzapw.bnz);
        arrayList.add(zzapw.bmV);
        arrayList.add(zzapm.bmp);
        arrayList.add(zzapw.bnE);
        arrayList.add(zzapu.bmp);
        arrayList.add(zzapt.bmp);
        arrayList.add(zzapw.bnC);
        arrayList.add(zzapk.bmp);
        arrayList.add(zzapw.bmT);
        arrayList.add(new zzapl(this.bkM));
        arrayList.add(new zzapq(this.bkM, z2));
        arrayList.add(new zzapn(this.bkM));
        arrayList.add(zzapw.bnJ);
        arrayList.add(new zzaps(this.bkM, zzaoaVar, zzapcVar));
        this.bkL = Collections.unmodifiableList(arrayList);
    }

    private zzaot<Number> zza(zzaor zzaorVar) {
        return zzaorVar == zzaor.DEFAULT ? zzapw.bnf : new zzaot<Number>() { // from class: com.google.android.gms.internal.zzaob.5
            @Override // com.google.android.gms.internal.zzaot
            public void zza(zzaqa zzaqaVar, Number number) throws IOException {
                if (number == null) {
                    zzaqaVar.mo9616bx();
                } else {
                    zzaqaVar.zzut(number.toString());
                }
            }

            @Override // com.google.android.gms.internal.zzaot
            /* renamed from: zzg */
            public Number zzb(zzapy zzapyVar) throws IOException {
                if (zzapyVar.mo9627bn() == zzapz.NULL) {
                    zzapyVar.nextNull();
                    return null;
                }
                return Long.valueOf(zzapyVar.nextLong());
            }
        };
    }

    private static void zza(Object obj, zzapy zzapyVar) {
        if (obj != null) {
            try {
                if (zzapyVar.mo9627bn() == zzapz.END_DOCUMENT) {
                    return;
                }
                throw new zzaoi("JSON document was not fully consumed.");
            } catch (zzaqb e) {
                throw new zzaoq(e);
            } catch (IOException e2) {
                throw new zzaoi(e2);
            }
        }
    }

    private zzaot<Number> zzdd(boolean z) {
        return z ? zzapw.bnh : new zzaot<Number>() { // from class: com.google.android.gms.internal.zzaob.3
            @Override // com.google.android.gms.internal.zzaot
            public void zza(zzaqa zzaqaVar, Number number) throws IOException {
                if (number == null) {
                    zzaqaVar.mo9616bx();
                    return;
                }
                zzaob.this.zzn(number.doubleValue());
                zzaqaVar.zza(number);
            }

            @Override // com.google.android.gms.internal.zzaot
            /* renamed from: zze */
            public Double zzb(zzapy zzapyVar) throws IOException {
                if (zzapyVar.mo9627bn() == zzapz.NULL) {
                    zzapyVar.nextNull();
                    return null;
                }
                return Double.valueOf(zzapyVar.nextDouble());
            }
        };
    }

    private zzaot<Number> zzde(boolean z) {
        return z ? zzapw.bng : new zzaot<Number>() { // from class: com.google.android.gms.internal.zzaob.4
            @Override // com.google.android.gms.internal.zzaot
            public void zza(zzaqa zzaqaVar, Number number) throws IOException {
                if (number == null) {
                    zzaqaVar.mo9616bx();
                    return;
                }
                zzaob.this.zzn(number.floatValue());
                zzaqaVar.zza(number);
            }

            @Override // com.google.android.gms.internal.zzaot
            /* renamed from: zzf */
            public Float zzb(zzapy zzapyVar) throws IOException {
                if (zzapyVar.mo9627bn() == zzapz.NULL) {
                    zzapyVar.nextNull();
                    return null;
                }
                return Float.valueOf((float) zzapyVar.nextDouble());
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzn(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            StringBuilder sb = new StringBuilder(168);
            sb.append(d);
            sb.append(" is not a valid double value as per JSON specification. To override this");
            sb.append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
            throw new IllegalArgumentException(sb.toString());
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.bkN + "factories:" + this.bkL + ",instanceCreators:" + this.bkM + "}";
    }

    public <T> zzaot<T> zza(zzaou zzaouVar, zzapx<T> zzapxVar) {
        boolean z = !this.bkL.contains(zzaouVar);
        for (zzaou zzaouVar2 : this.bkL) {
            if (z) {
                zzaot<T> zza2 = zzaouVar2.zza(this, zzapxVar);
                if (zza2 != null) {
                    return zza2;
                }
            } else if (zzaouVar2 == zzaouVar) {
                z = true;
            }
        }
        String valueOf = String.valueOf(zzapxVar);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("GSON cannot serialize ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> zzaot<T> zza(zzapx<T> zzapxVar) {
        zzaot<T> zzaotVar = (zzaot<T>) this.bkK.get(zzapxVar);
        if (zzaotVar != null) {
            return zzaotVar;
        }
        Map<zzapx<?>, zza<?>> map = this.bkJ.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.bkJ.set(map);
            z = true;
        }
        zza<?> zzaVar = map.get(zzapxVar);
        if (zzaVar != null) {
            return zzaVar;
        }
        try {
            zza<?> zzaVar2 = new zza<>();
            map.put(zzapxVar, zzaVar2);
            for (zzaou zzaouVar : this.bkL) {
                zzaot zzaotVar2 = (zzaot<T>) zzaouVar.zza(this, zzapxVar);
                if (zzaotVar2 != null) {
                    zzaVar2.zza(zzaotVar2);
                    this.bkK.put(zzapxVar, zzaotVar2);
                    return zzaotVar2;
                }
            }
            String valueOf = String.valueOf(zzapxVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
            sb.append("GSON cannot handle ");
            sb.append(valueOf);
            throw new IllegalArgumentException(sb.toString());
        } finally {
            map.remove(zzapxVar);
            if (z) {
                this.bkJ.remove();
            }
        }
    }

    public zzaqa zza(Writer writer) throws IOException {
        if (this.bkP) {
            writer.write(")]}'\n");
        }
        zzaqa zzaqaVar = new zzaqa(writer);
        if (this.bkQ) {
            zzaqaVar.setIndent("  ");
        }
        zzaqaVar.zzdi(this.bkN);
        return zzaqaVar;
    }

    public <T> T zza(zzaoh zzaohVar, Class<T> cls) throws zzaoq {
        return (T) zzaph.zzp(cls).cast(zza(zzaohVar, (Type) cls));
    }

    public <T> T zza(zzaoh zzaohVar, Type type) throws zzaoq {
        if (zzaohVar == null) {
            return null;
        }
        return (T) zza(new zzapo(zzaohVar), type);
    }

    public <T> T zza(zzapy zzapyVar, Type type) throws zzaoi, zzaoq {
        boolean isLenient = zzapyVar.isLenient();
        boolean z = true;
        zzapyVar.setLenient(true);
        try {
            try {
                try {
                    zzapyVar.mo9627bn();
                    z = false;
                    return zza(zzapx.zzl(type)).zzb(zzapyVar);
                } catch (EOFException e) {
                    if (z) {
                        zzapyVar.setLenient(isLenient);
                        return null;
                    }
                    throw new zzaoq(e);
                } catch (IllegalStateException e2) {
                    throw new zzaoq(e2);
                }
            } catch (IOException e3) {
                throw new zzaoq(e3);
            }
        } finally {
            zzapyVar.setLenient(isLenient);
        }
    }

    public <T> T zza(Reader reader, Type type) throws zzaoi, zzaoq {
        zzapy zzapyVar = new zzapy(reader);
        T t = (T) zza(zzapyVar, type);
        zza(t, zzapyVar);
        return t;
    }

    public <T> T zza(String str, Type type) throws zzaoq {
        if (str == null) {
            return null;
        }
        return (T) zza(new StringReader(str), type);
    }

    public void zza(zzaoh zzaohVar, zzaqa zzaqaVar) throws zzaoi {
        boolean isLenient = zzaqaVar.isLenient();
        zzaqaVar.setLenient(true);
        boolean m9626bJ = zzaqaVar.m9626bJ();
        zzaqaVar.zzdh(this.bkO);
        boolean m9625bK = zzaqaVar.m9625bK();
        zzaqaVar.zzdi(this.bkN);
        try {
            try {
                zzapi.zzb(zzaohVar, zzaqaVar);
            } catch (IOException e) {
                throw new zzaoi(e);
            }
        } finally {
            zzaqaVar.setLenient(isLenient);
            zzaqaVar.zzdh(m9626bJ);
            zzaqaVar.zzdi(m9625bK);
        }
    }

    public void zza(zzaoh zzaohVar, Appendable appendable) throws zzaoi {
        try {
            zza(zzaohVar, zza(zzapi.zza(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(Object obj, Type type, zzaqa zzaqaVar) throws zzaoi {
        zzaot zza2 = zza(zzapx.zzl(type));
        boolean isLenient = zzaqaVar.isLenient();
        zzaqaVar.setLenient(true);
        boolean m9626bJ = zzaqaVar.m9626bJ();
        zzaqaVar.zzdh(this.bkO);
        boolean m9625bK = zzaqaVar.m9625bK();
        zzaqaVar.zzdi(this.bkN);
        try {
            try {
                zza2.zza(zzaqaVar, obj);
            } catch (IOException e) {
                throw new zzaoi(e);
            }
        } finally {
            zzaqaVar.setLenient(isLenient);
            zzaqaVar.zzdh(m9626bJ);
            zzaqaVar.zzdi(m9625bK);
        }
    }

    public void zza(Object obj, Type type, Appendable appendable) throws zzaoi {
        try {
            zza(obj, type, zza(zzapi.zza(appendable)));
        } catch (IOException e) {
            throw new zzaoi(e);
        }
    }

    public String zzb(zzaoh zzaohVar) {
        StringWriter stringWriter = new StringWriter();
        zza(zzaohVar, stringWriter);
        return stringWriter.toString();
    }

    public String zzc(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        zza(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String zzcl(Object obj) {
        return obj == null ? zzb(zzaoj.bld) : zzc(obj, obj.getClass());
    }

    public <T> T zzf(String str, Class<T> cls) throws zzaoq {
        return (T) zzaph.zzp(cls).cast(zza(str, cls));
    }

    public <T> zzaot<T> zzk(Class<T> cls) {
        return zza(zzapx.zzr(cls));
    }
}
