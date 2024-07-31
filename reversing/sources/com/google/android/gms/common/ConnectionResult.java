package com.google.android.gms.common;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;

/* loaded from: classes.dex */
public final class ConnectionResult extends AbstractSafeParcelable {
    public static final int API_UNAVAILABLE = 16;
    public static final int CANCELED = 13;
    public static final int DEVELOPER_ERROR = 10;
    @Deprecated
    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 15;
    public static final int INVALID_ACCOUNT = 5;
    public static final int LICENSE_CHECK_FAILED = 11;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    public static final int RESTRICTED_PROFILE = 20;
    public static final int SERVICE_DISABLED = 3;
    public static final int SERVICE_INVALID = 9;
    public static final int SERVICE_MISSING = 1;
    public static final int SERVICE_MISSING_PERMISSION = 19;
    public static final int SERVICE_UPDATING = 18;
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_FAILED = 17;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int TIMEOUT = 14;
    private final PendingIntent mPendingIntent;
    final int mVersionCode;

    /* renamed from: rR */
    private final int f2639rR;

    /* renamed from: uK */
    private final String f2640uK;

    /* renamed from: uJ */
    public static final ConnectionResult f2638uJ = new ConnectionResult(0);
    public static final Parcelable.Creator<ConnectionResult> CREATOR = new zzb();

    public ConnectionResult(int i) {
        this(i, null, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionResult(int i, int i2, PendingIntent pendingIntent, String str) {
        this.mVersionCode = i;
        this.f2639rR = i2;
        this.mPendingIntent = pendingIntent;
        this.f2640uK = str;
    }

    public ConnectionResult(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public ConnectionResult(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String getStatusString(int i) {
        if (i != 42) {
            if (i != 99) {
                if (i != 1500) {
                    switch (i) {
                        case -1:
                            return "UNKNOWN";
                        case 0:
                            return "SUCCESS";
                        case 1:
                            return "SERVICE_MISSING";
                        case 2:
                            return "SERVICE_VERSION_UPDATE_REQUIRED";
                        case 3:
                            return "SERVICE_DISABLED";
                        case 4:
                            return "SIGN_IN_REQUIRED";
                        case 5:
                            return "INVALID_ACCOUNT";
                        case 6:
                            return "RESOLUTION_REQUIRED";
                        case 7:
                            return "NETWORK_ERROR";
                        case 8:
                            return "INTERNAL_ERROR";
                        case 9:
                            return "SERVICE_INVALID";
                        case 10:
                            return "DEVELOPER_ERROR";
                        case 11:
                            return "LICENSE_CHECK_FAILED";
                        default:
                            switch (i) {
                                case 13:
                                    return "CANCELED";
                                case 14:
                                    return "TIMEOUT";
                                case 15:
                                    return "INTERRUPTED";
                                case 16:
                                    return "API_UNAVAILABLE";
                                case 17:
                                    return "SIGN_IN_FAILED";
                                case 18:
                                    return "SERVICE_UPDATING";
                                case 19:
                                    return "SERVICE_MISSING_PERMISSION";
                                case 20:
                                    return "RESTRICTED_PROFILE";
                                case 21:
                                    return "API_VERSION_UPDATE_REQUIRED";
                                default:
                                    StringBuilder sb = new StringBuilder(31);
                                    sb.append("UNKNOWN_ERROR_CODE(");
                                    sb.append(i);
                                    sb.append(")");
                                    return sb.toString();
                            }
                    }
                }
                return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
            }
            return "UNFINISHED";
        }
        return "UPDATE_ANDROID_WEAR";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ConnectionResult) {
            ConnectionResult connectionResult = (ConnectionResult) obj;
            return this.f2639rR == connectionResult.f2639rR && zzab.equal(this.mPendingIntent, connectionResult.mPendingIntent) && zzab.equal(this.f2640uK, connectionResult.f2640uK);
        }
        return false;
    }

    public int getErrorCode() {
        return this.f2639rR;
    }

    @Nullable
    public String getErrorMessage() {
        return this.f2640uK;
    }

    @Nullable
    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public boolean hasResolution() {
        return (this.f2639rR == 0 || this.mPendingIntent == null) ? false : true;
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.f2639rR), this.mPendingIntent, this.f2640uK);
    }

    public boolean isSuccess() {
        return this.f2639rR == 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzab.zzx(this).zzg("statusCode", getStatusString(this.f2639rR)).zzg("resolution", this.mPendingIntent).zzg("message", this.f2640uK).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
