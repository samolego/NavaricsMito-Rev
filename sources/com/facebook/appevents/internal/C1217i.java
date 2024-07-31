package com.facebook.appevents.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.Logger;
import java.util.Locale;

/* renamed from: com.facebook.appevents.internal.i */
/* loaded from: classes.dex */
class SessionLogger {

    /* renamed from: a */
    private static final String f1763a = SessionLogger.class.getCanonicalName();

    /* renamed from: b */
    private static final long[] f1764b = {300000, 900000, 1800000, 3600000, 21600000, 43200000, 86400000, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    SessionLogger() {
    }

    /* renamed from: a */
    public static void m10964a(String str, SourceApplicationInfo sourceApplicationInfo, String str2, Context context) {
        String sourceApplicationInfo2 = sourceApplicationInfo != null ? sourceApplicationInfo.toString() : "Unclassified";
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", sourceApplicationInfo2);
        bundle.putString("fb_mobile_pckg_fp", m10966a(context));
        InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(str, str2, null);
        internalAppEventsLogger.m11060a("fb_mobile_activate_app", bundle);
        if (InternalAppEventsLogger.m11063a() != AppEventsLogger.FlushBehavior.EXPLICIT_ONLY) {
            internalAppEventsLogger.m11054b();
        }
    }

    /* renamed from: a */
    public static void m10965a(String str, SessionInfo sessionInfo, String str2) {
        Long valueOf = Long.valueOf(sessionInfo.m10973f() - sessionInfo.m10976c().longValue());
        if (valueOf.longValue() < 0) {
            valueOf = 0L;
            m10968a();
        }
        Long valueOf2 = Long.valueOf(sessionInfo.m10971h());
        if (valueOf2.longValue() < 0) {
            m10968a();
            valueOf2 = 0L;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", sessionInfo.m10975d());
        bundle.putString("fb_mobile_time_between_sessions", String.format(Locale.ROOT, "session_quanta_%d", Integer.valueOf(m10967a(valueOf.longValue()))));
        SourceApplicationInfo m10970i = sessionInfo.m10970i();
        bundle.putString("fb_mobile_launch_source", m10970i != null ? m10970i.toString() : "Unclassified");
        bundle.putLong("_logTime", sessionInfo.m10976c().longValue() / 1000);
        new InternalAppEventsLogger(str, str2, null).m11061a("fb_mobile_deactivate_app", valueOf2.longValue() / 1000.0d, bundle);
    }

    /* renamed from: a */
    private static void m10968a() {
        Logger.m10634a(LoggingBehavior.APP_EVENTS, f1763a, "Clock skew detected");
    }

    /* renamed from: a */
    private static int m10967a(long j) {
        int i = 0;
        while (true) {
            long[] jArr = f1764b;
            if (i >= jArr.length || jArr[i] >= j) {
                break;
            }
            i++;
        }
        return i;
    }

    @Nullable
    /* renamed from: a */
    private static String m10966a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String str = "PCKGCHKSUM;" + packageManager.getPackageInfo(context.getPackageName(), 0).versionName;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(str, null);
            if (string == null || string.length() != 32) {
                String m11005a = HashUtils.m11005a(packageManager.getApplicationInfo(context.getPackageName(), 0).sourceDir);
                sharedPreferences.edit().putString(str, m11005a).apply();
                return m11005a;
            }
            return string;
        } catch (Exception unused) {
            return null;
        }
    }
}
