package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.proguard.C2486p;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import com.tencent.bugly.proguard.InterfaceC2485o;
import java.util.Map;

/* renamed from: com.tencent.bugly.Bugly */
/* loaded from: classes2.dex */
public class BUGLY {
    public static final String SDK_IS_DEV = "false";

    /* renamed from: a */
    private static boolean f7120a = false;
    public static Context applicationContext = null;

    /* renamed from: b */
    private static String[] f7121b = {"BuglyCrashModule", "BuglyRqdModule", "BuglyBetaModule"};

    /* renamed from: c */
    private static String[] f7122c = {"BuglyRqdModule", "BuglyCrashModule", "BuglyBetaModule"};
    public static boolean enable = true;
    public static Boolean isDev;

    public static void init(Context context, String str, boolean z) {
        init(context, str, z, null);
    }

    public static synchronized void init(Context context, String str, boolean z, BuglyStrategy buglyStrategy) {
        String[] strArr;
        synchronized (BUGLY.class) {
            if (f7120a) {
                return;
            }
            f7120a = true;
            Context m5057a = C2503z.m5057a(context);
            applicationContext = m5057a;
            if (m5057a == null) {
                Log.e(C2499x.f7763a, "init arg 'context' should not be null!");
                return;
            }
            if (isDev()) {
                f7121b = f7122c;
            }
            for (String str2 : f7121b) {
                if (str2.equals("BuglyCrashModule")) {
                    C2404b.m5549a(CrashModule.getInstance());
                } else if (!str2.equals("BuglyBetaModule") && !str2.equals("BuglyRqdModule")) {
                    str2.equals("BuglyFeedbackModule");
                }
            }
            C2404b.f7144a = enable;
            C2404b.m5550a(applicationContext, str, z, buglyStrategy);
        }
    }

    public static synchronized String getAppChannel() {
        byte[] bArr;
        synchronized (BUGLY.class) {
            C2419a m5470b = C2419a.m5470b();
            if (m5470b == null) {
                return null;
            }
            if (TextUtils.isEmpty(m5470b.f7266l)) {
                C2486p m5175a = C2486p.m5175a();
                if (m5175a == null) {
                    return m5470b.f7266l;
                }
                Map<String, byte[]> m5172a = m5175a.m5172a(556, (InterfaceC2485o) null, true);
                if (m5172a != null && (bArr = m5172a.get("app_channel")) != null) {
                    return new String(bArr);
                }
            }
            return m5470b.f7266l;
        }
    }

    public static boolean isDev() {
        if (isDev == null) {
            isDev = Boolean.valueOf(Boolean.parseBoolean(SDK_IS_DEV.replace("@", "")));
        }
        return isDev.booleanValue();
    }
}
