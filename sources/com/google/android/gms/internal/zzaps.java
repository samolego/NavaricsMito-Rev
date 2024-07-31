package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzaps implements zzaou {
    private final zzapb bkM;
    private final zzapc bkV;
    private final zzaoa bkX;

    /* loaded from: classes.dex */
    public static final class zza<T> extends zzaot<T> {
        private final Map<String, zzb> bmM;
        private final zzapg<T> bmt;

        private zza(zzapg<T> zzapgVar, Map<String, zzb> map) {
            this.bmt = zzapgVar;
            this.bmM = map;
        }

        @Override // com.google.android.gms.internal.zzaot
        public void zza(zzaqa zzaqaVar, T t) throws IOException {
            if (t == null) {
                zzaqaVar.mo9616bx();
                return;
            }
            zzaqaVar.mo9618bv();
            try {
                for (zzb zzbVar : this.bmM.values()) {
                    if (zzbVar.zzct(t)) {
                        zzaqaVar.zzus(zzbVar.name);
                        zzbVar.zza(zzaqaVar, t);
                    }
                }
                zzaqaVar.mo9617bw();
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            }
        }

        @Override // com.google.android.gms.internal.zzaot
        public T zzb(zzapy zzapyVar) throws IOException {
            if (zzapyVar.mo9627bn() == zzapz.NULL) {
                zzapyVar.nextNull();
                return null;
            }
            T mo9646bg = this.bmt.mo9646bg();
            try {
                zzapyVar.beginObject();
                while (zzapyVar.hasNext()) {
                    zzb zzbVar = this.bmM.get(zzapyVar.nextName());
                    if (zzbVar != null && zzbVar.bmO) {
                        zzbVar.zza(zzapyVar, mo9646bg);
                    }
                    zzapyVar.skipValue();
                }
                zzapyVar.endObject();
                return mo9646bg;
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (IllegalStateException e2) {
                throw new zzaoq(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class zzb {
        final boolean bmN;
        final boolean bmO;
        final String name;

        protected zzb(String str, boolean z, boolean z2) {
            this.name = str;
            this.bmN = z;
            this.bmO = z2;
        }

        abstract void zza(zzapy zzapyVar, Object obj) throws IOException, IllegalAccessException;

        abstract void zza(zzaqa zzaqaVar, Object obj) throws IOException, IllegalAccessException;

        abstract boolean zzct(Object obj) throws IOException, IllegalAccessException;
    }

    public zzaps(zzapb zzapbVar, zzaoa zzaoaVar, zzapc zzapcVar) {
        this.bkM = zzapbVar;
        this.bkX = zzaoaVar;
        this.bkV = zzapcVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zzaot<?> zza(zzaob zzaobVar, Field field, zzapx<?> zzapxVar) {
        zzaot<?> zza2;
        zzaov zzaovVar = (zzaov) field.getAnnotation(zzaov.class);
        return (zzaovVar == null || (zza2 = zzapn.zza(this.bkM, zzaobVar, zzapxVar, zzaovVar)) == null) ? zzaobVar.zza(zzapxVar) : zza2;
    }

    private zzb zza(final zzaob zzaobVar, final Field field, String str, final zzapx<?> zzapxVar, boolean z, boolean z2) {
        final boolean zzk = zzaph.zzk(zzapxVar.m9638by());
        return new zzb(str, z, z2) { // from class: com.google.android.gms.internal.zzaps.1
            final zzaot<?> bmG;

            {
                this.bmG = zzaps.this.zza(zzaobVar, field, zzapxVar);
            }

            @Override // com.google.android.gms.internal.zzaps.zzb
            void zza(zzapy zzapyVar, Object obj) throws IOException, IllegalAccessException {
                Object zzb2 = this.bmG.zzb(zzapyVar);
                if (zzb2 == null && zzk) {
                    return;
                }
                field.set(obj, zzb2);
            }

            @Override // com.google.android.gms.internal.zzaps.zzb
            void zza(zzaqa zzaqaVar, Object obj) throws IOException, IllegalAccessException {
                new zzapv(zzaobVar, this.bmG, zzapxVar.m9637bz()).zza(zzaqaVar, field.get(obj));
            }

            @Override // com.google.android.gms.internal.zzaps.zzb
            public boolean zzct(Object obj) throws IOException, IllegalAccessException {
                return this.bmN && field.get(obj) != obj;
            }
        };
    }

    static List<String> zza(zzaoa zzaoaVar, Field field) {
        zzaow zzaowVar = (zzaow) field.getAnnotation(zzaow.class);
        LinkedList linkedList = new LinkedList();
        if (zzaowVar == null) {
            linkedList.add(zzaoaVar.zzc(field));
        } else {
            linkedList.add(zzaowVar.value());
            String[] m9654be = zzaowVar.m9654be();
            for (String str : m9654be) {
                linkedList.add(str);
            }
        }
        return linkedList;
    }

    private Map<String, zzb> zza(zzaob zzaobVar, zzapx<?> zzapxVar, Class<?> cls) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (cls.isInterface()) {
            return linkedHashMap;
        }
        Type m9637bz = zzapxVar.m9637bz();
        zzapx<?> zzapxVar2 = zzapxVar;
        Class<?> cls2 = cls;
        while (cls2 != Object.class) {
            Field[] declaredFields = cls2.getDeclaredFields();
            int length = declaredFields.length;
            boolean z = false;
            int i = 0;
            while (i < length) {
                Field field = declaredFields[i];
                boolean zza2 = zza(field, true);
                boolean zza3 = zza(field, z);
                if (zza2 || zza3) {
                    field.setAccessible(true);
                    Type zza4 = zzapa.zza(zzapxVar2.m9637bz(), cls2, field.getGenericType());
                    List<String> zzd = zzd(field);
                    zzb zzbVar = null;
                    int i2 = 0;
                    while (i2 < zzd.size()) {
                        String str = zzd.get(i2);
                        boolean z2 = i2 != 0 ? false : zza2;
                        zzb zzbVar2 = zzbVar;
                        int i3 = i2;
                        List<String> list = zzd;
                        Field field2 = field;
                        zzbVar = zzbVar2 == null ? (zzb) linkedHashMap.put(str, zza(zzaobVar, field, str, zzapx.zzl(zza4), z2, zza3)) : zzbVar2;
                        i2 = i3 + 1;
                        zza2 = z2;
                        zzd = list;
                        field = field2;
                    }
                    zzb zzbVar3 = zzbVar;
                    if (zzbVar3 != null) {
                        String valueOf = String.valueOf(m9637bz);
                        String str2 = zzbVar3.name;
                        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(str2).length());
                        sb.append(valueOf);
                        sb.append(" declares multiple JSON fields named ");
                        sb.append(str2);
                        throw new IllegalArgumentException(sb.toString());
                    }
                }
                i++;
                z = false;
            }
            zzapxVar2 = zzapx.zzl(zzapa.zza(zzapxVar2.m9637bz(), cls2, cls2.getGenericSuperclass()));
            cls2 = zzapxVar2.m9638by();
        }
        return linkedHashMap;
    }

    static boolean zza(Field field, boolean z, zzapc zzapcVar) {
        return (zzapcVar.zza(field.getType(), z) || zzapcVar.zza(field, z)) ? false : true;
    }

    private List<String> zzd(Field field) {
        return zza(this.bkX, field);
    }

    @Override // com.google.android.gms.internal.zzaou
    public <T> zzaot<T> zza(zzaob zzaobVar, zzapx<T> zzapxVar) {
        Class<? super T> m9638by = zzapxVar.m9638by();
        if (Object.class.isAssignableFrom(m9638by)) {
            return new zza(this.bkM.zzb(zzapxVar), zza(zzaobVar, (zzapx<?>) zzapxVar, (Class<?>) m9638by));
        }
        return null;
    }

    public boolean zza(Field field, boolean z) {
        return zza(field, z, this.bkV);
    }
}
