package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.info.C2420b;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.C2435b;
import com.tencent.bugly.crashreport.crash.C2437c;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.anr.TraceFileHelper;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2500y;
import com.tencent.bugly.proguard.C2503z;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.log4j.Priority;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.anr.b */
/* loaded from: classes2.dex */
public final class C2432b {

    /* renamed from: c */
    private final Context f7400c;

    /* renamed from: d */
    private final C2419a f7401d;

    /* renamed from: e */
    private final C2497w f7402e;

    /* renamed from: f */
    private final C2422a f7403f;

    /* renamed from: g */
    private final String f7404g;

    /* renamed from: h */
    private final C2435b f7405h;

    /* renamed from: i */
    private FileObserver f7406i;

    /* renamed from: a */
    private AtomicInteger f7398a = new AtomicInteger(0);

    /* renamed from: b */
    private long f7399b = -1;

    /* renamed from: j */
    private boolean f7407j = true;

    public C2432b(Context context, C2422a c2422a, C2419a c2419a, C2497w c2497w, C2435b c2435b) {
        this.f7400c = C2503z.m5057a(context);
        this.f7404g = context.getDir("bugly", 0).getAbsolutePath();
        this.f7401d = c2419a;
        this.f7402e = c2497w;
        this.f7403f = c2422a;
        this.f7405h = c2435b;
    }

    /* renamed from: a */
    private CrashDetailBean m5375a(C2431a c2431a) {
        CrashDetailBean crashDetailBean = new CrashDetailBean();
        try {
            crashDetailBean.f7329C = C2420b.m5414k();
            crashDetailBean.f7330D = C2420b.m5418i();
            crashDetailBean.f7331E = C2420b.m5410m();
            crashDetailBean.f7332F = this.f7401d.m5446p();
            crashDetailBean.f7333G = this.f7401d.m5447o();
            crashDetailBean.f7334H = this.f7401d.m5445q();
            crashDetailBean.f7372w = C2503z.m5056a(this.f7400c, C2437c.f7423e, (String) null);
            crashDetailBean.f7351b = 3;
            crashDetailBean.f7354e = this.f7401d.m5454h();
            crashDetailBean.f7355f = this.f7401d.f7264j;
            crashDetailBean.f7356g = this.f7401d.m5439w();
            crashDetailBean.f7362m = this.f7401d.m5456g();
            crashDetailBean.f7363n = "ANR_EXCEPTION";
            crashDetailBean.f7364o = c2431a.f7396f;
            crashDetailBean.f7366q = c2431a.f7397g;
            crashDetailBean.f7341O = new HashMap();
            crashDetailBean.f7341O.put("BUGLY_CR_01", c2431a.f7395e);
            int indexOf = crashDetailBean.f7366q != null ? crashDetailBean.f7366q.indexOf("\n") : -1;
            crashDetailBean.f7365p = indexOf > 0 ? crashDetailBean.f7366q.substring(0, indexOf) : "GET_FAIL";
            crashDetailBean.f7367r = c2431a.f7393c;
            if (crashDetailBean.f7366q != null) {
                crashDetailBean.f7370u = C2503z.m5023b(crashDetailBean.f7366q.getBytes());
            }
            crashDetailBean.f7375z = c2431a.f7392b;
            crashDetailBean.f7327A = c2431a.f7391a;
            crashDetailBean.f7328B = "main(1)";
            crashDetailBean.f7335I = this.f7401d.m5437y();
            crashDetailBean.f7357h = this.f7401d.m5440v();
            crashDetailBean.f7358i = this.f7401d.m5487J();
            crashDetailBean.f7371v = c2431a.f7394d;
            crashDetailBean.f7338L = this.f7401d.f7268n;
            crashDetailBean.f7339M = this.f7401d.f7230a;
            crashDetailBean.f7340N = this.f7401d.m5476a();
            crashDetailBean.f7342P = this.f7401d.m5489H();
            crashDetailBean.f7343Q = this.f7401d.m5488I();
            crashDetailBean.f7344R = this.f7401d.m5495B();
            crashDetailBean.f7345S = this.f7401d.m5490G();
            this.f7405h.m5348c(crashDetailBean);
            crashDetailBean.f7374y = C2500y.m5082a();
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
        }
        return crashDetailBean;
    }

    /* renamed from: a */
    private static boolean m5373a(String str, String str2, String str3) {
        BufferedWriter bufferedWriter;
        TraceFileHelper.C2429a readTargetDumpInfo = TraceFileHelper.readTargetDumpInfo(str3, str, true);
        if (readTargetDumpInfo == null || readTargetDumpInfo.f7390d == null || readTargetDumpInfo.f7390d.size() <= 0) {
            C2499x.m5083e("not found trace dump for %s", str3);
            return false;
        }
        File file = new File(str2);
        try {
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
            }
            if (!file.exists() || !file.canWrite()) {
                C2499x.m5083e("backup file create fail %s", str2);
                return false;
            }
            BufferedWriter bufferedWriter2 = null;
            try {
                try {
                    bufferedWriter = new BufferedWriter(new FileWriter(file, false));
                    try {
                        String[] strArr = readTargetDumpInfo.f7390d.get("main");
                        if (strArr != null && strArr.length >= 3) {
                            String str4 = strArr[0];
                            String str5 = strArr[1];
                            String str6 = strArr[2];
                            bufferedWriter.write("\"main\" tid=" + str6 + " :\n" + str4 + "\n" + str5 + "\n\n");
                            bufferedWriter.flush();
                        }
                        for (Map.Entry<String, String[]> entry : readTargetDumpInfo.f7390d.entrySet()) {
                            if (!entry.getKey().equals("main") && entry.getValue() != null && entry.getValue().length >= 3) {
                                String str7 = entry.getValue()[0];
                                String str8 = entry.getValue()[1];
                                String str9 = entry.getValue()[2];
                                bufferedWriter.write("\"" + entry.getKey() + "\" tid=" + str9 + " :\n" + str7 + "\n" + str8 + "\n\n");
                                bufferedWriter.flush();
                            }
                        }
                        try {
                            bufferedWriter.close();
                        } catch (IOException e) {
                            if (!C2499x.m5089a(e)) {
                                e.printStackTrace();
                            }
                        }
                        return true;
                    } catch (IOException e2) {
                        e = e2;
                        bufferedWriter2 = bufferedWriter;
                        if (!C2499x.m5089a(e)) {
                            e.printStackTrace();
                        }
                        C2499x.m5083e("dump trace fail %s", e.getClass().getName() + ":" + e.getMessage());
                        if (bufferedWriter2 != null) {
                            try {
                                bufferedWriter2.close();
                            } catch (IOException e3) {
                                if (!C2499x.m5089a(e3)) {
                                    e3.printStackTrace();
                                }
                            }
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        if (bufferedWriter != null) {
                            try {
                                bufferedWriter.close();
                            } catch (IOException e4) {
                                if (!C2499x.m5089a(e4)) {
                                    e4.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedWriter = bufferedWriter2;
                }
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Exception e6) {
            if (!C2499x.m5089a(e6)) {
                e6.printStackTrace();
            }
            C2499x.m5083e("backup file create error! %s  %s", e6.getClass().getName() + ":" + e6.getMessage(), str2);
            return false;
        }
    }

    /* renamed from: a */
    public final boolean m5377a() {
        return this.f7398a.get() != 0;
    }

    /* renamed from: a */
    public final void m5374a(String str) {
        long j;
        ActivityManager.ProcessErrorStateInfo processErrorStateInfo;
        synchronized (this) {
            if (this.f7398a.get() != 0) {
                C2499x.m5085c("trace started return ", new Object[0]);
                return;
            }
            this.f7398a.set(1);
            try {
                C2499x.m5085c("read trace first dump for create time!", new Object[0]);
                TraceFileHelper.C2429a readFirstDumpInfo = TraceFileHelper.readFirstDumpInfo(str, false);
                j = readFirstDumpInfo != null ? readFirstDumpInfo.f7389c : -1L;
                if (j == -1) {
                    C2499x.m5084d("trace dump fail could not get time!", new Object[0]);
                    j = System.currentTimeMillis();
                }
            } finally {
                try {
                    return;
                } finally {
                }
            }
            if (Math.abs(j - this.f7399b) < 10000) {
                C2499x.m5084d("should not process ANR too Fre in %d", Integer.valueOf((int) Priority.DEBUG_INT));
            } else {
                this.f7399b = j;
                this.f7398a.set(1);
                Map<String, String> m5060a = C2503z.m5060a(C2437c.f7424f, false);
                if (m5060a != null && m5060a.size() > 0) {
                    Context context = this.f7400c;
                    C2499x.m5085c("to find!", new Object[0]);
                    ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
                    int i = 0;
                    loop0: while (true) {
                        C2499x.m5085c("waiting!", new Object[0]);
                        List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = activityManager.getProcessesInErrorState();
                        if (processesInErrorState != null) {
                            Iterator<ActivityManager.ProcessErrorStateInfo> it = processesInErrorState.iterator();
                            while (it.hasNext()) {
                                processErrorStateInfo = it.next();
                                if (processErrorStateInfo.condition == 2) {
                                    C2499x.m5085c("found!", new Object[0]);
                                    break loop0;
                                }
                            }
                        }
                        C2503z.m5030b(500L);
                        int i2 = i + 1;
                        if (i >= 20) {
                            C2499x.m5085c("end!", new Object[0]);
                            processErrorStateInfo = null;
                            break;
                        }
                        i = i2;
                    }
                    if (processErrorStateInfo == null) {
                        C2499x.m5085c("proc state is unvisiable!", new Object[0]);
                    } else if (processErrorStateInfo.pid == Process.myPid()) {
                        C2499x.m5090a("found visiable anr , start to process!", new Object[0]);
                        File filesDir = this.f7400c.getFilesDir();
                        File file = new File(filesDir, "bugly/bugly_trace_" + j + ".txt");
                        C2431a c2431a = new C2431a();
                        c2431a.f7393c = j;
                        c2431a.f7394d = file.getAbsolutePath();
                        c2431a.f7391a = processErrorStateInfo.processName;
                        c2431a.f7396f = processErrorStateInfo.shortMsg;
                        c2431a.f7395e = processErrorStateInfo.longMsg;
                        c2431a.f7392b = m5060a;
                        if (m5060a != null) {
                            for (String str2 : m5060a.keySet()) {
                                if (str2.startsWith("main(")) {
                                    c2431a.f7397g = m5060a.get(str2);
                                }
                            }
                        }
                        Object[] objArr = new Object[6];
                        objArr[0] = Long.valueOf(c2431a.f7393c);
                        objArr[1] = c2431a.f7394d;
                        objArr[2] = c2431a.f7391a;
                        objArr[3] = c2431a.f7396f;
                        objArr[4] = c2431a.f7395e;
                        objArr[5] = Integer.valueOf(c2431a.f7392b == null ? 0 : c2431a.f7392b.size());
                        C2499x.m5085c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", objArr);
                        if (!this.f7403f.m5392b()) {
                            C2499x.m5083e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
                            C2435b.m5357a("ANR", C2503z.m5062a(), c2431a.f7391a, "main", c2431a.f7395e, null);
                        } else if (this.f7403f.m5390c().f7295j) {
                            C2499x.m5090a("found visiable anr , start to upload!", new Object[0]);
                            CrashDetailBean m5375a = m5375a(c2431a);
                            if (m5375a == null) {
                                C2499x.m5083e("pack anr fail!", new Object[0]);
                            } else {
                                C2437c.m5343a().m5339a(m5375a);
                                if (m5375a.f7350a >= 0) {
                                    C2499x.m5090a("backup anr record success!", new Object[0]);
                                } else {
                                    C2499x.m5084d("backup anr record fail!", new Object[0]);
                                }
                                if (str != null && new File(str).exists()) {
                                    this.f7398a.set(3);
                                    if (m5373a(str, c2431a.f7394d, c2431a.f7391a)) {
                                        C2499x.m5090a("backup trace success", new Object[0]);
                                    }
                                }
                                C2435b.m5357a("ANR", C2503z.m5062a(), c2431a.f7391a, "main", c2431a.f7395e, m5375a);
                                if (!this.f7405h.m5361a(m5375a)) {
                                    this.f7405h.m5359a(m5375a, 3000L, true);
                                }
                                this.f7405h.m5350b(m5375a);
                            }
                        } else {
                            C2499x.m5084d("ANR Report is closed!", new Object[0]);
                        }
                        return;
                    } else {
                        C2499x.m5085c("not mind proc!", processErrorStateInfo.processName);
                    }
                }
                C2499x.m5084d("can't get all thread skip this anr", new Object[0]);
            }
        }
    }

    /* renamed from: c */
    private synchronized void m5369c() {
        if (m5366e()) {
            C2499x.m5084d("start when started!", new Object[0]);
            return;
        }
        this.f7406i = new FileObserver("/data/anr/", 8) { // from class: com.tencent.bugly.crashreport.crash.anr.b.1
            @Override // android.os.FileObserver
            public final void onEvent(int i, String str) {
                if (str == null) {
                    return;
                }
                String str2 = "/data/anr/" + str;
                if (str2.contains("trace")) {
                    C2432b.this.m5374a(str2);
                } else {
                    C2499x.m5084d("not anr file %s", str2);
                }
            }
        };
        this.f7406i.startWatching();
        C2499x.m5090a("start anr monitor!", new Object[0]);
        this.f7402e.m5097a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.anr.b.2
            @Override // java.lang.Runnable
            public final void run() {
                C2432b.this.m5371b();
            }
        });
    }

    /* renamed from: d */
    private synchronized void m5367d() {
        if (!m5366e()) {
            C2499x.m5084d("close when closed!", new Object[0]);
            return;
        }
        this.f7406i.stopWatching();
        this.f7406i = null;
        C2499x.m5084d("close anr monitor!", new Object[0]);
    }

    /* renamed from: e */
    private synchronized boolean m5366e() {
        return this.f7406i != null;
    }

    /* renamed from: b */
    private synchronized void m5370b(boolean z) {
        if (z) {
            m5369c();
        } else {
            m5367d();
        }
    }

    /* renamed from: f */
    private synchronized boolean m5365f() {
        return this.f7407j;
    }

    /* renamed from: c */
    private synchronized void m5368c(boolean z) {
        if (this.f7407j != z) {
            C2499x.m5090a("user change anr %b", Boolean.valueOf(z));
            this.f7407j = z;
        }
    }

    /* renamed from: a */
    public final void m5372a(boolean z) {
        m5368c(z);
        boolean m5365f = m5365f();
        C2422a m5399a = C2422a.m5399a();
        if (m5399a != null) {
            m5365f = m5365f && m5399a.m5390c().f7292g;
        }
        if (m5365f != m5366e()) {
            C2499x.m5090a("anr changed to %b", Boolean.valueOf(m5365f));
            m5370b(m5365f);
        }
    }

    /* renamed from: b */
    protected final void m5371b() {
        int indexOf;
        long m5032b = C2503z.m5032b() - C2437c.f7425g;
        File file = new File(this.f7404g);
        if (file.exists() && file.isDirectory()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    int i = 0;
                    for (File file2 : listFiles) {
                        String name = file2.getName();
                        if (name.startsWith("bugly_trace_") && (((indexOf = name.indexOf(".txt")) <= 0 || Long.parseLong(name.substring(12, indexOf)) < m5032b) && file2.delete())) {
                            i++;
                        }
                    }
                    C2499x.m5085c("Number of overdue trace files that has deleted: " + i, new Object[0]);
                }
            } catch (Throwable th) {
                C2499x.m5089a(th);
            }
        }
    }

    /* renamed from: a */
    public final synchronized void m5376a(StrategyBean strategyBean) {
        if (strategyBean == null) {
            return;
        }
        if (strategyBean.f7295j != m5366e()) {
            C2499x.m5084d("server anr changed to %b", Boolean.valueOf(strategyBean.f7295j));
        }
        boolean z = strategyBean.f7295j && m5365f();
        if (z != m5366e()) {
            C2499x.m5090a("anr changed to %b", Boolean.valueOf(z));
            m5370b(z);
        }
    }
}
