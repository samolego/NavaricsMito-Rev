package com.tencent.bugly.crashreport.crash;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.info.C2420b;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2500y;
import com.tencent.bugly.proguard.C2503z;
import java.lang.Thread;
import java.util.HashMap;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.e */
/* loaded from: classes2.dex */
public final class C2443e implements Thread.UncaughtExceptionHandler {

    /* renamed from: h */
    private static String f7463h;

    /* renamed from: i */
    private static final Object f7464i = new Object();

    /* renamed from: a */
    private Context f7465a;

    /* renamed from: b */
    private C2435b f7466b;

    /* renamed from: c */
    private C2422a f7467c;

    /* renamed from: d */
    private C2419a f7468d;

    /* renamed from: e */
    private Thread.UncaughtExceptionHandler f7469e;

    /* renamed from: f */
    private Thread.UncaughtExceptionHandler f7470f;

    /* renamed from: g */
    private boolean f7471g = false;

    /* renamed from: j */
    private int f7472j;

    public C2443e(Context context, C2435b c2435b, C2422a c2422a, C2419a c2419a) {
        this.f7465a = context;
        this.f7466b = c2435b;
        this.f7467c = c2422a;
        this.f7468d = c2419a;
    }

    /* renamed from: a */
    public final synchronized void m5317a() {
        if (this.f7472j >= 10) {
            C2499x.m5090a("java crash handler over %d, no need set.", 10);
            return;
        }
        this.f7471g = true;
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            if (getClass().getName().equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                return;
            }
            if ("com.android.internal.os.RuntimeInit$UncaughtHandler".equals(defaultUncaughtExceptionHandler.getClass().getName())) {
                C2499x.m5090a("backup system java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7470f = defaultUncaughtExceptionHandler;
                this.f7469e = defaultUncaughtExceptionHandler;
            } else {
                C2499x.m5090a("backup java handler: %s", defaultUncaughtExceptionHandler.toString());
                this.f7469e = defaultUncaughtExceptionHandler;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
        this.f7472j++;
        C2499x.m5090a("registered java monitor: %s", toString());
    }

    /* renamed from: b */
    public final synchronized void m5311b() {
        this.f7471g = false;
        C2499x.m5090a("close java monitor!", new Object[0]);
        if (Thread.getDefaultUncaughtExceptionHandler().getClass().getName().contains("bugly")) {
            C2499x.m5090a("Java monitor to unregister: %s", toString());
            Thread.setDefaultUncaughtExceptionHandler(this.f7469e);
            this.f7472j--;
        }
    }

    /* renamed from: b */
    private CrashDetailBean m5310b(Thread thread, Throwable th, boolean z, String str, byte[] bArr) {
        String m5312a;
        boolean z2 = false;
        if (th == null) {
            C2499x.m5084d("We can do nothing with a null throwable.", new Object[0]);
            return null;
        }
        boolean m5325k = C2437c.m5343a().m5325k();
        String str2 = (m5325k && z) ? " This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful![Bugly]" : "";
        if (m5325k && z) {
            C2499x.m5083e("This Crash Caused By ANR , PLS To Fix ANR , This Trace May Be Not Useful!", new Object[0]);
        }
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        crashDetailBean.f7329C = C2420b.m5414k();
        crashDetailBean.f7330D = C2420b.m5418i();
        crashDetailBean.f7331E = C2420b.m5410m();
        crashDetailBean.f7332F = this.f7468d.m5446p();
        crashDetailBean.f7333G = this.f7468d.m5447o();
        crashDetailBean.f7334H = this.f7468d.m5445q();
        crashDetailBean.f7372w = C2503z.m5056a(this.f7465a, C2437c.f7423e, (String) null);
        crashDetailBean.f7374y = C2500y.m5082a();
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(crashDetailBean.f7374y == null ? 0 : crashDetailBean.f7374y.length);
        C2499x.m5090a("user log size:%d", objArr);
        crashDetailBean.f7351b = z ? 0 : 2;
        crashDetailBean.f7354e = this.f7468d.m5454h();
        crashDetailBean.f7355f = this.f7468d.f7264j;
        crashDetailBean.f7356g = this.f7468d.m5439w();
        crashDetailBean.f7362m = this.f7468d.m5456g();
        String name = th.getClass().getName();
        String m5309b = m5309b(th, 1000);
        if (m5309b == null) {
            m5309b = "";
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = Integer.valueOf(th.getStackTrace().length);
        objArr2[1] = Boolean.valueOf(th.getCause() != null);
        C2499x.m5083e("stack frame :%d, has cause %b", objArr2);
        String stackTraceElement = th.getStackTrace().length > 0 ? th.getStackTrace()[0].toString() : "";
        Throwable th2 = th;
        while (th2 != null && th2.getCause() != null) {
            th2 = th2.getCause();
        }
        if (th2 != null && th2 != th) {
            crashDetailBean.f7363n = th2.getClass().getName();
            crashDetailBean.f7364o = m5309b(th2, 1000);
            if (crashDetailBean.f7364o == null) {
                crashDetailBean.f7364o = "";
            }
            if (th2.getStackTrace().length > 0) {
                crashDetailBean.f7365p = th2.getStackTrace()[0].toString();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(name);
            sb.append(":");
            sb.append(m5309b);
            sb.append("\n");
            sb.append(stackTraceElement);
            sb.append("\n......");
            sb.append("\nCaused by:\n");
            sb.append(crashDetailBean.f7363n);
            sb.append(":");
            sb.append(crashDetailBean.f7364o);
            sb.append("\n");
            m5312a = m5312a(th2, C2437c.f7424f);
            sb.append(m5312a);
            crashDetailBean.f7366q = sb.toString();
        } else {
            crashDetailBean.f7363n = name;
            crashDetailBean.f7364o = m5309b + str2;
            if (crashDetailBean.f7364o == null) {
                crashDetailBean.f7364o = "";
            }
            crashDetailBean.f7365p = stackTraceElement;
            m5312a = m5312a(th, C2437c.f7424f);
            crashDetailBean.f7366q = m5312a;
        }
        crashDetailBean.f7367r = System.currentTimeMillis();
        crashDetailBean.f7370u = C2503z.m5023b(crashDetailBean.f7366q.getBytes());
        try {
            crashDetailBean.f7375z = C2503z.m5060a(C2437c.f7424f, false);
            crashDetailBean.f7327A = this.f7468d.f7258d;
            crashDetailBean.f7328B = thread.getName() + "(" + thread.getId() + ")";
            crashDetailBean.f7375z.put(crashDetailBean.f7328B, m5312a);
            crashDetailBean.f7335I = this.f7468d.m5437y();
            crashDetailBean.f7357h = this.f7468d.m5440v();
            crashDetailBean.f7358i = this.f7468d.m5487J();
            crashDetailBean.f7339M = this.f7468d.f7230a;
            crashDetailBean.f7340N = this.f7468d.m5476a();
            crashDetailBean.f7342P = this.f7468d.m5489H();
            crashDetailBean.f7343Q = this.f7468d.m5488I();
            crashDetailBean.f7344R = this.f7468d.m5495B();
            crashDetailBean.f7345S = this.f7468d.m5490G();
        } catch (Throwable th3) {
            C2499x.m5083e("handle crash error %s", th3.toString());
        }
        if (z) {
            this.f7466b.m5348c(crashDetailBean);
        } else {
            boolean z3 = str != null && str.length() > 0;
            if (bArr != null && bArr.length > 0) {
                z2 = true;
            }
            if (z3) {
                crashDetailBean.f7341O = new HashMap(1);
                crashDetailBean.f7341O.put("UserData", str);
            }
            if (z2) {
                crashDetailBean.f7346T = bArr;
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private static boolean m5314a(Thread thread) {
        synchronized (f7464i) {
            if (f7463h == null || !thread.getName().equals(f7463h)) {
                f7463h = thread.getName();
                return false;
            }
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x01b1, code lost:
        if (r8.f7470f != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b5, code lost:
        com.tencent.bugly.proguard.C2499x.m5083e("crashreport last handle start!", new java.lang.Object[0]);
        com.tencent.bugly.proguard.C2499x.m5083e("current process die", new java.lang.Object[0]);
        android.os.Process.killProcess(android.os.Process.myPid());
        java.lang.System.exit(1);
        com.tencent.bugly.proguard.C2499x.m5083e("crashreport last handle end!", new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01d4, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01f1, code lost:
        if (r8.f7470f != null) goto L23;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5313a(java.lang.Thread r9, java.lang.Throwable r10, boolean r11, java.lang.String r12, byte[] r13) {
        /*
            Method dump skipped, instructions count: 591
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.C2443e.m5313a(java.lang.Thread, java.lang.Throwable, boolean, java.lang.String, byte[]):void");
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        synchronized (f7464i) {
            m5313a(thread, th, true, null, null);
        }
    }

    /* renamed from: a */
    private static boolean m5315a(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        StackTraceElement[] stackTrace;
        if (uncaughtExceptionHandler == null) {
            return true;
        }
        String name = uncaughtExceptionHandler.getClass().getName();
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            if (name.equals(className) && "uncaughtException".equals(methodName)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public final synchronized void m5316a(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f7292g != this.f7471g) {
                C2499x.m5090a("java changed to %b", Boolean.valueOf(strategyBean.f7292g));
                if (strategyBean.f7292g) {
                    m5317a();
                    return;
                }
                m5311b();
            }
        }
    }

    /* renamed from: a */
    private static String m5312a(Throwable th, int i) {
        StackTraceElement[] stackTrace;
        if (th == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (th.getStackTrace() != null) {
                for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                    if (i > 0 && sb.length() >= i) {
                        sb.append("\n[Stack over limit size :" + i + " , has been cutted !]");
                        return sb.toString();
                    }
                    sb.append(stackTraceElement.toString());
                    sb.append("\n");
                }
            }
        } catch (Throwable th2) {
            C2499x.m5083e("gen stack error %s", th2.toString());
        }
        return sb.toString();
    }

    /* renamed from: b */
    private static String m5309b(Throwable th, int i) {
        if (th.getMessage() == null) {
            return "";
        }
        if (th.getMessage().length() <= 1000) {
            return th.getMessage();
        }
        return th.getMessage().substring(0, 1000) + "\n[Message over limit size:1000, has been cutted!]";
    }
}
