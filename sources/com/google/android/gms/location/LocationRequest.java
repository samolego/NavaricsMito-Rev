package com.google.android.gms.location;

import android.os.Parcel;
import android.os.SystemClock;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.senseplay.sdk.tool.IniEditor;

/* loaded from: classes.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final LocationRequestCreator CREATOR = new LocationRequestCreator();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;

    /* renamed from: TN */
    boolean f3392TN;
    long agU;
    long ahp;
    long ahq;
    int ahr;
    float ahs;
    long aht;
    int mPriority;
    private final int mVersionCode;

    public LocationRequest() {
        this.mVersionCode = 1;
        this.mPriority = 102;
        this.ahp = 3600000L;
        this.ahq = 600000L;
        this.f3392TN = false;
        this.agU = Long.MAX_VALUE;
        this.ahr = Integer.MAX_VALUE;
        this.ahs = 0.0f;
        this.aht = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationRequest(int i, int i2, long j, long j2, boolean z, long j3, int i3, float f, long j4) {
        this.mVersionCode = i;
        this.mPriority = i2;
        this.ahp = j;
        this.ahq = j2;
        this.f3392TN = z;
        this.agU = j3;
        this.ahr = i3;
        this.ahs = f;
        this.aht = j4;
    }

    public static LocationRequest create() {
        return new LocationRequest();
    }

    private static void zzau(long j) {
        if (j >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("invalid interval: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    private static void zze(float f) {
        if (f >= 0.0f) {
            return;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f);
        throw new IllegalArgumentException(sb.toString());
    }

    private static void zzud(int i) {
        switch (i) {
            case 100:
            case 102:
            case 104:
            case 105:
                return;
            case 101:
            case 103:
            default:
                StringBuilder sb = new StringBuilder(28);
                sb.append("invalid quality: ");
                sb.append(i);
                throw new IllegalArgumentException(sb.toString());
        }
    }

    public static String zzue(int i) {
        switch (i) {
            case 100:
                return "PRIORITY_HIGH_ACCURACY";
            case 101:
            case 103:
            default:
                return "???";
            case 102:
                return "PRIORITY_BALANCED_POWER_ACCURACY";
            case 104:
                return "PRIORITY_LOW_POWER";
            case 105:
                return "PRIORITY_NO_POWER";
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            return this.mPriority == locationRequest.mPriority && this.ahp == locationRequest.ahp && this.ahq == locationRequest.ahq && this.f3392TN == locationRequest.f3392TN && this.agU == locationRequest.agU && this.ahr == locationRequest.ahr && this.ahs == locationRequest.ahs;
        }
        return false;
    }

    public long getExpirationTime() {
        return this.agU;
    }

    public long getFastestInterval() {
        return this.ahq;
    }

    public long getInterval() {
        return this.ahp;
    }

    public long getMaxWaitTime() {
        long j = this.aht;
        long j2 = this.ahp;
        return j < j2 ? j2 : j;
    }

    public int getNumUpdates() {
        return this.ahr;
    }

    public int getPriority() {
        return this.mPriority;
    }

    public float getSmallestDisplacement() {
        return this.ahs;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.mPriority), Long.valueOf(this.ahp), Long.valueOf(this.ahq), Boolean.valueOf(this.f3392TN), Long.valueOf(this.agU), Integer.valueOf(this.ahr), Float.valueOf(this.ahs));
    }

    public LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (j > Long.MAX_VALUE - elapsedRealtime) {
            this.agU = Long.MAX_VALUE;
        } else {
            this.agU = j + elapsedRealtime;
        }
        if (this.agU < 0) {
            this.agU = 0L;
        }
        return this;
    }

    public LocationRequest setExpirationTime(long j) {
        this.agU = j;
        if (this.agU < 0) {
            this.agU = 0L;
        }
        return this;
    }

    public LocationRequest setFastestInterval(long j) {
        zzau(j);
        this.f3392TN = true;
        this.ahq = j;
        return this;
    }

    public LocationRequest setInterval(long j) {
        zzau(j);
        this.ahp = j;
        if (!this.f3392TN) {
            this.ahq = (long) (this.ahp / 6.0d);
        }
        return this;
    }

    public LocationRequest setMaxWaitTime(long j) {
        zzau(j);
        this.aht = j;
        return this;
    }

    public LocationRequest setNumUpdates(int i) {
        if (i > 0) {
            this.ahr = i;
            return this;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("invalid numUpdates: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public LocationRequest setPriority(int i) {
        zzud(i);
        this.mPriority = i;
        return this;
    }

    public LocationRequest setSmallestDisplacement(float f) {
        zze(f);
        this.ahs = f;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        sb.append(zzue(this.mPriority));
        if (this.mPriority != 105) {
            sb.append(" requested=");
            sb.append(this.ahp);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.ahq);
        sb.append("ms");
        if (this.aht > this.ahp) {
            sb.append(" maxWait=");
            sb.append(this.aht);
            sb.append("ms");
        }
        long j = this.agU;
        if (j != Long.MAX_VALUE) {
            sb.append(" expireIn=");
            sb.append(j - SystemClock.elapsedRealtime());
            sb.append("ms");
        }
        if (this.ahr != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.ahr);
        }
        sb.append(IniEditor.Section.HEADER_END);
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        LocationRequestCreator.zza(this, parcel, i);
    }
}
