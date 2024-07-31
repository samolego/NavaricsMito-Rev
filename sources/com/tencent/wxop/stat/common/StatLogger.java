package com.tencent.wxop.stat.common;

import android.util.Log;
import com.tencent.wxop.stat.InterfaceC2590g;
import com.tencent.wxop.stat.StatConfig;

/* loaded from: classes2.dex */
public final class StatLogger {

    /* renamed from: a */
    private String f8011a;

    /* renamed from: b */
    private boolean f8012b;

    /* renamed from: c */
    private int f8013c;

    public StatLogger() {
        this.f8011a = "default";
        this.f8012b = true;
        this.f8013c = 2;
    }

    public StatLogger(String str) {
        this.f8011a = "default";
        this.f8012b = true;
        this.f8013c = 2;
        this.f8011a = str;
    }

    /* renamed from: a */
    private String m4881a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(getClass().getName())) {
                return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + "]";
            }
        }
        return null;
    }

    /* renamed from: d */
    public final void m4880d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public final void debug(Object obj) {
        String str;
        if (this.f8013c <= 3) {
            String m4881a = m4881a();
            if (m4881a == null) {
                str = obj.toString();
            } else {
                str = m4881a + " - " + obj;
            }
            Log.d(this.f8011a, str);
            InterfaceC2590g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m4757e(str);
            }
        }
    }

    /* renamed from: e */
    public final void m4879e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    /* renamed from: e */
    public final void m4878e(Throwable th) {
        if (isDebugEnable()) {
            error(th);
        }
    }

    public final void error(Object obj) {
        String str;
        if (this.f8013c <= 6) {
            String m4881a = m4881a();
            if (m4881a == null) {
                str = obj.toString();
            } else {
                str = m4881a + " - " + obj;
            }
            Log.e(this.f8011a, str);
            InterfaceC2590g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m4758d(str);
            }
        }
    }

    public final void error(Throwable th) {
        if (this.f8013c <= 6) {
            Log.e(this.f8011a, "", th);
            InterfaceC2590g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m4758d(th);
            }
        }
    }

    public final int getLogLevel() {
        return this.f8013c;
    }

    /* renamed from: i */
    public final void m4877i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public final void info(Object obj) {
        String str;
        if (this.f8013c <= 4) {
            String m4881a = m4881a();
            if (m4881a == null) {
                str = obj.toString();
            } else {
                str = m4881a + " - " + obj;
            }
            Log.i(this.f8011a, str);
            InterfaceC2590g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m4761a(str);
            }
        }
    }

    public final boolean isDebugEnable() {
        return this.f8012b;
    }

    public final void setDebugEnable(boolean z) {
        this.f8012b = z;
    }

    public final void setLogLevel(int i) {
        this.f8013c = i;
    }

    public final void setTag(String str) {
        this.f8011a = str;
    }

    /* renamed from: v */
    public final void m4876v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public final void verbose(Object obj) {
        String str;
        if (this.f8013c <= 2) {
            String m4881a = m4881a();
            if (m4881a == null) {
                str = obj.toString();
            } else {
                str = m4881a + " - " + obj;
            }
            Log.v(this.f8011a, str);
            InterfaceC2590g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m4760b(str);
            }
        }
    }

    /* renamed from: w */
    public final void m4875w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public final void warn(Object obj) {
        String str;
        if (this.f8013c <= 5) {
            String m4881a = m4881a();
            if (m4881a == null) {
                str = obj.toString();
            } else {
                str = m4881a + " - " + obj;
            }
            Log.w(this.f8011a, str);
            InterfaceC2590g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.m4759c(str);
            }
        }
    }
}
