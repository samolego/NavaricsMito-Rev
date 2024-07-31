package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public class ActivityRecognitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityRecognitionRequest> CREATOR = new zza();
    private long agA;
    private boolean agB;
    @Nullable
    private WorkSource agC;
    @Nullable
    private int[] agD;
    @Nullable
    private boolean agE;
    private final long agF;
    @Nullable

    /* renamed from: fs */
    private String f3390fs;
    @Nullable
    private String mTag;
    private final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityRecognitionRequest(int i, long j, boolean z, @Nullable WorkSource workSource, @Nullable String str, @Nullable int[] iArr, boolean z2, @Nullable String str2, long j2) {
        this.mVersionCode = i;
        this.agA = j;
        this.agB = z;
        this.agC = workSource;
        this.mTag = str;
        this.agD = iArr;
        this.agE = z2;
        this.f3390fs = str2;
        this.agF = j2;
    }

    @Nullable
    public String getAccountName() {
        return this.f3390fs;
    }

    public long getIntervalMillis() {
        return this.agA;
    }

    @Nullable
    public String getTag() {
        return this.mTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public boolean zzbox() {
        return this.agB;
    }

    @Nullable
    public WorkSource zzboy() {
        return this.agC;
    }

    @Nullable
    public int[] zzboz() {
        return this.agD;
    }

    public boolean zzbpa() {
        return this.agE;
    }

    public long zzbpb() {
        return this.agF;
    }
}
