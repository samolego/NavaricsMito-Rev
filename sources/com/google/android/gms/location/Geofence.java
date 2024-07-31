package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.location.internal.ParcelableGeofence;

/* loaded from: classes.dex */
public interface Geofence {
    public static final int GEOFENCE_TRANSITION_DWELL = 4;
    public static final int GEOFENCE_TRANSITION_ENTER = 1;
    public static final int GEOFENCE_TRANSITION_EXIT = 2;
    public static final long NEVER_EXPIRE = -1;

    /* loaded from: classes.dex */
    public static final class Builder {
        private double agW;
        private double agX;
        private float agY;
        private String zzcaj = null;
        private int agT = 0;
        private long agU = Long.MIN_VALUE;
        private short agV = -1;
        private int agZ = 0;
        private int aha = -1;

        public Geofence build() {
            if (this.zzcaj != null) {
                int i = this.agT;
                if (i != 0) {
                    if ((i & 4) == 0 || this.aha >= 0) {
                        long j = this.agU;
                        if (j != Long.MIN_VALUE) {
                            if (this.agV != -1) {
                                int i2 = this.agZ;
                                if (i2 >= 0) {
                                    return new ParcelableGeofence(this.zzcaj, this.agT, (short) 1, this.agW, this.agX, this.agY, j, i2, this.aha);
                                }
                                throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
                            }
                            throw new IllegalArgumentException("Geofence region not set.");
                        }
                        throw new IllegalArgumentException("Expiration not set.");
                    }
                    throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
                }
                throw new IllegalArgumentException("Transitions types not set.");
            }
            throw new IllegalArgumentException("Request ID not set.");
        }

        public Builder setCircularRegion(double d, double d2, float f) {
            this.agV = (short) 1;
            this.agW = d;
            this.agX = d2;
            this.agY = f;
            return this;
        }

        public Builder setExpirationDuration(long j) {
            if (j < 0) {
                this.agU = -1L;
            } else {
                this.agU = SystemClock.elapsedRealtime() + j;
            }
            return this;
        }

        public Builder setLoiteringDelay(int i) {
            this.aha = i;
            return this;
        }

        public Builder setNotificationResponsiveness(int i) {
            this.agZ = i;
            return this;
        }

        public Builder setRequestId(String str) {
            this.zzcaj = str;
            return this;
        }

        public Builder setTransitionTypes(int i) {
            this.agT = i;
            return this;
        }
    }

    String getRequestId();
}
