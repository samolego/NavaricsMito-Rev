package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.senseplay.sdk.zxing.utils.PermissionsUtil;
import com.tencent.bugly.AbstractC2403a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.p */
/* loaded from: classes2.dex */
public final class C2486p {

    /* renamed from: a */
    private static C2486p f7676a = null;

    /* renamed from: b */
    private static C2488q f7677b = null;

    /* renamed from: c */
    private static boolean f7678c = false;

    private C2486p(Context context, List<AbstractC2403a> list) {
        f7677b = new C2488q(context, list);
    }

    /* renamed from: a */
    public static synchronized C2486p m5167a(Context context, List<AbstractC2403a> list) {
        C2486p c2486p;
        synchronized (C2486p.class) {
            if (f7676a == null) {
                f7676a = new C2486p(context, list);
            }
            c2486p = f7676a;
        }
        return c2486p;
    }

    /* renamed from: a */
    public static synchronized C2486p m5175a() {
        C2486p c2486p;
        synchronized (C2486p.class) {
            c2486p = f7676a;
        }
        return c2486p;
    }

    /* renamed from: a */
    public final long m5157a(String str, ContentValues contentValues, InterfaceC2485o interfaceC2485o, boolean z) {
        return m5158a(str, contentValues, (InterfaceC2485o) null);
    }

    /* renamed from: a */
    public final Cursor m5154a(String str, String[] strArr, String str2, String[] strArr2, InterfaceC2485o interfaceC2485o, boolean z) {
        return m5152a(false, str, strArr, str2, null, null, null, null, null, null);
    }

    /* renamed from: a */
    public final int m5155a(String str, String str2, String[] strArr, InterfaceC2485o interfaceC2485o, boolean z) {
        return m5156a(str, str2, (String[]) null, (InterfaceC2485o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized long m5158a(String str, ContentValues contentValues, InterfaceC2485o interfaceC2485o) {
        long j;
        j = 0;
        SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
        if (writableDatabase != null && contentValues != null) {
            long replace = writableDatabase.replace(str, "_id", contentValues);
            if (replace >= 0) {
                C2499x.m5085c("[Database] insert %s success.", str);
            } else {
                C2499x.m5084d("[Database] replace %s error.", str);
            }
            j = replace;
        }
        if (interfaceC2485o != null) {
            Long.valueOf(j);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized Cursor m5152a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6, InterfaceC2485o interfaceC2485o) {
        Cursor cursor;
        cursor = null;
        try {
            SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
            if (writableDatabase != null) {
                cursor = writableDatabase.query(z, str, strArr, str2, strArr2, str3, str4, str5, str6);
            }
        } catch (Throwable th) {
            try {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized int m5156a(String str, String str2, String[] strArr, InterfaceC2485o interfaceC2485o) {
        int delete;
        SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
        delete = writableDatabase != null ? writableDatabase.delete(str, str2, strArr) : 0;
        if (interfaceC2485o != null) {
            Integer.valueOf(delete);
        }
        return delete;
    }

    /* renamed from: a */
    public final boolean m5168a(int i, String str, byte[] bArr, InterfaceC2485o interfaceC2485o, boolean z) {
        if (!z) {
            C2487a c2487a = new C2487a(4, null);
            c2487a.m5145a(i, str, bArr);
            C2497w.m5098a().m5097a(c2487a);
            return true;
        }
        return m5169a(i, str, bArr, (InterfaceC2485o) null);
    }

    /* renamed from: a */
    public final Map<String, byte[]> m5172a(int i, InterfaceC2485o interfaceC2485o, boolean z) {
        return m5173a(i, (InterfaceC2485o) null);
    }

    /* renamed from: a */
    public final boolean m5170a(int i, String str, InterfaceC2485o interfaceC2485o, boolean z) {
        return m5171a(PermissionsUtil.HANDLER_RIGHT, str, (InterfaceC2485o) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r8 != null) goto L5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        return r0;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m5169a(int r5, java.lang.String r6, byte[] r7, com.tencent.bugly.proguard.InterfaceC2485o r8) {
        /*
            r4 = this;
            r0 = 0
            com.tencent.bugly.proguard.r r1 = new com.tencent.bugly.proguard.r     // Catch: java.lang.Throwable -> L1f
            r1.<init>()     // Catch: java.lang.Throwable -> L1f
            long r2 = (long) r5     // Catch: java.lang.Throwable -> L1f
            r1.f7701a = r2     // Catch: java.lang.Throwable -> L1f
            r1.f7706f = r6     // Catch: java.lang.Throwable -> L1f
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1f
            r1.f7705e = r5     // Catch: java.lang.Throwable -> L1f
            r1.f7707g = r7     // Catch: java.lang.Throwable -> L1f
            boolean r0 = r4.m5149b(r1)     // Catch: java.lang.Throwable -> L1f
            if (r8 == 0) goto L2c
        L19:
            java.lang.Boolean.valueOf(r0)
            goto L2c
        L1d:
            r5 = move-exception
            goto L2d
        L1f:
            r5 = move-exception
            boolean r6 = com.tencent.bugly.proguard.C2499x.m5089a(r5)     // Catch: java.lang.Throwable -> L1d
            if (r6 != 0) goto L29
            r5.printStackTrace()     // Catch: java.lang.Throwable -> L1d
        L29:
            if (r8 == 0) goto L2c
            goto L19
        L2c:
            return r0
        L2d:
            if (r8 == 0) goto L32
            java.lang.Boolean.valueOf(r0)
        L32:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C2486p.m5169a(int, java.lang.String, byte[], com.tencent.bugly.proguard.o):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public Map<String, byte[]> m5173a(int i, InterfaceC2485o interfaceC2485o) {
        HashMap hashMap = null;
        try {
            List<C2489r> m5148c = m5148c(i);
            if (m5148c != null) {
                HashMap hashMap2 = new HashMap();
                try {
                    for (C2489r c2489r : m5148c) {
                        byte[] bArr = c2489r.f7707g;
                        if (bArr != null) {
                            hashMap2.put(c2489r.f7706f, bArr);
                        }
                    }
                    return hashMap2;
                } catch (Throwable th) {
                    th = th;
                    hashMap = hashMap2;
                    if (C2499x.m5089a(th)) {
                        return hashMap;
                    }
                    th.printStackTrace();
                    return hashMap;
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: a */
    public final synchronized boolean m5159a(C2489r c2489r) {
        ContentValues m5147c;
        if (c2489r == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
            if (writableDatabase == null || (m5147c = m5147c(c2489r)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_lr", "_id", m5147c);
            if (replace >= 0) {
                C2499x.m5085c("[Database] insert %s success.", "t_lr");
                c2489r.f7701a = replace;
                return true;
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* renamed from: b */
    private synchronized boolean m5149b(C2489r c2489r) {
        ContentValues m5146d;
        if (c2489r == null) {
            return false;
        }
        try {
            SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
            if (writableDatabase == null || (m5146d = m5146d(c2489r)) == null) {
                return false;
            }
            long replace = writableDatabase.replace("t_pf", "_id", m5146d);
            if (replace >= 0) {
                C2499x.m5085c("[Database] insert %s success.", "t_pf");
                c2489r.f7701a = replace;
                return true;
            }
            return false;
        } catch (Throwable th) {
            try {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00ad A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #4 {, blocks: (B:3:0x0001, B:16:0x0037, B:33:0x00a1, B:41:0x00b2, B:37:0x00a7, B:39:0x00ad), top: B:55:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b2 A[Catch: all -> 0x00bf, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:16:0x0037, B:33:0x00a1, B:41:0x00b2, B:37:0x00a7, B:39:0x00ad), top: B:55:0x0001 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.util.List<com.tencent.bugly.proguard.C2489r> m5174a(int r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            com.tencent.bugly.proguard.q r0 = com.tencent.bugly.proguard.C2486p.f7677b     // Catch: java.lang.Throwable -> Lbf
            android.database.sqlite.SQLiteDatabase r0 = r0.getWritableDatabase()     // Catch: java.lang.Throwable -> Lbf
            r9 = 0
            if (r0 == 0) goto Lbd
            if (r11 < 0) goto L26
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L21
            java.lang.String r2 = "_tp = "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L21
            r1.append(r11)     // Catch: java.lang.Throwable -> L21
            java.lang.String r11 = r1.toString()     // Catch: java.lang.Throwable -> L21
            r4 = r11
            goto L27
        L1c:
            r11 = move-exception
            r0 = r11
            r11 = r9
            goto Lb7
        L21:
            r11 = move-exception
            r0 = r11
            r11 = r9
            goto La7
        L26:
            r4 = r9
        L27:
            java.lang.String r2 = "t_lr"
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r0
            android.database.Cursor r11 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L21
            if (r11 != 0) goto L3c
            if (r11 == 0) goto L3a
            r11.close()     // Catch: java.lang.Throwable -> Lbf
        L3a:
            monitor-exit(r10)
            return r9
        L3c:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r1.<init>()     // Catch: java.lang.Throwable -> La6
            java.util.ArrayList r2 = new java.util.ArrayList     // Catch: java.lang.Throwable -> La6
            r2.<init>()     // Catch: java.lang.Throwable -> La6
        L46:
            boolean r3 = r11.moveToNext()     // Catch: java.lang.Throwable -> La6
            r4 = 0
            if (r3 == 0) goto L77
            com.tencent.bugly.proguard.r r3 = m5166a(r11)     // Catch: java.lang.Throwable -> La6
            if (r3 == 0) goto L57
            r2.add(r3)     // Catch: java.lang.Throwable -> La6
            goto L46
        L57:
            java.lang.String r3 = "_id"
            int r3 = r11.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L6f
            long r5 = r11.getLong(r3)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r3 = " or _id"
            r1.append(r3)     // Catch: java.lang.Throwable -> L6f
            java.lang.String r3 = " = "
            r1.append(r3)     // Catch: java.lang.Throwable -> L6f
            r1.append(r5)     // Catch: java.lang.Throwable -> L6f
            goto L46
        L6f:
            java.lang.String r3 = "[Database] unknown id."
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> La6
            com.tencent.bugly.proguard.C2499x.m5084d(r3, r4)     // Catch: java.lang.Throwable -> La6
            goto L46
        L77:
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> La6
            int r3 = r1.length()     // Catch: java.lang.Throwable -> La6
            if (r3 <= 0) goto L9f
            r3 = 4
            java.lang.String r1 = r1.substring(r3)     // Catch: java.lang.Throwable -> La6
            java.lang.String r3 = "t_lr"
            int r0 = r0.delete(r3, r1, r9)     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = "[Database] deleted %s illegal data %d"
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> La6
            java.lang.String r5 = "t_lr"
            r3[r4] = r5     // Catch: java.lang.Throwable -> La6
            r4 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> La6
            r3[r4] = r0     // Catch: java.lang.Throwable -> La6
            com.tencent.bugly.proguard.C2499x.m5084d(r1, r3)     // Catch: java.lang.Throwable -> La6
        L9f:
            if (r11 == 0) goto La4
            r11.close()     // Catch: java.lang.Throwable -> Lbf
        La4:
            monitor-exit(r10)
            return r2
        La6:
            r0 = move-exception
        La7:
            boolean r1 = com.tencent.bugly.proguard.C2499x.m5089a(r0)     // Catch: java.lang.Throwable -> Lb6
            if (r1 != 0) goto Lb0
            r0.printStackTrace()     // Catch: java.lang.Throwable -> Lb6
        Lb0:
            if (r11 == 0) goto Lbd
            r11.close()     // Catch: java.lang.Throwable -> Lbf
            goto Lbd
        Lb6:
            r0 = move-exception
        Lb7:
            if (r11 == 0) goto Lbc
            r11.close()     // Catch: java.lang.Throwable -> Lbf
        Lbc:
            throw r0     // Catch: java.lang.Throwable -> Lbf
        Lbd:
            monitor-exit(r10)
            return r9
        Lbf:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.C2486p.m5174a(int):java.util.List");
    }

    /* renamed from: a */
    public final synchronized void m5153a(List<C2489r> list) {
        if (list != null) {
            if (list.size() != 0) {
                SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
                if (writableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    for (C2489r c2489r : list) {
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(c2489r.f7701a);
                    }
                    String sb2 = sb.toString();
                    if (sb2.length() > 0) {
                        sb2 = sb2.substring(4);
                    }
                    sb.setLength(0);
                    C2499x.m5085c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", sb2, null)));
                }
            }
        }
    }

    /* renamed from: b */
    public final synchronized void m5151b(int i) {
        String str;
        SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
        if (writableDatabase != null) {
            if (i >= 0) {
                str = "_tp = " + i;
            } else {
                str = null;
            }
            C2499x.m5085c("[Database] deleted %s data %d", "t_lr", Integer.valueOf(writableDatabase.delete("t_lr", str, null)));
        }
    }

    /* renamed from: c */
    private static ContentValues m5147c(C2489r c2489r) {
        if (c2489r == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c2489r.f7701a > 0) {
                contentValues.put("_id", Long.valueOf(c2489r.f7701a));
            }
            contentValues.put("_tp", Integer.valueOf(c2489r.f7702b));
            contentValues.put("_pc", c2489r.f7703c);
            contentValues.put("_th", c2489r.f7704d);
            contentValues.put("_tm", Long.valueOf(c2489r.f7705e));
            if (c2489r.f7707g != null) {
                contentValues.put("_dt", c2489r.f7707g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static C2489r m5166a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C2489r c2489r = new C2489r();
            c2489r.f7701a = cursor.getLong(cursor.getColumnIndex("_id"));
            c2489r.f7702b = cursor.getInt(cursor.getColumnIndex("_tp"));
            c2489r.f7703c = cursor.getString(cursor.getColumnIndex("_pc"));
            c2489r.f7704d = cursor.getString(cursor.getColumnIndex("_th"));
            c2489r.f7705e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c2489r.f7707g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c2489r;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: c */
    private synchronized List<C2489r> m5148c(int i) {
        Cursor cursor;
        try {
            SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
            if (writableDatabase != null) {
                String str = "_id = " + i;
                cursor = writableDatabase.query("t_pf", null, str, null, null, null, null);
                if (cursor == null) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
                try {
                    StringBuilder sb = new StringBuilder();
                    ArrayList arrayList = new ArrayList();
                    while (cursor.moveToNext()) {
                        C2489r m5150b = m5150b(cursor);
                        if (m5150b != null) {
                            arrayList.add(m5150b);
                        } else {
                            String string = cursor.getString(cursor.getColumnIndex("_tp"));
                            sb.append(" or _tp");
                            sb.append(" = ");
                            sb.append(string);
                        }
                    }
                    if (sb.length() > 0) {
                        sb.append(" and _id");
                        sb.append(" = ");
                        sb.append(i);
                        C2499x.m5084d("[Database] deleted %s illegal data %d.", "t_pf", Integer.valueOf(writableDatabase.delete("t_pf", str.substring(4), null)));
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th) {
                    th = th;
                    if (!C2499x.m5089a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized boolean m5171a(int i, String str, InterfaceC2485o interfaceC2485o) {
        boolean z;
        String str2;
        z = false;
        SQLiteDatabase writableDatabase = f7677b.getWritableDatabase();
        if (writableDatabase != null) {
            if (C2503z.m5043a(str)) {
                str2 = "_id = " + i;
            } else {
                str2 = "_id = " + i + " and _tp = \"" + str + "\"";
            }
            int delete = writableDatabase.delete("t_pf", str2, null);
            C2499x.m5085c("[Database] deleted %s data %d", "t_pf", Integer.valueOf(delete));
            if (delete > 0) {
                z = true;
            }
        }
        if (interfaceC2485o != null) {
            Boolean.valueOf(z);
        }
        return z;
    }

    /* renamed from: d */
    private static ContentValues m5146d(C2489r c2489r) {
        if (c2489r == null || C2503z.m5043a(c2489r.f7706f)) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (c2489r.f7701a > 0) {
                contentValues.put("_id", Long.valueOf(c2489r.f7701a));
            }
            contentValues.put("_tp", c2489r.f7706f);
            contentValues.put("_tm", Long.valueOf(c2489r.f7705e));
            if (c2489r.f7707g != null) {
                contentValues.put("_dt", c2489r.f7707g);
            }
            return contentValues;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    private static C2489r m5150b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C2489r c2489r = new C2489r();
            c2489r.f7701a = cursor.getLong(cursor.getColumnIndex("_id"));
            c2489r.f7705e = cursor.getLong(cursor.getColumnIndex("_tm"));
            c2489r.f7706f = cursor.getString(cursor.getColumnIndex("_tp"));
            c2489r.f7707g = cursor.getBlob(cursor.getColumnIndex("_dt"));
            return c2489r;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.proguard.p$a */
    /* loaded from: classes2.dex */
    public class C2487a extends Thread {

        /* renamed from: a */
        private int f7679a;

        /* renamed from: b */
        private InterfaceC2485o f7680b;

        /* renamed from: c */
        private String f7681c;

        /* renamed from: d */
        private ContentValues f7682d;

        /* renamed from: e */
        private boolean f7683e;

        /* renamed from: f */
        private String[] f7684f;

        /* renamed from: g */
        private String f7685g;

        /* renamed from: h */
        private String[] f7686h;

        /* renamed from: i */
        private String f7687i;

        /* renamed from: j */
        private String f7688j;

        /* renamed from: k */
        private String f7689k;

        /* renamed from: l */
        private String f7690l;

        /* renamed from: m */
        private String f7691m;

        /* renamed from: n */
        private String[] f7692n;

        /* renamed from: o */
        private int f7693o;

        /* renamed from: p */
        private String f7694p;

        /* renamed from: q */
        private byte[] f7695q;

        public C2487a(int i, InterfaceC2485o interfaceC2485o) {
            this.f7679a = i;
            this.f7680b = interfaceC2485o;
        }

        /* renamed from: a */
        public final void m5144a(boolean z, String str, String[] strArr, String str2, String[] strArr2, String str3, String str4, String str5, String str6) {
            this.f7683e = z;
            this.f7681c = str;
            this.f7684f = strArr;
            this.f7685g = str2;
            this.f7686h = strArr2;
            this.f7687i = str3;
            this.f7688j = str4;
            this.f7689k = str5;
            this.f7690l = str6;
        }

        /* renamed from: a */
        public final void m5145a(int i, String str, byte[] bArr) {
            this.f7693o = i;
            this.f7694p = str;
            this.f7695q = bArr;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            switch (this.f7679a) {
                case 1:
                    C2486p.this.m5158a(this.f7681c, this.f7682d, this.f7680b);
                    return;
                case 2:
                    C2486p.this.m5156a(this.f7681c, this.f7691m, this.f7692n, this.f7680b);
                    return;
                case 3:
                    Cursor m5152a = C2486p.this.m5152a(this.f7683e, this.f7681c, this.f7684f, this.f7685g, this.f7686h, this.f7687i, this.f7688j, this.f7689k, this.f7690l, this.f7680b);
                    if (m5152a != null) {
                        m5152a.close();
                        return;
                    }
                    return;
                case 4:
                    C2486p.this.m5169a(this.f7693o, this.f7694p, this.f7695q, this.f7680b);
                    return;
                case 5:
                    C2486p.this.m5173a(this.f7693o, this.f7680b);
                    return;
                case 6:
                    C2486p.this.m5171a(this.f7693o, this.f7694p, this.f7680b);
                    return;
                default:
                    return;
            }
        }
    }
}
