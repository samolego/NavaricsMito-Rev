package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes.dex */
public class ConverterWrapper extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();

    /* renamed from: Dn */
    private final StringToIntConverter f2913Dn;
    private final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConverterWrapper(int i, StringToIntConverter stringToIntConverter) {
        this.mVersionCode = i;
        this.f2913Dn = stringToIntConverter;
    }

    private ConverterWrapper(StringToIntConverter stringToIntConverter) {
        this.mVersionCode = 1;
        this.f2913Dn = stringToIntConverter;
    }

    public static ConverterWrapper zza(FastJsonResponse.zza<?, ?> zzaVar) {
        if (zzaVar instanceof StringToIntConverter) {
            return new ConverterWrapper((StringToIntConverter) zzaVar);
        }
        throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.zza(this, parcel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringToIntConverter zzavn() {
        return this.f2913Dn;
    }

    public FastJsonResponse.zza<?, ?> zzavo() {
        StringToIntConverter stringToIntConverter = this.f2913Dn;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }
}
