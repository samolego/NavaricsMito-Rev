package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C1188R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzaj;

@Deprecated
/* loaded from: classes.dex */
public final class zzqw {

    /* renamed from: yP */
    private static zzqw f3272yP;
    private static Object zzaok = new Object();

    /* renamed from: yQ */
    private final String f3273yQ;

    /* renamed from: yR */
    private final Status f3274yR;

    /* renamed from: yS */
    private final String f3275yS;

    /* renamed from: yT */
    private final String f3276yT;

    /* renamed from: yU */
    private final String f3277yU;

    /* renamed from: yV */
    private final boolean f3278yV;

    /* renamed from: yW */
    private final boolean f3279yW;
    private final String zzcpe;

    zzqw(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C1188R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            r3 = resources.getInteger(identifier) != 0;
            this.f3279yW = !r3;
        } else {
            this.f3279yW = false;
        }
        this.f3278yV = r3;
        zzaj zzajVar = new zzaj(context);
        this.f3275yS = zzajVar.getString("firebase_database_url");
        this.f3277yU = zzajVar.getString("google_storage_bucket");
        this.f3276yT = zzajVar.getString("gcm_defaultSenderId");
        this.f3273yQ = zzajVar.getString("google_api_key");
        String zzcg = com.google.android.gms.common.internal.zzaa.zzcg(context);
        zzcg = zzcg == null ? zzajVar.getString("google_app_id") : zzcg;
        if (TextUtils.isEmpty(zzcg)) {
            this.f3274yR = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.zzcpe = null;
            return;
        }
        this.zzcpe = zzcg;
        this.f3274yR = Status.f2684vY;
    }

    zzqw(String str, boolean z) {
        this(str, z, null, null, null);
    }

    zzqw(String str, boolean z, String str2, String str3, String str4) {
        this.zzcpe = str;
        this.f3273yQ = null;
        this.f3274yR = Status.f2684vY;
        this.f3278yV = z;
        this.f3279yW = !z;
        this.f3275yS = str2;
        this.f3276yT = str4;
        this.f3277yU = str3;
    }

    public static String zzasl() {
        return zzhf("getGoogleAppId").zzcpe;
    }

    public static boolean zzasm() {
        return zzhf("isMeasurementExplicitlyDisabled").f3279yW;
    }

    public static Status zzb(Context context, String str, boolean z) {
        com.google.android.gms.common.internal.zzac.zzb(context, "Context must not be null.");
        com.google.android.gms.common.internal.zzac.zzh(str, "App ID must be nonempty.");
        synchronized (zzaok) {
            if (f3272yP != null) {
                return f3272yP.zzhe(str);
            }
            f3272yP = new zzqw(str, z);
            return f3272yP.f3274yR;
        }
    }

    public static Status zzcb(Context context) {
        Status status;
        com.google.android.gms.common.internal.zzac.zzb(context, "Context must not be null.");
        synchronized (zzaok) {
            if (f3272yP == null) {
                f3272yP = new zzqw(context);
            }
            status = f3272yP.f3274yR;
        }
        return status;
    }

    private static zzqw zzhf(String str) {
        zzqw zzqwVar;
        synchronized (zzaok) {
            if (f3272yP == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34);
                sb.append("Initialize must be called before ");
                sb.append(str);
                sb.append(".");
                throw new IllegalStateException(sb.toString());
            }
            zzqwVar = f3272yP;
        }
        return zzqwVar;
    }

    Status zzhe(String str) {
        String str2 = this.zzcpe;
        if (str2 == null || str2.equals(str)) {
            return Status.f2684vY;
        }
        String str3 = this.zzcpe;
        StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 97);
        sb.append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '");
        sb.append(str3);
        sb.append("'.");
        return new Status(10, sb.toString());
    }
}
