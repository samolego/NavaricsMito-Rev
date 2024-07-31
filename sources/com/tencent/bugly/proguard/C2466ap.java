package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ap */
/* loaded from: classes2.dex */
public final class C2466ap extends AbstractC2479k implements Cloneable {

    /* renamed from: o */
    private static /* synthetic */ boolean f7601o = !C2466ap.class.desiredAssertionStatus();

    /* renamed from: m */
    private static C2465ao f7599m = new C2465ao();

    /* renamed from: n */
    private static Map<String, String> f7600n = new HashMap();

    /* renamed from: a */
    public boolean f7602a = true;

    /* renamed from: b */
    public boolean f7603b = true;

    /* renamed from: c */
    public boolean f7604c = true;

    /* renamed from: d */
    public String f7605d = "";

    /* renamed from: e */
    public String f7606e = "";

    /* renamed from: f */
    public C2465ao f7607f = null;

    /* renamed from: g */
    public Map<String, String> f7608g = null;

    /* renamed from: h */
    public long f7609h = 0;

    /* renamed from: j */
    private String f7611j = "";

    /* renamed from: k */
    private String f7612k = "";

    /* renamed from: l */
    private int f7613l = 0;

    /* renamed from: i */
    public int f7610i = 0;

    static {
        f7600n.put("", "");
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C2466ap c2466ap = (C2466ap) obj;
        return C2480l.m5192a(this.f7602a, c2466ap.f7602a) && C2480l.m5192a(this.f7603b, c2466ap.f7603b) && C2480l.m5192a(this.f7604c, c2466ap.f7604c) && C2480l.m5194a(this.f7605d, c2466ap.f7605d) && C2480l.m5194a(this.f7606e, c2466ap.f7606e) && C2480l.m5194a(this.f7607f, c2466ap.f7607f) && C2480l.m5194a(this.f7608g, c2466ap.f7608g) && C2480l.m5195a(this.f7609h, c2466ap.f7609h) && C2480l.m5194a(this.f7611j, c2466ap.f7611j) && C2480l.m5194a(this.f7612k, c2466ap.f7612k) && C2480l.m5196a(this.f7613l, c2466ap.f7613l) && C2480l.m5196a(this.f7610i, c2466ap.f7610i);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f7601o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5203a(this.f7602a, 0);
        c2478j.m5203a(this.f7603b, 1);
        c2478j.m5203a(this.f7604c, 2);
        String str = this.f7605d;
        if (str != null) {
            c2478j.m5207a(str, 3);
        }
        String str2 = this.f7606e;
        if (str2 != null) {
            c2478j.m5207a(str2, 4);
        }
        C2465ao c2465ao = this.f7607f;
        if (c2465ao != null) {
            c2478j.m5210a((AbstractC2479k) c2465ao, 5);
        }
        Map<String, String> map = this.f7608g;
        if (map != null) {
            c2478j.m5205a((Map) map, 6);
        }
        c2478j.m5211a(this.f7609h, 7);
        String str3 = this.f7611j;
        if (str3 != null) {
            c2478j.m5207a(str3, 8);
        }
        String str4 = this.f7612k;
        if (str4 != null) {
            c2478j.m5207a(str4, 9);
        }
        c2478j.m5212a(this.f7613l, 10);
        c2478j.m5212a(this.f7610i, 11);
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        boolean z = this.f7602a;
        this.f7602a = c2476i.m5235a(0, true);
        boolean z2 = this.f7603b;
        this.f7603b = c2476i.m5235a(1, true);
        boolean z3 = this.f7604c;
        this.f7604c = c2476i.m5235a(2, true);
        this.f7605d = c2476i.m5224b(3, false);
        this.f7606e = c2476i.m5224b(4, false);
        this.f7607f = (C2465ao) c2476i.m5232a((AbstractC2479k) f7599m, 5, false);
        this.f7608g = (Map) c2476i.m5231a((C2476i) f7600n, 6, false);
        this.f7609h = c2476i.m5234a(this.f7609h, 7, false);
        this.f7611j = c2476i.m5224b(8, false);
        this.f7612k = c2476i.m5224b(9, false);
        this.f7613l = c2476i.m5236a(this.f7613l, 10, false);
        this.f7610i = c2476i.m5236a(this.f7610i, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5197a(StringBuilder sb, int i) {
        C2475h c2475h = new C2475h(sb, i);
        c2475h.m5245a(this.f7602a, "enable");
        c2475h.m5245a(this.f7603b, "enableUserInfo");
        c2475h.m5245a(this.f7604c, "enableQuery");
        c2475h.m5248a(this.f7605d, "url");
        c2475h.m5248a(this.f7606e, "expUrl");
        c2475h.m5251a((AbstractC2479k) this.f7607f, "security");
        c2475h.m5247a((Map) this.f7608g, "valueMap");
        c2475h.m5252a(this.f7609h, "strategylastUpdateTime");
        c2475h.m5248a(this.f7611j, "httpsUrl");
        c2475h.m5248a(this.f7612k, "httpsExpUrl");
        c2475h.m5253a(this.f7613l, "eventRecordCount");
        c2475h.m5253a(this.f7610i, "eventTimeInterval");
    }
}
