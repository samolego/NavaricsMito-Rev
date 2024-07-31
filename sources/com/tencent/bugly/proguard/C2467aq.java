package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aq */
/* loaded from: classes2.dex */
public final class C2467aq extends AbstractC2479k {

    /* renamed from: i */
    private static Map<String, String> f7614i = new HashMap();

    /* renamed from: a */
    public long f7615a = 0;

    /* renamed from: b */
    public byte f7616b = 0;

    /* renamed from: c */
    public String f7617c = "";

    /* renamed from: d */
    public String f7618d = "";

    /* renamed from: e */
    public String f7619e = "";

    /* renamed from: f */
    public Map<String, String> f7620f = null;

    /* renamed from: g */
    public String f7621g = "";

    /* renamed from: h */
    public boolean f7622h = true;

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5211a(this.f7615a, 0);
        c2478j.m5214a(this.f7616b, 1);
        String str = this.f7617c;
        if (str != null) {
            c2478j.m5207a(str, 2);
        }
        String str2 = this.f7618d;
        if (str2 != null) {
            c2478j.m5207a(str2, 3);
        }
        String str3 = this.f7619e;
        if (str3 != null) {
            c2478j.m5207a(str3, 4);
        }
        Map<String, String> map = this.f7620f;
        if (map != null) {
            c2478j.m5205a((Map) map, 5);
        }
        String str4 = this.f7621g;
        if (str4 != null) {
            c2478j.m5207a(str4, 6);
        }
        c2478j.m5203a(this.f7622h, 7);
    }

    static {
        f7614i.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7615a = c2476i.m5234a(this.f7615a, 0, true);
        this.f7616b = c2476i.m5240a(this.f7616b, 1, true);
        this.f7617c = c2476i.m5224b(2, false);
        this.f7618d = c2476i.m5224b(3, false);
        this.f7619e = c2476i.m5224b(4, false);
        this.f7620f = (Map) c2476i.m5231a((C2476i) f7614i, 5, false);
        this.f7621g = c2476i.m5224b(6, false);
        boolean z = this.f7622h;
        this.f7622h = c2476i.m5235a(7, false);
    }
}
