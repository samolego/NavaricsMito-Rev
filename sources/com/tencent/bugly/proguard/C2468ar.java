package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ar */
/* loaded from: classes2.dex */
public final class C2468ar extends AbstractC2479k implements Cloneable {

    /* renamed from: f */
    private static ArrayList<C2467aq> f7623f;

    /* renamed from: g */
    private static Map<String, String> f7624g;

    /* renamed from: a */
    public byte f7625a = 0;

    /* renamed from: b */
    public String f7626b = "";

    /* renamed from: c */
    public String f7627c = "";

    /* renamed from: d */
    public ArrayList<C2467aq> f7628d = null;

    /* renamed from: e */
    public Map<String, String> f7629e = null;

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5197a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5214a(this.f7625a, 0);
        String str = this.f7626b;
        if (str != null) {
            c2478j.m5207a(str, 1);
        }
        String str2 = this.f7627c;
        if (str2 != null) {
            c2478j.m5207a(str2, 2);
        }
        ArrayList<C2467aq> arrayList = this.f7628d;
        if (arrayList != null) {
            c2478j.m5206a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f7629e;
        if (map != null) {
            c2478j.m5205a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7625a = c2476i.m5240a(this.f7625a, 0, true);
        this.f7626b = c2476i.m5224b(1, false);
        this.f7627c = c2476i.m5224b(2, false);
        if (f7623f == null) {
            f7623f = new ArrayList<>();
            f7623f.add(new C2467aq());
        }
        this.f7628d = (ArrayList) c2476i.m5231a((C2476i) f7623f, 3, false);
        if (f7624g == null) {
            f7624g = new HashMap();
            f7624g.put("", "");
        }
        this.f7629e = (Map) c2476i.m5231a((C2476i) f7624g, 4, false);
    }
}
