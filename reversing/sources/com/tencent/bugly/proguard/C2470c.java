package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.c */
/* loaded from: classes2.dex */
public class C2470c extends C2450a {

    /* renamed from: d */
    protected HashMap<String, byte[]> f7630d = null;

    /* renamed from: e */
    private HashMap<String, Object> f7631e = new HashMap<>();

    /* renamed from: f */
    private C2476i f7632f = new C2476i();

    @Override // com.tencent.bugly.proguard.C2450a
    /* renamed from: a */
    public final /* bridge */ /* synthetic */ void mo5264a(String str) {
        super.mo5264a(str);
    }

    /* renamed from: b */
    public void mo5259b() {
        this.f7630d = new HashMap<>();
    }

    @Override // com.tencent.bugly.proguard.C2450a
    /* renamed from: a */
    public <T> void mo5261a(String str, T t) {
        if (this.f7630d == null) {
            super.mo5261a(str, (String) t);
        } else if (str == null) {
            throw new IllegalArgumentException("put key can not is null");
        } else {
            if (t == null) {
                throw new IllegalArgumentException("put value can not is null");
            }
            if (t instanceof Set) {
                throw new IllegalArgumentException("can not support Set");
            }
            C2478j c2478j = new C2478j();
            c2478j.m5208a(this.f7513b);
            c2478j.m5209a(t, 0);
            this.f7630d.put(str, C2480l.m5193a(c2478j.m5215a()));
        }
    }

    /* renamed from: b */
    public final <T> T m5263b(String str, T t) throws C2469b {
        HashMap<String, byte[]> hashMap = this.f7630d;
        if (hashMap != null) {
            if (hashMap.containsKey(str)) {
                if (this.f7631e.containsKey(str)) {
                    return (T) this.f7631e.get(str);
                }
                try {
                    this.f7632f.m5226a(this.f7630d.get(str));
                    this.f7632f.m5230a(this.f7513b);
                    T t2 = (T) this.f7632f.m5231a((C2476i) t, 0, true);
                    if (t2 != null) {
                        this.f7631e.put(str, t2);
                    }
                    return t2;
                } catch (Exception e) {
                    throw new C2469b(e);
                }
            }
            return null;
        } else if (this.f7512a.containsKey(str)) {
            if (this.f7631e.containsKey(str)) {
                return (T) this.f7631e.get(str);
            }
            byte[] bArr = new byte[0];
            Iterator<Map.Entry<String, byte[]>> it = this.f7512a.get(str).entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                next.getKey();
                bArr = next.getValue();
            }
            try {
                this.f7632f.m5226a(bArr);
                this.f7632f.m5230a(this.f7513b);
                T t3 = (T) this.f7632f.m5231a((C2476i) t, 0, true);
                this.f7631e.put(str, t3);
                return t3;
            } catch (Exception e2) {
                throw new C2469b(e2);
            }
        } else {
            return null;
        }
    }

    @Override // com.tencent.bugly.proguard.C2450a
    /* renamed from: a */
    public byte[] mo5262a() {
        if (this.f7630d != null) {
            C2478j c2478j = new C2478j(0);
            c2478j.m5208a(this.f7513b);
            c2478j.m5205a((Map) this.f7630d, 0);
            return C2480l.m5193a(c2478j.m5215a());
        }
        return super.mo5262a();
    }

    @Override // com.tencent.bugly.proguard.C2450a
    /* renamed from: a */
    public void mo5260a(byte[] bArr) {
        try {
            super.mo5260a(bArr);
        } catch (Exception unused) {
            this.f7632f.m5226a(bArr);
            this.f7632f.m5230a(this.f7513b);
            HashMap hashMap = new HashMap(1);
            hashMap.put("", new byte[0]);
            this.f7630d = this.f7632f.m5229a((Map) hashMap, 0, false);
        }
    }
}
