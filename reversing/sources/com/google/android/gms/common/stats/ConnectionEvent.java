package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class ConnectionEvent extends StatsEvent {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();

    /* renamed from: DM */
    private final long f2939DM;

    /* renamed from: DN */
    private int f2940DN;

    /* renamed from: DO */
    private final String f2941DO;

    /* renamed from: DP */
    private final String f2942DP;

    /* renamed from: DQ */
    private final String f2943DQ;

    /* renamed from: DR */
    private final String f2944DR;

    /* renamed from: DS */
    private final String f2945DS;

    /* renamed from: DT */
    private final String f2946DT;

    /* renamed from: DU */
    private final long f2947DU;

    /* renamed from: DV */
    private final long f2948DV;

    /* renamed from: DW */
    private long f2949DW;
    final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.f2939DM = j;
        this.f2940DN = i2;
        this.f2941DO = str;
        this.f2942DP = str2;
        this.f2943DQ = str3;
        this.f2944DR = str4;
        this.f2949DW = -1L;
        this.f2945DS = str5;
        this.f2946DT = str6;
        this.f2947DU = j2;
        this.f2948DV = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public int getEventType() {
        return this.f2940DN;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long getTimeMillis() {
        return this.f2939DM;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzawk() {
        return this.f2941DO;
    }

    public String zzawl() {
        return this.f2942DP;
    }

    public String zzawm() {
        return this.f2943DQ;
    }

    public String zzawn() {
        return this.f2944DR;
    }

    public String zzawo() {
        return this.f2945DS;
    }

    public String zzawp() {
        return this.f2946DT;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long zzawq() {
        return this.f2949DW;
    }

    public long zzawr() {
        return this.f2948DV;
    }

    public long zzaws() {
        return this.f2947DU;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public String zzawt() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(zzawk());
        String valueOf3 = String.valueOf(zzawl());
        String valueOf4 = String.valueOf("\t");
        String valueOf5 = String.valueOf(zzawm());
        String valueOf6 = String.valueOf(zzawn());
        String valueOf7 = String.valueOf("\t");
        String str = this.f2945DS;
        if (str == null) {
            str = "";
        }
        String valueOf8 = String.valueOf("\t");
        long zzawr = zzawr();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str).length() + String.valueOf(valueOf8).length());
        sb.append(valueOf);
        sb.append(valueOf2);
        sb.append("/");
        sb.append(valueOf3);
        sb.append(valueOf4);
        sb.append(valueOf5);
        sb.append("/");
        sb.append(valueOf6);
        sb.append(valueOf7);
        sb.append(str);
        sb.append(valueOf8);
        sb.append(zzawr);
        return sb.toString();
    }
}
