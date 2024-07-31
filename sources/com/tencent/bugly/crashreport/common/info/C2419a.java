package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import com.tencent.bugly.C2404b;
import com.tencent.bugly.crashreport.InterfaceC2407a;
import com.tencent.bugly.proguard.C2499x;
import com.tencent.bugly.proguard.C2503z;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.a */
/* loaded from: classes2.dex */
public final class C2419a {

    /* renamed from: af */
    private static C2419a f7203af;

    /* renamed from: E */
    public SharedPreferences f7208E;

    /* renamed from: F */
    private final Context f7209F;

    /* renamed from: G */
    private String f7210G;

    /* renamed from: H */
    private String f7211H;

    /* renamed from: I */
    private String f7212I;

    /* renamed from: Y */
    private String f7228Y;

    /* renamed from: al */
    private boolean f7241al;

    /* renamed from: c */
    public String f7257c;

    /* renamed from: d */
    public final String f7258d;

    /* renamed from: f */
    public final String f7260f;

    /* renamed from: g */
    public final String f7261g;

    /* renamed from: h */
    public final String f7262h;

    /* renamed from: i */
    public long f7263i;

    /* renamed from: j */
    public String f7264j;

    /* renamed from: k */
    public String f7265k;

    /* renamed from: l */
    public String f7266l;

    /* renamed from: o */
    public List<String> f7269o;

    /* renamed from: u */
    public boolean f7275u;

    /* renamed from: v */
    public String f7276v;

    /* renamed from: w */
    public String f7277w;

    /* renamed from: x */
    public String f7278x;

    /* renamed from: z */
    public boolean f7280z;

    /* renamed from: e */
    public boolean f7259e = true;

    /* renamed from: J */
    private String f7213J = "unknown";

    /* renamed from: K */
    private String f7214K = "unknown";

    /* renamed from: L */
    private String f7215L = "";

    /* renamed from: M */
    private String f7216M = null;

    /* renamed from: N */
    private String f7217N = null;

    /* renamed from: O */
    private String f7218O = null;

    /* renamed from: P */
    private String f7219P = null;

    /* renamed from: Q */
    private long f7220Q = -1;

    /* renamed from: R */
    private long f7221R = -1;

    /* renamed from: S */
    private long f7222S = -1;

    /* renamed from: T */
    private String f7223T = null;

    /* renamed from: U */
    private String f7224U = null;

    /* renamed from: V */
    private Map<String, PlugInBean> f7225V = null;

    /* renamed from: W */
    private boolean f7226W = true;

    /* renamed from: X */
    private String f7227X = null;

    /* renamed from: Z */
    private Boolean f7229Z = null;

    /* renamed from: aa */
    private String f7231aa = null;

    /* renamed from: ab */
    private String f7232ab = null;

    /* renamed from: ac */
    private String f7233ac = null;

    /* renamed from: m */
    public String f7267m = null;

    /* renamed from: n */
    public String f7268n = null;

    /* renamed from: ad */
    private Map<String, PlugInBean> f7234ad = null;

    /* renamed from: ae */
    private Map<String, PlugInBean> f7235ae = null;

    /* renamed from: ag */
    private int f7236ag = -1;

    /* renamed from: ah */
    private int f7237ah = -1;

    /* renamed from: ai */
    private Map<String, String> f7238ai = new HashMap();

    /* renamed from: aj */
    private Map<String, String> f7239aj = new HashMap();

    /* renamed from: ak */
    private Map<String, String> f7240ak = new HashMap();

    /* renamed from: p */
    public String f7270p = "unknown";

    /* renamed from: q */
    public long f7271q = 0;

    /* renamed from: r */
    public long f7272r = 0;

    /* renamed from: s */
    public long f7273s = 0;

    /* renamed from: t */
    public long f7274t = 0;

    /* renamed from: y */
    public boolean f7279y = false;

    /* renamed from: am */
    private Boolean f7242am = null;

    /* renamed from: an */
    private Boolean f7243an = null;

    /* renamed from: A */
    public HashMap<String, String> f7204A = new HashMap<>();

    /* renamed from: ao */
    private String f7244ao = null;

    /* renamed from: ap */
    private String f7245ap = null;

    /* renamed from: aq */
    private String f7246aq = null;

    /* renamed from: ar */
    private String f7247ar = null;

    /* renamed from: as */
    private String f7248as = null;

    /* renamed from: B */
    public boolean f7205B = true;

    /* renamed from: C */
    public List<String> f7206C = new ArrayList();

    /* renamed from: D */
    public InterfaceC2407a f7207D = null;

    /* renamed from: at */
    private final Object f7249at = new Object();

    /* renamed from: au */
    private final Object f7250au = new Object();

    /* renamed from: av */
    private final Object f7251av = new Object();

    /* renamed from: aw */
    private final Object f7252aw = new Object();

    /* renamed from: ax */
    private final Object f7253ax = new Object();

    /* renamed from: ay */
    private final Object f7254ay = new Object();

    /* renamed from: az */
    private final Object f7255az = new Object();

    /* renamed from: a */
    public final long f7230a = System.currentTimeMillis();

    /* renamed from: b */
    public final byte f7256b = 1;

    /* renamed from: c */
    public static String m5465c() {
        return "2.8.6";
    }

    private C2419a(Context context) {
        this.f7264j = null;
        this.f7265k = null;
        this.f7228Y = null;
        this.f7266l = null;
        this.f7269o = null;
        this.f7275u = false;
        this.f7276v = null;
        this.f7277w = null;
        this.f7278x = null;
        this.f7280z = false;
        this.f7209F = C2503z.m5057a(context);
        PackageInfo m5504b = AppInfo.m5504b(context);
        if (m5504b != null) {
            try {
                this.f7264j = m5504b.versionName;
                this.f7276v = this.f7264j;
                this.f7277w = Integer.toString(m5504b.versionCode);
            } catch (Throwable th) {
                if (!C2499x.m5089a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.f7257c = AppInfo.m5508a(context);
        this.f7258d = AppInfo.m5509a(Process.myPid());
        this.f7260f = C2420b.m5408o();
        this.f7261g = C2420b.m5435a();
        this.f7265k = AppInfo.m5503c(context);
        this.f7262h = "Android " + C2420b.m5432b() + ",level " + C2420b.m5430c();
        String str = this.f7261g + ";" + this.f7262h;
        Map<String, String> m5502d = AppInfo.m5502d(context);
        if (m5502d != null) {
            try {
                this.f7269o = AppInfo.m5506a(m5502d);
                String str2 = m5502d.get("BUGLY_APPID");
                if (str2 != null) {
                    this.f7228Y = str2;
                    m5463c("APP_ID", this.f7228Y);
                }
                String str3 = m5502d.get("BUGLY_APP_VERSION");
                if (str3 != null) {
                    this.f7264j = str3;
                }
                String str4 = m5502d.get("BUGLY_APP_CHANNEL");
                if (str4 != null) {
                    this.f7266l = str4;
                }
                String str5 = m5502d.get("BUGLY_ENABLE_DEBUG");
                if (str5 != null) {
                    this.f7275u = str5.equalsIgnoreCase("true");
                }
                String str6 = m5502d.get("com.tencent.rdm.uuid");
                if (str6 != null) {
                    this.f7278x = str6;
                }
            } catch (Throwable th2) {
                if (!C2499x.m5089a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f7280z = true;
                C2499x.m5085c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th3) {
            if (C2404b.f7146c) {
                th3.printStackTrace();
            }
        }
        this.f7208E = C2503z.m5042a("BUGLY_COMMON_VALUES", context);
        C2499x.m5085c("com info create end", new Object[0]);
    }

    /* renamed from: a */
    public final boolean m5476a() {
        return this.f7241al;
    }

    /* renamed from: a */
    public final void m5471a(boolean z) {
        this.f7241al = z;
        InterfaceC2407a interfaceC2407a = this.f7207D;
        if (interfaceC2407a != null) {
            interfaceC2407a.setNativeIsAppForeground(z);
        }
    }

    /* renamed from: a */
    public static synchronized C2419a m5474a(Context context) {
        C2419a c2419a;
        synchronized (C2419a.class) {
            if (f7203af == null) {
                f7203af = new C2419a(context);
            }
            c2419a = f7203af;
        }
        return c2419a;
    }

    /* renamed from: b */
    public static synchronized C2419a m5470b() {
        C2419a c2419a;
        synchronized (C2419a.class) {
            c2419a = f7203af;
        }
        return c2419a;
    }

    /* renamed from: d */
    public final void m5462d() {
        synchronized (this.f7249at) {
            this.f7210G = UUID.randomUUID().toString();
        }
    }

    /* renamed from: e */
    public final String m5460e() {
        synchronized (this.f7249at) {
            if (this.f7210G == null) {
                synchronized (this.f7249at) {
                    this.f7210G = UUID.randomUUID().toString();
                }
            }
        }
        return this.f7210G;
    }

    /* renamed from: f */
    public final String m5458f() {
        if (C2503z.m5043a((String) null)) {
            return this.f7228Y;
        }
        return null;
    }

    /* renamed from: a */
    public final void m5473a(String str) {
        this.f7228Y = str;
        m5463c("APP_ID", str);
    }

    /* renamed from: g */
    public final String m5456g() {
        String str;
        synchronized (this.f7254ay) {
            str = this.f7213J;
        }
        return str;
    }

    /* renamed from: b */
    public final void m5468b(String str) {
        synchronized (this.f7254ay) {
            if (str == null) {
                str = "10000";
            }
            this.f7213J = str;
        }
    }

    /* renamed from: b */
    public final void m5466b(boolean z) {
        this.f7226W = z;
    }

    /* renamed from: h */
    public final String m5454h() {
        String str = this.f7212I;
        if (str != null) {
            return str;
        }
        this.f7212I = m5451k() + "|" + m5449m() + "|" + m5448n();
        return this.f7212I;
    }

    /* renamed from: c */
    public final void m5464c(String str) {
        this.f7212I = str;
        synchronized (this.f7255az) {
            this.f7239aj.put("E8", str);
        }
    }

    /* renamed from: i */
    public final synchronized String m5453i() {
        return this.f7214K;
    }

    /* renamed from: d */
    public final synchronized void m5461d(String str) {
        this.f7214K = str;
    }

    /* renamed from: j */
    public final synchronized String m5452j() {
        return this.f7215L;
    }

    /* renamed from: e */
    public final synchronized void m5459e(String str) {
        this.f7215L = str;
    }

    /* renamed from: k */
    public final String m5451k() {
        if (this.f7226W) {
            if (this.f7216M == null) {
                Context context = this.f7209F;
                this.f7216M = C2420b.m5428d();
            }
            return this.f7216M;
        }
        return "";
    }

    /* renamed from: l */
    public final String m5450l() {
        if (this.f7226W) {
            String str = this.f7217N;
            if (str == null || !str.contains(":")) {
                Context context = this.f7209F;
                this.f7217N = C2420b.m5424f();
            }
            return this.f7217N;
        }
        return "";
    }

    /* renamed from: m */
    public final String m5449m() {
        if (this.f7226W) {
            if (this.f7218O == null) {
                Context context = this.f7209F;
                this.f7218O = C2420b.m5426e();
            }
            return this.f7218O;
        }
        return "";
    }

    /* renamed from: n */
    public final String m5448n() {
        if (this.f7226W) {
            if (this.f7219P == null) {
                this.f7219P = C2420b.m5434a(this.f7209F);
            }
            return this.f7219P;
        }
        return "";
    }

    /* renamed from: o */
    public final long m5447o() {
        if (this.f7220Q <= 0) {
            this.f7220Q = C2420b.m5420h();
        }
        return this.f7220Q;
    }

    /* renamed from: p */
    public final long m5446p() {
        if (this.f7221R <= 0) {
            this.f7221R = C2420b.m5416j();
        }
        return this.f7221R;
    }

    /* renamed from: q */
    public final long m5445q() {
        if (this.f7222S <= 0) {
            this.f7222S = C2420b.m5412l();
        }
        return this.f7222S;
    }

    /* renamed from: r */
    public final String m5444r() {
        if (this.f7223T == null) {
            this.f7223T = C2420b.m5433a(this.f7209F, true);
        }
        return this.f7223T;
    }

    /* renamed from: s */
    public final String m5443s() {
        if (this.f7224U == null) {
            this.f7224U = C2420b.m5425e(this.f7209F);
        }
        return this.f7224U;
    }

    /* renamed from: a */
    public final void m5472a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.f7250au) {
            this.f7204A.put(str, str2);
        }
    }

    /* renamed from: t */
    public final String m5442t() {
        try {
            Map<String, ?> all = this.f7209F.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f7250au) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        this.f7204A.put(entry.getKey(), entry.getValue().toString());
                    }
                }
            }
        } catch (Throwable th) {
            C2499x.m5089a(th);
        }
        if (this.f7204A.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.f7204A.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(",");
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        m5463c("SDK_INFO", sb.toString());
        return sb.toString();
    }

    /* renamed from: u */
    public final String m5441u() {
        if (this.f7248as == null) {
            this.f7248as = AppInfo.m5501e(this.f7209F);
        }
        return this.f7248as;
    }

    /* renamed from: v */
    public final synchronized Map<String, PlugInBean> m5440v() {
        return null;
    }

    /* renamed from: w */
    public final String m5439w() {
        if (this.f7227X == null) {
            this.f7227X = C2420b.m5409n();
        }
        return this.f7227X;
    }

    /* renamed from: x */
    public final Boolean m5438x() {
        if (this.f7229Z == null) {
            this.f7229Z = Boolean.valueOf(C2420b.m5407p());
        }
        return this.f7229Z;
    }

    /* renamed from: y */
    public final String m5437y() {
        if (this.f7231aa == null) {
            this.f7231aa = C2420b.m5427d(this.f7209F);
            C2499x.m5090a("ROM ID: %s", this.f7231aa);
        }
        return this.f7231aa;
    }

    /* renamed from: z */
    public final String m5436z() {
        if (this.f7232ab == null) {
            this.f7232ab = C2420b.m5431b(this.f7209F);
            C2499x.m5090a("SIM serial number: %s", this.f7232ab);
        }
        return this.f7232ab;
    }

    /* renamed from: A */
    public final String m5496A() {
        if (this.f7233ac == null) {
            this.f7233ac = C2420b.m5422g();
            C2499x.m5090a("Hardware serial number: %s", this.f7233ac);
        }
        return this.f7233ac;
    }

    /* renamed from: B */
    public final Map<String, String> m5495B() {
        synchronized (this.f7251av) {
            if (this.f7238ai.size() <= 0) {
                return null;
            }
            return new HashMap(this.f7238ai);
        }
    }

    /* renamed from: f */
    public final String m5457f(String str) {
        String remove;
        if (C2503z.m5043a(str)) {
            C2499x.m5084d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.f7251av) {
            remove = this.f7238ai.remove(str);
        }
        return remove;
    }

    /* renamed from: C */
    public final void m5494C() {
        synchronized (this.f7251av) {
            this.f7238ai.clear();
        }
    }

    /* renamed from: g */
    public final String m5455g(String str) {
        String str2;
        if (C2503z.m5043a(str)) {
            C2499x.m5084d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.f7251av) {
            str2 = this.f7238ai.get(str);
        }
        return str2;
    }

    /* renamed from: b */
    public final void m5467b(String str, String str2) {
        if (!C2503z.m5043a(str) && !C2503z.m5043a(str2)) {
            synchronized (this.f7251av) {
                this.f7238ai.put(str, str2);
            }
            return;
        }
        C2499x.m5084d("key&value should not be empty %s %s", str, str2);
    }

    /* renamed from: D */
    public final int m5493D() {
        int size;
        synchronized (this.f7251av) {
            size = this.f7238ai.size();
        }
        return size;
    }

    /* renamed from: E */
    public final Set<String> m5492E() {
        Set<String> keySet;
        synchronized (this.f7251av) {
            keySet = this.f7238ai.keySet();
        }
        return keySet;
    }

    /* renamed from: F */
    public final Map<String, String> m5491F() {
        synchronized (this.f7255az) {
            if (this.f7239aj.size() <= 0) {
                return null;
            }
            return new HashMap(this.f7239aj);
        }
    }

    /* renamed from: c */
    public final void m5463c(String str, String str2) {
        if (!C2503z.m5043a(str) && !C2503z.m5043a(str2)) {
            synchronized (this.f7252aw) {
                this.f7240ak.put(str, str2);
            }
            return;
        }
        C2499x.m5084d("server key&value should not be empty %s %s", str, str2);
    }

    /* renamed from: G */
    public final Map<String, String> m5490G() {
        synchronized (this.f7252aw) {
            if (this.f7240ak.size() <= 0) {
                return null;
            }
            return new HashMap(this.f7240ak);
        }
    }

    /* renamed from: a */
    public final void m5475a(int i) {
        synchronized (this.f7253ax) {
            int i2 = this.f7236ag;
            if (i2 != i) {
                this.f7236ag = i;
                C2499x.m5090a("user scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f7236ag));
            }
        }
    }

    /* renamed from: H */
    public final int m5489H() {
        int i;
        synchronized (this.f7253ax) {
            i = this.f7236ag;
        }
        return i;
    }

    /* renamed from: b */
    public final void m5469b(int i) {
        int i2 = this.f7237ah;
        if (i2 != 24096) {
            this.f7237ah = 24096;
            C2499x.m5090a("server scene tag %d changed to tag %d", Integer.valueOf(i2), Integer.valueOf(this.f7237ah));
        }
    }

    /* renamed from: I */
    public final int m5488I() {
        return this.f7237ah;
    }

    /* renamed from: J */
    public final synchronized Map<String, PlugInBean> m5487J() {
        return null;
    }

    /* renamed from: K */
    public static int m5486K() {
        return C2420b.m5430c();
    }

    /* renamed from: L */
    public final String m5485L() {
        if (this.f7244ao == null) {
            this.f7244ao = C2420b.m5406q();
        }
        return this.f7244ao;
    }

    /* renamed from: M */
    public final String m5484M() {
        if (this.f7245ap == null) {
            this.f7245ap = C2420b.m5423f(this.f7209F);
        }
        return this.f7245ap;
    }

    /* renamed from: N */
    public final String m5483N() {
        if (this.f7246aq == null) {
            this.f7246aq = C2420b.m5421g(this.f7209F);
        }
        return this.f7246aq;
    }

    /* renamed from: O */
    public final String m5482O() {
        Context context = this.f7209F;
        return C2420b.m5405r();
    }

    /* renamed from: P */
    public final String m5481P() {
        if (this.f7247ar == null) {
            this.f7247ar = C2420b.m5419h(this.f7209F);
        }
        return this.f7247ar;
    }

    /* renamed from: Q */
    public final long m5480Q() {
        Context context = this.f7209F;
        return C2420b.m5404s();
    }

    /* renamed from: R */
    public final boolean m5479R() {
        if (this.f7242am == null) {
            this.f7242am = Boolean.valueOf(C2420b.m5417i(this.f7209F));
            C2499x.m5090a("Is it a virtual machine? " + this.f7242am, new Object[0]);
        }
        return this.f7242am.booleanValue();
    }

    /* renamed from: S */
    public final boolean m5478S() {
        if (this.f7243an == null) {
            this.f7243an = Boolean.valueOf(C2420b.m5415j(this.f7209F));
            C2499x.m5090a("Does it has hook frame? " + this.f7243an, new Object[0]);
        }
        return this.f7243an.booleanValue();
    }

    /* renamed from: T */
    public final String m5477T() {
        if (this.f7211H == null) {
            this.f7211H = AppInfo.m5499g(this.f7209F);
            C2499x.m5090a("Beacon channel " + this.f7211H, new Object[0]);
        }
        return this.f7211H;
    }
}
