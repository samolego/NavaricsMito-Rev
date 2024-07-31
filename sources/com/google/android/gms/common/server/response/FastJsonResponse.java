package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class FastJsonResponse {

    /* loaded from: classes.dex */
    public static class Field<I, O> extends AbstractSafeParcelable {
        public static final com.google.android.gms.common.server.response.zza CREATOR = new com.google.android.gms.common.server.response.zza();

        /* renamed from: DA */
        protected final String f2919DA;

        /* renamed from: DB */
        private FieldMappingDictionary f2920DB;

        /* renamed from: DC */
        private zza<I, O> f2921DC;

        /* renamed from: Dt */
        protected final int f2922Dt;

        /* renamed from: Du */
        protected final boolean f2923Du;

        /* renamed from: Dv */
        protected final int f2924Dv;

        /* renamed from: Dw */
        protected final boolean f2925Dw;

        /* renamed from: Dx */
        protected final String f2926Dx;

        /* renamed from: Dy */
        protected final int f2927Dy;

        /* renamed from: Dz */
        protected final Class<? extends FastJsonResponse> f2928Dz;
        private final int mVersionCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(int i, int i2, boolean z, int i3, boolean z2, String str, int i4, String str2, ConverterWrapper converterWrapper) {
            this.mVersionCode = i;
            this.f2922Dt = i2;
            this.f2923Du = z;
            this.f2924Dv = i3;
            this.f2925Dw = z2;
            this.f2926Dx = str;
            this.f2927Dy = i4;
            zza<I, O> zzaVar = null;
            if (str2 == null) {
                this.f2928Dz = null;
                this.f2919DA = null;
            } else {
                this.f2928Dz = SafeParcelResponse.class;
                this.f2919DA = str2;
            }
            this.f2921DC = converterWrapper != null ? (zza<I, O>) converterWrapper.zzavo() : zzaVar;
        }

        protected Field(int i, boolean z, int i2, boolean z2, String str, int i3, Class<? extends FastJsonResponse> cls, zza<I, O> zzaVar) {
            this.mVersionCode = 1;
            this.f2922Dt = i;
            this.f2923Du = z;
            this.f2924Dv = i2;
            this.f2925Dw = z2;
            this.f2926Dx = str;
            this.f2927Dy = i3;
            this.f2928Dz = cls;
            this.f2919DA = cls == null ? null : cls.getCanonicalName();
            this.f2921DC = zzaVar;
        }

        public static Field zza(String str, int i, zza<?, ?> zzaVar, boolean z) {
            return new Field(zzaVar.zzavq(), z, zzaVar.zzavr(), false, str, i, null, zzaVar);
        }

        public static <T extends FastJsonResponse> Field<T, T> zza(String str, int i, Class<T> cls) {
            return new Field<>(11, false, 11, false, str, i, cls, null);
        }

        public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> zzb(String str, int i, Class<T> cls) {
            return new Field<>(11, true, 11, true, str, i, cls, null);
        }

        public static Field<Integer, Integer> zzk(String str, int i) {
            return new Field<>(0, false, 0, false, str, i, null, null);
        }

        public static Field<Boolean, Boolean> zzl(String str, int i) {
            return new Field<>(6, false, 6, false, str, i, null, null);
        }

        public static Field<String, String> zzm(String str, int i) {
            return new Field<>(7, false, 7, false, str, i, null, null);
        }

        public I convertBack(O o) {
            return this.f2921DC.convertBack(o);
        }

        public int getVersionCode() {
            return this.mVersionCode;
        }

        public String toString() {
            zzab.zza zzg = zzab.zzx(this).zzg("versionCode", Integer.valueOf(this.mVersionCode)).zzg("typeIn", Integer.valueOf(this.f2922Dt)).zzg("typeInArray", Boolean.valueOf(this.f2923Du)).zzg("typeOut", Integer.valueOf(this.f2924Dv)).zzg("typeOutArray", Boolean.valueOf(this.f2925Dw)).zzg("outputFieldName", this.f2926Dx).zzg("safeParcelFieldId", Integer.valueOf(this.f2927Dy)).zzg("concreteTypeName", zzawa());
            Class<? extends FastJsonResponse> zzavz = zzavz();
            if (zzavz != null) {
                zzg.zzg("concreteType.class", zzavz.getCanonicalName());
            }
            zza<I, O> zzaVar = this.f2921DC;
            if (zzaVar != null) {
                zzg.zzg("converterName", zzaVar.getClass().getCanonicalName());
            }
            return zzg.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            com.google.android.gms.common.server.response.zza zzaVar = CREATOR;
            com.google.android.gms.common.server.response.zza.zza(this, parcel, i);
        }

        public void zza(FieldMappingDictionary fieldMappingDictionary) {
            this.f2920DB = fieldMappingDictionary;
        }

        public int zzavq() {
            return this.f2922Dt;
        }

        public int zzavr() {
            return this.f2924Dv;
        }

        public boolean zzavv() {
            return this.f2923Du;
        }

        public boolean zzavw() {
            return this.f2925Dw;
        }

        public String zzavx() {
            return this.f2926Dx;
        }

        public int zzavy() {
            return this.f2927Dy;
        }

        public Class<? extends FastJsonResponse> zzavz() {
            return this.f2928Dz;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String zzawa() {
            String str = this.f2919DA;
            if (str == null) {
                return null;
            }
            return str;
        }

        public boolean zzawb() {
            return this.f2921DC != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ConverterWrapper zzawc() {
            zza<I, O> zzaVar = this.f2921DC;
            if (zzaVar == null) {
                return null;
            }
            return ConverterWrapper.zza(zzaVar);
        }

        public Map<String, Field<?, ?>> zzawd() {
            zzac.zzy(this.f2919DA);
            zzac.zzy(this.f2920DB);
            return this.f2920DB.zzie(this.f2919DA);
        }
    }

    /* loaded from: classes.dex */
    public interface zza<I, O> {
        I convertBack(O o);

        int zzavq();

        int zzavr();
    }

    private void zza(StringBuilder sb, Field field, Object obj) {
        String str;
        if (field.zzavq() == 11) {
            str = field.zzavz().cast(obj).toString();
        } else if (field.zzavq() != 7) {
            sb.append(obj);
            return;
        } else {
            sb.append("\"");
            sb.append(zzp.zzii((String) obj));
            str = "\"";
        }
        sb.append(str);
    }

    private void zza(StringBuilder sb, Field field, ArrayList<Object> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                zza(sb, field, obj);
            }
        }
        sb.append("]");
    }

    public String toString() {
        String str;
        String zzp;
        Map<String, Field<?, ?>> zzavs = zzavs();
        StringBuilder sb = new StringBuilder(100);
        for (String str2 : zzavs.keySet()) {
            Field<?, ?> field = zzavs.get(str2);
            if (zza(field)) {
                Object zza2 = zza(field, zzb(field));
                sb.append(sb.length() == 0 ? "{" : ",");
                sb.append("\"");
                sb.append(str2);
                sb.append("\":");
                if (zza2 != null) {
                    switch (field.zzavr()) {
                        case 8:
                            sb.append("\"");
                            zzp = com.google.android.gms.common.util.zzc.zzp((byte[]) zza2);
                            sb.append(zzp);
                            str = "\"";
                            break;
                        case 9:
                            sb.append("\"");
                            zzp = com.google.android.gms.common.util.zzc.zzq((byte[]) zza2);
                            sb.append(zzp);
                            str = "\"";
                            break;
                        case 10:
                            zzq.zza(sb, (HashMap) zza2);
                            break;
                        default:
                            if (field.zzavv()) {
                                zza(sb, (Field) field, (ArrayList) zza2);
                                break;
                            } else {
                                zza(sb, field, zza2);
                                break;
                            }
                    }
                } else {
                    str = "null";
                }
                sb.append(str);
            }
        }
        sb.append(sb.length() > 0 ? "}" : "{}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public <O, I> I zza(Field<I, O> field, Object obj) {
        return ((Field) field).f2921DC != null ? field.convertBack(obj) : obj;
    }

    protected boolean zza(Field field) {
        return field.zzavr() == 11 ? field.zzavw() ? zzid(field.zzavx()) : zzic(field.zzavx()) : zzib(field.zzavx());
    }

    public abstract Map<String, Field<?, ?>> zzavs();

    public HashMap<String, Object> zzavt() {
        return null;
    }

    public HashMap<String, Object> zzavu() {
        return null;
    }

    protected Object zzb(Field field) {
        String zzavx = field.zzavx();
        if (field.zzavz() != null) {
            zzac.zza(zzia(field.zzavx()) == null, "Concrete field shouldn't be value object: %s", field.zzavx());
            HashMap<String, Object> zzavu = field.zzavw() ? zzavu() : zzavt();
            if (zzavu != null) {
                return zzavu.get(zzavx);
            }
            try {
                char upperCase = Character.toUpperCase(zzavx.charAt(0));
                String valueOf = String.valueOf(zzavx.substring(1));
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 4);
                sb.append("get");
                sb.append(upperCase);
                sb.append(valueOf);
                return getClass().getMethod(sb.toString(), new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return zzia(field.zzavx());
    }

    protected abstract Object zzia(String str);

    protected abstract boolean zzib(String str);

    protected boolean zzic(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean zzid(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }
}
