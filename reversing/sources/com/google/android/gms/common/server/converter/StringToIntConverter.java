package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();

    /* renamed from: Do */
    private final HashMap<String, Integer> f2914Do;

    /* renamed from: Dp */
    private final SparseArray<String> f2915Dp;

    /* renamed from: Dq */
    private final ArrayList<Entry> f2916Dq;
    private final int mVersionCode;

    /* loaded from: classes.dex */
    public static final class Entry extends AbstractSafeParcelable {
        public static final zzc CREATOR = new zzc();

        /* renamed from: Dr */
        final String f2917Dr;

        /* renamed from: Ds */
        final int f2918Ds;
        final int versionCode;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.f2917Dr = str;
            this.f2918Ds = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.f2917Dr = str;
            this.f2918Ds = i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            zzc zzcVar = CREATOR;
            zzc.zza(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.f2914Do = new HashMap<>();
        this.f2915Dp = new SparseArray<>();
        this.f2916Dq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.f2914Do = new HashMap<>();
        this.f2915Dp = new SparseArray<>();
        this.f2916Dq = null;
        zzh(arrayList);
    }

    private void zzh(ArrayList<Entry> arrayList) {
        Iterator<Entry> it = arrayList.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            zzj(next.f2917Dr, next.f2918Ds);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb zzbVar = CREATOR;
        zzb.zza(this, parcel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<Entry> zzavp() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String str : this.f2914Do.keySet()) {
            arrayList.add(new Entry(str, this.f2914Do.get(str).intValue()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzavq() {
        return 7;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    public int zzavr() {
        return 0;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.zza
    /* renamed from: zzd */
    public String convertBack(Integer num) {
        String str = this.f2915Dp.get(num.intValue());
        return (str == null && this.f2914Do.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    public StringToIntConverter zzj(String str, int i) {
        this.f2914Do.put(str, Integer.valueOf(i));
        this.f2915Dp.put(i, str);
        return this;
    }
}
