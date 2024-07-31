package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public class zzxb {
    private static boolean DEBUG = false;
    private static String TAG = "WakeLock";
    private static String aAo = "*gcore*:";

    /* renamed from: EA */
    private final String f3386EA;

    /* renamed from: Ey */
    private final String f3387Ey;
    private final PowerManager.WakeLock aAp;
    private final int aAq;
    private final String aAr;
    private boolean aAs;
    private int aAt;
    private int aAu;
    private WorkSource agC;
    private final Context mContext;

    public zzxb(Context context, int i, String str) {
        this(context, i, str, null, context == null ? null : context.getPackageName());
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzxb(Context context, int i, String str, String str2, String str3) {
        this(context, i, str, str2, str3, null);
    }

    @SuppressLint({"UnwrappedWakeLock"})
    public zzxb(Context context, int i, String str, String str2, String str3, String str4) {
        this.aAs = true;
        com.google.android.gms.common.internal.zzac.zzh(str, "Wake lock name can NOT be empty");
        this.aAq = i;
        this.aAr = str2;
        this.f3386EA = str4;
        this.mContext = context.getApplicationContext();
        if ("com.google.android.gms".equals(context.getPackageName())) {
            this.f3387Ey = str;
        } else {
            String valueOf = String.valueOf(aAo);
            String valueOf2 = String.valueOf(str);
            this.f3387Ey = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.aAp = ((PowerManager) context.getSystemService("power")).newWakeLock(i, str);
        if (com.google.android.gms.common.util.zzz.zzcp(this.mContext)) {
            this.agC = com.google.android.gms.common.util.zzz.zzy(context, com.google.android.gms.common.util.zzw.zzij(str3) ? context.getPackageName() : str3);
            zzc(this.agC);
        }
    }

    private void zzd(WorkSource workSource) {
        try {
            this.aAp.setWorkSource(workSource);
        } catch (IllegalArgumentException e) {
            Log.wtf(TAG, e.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r12.aAu == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r0 == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void zzm(java.lang.String r13, long r14) {
        /*
            r12 = this;
            boolean r0 = r12.zzop(r13)
            java.lang.String r6 = r12.zzp(r13, r0)
            monitor-enter(r12)
            boolean r13 = r12.aAs     // Catch: java.lang.Throwable -> L44
            if (r13 == 0) goto L17
            int r13 = r12.aAt     // Catch: java.lang.Throwable -> L44
            int r1 = r13 + 1
            r12.aAt = r1     // Catch: java.lang.Throwable -> L44
            if (r13 == 0) goto L1f
            if (r0 != 0) goto L1f
        L17:
            boolean r13 = r12.aAs     // Catch: java.lang.Throwable -> L44
            if (r13 != 0) goto L42
            int r13 = r12.aAu     // Catch: java.lang.Throwable -> L44
            if (r13 != 0) goto L42
        L1f:
            com.google.android.gms.common.stats.zzh r1 = com.google.android.gms.common.stats.zzh.zzaxf()     // Catch: java.lang.Throwable -> L44
            android.content.Context r2 = r12.mContext     // Catch: java.lang.Throwable -> L44
            android.os.PowerManager$WakeLock r13 = r12.aAp     // Catch: java.lang.Throwable -> L44
            java.lang.String r3 = com.google.android.gms.common.stats.zzf.zza(r13, r6)     // Catch: java.lang.Throwable -> L44
            r4 = 7
            java.lang.String r5 = r12.f3387Ey     // Catch: java.lang.Throwable -> L44
            java.lang.String r7 = r12.f3386EA     // Catch: java.lang.Throwable -> L44
            int r8 = r12.aAq     // Catch: java.lang.Throwable -> L44
            android.os.WorkSource r13 = r12.agC     // Catch: java.lang.Throwable -> L44
            java.util.List r9 = com.google.android.gms.common.util.zzz.zzb(r13)     // Catch: java.lang.Throwable -> L44
            r10 = r14
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L44
            int r13 = r12.aAu     // Catch: java.lang.Throwable -> L44
            int r13 = r13 + 1
            r12.aAu = r13     // Catch: java.lang.Throwable -> L44
        L42:
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L44
            return
        L44:
            r13 = move-exception
            monitor-exit(r12)     // Catch: java.lang.Throwable -> L44
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzxb.zzm(java.lang.String, long):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        if (r11.aAu == 1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r0 == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void zzoo(java.lang.String r12) {
        /*
            r11 = this;
            boolean r0 = r11.zzop(r12)
            java.lang.String r6 = r11.zzp(r12, r0)
            monitor-enter(r11)
            boolean r12 = r11.aAs     // Catch: java.lang.Throwable -> L43
            r10 = 1
            if (r12 == 0) goto L17
            int r12 = r11.aAt     // Catch: java.lang.Throwable -> L43
            int r12 = r12 - r10
            r11.aAt = r12     // Catch: java.lang.Throwable -> L43
            if (r12 == 0) goto L1f
            if (r0 != 0) goto L1f
        L17:
            boolean r12 = r11.aAs     // Catch: java.lang.Throwable -> L43
            if (r12 != 0) goto L41
            int r12 = r11.aAu     // Catch: java.lang.Throwable -> L43
            if (r12 != r10) goto L41
        L1f:
            com.google.android.gms.common.stats.zzh r1 = com.google.android.gms.common.stats.zzh.zzaxf()     // Catch: java.lang.Throwable -> L43
            android.content.Context r2 = r11.mContext     // Catch: java.lang.Throwable -> L43
            android.os.PowerManager$WakeLock r12 = r11.aAp     // Catch: java.lang.Throwable -> L43
            java.lang.String r3 = com.google.android.gms.common.stats.zzf.zza(r12, r6)     // Catch: java.lang.Throwable -> L43
            r4 = 8
            java.lang.String r5 = r11.f3387Ey     // Catch: java.lang.Throwable -> L43
            java.lang.String r7 = r11.f3386EA     // Catch: java.lang.Throwable -> L43
            int r8 = r11.aAq     // Catch: java.lang.Throwable -> L43
            android.os.WorkSource r12 = r11.agC     // Catch: java.lang.Throwable -> L43
            java.util.List r9 = com.google.android.gms.common.util.zzz.zzb(r12)     // Catch: java.lang.Throwable -> L43
            r1.zza(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L43
            int r12 = r11.aAu     // Catch: java.lang.Throwable -> L43
            int r12 = r12 - r10
            r11.aAu = r12     // Catch: java.lang.Throwable -> L43
        L41:
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L43
            return
        L43:
            r12 = move-exception
            monitor-exit(r11)     // Catch: java.lang.Throwable -> L43
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzxb.zzoo(java.lang.String):void");
    }

    private boolean zzop(String str) {
        return (TextUtils.isEmpty(str) || str.equals(this.aAr)) ? false : true;
    }

    private String zzp(String str, boolean z) {
        return (this.aAs && z) ? str : this.aAr;
    }

    public void acquire(long j) {
        if (!com.google.android.gms.common.util.zzs.zzaxn() && this.aAs) {
            String str = TAG;
            String valueOf = String.valueOf(this.f3387Ey);
            Log.wtf(str, valueOf.length() != 0 ? "Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: ".concat(valueOf) : new String("Do not acquire with timeout on reference counted WakeLocks before ICS. wakelock: "));
        }
        zzm(null, j);
        this.aAp.acquire(j);
    }

    public boolean isHeld() {
        return this.aAp.isHeld();
    }

    public void release() {
        zzoo(null);
        this.aAp.release();
    }

    public void setReferenceCounted(boolean z) {
        this.aAp.setReferenceCounted(z);
        this.aAs = z;
    }

    public void zzc(WorkSource workSource) {
        if (workSource == null || !com.google.android.gms.common.util.zzz.zzcp(this.mContext)) {
            return;
        }
        WorkSource workSource2 = this.agC;
        if (workSource2 != null) {
            workSource2.add(workSource);
        } else {
            this.agC = workSource;
        }
        zzd(this.agC);
    }
}
