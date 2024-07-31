package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzy;
import com.google.android.gms.common.zzd;
import com.google.android.gms.internal.zzsh;
import com.google.android.gms.internal.zzsi;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class zze {
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zzapk();

    /* renamed from: uX */
    public static boolean f3029uX = false;

    /* renamed from: uY */
    public static boolean f3030uY = false;

    /* renamed from: uZ */
    static boolean f3031uZ = false;

    /* renamed from: va */
    private static String f3032va = null;

    /* renamed from: vb */
    private static int f3033vb = 0;

    /* renamed from: vc */
    private static boolean f3034vc = false;

    /* renamed from: vd */
    static final AtomicBoolean f3035vd = new AtomicBoolean();

    /* renamed from: ve */
    private static final AtomicBoolean f3036ve = new AtomicBoolean();

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zzc.zzapd().getErrorResolutionPendingIntent(context, i, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return ConnectionResult.getStatusString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        InputStream openInputStream;
        try {
            openInputStream = context.getContentResolver().openInputStream(new Uri.Builder().scheme("android.resource").authority("com.google.android.gms").appendPath("raw").appendPath("oss_notice").build());
        } catch (Exception unused) {
            return null;
        }
        try {
            String next = new Scanner(openInputStream).useDelimiter("\\A").next();
            if (openInputStream != null) {
                openInputStream.close();
            }
            return next;
        } catch (NoSuchElementException unused2) {
            if (openInputStream != null) {
                openInputStream.close();
            }
            return null;
        }
    }

    public static Context getRemoteContext(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static Resources getRemoteResource(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        if (r7.zza(r5, r1) == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0066, code lost:
        r7 = "GooglePlayServicesUtil";
        r0 = "Google Play services signature invalid.";
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0071, code lost:
        if (r7.zza(r5, com.google.android.gms.common.zzd.C3244zzd.f3028uW) == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
        if (com.google.android.gms.common.util.zzl.zzhj(r5.versionCode) >= com.google.android.gms.common.util.zzl.zzhj(com.google.android.gms.common.zze.GOOGLE_PLAY_SERVICES_VERSION_CODE)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
        r0 = com.google.android.gms.common.zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        r1 = r5.versionCode;
        r2 = new java.lang.StringBuilder(77);
        r2.append("Google Play services out of date.  Requires ");
        r2.append(r0);
        r2.append(" but found ");
        r2.append(r1);
        android.util.Log.w("GooglePlayServicesUtil", r2.toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
        return 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
        r7 = r5.applicationInfo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00aa, code lost:
        if (r7 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00ac, code lost:
        r7 = r0.getApplicationInfo("com.google.android.gms", 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b3, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b4, code lost:
        android.util.Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00bb, code lost:
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00be, code lost:
        if (r7.enabled != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c0, code lost:
        return 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00c2, code lost:
        return 0;
     */
    @java.lang.Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int isGooglePlayServicesAvailable(android.content.Context r7) {
        /*
            android.content.pm.PackageManager r0 = r7.getPackageManager()
            android.content.res.Resources r1 = r7.getResources()     // Catch: java.lang.Throwable -> Le
            int r2 = com.google.android.gms.C1188R.string.common_google_play_services_unknown_issue     // Catch: java.lang.Throwable -> Le
            r1.getString(r2)     // Catch: java.lang.Throwable -> Le
            goto L15
        Le:
            java.lang.String r1 = "GooglePlayServicesUtil"
            java.lang.String r2 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
            android.util.Log.e(r1, r2)
        L15:
            java.lang.String r1 = "com.google.android.gms"
            java.lang.String r2 = r7.getPackageName()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L24
            zzbt(r7)
        L24:
            boolean r1 = com.google.android.gms.common.util.zzi.zzcl(r7)
            r2 = 1
            r1 = r1 ^ r2
            r3 = 0
            r4 = 9
            if (r1 == 0) goto L40
            java.lang.String r3 = "com.android.vending"
            r5 = 8256(0x2040, float:1.1569E-41)
            android.content.pm.PackageInfo r3 = r0.getPackageInfo(r3, r5)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L38
            goto L40
        L38:
            java.lang.String r7 = "GooglePlayServicesUtil"
            java.lang.String r0 = "Google Play Store is missing."
        L3c:
            android.util.Log.w(r7, r0)
            return r4
        L40:
            java.lang.String r5 = "com.google.android.gms"
            r6 = 64
            android.content.pm.PackageInfo r5 = r0.getPackageInfo(r5, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lc3
            com.google.android.gms.common.zzf r7 = com.google.android.gms.common.zzf.zzbz(r7)
            r6 = 0
            if (r1 == 0) goto L6b
            com.google.android.gms.common.zzd$zza[] r1 = com.google.android.gms.common.zzd.C3244zzd.f3028uW
            com.google.android.gms.common.zzd$zza r1 = r7.zza(r3, r1)
            if (r1 != 0) goto L5c
            java.lang.String r7 = "GooglePlayServicesUtil"
            java.lang.String r0 = "Google Play Store signature invalid."
            goto L3c
        L5c:
            com.google.android.gms.common.zzd$zza[] r3 = new com.google.android.gms.common.zzd.zza[r2]
            r3[r6] = r1
            com.google.android.gms.common.zzd$zza r7 = r7.zza(r5, r3)
            if (r7 != 0) goto L74
        L66:
            java.lang.String r7 = "GooglePlayServicesUtil"
            java.lang.String r0 = "Google Play services signature invalid."
            goto L3c
        L6b:
            com.google.android.gms.common.zzd$zza[] r1 = com.google.android.gms.common.zzd.C3244zzd.f3028uW
            com.google.android.gms.common.zzd$zza r7 = r7.zza(r5, r1)
            if (r7 != 0) goto L74
            goto L66
        L74:
            int r7 = com.google.android.gms.common.zze.GOOGLE_PLAY_SERVICES_VERSION_CODE
            int r7 = com.google.android.gms.common.util.zzl.zzhj(r7)
            int r1 = r5.versionCode
            int r1 = com.google.android.gms.common.util.zzl.zzhj(r1)
            if (r1 >= r7) goto La8
            java.lang.String r7 = "GooglePlayServicesUtil"
            int r0 = com.google.android.gms.common.zze.GOOGLE_PLAY_SERVICES_VERSION_CODE
            int r1 = r5.versionCode
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = 77
            r2.<init>(r3)
            java.lang.String r3 = "Google Play services out of date.  Requires "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = " but found "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            android.util.Log.w(r7, r0)
            r7 = 2
            return r7
        La8:
            android.content.pm.ApplicationInfo r7 = r5.applicationInfo
            if (r7 != 0) goto Lbc
            java.lang.String r7 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r7 = r0.getApplicationInfo(r7, r6)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> Lb3
            goto Lbc
        Lb3:
            r7 = move-exception
            java.lang.String r0 = "GooglePlayServicesUtil"
            java.lang.String r1 = "Google Play services missing when getting application info."
            android.util.Log.wtf(r0, r1, r7)
            return r2
        Lbc:
            boolean r7 = r7.enabled
            if (r7 != 0) goto Lc2
            r7 = 3
            return r7
        Lc2:
            return r6
        Lc3:
            java.lang.String r7 = "GooglePlayServicesUtil"
            java.lang.String r0 = "Google Play services is missing."
            android.util.Log.w(r7, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zze.isGooglePlayServicesAvailable(android.content.Context):int");
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        if (i != 9) {
            switch (i) {
                case 1:
                case 2:
                case 3:
                    return true;
                default:
                    return false;
            }
        }
        return true;
    }

    private static int zzapk() {
        return com.google.android.gms.common.internal.zzf.f2840BA;
    }

    @Deprecated
    public static boolean zzapl() {
        return "user".equals(Build.TYPE);
    }

    @TargetApi(19)
    @Deprecated
    public static boolean zzb(Context context, int i, String str) {
        return zzy.zzb(context, i, str);
    }

    @Deprecated
    public static void zzbc(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int isGooglePlayServicesAvailable = zzc.zzapd().isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 0) {
            Intent zza = zzc.zzapd().zza(context, isGooglePlayServicesAvailable, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(isGooglePlayServicesAvailable);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (zza != null) {
                throw new GooglePlayServicesRepairableException(isGooglePlayServicesAvailable, "Google Play Services not available", zza);
            }
            throw new GooglePlayServicesNotAvailableException(isGooglePlayServicesAvailable);
        }
    }

    @Deprecated
    public static int zzbo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @Deprecated
    public static void zzbq(Context context) {
        if (f3035vd.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
            if (notificationManager != null) {
                notificationManager.cancel(10436);
            }
        } catch (SecurityException unused) {
        }
    }

    private static void zzbt(Context context) {
        if (f3036ve.get()) {
            return;
        }
        zzbx(context);
        int i = f3033vb;
        if (i == 0) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        int i2 = GOOGLE_PLAY_SERVICES_VERSION_CODE;
        if (i == i2) {
            return;
        }
        String valueOf = String.valueOf("com.google.android.gms.version");
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 290);
        sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
        sb.append(i2);
        sb.append(" but found ");
        sb.append(i);
        sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"");
        sb.append(valueOf);
        sb.append("\" android:value=\"@integer/google_play_services_version\" />");
        throw new IllegalStateException(sb.toString());
    }

    public static boolean zzbu(Context context) {
        zzbx(context);
        return f3031uZ;
    }

    public static boolean zzbv(Context context) {
        return zzbu(context) || !zzapl();
    }

    @TargetApi(18)
    public static boolean zzbw(Context context) {
        Bundle applicationRestrictions;
        return zzs.zzaxq() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    private static void zzbx(Context context) {
        if (f3034vc) {
            return;
        }
        zzby(context);
    }

    private static void zzby(Context context) {
        try {
            try {
                f3032va = context.getPackageName();
                zzsh zzcr = zzsi.zzcr(context);
                f3033vb = zzaa.zzch(context);
                PackageInfo packageInfo = zzcr.getPackageInfo("com.google.android.gms", 64);
                if (packageInfo == null || zzf.zzbz(context).zza(packageInfo, zzd.C3244zzd.f3028uW[1]) == null) {
                    f3031uZ = false;
                } else {
                    f3031uZ = true;
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
            }
        } finally {
            f3034vc = true;
        }
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return zzs(context, "com.google.android.gms");
        }
        return false;
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        if (i == 9) {
            return zzs(context, "com.android.vending");
        }
        return false;
    }

    @Deprecated
    public static boolean zzf(Context context, int i) {
        return zzy.zzf(context, i);
    }

    @Deprecated
    public static Intent zzfm(int i) {
        return zzc.zzapd().zza(null, i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzfn(int i) {
        if (i == 18 || i == 42) {
            return true;
        }
        switch (i) {
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(21)
    public static boolean zzs(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (equals && com.google.android.gms.common.util.zzd.zzact()) {
            return false;
        }
        if (zzs.zzaxu()) {
            for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                if (str.equals(sessionInfo.getAppPackageName())) {
                    return true;
                }
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            return equals ? applicationInfo.enabled : applicationInfo.enabled && !zzbw(context);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
