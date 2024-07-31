package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.facebook.internal.q */
/* loaded from: classes.dex */
public class Logger {

    /* renamed from: a */
    private static final HashMap<String, String> f2020a = new HashMap<>();

    /* renamed from: b */
    private final LoggingBehavior f2021b;

    /* renamed from: c */
    private final String f2022c;

    /* renamed from: d */
    private StringBuilder f2023d;

    /* renamed from: e */
    private int f2024e = 3;

    /* renamed from: a */
    public static synchronized void m10630a(String str, String str2) {
        synchronized (Logger.class) {
            f2020a.put(str, str2);
        }
    }

    /* renamed from: a */
    public static synchronized void m10632a(String str) {
        synchronized (Logger.class) {
            if (!FacebookSdk.m10880a(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                m10630a(str, "ACCESS_TOKEN_REMOVED");
            }
        }
    }

    /* renamed from: a */
    public static void m10634a(LoggingBehavior loggingBehavior, String str, String str2) {
        m10636a(loggingBehavior, 3, str, str2);
    }

    /* renamed from: a */
    public static void m10633a(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        if (FacebookSdk.m10880a(loggingBehavior)) {
            m10636a(loggingBehavior, 3, str, String.format(str2, objArr));
        }
    }

    /* renamed from: a */
    public static void m10635a(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
        if (FacebookSdk.m10880a(loggingBehavior)) {
            m10636a(loggingBehavior, i, str, String.format(str2, objArr));
        }
    }

    /* renamed from: a */
    public static void m10636a(LoggingBehavior loggingBehavior, int i, String str, String str2) {
        if (FacebookSdk.m10880a(loggingBehavior)) {
            String m10625d = m10625d(str2);
            if (!str.startsWith("FacebookSDK.")) {
                str = "FacebookSDK." + str;
            }
            Log.println(i, str, m10625d);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                new Exception().printStackTrace();
            }
        }
    }

    /* renamed from: d */
    private static synchronized String m10625d(String str) {
        synchronized (Logger.class) {
            for (Map.Entry<String, String> entry : f2020a.entrySet()) {
                str = str.replace(entry.getKey(), entry.getValue());
            }
        }
        return str;
    }

    public Logger(LoggingBehavior loggingBehavior, String str) {
        Validate.m10468a(str, "tag");
        this.f2021b = loggingBehavior;
        this.f2022c = "FacebookSDK." + str;
        this.f2023d = new StringBuilder();
    }

    /* renamed from: a */
    public void m10637a() {
        m10627b(this.f2023d.toString());
        this.f2023d = new StringBuilder();
    }

    /* renamed from: b */
    public void m10627b(String str) {
        m10636a(this.f2021b, this.f2024e, this.f2022c, str);
    }

    /* renamed from: c */
    public void m10626c(String str) {
        if (m10628b()) {
            this.f2023d.append(str);
        }
    }

    /* renamed from: a */
    public void m10629a(String str, Object... objArr) {
        if (m10628b()) {
            this.f2023d.append(String.format(str, objArr));
        }
    }

    /* renamed from: a */
    public void m10631a(String str, Object obj) {
        m10629a("  %s:\t%s\n", str, obj);
    }

    /* renamed from: b */
    private boolean m10628b() {
        return FacebookSdk.m10880a(this.f2021b);
    }
}
