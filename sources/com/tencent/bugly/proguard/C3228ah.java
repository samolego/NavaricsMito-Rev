package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.ah */
/* loaded from: classes2.dex */
public final class C2458ah extends AbstractC2479k implements Cloneable {

    /* renamed from: a */
    public String f7518a = "";

    /* renamed from: b */
    public String f7519b = "";

    /* renamed from: c */
    public String f7520c = "";

    /* renamed from: e */
    private String f7522e = "";

    /* renamed from: d */
    public String f7521d = "";

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5197a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5207a(this.f7518a, 0);
        String str = this.f7519b;
        if (str != null) {
            c2478j.m5207a(str, 1);
        }
        String str2 = this.f7520c;
        if (str2 != null) {
            c2478j.m5207a(str2, 2);
        }
        String str3 = this.f7522e;
        if (str3 != null) {
            c2478j.m5207a(str3, 3);
        }
        String str4 = this.f7521d;
        if (str4 != null) {
            c2478j.m5207a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7518a = c2476i.m5224b(0, true);
        this.f7519b = c2476i.m5224b(1, false);
        this.f7520c = c2476i.m5224b(2, false);
        this.f7522e = c2476i.m5224b(3, false);
        this.f7521d = c2476i.m5224b(4, false);
    }
}
