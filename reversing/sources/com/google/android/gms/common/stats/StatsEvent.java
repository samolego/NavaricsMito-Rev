package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        long timeMillis = getTimeMillis();
        String valueOf = String.valueOf("\t");
        int eventType = getEventType();
        String valueOf2 = String.valueOf("\t");
        long zzawq = zzawq();
        String valueOf3 = String.valueOf(zzawt());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length());
        sb.append(timeMillis);
        sb.append(valueOf);
        sb.append(eventType);
        sb.append(valueOf2);
        sb.append(zzawq);
        sb.append(valueOf3);
        return sb.toString();
    }

    public abstract long zzawq();

    public abstract String zzawt();
}
