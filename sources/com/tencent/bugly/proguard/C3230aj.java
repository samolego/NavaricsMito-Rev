package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aj */
/* loaded from: classes2.dex */
public final class C2460aj extends AbstractC2479k implements Cloneable {

    /* renamed from: d */
    private static byte[] f7526d;

    /* renamed from: a */
    private byte f7527a;

    /* renamed from: b */
    private String f7528b;

    /* renamed from: c */
    private byte[] f7529c;

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5197a(StringBuilder sb, int i) {
    }

    public C2460aj() {
        this.f7527a = (byte) 0;
        this.f7528b = "";
        this.f7529c = null;
    }

    public C2460aj(byte b, String str, byte[] bArr) {
        this.f7527a = (byte) 0;
        this.f7528b = "";
        this.f7529c = null;
        this.f7527a = b;
        this.f7528b = str;
        this.f7529c = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5198a(C2478j c2478j) {
        c2478j.m5214a(this.f7527a, 0);
        c2478j.m5207a(this.f7528b, 1);
        byte[] bArr = this.f7529c;
        if (bArr != null) {
            c2478j.m5202a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC2479k
    /* renamed from: a */
    public final void mo5199a(C2476i c2476i) {
        this.f7527a = c2476i.m5240a(this.f7527a, 0, true);
        this.f7528b = c2476i.m5224b(1, true);
        if (f7526d == null) {
            f7526d = r0;
            byte[] bArr = {0};
        }
        byte[] bArr2 = f7526d;
        this.f7529c = c2476i.m5222c(2, false);
    }
}
