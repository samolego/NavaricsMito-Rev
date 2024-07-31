package com.tencent.bugly.crashreport.crash.jni;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.bugly.BUGLY;
import com.tencent.bugly.crashreport.InterfaceC2407a;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C2435b;
import com.tencent.bugly.crashreport.crash.C2437c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import java.io.File;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class NativeCrashHandler implements InterfaceC2407a {

    /* renamed from: a */
    private static NativeCrashHandler f7491a = null;

    /* renamed from: l */
    private static boolean f7492l = false;

    /* renamed from: m */
    private static boolean f7493m = false;

    /* renamed from: o */
    private static boolean f7494o = true;

    /* renamed from: b */
    private final Context f7495b;

    /* renamed from: c */
    private final C2419a f7496c;

    /* renamed from: d */
    private final C2497w f7497d;

    /* renamed from: e */
    private NativeExceptionHandler f7498e;

    /* renamed from: f */
    private String f7499f;

    /* renamed from: g */
    private final boolean f7500g;

    /* renamed from: h */
    private boolean f7501h = false;

    /* renamed from: i */
    private boolean f7502i = false;

    /* renamed from: j */
    private boolean f7503j = false;

    /* renamed from: k */
    private boolean f7504k = false;

    /* renamed from: n */
    private C2435b f7505n;

    protected native boolean appendNativeLog(String str, String str2, String str3);

    protected native boolean appendWholeNativeLog(String str);

    protected native String getNativeKeyValueList();

    protected native String getNativeLog();

    protected native boolean putNativeKeyValue(String str, String str2);

    protected native String regist(String str, boolean z, int i);

    protected native String removeNativeKeyValue(String str);

    protected native void setNativeInfo(int i, String str);

    protected native void testCrash();

    protected native String unregist();

    @SuppressLint({"SdCardPath"})
    private NativeCrashHandler(Context context, C2419a c2419a, C2435b c2435b, C2497w c2497w, boolean z, String str) {
        this.f7495b = C2503z.m5057a(context);
        try {
            if (C2503z.m5043a(str)) {
                str = context.getDir("bugly", 0).getAbsolutePath();
            }
        } catch (Throwable unused) {
            str = "/data/data/" + C2419a.m5474a(context).f7257c + "/app_bugly";
        }
        this.f7505n = c2435b;
        this.f7499f = str;
        this.f7496c = c2419a;
        this.f7497d = c2497w;
        this.f7500g = z;
        this.f7498e = new C2447a(context, c2419a, c2435b, C2422a.m5399a());
    }

    public static synchronized NativeCrashHandler getInstance(Context context, C2419a c2419a, C2435b c2435b, C2422a c2422a, C2497w c2497w, boolean z, String str) {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            if (f7491a == null) {
                f7491a = new NativeCrashHandler(context, c2419a, c2435b, c2497w, z, str);
            }
            nativeCrashHandler = f7491a;
        }
        return nativeCrashHandler;
    }

    public static synchronized NativeCrashHandler getInstance() {
        NativeCrashHandler nativeCrashHandler;
        synchronized (NativeCrashHandler.class) {
            nativeCrashHandler = f7491a;
        }
        return nativeCrashHandler;
    }

    public synchronized String getDumpFilePath() {
        return this.f7499f;
    }

    public synchronized void setDumpFilePath(String str) {
        this.f7499f = str;
    }

    public static void setShouldHandleInJava(boolean z) {
        f7494o = z;
        NativeCrashHandler nativeCrashHandler = f7491a;
        if (nativeCrashHandler != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(z);
            nativeCrashHandler.m5304a(999, sb.toString());
        }
    }

    public static boolean isShouldHandleInJava() {
        return f7494o;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(15:14|(1:16)(14:38|(1:40)|18|19|(1:21)|22|(1:24)|26|(1:28)(1:36)|29|(1:31)(1:35)|32|33|34)|17|18|19|(0)|22|(0)|26|(0)(0)|29|(0)(0)|32|33|34) */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f A[Catch: Throwable -> 0x008d, TryCatch #0 {Throwable -> 0x008d, blocks: (B:21:0x0075, B:23:0x007f, B:24:0x0081, B:26:0x008b), top: B:66:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: Throwable -> 0x008d, TRY_LEAVE, TryCatch #0 {Throwable -> 0x008d, blocks: (B:21:0x0075, B:23:0x007f, B:24:0x0081, B:26:0x008b), top: B:66:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091 A[Catch: Throwable -> 0x00c0, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:58:0x0199, B:39:0x00c9, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:70:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099 A[Catch: Throwable -> 0x00c0, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:58:0x0199, B:39:0x00c9, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:70:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a4 A[Catch: Throwable -> 0x00c0, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:58:0x0199, B:39:0x00c9, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:70:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ac A[Catch: Throwable -> 0x00c0, TryCatch #3 {, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x000f, B:58:0x0199, B:39:0x00c9, B:11:0x0015, B:13:0x001d, B:15:0x004f, B:16:0x005c, B:27:0x008d, B:29:0x0091, B:31:0x00a0, B:33:0x00a4, B:35:0x00b3, B:34:0x00ac, B:30:0x0099, B:17:0x0061, B:19:0x0067), top: B:70:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private synchronized void m5300a(boolean r11) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.m5300a(boolean):void");
    }

    public synchronized void startNativeMonitor() {
        if (!this.f7502i && !this.f7501h) {
            String str = "Bugly";
            boolean z = !C2503z.m5043a(this.f7496c.f7267m);
            String str2 = this.f7496c.f7267m;
            if (z) {
                str = str2;
            } else {
                this.f7496c.getClass();
            }
            this.f7502i = m5301a(str, z);
            if (this.f7502i || this.f7501h) {
                m5300a(this.f7500g);
                if (f7492l) {
                    setNativeAppVersion(this.f7496c.f7264j);
                    setNativeAppChannel(this.f7496c.f7266l);
                    setNativeAppPackage(this.f7496c.f7257c);
                    setNativeUserId(this.f7496c.m5456g());
                    setNativeIsAppForeground(this.f7496c.m5476a());
                    setNativeLaunchTime(this.f7496c.f7230a);
                }
                return;
            }
            return;
        }
        m5300a(this.f7500g);
    }

    public void checkUploadRecordCrash() {
        this.f7497d.m5097a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler.1
            @Override // java.lang.Runnable
            public final void run() {
                if (C2503z.m5054a(NativeCrashHandler.this.f7495b, "native_record_lock", 10000L)) {
                    if (!NativeCrashHandler.f7494o) {
                        NativeCrashHandler.this.m5304a(999, BUGLY.SDK_IS_DEV);
                    }
                    CrashDetailBean m5292a = C2448b.m5292a(NativeCrashHandler.this.f7495b, NativeCrashHandler.this.f7499f, NativeCrashHandler.this.f7498e);
                    if (m5292a != null) {
                        C2499x.m5090a("[Native] Get crash from native record.", new Object[0]);
                        if (!NativeCrashHandler.this.f7505n.m5361a(m5292a)) {
                            NativeCrashHandler.this.f7505n.m5359a(m5292a, 3000L, false);
                        }
                        C2448b.m5286a(false, NativeCrashHandler.this.f7499f);
                    }
                    NativeCrashHandler.this.m5305a();
                    C2503z.m5029b(NativeCrashHandler.this.f7495b, "native_record_lock");
                    return;
                }
                C2499x.m5090a("[Native] Failed to lock file for handling native crash record.", new Object[0]);
            }
        });
    }

    /* renamed from: a */
    private static boolean m5301a(String str, boolean z) {
        boolean z2;
        try {
            C2499x.m5090a("[Native] Trying to load so: %s", str);
            if (z) {
                System.load(str);
            } else {
                System.loadLibrary(str);
            }
        } catch (Throwable th) {
            th = th;
            z2 = false;
        }
        try {
            C2499x.m5090a("[Native] Successfully loaded SO: %s", str);
            return true;
        } catch (Throwable th2) {
            th = th2;
            z2 = true;
            C2499x.m5084d(th.getMessage(), new Object[0]);
            C2499x.m5084d("[Native] Failed to load so: %s", str);
            return z2;
        }
    }

    /* renamed from: c */
    private synchronized void m5296c() {
        if (!this.f7503j) {
            C2499x.m5084d("[Native] Native crash report has already unregistered.", new Object[0]);
        } else if (unregist() != null) {
            C2499x.m5090a("[Native] Successfully closed native crash report.", new Object[0]);
            this.f7503j = false;
        } else {
            C2503z.m5040a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "enableHandler", null, new Class[]{Boolean.TYPE}, new Object[]{false});
            this.f7503j = false;
            C2499x.m5090a("[Native] Successfully closed native crash report.", new Object[0]);
        }
    }

    public void testNativeCrash() {
        if (!this.f7502i) {
            C2499x.m5084d("[Native] Bugly SO file has not been load.", new Object[0]);
        } else {
            testCrash();
        }
    }

    public void testNativeCrash(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        sb.append(z);
        m5304a(16, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2);
        m5304a(17, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z3);
        m5304a(18, sb3.toString());
        testNativeCrash();
    }

    public NativeExceptionHandler getNativeExceptionHandler() {
        return this.f7498e;
    }

    /* renamed from: a */
    protected final void m5305a() {
        long m5032b = C2503z.m5032b() - C2437c.f7425g;
        long m5032b2 = C2503z.m5032b() + 86400000;
        File file = new File(this.f7499f);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    int i2 = 0;
                    for (File file2 : listFiles) {
                        long lastModified = file2.lastModified();
                        if (lastModified < m5032b || lastModified >= m5032b2) {
                            C2499x.m5090a("[Native] Delete record file: %s", file2.getAbsolutePath());
                            i++;
                            if (file2.delete()) {
                                i2++;
                            }
                        }
                    }
                    C2499x.m5085c("[Native] Number of record files overdue: %d, has deleted: %d", Integer.valueOf(i), Integer.valueOf(i2));
                }
            } catch (Throwable th) {
                C2499x.m5089a(th);
            }
        }
    }

    public void removeEmptyNativeRecordFiles() {
        C2448b.m5283c(this.f7499f);
    }

    /* renamed from: b */
    private synchronized void m5297b(boolean z) {
        if (z) {
            startNativeMonitor();
        } else {
            m5296c();
        }
    }

    public synchronized boolean isUserOpened() {
        return this.f7504k;
    }

    /* renamed from: c */
    private synchronized void m5294c(boolean z) {
        if (this.f7504k != z) {
            C2499x.m5090a("user change native %b", Boolean.valueOf(z));
            this.f7504k = z;
        }
    }

    public synchronized void setUserOpened(boolean z) {
        m5294c(z);
        boolean isUserOpened = isUserOpened();
        C2422a m5399a = C2422a.m5399a();
        if (m5399a != null) {
            isUserOpened = isUserOpened && m5399a.m5390c().f7292g;
        }
        if (isUserOpened != this.f7503j) {
            C2499x.m5090a("native changed to %b", Boolean.valueOf(isUserOpened));
            m5297b(isUserOpened);
        }
    }

    public synchronized void onStrategyChanged(StrategyBean strategyBean) {
        if (strategyBean != null) {
            if (strategyBean.f7292g != this.f7503j) {
                C2499x.m5084d("server native changed to %b", Boolean.valueOf(strategyBean.f7292g));
            }
        }
        boolean z = C2422a.m5399a().m5390c().f7292g && this.f7504k;
        if (z != this.f7503j) {
            C2499x.m5090a("native changed to %b", Boolean.valueOf(z));
            m5297b(z);
        }
    }

    @Override // com.tencent.bugly.crashreport.InterfaceC2407a
    public boolean appendLogToNative(String str, String str2, String str3) {
        if ((!this.f7501h && !this.f7502i) || !f7492l || str == null || str2 == null || str3 == null) {
            return false;
        }
        try {
            if (this.f7502i) {
                return appendNativeLog(str, str2, str3);
            }
            Boolean bool = (Boolean) C2503z.m5040a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "appendNativeLog", null, new Class[]{String.class, String.class, String.class}, new Object[]{str, str2, str3});
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        } catch (UnsatisfiedLinkError unused) {
            f7492l = false;
            return false;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    @Override // com.tencent.bugly.crashreport.InterfaceC2407a
    public String getLogFromNative() {
        if ((this.f7501h || this.f7502i) && f7492l) {
            try {
                if (this.f7502i) {
                    return getNativeLog();
                }
                return (String) C2503z.m5040a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "getNativeLog", null, null, null);
            } catch (UnsatisfiedLinkError unused) {
                f7492l = false;
                return null;
            } catch (Throwable th) {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
                return null;
            }
        }
        return null;
    }

    public boolean putKeyValueToNative(String str, String str2) {
        if ((this.f7501h || this.f7502i) && f7492l && str != null && str2 != null) {
            try {
                if (this.f7502i) {
                    return putNativeKeyValue(str, str2);
                }
                Boolean bool = (Boolean) C2503z.m5040a("com.tencent.feedback.eup.jni.NativeExceptionUpload", "putNativeKeyValue", null, new Class[]{String.class, String.class}, new Object[]{str, str2});
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (UnsatisfiedLinkError unused) {
                f7492l = false;
                return false;
            } catch (Throwable th) {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m5304a(int i, String str) {
        if (this.f7502i && f7493m) {
            try {
                setNativeInfo(i, str);
                return true;
            } catch (UnsatisfiedLinkError unused) {
                f7493m = false;
                return false;
            } catch (Throwable th) {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    public boolean filterSigabrtSysLog() {
        return m5304a(998, "true");
    }

    public boolean setNativeAppVersion(String str) {
        return m5304a(10, str);
    }

    public boolean setNativeAppChannel(String str) {
        return m5304a(12, str);
    }

    public boolean setNativeAppPackage(String str) {
        return m5304a(13, str);
    }

    public boolean setNativeUserId(String str) {
        return m5304a(11, str);
    }

    @Override // com.tencent.bugly.crashreport.InterfaceC2407a
    public boolean setNativeIsAppForeground(boolean z) {
        return m5304a(14, z ? "true" : BUGLY.SDK_IS_DEV);
    }

    public boolean setNativeLaunchTime(long j) {
        try {
            return m5304a(15, String.valueOf(j));
        } catch (NumberFormatException e) {
            if (C2499x.m5089a(e)) {
                return false;
            }
            e.printStackTrace();
            return false;
        }
    }
}
