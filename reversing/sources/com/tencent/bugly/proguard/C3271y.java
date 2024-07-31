package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C2419a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.y */
/* loaded from: classes2.dex */
public final class C2500y {

    /* renamed from: a */
    public static boolean f7766a = true;

    /* renamed from: b */
    private static SimpleDateFormat f7767b = null;

    /* renamed from: c */
    private static int f7768c = 5120;

    /* renamed from: d */
    private static StringBuilder f7769d = null;

    /* renamed from: e */
    private static StringBuilder f7770e = null;

    /* renamed from: f */
    private static boolean f7771f = false;

    /* renamed from: g */
    private static C2502a f7772g = null;

    /* renamed from: h */
    private static String f7773h = null;

    /* renamed from: i */
    private static String f7774i = null;

    /* renamed from: j */
    private static Context f7775j = null;

    /* renamed from: k */
    private static String f7776k = null;

    /* renamed from: l */
    private static boolean f7777l = false;

    /* renamed from: m */
    private static boolean f7778m = false;

    /* renamed from: n */
    private static int f7779n;

    /* renamed from: o */
    private static final Object f7780o = new Object();

    /* renamed from: b */
    static /* synthetic */ boolean m5073b(boolean z) {
        f7771f = false;
        return false;
    }

    static {
        try {
            f7767b = new SimpleDateFormat("MM-dd HH:mm:ss");
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private static boolean m5074b(String str, String str2, String str3) {
        try {
            C2419a m5470b = C2419a.m5470b();
            if (m5470b == null || m5470b.f7207D == null) {
                return false;
            }
            return m5470b.f7207D.appendLogToNative(str, str2, str3);
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return false;
            }
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: f */
    private static String m5069f() {
        try {
            C2419a m5470b = C2419a.m5470b();
            if (m5470b == null || m5470b.f7207D == null) {
                return null;
            }
            return m5470b.f7207D.getLogFromNative();
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static synchronized void m5080a(Context context) {
        synchronized (C2500y.class) {
            if (f7777l || context == null || !f7766a) {
                return;
            }
            try {
                f7770e = new StringBuilder(0);
                f7769d = new StringBuilder(0);
                f7775j = context;
                C2419a m5474a = C2419a.m5474a(context);
                f7773h = m5474a.f7258d;
                m5474a.getClass();
                f7774i = "";
                f7776k = f7775j.getFilesDir().getPath() + "/buglylog_" + f7773h + "_" + f7774i + ".txt";
                f7779n = Process.myPid();
            } catch (Throwable unused) {
            }
            f7777l = true;
        }
    }

    /* renamed from: a */
    public static void m5081a(int i) {
        synchronized (f7780o) {
            f7768c = i;
            if (i < 0) {
                f7768c = 0;
            } else if (i > 10240) {
                f7768c = 10240;
            }
        }
    }

    /* renamed from: a */
    public static void m5076a(boolean z) {
        C2499x.m5090a("[LogUtil] Whether can record user log into native: " + z, new Object[0]);
        f7778m = z;
    }

    /* renamed from: a */
    public static void m5077a(String str, String str2, Throwable th) {
        if (th == null) {
            return;
        }
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        m5078a(str, str2, message + '\n' + C2503z.m5024b(th));
    }

    /* renamed from: a */
    public static synchronized void m5078a(String str, String str2, String str3) {
        synchronized (C2500y.class) {
            if (f7777l && f7766a) {
                if (f7778m && m5074b(str, str2, str3)) {
                    return;
                }
                long myTid = Process.myTid();
                f7769d.setLength(0);
                if (str3.length() > 30720) {
                    str3 = str3.substring(str3.length() - 30720, str3.length() - 1);
                }
                Date date = new Date();
                String format = f7767b != null ? f7767b.format(date) : date.toString();
                StringBuilder sb = f7769d;
                sb.append(format);
                sb.append(" ");
                sb.append(f7779n);
                sb.append(" ");
                sb.append(myTid);
                sb.append(" ");
                sb.append(str);
                sb.append(" ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                sb.append("\u0001\r\n");
                String sb2 = f7769d.toString();
                synchronized (f7780o) {
                    f7770e.append(sb2);
                    if (f7770e.length() <= f7768c) {
                        return;
                    }
                    if (f7771f) {
                        return;
                    }
                    f7771f = true;
                    C2497w.m5098a().m5097a(new Runnable() { // from class: com.tencent.bugly.proguard.y.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            synchronized (C2500y.f7780o) {
                                try {
                                    if (C2500y.f7772g == null) {
                                        C2502a unused = C2500y.f7772g = new C2502a(C2500y.f7776k);
                                    } else if (C2500y.f7772g.f7782b == null || C2500y.f7772g.f7782b.length() + C2500y.f7770e.length() > C2500y.f7772g.f7785e) {
                                        C2500y.f7772g.m5068a();
                                    }
                                    if (C2500y.f7772g.m5066a(C2500y.f7770e.toString())) {
                                        C2500y.f7770e.setLength(0);
                                        C2500y.m5073b(false);
                                    }
                                } catch (Throwable unused2) {
                                }
                            }
                        }
                    });
                }
            }
        }
    }

    /* renamed from: a */
    public static byte[] m5082a() {
        if (f7766a) {
            if (f7778m) {
                C2499x.m5090a("[LogUtil] Get user log from native.", new Object[0]);
                String m5069f = m5069f();
                if (m5069f != null) {
                    C2499x.m5090a("[LogUtil] Got user log from native: %d bytes", Integer.valueOf(m5069f.length()));
                    return C2503z.m5047a((File) null, m5069f, "BuglyNativeLog.txt");
                }
            }
            StringBuilder sb = new StringBuilder();
            synchronized (f7780o) {
                if (f7772g != null && f7772g.f7781a && f7772g.f7782b != null && f7772g.f7782b.length() > 0) {
                    sb.append(C2503z.m5049a(f7772g.f7782b, 30720, true));
                }
                if (f7770e != null && f7770e.length() > 0) {
                    sb.append(f7770e.toString());
                }
            }
            return C2503z.m5047a((File) null, sb.toString(), "BuglyLog.txt");
        }
        return null;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.y$a */
    /* loaded from: classes2.dex */
    public static class C2502a {

        /* renamed from: a */
        private boolean f7781a;

        /* renamed from: b */
        private File f7782b;

        /* renamed from: c */
        private String f7783c;

        /* renamed from: d */
        private long f7784d;

        /* renamed from: e */
        private long f7785e = 30720;

        public C2502a(String str) {
            if (str == null || str.equals("")) {
                return;
            }
            this.f7783c = str;
            this.f7781a = m5068a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public boolean m5068a() {
            try {
                this.f7782b = new File(this.f7783c);
                if (this.f7782b.exists() && !this.f7782b.delete()) {
                    this.f7781a = false;
                    return false;
                } else if (this.f7782b.createNewFile()) {
                    return true;
                } else {
                    this.f7781a = false;
                    return false;
                }
            } catch (Throwable th) {
                C2499x.m5089a(th);
                this.f7781a = false;
                return false;
            }
        }

        /* renamed from: a */
        public final boolean m5066a(String str) {
            FileOutputStream fileOutputStream;
            byte[] bytes;
            if (this.f7781a) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    fileOutputStream = new FileOutputStream(this.f7782b, true);
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    fileOutputStream.write(str.getBytes("UTF-8"));
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    this.f7784d += bytes.length;
                    this.f7781a = true;
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                    return true;
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        C2499x.m5089a(th);
                        this.f7781a = false;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused2) {
                            }
                        }
                        return false;
                    } catch (Throwable th3) {
                        FileOutputStream fileOutputStream3 = fileOutputStream2;
                        if (fileOutputStream3 != null) {
                            try {
                                fileOutputStream3.close();
                            } catch (IOException unused3) {
                            }
                        }
                        throw th3;
                    }
                }
            }
            return false;
        }
    }
}
