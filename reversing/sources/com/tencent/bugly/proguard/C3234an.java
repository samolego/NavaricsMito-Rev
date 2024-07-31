package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.an */
/* loaded from: classes2.dex */
public final class C2464an extends AbstractC2479k {

    /* renamed from: i */
    private static byte[] f7587i;

    /* renamed from: j */
    private static Map<String, String> f7588j = new HashMap();

    /* renamed from: a */
    public byte f7589a = 0;

    /* renamed from: b */
    public int f7590b = 0;

    /* renamed from: c */
    public byte[] f7591c = null;

    /* renamed from: d */
    public String f7592d = "";

    /* renamed from: e */
    public long f7593e = 0;

    /* renamed from: h */
    private String f7596h = "";

    /* renamed from: f */
    public String f7594f = "";

    /* renamed from: g */
    public Map<String, String> f7595g = null;

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5214a(this.f7589a, 0);
        c2478j.m5212a(this.f7590b, 1);
        byte[] bArr = this.f7591c;
        if (bArr != null) {
            c2478j.m5202a(bArr, 2);
        }
        String str = this.f7592d;
        if (str != null) {
            c2478j.m5207a(str, 3);
        }
        c2478j.m5211a(this.f7593e, 4);
        String str2 = this.f7596h;
        if (str2 != null) {
            c2478j.m5207a(str2, 5);
        }
        String str3 = this.f7594f;
        if (str3 != null) {
            c2478j.m5207a(str3, 6);
        }
        Map<String, String> map = this.f7595g;
        if (map != null) {
            c2478j.m5205a((Map) map, 7);
        }
    }

    static {
        f7587i = r0;
        byte[] bArr = {0};
        f7588j.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7589a = c2476i.m5240a(this.f7589a, 0, true);
        this.f7590b = c2476i.m5236a(this.f7590b, 1, true);
        byte[] bArr = f7587i;
        this.f7591c = c2476i.m5222c(2, false);
        this.f7592d = c2476i.m5224b(3, false);
        this.f7593e = c2476i.m5234a(this.f7593e, 4, false);
        this.f7596h = c2476i.m5224b(5, false);
        this.f7594f = c2476i.m5224b(6, false);
        this.f7595g = (Map) c2476i.m5231a((C2476i) f7588j, 7, false);
    }
}
