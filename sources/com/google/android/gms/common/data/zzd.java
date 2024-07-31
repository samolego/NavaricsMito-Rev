package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* loaded from: classes.dex */
public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* renamed from: zM */
    private static final String[] f2733zM = {"data"};

    /* renamed from: zN */
    private final Parcelable.Creator<T> f2734zN;

    public zzd(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.f2734zN = creator;
    }

    public static <T extends SafeParcelable> void zza(DataHolder.zza zzaVar, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        zzaVar.zza(contentValues);
        obtain.recycle();
    }

    public static DataHolder.zza zzatd() {
        return DataHolder.zzc(f2733zM);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zzga */
    public T get(int i) {
        byte[] zzg = this.f2707xi.zzg("data", i, this.f2707xi.zzgb(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.f2734zN.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}
