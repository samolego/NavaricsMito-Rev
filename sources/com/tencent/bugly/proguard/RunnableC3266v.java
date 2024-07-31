package com.tencent.bugly.proguard;

import android.content.Context;
import com.tencent.bugly.crashreport.common.info.C2419a;
import com.tencent.bugly.crashreport.common.strategy.C2422a;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.v */
/* loaded from: classes2.dex */
public final class RunnableC2496v implements Runnable {

    /* renamed from: a */
    private int f7740a;

    /* renamed from: b */
    private int f7741b;

    /* renamed from: c */
    private final Context f7742c;

    /* renamed from: d */
    private final int f7743d;

    /* renamed from: e */
    private final byte[] f7744e;

    /* renamed from: f */
    private final C2419a f7745f;

    /* renamed from: g */
    private final C2422a f7746g;

    /* renamed from: h */
    private final C2490s f7747h;

    /* renamed from: i */
    private final C2492u f7748i;

    /* renamed from: j */
    private final int f7749j;

    /* renamed from: k */
    private final InterfaceC2491t f7750k;

    /* renamed from: l */
    private final InterfaceC2491t f7751l;

    /* renamed from: m */
    private String f7752m;

    /* renamed from: n */
    private final String f7753n;

    /* renamed from: o */
    private final Map<String, String> f7754o;

    /* renamed from: p */
    private int f7755p;

    /* renamed from: q */
    private long f7756q;

    /* renamed from: r */
    private long f7757r;

    /* renamed from: s */
    private boolean f7758s;

    /* renamed from: t */
    private boolean f7759t;

    public RunnableC2496v(Context context, int i, int i2, byte[] bArr, String str, String str2, InterfaceC2491t interfaceC2491t, boolean z, boolean z2) {
        this(context, i, i2, bArr, str, str2, interfaceC2491t, z, 2, 30000, z2, null);
    }

    public RunnableC2496v(Context context, int i, int i2, byte[] bArr, String str, String str2, InterfaceC2491t interfaceC2491t, boolean z, int i3, int i4, boolean z2, Map<String, String> map) {
        boolean z3;
        this.f7740a = 2;
        this.f7741b = 30000;
        this.f7752m = null;
        this.f7755p = 0;
        this.f7756q = 0L;
        this.f7757r = 0L;
        this.f7758s = true;
        this.f7759t = false;
        this.f7742c = context;
        this.f7745f = C2419a.m5474a(context);
        this.f7744e = bArr;
        this.f7746g = C2422a.m5399a();
        this.f7747h = C2490s.m5142a(context);
        this.f7748i = C2492u.m5135a();
        this.f7749j = i;
        this.f7752m = str;
        this.f7753n = str2;
        this.f7750k = interfaceC2491t;
        C2492u c2492u = this.f7748i;
        this.f7751l = null;
        this.f7758s = z;
        this.f7743d = i2;
        if (i3 > 0) {
            this.f7740a = i3;
        }
        if (i4 > 0) {
            this.f7741b = i4;
            z3 = z2;
        } else {
            z3 = z2;
        }
        this.f7759t = z3;
        this.f7754o = map;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m5101a(com.tencent.bugly.proguard.C2464an r5, boolean r6, int r7, java.lang.String r8, int r9) {
        /*
            r4 = this;
            int r5 = r4.f7743d
            r0 = 630(0x276, float:8.83E-43)
            if (r5 == r0) goto L1a
            r0 = 640(0x280, float:8.97E-43)
            if (r5 == r0) goto L17
            r0 = 830(0x33e, float:1.163E-42)
            if (r5 == r0) goto L1a
            r0 = 840(0x348, float:1.177E-42)
            if (r5 == r0) goto L17
            java.lang.String r5 = java.lang.String.valueOf(r5)
            goto L1c
        L17:
            java.lang.String r5 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r5 = "crash"
        L1c:
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L2a
            java.lang.String r7 = "[Upload] Success: %s"
            java.lang.Object[] r8 = new java.lang.Object[r0]
            r8[r1] = r5
            com.tencent.bugly.proguard.C2499x.m5090a(r7, r8)
            goto L47
        L2a:
            java.lang.String r2 = "[Upload] Failed to upload(%d) %s: %s"
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r3[r1] = r7
            r3[r0] = r5
            r5 = 2
            r3[r5] = r8
            com.tencent.bugly.proguard.C2499x.m5083e(r2, r3)
            boolean r5 = r4.f7758s
            if (r5 == 0) goto L47
            com.tencent.bugly.proguard.u r5 = r4.f7748i
            r7 = 0
            r5.m5129a(r9, r7)
        L47:
            long r7 = r4.f7756q
            long r0 = r4.f7757r
            long r7 = r7 + r0
            r0 = 0
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 <= 0) goto L67
            com.tencent.bugly.proguard.u r5 = r4.f7748i
            boolean r7 = r4.f7759t
            long r7 = r5.m5117a(r7)
            long r0 = r4.f7756q
            long r7 = r7 + r0
            long r0 = r4.f7757r
            long r7 = r7 + r0
            com.tencent.bugly.proguard.u r5 = r4.f7748i
            boolean r9 = r4.f7759t
            r5.m5128a(r7, r9)
        L67:
            com.tencent.bugly.proguard.t r5 = r4.f7750k
            if (r5 == 0) goto L74
            int r7 = r4.f7743d
            long r7 = r4.f7756q
            long r7 = r4.f7757r
            r5.mo5136a(r6)
        L74:
            com.tencent.bugly.proguard.t r5 = r4.f7751l
            if (r5 == 0) goto L81
            int r7 = r4.f7743d
            long r7 = r4.f7756q
            long r7 = r4.f7757r
            r5.mo5136a(r6)
        L81:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC2496v.m5101a(com.tencent.bugly.proguard.an, boolean, int, java.lang.String, int):void");
    }

    /* renamed from: a */
    private static boolean m5102a(C2464an c2464an, C2419a c2419a, C2422a c2422a) {
        if (c2464an == null) {
            C2499x.m5084d("resp == null!", new Object[0]);
            return false;
        } else if (c2464an.f7589a != 0) {
            C2499x.m5083e("resp result error %d", Byte.valueOf(c2464an.f7589a));
            return false;
        } else {
            try {
                if (!C2503z.m5043a(c2464an.f7592d) && !C2419a.m5470b().m5453i().equals(c2464an.f7592d)) {
                    C2486p.m5175a().m5168a(C2422a.f7311a, "gateway", c2464an.f7592d.getBytes("UTF-8"), (InterfaceC2485o) null, true);
                    c2419a.m5461d(c2464an.f7592d);
                }
                if (!C2503z.m5043a(c2464an.f7594f) && !C2419a.m5470b().m5452j().equals(c2464an.f7594f)) {
                    C2486p.m5175a().m5168a(C2422a.f7311a, "device", c2464an.f7594f.getBytes("UTF-8"), (InterfaceC2485o) null, true);
                    c2419a.m5459e(c2464an.f7594f);
                }
            } catch (Throwable th) {
                C2499x.m5089a(th);
            }
            c2419a.f7263i = c2464an.f7593e;
            if (c2464an.f7590b == 510) {
                if (c2464an.f7591c == null) {
                    C2499x.m5083e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(c2464an.f7590b));
                    return false;
                }
                C2466ap c2466ap = (C2466ap) C2450a.m5272a(c2464an.f7591c, C2466ap.class);
                if (c2466ap == null) {
                    C2499x.m5083e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(c2464an.f7590b));
                    return false;
                }
                c2422a.m5393a(c2466ap);
            }
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x02ae A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0245 A[Catch: Throwable -> 0x0475, TryCatch #1 {Throwable -> 0x0475, blocks: (B:3:0x0003, B:5:0x0015, B:8:0x0023, B:11:0x0028, B:13:0x003c, B:15:0x006e, B:17:0x0081, B:19:0x0085, B:21:0x0089, B:24:0x008f, B:26:0x0097, B:28:0x00a3, B:30:0x00c9, B:31:0x00ce, B:33:0x00d2, B:35:0x0105, B:37:0x0111, B:39:0x0117, B:41:0x0123, B:43:0x012b, B:45:0x0137, B:47:0x0146, B:48:0x014a, B:50:0x014e, B:51:0x0152, B:52:0x0159, B:55:0x0161, B:57:0x0178, B:58:0x0185, B:60:0x0197, B:61:0x019c, B:63:0x01cb, B:64:0x01e0, B:67:0x01ea, B:70:0x01f1, B:72:0x01f9, B:73:0x0201, B:84:0x0245, B:86:0x0273, B:87:0x027b, B:89:0x0281, B:90:0x02a1, B:95:0x02df, B:97:0x02ea, B:98:0x02ff, B:100:0x0348, B:74:0x0205, B:76:0x020d, B:77:0x0216, B:79:0x0226, B:80:0x0230, B:81:0x023b, B:103:0x0388, B:105:0x039a, B:107:0x039d, B:108:0x03a5, B:110:0x03ab, B:111:0x03c5, B:113:0x03d1, B:115:0x03d9, B:117:0x03e5, B:119:0x03eb, B:121:0x03f7, B:123:0x03ff, B:125:0x040b, B:127:0x040f, B:128:0x0414, B:132:0x0428, B:134:0x043b, B:136:0x0446, B:131:0x0425, B:138:0x0451, B:140:0x045d, B:142:0x0469, B:92:0x02ae), top: B:149:0x0003 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instructions count: 1152
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC2496v.run():void");
    }

    /* renamed from: a */
    public final void m5103a(long j) {
        this.f7755p++;
        this.f7756q += j;
    }

    /* renamed from: b */
    public final void m5099b(long j) {
        this.f7757r += j;
    }

    /* renamed from: a */
    private static String m5100a(String str) {
        if (C2503z.m5043a(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            C2499x.m5089a(th);
            return str;
        }
    }
}
