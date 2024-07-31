package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

/* loaded from: classes.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new zzg();

    /* renamed from: DM */
    private final long f2950DM;

    /* renamed from: DN */
    private int f2951DN;

    /* renamed from: DU */
    private final long f2952DU;

    /* renamed from: DW */
    private long f2953DW;

    /* renamed from: EA */
    private final String f2954EA;

    /* renamed from: EB */
    private final int f2955EB;

    /* renamed from: EC */
    private final List<String> f2956EC;

    /* renamed from: ED */
    private final String f2957ED;

    /* renamed from: EE */
    private int f2958EE;

    /* renamed from: EF */
    private final String f2959EF;

    /* renamed from: EG */
    private final float f2960EG;

    /* renamed from: Ey */
    private final String f2961Ey;

    /* renamed from: Ez */
    private final String f2962Ez;
    private final long mTimeout;
    final int mVersionCode;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f, long j3, String str5) {
        this.mVersionCode = i;
        this.f2950DM = j;
        this.f2951DN = i2;
        this.f2961Ey = str;
        this.f2962Ez = str3;
        this.f2954EA = str5;
        this.f2955EB = i3;
        this.f2953DW = -1L;
        this.f2956EC = list;
        this.f2957ED = str2;
        this.f2952DU = j2;
        this.f2958EE = i4;
        this.f2959EF = str4;
        this.f2960EG = f;
        this.mTimeout = j3;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f, long j3, String str5) {
        this(2, j, i, str, i2, list, str2, j2, i3, str3, str4, f, j3, str5);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public int getEventType() {
        return this.f2951DN;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long getTimeMillis() {
        return this.f2950DM;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public String zzawp() {
        return this.f2957ED;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public long zzawq() {
        return this.f2953DW;
    }

    public long zzaws() {
        return this.f2952DU;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public String zzawt() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(zzaww());
        String valueOf3 = String.valueOf("\t");
        int zzawz = zzawz();
        String valueOf4 = String.valueOf("\t");
        String join = zzaxa() == null ? "" : TextUtils.join(",", zzaxa());
        String valueOf5 = String.valueOf("\t");
        int zzaxb = zzaxb();
        String valueOf6 = String.valueOf("\t");
        String zzawx = zzawx() == null ? "" : zzawx();
        String valueOf7 = String.valueOf("\t");
        String zzaxc = zzaxc() == null ? "" : zzaxc();
        String valueOf8 = String.valueOf("\t");
        float zzaxd = zzaxd();
        String valueOf9 = String.valueOf("\t");
        String zzawy = zzawy() == null ? "" : zzawy();
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 37 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(join).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length() + String.valueOf(zzawx).length() + String.valueOf(valueOf7).length() + String.valueOf(zzaxc).length() + String.valueOf(valueOf8).length() + String.valueOf(valueOf9).length() + String.valueOf(zzawy).length());
        sb.append(valueOf);
        sb.append(valueOf2);
        sb.append(valueOf3);
        sb.append(zzawz);
        sb.append(valueOf4);
        sb.append(join);
        sb.append(valueOf5);
        sb.append(zzaxb);
        sb.append(valueOf6);
        sb.append(zzawx);
        sb.append(valueOf7);
        sb.append(zzaxc);
        sb.append(valueOf8);
        sb.append(zzaxd);
        sb.append(valueOf9);
        sb.append(zzawy);
        return sb.toString();
    }

    public String zzaww() {
        return this.f2961Ey;
    }

    public String zzawx() {
        return this.f2962Ez;
    }

    public String zzawy() {
        return this.f2954EA;
    }

    public int zzawz() {
        return this.f2955EB;
    }

    public List<String> zzaxa() {
        return this.f2956EC;
    }

    public int zzaxb() {
        return this.f2958EE;
    }

    public String zzaxc() {
        return this.f2959EF;
    }

    public float zzaxd() {
        return this.f2960EG;
    }

    public long zzaxe() {
        return this.mTimeout;
    }
}
