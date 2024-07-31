package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Base64;
import com.senseplay.sdk.zxing.utils.PermissionsUtil;
import com.tencent.bugly.C2404b;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.u */
/* loaded from: classes2.dex */
public final class C2492u {

    /* renamed from: b */
    private static C2492u f7711b;

    /* renamed from: a */
    public boolean f7712a;

    /* renamed from: d */
    private final Context f7714d;

    /* renamed from: f */
    private long f7716f;

    /* renamed from: g */
    private long f7717g;

    /* renamed from: k */
    private String f7721k;

    /* renamed from: e */
    private Map<Integer, Long> f7715e = new HashMap();

    /* renamed from: h */
    private LinkedBlockingQueue<Runnable> f7718h = new LinkedBlockingQueue<>();

    /* renamed from: i */
    private LinkedBlockingQueue<Runnable> f7719i = new LinkedBlockingQueue<>();

    /* renamed from: j */
    private final Object f7720j = new Object();

    /* renamed from: l */
    private byte[] f7722l = null;

    /* renamed from: m */
    private long f7723m = 0;

    /* renamed from: n */
    private byte[] f7724n = null;

    /* renamed from: o */
    private long f7725o = 0;

    /* renamed from: p */
    private String f7726p = null;

    /* renamed from: q */
    private long f7727q = 0;

    /* renamed from: r */
    private final Object f7728r = new Object();

    /* renamed from: s */
    private boolean f7729s = false;

    /* renamed from: t */
    private final Object f7730t = new Object();

    /* renamed from: u */
    private int f7731u = 0;

    /* renamed from: c */
    private final C2486p f7713c = C2486p.m5175a();

    /* renamed from: a */
    static /* synthetic */ boolean m5123a(C2492u c2492u, boolean z) {
        c2492u.f7729s = false;
        return false;
    }

    /* renamed from: b */
    static /* synthetic */ int m5113b(C2492u c2492u) {
        int i = c2492u.f7731u - 1;
        c2492u.f7731u = i;
        return i;
    }

    private C2492u(Context context) {
        this.f7721k = null;
        this.f7712a = true;
        this.f7714d = context;
        try {
            Class.forName("android.util.Base64");
        } catch (ClassNotFoundException unused) {
            C2499x.m5090a("[UploadManager] Error: Can not find Base64 class, will not use stronger security way to upload", new Object[0]);
            this.f7712a = false;
        }
        if (this.f7712a) {
            this.f7721k = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDP9x32s5pPtZBXzJBz2GWM/sbTvVO2+RvW0PH01IdaBxc/fB6fbHZocC9T3nl1+J5eAFjIRVuV8vHDky7Qo82Mnh0PVvcZIEQvMMVKU8dsMQopxgsOs2gkSHJwgWdinKNS8CmWobo6pFwPUW11lMv714jAUZRq2GBOqiO2vQI6iwIDAQAB";
        }
    }

    /* renamed from: a */
    public static synchronized C2492u m5127a(Context context) {
        C2492u c2492u;
        synchronized (C2492u.class) {
            if (f7711b == null) {
                f7711b = new C2492u(context);
            }
            c2492u = f7711b;
        }
        return c2492u;
    }

    /* renamed from: a */
    public static synchronized C2492u m5135a() {
        C2492u c2492u;
        synchronized (C2492u.class) {
            c2492u = f7711b;
        }
        return c2492u;
    }

    /* renamed from: a */
    public final void m5131a(int i, C2463am c2463am, String str, String str2, InterfaceC2491t interfaceC2491t, long j, boolean z) {
        try {
            m5119a(new RunnableC2496v(this.f7714d, i, c2463am.f7569g, C2450a.m5276a((Object) c2463am), str, str2, interfaceC2491t, this.f7712a, z), true, true, j);
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m5133a(int i, int i2, byte[] bArr, String str, String str2, InterfaceC2491t interfaceC2491t, int i3, int i4, boolean z, Map<String, String> map) {
        try {
            m5119a(new RunnableC2496v(this.f7714d, i, i2, bArr, str, str2, interfaceC2491t, this.f7712a, i3, i4, false, map), z, false, 0L);
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m5130a(int i, C2463am c2463am, String str, String str2, InterfaceC2491t interfaceC2491t, boolean z) {
        m5133a(i, c2463am.f7569g, C2450a.m5276a((Object) c2463am), str, str2, interfaceC2491t, 0, 0, z, null);
    }

    /* renamed from: a */
    public final long m5117a(boolean z) {
        long j;
        long m5032b = C2503z.m5032b();
        int i = z ? 5 : 3;
        List<C2489r> m5174a = this.f7713c.m5174a(i);
        if (m5174a != null && m5174a.size() > 0) {
            j = 0;
            try {
                C2489r c2489r = m5174a.get(0);
                if (c2489r.f7705e >= m5032b) {
                    j = C2503z.m5016c(c2489r.f7707g);
                    if (i == 3) {
                        this.f7716f = j;
                    } else {
                        this.f7717g = j;
                    }
                    m5174a.remove(c2489r);
                }
            } catch (Throwable th) {
                C2499x.m5089a(th);
            }
            if (m5174a.size() > 0) {
                this.f7713c.m5153a(m5174a);
            }
        } else {
            j = z ? this.f7717g : this.f7716f;
        }
        C2499x.m5085c("[UploadManager] Local network consume: %d KB", Long.valueOf(j / 1024));
        return j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final synchronized void m5128a(long j, boolean z) {
        int i = z ? 5 : 3;
        C2489r c2489r = new C2489r();
        c2489r.f7702b = i;
        c2489r.f7705e = C2503z.m5032b();
        c2489r.f7703c = "";
        c2489r.f7704d = "";
        c2489r.f7707g = C2503z.m5019c(j);
        this.f7713c.m5151b(i);
        this.f7713c.m5159a(c2489r);
        if (z) {
            this.f7717g = j;
        } else {
            this.f7716f = j;
        }
        C2499x.m5085c("[UploadManager] Network total consume: %d KB", Long.valueOf(j / 1024));
    }

    /* renamed from: a */
    public final synchronized void m5132a(int i, long j) {
        if (i < 0) {
            C2499x.m5083e("[UploadManager] Unknown uploading ID: %d", Integer.valueOf(i));
            return;
        }
        this.f7715e.put(Integer.valueOf(i), Long.valueOf(j));
        C2489r c2489r = new C2489r();
        c2489r.f7702b = i;
        c2489r.f7705e = j;
        c2489r.f7703c = "";
        c2489r.f7704d = "";
        c2489r.f7707g = new byte[0];
        this.f7713c.m5151b(i);
        this.f7713c.m5159a(c2489r);
        C2499x.m5085c("[UploadManager] Uploading(ID:%d) time: %s", Integer.valueOf(i), C2503z.m5058a(j));
    }

    /* renamed from: a */
    public final synchronized long m5134a(int i) {
        long j = 0;
        if (i >= 0) {
            Long l = this.f7715e.get(Integer.valueOf(i));
            if (l != null) {
                return l.longValue();
            }
            List<C2489r> m5174a = this.f7713c.m5174a(i);
            if (m5174a != null && m5174a.size() > 0) {
                if (m5174a.size() > 1) {
                    for (C2489r c2489r : m5174a) {
                        if (c2489r.f7705e > j) {
                            j = c2489r.f7705e;
                        }
                    }
                    this.f7713c.m5151b(i);
                } else {
                    j = m5174a.get(0).f7705e;
                }
            }
        } else {
            C2499x.m5083e("[UploadManager] Unknown upload ID: %d", Integer.valueOf(i));
        }
        return j;
    }

    /* renamed from: b */
    public final boolean m5114b(int i) {
        if (C2404b.f7146c) {
            C2499x.m5085c("Uploading frequency will not be checked if SDK is in debug mode.", new Object[0]);
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis() - m5134a(i);
        C2499x.m5085c("[UploadManager] Time interval is %d seconds since last uploading(ID: %d).", Long.valueOf(currentTimeMillis / 1000), Integer.valueOf(i));
        if (currentTimeMillis < 30000) {
            C2499x.m5090a("[UploadManager] Data only be uploaded once in %d seconds.", 30L);
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m5110c() {
        C2499x.m5085c("[UploadManager] Drop security info of database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C2486p m5175a = C2486p.m5175a();
            if (m5175a == null) {
                C2499x.m5084d("[UploadManager] Failed to get Database", new Object[0]);
                return false;
            }
            return m5175a.m5170a(PermissionsUtil.HANDLER_RIGHT, "security_info", (InterfaceC2485o) null, true);
        } catch (Throwable th) {
            C2499x.m5089a(th);
            return false;
        }
    }

    /* renamed from: d */
    private boolean m5107d() {
        C2499x.m5085c("[UploadManager] Record security info to database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C2486p m5175a = C2486p.m5175a();
            if (m5175a == null) {
                C2499x.m5084d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            StringBuilder sb = new StringBuilder();
            if (this.f7724n != null) {
                sb.append(Base64.encodeToString(this.f7724n, 0));
                sb.append("#");
                if (this.f7725o != 0) {
                    sb.append(Long.toString(this.f7725o));
                } else {
                    sb.append("null");
                }
                sb.append("#");
                if (this.f7726p != null) {
                    sb.append(this.f7726p);
                } else {
                    sb.append("null");
                }
                sb.append("#");
                if (this.f7727q != 0) {
                    sb.append(Long.toString(this.f7727q));
                } else {
                    sb.append("null");
                }
                m5175a.m5168a(PermissionsUtil.HANDLER_RIGHT, "security_info", sb.toString().getBytes(), (InterfaceC2485o) null, true);
                return true;
            }
            C2499x.m5085c("[UploadManager] AES key is null, will not record", new Object[0]);
            return false;
        } catch (Throwable th) {
            C2499x.m5089a(th);
            m5110c();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public boolean m5105e() {
        boolean z;
        C2499x.m5085c("[UploadManager] Load security info from database (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        try {
            C2486p m5175a = C2486p.m5175a();
            if (m5175a == null) {
                C2499x.m5084d("[UploadManager] Failed to get database", new Object[0]);
                return false;
            }
            Map<String, byte[]> m5172a = m5175a.m5172a(PermissionsUtil.HANDLER_RIGHT, (InterfaceC2485o) null, true);
            if (m5172a != null && m5172a.containsKey("security_info")) {
                String str = new String(m5172a.get("security_info"));
                String[] split = str.split("#");
                if (split.length == 4) {
                    if (!split[0].isEmpty() && !split[0].equals("null")) {
                        this.f7724n = Base64.decode(split[0], 0);
                    }
                    z = false;
                    if (0 == 0 && !split[1].isEmpty() && !split[1].equals("null")) {
                        this.f7725o = Long.parseLong(split[1]);
                    }
                    if (0 == 0 && !split[2].isEmpty() && !split[2].equals("null")) {
                        this.f7726p = split[2];
                    }
                    if (0 == 0 && !split[3].isEmpty() && !split[3].equals("null")) {
                        this.f7727q = Long.parseLong(split[3]);
                    }
                } else {
                    C2499x.m5090a("SecurityInfo = %s, Strings.length = %d", str, Integer.valueOf(split.length));
                    z = true;
                }
                if (z) {
                    m5110c();
                }
            }
            return true;
        } catch (Throwable th) {
            C2499x.m5089a(th);
            return false;
        }
    }

    /* renamed from: b */
    protected final boolean m5115b() {
        if (this.f7726p == null || this.f7727q == 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() + this.f7723m;
        long j = this.f7727q;
        if (j < currentTimeMillis) {
            C2499x.m5085c("[UploadManager] Session ID expired time from server is: %d(%s), but now is: %d(%s)", Long.valueOf(j), new Date(this.f7727q).toString(), Long.valueOf(currentTimeMillis), new Date(currentTimeMillis).toString());
            return false;
        }
        return true;
    }

    /* renamed from: b */
    protected final void m5112b(boolean z) {
        synchronized (this.f7728r) {
            C2499x.m5085c("[UploadManager] Clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            this.f7724n = null;
            this.f7726p = null;
            this.f7727q = 0L;
        }
        if (z) {
            m5110c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006c A[Catch: all -> 0x0159, TRY_LEAVE, TryCatch #3 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:22:0x0062, B:27:0x006c, B:33:0x008d, B:36:0x0093, B:42:0x00b4, B:43:0x00b7, B:17:0x0059, B:19:0x005d, B:29:0x0076, B:38:0x009d), top: B:85:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0093 A[Catch: all -> 0x0159, TRY_LEAVE, TryCatch #3 {, blocks: (B:8:0x001c, B:11:0x0049, B:12:0x0050, B:22:0x0062, B:27:0x006c, B:33:0x008d, B:36:0x0093, B:42:0x00b4, B:43:0x00b7, B:17:0x0059, B:19:0x005d, B:29:0x0076, B:38:0x009d), top: B:85:0x001c }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m5109c(int r14) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C2492u.m5109c(int):void");
    }

    /* renamed from: a */
    private boolean m5120a(Runnable runnable, boolean z) {
        if (runnable == null) {
            C2499x.m5090a("[UploadManager] Upload task should not be null", new Object[0]);
            return false;
        }
        try {
            C2499x.m5085c("[UploadManager] Add upload task to queue (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            synchronized (this.f7720j) {
                if (z) {
                    this.f7718h.put(runnable);
                } else {
                    this.f7719i.put(runnable);
                }
            }
            return true;
        } catch (Throwable th) {
            C2499x.m5083e("[UploadManager] Failed to add upload task to queue: %s", th.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5121a(Runnable runnable, long j) {
        if (runnable == null) {
            C2499x.m5084d("[UploadManager] Upload task should not be null", new Object[0]);
            return;
        }
        C2499x.m5085c("[UploadManager] Execute synchronized upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        Thread m5044a = C2503z.m5044a(runnable, "BUGLY_SYNC_UPLOAD");
        if (m5044a == null) {
            C2499x.m5083e("[UploadManager] Failed to start a thread to execute synchronized upload task, add it to queue.", new Object[0]);
            m5120a(runnable, true);
            return;
        }
        try {
            m5044a.join(j);
        } catch (Throwable th) {
            C2499x.m5083e("[UploadManager] Failed to join upload synchronized task with message: %s. Add it to queue.", th.getMessage());
            m5120a(runnable, true);
            m5109c(0);
        }
    }

    /* renamed from: a */
    private void m5119a(Runnable runnable, boolean z, boolean z2, long j) {
        if (runnable == null) {
            C2499x.m5084d("[UploadManager] Upload task should not be null", new Object[0]);
        }
        C2499x.m5085c("[UploadManager] Add upload task (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        if (this.f7726p != null) {
            if (m5115b()) {
                C2499x.m5085c("[UploadManager] Sucessfully got session ID, try to execute upload task now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                if (z2) {
                    m5121a(runnable, j);
                    return;
                }
                m5120a(runnable, z);
                m5109c(0);
                return;
            }
            C2499x.m5090a("[UploadManager] Session ID is expired, drop it (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            m5112b(false);
        }
        synchronized (this.f7730t) {
            if (this.f7729s) {
                m5120a(runnable, z);
                return;
            }
            this.f7729s = true;
            C2499x.m5085c("[UploadManager] Initialize security context now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            if (z2) {
                m5121a(new RunnableC2495a(this.f7714d, runnable, j), 0L);
                return;
            }
            m5120a(runnable, z);
            RunnableC2495a runnableC2495a = new RunnableC2495a(this.f7714d);
            C2499x.m5090a("[UploadManager] Create and start a new thread to execute a task of initializing security context: %s", "BUGLY_ASYNC_UPLOAD");
            if (C2503z.m5044a(runnableC2495a, "BUGLY_ASYNC_UPLOAD") == null) {
                C2499x.m5084d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                C2497w m5098a = C2497w.m5098a();
                if (m5098a != null) {
                    m5098a.m5097a(runnableC2495a);
                    return;
                }
                C2499x.m5083e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                synchronized (this.f7730t) {
                    this.f7729s = false;
                }
            }
        }
    }

    /* renamed from: a */
    public final void m5129a(int i, C2464an c2464an) {
        if (this.f7712a) {
            boolean z = true;
            if (i == 2) {
                C2499x.m5085c("[UploadManager] Session ID is invalid, will clear security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                m5112b(true);
            } else {
                synchronized (this.f7730t) {
                    if (!this.f7729s) {
                        return;
                    }
                    if (c2464an != null) {
                        C2499x.m5085c("[UploadManager] Record security context (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        try {
                            Map<String, String> map = c2464an.f7595g;
                            if (map != null && map.containsKey("S1") && map.containsKey("S2")) {
                                this.f7723m = c2464an.f7593e - System.currentTimeMillis();
                                C2499x.m5085c("[UploadManager] Time lag of server is: %d", Long.valueOf(this.f7723m));
                                this.f7726p = map.get("S1");
                                C2499x.m5085c("[UploadManager] Session ID from server is: %s", this.f7726p);
                                if (this.f7726p.length() > 0) {
                                    try {
                                        this.f7727q = Long.parseLong(map.get("S2"));
                                        C2499x.m5085c("[UploadManager] Session expired time from server is: %d(%s)", Long.valueOf(this.f7727q), new Date(this.f7727q).toString());
                                        if (this.f7727q < 1000) {
                                            C2499x.m5084d("[UploadManager] Session expired time from server is less than 1 second, will set to default value", new Object[0]);
                                            this.f7727q = 259200000L;
                                        }
                                    } catch (NumberFormatException unused) {
                                        C2499x.m5084d("[UploadManager] Session expired time is invalid, will set to default value", new Object[0]);
                                        this.f7727q = 259200000L;
                                    }
                                    if (m5107d()) {
                                        z = false;
                                    } else {
                                        C2499x.m5085c("[UploadManager] Failed to record database", new Object[0]);
                                    }
                                    m5109c(0);
                                } else {
                                    C2499x.m5085c("[UploadManager] Session ID from server is invalid, try next time", new Object[0]);
                                }
                            }
                        } catch (Throwable th) {
                            C2499x.m5089a(th);
                        }
                        if (z) {
                            m5112b(false);
                        }
                    } else {
                        C2499x.m5085c("[UploadManager] Fail to init security context and clear local info (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        m5112b(false);
                    }
                }
            }
            synchronized (this.f7730t) {
                if (this.f7729s) {
                    this.f7729s = false;
                    C2503z.m5029b(this.f7714d, "security_info");
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.u$a */
    /* loaded from: classes2.dex */
    public class RunnableC2495a implements Runnable {

        /* renamed from: a */
        private final Context f7736a;

        /* renamed from: b */
        private final Runnable f7737b;

        /* renamed from: c */
        private final long f7738c;

        public RunnableC2495a(Context context) {
            this.f7736a = context;
            this.f7737b = null;
            this.f7738c = 0L;
        }

        public RunnableC2495a(Context context, Runnable runnable, long j) {
            this.f7736a = context;
            this.f7737b = runnable;
            this.f7738c = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (C2503z.m5054a(this.f7736a, "security_info", 30000L)) {
                if (!C2492u.this.m5105e()) {
                    C2499x.m5084d("[UploadManager] Failed to load security info from database", new Object[0]);
                    C2492u.this.m5112b(false);
                }
                if (C2492u.this.f7726p != null) {
                    if (C2492u.this.m5115b()) {
                        C2499x.m5085c("[UploadManager] Sucessfully got session ID, try to execute upload tasks now (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                        Runnable runnable = this.f7737b;
                        if (runnable != null) {
                            C2492u.this.m5121a(runnable, this.f7738c);
                        }
                        C2492u.this.m5109c(0);
                        C2503z.m5029b(this.f7736a, "security_info");
                        synchronized (C2492u.this.f7730t) {
                            C2492u.m5123a(C2492u.this, false);
                        }
                        return;
                    }
                    C2499x.m5090a("[UploadManager] Session ID is expired, drop it.", new Object[0]);
                    C2492u.this.m5112b(true);
                }
                byte[] m5061a = C2503z.m5061a(128);
                if (m5061a != null && (m5061a.length << 3) == 128) {
                    C2492u.this.f7724n = m5061a;
                    C2499x.m5085c("[UploadManager] Execute one upload task for requesting session ID (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    Runnable runnable2 = this.f7737b;
                    if (runnable2 != null) {
                        C2492u.this.m5121a(runnable2, this.f7738c);
                        return;
                    } else {
                        C2492u.this.m5109c(1);
                        return;
                    }
                }
                C2499x.m5084d("[UploadManager] Failed to create AES key (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                C2492u.this.m5112b(false);
                C2503z.m5029b(this.f7736a, "security_info");
                synchronized (C2492u.this.f7730t) {
                    C2492u.m5123a(C2492u.this, false);
                }
                return;
            }
            C2499x.m5085c("[UploadManager] Sleep %d try to lock security file again (pid=%d | tid=%d)", 5000, Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            C2503z.m5030b(5000L);
            if (C2503z.m5044a(this, "BUGLY_ASYNC_UPLOAD") == null) {
                C2499x.m5084d("[UploadManager] Failed to start a thread to execute task of initializing security context, try to post it into thread pool.", new Object[0]);
                C2497w m5098a = C2497w.m5098a();
                if (m5098a != null) {
                    m5098a.m5097a(this);
                } else {
                    C2499x.m5083e("[UploadManager] Asynchronous thread pool is unavailable now, try next time.", new Object[0]);
                }
            }
        }
    }

    /* renamed from: a */
    public final byte[] m5116a(byte[] bArr) {
        byte[] bArr2 = this.f7724n;
        if (bArr2 == null || (bArr2.length << 3) != 128) {
            C2499x.m5084d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return null;
        }
        return C2503z.m5059a(1, bArr, bArr2);
    }

    /* renamed from: b */
    public final byte[] m5111b(byte[] bArr) {
        byte[] bArr2 = this.f7724n;
        if (bArr2 == null || (bArr2.length << 3) != 128) {
            C2499x.m5084d("[UploadManager] AES key is invalid (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
            return null;
        }
        return C2503z.m5059a(2, bArr, bArr2);
    }

    /* renamed from: a */
    public final boolean m5118a(Map<String, String> map) {
        if (map == null) {
            return false;
        }
        C2499x.m5085c("[UploadManager] Integrate security to HTTP headers (pid=%d | tid=%d)", Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
        String str = this.f7726p;
        if (str != null) {
            map.put("secureSessionId", str);
            return true;
        }
        byte[] bArr = this.f7724n;
        if (bArr == null || (bArr.length << 3) != 128) {
            C2499x.m5084d("[UploadManager] AES key is invalid", new Object[0]);
            return false;
        }
        if (this.f7722l == null) {
            this.f7722l = Base64.decode(this.f7721k, 0);
            if (this.f7722l == null) {
                C2499x.m5084d("[UploadManager] Failed to decode RSA public key", new Object[0]);
                return false;
            }
        }
        byte[] m5031b = C2503z.m5031b(1, this.f7724n, this.f7722l);
        if (m5031b == null) {
            C2499x.m5084d("[UploadManager] Failed to encrypt AES key", new Object[0]);
            return false;
        }
        String encodeToString = Base64.encodeToString(m5031b, 0);
        if (encodeToString == null) {
            C2499x.m5084d("[UploadManager] Failed to encode AES key", new Object[0]);
            return false;
        }
        map.put("raKey", encodeToString);
        return true;
    }
}
