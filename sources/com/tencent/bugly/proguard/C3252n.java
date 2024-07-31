package com.tencent.bugly.proguard;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.C2419a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.n */
/* loaded from: classes2.dex */
public final class C2482n {

    /* renamed from: a */
    public static final long f7665a = System.currentTimeMillis();

    /* renamed from: b */
    private static C2482n f7666b;

    /* renamed from: c */
    private Context f7667c;

    /* renamed from: f */
    private SharedPreferences f7670f;

    /* renamed from: e */
    private Map<Integer, Map<String, C2481m>> f7669e = new HashMap();

    /* renamed from: d */
    private String f7668d = C2419a.m5470b().f7258d;

    private C2482n(Context context) {
        this.f7667c = context;
        this.f7670f = context.getSharedPreferences("crashrecord", 0);
    }

    /* renamed from: a */
    public static synchronized C2482n m5187a(Context context) {
        C2482n c2482n;
        synchronized (C2482n.class) {
            if (f7666b == null) {
                f7666b = new C2482n(context);
            }
            c2482n = f7666b;
        }
        return c2482n;
    }

    /* renamed from: a */
    public static synchronized C2482n m5191a() {
        C2482n c2482n;
        synchronized (C2482n.class) {
            c2482n = f7666b;
        }
        return c2482n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public synchronized boolean m5183b(int i) {
        try {
            List<C2481m> m5180c = m5180c(i);
            if (m5180c == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (C2481m c2481m : m5180c) {
                if (c2481m.f7659b != null && c2481m.f7659b.equalsIgnoreCase(this.f7668d) && c2481m.f7661d > 0) {
                    arrayList.add(c2481m);
                }
                if (c2481m.f7660c + 86400000 < currentTimeMillis) {
                    arrayList2.add(c2481m);
                }
            }
            Collections.sort(arrayList);
            if (arrayList.size() >= 2) {
                if (arrayList.size() <= 0 || ((C2481m) arrayList.get(arrayList.size() - 1)).f7660c + 86400000 >= currentTimeMillis) {
                    return true;
                }
                m5180c.clear();
                m5188a(i, (int) m5180c);
                return false;
            }
            m5180c.removeAll(arrayList2);
            m5188a(i, (int) m5180c);
            return false;
        } catch (Exception unused) {
            C2499x.m5083e("isFrequentCrash failed", new Object[0]);
            return false;
        }
    }

    /* renamed from: a */
    public final void m5189a(int i, final int i2) {
        C2497w.m5098a().m5097a(new Runnable() { // from class: com.tencent.bugly.proguard.n.1
            @Override // java.lang.Runnable
            public final void run() {
                C2481m c2481m;
                try {
                    if (TextUtils.isEmpty(C2482n.this.f7668d)) {
                        return;
                    }
                    List<C2481m> m5180c = C2482n.this.m5180c(r2);
                    if (m5180c == null) {
                        m5180c = new ArrayList();
                    }
                    if (C2482n.this.f7669e.get(Integer.valueOf(r2)) == null) {
                        C2482n.this.f7669e.put(Integer.valueOf(r2), new HashMap());
                    }
                    if (((Map) C2482n.this.f7669e.get(Integer.valueOf(r2))).get(C2482n.this.f7668d) != null) {
                        c2481m = (C2481m) ((Map) C2482n.this.f7669e.get(Integer.valueOf(r2))).get(C2482n.this.f7668d);
                        c2481m.f7661d = i2;
                    } else {
                        c2481m = new C2481m();
                        c2481m.f7658a = r2;
                        c2481m.f7664g = C2482n.f7665a;
                        c2481m.f7659b = C2482n.this.f7668d;
                        c2481m.f7663f = C2419a.m5470b().f7264j;
                        C2419a.m5470b().getClass();
                        c2481m.f7662e = "2.8.6";
                        c2481m.f7660c = System.currentTimeMillis();
                        c2481m.f7661d = i2;
                        ((Map) C2482n.this.f7669e.get(Integer.valueOf(r2))).put(C2482n.this.f7668d, c2481m);
                    }
                    ArrayList arrayList = new ArrayList();
                    boolean z = false;
                    for (C2481m c2481m2 : m5180c) {
                        if (c2481m2.f7664g == c2481m.f7664g && c2481m2.f7659b != null && c2481m2.f7659b.equalsIgnoreCase(c2481m.f7659b)) {
                            z = true;
                            c2481m2.f7661d = c2481m.f7661d;
                        }
                        if ((c2481m2.f7662e != null && !c2481m2.f7662e.equalsIgnoreCase(c2481m.f7662e)) || ((c2481m2.f7663f != null && !c2481m2.f7663f.equalsIgnoreCase(c2481m.f7663f)) || c2481m2.f7661d <= 0)) {
                            arrayList.add(c2481m2);
                        }
                    }
                    m5180c.removeAll(arrayList);
                    if (!z) {
                        m5180c.add(c2481m);
                    }
                    C2482n.this.m5188a(r2, (int) m5180c);
                } catch (Exception unused) {
                    C2499x.m5083e("saveCrashRecord failed", new Object[0]);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0046, code lost:
        r6.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0052, code lost:
        if (r6 == null) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r6v5, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized <T extends java.util.List<?>> T m5180c(int r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            r0 = 0
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            android.content.Context r3 = r5.f7667c     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r4 = "crashrecord"
            java.io.File r3 = r3.getDir(r4, r1)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.<init>()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r4.append(r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            r2.<init>(r3, r6)     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            boolean r6 = r2.exists()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            if (r6 != 0) goto L24
            monitor-exit(r5)
            return r0
        L24:
            java.io.ObjectInputStream r6 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r3.<init>(r2)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            r6.<init>(r3)     // Catch: java.lang.Throwable -> L39 java.lang.ClassNotFoundException -> L3c java.io.IOException -> L4a
            java.lang.Object r2 = r6.readObject()     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.ClassNotFoundException -> L3d java.io.IOException -> L4b java.lang.Throwable -> L55
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            monitor-exit(r5)
            return r2
        L39:
            r2 = move-exception
            r6 = r0
            goto L56
        L3c:
            r6 = r0
        L3d:
            java.lang.String r2 = "get object error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.tencent.bugly.proguard.C2499x.m5090a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
        L46:
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
            goto L65
        L4a:
            r6 = r0
        L4b:
            java.lang.String r2 = "open record file error"
            java.lang.Object[] r3 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L55
            com.tencent.bugly.proguard.C2499x.m5090a(r2, r3)     // Catch: java.lang.Throwable -> L55
            if (r6 == 0) goto L65
            goto L46
        L55:
            r2 = move-exception
        L56:
            if (r6 == 0) goto L5b
            r6.close()     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5b:
            throw r2     // Catch: java.lang.Throwable -> L5c java.lang.Exception -> L5e
        L5c:
            r6 = move-exception
            goto L67
        L5e:
            java.lang.String r6 = "readCrashRecord error"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch: java.lang.Throwable -> L5c
            com.tencent.bugly.proguard.C2499x.m5083e(r6, r1)     // Catch: java.lang.Throwable -> L5c
        L65:
            monitor-exit(r5)
            return r0
        L67:
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C2482n.m5180c(int):java.util.List");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized <T extends List<?>> void m5188a(int i, T t) {
        File dir;
        StringBuilder sb;
        ObjectOutputStream objectOutputStream;
        if (t == null) {
            return;
        }
        try {
            dir = this.f7667c.getDir("crashrecord", 0);
            sb = new StringBuilder();
            sb.append(i);
            objectOutputStream = null;
        } catch (Exception unused) {
            C2499x.m5083e("writeCrashRecord error", new Object[0]);
        }
        try {
            try {
                ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new FileOutputStream(new File(dir, sb.toString())));
                try {
                    objectOutputStream2.writeObject(t);
                    objectOutputStream2.close();
                } catch (IOException e) {
                    e = e;
                    objectOutputStream = objectOutputStream2;
                    e.printStackTrace();
                    C2499x.m5090a("open record file error", new Object[0]);
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    objectOutputStream = objectOutputStream2;
                    if (objectOutputStream != null) {
                        objectOutputStream.close();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public final synchronized boolean m5190a(final int i) {
        boolean z;
        z = true;
        try {
            SharedPreferences sharedPreferences = this.f7670f;
            z = sharedPreferences.getBoolean(i + "_" + this.f7668d, true);
            C2497w.m5098a().m5097a(new Runnable() { // from class: com.tencent.bugly.proguard.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    boolean m5183b = C2482n.this.m5183b(i);
                    SharedPreferences.Editor edit = C2482n.this.f7670f.edit();
                    edit.putBoolean(i + "_" + C2482n.this.f7668d, !m5183b).commit();
                }
            });
        } catch (Exception unused) {
            C2499x.m5083e("canInit error", new Object[0]);
            return z;
        }
        return z;
    }
}
