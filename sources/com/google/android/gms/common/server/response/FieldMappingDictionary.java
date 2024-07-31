package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: DD */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f2929DD;

    /* renamed from: DE */
    private final ArrayList<Entry> f2930DE = null;

    /* renamed from: DF */
    private final String f2931DF;
    private final int mVersionCode;

    /* loaded from: classes.dex */
    public static class Entry extends AbstractSafeParcelable {
        public static final zzd CREATOR = new zzd();

        /* renamed from: DG */
        final ArrayList<FieldMapPair> f2932DG;
        final String className;
        final int versionCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.f2932DG = arrayList;
        }

        Entry(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.f2932DG = zzau(map);
        }

        private static ArrayList<FieldMapPair> zzau(Map<String, FastJsonResponse.Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList<>();
            for (String str : map.keySet()) {
                arrayList.add(new FieldMapPair(str, map.get(str)));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzd zzdVar = CREATOR;
            zzd.zza(this, parcel, i);
        }

        HashMap<String, FastJsonResponse.Field<?, ?>> zzawh() {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            int size = this.f2932DG.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = this.f2932DG.get(i);
                hashMap.put(fieldMapPair.zzcb, fieldMapPair.f2933DH);
            }
            return hashMap;
        }
    }

    /* loaded from: classes.dex */
    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final zzb CREATOR = new zzb();

        /* renamed from: DH */
        final FastJsonResponse.Field<?, ?> f2933DH;
        final int versionCode;
        final String zzcb;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FieldMapPair(int i, String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = i;
            this.zzcb = str;
            this.f2933DH = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = 1;
            this.zzcb = str;
            this.f2933DH = field;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzb zzbVar = CREATOR;
            zzb.zza(this, parcel, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.f2929DD = zzi(arrayList);
        this.f2931DF = (String) zzac.zzy(str);
        zzawe();
    }

    private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzi(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = arrayList.get(i);
            hashMap.put(entry.className, entry.zzawh());
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f2929DD.keySet()) {
            sb.append(str);
            sb.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f2929DD.get(str);
            for (String str2 : map.keySet()) {
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(map.get(str2));
            }
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzc zzcVar = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public void zzawe() {
        for (String str : this.f2929DD.keySet()) {
            Map<String, FastJsonResponse.Field<?, ?>> map = this.f2929DD.get(str);
            for (String str2 : map.keySet()) {
                map.get(str2).zza(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Entry> zzawf() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.f2929DD.keySet()) {
            arrayList.add(new Entry(str, this.f2929DD.get(str)));
        }
        return arrayList;
    }

    public String zzawg() {
        return this.f2931DF;
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzie(String str) {
        return this.f2929DD.get(str);
    }
}
