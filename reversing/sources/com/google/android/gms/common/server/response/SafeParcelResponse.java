package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final zze CREATOR = new zze();

    /* renamed from: DB */
    private final FieldMappingDictionary f2934DB;

    /* renamed from: DI */
    private final Parcel f2935DI;

    /* renamed from: DJ */
    private final int f2936DJ = 2;

    /* renamed from: DK */
    private int f2937DK;

    /* renamed from: DL */
    private int f2938DL;
    private final String mClassName;
    private final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = i;
        this.f2935DI = (Parcel) zzac.zzy(parcel);
        this.f2934DB = fieldMappingDictionary;
        FieldMappingDictionary fieldMappingDictionary2 = this.f2934DB;
        this.mClassName = fieldMappingDictionary2 == null ? null : fieldMappingDictionary2.zzawg();
        this.f2937DK = 2;
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        String zzii;
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"");
                zzii = zzp.zzii(obj.toString());
                break;
            case 8:
                sb.append("\"");
                zzii = com.google.android.gms.common.util.zzc.zzp((byte[]) obj);
                break;
            case 9:
                sb.append("\"");
                zzii = com.google.android.gms.common.util.zzc.zzq((byte[]) obj);
                break;
            case 10:
                zzq.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("Unknown type = ");
                sb2.append(i);
                throw new IllegalArgumentException(sb2.toString());
        }
        sb.append(zzii);
        sb.append("\"");
    }

    private void zza(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        Object valueOf;
        switch (field.zzavr()) {
            case 0:
                valueOf = Integer.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i));
                break;
            case 1:
                valueOf = com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i);
                break;
            case 2:
                valueOf = Long.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i));
                break;
            case 3:
                valueOf = Float.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i));
                break;
            case 4:
                valueOf = Double.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i));
                break;
            case 5:
                valueOf = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i);
                break;
            case 6:
                valueOf = Boolean.valueOf(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i));
                break;
            case 7:
                valueOf = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i);
                break;
            case 8:
            case 9:
                valueOf = com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, i);
                break;
            case 10:
                valueOf = zzq(com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, i));
                break;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                int zzavr = field.zzavr();
                StringBuilder sb2 = new StringBuilder(36);
                sb2.append("Unknown field out type = ");
                sb2.append(zzavr);
                throw new IllegalArgumentException(sb2.toString());
        }
        zzb(sb, field, zza(field, valueOf));
    }

    private void zza(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"");
        sb.append(str);
        sb.append("\":");
        if (field.zzawb()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzav = zzav(map);
        sb.append('{');
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            Map.Entry<String, FastJsonResponse.Field<?, ?>> entry = zzav.get(com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, entry.getKey(), entry.getValue(), parcel, zzcp);
                z = true;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            sb.append('}');
            return;
        }
        StringBuilder sb2 = new StringBuilder(37);
        sb2.append("Overread allowed size end=");
        sb2.append(zzcq);
        throw new zza.C3234zza(sb2.toString(), parcel);
    }

    private static SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzav(Map<String, FastJsonResponse.Field<?, ?>> map) {
        SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> sparseArray = new SparseArray<>();
        for (Map.Entry<String, FastJsonResponse.Field<?, ?>> entry : map.entrySet()) {
            sparseArray.put(entry.getValue().zzavy(), entry);
        }
        return sparseArray;
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        Object zzk;
        String zzii;
        String str;
        Object[] zzy;
        if (field.zzavw()) {
            sb.append("[");
            switch (field.zzavr()) {
                case 0:
                    com.google.android.gms.common.util.zzb.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzw(parcel, i));
                    break;
                case 1:
                    zzy = com.google.android.gms.common.internal.safeparcel.zza.zzy(parcel, i);
                    com.google.android.gms.common.util.zzb.zza(sb, zzy);
                    break;
                case 2:
                    com.google.android.gms.common.util.zzb.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzx(parcel, i));
                    break;
                case 3:
                    com.google.android.gms.common.util.zzb.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzz(parcel, i));
                    break;
                case 4:
                    com.google.android.gms.common.util.zzb.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzaa(parcel, i));
                    break;
                case 5:
                    zzy = com.google.android.gms.common.internal.safeparcel.zza.zzab(parcel, i);
                    com.google.android.gms.common.util.zzb.zza(sb, zzy);
                    break;
                case 6:
                    com.google.android.gms.common.util.zzb.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzv(parcel, i));
                    break;
                case 7:
                    com.google.android.gms.common.util.zzb.zza(sb, com.google.android.gms.common.internal.safeparcel.zza.zzac(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzag = com.google.android.gms.common.internal.safeparcel.zza.zzag(parcel, i);
                    int length = zzag.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        zzag[i2].setDataPosition(0);
                        zza(sb, field.zzawd(), zzag[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            str = "]";
        } else {
            switch (field.zzavr()) {
                case 0:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, i));
                    return;
                case 1:
                    zzk = com.google.android.gms.common.internal.safeparcel.zza.zzk(parcel, i);
                    sb.append(zzk);
                    return;
                case 2:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, i));
                    return;
                case 3:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzl(parcel, i));
                    return;
                case 4:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzn(parcel, i));
                    return;
                case 5:
                    zzk = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, i);
                    sb.append(zzk);
                    return;
                case 6:
                    sb.append(com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, i));
                    return;
                case 7:
                    String zzq = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, i);
                    sb.append("\"");
                    zzii = zzp.zzii(zzq);
                    sb.append(zzii);
                    str = "\"";
                    break;
                case 8:
                    byte[] zzt = com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, i);
                    sb.append("\"");
                    zzii = com.google.android.gms.common.util.zzc.zzp(zzt);
                    sb.append(zzii);
                    str = "\"";
                    break;
                case 9:
                    byte[] zzt2 = com.google.android.gms.common.internal.safeparcel.zza.zzt(parcel, i);
                    sb.append("\"");
                    zzii = com.google.android.gms.common.util.zzc.zzq(zzt2);
                    sb.append(zzii);
                    str = "\"";
                    break;
                case 10:
                    Bundle zzs = com.google.android.gms.common.internal.safeparcel.zza.zzs(parcel, i);
                    Set<String> keySet = zzs.keySet();
                    keySet.size();
                    sb.append("{");
                    boolean z = true;
                    for (String str2 : keySet) {
                        if (!z) {
                            sb.append(",");
                        }
                        sb.append("\"");
                        sb.append(str2);
                        sb.append("\"");
                        sb.append(":");
                        sb.append("\"");
                        sb.append(zzp.zzii(zzs.getString(str2)));
                        sb.append("\"");
                        z = false;
                    }
                    str = "}";
                    break;
                case 11:
                    Parcel zzaf = com.google.android.gms.common.internal.safeparcel.zza.zzaf(parcel, i);
                    zzaf.setDataPosition(0);
                    zza(sb, field.zzawd(), zzaf);
                    return;
                default:
                    throw new IllegalStateException("Unknown field type out");
            }
        }
        sb.append(str);
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzavv()) {
            zzb(sb, field, (ArrayList) obj);
        } else {
            zza(sb, field.zzavq(), obj);
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzavq(), arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzq(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public String toString() {
        zzac.zzb(this.f2934DB, "Cannot convert to JSON on client side.");
        Parcel zzawi = zzawi();
        zzawi.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.f2934DB.zzie(this.mClassName), zzawi);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zze zzeVar = CREATOR;
        zze.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> zzavs() {
        FieldMappingDictionary fieldMappingDictionary = this.f2934DB;
        if (fieldMappingDictionary == null) {
            return null;
        }
        return fieldMappingDictionary.zzie(this.mClassName);
    }

    public Parcel zzawi() {
        switch (this.f2937DK) {
            case 0:
                this.f2938DL = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(this.f2935DI);
            case 1:
                com.google.android.gms.common.internal.safeparcel.zzb.zzaj(this.f2935DI, this.f2938DL);
                this.f2937DK = 2;
                break;
        }
        return this.f2935DI;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMappingDictionary zzawj() {
        int i = this.f2936DJ;
        switch (i) {
            case 0:
                return null;
            case 1:
                return this.f2934DB;
            case 2:
                return this.f2934DB;
            default:
                StringBuilder sb = new StringBuilder(34);
                sb.append("Invalid creation type: ");
                sb.append(i);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public Object zzia(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    @Override // com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse, com.google.android.gms.common.server.response.FastJsonResponse
    public boolean zzib(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
}
