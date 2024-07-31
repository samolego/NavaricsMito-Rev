package com.google.android.gms.location.internal;

import android.annotation.SuppressLint;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.Geofence;
import java.util.Locale;

/* loaded from: classes.dex */
public class ParcelableGeofence extends AbstractSafeParcelable implements Geofence {
    public static final zzo CREATOR = new zzo();
    private final int agT;
    private final short agV;
    private final double agW;
    private final double agX;
    private final float agY;
    private final int agZ;
    private final int aha;
    private final long ain;
    private final int mVersionCode;
    private final String zzcaj;

    public ParcelableGeofence(int i, String str, int i2, short s, double d, double d2, float f, long j, int i3, int i4) {
        zzkz(str);
        zzf(f);
        zza(d, d2);
        int zzuq = zzuq(i2);
        this.mVersionCode = i;
        this.agV = s;
        this.zzcaj = str;
        this.agW = d;
        this.agX = d2;
        this.agY = f;
        this.ain = j;
        this.agT = zzuq;
        this.agZ = i3;
        this.aha = i4;
    }

    public ParcelableGeofence(String str, int i, short s, double d, double d2, float f, long j, int i2, int i3) {
        this(1, str, i, s, d, d2, f, j, i2, i3);
    }

    private static void zza(double d, double d2) {
        if (d > 90.0d || d < -90.0d) {
            StringBuilder sb = new StringBuilder(42);
            sb.append("invalid latitude: ");
            sb.append(d);
            throw new IllegalArgumentException(sb.toString());
        } else if (d2 > 180.0d || d2 < -180.0d) {
            StringBuilder sb2 = new StringBuilder(43);
            sb2.append("invalid longitude: ");
            sb2.append(d2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    private static void zzf(float f) {
        if (f > 0.0f) {
            return;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("invalid radius: ");
        sb.append(f);
        throw new IllegalArgumentException(sb.toString());
    }

    private static void zzkz(String str) {
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "requestId is null or too long: ".concat(valueOf) : new String("requestId is null or too long: "));
        }
    }

    private static int zzuq(int i) {
        int i2 = i & 7;
        if (i2 != 0) {
            return i2;
        }
        StringBuilder sb = new StringBuilder(46);
        sb.append("No supported transition specified: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    @SuppressLint({"DefaultLocale"})
    private static String zzur(int i) {
        if (i != 1) {
            return null;
        }
        return "CIRCLE";
    }

    public static ParcelableGeofence zzv(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        ParcelableGeofence parcelableGeofence = (ParcelableGeofence) CREATOR.createFromParcel(obtain);
        obtain.recycle();
        return parcelableGeofence;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ParcelableGeofence)) {
            ParcelableGeofence parcelableGeofence = (ParcelableGeofence) obj;
            return this.agY == parcelableGeofence.agY && this.agW == parcelableGeofence.agW && this.agX == parcelableGeofence.agX && this.agV == parcelableGeofence.agV;
        }
        return false;
    }

    public long getExpirationTime() {
        return this.ain;
    }

    public double getLatitude() {
        return this.agW;
    }

    public double getLongitude() {
        return this.agX;
    }

    public float getRadius() {
        return this.agY;
    }

    @Override // com.google.android.gms.location.Geofence
    public String getRequestId() {
        return this.zzcaj;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.agW);
        long doubleToLongBits2 = Double.doubleToLongBits(this.agX);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31) + Float.floatToIntBits(this.agY)) * 31) + this.agV) * 31) + this.agT;
    }

    public String toString() {
        return String.format(Locale.US, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", zzur(this.agV), this.zzcaj, Integer.valueOf(this.agT), Double.valueOf(this.agW), Double.valueOf(this.agX), Float.valueOf(this.agY), Integer.valueOf(this.agZ / 1000), Integer.valueOf(this.aha), Long.valueOf(this.ain));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzo zzoVar = CREATOR;
        zzo.zza(this, parcel, i);
    }

    public short zzbpq() {
        return this.agV;
    }

    public int zzbpr() {
        return this.agT;
    }

    public int zzbps() {
        return this.agZ;
    }

    public int zzbpt() {
        return this.aha;
    }
}
