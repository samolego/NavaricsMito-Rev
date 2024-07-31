package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ak */
/* loaded from: classes2.dex */
public final class C2461ak extends AbstractC2479k {

    /* renamed from: A */
    private static ArrayList<C2460aj> f7530A;

    /* renamed from: B */
    private static Map<String, String> f7531B;

    /* renamed from: C */
    private static Map<String, String> f7532C;

    /* renamed from: v */
    private static Map<String, String> f7533v = new HashMap();

    /* renamed from: w */
    private static C2459ai f7534w;

    /* renamed from: x */
    private static C2458ah f7535x;

    /* renamed from: y */
    private static ArrayList<C2458ah> f7536y;

    /* renamed from: z */
    private static ArrayList<C2458ah> f7537z;

    /* renamed from: a */
    public String f7538a = "";

    /* renamed from: b */
    public long f7539b = 0;

    /* renamed from: c */
    public String f7540c = "";

    /* renamed from: d */
    public String f7541d = "";

    /* renamed from: e */
    public String f7542e = "";

    /* renamed from: f */
    public String f7543f = "";

    /* renamed from: g */
    public String f7544g = "";

    /* renamed from: h */
    public Map<String, String> f7545h = null;

    /* renamed from: i */
    public String f7546i = "";

    /* renamed from: j */
    public C2459ai f7547j = null;

    /* renamed from: k */
    public int f7548k = 0;

    /* renamed from: l */
    public String f7549l = "";

    /* renamed from: m */
    public String f7550m = "";

    /* renamed from: n */
    public C2458ah f7551n = null;

    /* renamed from: o */
    public ArrayList<C2458ah> f7552o = null;

    /* renamed from: p */
    public ArrayList<C2458ah> f7553p = null;

    /* renamed from: q */
    public ArrayList<C2460aj> f7554q = null;

    /* renamed from: r */
    public Map<String, String> f7555r = null;

    /* renamed from: s */
    public Map<String, String> f7556s = null;

    /* renamed from: t */
    public String f7557t = "";

    /* renamed from: u */
    private boolean f7558u = true;

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5207a(this.f7538a, 0);
        c2478j.m5211a(this.f7539b, 1);
        c2478j.m5207a(this.f7540c, 2);
        String str = this.f7541d;
        if (str != null) {
            c2478j.m5207a(str, 3);
        }
        String str2 = this.f7542e;
        if (str2 != null) {
            c2478j.m5207a(str2, 4);
        }
        String str3 = this.f7543f;
        if (str3 != null) {
            c2478j.m5207a(str3, 5);
        }
        String str4 = this.f7544g;
        if (str4 != null) {
            c2478j.m5207a(str4, 6);
        }
        Map<String, String> map = this.f7545h;
        if (map != null) {
            c2478j.m5205a((Map) map, 7);
        }
        String str5 = this.f7546i;
        if (str5 != null) {
            c2478j.m5207a(str5, 8);
        }
        C2459ai c2459ai = this.f7547j;
        if (c2459ai != null) {
            c2478j.m5210a((AbstractC2479k) c2459ai, 9);
        }
        c2478j.m5212a(this.f7548k, 10);
        String str6 = this.f7549l;
        if (str6 != null) {
            c2478j.m5207a(str6, 11);
        }
        String str7 = this.f7550m;
        if (str7 != null) {
            c2478j.m5207a(str7, 12);
        }
        C2458ah c2458ah = this.f7551n;
        if (c2458ah != null) {
            c2478j.m5210a((AbstractC2479k) c2458ah, 13);
        }
        ArrayList<C2458ah> arrayList = this.f7552o;
        if (arrayList != null) {
            c2478j.m5206a((Collection) arrayList, 14);
        }
        ArrayList<C2458ah> arrayList2 = this.f7553p;
        if (arrayList2 != null) {
            c2478j.m5206a((Collection) arrayList2, 15);
        }
        ArrayList<C2460aj> arrayList3 = this.f7554q;
        if (arrayList3 != null) {
            c2478j.m5206a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f7555r;
        if (map2 != null) {
            c2478j.m5205a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f7556s;
        if (map3 != null) {
            c2478j.m5205a((Map) map3, 18);
        }
        String str8 = this.f7557t;
        if (str8 != null) {
            c2478j.m5207a(str8, 19);
        }
        c2478j.m5203a(this.f7558u, 20);
    }

    static {
        f7533v.put("", "");
        f7534w = new C2459ai();
        f7535x = new C2458ah();
        f7536y = new ArrayList<>();
        f7536y.add(new C2458ah());
        f7537z = new ArrayList<>();
        f7537z.add(new C2458ah());
        f7530A = new ArrayList<>();
        f7530A.add(new C2460aj());
        f7531B = new HashMap();
        f7531B.put("", "");
        f7532C = new HashMap();
        f7532C.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7538a = c2476i.m5224b(0, true);
        this.f7539b = c2476i.m5234a(this.f7539b, 1, true);
        this.f7540c = c2476i.m5224b(2, true);
        this.f7541d = c2476i.m5224b(3, false);
        this.f7542e = c2476i.m5224b(4, false);
        this.f7543f = c2476i.m5224b(5, false);
        this.f7544g = c2476i.m5224b(6, false);
        this.f7545h = (Map) c2476i.m5231a((C2476i) f7533v, 7, false);
        this.f7546i = c2476i.m5224b(8, false);
        this.f7547j = (C2459ai) c2476i.m5232a((AbstractC2479k) f7534w, 9, false);
        this.f7548k = c2476i.m5236a(this.f7548k, 10, false);
        this.f7549l = c2476i.m5224b(11, false);
        this.f7550m = c2476i.m5224b(12, false);
        this.f7551n = (C2458ah) c2476i.m5232a((AbstractC2479k) f7535x, 13, false);
        this.f7552o = (ArrayList) c2476i.m5231a((C2476i) f7536y, 14, false);
        this.f7553p = (ArrayList) c2476i.m5231a((C2476i) f7537z, 15, false);
        this.f7554q = (ArrayList) c2476i.m5231a((C2476i) f7530A, 16, false);
        this.f7555r = (Map) c2476i.m5231a((C2476i) f7531B, 17, false);
        this.f7556s = (Map) c2476i.m5231a((C2476i) f7532C, 18, false);
        this.f7557t = c2476i.m5224b(19, false);
        boolean z = this.f7558u;
        this.f7558u = c2476i.m5235a(20, false);
    }
}
