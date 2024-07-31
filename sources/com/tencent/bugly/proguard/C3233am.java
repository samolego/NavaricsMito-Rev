package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.am */
/* loaded from: classes2.dex */
public final class C2463am extends AbstractC2479k {

    /* renamed from: y */
    private static byte[] f7561y;

    /* renamed from: z */
    private static Map<String, String> f7562z = new HashMap();

    /* renamed from: a */
    public int f7563a = 0;

    /* renamed from: b */
    public String f7564b = "";

    /* renamed from: c */
    public String f7565c = "";

    /* renamed from: d */
    public String f7566d = "";

    /* renamed from: e */
    public String f7567e = "";

    /* renamed from: f */
    public String f7568f = "";

    /* renamed from: g */
    public int f7569g = 0;

    /* renamed from: h */
    public byte[] f7570h = null;

    /* renamed from: i */
    public String f7571i = "";

    /* renamed from: j */
    public String f7572j = "";

    /* renamed from: k */
    public Map<String, String> f7573k = null;

    /* renamed from: l */
    public String f7574l = "";

    /* renamed from: m */
    public long f7575m = 0;

    /* renamed from: n */
    public String f7576n = "";

    /* renamed from: o */
    public String f7577o = "";

    /* renamed from: p */
    public String f7578p = "";

    /* renamed from: q */
    public long f7579q = 0;

    /* renamed from: r */
    public String f7580r = "";

    /* renamed from: s */
    public String f7581s = "";

    /* renamed from: t */
    public String f7582t = "";

    /* renamed from: u */
    public String f7583u = "";

    /* renamed from: v */
    public String f7584v = "";

    /* renamed from: w */
    public String f7585w = "";

    /* renamed from: x */
    private String f7586x = "";

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5212a(this.f7563a, 0);
        c2478j.m5207a(this.f7564b, 1);
        c2478j.m5207a(this.f7565c, 2);
        c2478j.m5207a(this.f7566d, 3);
        String str = this.f7567e;
        if (str != null) {
            c2478j.m5207a(str, 4);
        }
        c2478j.m5207a(this.f7568f, 5);
        c2478j.m5212a(this.f7569g, 6);
        c2478j.m5202a(this.f7570h, 7);
        String str2 = this.f7571i;
        if (str2 != null) {
            c2478j.m5207a(str2, 8);
        }
        String str3 = this.f7572j;
        if (str3 != null) {
            c2478j.m5207a(str3, 9);
        }
        Map<String, String> map = this.f7573k;
        if (map != null) {
            c2478j.m5205a((Map) map, 10);
        }
        String str4 = this.f7574l;
        if (str4 != null) {
            c2478j.m5207a(str4, 11);
        }
        c2478j.m5211a(this.f7575m, 12);
        String str5 = this.f7576n;
        if (str5 != null) {
            c2478j.m5207a(str5, 13);
        }
        String str6 = this.f7577o;
        if (str6 != null) {
            c2478j.m5207a(str6, 14);
        }
        String str7 = this.f7578p;
        if (str7 != null) {
            c2478j.m5207a(str7, 15);
        }
        c2478j.m5211a(this.f7579q, 16);
        String str8 = this.f7580r;
        if (str8 != null) {
            c2478j.m5207a(str8, 17);
        }
        String str9 = this.f7581s;
        if (str9 != null) {
            c2478j.m5207a(str9, 18);
        }
        String str10 = this.f7582t;
        if (str10 != null) {
            c2478j.m5207a(str10, 19);
        }
        String str11 = this.f7583u;
        if (str11 != null) {
            c2478j.m5207a(str11, 20);
        }
        String str12 = this.f7584v;
        if (str12 != null) {
            c2478j.m5207a(str12, 21);
        }
        String str13 = this.f7585w;
        if (str13 != null) {
            c2478j.m5207a(str13, 22);
        }
        String str14 = this.f7586x;
        if (str14 != null) {
            c2478j.m5207a(str14, 23);
        }
    }

    static {
        f7561y = r0;
        byte[] bArr = {0};
        f7562z.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7563a = c2476i.m5236a(this.f7563a, 0, true);
        this.f7564b = c2476i.m5224b(1, true);
        this.f7565c = c2476i.m5224b(2, true);
        this.f7566d = c2476i.m5224b(3, true);
        this.f7567e = c2476i.m5224b(4, false);
        this.f7568f = c2476i.m5224b(5, true);
        this.f7569g = c2476i.m5236a(this.f7569g, 6, true);
        byte[] bArr = f7561y;
        this.f7570h = c2476i.m5222c(7, true);
        this.f7571i = c2476i.m5224b(8, false);
        this.f7572j = c2476i.m5224b(9, false);
        this.f7573k = (Map) c2476i.m5231a((C2476i) f7562z, 10, false);
        this.f7574l = c2476i.m5224b(11, false);
        this.f7575m = c2476i.m5234a(this.f7575m, 12, false);
        this.f7576n = c2476i.m5224b(13, false);
        this.f7577o = c2476i.m5224b(14, false);
        this.f7578p = c2476i.m5224b(15, false);
        this.f7579q = c2476i.m5234a(this.f7579q, 16, false);
        this.f7580r = c2476i.m5224b(17, false);
        this.f7581s = c2476i.m5224b(18, false);
        this.f7582t = c2476i.m5224b(19, false);
        this.f7583u = c2476i.m5224b(20, false);
        this.f7584v = c2476i.m5224b(21, false);
        this.f7585w = c2476i.m5224b(22, false);
        this.f7586x = c2476i.m5224b(23, false);
    }
}
