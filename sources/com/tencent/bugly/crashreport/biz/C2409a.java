package com.tencent.bugly.crashreport.biz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.AbstractC2479k;
import com.tencent.bugly.proguard.C2450a;
import com.tencent.bugly.proguard.C2463am;
import com.tencent.bugly.proguard.C2468ar;
import com.tencent.bugly.proguard.C2486p;
import com.tencent.bugly.proguard.C2492u;
import com.tencent.bugly.proguard.C2497w;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import com.tencent.bugly.proguard.InterfaceC2485o;
import com.tencent.bugly.proguard.InterfaceC2491t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.biz.a */
/* loaded from: classes2.dex */
public final class C2409a {

    /* renamed from: a */
    private Context f7171a;

    /* renamed from: b */
    private long f7172b;

    /* renamed from: c */
    private int f7173c;

    /* renamed from: d */
    private boolean f7174d;

    /* renamed from: a */
    static /* synthetic */ void m5536a(C2409a c2409a, UserInfoBean userInfoBean, boolean z) {
        List<UserInfoBean> m5535a;
        if (userInfoBean != null) {
            if (!z && userInfoBean.f7153b != 1 && (m5535a = c2409a.m5535a(C2419a.m5474a(c2409a.f7171a).f7258d)) != null && m5535a.size() >= 20) {
                C2499x.m5090a("[UserInfo] There are too many user info in local: %d", Integer.valueOf(m5535a.size()));
                return;
            }
            long m5157a = C2486p.m5175a().m5157a("t_ui", m5538a(userInfoBean), (InterfaceC2485o) null, true);
            if (m5157a >= 0) {
                C2499x.m5085c("[Database] insert %s success with ID: %d", "t_ui", Long.valueOf(m5157a));
                userInfoBean.f7152a = m5157a;
            }
        }
    }

    public C2409a(Context context, boolean z) {
        this.f7174d = true;
        this.f7171a = context;
        this.f7174d = z;
    }

    /* renamed from: a */
    public final void m5540a(int i, boolean z, long j) {
        C2422a m5399a = C2422a.m5399a();
        if (m5399a != null && !m5399a.m5390c().f7293h && i != 1 && i != 3) {
            C2499x.m5083e("UserInfo is disable", new Object[0]);
            return;
        }
        if (i == 1 || i == 3) {
            this.f7173c++;
        }
        C2419a m5474a = C2419a.m5474a(this.f7171a);
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.f7153b = i;
        userInfoBean.f7154c = m5474a.f7258d;
        userInfoBean.f7155d = m5474a.m5456g();
        userInfoBean.f7156e = System.currentTimeMillis();
        userInfoBean.f7157f = -1L;
        userInfoBean.f7165n = m5474a.f7264j;
        userInfoBean.f7166o = i == 1 ? 1 : 0;
        userInfoBean.f7163l = m5474a.m5476a();
        userInfoBean.f7164m = m5474a.f7270p;
        userInfoBean.f7158g = m5474a.f7271q;
        userInfoBean.f7159h = m5474a.f7272r;
        userInfoBean.f7160i = m5474a.f7273s;
        userInfoBean.f7162k = m5474a.f7274t;
        userInfoBean.f7169r = m5474a.m5495B();
        userInfoBean.f7170s = m5474a.m5490G();
        userInfoBean.f7167p = m5474a.m5489H();
        userInfoBean.f7168q = m5474a.m5488I();
        C2497w.m5098a().m5096a(new RunnableC2412a(userInfoBean, z), 0L);
    }

    /* renamed from: a */
    public final void m5541a() {
        this.f7172b = C2503z.m5032b() + 86400000;
        C2497w.m5098a().m5096a(new RunnableC2413b(), (this.f7172b - System.currentTimeMillis()) + 5000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$a */
    /* loaded from: classes2.dex */
    public class RunnableC2412a implements Runnable {

        /* renamed from: a */
        private boolean f7178a;

        /* renamed from: b */
        private UserInfoBean f7179b;

        public RunnableC2412a(UserInfoBean userInfoBean, boolean z) {
            this.f7179b = userInfoBean;
            this.f7178a = z;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C2419a m5470b;
            try {
                if (this.f7179b != null) {
                    UserInfoBean userInfoBean = this.f7179b;
                    if (userInfoBean != null && (m5470b = C2419a.m5470b()) != null) {
                        userInfoBean.f7161j = m5470b.m5460e();
                    }
                    C2499x.m5085c("[UserInfo] Record user info.", new Object[0]);
                    C2409a.m5536a(C2409a.this, this.f7179b, false);
                }
                if (this.f7178a) {
                    C2409a c2409a = C2409a.this;
                    C2497w m5098a = C2497w.m5098a();
                    if (m5098a != null) {
                        m5098a.m5097a(new RunnableC24112());
                    }
                }
            } catch (Throwable th) {
                if (C2499x.m5089a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m5531c() {
        boolean z;
        if (this.f7174d) {
            C2492u m5135a = C2492u.m5135a();
            if (m5135a == null) {
                return;
            }
            C2422a m5399a = C2422a.m5399a();
            if (m5399a == null) {
                return;
            }
            if (!m5399a.m5392b() || m5135a.m5114b(1001)) {
                String str = C2419a.m5474a(this.f7171a).f7258d;
                ArrayList arrayList = new ArrayList();
                final List<UserInfoBean> m5535a = m5535a(str);
                if (m5535a != null) {
                    int size = m5535a.size() - 20;
                    if (size > 0) {
                        int i = 0;
                        while (i < m5535a.size() - 1) {
                            int i2 = i + 1;
                            for (int i3 = i2; i3 < m5535a.size(); i3++) {
                                if (m5535a.get(i).f7156e > m5535a.get(i3).f7156e) {
                                    m5535a.set(i, m5535a.get(i3));
                                    m5535a.set(i3, m5535a.get(i));
                                }
                            }
                            i = i2;
                        }
                        for (int i4 = 0; i4 < size; i4++) {
                            arrayList.add(m5535a.get(i4));
                        }
                    }
                    Iterator<UserInfoBean> it = m5535a.iterator();
                    int i5 = 0;
                    while (it.hasNext()) {
                        UserInfoBean next = it.next();
                        if (next.f7157f != -1) {
                            it.remove();
                            if (next.f7156e < C2503z.m5032b()) {
                                arrayList.add(next);
                            }
                        }
                        if (next.f7156e > System.currentTimeMillis() - 600000 && (next.f7153b == 1 || next.f7153b == 4 || next.f7153b == 3)) {
                            i5++;
                        }
                    }
                    if (i5 > 15) {
                        C2499x.m5084d("[UserInfo] Upload user info too many times in 10 min: %d", Integer.valueOf(i5));
                        z = false;
                    } else {
                        z = true;
                    }
                } else {
                    m5535a = new ArrayList<>();
                    z = true;
                }
                if (arrayList.size() > 0) {
                    m5534a(arrayList);
                }
                if (z && m5535a.size() != 0) {
                    C2499x.m5085c("[UserInfo] Upload user info(size: %d)", Integer.valueOf(m5535a.size()));
                    C2468ar m5273a = C2450a.m5273a(m5535a, this.f7173c == 1 ? 1 : 2);
                    if (m5273a == null) {
                        C2499x.m5084d("[UserInfo] Failed to create UserInfoPackage.", new Object[0]);
                        return;
                    }
                    byte[] m5277a = C2450a.m5277a((AbstractC2479k) m5273a);
                    if (m5277a == null) {
                        C2499x.m5084d("[UserInfo] Failed to encode data.", new Object[0]);
                        return;
                    }
                    C2463am m5279a = C2450a.m5279a(this.f7171a, m5135a.f7712a ? 840 : 640, m5277a);
                    if (m5279a == null) {
                        C2499x.m5084d("[UserInfo] Request package is null.", new Object[0]);
                        return;
                    }
                    InterfaceC2491t interfaceC2491t = new InterfaceC2491t() { // from class: com.tencent.bugly.crashreport.biz.a.1
                        @Override // com.tencent.bugly.proguard.InterfaceC2491t
                        /* renamed from: a */
                        public final void mo5136a(boolean z2) {
                            if (z2) {
                                C2499x.m5085c("[UserInfo] Successfully uploaded user info.", new Object[0]);
                                long currentTimeMillis = System.currentTimeMillis();
                                for (UserInfoBean userInfoBean : m5535a) {
                                    userInfoBean.f7157f = currentTimeMillis;
                                    C2409a.m5536a(C2409a.this, userInfoBean, true);
                                }
                            }
                        }
                    };
                    StrategyBean m5390c = C2422a.m5399a().m5390c();
                    C2492u.m5135a().m5130a(1001, m5279a, m5135a.f7712a ? m5390c.f7303r : m5390c.f7305t, m5135a.f7712a ? StrategyBean.f7287b : StrategyBean.f7286a, interfaceC2491t, this.f7173c == 1);
                    return;
                }
                C2499x.m5085c("[UserInfo] There is no user info in local database.", new Object[0]);
            }
        }
    }

    /* renamed from: b */
    public final void m5533b() {
        C2497w m5098a = C2497w.m5098a();
        if (m5098a != null) {
            m5098a.m5097a(new RunnableC24112());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$2 */
    /* loaded from: classes2.dex */
    public final class RunnableC24112 implements Runnable {
        /* JADX INFO: Access modifiers changed from: package-private */
        public RunnableC24112() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                C2409a.this.m5531c();
            } catch (Throwable th) {
                C2499x.m5089a(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$b */
    /* loaded from: classes2.dex */
    public class RunnableC2413b implements Runnable {
        RunnableC2413b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis < C2409a.this.f7172b) {
                C2497w.m5098a().m5096a(new RunnableC2413b(), (C2409a.this.f7172b - currentTimeMillis) + 5000);
                return;
            }
            C2409a.this.m5540a(3, false, 0L);
            C2409a.this.m5541a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.biz.a$c */
    /* loaded from: classes2.dex */
    public class RunnableC2414c implements Runnable {

        /* renamed from: a */
        private long f7182a;

        public RunnableC2414c(long j) {
            this.f7182a = 21600000L;
            this.f7182a = j;
        }

        @Override // java.lang.Runnable
        public final void run() {
            C2409a c2409a = C2409a.this;
            C2497w m5098a = C2497w.m5098a();
            if (m5098a != null) {
                m5098a.m5097a(new RunnableC24112());
            }
            C2409a c2409a2 = C2409a.this;
            long j = this.f7182a;
            C2497w.m5098a().m5096a(new RunnableC2414c(j), j);
        }
    }

    /* renamed from: a */
    public final List<UserInfoBean> m5535a(String str) {
        Cursor cursor;
        String str2;
        try {
            if (C2503z.m5043a(str)) {
                str2 = null;
            } else {
                str2 = "_pc = '" + str + "'";
            }
            cursor = C2486p.m5175a().m5154a("t_ui", null, str2, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                StringBuilder sb = new StringBuilder();
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    UserInfoBean m5539a = m5539a(cursor);
                    if (m5539a != null) {
                        arrayList.add(m5539a);
                    } else {
                        long j = cursor.getLong(cursor.getColumnIndex("_id"));
                        sb.append(" or _id");
                        sb.append(" = ");
                        sb.append(j);
                    }
                }
                String sb2 = sb.toString();
                if (sb2.length() > 0) {
                    C2499x.m5084d("[Database] deleted %s error data %d", "t_ui", Integer.valueOf(C2486p.m5175a().m5155a("t_ui", sb2.substring(4), (String[]) null, (InterfaceC2485o) null, true)));
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

    /* renamed from: a */
    private static void m5534a(List<UserInfoBean> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() && i < 50; i++) {
            sb.append(" or _id");
            sb.append(" = ");
            sb.append(list.get(i).f7152a);
        }
        String sb2 = sb.toString();
        String substring = sb2.length() > 0 ? sb2.substring(4) : sb2;
        sb.setLength(0);
        try {
            C2499x.m5085c("[Database] deleted %s data %d", "t_ui", Integer.valueOf(C2486p.m5175a().m5155a("t_ui", substring, (String[]) null, (InterfaceC2485o) null, true)));
        } catch (Throwable th) {
            if (C2499x.m5089a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private static ContentValues m5538a(UserInfoBean userInfoBean) {
        if (userInfoBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (userInfoBean.f7152a > 0) {
                contentValues.put("_id", Long.valueOf(userInfoBean.f7152a));
            }
            contentValues.put("_tm", Long.valueOf(userInfoBean.f7156e));
            contentValues.put("_ut", Long.valueOf(userInfoBean.f7157f));
            contentValues.put("_tp", Integer.valueOf(userInfoBean.f7153b));
            contentValues.put("_pc", userInfoBean.f7154c);
            contentValues.put("_dt", C2503z.m5051a(userInfoBean));
            return contentValues;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    /* renamed from: a */
    private static UserInfoBean m5539a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            UserInfoBean userInfoBean = (UserInfoBean) C2503z.m5033a(blob, UserInfoBean.CREATOR);
            if (userInfoBean != null) {
                userInfoBean.f7152a = j;
            }
            return userInfoBean;
        } catch (Throwable th) {
            if (!C2499x.m5089a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }
}
