package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.C2404b;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.C2458ah;
import com.tencent.bugly.proguard.C2460aj;
import com.tencent.bugly.proguard.C2461ak;
import com.tencent.bugly.proguard.C2486p;
import com.tencent.bugly.proguard.C2489r;
import com.tencent.bugly.proguard.C2492u;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import com.tencent.bugly.proguard.InterfaceC2485o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.crash.b */
/* loaded from: classes2.dex */
public final class C2435b {

    /* renamed from: a */
    private static int f7410a;

    /* renamed from: b */
    private Context f7411b;

    /* renamed from: c */
    private C2492u f7412c;

    /* renamed from: d */
    private C2486p f7413d;

    /* renamed from: e */
    private C2422a f7414e;

    /* renamed from: f */
    private InterfaceC2485o f7415f;

    /* renamed from: g */
    private BuglyStrategy.C2402a f7416g;

    public C2435b(int i, Context context, C2492u c2492u, C2486p c2486p, C2422a c2422a, BuglyStrategy.C2402a c2402a, InterfaceC2485o interfaceC2485o) {
        f7410a = i;
        this.f7411b = context;
        this.f7412c = c2492u;
        this.f7413d = c2486p;
        this.f7414e = c2422a;
        this.f7416g = c2402a;
        this.f7415f = interfaceC2485o;
    }

    /* renamed from: a */
    private static List<C2426a> m5356a(List<C2426a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (C2426a c2426a : list) {
            if (c2426a.f7379d && c2426a.f7377b <= currentTimeMillis - 86400000) {
                arrayList.add(c2426a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private CrashDetailBean m5354a(List<C2426a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> m5349b;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (C2426a c2426a : list) {
            if (c2426a.f7380e) {
                arrayList.add(c2426a);
            }
        }
        if (arrayList.size() > 0 && (m5349b = m5349b(arrayList)) != null && m5349b.size() > 0) {
            Collections.sort(m5349b);
            CrashDetailBean crashDetailBean3 = null;
            for (int i = 0; i < m5349b.size(); i++) {
                CrashDetailBean crashDetailBean4 = m5349b.get(i);
                if (i == 0) {
                    crashDetailBean3 = crashDetailBean4;
                } else if (crashDetailBean4.f7368s != null && (split = crashDetailBean4.f7368s.split("\n")) != null) {
                    for (String str : split) {
                        if (!crashDetailBean3.f7368s.contains(str)) {
                            crashDetailBean3.f7369t++;
                            crashDetailBean3.f7368s += str + "\n";
                        }
                    }
                }
            }
            crashDetailBean2 = crashDetailBean3;
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f7359j = true;
            crashDetailBean.f7369t = 0;
            crashDetailBean.f7368s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (C2426a c2426a2 : list) {
            if (!c2426a2.f7380e && !c2426a2.f7379d) {
                String str2 = crashDetailBean2.f7368s;
                StringBuilder sb = new StringBuilder();
                sb.append(c2426a2.f7377b);
                if (!str2.contains(sb.toString())) {
                    crashDetailBean2.f7369t++;
                    crashDetailBean2.f7368s += c2426a2.f7377b + "\n";
                }
            }
        }
        if (crashDetailBean2.f7367r != crashDetailBean.f7367r) {
            String str3 = crashDetailBean2.f7368s;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f7367r);
            if (!str3.contains(sb2.toString())) {
                crashDetailBean2.f7369t++;
                crashDetailBean2.f7368s += crashDetailBean.f7367r + "\n";
            }
        }
        return crashDetailBean2;
    }

    /* renamed from: a */
    public final boolean m5361a(CrashDetailBean crashDetailBean) {
        return m5360a(crashDetailBean, -123456789);
    }

    /* renamed from: a */
    public final boolean m5360a(CrashDetailBean crashDetailBean, int i) {
        if (crashDetailBean == null) {
            return true;
        }
        if (C2437c.f7432n != null && !C2437c.f7432n.isEmpty()) {
            C2499x.m5085c("Crash filter for crash stack is: %s", C2437c.f7432n);
            if (crashDetailBean.f7366q.contains(C2437c.f7432n)) {
                C2499x.m5084d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (C2437c.f7433o != null && !C2437c.f7433o.isEmpty()) {
            C2499x.m5085c("Crash regular filter for crash stack is: %s", C2437c.f7433o);
            if (Pattern.compile(C2437c.f7433o).matcher(crashDetailBean.f7366q).find()) {
                C2499x.m5084d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        int i2 = crashDetailBean.f7351b;
        String str = crashDetailBean.f7363n;
        String str2 = crashDetailBean.f7365p;
        String str3 = crashDetailBean.f7366q;
        long j = crashDetailBean.f7367r;
        String str4 = crashDetailBean.f7362m;
        String str5 = crashDetailBean.f7354e;
        String str6 = crashDetailBean.f7352c;
        if (this.f7415f != null) {
            C2499x.m5085c("Calling 'onCrashSaving' of RQD crash listener.", new Object[0]);
            InterfaceC2485o interfaceC2485o = this.f7415f;
            String str7 = crashDetailBean.f7327A;
            if (!interfaceC2485o.m5176c()) {
                C2499x.m5084d("Crash listener 'onCrashSaving' return 'false' thus will not handle this crash.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f7351b != 2) {
            C2489r c2489r = new C2489r();
            c2489r.f7702b = 1;
            c2489r.f7703c = crashDetailBean.f7327A;
            c2489r.f7704d = crashDetailBean.f7328B;
            c2489r.f7705e = crashDetailBean.f7367r;
            this.f7413d.m5151b(1);
            this.f7413d.m5159a(c2489r);
            C2499x.m5087b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            C2499x.m5087b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<C2426a> m5352b = m5352b();
        ArrayList arrayList = null;
        if (m5352b != null && m5352b.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(m5356a(m5352b));
            m5352b.removeAll(arrayList);
            if (!C2404b.f7146c && C2437c.f7422d) {
                boolean z = false;
                for (C2426a c2426a : m5352b) {
                    if (crashDetailBean.f7370u.equals(c2426a.f7378c)) {
                        if (c2426a.f7380e) {
                            z = true;
                        }
                        arrayList2.add(c2426a);
                    }
                }
                if (z || arrayList2.size() >= C2437c.f7421c) {
                    C2499x.m5090a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean m5354a = m5354a(arrayList2, crashDetailBean);
                    for (C2426a c2426a2 : arrayList2) {
                        if (c2426a2.f7376a != m5354a.f7350a) {
                            arrayList.add(c2426a2);
                        }
                    }
                    m5346d(m5354a);
                    m5347c(arrayList);
                    C2499x.m5087b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        m5346d(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            m5347c(arrayList);
        }
        C2499x.m5087b("[crash] save crash success", new Object[0]);
        return false;
    }

    /* renamed from: a */
    public final List<CrashDetailBean> m5364a() {
        StrategyBean m5390c = C2422a.m5399a().m5390c();
        if (m5390c == null) {
            C2499x.m5084d("have not synced remote!", new Object[0]);
            return null;
        } else if (!m5390c.f7292g) {
            C2499x.m5084d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            C2499x.m5087b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            long m5032b = C2503z.m5032b();
            List<C2426a> m5352b = m5352b();
            C2499x.m5085c("Size of crash list loaded from DB: %s", Integer.valueOf(m5352b.size()));
            if (m5352b == null || m5352b.size() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(m5356a(m5352b));
            m5352b.removeAll(arrayList);
            Iterator<C2426a> it = m5352b.iterator();
            while (it.hasNext()) {
                C2426a next = it.next();
                if (next.f7377b < m5032b - C2437c.f7425g) {
                    it.remove();
                    arrayList.add(next);
                } else if (next.f7379d) {
                    if (next.f7377b >= currentTimeMillis - 86400000) {
                        it.remove();
                    } else if (!next.f7380e) {
                        it.remove();
                        arrayList.add(next);
                    }
                } else if (next.f7381f >= 3 && next.f7377b < currentTimeMillis - 86400000) {
                    it.remove();
                    arrayList.add(next);
                }
            }
            if (arrayList.size() > 0) {
                m5347c(arrayList);
            }
            ArrayList arrayList2 = new ArrayList();
            List<CrashDetailBean> m5349b = m5349b(m5352b);
            if (m5349b != null && m5349b.size() > 0) {
                String str = C2419a.m5470b().f7264j;
                Iterator<CrashDetailBean> it2 = m5349b.iterator();
                while (it2.hasNext()) {
                    CrashDetailBean next2 = it2.next();
                    if (!str.equals(next2.f7355f)) {
                        it2.remove();
                        arrayList2.add(next2);
                    }
                }
            }
            if (arrayList2.size() > 0) {
                m5345d(arrayList2);
            }
            return m5349b;
        }
    }

    /* renamed from: b */
    public final void m5350b(CrashDetailBean crashDetailBean) {
        if (this.f7415f != null) {
            C2499x.m5085c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
            InterfaceC2485o interfaceC2485o = this.f7415f;
            int i = crashDetailBean.f7351b;
        }
    }

    /* renamed from: a */
    public final void m5359a(CrashDetailBean crashDetailBean, long j, boolean z) {
        if (C2437c.f7430l) {
            C2499x.m5090a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            m5355a(arrayList, 3000L, z, crashDetailBean.f7351b == 7, z);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a7 A[Catch: Throwable -> 0x00e9, TryCatch #0 {Throwable -> 0x00e9, blocks: (B:20:0x0041, B:22:0x0047, B:24:0x004c, B:26:0x0053, B:28:0x0058, B:32:0x0064, B:35:0x006e, B:39:0x0077, B:40:0x0087, B:42:0x008d, B:45:0x00a7, B:47:0x00af, B:49:0x00b5, B:51:0x00bd, B:53:0x00c5, B:55:0x00cd, B:57:0x00d4, B:58:0x00e0, B:43:0x009d, B:27:0x0056, B:23:0x004a), top: B:66:0x0041 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00af A[Catch: Throwable -> 0x00e9, TryCatch #0 {Throwable -> 0x00e9, blocks: (B:20:0x0041, B:22:0x0047, B:24:0x004c, B:26:0x0053, B:28:0x0058, B:32:0x0064, B:35:0x006e, B:39:0x0077, B:40:0x0087, B:42:0x008d, B:45:0x00a7, B:47:0x00af, B:49:0x00b5, B:51:0x00bd, B:53:0x00c5, B:55:0x00cd, B:57:0x00d4, B:58:0x00e0, B:43:0x009d, B:27:0x0056, B:23:0x004a), top: B:66:0x0041 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5355a(final java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> r15, long r16, boolean r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.C2435b.m5355a(java.util.List, long, boolean, boolean, boolean):void");
    }

    /* renamed from: a */
    public static void m5353a(boolean z, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            C2499x.m5085c("up finish update state %b", Boolean.valueOf(z));
            for (CrashDetailBean crashDetailBean : list) {
                C2499x.m5085c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f7352c, Integer.valueOf(crashDetailBean.f7361l), Boolean.valueOf(crashDetailBean.f7353d), Boolean.valueOf(crashDetailBean.f7359j));
                crashDetailBean.f7361l++;
                crashDetailBean.f7353d = z;
                C2499x.m5085c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f7352c, Integer.valueOf(crashDetailBean.f7361l), Boolean.valueOf(crashDetailBean.f7353d), Boolean.valueOf(crashDetailBean.f7359j));
            }
            for (CrashDetailBean crashDetailBean2 : list) {
                C2437c.m5343a().m5339a(crashDetailBean2);
            }
            C2499x.m5085c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z) {
            return;
        }
        C2499x.m5087b("[crash] upload fail.", new Object[0]);
    }

    /* renamed from: c */
    public final void m5348c(CrashDetailBean crashDetailBean) {
        int i;
        Map<String, String> map;
        String str;
        HashMap hashMap;
        if (crashDetailBean == null) {
            return;
        }
        if (this.f7416g == null && this.f7415f == null) {
            return;
        }
        try {
            C2499x.m5090a("[crash callback] start user's callback:onCrashHandleStart()", new Object[0]);
            switch (crashDetailBean.f7351b) {
                case 0:
                    i = 0;
                    break;
                case 1:
                    i = 2;
                    break;
                case 2:
                    i = 1;
                    break;
                case 3:
                    i = 4;
                    break;
                case 4:
                    i = 3;
                    break;
                case 5:
                    i = 5;
                    break;
                case 6:
                    i = 6;
                    break;
                case 7:
                    i = 7;
                    break;
                default:
                    return;
            }
            int i2 = crashDetailBean.f7351b;
            String str2 = crashDetailBean.f7363n;
            String str3 = crashDetailBean.f7365p;
            String str4 = crashDetailBean.f7366q;
            long j = crashDetailBean.f7367r;
            byte[] bArr = null;
            if (this.f7415f != null) {
                C2499x.m5085c("Calling 'onCrashHandleStart' of RQD crash listener.", new Object[0]);
                InterfaceC2485o interfaceC2485o = this.f7415f;
                C2499x.m5085c("Calling 'getCrashExtraMessage' of RQD crash listener.", new Object[0]);
                String m5177b = this.f7415f.m5177b();
                if (m5177b != null) {
                    hashMap = new HashMap(1);
                    hashMap.put("userData", m5177b);
                } else {
                    hashMap = null;
                }
                map = hashMap;
            } else if (this.f7416g != null) {
                C2499x.m5085c("Calling 'onCrashHandleStart' of Bugly crash listener.", new Object[0]);
                map = this.f7416g.onCrashHandleStart(i, crashDetailBean.f7363n, crashDetailBean.f7364o, crashDetailBean.f7366q);
            } else {
                map = null;
            }
            if (map != null && map.size() > 0) {
                crashDetailBean.f7341O = new LinkedHashMap(map.size());
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (!C2503z.m5043a(entry.getKey())) {
                        String key = entry.getKey();
                        if (key.length() > 100) {
                            key = key.substring(0, 100);
                            C2499x.m5084d("setted key length is over limit %d substring to %s", 100, key);
                        }
                        if (!C2503z.m5043a(entry.getValue()) && entry.getValue().length() > 30000) {
                            str = entry.getValue().substring(entry.getValue().length() - 30000);
                            C2499x.m5084d("setted %s value length is over limit %d substring", key, 30000);
                        } else {
                            str = entry.getValue();
                        }
                        crashDetailBean.f7341O.put(key, str);
                        C2499x.m5090a("add setted key %s value size:%d", key, Integer.valueOf(str.length()));
                    }
                }
            }
            C2499x.m5090a("[crash callback] start user's callback:onCrashHandleStart2GetExtraDatas()", new Object[0]);
            if (this.f7415f != null) {
                C2499x.m5085c("Calling 'getCrashExtraData' of RQD crash listener.", new Object[0]);
                bArr = this.f7415f.m5178a();
            } else if (this.f7416g != null) {
                C2499x.m5085c("Calling 'onCrashHandleStart2GetExtraDatas' of Bugly crash listener.", new Object[0]);
                bArr = this.f7416g.onCrashHandleStart2GetExtraDatas(i, crashDetailBean.f7363n, crashDetailBean.f7364o, crashDetailBean.f7366q);
            }
            crashDetailBean.f7346T = bArr;
            if (bArr != null) {
                if (bArr.length > 30000) {
                    C2499x.m5084d("extra bytes size %d is over limit %d will drop over part", Integer.valueOf(bArr.length), 30000);
                    crashDetailBean.f7346T = Arrays.copyOf(bArr, 30000);
                }
                C2499x.m5090a("add extra bytes %d ", Integer.valueOf(bArr.length));
            }
        } catch (Throwable th) {
            C2499x.m5084d("crash handle callback something wrong! %s", th.getClass().getName());
            if (C2499x.m5089a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    private static ContentValues m5344e(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (crashDetailBean.f7350a > 0) {
                contentValues.put("_id", Long.valueOf(crashDetailBean.f7350a));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f7367r));
            contentValues.put("_s1", crashDetailBean.f7370u);
            int i = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f7353d ? 1 : 0));
            if (!crashDetailBean.f7359j) {
                i = 0;
            }
            contentValues.put("_me", Integer.valueOf(i));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f7361l));
            contentValues.put("_dt", C2503z.m5051a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static CrashDetailBean m5362a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) C2503z.m5033a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f7350a = j;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: d */
    public final void m5346d(CrashDetailBean crashDetailBean) {
        ContentValues m5344e;
        if (crashDetailBean == null || (m5344e = m5344e(crashDetailBean)) == null) {
            return;
        }
        long m5157a = C2486p.m5175a().m5157a("t_cr", m5344e, (InterfaceC2485o) null, true);
        if (m5157a >= 0) {
            C2499x.m5085c("insert %s success!", "t_cr");
            crashDetailBean.f7350a = m5157a;
        }
    }

    /* renamed from: b */
    private List<CrashDetailBean> m5349b(List<C2426a> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (C2426a c2426a : list) {
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(c2426a.f7376a);
        }
        String sb2 = sb.toString();
        String substring = sb2.length() > 0 ? sb2.substring(4) : sb2;
        sb.setLength(0);
        try {
            cursor = C2486p.m5175a().m5154a("t_cr", null, substring, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    CrashDetailBean m5362a = m5362a(cursor);
                    if (m5362a != null) {
                        arrayList.add(m5362a);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j);
                    }
                }
                String sb3 = sb.toString();
                if (sb3.length() > 0) {
                    C2499x.m5084d("deleted %s illegle data %d", "t_cr", Integer.valueOf(C2486p.m5175a().m5155a("t_cr", sb3.substring(4), (String[]) null, (InterfaceC2485o) null, true)));
                }
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C2499x.m5089a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    /* renamed from: b */
    private static C2426a m5351b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            C2426a c2426a = new C2426a();
            c2426a.f7376a = cursor.getLong(cursor.getColumnIndex("_id"));
            c2426a.f7377b = cursor.getLong(cursor.getColumnIndex("_tm"));
            c2426a.f7378c = cursor.getString(cursor.getColumnIndex("_s1"));
            c2426a.f7379d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            c2426a.f7380e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            c2426a.f7381f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return c2426a;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: b */
    private List<C2426a> m5352b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor m5154a = C2486p.m5175a().m5154a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
            if (m5154a == null) {
                if (m5154a != null) {
                    m5154a.close();
                }
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (m5154a.moveToNext()) {
                    C2426a m5351b = m5351b(m5154a);
                    if (m5351b != null) {
                        arrayList.add(m5351b);
                    } else {
                        long j = m5154a.getLong(m5154a.getColumnIndex("_id"));
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    C2499x.m5084d("deleted %s illegle data %d", "t_cr", Integer.valueOf(C2486p.m5175a().m5155a("t_cr", sb2.substring(4), (String[]) null, (InterfaceC2485o) null, true)));
                }
                if (m5154a != null) {
                    m5154a.close();
                }
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = m5154a;
                try {
                    if (!C2499x.m5089a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return arrayList;
                } catch (Throwable th2) {
                    Cursor cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: c */
    private static void m5347c(List<C2426a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (C2426a c2426a : list) {
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(c2426a.f7376a);
        }
        String sb2 = sb.toString();
        String substring = sb2.length() > 0 ? sb2.substring(4) : sb2;
        sb.setLength(0);
        try {
            C2499x.m5085c("deleted %s data %d", "t_cr", Integer.valueOf(C2486p.m5175a().m5155a("t_cr", substring, (String[]) null, (InterfaceC2485o) null, true)));
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: d */
    private static void m5345d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb.append(" or _id");
                    sb.append(" = ");
                    sb.append(crashDetailBean.f7350a);
                }
                String sb2 = sb.toString();
                String substring = sb2.length() > 0 ? sb2.substring(4) : sb2;
                sb.setLength(0);
                C2499x.m5085c("deleted %s data %d", "t_cr", Integer.valueOf(C2486p.m5175a().m5155a("t_cr", substring, (String[]) null, (InterfaceC2485o) null, true)));
            } catch (Throwable th) {
                if (C2499x.m5089a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static C2461ak m5363a(Context context, CrashDetailBean crashDetailBean, C2419a c2419a) {
        C2460aj m5358a;
        C2460aj m5358a2;
        C2460aj c2460aj;
        if (context == null || crashDetailBean == null || c2419a == null) {
            C2499x.m5084d("enExp args == null", new Object[0]);
            return null;
        }
        C2461ak c2461ak = new C2461ak();
        switch (crashDetailBean.f7351b) {
            case 0:
                c2461ak.f7538a = crashDetailBean.f7359j ? "200" : "100";
                break;
            case 1:
                c2461ak.f7538a = crashDetailBean.f7359j ? "201" : "101";
                break;
            case 2:
                c2461ak.f7538a = crashDetailBean.f7359j ? "202" : "102";
                break;
            case 3:
                c2461ak.f7538a = crashDetailBean.f7359j ? "203" : "103";
                break;
            case 4:
                c2461ak.f7538a = crashDetailBean.f7359j ? "204" : "104";
                break;
            case 5:
                c2461ak.f7538a = crashDetailBean.f7359j ? "207" : "107";
                break;
            case 6:
                c2461ak.f7538a = crashDetailBean.f7359j ? "206" : "106";
                break;
            case 7:
                c2461ak.f7538a = crashDetailBean.f7359j ? "208" : "108";
                break;
            default:
                C2499x.m5083e("crash type error! %d", Integer.valueOf(crashDetailBean.f7351b));
                break;
        }
        c2461ak.f7539b = crashDetailBean.f7367r;
        c2461ak.f7540c = crashDetailBean.f7363n;
        c2461ak.f7541d = crashDetailBean.f7364o;
        c2461ak.f7542e = crashDetailBean.f7365p;
        c2461ak.f7544g = crashDetailBean.f7366q;
        c2461ak.f7545h = crashDetailBean.f7375z;
        c2461ak.f7546i = crashDetailBean.f7352c;
        c2461ak.f7547j = null;
        c2461ak.f7549l = crashDetailBean.f7362m;
        c2461ak.f7550m = crashDetailBean.f7354e;
        c2461ak.f7543f = crashDetailBean.f7328B;
        c2461ak.f7557t = C2419a.m5470b().m5453i();
        c2461ak.f7551n = null;
        if (crashDetailBean.f7358i != null && crashDetailBean.f7358i.size() > 0) {
            c2461ak.f7552o = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f7358i.entrySet()) {
                C2458ah c2458ah = new C2458ah();
                c2458ah.f7518a = entry.getValue().f7200a;
                c2458ah.f7520c = entry.getValue().f7202c;
                c2458ah.f7521d = entry.getValue().f7201b;
                c2458ah.f7519b = c2419a.m5444r();
                c2461ak.f7552o.add(c2458ah);
            }
        }
        if (crashDetailBean.f7357h != null && crashDetailBean.f7357h.size() > 0) {
            c2461ak.f7553p = new ArrayList<>();
            for (Map.Entry<String, PlugInBean> entry2 : crashDetailBean.f7357h.entrySet()) {
                C2458ah c2458ah2 = new C2458ah();
                c2458ah2.f7518a = entry2.getValue().f7200a;
                c2458ah2.f7520c = entry2.getValue().f7202c;
                c2458ah2.f7521d = entry2.getValue().f7201b;
                c2461ak.f7553p.add(c2458ah2);
            }
        }
        if (crashDetailBean.f7359j) {
            c2461ak.f7548k = crashDetailBean.f7369t;
            if (crashDetailBean.f7368s != null && crashDetailBean.f7368s.length() > 0) {
                if (c2461ak.f7554q == null) {
                    c2461ak.f7554q = new ArrayList<>();
                }
                try {
                    c2461ak.f7554q.add(new C2460aj((byte) 1, "alltimes.txt", crashDetailBean.f7368s.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    c2461ak.f7554q = null;
                }
            }
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(c2461ak.f7548k);
            objArr[1] = Integer.valueOf(c2461ak.f7554q != null ? c2461ak.f7554q.size() : 0);
            C2499x.m5085c("crashcount:%d sz:%d", objArr);
        }
        if (crashDetailBean.f7372w != null) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            try {
                c2461ak.f7554q.add(new C2460aj((byte) 1, "log.txt", crashDetailBean.f7372w.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
                c2461ak.f7554q = null;
            }
        }
        if (crashDetailBean.f7373x != null) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            try {
                c2461ak.f7554q.add(new C2460aj((byte) 1, "jniLog.txt", crashDetailBean.f7373x.getBytes("utf-8")));
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
                c2461ak.f7554q = null;
            }
        }
        if (!C2503z.m5043a(crashDetailBean.f7347U)) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            try {
                c2460aj = new C2460aj((byte) 1, "crashInfos.txt", crashDetailBean.f7347U.getBytes("utf-8"));
            } catch (UnsupportedEncodingException e4) {
                e4.printStackTrace();
                c2460aj = null;
            }
            if (c2460aj != null) {
                C2499x.m5085c("attach crash infos", new Object[0]);
                c2461ak.f7554q.add(c2460aj);
            }
        }
        if (crashDetailBean.f7348V != null) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            C2460aj m5358a3 = m5358a("backupRecord.zip", context, crashDetailBean.f7348V);
            if (m5358a3 != null) {
                C2499x.m5085c("attach backup record", new Object[0]);
                c2461ak.f7554q.add(m5358a3);
            }
        }
        if (crashDetailBean.f7374y != null && crashDetailBean.f7374y.length > 0) {
            C2460aj c2460aj2 = new C2460aj((byte) 2, "buglylog.zip", crashDetailBean.f7374y);
            C2499x.m5085c("attach user log", new Object[0]);
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            c2461ak.f7554q.add(c2460aj2);
        }
        if (crashDetailBean.f7351b == 3) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            if (crashDetailBean.f7341O != null && crashDetailBean.f7341O.containsKey("BUGLY_CR_01")) {
                try {
                    c2461ak.f7554q.add(new C2460aj((byte) 1, "anrMessage.txt", crashDetailBean.f7341O.get("BUGLY_CR_01").getBytes("utf-8")));
                    C2499x.m5085c("attach anr message", new Object[0]);
                } catch (UnsupportedEncodingException e5) {
                    e5.printStackTrace();
                    c2461ak.f7554q = null;
                }
                crashDetailBean.f7341O.remove("BUGLY_CR_01");
            }
            if (crashDetailBean.f7371v != null && (m5358a2 = m5358a("trace.zip", context, crashDetailBean.f7371v)) != null) {
                C2499x.m5085c("attach traces", new Object[0]);
                c2461ak.f7554q.add(m5358a2);
            }
        }
        if (crashDetailBean.f7351b == 1) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            if (crashDetailBean.f7371v != null && (m5358a = m5358a("tomb.zip", context, crashDetailBean.f7371v)) != null) {
                C2499x.m5085c("attach tombs", new Object[0]);
                c2461ak.f7554q.add(m5358a);
            }
        }
        if (c2419a.f7206C != null && !c2419a.f7206C.isEmpty()) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            StringBuilder sb = new StringBuilder();
            for (String str : c2419a.f7206C) {
                sb.append(str);
            }
            try {
                c2461ak.f7554q.add(new C2460aj((byte) 1, "martianlog.txt", sb.toString().getBytes("utf-8")));
                C2499x.m5085c("attach pageTracingList", new Object[0]);
            } catch (UnsupportedEncodingException e6) {
                e6.printStackTrace();
            }
        }
        if (crashDetailBean.f7346T != null && crashDetailBean.f7346T.length > 0) {
            if (c2461ak.f7554q == null) {
                c2461ak.f7554q = new ArrayList<>();
            }
            c2461ak.f7554q.add(new C2460aj((byte) 1, "userExtraByteData", crashDetailBean.f7346T));
            C2499x.m5085c("attach extraData", new Object[0]);
        }
        c2461ak.f7555r = new HashMap();
        Map<String, String> map = c2461ak.f7555r;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.f7329C);
        map.put("A9", sb2.toString());
        Map<String, String> map2 = c2461ak.f7555r;
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.f7330D);
        map2.put("A11", sb3.toString());
        Map<String, String> map3 = c2461ak.f7555r;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(crashDetailBean.f7331E);
        map3.put("A10", sb4.toString());
        c2461ak.f7555r.put("A23", crashDetailBean.f7355f);
        c2461ak.f7555r.put("A7", c2419a.f7260f);
        c2461ak.f7555r.put("A6", c2419a.m5443s());
        c2461ak.f7555r.put("A5", c2419a.m5444r());
        c2461ak.f7555r.put("A22", c2419a.m5454h());
        Map<String, String> map4 = c2461ak.f7555r;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(crashDetailBean.f7333G);
        map4.put("A2", sb5.toString());
        Map<String, String> map5 = c2461ak.f7555r;
        StringBuilder sb6 = new StringBuilder();
        sb6.append(crashDetailBean.f7332F);
        map5.put("A1", sb6.toString());
        c2461ak.f7555r.put("A24", c2419a.f7262h);
        Map<String, String> map6 = c2461ak.f7555r;
        StringBuilder sb7 = new StringBuilder();
        sb7.append(crashDetailBean.f7334H);
        map6.put("A17", sb7.toString());
        c2461ak.f7555r.put("A3", c2419a.m5451k());
        c2461ak.f7555r.put("A16", c2419a.m5449m());
        c2461ak.f7555r.put("A25", c2419a.m5448n());
        c2461ak.f7555r.put("A14", c2419a.m5450l());
        c2461ak.f7555r.put("A15", c2419a.m5439w());
        Map<String, String> map7 = c2461ak.f7555r;
        StringBuilder sb8 = new StringBuilder();
        sb8.append(c2419a.m5438x());
        map7.put("A13", sb8.toString());
        c2461ak.f7555r.put("A34", crashDetailBean.f7327A);
        if (c2419a.f7278x != null) {
            c2461ak.f7555r.put("productIdentify", c2419a.f7278x);
        }
        try {
            c2461ak.f7555r.put("A26", URLEncoder.encode(crashDetailBean.f7335I, "utf-8"));
        } catch (UnsupportedEncodingException e7) {
            e7.printStackTrace();
        }
        if (crashDetailBean.f7351b == 1) {
            c2461ak.f7555r.put("A27", crashDetailBean.f7337K);
            c2461ak.f7555r.put("A28", crashDetailBean.f7336J);
            Map<String, String> map8 = c2461ak.f7555r;
            StringBuilder sb9 = new StringBuilder();
            sb9.append(crashDetailBean.f7360k);
            map8.put("A29", sb9.toString());
        }
        c2461ak.f7555r.put("A30", crashDetailBean.f7338L);
        Map<String, String> map9 = c2461ak.f7555r;
        StringBuilder sb10 = new StringBuilder();
        sb10.append(crashDetailBean.f7339M);
        map9.put("A18", sb10.toString());
        Map<String, String> map10 = c2461ak.f7555r;
        StringBuilder sb11 = new StringBuilder();
        sb11.append(!crashDetailBean.f7340N);
        map10.put("A36", sb11.toString());
        Map<String, String> map11 = c2461ak.f7555r;
        StringBuilder sb12 = new StringBuilder();
        sb12.append(c2419a.f7271q);
        map11.put("F02", sb12.toString());
        Map<String, String> map12 = c2461ak.f7555r;
        StringBuilder sb13 = new StringBuilder();
        sb13.append(c2419a.f7272r);
        map12.put("F03", sb13.toString());
        c2461ak.f7555r.put("F04", c2419a.m5460e());
        Map<String, String> map13 = c2461ak.f7555r;
        StringBuilder sb14 = new StringBuilder();
        sb14.append(c2419a.f7273s);
        map13.put("F05", sb14.toString());
        c2461ak.f7555r.put("F06", c2419a.f7270p);
        c2461ak.f7555r.put("F08", c2419a.f7276v);
        c2461ak.f7555r.put("F09", c2419a.f7277w);
        Map<String, String> map14 = c2461ak.f7555r;
        StringBuilder sb15 = new StringBuilder();
        sb15.append(c2419a.f7274t);
        map14.put("F10", sb15.toString());
        if (crashDetailBean.f7342P >= 0) {
            Map<String, String> map15 = c2461ak.f7555r;
            StringBuilder sb16 = new StringBuilder();
            sb16.append(crashDetailBean.f7342P);
            map15.put("C01", sb16.toString());
        }
        if (crashDetailBean.f7343Q >= 0) {
            Map<String, String> map16 = c2461ak.f7555r;
            StringBuilder sb17 = new StringBuilder();
            sb17.append(crashDetailBean.f7343Q);
            map16.put("C02", sb17.toString());
        }
        if (crashDetailBean.f7344R != null && crashDetailBean.f7344R.size() > 0) {
            for (Map.Entry<String, String> entry3 : crashDetailBean.f7344R.entrySet()) {
                c2461ak.f7555r.put("C03_" + entry3.getKey(), entry3.getValue());
            }
        }
        if (crashDetailBean.f7345S != null && crashDetailBean.f7345S.size() > 0) {
            for (Map.Entry<String, String> entry4 : crashDetailBean.f7345S.entrySet()) {
                c2461ak.f7555r.put("C04_" + entry4.getKey(), entry4.getValue());
            }
        }
        c2461ak.f7556s = null;
        if (crashDetailBean.f7341O != null && crashDetailBean.f7341O.size() > 0) {
            c2461ak.f7556s = crashDetailBean.f7341O;
            C2499x.m5090a("setted message size %d", Integer.valueOf(c2461ak.f7556s.size()));
        }
        Object[] objArr2 = new Object[12];
        objArr2[0] = crashDetailBean.f7363n;
        objArr2[1] = crashDetailBean.f7352c;
        objArr2[2] = c2419a.m5460e();
        objArr2[3] = Long.valueOf((crashDetailBean.f7367r - crashDetailBean.f7339M) / 1000);
        objArr2[4] = Boolean.valueOf(crashDetailBean.f7360k);
        objArr2[5] = Boolean.valueOf(crashDetailBean.f7340N);
        objArr2[6] = Boolean.valueOf(crashDetailBean.f7359j);
        objArr2[7] = Boolean.valueOf(crashDetailBean.f7351b == 1);
        objArr2[8] = Integer.valueOf(crashDetailBean.f7369t);
        objArr2[9] = crashDetailBean.f7368s;
        objArr2[10] = Boolean.valueOf(crashDetailBean.f7353d);
        objArr2[11] = Integer.valueOf(c2461ak.f7555r.size());
        C2499x.m5085c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
        return c2461ak;
    }

    /* renamed from: a */
    private static C2460aj m5358a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            C2499x.m5084d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        C2499x.m5085c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!C2503z.m5048a(file, file2, 5000)) {
            C2499x.m5084d("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                    byteArrayOutputStream.flush();
                }
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                C2499x.m5085c("read bytes :%d", Integer.valueOf(byteArray.length));
                C2460aj c2460aj = new C2460aj((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    if (!C2499x.m5089a(e)) {
                        e.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    C2499x.m5085c("del tmp", new Object[0]);
                    file2.delete();
                }
                return c2460aj;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!C2499x.m5089a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            if (!C2499x.m5089a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C2499x.m5085c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th2) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e3) {
                            if (!C2499x.m5089a(e3)) {
                                e3.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        C2499x.m5085c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }

    /* renamed from: a */
    public static void m5357a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        C2419a m5470b = C2419a.m5470b();
        if (m5470b == null) {
            return;
        }
        C2499x.m5083e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        C2499x.m5083e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        C2499x.m5083e("# PKG NAME: %s", m5470b.f7257c);
        C2499x.m5083e("# APP VER: %s", m5470b.f7264j);
        C2499x.m5083e("# LAUNCH TIME: %s", C2503z.m5038a(new Date(C2419a.m5470b().f7230a)));
        C2499x.m5083e("# CRASH TYPE: %s", str);
        C2499x.m5083e("# CRASH TIME: %s", str2);
        C2499x.m5083e("# CRASH PROCESS: %s", str3);
        C2499x.m5083e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            C2499x.m5083e("# REPORT ID: %s", crashDetailBean.f7352c);
            Object[] objArr = new Object[2];
            objArr[0] = m5470b.f7261g;
            objArr[1] = m5470b.m5438x().booleanValue() ? "ROOTED" : "UNROOT";
            C2499x.m5083e("# CRASH DEVICE: %s %s", objArr);
            C2499x.m5083e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f7329C), Long.valueOf(crashDetailBean.f7330D), Long.valueOf(crashDetailBean.f7331E));
            C2499x.m5083e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.f7332F), Long.valueOf(crashDetailBean.f7333G), Long.valueOf(crashDetailBean.f7334H));
            if (!C2503z.m5043a(crashDetailBean.f7337K)) {
                C2499x.m5083e("# EXCEPTION FIRED BY %s %s", crashDetailBean.f7337K, crashDetailBean.f7336J);
            } else if (crashDetailBean.f7351b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.f7341O == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.f7341O.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                C2499x.m5083e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!C2503z.m5043a(str5)) {
            C2499x.m5083e("# CRASH STACK: ", new Object[0]);
            C2499x.m5083e(str5, new Object[0]);
        }
        C2499x.m5083e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
