package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.d */
/* loaded from: classes2.dex */
public final class C2471d extends C2470c {

    /* renamed from: f */
    private static HashMap<String, byte[]> f7633f;

    /* renamed from: g */
    private static HashMap<String, HashMap<String, byte[]>> f7634g;

    /* renamed from: e */
    private C2473f f7635e = new C2473f();

    public C2471d() {
        this.f7635e.f7640a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.C2470c, com.tencent.bugly.proguard.C2450a
    /* renamed from: a */
    public final <T> void mo5261a(String str, T t) {
        if (str.startsWith(".")) {
            throw new IllegalArgumentException("put name can not startwith . , now is " + str);
        }
        super.mo5261a(str, (String) t);
    }

    @Override // com.tencent.bugly.proguard.C2470c
    /* renamed from: b */
    public final void mo5259b() {
        super.mo5259b();
        this.f7635e.f7640a = (short) 3;
    }

    @Override // com.tencent.bugly.proguard.C2470c, com.tencent.bugly.proguard.C2450a
    /* renamed from: a */
    public final byte[] mo5262a() {
        if (this.f7635e.f7640a == 2) {
            if (this.f7635e.f7642c.equals("")) {
                throw new IllegalArgumentException("servantName can not is null");
            }
            if (this.f7635e.f7643d.equals("")) {
                throw new IllegalArgumentException("funcName can not is null");
            }
        } else {
            if (this.f7635e.f7642c == null) {
                this.f7635e.f7642c = "";
            }
            if (this.f7635e.f7643d == null) {
                this.f7635e.f7643d = "";
            }
        }
        C2478j c2478j = new C2478j(0);
        c2478j.m5208a(this.f7513b);
        if (this.f7635e.f7640a == 2) {
            c2478j.m5205a((Map) this.f7512a, 0);
        } else {
            c2478j.m5205a((Map) this.f7630d, 0);
        }
        this.f7635e.f7644e = C2480l.m5193a(c2478j.m5215a());
        C2478j c2478j2 = new C2478j(0);
        c2478j2.m5208a(this.f7513b);
        this.f7635e.mo5198a(c2478j2);
        byte[] m5193a = C2480l.m5193a(c2478j2.m5215a());
        int length = m5193a.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(m5193a).flip();
        return allocate.array();
    }

    @Override // com.tencent.bugly.proguard.C2470c, com.tencent.bugly.proguard.C2450a
    /* renamed from: a */
    public final void mo5260a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("decode package must include size head");
        }
        try {
            C2476i c2476i = new C2476i(bArr, 4);
            c2476i.m5230a(this.f7513b);
            this.f7635e.mo5199a(c2476i);
            if (this.f7635e.f7640a == 3) {
                C2476i c2476i2 = new C2476i(this.f7635e.f7644e);
                c2476i2.m5230a(this.f7513b);
                if (f7633f == null) {
                    HashMap<String, byte[]> hashMap = new HashMap<>();
                    f7633f = hashMap;
                    hashMap.put("", new byte[0]);
                }
                this.f7630d = c2476i2.m5229a((Map) f7633f, 0, false);
                return;
            }
            C2476i c2476i3 = new C2476i(this.f7635e.f7644e);
            c2476i3.m5230a(this.f7513b);
            if (f7634g == null) {
                f7634g = new HashMap<>();
                HashMap<String, byte[]> hashMap2 = new HashMap<>();
                hashMap2.put("", new byte[0]);
                f7634g.put("", hashMap2);
            }
            this.f7512a = c2476i3.m5229a((Map) f7634g, 0, false);
            new HashMap();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: b */
    public final void m5257b(String str) {
        this.f7635e.f7642c = str;
    }

    /* renamed from: c */
    public final void m5256c(String str) {
        this.f7635e.f7643d = str;
    }

    /* renamed from: b */
    public final void m5258b(int i) {
        this.f7635e.f7641b = 1;
    }
}
