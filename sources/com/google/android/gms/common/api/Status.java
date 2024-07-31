package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

/* loaded from: classes.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;

    /* renamed from: rR */
    private final int f2691rR;

    /* renamed from: uK */
    private final String f2692uK;

    /* renamed from: vY */
    public static final Status f2684vY = new Status(0);

    /* renamed from: vZ */
    public static final Status f2685vZ = new Status(14);

    /* renamed from: wa */
    public static final Status f2686wa = new Status(8);

    /* renamed from: wb */
    public static final Status f2687wb = new Status(15);

    /* renamed from: wc */
    public static final Status f2688wc = new Status(16);

    /* renamed from: wd */
    public static final Status f2689wd = new Status(17);

    /* renamed from: we */
    public static final Status f2690we = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new zzh();

    public Status(int i) {
        this(i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.f2691rR = i2;
        this.f2692uK = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzaqi() {
        String str = this.f2692uK;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.f2691rR);
    }

    public boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.mVersionCode == status.mVersionCode && this.f2691rR == status.f2691rR && zzab.equal(this.f2692uK, status.f2692uK) && zzab.equal(this.mPendingIntent, status.mPendingIntent);
        }
        return false;
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.f2691rR;
    }

    @Nullable
    public String getStatusMessage() {
        return this.f2692uK;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.f2691rR), this.f2692uK, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.f2691rR == 16;
    }

    public boolean isInterrupted() {
        return this.f2691rR == 14;
    }

    public boolean isSuccess() {
        return this.f2691rR <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzab.zzx(this).zzg("statusCode", zzaqi()).zzg("resolution", this.mPendingIntent).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PendingIntent zzaqh() {
        return this.mPendingIntent;
    }
}
